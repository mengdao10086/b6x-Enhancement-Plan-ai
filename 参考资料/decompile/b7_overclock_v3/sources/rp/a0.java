package rp;

import java.math.BigInteger;
import np.e2;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class a0 implements e0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48970m = 188;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48971n = 12748;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48972o = 13004;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f48973p = 13260;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f48974q = 13516;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f48975r = 13772;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f48976s = 14028;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f48977t = 14284;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f48978u = 14540;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f48979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.b f48980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e2 f48981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f48982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f48983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f48984l;

    public a0(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar) {
        this(bVar, sVar, false);
    }

    public a0(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, boolean z10) {
        int iIntValue;
        this.f48980h = bVar;
        this.f48979g = sVar;
        if (z10) {
            iIntValue = 188;
        } else {
            Integer numA = t.a(sVar);
            if (numA == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + sVar.b());
            }
            iIntValue = numA.intValue();
        }
        this.f48982j = iIntValue;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        e2 e2Var = (e2) kVar;
        this.f48981i = e2Var;
        this.f48980h.a(z10, e2Var);
        int iBitLength = this.f48981i.e().bitLength();
        this.f48983k = iBitLength;
        this.f48984l = new byte[(iBitLength + 7) / 8];
        reset();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[PHI: r4
  0x002f: PHI (r4v3 java.math.BigInteger) = (r4v2 java.math.BigInteger), (r4v5 java.math.BigInteger) binds: [B:5:0x001a, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.crypto.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            org.bouncycastle.crypto.b r1 = r3.f48980h     // Catch: java.lang.Exception -> L5e
            int r2 = r4.length     // Catch: java.lang.Exception -> L5e
            byte[] r4 = r1.c(r4, r0, r2)     // Catch: java.lang.Exception -> L5e
            r3.f48984l = r4     // Catch: java.lang.Exception -> L5e
            java.math.BigInteger r4 = new java.math.BigInteger
            r1 = 1
            byte[] r2 = r3.f48984l
            r4.<init>(r1, r2)
            int r1 = r4.intValue()
            r1 = r1 & 15
            r2 = 12
            if (r1 != r2) goto L1d
            goto L2f
        L1d:
            np.e2 r1 = r3.f48981i
            java.math.BigInteger r1 = r1.e()
            java.math.BigInteger r4 = r1.subtract(r4)
            int r1 = r4.intValue()
            r1 = r1 & 15
            if (r1 != r2) goto L5e
        L2f:
            int r0 = r3.f48982j
            r3.h(r0)
            byte[] r0 = r3.f48984l
            int r0 = r0.length
            byte[] r4 = org.bouncycastle.util.b.b(r0, r4)
            byte[] r0 = r3.f48984l
            boolean r0 = org.bouncycastle.util.a.I(r0, r4)
            int r1 = r3.f48982j
            r2 = 15052(0x3acc, float:2.1092E-41)
            if (r1 != r2) goto L56
            if (r0 != 0) goto L56
            byte[] r0 = r3.f48984l
            int r1 = r0.length
            int r1 = r1 + (-2)
            r2 = 64
            r0[r1] = r2
            boolean r0 = org.bouncycastle.util.a.I(r0, r4)
        L56:
            byte[] r1 = r3.f48984l
            r3.g(r1)
            r3.g(r4)
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rp.a0.d(byte[]):boolean");
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws CryptoException {
        h(this.f48982j);
        org.bouncycastle.crypto.b bVar = this.f48980h;
        byte[] bArr = this.f48984l;
        BigInteger bigInteger = new BigInteger(1, bVar.c(bArr, 0, bArr.length));
        g(this.f48984l);
        return org.bouncycastle.util.b.b(org.bouncycastle.util.b.k(this.f48981i.e()), bigInteger.min(this.f48981i.e().subtract(bigInteger)));
    }

    public final void g(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    public final void h(int i10) {
        int length;
        int iH = this.f48979g.h();
        if (i10 == 188) {
            byte[] bArr = this.f48984l;
            length = (bArr.length - iH) - 1;
            this.f48979g.c(bArr, length);
            this.f48984l[r5.length - 1] = u.f49086t;
        } else {
            byte[] bArr2 = this.f48984l;
            int length2 = (bArr2.length - iH) - 2;
            this.f48979g.c(bArr2, length2);
            byte[] bArr3 = this.f48984l;
            bArr3[bArr3.length - 2] = (byte) (i10 >>> 8);
            bArr3[bArr3.length - 1] = (byte) i10;
            length = length2;
        }
        this.f48984l[0] = 107;
        for (int i11 = length - 2; i11 != 0; i11--) {
            this.f48984l[i11] = -69;
        }
        this.f48984l[length - 1] = -70;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f48979g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f48979g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f48979g.update(bArr, i10, i11);
    }
}
