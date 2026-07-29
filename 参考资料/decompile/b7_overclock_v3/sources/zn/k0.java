package zn;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f58804b = 128;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58805c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58806d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58807e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58808f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f58809g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58810h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f58811i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f58812j = 32768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.d f58813a;

    public k0(int i10) {
        this.f58813a = new gm.u1(i10);
    }

    public k0(gm.d dVar) {
        this.f58813a = dVar;
    }

    public static k0 x(z zVar) {
        return z(z.E(zVar, y.f59059f));
    }

    public static k0 z(Object obj) {
        if (obj instanceof k0) {
            return (k0) obj;
        }
        if (obj != null) {
            return new k0(gm.d.K(obj));
        }
        return null;
    }

    public boolean A(int i10) {
        return (this.f58813a.N() & i10) == i10;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58813a;
    }

    public int m() {
        return this.f58813a.m();
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        byte[] bArrH = this.f58813a.H();
        if (bArrH.length == 1) {
            sb2 = new StringBuilder();
            sb2.append("KeyUsage: 0x");
            i10 = bArrH[0] & 255;
        } else {
            sb2 = new StringBuilder();
            sb2.append("KeyUsage: 0x");
            i10 = (bArrH[0] & 255) | ((bArrH[1] & 255) << 8);
        }
        sb2.append(Integer.toHexString(i10));
        return sb2.toString();
    }

    public byte[] y() {
        return this.f58813a.H();
    }
}
