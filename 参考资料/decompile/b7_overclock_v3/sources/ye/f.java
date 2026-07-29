package ye;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f57327f = new f(g.f57333b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f57328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f57329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f57332e;

    public f(g gVar, int i10, int i11, int i12) {
        this.f57329b = gVar;
        this.f57328a = i10;
        this.f57330c = i11;
        this.f57331d = i12;
        this.f57332e = c(i11);
    }

    public static int c(int i10) {
        if (i10 > 62) {
            return 21;
        }
        if (i10 > 31) {
            return 20;
        }
        return i10 > 0 ? 10 : 0;
    }

    public f a(int i10) {
        g gVarA = this.f57329b;
        int i11 = this.f57328a;
        int i12 = this.f57331d;
        if (i11 == 4 || i11 == 2) {
            int i13 = d.f57319i[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            gVarA = gVarA.a(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.f57330c;
        f fVar = new f(gVarA, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return fVar.f57330c == 2078 ? fVar.d(i10 + 1) : fVar;
    }

    public f b(int i10) {
        g gVarA;
        g gVar = k(4, 0).f57329b;
        int length = 3;
        if (i10 < 0) {
            gVarA = gVar.a(0, 3);
        } else {
            if (i10 > 999999) {
                throw new IllegalArgumentException("ECI code must be between 0 and 999999");
            }
            byte[] bytes = Integer.toString(i10).getBytes(StandardCharsets.ISO_8859_1);
            g gVarA2 = gVar.a(bytes.length, 3);
            for (byte b10 : bytes) {
                gVarA2 = gVarA2.a((b10 - 48) + 2, 4);
            }
            length = 3 + (bytes.length * 4);
            gVarA = gVarA2;
        }
        return new f(gVarA, this.f57328a, 0, this.f57331d + length);
    }

    public f d(int i10) {
        int i11 = this.f57330c;
        return i11 == 0 ? this : new f(this.f57329b.b(i10 - i11, i11), this.f57328a, 0, this.f57331d);
    }

    public int e() {
        return this.f57330c;
    }

    public int f() {
        return this.f57331d;
    }

    public int g() {
        return this.f57328a;
    }

    public g h() {
        return this.f57329b;
    }

    public boolean i(f fVar) {
        int i10 = this.f57331d + (d.f57319i[this.f57328a][fVar.f57328a] >> 16);
        int i11 = this.f57330c;
        int i12 = fVar.f57330c;
        if (i11 < i12) {
            i10 += fVar.f57332e - this.f57332e;
        } else if (i11 > i12 && i12 > 0) {
            i10 += 10;
        }
        return i10 <= fVar.f57331d;
    }

    public f j(int i10, int i11) {
        int i12 = this.f57331d;
        g gVarA = this.f57329b;
        int i13 = this.f57328a;
        if (i10 != i13) {
            int i14 = d.f57319i[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            gVarA = gVarA.a(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new f(gVarA.a(i11, i17), i10, 0, i12 + i17);
    }

    public f k(int i10, int i11) {
        g gVar = this.f57329b;
        int i12 = this.f57328a;
        int i13 = i12 == 2 ? 4 : 5;
        return new f(gVar.a(d.f57321k[i12][i10], i13).a(i11, 5), this.f57328a, 0, this.f57331d + i13 + 5);
    }

    public af.a l(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        for (g gVarD = d(bArr.length).f57329b; gVarD != null; gVarD = gVarD.d()) {
            arrayList.add(gVarD);
        }
        af.a aVar = new af.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((g) arrayList.get(size)).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f57313c[this.f57328a], Integer.valueOf(this.f57331d), Integer.valueOf(this.f57330c));
    }
}
