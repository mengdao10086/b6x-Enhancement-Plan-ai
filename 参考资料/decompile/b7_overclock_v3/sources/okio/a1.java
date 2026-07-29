package okio;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.v1;
import okio.j;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000J\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\t\u001a\u00020\b*\u00020\bH\u0000\u001a\f\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\u0015\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0010\u001a\u00020\b*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0012\u001a\u00020\b*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0013\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000H\u0080\f\u001a\u0015\u0010\u0014\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0080\f\u001a\u0015\u0010\u0015\u001a\u00020\u0000*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H\u0080\f\u001a\u0019\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bH\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0000H\u0080\b\u001a0\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0000\u001a\f\u0010\u001e\u001a\u00020\u001d*\u00020\u000eH\u0000\u001a\f\u0010\u001f\u001a\u00020\u001d*\u00020\bH\u0000\u001a\f\u0010 \u001a\u00020\u001d*\u00020\u0000H\u0000\u001a\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0000\u001a\u0014\u0010&\u001a\u00020\b*\u00020$2\u0006\u0010%\u001a\u00020\bH\u0000\" \u0010,\u001a\u00020!8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)\"\u001a\u00100\u001a\u00020\b8\u0000X\u0080D¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"", "size", w.c.R, "byteCount", "Lkotlin/z1;", "e", "", "p", "", "n", "o", "bitCount", "i", "q", "", "other", an.aB, SsManifestParser.e.J, "a", "b", "w", "c", "k", xf.j.f55230b, "", "aOffset", "bOffset", "", "d", "", "t", "u", "v", "Lokio/j$a;", "unsafeCursor", m0.k.f40564b, "Lokio/ByteString;", CommonNetImpl.POSITION, com.flydigi.sdk.bluetooth.l.f16298a, "Lokio/j$a;", "g", "()Lokio/j$a;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "DEFAULT__new_UnsafeCursor", "I", "f", "()I", "DEFAULT__ByteString_size", "okio"}, k = 2, mv = {1, 5, 1})
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final j.a f44040a = new j.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f44041b = -1234567890;

    public static final int a(byte b10, int i10) {
        return b10 & i10;
    }

    public static final long b(byte b10, long j10) {
        return ((long) b10) & j10;
    }

    public static final long c(int i10, long j10) {
        return ((long) i10) & j10;
    }

    public static final boolean d(@yt.k byte[] a10, int i10, @yt.k byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(a10, "a");
        kotlin.jvm.internal.f0.p(b10, "b");
        if (i12 <= 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
            if (i14 >= i12) {
                return true;
            }
            i13 = i14;
        }
    }

    public static final void e(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int f() {
        return f44041b;
    }

    @yt.k
    public static final j.a g() {
        return f44040a;
    }

    public static /* synthetic */ void h() {
    }

    public static final int i(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public static final long j(int i10, long j10) {
        return Math.min(i10, j10);
    }

    public static final long k(long j10, int i10) {
        return Math.min(j10, i10);
    }

    public static final int l(@yt.k ByteString byteString, int i10) {
        kotlin.jvm.internal.f0.p(byteString, "<this>");
        return i10 == f44041b ? byteString.x0() : i10;
    }

    @yt.k
    public static final j.a m(@yt.k j.a unsafeCursor) {
        kotlin.jvm.internal.f0.p(unsafeCursor, "unsafeCursor");
        return unsafeCursor == f44040a ? new j.a() : unsafeCursor;
    }

    public static final int n(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final long o(long j10) {
        return ((j10 & 255) << 56) | (((-72057594037927936L) & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static final short p(short s10) {
        int i10 = s10 & v1.f38215d;
        return (short) (((i10 & 255) << 8) | ((65280 & i10) >>> 8));
    }

    public static final long q(long j10, int i10) {
        return (j10 << (64 - i10)) | (j10 >>> i10);
    }

    public static final int r(byte b10, int i10) {
        return b10 << i10;
    }

    public static final int s(byte b10, int i10) {
        return b10 >> i10;
    }

    @yt.k
    public static final String t(byte b10) {
        return kotlin.text.u.u1(new char[]{okio.internal.e.J()[(b10 >> 4) & 15], okio.internal.e.J()[b10 & 15]});
    }

    @yt.k
    public static final String u(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {okio.internal.e.J()[(i10 >> 28) & 15], okio.internal.e.J()[(i10 >> 24) & 15], okio.internal.e.J()[(i10 >> 20) & 15], okio.internal.e.J()[(i10 >> 16) & 15], okio.internal.e.J()[(i10 >> 12) & 15], okio.internal.e.J()[(i10 >> 8) & 15], okio.internal.e.J()[(i10 >> 4) & 15], okio.internal.e.J()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return kotlin.text.u.v1(cArr, i11, 8);
    }

    @yt.k
    public static final String v(long j10) {
        if (j10 == 0) {
            return "0";
        }
        int i10 = 0;
        char[] cArr = {okio.internal.e.J()[(int) ((j10 >> 60) & 15)], okio.internal.e.J()[(int) ((j10 >> 56) & 15)], okio.internal.e.J()[(int) ((j10 >> 52) & 15)], okio.internal.e.J()[(int) ((j10 >> 48) & 15)], okio.internal.e.J()[(int) ((j10 >> 44) & 15)], okio.internal.e.J()[(int) ((j10 >> 40) & 15)], okio.internal.e.J()[(int) ((j10 >> 36) & 15)], okio.internal.e.J()[(int) ((j10 >> 32) & 15)], okio.internal.e.J()[(int) ((j10 >> 28) & 15)], okio.internal.e.J()[(int) ((j10 >> 24) & 15)], okio.internal.e.J()[(int) ((j10 >> 20) & 15)], okio.internal.e.J()[(int) ((j10 >> 16) & 15)], okio.internal.e.J()[(int) ((j10 >> 12) & 15)], okio.internal.e.J()[(int) ((j10 >> 8) & 15)], okio.internal.e.J()[(int) ((j10 >> 4) & 15)], okio.internal.e.J()[(int) (j10 & 15)]};
        while (i10 < 16 && cArr[i10] == '0') {
            i10++;
        }
        return kotlin.text.u.v1(cArr, i10, 16);
    }

    public static final byte w(byte b10, byte b11) {
        return (byte) (b10 ^ b11);
    }
}
