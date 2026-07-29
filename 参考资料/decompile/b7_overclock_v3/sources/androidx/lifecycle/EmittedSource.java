package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.g1;

/* JADX INFO: loaded from: classes2.dex */
public final class EmittedSource implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final LiveData<?> f6072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final h0<?> f6073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6074c;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    @zj.d(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
        public int label;

        public AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return EmittedSource.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            yj.b.h();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
            EmittedSource.this.c();
            return z1.f38230a;
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    public EmittedSource(@yt.k LiveData<?> source, @yt.k h0<?> mediator) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(mediator, "mediator");
        this.f6072a = source;
        this.f6073b = mediator;
    }

    @yt.l
    public final Object b(@yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objH = kotlinx.coroutines.h.h(kotlinx.coroutines.d1.e().o2(), new EmittedSource$disposeNow$2(this, null), cVar);
        return objH == yj.b.h() ? objH : z1.f38230a;
    }

    @g.k0
    public final void c() {
        if (this.f6074c) {
            return;
        }
        this.f6073b.t(this.f6072a);
        this.f6074c = true;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        kotlinx.coroutines.j.f(kotlinx.coroutines.p0.a(kotlinx.coroutines.d1.e().o2()), null, null, new AnonymousClass1(null), 3, null);
    }
}
