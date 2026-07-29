package ip;

import np.n1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class s implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f35586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f35587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f35590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f35591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f35592k;

    public s() {
        this.f35590i = 0L;
        this.f35591j = 0;
        this.f35592k = 0;
        this.f35582a = 2;
        this.f35583b = 4;
    }

    public s(int i10, int i11) {
        this.f35590i = 0L;
        this.f35591j = 0;
        this.f35592k = 0;
        this.f35582a = i10;
        this.f35583b = i11;
    }

    public static long h(long j10, int i10) {
        return (j10 >>> (-i10)) | (j10 << i10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof n1)) {
            throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
        }
        byte[] bArrA = ((n1) kVar).a();
        if (bArrA.length != 16) {
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        this.f35584c = org.bouncycastle.util.o.v(bArrA, 0);
        this.f35585d = org.bouncycastle.util.o.v(bArrA, 8);
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "SipHash-" + this.f35582a + "-" + this.f35583b;
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        org.bouncycastle.util.o.F(f(), bArr, i10);
        return 8;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return 8;
    }

    public void e(int i10) {
        long jH = this.f35586e;
        long jH2 = this.f35587f;
        long jH3 = this.f35588g;
        long jH4 = this.f35589h;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jH + jH2;
            long j11 = jH3 + jH4;
            long jH5 = h(jH2, 13) ^ j10;
            long jH6 = h(jH4, 16) ^ j11;
            long j12 = j11 + jH5;
            jH = h(j10, 32) + jH6;
            jH2 = h(jH5, 17) ^ j12;
            jH4 = h(jH6, 21) ^ jH;
            jH3 = h(j12, 32);
        }
        this.f35586e = jH;
        this.f35587f = jH2;
        this.f35588g = jH3;
        this.f35589h = jH4;
    }

    public long f() throws IllegalStateException, DataLengthException {
        long j10 = this.f35590i;
        int i10 = this.f35591j;
        this.f35590i = ((j10 >>> ((7 - i10) << 3)) >>> 8) | ((((long) ((this.f35592k << 3) + i10)) & 255) << 56);
        g();
        this.f35588g ^= 255;
        e(this.f35583b);
        long j11 = ((this.f35586e ^ this.f35587f) ^ this.f35588g) ^ this.f35589h;
        reset();
        return j11;
    }

    public void g() {
        this.f35592k++;
        this.f35589h ^= this.f35590i;
        e(this.f35582a);
        this.f35586e ^= this.f35590i;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        long j10 = this.f35584c;
        this.f35586e = 8317987319222330741L ^ j10;
        long j11 = this.f35585d;
        this.f35587f = 7237128888997146477L ^ j11;
        this.f35588g = j10 ^ 7816392313619706465L;
        this.f35589h = 8387220255154660723L ^ j11;
        this.f35590i = 0L;
        this.f35591j = 0;
        this.f35592k = 0;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        this.f35590i = (this.f35590i >>> 8) | ((((long) b10) & 255) << 56);
        int i10 = this.f35591j + 1;
        this.f35591j = i10;
        if (i10 == 8) {
            g();
            this.f35591j = 0;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        int i12 = i11 & (-8);
        int i13 = this.f35591j;
        int i14 = 0;
        if (i13 == 0) {
            while (i14 < i12) {
                this.f35590i = org.bouncycastle.util.o.v(bArr, i10 + i14);
                g();
                i14 += 8;
            }
            while (i14 < i11) {
                long j10 = this.f35590i >>> 8;
                this.f35590i = j10;
                this.f35590i = j10 | ((((long) bArr[i10 + i14]) & 255) << 56);
                i14++;
            }
            this.f35591j = i11 - i12;
            return;
        }
        int i15 = i13 << 3;
        int i16 = 0;
        while (i16 < i12) {
            long jV = org.bouncycastle.util.o.v(bArr, i10 + i16);
            this.f35590i = (this.f35590i >>> (-i15)) | (jV << i15);
            g();
            this.f35590i = jV;
            i16 += 8;
        }
        while (i16 < i11) {
            long j11 = this.f35590i >>> 8;
            this.f35590i = j11;
            this.f35590i = j11 | ((((long) bArr[i10 + i16]) & 255) << 56);
            int i17 = this.f35591j + 1;
            this.f35591j = i17;
            if (i17 == 8) {
                g();
                this.f35591j = 0;
            }
            i16++;
        }
    }
}
