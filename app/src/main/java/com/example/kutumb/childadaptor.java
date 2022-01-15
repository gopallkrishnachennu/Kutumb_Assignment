package com.example.kutumb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class childadaptor extends RecyclerView.Adapter<childadaptor.viewholder> {
    List<post1> c;
    String language,languageColor,totalstars,forks,repositoryname,description;
  Context context;
    public childadaptor(List<post1> c, String language, String languageColor, String totalstars, String forks, String repositoryname, String description,Context context) {
        this.c = c;
        this.language = language;
        this.languageColor = languageColor;
        this.totalstars = totalstars;
        this.forks = forks;
        this.repositoryname=repositoryname;
        this.description=description;
        this.context=context;
    }

    @NonNull
    @Override
    public childadaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.childitem,parent,false);
        return new childadaptor.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull childadaptor.viewholder holder, int position) {
        Glide.with(context).load(c.get(position).getAvatar()).centerCrop().into(holder.i);
        holder.t1.setText(c.get(position).getUsername());
        holder.t2.setText(repositoryname);
        holder.t3.setText(description);
        holder.t4.setText(language);
        holder.t5.setText(totalstars);
        holder.t6.setText(forks);
        boolean isexpanded=c.get(position).getExpanded();
        holder.constraintLayout.setVisibility(isexpanded ? View.VISIBLE:View.GONE);
    }

    @Override
    public int getItemCount() {
        return c.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5,t6;
        CircleImageView i;
        LinearLayout constraintLayout;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.image);
            t1=itemView.findViewById(R.id.username);
            t2=itemView.findViewById(R.id.repositoryname);
            t3=itemView.findViewById(R.id.description);
            t4=itemView.findViewById(R.id.tlanguage);
            t5=itemView.findViewById(R.id.tstar);
            t6=itemView.findViewById(R.id.tfork);
            constraintLayout=itemView.findViewById(R.id.expand);
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    post1 po=c.get(getAbsoluteAdapterPosition());
                    po.setExpanded(!po.getExpanded());
                    notifyItemChanged(getAbsoluteAdapterPosition());
                }
            });
        }
    }
}
