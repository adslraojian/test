package test.raojian.com.interruptlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ListView listView;
    private MyAdapter adapter;
    private int screenW;
    private int screenH;
    private Button btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenW = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        screenH = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View v) {
        listView = (ListView) v.findViewById(R.id.fragment_main_list);
        btn = (Button) v.findViewById(R.id.fragment_mian_button);
//        listView.getLayoutParams().height = screenH - 300;
        adapter = new MyAdapter();
        listView.setAdapter(adapter);

        EdgeEffect ee = new EdgeEffect(getActivity()){

        };

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = null;
            if (convertView == null) {
                tv = new TextView(getContext());
                tv.setGravity(Gravity.CENTER);
                tv.setMinHeight(150);
                convertView = tv;
            }
            ((TextView) convertView).setText(position + "");
            return convertView;
        }
    }
}
