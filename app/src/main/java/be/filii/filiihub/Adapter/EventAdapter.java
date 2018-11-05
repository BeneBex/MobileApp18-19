package be.filii.filiihub.Adapter;

import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import be.filii.filiihub.R;
import be.filii.filiihub.data.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private List<Event> events;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name;

        public MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name);
        }
    }
    public EventAdapter(List<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public EventAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerfh_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyViewHolder myViewHolder, int index) {
        Event event = events.get(index);
        myViewHolder.name.setText(event.getName());
    }

    @Override
    public int getItemCount() {
        int count = events.size();
        return count;
    }
}
