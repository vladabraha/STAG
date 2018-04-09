package cz.uhk.fim.brahavl1.stag.servicies;

import java.util.List;

import cz.uhk.fim.brahavl1.stag.model.CalendarItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by brahavl1 on 09.04.2018.
 */

public interface StagInterface {

    //zavola a hodi to do listu calendarItemů
    @GET("kalendar/getHarmonogramRoku?rok=(year)&outputFormat=json")
    Call<List<CalendarItem>> listCalendarItems(@Path("year") String year);
}
