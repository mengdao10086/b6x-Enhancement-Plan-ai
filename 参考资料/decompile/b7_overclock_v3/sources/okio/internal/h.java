package okio.internal;

import com.blankj.utilcode.util.ThreadUtils;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.y;
import m0.k;
import okio.ByteString;
import okio.a1;
import okio.i0;
import okio.l0;
import okio.o0;
import okio.r0;
import okio.v0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0080\b\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\r\u0010\f\u001a\u00020\u000b*\u00020\u0000H\u0080\b\u001a\r\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0080\b\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0080\b\u001a\r\u0010\u0015\u001a\u00020\u0014*\u00020\u0000H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0019\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001e\u001a\u00020\u001d*\u00020\u0000H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a\u000f\u0010 \u001a\u0004\u0018\u00010\u001d*\u00020\u0000H\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u001d*\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0080\b\u001a\r\u0010#\u001a\u00020\u0012*\u00020\u0000H\u0080\b\u001a\r\u0010%\u001a\u00020$*\u00020\u0000H\u0080\b\u001a\r\u0010&\u001a\u00020$*\u00020\u0000H\u0080\b\u001a\r\u0010'\u001a\u00020\u0012*\u00020\u0000H\u0080\b\u001a\r\u0010(\u001a\u00020\u0012*\u00020\u0000H\u0080\b\u001a\r\u0010)\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\r\u0010*\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\r\u0010+\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\r\u0010,\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\u0015\u0010-\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\b\u001a%\u00100\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0080\b\u001a\u001d\u00102\u001a\u00020\u0003*\u00020\u00002\u0006\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0003H\u0080\b\u001a\u001d\u00104\u001a\u00020\u0003*\u00020\u00002\u0006\u00103\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0003H\u0080\b\u001a-\u00106\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u00101\u001a\u00020\r2\u0006\u00105\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0012H\u0080\b\u001a\r\u00108\u001a\u000207*\u00020\u0000H\u0080\b\u001a\r\u00109\u001a\u00020\b*\u00020\u0000H\u0080\b\u001a\r\u0010;\u001a\u00020:*\u00020\u0000H\u0080\b\u001a\r\u0010<\u001a\u00020\u001d*\u00020\u0000H\u0080\b¨\u0006="}, d2 = {"Lokio/o0;", "Lokio/j;", "sink", "", "byteCount", "i", "", "b", "Lkotlin/z1;", "F", i1.a.S4, "", "k", "Lokio/ByteString;", "n", "o", "Lokio/i0;", "options", "", "G", "", l.f16298a, k.f40564b, SsManifestParser.e.J, w.c.R, "h", "q", "Lokio/r0;", xf.j.f55230b, "", an.aD, i1.a.W4, "C", "limit", "D", "B", "", "x", "y", "t", "u", "v", "w", "p", an.aB, "H", "fromIndex", "toIndex", "c", "bytes", "d", "targetBytes", "e", "bytesOffset", "g", "Lokio/l;", "f", "a", "Lokio/v0;", "I", "J", "okio"}, k = 2, mv = {1, 5, 1})
public final class h {
    @yt.k
    public static final String A(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(j10);
        return o0Var.f44168b.q(j10);
    }

    public static final int B(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(1L);
        byte bD1 = o0Var.f44168b.d1(0L);
        if ((bD1 & 224) == 192) {
            o0Var.U1(2L);
        } else if ((bD1 & 240) == 224) {
            o0Var.U1(3L);
        } else if ((bD1 & ThreadUtils.f11619i) == 240) {
            o0Var.U1(4L);
        }
        return o0Var.f44168b.U0();
    }

    @yt.l
    public static final String C(@yt.k o0 o0Var) {
        f0.p(o0Var, "<this>");
        long jB2 = o0Var.b2((byte) 10);
        if (jB2 != -1) {
            return d.j0(o0Var.f44168b, jB2);
        }
        if (o0Var.f44168b.m2() != 0) {
            return o0Var.q(o0Var.f44168b.m2());
        }
        return null;
    }

    @yt.k
    public static final String D(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        byte b10 = (byte) 10;
        long jH0 = o0Var.h0(b10, 0L, j11);
        if (jH0 != -1) {
            return d.j0(o0Var.f44168b, jH0);
        }
        if (j11 < Long.MAX_VALUE && o0Var.request(j11) && o0Var.f44168b.d1(j11 - 1) == ((byte) 13) && o0Var.request(1 + j11) && o0Var.f44168b.d1(j11) == b10) {
            return d.j0(o0Var.f44168b, j11);
        }
        okio.j jVar = new okio.j();
        okio.j jVar2 = o0Var.f44168b;
        jVar2.u(jVar, 0L, Math.min(32, jVar2.m2()));
        throw new EOFException("\\n not found: limit=" + Math.min(o0Var.f44168b.m2(), j10) + " content=" + jVar.Z0().B() + y.F);
    }

