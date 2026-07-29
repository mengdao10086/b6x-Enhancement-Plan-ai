package kotlin.coroutines;

import ik.l;
import ik.p;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.v0;
import kotlin.z1;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n*L\n1#1,161:1\n*E\n"})
    public static final class a<T> implements c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f37761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<Result<? extends T>, z1> f37762b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CoroutineContext coroutineContext, l<? super Result<? extends T>, z1> lVar) {
            this.f37761a = coroutineContext;
            this.f37762b = lVar;
        }

        @Override // kotlin.coroutines.c
        @k
        public CoroutineContext b() {
            return this.f37761a;
        }

        @Override // kotlin.coroutines.c
        public void x(@k Object obj) {
            this.f37762b.i(Result.a(obj));
        }
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> c<T> a(CoroutineContext context, l<? super Result<? extends T>, z1> resumeWith) {
        f0.p(context, "context");
        f0.p(resumeWith, "resumeWith");
        return new a(context, resumeWith);
    }

    @v0(version = "1.3")
    @k
    public static final <T> c<z1> b(@k l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        return new h(IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, completion)), yj.b.h());
    }

    @v0(version = "1.3")
    @k
    public static final <R, T> c<z1> c(@k p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, @k c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        return new h(IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r10, completion)), yj.b.h());
    }

    public static final CoroutineContext d() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @bk.f
    @v0(version = "1.3")
    public static /* synthetic */ void e() {
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> void f(c<? super T> cVar, T t10) {
        f0.p(cVar, "<this>");
        Result.a aVar = Result.f37633a;
        cVar.x(Result.b(t10));
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> void g(c<? super T> cVar, Throwable exception) {
        f0.p(cVar, "<this>");
        f0.p(exception, "exception");
        Result.a aVar = Result.f37633a;
        cVar.x(Result.b(u0.a(exception)));
    }

    @v0(version = "1.3")
    public static final <T> void h(@k l<? super c<? super T>, ? extends Object> lVar, @k c<? super T> completion) {
        f0.p(lVar, "<this>");
        f0.p(completion, "completion");
        c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.b(lVar, completion));
        Result.a aVar = Result.f37633a;
        cVarD.x(Result.b(z1.f38230a));
    }

    @v0(version = "1.3")
    public static final <R, T> void i(@k p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, @k c<? super T> completion) {
        f0.p(pVar, "<this>");
        f0.p(completion, "completion");
        c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(IntrinsicsKt__IntrinsicsJvmKt.c(pVar, r10, completion));
        Result.a aVar = Result.f37633a;
        cVarD.x(Result.b(z1.f38230a));
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> Object j(l<? super c<? super T>, z1> lVar, c<? super T> cVar) throws Throwable {
        c0.e(0);
        h hVar = new h(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        lVar.i(hVar);
        Object objA = hVar.a();
        if (objA == yj.b.h()) {
            zj.f.c(cVar);
        }
        c0.e(1);
        return objA;
    }
}
