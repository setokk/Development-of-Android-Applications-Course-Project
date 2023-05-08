package com.mobile.physiolink.ui.psf;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.mobile.physiolink.R;
import com.mobile.physiolink.databinding.FragmentPsfHomeBinding;

public class PsfHomeFragment extends Fragment
{
    private FragmentPsfHomeBinding binding;

    public PsfHomeFragment() {}

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
        binding = FragmentPsfHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        /* Create clinic button */
        binding.psfImageButton1.setOnClickListener((v)->
        {
            Navigation.findNavController(getActivity(), R.id.fragmentContainerView)
                    .navigate(R.id.action_fragment_home_psf_to_phisiotherpeftiriaFragment);
        });

        /* Create Services button */
        binding.psfImageButton2.setOnClickListener((v)->
        {
            Navigation.findNavController(getActivity(), R.id.fragmentContainerView)
                    .navigate(R.id.action_fragment_home_psf_to_parohesFragment);
        });

    }
}