    public static final boolean E(@yt.k o0 o0Var, long j10) {
        f0.p(o0Var, "<this>");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (o0Var.f44168b.m2() < j10) {
            if (o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void F(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        if (!o0Var.request(j10)) {
            throw new EOFException();
        }
    }

    public static final int G(@yt.k o0 o0Var, @yt.k i0 options) throws EOFException {
        f0.p(o0Var, "<this>");
        f0.p(options, "options");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iL0 = d.l0(o0Var.f44168b, options, true);
            if (iL0 != -2) {
                if (iL0 == -1) {
                    return -1;
                }
                o0Var.f44168b.skip(options.l()[iL0].x0());
                return iL0;
            }
        } while (o0Var.f44167a.F1(o0Var.f44168b, 8192L) != -1);
        return -1;
    }

    public static final void H(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            if (o0Var.f44168b.m2() == 0 && o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, o0Var.f44168b.m2());
            o0Var.f44168b.skip(jMin);
            j10 -= jMin;
        }
    }

    @yt.k
    public static final v0 I(@yt.k o0 o0Var) {
        f0.p(o0Var, "<this>");
        return o0Var.f44167a.U();
    }

    @yt.k
    public static final String J(@yt.k o0 o0Var) {
        f0.p(o0Var, "<this>");
        return "buffer(" + o0Var.f44167a + ')';
    }

    public static final void a(@yt.k o0 o0Var) throws IOException {
        f0.p(o0Var, "<this>");
        if (o0Var.f44169c) {
            return;
        }
        o0Var.f44169c = true;
        o0Var.f44167a.close();
        o0Var.f44168b.d();
    }

    public static final boolean b(@yt.k o0 o0Var) {
        f0.p(o0Var, "<this>");
        if (!o0Var.f44169c) {
            return o0Var.f44168b.d0() && o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long c(@yt.k o0 o0Var, byte b10, long j10, long j11) {
        f0.p(o0Var, "<this>");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j10 && j10 <= j11)) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jH0 = o0Var.f44168b.h0(b10, j10, j11);
            if (jH0 != -1) {
                return jH0;
            }
            long jM2 = o0Var.f44168b.m2();
            if (jM2 >= j11 || o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                break;
            }
            j10 = Math.max(j10, jM2);
        }
        return -1L;
    }

