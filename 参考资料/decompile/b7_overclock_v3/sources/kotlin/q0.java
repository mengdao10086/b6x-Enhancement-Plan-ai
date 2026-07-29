package kotlin;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
public class q0 extends p0 {
    @bk.f
    public static final void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @bk.f
    public static final void d(boolean z10, ik.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (!z10) {
            throw new IllegalStateException(lazyMessage.o().toString());
        }
    }

    @bk.f
    public static final <T> T e(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @bk.f
    public static final <T> T f(T t10, ik.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(lazyMessage.o().toString());
    }

    @bk.f
    public static final Void g(Object message) {
        kotlin.jvm.internal.f0.p(message, "message");
        throw new IllegalStateException(message.toString());
    }

    @bk.f
    public static final void h(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @bk.f
    public static final void i(boolean z10, ik.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (!z10) {
            throw new IllegalArgumentException(lazyMessage.o().toString());
        }
    }

    @bk.f
    public static final <T> T j(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @bk.f
    public static final <T> T k(T t10, ik.a<? extends Object> lazyMessage) {
        kotlin.jvm.internal.f0.p(lazyMessage, "lazyMessage");
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(lazyMessage.o().toString());
    }
}
