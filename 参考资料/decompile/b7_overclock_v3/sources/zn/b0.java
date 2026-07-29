package zn;

import gm.c2;
import gm.f2;
import gm.n2;
import java.io.IOException;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58668c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58669d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58670e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58671f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58672g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58673h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f58674i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58675j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f58676k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f58677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58678b;

    public b0(int i10, gm.h hVar) {
        this.f58677a = hVar;
        this.f58678b = i10;
    }

    public b0(int i10, String str) {
        gm.h c2Var;
        this.f58678b = i10;
        if (i10 == 1 || i10 == 2 || i10 == 6) {
            c2Var = new c2(str);
        } else if (i10 == 8) {
            c2Var = new gm.y(str);
        } else {
            if (i10 != 4) {
                if (i10 != 7) {
                    throw new IllegalArgumentException("can't process String for tag: " + i10);
                }
                byte[] bArrF = F(str);
                if (bArrF == null) {
                    throw new IllegalArgumentException("IP Address is invalid");
                }
                this.f58677a = new f2(bArrF);
                return;
            }
            c2Var = new xn.d(str);
        }
        this.f58677a = c2Var;
    }

    public b0(xn.d dVar) {
        this.f58677a = dVar;
        this.f58678b = 4;
    }

    public b0(w1 w1Var) {
        this.f58677a = xn.d.A(w1Var);
        this.f58678b = 4;
    }

    public static b0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.n0.S(n0Var, true));
    }

    public static b0 z(Object obj) {
        if (obj == null || (obj instanceof b0)) {
            return (b0) obj;
        }
        if (!(obj instanceof gm.n0)) {
            if (obj instanceof byte[]) {
                try {
                    return z(gm.c0.D((byte[]) obj));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("unable to parse encoded general name");
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        gm.n0 n0Var = (gm.n0) obj;
        int iQ = n0Var.q();
        switch (iQ) {
            case 0:
            case 3:
            case 5:
                return new b0(iQ, gm.f0.I(n0Var, false));
            case 1:
            case 2:
            case 6:
                return new b0(iQ, gm.r.H(n0Var, false));
            case 4:
                return new b0(iQ, xn.d.z(n0Var, true));
            case 7:
                return new b0(iQ, gm.z.H(n0Var, false));
            case 8:
                return new b0(iQ, gm.y.M(n0Var, false));
            default:
                throw new IllegalArgumentException("unknown tag: " + iQ);
        }
    }

    public gm.h A() {
        return this.f58677a;
    }

    public final void B(String str, byte[] bArr, int i10) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "./");
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            bArr[i11 + i10] = (byte) Integer.parseInt(stringTokenizer.nextToken());
            i11++;
        }
    }

    public final void C(String str, byte[] bArr, int i10) {
        int i11 = Integer.parseInt(str);
        for (int i12 = 0; i12 != i11; i12++) {
            int i13 = (i12 / 8) + i10;
            bArr[i13] = (byte) (bArr[i13] | (1 << (7 - (i12 % 8))));
        }
    }

    public final int[] D(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":", true);
        int[] iArr = new int[8];
        if (str.charAt(0) == ':' && str.charAt(1) == ':') {
            stringTokenizer.nextToken();
        }
        int i10 = -1;
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals(":")) {
                iArr[i11] = 0;
                int i12 = i11;
                i11++;
                i10 = i12;
            } else if (strNextToken.indexOf(46) < 0) {
                int i13 = i11 + 1;
                iArr[i11] = Integer.parseInt(strNextToken, 16);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                }
                i11 = i13;
            } else {
                StringTokenizer stringTokenizer2 = new StringTokenizer(strNextToken, j3.b.f36044h);
                int i14 = i11 + 1;
                iArr[i11] = (Integer.parseInt(stringTokenizer2.nextToken()) << 8) | Integer.parseInt(stringTokenizer2.nextToken());
                i11 = i14 + 1;
                iArr[i14] = Integer.parseInt(stringTokenizer2.nextToken()) | (Integer.parseInt(stringTokenizer2.nextToken()) << 8);
            }
        }
        if (i11 != 8) {
            int i15 = i11 - i10;
            int i16 = 8 - i15;
            System.arraycopy(iArr, i10, iArr, i16, i15);
            while (i10 != i16) {
                iArr[i10] = 0;
                i10++;
            }
        }
        return iArr;
    }

    public final int[] E(String str) {
        int[] iArr = new int[8];
        int i10 = Integer.parseInt(str);
        for (int i11 = 0; i11 != i10; i11++) {
            int i12 = i11 / 16;
            iArr[i12] = iArr[i12] | (1 << (15 - (i11 % 16)));
        }
        return iArr;
    }

    public final byte[] F(String str) {
        if (org.bouncycastle.util.i.f(str) || org.bouncycastle.util.i.e(str)) {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf < 0) {
                byte[] bArr = new byte[16];
                x(D(str), bArr, 0);
                return bArr;
            }
            byte[] bArr2 = new byte[32];
            x(D(str.substring(0, iIndexOf)), bArr2, 0);
            String strSubstring = str.substring(iIndexOf + 1);
            x(strSubstring.indexOf(58) > 0 ? D(strSubstring) : E(strSubstring), bArr2, 16);
            return bArr2;
        }
        if (!org.bouncycastle.util.i.d(str) && !org.bouncycastle.util.i.c(str)) {
            return null;
        }
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0) {
            byte[] bArr3 = new byte[4];
            B(str, bArr3, 0);
            return bArr3;
        }
        byte[] bArr4 = new byte[8];
        B(str.substring(0, iIndexOf2), bArr4, 0);
        String strSubstring2 = str.substring(iIndexOf2 + 1);
        if (strSubstring2.indexOf(46) > 0) {
            B(strSubstring2, bArr4, 4);
        } else {
            C(strSubstring2, bArr4, 4);
        }
        return bArr4;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        int i10 = this.f58678b;
        return new n2(i10 == 4, i10, this.f58677a);
    }

    public int q() {
        return this.f58678b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r3.f58678b
            r0.append(r1)
            java.lang.String r1 = ": "
            r0.append(r1)
            int r1 = r3.f58678b
            r2 = 1
            if (r1 == r2) goto L2f
            r2 = 2
            if (r1 == r2) goto L2f
            r2 = 4
            if (r1 == r2) goto L24
            r2 = 6
            if (r1 == r2) goto L2f
            gm.h r1 = r3.f58677a
            java.lang.String r1 = r1.toString()
            goto L39
        L24:
            gm.h r1 = r3.f58677a
            xn.d r1 = xn.d.A(r1)
            java.lang.String r1 = r1.toString()
            goto L39
        L2f:
            gm.h r1 = r3.f58677a
            gm.r r1 = gm.r.I(r1)
            java.lang.String r1 = r1.d()
        L39:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.b0.toString():java.lang.String");
    }

    public final void x(int[] iArr, byte[] bArr, int i10) {
        for (int i11 = 0; i11 != iArr.length; i11++) {
            int i12 = i11 * 2;
            bArr[i12 + i10] = (byte) (iArr[i11] >> 8);
            bArr[i12 + 1 + i10] = (byte) iArr[i11];
        }
    }
}
