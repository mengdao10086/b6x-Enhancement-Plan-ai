package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class a0 extends k2.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5844f = "FragmentPagerAdapter";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f5845g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f5846h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5847i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f5850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f5851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5852e;

    @Deprecated
    public a0(@g.n0 FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public static String c(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    @g.n0
    public abstract Fragment a(int i10);

    public long b(int i10) {
        return i10;
    }

    @Override // k2.a
    public void destroyItem(@g.n0 ViewGroup viewGroup, int i10, @g.n0 Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f5850c == null) {
            this.f5850c = this.f5848a.u();
        }
        this.f5850c.v(fragment);
        if (fragment.equals(this.f5851d)) {
            this.f5851d = null;
        }
    }

    @Override // k2.a
    public void finishUpdate(@g.n0 ViewGroup viewGroup) {
        g0 g0Var = this.f5850c;
        if (g0Var != null) {
            if (!this.f5852e) {
                try {
                    this.f5852e = true;
                    g0Var.t();
                } finally {
                    this.f5852e = false;
                }
            }
            this.f5850c = null;
        }
    }

    @Override // k2.a
    @g.n0
    public Object instantiateItem(@g.n0 ViewGroup viewGroup, int i10) {
        if (this.f5850c == null) {
            this.f5850c = this.f5848a.u();
        }
        long jB = b(i10);
        Fragment fragmentS0 = this.f5848a.s0(c(viewGroup.getId(), jB));
        if (fragmentS0 != null) {
            this.f5850c.p(fragmentS0);
        } else {
            fragmentS0 = a(i10);
            this.f5850c.g(viewGroup.getId(), fragmentS0, c(viewGroup.getId(), jB));
        }
        if (fragmentS0 != this.f5851d) {
            fragmentS0.k5(false);
            if (this.f5849b == 1) {
                this.f5850c.O(fragmentS0, Lifecycle.State.STARTED);
            } else {
                fragmentS0.v5(false);
            }
        }
        return fragmentS0;
    }

    @Override // k2.a
    public boolean isViewFromObject(@g.n0 View view, @g.n0 Object obj) {
        return ((Fragment) obj).k3() == view;
    }

    @Override // k2.a
    public void restoreState(@p0 Parcelable parcelable, @p0 ClassLoader classLoader) {
    }

    @Override // k2.a
    @p0
    public Parcelable saveState() {
        return null;
    }

    @Override // k2.a
    public void setPrimaryItem(@g.n0 ViewGroup viewGroup, int i10, @g.n0 Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f5851d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.k5(false);
                if (this.f5849b == 1) {
                    if (this.f5850c == null) {
                        this.f5850c = this.f5848a.u();
                    }
                    this.f5850c.O(this.f5851d, Lifecycle.State.STARTED);
                } else {
                    this.f5851d.v5(false);
                }
            }
            fragment.k5(true);
            if (this.f5849b == 1) {
                if (this.f5850c == null) {
                    this.f5850c = this.f5848a.u();
                }
                this.f5850c.O(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.v5(true);
            }
            this.f5851d = fragment;
        }
    }

    @Override // k2.a
    public void startUpdate(@g.n0 ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public a0(@g.n0 FragmentManager fragmentManager, int i10) {
        this.f5850c = null;
        this.f5851d = null;
        this.f5848a = fragmentManager;
        this.f5849b = i10;
    }
}
