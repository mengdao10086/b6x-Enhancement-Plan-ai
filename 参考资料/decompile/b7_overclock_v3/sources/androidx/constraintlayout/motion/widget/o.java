package androidx.constraintlayout.motion.widget;

import a0.c;
import a0.d;
import a0.f;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import w.f0;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 6;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f3829a0 = 1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f3830b0 = 2;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f3831c0 = "MotionController";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final boolean f3832d0 = false;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final boolean f3833e0 = false;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f3834f0 = 0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f3835g0 = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f3836h0 = 2;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f3837i0 = 3;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f3838j0 = 4;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f3839k0 = 5;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f3840l0 = -1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f3841m0 = -2;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f3842n0 = -3;
    public HashMap<String, a0.f> B;
    public HashMap<String, a0.d> C;
    public HashMap<String, a0.c> D;
    public m[] E;
    public int F;
    public int G;
    public View H;
    public int I;
    public float J;
    public Interpolator K;
    public boolean L;
    public String[] M;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3845c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3847e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w.b[] f3853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w.b f3854l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f3860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f3861s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double[] f3862t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String[] f3863u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f3864v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f3843a = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3846d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3848f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f3849g = new s();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f3850h = new s();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n f3851i = new n();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f3852j = new n();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3855m = Float.NaN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3856n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3857o = 1.0f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3865w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float[] f3866x = new float[4];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<s> f3867y = new ArrayList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f3868z = new float[1];
    public ArrayList<f> A = new ArrayList<>();

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w.d f3869a;

        public a(final w.d val$easing) {
            this.f3869a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v10) {
            return (float) this.f3869a.a(v10);
        }
    }

    public o(View view) {
        int i10 = f.f3644f;
        this.F = i10;
        this.G = i10;
        this.H = null;
        this.I = i10;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        Z(view);
    }

    public static Interpolator v(Context context, int type, String interpolatorString, int id2) {
        if (type == -2) {
            return AnimationUtils.loadInterpolator(context, id2);
        }
        if (type == -1) {
            return new a(w.d.c(interpolatorString));
        }
        if (type == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (type == 1) {
            return new AccelerateInterpolator();
        }
        if (type == 2) {
            return new DecelerateInterpolator();
        }
        if (type == 4) {
            return new BounceInterpolator();
        }
        if (type != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    public double[] A(double position) {
        this.f3853k[0].d(position, this.f3861s);
        w.b bVar = this.f3854l;
        if (bVar != null) {
            double[] dArr = this.f3861s;
            if (dArr.length > 0) {
                bVar.d(position, dArr);
            }
        }
        return this.f3861s;
    }

    public k B(int layoutWidth, int layoutHeight, float x10, float y10) {
        RectF rectF = new RectF();
        s sVar = this.f3849g;
        float f10 = sVar.f3886e;
        rectF.left = f10;
        float f11 = sVar.f3887f;
        rectF.top = f11;
        rectF.right = f10 + sVar.f3888g;
        rectF.bottom = f11 + sVar.f3889h;
        RectF rectF2 = new RectF();
        s sVar2 = this.f3850h;
        float f12 = sVar2.f3886e;
        rectF2.left = f12;
        float f13 = sVar2.f3887f;
        rectF2.top = f13;
        rectF2.right = f12 + sVar2.f3888g;
        rectF2.bottom = f13 + sVar2.f3889h;
        for (f fVar : this.A) {
            if (fVar instanceof k) {
                k kVar = (k) fVar;
                if (kVar.r(layoutWidth, layoutHeight, rectF, rectF2, x10, y10)) {
                    return kVar;
                }
            }
        }
        return null;
    }

    public void C(float position, int width, int height, float locationX, float locationY, float[] mAnchorDpDt) {
        float fJ = j(position, this.f3868z);
        HashMap<String, a0.d> map = this.C;
        a0.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, a0.d> map2 = this.C;
        a0.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, a0.d> map3 = this.C;
        a0.d dVar3 = map3 == null ? null : map3.get(f.f3647i);
        HashMap<String, a0.d> map4 = this.C;
        a0.d dVar4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, a0.d> map5 = this.C;
        a0.d dVar5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, a0.c> map6 = this.D;
        a0.c cVar = map6 == null ? null : map6.get("translationX");
        HashMap<String, a0.c> map7 = this.D;
        a0.c cVar2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, a0.c> map8 = this.D;
        a0.c cVar3 = map8 == null ? null : map8.get(f.f3647i);
        HashMap<String, a0.c> map9 = this.D;
        a0.c cVar4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, a0.c> map10 = this.D;
        a0.c cVar5 = map10 != null ? map10.get("scaleY") : null;
        f0 f0Var = new f0();
        f0Var.b();
        f0Var.d(dVar3, fJ);
        f0Var.h(dVar, dVar2, fJ);
        f0Var.f(dVar4, dVar5, fJ);
        f0Var.c(cVar3, fJ);
        f0Var.g(cVar, cVar2, fJ);
        f0Var.e(cVar4, cVar5, fJ);
        w.b bVar = this.f3854l;
        if (bVar != null) {
            double[] dArr = this.f3861s;
            if (dArr.length > 0) {
                double d10 = fJ;
                bVar.d(d10, dArr);
                this.f3854l.g(d10, this.f3862t);
                this.f3849g.v(locationX, locationY, mAnchorDpDt, this.f3860r, this.f3862t, this.f3861s);
            }
            f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
            return;
        }
        int i10 = 0;
        if (this.f3853k == null) {
            s sVar = this.f3850h;
            float f10 = sVar.f3886e;
            s sVar2 = this.f3849g;
            float f11 = f10 - sVar2.f3886e;
            a0.c cVar6 = cVar5;
            float f12 = sVar.f3887f - sVar2.f3887f;
            a0.c cVar7 = cVar4;
            float f13 = (sVar.f3888g - sVar2.f3888g) + f11;
            float f14 = (sVar.f3889h - sVar2.f3889h) + f12;
            mAnchorDpDt[0] = (f11 * (1.0f - locationX)) + (f13 * locationX);
            mAnchorDpDt[1] = (f12 * (1.0f - locationY)) + (f14 * locationY);
            f0Var.b();
            f0Var.d(dVar3, fJ);
            f0Var.h(dVar, dVar2, fJ);
            f0Var.f(dVar4, dVar5, fJ);
            f0Var.c(cVar3, fJ);
            f0Var.g(cVar, cVar2, fJ);
            f0Var.e(cVar7, cVar6, fJ);
            f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
            return;
        }
        double dJ = j(fJ, this.f3868z);
        this.f3853k[0].g(dJ, this.f3862t);
        this.f3853k[0].d(dJ, this.f3861s);
        float f15 = this.f3868z[0];
        while (true) {
            double[] dArr2 = this.f3862t;
            if (i10 >= dArr2.length) {
                this.f3849g.v(locationX, locationY, mAnchorDpDt, this.f3860r, dArr2, this.f3861s);
                f0Var.a(locationX, locationY, width, height, mAnchorDpDt);
                return;
            } else {
                dArr2[i10] = dArr2[i10] * ((double) f15);
                i10++;
            }
        }
    }

    public final float D() {
        char c10;
        float fHypot;
        float[] fArr = new float[2];
        float f10 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        float f11 = 0.0f;
        int i10 = 0;
        while (i10 < 100) {
            float f12 = i10 * f10;
            double dA = f12;
            w.d dVar = this.f3849g.f3882a;
            float f13 = Float.NaN;
            float f14 = 0.0f;
            for (s sVar : this.f3867y) {
                w.d dVar2 = sVar.f3882a;
                if (dVar2 != null) {
                    float f15 = sVar.f3884c;
                    if (f15 < f12) {
                        dVar = dVar2;
                        f14 = f15;
                    } else if (Float.isNaN(f13)) {
                        f13 = sVar.f3884c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f13)) {
                    f13 = 1.0f;
                }
                dA = (((float) dVar.a((f12 - f14) / r17)) * (f13 - f14)) + f14;
            }
            this.f3853k[0].d(dA, this.f3861s);
            float f16 = f11;
            int i11 = i10;
            this.f3849g.j(dA, this.f3860r, this.f3861s, fArr, 0);
            if (i11 > 0) {
                c10 = 0;
                fHypot = (float) (((double) f16) + Math.hypot(d11 - ((double) fArr[1]), d10 - ((double) fArr[0])));
            } else {
                c10 = 0;
                fHypot = f16;
            }
            d10 = fArr[c10];
            i10 = i11 + 1;
            f11 = fHypot;
            d11 = fArr[1];
        }
        return f11;
    }

    public float E() {
        return this.f3849g.f3889h;
    }

    public float F() {
        return this.f3849g.f3888g;
    }

    public float G() {
        return this.f3849g.f3886e;
    }

    public float H() {
        return this.f3849g.f3887f;
    }

    public int I() {
        return this.G;
    }

    public View J() {
        return this.f3844b;
    }

    public final void K(s point) {
        if (Collections.binarySearch(this.f3867y, point) == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" KeyPath position \"");
            sb2.append(point.f3885d);
            sb2.append("\" outside of range");
        }
        this.f3867y.add((-r0) - 1, point);
    }

    public boolean L(View child, float global_position, long time, w.g keyCache) {
        f.d dVar;
        boolean zK;
        char c10;
        double d10;
        float fJ = j(global_position, null);
        int i10 = this.I;
        if (i10 != f.f3644f) {
            float f10 = 1.0f / i10;
            float fFloor = ((float) Math.floor(fJ / f10)) * f10;
            float f11 = (fJ % f10) / f10;
            if (!Float.isNaN(this.J)) {
                f11 = (f11 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            fJ = ((interpolator != null ? interpolator.getInterpolation(f11) : ((double) f11) > 0.5d ? 1.0f : 0.0f) * f10) + fFloor;
        }
        float f12 = fJ;
        HashMap<String, a0.d> map = this.C;
        if (map != null) {
            Iterator<a0.d> it2 = map.values().iterator();
            while (it2.hasNext()) {
                it2.next().m(child, f12);
            }
        }
        HashMap<String, a0.f> map2 = this.B;
        if (map2 != null) {
            f.d dVar2 = null;
            boolean zJ = false;
            for (a0.f fVar : map2.values()) {
                if (fVar instanceof f.d) {
                    dVar2 = (f.d) fVar;
                } else {
                    zJ |= fVar.j(child, f12, time, keyCache);
                }
            }
            zK = zJ;
            dVar = dVar2;
        } else {
            dVar = null;
            zK = false;
        }
        w.b[] bVarArr = this.f3853k;
        if (bVarArr != null) {
            double d11 = f12;
            bVarArr[0].d(d11, this.f3861s);
            this.f3853k[0].g(d11, this.f3862t);
            w.b bVar = this.f3854l;
            if (bVar != null) {
                double[] dArr = this.f3861s;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                    this.f3854l.g(d11, this.f3862t);
                }
            }
            if (this.L) {
                d10 = d11;
            } else {
                d10 = d11;
                this.f3849g.w(f12, child, this.f3860r, this.f3861s, this.f3862t, null, this.f3846d);
                this.f3846d = false;
            }
            if (this.G != f.f3644f) {
                if (this.H == null) {
                    this.H = ((View) child.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top2 = (r1.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (child.getRight() - child.getLeft() > 0 && child.getBottom() - child.getTop() > 0) {
                        child.setPivotX(left - child.getLeft());
                        child.setPivotY(top2 - child.getTop());
                    }
                }
            }
            HashMap<String, a0.d> map3 = this.C;
            if (map3 != null) {
                for (a0.d dVar3 : map3.values()) {
                    if (dVar3 instanceof d.C0002d) {
                        double[] dArr2 = this.f3862t;
                        if (dArr2.length > 1) {
                            ((d.C0002d) dVar3).n(child, f12, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.f3862t;
                c10 = 1;
                zK |= dVar.k(child, keyCache, f12, time, dArr3[0], dArr3[1]);
            } else {
                c10 = 1;
            }
            int i11 = 1;
            while (true) {
                w.b[] bVarArr2 = this.f3853k;
                if (i11 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i11].e(d10, this.f3866x);
                a0.a.b(this.f3849g.f3896o.get(this.f3863u[i11 - 1]), child, this.f3866x);
                i11++;
            }
            n nVar = this.f3851i;
            if (nVar.f3804b == 0) {
                if (f12 <= 0.0f) {
                    child.setVisibility(nVar.f3805c);
                } else if (f12 >= 1.0f) {
                    child.setVisibility(this.f3852j.f3805c);
                } else if (this.f3852j.f3805c != nVar.f3805c) {
                    child.setVisibility(0);
                }
            }
            if (this.E != null) {
                int i12 = 0;
                while (true) {
                    m[] mVarArr = this.E;
                    if (i12 >= mVarArr.length) {
                        break;
                    }
                    mVarArr[i12].A(f12, child);
                    i12++;
                }
            }
        } else {
            c10 = 1;
            s sVar = this.f3849g;
            float f13 = sVar.f3886e;
            s sVar2 = this.f3850h;
            float f14 = f13 + ((sVar2.f3886e - f13) * f12);
            float f15 = sVar.f3887f;
            float f16 = f15 + ((sVar2.f3887f - f15) * f12);
            float f17 = sVar.f3888g;
            float f18 = sVar2.f3888g;
            float f19 = sVar.f3889h;
            float f20 = sVar2.f3889h;
            float f21 = f14 + 0.5f;
            int i13 = (int) f21;
            float f22 = f16 + 0.5f;
            int i14 = (int) f22;
            int i15 = (int) (f21 + ((f18 - f17) * f12) + f17);
            int i16 = (int) (f22 + ((f20 - f19) * f12) + f19);
            int i17 = i15 - i13;
            int i18 = i16 - i14;
            if (f18 != f17 || f20 != f19 || this.f3846d) {
                child.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
                this.f3846d = false;
            }
            child.layout(i13, i14, i15, i16);
        }
        HashMap<String, a0.c> map4 = this.D;
        if (map4 != null) {
            for (a0.c cVar : map4.values()) {
                if (cVar instanceof c.d) {
                    double[] dArr4 = this.f3862t;
                    ((c.d) cVar).n(child, f12, dArr4[0], dArr4[c10]);
                } else {
                    cVar.m(child, f12);
                }
            }
        }
        return zK;
    }

    public String M() {
        return this.f3844b.getContext().getResources().getResourceEntryName(this.f3844b.getId());
    }

    public void N(View view, k key, float x10, float y10, String[] attribute, float[] value) {
        RectF rectF = new RectF();
        s sVar = this.f3849g;
        float f10 = sVar.f3886e;
        rectF.left = f10;
        float f11 = sVar.f3887f;
        rectF.top = f11;
        rectF.right = f10 + sVar.f3888g;
        rectF.bottom = f11 + sVar.f3889h;
        RectF rectF2 = new RectF();
        s sVar2 = this.f3850h;
        float f12 = sVar2.f3886e;
        rectF2.left = f12;
        float f13 = sVar2.f3887f;
        rectF2.top = f13;
        rectF2.right = f12 + sVar2.f3888g;
        rectF2.bottom = f13 + sVar2.f3889h;
        key.s(view, rectF, rectF2, x10, y10, attribute, value);
    }

    public final void O(s motionPaths) {
        motionPaths.u((int) this.f3844b.getX(), (int) this.f3844b.getY(), this.f3844b.getWidth(), this.f3844b.getHeight());
    }

    public void P() {
        this.f3846d = true;
    }

    public void Q(Rect rect, Rect out, int rotation, int preHeight, int preWidth) {
        if (rotation == 1) {
            int i10 = rect.left + rect.right;
            out.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            out.top = preWidth - ((i10 + rect.height()) / 2);
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation == 2) {
            int i11 = rect.left + rect.right;
            out.left = preHeight - (((rect.top + rect.bottom) + rect.width()) / 2);
            out.top = (i11 - rect.height()) / 2;
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation == 3) {
            int i12 = rect.left + rect.right;
            out.left = ((rect.height() / 2) + rect.top) - (i12 / 2);
            out.top = preWidth - ((i12 + rect.height()) / 2);
            out.right = out.left + rect.width();
            out.bottom = out.top + rect.height();
            return;
        }
        if (rotation != 4) {
            return;
        }
        int i13 = rect.left + rect.right;
        out.left = preHeight - (((rect.bottom + rect.top) + rect.width()) / 2);
        out.top = (i13 - rect.height()) / 2;
        out.right = out.left + rect.width();
        out.bottom = out.top + rect.height();
    }

    public void R(View v10) {
        s sVar = this.f3849g;
        sVar.f3884c = 0.0f;
        sVar.f3885d = 0.0f;
        this.L = true;
        sVar.u(v10.getX(), v10.getY(), v10.getWidth(), v10.getHeight());
        this.f3850h.u(v10.getX(), v10.getY(), v10.getWidth(), v10.getHeight());
        this.f3851i.q(v10);
        this.f3852j.q(v10);
    }

    public void S(int debugMode) {
        this.f3849g.f3883b = debugMode;
    }

    public void T(Rect cw, androidx.constraintlayout.widget.d constraintSet, int parentWidth, int parentHeight) {
        int i10 = constraintSet.f4287d;
        if (i10 != 0) {
            Q(cw, this.f3843a, i10, parentWidth, parentHeight);
            cw = this.f3843a;
        }
        s sVar = this.f3850h;
        sVar.f3884c = 1.0f;
        sVar.f3885d = 1.0f;
        O(sVar);
        this.f3850h.u(cw.left, cw.top, cw.width(), cw.height());
        this.f3850h.c(constraintSet.q0(this.f3845c));
        this.f3852j.p(cw, constraintSet, i10, this.f3845c);
    }

    public void U(int arc) {
        this.F = arc;
    }

    public void V(View v10) {
        s sVar = this.f3849g;
        sVar.f3884c = 0.0f;
        sVar.f3885d = 0.0f;
        sVar.u(v10.getX(), v10.getY(), v10.getWidth(), v10.getHeight());
        this.f3851i.q(v10);
    }

    public void W(a0.e rect, View v10, int rotation, int preWidth, int preHeight) {
        s sVar = this.f3849g;
        sVar.f3884c = 0.0f;
        sVar.f3885d = 0.0f;
        Rect rect2 = new Rect();
        if (rotation == 1) {
            int i10 = rect.f21b + rect.f23d;
            rect2.left = ((rect.f22c + rect.f24e) - rect.c()) / 2;
            rect2.top = preWidth - ((i10 + rect.b()) / 2);
            rect2.right = rect2.left + rect.c();
            rect2.bottom = rect2.top + rect.b();
        } else if (rotation == 2) {
            int i11 = rect.f21b + rect.f23d;
            rect2.left = preHeight - (((rect.f22c + rect.f24e) + rect.c()) / 2);
            rect2.top = (i11 - rect.b()) / 2;
            rect2.right = rect2.left + rect.c();
            rect2.bottom = rect2.top + rect.b();
        }
        this.f3849g.u(rect2.left, rect2.top, rect2.width(), rect2.height());
        this.f3851i.o(rect2, v10, rotation, rect.f20a);
    }

    public void X(Rect cw, androidx.constraintlayout.widget.d constraintSet, int parentWidth, int parentHeight) {
        int i10 = constraintSet.f4287d;
        if (i10 != 0) {
            Q(cw, this.f3843a, i10, parentWidth, parentHeight);
        }
        s sVar = this.f3849g;
        sVar.f3884c = 0.0f;
        sVar.f3885d = 0.0f;
        O(sVar);
        this.f3849g.u(cw.left, cw.top, cw.width(), cw.height());
        d.a aVarQ0 = constraintSet.q0(this.f3845c);
        this.f3849g.c(aVarQ0);
        this.f3855m = aVarQ0.f4294d.f4411g;
        this.f3851i.p(cw, constraintSet, i10, this.f3845c);
        this.G = aVarQ0.f4296f.f4444i;
        d.c cVar = aVarQ0.f4294d;
        this.I = cVar.f4415k;
        this.J = cVar.f4414j;
        Context context = this.f3844b.getContext();
        d.c cVar2 = aVarQ0.f4294d;
        this.K = v(context, cVar2.f4417m, cVar2.f4416l, cVar2.f4418n);
    }

    public void Y(int transformPivotTarget) {
        this.G = transformPivotTarget;
        this.H = null;
    }

    public void Z(View view) {
        this.f3844b = view;
        this.f3845c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f3847e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void a(f key) {
        this.A.add(key);
    }

    public void a0(int parentWidth, int parentHeight, float transitionDuration, long currentTime) {
        ArrayList arrayList;
        String[] strArr;
        ConstraintAttribute constraintAttribute;
        a0.f fVarI;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        a0.d dVarL;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i10 = this.F;
        if (i10 != f.f3644f) {
            this.f3849g.f3892k = i10;
        }
        this.f3851i.h(this.f3852j, hashSet2);
        ArrayList<f> arrayList2 = this.A;
        if (arrayList2 != null) {
            arrayList = null;
            for (f fVar : arrayList2) {
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    K(new s(parentWidth, parentHeight, jVar, this.f3849g, this.f3850h));
                    int i11 = jVar.D;
                    if (i11 != f.f3644f) {
                        this.f3848f = i11;
                    }
                } else if (fVar instanceof h) {
                    fVar.d(hashSet3);
                } else if (fVar instanceof l) {
                    fVar.d(hashSet);
                } else if (fVar instanceof m) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((m) fVar);
                } else {
                    fVar.i(map);
                    fVar.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c10 = 0;
        if (arrayList != null) {
            this.E = (m[]) arrayList.toArray(new m[0]);
        }
        char c11 = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(ag.c.f654g)[c11];
                    for (f fVar2 : this.A) {
                        HashMap<String, ConstraintAttribute> map2 = fVar2.f3669e;
                        if (map2 != null && (constraintAttribute3 = map2.get(str2)) != null) {
                            sparseArray.append(fVar2.f3665a, constraintAttribute3);
                        }
                    }
                    dVarL = a0.d.k(str, sparseArray);
                } else {
                    dVarL = a0.d.l(str);
                }
                if (dVarL != null) {
                    dVarL.i(str);
                    this.C.put(str, dVarL);
                }
                c11 = 1;
            }
            ArrayList<f> arrayList3 = this.A;
            if (arrayList3 != null) {
                for (f fVar3 : arrayList3) {
                    if (fVar3 instanceof g) {
                        fVar3.a(this.C);
                    }
                }
            }
            this.f3851i.c(this.C, 0);
            this.f3852j.c(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                a0.d dVar = this.C.get(str3);
                if (dVar != null) {
                    dVar.j(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(ag.c.f654g)[1];
                        for (f fVar4 : this.A) {
                            HashMap<String, ConstraintAttribute> map3 = fVar4.f3669e;
                            if (map3 != null && (constraintAttribute2 = map3.get(str5)) != null) {
                                sparseArray2.append(fVar4.f3665a, constraintAttribute2);
                            }
                        }
                        fVarI = a0.f.h(str4, sparseArray2);
                    } else {
                        fVarI = a0.f.i(str4, currentTime);
                    }
                    if (fVarI != null) {
                        fVarI.e(str4);
                        this.B.put(str4, fVarI);
                    }
                }
            }
            ArrayList<f> arrayList4 = this.A;
            if (arrayList4 != null) {
                for (f fVar5 : arrayList4) {
                    if (fVar5 instanceof l) {
                        ((l) fVar5).W(this.B);
                    }
                }
            }
            for (String str6 : this.B.keySet()) {
                this.B.get(str6).f(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int i12 = 2;
        int size = this.f3867y.size() + 2;
        s[] sVarArr = new s[size];
        sVarArr[0] = this.f3849g;
        sVarArr[size - 1] = this.f3850h;
        if (this.f3867y.size() > 0 && this.f3848f == -1) {
            this.f3848f = 0;
        }
        Iterator<s> it2 = this.f3867y.iterator();
        int i13 = 1;
        while (it2.hasNext()) {
            sVarArr[i13] = it2.next();
            i13++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.f3850h.f3896o.keySet()) {
            if (this.f3849g.f3896o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f3863u = strArr2;
        this.f3864v = new int[strArr2.length];
        int i14 = 0;
        while (true) {
            strArr = this.f3863u;
            if (i14 >= strArr.length) {
                break;
            }
            String str8 = strArr[i14];
            this.f3864v[i14] = 0;
            int i15 = 0;
            while (true) {
                if (i15 >= size) {
                    break;
                }
                if (sVarArr[i15].f3896o.containsKey(str8) && (constraintAttribute = sVarArr[i15].f3896o.get(str8)) != null) {
                    int[] iArr = this.f3864v;
                    iArr[i14] = iArr[i14] + constraintAttribute.p();
                    break;
                }
                i15++;
            }
            i14++;
        }
        boolean z10 = sVarArr[0].f3892k != f.f3644f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i16 = 1; i16 < size; i16++) {
            sVarArr[i16].g(sVarArr[i16 - 1], zArr, this.f3863u, z10);
        }
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                i17++;
            }
        }
        this.f3860r = new int[i17];
        int iMax = Math.max(2, i17);
        this.f3861s = new double[iMax];
        this.f3862t = new double[iMax];
        int i19 = 0;
        for (int i20 = 1; i20 < length; i20++) {
            if (zArr[i20]) {
                this.f3860r[i19] = i20;
                i19++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, size, this.f3860r.length);
        double[] dArr2 = new double[size];
        for (int i21 = 0; i21 < size; i21++) {
            sVarArr[i21].h(dArr[i21], this.f3860r);
            dArr2[i21] = sVarArr[i21].f3884c;
        }
        int i22 = 0;
        while (true) {
            int[] iArr2 = this.f3860r;
            if (i22 >= iArr2.length) {
                break;
            }
            if (iArr2[i22] < s.K0.length) {
                String str9 = s.K0[this.f3860r[i22]] + " [";
                for (int i23 = 0; i23 < size; i23++) {
                    str9 = str9 + dArr[i23][i22];
                }
            }
            i22++;
        }
        this.f3853k = new w.b[this.f3863u.length + 1];
        int i24 = 0;
        while (true) {
            String[] strArr3 = this.f3863u;
            if (i24 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i24];
            int i25 = 0;
            double[] dArr3 = null;
            int i26 = 0;
            double[][] dArr4 = null;
            while (i25 < size) {
                if (sVarArr[i25].p(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i12];
                        iArr3[1] = sVarArr[i25].n(str10);
                        iArr3[c10] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) double.class, iArr3);
                    }
                    dArr3[i26] = sVarArr[i25].f3884c;
                    sVarArr[i25].m(str10, dArr4[i26], 0);
                    i26++;
                }
                i25++;
                i12 = 2;
                c10 = 0;
            }
            i24++;
            this.f3853k[i24] = w.b.a(this.f3848f, Arrays.copyOf(dArr3, i26), (double[][]) Arrays.copyOf(dArr4, i26));
            i12 = 2;
            c10 = 0;
        }
        this.f3853k[0] = w.b.a(this.f3848f, dArr2, dArr);
        if (sVarArr[0].f3892k != f.f3644f) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) double.class, size, 2);
            for (int i27 = 0; i27 < size; i27++) {
                iArr4[i27] = sVarArr[i27].f3892k;
                dArr5[i27] = sVarArr[i27].f3884c;
                dArr6[i27][0] = sVarArr[i27].f3886e;
                dArr6[i27][1] = sVarArr[i27].f3887f;
            }
            this.f3854l = w.b.b(iArr4, dArr5, dArr6);
        }
        float fD = Float.NaN;
        this.D = new HashMap<>();
        if (this.A != null) {
            for (String str11 : hashSet3) {
                a0.c cVarL = a0.c.l(str11);
                if (cVarL != null) {
                    if (cVarL.k() && Float.isNaN(fD)) {
                        fD = D();
                    }
                    cVarL.i(str11);
                    this.D.put(str11, cVarL);
                }
            }
            for (f fVar6 : this.A) {
                if (fVar6 instanceof h) {
                    ((h) fVar6).a0(this.D);
                }
            }
            Iterator<a0.c> it3 = this.D.values().iterator();
            while (it3.hasNext()) {
                it3.next().j(fD);
            }
        }
    }

    public void b(ArrayList<f> list) {
        this.A.addAll(list);
    }

    public void b0(o motionController) {
        this.f3849g.x(motionController, motionController.f3849g);
        this.f3850h.x(motionController, motionController.f3850h);
    }

    public void c(float[] bounds, int pointCount) {
        float f10 = 1.0f / (pointCount - 1);
        HashMap<String, a0.d> map = this.C;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, a0.d> map2 = this.C;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, a0.c> map3 = this.D;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, a0.c> map4 = this.D;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i10 = 0; i10 < pointCount; i10++) {
            float fMin = i10 * f10;
            float f11 = this.f3857o;
            float f12 = 0.0f;
            if (f11 != 1.0f) {
                float f13 = this.f3856n;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f11, 1.0f);
                }
            }
            double dA = fMin;
            w.d dVar = this.f3849g.f3882a;
            float f14 = Float.NaN;
            for (s sVar : this.f3867y) {
                w.d dVar2 = sVar.f3882a;
                if (dVar2 != null) {
                    float f15 = sVar.f3884c;
                    if (f15 < fMin) {
                        dVar = dVar2;
                        f12 = f15;
                    } else if (Float.isNaN(f14)) {
                        f14 = sVar.f3884c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                dA = (((float) dVar.a((fMin - f12) / r11)) * (f14 - f12)) + f12;
            }
            this.f3853k[0].d(dA, this.f3861s);
            w.b bVar = this.f3854l;
            if (bVar != null) {
                double[] dArr = this.f3861s;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            this.f3849g.i(this.f3860r, this.f3861s, bounds, i10 * 2);
        }
    }

    public int d(float[] keyBounds, int[] mode) {
        if (keyBounds == null) {
            return 0;
        }
        double[] dArrH = this.f3853k[0].h();
        if (mode != null) {
            Iterator<s> it2 = this.f3867y.iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                mode[i10] = it2.next().f3897p;
                i10++;
            }
        }
        int i11 = 0;
        for (double d10 : dArrH) {
            this.f3853k[0].d(d10, this.f3861s);
            this.f3849g.i(this.f3860r, this.f3861s, keyBounds, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    public int e(float[] keyFrames, int[] mode) {
        if (keyFrames == null) {
            return 0;
        }
        double[] dArrH = this.f3853k[0].h();
        if (mode != null) {
            Iterator<s> it2 = this.f3867y.iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                mode[i10] = it2.next().f3897p;
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < dArrH.length; i12++) {
            this.f3853k[0].d(dArrH[i12], this.f3861s);
            this.f3849g.j(dArrH[i12], this.f3860r, this.f3861s, keyFrames, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    public void f(float[] points, int pointCount) {
        double dA;
        float f10 = 1.0f;
        float f11 = 1.0f / (pointCount - 1);
        HashMap<String, a0.d> map = this.C;
        a0.d dVar = map == null ? null : map.get("translationX");
        HashMap<String, a0.d> map2 = this.C;
        a0.d dVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, a0.c> map3 = this.D;
        a0.c cVar = map3 == null ? null : map3.get("translationX");
        HashMap<String, a0.c> map4 = this.D;
        a0.c cVar2 = map4 != null ? map4.get("translationY") : null;
        int i10 = 0;
        while (i10 < pointCount) {
            float fMin = i10 * f11;
            float f12 = this.f3857o;
            if (f12 != f10) {
                float f13 = this.f3856n;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f12, f10);
                }
            }
            float f14 = fMin;
            double d10 = f14;
            w.d dVar3 = this.f3849g.f3882a;
            float f15 = Float.NaN;
            float f16 = 0.0f;
            for (s sVar : this.f3867y) {
                w.d dVar4 = sVar.f3882a;
                double d11 = d10;
                if (dVar4 != null) {
                    float f17 = sVar.f3884c;
                    if (f17 < f14) {
                        f16 = f17;
                        dVar3 = dVar4;
                    } else if (Float.isNaN(f15)) {
                        f15 = sVar.f3884c;
                    }
                }
                d10 = d11;
            }
            double d12 = d10;
            if (dVar3 != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                dA = (((float) dVar3.a((f14 - f16) / r5)) * (f15 - f16)) + f16;
            } else {
                dA = d12;
            }
            this.f3853k[0].d(dA, this.f3861s);
            w.b bVar = this.f3854l;
            if (bVar != null) {
                double[] dArr = this.f3861s;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            int i11 = i10 * 2;
            int i12 = i10;
            this.f3849g.j(dA, this.f3860r, this.f3861s, points, i11);
            if (cVar != null) {
                points[i11] = points[i11] + cVar.a(f14);
            } else if (dVar != null) {
                points[i11] = points[i11] + dVar.a(f14);
            }
            if (cVar2 != null) {
                int i13 = i11 + 1;
                points[i13] = points[i13] + cVar2.a(f14);
            } else if (dVar2 != null) {
                int i14 = i11 + 1;
                points[i14] = points[i14] + dVar2.a(f14);
            }
            i10 = i12 + 1;
            f10 = 1.0f;
        }
    }

    public void g(float p10, float[] path, int offset) {
        this.f3853k[0].d(j(p10, null), this.f3861s);
        this.f3849g.o(this.f3860r, this.f3861s, path, offset);
    }

    public void h(float[] path, int pointCount) {
        float f10 = 1.0f / (pointCount - 1);
        for (int i10 = 0; i10 < pointCount; i10++) {
            this.f3853k[0].d(j(i10 * f10, null), this.f3861s);
            this.f3849g.o(this.f3860r, this.f3861s, path, i10 * 8);
        }
    }

    public void i(boolean start) {
        if (!"button".equals(c.k(this.f3844b)) || this.E == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            m[] mVarArr = this.E;
            if (i10 >= mVarArr.length) {
                return;
            }
            mVarArr[i10].A(start ? -100.0f : 100.0f, this.f3844b);
            i10++;
        }
    }

    public final float j(float position, float[] velocity) {
        float f10 = 0.0f;
        if (velocity != null) {
            velocity[0] = 1.0f;
        } else {
            float f11 = this.f3857o;
            if (f11 != 1.0d) {
                float f12 = this.f3856n;
                if (position < f12) {
                    position = 0.0f;
                }
                if (position > f12 && position < 1.0d) {
                    position = Math.min((position - f12) * f11, 1.0f);
                }
            }
        }
        w.d dVar = this.f3849g.f3882a;
        float f13 = Float.NaN;
        for (s sVar : this.f3867y) {
            w.d dVar2 = sVar.f3882a;
            if (dVar2 != null) {
                float f14 = sVar.f3884c;
                if (f14 < position) {
                    dVar = dVar2;
                    f10 = f14;
                } else if (Float.isNaN(f13)) {
                    f13 = sVar.f3884c;
                }
            }
        }
        if (dVar != null) {
            float f15 = (Float.isNaN(f13) ? 1.0f : f13) - f10;
            double d10 = (position - f10) / f15;
            position = (((float) dVar.a(d10)) * f15) + f10;
            if (velocity != null) {
                velocity[0] = (float) dVar.b(d10);
            }
        }
        return position;
    }

    public int k() {
        return this.f3849g.f3893l;
    }

    public int l(String attributeType, float[] points, int pointCount) {
        a0.d dVar = this.C.get(attributeType);
        if (dVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < points.length; i10++) {
            points[i10] = dVar.a(i10 / (points.length - 1));
        }
        return points.length;
    }

    public void m(double p10, float[] pos, float[] vel) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f3853k[0].d(p10, dArr);
        this.f3853k[0].g(p10, dArr2);
        Arrays.fill(vel, 0.0f);
        this.f3849g.k(p10, this.f3860r, dArr, pos, dArr2, vel);
    }

    public float n() {
        return this.f3858p;
    }

    public float o() {
        return this.f3859q;
    }

    public void p(float position, float locationX, float locationY, float[] mAnchorDpDt) {
        double[] dArr;
        float fJ = j(position, this.f3868z);
        w.b[] bVarArr = this.f3853k;
        int i10 = 0;
        if (bVarArr == null) {
            s sVar = this.f3850h;
            float f10 = sVar.f3886e;
            s sVar2 = this.f3849g;
            float f11 = f10 - sVar2.f3886e;
            float f12 = sVar.f3887f - sVar2.f3887f;
            float f13 = (sVar.f3888g - sVar2.f3888g) + f11;
            float f14 = (sVar.f3889h - sVar2.f3889h) + f12;
            mAnchorDpDt[0] = (f11 * (1.0f - locationX)) + (f13 * locationX);
            mAnchorDpDt[1] = (f12 * (1.0f - locationY)) + (f14 * locationY);
            return;
        }
        double d10 = fJ;
        bVarArr[0].g(d10, this.f3862t);
        this.f3853k[0].d(d10, this.f3861s);
        float f15 = this.f3868z[0];
        while (true) {
            dArr = this.f3862t;
            if (i10 >= dArr.length) {
                break;
            }
            dArr[i10] = dArr[i10] * ((double) f15);
            i10++;
        }
        w.b bVar = this.f3854l;
        if (bVar == null) {
            this.f3849g.v(locationX, locationY, mAnchorDpDt, this.f3860r, dArr, this.f3861s);
            return;
        }
        double[] dArr2 = this.f3861s;
        if (dArr2.length > 0) {
            bVar.d(d10, dArr2);
            this.f3854l.g(d10, this.f3862t);
            this.f3849g.v(locationX, locationY, mAnchorDpDt, this.f3860r, this.f3862t, this.f3861s);
        }
    }

    public int q() {
        int iMax = this.f3849g.f3883b;
        Iterator<s> it2 = this.f3867y.iterator();
        while (it2.hasNext()) {
            iMax = Math.max(iMax, it2.next().f3883b);
        }
        return Math.max(iMax, this.f3850h.f3883b);
    }

    public float r() {
        return this.f3850h.f3889h;
    }

    public float s() {
        return this.f3850h.f3888g;
    }

    public float t() {
        return this.f3850h.f3886e;
    }

    public String toString() {
        return " start: x: " + this.f3849g.f3886e + " y: " + this.f3849g.f3887f + " end: x: " + this.f3850h.f3886e + " y: " + this.f3850h.f3887f;
    }

    public float u() {
        return this.f3850h.f3887f;
    }

    public s w(int i10) {
        return this.f3867y.get(i10);
    }

    public int x(int type, int[] info) {
        float[] fArr = new float[2];
        int i10 = 0;
        int i11 = 0;
        for (f fVar : this.A) {
            int i12 = fVar.f3668d;
            if (i12 == type || type != -1) {
                info[i11] = 0;
                int i13 = i11 + 1;
                info[i13] = i12;
                int i14 = i13 + 1;
                int i15 = fVar.f3665a;
                info[i14] = i15;
                double d10 = i15 / 100.0f;
                this.f3853k[0].d(d10, this.f3861s);
                this.f3849g.j(d10, this.f3860r, this.f3861s, fArr, 0);
                int i16 = i14 + 1;
                info[i16] = Float.floatToIntBits(fArr[0]);
                int i17 = i16 + 1;
                info[i17] = Float.floatToIntBits(fArr[1]);
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i18 = i17 + 1;
                    info[i18] = jVar.O;
                    int i19 = i18 + 1;
                    info[i19] = Float.floatToIntBits(jVar.K);
                    i17 = i19 + 1;
                    info[i17] = Float.floatToIntBits(jVar.L);
                }
                int i20 = i17 + 1;
                info[i11] = i20 - i11;
                i10++;
                i11 = i20;
            }
        }
        return i10;
    }

    public float y(int type, float x10, float y10) {
        s sVar = this.f3850h;
        float f10 = sVar.f3886e;
        s sVar2 = this.f3849g;
        float f11 = sVar2.f3886e;
        float f12 = f10 - f11;
        float f13 = sVar.f3887f;
        float f14 = sVar2.f3887f;
        float f15 = f13 - f14;
        float f16 = f11 + (sVar2.f3888g / 2.0f);
        float f17 = f14 + (sVar2.f3889h / 2.0f);
        float fHypot = (float) Math.hypot(f12, f15);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f18 = x10 - f16;
        float f19 = y10 - f17;
        if (((float) Math.hypot(f18, f19)) == 0.0f) {
            return 0.0f;
        }
        float f20 = (f18 * f12) + (f19 * f15);
        if (type == 0) {
            return f20 / fHypot;
        }
        if (type == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f20 * f20));
        }
        if (type == 2) {
            return f18 / f12;
        }
        if (type == 3) {
            return f19 / f12;
        }
        if (type == 4) {
            return f18 / f15;
        }
        if (type != 5) {
            return 0.0f;
        }
        return f19 / f15;
    }

    public int z(int[] type, float[] pos) {
        int i10 = 0;
        int i11 = 0;
        for (f fVar : this.A) {
            int i12 = fVar.f3665a;
            type[i10] = (fVar.f3668d * 1000) + i12;
            double d10 = i12 / 100.0f;
            this.f3853k[0].d(d10, this.f3861s);
            this.f3849g.j(d10, this.f3860r, this.f3861s, pos, i11);
            i11 += 2;
            i10++;
        }
        return i10;
    }
}
