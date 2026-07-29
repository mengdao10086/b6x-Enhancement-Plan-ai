package kotlinx.coroutines.sync;

import hk.e;
import hk.v;
import ik.l;
import ik.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.w0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.m3;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p;
import kotlinx.coroutines.r;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.selects.g;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.selects.j;
import kotlinx.coroutines.y1;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n332#2,12:301\n1#3:313\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n168#1:301,12\n*E\n"})
public class MutexImpl extends SemaphoreImpl implements kotlinx.coroutines.sync.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final AtomicReferenceFieldUpdater f39039i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final q<j<?>, Object, Object, l<Throwable, z1>> f39040h;

    @yt.l
    @v
    private volatile Object owner;

    @t0({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1#2:301\n*E\n"})
    public final class CancellableContinuationWithOwner implements o<z1>, m3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @e
        @k
        public final p<z1> f39041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @e
        @yt.l
        public final Object f39042b;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(@k p<? super z1> pVar, @yt.l Object obj) {
            this.f39041a = pVar;
            this.f39042b = obj;
        }

        @Override // kotlinx.coroutines.o
        public void B(@k l<? super Throwable, z1> lVar) {
            this.f39041a.B(lVar);
        }

        @Override // kotlinx.coroutines.o
        @yt.l
        @y1
        public Object J(@k Throwable th2) {
            return this.f39041a.J(th2);
        }

        @Override // kotlinx.coroutines.o
        @s1
        public void K(@k CoroutineDispatcher coroutineDispatcher, @k Throwable th2) {
            this.f39041a.K(coroutineDispatcher, th2);
        }

        @Override // kotlinx.coroutines.o
        @y1
        public void Q() {
            this.f39041a.Q();
        }

        @Override // kotlinx.coroutines.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void R(@k z1 z1Var, @yt.l l<? super Throwable, z1> lVar) {
            MutexImpl.f39039i.set(MutexImpl.this, this.f39042b);
            p<z1> pVar = this.f39041a;
            final MutexImpl mutexImpl = MutexImpl.this;
            pVar.R(z1Var, new l<Throwable, z1>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(@k Throwable th2) {
                    mutexImpl.f(this.f39042b);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            });
        }

        @Override // kotlin.coroutines.c
        @k
        public CoroutineContext b() {
            return this.f39041a.b();
        }

        @Override // kotlinx.coroutines.o
        @s1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void O(@k CoroutineDispatcher coroutineDispatcher, @k z1 z1Var) {
            this.f39041a.O(coroutineDispatcher, z1Var);
        }

        @Override // kotlinx.coroutines.o
        public boolean d(@yt.l Throwable th2) {
            return this.f39041a.d(th2);
        }

        @Override // kotlinx.coroutines.o
        @yt.l
        @y1
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object p(@k z1 z1Var, @yt.l Object obj) {
            return this.f39041a.p(z1Var, obj);
        }

        @Override // kotlinx.coroutines.o
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object w(@k z1 z1Var, @yt.l Object obj, @yt.l l<? super Throwable, z1> lVar) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object objW = this.f39041a.w(z1Var, obj, new l<Throwable, z1>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(@k Throwable th2) {
                    MutexImpl.f39039i.set(mutexImpl, this.f39042b);
                    mutexImpl.f(this.f39042b);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            });
            if (objW != null) {
                MutexImpl.f39039i.set(MutexImpl.this, this.f39042b);
            }
            return objW;
        }

        @Override // kotlinx.coroutines.m3
        public void g(@k l0<?> l0Var, int i10) {
            this.f39041a.g(l0Var, i10);
        }

        @Override // kotlinx.coroutines.o
        public boolean isActive() {
            return this.f39041a.isActive();
        }

        @Override // kotlinx.coroutines.o
        public boolean isCancelled() {
            return this.f39041a.isCancelled();
        }

        @Override // kotlinx.coroutines.o
        @y1
        public void l0(@k Object obj) {
            this.f39041a.l0(obj);
        }

        @Override // kotlinx.coroutines.o
        public boolean n() {
            return this.f39041a.n();
        }

        @Override // kotlin.coroutines.c
        public void x(@k Object obj) {
            this.f39041a.x(obj);
        }
    }

    @t0({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl$SelectInstanceWithOwner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,300:1\n1#2:301\n*E\n"})
    public final class a<Q> implements kotlinx.coroutines.selects.k<Q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @e
        @k
        public final kotlinx.coroutines.selects.k<Q> f39044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @e
        @yt.l
        public final Object f39045b;

        public a(@k kotlinx.coroutines.selects.k<Q> kVar, @yt.l Object obj) {
            this.f39044a = kVar;
            this.f39045b = obj;
        }

        @Override // kotlinx.coroutines.selects.j
        @k
        public CoroutineContext b() {
            return this.f39044a.b();
        }

        @Override // kotlinx.coroutines.selects.j
        public void d(@k g1 g1Var) {
            this.f39044a.d(g1Var);
        }

        @Override // kotlinx.coroutines.m3
        public void g(@k l0<?> l0Var, int i10) {
            this.f39044a.g(l0Var, i10);
        }

        @Override // kotlinx.coroutines.selects.j
        public boolean n(@k Object obj, @yt.l Object obj2) {
            boolean zN = this.f39044a.n(obj, obj2);
            MutexImpl mutexImpl = MutexImpl.this;
            if (zN) {
                MutexImpl.f39039i.set(mutexImpl, this.f39045b);
            }
            return zN;
        }

        @Override // kotlinx.coroutines.selects.j
        public void r(@yt.l Object obj) {
            MutexImpl.f39039i.set(MutexImpl.this, this.f39045b);
            this.f39044a.r(obj);
        }
    }

    public MutexImpl(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : MutexKt.f39049a;
        this.f39040h = new q<j<?>, Object, Object, l<? super Throwable, ? extends z1>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // ik.q
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final l<Throwable, z1> A(@k j<?> jVar, @yt.l final Object obj, @yt.l Object obj2) {
                final MutexImpl mutexImpl = this.this$0;
                return new l<Throwable, z1>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(@k Throwable th2) {
                        mutexImpl.f(obj);
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
            }
        };
    }

    public static /* synthetic */ void x() {
    }

    public static /* synthetic */ Object y(MutexImpl mutexImpl, Object obj, kotlin.coroutines.c<? super z1> cVar) {
        Object objZ;
        return (!mutexImpl.b(obj) && (objZ = mutexImpl.z(obj, cVar)) == yj.b.h()) ? objZ : z1.f38230a;
    }

    @yt.l
    public Object A(@yt.l Object obj, @yt.l Object obj2) {
        if (!f0.g(obj2, MutexKt.f39050b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void B(@k j<?> jVar, @yt.l Object obj) {
        if (obj != null && g(obj)) {
            jVar.r(MutexKt.f39050b);
        } else {
            f0.n(jVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            s(new a((kotlinx.coroutines.selects.k) jVar, obj), obj);
        }
    }

    public final int C(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            if (g(obj)) {
                return 2;
            }
            if (c()) {
                return 1;
            }
        }
        f39039i.set(this, obj);
        return 0;
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean b(@yt.l Object obj) {
        int iC = C(obj);
        if (iC == 0) {
            return true;
        }
        if (iC == 1) {
            return false;
        }
        if (iC != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean c() {
        return a() == 0;
    }

    @Override // kotlinx.coroutines.sync.a
    @yt.l
    public Object e(@yt.l Object obj, @k kotlin.coroutines.c<? super z1> cVar) {
        return y(this, obj, cVar);
    }

    @Override // kotlinx.coroutines.sync.a
    public void f(@yt.l Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f39039i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != MutexKt.f39049a) {
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (al.o.a(atomicReferenceFieldUpdater, this, obj2, MutexKt.f39049a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean g(@k Object obj) {
        while (c()) {
            Object obj2 = f39039i.get(this);
            if (obj2 != MutexKt.f39049a) {
                return obj2 == obj;
            }
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.a
    @k
    public g<Object, kotlinx.coroutines.sync.a> h() {
        MutexImpl$onLock$1 mutexImpl$onLock$1 = MutexImpl$onLock$1.f39047c;
        f0.n(mutexImpl$onLock$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        q qVar = (q) w0.q(mutexImpl$onLock$1, 3);
        MutexImpl$onLock$2 mutexImpl$onLock$2 = MutexImpl$onLock$2.f39048c;
        f0.n(mutexImpl$onLock$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new h(this, qVar, (q) w0.q(mutexImpl$onLock$2, 3), this.f39040h);
    }

    @k
    public String toString() {
        return "Mutex@" + r0.b(this) + "[isLocked=" + c() + ",owner=" + f39039i.get(this) + ']';
    }

    public final Object z(Object obj, kotlin.coroutines.c<? super z1> cVar) {
        p pVarB = r.b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            m(new CancellableContinuationWithOwner(pVarB, obj));
            Object objC = pVarB.C();
            if (objC == yj.b.h()) {
                f.c(cVar);
            }
            return objC == yj.b.h() ? objC : z1.f38230a;
        } catch (Throwable th2) {
            pVarB.U();
            throw th2;
        }
    }
}
