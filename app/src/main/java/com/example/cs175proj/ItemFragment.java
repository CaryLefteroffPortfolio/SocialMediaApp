package com.example.cs175proj;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.net.Uri;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.core.app.ActivityCompat;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;
        import androidx.navigation.NavHost;
        import androidx.navigation.Navigation;
        import androidx.navigation.fragment.NavHostFragment;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.provider.Settings;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.cs175proj.databinding.FragmentItemListBinding;
        import com.example.cs175proj.databinding.FragmentMainBinding;

        import java.util.ArrayList;
        import java.util.Objects;

public class ItemFragment extends Fragment implements MyItemRecyclerViewAdapter.ClickListener{

    ArrayList<Post> data = new ArrayList<>();

    MyItemRecyclerViewAdapter adapter;
    FragmentItemListBinding b;

//    RecyclerView recyclerView;

    public ItemFragment() {
    }

    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("PostIndex", position);

        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_itemFragment_to_postContentViewFragment, bundle);
    }

    public void onCreateButtonClick() {
        NavController nav = NavHostFragment.findNavController(this);
        nav.navigate(R.id.action_itemFragment_to_createPostFragment);
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

            Intent intent = new Intent(this.getActivity(), LogActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, next, "find").commit();

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

        for(int i = 1; i < 25; i++) {
            data.add(new Post(new User("a", "a", "a"), "CONTENT OF POST!", "POST TITLE NUMBER " + i));
        }


        b = FragmentItemListBinding.inflate(getLayoutInflater());
        adapter = new MyItemRecyclerViewAdapter(data, this);
//        recyclerView = (RecyclerView) view;
//        recyclerView.setAdapter(adapter);

        b.list.setAdapter(adapter);
        b.list.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        return view;
        return b.getRoot();
    }

}