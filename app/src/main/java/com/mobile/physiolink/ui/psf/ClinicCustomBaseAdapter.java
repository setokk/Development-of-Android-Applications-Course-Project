package com.mobile.physiolink.ui.psf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.physiolink.R;

public class ClinicCustomBaseAdapter extends RecyclerView.Adapter<ClinicCustomBaseAdapter.MyViewHolder> {


    String listDoctorName[];
    String listDoctorOffice[];
    String listDoctorAddress[];

    //int images[];



    public ClinicCustomBaseAdapter(Fragment PhisiotherpeftiriaFragment, String n1[], String n2[], String n3[]){
        Context ct =PhisiotherpeftiriaFragment.getContext();
        listDoctorName=n1;
        listDoctorOffice=n2;
        listDoctorAddress=n3;
        //images=doctorImages;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_doc,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(listDoctorName[position]);
        holder.office.setText(listDoctorOffice[position]);
        holder.address.setText(listDoctorAddress[position]);
       // holder.img.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return listDoctorName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, office, address;
        //ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.doctorName);
            office= itemView.findViewById(R.id.doctorOffice);
            address= itemView.findViewById(R.id.doctorAddress);
            //img=itemView.findViewById(R.id.doctorImage);

        }
    }
}