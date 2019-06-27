package tyrantgit.sample.heartlayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import tyrantgit.widget.HeartLayout;


public class MainActivity extends Activity {

    private Random mRandom = new Random();
    private Timer mTimer = new Timer();
    private HeartLayout mHeartLayout;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeartLayout = (HeartLayout) findViewById(R.id.heart_layout);
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mHeartLayout.post(new Runnable() {
                    @Override
                    public void run() {
//                        DemoView demoView=new DemoView(MainActivity.this);
//                        demoView.setLayoutParams(new ViewGroup.LayoutParams(150,150));
                        count++;
                        View view=getLayoutInflater().inflate(R.layout.item_exercise,null);
                        final TextView tv_content_exercise_fragment=view.findViewById(R.id.tv_content_exercise_fragment);
                        tv_content_exercise_fragment.setText("你要三日游吗？".concat(String.valueOf(count)));
                        tv_content_exercise_fragment.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String result=tv_content_exercise_fragment.getText().toString().trim();
                                Log.e("qwe","========>"+result);
                            }
                        });
                        mHeartLayout.addDemoView(view,count);
                    }
                });
            }
        }, 1000, 1000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }

    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255),
                mRandom.nextInt(255));
    }

    private View getItemView(){
        View view=LayoutInflater.from(this).inflate(R.layout.item_exercise,null);
        view.setLayoutParams(new ConstraintLayout.LayoutParams(500,200));
        return view;
    }
}
