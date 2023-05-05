
package com.mobile.physiolink.ui.psf;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.mobile.physiolink.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.physiolink.databinding.FragmentClinicBinding;


public class ClinicFragment extends Fragment {


    RecyclerView doctorList;
    String n1[],n2[],n3[];
   // int doctorImages[] = {R.drawable.giorgos,R.drawable.maria,R.drawable.ioannis,R.drawable.michalis,R.drawable.dimitra,R.drawable.christos};

    private FragmentClinicBinding binding;

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
        binding = FragmentClinicBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        doctorList = view.findViewById(R.id.customListView);

        n1=getResources().getStringArray(R.array.doctoNameListExample);
        n2=getResources().getStringArray(R.array.doctorOfficeListExample);
        n3=getResources().getStringArray(R.array.doctorAddressListExample);

        MyItemDecoration itemDecoration = new MyItemDecoration(20); // 20px spacing
        doctorList.addItemDecoration(itemDecoration);


        ClinicCustomBaseAdapter myAdapter = new ClinicCustomBaseAdapter(this,n1,n2,n3);
        doctorList.setAdapter(myAdapter);
        doctorList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        Button goToNewPfisiotherapeftiria = view.findViewById(R.id.newPfisiotherapeftirioButton);
        goToNewPfisiotherapeftiria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.fragmentContainerView)
                        .navigate(R.id.action_phisiotherpeftiriaFragment_to_createPhisiotherapeftiriaFragment);
            }
        });
    }
}




