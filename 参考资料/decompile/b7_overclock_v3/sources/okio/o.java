package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0003R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001a¨\u0006\u001f"}, d2 = {"Lokio/o;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "c", "()V", "close", "Lokio/v0;", "U", "", "toString", "", "syncFlush", "a", "Lokio/k;", "Lokio/k;", "sink", "Ljava/util/zip/Deflater;", "b", "Ljava/util/zip/Deflater;", "deflater", "Z", "closed", "<init>", "(Lokio/k;Ljava/util/zip/Deflater;)V", "(Lokio/r0;Ljava/util/zip/Deflater;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class o implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final k f44164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Deflater f44165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44166c;

    public o(@yt.k k sink, @yt.k Deflater deflater) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(deflater, "deflater");
        this.f44164a = sink;
        this.f44165b = deflater;
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44164a.U();
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        a1.e(source.m2(), 0L, j10);
        while (j10 > 0) {
            p0 p0Var = source.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            this.f44165b.setInput(p0Var.f44174a, p0Var.f44175b, iMin);
            a(false);
            long j11 = iMin;
            source.i2(source.m2() - j11);
            int i10 = p0Var.f44175b + iMin;
            p0Var.f44175b = i10;
            if (i10 == p0Var.f44176c) {
                source.f44116a = p0Var.b();
                q0.d(p0Var);
            }
            j10 -= j11;
        }
    }

    @IgnoreJRERequirement
    public final void a(boolean z10) throws IOException {
        p0 p0VarP2;
        int iDeflate;
        j jVarG = this.f44164a.g();
        while (true) {
            p0VarP2 = jVarG.p2(1);
            if (z10) {
                Deflater deflater = this.f44165b;
                byte[] bArr = p0VarP2.f44174a;
                int i10 = p0VarP2.f44176c;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                Deflater deflater2 = this.f44165b;
                byte[] bArr2 = p0VarP2.f44174a;
                int i11 = p0VarP2.f44176c;
                iDeflate = deflater2.deflate(bArr2, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                p0VarP2.f44176c += iDeflate;
                jVarG.i2(jVarG.m2() + ((long) iDeflate));
                this.f44164a.l0();
            } else if (this.f44165b.needsInput()) {
                break;
            }
        }
        if (p0VarP2.f44175b == p0VarP2.f44176c) {
            jVarG.f44116a = p0VarP2.b();
            q0.d(p0VarP2);
        }
    }

    public final void c() throws IOException {
        this.f44165b.finish();
        a(false);
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f44166c) {
            return;
        }
        Throwable th2 = null;
        try {
            c();
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            this.f44165b.end();
        } catch (Throwable th4) {
            if (th2 == null) {
                th2 = th4;
            }
        }
        try {
            this.f44164a.close();
        } catch (Throwable th5) {
            if (th2 == null) {
                th2 = th5;
            }
        }
        this.f44166c = true;
        if (th2 != null) {
            throw th2;
        }
    }

    @Override // okio.r0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f44164a.flush();
    }

    @yt.k
    public String toString() {
        return "DeflaterSink(" + this.f44164a + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(@yt.k r0 sink, @yt.k Deflater deflater) {
        this(f0.d(sink), deflater);
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(deflater, "deflater");
    }
}
