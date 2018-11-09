package be.filii.filiihub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class EventsDetailActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_events_detail);

        Intent intent = getIntent();
        String item = intent.getStringExtra("name");

        ((TextView) findViewById(R.id.textViewTitle)).setText(item);
    }
}
