package nazanin.khazaee.movies.IMDBMain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import nazanin.khazaee.movies.R;

/**
 * Created by nazi on 02/01/2018.
 */

public class ImdbListAdapter extends BaseAdapter {
    Context mContext;
    List<String> resulte;

    public ImdbListAdapter(Context mContext, List<String> resulte_title ) {
        this.mContext = mContext;
        this.resulte = resulte_title;
    }
        @Override
    public int getCount() {
        return resulte.size();
    }

    @Override
    public Object getItem(int i) {
        return resulte.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = LayoutInflater.from(mContext).inflate(R.layout.imdb_list_item, viewGroup, false);
        TextView text = rowView.findViewById(R.id.text);
        text.setText(resulte.get(position));

        return rowView;
    }
}
