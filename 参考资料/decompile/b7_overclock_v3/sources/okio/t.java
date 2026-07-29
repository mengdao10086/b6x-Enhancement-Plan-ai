package okio;

import java.io.IOException;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000f\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lokio/t;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "", "toString", "a", "()Lokio/r0;", "Lokio/r0;", "c", "delegate", "<init>", "(Lokio/r0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class t implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final r0 f44208a;

    public t(@yt.k r0 delegate) {
        kotlin.jvm.internal.f0.p(delegate, "delegate");
        this.f44208a = delegate;
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44208a.U();
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        this.f44208a.V0(source, j10);
    }

    @hk.h(name = "-deprecated_delegate")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "delegate", imports = {}))
    @yt.k
    public final r0 a() {
        return this.f44208a;
    }

    @hk.h(name = "delegate")
    @yt.k
    public final r0 c() {
        return this.f44208a;
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44208a.close();
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() throws IOException {
        this.f44208a.flush();
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getClass().getSimpleName());
        sb2.append('(');
        sb2.append(this.f44208a);
        sb2.append(')');
        return sb2.toString();
    }
}
