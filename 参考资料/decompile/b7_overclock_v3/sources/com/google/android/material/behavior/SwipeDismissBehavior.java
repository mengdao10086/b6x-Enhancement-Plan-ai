package com.google.android.material.behavior;

import a1.d;
import a1.g;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import e1.d;
import g.i1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f19625k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f19626l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f19627m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19628n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f19629o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f19630p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f19631q = 0.5f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f19632r = 0.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f19633s = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e1.d f19634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f19635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19636c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19638e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f19637d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19639f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f19640g = 0.5f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f19641h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f19642i = 0.5f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d.c f19643j = new a();

    public class a extends d.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f19644d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19646b = -1;

        public a() {
        }

        @Override // e1.d.c
        public int a(@n0 View view, int i10, int i11) {
            int width;
            int width2;
            int width3;
            boolean z10 = u0.Z(view) == 1;
            int i12 = SwipeDismissBehavior.this.f19639f;
            if (i12 == 0) {
                if (z10) {
                    width = this.f19645a - view.getWidth();
                    width2 = this.f19645a;
                } else {
                    width = this.f19645a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i12 != 1) {
                width = this.f19645a - view.getWidth();
                width2 = view.getWidth() + this.f19645a;
            } else if (z10) {
                width = this.f19645a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f19645a - view.getWidth();
                width2 = this.f19645a;
            }
            return SwipeDismissBehavior.I(width, i10, width2);
        }

        @Override // e1.d.c
        public int b(@n0 View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // e1.d.c
        public int d(@n0 View view) {
            return view.getWidth();
        }

        @Override // e1.d.c
        public void i(@n0 View view, int i10) {
            this.f19646b = i10;
            this.f19645a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // e1.d.c
        public void j(int i10) {
            c cVar = SwipeDismissBehavior.this.f19635b;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // e1.d.c
        public void k(@n0 View view, int i10, int i11, int i12, int i13) {
            float width = this.f19645a + (view.getWidth() * SwipeDismissBehavior.this.f19641h);
            float width2 = this.f19645a + (view.getWidth() * SwipeDismissBehavior.this.f19642i);
            float f10 = i10;
            if (f10 <= width) {
                view.setAlpha(1.0f);
            } else if (f10 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.H(0.0f, 1.0f - SwipeDismissBehavior.K(width, width2, f10), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // e1.d.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(@g.n0 android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f19646b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.f19645a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.f19645a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.f19645a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                e1.d r5 = r5.f19634a
                int r1 = r3.getTop()
                boolean r5 = r5.V(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$d r5 = new com.google.android.material.behavior.SwipeDismissBehavior$d
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                androidx.core.view.u0.p1(r3, r5)
                goto L4a
            L3f:
                if (r4 == 0) goto L4a
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$c r4 = r4.f19635b
                if (r4 == 0) goto L4a
                r4.a(r3)
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // e1.d.c
        public boolean m(View view, int i10) {
            int i11 = this.f19646b;
            return (i11 == -1 || i11 == i10) && SwipeDismissBehavior.this.G(view);
        }

        public final boolean n(@n0 View view, float f10) {
            if (f10 == 0.0f) {
                return Math.abs(view.getLeft() - this.f19645a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f19640g);
            }
            boolean z10 = u0.Z(view) == 1;
            int i10 = SwipeDismissBehavior.this.f19639f;
            if (i10 == 2) {
                return true;
            }
            if (i10 == 0) {
                if (z10) {
                    if (f10 >= 0.0f) {
                        return false;
                    }
                } else if (f10 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            if (z10) {
                if (f10 <= 0.0f) {
                    return false;
                }
            } else if (f10 >= 0.0f) {
                return false;
            }
            return true;
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // a1.g
        public boolean a(@n0 View view, @p0 g.a aVar) {
            boolean z10 = false;
            if (!SwipeDismissBehavior.this.G(view)) {
                return false;
            }
            boolean z11 = u0.Z(view) == 1;
            int i10 = SwipeDismissBehavior.this.f19639f;
            if ((i10 == 0 && z11) || (i10 == 1 && !z11)) {
                z10 = true;
            }
            int width = view.getWidth();
            if (z10) {
                width = -width;
            }
            u0.e1(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f19635b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i10);
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f19649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f19650b;

        public d(View view, boolean z10) {
            this.f19649a = view;
            this.f19650b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            e1.d dVar = SwipeDismissBehavior.this.f19634a;
            if (dVar != null && dVar.o(true)) {
                u0.p1(this.f19649a, this);
            } else {
                if (!this.f19650b || (cVar = SwipeDismissBehavior.this.f19635b) == null) {
                    return;
                }
                cVar.a(this.f19649a);
            }
        }
    }

    public static float H(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    public static int I(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i11), i12);
    }

    public static float K(float f10, float f11, float f12) {
        return (f12 - f10) / (f11 - f10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        e1.d dVar = this.f19634a;
        if (dVar == null) {
            return false;
        }
        dVar.M(motionEvent);
        return true;
    }

    public boolean G(@n0 View view) {
        return true;
    }

    public final void J(ViewGroup viewGroup) {
        if (this.f19634a == null) {
            this.f19634a = this.f19638e ? e1.d.p(viewGroup, this.f19637d, this.f19643j) : e1.d.q(viewGroup, this.f19643j);
        }
    }

    public int L() {
        e1.d dVar = this.f19634a;
        if (dVar != null) {
            return dVar.F();
        }
        return 0;
    }

    @i1
    @p0
    public c M() {
        return this.f19635b;
    }

    public void N(float f10) {
        this.f19640g = H(0.0f, f10, 1.0f);
    }

    public void O(float f10) {
        this.f19642i = H(0.0f, f10, 1.0f);
    }

    public void P(@p0 c cVar) {
        this.f19635b = cVar;
    }

    public void Q(float f10) {
        this.f19637d = f10;
        this.f19638e = true;
    }

    public void R(float f10) {
        this.f19641h = H(0.0f, f10, 1.0f);
    }

    public void S(int i10) {
        this.f19639f = i10;
    }

    public final void T(View view) {
        u0.r1(view, 1048576);
        if (G(view)) {
            u0.u1(view, d.a.f126z, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
        boolean zA = this.f19636c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zA = coordinatorLayout.A(v10, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f19636c = zA;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f19636c = false;
        }
        if (!zA) {
            return false;
        }
        J(coordinatorLayout);
        return this.f19634a.W(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
        boolean zM = super.m(coordinatorLayout, v10, i10);
        if (u0.V(v10) == 0) {
            u0.R1(v10, 1);
            T(v10);
        }
        return zM;
    }
}
