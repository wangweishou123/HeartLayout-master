package tyrantgit.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class AttriAnimator extends AbstractPathAnimator{
    private final AtomicInteger mCounter = new AtomicInteger(0);
    private Handler mHandler;
    private Context context;
    private float count=0f;
    public AttriAnimator(Config config,Context context) {
        super(config);
        mHandler = new Handler(Looper.getMainLooper());
        this.context=context;
    }

    @Override
    public void start(final View child, final ViewGroup parent, int position) {
        parent.addView(child,
                new ViewGroup.LayoutParams(mConfig.heartWidth, mConfig.heartHeight));
        AnimatorSet animatorSet=new AnimatorSet();


        ObjectAnimator transY=ObjectAnimator.ofFloat(child,"translationY",1000f,0f);
        transY.setInterpolator(new LinearInterpolator());

        if (count==0){
            count=new Random().nextInt(400);
        }else if (count>150){
            count=new Random().nextInt(400);
            if (count>150){
                count-=150;
            }
        }else {
            count=new Random().nextInt(400);
            if (count<150){
                count+=150;
            }
        }

        ObjectAnimator transX=ObjectAnimator.ofFloat(child,"translationX",150f,count);
        ObjectAnimator scale=ObjectAnimator.ofFloat(child,"rotation",0f,new Random().nextInt(20)-10);


        animatorSet.setDuration(mConfig.animDuration);
        animatorSet.playTogether(transX,transY,scale);

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mCounter.incrementAndGet();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        parent.removeView(child);
                    }
                });
                mCounter.decrementAndGet();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }
}
