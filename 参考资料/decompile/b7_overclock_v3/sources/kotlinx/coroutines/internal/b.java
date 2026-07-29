package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nAtomic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Atomic.kt\nkotlinx/coroutines/internal/AtomicOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
@y1
public abstract class b<T> extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38782a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");

    @yt.l
    @hk.v
    private volatile Object _consensus = a.f38775a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.g0
    @yt.k
    public b<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.g0
    @yt.l
    public final Object b(@yt.l Object obj) {
        Object objD = f38782a.get(this);
        if (objD == a.f38775a) {
            objD = d(e(obj));
        }
        c(obj, objD);
        return objD;
    }

    public abstract void c(T t10, @yt.l Object obj);

    public final Object d(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38782a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f38775a;
        return obj2 != obj3 ? obj2 : al.o.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    @yt.l
    public abstract Object e(T t10);
}
