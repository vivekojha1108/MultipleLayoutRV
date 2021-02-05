package com.vivekojha.multiplelayoutrv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentRecyclerviewAdapter extends RecyclerView.Adapter<FragmentRecyclerviewAdapter.ViewHolder> {

    ArrayList<String> fgTextArrayList;

    public FragmentRecyclerviewAdapter(ArrayList<String> fgTextArrayList) {
        this.fgTextArrayList = fgTextArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_frg_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fgText.setText(fgTextArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return fgTextArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fgText;
        ImageView fgImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fgText = itemView.findViewById(R.id.textViewFgItem);
            fgImage = itemView.findViewById(R.id.imageViewFgItem);
        }
    }
}
