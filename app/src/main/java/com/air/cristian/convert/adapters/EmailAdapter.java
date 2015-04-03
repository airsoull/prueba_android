package com.air.cristian.convert.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import com.air.cristian.convert.R;
import com.air.cristian.convert.models.Email;

import java.util.List;


public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {
    private List<Email> items;

    public EmailAdapter(List items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView email;
        private TextView name;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);

        }

    }

    @Override
    public EmailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.email.setText(items.get(position).getEmail());
        holder.name.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
