package com.example.cse471.Model.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse471.R;

public class commentViewHolder extends RecyclerView.ViewHolder {
    public TextView cuname, cumessage, cudt;
    public ImageView cuimage;

    public commentViewHolder(@NonNull View itemView) {
        super(itemView);

        cuname = itemView.findViewById(R.id.cuname);
        cumessage = itemView.findViewById(R.id.cumessage);
        cudt = itemView.findViewById(R.id.cudt);
        cuimage = itemView.findViewById(R.id.cuimage);
    }
}
