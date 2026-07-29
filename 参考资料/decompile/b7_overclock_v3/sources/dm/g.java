package dm;

import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.ByteString;
import okio.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Ldm/g;", "", "Lokio/j$a;", "cursor", "", "key", "Lkotlin/z1;", "c", "", "code", "", "b", "d", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final g f26369a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final String f26370b = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f26371c = 128;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f26372d = 64;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26373e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26374f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26375g = 15;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26376h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26377i = 128;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f26378j = 127;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f26379k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f26380l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f26381m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f26382n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f26383o = 9;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f26384p = 10;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f26385q = 125;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f26386r = 123;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f26387s = 126;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f26388t = 65535;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f26389u = 127;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f26390v = 1001;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f26391w = 1005;

    @k
    public final String a(@k String key) {
        f0.p(key, "key");
        return ByteString.f44029c.l(f0.C(key, f26370b)).u0().h();
    }

    @l
    public final String b(int i10) {
        if (i10 < 1000 || i10 >= 5000) {
            return f0.C("Code must be in range [1000,5000): ", Integer.valueOf(i10));
        }
        if (!(1004 <= i10 && i10 < 1007)) {
            if (!(1015 <= i10 && i10 < 3000)) {
                return null;
            }
        }
        return "Code " + i10 + " is reserved and may not be used.";
    }

    public final void c(@k j.a cursor, @k byte[] key) {
        f0.p(cursor, "cursor");
        f0.p(key, "key");
        int length = key.length;
        int i10 = 0;
        do {
            byte[] bArr = cursor.f44122e;
            int i11 = cursor.f44123f;
            int i12 = cursor.f44124g;
            if (bArr != null) {
                while (i11 < i12) {
                    int i13 = i10 % length;
                    bArr[i11] = (byte) (bArr[i11] ^ key[i13]);
                    i11++;
                    i10 = i13 + 1;
                }
            }
        } while (cursor.d() != -1);
    }

    public final void d(int i10) {
        String strB = b(i10);
        if (strB == null) {
            return;
        }
        f0.m(strB);
        throw new IllegalArgumentException(strB.toString());
    }
}
