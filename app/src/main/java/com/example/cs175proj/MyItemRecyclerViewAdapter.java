package com.example.cs175proj;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cs175proj.databinding.FragmentItemBinding;

import java.util.List;

/**
 * MyItemRecyclerViewAdapter serves as the adapter for the RecyclerView of the app, which is the list of posts
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    List<Post> mValues;
    ClickListener clickListener;

    /**
     * Constructor for the adapter, takes in a list of posts and a Clicklistener interface
     * @param items the list of posts
     * @param clickListener the ClickListener interface
     */
    public MyItemRecyclerViewAdapter(List<Post> items, ClickListener clickListener) {
        mValues = items;
        this.clickListener = clickListener;
    }

    /**
     * Autogenerated onCreateViewHolder method, creates a ViewHolder and returns it
     * @param parent
     * @param viewType
     * @return a ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), clickListener);

    }

    /**
     * Autogenerated onBindViewholder method, sets the content of the binding to the Post title at a given position
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String current = mValues.get(position).toString();
        holder.binding.content.setText(current);
    }

    /**
     * Returns the number of items in the RecyclerView
     * @return the number of items in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * ViewHolder class for the RecyclerView
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        FragmentItemBinding binding;

        /**
         * Constructor, takes in a binding and a Clicklistener interface, sets the binding to the binding instance variable and sets the binding's root's onClickListener to the onItemClick method in the ClickListener
         * @param binding the binding
         * @param clickListener the ClickListener
         */
        public ViewHolder(FragmentItemBinding binding, ClickListener clickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(view ->
                  clickListener.onItemClick(getBindingAdapterPosition()));
        }

    }

    /**
     * Interface to help bind onClick method to adapter
     */
    public interface ClickListener {
        /**
         * onItemClick method, implementation should handle a click event at a given position
         * @param position the position of the click within the list
         */
        void onItemClick(int position);
    }
}