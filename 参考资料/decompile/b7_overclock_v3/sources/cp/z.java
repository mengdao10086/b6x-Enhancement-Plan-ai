package cp;

import java.util.Enumeration;
import java.util.Hashtable;
import np.x1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class z implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25759d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static byte[] f25760e = {4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static byte[] f25761f = {4, 2, 15, 5, 9, 1, 0, 8, 14, 3, 11, 12, 13, 7, 10, 6, 12, 9, 15, 14, 8, 1, 3, 10, 2, 7, 4, 13, 6, 0, 11, 5, 13, 8, 14, 12, 7, 3, 9, 10, 1, 5, 2, 4, 6, 15, 0, 11, 14, 9, 11, 2, 5, 15, 7, 1, 0, 13, 12, 6, 10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 0, 13, 10, 11, 7, 12, 2, 1, 15, 4, 8, 15, 6, 11, 1, 9, 12, 5, 13, 3, 7, 10, 0, 14, 2, 4, 9, 11, 12, 0, 3, 6, 7, 5, 4, 8, 14, 15, 1, 10, 2, 13, 12, 6, 5, 2, 11, 0, 9, 13, 3, 14, 7, 10, 15, 4, 1, 8};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static byte[] f25762g = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static byte[] f25763h = {8, 4, 11, 1, 3, 5, 0, 9, 2, 14, 10, 12, 13, 6, 7, 15, 0, 1, 2, 10, 4, 13, 5, 12, 9, 7, 3, 15, 11, 8, 6, 14, 14, 12, 0, 10, 9, 2, 13, 11, 7, 5, 8, 15, 3, 6, 1, 4, 7, 5, 0, 13, 11, 6, 1, 2, 3, 10, 12, 15, 4, 14, 9, 8, 2, 7, 12, 15, 9, 5, 10, 11, 1, 4, 0, 13, 6, 8, 14, 3, 8, 3, 2, 6, 4, 13, 14, 11, 12, 1, 7, 15, 10, 0, 9, 5, 5, 2, 10, 11, 9, 1, 12, 3, 7, 4, 13, 0, 6, 15, 8, 14, 0, 4, 11, 14, 8, 3, 7, 1, 10, 2, 9, 6, 15, 13, 5, 12};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static byte[] f25764i = {1, 11, 12, 2, 9, 13, 0, 15, 4, 5, 8, 14, 10, 7, 6, 3, 0, 1, 7, 13, 11, 4, 5, 2, 8, 14, 15, 12, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, 15, 10, 3, 7, 12, 13, 6, 14, 1, 11, 3, 6, 0, 1, 5, 13, 10, 8, 11, 2, 9, 7, 14, 15, 12, 4, 8, 13, 11, 0, 4, 5, 1, 2, 9, 3, 12, 14, 6, 15, 10, 7, 12, 9, 11, 1, 8, 14, 2, 4, 7, 3, 6, 5, 10, 0, 15, 13, 10, 9, 6, 8, 13, 14, 2, 0, 15, 3, 5, 11, 4, 1, 12, 7, 7, 4, 0, 5, 10, 2, 15, 14, 12, 6, 1, 11, 13, 9, 3, 8};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static byte[] f25765j = {15, 12, 2, 10, 6, 4, 5, 0, 7, 9, 14, 13, 1, 11, 8, 3, 11, 6, 3, 4, 12, 15, 14, 2, 7, 13, 8, 0, 5, 10, 9, 1, 1, 12, 11, 0, 15, 14, 6, 5, 10, 13, 4, 8, 9, 3, 7, 2, 1, 5, 14, 12, 10, 7, 0, 13, 6, 2, 11, 4, 9, 3, 15, 8, 0, 12, 8, 9, 13, 2, 10, 11, 7, 3, 6, 5, 4, 14, 15, 1, 8, 0, 15, 3, 2, 5, 14, 11, 1, 10, 4, 7, 12, 9, 13, 6, 3, 0, 6, 15, 1, 14, 9, 2, 13, 8, 12, 4, 11, 10, 5, 7, 1, 10, 6, 8, 15, 11, 0, 4, 12, 3, 5, 9, 7, 13, 2, 14};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static byte[] f25766k = {12, 4, 6, 2, 10, 5, 11, 9, 14, 8, 13, 7, 0, 3, 15, 1, 6, 8, 2, 3, 9, 10, 5, 12, 1, 14, 4, 7, 11, 13, 0, 15, 11, 3, 5, 8, 2, 15, 10, 13, 14, 1, 7, 4, 12, 9, 6, 0, 12, 8, 2, 1, 13, 4, 15, 6, 7, 0, 10, 5, 3, 14, 9, 11, 7, 15, 5, 10, 8, 1, 6, 13, 0, 9, 3, 14, 11, 4, 2, 12, 5, 13, 15, 6, 9, 2, 12, 10, 11, 7, 8, 1, 4, 3, 14, 0, 8, 14, 2, 5, 6, 9, 1, 12, 15, 4, 11, 0, 13, 10, 3, 7, 1, 7, 14, 13, 0, 5, 8, 3, 4, 15, 10, 6, 9, 12, 11, 2};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static byte[] f25767l = {4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static byte[] f25768m = {10, 4, 5, 6, 8, 1, 3, 7, 13, 12, 14, 0, 9, 2, 11, 15, 5, 15, 4, 0, 2, 13, 11, 9, 1, 7, 6, 3, 12, 14, 10, 8, 7, 15, 12, 14, 9, 4, 1, 0, 3, 11, 5, 2, 6, 10, 8, 13, 4, 10, 7, 12, 0, 15, 2, 8, 14, 1, 6, 5, 13, 11, 9, 3, 7, 6, 4, 11, 9, 12, 2, 10, 1, 8, 0, 14, 15, 13, 3, 5, 7, 6, 2, 4, 13, 9, 15, 0, 10, 1, 5, 11, 8, 14, 12, 3, 13, 14, 4, 1, 7, 0, 5, 10, 3, 12, 8, 15, 6, 2, 9, 11, 1, 3, 10, 9, 5, 11, 4, 15, 8, 6, 7, 14, 13, 0, 2, 12};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Hashtable f25769n = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25771b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25770a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25772c = f25760e;

    static {
        g("Default", f25760e);
        g("E-TEST", f25761f);
        g("E-A", f25762g);
        g("E-B", f25763h);
        g("E-C", f25764i);
        g("E-D", f25765j);
        g("Param-Z", f25766k);
        g("D-TEST", f25767l);
        g("D-A", f25768m);
    }

    public static void g(String str, byte[] bArr) {
        f25769n.put(Strings.o(str), bArr);
    }

    public static byte[] j(String str) {
        byte[] bArr = (byte[]) f25769n.get(Strings.o(str));
        if (bArr != null) {
            return org.bouncycastle.util.a.p(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    public static String k(byte[] bArr) {
        Enumeration enumerationKeys = f25769n.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            if (org.bouncycastle.util.a.g((byte[]) f25769n.get(str), bArr)) {
                return str;
            }
        }
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof x1) {
            x1 x1Var = (x1) kVar;
            byte[] bArrB = x1Var.b();
            if (bArrB.length != f25760e.length) {
                throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
            }
            this.f25772c = org.bouncycastle.util.a.p(bArrB);
            if (x1Var.a() != null) {
                this.f25770a = i(z10, ((np.n1) x1Var.a()).a());
                return;
            }
            return;
        }
        if (kVar instanceof np.n1) {
            this.f25770a = i(z10, ((np.n1) kVar).a());
        } else {
            if (kVar == null) {
                return;
            }
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "GOST28147";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArr = this.f25770a;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        e(iArr, bArr, i10, bArr2, i11);
        return 8;
    }

    public final void e(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12;
        int i13;
        int iH = h(bArr, i10);
        int iH2 = h(bArr, i10 + 4);
        int i14 = 7;
        if (this.f25771b) {
            for (int i15 = 0; i15 < 3; i15++) {
                int i16 = 0;
                while (i16 < 8) {
                    int iF = iH2 ^ f(iH, iArr[i16]);
                    i16++;
                    int i17 = iH;
                    iH = iF;
                    iH2 = i17;
                }
            }
            i12 = iH2;
            i13 = iH;
            while (i14 > 0) {
                int iF2 = i12 ^ f(i13, iArr[i14]);
                i14--;
                i12 = i13;
                i13 = iF2;
            }
        } else {
            int i18 = 0;
            while (i18 < 8) {
                int iF3 = iH2 ^ f(iH, iArr[i18]);
                i18++;
                int i19 = iH;
                iH = iF3;
                iH2 = i19;
            }
            i12 = iH2;
            i13 = iH;
            for (int i20 = 0; i20 < 3; i20++) {
                int i21 = 7;
                while (i21 >= 0 && (i20 != 2 || i21 != 0)) {
                    int iF4 = i12 ^ f(i13, iArr[i21]);
                    i21--;
                    i12 = i13;
                    i13 = iF4;
                }
            }
        }
        int iF5 = f(i13, iArr[0]) ^ i12;
        l(i13, bArr2, i11);
        l(iF5, bArr2, i11 + 4);
    }

    public final int f(int i10, int i11) {
        int i12 = i11 + i10;
        byte[] bArr = this.f25772c;
        int i13 = (bArr[((i12 >> 0) & 15) + 0] << 0) + (bArr[((i12 >> 4) & 15) + 16] << 4) + (bArr[((i12 >> 8) & 15) + 32] << 8) + (bArr[((i12 >> 12) & 15) + 48] << 12) + (bArr[((i12 >> 16) & 15) + 64] << 16) + (bArr[((i12 >> 20) & 15) + 80] << 20) + (bArr[((i12 >> 24) & 15) + 96] << 24) + (bArr[((i12 >> 28) & 15) + 112] << 28);
        return (i13 << 11) | (i13 >>> 21);
    }

    public final int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << 24) & (-16777216)) + ((bArr[i10 + 2] << 16) & 16711680) + ((bArr[i10 + 1] << 8) & 65280) + (bArr[i10] & 255);
    }

    public final int[] i(boolean z10, byte[] bArr) {
        this.f25771b = z10;
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int[] iArr = new int[8];
        for (int i10 = 0; i10 != 8; i10++) {
            iArr[i10] = h(bArr, i10 * 4);
        }
        return iArr;
    }

    public final void l(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >>> 24);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11] = (byte) i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
