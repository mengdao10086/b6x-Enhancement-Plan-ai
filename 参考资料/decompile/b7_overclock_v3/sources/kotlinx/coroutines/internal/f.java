package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.internal.f;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
public abstract class f<N extends f<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38797a = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38798b = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_prev");

    @yt.l
    @hk.v
    private volatile Object _next;

    @yt.l
    @hk.v
    private volatile Object _prev;

    public f(@yt.l N n10) {
        this._prev = n10;
    }

    private final void n(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, ? extends Object> lVar, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!al.o.a(atomicReferenceFieldUpdater, obj, obj2, lVar.i(obj2)));
    }

    public final void b() {
        f38798b.lazySet(this, null);
    }

    public final N c() {
        N n10 = (N) g();
        while (n10 != null && n10.h()) {
            n10 = (N) f38798b.get(n10);
        }
        return n10;
    }

    public final N d() {
        f fVarE;
        N n10 = (N) e();
        kotlin.jvm.internal.f0.m(n10);
        while (n10.h() && (fVarE = n10.e()) != null) {
            n10 = (N) fVarE;
        }
        return n10;
    }

    @yt.l
    public final N e() {
        Object objF = f();
        if (objF == e.f38792b) {
            return null;
        }
        return (N) objF;
    }

    public final Object f() {
        return f38797a.get(this);
    }

    @yt.l
    public final N g() {
        return (N) f38798b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return al.o.a(f38797a, this, null, e.f38792b);
    }

    @yt.l
    public final N k(@yt.k ik.a aVar) {
        Object objF = f();
        if (objF != e.f38792b) {
            return (N) objF;
        }
        aVar.o();
        throw new KotlinNothingValueException();
    }

    public final void l() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            f fVarC = c();
            f fVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38798b;
            do {
                obj = atomicReferenceFieldUpdater.get(fVarD);
            } while (!al.o.a(atomicReferenceFieldUpdater, fVarD, obj, ((f) obj) == null ? null : fVarC));
            if (fVarC != null) {
                f38797a.set(fVarC, fVarD);
            }
            if (!fVarD.h() || fVarD.i()) {
                if (fVarC == null || !fVarC.h()) {
                    return;
                }
            }
        }
    }

    public final boolean m(@yt.k N n10) {
        return al.o.a(f38797a, this, null, n10);
    }
}
