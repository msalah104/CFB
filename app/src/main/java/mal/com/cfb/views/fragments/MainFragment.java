package mal.com.cfb.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import mal.com.cfb.R;


public class MainFragment extends Fragment {


    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_main);
        return view;
    }

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(int position);
    }

//    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ((Callback) getActivity())
                .onItemSelected(position);

    }
}
