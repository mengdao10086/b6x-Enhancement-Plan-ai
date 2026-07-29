package p4;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import g.i1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class o extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f46368g = "RMFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p4.a f46369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f46370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<o> f46371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public com.bumptech.glide.i f46372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public o f46373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public Fragment f46374f;

    public class a implements q {
        public a() {
        }

        @Override // p4.q
        @n0
        public Set<com.bumptech.glide.i> a() {
            Set<o> setB = o.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (o oVar : setB) {
                if (oVar.e() != null) {
                    hashSet.add(oVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + zc.a.f58317e;
        }
    }

    public o() {
        this(new p4.a());
    }

    public final void a(o oVar) {
        this.f46371c.add(oVar);
    }

    @TargetApi(17)
    @n0
    public Set<o> b() {
        if (equals(this.f46373e)) {
            return Collections.unmodifiableSet(this.f46371c);
        }
        if (this.f46373e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (o oVar : this.f46373e.b()) {
            if (g(oVar.getParentFragment())) {
                hashSet.add(oVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @n0
    public p4.a c() {
        return this.f46369a;
    }

    @p0
    @TargetApi(17)
    public final Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f46374f;
    }

    @p0
    public com.bumptech.glide.i e() {
        return this.f46372d;
    }

    @n0
    public q f() {
        return this.f46370b;
    }

    @TargetApi(17)
    public final boolean g(@n0 Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void h(@n0 Activity activity) {
        l();
        o oVarQ = com.bumptech.glide.b.e(activity).o().q(activity);
        this.f46373e = oVarQ;
        if (equals(oVarQ)) {
            return;
        }
        this.f46373e.a(this);
    }

    public final void i(o oVar) {
        this.f46371c.remove(oVar);
    }

    public void j(@p0 Fragment fragment) {
        this.f46374f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@p0 com.bumptech.glide.i iVar) {
        this.f46372d = iVar;
    }

    public final void l() {
        o oVar = this.f46373e;
        if (oVar != null) {
            oVar.i(this);
            this.f46373e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f46369a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f46369a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f46369a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + zc.a.f58317e;
    }

    @i1
    @SuppressLint({"ValidFragment"})
    public o(@n0 p4.a aVar) {
        this.f46370b = new a();
        this.f46371c = new HashSet();
        this.f46369a = aVar;
    }
}
