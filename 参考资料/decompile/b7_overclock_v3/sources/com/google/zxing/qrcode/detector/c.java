package com.google.zxing.qrcode.detector;

import af.f;
import af.k;
import af.n;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.g;
import java.util.Map;
import ve.l;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f21637b;

    public c(af.b bVar) {
        this.f21636a = bVar;
    }

    public static int c(l lVar, l lVar2, l lVar3, float f10) throws NotFoundException {
        int iC = ((bf.a.c(l.b(lVar, lVar2) / f10) + bf.a.c(l.b(lVar, lVar3) / f10)) / 2) + 7;
        int i10 = iC & 3;
        if (i10 == 0) {
            return iC + 1;
        }
        if (i10 == 2) {
            return iC - 1;
        }
        if (i10 != 3) {
            return iC;
        }
        throw NotFoundException.b();
    }

    public static n d(l lVar, l lVar2, l lVar3, l lVar4, int i10) {
        float fC;
        float fD;
        float f10;
        float f11 = i10 - 3.5f;
        if (lVar4 != null) {
            fC = lVar4.c();
            fD = lVar4.d();
            f10 = f11 - 3.0f;
        } else {
            fC = (lVar2.c() - lVar.c()) + lVar3.c();
            fD = (lVar2.d() - lVar.d()) + lVar3.d();
            f10 = f11;
        }
        return n.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), fC, fD, lVar3.c(), lVar3.d());
    }

    public static af.b k(af.b bVar, n nVar, int i10) throws NotFoundException {
        return k.b().d(bVar, i10, i10, nVar);
    }

    public final float a(l lVar, l lVar2, l lVar3) {
        return (b(lVar, lVar2) + b(lVar, lVar3)) / 2.0f;
    }

    public final float b(l lVar, l lVar2) {
        float fM = m((int) lVar.c(), (int) lVar.d(), (int) lVar2.c(), (int) lVar2.d());
        float fM2 = m((int) lVar2.c(), (int) lVar2.d(), (int) lVar.c(), (int) lVar.d());
        return Float.isNaN(fM) ? fM2 / 7.0f : Float.isNaN(fM2) ? fM / 7.0f : (fM + fM2) / 14.0f;
    }

    public f e() throws NotFoundException, FormatException {
        return f(null);
    }

    public final f f(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f21637b = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return j(new FinderPatternFinder(this.f21636a, this.f21637b).h(map));
    }

    public final a g(float f10, int i10, int i11, float f11) throws NotFoundException {
        int i12 = (int) (f11 * f10);
        int iMax = Math.max(0, i10 - i12);
        int iMin = Math.min(this.f21636a.m() - 1, i10 + i12) - iMax;
        float f12 = 3.0f * f10;
        if (iMin < f12) {
            throw NotFoundException.b();
        }
        int iMax2 = Math.max(0, i11 - i12);
        int iMin2 = Math.min(this.f21636a.i() - 1, i11 + i12) - iMax2;
        if (iMin2 >= f12) {
            return new b(this.f21636a, iMax, iMax2, iMin, iMin2, f10, this.f21637b).c();
        }
        throw NotFoundException.b();
    }

    public final af.b h() {
        return this.f21636a;
    }

    public final m i() {
        return this.f21637b;
    }

    public final f j(e eVar) throws NotFoundException, FormatException {
        d dVarB = eVar.b();
        d dVarC = eVar.c();
        d dVarA = eVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw NotFoundException.b();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        g gVarG = g.g(iC);
        int iE = gVarG.e() - 7;
        a aVarG = null;
        if (gVarG.d().length > 0) {
            float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
            float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
            float f10 = 1.0f - (3.0f / iE);
            int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f10));
            int iD = (int) (dVarB.d() + (f10 * (fD - dVarB.d())));
            for (int i10 = 4; i10 <= 16; i10 <<= 1) {
                try {
                    aVarG = g(fA, iC2, iD, i10);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        return new f(k(this.f21636a, d(dVarB, dVarC, dVarA, aVarG, iC), iC), aVarG == null ? new l[]{dVarA, dVarB, dVarC} : new l[]{dVarA, dVarB, dVarC, aVarG});
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        if (r15 != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return bf.a.b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float l(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r4 >= r6) goto L3d
            r11 = 1
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L80
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 1
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            af.b r5 = r3.f21636a
            boolean r2 = r5.f(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = bf.a.b(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L78
            if (r14 != r6) goto L76
            goto L84
        L76:
            int r14 = r14 + r11
            int r9 = r9 - r7
        L78:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L80:
            r3 = r17
            r19 = r5
        L84:
            r0 = 2
            if (r15 != r0) goto L8e
            r5 = r19
            float r0 = bf.a.b(r5, r6, r1, r4)
            return r0
        L8e:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.c.l(int, int, int, int):float");
    }

    public final float m(int i10, int i11, int i12, int i13) {
        float fM;
        float fI;
        float fL = l(i10, i11, i12, i13);
        int iM = i10 - (i12 - i10);
        int i14 = 0;
        if (iM < 0) {
            fM = i10 / (i10 - iM);
            iM = 0;
        } else if (iM >= this.f21636a.m()) {
            fM = ((this.f21636a.m() - 1) - i10) / (iM - i10);
            iM = this.f21636a.m() - 1;
        } else {
            fM = 1.0f;
        }
        float f10 = i11;
        int i15 = (int) (f10 - ((i13 - i11) * fM));
        if (i15 < 0) {
            fI = f10 / (i11 - i15);
        } else if (i15 >= this.f21636a.i()) {
            fI = ((this.f21636a.i() - 1) - i11) / (i15 - i11);
            i14 = this.f21636a.i() - 1;
        } else {
            i14 = i15;
            fI = 1.0f;
        }
        return (fL + l(i10, i11, (int) (i10 + ((iM - i10) * fI)), i14)) - 1.0f;
    }
}
