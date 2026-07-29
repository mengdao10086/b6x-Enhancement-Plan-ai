package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@hk.f
public final class Result<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f37633a = new a(null);

    @yt.l
    private final Object value;

    public static final class Failure implements Serializable {

        @hk.e
        @yt.k
        public final Throwable exception;

        public Failure(@yt.k Throwable exception) {
            kotlin.jvm.internal.f0.p(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(@yt.l Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.f0.g(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @yt.k
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.h(name = "failure")
        @bk.f
        public final <T> Object a(Throwable exception) {
            kotlin.jvm.internal.f0.p(exception, "exception");
            return Result.b(u0.a(exception));
        }

        @hk.h(name = "success")
        @bk.f
        public final <T> Object b(T t10) {
            return Result.b(t10);
        }
    }

    @s0
    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    public static final /* synthetic */ Result a(Object obj) {
        return new Result(obj);
    }

    @s0
    @yt.k
    public static <T> Object b(@yt.l Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.f0.g(obj, ((Result) obj2).o());
    }

    public static final boolean d(Object obj, Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    @yt.l
    public static final Throwable f(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    public static final T h(Object obj) {
        if (l(obj)) {
            return null;
        }
        return obj;
    }

    @s0
    public static /* synthetic */ void i() {
    }

    public static int k(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean l(Object obj) {
        return obj instanceof Failure;
    }

    public static final boolean m(Object obj) {
        return !(obj instanceof Failure);
    }

    @yt.k
    public static String n(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.value, obj);
    }

    public int hashCode() {
        return k(this.value);
    }

    public final /* synthetic */ Object o() {
        return this.value;
    }

    @yt.k
    public String toString() {
        return n(this.value);
    }
}
