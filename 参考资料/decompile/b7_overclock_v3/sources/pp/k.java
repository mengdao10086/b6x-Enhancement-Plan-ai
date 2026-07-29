package pp;

import okio.w0;
import org.bouncycastle.util.o;
import rp.u;

/* JADX INFO: loaded from: classes5.dex */
public class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f46967a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f46968b = {-69, rc.a.f48412d0, 98, 127, -75, -86, -44, 13, -127, -2, -78, -126, i1.a.f31741x7, -96, -95, 8, 24, pq.b.f46993j, 86, -24, 73, 2, 16, -60, -34, 53, -91, -20, -128, 18, -72, 105, i1.a.B7, 47, 117, -52, -94, 9, 54, 3, 97, rc.a.f48413e0, -3, -32, -35, 5, 67, -112, -83, -56, -31, -81, 87, -101, 76, i1.a.f31659n7, 81, -82, jt.l.f36951s, -123, 60, 10, -28, -13, -100, rc.a.Y, 35, 83, i1.a.f31723v7, -125, -105, 70, -79, -103, 100, 49, 119, -43, 29, -42, tc.a.f51065w, -67, 94, -80, -118, 34, 56, -8, 104, rc.a.f48411c0, 42, i1.a.f31699s7, -45, -9, u.f49086t, pq.b.f46991h, -33, 4, -27, -107, 62, rc.a.X, -122, -90, 11, -113, -15, rc.a.W, 14, -41, 64, -77, i1.a.A7, 126, 6, 21, -102, 77, 28, -93, -37, 50, -110, o5.b.f42741j, 17, rc.a.Z, -12, 89, -48, 78, 106, 23, 91, -84, -1, 7, i1.a.f31667o7, 101, 121, -4, i1.a.f31714u7, i1.a.f31750y7, 118, 66, 93, -25, 58, 52, 122, jt.l.f36949q, 40, 15, 115, 1, -7, -47, -46, 25, -23, -111, -71, 90, -19, 65, 109, -76, i1.a.f31691r7, -98, -65, 99, -6, 31, 51, jt.l.f36952t, 71, -119, -16, -106, 26, 95, -109, 61, 55, 75, i1.a.E7, -88, i1.a.f31675p7, 27, -10, 57, -117, -73, 12, 32, i1.a.f31759z7, -120, pq.b.f46992i, -74, 116, -114, -115, 22, rc.a.f48409a0, -14, -121, -11, -21, pq.b.f46994k, -29, -5, 85, -97, i1.a.f31707t7, 68, 74, 69, 125, -30, 107, 92, 108, 102, -87, -116, -18, -124, 19, -89, 30, -99, -36, 103, 72, -70, rc.a.f48414f0, -26, -92, -85, 124, -108, 0, rc.a.V, -17, -22, -66, i1.a.f31732w7, 114, 79, 82, -104, w0.f44229a, i1.a.f31683q7, 20, 123, 59, 84};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f46969c = -66;

    @Override // pp.g
    public void a(byte[] bArr, int i10, int i11) {
        synchronized (this.f46968b) {
            int i12 = i11 + i10;
            while (i10 != i12) {
                byte[] bArr2 = this.f46968b;
                byte b10 = this.f46969c;
                byte b11 = this.f46967a;
                byte b12 = bArr2[(b10 + bArr2[b11 & 255]) & 255];
                this.f46969c = b12;
                bArr[i10] = bArr2[(bArr2[bArr2[b12 & 255] & 255] + 1) & 255];
                byte b13 = bArr2[b11 & 255];
                bArr2[b11 & 255] = bArr2[b12 & 255];
                bArr2[b12 & 255] = b13;
                this.f46967a = (byte) ((b11 + 1) & 255);
                i10++;
            }
        }
    }

    @Override // pp.g
    public void b(long j10) {
        c(o.D(j10));
    }

    @Override // pp.g
    public void c(byte[] bArr) {
        for (byte b10 : bArr) {
            byte[] bArr2 = this.f46968b;
            byte b11 = this.f46969c;
            byte b12 = this.f46967a;
            byte b13 = bArr2[(b11 + bArr2[b12 & 255] + b10) & 255];
            this.f46969c = b13;
            byte b14 = bArr2[b12 & 255];
            bArr2[b12 & 255] = bArr2[b13 & 255];
            bArr2[b13 & 255] = b14;
            this.f46967a = (byte) ((b12 + 1) & 255);
        }
    }

    @Override // pp.g
    public void d(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }
}
