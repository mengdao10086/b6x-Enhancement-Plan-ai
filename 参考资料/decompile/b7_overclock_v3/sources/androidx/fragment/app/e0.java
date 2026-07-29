package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import g.p0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class e0 extends k2.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5916h = "FragmentStatePagerAdapt";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f5917i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final int f5918j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5919k = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f5920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f5922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f5923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f5924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f5925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5926g;

    @Deprecated
    public e0(@g.n0 FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @g.n0
    public abstract Fragment a(int i10);

    @Override // k2.a
    public void destroyItem(@g.n0 ViewGroup viewGroup, int i10, @g.n0 Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f5922c == null) {
            this.f5922c = this.f5920a.u();
        }
        while (this.f5923d.size() <= i10) {
            this.f5923d.add(null);
        }
        this.f5923d.set(i10, fragment.s3() ? this.f5920a.T1(fragment) : null);
        this.f5924e.set(i10, null);
        this.f5922c.B(fragment);
        if (fragment.equals(this.f5925f)) {
            this.f5925f = null;
        }
    }

    @Override // k2.a
    public void finishUpdate(@g.n0 ViewGroup viewGroup) {
        g0 g0Var = this.f5922c;
        if (g0Var != null) {
            if (!this.f5926g) {
                try {
                    this.f5926g = true;
                    g0Var.t();
                } finally {
                    this.f5926g = false;
                }
            }
            this.f5922c = null;
        }
    }

    @Override // k2.a
    @g.n0
    public Object instantiateItem(@g.n0 ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f5924e.size() > i10 && (fragment = this.f5924e.get(i10)) != null) {
            return fragment;
        }
        if (this.f5922c == null) {
            this.f5922c = this.f5920a.u();
        }
        Fragment fragmentA = a(i10);
        if (this.f5923d.size() > i10 && (savedState = this.f5923d.get(i10)) != null) {
            fragmentA.j5(savedState);
        }
        while (this.f5924e.size() <= i10) {
            this.f5924e.add(null);
        }
        fragmentA.k5(false);
        if (this.f5921b == 0) {
            fragmentA.v5(false);
        }
        this.f5924e.set(i10, fragmentA);
        this.f5922c.f(viewGroup.getId(), fragmentA);
        if (this.f5921b == 1) {
            this.f5922c.O(fragmentA, Lifecycle.State.STARTED);
        }
        return fragmentA;
    }

    @Override // k2.a
    public boolean isViewFromObject(@g.n0 View view, @g.n0 Object obj) {
        return ((Fragment) obj).k3() == view;
    }

    @Override // k2.a
    public void restoreState(@p0 Parcelable parcelable, @p0 ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f5923d.clear();
            this.f5924e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f5923d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i10 = Integer.parseInt(str.substring(1));
                    Fragment fragmentE0 = this.f5920a.E0(bundle, str);
                    if (fragmentE0 != null) {
                        while (this.f5924e.size() <= i10) {
                            this.f5924e.add(null);
                        }
                        fragmentE0.k5(false);
                        this.f5924e.set(i10, fragmentE0);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bad fragment at key ");
                        sb2.append(str);
                    }
                }
            }
        }
    }

    @Override // k2.a
    @p0
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f5923d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f5923d.size()];
            this.f5923d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f5924e.size(); i10++) {
            Fragment fragment = this.f5924e.get(i10);
            if (fragment != null && fragment.s3()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f5920a.A1(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // k2.a
    public void setPrimaryItem(@g.n0 ViewGroup viewGroup, int i10, @g.n0 Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f5925f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.k5(false);
                if (this.f5921b == 1) {
                    if (this.f5922c == null) {
                        this.f5922c = this.f5920a.u();
                    }
                    this.f5922c.O(this.f5925f, Lifecycle.State.STARTED);
                } else {
                    this.f5925f.v5(false);
                }
            }
            fragment.k5(true);
            if (this.f5921b == 1) {
                if (this.f5922c == null) {
                    this.f5922c = this.f5920a.u();
                }
                this.f5922c.O(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.v5(true);
            }
            this.f5925f = fragment;
        }
    }

    @Override // k2.a
    public void startUpdate(@g.n0 ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public e0(@g.n0 FragmentManager fragmentManager, int i10) {
        this.f5922c = null;
        this.f5923d = new ArrayList<>();
        this.f5924e = new ArrayList<>();
        this.f5925f = null;
        this.f5920a = fragmentManager;
        this.f5921b = i10;
    }
}
