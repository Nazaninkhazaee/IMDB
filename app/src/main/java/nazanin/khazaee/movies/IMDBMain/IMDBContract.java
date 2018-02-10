package nazanin.khazaee.movies.IMDBMain;

import java.util.List;

import nazanin.khazaee.movies.utils.webModel.WebIMDBModel;

/**
 * Created by nazi on 02/01/2018.
 */

public interface IMDBContract {
    interface View{
        void onSearchResult(WebIMDBModel model);
        void onWebServiceError();

    }


    interface Presenter{
        void attachView(View view);
        void search(String word);
        void onSearchResult(WebIMDBModel model);
        void onWebServiceError();

    }
}
