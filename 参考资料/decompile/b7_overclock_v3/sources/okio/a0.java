package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019¨\u0006\u001e"}, d2 = {"Lokio/a0;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "a", "", "c", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "d", "Lokio/l;", "Lokio/l;", "source", "Ljava/util/zip/Inflater;", "b", "Ljava/util/zip/Inflater;", "inflater", "", "I", "bufferBytesHeldByInflater", "Z", "closed", "<init>", "(Lokio/l;Ljava/util/zip/Inflater;)V", "(Lokio/t0;Ljava/util/zip/Inflater;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class a0 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final l f44036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Inflater f44037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f44039d;

    public a0(@yt.k l source, @yt.k Inflater inflater) {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        this.f44036a = source;
        this.f44037b = inflater;
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        do {
            long jA = a(sink, j10);
            if (jA > 0) {
                return jA;
            }
            if (this.f44037b.finished() || this.f44037b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f44036a.d0());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44036a.U();
    }

    public final long a(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(!this.f44039d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            p0 p0VarP2 = sink.p2(1);
            int iMin = (int) Math.min(j10, 8192 - p0VarP2.f44176c);
            c();
            int iInflate = this.f44037b.inflate(p0VarP2.f44174a, p0VarP2.f44176c, iMin);
            d();
            if (iInflate > 0) {
                p0VarP2.f44176c += iInflate;
                long j11 = iInflate;
                sink.i2(sink.m2() + j11);
                return j11;
            }
            if (p0VarP2.f44175b == p0VarP2.f44176c) {
                sink.f44116a = p0VarP2.b();
                q0.d(p0VarP2);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    public final boolean c() throws IOException {
        if (!this.f44037b.needsInput()) {
            return false;
        }
        if (this.f44036a.d0()) {
            return true;
        }
        p0 p0Var = this.f44036a.g().f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        int i10 = p0Var.f44176c;
        int i11 = p0Var.f44175b;
        int i12 = i10 - i11;
        this.f44038c = i12;
        this.f44037b.setInput(p0Var.f44174a, i11, i12);
        return false;
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f44039d) {
            return;
        }
        this.f44037b.end();
        this.f44039d = true;
        this.f44036a.close();
    }

    public final void d() throws IOException {
        int i10 = this.f44038c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f44037b.getRemaining();
        this.f44038c -= remaining;
        this.f44036a.skip(remaining);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a0(@yt.k t0 source, @yt.k Inflater inflater) {
        this(f0.e(source), inflater);
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(inflater, "inflater");
    }
}
