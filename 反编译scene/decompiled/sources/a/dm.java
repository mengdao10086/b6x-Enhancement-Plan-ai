package a;

import a.hn;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class dm extends ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hm f580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final jl f581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f582a;

    @Deprecated
    public dm(jl jlVar) {
        this(jlVar, 0);
    }

    public dm(jl jlVar, int i) {
        this.f580a = null;
        this.f582a = null;
        this.f581a = jlVar;
        this.f5914a = i;
    }

    public static String s(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // a.ku
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f580a == null) {
            this.f580a = this.f581a.a();
        }
        this.f580a.i(fragment);
        if (fragment == this.f582a) {
            this.f582a = null;
        }
    }

    @Override // a.ku
    public void b(ViewGroup viewGroup) {
        hm hmVar = this.f580a;
        if (hmVar != null) {
            hmVar.h();
            this.f580a = null;
        }
    }

    @Override // a.ku
    public Object g(ViewGroup viewGroup, int i) {
        if (this.f580a == null) {
            this.f580a = this.f581a.a();
        }
        long jR = r(i);
        Fragment fragmentC = this.f581a.c(s(viewGroup.getId(), jR));
        if (fragmentC != null) {
            this.f580a.e(fragmentC);
        } else {
            fragmentC = q(i);
            this.f580a.b(viewGroup.getId(), fragmentC, s(viewGroup.getId(), jR));
        }
        if (fragmentC != this.f582a) {
            fragmentC.m1(false);
            if (this.f5914a == 1) {
                this.f580a.o(fragmentC, hn.b.STARTED);
            } else {
                fragmentC.r1(false);
            }
        }
        return fragmentC;
    }

    @Override // a.ku
    public boolean h(View view, Object obj) {
        return ((Fragment) obj).M() == view;
    }

    @Override // a.ku
    public void k(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // a.ku
    public Parcelable l() {
        return null;
    }

    @Override // a.ku
    public void m(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f582a;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.m1(false);
                if (this.f5914a == 1) {
                    if (this.f580a == null) {
                        this.f580a = this.f581a.a();
                    }
                    this.f580a.o(this.f582a, hn.b.STARTED);
                } else {
                    this.f582a.r1(false);
                }
            }
            fragment.m1(true);
            if (this.f5914a == 1) {
                if (this.f580a == null) {
                    this.f580a = this.f581a.a();
                }
                this.f580a.o(fragment, hn.b.RESUMED);
            } else {
                fragment.r1(true);
            }
            this.f582a = fragment;
        }
    }

    @Override // a.ku
    public void o(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment q(int i);

    public long r(int i) {
        return i;
    }
}
