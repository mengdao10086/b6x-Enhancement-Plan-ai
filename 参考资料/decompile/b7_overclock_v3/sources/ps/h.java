package ps;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes6.dex */
public class h implements js.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f47049f = 65536;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f47050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[] f47052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qs.a f47053d = new qs.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f47054e;

    @Override // js.f
    public void a(boolean z10, k kVar) {
        d dVar;
        if (!z10) {
            dVar = (g) kVar;
        } else {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f47050a = w1Var.b();
                this.f47054e = (f) w1Var.a();
                this.f47051b = this.f47054e.d();
            }
            this.f47050a = n.f();
            dVar = (f) kVar;
        }
        this.f47054e = dVar;
        this.f47051b = this.f47054e.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3 A[EDGE_INSN: B:35:0x00b3->B:28:0x00b3 BREAK  A[LOOP:0: B:32:0x0026->B:37:?], SYNTHETIC] */
    @Override // js.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] b(byte[] r15) {
        /*
            r14 = this;
            ps.d r0 = r14.f47054e
            ps.f r0 = (ps.f) r0
            ps.a[] r0 = r0.i()
            int r1 = r0.length
            ps.d r2 = r14.f47054e
            ps.f r2 = (ps.f) r2
            short[][] r2 = r2.h()
            int r2 = r2.length
            short[] r2 = new short[r2]
            r14.f47052c = r2
            int r2 = r1 + (-1)
            r2 = r0[r2]
            int r2 = r2.g()
            byte[] r3 = new byte[r2]
            short[] r15 = r14.f(r15)
            r4 = 0
            r5 = 0
        L26:
            short[] r6 = r14.e(r0, r15)     // Catch: java.lang.Exception -> Laa
            r7 = 0
            r8 = 0
        L2c:
            if (r7 >= r1) goto L7f
            r9 = r0[r7]     // Catch: java.lang.Exception -> Laa
            int r9 = r9.e()     // Catch: java.lang.Exception -> Laa
            short[] r9 = new short[r9]     // Catch: java.lang.Exception -> Laa
            r10 = r0[r7]     // Catch: java.lang.Exception -> Laa
            int r10 = r10.e()     // Catch: java.lang.Exception -> Laa
            short[] r10 = new short[r10]     // Catch: java.lang.Exception -> Laa
            r10 = 0
        L3f:
            r11 = r0[r7]     // Catch: java.lang.Exception -> Laa
            int r11 = r11.e()     // Catch: java.lang.Exception -> Laa
            if (r10 >= r11) goto L50
            short r11 = r6[r8]     // Catch: java.lang.Exception -> Laa
            r9[r10] = r11     // Catch: java.lang.Exception -> Laa
            int r8 = r8 + 1
            int r10 = r10 + 1
            goto L3f
        L50:
            qs.a r10 = r14.f47053d     // Catch: java.lang.Exception -> Laa
            r11 = r0[r7]     // Catch: java.lang.Exception -> Laa
            short[] r12 = r14.f47052c     // Catch: java.lang.Exception -> Laa
            short[][] r11 = r11.h(r12)     // Catch: java.lang.Exception -> Laa
            short[] r9 = r10.k(r11, r9)     // Catch: java.lang.Exception -> Laa
            if (r9 == 0) goto L77
            r10 = 0
        L61:
            int r11 = r9.length     // Catch: java.lang.Exception -> Laa
            if (r10 >= r11) goto L74
            short[] r11 = r14.f47052c     // Catch: java.lang.Exception -> Laa
            r12 = r0[r7]     // Catch: java.lang.Exception -> Laa
            int r12 = r12.f()     // Catch: java.lang.Exception -> Laa
            int r12 = r12 + r10
            short r13 = r9[r10]     // Catch: java.lang.Exception -> Laa
            r11[r12] = r13     // Catch: java.lang.Exception -> Laa
            int r10 = r10 + 1
            goto L61
        L74:
            int r7 = r7 + 1
            goto L2c
        L77:
            java.lang.Exception r6 = new java.lang.Exception     // Catch: java.lang.Exception -> Laa
            java.lang.String r7 = "LES is not solveable!"
            r6.<init>(r7)     // Catch: java.lang.Exception -> Laa
            throw r6     // Catch: java.lang.Exception -> Laa
        L7f:
            qs.a r6 = r14.f47053d     // Catch: java.lang.Exception -> Laa
            ps.d r7 = r14.f47054e     // Catch: java.lang.Exception -> Laa
            ps.f r7 = (ps.f) r7     // Catch: java.lang.Exception -> Laa
            short[] r7 = r7.f()     // Catch: java.lang.Exception -> Laa
            short[] r8 = r14.f47052c     // Catch: java.lang.Exception -> Laa
            short[] r6 = r6.b(r7, r8)     // Catch: java.lang.Exception -> Laa
            qs.a r7 = r14.f47053d     // Catch: java.lang.Exception -> Laa
            ps.d r8 = r14.f47054e     // Catch: java.lang.Exception -> Laa
            ps.f r8 = (ps.f) r8     // Catch: java.lang.Exception -> Laa
            short[][] r8 = r8.h()     // Catch: java.lang.Exception -> Laa
            short[] r6 = r7.i(r8, r6)     // Catch: java.lang.Exception -> Laa
            r7 = 0
        L9e:
            if (r7 >= r2) goto La8
            short r8 = r6[r7]     // Catch: java.lang.Exception -> Laa
            byte r8 = (byte) r8     // Catch: java.lang.Exception -> Laa
            r3[r7] = r8     // Catch: java.lang.Exception -> Laa
            int r7 = r7 + 1
            goto L9e
        La8:
            r6 = 1
            goto Lab
        Laa:
            r6 = 0
        Lab:
            r7 = 65536(0x10000, float:9.1835E-41)
            if (r6 != 0) goto Lb3
            int r5 = r5 + 1
            if (r5 < r7) goto L26
        Lb3:
            if (r5 == r7) goto Lb6
            return r3
        Lb6:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unable to generate signature - LES not solvable"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ps.h.b(byte[]):byte[]");
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        short[] sArr = new short[bArr2.length];
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            sArr[i10] = (short) (bArr2[i10] & 255);
        }
        short[] sArrF = f(bArr);
        short[] sArrG = g(sArr);
        if (sArrF.length != sArrG.length) {
            return false;
        }
        boolean z10 = true;
        for (int i11 = 0; i11 < sArrF.length; i11++) {
            z10 = z10 && sArrF[i11] == sArrG[i11];
        }
        return z10;
    }

    public final short[] e(a[] aVarArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        short[] sArrI = this.f47053d.i(((f) this.f47054e).g(), this.f47053d.b(((f) this.f47054e).e(), sArr));
        for (int i10 = 0; i10 < aVarArr[0].f(); i10++) {
            this.f47052c[i10] = (short) this.f47050a.nextInt();
            short[] sArr3 = this.f47052c;
            sArr3[i10] = (short) (sArr3[i10] & 255);
        }
        return sArrI;
    }

    public final short[] f(byte[] bArr) {
        int i10 = this.f47051b;
        short[] sArr = new short[i10];
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            sArr[i11] = bArr[i12];
            sArr[i11] = (short) (sArr[i11] & 255);
            i12++;
            i11++;
            if (i11 >= i10) {
                break;
            }
        }
        return sArr;
    }

    public final short[] g(short[] sArr) {
        short[][] sArrE = ((g) this.f47054e).e();
        short[][] sArrG = ((g) this.f47054e).g();
        short[] sArrF = ((g) this.f47054e).f();
        short[] sArr2 = new short[sArrE.length];
        int length = sArrG[0].length;
        for (int i10 = 0; i10 < sArrE.length; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                for (int i13 = i12; i13 < length; i13++) {
                    sArr2[i10] = qs.b.a(sArr2[i10], qs.b.e(sArrE[i10][i11], qs.b.e(sArr[i12], sArr[i13])));
                    i11++;
                }
                sArr2[i10] = qs.b.a(sArr2[i10], qs.b.e(sArrG[i10][i12], sArr[i12]));
            }
            sArr2[i10] = qs.b.a(sArr2[i10], sArrF[i10]);
        }
        return sArr2;
    }
}
