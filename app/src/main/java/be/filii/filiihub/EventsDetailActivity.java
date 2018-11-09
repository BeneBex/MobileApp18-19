package be.filii.filiihub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventsDetailActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_events_detail);

        Intent intent = getIntent();
        List items = new ArrayList();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String place = intent.getStringExtra("place");
        String date = intent.getStringExtra("date").substring(0,10);

        items.add(name);
        items.add(description);
        items.add(place);
        items.add(date);

        ((TextView) findViewById(R.id.textViewTitle)).setText(name);
        ((TextView) findViewById(R.id.textViewContent)).setText(description);
        ((TextView) findViewById(R.id.textViewPlace)).setText(place);
        ((TextView) findViewById(R.id.textViewDate)).setText(date);
    }
}
