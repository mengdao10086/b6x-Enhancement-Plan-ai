package qp;

import ir.e;
import ir.h;
import ir.i;
import java.math.BigInteger;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class c implements f {
    public static final int A = 4096;
    public static final int B = 4096;
    public static final int C = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final BigInteger f47549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final BigInteger f47550n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final BigInteger f47551o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final BigInteger f47552p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f47553q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f47554r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final BigInteger f47555s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final BigInteger f47556t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final BigInteger f47557u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final BigInteger f47558v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final BigInteger f47559w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final BigInteger f47560x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b[] f47561y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f47562z = 2147483648L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f47563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f47564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pp.d f47565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f47567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e.f f47569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f47570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f47571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f47572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f47573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public h f47574l;

    static {
        BigInteger bigInteger = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        f47549m = bigInteger;
        BigInteger bigInteger2 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        f47550n = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        f47551o = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        f47552p = bigInteger4;
        BigInteger bigInteger5 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        f47553q = bigInteger5;
        BigInteger bigInteger6 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        f47554r = bigInteger6;
        BigInteger bigInteger7 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        f47555s = bigInteger7;
        BigInteger bigInteger8 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        f47556t = bigInteger8;
        BigInteger bigInteger9 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        f47557u = bigInteger9;
        BigInteger bigInteger10 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        f47558v = bigInteger10;
        BigInteger bigInteger11 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        f47559w = bigInteger11;
        BigInteger bigInteger12 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        f47560x = bigInteger12;
        f47561y = new b[]{new b(128, fVar.h(bigInteger, bigInteger2), fVar.h(bigInteger3, bigInteger4), 1), new b(192, fVar.h(bigInteger5, bigInteger6), fVar.h(bigInteger7, bigInteger8), 1), new b(256, fVar.h(bigInteger9, bigInteger10), fVar.h(bigInteger11, bigInteger12), 1)};
        e.f fVar = (e.f) kn.c.b("P-256").y();
        e.f fVar2 = (e.f) kn.c.b("P-384").y();
        e.f fVar3 = (e.f) kn.c.b("P-521").y();
    }

    public c(s sVar, int i10, pp.d dVar, byte[] bArr, byte[] bArr2) {
        this(f47561y, sVar, i10, dVar, bArr, bArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        if (r2.f47570h == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        r3 = qp.g.c(r2.f47563a, r6, r2.f47567e);
        r2.f47572j = r3;
        r2.f47573k = r3.length;
        r2.f47564b = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
    
        throw new java.lang.IllegalArgumentException("security strength cannot be greater than 256 bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(qp.b[] r3, org.bouncycastle.crypto.s r4, int r5, pp.d r6, byte[] r7, byte[] r8) {
        /*
            r2 = this;
            r2.<init>()
            ir.k r0 = new ir.k
            r0.<init>()
            r2.f47574l = r0
            r2.f47563a = r4
            r2.f47565c = r6
            r2.f47566d = r5
            r0 = 512(0x200, float:7.17E-43)
            boolean r0 = qp.g.d(r7, r0)
            if (r0 != 0) goto Lb6
            int r0 = r6.c()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 < r5) goto L92
            int r6 = r6.c()
            if (r6 > r1) goto L92
            byte[] r6 = r2.d()
            byte[] r6 = org.bouncycastle.util.a.C(r6, r8, r7)
            r7 = 0
        L2f:
            int r8 = r3.length
            if (r7 == r8) goto L74
            r8 = r3[r7]
            int r8 = r8.e()
            if (r5 > r8) goto L71
            int r4 = qp.g.a(r4)
            r5 = r3[r7]
            int r5 = r5.e()
            if (r4 < r5) goto L69
            r4 = r3[r7]
            int r4 = r4.f()
            r2.f47567e = r4
            r4 = r3[r7]
            int r4 = r4.b()
            int r4 = r4 / 8
            r2.f47568f = r4
            r4 = r3[r7]
            ir.i r4 = r4.c()
            r2.f47570h = r4
            r3 = r3[r7]
            ir.i r3 = r3.d()
            r2.f47571i = r3
            goto L74
        L69:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Requested security strength is not supported by digest"
            r3.<init>(r4)
            throw r3
        L71:
            int r7 = r7 + 1
            goto L2f
        L74:
            ir.i r3 = r2.f47570h
            if (r3 == 0) goto L8a
            org.bouncycastle.crypto.s r3 = r2.f47563a
            int r4 = r2.f47567e
            byte[] r3 = qp.g.c(r3, r6, r4)
            r2.f47572j = r3
            int r3 = r3.length
            r2.f47573k = r3
            r3 = 0
            r2.f47564b = r3
            return
        L8a:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "security strength cannot be greater than 256 bits"
            r3.<init>(r4)
            throw r3
        L92:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "EntropySource must provide between "
            r4.append(r6)
            r4.append(r5)
            java.lang.String r5 = " and "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = " bits"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        Lb6:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Personalization string too large"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qp.c.<init>(qp.b[], org.bouncycastle.crypto.s, int, pp.d, byte[], byte[]):void");
    }

    @Override // qp.f
    public void a(byte[] bArr) {
        if (g.d(bArr, 512)) {
            throw new IllegalArgumentException("Additional input string too large");
        }
        this.f47572j = g.c(this.f47563a, org.bouncycastle.util.a.C(f(this.f47572j, this.f47567e), d(), bArr), this.f47567e);
        this.f47564b = 0L;
    }

    @Override // qp.f
    public int b(byte[] bArr, byte[] bArr2, boolean z10) {
        int length = bArr.length * 8;
        int length2 = bArr.length / this.f47568f;
        if (g.d(bArr2, 512)) {
            throw new IllegalArgumentException("Additional input too large");
        }
        if (this.f47564b + ((long) length2) > 2147483648L) {
            return -1;
        }
        if (z10) {
            a(bArr2);
            bArr2 = null;
        }
        BigInteger bigInteger = bArr2 != null ? new BigInteger(1, g(this.f47572j, g.c(this.f47563a, bArr2, this.f47567e))) : new BigInteger(1, this.f47572j);
        int length3 = 0;
        org.bouncycastle.util.a.d0(bArr, (byte) 0);
        int length4 = 0;
        for (int i10 = 0; i10 < length2; i10++) {
            bigInteger = e(this.f47570h, bigInteger);
            byte[] byteArray = e(this.f47571i, bigInteger).toByteArray();
            int length5 = byteArray.length;
            int i11 = this.f47568f;
            if (length5 > i11) {
                System.arraycopy(byteArray, byteArray.length - i11, bArr, length4, i11);
            } else {
                System.arraycopy(byteArray, 0, bArr, (i11 - byteArray.length) + length4, byteArray.length);
            }
            length4 += this.f47568f;
            this.f47564b++;
        }
        if (length4 < bArr.length) {
            bigInteger = e(this.f47570h, bigInteger);
            byte[] byteArray2 = e(this.f47571i, bigInteger).toByteArray();
            int length6 = bArr.length - length4;
            int length7 = byteArray2.length;
            int i12 = this.f47568f;
            if (length7 > i12) {
                length3 = byteArray2.length - i12;
            } else {
                length4 += i12 - byteArray2.length;
            }
            System.arraycopy(byteArray2, length3, bArr, length4, length6);
            this.f47564b++;
        }
        this.f47572j = org.bouncycastle.util.b.b(this.f47573k, e(this.f47570h, bigInteger));
        return length;
    }

    @Override // qp.f
    public int c() {
        return this.f47568f * 8;
    }

    public final byte[] d() {
        byte[] bArrA = this.f47565c.a();
        if (bArrA.length >= (this.f47566d + 7) / 8) {
            return bArrA;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final BigInteger e(i iVar, BigInteger bigInteger) {
        return this.f47574l.a(iVar, bigInteger).B().f().v();
    }

    public final byte[] f(byte[] bArr, int i10) {
        int i11 = i10 % 8;
        if (i11 == 0) {
            return bArr;
        }
        int i12 = 8 - i11;
        int i13 = 0;
        int length = bArr.length - 1;
        while (length >= 0) {
            int i14 = bArr[length] & 255;
            bArr[length] = (byte) ((i13 >> (8 - i12)) | (i14 << i12));
            length--;
            i13 = i14;
        }
        return bArr;
    }

    public final byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }
}
