package com.tmall.ultraviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tmall.ultraviewpager.UltraViewPager;

/* JADX INFO: loaded from: classes5.dex */
public class e extends View implements ViewPager.j, com.tmall.ultraviewpager.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f22874v = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f22875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager.j f22876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UltraViewPager.Orientation f22882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f22889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f22890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Paint f22891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f22892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f22893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f22894t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f22895u;

    public interface a {
        void a();
    }

    public e(Context context) {
        super(context);
        this.f22882h = UltraViewPager.Orientation.HORIZONTAL;
        n();
    }

    private float getItemHeight() {
        if (o()) {
            return Math.max(this.f22889o.getHeight(), this.f22890p.getHeight());
        }
        int i10 = this.f22878d;
        return i10 == 0 ? this.f22894t : i10;
    }

    private float getItemWidth() {
        if (o()) {
            return Math.max(this.f22889o.getWidth(), this.f22890p.getWidth());
        }
        int i10 = this.f22878d;
        return i10 == 0 ? this.f22894t : i10;
    }

    @Override // com.tmall.ultraviewpager.a
    public void a() {
        a aVar = this.f22895u;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a b(int i10) {
        this.f22891q.setColor(i10);
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a c(int i10) {
        this.f22891q.setStrokeWidth(i10);
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a d(int i10) {
        try {
            this.f22890p = BitmapFactory.decodeResource(getResources(), i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a e(int i10) {
        this.f22881g = i10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a f(int i10) {
        try {
            this.f22889o = BitmapFactory.decodeResource(getResources(), i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a g(UltraViewPager.Orientation orientation) {
        this.f22882h = orientation;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a h(int i10) {
        this.f22879e = i10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a i(int i10) {
        this.f22878d = i10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a j(Bitmap bitmap) {
        this.f22889o = bitmap;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a k(int i10, int i11, int i12, int i13) {
        this.f22883i = i10;
        this.f22884j = i11;
        this.f22885k = i12;
        this.f22886l = i13;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a l(Bitmap bitmap) {
        this.f22890p = bitmap;
        return this;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a m(int i10) {
        this.f22887m = i10;
        return this;
    }

    public final void n() {
        Paint paint = new Paint(1);
        this.f22891q = paint;
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.f22892r = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f22894t = TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
    }

    public final boolean o() {
        return (this.f22889o == null || this.f22890p == null) ? false : true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iB;
        int height;
        int width;
        int paddingTop;
        int strokeWidth;
        int paddingLeft;
        int paddingRight;
        int i10;
        float f10;
        float f11;
        float f12;
        super.onDraw(canvas);
        f fVar = this.f22875a;
        if (fVar == null || fVar.getAdapter() == null || (iB = ((d) this.f22875a.getAdapter()).b()) == 0) {
            return;
        }
        UltraViewPager.Orientation orientation = this.f22882h;
        UltraViewPager.Orientation orientation2 = UltraViewPager.Orientation.HORIZONTAL;
        if (orientation == orientation2) {
            height = this.f22875a.getWidth();
            width = this.f22875a.getHeight();
            paddingTop = getPaddingLeft() + this.f22883i;
            strokeWidth = getPaddingRight() + this.f22885k;
            paddingLeft = getPaddingTop() + this.f22884j;
            paddingRight = ((int) this.f22891q.getStrokeWidth()) + getPaddingBottom();
            i10 = this.f22886l;
        } else {
            height = this.f22875a.getHeight();
            width = this.f22875a.getWidth();
            paddingTop = getPaddingTop() + this.f22884j;
            strokeWidth = ((int) this.f22891q.getStrokeWidth()) + getPaddingBottom() + this.f22886l;
            paddingLeft = getPaddingLeft() + this.f22883i;
            paddingRight = getPaddingRight();
            i10 = this.f22885k;
        }
        int i11 = paddingRight + i10;
        float itemWidth = getItemWidth();
        int i12 = o() ? 1 : 2;
        if (this.f22879e == 0) {
            this.f22879e = (int) itemWidth;
        }
        float f13 = paddingTop;
        float f14 = i12 * itemWidth;
        float f15 = (iB - 1) * (this.f22879e + f14);
        int i13 = this.f22881g;
        float itemHeight = paddingLeft;
        int i14 = i13 & 7;
        int i15 = i13 & 112;
        if (i14 == 1) {
            f13 = (((height - paddingTop) - strokeWidth) - f15) / 2.0f;
        } else if (i14 == 3) {
            f13 += itemWidth;
        } else if (i14 == 5) {
            UltraViewPager.Orientation orientation3 = this.f22882h;
            if (orientation3 == orientation2) {
                f13 = ((height - strokeWidth) - f15) - itemWidth;
            }
            if (orientation3 == UltraViewPager.Orientation.VERTICAL) {
                itemHeight = (width - i11) - itemWidth;
            }
        }
        if (i15 == 16) {
            itemHeight = (((width - i11) - paddingLeft) - itemWidth) / 2.0f;
        } else if (i15 == 48) {
            itemHeight += itemWidth;
        } else if (i15 == 80) {
            if (this.f22882h == orientation2) {
                itemHeight = (width - i11) - getItemHeight();
            }
            if (this.f22882h == UltraViewPager.Orientation.VERTICAL) {
                f13 = (height - strokeWidth) - f15;
            }
        }
        if (i14 == 1 && i15 == 16) {
            itemHeight = (((width - i11) - paddingLeft) - itemWidth) / 2.0f;
        }
        float strokeWidth2 = this.f22878d;
        if (this.f22891q.getStrokeWidth() > 0.0f) {
            strokeWidth2 -= this.f22891q.getStrokeWidth() / 2.0f;
        }
        for (int i16 = 0; i16 < iB; i16++) {
            float f16 = (i16 * (this.f22879e + f14)) + f13;
            if (this.f22882h == UltraViewPager.Orientation.HORIZONTAL) {
                f12 = itemHeight;
            } else {
                f12 = f16;
                f16 = itemHeight;
            }
            if (!o()) {
                if (this.f22892r.getAlpha() > 0) {
                    this.f22892r.setColor(this.f22888n);
                    canvas.drawCircle(f16, f12, strokeWidth2, this.f22892r);
                }
                int i17 = this.f22878d;
                if (strokeWidth2 != i17) {
                    canvas.drawCircle(f16, f12, i17, this.f22891q);
                }
            } else if (i16 != this.f22875a.getCurrentItem()) {
                canvas.drawBitmap(this.f22890p, f16, f12, this.f22892r);
            }
        }
        float currentItem = this.f22875a.getCurrentItem() * (f14 + this.f22879e);
        if (this.f22880f) {
            currentItem += this.f22893s * itemWidth;
        }
        if (this.f22882h == UltraViewPager.Orientation.HORIZONTAL) {
            f11 = f13 + currentItem;
            f10 = itemHeight;
        } else {
            f10 = f13 + currentItem;
            f11 = itemHeight;
        }
        if (o()) {
            canvas.drawBitmap(this.f22889o, f11, f10, this.f22891q);
        } else {
            this.f22892r.setColor(this.f22887m);
            canvas.drawCircle(f11, f10, this.f22878d, this.f22892r);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i10) {
        this.f22877c = i10;
        ViewPager.j jVar = this.f22876b;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i10, float f10, int i11) {
        this.f22893s = f10;
        invalidate();
        ViewPager.j jVar = this.f22876b;
        if (jVar != null) {
            jVar.onPageScrolled(i10, f10, i11);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i10) {
        if (this.f22877c == 0) {
            invalidate();
        }
        ViewPager.j jVar = this.f22876b;
        if (jVar != null) {
            jVar.onPageSelected(i10);
        }
    }

    public void setIndicatorBuildListener(a aVar) {
        this.f22895u = aVar;
    }

    @Override // com.tmall.ultraviewpager.a
    public com.tmall.ultraviewpager.a setNormalColor(int i10) {
        this.f22888n = i10;
        return this;
    }

    public void setPageChangeListener(ViewPager.j jVar) {
        this.f22876b = jVar;
    }

    public void setViewPager(f fVar) {
        this.f22875a = fVar;
        fVar.setOnPageChangeListener(this);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22882h = UltraViewPager.Orientation.HORIZONTAL;
        n();
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22882h = UltraViewPager.Orientation.HORIZONTAL;
        n();
    }
}
