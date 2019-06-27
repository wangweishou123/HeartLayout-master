/*
 * Copyright (C) 2015 tyrantgit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tyrantgit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;


public class HeartLayout extends RelativeLayout {

    private AbstractPathAnimator mAnimator;

    public HeartLayout(Context context) {
        super(context);
        init(null, 0,context);
    }

    public HeartLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0,context);
    }

    public HeartLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr,context);
    }

    private void init(AttributeSet attrs, int defStyleAttr,Context context) {

        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.HeartLayout, defStyleAttr, 0);

        mAnimator = new AttriAnimator(AbstractPathAnimator.Config.fromTypeArray(a),context);

        a.recycle();
    }

    public AbstractPathAnimator getAnimator() {
        return mAnimator;
    }

    public void setAnimator(AbstractPathAnimator animator) {
        clearAnimation();
        mAnimator = animator;
    }

    public void clearAnimation() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).clearAnimation();
        }
        removeAllViews();
    }

    public void addHeart(int color,int position) {
        HeartView heartView = new HeartView(getContext());
        heartView.setColor(color);
        mAnimator.start(heartView, this,position);
    }

    public void addHeart(int color, int heartResId, int heartBorderResId,int position) {
        HeartView heartView = new HeartView(getContext());
        heartView.setColorAndDrawables(color, heartResId, heartBorderResId);
        mAnimator.start(heartView, this,position);
    }
    public void addDemoView(View view,int position){
        mAnimator.start(view,this,position);
    }

}
