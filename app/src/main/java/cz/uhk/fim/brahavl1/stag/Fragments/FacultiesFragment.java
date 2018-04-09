package cz.uhk.fim.brahavl1.stag.Fragments;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import cz.uhk.fim.brahavl1.stag.R;
import cz.uhk.fim.brahavl1.stag.model.CalendarItem;
import cz.uhk.fim.brahavl1.stag.servicies.StagInterface;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public class FacultiesFragment extends Fragment {

    StagInterface stagInterface;

    @BindView(R.id.layoutEvents)
    LinearLayout linearLayout;

    public FacultiesFragment(){}

    @SuppressLint("StaticFieldLeak")
    @Override
    public void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://stag-demo.uhk.cz/ws/services/rest/").addConverterFactory(GsonConverterFactory.create()).build();

        stagInterface = retrofit.create(StagInterface.class);

        new AsyncTask<String, Void, List<CalendarItem>>() {
            @Override
            protected List<CalendarItem> doInBackground(String... strings) {
                Call<List<CalendarItem>> listCall = stagInterface.listCalendarItems(strings[0]);

                try {
                    listCall.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        }.execute("2018"); //tohle co tam pošleme
    }

    @Nullable
    public void onCreateView(@Nullable Bundle savedInstanceState) {


    }
}
