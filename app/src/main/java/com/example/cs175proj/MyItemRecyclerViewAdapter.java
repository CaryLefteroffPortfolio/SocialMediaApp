package com.example.cs175proj;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cs175proj.databinding.FragmentItemBinding;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    List<Post> mValues;
    ClickListener clickListener;

    public MyItemRecyclerViewAdapter(List<Post> items, ClickListener clickListener) {
        mValues = items;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), clickListener);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String current = mValues.get(position).toString();
        holder.binding.content.setText(current);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FragmentItemBinding binding;

        public ViewHolder(FragmentItemBinding binding, ClickListener clickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view ->
                  clickListener.onItemClick(getBindingAdapterPosition()));
        }

    }

    public interface ClickListener {
        void onItemClick(int position);
    }
}