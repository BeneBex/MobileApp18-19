package be.filii.filiihub;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import be.filii.filiihub.Adapter.EventAdapter;
import be.filii.filiihub.data.Event;

public class EventFragment extends Fragment{
    private EventAdapter adapter;
    private List<Event> events = new ArrayList<Event>();
    private RecyclerView listEventShower;


    public static Fragment newInstance() {
        return new EventFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        listEventShower = view.findViewById(R.id.recyclerfh);
        adapter = new EventAdapter(events);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listEventShower.setLayoutManager(layoutManager);
        listEventShower.setItemAnimator(new DefaultItemAnimator());
        listEventShower.setAdapter(adapter);
        prepareEvent();
        return view;
    }

    private void prepareEvent(){
        Event event = new Event(new Date(2018,12,20), "Blue Thrill Td", "een toffe TD", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2018,11,27), "Boardgame Night", "spelletjes avond met Cegeka", "Cegeka Hasselt");
        events.add(event);
        event = new Event(new Date(2018,12,31), "New Year", "Samen het nieuwe jaar instappen!", "Fitlink Diepenbeek");
        events.add(event);
        event = new Event(new Date(2019,2,14), "Valentijn", "We gaan samen chocolade desserts maken!", "Bakkery Hasselt");
        events.add(event);
        event = new Event(new Date(2019,1,20), "LAN Party", "In een grote zaal samen game", "PXL");
        events.add(event);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }


}
