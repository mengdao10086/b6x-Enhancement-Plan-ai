package xi;

import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y<Object> f55353b = new y<>(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f55354a;

    public y(Object obj) {
        this.f55354a = obj;
    }

    @bj.e
    public static <T> y<T> a() {
        return (y<T>) f55353b;
    }

    @bj.e
    public static <T> y<T> b(@bj.e Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "error is null");
        return new y<>(NotificationLite.error(th2));
    }

    @bj.e
    public static <T> y<T> c(@bj.e T t10) {
        io.reactivex.internal.functions.a.g(t10, "value is null");
        return new y<>(t10);
    }

    @bj.f
    public Throwable d() {
        Object obj = this.f55354a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @bj.f
    public T e() {
        Object obj = this.f55354a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.f55354a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof y) {
            return io.reactivex.internal.functions.a.c(this.f55354a, ((y) obj).f55354a);
        }
        return false;
    }

    public boolean f() {
        return this.f55354a == null;
    }

    public boolean g() {
        return NotificationLite.isError(this.f55354a);
    }

    public boolean h() {
        Object obj = this.f55354a;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public int hashCode() {
        Object obj = this.f55354a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f55354a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f55354a + "]";
    }
}
