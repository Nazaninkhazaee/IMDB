package nazanin.khazaee.movies.IMDBMain;

import nazanin.khazaee.movies.utils.BaseActivity;
import nazanin.khazaee.movies.utils.webModel.WebIMDBModel;

/**
 * Created by nazi on 02/01/2018.
 */

public class IMDBPresenter extends BaseActivity implements IMDBContract.Presenter {
    private IMDBContract.View view;
    IMDBModel model;

    @Override
    public void attachView(IMDBContract.View view) {

        this.view = view;
        model = new IMDBModel(this);
    }

    @Override
    public void search(String word) {
        model.getWordDetail(word);
      //  view.showHideLoading(true);
    }

    @Override
    public void onSearchResult(WebIMDBModel model) {
        view.onSearchResult(model);
       // view.showHideLoading(false);

    }

    @Override
    public void onWebServiceError() {
        //view.showHideLoading(false);
    }
}
