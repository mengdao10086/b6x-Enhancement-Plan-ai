package okio;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokio/j0;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "Lokio/v0;", "U", "", "toString", "Ljava/io/OutputStream;", "a", "Ljava/io/OutputStream;", "out", "b", "Lokio/v0;", "timeout", "<init>", "(Ljava/io/OutputStream;Lokio/v0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class j0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final OutputStream f44127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final v0 f44128b;

    public j0(@yt.k OutputStream out, @yt.k v0 timeout) {
        kotlin.jvm.internal.f0.p(out, "out");
        kotlin.jvm.internal.f0.p(timeout, "timeout");
        this.f44127a = out;
        this.f44128b = timeout;
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44128b;
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        a1.e(source.m2(), 0L, j10);
        while (j10 > 0) {
            this.f44128b.h();
            p0 p0Var = source.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            this.f44127a.write(p0Var.f44174a, p0Var.f44175b, iMin);
            p0Var.f44175b += iMin;
            long j11 = iMin;
            j10 -= j11;
            source.i2(source.m2() - j11);
            if (p0Var.f44175b == p0Var.f44176c) {
                source.f44116a = p0Var.b();
                q0.d(p0Var);
            }
        }
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44127a.close();
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() throws IOException {
        this.f44127a.flush();
    }

    @yt.k
    public String toString() {
        return "sink(" + this.f44127a + ')';
    }
}
