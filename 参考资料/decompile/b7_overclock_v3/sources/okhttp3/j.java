package okhttp3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rB!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013B\t\b\u0016¢\u0006\u0004\b\f\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u000b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lokhttp3/j;", "", "", "d", "a", "Lkotlin/z1;", "b", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "c", "()Lokhttp3/internal/connection/f;", "delegate", "<init>", "(Lokhttp3/internal/connection/f;)V", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final okhttp3.internal.connection.f f43879a;

    public j(@yt.k okhttp3.internal.connection.f delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f43879a = delegate;
    }

    public final int a() {
        return this.f43879a.d();
    }

    public final void b() {
        this.f43879a.e();
    }

    @yt.k
    public final okhttp3.internal.connection.f c() {
        return this.f43879a;
    }

    public final int d() {
        return this.f43879a.f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(int i10, long j10, @yt.k TimeUnit timeUnit) {
        this(new okhttp3.internal.connection.f(ul.d.f52208i, i10, j10, timeUnit));
        kotlin.jvm.internal.f0.p(timeUnit, "timeUnit");
    }

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
