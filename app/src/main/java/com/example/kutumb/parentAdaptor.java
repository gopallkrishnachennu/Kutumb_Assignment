package com.example.kutumb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class parentAdaptor extends RecyclerView.Adapter<parentAdaptor.viewholder> {
    private Activity activity;
    List<Post> p;
    Context context;
    public parentAdaptor(Activity activity, List<Post> p,Context context) {
        this.activity = activity;
        this.p = p;
        this.context=context;
    }

    @NonNull
    @Override
    public parentAdaptor.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parentitem,parent,false);
        return new parentAdaptor.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull parentAdaptor.viewholder holder, int position) {
        Post l=p.get(position);
        holder.t.setText(l.getLanguage());
        try {
            holder.t.setBackgroundColor(Color.parseColor(l.getLanguageColor()));
        }
        catch (Exception e)
        {
            holder.t.setBackgroundColor(Color.parseColor("#000000"));
        }
        List<post1> c=new ArrayList<>();
        for(int i=0;i<l.getBuiltBy().size();i++)
        {
            c.add(l.getBuiltBy().get(i));
        }
        childadaptor adaptor=new childadaptor(c,l.getLanguage(),l.getLanguageColor(),l.getTotalStars(),l.getForks(),l.getRepositoryName(),l.getDescription(),context);
        LinearLayoutManager layoutManager=new LinearLayoutManager(activity);
        holder.r.setLayoutManager(layoutManager);
        holder.r.setAdapter(adaptor);

    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView t;
        RecyclerView r;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            r=itemView.findViewById(R.id.child);
            t=itemView.findViewById(R.id.language);
        }
    }
}
