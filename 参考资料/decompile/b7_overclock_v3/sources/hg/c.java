package hg;

import com.qualcomm.qti.libraries.gaia.GaiaException;
import gg.d;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31276f = 263;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31277g = 254;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31278h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31279i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31280j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31281k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31282l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f31283m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f31284n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f31285o = 6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f31286p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f31287q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f31288r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f31289s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f31290t = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f31291e;

    public c(byte[] bArr) {
        this.f31291e = false;
        byte b10 = bArr[2];
        int length = bArr.length - 8;
        length = (b10 & 1) != 0 ? length - 1 : length;
        this.f31264a = d.b(bArr, 4, 2, false);
        this.f31265b = d.b(bArr, 6, 2, false);
        if (length > 0) {
            byte[] bArr2 = new byte[length];
            this.f31266c = bArr2;
            System.arraycopy(bArr, 8, bArr2, 0, length);
        }
        this.f31267d = bArr;
    }

    @Override // hg.a
    public byte[] a(int i10, byte[] bArr) throws GaiaException {
        int i11;
        int i12 = 0;
        if (bArr.length > 254) {
            throw new GaiaException(0);
        }
        int length = bArr.length + 8;
        byte b10 = this.f31291e;
        int i13 = length + b10;
        byte[] bArr2 = new byte[i13];
        bArr2[0] = -1;
        bArr2[1] = 1;
        bArr2[2] = b10;
        bArr2[3] = (byte) bArr.length;
        d.a(this.f31264a, bArr2, 4, 2, false);
        d.a(i10, bArr2, 6, 2, false);
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        if (this.f31291e) {
            byte b11 = 0;
            while (true) {
                i11 = i13 - 1;
                if (i12 >= i11) {
                    break;
                }
                b11 = (byte) (b11 ^ bArr2[i12]);
                i12++;
            }
            bArr2[i11] = b11;
        }
        return bArr2;
    }

    @Override // hg.a
    public int i() {
        return 254;
    }

    public c(int i10, int i11, boolean z10) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = new byte[0];
        this.f31291e = z10;
        this.f31267d = null;
    }

    public c(int i10, int i11) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = new byte[0];
        this.f31291e = false;
        this.f31267d = null;
    }

    public c(int i10, int i11, byte[] bArr, boolean z10) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = bArr;
        this.f31291e = z10;
        this.f31267d = null;
    }

    public c(int i10, int i11, byte[] bArr) {
        this.f31264a = i10;
        this.f31265b = i11;
        this.f31266c = bArr;
        this.f31291e = false;
        this.f31267d = null;
    }
}
