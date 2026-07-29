package okio;

import androidx.multidex.MultiDexExtractor;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\f8G¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lokio/w;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "Ljava/util/zip/Deflater;", "a", "()Ljava/util/zip/Deflater;", "f", "buffer", "d", "Lokio/n0;", "Lokio/n0;", "sink", "b", "Ljava/util/zip/Deflater;", "c", "deflater", "Lokio/o;", "Lokio/o;", "deflaterSink", "", "Z", "closed", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", MultiDexExtractor.f6375o, "<init>", "(Lokio/r0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class w implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final n0 f44224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Deflater f44225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final o f44226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f44227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final CRC32 f44228e;

    public w(@yt.k r0 sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        n0 n0Var = new n0(sink);
        this.f44224a = n0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f44225b = deflater;
        this.f44226c = new o((k) n0Var, deflater);
        this.f44228e = new CRC32();
        j jVar = n0Var.f44161b;
        jVar.writeShort(8075);
        jVar.writeByte(8);
        jVar.writeByte(0);
        jVar.writeInt(0);
        jVar.writeByte(0);
        jVar.writeByte(0);
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44224a.U();
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (j10 == 0) {
            return;
        }
        d(source, j10);
        this.f44226c.V0(source, j10);
    }

    @hk.h(name = "-deprecated_deflater")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "deflater", imports = {}))
    @yt.k
    public final Deflater a() {
        return this.f44225b;
    }

    @hk.h(name = "deflater")
    @yt.k
    public final Deflater c() {
        return this.f44225b;
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f44227d) {
            return;
        }
        Throwable th2 = null;
        try {
            this.f44226c.c();
            f();
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            this.f44225b.end();
        } catch (Throwable th4) {
            if (th2 == null) {
                th2 = th4;
            }
        }
        try {
            this.f44224a.close();
        } catch (Throwable th5) {
            if (th2 == null) {
                th2 = th5;
            }
        }
        this.f44227d = true;
        if (th2 != null) {
            throw th2;
        }
    }

    public final void d(j jVar, long j10) {
        p0 p0Var = jVar.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            this.f44228e.update(p0Var.f44174a, p0Var.f44175b, iMin);
            j10 -= (long) iMin;
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
        }
    }

    public final void f() {
        this.f44224a.c0((int) this.f44228e.getValue());
        this.f44224a.c0((int) this.f44225b.getBytesRead());
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() throws IOException {
        this.f44226c.flush();
    }
}
