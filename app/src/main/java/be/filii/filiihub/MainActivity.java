package be.filii.filiihub;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            int navItemId = item.getItemId();

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("nav_id", navItemId);
            editor.apply();



            switch (item.getItemId()) {
                case R.id.navigation_filiihub:
                    selectedFragment = FiliihubFragment.newInstance();
                    openFragment(selectedFragment);
                    return true;
                case R.id.navigation_event:
                    selectedFragment = EventsFragment.newInstance();
                    openFragment(selectedFragment);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = this.getPreferences(this.MODE_PRIVATE);







        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int defaultValue = R.id.navigation_filiihub;
        int previousNavId = sharedPref.getInt("nav_id", defaultValue);

        Fragment selectedFragment = null;
        String previousNav = null;
        switch (previousNavId) {
            case R.id.navigation_filiihub:
                selectedFragment = FiliihubFragment.newInstance();
                break;
            case R.id.navigation_event:
                selectedFragment = EventsFragment.newInstance();
                break;
        }

        openFragment(selectedFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(previousNavId);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    private void openFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        //transaction.addToBackStack(null); wisselen van ding niet naar terugknop zetten.
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = (MenuItem) menu.findItem(R.id.switchId);
        item.setActionView(R.layout.switch_layout);
        Switch switchAB = item.getActionView().findViewById(R.id.switchAB);
        switchAB.setChecked(false);

        switchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
