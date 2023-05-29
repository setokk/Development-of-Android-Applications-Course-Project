package com.mobile.physiolink.ui.doctor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobile.physiolink.databinding.FragmentDoctorProfileBinding;
import com.mobile.physiolink.model.user.singleton.UserHolder;

public class DoctorProfileFragment extends Fragment {
    private FragmentDoctorProfileBinding binding;

    public DoctorProfileFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        binding = FragmentDoctorProfileBinding.inflate(inflater, container, false);
        binding.profileNameDoctor.setText(String.format("%s %s",
                UserHolder.doctor().getName(), UserHolder.doctor().getSurname()));
        binding.profileUsernameDoctor.setText(String.format("%s ",
                UserHolder.doctor().getUsername()));
        binding.amkaOutputProfileDoctor.setText(String.format("%s ",
                UserHolder.doctor().getAfm()));
        binding.emailOutputDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getEmail()));
        binding.physioNameDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getPhysioName()));
        binding.cityOutputDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getCity()));
        binding.adressOutputDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getAddress()));
        binding.phoneOutputDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getPhoneNumber()));
        binding.postalCodeDoctorProfile.setText(String.format("%s ",
                UserHolder.doctor().getPostalCode()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}