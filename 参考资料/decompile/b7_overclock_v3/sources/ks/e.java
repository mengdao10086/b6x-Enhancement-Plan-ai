package ks;

import com.blankj.utilcode.util.i0;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f39129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ls.a f39132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f39133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f39134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f39137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f39138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f39139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f39140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f39141m;

    public e(e eVar) {
        this.f39129a = eVar.f39129a;
        this.f39130b = eVar.f39130b;
        this.f39131c = eVar.f39131c;
        this.f39132d = eVar.f39132d;
        this.f39133e = org.bouncycastle.util.a.p(eVar.f39133e);
        this.f39134f = org.bouncycastle.util.a.p(eVar.f39134f);
        this.f39135g = eVar.f39135g;
        this.f39136h = eVar.f39136h;
        this.f39137i = eVar.f39137i;
        this.f39138j = eVar.f39138j;
        this.f39139k = eVar.f39139k;
        this.f39140l = org.bouncycastle.util.a.p(eVar.f39140l);
        this.f39141m = org.bouncycastle.util.a.p(eVar.f39141m);
    }

    public e(s sVar, int i10, int i11) {
        this.f39138j = i10;
        this.f39129a = sVar;
        this.f39132d = new ls.a(sVar);
        int iH = this.f39129a.h();
        this.f39130b = iH;
        double d10 = i10;
        int iCeil = (int) Math.ceil(((double) (iH << 3)) / d10);
        int iCeil2 = iCeil + ((int) Math.ceil(((double) b((iCeil << i10) + 1)) / d10));
        this.f39131c = iCeil2;
        int i12 = 1 << i10;
        this.f39137i = i12;
        this.f39139k = (int) Math.ceil(((double) ((((i12 - 1) * iCeil2) + 1) + iCeil2)) / ((double) i11));
        int i13 = this.f39130b;
        this.f39140l = new byte[i13];
        this.f39133e = new byte[i13];
        this.f39141m = new byte[i13];
        this.f39134f = new byte[i13 * this.f39131c];
    }

    public e(s sVar, int i10, int i11, byte[] bArr) {
        this.f39138j = i10;
        this.f39129a = sVar;
        this.f39132d = new ls.a(sVar);
        int iH = this.f39129a.h();
        this.f39130b = iH;
        double d10 = i10;
        int iCeil = (int) Math.ceil(((double) (iH << 3)) / d10);
        int iCeil2 = iCeil + ((int) Math.ceil(((double) b((iCeil << i10) + 1)) / d10));
        this.f39131c = iCeil2;
        int i12 = 1 << i10;
        this.f39137i = i12;
        this.f39139k = (int) Math.ceil(((double) ((((i12 - 1) * iCeil2) + 1) + iCeil2)) / ((double) i11));
        int i13 = this.f39130b;
        this.f39140l = new byte[i13];
        this.f39133e = new byte[i13];
        this.f39141m = new byte[i13];
        this.f39134f = new byte[i13 * this.f39131c];
        e(bArr);
    }

    public e(s sVar, byte[][] bArr, int[] iArr) {
        this.f39135g = iArr[0];
        this.f39136h = iArr[1];
        this.f39139k = iArr[2];
        this.f39138j = iArr[3];
        this.f39129a = sVar;
        this.f39132d = new ls.a(sVar);
        int iH = this.f39129a.h();
        this.f39130b = iH;
        int iCeil = (int) Math.ceil(((double) (iH << 3)) / ((double) this.f39138j));
        this.f39131c = iCeil + ((int) Math.ceil(((double) b((iCeil << this.f39138j) + 1)) / ((double) this.f39138j)));
        this.f39137i = 1 << this.f39138j;
        this.f39141m = bArr[0];
        this.f39140l = bArr[1];
        this.f39134f = bArr[2];
        this.f39133e = bArr[3];
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f39133e);
    }

    public final int b(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public byte[][] c() {
        return new byte[][]{this.f39141m, this.f39140l, this.f39134f, this.f39133e};
    }

    public int[] d() {
        return new int[]{this.f39135g, this.f39136h, this.f39139k, this.f39138j};
    }

    public void e(byte[] bArr) {
        this.f39135g = 0;
        this.f39136h = 0;
        byte[] bArr2 = new byte[this.f39130b];
        System.arraycopy(bArr, 0, bArr2, 0, this.f39140l.length);
        this.f39140l = this.f39132d.c(bArr2);
    }

    public e f() {
        e eVar = new e(this);
        eVar.g();
        return eVar;
    }

    public final void g() {
        byte[] bArr = new byte[this.f39129a.h()];
        for (int i10 = 0; i10 < this.f39139k + 10000; i10++) {
            int i11 = this.f39135g;
            if (i11 == this.f39131c && this.f39136h == this.f39137i - 1) {
                s sVar = this.f39129a;
                byte[] bArr2 = this.f39134f;
                sVar.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.f39129a.h()];
                this.f39133e = bArr3;
                this.f39129a.c(bArr3, 0);
                return;
            }
            if (i11 == 0 || this.f39136h == this.f39137i - 1) {
                this.f39135g = i11 + 1;
                this.f39136h = 0;
                this.f39141m = this.f39132d.c(this.f39140l);
            } else {
                s sVar2 = this.f39129a;
                byte[] bArr4 = this.f39141m;
                sVar2.update(bArr4, 0, bArr4.length);
                this.f39141m = bArr;
                this.f39129a.c(bArr, 0);
                int i12 = this.f39136h + 1;
                this.f39136h = i12;
                if (i12 == this.f39137i - 1) {
                    byte[] bArr5 = this.f39141m;
                    byte[] bArr6 = this.f39134f;
                    int i13 = this.f39130b;
                    System.arraycopy(bArr5, 0, bArr6, (this.f39135g - 1) * i13, i13);
                }
            }
        }
        throw new IllegalStateException("unable to updateLeaf in steps: " + this.f39139k + i0.f11861z + this.f39135g + i0.f11861z + this.f39136h);
    }

    public String toString() {
        StringBuilder sb2;
        String str = "";
        for (int i10 = 0; i10 < 4; i10++) {
            str = str + d()[i10] + i0.f11861z;
        }
        String string = str + i0.f11861z + this.f39130b + i0.f11861z + this.f39131c + i0.f11861z + this.f39137i + i0.f11861z;
        byte[][] bArrC = c();
        for (int i11 = 0; i11 < 4; i11++) {
            if (bArrC[i11] != null) {
                sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(new String(jt.h.h(bArrC[i11])));
                sb2.append(i0.f11861z);
            } else {
                sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append("null ");
            }
            string = sb2.toString();
        }
        return string;
    }
}
