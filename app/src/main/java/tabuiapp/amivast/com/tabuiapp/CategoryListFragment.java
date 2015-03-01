package tabuiapp.amivast.com.tabuiapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Boka on 02-Mar-15.
 */
public class CategoryListFragment extends ListFragment {

    Communicator comm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExampleAdapter adapter = new ExampleAdapter(getActivity(), TabActivity.categoryName, TabActivity.categoryRewardCounter);
        setListAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        comm.resond();
    }

    private class ExampleAdapter extends BaseAdapter {

        Context context;
        ArrayList<String> title;
        ArrayList<Integer> counter;

        public ExampleAdapter(Context context, ArrayList<String> title, ArrayList<Integer> counter) {
            this.context = context;
            this.title = title;
            this.counter = counter;
        }

        @Override
        public int getCount() {
            return title.size();
        }

        @Override
        public Object getItem(int position) {
            return title.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.fragment_category_item, null);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            tvName.setText(title.get(position));
            TextView tvNum = (TextView) view.findViewById(R.id.tvNumber);
            tvNum.setText(counter.get(position) + " rewards");
            return view;
        }

    }
}
