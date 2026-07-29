package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.transition.a;
import androidx.transition.q;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends q {
    public static final String P7 = "android:visibility:screenLocation";
    public static final int Q7 = 1;
    public static final int R7 = 2;
    public int M7;
    public static final String N7 = "android:visibility:visibility";
    public static final String O7 = "android:visibility:parent";
    public static final String[] S7 = {N7, O7};

    public class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f7795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f7796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f7797c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f7795a = viewGroup;
            this.f7796b = view;
            this.f7797c = view2;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void b(@n0 q qVar) {
            g2.v.b(this.f7795a).d(this.f7796b);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            this.f7797c.setTag(R.id.save_overlay_view, null);
            g2.v.b(this.f7795a).d(this.f7796b);
            qVar.p0(this);
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void e(@n0 q qVar) {
            if (this.f7796b.getParent() == null) {
                g2.v.b(this.f7795a).c(this.f7796b);
            } else {
                a0.this.cancel();
            }
        }
    }

    public static class b extends AnimatorListenerAdapter implements q.h, a.InterfaceC0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f7801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f7802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7804f = false;

        public b(View view, int i10, boolean z10) {
            this.f7799a = view;
            this.f7800b = i10;
            this.f7801c = (ViewGroup) view.getParent();
            this.f7802d = z10;
            g(true);
        }

        @Override // androidx.transition.q.h
        public void a(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void b(@n0 q qVar) {
            g(false);
        }

        @Override // androidx.transition.q.h
        public void c(@n0 q qVar) {
            f();
            qVar.p0(this);
        }

        @Override // androidx.transition.q.h
        public void d(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void e(@n0 q qVar) {
            g(true);
        }

        public final void f() {
            if (!this.f7804f) {
                g2.z.i(this.f7799a, this.f7800b);
                ViewGroup viewGroup = this.f7801c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f7802d || this.f7803e == z10 || (viewGroup = this.f7801c) == null) {
                return;
            }
            this.f7803e = z10;
            g2.v.d(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7804f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0073a
        public void onAnimationPause(Animator animator) {
            if (this.f7804f) {
                return;
            }
            g2.z.i(this.f7799a, this.f7800b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0073a
        public void onAnimationResume(Animator animator) {
            if (this.f7804f) {
                return;
            }
            g2.z.i(this.f7799a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f7809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f7810f;
    }

    public a0() {
        this.M7 = 3;
    }

    public final void H0(g2.q qVar) {
        qVar.f28972a.put(N7, Integer.valueOf(qVar.f28973b.getVisibility()));
        qVar.f28972a.put(O7, qVar.f28973b.getParent());
        int[] iArr = new int[2];
        qVar.f28973b.getLocationOnScreen(iArr);
        qVar.f28972a.put(P7, iArr);
    }

    public int I0() {
        return this.M7;
    }

    public final d J0(g2.q qVar, g2.q qVar2) {
        d dVar = new d();
        dVar.f7805a = false;
        dVar.f7806b = false;
        if (qVar == null || !qVar.f28972a.containsKey(N7)) {
            dVar.f7807c = -1;
            dVar.f7809e = null;
        } else {
            dVar.f7807c = ((Integer) qVar.f28972a.get(N7)).intValue();
            dVar.f7809e = (ViewGroup) qVar.f28972a.get(O7);
        }
        if (qVar2 == null || !qVar2.f28972a.containsKey(N7)) {
            dVar.f7808d = -1;
            dVar.f7810f = null;
        } else {
            dVar.f7808d = ((Integer) qVar2.f28972a.get(N7)).intValue();
            dVar.f7810f = (ViewGroup) qVar2.f28972a.get(O7);
        }
        if (qVar != null && qVar2 != null) {
            int i10 = dVar.f7807c;
            int i11 = dVar.f7808d;
            if (i10 == i11 && dVar.f7809e == dVar.f7810f) {
                return dVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    dVar.f7806b = false;
                    dVar.f7805a = true;
                } else if (i11 == 0) {
                    dVar.f7806b = true;
                    dVar.f7805a = true;
                }
            } else if (dVar.f7810f == null) {
                dVar.f7806b = false;
                dVar.f7805a = true;
            } else if (dVar.f7809e == null) {
                dVar.f7806b = true;
                dVar.f7805a = true;
            }
        } else if (qVar == null && dVar.f7808d == 0) {
            dVar.f7806b = true;
            dVar.f7805a = true;
        } else if (qVar2 == null && dVar.f7807c == 0) {
            dVar.f7806b = false;
            dVar.f7805a = true;
        }
        return dVar;
    }

    public boolean K0(g2.q qVar) {
        if (qVar == null) {
            return false;
        }
        return ((Integer) qVar.f28972a.get(N7)).intValue() == 0 && ((View) qVar.f28972a.get(O7)) != null;
    }

    @p0
    public Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return null;
    }

    @p0
    public Animator M0(ViewGroup viewGroup, g2.q qVar, int i10, g2.q qVar2, int i11) {
        if ((this.M7 & 1) != 1 || qVar2 == null) {
            return null;
        }
        if (qVar == null) {
            View view = (View) qVar2.f28973b.getParent();
            if (J0(K(view, false), c0(view, false)).f7805a) {
                return null;
            }
        }
        return L0(viewGroup, qVar2.f28973b, qVar, qVar2);
    }

    @p0
    public Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f A[PHI: r8
  0x008f: PHI (r8v3 android.view.View) = 
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v2 android.view.View)
  (r8v6 android.view.View)
 binds: [B:26:0x0048, B:31:0x0057, B:36:0x007c, B:38:0x007f, B:40:0x0085, B:42:0x0089, B:34:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator O0(android.view.ViewGroup r18, g2.q r19, int r20, g2.q r21, int r22) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.a0.O0(android.view.ViewGroup, g2.q, int, g2.q, int):android.animation.Animator");
    }

    public void P0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.M7 = i10;
    }

    @Override // androidx.transition.q
    @p0
    public String[] a0() {
        return S7;
    }

    @Override // androidx.transition.q
    public boolean d0(@p0 g2.q qVar, @p0 g2.q qVar2) {
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (qVar != null && qVar2 != null && qVar2.f28972a.containsKey(N7) != qVar.f28972a.containsKey(N7)) {
            return false;
        }
        d dVarJ0 = J0(qVar, qVar2);
        if (dVarJ0.f7805a) {
            return dVarJ0.f7807c == 0 || dVarJ0.f7808d == 0;
        }
        return false;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        d dVarJ0 = J0(qVar, qVar2);
        if (!dVarJ0.f7805a) {
            return null;
        }
        if (dVarJ0.f7809e == null && dVarJ0.f7810f == null) {
            return null;
        }
        return dVarJ0.f7806b ? M0(viewGroup, qVar, dVarJ0.f7807c, qVar2, dVarJ0.f7808d) : O0(viewGroup, qVar, dVarJ0.f7807c, qVar2, dVarJ0.f7808d);
    }

    @SuppressLint({"RestrictedApi"})
    public a0(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M7 = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7922e);
        int iK = j0.n.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iK != 0) {
            P0(iK);
        }
    }
}
