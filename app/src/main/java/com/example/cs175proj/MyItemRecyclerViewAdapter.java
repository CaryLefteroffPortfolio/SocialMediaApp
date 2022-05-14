package com.example.cs175proj;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cs175proj.databinding.FragmentItemBinding;
import com.example.cs175proj.placeholder.PlaceholderContent;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent.PlaceholderItem> mValues;

    public MyItemRecyclerViewAdapter(List<PlaceholderContent.PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

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
        protected final FragmentItemBinding binding;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view -> Toast.makeText(view.getContext(), "A row clicked", Toast.LENGTH_SHORT).show());
        }

    }
}