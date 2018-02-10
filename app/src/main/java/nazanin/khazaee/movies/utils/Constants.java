package nazanin.khazaee.movies.utils;

/**
 * Created by nazi on 02/01/2018.
 */

public class Constants {
    public static String BASE_URL = "http://www.omdbapi.com" ;


    public static String OMDB_ApiKey = "70ad462a" ;
    public static WebServiceInterface webInterface = RetrofitGenerator.create(WebServiceInterface.class);


}
