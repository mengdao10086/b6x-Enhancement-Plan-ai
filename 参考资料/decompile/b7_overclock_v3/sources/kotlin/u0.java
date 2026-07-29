package kotlin;

import kotlin.Result;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
public final class u0 {
    @v0(version = "1.3")
    @s0
    @yt.k
    public static final Object a(@yt.k Throwable exception) {
        kotlin.jvm.internal.f0.p(exception, "exception");
        return new Result.Failure(exception);
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T> R b(Object obj, ik.l<? super T, ? extends R> onSuccess, ik.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.f0.p(onSuccess, "onSuccess");
        kotlin.jvm.internal.f0.p(onFailure, "onFailure");
        Throwable thF = Result.f(obj);
        return thF == null ? onSuccess.i(obj) : onFailure.i(thF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <R, T extends R> R c(Object obj, R r10) {
        return Result.l(obj) ? r10 : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <R, T extends R> R d(Object obj, ik.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.f0.p(onFailure, "onFailure");
        Throwable thF = Result.f(obj);
        return thF == null ? obj : onFailure.i(thF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <T> T e(Object obj) throws Throwable {
        n(obj);
        return obj;
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T> Object f(Object obj, ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        if (!Result.m(obj)) {
            return Result.b(obj);
        }
        Result.a aVar = Result.f37633a;
        return Result.b(transform.i(obj));
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T> Object g(Object obj, ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        if (!Result.m(obj)) {
            return Result.b(obj);
        }
        try {
            Result.a aVar = Result.f37633a;
            return Result.b(transform.i(obj));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            return Result.b(a(th2));
        }
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> Object h(Object obj, ik.l<? super Throwable, z1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        Throwable thF = Result.f(obj);
        if (thF != null) {
            action.i(thF);
        }
        return obj;
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T> Object i(Object obj, ik.l<? super T, z1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        if (Result.m(obj)) {
            action.i(obj);
        }
        return obj;
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T extends R> Object j(Object obj, ik.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        Throwable thF = Result.f(obj);
        if (thF == null) {
            return obj;
        }
        Result.a aVar = Result.f37633a;
        return Result.b(transform.i(thF));
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R, T extends R> Object k(Object obj, ik.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(transform, "transform");
        Throwable thF = Result.f(obj);
        if (thF == null) {
            return obj;
        }
        try {
            Result.a aVar = Result.f37633a;
            return Result.b(transform.i(thF));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            return Result.b(a(th2));
        }
    }

    @bk.f
    @v0(version = "1.3")
    public static final <R> Object l(ik.a<? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        try {
            Result.a aVar = Result.f37633a;
            return Result.b(block.o());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            return Result.b(a(th2));
        }
    }

    @bk.f
    @v0(version = "1.3")
    public static final <T, R> Object m(T t10, ik.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        try {
            Result.a aVar = Result.f37633a;
            return Result.b(block.i(t10));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            return Result.b(a(th2));
        }
    }

    @v0(version = "1.3")
    @s0
    public static final void n(@yt.k Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
