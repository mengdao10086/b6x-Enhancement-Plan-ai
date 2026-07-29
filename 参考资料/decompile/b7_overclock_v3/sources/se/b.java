package se;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final se.a f49690a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final se.a f49691b = new C0572b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final se.a f49692c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final se.a f49693d = new d();

    public class a implements se.a {
        @Override // se.a
        public se.c a(float f10, float f11, float f12, float f13) {
            return se.c.a(255, u.n(0, 255, f11, f12, f10));
        }
    }

    /* JADX INFO: renamed from: se.b$b, reason: collision with other inner class name */
    public class C0572b implements se.a {
        @Override // se.a
        public se.c a(float f10, float f11, float f12, float f13) {
            return se.c.b(u.n(255, 0, f11, f12, f10), 255);
        }
    }

    public class c implements se.a {
        @Override // se.a
        public se.c a(float f10, float f11, float f12, float f13) {
            return se.c.b(u.n(255, 0, f11, f12, f10), u.n(0, 255, f11, f12, f10));
        }
    }

    public class d implements se.a {
        @Override // se.a
        public se.c a(float f10, float f11, float f12, float f13) {
            float f14 = ((f12 - f11) * f13) + f11;
            return se.c.b(u.n(255, 0, f11, f14, f10), u.n(0, 255, f14, f12, f10));
        }
    }

    public static se.a a(int i10, boolean z10) {
        if (i10 == 0) {
            return z10 ? f49690a : f49691b;
        }
        if (i10 == 1) {
            return z10 ? f49691b : f49690a;
        }
        if (i10 == 2) {
            return f49692c;
        }
        if (i10 == 3) {
            return f49693d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i10);
    }
}
