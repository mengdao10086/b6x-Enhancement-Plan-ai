package m9;

import java.util.List;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final e f40735a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40736b = {-70, i1.a.f31667o7, 0, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final byte[] f40737c = {19, 1, 0, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40738d = {19, 2, 0, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40739e = {19, 3, 0, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final byte[] f40740f = {19, 4, 0, 0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final byte[] f40741g = {-91, 1, 0, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final byte[] f40742h = {19, 6, 0, 0};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final byte[] f40743i = {-84, pq.b.f46991h, 0};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40744j = {-84, pq.b.f46991h, 0};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40745k = {-84, -119, 0};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40746l = {-91, -96, 0, 0};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40747m = {-91, -95, 0, 0};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final byte[] f40748n = {20, 1, 0, 0};

    @hk.m
    @yt.k
    public static final byte[] b(boolean z10) {
        return new byte[]{-84, (byte) (z10 ? 153 : 25), 0};
    }

    public static /* synthetic */ byte[] c(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return b(z10);
    }

    @hk.m
    @yt.k
    public static final byte[] e(int i10) {
        byte[] bArr = new byte[20];
        byte b10 = 0;
        bArr[0] = 65;
        if (i10 != 1) {
            if (i10 == 2) {
                b10 = 2;
            } else if (i10 == 3) {
                b10 = 1;
            } else if (i10 == 4) {
                b10 = 3;
            }
        }
        bArr[1] = b10;
        l9.b.a(bArr);
        return bArr;
    }

    @hk.m
    @yt.k
    public static final byte[] h(byte b10) {
        byte[] bArr = new byte[20];
        bArr[0] = 47;
        bArr[1] = b10;
        l9.b.a(bArr);
        return bArr;
    }

    public static /* synthetic */ byte[] p(e eVar, byte b10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return eVar.n(b10, z10);
    }

    @hk.m
    public static final boolean q(@yt.k byte[] value) {
        f0.p(value, "value");
        if (value.length == 20) {
            return (value[0] & 255) == 81 || (value[0] & 255) == 82 || (value[0] & 255) == 83;
        }
        return false;
    }

    @hk.m
    public static final boolean r(@yt.k byte[] value) {
        f0.p(value, "value");
        return (value[0] & 255) == 83;
    }

    @hk.m
    @yt.k
    public static final byte[] s(boolean z10, boolean z11) {
        int i10 = z10 ? 48 : 33;
        if (z11) {
            i10 |= 128;
        }
        return new byte[]{-84, (byte) i10, 0};
    }

    public static /* synthetic */ byte[] t(boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return s(z10, z11);
    }

    @hk.m
    @yt.k
    public static final byte[] u(int i10) {
        byte[] bArr = new byte[4];
        byte b10 = 0;
        bArr[0] = 19;
        if (i10 == 0) {
            b10 = 16;
        } else if (i10 == 1) {
            b10 = 17;
        } else if (i10 == 3) {
            b10 = 19;
        } else if (i10 == 4) {
            b10 = 18;
        }
        bArr[1] = b10;
        return bArr;
    }

    @hk.m
    @yt.k
    public static final byte[] w(boolean z10) {
        byte[] bArr = new byte[20];
        bArr[0] = z10 ? (byte) 82 : (byte) 83;
        l9.b.a(bArr);
        return bArr;
    }

    @hk.m
    @yt.k
    public static final byte[] x() {
        byte[] bArr = new byte[20];
        bArr[0] = 84;
        l9.b.a(bArr);
        return bArr;
    }

    @hk.m
    @yt.k
    public static final byte[] y(int i10) {
        byte[] bArr = new byte[20];
        bArr[0] = 64;
        bArr[1] = (byte) i10;
        l9.b.a(bArr);
        return bArr;
    }

    @hk.m
    @yt.k
    public static final byte[] z(@yt.k List<Byte> data, int i10, int i11) {
        f0.p(data, "data");
        byte[] bArr = new byte[20];
        bArr[0] = 81;
        bArr[1] = (byte) i10;
        bArr[2] = (byte) i11;
        for (int i12 = 0; i12 < 16; i12++) {
            if (i12 < data.size()) {
                bArr[i12 + 3] = data.get(i12).byteValue();
            } else {
                bArr[i12 + 3] = -1;
            }
        }
        l9.b.a(bArr);
        return bArr;
    }

    @yt.k
    public final byte[] a(boolean z10, boolean z11, @yt.k byte[] value, boolean z12) {
        f0.p(value, "value");
        byte[] bArr = new byte[33];
        bArr[0] = 65;
        if (z10) {
            bArr[1] = i1.a.f31667o7;
            System.arraycopy(value, 0, bArr, 2, value.length);
        } else {
            bArr[1] = 4;
            bArr[2] = -2;
            if (z12) {
                bArr[3] = 119;
                bArr[4] = value[9];
                bArr[5] = value[8];
                bArr[6] = value[1];
                bArr[7] = value[2];
                bArr[8] = value[3];
                bArr[9] = value[4];
                bArr[10] = value[5];
                bArr[11] = value[11];
                bArr[12] = value[12];
                bArr[13] = value[13];
            } else {
                bArr[3] = 102;
                bArr[4] = 0;
                bArr[5] = value[11];
                bArr[6] = value[12];
                bArr[7] = value[13];
                bArr[8] = value[9];
                bArr[9] = value[8];
                bArr[10] = value[4];
                bArr[11] = value[5];
                bArr[18] = value[0];
                bArr[19] = 0;
                bArr[20] = value[1];
                bArr[21] = 0;
                bArr[22] = value[2];
                bArr[23] = value[3];
                bArr[24] = value[6];
                bArr[25] = value[7];
                bArr[31] = 102;
                if (z11) {
                    bArr[32] = 18;
                } else {
                    bArr[32] = 17;
                }
            }
        }
        return bArr;
    }

    @yt.k
    public final byte[] d() {
        return new byte[]{-84, -2, 1, 0};
    }

    @yt.k
    public final byte[] f() {
        return f40743i;
    }

    @yt.k
    public final byte[] g() {
        return f40741g;
    }

    @yt.k
    public final byte[] i(int i10) {
        return new byte[]{19, 5, (byte) i10, 0};
    }

    @yt.k
    public final byte[] j() {
        return f40737c;
    }

    @yt.k
    public final byte[] k() {
        return f40742h;
    }

    @yt.k
    public final byte[] l() {
        return f40740f;
    }

    @yt.k
    public final byte[] m(int i10) {
        return new byte[]{16, (byte) i10, 1, 1};
    }

    @yt.k
    public final byte[] n(byte b10, boolean z10) {
        byte[] bArr = new byte[4];
        bArr[0] = 17;
        bArr[1] = z10 ? b10 : (byte) 0;
        if (z10) {
            b10 = 0;
        }
        bArr[2] = b10;
        bArr[3] = 100;
        return bArr;
    }

    @yt.k
    public final byte[] o(int i10, int i11, int i12) {
        byte[] bArr = new byte[4];
        bArr[0] = 17;
        if (!(i10 >= 0 && i10 < 256)) {
            i10 = 0;
        }
        bArr[1] = (byte) i10;
        if (!(i11 >= 0 && i11 < 256)) {
            i11 = 0;
        }
        bArr[2] = (byte) i11;
        bArr[3] = (byte) i12;
        return bArr;
    }

    @yt.k
    public final byte[] v(@yt.k byte[] color, int i10) {
        f0.p(color, "color");
        byte[] bArr = new byte[4];
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i11] = 0;
        }
        bArr[0] = 18;
        bArr[1] = color[0];
        bArr[2] = color[1];
        bArr[3] = color[2];
        return bArr;
    }
}
