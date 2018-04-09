package cz.uhk.fim.brahavl1.stag.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public class SubjectsFragment extends Fragment {

    public SubjectsFragment(){}

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView view = new TextView(container.getContext());
        view.setText("Subjects");
        return view;
    }
}
