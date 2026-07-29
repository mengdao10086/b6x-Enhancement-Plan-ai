package bf;

import com.google.zxing.NotFoundException;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f9416h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9417i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f9418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9424g;

    public c(af.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.m() / 2, bVar.i() / 2);
    }

    public final l[] a(l lVar, l lVar2, l lVar3, l lVar4) {
        float fC = lVar.c();
        float fD = lVar.d();
        float fC2 = lVar2.c();
        float fD2 = lVar2.d();
        float fC3 = lVar3.c();
        float fD3 = lVar3.d();
        float fC4 = lVar4.c();
        float fD4 = lVar4.d();
        return fC < ((float) this.f9420c) / 2.0f ? new l[]{new l(fC4 - 1.0f, fD4 + 1.0f), new l(fC2 + 1.0f, fD2 + 1.0f), new l(fC3 - 1.0f, fD3 - 1.0f), new l(fC + 1.0f, fD - 1.0f)} : new l[]{new l(fC4 + 1.0f, fD4 + 1.0f), new l(fC2 + 1.0f, fD2 - 1.0f), new l(fC3 - 1.0f, fD3 + 1.0f), new l(fC - 1.0f, fD - 1.0f)};
    }

    public final boolean b(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f9418a.f(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f9418a.f(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public l[] c() throws NotFoundException {
        int i10 = this.f9421d;
        int i11 = this.f9422e;
        int i12 = this.f9424g;
        int i13 = this.f9423f;
        boolean z10 = false;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (z11) {
            boolean zB = true;
            boolean z16 = false;
            while (true) {
                if ((!zB && z12) || i11 >= this.f9420c) {
                    break;
                }
                zB = b(i12, i13, i11, false);
                if (zB) {
                    i11++;
                    z12 = true;
                    z16 = true;
                } else if (!z12) {
                    i11++;
                }
            }
            if (i11 < this.f9420c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z13) || i13 >= this.f9419b) {
                        break;
                    }
                    zB2 = b(i10, i11, i13, true);
                    if (zB2) {
                        i13++;
                        z13 = true;
                        z16 = true;
                    } else if (!z13) {
                        i13++;
                    }
                }
                if (i13 < this.f9419b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z14) || i10 < 0) {
                            break;
                        }
                        zB3 = b(i12, i13, i10, false);
                        if (zB3) {
                            i10--;
                            z14 = true;
                            z16 = true;
                        } else if (!z14) {
                            i10--;
                        }
                    }
                    if (i10 >= 0) {
                        z11 = z16;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z15) || i12 < 0) {
                                break;
                            }
                            zB4 = b(i10, i11, i12, true);
                            if (zB4) {
                                i12--;
                                z11 = true;
                                z15 = true;
                            } else if (!z15) {
                                i12--;
                            }
                        }
                        if (i12 < 0) {
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (z10) {
            throw NotFoundException.b();
        }
        int i14 = i11 - i10;
        l lVarD = null;
        l lVarD2 = null;
        for (int i15 = 1; lVarD2 == null && i15 < i14; i15++) {
            lVarD2 = d(i10, i13 - i15, i10 + i15, i13);
        }
        if (lVarD2 == null) {
            throw NotFoundException.b();
        }
        l lVarD3 = null;
        for (int i16 = 1; lVarD3 == null && i16 < i14; i16++) {
            lVarD3 = d(i10, i12 + i16, i10 + i16, i12);
        }
        if (lVarD3 == null) {
            throw NotFoundException.b();
        }
        l lVarD4 = null;
        for (int i17 = 1; lVarD4 == null && i17 < i14; i17++) {
            lVarD4 = d(i11, i12 + i17, i11 - i17, i12);
        }
        if (lVarD4 == null) {
            throw NotFoundException.b();
        }
        for (int i18 = 1; lVarD == null && i18 < i14; i18++) {
            lVarD = d(i11, i13 - i18, i11 - i18, i13);
        }
        if (lVarD != null) {
            return a(lVarD, lVarD2, lVarD4, lVarD3);
        }
        throw NotFoundException.b();
    }

    public final l d(float f10, float f11, float f12, float f13) {
        int iC = a.c(a.a(f10, f11, f12, f13));
        float f14 = iC;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < iC; i10++) {
            float f17 = i10;
            int iC2 = a.c((f17 * f15) + f10);
            int iC3 = a.c((f17 * f16) + f11);
            if (this.f9418a.f(iC2, iC3)) {
                return new l(iC2, iC3);
            }
        }
        return null;
    }

    public c(af.b bVar, int i10, int i11, int i12) throws NotFoundException {
        this.f9418a = bVar;
        int i13 = bVar.i();
        this.f9419b = i13;
        int iM = bVar.m();
        this.f9420c = iM;
        int i14 = i10 / 2;
        int i15 = i11 - i14;
        this.f9421d = i15;
        int i16 = i11 + i14;
        this.f9422e = i16;
        int i17 = i12 - i14;
        this.f9424g = i17;
        int i18 = i12 + i14;
        this.f9423f = i18;
        if (i17 < 0 || i15 < 0 || i18 >= i13 || i16 >= iM) {
            throw NotFoundException.b();
        }
    }
}
