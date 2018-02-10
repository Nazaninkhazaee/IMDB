package nazanin.khazaee.movies.utils;

import nazanin.khazaee.movies.utils.webModel.WebIMDBModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nazi on 02/01/2018.
 */

public interface WebServiceInterface {
    @GET("/")
    Call<WebIMDBModel> searchWord(@Query("t") String t , @Query("apikey") String apikey);
}
