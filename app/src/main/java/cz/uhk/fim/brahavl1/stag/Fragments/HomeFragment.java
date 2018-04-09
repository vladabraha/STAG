package cz.uhk.fim.brahavl1.stag.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.uhk.fim.brahavl1.stag.R;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.textViewHome)
    TextView textView;

    @BindView(R.id.btnHome)
    Button button;

    @OnClick(R.id.btnHome)
    public void onHomeButtonClick(View v){
        textView.setText("Kliknuto z tlacitka!");
    }


    public HomeFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        ButterKnife.bind(this, view);
        textView.setText("ahoj z fragmentu");

        return view;
    }
}
