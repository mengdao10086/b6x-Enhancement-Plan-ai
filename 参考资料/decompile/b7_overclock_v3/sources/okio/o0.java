package okio;

import com.blankj.utilcode.util.ThreadUtils;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010P\u001a\u00020M¢\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0016H\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016J\n\u0010'\u001a\u0004\u0018\u00010 H\u0016J\b\u0010(\u001a\u00020 H\u0016J\u0010\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\u0014H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\rH\u0016J\u0018\u00109\u001a\u00020\u00052\u0006\u00106\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0005H\u0016J \u0010;\u001a\u00020\u00052\u0006\u00106\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u000fH\u0016J\u0018\u0010>\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0005H\u0016J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u000fH\u0016J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0005H\u0016J\u0018\u0010B\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u000fH\u0016J(\u0010D\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0014H\u0016J\b\u0010E\u001a\u00020\u0001H\u0016J\b\u0010G\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020 H\u0016R\u0014\u0010P\u001a\u00020M8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010QR\u0016\u0010U\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bV\u0010W¨\u0006]"}, d2 = {"Lokio/o0;", "Lokio/l;", "Lokio/j;", "e", "sink", "", "byteCount", "F1", "", "d0", "Lkotlin/z1;", "U1", SocialConstants.TYPE_REQUEST, "", "readByte", "Lokio/ByteString;", "Z0", "y", "Lokio/i0;", "options", "", "g2", "", i1.a.R4, "w1", "read", "readFully", w.c.R, "Ljava/nio/ByteBuffer;", "g0", "Lokio/r0;", "J1", "", "y1", "q", "Ljava/nio/charset/Charset;", "charset", "O0", "A1", xf.k0.f55262g, "n1", "limit", "r0", "U0", "", "readShort", "E1", "readInt", m9.h.f40773p, "readLong", "H1", "n0", "d2", com.google.android.material.timepicker.d.C2, "b", "b2", "fromIndex", "f0", "toIndex", "h0", "bytes", i1.a.X4, an.aB, "targetBytes", "j0", "T1", "N0", "bytesOffset", "r1", "peek", "Ljava/io/InputStream;", "e2", "isOpen", "close", "Lokio/v0;", "U", "toString", "Lokio/t0;", "a", "Lokio/t0;", "source", "Lokio/j;", "bufferField", "c", "Z", "closed", "g", "()Lokio/j;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/t0;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class o0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final t0 f44167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public final j f44168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public boolean f44169c;

    public o0(@yt.k t0 source) {
        kotlin.jvm.internal.f0.p(source, "source");
        this.f44167a = source;
        this.f44168b = new j();
    }

    public static /* synthetic */ void a() {
    }

    @Override // okio.l
    @yt.k
    public String A1(long j10, @yt.k Charset charset) throws EOFException {
        kotlin.jvm.internal.f0.p(charset, "charset");
        U1(j10);
        return this.f44168b.A1(j10, charset);
    }

    @Override // okio.l
    public short E1() throws EOFException {
        U1(2L);
        return this.f44168b.E1();
    }

    @Override // okio.t0
    public long F1(@yt.k j sink, long j10) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(true ^ this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f44168b.m2() == 0 && this.f44167a.F1(this.f44168b, 8192L) == -1) {
            return -1L;
        }
        return this.f44168b.F1(sink, Math.min(j10, this.f44168b.m2()));
    }

    @Override // okio.l
    public long H1() throws EOFException {
        U1(8L);
        return this.f44168b.H1();
    }

    @Override // okio.l
    public long J1(@yt.k r0 sink) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        long j10 = 0;
        while (this.f44167a.F1(this.f44168b, 8192L) != -1) {
            long jH = this.f44168b.h();
            if (jH > 0) {
                j10 += jH;
                sink.V0(this.f44168b, jH);
            }
        }
        if (this.f44168b.m2() <= 0) {
            return j10;
        }
        long jM2 = j10 + this.f44168b.m2();
        j jVar = this.f44168b;
        sink.V0(jVar, jVar.m2());
        return jM2;
    }

    @Override // okio.l
    public boolean N0(long j10, @yt.k ByteString bytes) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        return r1(j10, bytes, 0, bytes.x0());
    }

    @Override // okio.l
    @yt.k
    public String O0(@yt.k Charset charset) throws IOException {
        kotlin.jvm.internal.f0.p(charset, "charset");
        this.f44168b.X0(this.f44167a);
        return this.f44168b.O0(charset);
    }

    @Override // okio.l
    @yt.k
    public byte[] S() throws IOException {
        this.f44168b.X0(this.f44167a);
        return this.f44168b.S();
    }

    @Override // okio.l
    public long T1(@yt.k ByteString targetBytes, long j10) {
        kotlin.jvm.internal.f0.p(targetBytes, "targetBytes");
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jT1 = this.f44168b.T1(targetBytes, j10);
            if (jT1 != -1) {
                return jT1;
            }
            long jM2 = this.f44168b.m2();
            if (this.f44167a.F1(this.f44168b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, jM2);
        }
    }

    @Override // okio.t0
    @yt.k
    public v0 U() {
        return this.f44167a.U();
    }

    @Override // okio.l
    public int U0() throws EOFException {
        U1(1L);
        byte bD1 = this.f44168b.d1(0L);
        if ((bD1 & 224) == 192) {
            U1(2L);
        } else if ((bD1 & 240) == 224) {
            U1(3L);
        } else if ((bD1 & ThreadUtils.f11619i) == 240) {
            U1(4L);
        }
        return this.f44168b.U0();
    }

    @Override // okio.l
    public void U1(long j10) throws EOFException {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // okio.l
    public long V(@yt.k ByteString bytes) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        return s(bytes, 0L);
    }

    @Override // okio.l
    @yt.k
    public ByteString Z0() throws IOException {
        this.f44168b.X0(this.f44167a);
        return this.f44168b.Z0();
    }

    @Override // okio.l
    public long b2(byte b10) {
        return h0(b10, 0L, Long.MAX_VALUE);
    }

    @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f44169c) {
            return;
        }
        this.f44169c = true;
        this.f44167a.close();
        this.f44168b.d();
    }

    @Override // okio.l
    public boolean d0() {
        if (!this.f44169c) {
            return this.f44168b.d0() && this.f44167a.F1(this.f44168b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.l
    public long d2() throws EOFException {
        byte bD1;
        U1(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request(i11)) {
                break;
            }
            bD1 = this.f44168b.d1(i10);
            if ((bD1 < ((byte) 48) || bD1 > ((byte) 57)) && ((bD1 < ((byte) 97) || bD1 > ((byte) 102)) && (bD1 < ((byte) 65) || bD1 > ((byte) 70)))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            String string = Integer.toString(bD1, kotlin.text.b.a(kotlin.text.b.a(16)));
            kotlin.jvm.internal.f0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(kotlin.jvm.internal.f0.C("Expected leading [0-9a-fA-F] character but was 0x", string));
        }
        return this.f44168b.d2();
    }

    @Override // okio.l, okio.k
    @yt.k
    public j e() {
        return this.f44168b;
    }

    @Override // okio.l
    @yt.k
    public InputStream e2() {
        return new a();
    }

    @Override // okio.l
    public long f0(byte b10, long j10) {
        return h0(b10, j10, Long.MAX_VALUE);
    }

    @Override // okio.l, okio.k
    @yt.k
    public j g() {
        return this.f44168b;
    }

    @Override // okio.l
    public void g0(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        try {
            U1(j10);
            this.f44168b.g0(sink, j10);
        } catch (EOFException e10) {
            sink.X0(this.f44168b);
            throw e10;
        }
    }

    @Override // okio.l
    public int g2(@yt.k i0 options) throws EOFException {
        kotlin.jvm.internal.f0.p(options, "options");
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iL0 = okio.internal.d.l0(this.f44168b, options, true);
            if (iL0 != -2) {
                if (iL0 != -1) {
                    this.f44168b.skip(options.l()[iL0].x0());
                    return iL0;
                }
            } else if (this.f44167a.F1(this.f44168b, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // okio.l
    public long h0(byte b10, long j10, long j11) {
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j10 && j10 <= j11)) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jH0 = this.f44168b.h0(b10, j10, j11);
            if (jH0 != -1) {
                return jH0;
            }
            long jM2 = this.f44168b.m2();
            if (jM2 >= j11 || this.f44167a.F1(this.f44168b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, jM2);
        }
        return -1L;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f44169c;
    }

    @Override // okio.l
    public long j0(@yt.k ByteString targetBytes) {
        kotlin.jvm.internal.f0.p(targetBytes, "targetBytes");
        return T1(targetBytes, 0L);
    }

    @Override // okio.l
    @yt.l
    public String k0() {
        long jB2 = b2((byte) 10);
        if (jB2 != -1) {
            return okio.internal.d.j0(this.f44168b, jB2);
        }
        if (this.f44168b.m2() != 0) {
            return q(this.f44168b.m2());
        }
        return null;
    }

    @Override // okio.l
    public long n0() throws EOFException {
        byte bD1;
        U1(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!request(j11)) {
                break;
            }
            bD1 = this.f44168b.d1(j10);
            if ((bD1 < ((byte) 48) || bD1 > ((byte) 57)) && !(j10 == 0 && bD1 == ((byte) 45))) {
                break;
            }
            j10 = j11;
        }
        if (j10 == 0) {
            String string = Integer.toString(bD1, kotlin.text.b.a(kotlin.text.b.a(16)));
            kotlin.jvm.internal.f0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(kotlin.jvm.internal.f0.C("Expected a digit or '-' but was 0x", string));
        }
        return this.f44168b.n0();
    }

    @Override // okio.l
    @yt.k
    public String n1() {
        return r0(Long.MAX_VALUE);
    }

    @Override // okio.l
    @yt.k
    public l peek() {
        return f0.e(new l0(this));
    }

    @Override // okio.l
    @yt.k
    public String q(long j10) throws EOFException {
        U1(j10);
        return this.f44168b.q(j10);
    }

    @Override // okio.l
    public int q1() throws EOFException {
        U1(4L);
        return this.f44168b.q1();
    }

    @Override // okio.l
    @yt.k
    public String r0(long j10) throws EOFException {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        byte b10 = (byte) 10;
        long jH0 = h0(b10, 0L, j11);
        if (jH0 != -1) {
            return okio.internal.d.j0(this.f44168b, jH0);
        }
        if (j11 < Long.MAX_VALUE && request(j11) && this.f44168b.d1(j11 - 1) == ((byte) 13) && request(1 + j11) && this.f44168b.d1(j11) == b10) {
            return okio.internal.d.j0(this.f44168b, j11);
        }
        j jVar = new j();
        j jVar2 = this.f44168b;
        jVar2.u(jVar, 0L, Math.min(32, jVar2.m2()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f44168b.m2(), j10) + " content=" + jVar.Z0().B() + kotlin.text.y.F);
    }

    @Override // okio.l
    public boolean r1(long j10, @yt.k ByteString bytes, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 >= 0 && i10 >= 0 && i11 >= 0 && bytes.x0() - i10 >= i11) {
            if (i11 <= 0) {
                return true;
            }
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                long j11 = ((long) i12) + j10;
                if (!request(1 + j11) || this.f44168b.d1(j11) != bytes.v(i12 + i10)) {
                    break;
                }
                if (i13 >= i11) {
                    return true;
                }
                i12 = i13;
            }
        }
        return false;
    }

    @Override // okio.l
    public int read(@yt.k byte[] sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.l
    public byte readByte() throws EOFException {
        U1(1L);
        return this.f44168b.readByte();
    }

    @Override // okio.l
    public void readFully(@yt.k byte[] sink) throws EOFException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        try {
            U1(sink.length);
            this.f44168b.readFully(sink);
        } catch (EOFException e10) {
            int i10 = 0;
            while (this.f44168b.m2() > 0) {
                j jVar = this.f44168b;
                int i11 = jVar.read(sink, i10, (int) jVar.m2());
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
            throw e10;
        }
    }

    @Override // okio.l
    public int readInt() throws EOFException {
        U1(4L);
        return this.f44168b.readInt();
    }

    @Override // okio.l
    public long readLong() throws EOFException {
        U1(8L);
        return this.f44168b.readLong();
    }

    @Override // okio.l
    public short readShort() throws EOFException {
        U1(2L);
        return this.f44168b.readShort();
    }

    @Override // okio.l
    public boolean request(long j10) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f44168b.m2() < j10) {
            if (this.f44167a.F1(this.f44168b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.l
    public long s(@yt.k ByteString bytes, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(bytes, "bytes");
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jS = this.f44168b.s(bytes, j10);
            if (jS != -1) {
                return jS;
            }
            long jM2 = this.f44168b.m2();
            if (this.f44167a.F1(this.f44168b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (jM2 - ((long) bytes.x0())) + 1);
        }
    }

    @Override // okio.l
    public void skip(long j10) throws EOFException {
        if (!(!this.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            if (this.f44168b.m2() == 0 && this.f44167a.F1(this.f44168b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f44168b.m2());
            this.f44168b.skip(jMin);
            j10 -= jMin;
        }
    }

    @yt.k
    public String toString() {
        return "buffer(" + this.f44167a + ')';
    }

    @Override // okio.l
    @yt.k
    public byte[] w1(long j10) throws EOFException {
        U1(j10);
        return this.f44168b.w1(j10);
    }

    @Override // okio.l
    @yt.k
    public ByteString y(long j10) throws EOFException {
        U1(j10);
        return this.f44168b.y(j10);
    }

    @Override // okio.l
    @yt.k
    public String y1() throws IOException {
        this.f44168b.X0(this.f44167a);
        return this.f44168b.y1();
    }

    @Override // okio.l
    public int read(@yt.k byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        long j10 = i11;
        a1.e(sink.length, i10, j10);
        if (this.f44168b.m2() == 0 && this.f44167a.F1(this.f44168b, 8192L) == -1) {
            return -1;
        }
        return this.f44168b.read(sink, i10, (int) Math.min(j10, this.f44168b.m2()));
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"okio/o0$a", "Ljava/io/InputStream;", "", "read", "", "data", w.c.R, "byteCount", "available", "Lkotlin/z1;", "close", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            o0 o0Var = o0.this;
            if (o0Var.f44169c) {
                throw new IOException("closed");
            }
            return (int) Math.min(o0Var.f44168b.m2(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            o0.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            o0 o0Var = o0.this;
            if (o0Var.f44169c) {
                throw new IOException("closed");
            }
            if (o0Var.f44168b.m2() == 0) {
                o0 o0Var2 = o0.this;
                if (o0Var2.f44167a.F1(o0Var2.f44168b, 8192L) == -1) {
                    return -1;
                }
            }
            return o0.this.f44168b.readByte() & 255;
        }

        @yt.k
        public String toString() {
            return o0.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@yt.k byte[] data, int i10, int i11) throws IOException {
            kotlin.jvm.internal.f0.p(data, "data");
            if (!o0.this.f44169c) {
                a1.e(data.length, i10, i11);
                if (o0.this.f44168b.m2() == 0) {
                    o0 o0Var = o0.this;
                    if (o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                        return -1;
                    }
                }
                return o0.this.f44168b.read(data, i10, i11);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@yt.k ByteBuffer sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (this.f44168b.m2() == 0 && this.f44167a.F1(this.f44168b, 8192L) == -1) {
            return -1;
        }
        return this.f44168b.read(sink);
    }
}
