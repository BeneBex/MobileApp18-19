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
        TextView Textview = (TextView) view.findViewById(R.id.textViewTitle);
        String item = "";

        if(bundle != null){
            item = getArguments().getString("name");
        }

        Textview.setText(item);

        return view;
    }
}
