package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import w.u;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class n implements w {
    public static final int A = -1;
    public static final int B = -2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3141q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f3142r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f3143s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3144t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f3145u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f3146v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3147w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3148x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3149y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3150z = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<Integer, HashMap<String, a>> f3151h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<String, b> f3152i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u f3153j = new u();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3154k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3155l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w.d f3156m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3157n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3158o = 400;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3159p = 0.0f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f3163d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f3164e;

        public a(String str, int i10, int i11, float f10, float f11) {
            this.f3161b = str;
            this.f3160a = i10;
            this.f3162c = i11;
            this.f3163d = f10;
            this.f3164e = f11;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t.b f3168d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public w.g f3172h = new w.g();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3173i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3174j = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f3165a = new o();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f3166b = new o();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f3167c = new o();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t.e f3169e = new t.e(this.f3165a);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public t.e f3170f = new t.e(this.f3166b);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t.e f3171g = new t.e(this.f3167c);

        public b() {
            t.b bVar = new t.b(this.f3169e);
            this.f3168d = bVar;
            bVar.Z(this.f3169e);
            this.f3168d.X(this.f3170f);
        }

        public o a(int i10) {
            return i10 == 0 ? this.f3165a : i10 == 1 ? this.f3166b : this.f3167c;
        }

        public void b(int i10, int i11, float f10, n nVar) {
            this.f3173i = i11;
            this.f3174j = i10;
            this.f3168d.d0(i10, i11, 1.0f, System.nanoTime());
            o.n(i10, i11, this.f3167c, this.f3165a, this.f3166b, nVar, f10);
            this.f3167c.f3193q = f10;
            this.f3168d.Q(this.f3171g, f10, System.nanoTime(), this.f3172h);
        }

        public void c(u uVar) {
            u.c cVar = new u.c();
            uVar.g(cVar);
            this.f3168d.f(cVar);
        }

        public void d(u uVar) {
            u.d dVar = new u.d();
            uVar.g(dVar);
            this.f3168d.f(dVar);
        }

        public void e(u uVar) {
            u.e eVar = new u.e();
            uVar.g(eVar);
            this.f3168d.f(eVar);
        }

        public void f(ConstraintWidget constraintWidget, int i10) {
            if (i10 == 0) {
                this.f3165a.C(constraintWidget);
                this.f3168d.Z(this.f3169e);
            } else if (i10 == 1) {
                this.f3166b.C(constraintWidget);
                this.f3168d.X(this.f3170f);
            }
            this.f3174j = -1;
        }
    }

    public static androidx.constraintlayout.core.state.b E(int i10, final String str) {
        switch (i10) {
            case -1:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.f
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.Q(str, f10);
                    }
                };
            case 0:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.i
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.R(f10);
                    }
                };
            case 1:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.j
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.S(f10);
                    }
                };
            case 2:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.g
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.T(f10);
                    }
                };
            case 3:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.h
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.U(f10);
                    }
                };
            case 4:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.k
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.X(f10);
                    }
                };
            case 5:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.m
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.W(f10);
                    }
                };
            case 6:
                return new androidx.constraintlayout.core.state.b() { // from class: androidx.constraintlayout.core.state.l
                    @Override // androidx.constraintlayout.core.state.b
                    public final float getInterpolation(float f10) {
                        return n.V(f10);
                    }
                };
            default:
                return null;
        }
    }

    public static /* synthetic */ float Q(String str, float f10) {
        return (float) w.d.c(str).a(f10);
    }

    public static /* synthetic */ float R(float f10) {
        return (float) w.d.c(w.d.f53422k).a(f10);
    }

    public static /* synthetic */ float S(float f10) {
        return (float) w.d.c(w.d.f53421j).a(f10);
    }

    public static /* synthetic */ float T(float f10) {
        return (float) w.d.c(w.d.f53420i).a(f10);
    }

    public static /* synthetic */ float U(float f10) {
        return (float) w.d.c(w.d.f53423l).a(f10);
    }

    public static /* synthetic */ float V(float f10) {
        return (float) w.d.c(w.d.f53424m).a(f10);
    }

    public static /* synthetic */ float W(float f10) {
        return (float) w.d.c(w.d.f53425n).a(f10);
    }

    public static /* synthetic */ float X(float f10) {
        return (float) w.d.c("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").a(f10);
    }

    public o A(String str) {
        b bVar = this.f3152i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3166b;
    }

    public o B(ConstraintWidget constraintWidget) {
        return M(constraintWidget.f3263o, null, 2).f3167c;
    }

    public o C(String str) {
        b bVar = this.f3152i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3167c;
    }

    public androidx.constraintlayout.core.state.b D() {
        return E(this.f3154k, this.f3155l);
    }

    public int F(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.f3152i.get(str).f3168d.j(fArr, iArr, iArr2);
    }

    public t.b G(String str) {
        return M(str, null, 0).f3168d;
    }

    public int H(o oVar) {
        int i10 = 0;
        for (int i11 = 0; i11 <= 100; i11++) {
            HashMap<String, a> map = this.f3151h.get(Integer.valueOf(i11));
            if (map != null && map.get(oVar.f3177a.f3263o) != null) {
                i10++;
            }
        }
        return i10;
    }

    public float[] I(String str) {
        float[] fArr = new float[124];
        this.f3152i.get(str).f3168d.k(fArr, 62);
        return fArr;
    }

    public o J(ConstraintWidget constraintWidget) {
        return M(constraintWidget.f3263o, null, 0).f3165a;
    }

    public o K(String str) {
        b bVar = this.f3152i.get(str);
        if (bVar == null) {
            return null;
        }
        return bVar.f3165a;
    }

    public final b L(String str) {
        return this.f3152i.get(str);
    }

    public final b M(String str, ConstraintWidget constraintWidget, int i10) {
        b bVar = this.f3152i.get(str);
        if (bVar == null) {
            bVar = new b();
            this.f3153j.g(bVar.f3168d);
            this.f3152i.put(str, bVar);
            if (constraintWidget != null) {
                bVar.f(constraintWidget, i10);
            }
        }
        return bVar;
    }

    public boolean N() {
        return this.f3151h.size() > 0;
    }

    public void O(int i10, int i11, float f10) {
        w.d dVar = this.f3156m;
        if (dVar != null) {
            f10 = (float) dVar.a(f10);
        }
        Iterator<String> it2 = this.f3152i.keySet().iterator();
        while (it2.hasNext()) {
            this.f3152i.get(it2.next()).b(i10, i11, f10, this);
        }
    }

    public boolean P() {
        return this.f3152i.isEmpty();
    }

    public void Y(u uVar) {
        uVar.f(this.f3153j);
        uVar.g(this);
    }

    public void Z(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        ArrayList<ConstraintWidget> arrayListL2 = dVar.l2();
        int size = arrayListL2.size();
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = arrayListL2.get(i11);
            M(constraintWidget.f3263o, null, i10).f(constraintWidget, i10);
        }
    }

    @Override // w.w
    public boolean a(int i10, int i11) {
        return false;
    }

    @Override // w.w
    public boolean b(int i10, float f10) {
        if (i10 != 706) {
            return false;
        }
        this.f3159p = f10;
        return false;
    }

    @Override // w.w
    public boolean c(int i10, String str) {
        if (i10 != 705) {
            return false;
        }
        this.f3155l = str;
        this.f3156m = w.d.c(str);
        return false;
    }

    @Override // w.w
    public boolean d(int i10, boolean z10) {
        return false;
    }

    @Override // w.w
    public int e(String str) {
        return 0;
    }

    public void n(int i10, String str, String str2, int i11) {
        M(str, null, i10).a(i10).c(str2, i11);
    }

    public void o(int i10, String str, String str2, float f10) {
        M(str, null, i10).a(i10).d(str2, f10);
    }

    public void p(String str, u uVar) {
        M(str, null, 0).c(uVar);
    }

    public void q(String str, u uVar) {
        M(str, null, 0).d(uVar);
    }

    public void r(String str, int i10, int i11, float f10, float f11) {
        u uVar = new u();
        uVar.b(w.g.f53779r, 2);
        uVar.b(100, i10);
        uVar.a(w.g.f53775n, f10);
        uVar.a(w.g.f53776o, f11);
        M(str, null, 0).e(uVar);
        a aVar = new a(str, i10, i11, f10, f11);
        HashMap<String, a> map = this.f3151h.get(Integer.valueOf(i10));
        if (map == null) {
            map = new HashMap<>();
            this.f3151h.put(Integer.valueOf(i10), map);
        }
        map.put(str, aVar);
    }

    public void s(String str, u uVar) {
        M(str, null, 0).e(uVar);
    }

    public void t() {
        this.f3152i.clear();
    }

    public boolean u(String str) {
        return this.f3152i.containsKey(str);
    }

    public void v(o oVar, float[] fArr, float[] fArr2, float[] fArr3) {
        a aVar;
        int i10 = 0;
        for (int i11 = 0; i11 <= 100; i11++) {
            HashMap<String, a> map = this.f3151h.get(Integer.valueOf(i11));
            if (map != null && (aVar = map.get(oVar.f3177a.f3263o)) != null) {
                fArr[i10] = aVar.f3163d;
                fArr2[i10] = aVar.f3164e;
                fArr3[i10] = aVar.f3160a;
                i10++;
            }
        }
    }

    public a w(String str, int i10) {
        a aVar;
        while (i10 <= 100) {
            HashMap<String, a> map = this.f3151h.get(Integer.valueOf(i10));
            if (map != null && (aVar = map.get(str)) != null) {
                return aVar;
            }
            i10++;
        }
        return null;
    }

    public a x(String str, int i10) {
        a aVar;
        while (i10 >= 0) {
            HashMap<String, a> map = this.f3151h.get(Integer.valueOf(i10));
            if (map != null && (aVar = map.get(str)) != null) {
                return aVar;
            }
            i10--;
        }
        return null;
    }

    public int y() {
        return this.f3157n;
    }

    public o z(ConstraintWidget constraintWidget) {
        return M(constraintWidget.f3263o, null, 1).f3166b;
    }
}
