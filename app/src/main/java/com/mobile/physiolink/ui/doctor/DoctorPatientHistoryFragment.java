package com.mobile.physiolink.ui.doctor;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.textfield.TextInputEditText;
import com.mobile.physiolink.R;
import com.mobile.physiolink.databinding.FragmentDoctorPatientHistoryBinding;
import com.mobile.physiolink.model.user.singleton.UserHolder;
import com.mobile.physiolink.ui.decoration.DecorationSpacingItem;
import com.mobile.physiolink.ui.doctor.adapter.AdapterForPatientHistory;
import com.mobile.physiolink.ui.doctor.viewmodel.DoctorPatientHistoryViewModel;

public class DoctorPatientHistoryFragment extends Fragment
{
    private FragmentDoctorPatientHistoryBinding binding;
    private DoctorPatientHistoryViewModel viewModel;
    private AdapterForPatientHistory adapter;

    private TextInputEditText[] allInputs = new TextInputEditText[8];

    boolean shouldEdit = true;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        /* On back button pressed, Go back to patients fragment */
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                NavController navController = Navigation.findNavController(getActivity(), R.id.container);
                navController.navigate(R.id.action_doctorPatientHistoryFragment_to_doctorPatientsFragment);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentDoctorPatientHistoryBinding.inflate(inflater, container, false);

        adapter = new AdapterForPatientHistory();

        viewModel = new ViewModelProvider(this).get(DoctorPatientHistoryViewModel.class);
        viewModel.getSelectedPatient().observe(getViewLifecycleOwner(), patient ->
        {
            binding.patientHistoryNameDoctor.setText(patient.getName());
            binding.patientHistorySurnameDoctor.setText(patient.getSurname());
            binding.phonePatientHistoryDoctor.setText(patient.getPhoneNumber());
            binding.emailPatientHistoryDoctor.setText(patient.getEmail());
            binding.amkaPatientHistoryDoctor.setText(patient.getAmka());
            binding.cityPatientHistoryDoctor.setText(patient.getCity());
            binding.postalCodePatientHistoryDoctor.setText(patient.getPostalCode());
            binding.addressPatientHistoryDoctor.setText(patient.getAddress());
        });

        populateAllInputs();
        makeTextViewsUneditable();

        viewModel.getHistoryAppointments().observe(getViewLifecycleOwner(), appointments ->
        {
            adapter.setAppointments(appointments);
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


        binding.patientHistoryInfoDownBtn.setOnClickListener(view1 ->
        {
            if(binding.patientHistoryMoreInfoDoctorConstraint.getVisibility()==View.GONE)
            {
                TransitionManager.beginDelayedTransition(binding.patientHistoryInfoDoctor,
                        new AutoTransition());
                binding.patientHistoryMoreInfoDoctorConstraint.setVisibility(View.VISIBLE);
                binding.patientHistoryInfoDownBtn
                        .setBackgroundResource(R.drawable.baseline_arrow_drop_up_24);
            }
            else
            {
                TransitionManager.beginDelayedTransition(binding.patientHistoryInfoDoctor,
                        new AutoTransition());
                binding.patientHistoryMoreInfoDoctorConstraint.setVisibility(View.GONE);
                binding.patientHistoryInfoDownBtn
                        .setBackgroundResource(R.drawable.baseline_arrow_drop_down_24);
            }
        });

        binding.editInfoBtnPatientHistoryDoctor.setOnClickListener(v ->
        {
            if (shouldEdit)
            {
                makeTextViewsEditable();
                binding.patientHistoryNameDoctor.setFocusableInTouchMode(true);
                binding.patientHistoryNameDoctor.requestFocus();
                binding.patientHistoryNameDoctor.setSelection(binding.patientHistoryNameDoctor.getText().length());
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(binding.patientHistoryNameDoctor, InputMethodManager.SHOW_IMPLICIT);
                binding.editInfoBtnPatientHistoryDoctor.setText("Αποθήκευση");
            }
            else
            {
                makeTextViewsUneditable();
                binding.editInfoBtnPatientHistoryDoctor.setText("Επεξεργασία");
                //TODO: SAVE TO DB
            }
            shouldEdit = !shouldEdit;
        });

        DecorationSpacingItem itemDecoration = new DecorationSpacingItem(20); // 20px spacing
        binding.servicesListPatientHistoryDoctor.addItemDecoration(itemDecoration);

        binding.servicesListPatientHistoryDoctor.setAdapter(adapter);
        binding.servicesListPatientHistoryDoctor.setLayoutManager(new LinearLayoutManager(this.getContext()));

        long patientId = DoctorPatientHistoryFragmentArgs.fromBundle(getArguments()).getPatientId();
        viewModel.loadPatient(patientId);
        viewModel.loadPatientHistoryAppointments(patientId);
    }

    private void makeTextViewsEditable()
    {
        for (int i = 0; i < allInputs.length; ++i)
        {
            allInputs[i].setEnabled(true);
            allInputs[i].setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        }
    }

    private void makeTextViewsUneditable()
    {
        for (int i = 0; i < allInputs.length; ++i)
        {
            allInputs[i].setEnabled(false);
            allInputs[i].setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        }
    }

    private void populateAllInputs()
    {
        allInputs[0] = binding.patientHistoryNameDoctor;
        allInputs[1] = binding.patientHistorySurnameDoctor;
        allInputs[2] = binding.emailPatientHistoryDoctor;
        allInputs[3] = binding.phonePatientHistoryDoctor;
        allInputs[4] = binding.amkaPatientHistoryDoctor;
        allInputs[5] = binding.cityPatientHistoryDoctor;
        allInputs[6] = binding.addressPatientHistoryDoctor;
        allInputs[7] = binding.postalCodePatientHistoryDoctor;
    }
}