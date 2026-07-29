package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.u0;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d1;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5901f = "FragmentManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5902g = "android:target_req_state";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5903h = "android:target_state";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5904i = "android:view_state";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f5905j = "android:view_registry_state";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5906k = "android:user_visible_hint";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f5907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f5908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Fragment f5909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5910d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5911e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5912a;

        public a(View view) {
            this.f5912a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f5912a.removeOnAttachStateChangeListener(this);
            u0.v1(this.f5912a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5914a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f5914a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5914a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5914a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5914a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d0(@g.n0 p pVar, @g.n0 f0 f0Var, @g.n0 Fragment fragment) {
        this.f5907a = pVar;
        this.f5908b = f0Var;
        this.f5909c = fragment;
    }

    public void a() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ACTIVITY_CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        fragment.l4(fragment.f5642b);
        p pVar = this.f5907a;
        Fragment fragment2 = this.f5909c;
        pVar.a(fragment2, fragment2.f5642b, false);
    }

    public void b() {
        int iJ = this.f5908b.j(this.f5909c);
        Fragment fragment = this.f5909c;
        fragment.f5665v1.addView(fragment.C1, iJ);
    }

    public void c() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto ATTACHED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        Fragment fragment2 = fragment.f5648h;
        d0 d0VarO = null;
        if (fragment2 != null) {
            d0 d0VarO2 = this.f5908b.o(fragment2.f5646f);
            if (d0VarO2 == null) {
                throw new IllegalStateException("Fragment " + this.f5909c + " declared target fragment " + this.f5909c.f5648h + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f5909c;
            fragment3.f5649i = fragment3.f5648h.f5646f;
            fragment3.f5648h = null;
            d0VarO = d0VarO2;
        } else {
            String str = fragment.f5649i;
            if (str != null && (d0VarO = this.f5908b.o(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f5909c + " declared target fragment " + this.f5909c.f5649i + " that does not belong to this FragmentManager!");
            }
        }
        if (d0VarO != null) {
            d0VarO.m();
        }
        Fragment fragment4 = this.f5909c;
        fragment4.f5663u = fragment4.f5662t.J0();
        Fragment fragment5 = this.f5909c;
        fragment5.f5667w = fragment5.f5662t.M0();
        this.f5907a.g(this.f5909c, false);
        this.f5909c.m4();
        this.f5907a.b(this.f5909c, false);
    }

    public int d() {
        Fragment fragment = this.f5909c;
        if (fragment.f5662t == null) {
            return fragment.f5641a;
        }
        int iMin = this.f5911e;
        int i10 = b.f5914a[fragment.I7.ordinal()];
        if (i10 != 1) {
            iMin = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f5909c;
        if (fragment2.f5657o) {
            if (fragment2.f5658p) {
                iMin = Math.max(this.f5911e, 2);
                View view = this.f5909c.C1;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f5911e < 4 ? Math.min(iMin, fragment2.f5641a) : Math.min(iMin, 1);
            }
        }
        if (!this.f5909c.f5654l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f5909c;
        ViewGroup viewGroup = fragment3.f5665v1;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpactL = viewGroup != null ? SpecialEffectsController.n(viewGroup, fragment3.L2()).l(this) : null;
        if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (lifecycleImpactL == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f5909c;
            if (fragment4.f5655m) {
                iMin = fragment4.v3() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f5909c;
        if (fragment5.K1 && fragment5.f5641a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("computeExpectedState() of ");
            sb2.append(iMin);
            sb2.append(" for ");
            sb2.append(this.f5909c);
        }
        return iMin;
    }

    public void e() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        if (fragment.G7) {
            fragment.W4(fragment.f5642b);
            this.f5909c.f5641a = 1;
            return;
        }
        this.f5907a.h(fragment, fragment.f5642b, false);
        Fragment fragment2 = this.f5909c;
        fragment2.p4(fragment2.f5642b);
        p pVar = this.f5907a;
        Fragment fragment3 = this.f5909c;
        pVar.c(fragment3, fragment3.f5642b, false);
    }

    public void f() {
        String resourceName;
        if (this.f5909c.f5657o) {
            return;
        }
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto CREATE_VIEW: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        LayoutInflater layoutInflaterV4 = fragment.v4(fragment.f5642b);
        ViewGroup viewGroup = null;
        Fragment fragment2 = this.f5909c;
        ViewGroup viewGroup2 = fragment2.f5665v1;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i10 = fragment2.f5669y;
            if (i10 != 0) {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f5909c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.f5662t.D0().c(this.f5909c.f5669y);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f5909c;
                    if (!fragment3.f5659q) {
                        try {
                            resourceName = fragment3.V2().getResourceName(this.f5909c.f5669y);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f5909c.f5669y) + " (" + resourceName + ") for fragment " + this.f5909c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.r(this.f5909c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f5909c;
        fragment4.f5665v1 = viewGroup;
        fragment4.r4(layoutInflaterV4, viewGroup, fragment4.f5642b);
        View view = this.f5909c.C1;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f5909c;
            fragment5.C1.setTag(R.id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f5909c;
            if (fragment6.A) {
                fragment6.C1.setVisibility(8);
            }
            if (u0.O0(this.f5909c.C1)) {
                u0.v1(this.f5909c.C1);
            } else {
                View view2 = this.f5909c.C1;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f5909c.I4();
            p pVar = this.f5907a;
            Fragment fragment7 = this.f5909c;
            pVar.m(fragment7, fragment7.C1, fragment7.f5642b, false);
            int visibility = this.f5909c.C1.getVisibility();
            this.f5909c.n5(this.f5909c.C1.getAlpha());
            Fragment fragment8 = this.f5909c;
            if (fragment8.f5665v1 != null && visibility == 0) {
                View viewFindFocus = fragment8.C1.findFocus();
                if (viewFindFocus != null) {
                    this.f5909c.h5(viewFindFocus);
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("requestFocus: Saved focused view ");
                        sb3.append(viewFindFocus);
                        sb3.append(" for Fragment ");
                        sb3.append(this.f5909c);
                    }
                }
                this.f5909c.C1.setAlpha(0.0f);
            }
        }
        this.f5909c.f5641a = 2;
    }

    public void g() {
        Fragment fragmentF;
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATED: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = fragment.f5655m && !fragment.v3();
        if (z10) {
            Fragment fragment2 = this.f5909c;
            if (!fragment2.f5656n) {
                this.f5908b.C(fragment2.f5646f, null);
            }
        }
        if (!(z10 || this.f5908b.q().v(this.f5909c))) {
            String str = this.f5909c.f5649i;
            if (str != null && (fragmentF = this.f5908b.f(str)) != null && fragmentF.C) {
                this.f5909c.f5648h = fragmentF;
            }
            this.f5909c.f5641a = 0;
            return;
        }
        l<?> lVar = this.f5909c.f5663u;
        if (lVar instanceof d1) {
            zIsChangingConfigurations = this.f5908b.q().r();
        } else if (lVar.g() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) lVar.g()).isChangingConfigurations();
        }
        if ((z10 && !this.f5909c.f5656n) || zIsChangingConfigurations) {
            this.f5908b.q().h(this.f5909c);
        }
        this.f5909c.s4();
        this.f5907a.d(this.f5909c, false);
        for (d0 d0Var : this.f5908b.l()) {
            if (d0Var != null) {
                Fragment fragmentK = d0Var.k();
                if (this.f5909c.f5646f.equals(fragmentK.f5649i)) {
                    fragmentK.f5648h = this.f5909c;
                    fragmentK.f5649i = null;
                }
            }
        }
        Fragment fragment3 = this.f5909c;
        String str2 = fragment3.f5649i;
        if (str2 != null) {
            fragment3.f5648h = this.f5908b.f(str2);
        }
        this.f5908b.t(this);
    }

    public void h() {
        View view;
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom CREATE_VIEW: ");
            sb2.append(this.f5909c);
        }
        Fragment fragment = this.f5909c;
        ViewGroup viewGroup = fragment.f5665v1;
        if (viewGroup != null && (view = fragment.C1) != null) {
            viewGroup.removeView(view);
        }
        this.f5909c.t4();
        this.f5907a.n(this.f5909c, false);
        Fragment fragment2 = this.f5909c;
        fragment2.f5665v1 = null;
        fragment2.C1 = null;
        fragment2.K7 = null;
        fragment2.L7.r(null);
        this.f5909c.f5658p = false;
    }

    public void i() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom ATTACHED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.u4();
        boolean z10 = false;
        this.f5907a.e(this.f5909c, false);
        Fragment fragment = this.f5909c;
        fragment.f5641a = -1;
        fragment.f5663u = null;
        fragment.f5667w = null;
        fragment.f5662t = null;
        if (fragment.f5655m && !fragment.v3()) {
            z10 = true;
        }
        if (z10 || this.f5908b.q().v(this.f5909c)) {
            if (FragmentManager.W0(3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("initState called for fragment: ");
                sb3.append(this.f5909c);
            }
            this.f5909c.p3();
        }
    }

    public void j() {
        Fragment fragment = this.f5909c;
        if (fragment.f5657o && fragment.f5658p && !fragment.f5660r) {
            if (FragmentManager.W0(3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveto CREATE_VIEW: ");
                sb2.append(this.f5909c);
            }
            Fragment fragment2 = this.f5909c;
            fragment2.r4(fragment2.v4(fragment2.f5642b), null, this.f5909c.f5642b);
            View view = this.f5909c.C1;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f5909c;
                fragment3.C1.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f5909c;
                if (fragment4.A) {
                    fragment4.C1.setVisibility(8);
                }
                this.f5909c.I4();
                p pVar = this.f5907a;
                Fragment fragment5 = this.f5909c;
                pVar.m(fragment5, fragment5.C1, fragment5.f5642b, false);
                this.f5909c.f5641a = 2;
            }
        }
    }

    @g.n0
    public Fragment k() {
        return this.f5909c;
    }

    public final boolean l(@g.n0 View view) {
        if (view == this.f5909c.C1) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f5909c.C1) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f5910d) {
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb2.append(k());
                return;
            }
            return;
        }
        try {
            this.f5910d = true;
            boolean z10 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f5909c;
                int i10 = fragment.f5641a;
                if (iD == i10) {
                    if (!z10 && i10 == -1 && fragment.f5655m && !fragment.v3() && !this.f5909c.f5656n) {
                        if (FragmentManager.W0(3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Cleaning up state of never attached fragment: ");
                            sb3.append(this.f5909c);
                        }
                        this.f5908b.q().h(this.f5909c);
                        this.f5908b.t(this);
                        if (FragmentManager.W0(3)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("initState called for fragment: ");
                            sb4.append(this.f5909c);
                        }
                        this.f5909c.p3();
                    }
                    Fragment fragment2 = this.f5909c;
                    if (fragment2.E7) {
                        if (fragment2.C1 != null && (viewGroup = fragment2.f5665v1) != null) {
                            SpecialEffectsController specialEffectsControllerN = SpecialEffectsController.n(viewGroup, fragment2.L2());
                            if (this.f5909c.A) {
                                specialEffectsControllerN.c(this);
                            } else {
                                specialEffectsControllerN.e(this);
                            }
                        }
                        Fragment fragment3 = this.f5909c;
                        FragmentManager fragmentManager = fragment3.f5662t;
                        if (fragmentManager != null) {
                            fragmentManager.U0(fragment3);
                        }
                        Fragment fragment4 = this.f5909c;
                        fragment4.E7 = false;
                        fragment4.U3(fragment4.A);
                        this.f5909c.f5664v.Q();
                    }
                    return;
                }
                if (iD <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.f5656n && this.f5908b.r(fragment.f5646f) == null) {
                                s();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f5909c.f5641a = 1;
                            break;
                        case 2:
                            fragment.f5658p = false;
                            fragment.f5641a = 2;
                            break;
                        case 3:
                            if (FragmentManager.W0(3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("movefrom ACTIVITY_CREATED: ");
                                sb5.append(this.f5909c);
                            }
                            Fragment fragment5 = this.f5909c;
                            if (fragment5.f5656n) {
                                s();
                            } else if (fragment5.C1 != null && fragment5.f5643c == null) {
                                t();
                            }
                            Fragment fragment6 = this.f5909c;
                            if (fragment6.C1 != null && (viewGroup2 = fragment6.f5665v1) != null) {
                                SpecialEffectsController.n(viewGroup2, fragment6.L2()).d(this);
                            }
                            this.f5909c.f5641a = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.f5641a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.C1 != null && (viewGroup3 = fragment.f5665v1) != null) {
                                SpecialEffectsController.n(viewGroup3, fragment.L2()).b(SpecialEffectsController.Operation.State.from(this.f5909c.C1.getVisibility()), this);
                            }
                            this.f5909c.f5641a = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.f5641a = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z10 = true;
            }
        } finally {
            this.f5910d = false;
        }
    }

    public void n() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom RESUMED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.A4();
        this.f5907a.f(this.f5909c, false);
    }

    public void o(@g.n0 ClassLoader classLoader) {
        Bundle bundle = this.f5909c.f5642b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f5909c;
        fragment.f5643c = fragment.f5642b.getSparseParcelableArray(f5904i);
        Fragment fragment2 = this.f5909c;
        fragment2.f5644d = fragment2.f5642b.getBundle(f5905j);
        Fragment fragment3 = this.f5909c;
        fragment3.f5649i = fragment3.f5642b.getString(f5903h);
        Fragment fragment4 = this.f5909c;
        if (fragment4.f5649i != null) {
            fragment4.f5650j = fragment4.f5642b.getInt(f5902g, 0);
        }
        Fragment fragment5 = this.f5909c;
        Boolean bool = fragment5.f5645e;
        if (bool != null) {
            fragment5.f5666v2 = bool.booleanValue();
            this.f5909c.f5645e = null;
        } else {
            fragment5.f5666v2 = fragment5.f5642b.getBoolean(f5906k, true);
        }
        Fragment fragment6 = this.f5909c;
        if (fragment6.f5666v2) {
            return;
        }
        fragment6.K1 = true;
    }

    public void p() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto RESUMED: ");
            sb2.append(this.f5909c);
        }
        View viewN2 = this.f5909c.n2();
        if (viewN2 != null && l(viewN2)) {
            boolean zRequestFocus = viewN2.requestFocus();
            if (FragmentManager.W0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("requestFocus: Restoring focused view ");
                sb3.append(viewN2);
                sb3.append(com.blankj.utilcode.util.i0.f11861z);
                sb3.append(zRequestFocus ? "succeeded" : "failed");
                sb3.append(" on Fragment ");
                sb3.append(this.f5909c);
                sb3.append(" resulting in focused view ");
                sb3.append(this.f5909c.C1.findFocus());
            }
        }
        this.f5909c.h5(null);
        this.f5909c.E4();
        this.f5907a.i(this.f5909c, false);
        Fragment fragment = this.f5909c;
        fragment.f5642b = null;
        fragment.f5643c = null;
        fragment.f5644d = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.f5909c.F4(bundle);
        this.f5907a.j(this.f5909c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f5909c.C1 != null) {
            t();
        }
        if (this.f5909c.f5643c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(f5904i, this.f5909c.f5643c);
        }
        if (this.f5909c.f5644d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(f5905j, this.f5909c.f5644d);
        }
        if (!this.f5909c.f5666v2) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f5906k, this.f5909c.f5666v2);
        }
        return bundle;
    }

    @p0
    public Fragment.SavedState r() {
        Bundle bundleQ;
        if (this.f5909c.f5641a <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleQ);
    }

    public void s() {
        FragmentState fragmentState = new FragmentState(this.f5909c);
        Fragment fragment = this.f5909c;
        if (fragment.f5641a <= -1 || fragmentState.f5793m != null) {
            fragmentState.f5793m = fragment.f5642b;
        } else {
            Bundle bundleQ = q();
            fragmentState.f5793m = bundleQ;
            if (this.f5909c.f5649i != null) {
                if (bundleQ == null) {
                    fragmentState.f5793m = new Bundle();
                }
                fragmentState.f5793m.putString(f5903h, this.f5909c.f5649i);
                int i10 = this.f5909c.f5650j;
                if (i10 != 0) {
                    fragmentState.f5793m.putInt(f5902g, i10);
                }
            }
        }
        this.f5908b.C(this.f5909c.f5646f, fragmentState);
    }

    public void t() {
        if (this.f5909c.C1 == null) {
            return;
        }
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Saving view state for fragment ");
            sb2.append(this.f5909c);
            sb2.append(" with view ");
            sb2.append(this.f5909c.C1);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f5909c.C1.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f5909c.f5643c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f5909c.K7.f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f5909c.f5644d = bundle;
    }

    public void u(int i10) {
        this.f5911e = i10;
    }

    public void v() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("moveto STARTED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.G4();
        this.f5907a.k(this.f5909c, false);
    }

    public void w() {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("movefrom STARTED: ");
            sb2.append(this.f5909c);
        }
        this.f5909c.H4();
        this.f5907a.l(this.f5909c, false);
    }

    public d0(@g.n0 p pVar, @g.n0 f0 f0Var, @g.n0 ClassLoader classLoader, @g.n0 k kVar, @g.n0 FragmentState fragmentState) {
        this.f5907a = pVar;
        this.f5908b = f0Var;
        Fragment fragmentA = fragmentState.a(kVar, classLoader);
        this.f5909c = fragmentA;
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Instantiated fragment ");
            sb2.append(fragmentA);
        }
    }

    public d0(@g.n0 p pVar, @g.n0 f0 f0Var, @g.n0 Fragment fragment, @g.n0 FragmentState fragmentState) {
        this.f5907a = pVar;
        this.f5908b = f0Var;
        this.f5909c = fragment;
        fragment.f5643c = null;
        fragment.f5644d = null;
        fragment.f5661s = 0;
        fragment.f5658p = false;
        fragment.f5654l = false;
        Fragment fragment2 = fragment.f5648h;
        fragment.f5649i = fragment2 != null ? fragment2.f5646f : null;
        fragment.f5648h = null;
        Bundle bundle = fragmentState.f5793m;
        if (bundle != null) {
            fragment.f5642b = bundle;
        } else {
            fragment.f5642b = new Bundle();
        }
    }
}
