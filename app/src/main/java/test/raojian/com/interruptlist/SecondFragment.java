package test.raojian.com.interruptlist;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import test.raojian.com.interruptlist.utils.DPIUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class SecondFragment extends Fragment {
    private int screenW;
    private int screenH;
    private View titleLayout;
    private View moveLayout;
    private RelativeLayout.LayoutParams moveParams;
    private int moveValue = 50; //上下浮动值
    private ValueAnimator inAnim, outAnim;
    private Runnable inRun, outRun;
    private int titleH, moveH;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){

            }else{

            }

        }

    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenW = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        screenH = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        titleH = DPIUtils.dip2px(getContext(), 150);
        moveH = DPIUtils.dip2px(getContext(), 100);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View v) {
        moveLayout = v.findViewById(R.id.fragment_sencond_move_layout);
        titleLayout = v.findViewById(R.id.fragment_sencond_title_layout);
        moveParams = (RelativeLayout.LayoutParams) moveLayout.getLayoutParams();
    }

    @Override
    public void onResume() {
        super.onResume();
        initInAnim();
        initOutAnim();

    }

    private void initInAnim(){
        inRun = new Runnable() {
            @Override
            public void run() {
                outAnim.start();
            }
        };
        inAnim = ValueAnimator.ofInt(titleH - moveValue, titleH);
//        animator.setTarget(mBlueBall);
        inAnim.setDuration(2000).start();

//      animator.setInterpolator(value)
        inAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                handler.postDelayed(inRun, 4000);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        inAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("raojian", (int) animation.getAnimatedValue() +"in");
                moveParams.setMargins(0, (int) animation.getAnimatedValue(), 0, 0);
                moveLayout.requestLayout();
            }
        });
    }

    private void initOutAnim(){
        outRun = new Runnable() {
            @Override
            public void run() {
                inAnim.start();
            }
        };
        outAnim = ValueAnimator.ofInt(titleH, titleH - moveValue);
//        animator.setTarget(mBlueBall);
        outAnim.setDuration(2000);

//      animator.setInterpolator(value)
        outAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                handler.postDelayed(outRun, 4000);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        outAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("raojian", (int) animation.getAnimatedValue() +"out");
                moveParams.setMargins(0, (int) animation.getAnimatedValue(), 0, 0);
                moveLayout.requestLayout();
            }
        });
    }
}
