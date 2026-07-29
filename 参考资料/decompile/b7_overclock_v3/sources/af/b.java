package af;

import com.bumptech.glide.load.engine.GlideException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f585d;

    public b(int i10) {
        this(i10, i10);
    }

    public static b n(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int length = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        while (length < str.length()) {
            if (str.charAt(length) == '\n' || str.charAt(length) == '\r') {
                if (i10 > i11) {
                    if (i12 == -1) {
                        i12 = i10 - i11;
                    } else if (i10 - i11 != i12) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i13++;
                    i11 = i10;
                }
                length++;
            } else {
                if (str.startsWith(str2, length)) {
                    length += str2.length();
                    zArr[i10] = true;
                } else {
                    if (!str.startsWith(str3, length)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(length));
                    }
                    length += str3.length();
                    zArr[i10] = false;
                }
                i10++;
            }
        }
        if (i10 > i11) {
            if (i12 == -1) {
                i12 = i10 - i11;
            } else if (i10 - i11 != i12) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i13++;
        }
        b bVar = new b(i12, i13);
        for (int i14 = 0; i14 < i10; i14++) {
            if (zArr[i14]) {
                bVar.s(i14 % i12, i14 / i12);
            }
        }
        return bVar;
    }

    public static b o(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        b bVar = new b(length2, length);
        for (int i10 = 0; i10 < length; i10++) {
            boolean[] zArr2 = zArr[i10];
            for (int i11 = 0; i11 < length2; i11++) {
                if (zArr2[i11]) {
                    bVar.s(i11, i10);
                }
            }
        }
        return bVar;
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f583b * (this.f582a + 1));
        for (int i10 = 0; i10 < this.f583b; i10++) {
            for (int i11 = 0; i11 < this.f582a; i11++) {
                sb2.append(f(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void b() {
        int length = this.f585d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f585d[i10] = 0;
        }
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f582a, this.f583b, this.f584c, (int[]) this.f585d.clone());
    }

    public void d() {
        int length = this.f585d.length;
        for (int i10 = 0; i10 < length; i10++) {
            int[] iArr = this.f585d;
            iArr[i10] = ~iArr[i10];
        }
    }

    public void e(int i10, int i11) {
        int i12 = (i11 * this.f584c) + (i10 / 32);
        int[] iArr = this.f585d;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f582a == bVar.f582a && this.f583b == bVar.f583b && this.f584c == bVar.f584c && Arrays.equals(this.f585d, bVar.f585d);
    }

    public boolean f(int i10, int i11) {
        return ((this.f585d[(i11 * this.f584c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int[] g() {
        int length = this.f585d.length - 1;
        while (length >= 0 && this.f585d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f584c;
        int i11 = length / i10;
        int i12 = (length % i10) * 32;
        int i13 = 31;
        while ((this.f585d[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public int[] h() {
        int i10 = this.f582a;
        int i11 = this.f583b;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f583b; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.f584c;
                if (i15 < i16) {
                    int i17 = this.f585d[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 * 32;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 < i10 || i13 < i11) {
            return null;
        }
        return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
    }

    public int hashCode() {
        int i10 = this.f582a;
        return (((((((i10 * 31) + i10) * 31) + this.f583b) * 31) + this.f584c) * 31) + Arrays.hashCode(this.f585d);
    }

    public int i() {
        return this.f583b;
    }

    public a j(int i10, a aVar) {
        if (aVar == null || aVar.l() < this.f582a) {
            aVar = new a(this.f582a);
        } else {
            aVar.d();
        }
        int i11 = i10 * this.f584c;
        for (int i12 = 0; i12 < this.f584c; i12++) {
            aVar.r(i12 * 32, this.f585d[i11 + i12]);
        }
        return aVar;
    }

    public int k() {
        return this.f584c;
    }

    public int[] l() {
        int[] iArr;
        int i10 = 0;
        while (true) {
            iArr = this.f585d;
            if (i10 >= iArr.length || iArr[i10] != 0) {
                break;
            }
            i10++;
        }
        if (i10 == iArr.length) {
            return null;
        }
        int i11 = this.f584c;
        int i12 = i10 / i11;
        int i13 = (i10 % i11) * 32;
        int i14 = iArr[i10];
        int i15 = 0;
        while ((i14 << (31 - i15)) == 0) {
            i15++;
        }
        return new int[]{i13 + i15, i12};
    }

    public int m() {
        return this.f582a;
    }

    public void p(int i10) {
        int i11 = i10 % 360;
        if (i11 != 0) {
            if (i11 == 90) {
                r();
                return;
            }
            if (i11 == 180) {
                q();
            } else {
                if (i11 != 270) {
                    throw new IllegalArgumentException("degrees must be a multiple of 0, 90, 180, or 270");
                }
                r();
                q();
            }
        }
    }

    public void q() {
        a aVar = new a(this.f582a);
        a aVar2 = new a(this.f582a);
        int i10 = (this.f583b + 1) / 2;
        for (int i11 = 0; i11 < i10; i11++) {
            aVar = j(i11, aVar);
            int i12 = (this.f583b - 1) - i11;
            aVar2 = j(i12, aVar2);
            aVar.p();
            aVar2.p();
            u(i11, aVar2);
            u(i12, aVar);
        }
    }

    public void r() {
        int i10 = this.f583b;
        int i11 = this.f582a;
        int i12 = (i10 + 31) / 32;
        int[] iArr = new int[i12 * i11];
        for (int i13 = 0; i13 < this.f583b; i13++) {
            for (int i14 = 0; i14 < this.f582a; i14++) {
                if (((this.f585d[(this.f584c * i13) + (i14 / 32)] >>> (i14 & 31)) & 1) != 0) {
                    int i15 = (((i11 - 1) - i14) * i12) + (i13 / 32);
                    iArr[i15] = (1 << (i13 & 31)) | iArr[i15];
                }
            }
        }
        this.f582a = i10;
        this.f583b = i11;
        this.f584c = i12;
        this.f585d = iArr;
    }

    public void s(int i10, int i11) {
        int i12 = (i11 * this.f584c) + (i10 / 32);
        int[] iArr = this.f585d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void t(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f583b || i14 > this.f582a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f584c * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f585d;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public String toString() {
        return v("X ", GlideException.a.f12263d);
    }

    public void u(int i10, a aVar) {
        int[] iArrI = aVar.i();
        int[] iArr = this.f585d;
        int i11 = this.f584c;
        System.arraycopy(iArrI, 0, iArr, i10 * i11, i11);
    }

    public String v(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String w(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void x(int i10, int i11) {
        int i12 = (i11 * this.f584c) + (i10 / 32);
        int[] iArr = this.f585d;
        iArr[i12] = (~(1 << (i10 & 31))) & iArr[i12];
    }

    public void y(b bVar) {
        if (this.f582a != bVar.f582a || this.f583b != bVar.f583b || this.f584c != bVar.f584c) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        a aVar = new a(this.f582a);
        for (int i10 = 0; i10 < this.f583b; i10++) {
            int i11 = this.f584c * i10;
            int[] iArrI = bVar.j(i10, aVar).i();
            for (int i12 = 0; i12 < this.f584c; i12++) {
                int[] iArr = this.f585d;
                int i13 = i11 + i12;
                iArr[i13] = iArr[i13] ^ iArrI[i12];
            }
        }
    }

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f582a = i10;
        this.f583b = i11;
        int i12 = (i10 + 31) / 32;
        this.f584c = i12;
        this.f585d = new int[i12 * i11];
    }

    public b(int i10, int i11, int i12, int[] iArr) {
        this.f582a = i10;
        this.f583b = i11;
        this.f584c = i12;
        this.f585d = iArr;
    }
}
