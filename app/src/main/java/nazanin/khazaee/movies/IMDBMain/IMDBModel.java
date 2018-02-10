package nazanin.khazaee.movies.IMDBMain;

import android.provider.SyncStateContract;

import nazanin.khazaee.movies.utils.Constants;
import nazanin.khazaee.movies.utils.webModel.WebIMDBModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nazi on 02/01/2018.
 */

public class IMDBModel {
    IMDBContract.Presenter presenter;

    public IMDBModel(IMDBContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void getWordDetail(String word) {

        Constants.webInterface.searchWord(word , Constants.OMDB_ApiKey).enqueue(new Callback<WebIMDBModel>() {
            @Override
            public void onResponse(Call<WebIMDBModel> call, Response<WebIMDBModel> response) {
                presenter.onSearchResult(response.body());

            }

            @Override
            public void onFailure(Call<WebIMDBModel> call, Throwable t) {
                presenter.onWebServiceError();

            }

        });

    }
}
