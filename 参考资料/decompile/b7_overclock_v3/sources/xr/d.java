package xr;

/* JADX INFO: loaded from: classes6.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.z f55841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.z f55842b;

    public d(gm.z zVar, gm.z zVar2) {
        this.f55841a = zVar;
        this.f55842b = zVar2;
    }

    public static d x(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj == null) {
            return null;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new d(gm.z.I(f0VarJ.K(0)), gm.z.I(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55841a, this.f55842b);
    }

    public gm.z y() {
        return this.f55842b;
    }

    public gm.z z() {
        return this.f55841a;
    }
}
