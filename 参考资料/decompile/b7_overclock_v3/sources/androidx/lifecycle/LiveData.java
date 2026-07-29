package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6086k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f6087l = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o.b<k0<? super T>, LiveData<T>.c> f6089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f6092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f6093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f6097j;

    public class LifecycleBoundObserver extends LiveData<T>.c implements v {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.n0
        public final y f6098e;

        public LifecycleBoundObserver(@g.n0 y yVar, k0<? super T> k0Var) {
            super(k0Var);
            this.f6098e = yVar;
        }

        @Override // androidx.lifecycle.v
        public void c(@g.n0 y yVar, @g.n0 Lifecycle.Event event) {
            Lifecycle.State stateB = this.f6098e.e().b();
            if (stateB == Lifecycle.State.DESTROYED) {
                LiveData.this.p(this.f6102a);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                h(k());
                state = stateB;
                stateB = this.f6098e.e().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        public void i() {
            this.f6098e.e().d(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean j(y yVar) {
            return this.f6098e == yVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return this.f6098e.e().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f6088a) {
                obj = LiveData.this.f6093f;
                LiveData.this.f6093f = LiveData.f6087l;
            }
            LiveData.this.r(obj);
        }
    }

    public class b extends LiveData<T>.c {
        public b(k0<? super T> k0Var) {
            super(k0Var);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0<? super T> f6102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6103b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6104c = -1;

        public c(k0<? super T> k0Var) {
            this.f6102a = k0Var;
        }

        public void h(boolean z10) {
            if (z10 == this.f6103b) {
                return;
            }
            this.f6103b = z10;
            LiveData.this.c(z10 ? 1 : -1);
            if (this.f6103b) {
                LiveData.this.e(this);
            }
        }

        public void i() {
        }

        public boolean j(y yVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData(T t10) {
        this.f6088a = new Object();
        this.f6089b = new o.b<>();
        this.f6090c = 0;
        this.f6093f = f6087l;
        this.f6097j = new a();
        this.f6092e = t10;
        this.f6094g = 0;
    }

    public static void b(String str) {
        if (n.c.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    @g.k0
    public void c(int i10) {
        int i11 = this.f6090c;
        this.f6090c = i10 + i11;
        if (this.f6091d) {
            return;
        }
        this.f6091d = true;
        while (true) {
            try {
                int i12 = this.f6090c;
                if (i11 == i12) {
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    m();
                } else if (z11) {
                    n();
                }
                i11 = i12;
            } finally {
                this.f6091d = false;
            }
        }
    }

    public final void d(LiveData<T>.c cVar) {
        if (cVar.f6103b) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i10 = cVar.f6104c;
            int i11 = this.f6094g;
            if (i10 >= i11) {
                return;
            }
            cVar.f6104c = i11;
            cVar.f6102a.b((Object) this.f6092e);
        }
    }

    public void e(@g.p0 LiveData<T>.c cVar) {
        if (this.f6095h) {
            this.f6096i = true;
            return;
        }
        this.f6095h = true;
        do {
            this.f6096i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                o.b<k0<? super T>, LiveData<T>.c>.d dVarD = this.f6089b.d();
                while (dVarD.hasNext()) {
                    d((c) dVarD.next().getValue());
                    if (this.f6096i) {
                        break;
                    }
                }
            }
        } while (this.f6096i);
        this.f6095h = false;
    }

    @g.p0
    public T f() {
        T t10 = (T) this.f6092e;
        if (t10 != f6087l) {
            return t10;
        }
        return null;
    }

    public int g() {
        return this.f6094g;
    }

    public boolean h() {
        return this.f6090c > 0;
    }

    public boolean i() {
        return this.f6089b.size() > 0;
    }

    public boolean j() {
        return this.f6092e != f6087l;
    }

    @g.k0
    public void k(@g.n0 y yVar, @g.n0 k0<? super T> k0Var) {
        b("observe");
        if (yVar.e().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(yVar, k0Var);
        LiveData<T>.c cVarG = this.f6089b.g(k0Var, lifecycleBoundObserver);
        if (cVarG != null && !cVarG.j(yVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarG != null) {
            return;
        }
        yVar.e().a(lifecycleBoundObserver);
    }

    @g.k0
    public void l(@g.n0 k0<? super T> k0Var) {
        b("observeForever");
        b bVar = new b(k0Var);
        LiveData<T>.c cVarG = this.f6089b.g(k0Var, bVar);
        if (cVarG instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarG != null) {
            return;
        }
        bVar.h(true);
    }

    public void m() {
    }

    public void n() {
    }

    public void o(T t10) {
        boolean z10;
        synchronized (this.f6088a) {
            z10 = this.f6093f == f6087l;
            this.f6093f = t10;
        }
        if (z10) {
            n.c.h().d(this.f6097j);
        }
    }

    @g.k0
    public void p(@g.n0 k0<? super T> k0Var) {
        b("removeObserver");
        LiveData<T>.c cVarI = this.f6089b.i(k0Var);
        if (cVarI == null) {
            return;
        }
        cVarI.i();
        cVarI.h(false);
    }

    @g.k0
    public void q(@g.n0 y yVar) {
        b("removeObservers");
        for (Map.Entry<k0<? super T>, LiveData<T>.c> entry : this.f6089b) {
            if (entry.getValue().j(yVar)) {
                p(entry.getKey());
            }
        }
    }

    @g.k0
    public void r(T t10) {
        b("setValue");
        this.f6094g++;
        this.f6092e = t10;
        e(null);
    }

    public LiveData() {
        this.f6088a = new Object();
        this.f6089b = new o.b<>();
        this.f6090c = 0;
        Object obj = f6087l;
        this.f6093f = obj;
        this.f6097j = new a();
        this.f6092e = obj;
        this.f6094g = -1;
    }
}
