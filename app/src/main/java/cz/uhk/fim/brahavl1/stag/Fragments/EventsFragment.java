package cz.uhk.fim.brahavl1.stag.Fragments;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public class EventsFragment extends Fragment {

    public EventsFragment(){}

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView view = new TextView(container.getContext());
        view.setText("Events");
        return view;
    }
}
