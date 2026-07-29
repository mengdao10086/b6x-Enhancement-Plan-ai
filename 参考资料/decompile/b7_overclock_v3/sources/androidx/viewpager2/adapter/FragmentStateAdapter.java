package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.h;
import androidx.core.util.o;
import androidx.core.view.u0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g;
import androidx.fragment.app.g0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import g.i;
import g.n0;
import g.p0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentStateAdapter extends RecyclerView.g<androidx.viewpager2.adapter.a> implements androidx.viewpager2.adapter.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8156i = "f#";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8157j = "s#";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f8158k = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f8159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<Fragment> f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h<Fragment.SavedState> f8162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h<Integer> f8163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentMaxLifecycleEnforcer f8164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8166h;

    public class FragmentMaxLifecycleEnforcer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewPager2.j f8172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.i f8173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v f8174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewPager2 f8175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8176e = -1;

        public class a extends ViewPager2.j {
            public a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.j
            public void a(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.j
            public void c(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        public class b extends d {
            public b() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.d, androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        @n0
        public final ViewPager2 a(@n0 RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(@n0 RecyclerView recyclerView) {
            this.f8175d = a(recyclerView);
            a aVar = new a();
            this.f8172a = aVar;
            this.f8175d.n(aVar);
            b bVar = new b();
            this.f8173b = bVar;
            FragmentStateAdapter.this.registerAdapterDataObserver(bVar);
            v vVar = new v() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.v
                public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f8174c = vVar;
            FragmentStateAdapter.this.f8159a.a(vVar);
        }

        public void c(@n0 RecyclerView recyclerView) {
            a(recyclerView).x(this.f8172a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f8173b);
            FragmentStateAdapter.this.f8159a.d(this.f8174c);
            this.f8175d = null;
        }

        public void d(boolean z10) {
            int currentItem;
            Fragment fragmentH;
            if (FragmentStateAdapter.this.E() || this.f8175d.getScrollState() != 0 || FragmentStateAdapter.this.f8161c.l() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.f8175d.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f8176e || z10) && (fragmentH = FragmentStateAdapter.this.f8161c.h(itemId)) != null && fragmentH.s3()) {
                this.f8176e = itemId;
                g0 g0VarU = FragmentStateAdapter.this.f8160b.u();
                Fragment fragment = null;
                for (int i10 = 0; i10 < FragmentStateAdapter.this.f8161c.w(); i10++) {
                    long jM = FragmentStateAdapter.this.f8161c.m(i10);
                    Fragment fragmentX = FragmentStateAdapter.this.f8161c.x(i10);
                    if (fragmentX.s3()) {
                        if (jM != this.f8176e) {
                            g0VarU.O(fragmentX, Lifecycle.State.STARTED);
                        } else {
                            fragment = fragmentX;
                        }
                        fragmentX.k5(jM == this.f8176e);
                    }
                }
                if (fragment != null) {
                    g0VarU.O(fragment, Lifecycle.State.RESUMED);
                }
                if (g0VarU.A()) {
                    return;
                }
                g0VarU.s();
            }
        }
    }

    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f8181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.viewpager2.adapter.a f8182b;

        public a(FrameLayout frameLayout, androidx.viewpager2.adapter.a aVar) {
            this.f8181a = frameLayout;
            this.f8182b = aVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (this.f8181a.getParent() != null) {
                this.f8181a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.A(this.f8182b);
            }
        }
    }

    public class b extends FragmentManager.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f8184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f8185b;

        public b(Fragment fragment, FrameLayout frameLayout) {
            this.f8184a = fragment;
            this.f8185b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void m(@n0 FragmentManager fragmentManager, @n0 Fragment fragment, @n0 View view, @p0 Bundle bundle) {
            if (fragment == this.f8184a) {
                fragmentManager.f2(this);
                FragmentStateAdapter.this.l(view, this.f8185b);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f8165g = false;
            fragmentStateAdapter.q();
        }
    }

    public static abstract class d extends RecyclerView.i {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i10, int i11, @p0 Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void f(int i10, int i11) {
            a();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public FragmentStateAdapter(@n0 g gVar) {
        this(gVar.n3(), gVar.e());
    }

    @n0
    public static String o(@n0 String str, long j10) {
        return str + j10;
    }

    public static boolean s(@n0 String str, @n0 String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    public static long z(@n0 String str, @n0 String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    public void A(@n0 final androidx.viewpager2.adapter.a aVar) {
        Fragment fragmentH = this.f8161c.h(aVar.getItemId());
        if (fragmentH == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutI = aVar.i();
        View viewK3 = fragmentH.k3();
        if (!fragmentH.s3() && viewK3 != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragmentH.s3() && viewK3 == null) {
            D(fragmentH, frameLayoutI);
            return;
        }
        if (fragmentH.s3() && viewK3.getParent() != null) {
            if (viewK3.getParent() != frameLayoutI) {
                l(viewK3, frameLayoutI);
                return;
            }
            return;
        }
        if (fragmentH.s3()) {
            l(viewK3, frameLayoutI);
            return;
        }
        if (E()) {
            if (this.f8160b.V0()) {
                return;
            }
            this.f8159a.a(new v() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.v
                public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.E()) {
                        return;
                    }
                    yVar.e().d(this);
                    if (u0.O0(aVar.i())) {
                        FragmentStateAdapter.this.A(aVar);
                    }
                }
            });
            return;
        }
        D(fragmentH, frameLayoutI);
        this.f8160b.u().k(fragmentH, "f" + aVar.getItemId()).O(fragmentH, Lifecycle.State.STARTED).s();
        this.f8164f.d(false);
    }

    public final void B(long j10) {
        ViewParent parent;
        Fragment fragmentH = this.f8161c.h(j10);
        if (fragmentH == null) {
            return;
        }
        if (fragmentH.k3() != null && (parent = fragmentH.k3().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!m(j10)) {
            this.f8162d.q(j10);
        }
        if (!fragmentH.s3()) {
            this.f8161c.q(j10);
            return;
        }
        if (E()) {
            this.f8166h = true;
            return;
        }
        if (fragmentH.s3() && m(j10)) {
            this.f8162d.n(j10, this.f8160b.T1(fragmentH));
        }
        this.f8160b.u().B(fragmentH).s();
        this.f8161c.q(j10);
    }

    public final void C() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.f8159a.a(new v() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.v
            public void c(@n0 y yVar, @n0 Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    yVar.e().d(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000L);
    }

    public final void D(Fragment fragment, @n0 FrameLayout frameLayout) {
        this.f8160b.B1(new b(fragment, frameLayout), false);
    }

    public boolean E() {
        return this.f8160b.d1();
    }

    @Override // androidx.viewpager2.adapter.b
    @n0
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f8161c.w() + this.f8162d.w());
        for (int i10 = 0; i10 < this.f8161c.w(); i10++) {
            long jM = this.f8161c.m(i10);
            Fragment fragmentH = this.f8161c.h(jM);
            if (fragmentH != null && fragmentH.s3()) {
                this.f8160b.A1(bundle, o(f8156i, jM), fragmentH);
            }
        }
        for (int i11 = 0; i11 < this.f8162d.w(); i11++) {
            long jM2 = this.f8162d.m(i11);
            if (m(jM2)) {
                bundle.putParcelable(o(f8157j, jM2), this.f8162d.h(jM2));
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager2.adapter.b
    public final void d(@n0 Parcelable parcelable) {
        if (!this.f8162d.l() || !this.f8161c.l()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (s(str, f8156i)) {
                this.f8161c.n(z(str, f8156i), this.f8160b.E0(bundle, str));
            } else {
                if (!s(str, f8157j)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jZ = z(str, f8157j);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (m(jZ)) {
                    this.f8162d.n(jZ, savedState);
                }
            }
        }
        if (this.f8161c.l()) {
            return;
        }
        this.f8166h = true;
        this.f8165g = true;
        q();
        C();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        return i10;
    }

    public void l(@n0 View view, @n0 FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean m(long j10) {
        return j10 >= 0 && j10 < ((long) getItemCount());
    }

    @n0
    public abstract Fragment n(int i10);

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @i
    public void onAttachedToRecyclerView(@n0 RecyclerView recyclerView) {
        o.a(this.f8164f == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f8164f = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @i
    public void onDetachedFromRecyclerView(@n0 RecyclerView recyclerView) {
        this.f8164f.c(recyclerView);
        this.f8164f = null;
    }

    public final void p(int i10) {
        long itemId = getItemId(i10);
        if (this.f8161c.d(itemId)) {
            return;
        }
        Fragment fragmentN = n(i10);
        fragmentN.j5(this.f8162d.h(itemId));
        this.f8161c.n(itemId, fragmentN);
    }

    public void q() {
        if (!this.f8166h || E()) {
            return;
        }
        androidx.collection.c cVar = new androidx.collection.c();
        for (int i10 = 0; i10 < this.f8161c.w(); i10++) {
            long jM = this.f8161c.m(i10);
            if (!m(jM)) {
                cVar.add(Long.valueOf(jM));
                this.f8163e.q(jM);
            }
        }
        if (!this.f8165g) {
            this.f8166h = false;
            for (int i11 = 0; i11 < this.f8161c.w(); i11++) {
                long jM2 = this.f8161c.m(i11);
                if (!r(jM2)) {
                    cVar.add(Long.valueOf(jM2));
                }
            }
        }
        Iterator<E> it2 = cVar.iterator();
        while (it2.hasNext()) {
            B(((Long) it2.next()).longValue());
        }
    }

    public final boolean r(long j10) {
        View viewK3;
        if (this.f8163e.d(j10)) {
            return true;
        }
        Fragment fragmentH = this.f8161c.h(j10);
        return (fragmentH == null || (viewK3 = fragmentH.k3()) == null || viewK3.getParent() == null) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public final Long t(int i10) {
        Long lValueOf = null;
        for (int i11 = 0; i11 < this.f8163e.w(); i11++) {
            if (this.f8163e.x(i11).intValue() == i10) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.f8163e.m(i11));
            }
        }
        return lValueOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(@n0 androidx.viewpager2.adapter.a aVar, int i10) {
        long itemId = aVar.getItemId();
        int id2 = aVar.i().getId();
        Long lT = t(id2);
        if (lT != null && lT.longValue() != itemId) {
            B(lT.longValue());
            this.f8163e.q(lT.longValue());
        }
        this.f8163e.n(itemId, Integer.valueOf(id2));
        p(i10);
        FrameLayout frameLayoutI = aVar.i();
        if (u0.O0(frameLayoutI)) {
            if (frameLayoutI.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutI.addOnLayoutChangeListener(new a(frameLayoutI, aVar));
        }
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @n0
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.a onCreateViewHolder(@n0 ViewGroup viewGroup, int i10) {
        return androidx.viewpager2.adapter.a.h(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(@n0 androidx.viewpager2.adapter.a aVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(@n0 androidx.viewpager2.adapter.a aVar) {
        A(aVar);
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(@n0 androidx.viewpager2.adapter.a aVar) {
        Long lT = t(aVar.i().getId());
        if (lT != null) {
            B(lT.longValue());
            this.f8163e.q(lT.longValue());
        }
    }

    public FragmentStateAdapter(@n0 Fragment fragment) {
        this(fragment.U1(), fragment.e());
    }

    public FragmentStateAdapter(@n0 FragmentManager fragmentManager, @n0 Lifecycle lifecycle) {
        this.f8161c = new h<>();
        this.f8162d = new h<>();
        this.f8163e = new h<>();
        this.f8165g = false;
        this.f8166h = false;
        this.f8160b = fragmentManager;
        this.f8159a = lifecycle;
        super.setHasStableIds(true);
    }
}
