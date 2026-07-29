package okio;

import java.io.EOFException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lokio/i;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class i implements r0 {
    @Override // okio.r0
    @yt.k
    public v0 U() {
        return v0.f44220e;
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws EOFException {
        kotlin.jvm.internal.f0.p(source, "source");
        source.skip(j10);
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() {
    }
}
