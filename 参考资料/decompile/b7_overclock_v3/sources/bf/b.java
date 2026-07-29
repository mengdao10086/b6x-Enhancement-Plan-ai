package bf;

import com.google.zxing.NotFoundException;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9414b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f9415a;

    public b(af.b bVar) {
        this.f9415a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0031 A[EDGE_INSN: B:69:0x0031->B:22:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:72:0x001c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0067 A[EDGE_INSN: B:85:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:38:0x0053->B:90:0x0053], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] a(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 < r8) goto L3a
            af.b r3 = r5.f9415a
            if (r10 == 0) goto L12
            boolean r3 = r3.f(r2, r6)
            if (r3 == 0) goto L1b
            goto L18
        L12:
            boolean r3 = r3.f(r6, r2)
            if (r3 == 0) goto L1b
        L18:
            int r2 = r2 + (-1)
            goto L5
        L1b:
            r3 = r2
        L1c:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L31
            af.b r4 = r5.f9415a
            if (r10 == 0) goto L2b
            boolean r4 = r4.f(r3, r6)
            if (r4 == 0) goto L1c
            goto L31
        L2b:
            boolean r4 = r4.f(r6, r3)
            if (r4 == 0) goto L1c
        L31:
            int r4 = r2 - r3
            if (r3 < r8) goto L3a
            if (r4 <= r7) goto L38
            goto L3a
        L38:
            r2 = r3
            goto L5
        L3a:
            r8 = 1
            int r2 = r2 + r8
        L3c:
            if (r0 >= r9) goto L70
            af.b r3 = r5.f9415a
            if (r10 == 0) goto L49
            boolean r3 = r3.f(r0, r6)
            if (r3 == 0) goto L52
            goto L4f
        L49:
            boolean r3 = r3.f(r6, r0)
            if (r3 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r3 = r0
        L53:
            int r3 = r3 + r8
            if (r3 >= r9) goto L67
            af.b r4 = r5.f9415a
            if (r10 == 0) goto L61
            boolean r4 = r4.f(r3, r6)
            if (r4 == 0) goto L53
            goto L67
        L61:
            boolean r4 = r4.f(r6, r3)
            if (r4 == 0) goto L53
        L67:
            int r4 = r3 - r0
            if (r3 >= r9) goto L70
            if (r4 <= r7) goto L6e
            goto L70
        L6e:
            r0 = r3
            goto L3c
        L70:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L7c
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            goto L7d
        L7c:
            r6 = 0
        L7d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.b.a(int, int, int, int, boolean):int[]");
    }

    public l[] b() throws NotFoundException {
        int i10 = this.f9415a.i();
        int iM = this.f9415a.m();
        int i11 = i10 / 2;
        int i12 = iM / 2;
        int iMax = Math.max(1, i10 / 256);
        int iMax2 = Math.max(1, iM / 256);
        int i13 = -iMax;
        int i14 = i12 / 2;
        int iD = ((int) c(i12, 0, 0, iM, i11, i13, 0, i10, i14).d()) - 1;
        int i15 = i11 / 2;
        l lVarC = c(i12, -iMax2, 0, iM, i11, 0, iD, i10, i15);
        int iC = ((int) lVarC.c()) - 1;
        l lVarC2 = c(i12, iMax2, iC, iM, i11, 0, iD, i10, i15);
        int iC2 = ((int) lVarC2.c()) + 1;
        l lVarC3 = c(i12, 0, iC, iC2, i11, iMax, iD, i10, i14);
        return new l[]{c(i12, 0, iC, iC2, i11, i13, iD, ((int) lVarC3.d()) + 1, i12 / 4), lVarC, lVarC2, lVarC3};
    }

    public final l c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) throws NotFoundException {
        int[] iArr = null;
        int i19 = i10;
        int i20 = i14;
        while (i20 < i17 && i20 >= i16 && i19 < i13 && i19 >= i12) {
            int[] iArrA = i11 == 0 ? a(i20, i18, i12, i13, true) : a(i19, i18, i16, i17, false);
            if (iArrA == null) {
                if (iArr == null) {
                    throw NotFoundException.b();
                }
                if (i11 == 0) {
                    int i21 = i20 - i15;
                    if (iArr[0] >= i10) {
                        return new l(iArr[1], i21);
                    }
                    if (iArr[1] > i10) {
                        return new l(iArr[i15 > 0 ? (char) 0 : (char) 1], i21);
                    }
                    return new l(iArr[0], i21);
                }
                int i22 = i19 - i11;
                if (iArr[0] >= i14) {
                    return new l(i22, iArr[1]);
                }
                if (iArr[1] > i14) {
                    return new l(i22, iArr[i11 < 0 ? (char) 0 : (char) 1]);
                }
                return new l(i22, iArr[0]);
            }
            i20 += i15;
            i19 += i11;
            iArr = iArrA;
        }
        throw NotFoundException.b();
    }
}
