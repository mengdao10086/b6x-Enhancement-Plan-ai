package qp;

import java.util.Hashtable;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.j;
import rs.h;

/* JADX INFO: loaded from: classes5.dex */
public class e implements f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f47583h = {1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f47584i = 140737488355328L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47585j = 262144;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Hashtable f47586k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f47587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f47588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f47589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f47590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public pp.d f47591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47593g;

    static {
        Hashtable hashtable = new Hashtable();
        f47586k = hashtable;
        hashtable.put(et.e.f27137f, j.g(440));
        hashtable.put(et.e.f27138g, j.g(440));
        hashtable.put("SHA-256", j.g(440));
        hashtable.put(h.f49168c, j.g(440));
        hashtable.put("SHA-512/224", j.g(440));
        hashtable.put(et.e.f27140i, j.g(888));
        hashtable.put("SHA-512", j.g(888));
    }

    public e(s sVar, int i10, pp.d dVar, byte[] bArr, byte[] bArr2) {
        if (i10 > g.a(sVar)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (dVar.c() < i10) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this.f47587a = sVar;
        this.f47591e = dVar;
        this.f47592f = i10;
        this.f47593g = ((Integer) f47586k.get(sVar.b())).intValue();
        byte[] bArrC = g.c(this.f47587a, org.bouncycastle.util.a.C(f(), bArr2, bArr), this.f47593g);
        this.f47588b = bArrC;
        byte[] bArr3 = new byte[bArrC.length + 1];
        System.arraycopy(bArrC, 0, bArr3, 1, bArrC.length);
        this.f47589c = g.c(this.f47587a, bArr3, this.f47593g);
        this.f47590d = 1L;
    }

    @Override // qp.f
    public void a(byte[] bArr) {
        byte[] bArrC = g.c(this.f47587a, org.bouncycastle.util.a.D(f47583h, this.f47588b, f(), bArr), this.f47593g);
        this.f47588b = bArrC;
        byte[] bArr2 = new byte[bArrC.length + 1];
        bArr2[0] = 0;
        System.arraycopy(bArrC, 0, bArr2, 1, bArrC.length);
        this.f47589c = g.c(this.f47587a, bArr2, this.f47593g);
        this.f47590d = 1L;
    }

    @Override // qp.f
    public int b(byte[] bArr, byte[] bArr2, boolean z10) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this.f47590d > 140737488355328L) {
            return -1;
        }
        if (z10) {
            a(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            byte[] bArr3 = this.f47588b;
            byte[] bArr4 = new byte[bArr3.length + 1 + bArr2.length];
            bArr4[0] = 2;
            System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
            System.arraycopy(bArr2, 0, bArr4, this.f47588b.length + 1, bArr2.length);
            d(this.f47588b, g(bArr4));
        }
        byte[] bArrH = h(this.f47588b, length);
        byte[] bArr5 = this.f47588b;
        byte[] bArr6 = new byte[bArr5.length + 1];
        System.arraycopy(bArr5, 0, bArr6, 1, bArr5.length);
        bArr6[0] = 3;
        d(this.f47588b, g(bArr6));
        d(this.f47588b, this.f47589c);
        d(this.f47588b, new byte[]{(byte) (r6 >> 24), (byte) (r6 >> 16), (byte) (r6 >> 8), (byte) this.f47590d});
        this.f47590d++;
        System.arraycopy(bArrH, 0, bArr, 0, bArr.length);
        return length;
    }

    @Override // qp.f
    public int c() {
        return this.f47587a.h() * 8;
    }

    public final void d(byte[] bArr, byte[] bArr2) {
        int i10 = 0;
        for (int i11 = 1; i11 <= bArr2.length; i11++) {
            int i12 = (bArr[bArr.length - i11] & 255) + (bArr2[bArr2.length - i11] & 255) + i10;
            i10 = i12 > 255 ? 1 : 0;
            bArr[bArr.length - i11] = (byte) i12;
        }
        for (int length = bArr2.length + 1; length <= bArr.length; length++) {
            int i13 = (bArr[bArr.length - length] & 255) + i10;
            i10 = i13 > 255 ? 1 : 0;
            bArr[bArr.length - length] = (byte) i13;
        }
    }

    public final void e(byte[] bArr, byte[] bArr2) {
        this.f47587a.update(bArr, 0, bArr.length);
        this.f47587a.c(bArr2, 0);
    }

    public final byte[] f() {
        byte[] bArrA = this.f47591e.a();
        if (bArrA.length >= (this.f47592f + 7) / 8) {
            return bArrA;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[this.f47587a.h()];
        e(bArr, bArr2);
        return bArr2;
    }

    public final byte[] h(byte[] bArr, int i10) {
        int i11 = i10 / 8;
        int iH = i11 / this.f47587a.h();
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = new byte[i11];
        int iH2 = this.f47587a.h();
        byte[] bArr4 = new byte[iH2];
        for (int i12 = 0; i12 <= iH; i12++) {
            e(bArr2, bArr4);
            int i13 = i12 * iH2;
            int i14 = i11 - i13;
            if (i14 > iH2) {
                i14 = iH2;
            }
            System.arraycopy(bArr4, 0, bArr3, i13, i14);
            d(bArr2, f47583h);
        }
        return bArr3;
    }
}
