package qk;

import kotlin.jvm.internal.f0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class u {
    public static final void a(boolean z10, @yt.k Number step) {
        f0.p(step, "step");
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lqk/h<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @bk.f
    @v0(version = "1.3")
    public static final boolean b(h hVar, Object obj) {
        f0.p(hVar, "<this>");
        return obj != null && hVar.contains((Comparable) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lqk/s<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    @bk.f
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean c(s sVar, Object obj) {
        f0.p(sVar, "<this>");
        return obj != null && sVar.contains((Comparable) obj);
    }

    @v0(version = "1.1")
    @yt.k
    public static final g<Double> d(double d10, double d11) {
        return new e(d10, d11);
    }

    @v0(version = "1.1")
    @yt.k
    public static final g<Float> e(float f10, float f11) {
        return new f(f10, f11);
    }

    @yt.k
    public static final <T extends Comparable<? super T>> h<T> f(@yt.k T t10, @yt.k T that) {
        f0.p(t10, "<this>");
        f0.p(that, "that");
        return new j(t10, that);
    }

    @v0(version = "1.7")
    @yt.k
    @kotlin.q
    public static final s<Double> g(double d10, double d11) {
        return new q(d10, d11);
    }

    @v0(version = "1.7")
    @yt.k
    @kotlin.q
    public static final s<Float> h(float f10, float f11) {
        return new r(f10, f11);
    }

    @v0(version = "1.7")
    @yt.k
    @kotlin.q
    public static final <T extends Comparable<? super T>> s<T> i(@yt.k T t10, @yt.k T that) {
        f0.p(t10, "<this>");
        f0.p(that, "that");
        return new i(t10, that);
    }
}
