package zo;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public class m extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[][] f59346e = {new byte[]{6, -124, pq.b.f46994k, 76, -26, 32, i1.a.f31667o7, 10, -78, i1.a.f31699s7, -2, -16, 117, -127, 123, -99}, new byte[]{-117, 102, -76, -31, -120, -13, -96, 107, 100, 15, 107, -92, 47, 8, -9, 23}, new byte[]{52, 2, -34, rc.a.f48413e0, 83, -14, -124, -104, i1.a.A7, 2, -99, jt.l.f36952t, -97, 2, -111, 20}, new byte[]{14, -42, -22, -26, rc.a.f48414f0, 123, 79, 8, -69, -13, rp.u.f49086t, -81, -3, 91, 79, 121}, new byte[]{i1.a.f31741x7, i1.a.A7, -80, i1.a.f31741x7, 72, 114, 68, -117, 121, -18, i1.a.f31750y7, 28, -66, 57, pq.b.f46994k, 68}, new byte[]{126, -22, i1.a.f31750y7, -18, pq.b.f46992i, -112, 50, -73, -115, 83, 53, -19, rc.a.f48411c0, -118, 5, 123}, new byte[]{103, i1.a.f31683q7, -113, 67, 94, rc.a.f48414f0, 124, -48, -30, 65, rc.a.Z, 97, i1.a.B7, 79, -17, 27}, new byte[]{rc.a.f48409a0, rc.a.W, i1.a.E7, -80, -81, i1.a.f31732w7, -52, 7, 103, 95, -3, -30, 31, i1.a.f31714u7, 11, 59}, new byte[]{-85, 77, 99, -15, -26, -122, 127, -23, -20, -37, -113, i1.a.f31732w7, -71, -44, 101, -18}, new byte[]{28, jt.l.f36949q, -65, -124, -44, -73, i1.a.f31750y7, 100, 91, 42, 64, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, 23, 35, -65, 105, 2, -117, rc.a.f48414f0, -115, -10, -104, 0}, new byte[]{-6, 4, tc.a.f51065w, -90, -34, pq.b.f46991h, 85, 114, 74, -86, -98, -56, 92, -99, rc.a.f48413e0, -118}, new byte[]{-33, -76, -97, rc.a.f48411c0, 107, 119, 42, 18, 14, -6, 79, rc.a.f48414f0, rc.a.f48409a0, 18, -97, -44}, new byte[]{30, -95, 3, 68, -12, 73, -94, 54, 50, -42, 17, -82, -69, 106, 18, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, 95, -106, 0, i1.a.f31723v7, -100, -88, -20, -90}, new byte[]{rc.a.V, 2, 94, i1.a.f31659n7, -99, 25, -100, 79, tc.a.f51065w, -94, i1.a.f31714u7, -29, rc.a.Z, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, i1.a.f31723v7, -73, -71, 40, rc.a.f48414f0, i1.a.f31750y7, -126, -44, 1, 115}, new byte[]{98, jt.l.f36952t, pq.b.f46994k, 13, 97, -122, -80, 23, 55, -14, -17, i1.a.E7, 16, jt.l.f36949q, 125, 107}, new byte[]{90, i1.a.f31732w7, 69, i1.a.f31683q7, rc.a.V, jt.l.f36949q, 4, 67, -127, i1.a.f31683q7, -111, 83, -10, -4, -102, i1.a.f31707t7}, new byte[]{-110, 35, -105, 60, 34, 107, 104, -69, rc.a.f48412d0, -81, -110, -24, 54, -47, -108, 58}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f59347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f59348d;

    public m() {
        this.f59347c = new byte[32];
    }

    public m(m mVar) {
        this.f59347c = org.bouncycastle.util.a.p(mVar.f59347c);
        this.f59348d = mVar.f59348d;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "Haraka-256";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        if (this.f59348d != 32) {
            throw new IllegalStateException("input must be exactly 32 bytes");
        }
        if (bArr.length - i10 < 32) {
            throw new IllegalArgumentException("output too short to receive digest");
        }
        int iO = o(this.f59347c, bArr, i10);
        reset();
        return iO;
    }

    public final int o(byte[] bArr, byte[] bArr2, int i10) {
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) byte.class, 2, 16);
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) byte.class, 2, 16);
        System.arraycopy(bArr, 0, bArr3[0], 0, 16);
        System.arraycopy(bArr, 16, bArr3[1], 0, 16);
        byte[] bArr5 = bArr3[0];
        byte[][] bArr6 = f59346e;
        bArr3[0] = o.a(bArr5, bArr6[0]);
        bArr3[1] = o.a(bArr3[1], bArr6[1]);
        bArr3[0] = o.a(bArr3[0], bArr6[2]);
        bArr3[1] = o.a(bArr3[1], bArr6[3]);
        p(bArr3, bArr4);
        bArr3[0] = o.a(bArr4[0], bArr6[4]);
        bArr3[1] = o.a(bArr4[1], bArr6[5]);
        bArr3[0] = o.a(bArr3[0], bArr6[6]);
        bArr3[1] = o.a(bArr3[1], bArr6[7]);
        p(bArr3, bArr4);
        bArr3[0] = o.a(bArr4[0], bArr6[8]);
        bArr3[1] = o.a(bArr4[1], bArr6[9]);
        bArr3[0] = o.a(bArr3[0], bArr6[10]);
        bArr3[1] = o.a(bArr3[1], bArr6[11]);
        p(bArr3, bArr4);
        bArr3[0] = o.a(bArr4[0], bArr6[12]);
        bArr3[1] = o.a(bArr4[1], bArr6[13]);
        bArr3[0] = o.a(bArr3[0], bArr6[14]);
        bArr3[1] = o.a(bArr3[1], bArr6[15]);
        p(bArr3, bArr4);
        bArr3[0] = o.a(bArr4[0], bArr6[16]);
        bArr3[1] = o.a(bArr4[1], bArr6[17]);
        bArr3[0] = o.a(bArr3[0], bArr6[18]);
        bArr3[1] = o.a(bArr3[1], bArr6[19]);
        p(bArr3, bArr4);
        bArr3[0] = o.m(bArr4[0], bArr, 0);
        bArr3[1] = o.m(bArr4[1], bArr, 16);
        System.arraycopy(bArr3[0], 0, bArr2, i10, 16);
        System.arraycopy(bArr3[1], 0, bArr2, i10 + 16, 16);
        return 32;
    }

    public final void p(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 0, bArr2[0], 0, 4);
        System.arraycopy(bArr[1], 0, bArr2[0], 4, 4);
        System.arraycopy(bArr[0], 4, bArr2[0], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[0], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[1], 0, 4);
        System.arraycopy(bArr[1], 8, bArr2[1], 4, 4);
        System.arraycopy(bArr[0], 12, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 12, bArr2[1], 12, 4);
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59348d = 0;
        org.bouncycastle.util.a.n(this.f59347c);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        int i10 = this.f59348d;
        if (i10 + 1 > 32) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        byte[] bArr = this.f59347c;
        this.f59348d = i10 + 1;
        bArr[i10] = b10;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        int i12 = this.f59348d;
        if (i12 + i11 > 32) {
            throw new IllegalArgumentException("total input cannot be more than 32 bytes");
        }
        System.arraycopy(bArr, i10, this.f59347c, i12, i11);
        this.f59348d += i11;
    }
}
