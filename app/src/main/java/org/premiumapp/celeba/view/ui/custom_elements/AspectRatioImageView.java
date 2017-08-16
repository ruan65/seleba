package org.premiumapp.celeba.view.ui.custom_elements;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by a on 16.08.17.
 */

@SuppressLint("AppCompatCustomView")
public class AspectRatioImageView extends ImageView {

    public AspectRatioImageView(Context context) {
        super(context);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(21) public AspectRatioImageView(Context context, AttributeSet attrs,
                                               int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredHeight = ((int) (((double) getMeasuredWidth()) / 0.68636363));
        setMeasuredDimension(getMeasuredWidth(), measuredHeight);
    }
}
