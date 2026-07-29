package com.google.zxing.datamatrix.decoder;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.FormatException;
import mb.e;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d[] f21287h = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f21293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21294g;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21296b;

        public int a() {
            return this.f21295a;
        }

        public int b() {
            return this.f21296b;
        }

        public b(int i10, int i11) {
            this.f21295a = i10;
            this.f21296b = i11;
        }
    }

    public d(int i10, int i11, int i12, int i13, int i14, c cVar) {
        this.f21288a = i10;
        this.f21289b = i11;
        this.f21290c = i12;
        this.f21291d = i13;
        this.f21292e = i14;
        this.f21293f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f21294g = iA;
    }

    public static d[] a() {
        int i10 = 48;
        int i11 = 1;
        int i12 = 5;
        int i13 = 8;
        d dVar = new d(3, 14, 14, 12, 12, new c(10, new b(i11, i13)));
        int i14 = 2;
        int i15 = 12;
        int i16 = 18;
        d dVar2 = new d(5, 18, 18, 16, 16, new c(14, new b(i11, 18)));
        int i17 = 4;
        int i18 = 36;
        b bVar = new b(i11, 44);
        int i19 = 62;
        b bVar2 = new b(i11, 86);
        int i20 = 42;
        b bVar3 = new b(i11, 144);
        int i21 = 56;
        b bVar4 = new b(i11, e.f41073w1);
        d dVar3 = new d(15, 52, 52, 24, 24, new c(i20, new b(i14, 102)));
        b bVar5 = new b(6, HideBottomViewOnScrollBehavior.f19616g);
        d dVar4 = new d(23, 132, 132, 20, 20, new c(i19, new b(i13, 163)));
        int i22 = 22;
        b bVar6 = new b(i11, 5);
        b bVar7 = new b(i11, 10);
        int i23 = 32;
        int i24 = 38;
        return new d[]{new d(1, 10, 10, 8, 8, new c(i12, new b(i11, 3))), new d(2, 12, 12, 10, 10, new c(7, new b(i11, i12))), dVar, new d(4, 16, 16, 14, 14, new c(i15, new b(i11, i15))), dVar2, new d(6, 20, 20, 18, 18, new c(i16, new b(i11, 22))), new d(7, 22, 22, 20, 20, new c(20, new b(i11, 30))), new d(8, 24, 24, 22, 22, new c(24, new b(i11, i18))), new d(9, 26, 26, 24, 24, new c(28, bVar)), new d(10, 32, 32, 14, 14, new c(i18, new b(i11, i19))), new d(11, 36, 36, 16, 16, new c(i20, bVar2)), new d(12, 40, 40, 18, 18, new c(i10, new b(i11, 114))), new d(13, 44, 44, 20, 20, new c(i21, bVar3)), new d(14, 48, 48, 22, 22, new c(68, bVar4)), dVar3, new d(16, 64, 64, 14, 14, new c(i21, new b(i14, 140))), new d(17, 72, 72, 16, 16, new c(i18, new b(i17, 92))), new d(18, 80, 80, 18, 18, new c(i10, new b(i17, 114))), new d(19, 88, 88, 20, 20, new c(i21, new b(i17, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(i17, e.f41073w1))), new d(21, 104, 104, 24, 24, new c(i21, new b(6, 136))), new d(22, 120, 120, 18, 18, new c(68, bVar5)), dVar4, new d(24, 144, 144, 22, 22, new c(i19, new b(i13, 156), new b(i14, 155))), new d(25, 8, 18, 6, 16, new c(7, bVar6)), new d(26, 8, 32, 6, 14, new c(11, bVar7)), new d(27, 12, 26, 10, 24, new c(14, new b(i11, 16))), new d(28, 12, 36, 10, 16, new c(i16, new b(i11, i22))), new d(29, 16, 36, 14, 16, new c(24, new b(i11, i23))), new d(30, 16, 48, 14, 22, new c(28, new b(i11, 49))), new d(31, 8, 48, 6, 22, new c(15, new b(i11, i16))), new d(32, 8, 64, 6, 14, new c(i16, new b(i11, 24))), new d(33, 8, 80, 6, 18, new c(i22, new b(i11, i23))), new d(34, 8, 96, 6, 22, new c(28, new b(i11, i24))), new d(35, 8, 120, 6, 18, new c(i23, new b(i11, 49))), new d(36, 8, 144, 6, 22, new c(i18, new b(i11, 63))), new d(37, 12, 64, 10, 14, new c(27, new b(i11, 43))), new d(38, 12, 88, 10, 20, new c(i18, new b(i11, 64))), new d(39, 16, 64, 14, 14, new c(i18, new b(i11, i19))), new d(40, 20, 36, 18, 16, new c(28, new b(i11, 44))), new d(41, 20, 44, 18, 20, new c(34, new b(i11, i21))), new d(42, 20, 64, 18, 14, new c(42, new b(i11, 84))), new d(43, 22, 48, 20, 22, new c(i24, new b(i11, 72))), new d(44, 24, 48, 22, 22, new c(41, new b(i11, 80))), new d(45, 24, 64, 22, 14, new c(46, new b(i11, 108))), new d(46, 26, 40, 24, 18, new c(i24, new b(i11, 70))), new d(47, 26, 48, 24, 22, new c(42, new b(i11, 90))), new d(48, 26, 64, 24, 14, new c(50, new b(i11, 118)))};
    }

    public static d h(int i10, int i11) throws FormatException {
        if ((i10 & 1) != 0 || (i11 & 1) != 0) {
            throw FormatException.b();
        }
        for (d dVar : f21287h) {
            if (dVar.f21289b == i10 && dVar.f21290c == i11) {
                return dVar;
            }
        }
        throw FormatException.b();
    }

    public int b() {
        return this.f21292e;
    }

    public int c() {
        return this.f21291d;
    }

    public c d() {
        return this.f21293f;
    }

    public int e() {
        return this.f21290c;
    }

    public int f() {
        return this.f21289b;
    }

    public int g() {
        return this.f21294g;
    }

    public int i() {
        return this.f21288a;
    }

    public String toString() {
        return String.valueOf(this.f21288a);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f21298b;

        public b[] a() {
            return this.f21298b;
        }

        public int b() {
            return this.f21297a;
        }

        public c(int i10, b bVar) {
            this.f21297a = i10;
            this.f21298b = new b[]{bVar};
        }

        public c(int i10, b bVar, b bVar2) {
            this.f21297a = i10;
            this.f21298b = new b[]{bVar, bVar2};
        }
    }
}
