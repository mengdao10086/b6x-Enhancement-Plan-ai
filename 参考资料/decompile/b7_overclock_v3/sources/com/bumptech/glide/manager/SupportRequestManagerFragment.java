package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import g.i1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p4.q;

/* JADX INFO: loaded from: classes2.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final String f12675i8 = "SupportRMFragment";

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public final p4.a f12676c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public final q f12677d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public final Set<SupportRequestManagerFragment> f12678e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    @p0
    public SupportRequestManagerFragment f12679f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    @p0
    public i f12680g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    @p0
    public Fragment f12681h8;

    public class a implements q {
        public a() {
        }

        @Override // p4.q
        @n0
        public Set<i> a() {
            Set<SupportRequestManagerFragment> setF5 = SupportRequestManagerFragment.this.F5();
            HashSet hashSet = new HashSet(setF5.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : setF5) {
                if (supportRequestManagerFragment.I5() != null) {
                    hashSet.add(supportRequestManagerFragment.I5());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + zc.a.f58317e;
        }
    }

    public SupportRequestManagerFragment() {
        this(new p4.a());
    }

    @p0
    public static FragmentManager K5(@n0 Fragment fragment) {
        while (fragment.J2() != null) {
            fragment = fragment.J2();
        }
        return fragment.t2();
    }

    public final void E5(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f12678e8.add(supportRequestManagerFragment);
    }

    @n0
    public Set<SupportRequestManagerFragment> F5() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f12679f8;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f12678e8);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f12679f8.F5()) {
            if (L5(supportRequestManagerFragment2.H5())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @n0
    public p4.a G5() {
        return this.f12676c8;
    }

    @Override // androidx.fragment.app.Fragment
    public void H3(Context context) {
        super.H3(context);
        FragmentManager fragmentManagerK5 = K5(this);
        if (fragmentManagerK5 == null) {
            return;
        }
        try {
            M5(X1(), fragmentManagerK5);
        } catch (IllegalStateException unused) {
        }
    }

    @p0
    public final Fragment H5() {
        Fragment fragmentJ2 = J2();
        return fragmentJ2 != null ? fragmentJ2 : this.f12681h8;
    }

    @p0
    public i I5() {
        return this.f12680g8;
    }

    @n0
    public q J5() {
        return this.f12677d8;
    }

    public final boolean L5(@n0 Fragment fragment) {
        Fragment fragmentH5 = H5();
        while (true) {
            Fragment fragmentJ2 = fragment.J2();
            if (fragmentJ2 == null) {
                return false;
            }
            if (fragmentJ2.equals(fragmentH5)) {
                return true;
            }
            fragment = fragment.J2();
        }
    }

    public final void M5(@n0 Context context, @n0 FragmentManager fragmentManager) {
        Q5();
        SupportRequestManagerFragment supportRequestManagerFragmentS = b.e(context).o().s(fragmentManager);
        this.f12679f8 = supportRequestManagerFragmentS;
        if (equals(supportRequestManagerFragmentS)) {
            return;
        }
        this.f12679f8.E5(this);
    }

    public final void N5(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f12678e8.remove(supportRequestManagerFragment);
    }

    public void O5(@p0 Fragment fragment) {
        FragmentManager fragmentManagerK5;
        this.f12681h8 = fragment;
        if (fragment == null || fragment.X1() == null || (fragmentManagerK5 = K5(fragment)) == null) {
            return;
        }
        M5(fragment.X1(), fragmentManagerK5);
    }

    @Override // androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        this.f12676c8.c();
        Q5();
    }

    public void P5(@p0 i iVar) {
        this.f12680g8 = iVar;
    }

    public final void Q5() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f12679f8;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.N5(this);
            this.f12679f8 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void S3() {
        super.S3();
        this.f12681h8 = null;
        Q5();
    }

    @Override // androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        this.f12676c8.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        this.f12676c8.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + H5() + zc.a.f58317e;
    }

    @i1
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@n0 p4.a aVar) {
        this.f12677d8 = new a();
        this.f12678e8 = new HashSet();
        this.f12676c8 = aVar;
    }
}
