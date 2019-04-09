package com.radius.assignment;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.radius.assignment.model.UserResults;
import com.squareup.picasso.Picasso;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvName;
    TextView tvAge;
    ImageView ivThumbnail;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_user_name);
        tvAge = itemView.findViewById(R.id.tv_user_age);
        ivThumbnail = itemView.findViewById(R.id.iv_user_thumbnail);
    }

    public void populateView(UserResults user, Context context){
        tvName.setText(user.getName().getTitle() + " " + user.getName().getFirst() + " " +
                user.getName().getLast());
        tvAge.setText(user.getDob().getAge() + " years");
        Picasso.with(context)
                .load(user.getPicture().getThumbnail())
                .resize(50,50)
                .centerCrop()
                .into(ivThumbnail);
    }
}
