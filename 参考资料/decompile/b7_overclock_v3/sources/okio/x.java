package okio;

import androidx.multidex.MultiDexExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lokio/x;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "c", "d", "buffer", w.c.R, "f", "", "name", "", "expected", "actual", "a", "", "B", "section", "Lokio/o0;", "b", "Lokio/o0;", "source", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/a0;", "Lokio/a0;", "inflaterSource", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", MultiDexExtractor.f6375o, "<init>", "(Lokio/t0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class x implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f44237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final o0 f44238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Inflater f44239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final a0 f44240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final CRC32 f44241e;

    public x(@yt.k t0 source) {
        kotlin.jvm.internal.f0.p(source, "source");
        o0 o0Var = new o0(source);
        this.f44238b = o0Var;
        Inflater inflater = new Inflater(true);
        this.f44239c = inflater;
        this.f44240d = new a0((l) o0Var, inflater);
        this.f44241e = new CRC32();
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f44237a == 0) {
            c();
            this.f44237a = (byte) 1;
        }
        if (this.f44237a == 1) {
            long jM2 = sink.m2();
            long jF1 = this.f44240d.F1(sink, j10);
            if (jF1 != -1) {
                f(sink, jM2, jF1);
                return jF1;
            }
            this.f44237a = (byte) 2;
        }
        if (this.f44237a == 2) {
            d();
            this.f44237a = (byte) 3;
            if (!this.f44238b.d0()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44238b.U();
    }

    public final void a(String str, int i10, int i11) throws IOException {
        if (i11 == i10) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
        kotlin.jvm.internal.f0.o(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    public final void c() throws IOException {
        this.f44238b.U1(10L);
        byte bD1 = this.f44238b.f44168b.d1(3L);
        boolean z10 = ((bD1 >> 1) & 1) == 1;
        if (z10) {
            f(this.f44238b.f44168b, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f44238b.readShort());
        this.f44238b.skip(8L);
        if (((bD1 >> 2) & 1) == 1) {
            this.f44238b.U1(2L);
            if (z10) {
                f(this.f44238b.f44168b, 0L, 2L);
            }
            long jE1 = this.f44238b.f44168b.E1();
            this.f44238b.U1(jE1);
            if (z10) {
                f(this.f44238b.f44168b, 0L, jE1);
            }
            this.f44238b.skip(jE1);
        }
        if (((bD1 >> 3) & 1) == 1) {
            long jB2 = this.f44238b.b2((byte) 0);
            if (jB2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                f(this.f44238b.f44168b, 0L, jB2 + 1);
            }
            this.f44238b.skip(jB2 + 1);
        }
        if (((bD1 >> 4) & 1) == 1) {
            long jB22 = this.f44238b.b2((byte) 0);
            if (jB22 == -1) {
                throw new EOFException();
            }
            if (z10) {
                f(this.f44238b.f44168b, 0L, jB22 + 1);
            }
            this.f44238b.skip(jB22 + 1);
        }
        if (z10) {
            a("FHCRC", this.f44238b.E1(), (short) this.f44241e.getValue());
            this.f44241e.reset();
        }
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44240d.close();
    }

    public final void d() throws IOException {
        a("CRC", this.f44238b.q1(), (int) this.f44241e.getValue());
        a("ISIZE", this.f44238b.q1(), (int) this.f44239c.getBytesWritten());
    }

    public final void f(j jVar, long j10, long j11) {
        p0 p0Var = jVar.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        while (true) {
            int i10 = p0Var.f44176c;
            int i11 = p0Var.f44175b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
        }
        while (j11 > 0) {
            int i12 = (int) (((long) p0Var.f44175b) + j10);
            int iMin = (int) Math.min(p0Var.f44176c - i12, j11);
            this.f44241e.update(p0Var.f44174a, i12, iMin);
            j11 -= (long) iMin;
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
            j10 = 0;
        }
    }
}
