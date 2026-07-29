package kotlinx.coroutines.internal;

import kotlinx.coroutines.internal.l0;

/* JADX INFO: loaded from: classes5.dex */
@hk.f
public final class m0<S extends l0<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Object f38815a;

    public /* synthetic */ m0(Object obj) {
        this.f38815a = obj;
    }

    public static final /* synthetic */ m0 a(Object obj) {
        return new m0(obj);
    }

    @yt.k
    public static <S extends l0<S>> Object b(@yt.l Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof m0) && kotlin.jvm.internal.f0.g(obj, ((m0) obj2).j());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @yt.k
    public static final S f(Object obj) {
        if (obj == e.f38792b) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj == e.f38792b;
    }

    public static String i(Object obj) {
        return "SegmentOrClosed(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f38815a, obj);
    }

    public int hashCode() {
        return g(this.f38815a);
    }

    public final /* synthetic */ Object j() {
        return this.f38815a;
    }

    public String toString() {
        return i(this.f38815a);
    }
}
