package te;

import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final te.a f51081a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final te.a f51082b = new C0580b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final te.a f51083c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final te.a f51084d = new d();

    public class a implements te.a {
        @Override // te.a
        public te.c a(float f10, float f11, float f12, float f13) {
            return te.c.a(255, v.n(0, 255, f11, f12, f10));
        }
    }

    /* JADX INFO: renamed from: te.b$b, reason: collision with other inner class name */
    public class C0580b implements te.a {
        @Override // te.a
        public te.c a(float f10, float f11, float f12, float f13) {
            return te.c.b(v.n(255, 0, f11, f12, f10), 255);
        }
    }

    public class c implements te.a {
        @Override // te.a
        public te.c a(float f10, float f11, float f12, float f13) {
            return te.c.b(v.n(255, 0, f11, f12, f10), v.n(0, 255, f11, f12, f10));
        }
    }

    public class d implements te.a {
        @Override // te.a
        public te.c a(float f10, float f11, float f12, float f13) {
            float f14 = ((f12 - f11) * f13) + f11;
            return te.c.b(v.n(255, 0, f11, f14, f10), v.n(0, 255, f14, f12, f10));
        }
    }

    public static te.a a(int i10, boolean z10) {
        if (i10 == 0) {
            return z10 ? f51081a : f51082b;
        }
        if (i10 == 1) {
            return z10 ? f51082b : f51081a;
        }
        if (i10 == 2) {
            return f51083c;
        }
        if (i10 == 3) {
            return f51084d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i10);
    }
}
