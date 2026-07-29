package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.u0;
import androidx.swiperefreshlayout.R;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7729d = -328966;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7730e = 1023410176;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7731f = 503316480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f7732g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f7733h = 1.75f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f7734i = 3.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7735j = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f7736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7738c;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    public static class C0071a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Paint f7739a = new Paint();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f7741c;

        public C0071a(a aVar, int i10) {
            this.f7741c = aVar;
            this.f7740b = i10;
            a((int) rect().width());
        }

        public final void a(int i10) {
            float f10 = i10 / 2;
            this.f7739a.setShader(new RadialGradient(f10, f10, this.f7740b, new int[]{a.f7730e, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.f7741c.getWidth() / 2;
            float height = this.f7741c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f7739a);
            canvas.drawCircle(width, height, r0 - this.f7740b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    public a(Context context) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i10 = (int) (1.75f * f10);
        int i11 = (int) (0.0f * f10);
        this.f7737b = (int) (3.5f * f10);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.f7738c = typedArrayObtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, f7729d);
        typedArrayObtainStyledAttributes.recycle();
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            u0.N1(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0071a(this, this.f7737b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f7737b, i11, i10, f7731f);
            int i12 = this.f7737b;
            setPadding(i12, i12, i12, i12);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f7738c);
        u0.I1(this, shapeDrawable);
    }

    public final boolean a() {
        return true;
    }

    public int b() {
        return this.f7738c;
    }

    public void c(Animation.AnimationListener animationListener) {
        this.f7736a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f7736a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f7736a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f7737b * 2), getMeasuredHeight() + (this.f7737b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
            this.f7738c = i10;
        }
    }
}
