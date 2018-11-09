package be.filii.filiihub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EventsDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_detail, container, false);

        Bundle bundle = getArguments();
        TextView textviewTitle = (TextView) view.findViewById(R.id.textViewTitle);
        TextView textviewContent = (TextView) view.findViewById(R.id.textViewContent);
        TextView textviexPlace = (TextView) view.findViewById(R.id.textViewPlace);
        TextView textviexDate = (TextView) view.findViewById(R.id.textViewDate);
        String name = "";
        String description = "";
        String place = "";
        String date = "";

        if(bundle != null){
            name = getArguments().getString("name");
            description = getArguments().getString("description");
            place = getArguments().getString("place");
            date = getArguments().getString("date").substring(0,10);

        }

        textviewTitle.setText(name);
        textviewContent.setText(description);
        textviexPlace.setText(place);
        textviexDate.setText(date);

        return view;
    }
}
