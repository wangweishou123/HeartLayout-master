package tyrantgit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DemoView extends View {
    private int width=0;
    private int height=0;

    private Paint paint;

    private int color;

    public DemoView(Context context) {
        super(context);
        init();
    }

    public DemoView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        width=getMeasuredWidth();
        height=getMeasuredHeight();
        color=R.color.theme;

        paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(0,0,100,paint);
        canvas.restore();
    }

}
