package af;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public class j extends ve.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f609d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f610e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f611f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f612g = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f614c;

    public j(ve.e eVar) {
        super(eVar);
        this.f613b = f612g;
        this.f614c = new int[32];
    }

    public static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (iArr[i13] > i10) {
                i10 = iArr[i13];
                i12 = i13;
            }
            if (iArr[i13] > i11) {
                i11 = iArr[i13];
            }
        }
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 - i12;
            int i18 = iArr[i16] * i17 * i17;
            if (i18 > i15) {
                i14 = i16;
                i15 = i18;
            }
        }
        if (i12 <= i14) {
            int i19 = i12;
            i12 = i14;
            i14 = i19;
        }
        if (i12 - i14 <= length / 16) {
            throw NotFoundException.b();
        }
        int i20 = i12 - 1;
        int i21 = i20;
        int i22 = -1;
        while (i20 > i14) {
            int i23 = i20 - i14;
            int i24 = i23 * i23 * (i12 - i20) * (i11 - iArr[i20]);
            if (i24 > i22) {
                i21 = i20;
                i22 = i24;
            }
            i20--;
        }
        return i21 << 3;
    }

    @Override // ve.a
    public ve.a a(ve.e eVar) {
        return new j(eVar);
    }

    @Override // ve.a
    public b b() throws NotFoundException {
        ve.e eVarE = e();
        int iE = eVarE.e();
        int iB = eVarE.b();
        b bVar = new b(iE, iB);
        h(iE);
        int[] iArr = this.f614c;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] bArrD = eVarE.d((iB * i10) / 5, this.f613b);
            int i11 = (iE * 4) / 5;
            for (int i12 = iE / 5; i12 < i11; i12++) {
                int i13 = (bArrD[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrC = eVarE.c();
        for (int i14 = 0; i14 < iB; i14++) {
            int i15 = i14 * iE;
            for (int i16 = 0; i16 < iE; i16++) {
                if ((bArrC[i15 + i16] & 255) < iG) {
                    bVar.s(i16, i14);
                }
            }
        }
        return bVar;
    }

    @Override // ve.a
    public a c(int i10, a aVar) throws NotFoundException {
        ve.e eVarE = e();
        int iE = eVarE.e();
        if (aVar == null || aVar.l() < iE) {
            aVar = new a(iE);
        } else {
            aVar.d();
        }
        h(iE);
        byte[] bArrD = eVarE.d(i10, this.f613b);
        int[] iArr = this.f614c;
        for (int i11 = 0; i11 < iE; i11++) {
            int i12 = (bArrD[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int iG = g(iArr);
        if (iE < 3) {
            for (int i13 = 0; i13 < iE; i13++) {
                if ((bArrD[i13] & 255) < iG) {
                    aVar.q(i13);
                }
            }
        } else {
            int i14 = 1;
            int i15 = bArrD[0] & 255;
            int i16 = bArrD[1] & 255;
            while (i14 < iE - 1) {
                int i17 = i14 + 1;
                int i18 = bArrD[i17] & 255;
                if ((((i16 * 4) - i15) - i18) / 2 < iG) {
                    aVar.q(i14);
                }
                i15 = i16;
                i14 = i17;
                i16 = i18;
            }
        }
        return aVar;
    }

    public final void h(int i10) {
        if (this.f613b.length < i10) {
            this.f613b = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f614c[i11] = 0;
        }
    }
}
