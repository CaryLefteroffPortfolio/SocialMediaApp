package com.example.cs175proj;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.net.Uri;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;
        import androidx.navigation.fragment.NavHostFragment;
        import androidx.recyclerview.widget.LinearLayoutManager;

        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;


        import com.example.cs175proj.databinding.FragmentItemListBinding;

        import java.util.ArrayList;

/**
 * ItemFragment class uses a RecyclerView to display a list of posts
 */
public class ItemFragment extends Fragment implements MyItemRecyclerViewAdapter.ClickListener{

    ArrayList<Post> data = new ArrayList<>();

    MyItemRecyclerViewAdapter adapter;
    FragmentItemListBinding b;

    public ItemFragment() {
    }

    /**
     * Takes in a position of a click and uses the nav to go to the PostContentViewFragment, passing the position through the nav in a Bundle
     * @param position the position of the click within the list
     */
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("PostIndex", position);

        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_itemFragment_to_postContentViewFragment, bundle);
    }

    /**
     * Autogenerated onCreate, sets setHasOptionMenu to true
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    /**
     * Autogenerated onCreateOptionMenu method, inflates the menu
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    /**
     * Handles selections in the item menu
     * @param item the selected MenuItem
     * @return return value of super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.exit){
            SharedPreferences sp = getActivity().getSharedPreferences("SESSION_KEY", Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.clear();
            e.apply();
            NavController nav = NavHostFragment.findNavController(this);
            nav.navigate(R.id.action_itemFragment_to_mainFragment);
        }else if(item.getItemId() == R.id.uninstall){
            Intent delete = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + getActivity().getPackageName()));
            startActivity(delete);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * onCreateView, inflates view and the binding, sets the post list for the RecyclerView, sets the adapter, and sets the layout manager
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_item_list, container, false);

        data = ((LogActivity) getActivity()).getAllPosts();

        b = FragmentItemListBinding.inflate(getLayoutInflater());
        adapter = new MyItemRecyclerViewAdapter(data, this);

        b.list.setAdapter(adapter);
        b.list.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return b.getRoot();
    }
}