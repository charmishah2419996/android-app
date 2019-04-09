package com.radius.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.radius.assignment.model.UserResults;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<UserResults> users;
    Context context;

    public UserListAdapter(List<UserResults> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View convertView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_user, viewGroup, false);
        return new UserViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof UserViewHolder){
            ((UserViewHolder)viewHolder).populateView(users.get(i),context);
        }
    }

    @Override
    public int getItemCount() {
        if(users!=null){
            return users.size();
        }
        return 0;
    }
}
