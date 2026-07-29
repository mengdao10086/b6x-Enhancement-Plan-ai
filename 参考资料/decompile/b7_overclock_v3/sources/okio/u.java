package okio;

import java.io.IOException;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000f\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lokio/u;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "", "toString", "a", "()Lokio/t0;", "Lokio/t0;", "c", "delegate", "<init>", "(Lokio/t0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class u implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final t0 f44209a;

    public u(@yt.k t0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f44209a = delegate;
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return this.f44209a.F1(sink, j10);
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44209a.U();
    }

    @hk.h(name = "-deprecated_delegate")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "delegate", imports = {}))
    @yt.k
    public final t0 a() {
        return this.f44209a;
    }

    @hk.h(name = "delegate")
    @yt.k
    public final t0 c() {
        return this.f44209a;
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44209a.close();
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getClass().getSimpleName());
        sb2.append('(');
        sb2.append(this.f44209a);
        sb2.append(')');
        return sb2.toString();
    }
}
