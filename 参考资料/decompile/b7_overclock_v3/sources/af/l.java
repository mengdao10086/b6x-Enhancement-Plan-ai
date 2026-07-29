package af;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f616i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f617j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f618k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f619l = 40;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f620m = 24;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f621h;

    public l(ve.e eVar) {
        super(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[PHI: r5
  0x009e: PHI (r5v3 int) = (r5v2 int), (r5v6 int), (r5v6 int) binds: [B:31:0x007b, B:33:0x007f, B:34:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[][] i(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = 8
            int r3 = r21 + (-8)
            int r4 = r20 + (-8)
            r5 = 2
            int[] r6 = new int[r5]
            r7 = 1
            r6[r7] = r0
            r8 = 0
            r6[r8] = r1
            java.lang.Class<int> r9 = int.class
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r9, r6)
            int[][] r6 = (int[][]) r6
            r9 = 0
        L1c:
            if (r9 >= r1) goto Lb7
            int r10 = r9 << 3
            if (r10 <= r3) goto L23
            r10 = r3
        L23:
            r11 = 0
        L24:
            if (r11 >= r0) goto Lac
            int r12 = r11 << 3
            if (r12 <= r4) goto L2b
            r12 = r4
        L2b:
            int r13 = r10 * r20
            int r13 = r13 + r12
            r12 = 255(0xff, float:3.57E-43)
            r8 = 255(0xff, float:3.57E-43)
            r14 = 0
            r15 = 0
            r16 = 0
        L36:
            if (r14 >= r2) goto L74
            r7 = r16
            r5 = 0
        L3b:
            if (r5 >= r2) goto L4e
            int r16 = r13 + r5
            r2 = r17[r16]
            r2 = r2 & r12
            int r15 = r15 + r2
            if (r2 >= r8) goto L46
            r8 = r2
        L46:
            if (r2 <= r7) goto L49
            r7 = r2
        L49:
            int r5 = r5 + 1
            r2 = 8
            goto L3b
        L4e:
            int r2 = r7 - r8
            r5 = 24
            if (r2 <= r5) goto L6a
        L54:
            int r14 = r14 + 1
            int r13 = r13 + r20
            r2 = 8
            if (r14 >= r2) goto L6a
            r5 = 0
        L5d:
            if (r5 >= r2) goto L54
            int r16 = r13 + r5
            r2 = r17[r16]
            r2 = r2 & r12
            int r15 = r15 + r2
            int r5 = r5 + 1
            r2 = 8
            goto L5d
        L6a:
            r2 = 1
            int r14 = r14 + r2
            int r13 = r13 + r20
            r16 = r7
            r2 = 8
            r7 = 1
            goto L36
        L74:
            r2 = 1
            int r5 = r15 >> 6
            int r7 = r16 - r8
            r12 = 24
            if (r7 > r12) goto L9e
            int r5 = r8 / 2
            if (r9 <= 0) goto L9e
            if (r11 <= 0) goto L9e
            int r7 = r9 + (-1)
            r12 = r6[r7]
            r12 = r12[r11]
            r13 = r6[r9]
            int r14 = r11 + (-1)
            r13 = r13[r14]
            r15 = 2
            int r13 = r13 * 2
            int r12 = r12 + r13
            r7 = r6[r7]
            r7 = r7[r14]
            int r12 = r12 + r7
            int r7 = r12 / 4
            if (r8 >= r7) goto L9f
            r5 = r7
            goto L9f
        L9e:
            r15 = 2
        L9f:
            r7 = r6[r9]
            r7[r11] = r5
            int r11 = r11 + 1
            r2 = 8
            r5 = 2
            r7 = 1
            r8 = 0
            goto L24
        Lac:
            r2 = 1
            r15 = 2
            int r9 = r9 + 1
            r2 = 8
            r5 = 2
            r7 = 1
            r8 = 0
            goto L1c
        Lb7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: af.l.i(byte[], int, int, int, int):int[][]");
    }

    public static void j(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, b bVar) {
        int i14 = i13 - 8;
        int i15 = i12 - 8;
        for (int i16 = 0; i16 < i11; i16++) {
            int i17 = i16 << 3;
            int i18 = i17 > i14 ? i14 : i17;
            int iK = k(i16, i11 - 3);
            for (int i19 = 0; i19 < i10; i19++) {
                int i20 = i19 << 3;
                int i21 = i20 > i15 ? i15 : i20;
                int iK2 = k(i19, i10 - 3);
                int i22 = 0;
                for (int i23 = -2; i23 <= 2; i23++) {
                    int[] iArr2 = iArr[iK + i23];
                    i22 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i21, i18, i22 / 25, i12, bVar);
            }
        }
    }

    public static int k(int i10, int i11) {
        if (i10 < 2) {
            return 2;
        }
        return Math.min(i10, i11);
    }

    public static void l(byte[] bArr, int i10, int i11, int i12, int i13, b bVar) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bVar.s(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // af.j, ve.a
    public ve.a a(ve.e eVar) {
        return new l(eVar);
    }

    @Override // af.j, ve.a
    public b b() throws NotFoundException {
        b bVar = this.f621h;
        if (bVar != null) {
            return bVar;
        }
        ve.e eVarE = e();
        int iE = eVarE.e();
        int iB = eVarE.b();
        if (iE < 40 || iB < 40) {
            this.f621h = super.b();
        } else {
            byte[] bArrC = eVarE.c();
            int i10 = iE >> 3;
            if ((iE & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = iB >> 3;
            if ((iB & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] iArrI = i(bArrC, i11, i13, iE, iB);
            b bVar2 = new b(iE, iB);
            j(bArrC, i11, i13, iE, iB, iArrI, bVar2);
            this.f621h = bVar2;
        }
        return this.f621h;
    }
}
