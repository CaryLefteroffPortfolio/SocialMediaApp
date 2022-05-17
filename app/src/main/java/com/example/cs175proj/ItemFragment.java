package com.example.cs175proj;

        import android.content.Context;
        import android.os.Bundle;

        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;
        import androidx.navigation.Navigation;
        import androidx.navigation.fragment.NavHostFragment;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.example.cs175proj.databinding.FragmentItemListBinding;
        import com.example.cs175proj.databinding.FragmentMainBinding;

        import java.util.ArrayList;

public class ItemFragment extends Fragment implements MyItemRecyclerViewAdapter.ClickListener{

    ArrayList<Post> data = new ArrayList<>();
    MyItemRecyclerViewAdapter adapter;
    FragmentItemListBinding b;

    RecyclerView recyclerView;

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
        super.onCreate(savedInstanceState);
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
        recyclerView = (RecyclerView) view;
        recyclerView.setAdapter(adapter);

        b.list.setAdapter(adapter);
        b.list.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        return view;
        return b.getRoot();
    }

}