    public static final long d(@yt.k o0 o0Var, @yt.k ByteString bytes, long j10) throws IOException {
        f0.p(o0Var, "<this>");
        f0.p(bytes, "bytes");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jS = o0Var.f44168b.s(bytes, j10);
            if (jS != -1) {
                return jS;
            }
            long jM2 = o0Var.f44168b.m2();
            if (o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (jM2 - ((long) bytes.x0())) + 1);
        }
    }

    public static final long e(@yt.k o0 o0Var, @yt.k ByteString targetBytes, long j10) {
        f0.p(o0Var, "<this>");
        f0.p(targetBytes, "targetBytes");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jT1 = o0Var.f44168b.T1(targetBytes, j10);
            if (jT1 != -1) {
                return jT1;
            }
            long jM2 = o0Var.f44168b.m2();
            if (o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, jM2);
        }
    }

    @yt.k
    public static final okio.l f(@yt.k o0 o0Var) {
        f0.p(o0Var, "<this>");
        return okio.f0.e(new l0(o0Var));
    }

    public static final boolean g(@yt.k o0 o0Var, long j10, @yt.k ByteString bytes, int i10, int i11) {
        f0.p(o0Var, "<this>");
        f0.p(bytes, "bytes");
        if (!(!o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || bytes.x0() - i10 < i11) {
            return false;
        }
        if (i11 > 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                long j11 = ((long) i12) + j10;
                if (!o0Var.request(1 + j11) || o0Var.f44168b.d1(j11) != bytes.v(i12 + i10)) {
                    return false;
                }
                if (i13 >= i11) {
                    break;
                }
                i12 = i13;
            }
        }
        return true;
    }

    public static final int h(@yt.k o0 o0Var, @yt.k byte[] sink, int i10, int i11) {
        f0.p(o0Var, "<this>");
        f0.p(sink, "sink");
        long j10 = i11;
        a1.e(sink.length, i10, j10);
        if (o0Var.f44168b.m2() == 0 && o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
            return -1;
        }
        return o0Var.f44168b.read(sink, i10, (int) Math.min(j10, o0Var.f44168b.m2()));
    }

    public static final long i(@yt.k o0 o0Var, @yt.k okio.j sink, long j10) {
        f0.p(o0Var, "<this>");
        f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (!(true ^ o0Var.f44169c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (o0Var.f44168b.m2() == 0 && o0Var.f44167a.F1(o0Var.f44168b, 8192L) == -1) {
            return -1L;
        }
        return o0Var.f44168b.F1(sink, Math.min(j10, o0Var.f44168b.m2()));
    }

    public static final long j(@yt.k o0 o0Var, @yt.k r0 sink) throws IOException {
        f0.p(o0Var, "<this>");
        f0.p(sink, "sink");
        long j10 = 0;
        while (o0Var.f44167a.F1(o0Var.f44168b, 8192L) != -1) {
            long jH = o0Var.f44168b.h();
            if (jH > 0) {
                j10 += jH;
                sink.V0(o0Var.f44168b, jH);
            }
        }
        if (o0Var.f44168b.m2() <= 0) {
            return j10;
        }
        long jM2 = j10 + o0Var.f44168b.m2();
        okio.j jVar = o0Var.f44168b;
        sink.V0(jVar, jVar.m2());
        return jM2;
    }

    public static final byte k(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(1L);
        return o0Var.f44168b.readByte();
    }

    @yt.k
    public static final byte[] l(@yt.k o0 o0Var) throws IOException {
        f0.p(o0Var, "<this>");
        o0Var.f44168b.X0(o0Var.f44167a);
        return o0Var.f44168b.S();
    }

    @yt.k
    public static final byte[] m(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(j10);
        return o0Var.f44168b.w1(j10);
    }

    @yt.k
    public static final ByteString n(@yt.k o0 o0Var) throws IOException {
        f0.p(o0Var, "<this>");
        o0Var.f44168b.X0(o0Var.f44167a);
        return o0Var.f44168b.Z0();
    }

    @yt.k
    public static final ByteString o(@yt.k o0 o0Var, long j10) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(j10);
        return o0Var.f44168b.y(j10);
    }

    public static final long p(@yt.k o0 o0Var) throws EOFException {
        byte bD1;
        f0.p(o0Var, "<this>");
        o0Var.U1(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!o0Var.request(j11)) {
                break;
            }
            bD1 = o0Var.f44168b.d1(j10);
            if ((bD1 < ((byte) 48) || bD1 > ((byte) 57)) && !(j10 == 0 && bD1 == ((byte) 45))) {
                break;
            }
            j10 = j11;
        }
        if (j10 == 0) {
            String string = Integer.toString(bD1, kotlin.text.b.a(kotlin.text.b.a(16)));
            f0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(f0.C("Expected a digit or '-' but was 0x", string));
        }
        return o0Var.f44168b.n0();
    }

    public static final void q(@yt.k o0 o0Var, @yt.k okio.j sink, long j10) throws IOException {
        f0.p(o0Var, "<this>");
        f0.p(sink, "sink");
        try {
            o0Var.U1(j10);
            o0Var.f44168b.g0(sink, j10);
        } catch (EOFException e10) {
            sink.X0(o0Var.f44168b);
            throw e10;
        }
    }

    public static final void r(@yt.k o0 o0Var, @yt.k byte[] sink) throws EOFException {
        f0.p(o0Var, "<this>");
        f0.p(sink, "sink");
        try {
            o0Var.U1(sink.length);
            o0Var.f44168b.readFully(sink);
        } catch (EOFException e10) {
            int i10 = 0;
            while (o0Var.f44168b.m2() > 0) {
                okio.j jVar = o0Var.f44168b;
                int i11 = jVar.read(sink, i10, (int) jVar.m2());
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
            throw e10;
        }
    }

    public static final long s(@yt.k o0 o0Var) throws EOFException {
        byte bD1;
        f0.p(o0Var, "<this>");
        o0Var.U1(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!o0Var.request(i11)) {
                break;
            }
            bD1 = o0Var.f44168b.d1(i10);
            if ((bD1 < ((byte) 48) || bD1 > ((byte) 57)) && ((bD1 < ((byte) 97) || bD1 > ((byte) 102)) && (bD1 < ((byte) 65) || bD1 > ((byte) 70)))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            String string = Integer.toString(bD1, kotlin.text.b.a(kotlin.text.b.a(16)));
            f0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(f0.C("Expected leading [0-9a-fA-F] character but was 0x", string));
        }
        return o0Var.f44168b.d2();
    }

    public static final int t(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(4L);
        return o0Var.f44168b.readInt();
    }

    public static final int u(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(4L);
        return o0Var.f44168b.q1();
    }

    public static final long v(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(8L);
        return o0Var.f44168b.readLong();
    }

    public static final long w(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(8L);
        return o0Var.f44168b.H1();
    }

    public static final short x(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(2L);
        return o0Var.f44168b.readShort();
    }

    public static final short y(@yt.k o0 o0Var) throws EOFException {
        f0.p(o0Var, "<this>");
        o0Var.U1(2L);
        return o0Var.f44168b.E1();
    }

    @yt.k
    public static final String z(@yt.k o0 o0Var) throws IOException {
        f0.p(o0Var, "<this>");
        o0Var.f44168b.X0(o0Var.f44167a);
        return o0Var.f44168b.y1();
    }
}
