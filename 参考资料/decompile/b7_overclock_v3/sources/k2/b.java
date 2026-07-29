package k2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.v;
import h0.d;

/* JADX INFO: loaded from: classes2.dex */
public class b extends androidx.viewpager.widget.a {
    public static final String C1 = "PagerTabStrip";
    public static final int C2 = 16;
    public static final int E7 = 64;
    public static final int F7 = 1;
    public static final int G7 = 32;
    public static final int K1 = 3;
    public static final int K2 = 32;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f36970v2 = 6;
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public float K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f36971k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f36972k1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f36973s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f36974t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f36975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f36976v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f36977v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f36978w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f36979x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f36980y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Rect f36981z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f8139a.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: renamed from: k2.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0418b implements View.OnClickListener {
        public ViewOnClickListenerC0418b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = b.this.f8139a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public b(@n0 Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.a
    public void d(int i10, float f10, boolean z10) {
        Rect rect = this.f36981z;
        int height = getHeight();
        int left = this.f8141c.getLeft() - this.f36979x;
        int right = this.f8141c.getRight() + this.f36979x;
        int i11 = height - this.f36974t;
        rect.set(left, i11, right, height);
        super.d(i10, f10, z10);
        this.A = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f8141c.getLeft() - this.f36979x, i11, this.f8141c.getRight() + this.f36979x, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.B;
    }

    @Override // androidx.viewpager.widget.a
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f36978w);
    }

    @l
    public int getTabIndicatorColor() {
        return this.f36973s;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f8141c.getLeft() - this.f36979x;
        int right = this.f8141c.getRight() + this.f36979x;
        int i10 = height - this.f36974t;
        this.f36980y.setColor((this.A << 24) | (this.f36973s & 16777215));
        float f10 = height;
        canvas.drawRect(left, i10, right, f10, this.f36980y);
        if (this.B) {
            this.f36980y.setColor((-16777216) | (this.f36973s & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.D, getWidth() - getPaddingRight(), f10, this.f36980y);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f36971k0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.K0 = x10;
            this.f36972k1 = y10;
            this.f36971k0 = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x10 - this.K0) > this.f36977v1 || Math.abs(y10 - this.f36972k1) > this.f36977v1)) {
                this.f36971k0 = true;
            }
        } else if (x10 < this.f8141c.getLeft() - this.f36979x) {
            ViewPager viewPager = this.f8139a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x10 > this.f8141c.getRight() + this.f36979x) {
            ViewPager viewPager2 = this.f8139a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@l int i10) {
        super.setBackgroundColor(i10);
        if (this.C) {
            return;
        }
        this.B = (i10 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.C) {
            return;
        }
        this.B = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@v int i10) {
        super.setBackgroundResource(i10);
        if (this.C) {
            return;
        }
        this.B = i10 == 0;
    }

    public void setDrawFullUnderline(boolean z10) {
        this.B = z10;
        this.C = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f36975u;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(@l int i10) {
        this.f36973s = i10;
        this.f36980y.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(@n int i10) {
        setTabIndicatorColor(d.f(getContext(), i10));
    }

    @Override // androidx.viewpager.widget.a
    public void setTextSpacing(int i10) {
        int i11 = this.f36976v;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    public b(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f36980y = paint;
        this.f36981z = new Rect();
        this.A = 255;
        this.B = false;
        this.C = false;
        int i10 = this.f8152n;
        this.f36973s = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f36974t = (int) ((3.0f * f10) + 0.5f);
        this.f36975u = (int) ((6.0f * f10) + 0.5f);
        this.f36976v = (int) (64.0f * f10);
        this.f36979x = (int) ((16.0f * f10) + 0.5f);
        this.D = (int) ((1.0f * f10) + 0.5f);
        this.f36978w = (int) ((f10 * 32.0f) + 0.5f);
        this.f36977v1 = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f8140b.setFocusable(true);
        this.f8140b.setOnClickListener(new a());
        this.f8142d.setFocusable(true);
        this.f8142d.setOnClickListener(new ViewOnClickListenerC0418b());
        if (getBackground() == null) {
            this.B = true;
        }
    }
}
