package zo;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class x implements org.bouncycastle.crypto.m0, org.bouncycastle.crypto.s {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f59528k = Strings.i("ParallelHash");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f59529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f59530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f59533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f59534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f59535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f59536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f59537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59538j;

    public x(int i10, byte[] bArr, int i11) {
        this(i10, bArr, i11, i10 * 2);
    }

    public x(int i10, byte[] bArr, int i11, int i12) {
        this.f59529a = new e(i10, f59528k, bArr);
        this.f59530b = new e(i10, new byte[0], new byte[0]);
        this.f59531c = i10;
        this.f59533e = i11;
        this.f59532d = (i12 + 7) / 8;
        this.f59534f = new byte[i11];
        this.f59535g = new byte[(i10 * 2) / 8];
        reset();
    }

    public x(x xVar) {
        this.f59529a = new e(xVar.f59529a);
        this.f59530b = new e(xVar.f59530b);
        this.f59531c = xVar.f59531c;
        this.f59533e = xVar.f59533e;
        this.f59532d = xVar.f59532d;
        this.f59534f = org.bouncycastle.util.a.p(xVar.f59534f);
        this.f59535g = org.bouncycastle.util.a.p(xVar.f59535g);
    }

    public final void a() {
        d(this.f59534f, 0, this.f59538j);
        this.f59538j = 0;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "ParallelHash" + this.f59529a.b().substring(6);
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        if (this.f59536h) {
            i(this.f59532d);
        }
        int iF = this.f59529a.f(bArr, i10, h());
        reset();
        return iF;
    }

    public final void d(byte[] bArr, int i10, int i11) {
        this.f59530b.update(bArr, i10, i11);
        e eVar = this.f59530b;
        byte[] bArr2 = this.f59535g;
        eVar.f(bArr2, 0, bArr2.length);
        e eVar2 = this.f59529a;
        byte[] bArr3 = this.f59535g;
        eVar2.update(bArr3, 0, bArr3.length);
        this.f59537i++;
    }

    @Override // org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        if (this.f59536h) {
            i(0);
        }
        return this.f59529a.e(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        if (this.f59536h) {
            i(this.f59532d);
        }
        int iF = this.f59529a.f(bArr, i10, i11);
        reset();
        return iF;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59529a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59532d;
    }

    public final void i(int i10) {
        if (this.f59538j != 0) {
            a();
        }
        byte[] bArrD = r0.d(this.f59537i);
        byte[] bArrD2 = r0.d(i10 * 8);
        this.f59529a.update(bArrD, 0, bArrD.length);
        this.f59529a.update(bArrD2, 0, bArrD2.length);
        this.f59536h = false;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59529a.reset();
        org.bouncycastle.util.a.n(this.f59534f);
        byte[] bArrC = r0.c(this.f59533e);
        this.f59529a.update(bArrC, 0, bArrC.length);
        this.f59537i = 0;
        this.f59538j = 0;
        this.f59536h = true;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.f59534f;
        int i10 = this.f59538j;
        int i11 = i10 + 1;
        this.f59538j = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            a();
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        int i12 = 0;
        int iMax = Math.max(0, i11);
        if (this.f59538j != 0) {
            while (i12 < iMax) {
                int i13 = this.f59538j;
                byte[] bArr2 = this.f59534f;
                if (i13 == bArr2.length) {
                    break;
                }
                this.f59538j = i13 + 1;
                bArr2[i13] = bArr[i12 + i10];
                i12++;
            }
            if (this.f59538j == this.f59534f.length) {
                a();
            }
        }
        if (i12 < iMax) {
            while (true) {
                int i14 = iMax - i12;
                int i15 = this.f59533e;
                if (i14 <= i15) {
                    break;
                }
                d(bArr, i10 + i12, i15);
                i12 += this.f59533e;
            }
        }
        while (i12 < iMax) {
            update(bArr[i12 + i10]);
            i12++;
        }
    }
}
