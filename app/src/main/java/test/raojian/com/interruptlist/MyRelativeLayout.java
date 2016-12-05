package test.raojian.com.interruptlist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/1/13.
 */
public class MyRelativeLayout extends RelativeLayout {
    private int downX, downY;
    private boolean isFirstMove = false;
    private MyScrollView scrollView;
    private boolean isIntercept;
    private ListView listView;
    private boolean isFirstVisibleItem = true;


    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        listView.dispatchTouchEvent(ev);
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("raojian", "rl_dispatch_DOWN");
//                return super.dispatchTouchEvent(ev);
                return super.dispatchTouchEvent(ev);
            case MotionEvent.ACTION_MOVE:
                Log.e("raojian", "rl_dispatch_MOVE");
//                return super.dispatchTouchEvent(ev);
                return super.dispatchTouchEvent(ev);
            case MotionEvent.ACTION_UP:
                Log.e("raojian", "rl_dispatch_UP");
//                return super.dispatchTouchEvent(ev);
                return super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("raojian", "rl_Intercept_DOWN");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("raojian", "rl_Intercept_MOVE");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e("raojian", "rl_Intercept_UP");
                return true;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("raojian", "rl_Touch_DOWN");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("raojian", "rl_Touch_MOVE");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e("raojian", "rl_Touch_UP");
                return true;
        }
        return true;
    }

}
