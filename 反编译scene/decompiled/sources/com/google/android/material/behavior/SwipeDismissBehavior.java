package com.google.android.material.behavior;

import a.bj;
import a.eh;
import a.lk;
import a.ni;
import a.ti;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lk f4562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f4563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4564a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4565b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8282a = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4560a = 2;
    public float b = 0.5f;
    public float c = 0.0f;
    public float d = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lk.a f4561a = new a();

    public class a extends lk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8283a;
        public int b = -1;

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
        @Override // a.lk.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = a.eh.y(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = r0
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f4560a
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.f8283a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f8283a
                goto L37
            L1c:
                int r5 = r2.f8283a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.f8283a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f8283a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.G(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // a.lk.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // a.lk.a
        public int d(View view) {
            return view.getWidth();
        }

        @Override // a.lk.a
        public void i(View view, int i) {
            this.b = i;
            this.f8283a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // a.lk.a
        public void j(int i) {
            c cVar = SwipeDismissBehavior.this.f4563a;
            if (cVar != null) {
                cVar.a(i);
            }
        }

        @Override // a.lk.a
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = this.f8283a + (view.getWidth() * SwipeDismissBehavior.this.c);
            float width2 = this.f8283a + (view.getWidth() * SwipeDismissBehavior.this.d);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f), 1.0f));
            }
        }

        @Override // a.lk.a
        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            c cVar;
            this.b = -1;
            int width = view.getWidth();
            if (n(view, f)) {
                int left = view.getLeft();
                int i2 = this.f8283a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.f8283a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f4562a.M(i, view.getTop())) {
                eh.c0(view, new d(view, z));
            } else {
                if (!z || (cVar = SwipeDismissBehavior.this.f4563a) == null) {
                    return;
                }
                cVar.b(view);
            }
        }

        @Override // a.lk.a
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.E(view);
        }

        public final boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.f8283a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.b);
            }
            boolean z = eh.y(view) == 1;
            int i = SwipeDismissBehavior.this.f4560a;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }
    }

    public class b implements bj {
        public b() {
        }

        @Override // a.bj
        public boolean a(View view, ti tiVar) {
            boolean z = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z2 = eh.y(view) == 1;
            if ((SwipeDismissBehavior.this.f4560a == 0 && z2) || (SwipeDismissBehavior.this.f4560a == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            eh.V(view, width);
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.f4563a;
            if (cVar != null) {
                cVar.b(view);
            }
            return true;
        }
    }

    public interface c {
        void a(int i);

        void b(View view);
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8285a;
        public final boolean b;

        public d(View view, boolean z) {
            this.f8285a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            lk lkVar = SwipeDismissBehavior.this.f4562a;
            if (lkVar != null && lkVar.m(true)) {
                eh.c0(this.f8285a, this);
            } else {
                if (!this.b || (cVar = SwipeDismissBehavior.this.f4563a) == null) {
                    return;
                }
                cVar.b(this.f8285a);
            }
        }
    }

    public static float F(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public static int G(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static float I(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        lk lkVar = this.f4562a;
        if (lkVar == null) {
            return false;
        }
        lkVar.E(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public final void H(ViewGroup viewGroup) {
        if (this.f4562a == null) {
            this.f4562a = this.f4565b ? lk.n(viewGroup, this.f8282a, this.f4561a) : lk.o(viewGroup, this.f4561a);
        }
    }

    public void J(float f) {
        this.d = F(0.0f, f, 1.0f);
    }

    public void K(c cVar) {
        this.f4563a = cVar;
    }

    public void L(float f) {
        this.c = F(0.0f, f, 1.0f);
    }

    public void M(int i) {
        this.f4560a = i;
    }

    public final void N(View view) {
        eh.e0(view, 1048576);
        if (E(view)) {
            eh.g0(view, ni.a.h, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean zB = this.f4564a;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zB = coordinatorLayout.B(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f4564a = zB;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4564a = false;
        }
        if (!zB) {
            return false;
        }
        H(coordinatorLayout);
        return this.f4562a.N(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        boolean zL = super.l(coordinatorLayout, v, i);
        if (eh.w(v) == 0) {
            eh.t0(v, 1);
            N(v);
        }
        return zL;
    }
}
