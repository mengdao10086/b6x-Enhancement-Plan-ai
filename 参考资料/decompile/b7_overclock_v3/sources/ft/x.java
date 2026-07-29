package ft;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f28821a;

    public x(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("invalid length");
        }
        this.f28821a = new int[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            this.f28821a[i11] = i11;
        }
    }

    public x(int i10, SecureRandom secureRandom) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("invalid length");
        }
        this.f28821a = new int[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = i11;
        }
        int i12 = i10;
        for (int i13 = 0; i13 < i10; i13++) {
            int iA = b0.a(secureRandom, i12);
            i12--;
            this.f28821a[i13] = iArr[iA];
            iArr[iA] = iArr[i12];
        }
    }

    public x(byte[] bArr) {
        if (bArr.length <= 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        int iG = v.g(bArr, 0);
        int iE = u.e(iG - 1);
        if (bArr.length != (iG * iE) + 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        this.f28821a = new int[iG];
        for (int i10 = 0; i10 < iG; i10++) {
            this.f28821a[i10] = v.h(bArr, (i10 * iE) + 4, iE);
        }
        if (!d(this.f28821a)) {
            throw new IllegalArgumentException("invalid encoding");
        }
    }

    public x(int[] iArr) {
        if (!d(iArr)) {
            throw new IllegalArgumentException("array is not a permutation vector");
        }
        this.f28821a = t.a(iArr);
    }

    public x a() {
        x xVar = new x(this.f28821a.length);
        for (int length = this.f28821a.length - 1; length >= 0; length--) {
            xVar.f28821a[this.f28821a[length]] = length;
        }
        return xVar;
    }

    public byte[] b() {
        int length = this.f28821a.length;
        int iE = u.e(length - 1);
        byte[] bArr = new byte[(length * iE) + 4];
        v.a(length, bArr, 0);
        for (int i10 = 0; i10 < length; i10++) {
            v.b(this.f28821a[i10], bArr, (i10 * iE) + 4, iE);
        }
        return bArr;
    }

    public int[] c() {
        return t.a(this.f28821a);
    }

    public final boolean d(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            if (iArr[i10] < 0 || iArr[i10] >= length || zArr[iArr[i10]]) {
                return false;
            }
            zArr[iArr[i10]] = true;
        }
        return true;
    }

    public x e(x xVar) {
        int length = xVar.f28821a.length;
        int[] iArr = this.f28821a;
        if (length != iArr.length) {
            throw new IllegalArgumentException("length mismatch");
        }
        x xVar2 = new x(iArr.length);
        for (int length2 = this.f28821a.length - 1; length2 >= 0; length2--) {
            xVar2.f28821a[length2] = this.f28821a[xVar.f28821a[length2]];
        }
        return xVar2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof x) {
            return t.b(this.f28821a, ((x) obj).f28821a);
        }
        return false;
    }

    public int hashCode() {
        return org.bouncycastle.util.a.v0(this.f28821a);
    }

    public String toString() {
        String str = "[" + this.f28821a[0];
        for (int i10 = 1; i10 < this.f28821a.length; i10++) {
            str = str + ", " + this.f28821a[i10];
        }
        return str + "]";
    }
}
