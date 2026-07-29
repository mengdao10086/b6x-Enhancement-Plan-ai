package af;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class m implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f622c = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f624b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f628d;

        public boolean e() {
            return this.f625a == 1000;
        }

        public b(char c10, g gVar, int i10, b bVar, int i11) {
            char c11 = c10 == i11 ? (char) 1000 : c10;
            this.f625a = c11;
            this.f626b = i10;
            this.f627c = bVar;
            int length = c11 == 1000 ? 1 : gVar.b(c10, i10).length;
            length = (bVar == null ? 0 : bVar.f626b) != i10 ? length + 3 : length;
            this.f628d = bVar != null ? length + bVar.f628d : length;
        }
    }

    public m(String str, Charset charset, int i10) {
        this.f624b = i10;
        g gVar = new g(str, charset, i10);
        if (gVar.h() != 1) {
            this.f623a = f(str, gVar, i10);
            return;
        }
        this.f623a = new int[str.length()];
        for (int i11 = 0; i11 < this.f623a.length; i11++) {
            char cCharAt = str.charAt(i11);
            int[] iArr = this.f623a;
            if (cCharAt == i10) {
                cCharAt = 1000;
            }
            iArr[i11] = cCharAt;
        }
    }

    public static void d(b[][] bVarArr, int i10, b bVar) {
        if (bVarArr[i10][bVar.f626b] == null || bVarArr[i10][bVar.f626b].f628d > bVar.f628d) {
            bVarArr[i10][bVar.f626b] = bVar;
        }
    }

    public static void e(String str, g gVar, b[][] bVarArr, int i10, b bVar, int i11) {
        int i12;
        int iG;
        char cCharAt = str.charAt(i10);
        int iH = gVar.h();
        if (gVar.g() < 0 || !(cCharAt == i11 || gVar.a(cCharAt, gVar.g()))) {
            i12 = iH;
            iG = 0;
        } else {
            iG = gVar.g();
            i12 = iG + 1;
        }
        for (int i13 = iG; i13 < i12; i13++) {
            if (cCharAt == i11 || gVar.a(cCharAt, i13)) {
                d(bVarArr, i10 + 1, new b(cCharAt, gVar, i13, bVar, i11));
            }
        }
    }

    public static int[] f(String str, g gVar, int i10) {
        int length = str.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, gVar.h());
        e(str, gVar, bVarArr, 0, null, i10);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < gVar.h(); i12++) {
                if (bVarArr[i11][i12] != null && i11 < length) {
                    e(str, gVar, bVarArr, i11, bVarArr[i11][i12], i10);
                }
            }
            for (int i13 = 0; i13 < gVar.h(); i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = Integer.MAX_VALUE;
        int i15 = -1;
        for (int i16 = 0; i16 < gVar.h(); i16++) {
            if (bVarArr[length][i16] != null) {
                b bVar = bVarArr[length][i16];
                if (bVar.f628d < i14) {
                    i14 = bVar.f628d;
                    i15 = i16;
                }
            }
        }
        if (i15 < 0) {
            throw new IllegalStateException("Failed to encode \"" + str + "\"");
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 = bVarArr[length][i15]; bVar2 != null; bVar2 = bVar2.f627c) {
            if (bVar2.e()) {
                arrayList.add(0, 1000);
            } else {
                byte[] bArrB = gVar.b(bVar2.f625a, bVar2.f626b);
                for (int length2 = bArrB.length - 1; length2 >= 0; length2--) {
                    arrayList.add(0, Integer.valueOf(bArrB[length2] & 255));
                }
            }
            if ((bVar2.f627c == null ? 0 : bVar2.f627c.f626b) != bVar2.f626b) {
                arrayList.add(0, Integer.valueOf(gVar.f(bVar2.f626b) + 256));
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i17 = 0; i17 < size; i17++) {
            iArr[i17] = ((Integer) arrayList.get(i17)).intValue();
        }
        return iArr;
    }

    @Override // af.h
    public int a(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (b(i10)) {
            return this.f623a[i10] - 256;
        }
        throw new IllegalArgumentException("value at " + i10 + " is not an ECI but a character");
    }

    @Override // af.h
    public boolean b(int i10) {
        if (i10 >= 0 && i10 < length()) {
            int[] iArr = this.f623a;
            return iArr[i10] > 255 && iArr[i10] <= 999;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // af.h
    public boolean c(int i10, int i11) {
        if ((i10 + i11) - 1 >= this.f623a.length) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (b(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // af.h
    public char charAt(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        if (!b(i10)) {
            return (char) (h(i10) ? this.f624b : this.f623a[i10]);
        }
        throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
    }

    public int g() {
        return this.f624b;
    }

    public boolean h(int i10) {
        if (i10 >= 0 && i10 < length()) {
            return this.f623a[i10] == 1000;
        }
        throw new IndexOutOfBoundsException("" + i10);
    }

    @Override // af.h
    public int length() {
        return this.f623a.length;
    }

    @Override // af.h
    public CharSequence subSequence(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < i11) {
            if (b(i10)) {
                throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
            }
            sb2.append(charAt(i10));
            i10++;
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length(); i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (b(i10)) {
                sb2.append("ECI(");
                sb2.append(a(i10));
                sb2.append(')');
            } else if (charAt(i10) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i10));
                sb2.append('\'');
            } else {
                sb2.append((int) charAt(i10));
            }
        }
        return sb2.toString();
    }
}
