package rg;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R;
import g.l;
import g.n;
import g.n0;
import g.v;
import mg.h;
import mg.i;
import mg.j;
import rg.c;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T extends c> extends b implements h {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48757q = R.id.srl_classics_title;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48758r = R.id.srl_classics_arrow;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48759s = R.id.srl_classics_progress;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f48760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f48761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f48762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f48763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f48764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f48765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f48767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f48768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f48769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f48770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f48771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f48772p;

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f48769m = 500;
        this.f48770n = 20;
        this.f48771o = 20;
        this.f48772p = 0;
        this.f48755b = ng.b.f42143d;
    }

    public T A(int i10) {
        this.f48769m = i10;
        return (T) g();
    }

    public T B(@l int i10) {
        this.f48767k = true;
        this.f48768l = i10;
        i iVar = this.f48763g;
        if (iVar != null) {
            iVar.g(this, i10);
        }
        return (T) g();
    }

    public T C(@n int i10) {
        B(h0.d.f(getContext(), i10));
        return (T) g();
    }

    public T D(Drawable drawable) {
        this.f48765i = null;
        this.f48762f.setImageDrawable(drawable);
        return (T) g();
    }

    public T E(@v int i10) {
        this.f48765i = null;
        this.f48762f.setImageResource(i10);
        return (T) g();
    }

    public T F(ng.b bVar) {
        this.f48755b = bVar;
        return (T) g();
    }

    public T G(float f10) {
        this.f48760d.setTextSize(f10);
        i iVar = this.f48763g;
        if (iVar != null) {
            iVar.c(this);
        }
        return (T) g();
    }

    @Override // rg.b, mg.h
    public void b(@n0 j jVar, int i10, int i11) {
        ImageView imageView = this.f48762f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f48762f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public T g() {
        return this;
    }

    @Override // rg.b, mg.h
    public void i(@n0 j jVar, int i10, int i11) {
        b(jVar, i10, i11);
    }

    @Override // rg.b, mg.h
    public int l(@n0 j jVar, boolean z10) {
        ImageView imageView = this.f48762f;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.f48769m;
    }

    @Override // rg.b, mg.h
    public void n(@n0 i iVar, int i10, int i11) {
        this.f48763g = iVar;
        iVar.g(this, this.f48768l);
    }

    public T o(@l int i10) {
        this.f48766j = true;
        this.f48760d.setTextColor(i10);
        d dVar = this.f48764h;
        if (dVar != null) {
            dVar.a(i10);
            this.f48761e.invalidateDrawable(this.f48764h);
        }
        d dVar2 = this.f48765i;
        if (dVar2 != null) {
            dVar2.a(i10);
            this.f48762f.invalidateDrawable(this.f48765i);
        }
        return (T) g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.f48761e;
        ImageView imageView2 = this.f48762f;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.f48762f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f48772p == 0) {
            this.f48770n = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.f48771o = paddingBottom;
            if (this.f48770n == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iD = this.f48770n;
                if (iD == 0) {
                    iD = tg.b.d(20.0f);
                }
                this.f48770n = iD;
                int iD2 = this.f48771o;
                if (iD2 == 0) {
                    iD2 = tg.b.d(20.0f);
                }
                this.f48771o = iD2;
                setPadding(paddingLeft, this.f48770n, paddingRight, iD2);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            int size = View.MeasureSpec.getSize(i11);
            int i12 = this.f48772p;
            if (size < i12) {
                int i13 = (size - i12) / 2;
                setPadding(getPaddingLeft(), i13, getPaddingRight(), i13);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.f48770n, getPaddingRight(), this.f48771o);
        }
        super.onMeasure(i10, i11);
        if (this.f48772p == 0) {
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                int measuredHeight = getChildAt(i14).getMeasuredHeight();
                if (this.f48772p < measuredHeight) {
                    this.f48772p = measuredHeight;
                }
            }
        }
    }

    @Override // rg.b, mg.h
    public void setPrimaryColors(@l int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.f48767k) {
                B(iArr[0]);
                this.f48767k = false;
            }
            if (this.f48766j) {
                return;
            }
            if (iArr.length > 1) {
                o(iArr[1]);
            } else {
                o(iArr[0] == -1 ? -10066330 : -1);
            }
            this.f48766j = false;
        }
    }

    public T t(@n int i10) {
        o(h0.d.f(getContext(), i10));
        return (T) g();
    }

    public T u(Drawable drawable) {
        this.f48764h = null;
        this.f48761e.setImageDrawable(drawable);
        return (T) g();
    }

    public T v(@v int i10) {
        this.f48764h = null;
        this.f48761e.setImageResource(i10);
        return (T) g();
    }

    public T w(float f10) {
        ImageView imageView = this.f48761e;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iD = tg.b.d(f10);
        layoutParams.width = iD;
        layoutParams.height = iD;
        imageView.setLayoutParams(layoutParams);
        return (T) g();
    }

    public T x(float f10) {
        ImageView imageView = this.f48761e;
        ImageView imageView2 = this.f48762f;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int iD = tg.b.d(f10);
        marginLayoutParams2.rightMargin = iD;
        marginLayoutParams.rightMargin = iD;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return (T) g();
    }

    public T y(float f10) {
        ImageView imageView = this.f48762f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iD = tg.b.d(f10);
        layoutParams.width = iD;
        layoutParams.height = iD;
        imageView.setLayoutParams(layoutParams);
        return (T) g();
    }

    public T z(float f10) {
        ImageView imageView = this.f48761e;
        ImageView imageView2 = this.f48762f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int iD = tg.b.d(f10);
        layoutParams2.width = iD;
        layoutParams.width = iD;
        int iD2 = tg.b.d(f10);
        layoutParams2.height = iD2;
        layoutParams.height = iD2;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return (T) g();
    }
}
