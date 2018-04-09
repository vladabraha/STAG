package cz.uhk.fim.brahavl1.stag.Fragments;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.uhk.fim.brahavl1.stag.R;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public class EventsFragment extends Fragment {

    @BindView(R.id.layoutEvents)
    LinearLayout linearLayout;

    public EventsFragment(){}

    @SuppressLint("StaticFieldLeak")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //nový vlákno
        //vrací stav v integru - progress
        //vlákno vrátí list stringů
        new AsyncTask<String, Integer, List<String>>(){

            @Override //sem to přijde z doinbackground
            protected void onPostExecute(List<String> strings) {
                for(String s :strings){
                    System.out.println("OnPostExecute: " + s);
                    TextView textView = new TextView(getContext());
                    textView.setText(s);
                    linearLayout.addView(textView);
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {

                int percentage = values[0];
                Toast.makeText(getContext(),"Procent" + percentage, Toast.LENGTH_LONG).show();
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }



            @Override //dostanu vstupni string dole z execute
            protected List<String> doInBackground(String... strings) { //tady nejde skočit do ui odsud!!!
                //bezi na pozadi

                System.out.println("Do in background: " + strings[0]);

//                List<String> list = new ArrayList<String>(){{
//                    add("ahoj");
//                add("hello");
//                }};

          String nickname = strings[0];
          List<String> list = new ArrayList<String>();
          for (int i = 0; i < nickname.length(); i++){

              publishProgress((int)(float)(i / nickname.length()) * 100); //prijde do in progress update

              //tohle je uspání vlákna, normálně nepoužívat, je to tu jenom pro ukázku, aby to ukázaalo, jak to stahuje procenta
              try{
                  Thread.sleep(100);
              }catch(InterruptedException e){
                  e.printStackTrace();
              }


              list.add(nickname.substring(i,i + 1 ));
          }
                return list;
            }

        }.execute("http://uhk.cz");
    }


    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, null);

        ButterKnife.bind(this, view); //musí se vždycky nabindovat, jinak to nebude fungovat

        LinearLayout linearLayout = view.findViewById(R.id.layoutEvents);


        TextView title = new TextView(view.getContext());
        title.setText("events");
        linearLayout.addView(title);
        return view;
    }
}
