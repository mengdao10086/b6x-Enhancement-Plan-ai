package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0001H\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokio/v;", "Lokio/v0;", "delegate", m0.k.f40564b, "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", xf.j.f55230b, "", "f", "d", "deadlineNanoTime", "e", "b", "a", "Lkotlin/z1;", "h", "Lokio/v0;", com.flydigi.sdk.bluetooth.l.f16298a, "()Lokio/v0;", "n", "(Lokio/v0;)V", "<init>", "okio"}, k = 1, mv = {1, 5, 1})
public class v extends v0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public v0 f44218f;

    public v(@yt.k v0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f44218f = delegate;
    }

    @Override // okio.v0
    @yt.k
    public v0 a() {
        return this.f44218f.a();
    }

    @Override // okio.v0
    @yt.k
    public v0 b() {
        return this.f44218f.b();
    }

    @Override // okio.v0
    public long d() {
        return this.f44218f.d();
    }

    @Override // okio.v0
    @yt.k
    public v0 e(long j10) {
        return this.f44218f.e(j10);
    }

    @Override // okio.v0
    public boolean f() {
        return this.f44218f.f();
    }

    @Override // okio.v0
    public void h() throws IOException {
        this.f44218f.h();
    }

    @Override // okio.v0
    @yt.k
    public v0 i(long j10, @yt.k TimeUnit unit) {
        kotlin.jvm.internal.f0.p(unit, "unit");
        return this.f44218f.i(j10, unit);
    }

    @Override // okio.v0
    public long j() {
        return this.f44218f.j();
    }

    @hk.h(name = "delegate")
    @yt.k
    public final v0 l() {
        return this.f44218f;
    }

    @yt.k
    public final v m(@yt.k v0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f44218f = delegate;
        return this;
    }

    public final /* synthetic */ void n(v0 v0Var) {
        kotlin.jvm.internal.f0.p(v0Var, "<set-?>");
        this.f44218f = v0Var;
    }
}
