package be.filii.filiihub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import be.filii.filiihub.Adapter.EventAdapter;
import be.filii.filiihub.data.DataMock;
import be.filii.filiihub.data.Event;

public class EventsListFragment extends Fragment
    implements EventAdapter.ListItemClickListener{

    private List<Event> data;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_events, container, false);
        return view;
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Log.i("LISTITEM", "onListItemClick: " + data.get(clickedItemIndex).getName());

        EventsDetailFragment detailFragment = (EventsDetailFragment) getFragmentManager().findFragmentById(R.id.detail);
        if (detailFragment != null && detailFragment.isVisible()) {
            // Visible: send bundle
            EventsDetailFragment newFragment = new EventsDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", data.get(clickedItemIndex).getName());
            bundle.putString("description", data.get(clickedItemIndex).getDescription());
            bundle.putString("place", data.get(clickedItemIndex).getPlace());
            bundle.putString("date", data.get(clickedItemIndex).getDate().toString());

            newFragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(detailFragment.getId(), newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            // Not visible: start as intent
            Intent intent = new Intent(getActivity().getBaseContext(), EventsDetailActivity.class);
            intent.putExtra("name", data.get(clickedItemIndex).getName());
            intent.putExtra("description", data.get(clickedItemIndex).getDescription());
            intent.putExtra("place", data.get(clickedItemIndex).getPlace());
            intent.putExtra("date", data.get(clickedItemIndex).getDate().toString());
            getActivity().startActivity(intent);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data = DataMock.mockEvents();

        mRecyclerView = (RecyclerView) getView().findViewById(R.id.events_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter= new EventAdapter(data, this);
        mRecyclerView.setAdapter(mAdapter);

    }
}
