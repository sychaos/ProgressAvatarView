package cloudist.cc.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by cloudist on 2017/10/24.
 */

public class ProgressAvatarView extends ImageView {

    private int mColor;
    private Paint mProgressPaint;
    private int centerPositionY;
    private int centerPositionX;

    private int mHeight;
    private int mWidth;

    //    TODO 圆形头像处理
    public ProgressAvatarView(Context context) {
        super(context);
        initView(context, null);
    }

    public ProgressAvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ProgressAvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        initAttrs(context, attrs);
        mProgressPaint = new Paint();
        mProgressPaint.setColor(mColor);
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setStrokeWidth(5);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (null != attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProgressAvatarView);
            mColor = a.getColor(R.styleable.ProgressAvatarView_progress_color, Color.parseColor("#007bff"));
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //  增加偏移 TODO
        canvas.drawCircle(centerPositionX, centerPositionY, mWidth / 2, mProgressPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        //TODO 适配warp
        //centerPositionY为view的正中央
        centerPositionY = mHeight / 2 + 5;
        centerPositionX = mWidth / 2 + 5;
        super.onMeasure(widthMeasureSpec + 10, heightMeasureSpec + 10);
    }
}
