package a;

import a.hn;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yl extends jl implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f7991a = new DecelerateInterpolator(2.5f);
    public static final Interpolator b = new DecelerateInterpolator(1.5f);
    public static boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cm f3722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dl f3723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gl f3724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnBackPressedDispatcher f3728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f3729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<vl> f3731a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Fragment f3735b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3737b;
    public ArrayList<sk> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3738c;
    public ArrayList<Fragment> d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3739d;
    public ArrayList<sk> e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3740e;
    public ArrayList<Integer> f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3741f;
    public ArrayList<il> g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f3742g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public ArrayList<sk> f3743h;
    public ArrayList<Boolean> i;
    public ArrayList<Fragment> j;
    public ArrayList<xl> k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3721a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<Fragment> f3736b = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, Fragment> f3732a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q f3725a = new kl(this, false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArrayList<tl> f3733a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f3734b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f3726a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<Parcelable> f3727a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f3730a = new ll(this);

    public static rl L0(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(b);
        alphaAnimation.setDuration(220L);
        return new rl(alphaAnimation);
    }

    public static rl N0(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f7991a);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(b);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new rl(animationSet);
    }

    public static int e1(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public static void o0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            sk skVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                skVar.p(-1);
                skVar.u(i == i2 + (-1));
            } else {
                skVar.p(1);
                skVar.t();
            }
            i++;
        }
    }

    public static int p1(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    public void A(Configuration configuration) {
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null) {
                fragment.H0(configuration);
            }
        }
    }

    public Fragment A0() {
        return this.f3735b;
    }

    public boolean B(MenuItem menuItem) {
        if (this.f3734b < 1) {
            return false;
        }
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null && fragment.I0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public xn B0(Fragment fragment) {
        return this.f3722a.i(fragment);
    }

    public void C() {
        this.f3739d = false;
        this.f3740e = false;
        f0(1);
    }

    public void C0() {
        m0();
        if (this.f3725a.c()) {
            i();
        } else {
            this.f3728a.c();
        }
    }

    public boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f3734b < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null && fragment.K0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.d != null) {
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                Fragment fragment2 = this.d.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.k0();
                }
            }
        }
        this.d = arrayList;
        return z;
    }

    public void D0(Fragment fragment) {
        if (h) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.h) {
            return;
        }
        fragment.h = true;
        fragment.r = true ^ fragment.r;
    }

    public void E() {
        this.f3741f = true;
        m0();
        f0(0);
        this.f3724a = null;
        this.f3723a = null;
        this.f3729a = null;
        if (this.f3728a != null) {
            this.f3725a.d();
            this.f3728a = null;
        }
    }

    public boolean E0() {
        return this.f3741f;
    }

    public void F() {
        f0(1);
    }

    public final boolean F0(Fragment fragment) {
        return (fragment.l && fragment.m) || fragment.f4268b.t();
    }

    public void G() {
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null) {
                fragment.Q0();
            }
        }
    }

    public boolean G0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        yl ylVar = fragment.f4258a;
        return fragment == ylVar.A0() && G0(ylVar.f3729a);
    }

    public void H(boolean z) {
        int size = this.f3736b.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.f3736b.get(size);
            if (fragment != null) {
                fragment.R0(z);
            }
        }
    }

    public boolean H0(int i) {
        return this.f3734b >= i;
    }

    public void I(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).I(fragment, bundle, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.a(this, fragment, bundle);
            }
        }
    }

    public boolean I0() {
        return this.f3739d || this.f3740e;
    }

    public void J(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).J(fragment, context, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.b(this, fragment, context);
            }
        }
    }

    public rl J0(Fragment fragment, int i, boolean z, int i2) {
        int iP1;
        int iY = fragment.y();
        boolean z2 = false;
        fragment.n1(0);
        ViewGroup viewGroup = fragment.f4264a;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation animationF0 = fragment.f0(i, z, iY);
        if (animationF0 != null) {
            return new rl(animationF0);
        }
        Animator animatorG0 = fragment.g0(i, z, iY);
        if (animatorG0 != null) {
            return new rl(animatorG0);
        }
        if (iY != 0) {
            boolean zEquals = "anim".equals(this.f3724a.e().getResources().getResourceTypeName(iY));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3724a.e(), iY);
                    if (animationLoadAnimation != null) {
                        return new rl(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.f3724a.e(), iY);
                    if (animatorLoadAnimator != null) {
                        return new rl(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.f3724a.e(), iY);
                    if (animationLoadAnimation2 != null) {
                        return new rl(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iP1 = p1(i, z)) < 0) {
            return null;
        }
        switch (iP1) {
            case 1:
                return N0(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return N0(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return N0(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return N0(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return L0(0.0f, 1.0f);
            case 6:
                return L0(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f3724a.l()) {
                    this.f3724a.k();
                }
                return null;
        }
    }

    public void K(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).K(fragment, bundle, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.c(this, fragment, bundle);
            }
        }
    }

    public void K0(Fragment fragment) {
        if (this.f3732a.get(fragment.f4267a) != null) {
            return;
        }
        this.f3732a.put(fragment.f4267a, fragment);
        if (fragment.k) {
            if (fragment.j) {
                n(fragment);
            } else {
                b1(fragment);
            }
            fragment.k = false;
        }
        if (h) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void L(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).L(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.d(this, fragment);
            }
        }
    }

    public void M(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).M(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.e(this, fragment);
            }
        }
    }

    public void M0(Fragment fragment) {
        if (this.f3732a.get(fragment.f4267a) == null) {
            return;
        }
        if (h) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f3732a.values()) {
            if (fragment2 != null && fragment.f4267a.equals(fragment2.f4273b)) {
                fragment2.f4265a = fragment;
                fragment2.f4273b = null;
            }
        }
        this.f3732a.put(fragment.f4267a, null);
        b1(fragment);
        String str = fragment.f4273b;
        if (str != null) {
            fragment.f4265a = this.f3732a.get(str);
        }
        fragment.O();
    }

    public void N(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).N(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.f(this, fragment);
            }
        }
    }

    public void O(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).O(fragment, context, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.g(this, fragment, context);
            }
        }
    }

    public final void O0(da<Fragment> daVar) {
        int size = daVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentH = daVar.h(i);
            if (!fragmentH.f4274b) {
                View viewF1 = fragmentH.f1();
                fragmentH.f4250a = viewF1.getAlpha();
                viewF1.setAlpha(0.0f);
            }
        }
    }

    public void P(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).P(fragment, bundle, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.h(this, fragment, bundle);
            }
        }
    }

    public void P0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f3732a.containsKey(fragment.f4267a)) {
            if (h) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f3734b + "since it is not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.f3734b;
        if (fragment.f4276c) {
            iMin = fragment.U() ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        S0(fragment, iMin, fragment.z(), fragment.A(), false);
        if (fragment.f4263a != null) {
            Fragment fragmentT0 = t0(fragment);
            if (fragmentT0 != null) {
                View view = fragmentT0.f4263a;
                ViewGroup viewGroup = fragment.f4264a;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.f4263a);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.f4263a, iIndexOfChild);
                }
            }
            if (fragment.q && fragment.f4264a != null) {
                float f = fragment.f4250a;
                if (f > 0.0f) {
                    fragment.f4263a.setAlpha(f);
                }
                fragment.f4250a = 0.0f;
                fragment.q = false;
                rl rlVarJ0 = J0(fragment, fragment.z(), true, fragment.A());
                if (rlVarJ0 != null) {
                    Animation animation = rlVarJ0.f2749a;
                    if (animation != null) {
                        fragment.f4263a.startAnimation(animation);
                    } else {
                        rlVarJ0.f7311a.setTarget(fragment.f4263a);
                        rlVarJ0.f7311a.start();
                    }
                }
            }
        }
        if (fragment.r) {
            x(fragment);
        }
    }

    public void Q(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).Q(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.i(this, fragment);
            }
        }
    }

    public void Q0(int i, boolean z) {
        gl glVar;
        if (this.f3724a == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f3734b) {
            this.f3734b = i;
            int size = this.f3736b.size();
            for (int i2 = 0; i2 < size; i2++) {
                P0(this.f3736b.get(i2));
            }
            for (Fragment fragment : this.f3732a.values()) {
                if (fragment != null && (fragment.f4276c || fragment.i)) {
                    if (!fragment.q) {
                        P0(fragment);
                    }
                }
            }
            n1();
            if (this.f3738c && (glVar = this.f3724a) != null && this.f3734b == 4) {
                glVar.o();
                this.f3738c = false;
            }
        }
    }

    public void R(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).R(fragment, bundle, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.j(this, fragment, bundle);
            }
        }
    }

    public void R0(Fragment fragment) {
        S0(fragment, this.f3734b, 0, 0, false);
    }

    public void S(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).S(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.k(this, fragment);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S0(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.yl.S0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    public void T(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).T(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.l(this, fragment);
            }
        }
    }

    public void T0() {
        this.f3739d = false;
        this.f3740e = false;
        int size = this.f3736b.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null) {
                fragment.X();
            }
        }
    }

    public void U(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).U(fragment, view, bundle, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.m(this, fragment, view, bundle);
            }
        }
    }

    public void U0(Fragment fragment) {
        if (fragment.o) {
            if (this.f3737b) {
                this.f3742g = true;
            } else {
                fragment.o = false;
                S0(fragment, this.f3734b, 0, 0, false);
            }
        }
    }

    public void V(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3729a;
        if (fragment2 != null) {
            jl jlVarU = fragment2.u();
            if (jlVarU instanceof yl) {
                ((yl) jlVarU).V(fragment, true);
            }
        }
        for (tl tlVar : this.f3733a) {
            if (!z || tlVar.f3040a) {
                tlVar.f7511a.n(this, fragment);
            }
        }
    }

    public final boolean V0(String str, int i, int i2) {
        m0();
        k0(true);
        Fragment fragment = this.f3735b;
        if (fragment != null && i < 0 && str == null && fragment.o().i()) {
            return true;
        }
        boolean zW0 = W0(this.f3743h, this.i, str, i, i2);
        if (zW0) {
            this.f3737b = true;
            try {
                a1(this.f3743h, this.i);
            } finally {
                v();
            }
        }
        q1();
        h0();
        s();
        return zW0;
    }

    public boolean W(MenuItem menuItem) {
        if (this.f3734b < 1) {
            return false;
        }
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null && fragment.S0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean W0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<sk> arrayList3 = this.c;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.c.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                int size2 = this.c.size() - 1;
                while (size2 >= 0) {
                    sk skVar = this.c.get(size2);
                    if ((str != null && str.equals(skVar.w())) || (i >= 0 && i == skVar.i)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        sk skVar2 = this.c.get(size2);
                        if (str == null || !str.equals(skVar2.w())) {
                            if (i < 0 || i != skVar2.i) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.c.size() - 1) {
                return false;
            }
            for (int size3 = this.c.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.c.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void X(Menu menu) {
        if (this.f3734b < 1) {
            return;
        }
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null) {
                fragment.T0(menu);
            }
        }
    }

    public final int X0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, da<Fragment> daVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            sk skVar = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (skVar.A() && !skVar.y(arrayList, i4 + 1, i2)) {
                if (this.k == null) {
                    this.k = new ArrayList<>();
                }
                xl xlVar = new xl(skVar, zBooleanValue);
                this.k.add(xlVar);
                skVar.C(xlVar);
                if (zBooleanValue) {
                    skVar.t();
                } else {
                    skVar.u(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, skVar);
                }
                k(daVar);
            }
        }
        return i3;
    }

    public final void Y(Fragment fragment) {
        if (fragment == null || this.f3732a.get(fragment.f4267a) != fragment) {
            return;
        }
        fragment.X0();
    }

    public void Y0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f4258a == this) {
            bundle.putString(str, fragment.f4267a);
            return;
        }
        o1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void Z() {
        f0(3);
    }

    public void Z0(Fragment fragment) {
        if (h) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.c);
        }
        boolean z = !fragment.U();
        if (!fragment.i || z) {
            synchronized (this.f3736b) {
                this.f3736b.remove(fragment);
            }
            if (F0(fragment)) {
                this.f3738c = true;
            }
            fragment.f4274b = false;
            fragment.f4276c = true;
        }
    }

    @Override // a.jl
    public hm a() {
        return new sk(this);
    }

    public void a0(boolean z) {
        int size = this.f3736b.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            Fragment fragment = this.f3736b.get(size);
            if (fragment != null) {
                fragment.V0(z);
            }
        }
    }

    public final void a1(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        q0(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((hm) arrayList.get(i)).f1191b) {
                if (i2 != i) {
                    p0(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !((hm) arrayList.get(i2)).f1191b) {
                        i2++;
                    }
                }
                p0(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            p0(arrayList, arrayList2, i2, size);
        }
    }

    @Override // a.jl
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f3732a.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f3732a.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.g(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f3736b.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                Fragment fragment2 = this.f3736b.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.d;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                Fragment fragment3 = this.d.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<sk> arrayList2 = this.c;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                sk skVar = this.c.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(skVar.toString());
                skVar.r(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.e != null && (size2 = this.e.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (sk) this.e.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f != null && this.f.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f.toArray()));
            }
        }
        ArrayList<vl> arrayList3 = this.f3731a;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (vl) this.f3731a.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3724a);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3723a);
        if (this.f3729a != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3729a);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3734b);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3739d);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3740e);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3741f);
        if (this.f3738c) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3738c);
        }
    }

    public boolean b0(Menu menu) {
        if (this.f3734b < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f3736b.size(); i++) {
            Fragment fragment = this.f3736b.get(i);
            if (fragment != null && fragment.W0(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void b1(Fragment fragment) {
        if (I0()) {
            if (h) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f3722a.k(fragment) && h) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // a.jl
    public Fragment c(String str) {
        if (str != null) {
            for (int size = this.f3736b.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3736b.get(size);
                if (fragment != null && str.equals(fragment.f4275c)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f3732a.values()) {
            if (fragment2 != null && str.equals(fragment2.f4275c)) {
                return fragment2;
            }
        }
        return null;
    }

    public void c0() {
        q1();
        Y(this.f3735b);
    }

    public void c1() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                this.g.get(i).a();
            }
        }
    }

    @Override // a.jl
    public int d() {
        ArrayList<sk> arrayList = this.c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void d0() {
        this.f3739d = false;
        this.f3740e = false;
        f0(4);
    }

    public void d1(Parcelable parcelable) {
        fm next;
        if (parcelable == null) {
            return;
        }
        am amVar = (am) parcelable;
        if (amVar.f86a == null) {
            return;
        }
        for (Fragment fragment : this.f3722a.h()) {
            if (h) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<fm> it = amVar.f86a.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.f921b.equals(fragment.f4267a)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next == null) {
                if (h) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + amVar.f86a);
                }
                S0(fragment, 1, 0, 0, false);
                fragment.f4276c = true;
                S0(fragment, 0, 0, 0, false);
            } else {
                next.f918a = fragment;
                fragment.f4261a = null;
                fragment.c = 0;
                fragment.f4278e = false;
                fragment.f4274b = false;
                Fragment fragment2 = fragment.f4265a;
                fragment.f4273b = fragment2 != null ? fragment2.f4267a : null;
                fragment.f4265a = null;
                Bundle bundle = next.f920b;
                if (bundle != null) {
                    bundle.setClassLoader(this.f3724a.e().getClassLoader());
                    fragment.f4261a = next.f920b.getSparseParcelableArray("android:view_state");
                    fragment.f4260a = next.f920b;
                }
            }
        }
        this.f3732a.clear();
        for (fm fmVar : amVar.f86a) {
            if (fmVar != null) {
                Fragment fragmentQ = fmVar.q(this.f3724a.e().getClassLoader(), e());
                fragmentQ.f4258a = this;
                if (h) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentQ.f4267a + "): " + fragmentQ);
                }
                this.f3732a.put(fragmentQ.f4267a, fragmentQ);
                fmVar.f918a = null;
            }
        }
        this.f3736b.clear();
        ArrayList<String> arrayList = amVar.b;
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragment3 = this.f3732a.get(str);
                if (fragment3 == null) {
                    o1(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                    throw null;
                }
                fragment3.f4274b = true;
                if (h) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragment3);
                }
                if (this.f3736b.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.f3736b) {
                    this.f3736b.add(fragment3);
                }
            }
        }
        if (amVar.f87a != null) {
            this.c = new ArrayList<>(amVar.f87a.length);
            int i = 0;
            while (true) {
                uk[] ukVarArr = amVar.f87a;
                if (i >= ukVarArr.length) {
                    break;
                }
                sk skVarQ = ukVarArr[i].q(this);
                if (h) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + skVarQ.i + "): " + skVarQ);
                    PrintWriter printWriter = new PrintWriter(new jf("FragmentManager"));
                    skVarQ.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.c.add(skVarQ);
                int i2 = skVarQ.i;
                if (i2 >= 0) {
                    j1(i2, skVarQ);
                }
                i++;
            }
        } else {
            this.c = null;
        }
        String str2 = amVar.f85a;
        if (str2 != null) {
            Fragment fragment4 = this.f3732a.get(str2);
            this.f3735b = fragment4;
            Y(fragment4);
        }
        this.f3721a = amVar.f5619a;
    }

    @Override // a.jl
    public fl e() {
        if (super.e() == jl.b) {
            Fragment fragment = this.f3729a;
            if (fragment != null) {
                return fragment.f4258a.e();
            }
            j(new ql(this));
        }
        return super.e();
    }

    public void e0() {
        this.f3739d = false;
        this.f3740e = false;
        f0(3);
    }

    @Override // a.jl
    public List<Fragment> f() {
        List<Fragment> list;
        if (this.f3736b.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3736b) {
            list = (List) this.f3736b.clone();
        }
        return list;
    }

    public final void f0(int i) {
        try {
            this.f3737b = true;
            Q0(i, false);
            this.f3737b = false;
            m0();
        } catch (Throwable th) {
            this.f3737b = false;
            throw th;
        }
    }

    public Parcelable f1() {
        ArrayList<String> arrayList;
        int size;
        u0();
        i0();
        m0();
        this.f3739d = true;
        uk[] ukVarArr = null;
        if (this.f3732a.isEmpty()) {
            return null;
        }
        ArrayList<fm> arrayList2 = new ArrayList<>(this.f3732a.size());
        boolean z = false;
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null) {
                if (fragment.f4258a != this) {
                    o1(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                    throw null;
                }
                fm fmVar = new fm(fragment);
                arrayList2.add(fmVar);
                if (fragment.f4251a <= 0 || fmVar.f920b != null) {
                    fmVar.f920b = fragment.f4260a;
                } else {
                    fmVar.f920b = g1(fragment);
                    String str = fragment.f4273b;
                    if (str != null) {
                        Fragment fragment2 = this.f3732a.get(str);
                        if (fragment2 == null) {
                            o1(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f4273b));
                            throw null;
                        }
                        if (fmVar.f920b == null) {
                            fmVar.f920b = new Bundle();
                        }
                        Y0(fmVar.f920b, "android:target_state", fragment2);
                        int i = fragment.b;
                        if (i != 0) {
                            fmVar.f920b.putInt("android:target_req_state", i);
                        }
                    }
                }
                if (h) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fmVar.f920b);
                }
                z = true;
            }
        }
        if (!z) {
            if (h) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f3736b.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            for (Fragment fragment3 : this.f3736b) {
                arrayList.add(fragment3.f4267a);
                if (fragment3.f4258a != this) {
                    o1(new IllegalStateException("Failure saving state: active " + fragment3 + " was removed from the FragmentManager"));
                    throw null;
                }
                if (h) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.f4267a + "): " + fragment3);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<sk> arrayList3 = this.c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            ukVarArr = new uk[size];
            for (int i2 = 0; i2 < size; i2++) {
                ukVarArr[i2] = new uk(this.c.get(i2));
                if (h) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.c.get(i2));
                }
            }
        }
        am amVar = new am();
        amVar.f86a = arrayList2;
        amVar.b = arrayList;
        amVar.f87a = ukVarArr;
        Fragment fragment4 = this.f3735b;
        if (fragment4 != null) {
            amVar.f85a = fragment4.f4267a;
        }
        amVar.f5619a = this.f3721a;
        return amVar;
    }

    @Override // a.jl
    public void g() {
        j0(new wl(this, null, -1, 0), false);
    }

    public void g0() {
        this.f3740e = true;
        f0(2);
    }

    public Bundle g1(Fragment fragment) {
        if (this.f3726a == null) {
            this.f3726a = new Bundle();
        }
        fragment.Z0(this.f3726a);
        R(fragment, this.f3726a, false);
        Bundle bundle = null;
        if (!this.f3726a.isEmpty()) {
            Bundle bundle2 = this.f3726a;
            this.f3726a = null;
            bundle = bundle2;
        }
        if (fragment.f4263a != null) {
            h1(fragment);
        }
        if (fragment.f4261a != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f4261a);
        }
        if (!fragment.p) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.p);
        }
        return bundle;
    }

    @Override // a.jl
    public void h(int i, int i2) {
        if (i >= 0) {
            j0(new wl(this, null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public void h0() {
        if (this.f3742g) {
            this.f3742g = false;
            n1();
        }
    }

    public void h1(Fragment fragment) {
        if (fragment.f4270b == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.f3727a;
        if (sparseArray == null) {
            this.f3727a = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.f4270b.saveHierarchyState(this.f3727a);
        if (this.f3727a.size() > 0) {
            fragment.f4261a = this.f3727a;
            this.f3727a = null;
        }
    }

    @Override // a.jl
    public boolean i() {
        u();
        return V0(null, -1, 0);
    }

    public final void i0() {
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null) {
                if (fragment.m() != null) {
                    int I = fragment.I();
                    View viewM = fragment.m();
                    Animation animation = viewM.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewM.clearAnimation();
                    }
                    fragment.i1(null);
                    S0(fragment, I, 0, 0, false);
                } else if (fragment.n() != null) {
                    fragment.n().end();
                }
            }
        }
    }

    public void i1() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.k == null || this.k.isEmpty()) ? false : true;
            if (this.f3731a != null && this.f3731a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f3724a.f().removeCallbacks(this.f3730a);
                this.f3724a.f().post(this.f3730a);
                q1();
            }
        }
    }

    public void j0(vl vlVar, boolean z) {
        if (!z) {
            u();
        }
        synchronized (this) {
            if (!this.f3741f && this.f3724a != null) {
                if (this.f3731a == null) {
                    this.f3731a = new ArrayList<>();
                }
                this.f3731a.add(vlVar);
                i1();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void j1(int i, sk skVar) {
        synchronized (this) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            int size = this.e.size();
            if (i < size) {
                if (h) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + skVar);
                }
                this.e.set(i, skVar);
            } else {
                while (size < i) {
                    this.e.add(null);
                    if (this.f == null) {
                        this.f = new ArrayList<>();
                    }
                    if (h) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f.add(Integer.valueOf(size));
                    size++;
                }
                if (h) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + skVar);
                }
                this.e.add(skVar);
            }
        }
    }

    public final void k(da<Fragment> daVar) {
        int i = this.f3734b;
        if (i < 1) {
            return;
        }
        int iMin = Math.min(i, 3);
        int size = this.f3736b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f3736b.get(i2);
            if (fragment.f4251a < iMin) {
                S0(fragment, iMin, fragment.y(), fragment.z(), false);
                if (fragment.f4263a != null && !fragment.h && fragment.q) {
                    daVar.add(fragment);
                }
            }
        }
    }

    public final void k0(boolean z) {
        if (this.f3737b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3724a == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f3724a.f().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            u();
        }
        if (this.f3743h == null) {
            this.f3743h = new ArrayList<>();
            this.i = new ArrayList<>();
        }
        this.f3737b = true;
        try {
            q0(null, null);
        } finally {
            this.f3737b = false;
        }
    }

    public void k1(Fragment fragment, hn.b bVar) {
        if (this.f3732a.get(fragment.f4267a) == fragment && (fragment.f4252a == null || fragment.u() == this)) {
            fragment.f4253a = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void l(sk skVar) {
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(skVar);
    }

    public void l0(Fragment fragment) {
        if (!fragment.f4277d || fragment.g) {
            return;
        }
        fragment.L0(fragment.P0(fragment.f4260a), null, fragment.f4260a);
        View view = fragment.f4263a;
        if (view == null) {
            fragment.f4270b = null;
            return;
        }
        fragment.f4270b = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.h) {
            fragment.f4263a.setVisibility(8);
        }
        fragment.D0(fragment.f4263a, fragment.f4260a);
        U(fragment, fragment.f4263a, fragment.f4260a, false);
    }

    public void l1(Fragment fragment) {
        if (fragment == null || (this.f3732a.get(fragment.f4267a) == fragment && (fragment.f4252a == null || fragment.u() == this))) {
            Fragment fragment2 = this.f3735b;
            this.f3735b = fragment;
            Y(fragment2);
            Y(this.f3735b);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void m(Fragment fragment, boolean z) {
        if (h) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        K0(fragment);
        if (fragment.i) {
            return;
        }
        if (this.f3736b.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f3736b) {
            this.f3736b.add(fragment);
        }
        fragment.f4274b = true;
        fragment.f4276c = false;
        if (fragment.f4263a == null) {
            fragment.r = false;
        }
        if (F0(fragment)) {
            this.f3738c = true;
        }
        if (z) {
            R0(fragment);
        }
    }

    public boolean m0() {
        k0(true);
        boolean z = false;
        while (w0(this.f3743h, this.i)) {
            this.f3737b = true;
            try {
                a1(this.f3743h, this.i);
                v();
                z = true;
            } catch (Throwable th) {
                v();
                throw th;
            }
        }
        q1();
        h0();
        s();
        return z;
    }

    public void m1(Fragment fragment) {
        if (h) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.h) {
            fragment.h = false;
            fragment.r = !fragment.r;
        }
    }

    public void n(Fragment fragment) {
        if (I0()) {
            if (h) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.f3722a.d(fragment) && h) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public void n0(vl vlVar, boolean z) {
        if (z && (this.f3724a == null || this.f3741f)) {
            return;
        }
        k0(z);
        if (vlVar.a(this.f3743h, this.i)) {
            this.f3737b = true;
            try {
                a1(this.f3743h, this.i);
            } finally {
                v();
            }
        }
        q1();
        h0();
        s();
    }

    public void n1() {
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null) {
                U0(fragment);
            }
        }
    }

    public int o(sk skVar) {
        synchronized (this) {
            if (this.f != null && this.f.size() > 0) {
                int iIntValue = this.f.remove(this.f.size() - 1).intValue();
                if (h) {
                    Log.v("FragmentManager", "Adding back stack index " + iIntValue + " with " + skVar);
                }
                this.e.set(iIntValue, skVar);
                return iIntValue;
            }
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            int size = this.e.size();
            if (h) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + skVar);
            }
            this.e.add(skVar);
            return size;
        }
    }

    public final void o1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new jf("FragmentManager"));
        gl glVar = this.f3724a;
        try {
            if (glVar != null) {
                glVar.h("  ", null, printWriter, new String[0]);
            } else {
                b("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e) {
            Log.e("FragmentManager", "Failed dumping state", e);
            throw runtimeException;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ul.f7608a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !fl.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment fragmentR0 = resourceId != -1 ? r0(resourceId) : null;
        if (fragmentR0 == null && string != null) {
            fragmentR0 = c(string);
        }
        if (fragmentR0 == null && id != -1) {
            fragmentR0 = r0(id);
        }
        if (h) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentR0);
        }
        if (fragmentR0 == null) {
            fragmentR0 = e().a(context.getClassLoader(), str2);
            fragmentR0.f4277d = true;
            fragmentR0.d = resourceId != 0 ? resourceId : id;
            fragmentR0.e = id;
            fragmentR0.f4275c = string;
            fragmentR0.f4278e = true;
            fragmentR0.f4258a = this;
            gl glVar = this.f3724a;
            fragmentR0.f4252a = glVar;
            fragmentR0.q0(glVar.e(), attributeSet, fragmentR0.f4260a);
            m(fragmentR0, true);
        } else {
            if (fragmentR0.f4278e) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            fragmentR0.f4278e = true;
            gl glVar2 = this.f3724a;
            fragmentR0.f4252a = glVar2;
            fragmentR0.q0(glVar2.e(), attributeSet, fragmentR0.f4260a);
        }
        Fragment fragment = fragmentR0;
        if (this.f3734b >= 1 || !fragment.f4277d) {
            R0(fragment);
        } else {
            S0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.f4263a;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.f4263a.getTag() == null) {
                fragment.f4263a.setTag(string);
            }
            return fragment.f4263a;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public final void p(Fragment fragment, rl rlVar, int i) {
        View view = fragment.f4263a;
        ViewGroup viewGroup = fragment.f4264a;
        viewGroup.startViewTransition(view);
        fragment.q1(i);
        if (rlVar.f2749a != null) {
            sl slVar = new sl(rlVar.f2749a, viewGroup, view);
            fragment.i1(fragment.f4263a);
            slVar.setAnimationListener(new nl(this, viewGroup, fragment));
            fragment.f4263a.startAnimation(slVar);
            return;
        }
        Animator animator = rlVar.f7311a;
        fragment.j1(animator);
        animator.addListener(new ol(this, viewGroup, view, fragment));
        animator.setTarget(fragment.f4263a);
        animator.start();
    }

    public final void p0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = ((hm) arrayList.get(i5)).f1191b;
        ArrayList<Fragment> arrayList3 = this.j;
        if (arrayList3 == null) {
            this.j = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.j.addAll(this.f3736b);
        Fragment fragmentA0 = A0();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            sk skVar = arrayList.get(i6);
            fragmentA0 = !arrayList2.get(i6).booleanValue() ? skVar.v(this.j, fragmentA0) : skVar.D(this.j, fragmentA0);
            z2 = z2 || ((hm) skVar).f1188a;
        }
        this.j.clear();
        if (!z) {
            nm.C(this, arrayList, arrayList2, i, i2, false);
        }
        o0(arrayList, arrayList2, i, i2);
        if (z) {
            da<Fragment> daVar = new da<>();
            k(daVar);
            int iX0 = X0(arrayList, arrayList2, i, i2, daVar);
            O0(daVar);
            i3 = iX0;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            nm.C(this, arrayList, arrayList2, i, i3, true);
            Q0(this.f3734b, true);
        }
        while (i5 < i2) {
            sk skVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = skVar2.i) >= 0) {
                v0(i4);
                skVar2.i = -1;
            }
            skVar2.B();
            i5++;
        }
        if (z2) {
            c1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void q(gl glVar, dl dlVar, Fragment fragment) {
        if (this.f3724a != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3724a = glVar;
        this.f3723a = dlVar;
        this.f3729a = fragment;
        if (fragment != null) {
            q1();
        }
        if (glVar instanceof s) {
            s sVar = (s) glVar;
            this.f3728a = sVar.getOnBackPressedDispatcher();
            kn knVar = sVar;
            if (fragment != null) {
                knVar = fragment;
            }
            this.f3728a.a(knVar, this.f3725a);
        }
        this.f3722a = fragment != null ? fragment.f4258a.x0(fragment) : glVar instanceof yn ? cm.g(((yn) glVar).getViewModelStore()) : new cm(false);
    }

    public final void q0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<xl> arrayList3 = this.k;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            xl xlVar = this.k.get(i);
            if (arrayList == null || xlVar.f3601a || (iIndexOf2 = arrayList.indexOf(xlVar.f3600a)) == -1 || !arrayList2.get(iIndexOf2).booleanValue()) {
                if (xlVar.e() || (arrayList != null && xlVar.f3600a.y(arrayList, 0, arrayList.size()))) {
                    this.k.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || xlVar.f3601a || (iIndexOf = arrayList.indexOf(xlVar.f3600a)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                        xlVar.d();
                    }
                }
                i++;
            } else {
                this.k.remove(i);
                i--;
                size--;
            }
            xlVar.c();
            i++;
        }
    }

    public final void q1() {
        ArrayList<vl> arrayList = this.f3731a;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f3725a.f(d() > 0 && G0(this.f3729a));
        } else {
            this.f3725a.f(true);
        }
    }

    public void r(Fragment fragment) {
        if (h) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.i) {
            fragment.i = false;
            if (fragment.f4274b) {
                return;
            }
            if (this.f3736b.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (h) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f3736b) {
                this.f3736b.add(fragment);
            }
            fragment.f4274b = true;
            if (F0(fragment)) {
                this.f3738c = true;
            }
        }
    }

    public Fragment r0(int i) {
        for (int size = this.f3736b.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3736b.get(size);
            if (fragment != null && fragment.d == i) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f3732a.values()) {
            if (fragment2 != null && fragment2.d == i) {
                return fragment2;
            }
        }
        return null;
    }

    public final void s() {
        this.f3732a.values().removeAll(Collections.singleton(null));
    }

    public Fragment s0(String str) {
        Fragment fragmentI;
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null && (fragmentI = fragment.i(str)) != null) {
                return fragmentI;
            }
        }
        return null;
    }

    public boolean t() {
        boolean zF0 = false;
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null) {
                zF0 = F0(fragment);
            }
            if (zF0) {
                return true;
            }
        }
        return false;
    }

    public final Fragment t0(Fragment fragment) {
        ViewGroup viewGroup = fragment.f4264a;
        View view = fragment.f4263a;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f3736b.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.f3736b.get(iIndexOf);
                if (fragment2.f4264a == viewGroup && fragment2.f4263a != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f3729a;
        if (obj == null) {
            obj = this.f3724a;
        }
        Cif.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public final void u() {
        if (I0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final void u0() {
        if (this.k != null) {
            while (!this.k.isEmpty()) {
                this.k.remove(0).d();
            }
        }
    }

    public final void v() {
        this.f3737b = false;
        this.i.clear();
        this.f3743h.clear();
    }

    public void v0(int i) {
        synchronized (this) {
            this.e.set(i, null);
            if (this.f == null) {
                this.f = new ArrayList<>();
            }
            if (h) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f.add(Integer.valueOf(i));
        }
    }

    public void w(sk skVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            skVar.u(z3);
        } else {
            skVar.t();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(skVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            nm.C(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            Q0(this.f3734b, true);
        }
        for (Fragment fragment : this.f3732a.values()) {
            if (fragment != null && fragment.f4263a != null && fragment.q && skVar.x(fragment.e)) {
                float f = fragment.f4250a;
                if (f > 0.0f) {
                    fragment.f4263a.setAlpha(f);
                }
                if (z3) {
                    fragment.f4250a = 0.0f;
                } else {
                    fragment.f4250a = -1.0f;
                    fragment.q = false;
                }
            }
        }
    }

    public final boolean w0(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f3731a != null && this.f3731a.size() != 0) {
                int size = this.f3731a.size();
                boolean zA = false;
                for (int i = 0; i < size; i++) {
                    zA |= this.f3731a.get(i).a(arrayList, arrayList2);
                }
                this.f3731a.clear();
                this.f3724a.f().removeCallbacks(this.f3730a);
                return zA;
            }
            return false;
        }
    }

    public void x(Fragment fragment) {
        Animator animator;
        if (fragment.f4263a != null) {
            rl rlVarJ0 = J0(fragment, fragment.z(), !fragment.h, fragment.A());
            if (rlVarJ0 == null || (animator = rlVarJ0.f7311a) == null) {
                if (rlVarJ0 != null) {
                    fragment.f4263a.startAnimation(rlVarJ0.f2749a);
                    rlVarJ0.f2749a.start();
                }
                fragment.f4263a.setVisibility((!fragment.h || fragment.T()) ? 0 : 8);
                if (fragment.T()) {
                    fragment.l1(false);
                }
            } else {
                animator.setTarget(fragment.f4263a);
                if (!fragment.h) {
                    fragment.f4263a.setVisibility(0);
                } else if (fragment.T()) {
                    fragment.l1(false);
                } else {
                    ViewGroup viewGroup = fragment.f4264a;
                    View view = fragment.f4263a;
                    viewGroup.startViewTransition(view);
                    rlVarJ0.f7311a.addListener(new pl(this, viewGroup, view, fragment));
                }
                rlVarJ0.f7311a.start();
            }
        }
        if (fragment.f4274b && F0(fragment)) {
            this.f3738c = true;
        }
        fragment.r = false;
        fragment.o0(fragment.h);
    }

    public cm x0(Fragment fragment) {
        return this.f3722a.f(fragment);
    }

    public void y(Fragment fragment) {
        if (h) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.i) {
            return;
        }
        fragment.i = true;
        if (fragment.f4274b) {
            if (h) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f3736b) {
                this.f3736b.remove(fragment);
            }
            if (F0(fragment)) {
                this.f3738c = true;
            }
            fragment.f4274b = false;
        }
    }

    public Fragment y0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f3732a.get(string);
        if (fragment != null) {
            return fragment;
        }
        o1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public void z() {
        this.f3739d = false;
        this.f3740e = false;
        f0(2);
    }

    public LayoutInflater.Factory2 z0() {
        return this;
    }
}
