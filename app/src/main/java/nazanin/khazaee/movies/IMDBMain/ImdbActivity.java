package nazanin.khazaee.movies.IMDBMain;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import org.androidannotations.annotations.Click;

import java.util.ArrayList;
import java.util.List;

import nazanin.khazaee.movies.MainActivity;
import nazanin.khazaee.movies.R;
import nazanin.khazaee.movies.utils.BaseActivity;
import nazanin.khazaee.movies.utils.PublicMethods;
import nazanin.khazaee.movies.utils.webModel.WebIMDBModel;

@EActivity(R.layout.activity_imdb)
public class ImdbActivity extends BaseActivity implements IMDBContract.View {

    IMDBContract.Presenter presenter;
    @ViewById
    EditText word;

    @ViewById
    ImageView img;
    @ViewById
    ListView imdb_list;




    @AfterViews
    void init(){
        presenter = new IMDBPresenter();
        presenter.attachView(this);

    }


    @Click
    void search(){
        if (word.length()!= 0){
            presenter.search(word.getText().toString());
        }
        else {
            PublicMethods.showToast(mContext,"لطفا نام فیلم را وارد نمایید!");
        }

    }


    @Override
    public void onSearchResult(WebIMDBModel model) {
        if (model.getTitle()==null ){
            PublicMethods.showToast(mContext,"فیلم موجود نمی باشد!");

        }
        else{

            List<String> text = new ArrayList<>();
            text.add(" Title : " + model.getTitle());
            text.add(" Year : "+model.getYear());
            text.add(" Released : "+model.getReleased());
            text.add(" Runtime : "+model.getRuntime());
            text.add(" Gener : "+model.getGenre());
            text.add(" Director : "+model.getDirector());
            text.add(" Actors : "+model.getActors());
            text.add(" Awards : "+model.getAwards());
            text.add(" Rating : "+model.getImdbRating());
            text.add("BoxOffice : "+model.getBoxOffice());
            ImdbListAdapter adap = new ImdbListAdapter(mContext , text);
            imdb_list.setAdapter(adap);


            Glide.with(mContext).load(model.getPoster()).into(img);
            PublicMethods.showImage(mContext, model.getPoster(), img);


        }




    }



    @Override
    public void onWebServiceError() {
        PublicMethods.showToast(mContext , "Error in WebService");


    }


}
