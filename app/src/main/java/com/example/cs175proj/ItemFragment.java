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
        import android.widget.Button;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;


        import com.example.cs175proj.databinding.FragmentItemListBinding;

        import java.util.ArrayList;

public class ItemFragment extends Fragment implements MyItemRecyclerViewAdapter.ClickListener{

    ArrayList<Post> data = new ArrayList<>();

    MyItemRecyclerViewAdapter adapter;
    FragmentItemListBinding b;

    FloatingActionButton fab;
//    RecyclerView recyclerView;

    public ItemFragment() {
    }

    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("PostIndex", position);

        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_itemFragment_to_postContentViewFragment, bundle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.exit){
            SharedPreferences sp = getActivity().getSharedPreferences("SESSION_KEY", Context.MODE_PRIVATE);
            SharedPreferences.Editor e = sp.edit();
            e.clear();
            e.apply();
            MainFragment next = new MainFragment();

            NavController nav = NavHostFragment.findNavController(this);
            nav.navigate(R.id.action_itemFragment_to_mainFragment);
        }else if(item.getItemId() == R.id.uninstall){
            Intent delete = new Intent(Intent.ACTION_DELETE, Uri.parse("package:" + getActivity().getPackageName()));
            startActivity(delete);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        data = ((LogActivity) getActivity()).getAllPosts();

        b = FragmentItemListBinding.inflate(getLayoutInflater());
        adapter = new MyItemRecyclerViewAdapter(data, this);

        b.list.setAdapter(adapter);
        b.list.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        return view;
        return b.getRoot();
    }

    public void onCreateButtonClick() {
        System.out.println("HERE");
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_itemFragment_to_createPostFragment);
    }

}