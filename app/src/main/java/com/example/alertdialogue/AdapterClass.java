package com.example.alertdialogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    Context mcontext;
    List<ModelClass> modelclass;

    public AdapterClass(Context mcontext, List<ModelClass> modelclass) {
        this.mcontext = mcontext;
        this.modelclass = modelclass;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View citylist = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_custom,parent,false);

        return new ViewHolder(citylist);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {

        ModelClass cityn = modelclass.get(position);

        holder.Name.setText(cityn.getName());
        holder.Mobile.setText(cityn.getMobile());
        holder.Mail.setText(cityn.getMail());
        holder.Website.setText(cityn.getWebsite());
    }

    @Override
    public int getItemCount() {
        return modelclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Name,Mobile,Mail,Website;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.name);
            Mobile = itemView.findViewById(R.id.Mobile);
            Mail = itemView.findViewById(R.id.Mail);
            Website = itemView.findViewById(R.id.Website);


        }
    }
}
