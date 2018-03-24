package com.freelance.docstalk.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freelance.docstalk.Model.GitModel;
import com.freelance.docstalk.R;

import java.util.List;

/**
 * Created by Shubham Shukla on 24-03-2018.
 */

public class DataLoader extends RecyclerView.Adapter<DataLoader.ViewHolder> {


    private Context context;
    private List<GitModel.InnerItems> innerItemslist;

    public DataLoader(Context context, List<GitModel.InnerItems> innerItemslist) {
        this.context = context;
        this.innerItemslist = innerItemslist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_representer,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.id.setText(innerItemslist.get(position).getId());
        holder.username.setText(innerItemslist.get(position).getLogin());
        holder.score.setText(innerItemslist.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return innerItemslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView username,id,score;
        public ViewHolder(View itemView) {
            super(itemView);
            username=(TextView)itemView.findViewById(R.id.username);
            id=(TextView)itemView.findViewById(R.id.id_user);
            score=(TextView)itemView.findViewById(R.id.score);
        }
    }
}
