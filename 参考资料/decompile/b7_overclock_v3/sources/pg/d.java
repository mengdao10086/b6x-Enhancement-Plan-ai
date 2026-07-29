package pg;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.n0;
import g.p0;
import mg.g;
import mg.h;
import mg.i;
import mg.j;

/* JADX INFO: loaded from: classes5.dex */
public class d extends rg.b implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f46650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f46651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f46652g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f46653h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f46654i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f46655j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f46656k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f46657l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f46658m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f46659n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f46660o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f46661p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f46662q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public mg.d f46663r;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46664a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f46664a = iArr;
            try {
                iArr[RefreshState.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46664a[RefreshState.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46664a[RefreshState.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46664a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public d A(g gVar) {
        return B(gVar, -1, -2);
    }

    public d B(g gVar, int i10, int i11) {
        if (gVar != null) {
            h hVar = this.f46661p;
            if (hVar != null) {
                removeView(hVar.getView());
            }
            if (i10 == 0) {
                i10 = -1;
            }
            if (i11 == 0) {
                i11 = -2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, i11);
            ViewGroup.LayoutParams layoutParams2 = gVar.getView().getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            if (gVar.getSpinnerStyle() == ng.b.f42145f) {
                addView(gVar.getView(), 0, layoutParams);
            } else {
                addView(gVar.getView(), getChildCount(), layoutParams);
            }
            this.f46661p = gVar;
            this.f48756c = gVar;
        }
        return this;
    }

    public d C(float f10) {
        this.f46653h = f10;
        return this;
    }

    @Override // rg.b
    public boolean equals(Object obj) {
        h hVar = this.f46661p;
        return (hVar != null && hVar.equals(obj)) || super.equals(obj);
    }

    public d g() {
        i iVar = this.f46662q;
        if (iVar != null) {
            iVar.e();
        }
        return this;
    }

    @Override // rg.b, sg.f
    public void h(@n0 j jVar, @n0 RefreshState refreshState, @n0 RefreshState refreshState2) {
        h hVar = this.f46661p;
        if (hVar != null) {
            if (refreshState2 == RefreshState.ReleaseToRefresh && !this.f46656k) {
                refreshState2 = RefreshState.PullDownToRefresh;
            }
            hVar.h(jVar, refreshState, refreshState2);
            int i10 = a.f46664a[refreshState2.ordinal()];
            boolean z10 = true;
            if (i10 != 1) {
                if (i10 == 3) {
                    if (hVar.getView() != this) {
                        hVar.getView().animate().alpha(1.0f).setDuration(this.f46658m / 2);
                        return;
                    }
                    return;
                } else {
                    if (i10 == 4 && hVar.getView().getAlpha() == 0.0f && hVar.getView() != this) {
                        hVar.getView().setAlpha(1.0f);
                        return;
                    }
                    return;
                }
            }
            if (hVar.getView() != this) {
                hVar.getView().animate().alpha(0.0f).setDuration(this.f46658m / 2);
            }
            i iVar = this.f46662q;
            if (iVar != null) {
                mg.d dVar = this.f46663r;
                if (dVar != null && !dVar.a(jVar)) {
                    z10 = false;
                }
                iVar.j(z10);
            }
        }
    }

    @Override // rg.b, mg.h
    public void n(@n0 i iVar, int i10, int i11) {
        h hVar = this.f46661p;
        if (hVar == null) {
            return;
        }
        if (((i11 + i10) * 1.0f) / i10 != this.f46651f && this.f46657l == 0) {
            this.f46657l = i10;
            this.f46661p = null;
            iVar.h().y(this.f46651f);
            this.f46661p = hVar;
        }
        if (this.f46662q == null && hVar.getSpinnerStyle() == ng.b.f42143d && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i10;
            hVar.getView().setLayoutParams(marginLayoutParams);
        }
        this.f46657l = i10;
        this.f46662q = iVar;
        iVar.a(this.f46658m, this.f46659n, this.f46660o);
        iVar.l(this, !this.f46655j);
        hVar.n(iVar, i10, i11);
    }

    public void o(int i10) {
        h hVar = this.f46661p;
        if (this.f46649d == i10 || hVar == null) {
            return;
        }
        this.f46649d = i10;
        ng.b spinnerStyle = hVar.getSpinnerStyle();
        if (spinnerStyle == ng.b.f42143d) {
            hVar.getView().setTranslationY(i10);
        } else if (spinnerStyle.f42151c) {
            View view = hVar.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i10));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f48755b = ng.b.f42147h;
        if (this.f46661p == null) {
            A(new b(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f48755b = ng.b.f42145f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof g) {
                this.f46661p = (g) childAt;
                this.f48756c = (h) childAt;
                bringChildToFront(childAt);
                return;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        h hVar = this.f46661p;
        if (hVar == null) {
            super.onMeasure(i10, i11);
        } else {
            if (View.MeasureSpec.getMode(i11) != Integer.MIN_VALUE) {
                super.onMeasure(i10, i11);
                return;
            }
            hVar.getView().measure(i10, i11);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i10), hVar.getView().getMeasuredHeight());
        }
    }

    @Override // rg.b, mg.h
    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        o(i10);
        h hVar = this.f46661p;
        i iVar = this.f46662q;
        if (hVar != null) {
            hVar.r(z10, f10, i10, i11, i12);
        }
        if (z10) {
            float f11 = this.f46650e;
            float f12 = this.f46652g;
            if (f11 < f12 && f10 >= f12 && this.f46654i) {
                iVar.b(RefreshState.ReleaseToTwoLevel);
            } else if (f11 >= f12 && f10 < this.f46653h) {
                iVar.b(RefreshState.PullDownToRefresh);
            } else if (f11 >= f12 && f10 < f12 && this.f46656k) {
                iVar.b(RefreshState.ReleaseToRefresh);
            } else if (!this.f46656k && iVar.h().getState() != RefreshState.ReleaseToTwoLevel) {
                iVar.b(RefreshState.PullDownToRefresh);
            }
            this.f46650e = f10;
        }
    }

    public d t(boolean z10) {
        i iVar = this.f46662q;
        if (iVar != null) {
            mg.d dVar = this.f46663r;
            iVar.j(!z10 || dVar == null || dVar.a(iVar.h()));
        }
        return this;
    }

    public d u(boolean z10) {
        i iVar = this.f46662q;
        this.f46655j = z10;
        if (iVar != null) {
            iVar.l(this, !z10);
        }
        return this;
    }

    public d v(boolean z10) {
        this.f46654i = z10;
        return this;
    }

    public d w(int i10) {
        this.f46658m = i10;
        return this;
    }

    public d x(float f10) {
        this.f46652g = f10;
        return this;
    }

    public d y(float f10) {
        if (this.f46651f != f10) {
            this.f46651f = f10;
            i iVar = this.f46662q;
            if (iVar != null) {
                this.f46657l = 0;
                iVar.h().y(this.f46651f);
            }
        }
        return this;
    }

    public d z(mg.d dVar) {
        this.f46663r = dVar;
        return this;
    }

    public d(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f46650e = 0.0f;
        this.f46651f = 2.5f;
        this.f46652g = 1.9f;
        this.f46653h = 1.0f;
        this.f46654i = true;
        this.f46655j = true;
        this.f46656k = true;
        this.f46658m = 1000;
        this.f46659n = 1.0f;
        this.f46660o = 0.16666667f;
        this.f48755b = ng.b.f42145f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.f46651f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.f46651f);
        this.f46652g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f46652g);
        this.f46653h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.f46653h);
        this.f46651f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRate, this.f46651f);
        this.f46652g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRate, this.f46652g);
        this.f46653h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRate, this.f46653h);
        this.f46658m = typedArrayObtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.f46658m);
        this.f46654i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f46654i);
        this.f46656k = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableFloorRefresh, this.f46656k);
        this.f46659n = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorOpenLayoutRate, this.f46659n);
        this.f46660o = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorBottomDragLayoutRate, this.f46660o);
        this.f46655j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f46655j);
        typedArrayObtainStyledAttributes.recycle();
    }
}
