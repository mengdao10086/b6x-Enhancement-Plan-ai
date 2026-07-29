package okio;

import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J(\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001eH\u0016J\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0001H\u0016J\b\u0010/\u001a\u00020\u0001H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u000fH\u0016R\u0014\u0010<\u001a\u0002098\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010=R\u0016\u0010A\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bD\u0010E\u001a\u0004\bB\u0010C¨\u0006I"}, d2 = {"Lokio/n0;", "Lokio/k;", "Lokio/j;", "e", "source", "", "byteCount", "Lkotlin/z1;", "V0", "Lokio/ByteString;", "byteString", "B1", "", w.c.R, "J", "", w.b.f53669e, "H0", "beginIndex", "endIndex", "W0", "codePoint", "H", "Ljava/nio/charset/Charset;", "charset", "a1", "S1", "", "write", "Ljava/nio/ByteBuffer;", "Lokio/t0;", "X0", m9.h.A, "b", "writeByte", an.aB, "writeShort", "D0", "i", "writeInt", "c0", "v", "writeLong", "N", "W1", "Y0", "l0", i1.a.S4, "Ljava/io/OutputStream;", "a2", "flush", "", "isOpen", "close", "Lokio/v0;", "U", "toString", "Lokio/r0;", "a", "Lokio/r0;", "sink", "Lokio/j;", "bufferField", "c", "Z", "closed", "g", "()Lokio/j;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/r0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class n0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final r0 f44160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public final j f44161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public boolean f44162c;

    public n0(@yt.k r0 sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        this.f44160a = sink;
        this.f44161b = new j();
    }

    public static /* synthetic */ void a() {
    }

    @Override // okio.k
    @yt.k
    public k B1(@yt.k ByteString byteString) {
        kotlin.jvm.internal.f0.p(byteString, "byteString");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.B1(byteString);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k D0(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.D0(i10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k E() throws IOException {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM2 = this.f44161b.m2();
        if (jM2 > 0) {
            this.f44160a.V0(this.f44161b, jM2);
        }
        return this;
    }

    @Override // okio.k
    @yt.k
    public k H(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.H(i10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k H0(@yt.k String string) {
        kotlin.jvm.internal.f0.p(string, "string");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.H0(string);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k J(@yt.k ByteString byteString, int i10, int i11) {
        kotlin.jvm.internal.f0.p(byteString, "byteString");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.J(byteString, i10, i11);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k N(long j10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.N(j10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k S1(@yt.k String string, int i10, int i11, @yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(string, "string");
        kotlin.jvm.internal.f0.p(charset, "charset");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.S1(string, i10, i11, charset);
        return l0();
    }

    @Override // okio.r0
    @yt.k
    public v0 U() {
        return this.f44160a.U();
    }

    @Override // okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.V0(source, j10);
        l0();
    }

    @Override // okio.k
    @yt.k
    public k W0(@yt.k String string, int i10, int i11) {
        kotlin.jvm.internal.f0.p(string, "string");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.W0(string, i10, i11);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k W1(long j10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.W1(j10);
        return l0();
    }

    @Override // okio.k
    public long X0(@yt.k t0 source) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        long j10 = 0;
        while (true) {
            long jF1 = source.F1(this.f44161b, 8192L);
            if (jF1 == -1) {
                return j10;
            }
            j10 += jF1;
            l0();
        }
    }

    @Override // okio.k
    @yt.k
    public k Y0(long j10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.Y0(j10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k a1(@yt.k String string, @yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(string, "string");
        kotlin.jvm.internal.f0.p(charset, "charset");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.a1(string, charset);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public OutputStream a2() {
        return new a();
    }

    @Override // okio.k
    @yt.k
    public k c0(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.c0(i10);
        return l0();
    }

    @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f44162c) {
            return;
        }
        Throwable th2 = null;
        try {
            if (this.f44161b.m2() > 0) {
                r0 r0Var = this.f44160a;
                j jVar = this.f44161b;
                r0Var.V0(jVar, jVar.m2());
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            this.f44160a.close();
        } catch (Throwable th4) {
            if (th2 == null) {
                th2 = th4;
            }
        }
        this.f44162c = true;
        if (th2 != null) {
            throw th2;
        }
    }

    @Override // okio.k
    @yt.k
    public j e() {
        return this.f44161b;
    }

    @Override // okio.k, okio.r0, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f44161b.m2() > 0) {
            r0 r0Var = this.f44160a;
            j jVar = this.f44161b;
            r0Var.V0(jVar, jVar.m2());
        }
        this.f44160a.flush();
    }

    @Override // okio.k
    @yt.k
    public j g() {
        return this.f44161b;
    }

    @Override // okio.k
    @yt.k
    public k g1(@yt.k t0 source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        while (j10 > 0) {
            long jF1 = source.F1(this.f44161b, j10);
            if (jF1 == -1) {
                throw new EOFException();
            }
            j10 -= jF1;
            l0();
        }
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f44162c;
    }

    @Override // okio.k
    @yt.k
    public k l0() throws IOException {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jH = this.f44161b.h();
        if (jH > 0) {
            this.f44160a.V0(this.f44161b, jH);
        }
        return this;
    }

    @yt.k
    public String toString() {
        return "buffer(" + this.f44160a + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@yt.k ByteBuffer source) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f44161b.write(source);
        l0();
        return iWrite;
    }

    @Override // okio.k
    @yt.k
    public k writeByte(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.writeByte(i10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k writeInt(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.writeInt(i10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k writeLong(long j10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.writeLong(j10);
        return l0();
    }

    @Override // okio.k
    @yt.k
    public k writeShort(int i10) {
        if (!(!this.f44162c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f44161b.writeShort(i10);
        return l0();
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"okio/n0$a", "Ljava/io/OutputStream;", "", "b", "Lkotlin/z1;", "write", "", "data", w.c.R, "byteCount", "flush", "close", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            n0.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            n0 n0Var = n0.this;
            if (n0Var.f44162c) {
                return;
            }
            n0Var.flush();
        }

        @yt.k
        public String toString() {
            return n0.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            n0 n0Var = n0.this;
            if (n0Var.f44162c) {
                throw new IOException("closed");
            }
            n0Var.f44161b.writeByte((byte) i10);
            n0.this.l0();
        }

        @Override // java.io.OutputStream
        public void write(@yt.k byte[] data, int i10, int i11) throws IOException {
            kotlin.jvm.internal.f0.p(data, "data");
            n0 n0Var = n0.this;
            if (!n0Var.f44162c) {
                n0Var.f44161b.write(data, i10, i11);
                n0.this.l0();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // okio.k
    @yt.k
    public k write(@yt.k byte[] source) {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!this.f44162c) {
            this.f44161b.write(source);
            return l0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.k
    @yt.k
    public k write(@yt.k byte[] source, int i10, int i11) {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!this.f44162c) {
            this.f44161b.write(source, i10, i11);
            return l0();
        }
        throw new IllegalStateException("closed".toString());
    }
}
