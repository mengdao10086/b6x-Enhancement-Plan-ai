package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintLayout extends ViewGroup {
    public static final String A = "ConstraintLayout";
    public static final boolean B = true;
    public static final boolean C = false;
    public static final boolean D = false;
    public static final boolean K0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f4040k0 = false;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f4041k1 = 0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static i f4042v1 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f4043z = "ConstraintLayout-2.1.4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray<View> f4044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<androidx.constraintlayout.widget.a> f4045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f4046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f4053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.constraintlayout.widget.b f4054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, Integer> f4056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4058o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4059p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4061r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4062s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SparseArray<ConstraintWidget> f4063t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c0.a f4064u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public s.b f4065v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f4066w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4067x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4068y;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4069a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f4069a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4069a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4069a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4069a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements b.InterfaceC0036b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f4157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4160d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4161e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4162f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4163g;

        public c(ConstraintLayout l10) {
            this.f4157a = l10;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0036b
        public final void a() {
            int childCount = this.f4157a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f4157a.getChildAt(i10);
                if (childAt instanceof g) {
                    ((g) childAt).b(this.f4157a);
                }
            }
            int size = this.f4157a.f4045b.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((androidx.constraintlayout.widget.a) this.f4157a.f4045b.get(i11)).E(this.f4157a);
                }
            }
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0036b
        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget widget, b.a measure) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int i10;
            int measuredHeight;
            int i11;
            if (widget == null) {
                return;
            }
            if (widget.l0() == 8 && !widget.C0()) {
                measure.f3330e = 0;
                measure.f3331f = 0;
                measure.f3332g = 0;
                return;
            }
            if (widget.U() == null) {
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f3326a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.f3327b;
            int i12 = measure.f3328c;
            int i13 = measure.f3329d;
            int i14 = this.f4158b + this.f4159c;
            int i15 = this.f4160d;
            View view = (View) widget.w();
            int[] iArr = a.f4069a;
            int i16 = iArr[dimensionBehaviour.ordinal()];
            if (i16 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (i16 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4162f, i15, -2);
            } else if (i16 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4162f, i15 + widget.I(), -1);
            } else if (i16 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f4162f, i15, -2);
                boolean z10 = widget.f3279w == 1;
                int i17 = measure.f3335j;
                if (i17 == b.a.f3324l || i17 == b.a.f3325m) {
                    if (measure.f3335j == b.a.f3325m || !z10 || (z10 && (view.getMeasuredHeight() == widget.D())) || (view instanceof g) || widget.G0()) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(widget.m0(), 1073741824);
                    }
                }
            }
            int i18 = iArr[dimensionBehaviour2.ordinal()];
            if (i18 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            } else if (i18 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4163g, i14, -2);
            } else if (i18 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4163g, i14 + widget.k0(), -1);
            } else if (i18 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f4163g, i14, -2);
                boolean z11 = widget.f3281x == 1;
                int i19 = measure.f3335j;
                if (i19 == b.a.f3324l || i19 == b.a.f3325m) {
                    if (measure.f3335j == b.a.f3325m || !z11 || (z11 && (view.getMeasuredWidth() == widget.m0())) || (view instanceof g) || widget.H0()) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(widget.D(), 1073741824);
                    }
                }
            }
            androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) widget.U();
            if (dVar != null && androidx.constraintlayout.core.widgets.g.b(ConstraintLayout.this.f4052i, 256) && view.getMeasuredWidth() == widget.m0() && view.getMeasuredWidth() < dVar.m0() && view.getMeasuredHeight() == widget.D() && view.getMeasuredHeight() < dVar.D() && view.getBaseline() == widget.t() && !widget.F0()) {
                if (d(widget.J(), iMakeMeasureSpec, widget.m0()) && d(widget.K(), iMakeMeasureSpec2, widget.D())) {
                    measure.f3330e = widget.m0();
                    measure.f3331f = widget.D();
                    measure.f3332g = widget.t();
                    return;
                }
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z12 = dimensionBehaviour == dimensionBehaviour3;
            boolean z13 = dimensionBehaviour2 == dimensionBehaviour3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            boolean z14 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z15 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z16 = z12 && widget.f3246f0 > 0.0f;
            boolean z17 = z13 && widget.f3246f0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar = (b) view.getLayoutParams();
            int i20 = measure.f3335j;
            if (i20 != b.a.f3324l && i20 != b.a.f3325m && z12 && widget.f3279w == 0 && z13 && widget.f3281x == 0) {
                i11 = -1;
                measuredHeight = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof k) && (widget instanceof androidx.constraintlayout.core.widgets.i)) {
                    ((k) view).J((androidx.constraintlayout.core.widgets.i) widget, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                widget.J1(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i21 = widget.f3285z;
                iMax = i21 > 0 ? Math.max(i21, measuredWidth) : measuredWidth;
                int i22 = widget.A;
                if (i22 > 0) {
                    iMax = Math.min(i22, iMax);
                }
                int i23 = widget.C;
                if (i23 > 0) {
                    measuredHeight = Math.max(i23, measuredHeight2);
                    i10 = iMakeMeasureSpec;
                } else {
                    i10 = iMakeMeasureSpec;
                    measuredHeight = measuredHeight2;
                }
                int i24 = widget.D;
                if (i24 > 0) {
                    measuredHeight = Math.min(i24, measuredHeight);
                }
                if (!androidx.constraintlayout.core.widgets.g.b(ConstraintLayout.this.f4052i, 1)) {
                    if (z16 && z14) {
                        iMax = (int) ((measuredHeight * widget.f3246f0) + 0.5f);
                    } else if (z17 && z15) {
                        measuredHeight = (int) ((iMax / widget.f3246f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight2 != measuredHeight) {
                    int iMakeMeasureSpec3 = measuredWidth != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i10;
                    if (measuredHeight2 != measuredHeight) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    widget.J1(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i11 = -1;
            }
            boolean z18 = baseline != i11;
            measure.f3334i = (iMax == measure.f3328c && measuredHeight == measure.f3329d) ? false : true;
            if (bVar.f4086g0) {
                z18 = true;
            }
            if (z18 && baseline != -1 && widget.t() != baseline) {
                measure.f3334i = true;
            }
            measure.f3330e = iMax;
            measure.f3331f = measuredHeight;
            measure.f3333h = z18;
            measure.f3332g = baseline;
        }

        public void c(int widthSpec, int heightSpec, int top2, int bottom, int width, int height) {
            this.f4158b = top2;
            this.f4159c = bottom;
            this.f4160d = width;
            this.f4161e = height;
            this.f4162f = widthSpec;
            this.f4163g = heightSpec;
        }

        public final boolean d(int lastMeasureSpec, int spec, int widgetSize) {
            if (lastMeasureSpec == spec) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(lastMeasureSpec);
            View.MeasureSpec.getSize(lastMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(spec);
            int size = View.MeasureSpec.getSize(spec);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && widgetSize == size;
            }
            return false;
        }
    }

    public ConstraintLayout(@n0 Context context) {
        super(context);
        this.f4044a = new SparseArray<>();
        this.f4045b = new ArrayList<>(4);
        this.f4046c = new androidx.constraintlayout.core.widgets.d();
        this.f4047d = 0;
        this.f4048e = 0;
        this.f4049f = Integer.MAX_VALUE;
        this.f4050g = Integer.MAX_VALUE;
        this.f4051h = true;
        this.f4052i = 257;
        this.f4053j = null;
        this.f4054k = null;
        this.f4055l = -1;
        this.f4056m = new HashMap<>();
        this.f4057n = -1;
        this.f4058o = -1;
        this.f4059p = -1;
        this.f4060q = -1;
        this.f4061r = 0;
        this.f4062s = 0;
        this.f4063t = new SparseArray<>();
        this.f4066w = new c(this);
        this.f4067x = 0;
        this.f4068y = 0;
        u(null, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static i getSharedValues() {
        if (f4042v1 == null) {
            f4042v1 = new i();
        }
        return f4042v1;
    }

    public void A(androidx.constraintlayout.core.widgets.d layout, int optimizationLevel, int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i10 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f4066w.c(widthMeasureSpec, heightMeasureSpec, iMax, iMax2, paddingWidth, i10);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        int iMax5 = (iMax3 > 0 || iMax4 > 0) ? v() ? iMax4 : iMax3 : Math.max(0, getPaddingLeft());
        int i11 = size - paddingWidth;
        int i12 = size2 - i10;
        F(layout, mode, i11, mode2, i12);
        layout.Q2(optimizationLevel, mode, i11, mode2, i12, this.f4057n, this.f4058o, iMax5, iMax);
    }

    public final void C() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ConstraintWidget constraintWidgetT = t(getChildAt(i10));
            if (constraintWidgetT != null) {
                constraintWidgetT.R0();
            }
        }
        if (zIsInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    E(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    r(childAt.getId()).j1(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f4055l != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.f4055l && (childAt2 instanceof e)) {
                    this.f4053j = ((e) childAt2).getConstraintSet();
                }
            }
        }
        d dVar = this.f4053j;
        if (dVar != null) {
            dVar.t(this, true);
        }
        this.f4046c.p2();
        int size = this.f4045b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.f4045b.get(i13).H(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof g) {
                ((g) childAt3).c(this);
            }
        }
        this.f4063t.clear();
        this.f4063t.put(0, this.f4046c);
        this.f4063t.put(getId(), this.f4046c);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.f4063t.put(childAt4.getId(), t(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            ConstraintWidget constraintWidgetT2 = t(childAt5);
            if (constraintWidgetT2 != null) {
                b bVar = (b) childAt5.getLayoutParams();
                this.f4046c.b(constraintWidgetT2);
                m(zIsInEditMode, childAt5, constraintWidgetT2, bVar, this.f4063t);
            }
        }
    }

    public void E(int type, Object value1, Object value2) {
        if (type == 0 && (value1 instanceof String) && (value2 instanceof Integer)) {
            if (this.f4056m == null) {
                this.f4056m = new HashMap<>();
            }
            String strSubstring = (String) value1;
            int iIndexOf = strSubstring.indexOf(fh.a.f28350w);
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f4056m.put(strSubstring, Integer.valueOf(((Integer) value2).intValue()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
  0x003e: PHI (r2v4 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour) = 
  (r2v3 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
  (r2v0 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
 binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(androidx.constraintlayout.core.widgets.d r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f4066w
            int r1 = r0.f4161e
            int r0 = r0.f4160d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = 0
            goto L38
        L1a:
            int r9 = r7.f4049f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.f4047d
            int r10 = java.lang.Math.max(r6, r10)
            goto L38
        L2e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.f4047d
            int r10 = java.lang.Math.max(r6, r10)
        L38:
            if (r11 == r5) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = 0
            goto L5d
        L40:
            int r11 = r7.f4050g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.f4048e
            int r12 = java.lang.Math.max(r6, r11)
            goto L5d
        L53:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.f4048e
            int r12 = java.lang.Math.max(r6, r11)
        L5d:
            int r11 = r8.m0()
            if (r10 != r11) goto L69
            int r11 = r8.D()
            if (r12 == r11) goto L6c
        L69:
            r8.M2()
        L6c:
            r8.f2(r6)
            r8.g2(r6)
            int r11 = r7.f4049f
            int r11 = r11 - r0
            r8.M1(r11)
            int r11 = r7.f4050g
            int r11 = r11 - r1
            r8.L1(r11)
            r8.P1(r6)
            r8.O1(r6)
            r8.D1(r9)
            r8.c2(r10)
            r8.Y1(r2)
            r8.y1(r12)
            int r9 = r7.f4047d
            int r9 = r9 - r0
            r8.P1(r9)
            int r9 = r7.f4048e
            int r9 = r9 - r1
            r8.O1(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.F(androidx.constraintlayout.core.widgets.d, int, int, int, int):void");
    }

    public void I(int id2, int screenWidth, int screenHeight) {
        androidx.constraintlayout.widget.b bVar = this.f4054k;
        if (bVar != null) {
            bVar.e(id2, screenWidth, screenHeight);
        }
    }

    public final void L(ConstraintWidget widget, b layoutParams, SparseArray<ConstraintWidget> idToWidget, int baselineTarget, ConstraintAnchor.Type type) {
        View view = this.f4044a.get(baselineTarget);
        ConstraintWidget constraintWidget = idToWidget.get(baselineTarget);
        if (constraintWidget == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        layoutParams.f4086g0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
        if (type == type2) {
            b bVar = (b) view.getLayoutParams();
            bVar.f4086g0 = true;
            bVar.f4116v0.x1(true);
        }
        widget.r(type2).b(constraintWidget.r(type), layoutParams.D, layoutParams.C, true);
        widget.x1(true);
        widget.r(ConstraintAnchor.Type.TOP).x();
        widget.r(ConstraintAnchor.Type.BOTTOM).x();
    }

    public final boolean M() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            C();
        }
        return z10;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p10) {
        return p10 instanceof b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<androidx.constraintlayout.widget.a> arrayList = this.f4045b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.f4045b.get(i10).F(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(ag.c.f654g);
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i15;
                        float f11 = i16;
                        float f12 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float f13 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, f13, paint);
                        canvas.drawLine(f12, f13, f10, f13, paint);
                        canvas.drawLine(f10, f13, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, f13, paint);
                        canvas.drawLine(f10, f13, f12, f11, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        x();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f4050g;
    }

    public int getMaxWidth() {
        return this.f4049f;
    }

    public int getMinHeight() {
        return this.f4048e;
    }

    public int getMinWidth() {
        return this.f4047d;
    }

    public int getOptimizationLevel() {
        return this.f4046c.H2();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.f4046c.f3263o == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.f4046c.f3263o = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.f4046c.f3263o = d.V1;
            }
        }
        if (this.f4046c.y() == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f4046c;
            dVar.j1(dVar.f3263o);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" setDebugName ");
            sb3.append(this.f4046c.y());
        }
        for (ConstraintWidget constraintWidget : this.f4046c.l2()) {
            View view = (View) constraintWidget.w();
            if (view != null) {
                if (constraintWidget.f3263o == null && (id2 = view.getId()) != -1) {
                    constraintWidget.f3263o = getContext().getResources().getResourceEntryName(id2);
                }
                if (constraintWidget.y() == null) {
                    constraintWidget.j1(constraintWidget.f3263o);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" setDebugName ");
                    sb4.append(constraintWidget.y());
                }
            }
        }
        this.f4046c.b0(sb2);
        return sb2.toString();
    }

    public void m(boolean isInEditMode, View child, ConstraintWidget widget, b layoutParams, SparseArray<ConstraintWidget> idToWidget) {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        int i10;
        layoutParams.e();
        layoutParams.f4118w0 = false;
        widget.b2(child.getVisibility());
        if (layoutParams.f4092j0) {
            widget.H1(true);
            widget.b2(8);
        }
        widget.h1(child);
        if (child instanceof androidx.constraintlayout.widget.a) {
            ((androidx.constraintlayout.widget.a) child).B(widget, this.f4046c.O2());
        }
        if (layoutParams.f4088h0) {
            androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) widget;
            int i11 = layoutParams.f4110s0;
            int i12 = layoutParams.f4112t0;
            float f10 = layoutParams.f4114u0;
            if (f10 != -1.0f) {
                fVar.y2(f10);
                return;
            } else if (i11 != -1) {
                fVar.w2(i11);
                return;
            } else {
                if (i12 != -1) {
                    fVar.x2(i12);
                    return;
                }
                return;
            }
        }
        int i13 = layoutParams.f4096l0;
        int i14 = layoutParams.f4098m0;
        int i15 = layoutParams.f4100n0;
        int i16 = layoutParams.f4102o0;
        int i17 = layoutParams.f4104p0;
        int i18 = layoutParams.f4106q0;
        float f11 = layoutParams.f4108r0;
        int i19 = layoutParams.f4103p;
        if (i19 != -1) {
            ConstraintWidget constraintWidget5 = idToWidget.get(i19);
            if (constraintWidget5 != null) {
                widget.m(constraintWidget5, layoutParams.f4107r, layoutParams.f4105q);
            }
        } else {
            if (i13 != -1) {
                ConstraintWidget constraintWidget6 = idToWidget.get(i13);
                if (constraintWidget6 != null) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    widget.v0(type, constraintWidget6, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i17);
                }
            } else if (i14 != -1 && (constraintWidget = idToWidget.get(i14)) != null) {
                widget.v0(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i17);
            }
            if (i15 != -1) {
                ConstraintWidget constraintWidget7 = idToWidget.get(i15);
                if (constraintWidget7 != null) {
                    widget.v0(ConstraintAnchor.Type.RIGHT, constraintWidget7, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18);
                }
            } else if (i16 != -1 && (constraintWidget2 = idToWidget.get(i16)) != null) {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                widget.v0(type2, constraintWidget2, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18);
            }
            int i20 = layoutParams.f4089i;
            if (i20 != -1) {
                ConstraintWidget constraintWidget8 = idToWidget.get(i20);
                if (constraintWidget8 != null) {
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                    widget.v0(type3, constraintWidget8, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f4119x);
                }
            } else {
                int i21 = layoutParams.f4091j;
                if (i21 != -1 && (constraintWidget3 = idToWidget.get(i21)) != null) {
                    widget.v0(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f4119x);
                }
            }
            int i22 = layoutParams.f4093k;
            if (i22 != -1) {
                ConstraintWidget constraintWidget9 = idToWidget.get(i22);
                if (constraintWidget9 != null) {
                    widget.v0(ConstraintAnchor.Type.BOTTOM, constraintWidget9, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f4121z);
                }
            } else {
                int i23 = layoutParams.f4095l;
                if (i23 != -1 && (constraintWidget4 = idToWidget.get(i23)) != null) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                    widget.v0(type4, constraintWidget4, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f4121z);
                }
            }
            int i24 = layoutParams.f4097m;
            if (i24 != -1) {
                L(widget, layoutParams, idToWidget, i24, ConstraintAnchor.Type.BASELINE);
            } else {
                int i25 = layoutParams.f4099n;
                if (i25 != -1) {
                    L(widget, layoutParams, idToWidget, i25, ConstraintAnchor.Type.TOP);
                } else {
                    int i26 = layoutParams.f4101o;
                    if (i26 != -1) {
                        L(widget, layoutParams, idToWidget, i26, ConstraintAnchor.Type.BOTTOM);
                    }
                }
            }
            if (f11 >= 0.0f) {
                widget.A1(f11);
            }
            float f12 = layoutParams.H;
            if (f12 >= 0.0f) {
                widget.V1(f12);
            }
        }
        if (isInEditMode && ((i10 = layoutParams.X) != -1 || layoutParams.Y != -1)) {
            widget.R1(i10, layoutParams.Y);
        }
        if (layoutParams.f4082e0) {
            widget.D1(ConstraintWidget.DimensionBehaviour.FIXED);
            widget.c2(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                widget.D1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.f4074a0) {
                widget.D1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                widget.D1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            }
            widget.r(ConstraintAnchor.Type.LEFT).f3205g = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            widget.r(ConstraintAnchor.Type.RIGHT).f3205g = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            widget.D1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            widget.c2(0);
        }
        if (layoutParams.f4084f0) {
            widget.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
            widget.y1(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                widget.Y1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.f4076b0) {
                widget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                widget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            }
            widget.r(ConstraintAnchor.Type.TOP).f3205g = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            widget.r(ConstraintAnchor.Type.BOTTOM).f3205g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            widget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            widget.y1(0);
        }
        widget.n1(layoutParams.I);
        widget.F1(layoutParams.L);
        widget.a2(layoutParams.M);
        widget.B1(layoutParams.N);
        widget.W1(layoutParams.O);
        widget.e2(layoutParams.f4080d0);
        widget.E1(layoutParams.P, layoutParams.R, layoutParams.T, layoutParams.V);
        widget.Z1(layoutParams.Q, layoutParams.S, layoutParams.U, layoutParams.W);
    }

    public void n(s.b metrics) {
        this.f4065v = metrics;
        this.f4046c.E2(metrics);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            b bVar = (b) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = bVar.f4116v0;
            if ((childAt.getVisibility() != 8 || bVar.f4088h0 || bVar.f4090i0 || bVar.f4094k0 || zIsInEditMode) && !bVar.f4092j0) {
                int iO0 = constraintWidget.o0();
                int iP0 = constraintWidget.p0();
                int iM0 = constraintWidget.m0() + iO0;
                int iD = constraintWidget.D() + iP0;
                childAt.layout(iO0, iP0, iM0, iD);
                if ((childAt instanceof g) && (content = ((g) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iO0, iP0, iM0, iD);
                }
            }
        }
        int size = this.f4045b.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.f4045b.get(i11).D(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f4067x == widthMeasureSpec) {
            int i10 = this.f4068y;
        }
        if (!this.f4051h) {
            int childCount = getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                if (getChildAt(i11).isLayoutRequested()) {
                    this.f4051h = true;
                    break;
                }
                i11++;
            }
        }
        boolean z10 = this.f4051h;
        this.f4067x = widthMeasureSpec;
        this.f4068y = heightMeasureSpec;
        this.f4046c.Y2(v());
        if (this.f4051h) {
            this.f4051h = false;
            if (M()) {
                this.f4046c.a3();
            }
        }
        A(this.f4046c, this.f4052i, widthMeasureSpec, heightMeasureSpec);
        z(widthMeasureSpec, heightMeasureSpec, this.f4046c.m0(), this.f4046c.D(), this.f4046c.P2(), this.f4046c.N2());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget constraintWidgetT = t(view);
        if ((view instanceof Guideline) && !(constraintWidgetT instanceof androidx.constraintlayout.core.widgets.f)) {
            b bVar = (b) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.f fVar = new androidx.constraintlayout.core.widgets.f();
            bVar.f4116v0 = fVar;
            bVar.f4088h0 = true;
            fVar.B2(bVar.Z);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar = (androidx.constraintlayout.widget.a) view;
            aVar.I();
            ((b) view.getLayoutParams()).f4090i0 = true;
            if (!this.f4045b.contains(aVar)) {
                this.f4045b.add(aVar);
            }
        }
        this.f4044a.put(view.getId(), view);
        this.f4051h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f4044a.remove(view.getId());
        this.f4046c.o2(t(view));
        this.f4045b.remove(view);
        this.f4051h = true;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attrs) {
        return new b(getContext(), attrs);
    }

    public Object q(int type, Object value) {
        if (type != 0 || !(value instanceof String)) {
            return null;
        }
        String str = (String) value;
        HashMap<String, Integer> map = this.f4056m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f4056m.get(str);
    }

    public final ConstraintWidget r(int id2) {
        if (id2 == 0) {
            return this.f4046c;
        }
        View viewFindViewById = this.f4044a.get(id2);
        if (viewFindViewById == null && (viewFindViewById = findViewById(id2)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f4046c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f4116v0;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        x();
        super.requestLayout();
    }

    public View s(int id2) {
        return this.f4044a.get(id2);
    }

    public void setConstraintSet(d set) {
        this.f4053j = set;
    }

    @Override // android.view.View
    public void setId(int id2) {
        this.f4044a.remove(getId());
        super.setId(id2);
        this.f4044a.put(getId(), this);
    }

    public void setMaxHeight(int value) {
        if (value == this.f4050g) {
            return;
        }
        this.f4050g = value;
        requestLayout();
    }

    public void setMaxWidth(int value) {
        if (value == this.f4049f) {
            return;
        }
        this.f4049f = value;
        requestLayout();
    }

    public void setMinHeight(int value) {
        if (value == this.f4048e) {
            return;
        }
        this.f4048e = value;
        requestLayout();
    }

    public void setMinWidth(int value) {
        if (value == this.f4047d) {
            return;
        }
        this.f4047d = value;
        requestLayout();
    }

    public void setOnConstraintsChanged(c0.a constraintsChangedListener) {
        this.f4064u = constraintsChangedListener;
        androidx.constraintlayout.widget.b bVar = this.f4054k;
        if (bVar != null) {
            bVar.d(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int level) {
        this.f4052i = level;
        this.f4046c.V2(level);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final ConstraintWidget t(View view) {
        if (view == this) {
            return this.f4046c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f4116v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f4116v0;
        }
        return null;
    }

    public final void u(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f4046c.h1(this);
        this.f4046c.U2(this.f4066w);
        this.f4044a.put(getId(), this);
        this.f4053j = null;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout, defStyleAttr, defStyleRes);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f4047d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4047d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f4048e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4048e);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f4049f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4049f);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f4050g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4050g);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f4052i = typedArrayObtainStyledAttributes.getInt(index, this.f4052i);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            y(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f4054k = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f4053j = dVar;
                        dVar.w0(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f4053j = null;
                    }
                    this.f4055l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f4046c.V2(this.f4052i);
    }

    public boolean v() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void w(int layoutDescription) {
        if (layoutDescription == 0) {
            this.f4054k = null;
            return;
        }
        try {
            this.f4054k = new androidx.constraintlayout.widget.b(getContext(), this, layoutDescription);
        } catch (Resources.NotFoundException unused) {
            this.f4054k = null;
        }
    }

    public final void x() {
        this.f4051h = true;
        this.f4057n = -1;
        this.f4058o = -1;
        this.f4059p = -1;
        this.f4060q = -1;
        this.f4061r = 0;
        this.f4062s = 0;
    }

    public void y(int id2) {
        this.f4054k = new androidx.constraintlayout.widget.b(getContext(), this, id2);
    }

    public void z(int widthMeasureSpec, int heightMeasureSpec, int measuredWidth, int measuredHeight, boolean isWidthMeasuredTooSmall, boolean isHeightMeasuredTooSmall) {
        c cVar = this.f4066w;
        int i10 = cVar.f4161e;
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(measuredWidth + cVar.f4160d, widthMeasureSpec, 0);
        int iResolveSizeAndState2 = ViewGroup.resolveSizeAndState(measuredHeight + i10, heightMeasureSpec, 0) & 16777215;
        int iMin = Math.min(this.f4049f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f4050g, iResolveSizeAndState2);
        if (isWidthMeasuredTooSmall) {
            iMin |= 16777216;
        }
        if (isHeightMeasuredTooSmall) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f4057n = iMin;
        this.f4058o = iMin2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p10) {
        return new b(p10);
    }

    public ConstraintLayout(@n0 Context context, @p0 AttributeSet attrs) {
        super(context, attrs);
        this.f4044a = new SparseArray<>();
        this.f4045b = new ArrayList<>(4);
        this.f4046c = new androidx.constraintlayout.core.widgets.d();
        this.f4047d = 0;
        this.f4048e = 0;
        this.f4049f = Integer.MAX_VALUE;
        this.f4050g = Integer.MAX_VALUE;
        this.f4051h = true;
        this.f4052i = 257;
        this.f4053j = null;
        this.f4054k = null;
        this.f4055l = -1;
        this.f4056m = new HashMap<>();
        this.f4057n = -1;
        this.f4058o = -1;
        this.f4059p = -1;
        this.f4060q = -1;
        this.f4061r = 0;
        this.f4062s = 0;
        this.f4063t = new SparseArray<>();
        this.f4066w = new c(this);
        this.f4067x = 0;
        this.f4068y = 0;
        u(attrs, 0, 0);
    }

    public ConstraintLayout(@n0 Context context, @p0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4044a = new SparseArray<>();
        this.f4045b = new ArrayList<>(4);
        this.f4046c = new androidx.constraintlayout.core.widgets.d();
        this.f4047d = 0;
        this.f4048e = 0;
        this.f4049f = Integer.MAX_VALUE;
        this.f4050g = Integer.MAX_VALUE;
        this.f4051h = true;
        this.f4052i = 257;
        this.f4053j = null;
        this.f4054k = null;
        this.f4055l = -1;
        this.f4056m = new HashMap<>();
        this.f4057n = -1;
        this.f4058o = -1;
        this.f4059p = -1;
        this.f4060q = -1;
        this.f4061r = 0;
        this.f4062s = 0;
        this.f4063t = new SparseArray<>();
        this.f4066w = new c(this);
        this.f4067x = 0;
        this.f4068y = 0;
        u(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@n0 Context context, @p0 AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.f4044a = new SparseArray<>();
        this.f4045b = new ArrayList<>(4);
        this.f4046c = new androidx.constraintlayout.core.widgets.d();
        this.f4047d = 0;
        this.f4048e = 0;
        this.f4049f = Integer.MAX_VALUE;
        this.f4050g = Integer.MAX_VALUE;
        this.f4051h = true;
        this.f4052i = 257;
        this.f4053j = null;
        this.f4054k = null;
        this.f4055l = -1;
        this.f4056m = new HashMap<>();
        this.f4057n = -1;
        this.f4058o = -1;
        this.f4059p = -1;
        this.f4060q = -1;
        this.f4061r = 0;
        this.f4062s = 0;
        this.f4063t = new SparseArray<>();
        this.f4066w = new c(this);
        this.f4067x = 0;
        this.f4068y = 0;
        u(attrs, defStyleAttr, defStyleRes);
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public static final int A0 = Integer.MIN_VALUE;
        public static final int B0 = 0;
        public static final int C0 = 1;
        public static final int D0 = 1;
        public static final int E0 = 2;
        public static final int F0 = 3;
        public static final int G0 = 4;
        public static final int H0 = 5;
        public static final int I0 = 6;
        public static final int J0 = 7;
        public static final int K0 = 8;
        public static final int L0 = 1;
        public static final int M0 = 0;
        public static final int N0 = 2;
        public static final int O0 = 0;
        public static final int P0 = 1;
        public static final int Q0 = 2;
        public static final int R0 = 0;
        public static final int S0 = 1;
        public static final int T0 = 2;
        public static final int U0 = 3;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public static final int f4070x0 = 0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public static final int f4071y0 = 0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public static final int f4072z0 = -1;
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E;
        public boolean F;
        public float G;
        public float H;
        public String I;
        public float J;
        public int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4073a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f4074a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4075b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f4076b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4077c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f4078c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4079d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f4080d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4081e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f4082e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4083f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f4084f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4085g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f4086g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4087h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f4088h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4089i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f4090i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4091j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f4092j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4093k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public boolean f4094k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f4095l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f4096l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4097m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f4098m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4099n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f4100n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f4101o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f4102o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f4103p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f4104p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f4105q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f4106q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f4107r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f4108r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f4109s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f4110s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f4111t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f4112t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f4113u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f4114u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f4115v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public ConstraintWidget f4116v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f4117w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f4118w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f4119x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f4120y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f4121z;

        public static class a {
            public static final int A = 26;
            public static final int B = 27;
            public static final int C = 28;
            public static final int D = 29;
            public static final int E = 30;
            public static final int F = 31;
            public static final int G = 32;
            public static final int H = 33;
            public static final int I = 34;
            public static final int J = 35;
            public static final int K = 36;
            public static final int L = 37;
            public static final int M = 38;
            public static final int N = 39;
            public static final int O = 40;
            public static final int P = 41;
            public static final int Q = 42;
            public static final int R = 43;
            public static final int S = 44;
            public static final int T = 45;
            public static final int U = 46;
            public static final int V = 47;
            public static final int W = 48;
            public static final int X = 49;
            public static final int Y = 50;
            public static final int Z = 51;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f4122a = 0;

            /* JADX INFO: renamed from: a0, reason: collision with root package name */
            public static final int f4123a0 = 52;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f4124b = 1;

            /* JADX INFO: renamed from: b0, reason: collision with root package name */
            public static final int f4125b0 = 53;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f4126c = 2;

            /* JADX INFO: renamed from: c0, reason: collision with root package name */
            public static final int f4127c0 = 54;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f4128d = 3;

            /* JADX INFO: renamed from: d0, reason: collision with root package name */
            public static final int f4129d0 = 55;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f4130e = 4;

            /* JADX INFO: renamed from: e0, reason: collision with root package name */
            public static final int f4131e0 = 64;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f4132f = 5;

            /* JADX INFO: renamed from: f0, reason: collision with root package name */
            public static final int f4133f0 = 65;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f4134g = 6;

            /* JADX INFO: renamed from: g0, reason: collision with root package name */
            public static final int f4135g0 = 66;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f4136h = 7;

            /* JADX INFO: renamed from: h0, reason: collision with root package name */
            public static final int f4137h0 = 67;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f4138i = 8;

            /* JADX INFO: renamed from: i0, reason: collision with root package name */
            public static final SparseIntArray f4139i0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f4140j = 9;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f4141k = 10;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final int f4142l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f4143m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final int f4144n = 13;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final int f4145o = 14;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final int f4146p = 15;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final int f4147q = 16;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static final int f4148r = 17;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public static final int f4149s = 18;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public static final int f4150t = 19;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public static final int f4151u = 20;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public static final int f4152v = 21;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public static final int f4153w = 22;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public static final int f4154x = 23;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public static final int f4155y = 24;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public static final int f4156z = 25;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f4139i0 = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public b(b source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.f4073a = -1;
            this.f4075b = -1;
            this.f4077c = -1.0f;
            this.f4079d = true;
            this.f4081e = -1;
            this.f4083f = -1;
            this.f4085g = -1;
            this.f4087h = -1;
            this.f4089i = -1;
            this.f4091j = -1;
            this.f4093k = -1;
            this.f4095l = -1;
            this.f4097m = -1;
            this.f4099n = -1;
            this.f4101o = -1;
            this.f4103p = -1;
            this.f4105q = 0;
            this.f4107r = 0.0f;
            this.f4109s = -1;
            this.f4111t = -1;
            this.f4113u = -1;
            this.f4115v = -1;
            this.f4117w = Integer.MIN_VALUE;
            this.f4119x = Integer.MIN_VALUE;
            this.f4120y = Integer.MIN_VALUE;
            this.f4121z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4074a0 = false;
            this.f4076b0 = false;
            this.f4078c0 = null;
            this.f4080d0 = 0;
            this.f4082e0 = true;
            this.f4084f0 = true;
            this.f4086g0 = false;
            this.f4088h0 = false;
            this.f4090i0 = false;
            this.f4092j0 = false;
            this.f4094k0 = false;
            this.f4096l0 = -1;
            this.f4098m0 = -1;
            this.f4100n0 = -1;
            this.f4102o0 = -1;
            this.f4104p0 = Integer.MIN_VALUE;
            this.f4106q0 = Integer.MIN_VALUE;
            this.f4108r0 = 0.5f;
            this.f4116v0 = new ConstraintWidget();
            this.f4118w0 = false;
            this.f4073a = source.f4073a;
            this.f4075b = source.f4075b;
            this.f4077c = source.f4077c;
            this.f4079d = source.f4079d;
            this.f4081e = source.f4081e;
            this.f4083f = source.f4083f;
            this.f4085g = source.f4085g;
            this.f4087h = source.f4087h;
            this.f4089i = source.f4089i;
            this.f4091j = source.f4091j;
            this.f4093k = source.f4093k;
            this.f4095l = source.f4095l;
            this.f4097m = source.f4097m;
            this.f4099n = source.f4099n;
            this.f4101o = source.f4101o;
            this.f4103p = source.f4103p;
            this.f4105q = source.f4105q;
            this.f4107r = source.f4107r;
            this.f4109s = source.f4109s;
            this.f4111t = source.f4111t;
            this.f4113u = source.f4113u;
            this.f4115v = source.f4115v;
            this.f4117w = source.f4117w;
            this.f4119x = source.f4119x;
            this.f4120y = source.f4120y;
            this.f4121z = source.f4121z;
            this.A = source.A;
            this.B = source.B;
            this.C = source.C;
            this.D = source.D;
            this.G = source.G;
            this.H = source.H;
            this.I = source.I;
            this.J = source.J;
            this.K = source.K;
            this.L = source.L;
            this.M = source.M;
            this.N = source.N;
            this.O = source.O;
            this.f4074a0 = source.f4074a0;
            this.f4076b0 = source.f4076b0;
            this.P = source.P;
            this.Q = source.Q;
            this.R = source.R;
            this.T = source.T;
            this.S = source.S;
            this.U = source.U;
            this.V = source.V;
            this.W = source.W;
            this.X = source.X;
            this.Y = source.Y;
            this.Z = source.Z;
            this.f4082e0 = source.f4082e0;
            this.f4084f0 = source.f4084f0;
            this.f4086g0 = source.f4086g0;
            this.f4088h0 = source.f4088h0;
            this.f4096l0 = source.f4096l0;
            this.f4098m0 = source.f4098m0;
            this.f4100n0 = source.f4100n0;
            this.f4102o0 = source.f4102o0;
            this.f4104p0 = source.f4104p0;
            this.f4106q0 = source.f4106q0;
            this.f4108r0 = source.f4108r0;
            this.f4078c0 = source.f4078c0;
            this.f4080d0 = source.f4080d0;
            this.f4116v0 = source.f4116v0;
            this.E = source.E;
            this.F = source.F;
        }

        public String a() {
            return this.f4078c0;
        }

        public ConstraintWidget b() {
            return this.f4116v0;
        }

        public void c() {
            ConstraintWidget constraintWidget = this.f4116v0;
            if (constraintWidget != null) {
                constraintWidget.R0();
            }
        }

        public void d(String text) {
            this.f4116v0.j1(text);
        }

        public void e() {
            this.f4088h0 = false;
            this.f4082e0 = true;
            this.f4084f0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.f4074a0) {
                this.f4082e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.f4076b0) {
                this.f4084f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f4082e0 = false;
                if (i10 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f4074a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f4084f0 = false;
                if (i11 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f4076b0 = true;
                }
            }
            if (this.f4077c == -1.0f && this.f4073a == -1 && this.f4075b == -1) {
                return;
            }
            this.f4088h0 = true;
            this.f4082e0 = true;
            this.f4084f0 = true;
            if (!(this.f4116v0 instanceof androidx.constraintlayout.core.widgets.f)) {
                this.f4116v0 = new androidx.constraintlayout.core.widgets.f();
            }
            ((androidx.constraintlayout.core.widgets.f) this.f4116v0).B2(this.Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instruction units count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(Context c10, AttributeSet attrs) {
            super(c10, attrs);
            this.f4073a = -1;
            this.f4075b = -1;
            this.f4077c = -1.0f;
            this.f4079d = true;
            this.f4081e = -1;
            this.f4083f = -1;
            this.f4085g = -1;
            this.f4087h = -1;
            this.f4089i = -1;
            this.f4091j = -1;
            this.f4093k = -1;
            this.f4095l = -1;
            this.f4097m = -1;
            this.f4099n = -1;
            this.f4101o = -1;
            this.f4103p = -1;
            this.f4105q = 0;
            this.f4107r = 0.0f;
            this.f4109s = -1;
            this.f4111t = -1;
            this.f4113u = -1;
            this.f4115v = -1;
            this.f4117w = Integer.MIN_VALUE;
            this.f4119x = Integer.MIN_VALUE;
            this.f4120y = Integer.MIN_VALUE;
            this.f4121z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4074a0 = false;
            this.f4076b0 = false;
            this.f4078c0 = null;
            this.f4080d0 = 0;
            this.f4082e0 = true;
            this.f4084f0 = true;
            this.f4086g0 = false;
            this.f4088h0 = false;
            this.f4090i0 = false;
            this.f4092j0 = false;
            this.f4094k0 = false;
            this.f4096l0 = -1;
            this.f4098m0 = -1;
            this.f4100n0 = -1;
            this.f4102o0 = -1;
            this.f4104p0 = Integer.MIN_VALUE;
            this.f4106q0 = Integer.MIN_VALUE;
            this.f4108r0 = 0.5f;
            this.f4116v0 = new ConstraintWidget();
            this.f4118w0 = false;
            TypedArray typedArrayObtainStyledAttributes = c10.obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = a.f4139i0.get(index);
                switch (i11) {
                    case 1:
                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f4103p);
                        this.f4103p = resourceId;
                        if (resourceId == -1) {
                            this.f4103p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f4105q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4105q);
                        break;
                    case 4:
                        float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f4107r) % 360.0f;
                        this.f4107r = f10;
                        if (f10 < 0.0f) {
                            this.f4107r = (360.0f - f10) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f4073a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4073a);
                        break;
                    case 6:
                        this.f4075b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4075b);
                        break;
                    case 7:
                        this.f4077c = typedArrayObtainStyledAttributes.getFloat(index, this.f4077c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4081e);
                        this.f4081e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f4081e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4083f);
                        this.f4083f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f4083f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4085g);
                        this.f4085g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f4085g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4087h);
                        this.f4087h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f4087h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4089i);
                        this.f4089i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f4089i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4091j);
                        this.f4091j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f4091j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4093k);
                        this.f4093k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f4093k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4095l);
                        this.f4095l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f4095l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4097m);
                        this.f4097m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f4097m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4109s);
                        this.f4109s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f4109s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4111t);
                        this.f4111t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f4111t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4113u);
                        this.f4113u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f4113u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4115v);
                        this.f4115v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f4115v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f4117w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4117w);
                        break;
                    case 22:
                        this.f4119x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4119x);
                        break;
                    case 23:
                        this.f4120y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4120y);
                        break;
                    case 24:
                        this.f4121z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4121z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f4074a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4074a0);
                        break;
                    case 28:
                        this.f4076b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4076b0);
                        break;
                    case 29:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        this.P = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.Q = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                            }
                        }
                        break;
                    case 35:
                        this.V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                d.C0(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case 51:
                                this.f4078c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4099n);
                                this.f4099n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f4099n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f4101o);
                                this.f4101o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f4101o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        d.A0(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        d.A0(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f4080d0 = typedArrayObtainStyledAttributes.getInt(index, this.f4080d0);
                                        break;
                                    case 67:
                                        this.f4079d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4079d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            e();
        }

        public b(int width, int height) {
            super(width, height);
            this.f4073a = -1;
            this.f4075b = -1;
            this.f4077c = -1.0f;
            this.f4079d = true;
            this.f4081e = -1;
            this.f4083f = -1;
            this.f4085g = -1;
            this.f4087h = -1;
            this.f4089i = -1;
            this.f4091j = -1;
            this.f4093k = -1;
            this.f4095l = -1;
            this.f4097m = -1;
            this.f4099n = -1;
            this.f4101o = -1;
            this.f4103p = -1;
            this.f4105q = 0;
            this.f4107r = 0.0f;
            this.f4109s = -1;
            this.f4111t = -1;
            this.f4113u = -1;
            this.f4115v = -1;
            this.f4117w = Integer.MIN_VALUE;
            this.f4119x = Integer.MIN_VALUE;
            this.f4120y = Integer.MIN_VALUE;
            this.f4121z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4074a0 = false;
            this.f4076b0 = false;
            this.f4078c0 = null;
            this.f4080d0 = 0;
            this.f4082e0 = true;
            this.f4084f0 = true;
            this.f4086g0 = false;
            this.f4088h0 = false;
            this.f4090i0 = false;
            this.f4092j0 = false;
            this.f4094k0 = false;
            this.f4096l0 = -1;
            this.f4098m0 = -1;
            this.f4100n0 = -1;
            this.f4102o0 = -1;
            this.f4104p0 = Integer.MIN_VALUE;
            this.f4106q0 = Integer.MIN_VALUE;
            this.f4108r0 = 0.5f;
            this.f4116v0 = new ConstraintWidget();
            this.f4118w0 = false;
        }

        public b(ViewGroup.LayoutParams source) {
            super(source);
            this.f4073a = -1;
            this.f4075b = -1;
            this.f4077c = -1.0f;
            this.f4079d = true;
            this.f4081e = -1;
            this.f4083f = -1;
            this.f4085g = -1;
            this.f4087h = -1;
            this.f4089i = -1;
            this.f4091j = -1;
            this.f4093k = -1;
            this.f4095l = -1;
            this.f4097m = -1;
            this.f4099n = -1;
            this.f4101o = -1;
            this.f4103p = -1;
            this.f4105q = 0;
            this.f4107r = 0.0f;
            this.f4109s = -1;
            this.f4111t = -1;
            this.f4113u = -1;
            this.f4115v = -1;
            this.f4117w = Integer.MIN_VALUE;
            this.f4119x = Integer.MIN_VALUE;
            this.f4120y = Integer.MIN_VALUE;
            this.f4121z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f4074a0 = false;
            this.f4076b0 = false;
            this.f4078c0 = null;
            this.f4080d0 = 0;
            this.f4082e0 = true;
            this.f4084f0 = true;
            this.f4086g0 = false;
            this.f4088h0 = false;
            this.f4090i0 = false;
            this.f4092j0 = false;
            this.f4094k0 = false;
            this.f4096l0 = -1;
            this.f4098m0 = -1;
            this.f4100n0 = -1;
            this.f4102o0 = -1;
            this.f4104p0 = Integer.MIN_VALUE;
            this.f4106q0 = Integer.MIN_VALUE;
            this.f4108r0 = 0.5f;
            this.f4116v0 = new ConstraintWidget();
            this.f4118w0 = false;
        }
    }
}
