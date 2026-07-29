package xl;

import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.u;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lxl/c;", "", "", "inbound", "", "streamId", fd.c.f28042f, "type", "flags", "", "c", "b", "(I)Ljava/lang/String;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55400c = 16384;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55401d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55402e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55403f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55404g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f55405h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f55406i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55407j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f55408k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f55409l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f55410m = 9;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f55411n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f55412o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f55413p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f55414q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f55415r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f55416s = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f55417t = 32;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f55418u = 32;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @yt.k
    public static final String[] f55421x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f55398a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final ByteString f55399b = ByteString.f44029c.l("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public static final String[] f55419v = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @yt.k
    public static final String[] f55420w = new String[64];

    static {
        String[] strArr = new String[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            String binaryString = Integer.toBinaryString(i11);
            f0.o(binaryString, "toBinaryString(it)");
            strArr[i11] = u.k2(rl.f.y("%8s", binaryString), zc.f.f58383m, '0', false, 4, null);
        }
        f55421x = strArr;
        String[] strArr2 = f55420w;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i12 = 0;
        while (i12 < 1) {
            int i13 = iArr[i12];
            i12++;
            String[] strArr3 = f55420w;
            strArr3[i13 | 8] = f0.C(strArr3[i13], "|PADDED");
        }
        String[] strArr4 = f55420w;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i14 = 0;
        while (i14 < 3) {
            int i15 = iArr2[i14];
            i14++;
            int i16 = 0;
            while (i16 < 1) {
                int i17 = iArr[i16];
                i16++;
                String[] strArr5 = f55420w;
                int i18 = i17 | i15;
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) strArr5[i17]);
                sb2.append('|');
                sb2.append((Object) strArr5[i15]);
                strArr5[i18] = sb2.toString();
                strArr5[i18 | 8] = ((Object) strArr5[i17]) + '|' + ((Object) strArr5[i15]) + "|PADDED";
            }
        }
        int length = f55420w.length;
        while (i10 < length) {
            int i19 = i10 + 1;
            String[] strArr6 = f55420w;
            if (strArr6[i10] == null) {
                strArr6[i10] = f55421x[i10];
            }
            i10 = i19;
        }
    }

    @yt.k
    public final String a(int i10, int i11) {
        String str;
        if (i11 == 0) {
            return "";
        }
        if (i10 != 2 && i10 != 3) {
            if (i10 == 4 || i10 == 6) {
                return i11 == 1 ? "ACK" : f55421x[i11];
            }
            if (i10 != 7 && i10 != 8) {
                String[] strArr = f55420w;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                    f0.m(str);
                } else {
                    str = f55421x[i11];
                }
                String str2 = str;
                return (i10 != 5 || (i11 & 4) == 0) ? (i10 != 0 || (i11 & 32) == 0) ? str2 : u.l2(str2, "PRIORITY", "COMPRESSED", false, 4, null) : u.l2(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return f55421x[i11];
    }

    @yt.k
    public final String b(int i10) {
        String[] strArr = f55419v;
        return i10 < strArr.length ? strArr[i10] : rl.f.y("0x%02x", Integer.valueOf(i10));
    }

    @yt.k
    public final String c(boolean z10, int i10, int i11, int i12, int i13) {
        return rl.f.y("%s 0x%08x %5d %-13s %s", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), b(i12), a(i12, i13));
    }
}
