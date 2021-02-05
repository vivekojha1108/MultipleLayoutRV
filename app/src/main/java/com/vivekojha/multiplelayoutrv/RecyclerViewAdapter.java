package com.vivekojha.multiplelayoutrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.mViewHolder> {
    ArrayList<String> childArrayList;

    public RecyclerViewAdapter(ArrayList<String> childArrayList) {
        this.childArrayList = childArrayList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_rowlayout, parent, false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        holder.Username.setText(childArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return childArrayList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder {
        TextView Username;
        ImageView UserImage;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            Username = itemView.findViewById(R.id.username_tv);
            UserImage = itemView.findViewById(R.id.userImageCard);
        }
    }
}
