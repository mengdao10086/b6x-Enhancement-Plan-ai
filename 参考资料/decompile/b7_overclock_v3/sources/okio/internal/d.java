package okio.internal;

import com.blankj.utilcode.util.ThreadUtils;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import ik.p;
import java.io.EOFException;
import java.io.IOException;
import kotlin.collections.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.y;
import m0.k;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;
import okio.a1;
import okio.i0;
import okio.j;
import okio.p0;
import okio.q0;
import okio.r0;
import okio.t0;
import okio.w0;
import okio.z0;
import w.w;
import xf.k0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a0\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aA\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000b2\u001a\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0011H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0018\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\bH\u0000\u001a%\u0010\u001c\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u001e*\u00020\nH\u0080\b\u001a\r\u0010!\u001a\u00020 *\u00020\nH\u0080\b\u001a\r\u0010\"\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a\r\u0010#\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\u0015\u0010%\u001a\u00020\u001e*\u00020\n2\u0006\u0010$\u001a\u00020\u000bH\u0080\b\u001a\r\u0010'\u001a\u00020&*\u00020\nH\u0080\b\u001a\u0015\u0010(\u001a\u00020&*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a)\u0010+\u001a\u00020\n*\u00020\n2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010.\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u0015\u00100\u001a\u00020\u0000*\u00020\n2\u0006\u0010/\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020\u0004H\u0080\b\u001a%\u00102\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\r\u00103\u001a\u00020\u0004*\u00020\nH\u0080\b\u001a\u0015\u0010,\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u00105\u001a\u00020\u0002*\u00020\n2\u0006\u00104\u001a\u00020\u0004H\u0080\b\u001a\u0015\u00106\u001a\u00020&*\u00020\n2\u0006\u00104\u001a\u00020\u0004H\u0080\b\u001a%\u00107\u001a\u00020\u0002*\u00020\n2\u0006\u00104\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\r\u00108\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u00109\u001a\u00020\u000b*\u00020\nH\u0080\b\u001a\r\u0010:\u001a\u00020)*\u00020\nH\u0080\b\u001a\u0015\u0010;\u001a\u00020)*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010<\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0080\b\u001a\u001d\u0010=\u001a\u00020&*\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010?\u001a\u00020\u000b*\u00020\n2\u0006\u00104\u001a\u00020>H\u0080\b\u001a\u0015\u0010@\u001a\u00020\r*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u000f\u0010A\u001a\u0004\u0018\u00010\r*\u00020\nH\u0080\b\u001a\u0015\u0010C\u001a\u00020\r*\u00020\n2\u0006\u0010B\u001a\u00020\u000bH\u0080\b\u001a\r\u0010D\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a%\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010L\u001a\u00020\u000b*\u00020\n2\u0006\u00101\u001a\u00020KH\u0080\b\u001a\u001d\u0010M\u001a\u00020\n*\u00020\n2\u0006\u00101\u001a\u00020K2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010N\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010R\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010T\u001a\u00020\n*\u00020\n2\u0006\u0010,\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010U\u001a\u00020&*\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010V\u001a\u00020\u000b*\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0080\b\u001a%\u0010X\u001a\u00020\u000b*\u00020\n2\u0006\u0010N\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010Y\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a\u001d\u0010[\u001a\u00020\u000b*\u00020\n2\u0006\u0010Z\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\b\u001a-\u0010\\\u001a\u00020\b*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\u0017\u0010_\u001a\u00020\b*\u00020\n2\b\u0010^\u001a\u0004\u0018\u00010]H\u0080\b\u001a\r\u0010R\u001a\u00020\u0002*\u00020\nH\u0080\b\u001a\r\u0010`\u001a\u00020\n*\u00020\nH\u0080\b\u001a\r\u0010a\u001a\u00020)*\u00020\nH\u0080\b\u001a\u0015\u0010b\u001a\u00020)*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0002H\u0080\b\u001a\u0014\u0010e\u001a\u00020c*\u00020\n2\u0006\u0010d\u001a\u00020cH\u0000\u001a\u0014\u0010P\u001a\u00020c*\u00020\n2\u0006\u0010d\u001a\u00020cH\u0000\u001a\r\u0010f\u001a\u00020\u0002*\u00020cH\u0080\b\u001a\u0015\u0010g\u001a\u00020\u0002*\u00020c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010i\u001a\u00020\u000b*\u00020c2\u0006\u0010h\u001a\u00020\u000bH\u0080\b\u001a\u0015\u0010k\u001a\u00020\u000b*\u00020c2\u0006\u0010j\u001a\u00020\u0002H\u0080\b\u001a\r\u0010N\u001a\u00020&*\u00020cH\u0080\b\" \u0010q\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b'\u0010l\u0012\u0004\bo\u0010p\u001a\u0004\bm\u0010n\"\u0014\u0010r\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\bN\u0010A\"\u0014\u0010s\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010C\"\u0014\u0010t\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b`\u0010C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006u"}, d2 = {"Lokio/p0;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "i0", "Lokio/j;", "", "newline", "", "j0", i1.a.f31577d5, "fromIndex", "Lkotlin/Function2;", "lambda", k0.f55262g, "(Lokio/j;JLik/p;)Ljava/lang/Object;", "Lokio/i0;", "options", "selectTruncated", "l0", "out", w.c.R, "byteCount", "e", "c", "", "t", "", i1.a.S4, "C", "D", "pos", "h", "Lkotlin/z1;", "a", "N", "Lokio/ByteString;", "byteString", "R", "v", "Z", "a0", "minimumCapacity", "Q", "source", "U", "u", "sink", "o", i1.a.W4, "p", "y", "B", "w", "x", "M", an.aD, "Lokio/r0;", SsManifestParser.e.J, "G", "I", "limit", "J", "H", w.b.f53669e, "beginIndex", "endIndex", "e0", "codePoint", "f0", "Lokio/t0;", "X", i1.a.R4, "b", "Y", an.aB, "d0", "i", "b0", "c0", i1.a.X4, "q", "toIndex", xf.j.f55230b, "k", "targetBytes", l.f16298a, "n", "", "other", "f", "d", "O", "P", "Lokio/j$a;", "unsafeCursor", "F", k.f40564b, "L", "newSize", "K", "minByteCount", "g", "[B", "g0", "()[B", "getHEX_DIGIT_BYTES$annotations", "()V", "HEX_DIGIT_BYTES", "SEGMENTING_THRESHOLD", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "okio"}, k = 2, mv = {1, 5, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final byte[] f44106a = z0.a("0123456789abcdef");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f44107b = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f44108c = -922337203685477580L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f44109d = -7;

    public static final void A(@yt.k okio.j jVar, @yt.k byte[] sink) throws EOFException {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = jVar.read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d A[EDGE_INSN: B:43:0x009d->B:37:0x009d BREAK  A[LOOP:0: B:5:0x0012->B:45:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long B(@yt.k okio.j r15) throws java.io.EOFException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.f0.p(r15, r0)
            long r0 = r15.m2()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La7
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.p0 r6 = r15.f44116a
            kotlin.jvm.internal.f0.m(r6)
            byte[] r7 = r6.f44174a
            int r8 = r6.f44175b
            int r9 = r6.f44176c
        L1d:
            if (r8 >= r9) goto L89
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L2e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L2e
            int r11 = r10 - r11
            goto L48
        L2e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3d
        L38:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L48
        L3d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L75
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L75
            goto L38
        L48:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L58
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1d
        L58:
            okio.j r15 = new okio.j
            r15.<init>()
            okio.j r15 = r15.Y0(r4)
            okio.j r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r15 = r15.y1()
            java.lang.String r1 = "Number too large: "
            java.lang.String r15 = kotlin.jvm.internal.f0.C(r1, r15)
            r0.<init>(r15)
            throw r0
        L75:
            if (r0 == 0) goto L79
            r1 = 1
            goto L89
        L79:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.String r0 = okio.a1.t(r10)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = kotlin.jvm.internal.f0.C(r1, r0)
            r15.<init>(r0)
            throw r15
        L89:
            if (r8 != r9) goto L95
            okio.p0 r7 = r6.b()
            r15.f44116a = r7
            okio.q0.d(r6)
            goto L97
        L95:
            r6.f44175b = r8
        L97:
            if (r1 != 0) goto L9d
            okio.p0 r6 = r15.f44116a
            if (r6 != 0) goto L12
        L9d:
            long r1 = r15.m2()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.i2(r1)
            return r4
        La7:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.d.B(okio.j):long");
    }

    public static final int C(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        if (jVar.m2() < 4) {
            throw new EOFException();
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 4) {
            return (jVar.readByte() & 255) | ((jVar.readByte() & 255) << 24) | ((jVar.readByte() & 255) << 16) | ((jVar.readByte() & 255) << 8);
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        int i17 = i15 + 1;
        int i18 = i16 | (bArr[i15] & 255);
        jVar.i2(jVar.m2() - 4);
        if (i17 == i11) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i17;
        }
        return i18;
    }

    public static final long D(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        if (jVar.m2() < 8) {
            throw new EOFException();
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 8) {
            return ((((long) jVar.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) jVar.readInt()));
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        long j10 = (((long) bArr[i10]) & 255) << 56;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 48);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 40);
        int i15 = i14 + 1;
        long j13 = ((((long) bArr[i14]) & 255) << 32) | j12;
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 24);
        int i17 = i16 + 1;
        long j15 = j14 | ((((long) bArr[i16]) & 255) << 16);
        int i18 = i17 + 1;
        long j16 = j15 | ((((long) bArr[i17]) & 255) << 8);
        int i19 = i18 + 1;
        long j17 = j16 | (((long) bArr[i18]) & 255);
        jVar.i2(jVar.m2() - 8);
        if (i19 == i11) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i19;
        }
        return j17;
    }

    public static final short E(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        if (jVar.m2() < 2) {
            throw new EOFException();
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        if (i11 - i10 < 2) {
            return (short) ((jVar.readByte() & 255) | ((jVar.readByte() & 255) << 8));
        }
        byte[] bArr = p0Var.f44174a;
        int i12 = i10 + 1;
        int i13 = i12 + 1;
        int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
        jVar.i2(jVar.m2() - 2);
        if (i13 == i11) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i13;
        }
        return (short) i14;
    }

    @yt.k
    public static final j.a F(@yt.k okio.j jVar, @yt.k j.a unsafeCursor) {
        f0.p(jVar, "<this>");
        f0.p(unsafeCursor, "unsafeCursor");
        j.a aVarM = a1.m(unsafeCursor);
        if (!(aVarM.f44118a == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVarM.f44118a = jVar;
        aVarM.f44119b = false;
        return aVarM;
    }

    @yt.k
    public static final String G(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (jVar.m2() < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        int i10 = p0Var.f44175b;
        if (((long) i10) + j10 > p0Var.f44176c) {
            return j.c(jVar.w1(j10), 0, 0, 3, null);
        }
        int i11 = (int) j10;
        String strB = j.b(p0Var.f44174a, i10, i10 + i11);
        p0Var.f44175b += i11;
        jVar.i2(jVar.m2() - j10);
        if (p0Var.f44175b == p0Var.f44176c) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return strB;
    }

    public static final int H(@yt.k okio.j jVar) throws EOFException {
        int i10;
        int i11;
        int i12;
        f0.p(jVar, "<this>");
        if (jVar.m2() == 0) {
            throw new EOFException();
        }
        byte bD1 = jVar.d1(0L);
        boolean z10 = false;
        if ((bD1 & 128) == 0) {
            i10 = bD1 & 127;
            i11 = 1;
            i12 = 0;
        } else if ((bD1 & 224) == 192) {
            i10 = bD1 & 31;
            i11 = 2;
            i12 = 128;
        } else if ((bD1 & 240) == 224) {
            i10 = bD1 & 15;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bD1 & ThreadUtils.f11619i) != 240) {
                jVar.skip(1L);
                return w0.f44231c;
            }
            i10 = bD1 & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (jVar.m2() < j10) {
            throw new EOFException("size < " + i11 + ": " + jVar.m2() + " (to read code point prefixed 0x" + a1.t(bD1) + ')');
        }
        if (1 < i11) {
            int i13 = 1;
            while (true) {
                int i14 = i13 + 1;
                long j11 = i13;
                byte bD12 = jVar.d1(j11);
                if ((bD12 & i1.a.f31667o7) != 128) {
                    jVar.skip(j11);
                    return w0.f44231c;
                }
                i10 = (i10 << 6) | (bD12 & w0.f44229a);
                if (i14 >= i11) {
                    break;
                }
                i13 = i14;
            }
        }
        jVar.skip(j10);
        if (i10 > 1114111) {
            return w0.f44231c;
        }
        if (55296 <= i10 && i10 <= 57343) {
            z10 = true;
        }
        return (!z10 && i10 >= i12) ? i10 : w0.f44231c;
    }

    @yt.l
    public static final String I(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        long jB2 = jVar.b2((byte) 10);
        if (jB2 != -1) {
            return j0(jVar, jB2);
        }
        if (jVar.m2() != 0) {
            return jVar.q(jVar.m2());
        }
        return null;
    }

    @yt.k
    public static final String J(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("limit < 0: ", Long.valueOf(j10)).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        byte b10 = (byte) 10;
        long jH0 = jVar.h0(b10, 0L, j11);
        if (jH0 != -1) {
            return j0(jVar, jH0);
        }
        if (j11 < jVar.m2() && jVar.d1(j11 - 1) == ((byte) 13) && jVar.d1(j11) == b10) {
            return j0(jVar, j11);
        }
        okio.j jVar2 = new okio.j();
        jVar.u(jVar2, 0L, Math.min(32, jVar.m2()));
        throw new EOFException("\\n not found: limit=" + Math.min(jVar.m2(), j10) + " content=" + jVar2.Z0().B() + y.F);
    }

    public static final long K(@yt.k j.a aVar, long j10) {
        f0.p(aVar, "<this>");
        okio.j jVar = aVar.f44118a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!aVar.f44119b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long jM2 = jVar.m2();
        int i10 = 1;
        if (j10 <= jM2) {
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(f0.C("newSize < 0: ", Long.valueOf(j10)).toString());
            }
            long j11 = jM2 - j10;
            while (true) {
                if (j11 <= 0) {
                    break;
                }
                p0 p0Var = jVar.f44116a;
                f0.m(p0Var);
                p0 p0Var2 = p0Var.f44180g;
                f0.m(p0Var2);
                int i11 = p0Var2.f44176c;
                long j12 = i11 - p0Var2.f44175b;
                if (j12 > j11) {
                    p0Var2.f44176c = i11 - ((int) j11);
                    break;
                }
                jVar.f44116a = p0Var2.b();
                q0.d(p0Var2);
                j11 -= j12;
            }
            aVar.i(null);
            aVar.f44121d = j10;
            aVar.f44122e = null;
            aVar.f44123f = -1;
            aVar.f44124g = -1;
        } else if (j10 > jM2) {
            long j13 = j10 - jM2;
            boolean z10 = true;
            while (j13 > 0) {
                p0 p0VarP2 = jVar.p2(i10);
                int iMin = (int) Math.min(j13, 8192 - p0VarP2.f44176c);
                p0VarP2.f44176c += iMin;
                j13 -= (long) iMin;
                if (z10) {
                    aVar.i(p0VarP2);
                    aVar.f44121d = jM2;
                    aVar.f44122e = p0VarP2.f44174a;
                    int i12 = p0VarP2.f44176c;
                    aVar.f44123f = i12 - iMin;
                    aVar.f44124g = i12;
                    i10 = 1;
                    z10 = false;
                } else {
                    i10 = 1;
                }
            }
        }
        jVar.i2(j10);
        return jM2;
    }

    public static final int L(@yt.k j.a aVar, long j10) {
        p0 p0VarC;
        f0.p(aVar, "<this>");
        okio.j jVar = aVar.f44118a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (j10 < -1 || j10 > jVar.m2()) {
            throw new ArrayIndexOutOfBoundsException("offset=" + j10 + " > size=" + jVar.m2());
        }
        if (j10 == -1 || j10 == jVar.m2()) {
            aVar.i(null);
            aVar.f44121d = j10;
            aVar.f44122e = null;
            aVar.f44123f = -1;
            aVar.f44124g = -1;
            return -1;
        }
        long j11 = 0;
        long jM2 = jVar.m2();
        p0 p0VarC2 = jVar.f44116a;
        if (aVar.c() != null) {
            long j12 = aVar.f44121d;
            int i10 = aVar.f44123f;
            p0 p0VarC3 = aVar.c();
            f0.m(p0VarC3);
            long j13 = j12 - ((long) (i10 - p0VarC3.f44175b));
            if (j13 > j10) {
                p0VarC2 = aVar.c();
                jM2 = j13;
                p0VarC = p0VarC2;
            } else {
                p0VarC = aVar.c();
                j11 = j13;
            }
        } else {
            p0VarC = p0VarC2;
        }
        if (jM2 - j10 > j10 - j11) {
            while (true) {
                f0.m(p0VarC);
                int i11 = p0VarC.f44176c;
                int i12 = p0VarC.f44175b;
                if (j10 < ((long) (i11 - i12)) + j11) {
                    break;
                }
                j11 += (long) (i11 - i12);
                p0VarC = p0VarC.f44179f;
            }
        } else {
            while (jM2 > j10) {
                f0.m(p0VarC2);
                p0VarC2 = p0VarC2.f44180g;
                f0.m(p0VarC2);
                jM2 -= (long) (p0VarC2.f44176c - p0VarC2.f44175b);
            }
            j11 = jM2;
            p0VarC = p0VarC2;
        }
        if (aVar.f44119b) {
            f0.m(p0VarC);
            if (p0VarC.f44177d) {
                p0 p0VarF = p0VarC.f();
                if (jVar.f44116a == p0VarC) {
                    jVar.f44116a = p0VarF;
                }
                p0VarC = p0VarC.c(p0VarF);
                p0 p0Var = p0VarC.f44180g;
                f0.m(p0Var);
                p0Var.b();
            }
        }
        aVar.i(p0VarC);
        aVar.f44121d = j10;
        f0.m(p0VarC);
        aVar.f44122e = p0VarC.f44174a;
        int i13 = p0VarC.f44175b + ((int) (j10 - j11));
        aVar.f44123f = i13;
        int i14 = p0VarC.f44176c;
        aVar.f44124g = i14;
        return i14 - i13;
    }

    public static final int M(@yt.k okio.j jVar, @yt.k i0 options) throws EOFException {
        f0.p(jVar, "<this>");
        f0.p(options, "options");
        int iM0 = m0(jVar, options, false, 2, null);
        if (iM0 == -1) {
            return -1;
        }
        jVar.skip(options.l()[iM0].x0());
        return iM0;
    }

    public static final void N(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        while (j10 > 0) {
            p0 p0Var = jVar.f44116a;
            if (p0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, p0Var.f44176c - p0Var.f44175b);
            long j11 = iMin;
            jVar.i2(jVar.m2() - j11);
            j10 -= j11;
            int i10 = p0Var.f44175b + iMin;
            p0Var.f44175b = i10;
            if (i10 == p0Var.f44176c) {
                jVar.f44116a = p0Var.b();
                q0.d(p0Var);
            }
        }
    }

    @yt.k
    public static final ByteString O(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        if (jVar.m2() <= 2147483647L) {
            return jVar.o2((int) jVar.m2());
        }
        throw new IllegalStateException(f0.C("size > Int.MAX_VALUE: ", Long.valueOf(jVar.m2())).toString());
    }

    @yt.k
    public static final ByteString P(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        if (i10 == 0) {
            return ByteString.f44030d;
        }
        a1.e(jVar.m2(), 0L, i10);
        p0 p0Var = jVar.f44116a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            f0.m(p0Var);
            int i14 = p0Var.f44176c;
            int i15 = p0Var.f44175b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            p0Var = p0Var.f44179f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        p0 p0Var2 = jVar.f44116a;
        int i16 = 0;
        while (i11 < i10) {
            f0.m(p0Var2);
            bArr[i16] = p0Var2.f44174a;
            i11 += p0Var2.f44176c - p0Var2.f44175b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = p0Var2.f44175b;
            p0Var2.f44177d = true;
            i16++;
            p0Var2 = p0Var2.f44179f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @yt.k
    public static final p0 Q(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        if (!(i10 >= 1 && i10 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        p0 p0Var = jVar.f44116a;
        if (p0Var != null) {
            f0.m(p0Var);
            p0 p0Var2 = p0Var.f44180g;
            f0.m(p0Var2);
            return (p0Var2.f44176c + i10 > 8192 || !p0Var2.f44178e) ? p0Var2.c(q0.e()) : p0Var2;
        }
        p0 p0VarE = q0.e();
        jVar.f44116a = p0VarE;
        p0VarE.f44180g = p0VarE;
        p0VarE.f44179f = p0VarE;
        return p0VarE;
    }

    @yt.k
    public static final okio.j R(@yt.k okio.j jVar, @yt.k ByteString byteString, int i10, int i11) {
        f0.p(jVar, "<this>");
        f0.p(byteString, "byteString");
        byteString.Q0(jVar, i10, i11);
        return jVar;
    }

    @yt.k
    public static final okio.j S(@yt.k okio.j jVar, @yt.k t0 source, long j10) throws IOException {
        f0.p(jVar, "<this>");
        f0.p(source, "source");
        while (j10 > 0) {
            long jF1 = source.F1(jVar, j10);
            if (jF1 == -1) {
                throw new EOFException();
            }
            j10 -= jF1;
        }
        return jVar;
    }

    @yt.k
    public static final okio.j T(@yt.k okio.j jVar, @yt.k byte[] source) {
        f0.p(jVar, "<this>");
        f0.p(source, "source");
        return jVar.write(source, 0, source.length);
    }

    @yt.k
    public static final okio.j U(@yt.k okio.j jVar, @yt.k byte[] source, int i10, int i11) {
        f0.p(jVar, "<this>");
        f0.p(source, "source");
        long j10 = i11;
        a1.e(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            p0 p0VarP2 = jVar.p2(1);
            int iMin = Math.min(i12 - i10, 8192 - p0VarP2.f44176c);
            int i13 = i10 + iMin;
            m.W0(source, p0VarP2.f44174a, p0VarP2.f44176c, i10, i13);
            p0VarP2.f44176c += iMin;
            i10 = i13;
        }
        jVar.i2(jVar.m2() + j10);
        return jVar;
    }

    public static final void V(@yt.k okio.j jVar, @yt.k okio.j source, long j10) {
        p0 p0Var;
        f0.p(jVar, "<this>");
        f0.p(source, "source");
        if (!(source != jVar)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        a1.e(source.m2(), 0L, j10);
        while (j10 > 0) {
            p0 p0Var2 = source.f44116a;
            f0.m(p0Var2);
            int i10 = p0Var2.f44176c;
            f0.m(source.f44116a);
            if (j10 < i10 - r2.f44175b) {
                p0 p0Var3 = jVar.f44116a;
                if (p0Var3 != null) {
                    f0.m(p0Var3);
                    p0Var = p0Var3.f44180g;
                } else {
                    p0Var = null;
                }
                if (p0Var != null && p0Var.f44178e) {
                    if ((((long) p0Var.f44176c) + j10) - ((long) (p0Var.f44177d ? 0 : p0Var.f44175b)) <= 8192) {
                        p0 p0Var4 = source.f44116a;
                        f0.m(p0Var4);
                        p0Var4.g(p0Var, (int) j10);
                        source.i2(source.m2() - j10);
                        jVar.i2(jVar.m2() + j10);
                        return;
                    }
                }
                p0 p0Var5 = source.f44116a;
                f0.m(p0Var5);
                source.f44116a = p0Var5.e((int) j10);
            }
            p0 p0Var6 = source.f44116a;
            f0.m(p0Var6);
            long j11 = p0Var6.f44176c - p0Var6.f44175b;
            source.f44116a = p0Var6.b();
            p0 p0Var7 = jVar.f44116a;
            if (p0Var7 == null) {
                jVar.f44116a = p0Var6;
                p0Var6.f44180g = p0Var6;
                p0Var6.f44179f = p0Var6;
            } else {
                f0.m(p0Var7);
                p0 p0Var8 = p0Var7.f44180g;
                f0.m(p0Var8);
                p0Var8.c(p0Var6).a();
            }
            source.i2(source.m2() - j11);
            jVar.i2(jVar.m2() + j11);
            j10 -= j11;
        }
    }

    public static /* synthetic */ okio.j W(okio.j jVar, ByteString byteString, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = byteString.x0();
        }
        f0.p(jVar, "<this>");
        f0.p(byteString, "byteString");
        byteString.Q0(jVar, i10, i11);
        return jVar;
    }

    public static final long X(@yt.k okio.j jVar, @yt.k t0 source) throws IOException {
        f0.p(jVar, "<this>");
        f0.p(source, "source");
        long j10 = 0;
        while (true) {
            long jF1 = source.F1(jVar, 8192L);
            if (jF1 == -1) {
                return j10;
            }
            j10 += jF1;
        }
    }

    @yt.k
    public static final okio.j Y(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        p0 p0VarP2 = jVar.p2(1);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        p0VarP2.f44176c = i11 + 1;
        bArr[i11] = (byte) i10;
        jVar.i2(jVar.m2() + 1);
        return jVar;
    }

    @yt.k
    public static final okio.j Z(@yt.k okio.j jVar, long j10) {
        f0.p(jVar, "<this>");
        if (j10 == 0) {
            return jVar.writeByte(48);
        }
        boolean z10 = false;
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return jVar.H0("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 >= 100000000) {
            i10 = j10 < com.google.android.material.slider.c.f20671e ? j10 < RealConnection.f43773w ? j10 < ya.g.f56695j ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        p0 p0VarP2 = jVar.p2(i10);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = g0()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = (byte) 45;
        }
        p0VarP2.f44176c += i10;
        jVar.i2(jVar.m2() + ((long) i10));
        return jVar;
    }

    public static final void a(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        jVar.skip(jVar.m2());
    }

    @yt.k
    public static final okio.j a0(@yt.k okio.j jVar, long j10) {
        f0.p(jVar, "<this>");
        if (j10 == 0) {
            return jVar.writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & rr.b.f49130b);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        p0 p0VarP2 = jVar.p2(i10);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = g0()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        p0VarP2.f44176c += i10;
        jVar.i2(jVar.m2() + ((long) i10));
        return jVar;
    }

    public static final void b(@yt.k j.a aVar) {
        f0.p(aVar, "<this>");
        if (!(aVar.f44118a != null)) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        aVar.f44118a = null;
        aVar.i(null);
        aVar.f44121d = -1L;
        aVar.f44122e = null;
        aVar.f44123f = -1;
        aVar.f44124g = -1;
    }

    @yt.k
    public static final okio.j b0(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        p0 p0VarP2 = jVar.p2(4);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        p0VarP2.f44176c = i14 + 1;
        jVar.i2(jVar.m2() + 4);
        return jVar;
    }

    public static final long c(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        long jM2 = jVar.m2();
        if (jM2 == 0) {
            return 0L;
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        p0 p0Var2 = p0Var.f44180g;
        f0.m(p0Var2);
        int i10 = p0Var2.f44176c;
        return (i10 >= 8192 || !p0Var2.f44178e) ? jM2 : jM2 - ((long) (i10 - p0Var2.f44175b));
    }

    @yt.k
    public static final okio.j c0(@yt.k okio.j jVar, long j10) {
        f0.p(jVar, "<this>");
        p0 p0VarP2 = jVar.p2(8);
        byte[] bArr = p0VarP2.f44174a;
        int i10 = p0VarP2.f44176c;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j10 >>> 48) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j10 >>> 40) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j10 >>> 32) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j10 >>> 24) & 255);
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((j10 >>> 16) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((j10 >>> 8) & 255);
        bArr[i17] = (byte) (j10 & 255);
        p0VarP2.f44176c = i17 + 1;
        jVar.i2(jVar.m2() + 8);
        return jVar;
    }

    @yt.k
    public static final okio.j d(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        okio.j jVar2 = new okio.j();
        if (jVar.m2() == 0) {
            return jVar2;
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        p0 p0VarD = p0Var.d();
        jVar2.f44116a = p0VarD;
        p0VarD.f44180g = p0VarD;
        p0VarD.f44179f = p0VarD;
        for (p0 p0Var2 = p0Var.f44179f; p0Var2 != p0Var; p0Var2 = p0Var2.f44179f) {
            p0 p0Var3 = p0VarD.f44180g;
            f0.m(p0Var3);
            f0.m(p0Var2);
            p0Var3.c(p0Var2.d());
        }
        jVar2.i2(jVar.m2());
        return jVar2;
    }

    @yt.k
    public static final okio.j d0(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        p0 p0VarP2 = jVar.p2(2);
        byte[] bArr = p0VarP2.f44174a;
        int i11 = p0VarP2.f44176c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        p0VarP2.f44176c = i12 + 1;
        jVar.i2(jVar.m2() + 2);
        return jVar;
    }

    @yt.k
    public static final okio.j e(@yt.k okio.j jVar, @yt.k okio.j out, long j10, long j11) {
        f0.p(jVar, "<this>");
        f0.p(out, "out");
        a1.e(jVar.m2(), j10, j11);
        if (j11 == 0) {
            return jVar;
        }
        out.i2(out.m2() + j11);
        p0 p0Var = jVar.f44116a;
        while (true) {
            f0.m(p0Var);
            int i10 = p0Var.f44176c;
            int i11 = p0Var.f44175b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= (long) (i10 - i11);
            p0Var = p0Var.f44179f;
        }
        while (j11 > 0) {
            f0.m(p0Var);
            p0 p0VarD = p0Var.d();
            int i12 = p0VarD.f44175b + ((int) j10);
            p0VarD.f44175b = i12;
            p0VarD.f44176c = Math.min(i12 + ((int) j11), p0VarD.f44176c);
            p0 p0Var2 = out.f44116a;
            if (p0Var2 == null) {
                p0VarD.f44180g = p0VarD;
                p0VarD.f44179f = p0VarD;
                out.f44116a = p0VarD;
            } else {
                f0.m(p0Var2);
                p0 p0Var3 = p0Var2.f44180g;
                f0.m(p0Var3);
                p0Var3.c(p0VarD);
            }
            j11 -= (long) (p0VarD.f44176c - p0VarD.f44175b);
            p0Var = p0Var.f44179f;
            j10 = 0;
        }
        return jVar;
    }

    @yt.k
    public static final okio.j e0(@yt.k okio.j jVar, @yt.k String string, int i10, int i11) {
        char cCharAt;
        f0.p(jVar, "<this>");
        f0.p(string, "string");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(f0.C("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = string.charAt(i10);
            if (cCharAt2 < 128) {
                p0 p0VarP2 = jVar.p2(1);
                byte[] bArr = p0VarP2.f44174a;
                int i12 = p0VarP2.f44176c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = string.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = p0VarP2.f44176c;
                int i15 = (i12 + i10) - i14;
                p0VarP2.f44176c = i14 + i15;
                jVar.i2(jVar.m2() + ((long) i15));
            } else {
                if (cCharAt2 < 2048) {
                    p0 p0VarP22 = jVar.p2(2);
                    byte[] bArr2 = p0VarP22.f44174a;
                    int i16 = p0VarP22.f44176c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    p0VarP22.f44176c = i16 + 2;
                    jVar.i2(jVar.m2() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    p0 p0VarP23 = jVar.p2(3);
                    byte[] bArr3 = p0VarP23.f44174a;
                    int i17 = p0VarP23.f44176c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    p0VarP23.f44176c = i17 + 3;
                    jVar.i2(jVar.m2() + 3);
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    if (cCharAt2 <= 56319) {
                        if (56320 <= cCharAt3 && cCharAt3 <= 57343) {
                            int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            p0 p0VarP24 = jVar.p2(4);
                            byte[] bArr4 = p0VarP24.f44174a;
                            int i20 = p0VarP24.f44176c;
                            bArr4[i20] = (byte) ((i19 >> 18) | 240);
                            bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                            bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                            bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                            p0VarP24.f44176c = i20 + 4;
                            jVar.i2(jVar.m2() + 4);
                            i10 += 2;
                        }
                    }
                    jVar.writeByte(63);
                    i10 = i18;
                }
                i10++;
            }
        }
        return jVar;
    }

    public static final boolean f(@yt.k okio.j jVar, @yt.l Object obj) {
        f0.p(jVar, "<this>");
        if (jVar == obj) {
            return true;
        }
        if (!(obj instanceof okio.j)) {
            return false;
        }
        okio.j jVar2 = (okio.j) obj;
        if (jVar.m2() != jVar2.m2()) {
            return false;
        }
        if (jVar.m2() == 0) {
            return true;
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        p0 p0Var2 = jVar2.f44116a;
        f0.m(p0Var2);
        int i10 = p0Var.f44175b;
        int i11 = p0Var2.f44175b;
        long j10 = 0;
        while (j10 < jVar.m2()) {
            long jMin = Math.min(p0Var.f44176c - i10, p0Var2.f44176c - i11);
            if (0 < jMin) {
                long j11 = 0;
                while (true) {
                    j11++;
                    int i12 = i10 + 1;
                    int i13 = i11 + 1;
                    if (p0Var.f44174a[i10] != p0Var2.f44174a[i11]) {
                        return false;
                    }
                    if (j11 >= jMin) {
                        i10 = i12;
                        i11 = i13;
                        break;
                    }
                    i10 = i12;
                    i11 = i13;
                }
            }
            if (i10 == p0Var.f44176c) {
                p0Var = p0Var.f44179f;
                f0.m(p0Var);
                i10 = p0Var.f44175b;
            }
            if (i11 == p0Var2.f44176c) {
                p0Var2 = p0Var2.f44179f;
                f0.m(p0Var2);
                i11 = p0Var2.f44175b;
            }
            j10 += jMin;
        }
        return true;
    }

    @yt.k
    public static final okio.j f0(@yt.k okio.j jVar, int i10) {
        f0.p(jVar, "<this>");
        if (i10 < 128) {
            jVar.writeByte(i10);
        } else if (i10 < 2048) {
            p0 p0VarP2 = jVar.p2(2);
            byte[] bArr = p0VarP2.f44174a;
            int i11 = p0VarP2.f44176c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            p0VarP2.f44176c = i11 + 2;
            jVar.i2(jVar.m2() + 2);
        } else {
            boolean z10 = false;
            if (55296 <= i10 && i10 <= 57343) {
                z10 = true;
            }
            if (z10) {
                jVar.writeByte(63);
            } else if (i10 < 65536) {
                p0 p0VarP22 = jVar.p2(3);
                byte[] bArr2 = p0VarP22.f44174a;
                int i12 = p0VarP22.f44176c;
                bArr2[i12] = (byte) ((i10 >> 12) | 224);
                bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
                bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
                p0VarP22.f44176c = i12 + 3;
                jVar.i2(jVar.m2() + 3);
            } else {
                if (i10 > 1114111) {
                    throw new IllegalArgumentException(f0.C("Unexpected code point: 0x", a1.u(i10)));
                }
                p0 p0VarP23 = jVar.p2(4);
                byte[] bArr3 = p0VarP23.f44174a;
                int i13 = p0VarP23.f44176c;
                bArr3[i13] = (byte) ((i10 >> 18) | 240);
                bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
                p0VarP23.f44176c = i13 + 4;
                jVar.i2(jVar.m2() + 4);
            }
        }
        return jVar;
    }

    public static final long g(@yt.k j.a aVar, int i10) {
        f0.p(aVar, "<this>");
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(f0.C("minByteCount <= 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i10 <= 8192)) {
            throw new IllegalArgumentException(f0.C("minByteCount > Segment.SIZE: ", Integer.valueOf(i10)).toString());
        }
        okio.j jVar = aVar.f44118a;
        if (jVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!aVar.f44119b) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        }
        long jM2 = jVar.m2();
        p0 p0VarP2 = jVar.p2(i10);
        int i11 = 8192 - p0VarP2.f44176c;
        p0VarP2.f44176c = 8192;
        long j10 = i11;
        jVar.i2(jM2 + j10);
        aVar.i(p0VarP2);
        aVar.f44121d = jM2;
        aVar.f44122e = p0VarP2.f44174a;
        aVar.f44123f = 8192 - i11;
        aVar.f44124g = 8192;
        return j10;
    }

    @yt.k
    public static final byte[] g0() {
        return f44106a;
    }

    public static final byte h(@yt.k okio.j jVar, long j10) {
        f0.p(jVar, "<this>");
        a1.e(jVar.m2(), j10, 1L);
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            f0.m(null);
            throw null;
        }
        if (jVar.m2() - j10 < j10) {
            long jM2 = jVar.m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            f0.m(p0Var);
            return p0Var.f44174a[(int) ((((long) p0Var.f44175b) + j10) - jM2)];
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j11;
            if (j12 > j10) {
                f0.m(p0Var);
                return p0Var.f44174a[(int) ((((long) p0Var.f44175b) + j10) - j11)];
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            j11 = j12;
        }
    }

    public static /* synthetic */ void h0() {
    }

    public static final int i(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = p0Var.f44176c;
            for (int i12 = p0Var.f44175b; i12 < i11; i12++) {
                i10 = (i10 * 31) + p0Var.f44174a[i12];
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
        } while (p0Var != jVar.f44116a);
        return i10;
    }

    public static final boolean i0(@yt.k p0 segment, int i10, @yt.k byte[] bytes, int i11, int i12) {
        f0.p(segment, "segment");
        f0.p(bytes, "bytes");
        int i13 = segment.f44176c;
        byte[] bArr = segment.f44174a;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.f44179f;
                f0.m(segment);
                byte[] bArr2 = segment.f44174a;
                bArr = bArr2;
                i10 = segment.f44175b;
                i13 = segment.f44176c;
            }
            if (bArr[i10] != bytes[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final long j(@yt.k okio.j jVar, byte b10, long j10, long j11) {
        p0 p0Var;
        long j12 = j10;
        long jM2 = j11;
        f0.p(jVar, "<this>");
        boolean z10 = false;
        long j13 = 0;
        if (0 <= j12 && j12 <= jM2) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException(("size=" + jVar.m2() + " fromIndex=" + j12 + " toIndex=" + jM2).toString());
        }
        if (jM2 > jVar.m2()) {
            jM2 = jVar.m2();
        }
        long j14 = jM2;
        if (j12 == j14 || (p0Var = jVar.f44116a) == null) {
            return -1L;
        }
        if (jVar.m2() - j12 < j12) {
            long jM22 = jVar.m2();
            while (jM22 > j12) {
                p0Var = p0Var.f44180g;
                f0.m(p0Var);
                jM22 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            while (jM22 < j14) {
                byte[] bArr = p0Var.f44174a;
                int iMin = (int) Math.min(p0Var.f44176c, (((long) p0Var.f44175b) + j14) - jM22);
                for (int i10 = (int) ((((long) p0Var.f44175b) + j12) - jM22); i10 < iMin; i10++) {
                    if (bArr[i10] == b10) {
                        return ((long) (i10 - p0Var.f44175b)) + jM22;
                    }
                }
                jM22 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                f0.m(p0Var);
                j12 = jM22;
            }
            return -1L;
        }
        while (true) {
            long j15 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j13;
            if (j15 > j12) {
                break;
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            j13 = j15;
        }
        while (j13 < j14) {
            byte[] bArr2 = p0Var.f44174a;
            int iMin2 = (int) Math.min(p0Var.f44176c, (((long) p0Var.f44175b) + j14) - j13);
            for (int i11 = (int) ((((long) p0Var.f44175b) + j12) - j13); i11 < iMin2; i11++) {
                if (bArr2[i11] == b10) {
                    return ((long) (i11 - p0Var.f44175b)) + j13;
                }
            }
            j13 += (long) (p0Var.f44176c - p0Var.f44175b);
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            j12 = j13;
        }
        return -1L;
    }

    @yt.k
    public static final String j0(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (jVar.d1(j11) == ((byte) 13)) {
                String strQ = jVar.q(j11);
                jVar.skip(2L);
                return strQ;
            }
        }
        String strQ2 = jVar.q(j10);
        jVar.skip(1L);
        return strQ2;
    }

    public static final long k(@yt.k okio.j jVar, @yt.k ByteString bytes, long j10) {
        f0.p(jVar, "<this>");
        f0.p(bytes, "bytes");
        if (!(bytes.x0() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j11 = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("fromIndex < 0: ", Long.valueOf(j10)).toString());
        }
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            return -1L;
        }
        if (jVar.m2() - j10 < j10) {
            long jM2 = jVar.m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            byte[] bArrO = bytes.O();
            byte b10 = bArrO[0];
            int iX0 = bytes.x0();
            long jM22 = (jVar.m2() - ((long) iX0)) + 1;
            long j12 = jM2;
            p0 p0Var2 = p0Var;
            long j13 = j10;
            while (j12 < jM22) {
                byte[] bArr = p0Var2.f44174a;
                p0 p0Var3 = p0Var2;
                int iMin = (int) Math.min(p0Var2.f44176c, (((long) p0Var2.f44175b) + jM22) - j12);
                int i10 = (int) ((((long) p0Var3.f44175b) + j13) - j12);
                if (i10 < iMin) {
                    while (true) {
                        int i11 = i10 + 1;
                        if (bArr[i10] == b10 && i0(p0Var3, i11, bArrO, 1, iX0)) {
                            return ((long) (i10 - p0Var3.f44175b)) + j12;
                        }
                        if (i11 >= iMin) {
                            break;
                        }
                        i10 = i11;
                    }
                }
                j12 += (long) (p0Var3.f44176c - p0Var3.f44175b);
                p0Var2 = p0Var3.f44179f;
                f0.m(p0Var2);
                j13 = j12;
            }
            return -1L;
        }
        while (true) {
            long j14 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j11;
            if (j14 > j10) {
                break;
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            j11 = j14;
        }
        byte[] bArrO2 = bytes.O();
        byte b11 = bArrO2[0];
        int iX02 = bytes.x0();
        long jM23 = (jVar.m2() - ((long) iX02)) + 1;
        long j15 = j11;
        p0 p0Var4 = p0Var;
        long j16 = j10;
        while (j15 < jM23) {
            byte[] bArr2 = p0Var4.f44174a;
            long j17 = jM23;
            int iMin2 = (int) Math.min(p0Var4.f44176c, (((long) p0Var4.f44175b) + jM23) - j15);
            int i12 = (int) ((((long) p0Var4.f44175b) + j16) - j15);
            if (i12 < iMin2) {
                while (true) {
                    int i13 = i12 + 1;
                    if (bArr2[i12] == b11 && i0(p0Var4, i13, bArrO2, 1, iX02)) {
                        return ((long) (i12 - p0Var4.f44175b)) + j15;
                    }
                    if (i13 >= iMin2) {
                        break;
                    }
                    i12 = i13;
                }
            }
            j15 += (long) (p0Var4.f44176c - p0Var4.f44175b);
            p0Var4 = p0Var4.f44179f;
            f0.m(p0Var4);
            jM23 = j17;
            j16 = j15;
        }
        return -1L;
    }

    public static final <T> T k0(@yt.k okio.j jVar, long j10, @yt.k p<? super p0, ? super Long, ? extends T> lambda) {
        f0.p(jVar, "<this>");
        f0.p(lambda, "lambda");
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            return lambda.r0(null, -1L);
        }
        if (jVar.m2() - j10 < j10) {
            long jM2 = jVar.m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            return lambda.r0(p0Var, Long.valueOf(jM2));
        }
        long j11 = 0;
        while (true) {
            long j12 = ((long) (p0Var.f44176c - p0Var.f44175b)) + j11;
            if (j12 > j10) {
                return lambda.r0(p0Var, Long.valueOf(j11));
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            j11 = j12;
        }
    }

    public static final long l(@yt.k okio.j jVar, @yt.k ByteString targetBytes, long j10) {
        int i10;
        int i11;
        f0.p(jVar, "<this>");
        f0.p(targetBytes, "targetBytes");
        long jM2 = 0;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("fromIndex < 0: ", Long.valueOf(j10)).toString());
        }
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            return -1L;
        }
        if (jVar.m2() - j10 < j10) {
            jM2 = jVar.m2();
            while (jM2 > j10) {
                p0Var = p0Var.f44180g;
                f0.m(p0Var);
                jM2 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            if (targetBytes.x0() == 2) {
                byte bV = targetBytes.v(0);
                byte bV2 = targetBytes.v(1);
                while (jM2 < jVar.m2()) {
                    byte[] bArr = p0Var.f44174a;
                    i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                    int i12 = p0Var.f44176c;
                    while (i10 < i12) {
                        byte b10 = bArr[i10];
                        if (b10 == bV || b10 == bV2) {
                            i11 = p0Var.f44175b;
                        } else {
                            i10++;
                        }
                    }
                    jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                    p0Var = p0Var.f44179f;
                    f0.m(p0Var);
                    j10 = jM2;
                }
            } else {
                byte[] bArrO = targetBytes.O();
                while (jM2 < jVar.m2()) {
                    byte[] bArr2 = p0Var.f44174a;
                    i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                    int i13 = p0Var.f44176c;
                    while (i10 < i13) {
                        byte b11 = bArr2[i10];
                        int length = bArrO.length;
                        int i14 = 0;
                        while (i14 < length) {
                            byte b12 = bArrO[i14];
                            i14++;
                            if (b11 == b12) {
                                i11 = p0Var.f44175b;
                            }
                        }
                        i10++;
                    }
                    jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                    p0Var = p0Var.f44179f;
                    f0.m(p0Var);
                    j10 = jM2;
                }
            }
            return -1L;
        }
        while (true) {
            long j11 = ((long) (p0Var.f44176c - p0Var.f44175b)) + jM2;
            if (j11 > j10) {
                break;
            }
            p0Var = p0Var.f44179f;
            f0.m(p0Var);
            jM2 = j11;
        }
        if (targetBytes.x0() == 2) {
            byte bV3 = targetBytes.v(0);
            byte bV4 = targetBytes.v(1);
            while (jM2 < jVar.m2()) {
                byte[] bArr3 = p0Var.f44174a;
                i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                int i15 = p0Var.f44176c;
                while (i10 < i15) {
                    byte b13 = bArr3[i10];
                    if (b13 == bV3 || b13 == bV4) {
                        i11 = p0Var.f44175b;
                    } else {
                        i10++;
                    }
                }
                jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                f0.m(p0Var);
                j10 = jM2;
            }
        } else {
            byte[] bArrO2 = targetBytes.O();
            while (jM2 < jVar.m2()) {
                byte[] bArr4 = p0Var.f44174a;
                i10 = (int) ((((long) p0Var.f44175b) + j10) - jM2);
                int i16 = p0Var.f44176c;
                while (i10 < i16) {
                    byte b14 = bArr4[i10];
                    int length2 = bArrO2.length;
                    int i17 = 0;
                    while (i17 < length2) {
                        byte b15 = bArrO2[i17];
                        i17++;
                        if (b14 == b15) {
                            i11 = p0Var.f44175b;
                        }
                    }
                    i10++;
                }
                jM2 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                f0.m(p0Var);
                j10 = jM2;
            }
        }
        return -1L;
        return ((long) (i10 - i11)) + jM2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int l0(@yt.k okio.j r17, @yt.k okio.i0 r18, boolean r19) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.f0.p(r0, r1)
            java.lang.String r1 = "options"
            r2 = r18
            kotlin.jvm.internal.f0.p(r2, r1)
            okio.p0 r0 = r0.f44116a
            r1 = -2
            r3 = -1
            if (r0 != 0) goto L19
            if (r19 == 0) goto L17
            goto L18
        L17:
            r1 = -1
        L18:
            return r1
        L19:
            byte[] r4 = r0.f44174a
            int r5 = r0.f44175b
            int r6 = r0.f44176c
            int[] r2 = r18.m()
            r7 = 0
            r9 = r0
            r8 = 0
            r10 = -1
        L27:
            int r11 = r8 + 1
            r8 = r2[r8]
            int r12 = r11 + 1
            r11 = r2[r11]
            if (r11 == r3) goto L32
            r10 = r11
        L32:
            if (r9 != 0) goto L35
            goto L62
        L35:
            r11 = 0
            if (r8 >= 0) goto L82
            int r8 = r8 * (-1)
            int r13 = r12 + r8
        L3c:
            int r8 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r2[r12]
            if (r5 == r12) goto L49
            return r10
        L49:
            if (r14 != r13) goto L4d
            r5 = 1
            goto L4e
        L4d:
            r5 = 0
        L4e:
            if (r8 != r6) goto L6f
            kotlin.jvm.internal.f0.m(r9)
            okio.p0 r4 = r9.f44179f
            kotlin.jvm.internal.f0.m(r4)
            int r6 = r4.f44175b
            byte[] r8 = r4.f44174a
            int r9 = r4.f44176c
            if (r4 != r0) goto L69
            if (r5 != 0) goto L66
        L62:
            if (r19 == 0) goto L65
            return r1
        L65:
            return r10
        L66:
            r4 = r8
            r8 = r11
            goto L75
        L69:
            r16 = r8
            r8 = r4
            r4 = r16
            goto L75
        L6f:
            r16 = r9
            r9 = r6
            r6 = r8
            r8 = r16
        L75:
            if (r5 == 0) goto L7d
            r5 = r2[r14]
            r13 = r6
            r6 = r9
            r9 = r8
            goto La7
        L7d:
            r5 = r6
            r6 = r9
            r12 = r14
            r9 = r8
            goto L3c
        L82:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r8
        L8a:
            if (r12 != r14) goto L8d
            return r10
        L8d:
            r15 = r2[r12]
            if (r5 != r15) goto Lae
            int r12 = r12 + r8
            r5 = r2[r12]
            if (r13 != r6) goto La7
            okio.p0 r9 = r9.f44179f
            kotlin.jvm.internal.f0.m(r9)
            int r4 = r9.f44175b
            byte[] r6 = r9.f44174a
            int r8 = r9.f44176c
            r13 = r4
            r4 = r6
            r6 = r8
            if (r9 != r0) goto La7
            r9 = r11
        La7:
            if (r5 < 0) goto Laa
            return r5
        Laa:
            int r8 = -r5
            r5 = r13
            goto L27
        Lae:
            int r12 = r12 + 1
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.d.l0(okio.j, okio.i0, boolean):int");
    }

    public static final int m(@yt.k j.a aVar) {
        f0.p(aVar, "<this>");
        long j10 = aVar.f44121d;
        okio.j jVar = aVar.f44118a;
        f0.m(jVar);
        if (!(j10 != jVar.m2())) {
            throw new IllegalStateException("no more bytes".toString());
        }
        long j11 = aVar.f44121d;
        return aVar.h(j11 == -1 ? 0L : j11 + ((long) (aVar.f44124g - aVar.f44123f)));
    }

    public static /* synthetic */ int m0(okio.j jVar, i0 i0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return l0(jVar, i0Var, z10);
    }

    public static final boolean n(@yt.k okio.j jVar, long j10, @yt.k ByteString bytes, int i10, int i11) {
        f0.p(jVar, "<this>");
        f0.p(bytes, "bytes");
        if (j10 < 0 || i10 < 0 || i11 < 0 || jVar.m2() - j10 < i11 || bytes.x0() - i10 < i11) {
            return false;
        }
        if (i11 <= 0) {
            return true;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12 + 1;
            if (jVar.d1(((long) i12) + j10) != bytes.v(i12 + i10)) {
                return false;
            }
            if (i13 >= i11) {
                return true;
            }
            i12 = i13;
        }
    }

    public static final int o(@yt.k okio.j jVar, @yt.k byte[] sink) {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        return jVar.read(sink, 0, sink.length);
    }

    public static final int p(@yt.k okio.j jVar, @yt.k byte[] sink, int i10, int i11) {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        a1.e(sink.length, i10, i11);
        p0 p0Var = jVar.f44116a;
        if (p0Var == null) {
            return -1;
        }
        int iMin = Math.min(i11, p0Var.f44176c - p0Var.f44175b);
        byte[] bArr = p0Var.f44174a;
        int i12 = p0Var.f44175b;
        m.W0(bArr, sink, i10, i12, i12 + iMin);
        p0Var.f44175b += iMin;
        jVar.i2(jVar.m2() - ((long) iMin));
        if (p0Var.f44175b == p0Var.f44176c) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        }
        return iMin;
    }

    public static final long q(@yt.k okio.j jVar, @yt.k okio.j sink, long j10) {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
        }
        if (jVar.m2() == 0) {
            return -1L;
        }
        if (j10 > jVar.m2()) {
            j10 = jVar.m2();
        }
        sink.V0(jVar, j10);
        return j10;
    }

    public static final long r(@yt.k okio.j jVar, @yt.k r0 sink) throws IOException {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        long jM2 = jVar.m2();
        if (jM2 > 0) {
            sink.V0(jVar, jM2);
        }
        return jM2;
    }

    @yt.k
    public static final j.a s(@yt.k okio.j jVar, @yt.k j.a unsafeCursor) {
        f0.p(jVar, "<this>");
        f0.p(unsafeCursor, "unsafeCursor");
        j.a aVarM = a1.m(unsafeCursor);
        if (!(aVarM.f44118a == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVarM.f44118a = jVar;
        aVarM.f44119b = true;
        return aVarM;
    }

    public static final byte t(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        if (jVar.m2() == 0) {
            throw new EOFException();
        }
        p0 p0Var = jVar.f44116a;
        f0.m(p0Var);
        int i10 = p0Var.f44175b;
        int i11 = p0Var.f44176c;
        int i12 = i10 + 1;
        byte b10 = p0Var.f44174a[i10];
        jVar.i2(jVar.m2() - 1);
        if (i12 == i11) {
            jVar.f44116a = p0Var.b();
            q0.d(p0Var);
        } else {
            p0Var.f44175b = i12;
        }
        return b10;
    }

    @yt.k
    public static final byte[] u(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        return jVar.w1(jVar.m2());
    }

    @yt.k
    public static final byte[] v(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (jVar.m2() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        jVar.readFully(bArr);
        return bArr;
    }

    @yt.k
    public static final ByteString w(@yt.k okio.j jVar) {
        f0.p(jVar, "<this>");
        return jVar.y(jVar.m2());
    }

    @yt.k
    public static final ByteString x(@yt.k okio.j jVar, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        if (!(j10 >= 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(f0.C("byteCount: ", Long.valueOf(j10)).toString());
        }
        if (jVar.m2() < j10) {
            throw new EOFException();
        }
        if (j10 < 4096) {
            return new ByteString(jVar.w1(j10));
        }
        ByteString byteStringO2 = jVar.o2((int) j10);
        jVar.skip(j10);
        return byteStringO2;
    }

    public static final long y(@yt.k okio.j jVar) throws EOFException {
        f0.p(jVar, "<this>");
        if (jVar.m2() == 0) {
            throw new EOFException();
        }
        long j10 = -7;
        int i10 = 0;
        long j11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        do {
            p0 p0Var = jVar.f44116a;
            f0.m(p0Var);
            byte[] bArr = p0Var.f44174a;
            int i11 = p0Var.f44175b;
            int i12 = p0Var.f44176c;
            while (i11 < i12) {
                byte b10 = bArr[i11];
                byte b11 = (byte) 48;
                if (b10 >= b11 && b10 <= ((byte) 57)) {
                    int i13 = b11 - b10;
                    if (j11 < f44108c || (j11 == f44108c && i13 < j10)) {
                        okio.j jVarV2 = new okio.j().W1(j11).writeByte(b10);
                        if (!z10) {
                            jVarV2.readByte();
                        }
                        throw new NumberFormatException(f0.C("Number too large: ", jVarV2.y1()));
                    }
                    j11 = (j11 * 10) + ((long) i13);
                } else {
                    if (b10 != ((byte) 45) || i10 != 0) {
                        z11 = true;
                        break;
                    }
                    j10--;
                    z10 = true;
                }
                i11++;
                i10++;
            }
            if (i11 == i12) {
                jVar.f44116a = p0Var.b();
                q0.d(p0Var);
            } else {
                p0Var.f44175b = i11;
            }
            if (z11) {
                break;
            }
        } while (jVar.f44116a != null);
        jVar.i2(jVar.m2() - ((long) i10));
        if (i10 >= (z10 ? 2 : 1)) {
            return z10 ? j11 : -j11;
        }
        if (jVar.m2() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((z10 ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + a1.t(jVar.d1(0L)));
    }

    public static final void z(@yt.k okio.j jVar, @yt.k okio.j sink, long j10) throws EOFException {
        f0.p(jVar, "<this>");
        f0.p(sink, "sink");
        if (jVar.m2() >= j10) {
            sink.V0(jVar, j10);
        } else {
            sink.V0(jVar, jVar.m2());
            throw new EOFException();
        }
    }
}
