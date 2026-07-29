package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public class x0 {
    @bk.f
    public static final Void a() {
        throw new NotImplementedError(null, 1, null);
    }

    @bk.f
    public static final Void b(String reason) {
        kotlin.jvm.internal.f0.p(reason, "reason");
        throw new NotImplementedError("An operation is not implemented: " + reason);
    }

    @bk.f
    @v0(version = "1.1")
    public static final <T> T c(T t10, ik.l<? super T, z1> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        block.i(t10);
        return t10;
    }

    @bk.f
    public static final <T> T d(T t10, ik.l<? super T, z1> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        block.i(t10);
        return t10;
    }

    @bk.f
    public static final <T, R> R e(T t10, ik.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.i(t10);
    }

    @bk.f
    public static final void f(int i10, ik.l<? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(action, "action");
        for (int i11 = 0; i11 < i10; i11++) {
            action.i(Integer.valueOf(i11));
        }
    }

    @bk.f
    public static final <R> R g(ik.a<? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.o();
    }

    @bk.f
    public static final <T, R> R h(T t10, ik.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.i(t10);
    }

    @bk.f
    @v0(version = "1.1")
    public static final <T> T i(T t10, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (predicate.i(t10).booleanValue()) {
            return t10;
        }
        return null;
    }

    @bk.f
    @v0(version = "1.1")
    public static final <T> T j(T t10, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        if (predicate.i(t10).booleanValue()) {
            return null;
        }
        return t10;
    }

    @bk.f
    public static final <T, R> R k(T t10, ik.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.f0.p(block, "block");
        return block.i(t10);
    }
}
