package okio;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/b0;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "Lokio/v0;", "U", "", "toString", "Ljava/io/InputStream;", "a", "Ljava/io/InputStream;", "input", "b", "Lokio/v0;", "timeout", "<init>", "(Ljava/io/InputStream;Lokio/v0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public class b0 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final InputStream f44043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final v0 f44044b;

    public b0(@yt.k InputStream input, @yt.k v0 timeout) {
        kotlin.jvm.internal.f0.p(input, "input");
        kotlin.jvm.internal.f0.p(timeout, "timeout");
        this.f44043a = input;
        this.f44044b = timeout;
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        try {
            this.f44044b.h();
            p0 p0VarP2 = sink.p2(1);
            int i10 = this.f44043a.read(p0VarP2.f44174a, p0VarP2.f44176c, (int) Math.min(j10, 8192 - p0VarP2.f44176c));
            if (i10 != -1) {
                p0VarP2.f44176c += i10;
                long j11 = i10;
                sink.i2(sink.m2() + j11);
                return j11;
            }
            if (p0VarP2.f44175b != p0VarP2.f44176c) {
                return -1L;
            }
            sink.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
            return -1L;
        } catch (AssertionError e10) {
            if (f0.l(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44044b;
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44043a.close();
    }

    @yt.k
    public String toString() {
        return "source(" + this.f44043a + ')';
    }
}
