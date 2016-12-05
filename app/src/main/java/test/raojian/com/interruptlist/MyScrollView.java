package test.raojian.com.interruptlist;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/1/13.
 */
public class MyScrollView extends ScrollView {

    private int screenW;
    private int screenH;
    private Context context;
    private int[] loc = new int[2];

    private Button btn;
    private ListView listView;
    private boolean isInterceptTouch = true;
    private boolean isListTop = true;


    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        screenW = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
        screenH = ((Activity) context).getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ListView) findViewById(R.id.fragment_main_list);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    View v = view.getChildAt(0);
                    int top = v.getTop();
                    Log.d("raojian", "top" + top);
                    if (top >= -2) {
                        isListTop = true;
                    } else {
                        isListTop = false;
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    public boolean isInterceptTouch() {
        return isInterceptTouch;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
////        listView.dispatchTouchEvent(ev);
//        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e("raojian", "sv_dispatch_DOWN");
////                return super.dispatchTouchEvent(ev);
//                return super.dispatchTouchEvent(ev);
//            case MotionEvent.ACTION_MOVE:
//                Log.e("raojian", "sv_dispatch_MOVE");
////                return super.dispatchTouchEvent(ev);
//                return super.dispatchTouchEvent(ev);
//            case MotionEvent.ACTION_UP:
//                Log.e("raojian", "sv_dispatch_UP");
////                return super.dispatchTouchEvent(ev);
//                return super.dispatchTouchEvent(ev);
//        }


        listView.getLocationOnScreen(loc);
        int scrollY = loc[1];
        Log.d("raojian", scrollY + "");
        if (scrollY <= 0) {
            isInterceptTouch = false;
        } else {
            isInterceptTouch = true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e("raojian", "sv_Intercept_DOWN");
//                return false;
//            case MotionEvent.ACTION_MOVE:
//                Log.d("raojian", "isListTop："+isListTop);
//                if(isListTop){
//                    return false;
//                }else{
//                    return true;
//                }
////                Log.e("raojian", "sv_Intercept_MOVE");
////                return false;
//            case MotionEvent.ACTION_UP:
//                Log.e("raojian", "sv_Intercept_UP");
//                return true;
//        }

//        Log.d("raojian", )
        if(!isInterceptTouch){
            listView.dispatchTouchEvent(ev);
        }

        return true;


    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        int action = ev.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e("raojian", "sv_Touch_DOWN");
//                return true;
//            case MotionEvent.ACTION_MOVE:
//                Log.e("raojian", "sv_Touch_MOVE");
//                return true;
//            case MotionEvent.ACTION_UP:
//                Log.e("raojian", "sv_Touch_UP");
//                return true;
//        }
        if(isInterceptTouch)
            super.onTouchEvent(ev);
        return true;
    }
}
