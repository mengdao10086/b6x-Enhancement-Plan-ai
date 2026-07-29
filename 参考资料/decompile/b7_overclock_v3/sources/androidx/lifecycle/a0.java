package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import g.i1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a0 extends Lifecycle {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final a f6162j = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public o.a<x, b> f6164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public Lifecycle.State f6165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final WeakReference<y> f6166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public ArrayList<Lifecycle.State> f6170i;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @i1
        @hk.m
        @yt.k
        public final a0 a(@yt.k y owner) {
            kotlin.jvm.internal.f0.p(owner, "owner");
            return new a0(owner, false, null);
        }

        @hk.m
        @yt.k
        public final Lifecycle.State b(@yt.k Lifecycle.State state1, @yt.l Lifecycle.State state) {
            kotlin.jvm.internal.f0.p(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public Lifecycle.State f6171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public v f6172b;

        public b(@yt.l x xVar, @yt.k Lifecycle.State initialState) {
            kotlin.jvm.internal.f0.p(initialState, "initialState");
            kotlin.jvm.internal.f0.m(xVar);
            this.f6172b = e0.f(xVar);
            this.f6171a = initialState;
        }

        public final void a(@yt.l y yVar, @yt.k Lifecycle.Event event) {
            kotlin.jvm.internal.f0.p(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f6171a = a0.f6162j.b(this.f6171a, targetState);
            v vVar = this.f6172b;
            kotlin.jvm.internal.f0.m(yVar);
            vVar.c(yVar, event);
            this.f6171a = targetState;
        }

        @yt.k
        public final v b() {
            return this.f6172b;
        }

        @yt.k
        public final Lifecycle.State c() {
            return this.f6171a;
        }

        public final void d(@yt.k v vVar) {
            kotlin.jvm.internal.f0.p(vVar, "<set-?>");
            this.f6172b = vVar;
        }

        public final void e(@yt.k Lifecycle.State state) {
            kotlin.jvm.internal.f0.p(state, "<set-?>");
            this.f6171a = state;
        }
    }

    public a0(y yVar, boolean z10) {
        this.f6163b = z10;
        this.f6164c = new o.a<>();
        this.f6165d = Lifecycle.State.INITIALIZED;
        this.f6170i = new ArrayList<>();
        this.f6166e = new WeakReference<>(yVar);
    }

    public /* synthetic */ a0(y yVar, boolean z10, kotlin.jvm.internal.u uVar) {
        this(yVar, z10);
    }

    @i1
    @hk.m
    @yt.k
    public static final a0 h(@yt.k y yVar) {
        return f6162j.a(yVar);
    }

    @hk.m
    @yt.k
    public static final Lifecycle.State o(@yt.k Lifecycle.State state, @yt.l Lifecycle.State state2) {
        return f6162j.b(state, state2);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(@yt.k x observer) {
        y yVar;
        kotlin.jvm.internal.f0.p(observer, "observer");
        i("addObserver");
        Lifecycle.State state = this.f6165d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (this.f6164c.g(observer, bVar) == null && (yVar = this.f6166e.get()) != null) {
            boolean z10 = this.f6167f != 0 || this.f6168g;
            Lifecycle.State stateG = g(observer);
            this.f6167f++;
            while (bVar.c().compareTo(stateG) < 0 && this.f6164c.contains(observer)) {
                r(bVar.c());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.c());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.c());
                }
                bVar.a(yVar, eventC);
                q();
                stateG = g(observer);
            }
            if (!z10) {
                t();
            }
            this.f6167f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @yt.k
    public Lifecycle.State b() {
        return this.f6165d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void d(@yt.k x observer) {
        kotlin.jvm.internal.f0.p(observer, "observer");
        i("removeObserver");
        this.f6164c.i(observer);
    }

    public final void f(y yVar) {
        Iterator<Map.Entry<x, b>> itDescendingIterator = this.f6164c.descendingIterator();
        kotlin.jvm.internal.f0.o(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f6169h) {
            Map.Entry<x, b> next = itDescendingIterator.next();
            kotlin.jvm.internal.f0.o(next, "next()");
            x key = next.getKey();
            b value = next.getValue();
            while (value.c().compareTo(this.f6165d) > 0 && !this.f6169h && this.f6164c.contains(key)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(value.c());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + value.c());
                }
                r(eventA.getTargetState());
                value.a(yVar, eventA);
                q();
            }
        }
    }

    public final Lifecycle.State g(x xVar) {
        b value;
        Map.Entry<x, b> entryJ = this.f6164c.j(xVar);
        Lifecycle.State state = null;
        Lifecycle.State stateC = (entryJ == null || (value = entryJ.getValue()) == null) ? null : value.c();
        if (!this.f6170i.isEmpty()) {
            state = this.f6170i.get(r0.size() - 1);
        }
        a aVar = f6162j;
        return aVar.b(aVar.b(this.f6165d, stateC), state);
    }

    @SuppressLint({"RestrictedApi"})
    public final void i(String str) {
        if (!this.f6163b || n.c.h().c()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void j(y yVar) {
        o.b<x, b>.d dVarD = this.f6164c.d();
        kotlin.jvm.internal.f0.o(dVarD, "observerMap.iteratorWithAdditions()");
        while (dVarD.hasNext() && !this.f6169h) {
            Map.Entry next = dVarD.next();
            x xVar = (x) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.c().compareTo(this.f6165d) < 0 && !this.f6169h && this.f6164c.contains(xVar)) {
                r(bVar.c());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.c());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.c());
                }
                bVar.a(yVar, eventC);
                q();
            }
        }
    }

    public int k() {
        i("getObserverCount");
        return this.f6164c.size();
    }

    public void l(@yt.k Lifecycle.Event event) {
        kotlin.jvm.internal.f0.p(event, "event");
        i("handleLifecycleEvent");
        p(event.getTargetState());
    }

    public final boolean m() {
        if (this.f6164c.size() == 0) {
            return true;
        }
        Map.Entry<x, b> entryA = this.f6164c.a();
        kotlin.jvm.internal.f0.m(entryA);
        Lifecycle.State stateC = entryA.getValue().c();
        Map.Entry<x, b> entryE = this.f6164c.e();
        kotlin.jvm.internal.f0.m(entryE);
        Lifecycle.State stateC2 = entryE.getValue().c();
        return stateC == stateC2 && this.f6165d == stateC2;
    }

    @g.k0
    @kotlin.k(message = "Override [currentState].")
    public void n(@yt.k Lifecycle.State state) {
        kotlin.jvm.internal.f0.p(state, "state");
        i("markState");
        s(state);
    }

    public final void p(Lifecycle.State state) {
        Lifecycle.State state2 = this.f6165d;
        if (state2 == state) {
            return;
        }
        if (!((state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.f6165d + " in component " + this.f6166e.get()).toString());
        }
        this.f6165d = state;
        if (this.f6168g || this.f6167f != 0) {
            this.f6169h = true;
            return;
        }
        this.f6168g = true;
        t();
        this.f6168g = false;
        if (this.f6165d == Lifecycle.State.DESTROYED) {
            this.f6164c = new o.a<>();
        }
    }

    public final void q() {
        this.f6170i.remove(r0.size() - 1);
    }

    public final void r(Lifecycle.State state) {
        this.f6170i.add(state);
    }

    public void s(@yt.k Lifecycle.State state) {
        kotlin.jvm.internal.f0.p(state, "state");
        i("setCurrentState");
        p(state);
    }

    public final void t() {
        y yVar = this.f6166e.get();
        if (yVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!m()) {
            this.f6169h = false;
            Lifecycle.State state = this.f6165d;
            Map.Entry<x, b> entryA = this.f6164c.a();
            kotlin.jvm.internal.f0.m(entryA);
            if (state.compareTo(entryA.getValue().c()) < 0) {
                f(yVar);
            }
            Map.Entry<x, b> entryE = this.f6164c.e();
            if (!this.f6169h && entryE != null && this.f6165d.compareTo(entryE.getValue().c()) > 0) {
                j(yVar);
            }
        }
        this.f6169h = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(@yt.k y provider) {
        this(provider, true);
        kotlin.jvm.internal.f0.p(provider, "provider");
    }
}
