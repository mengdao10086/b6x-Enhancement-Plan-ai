package xr;

import xr.e0;

/* JADX INFO: loaded from: classes6.dex */
public class s0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0.c f56026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f56027b;

    public s0(e0.c cVar, n nVar) {
        this.f56026a = cVar;
        this.f56027b = nVar;
    }

    public static s0 z(Object obj) {
        if (obj instanceof s0) {
            return (s0) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new s0((e0.c) e0.x(f0VarJ.K(0)), n.z(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56026a, this.f56027b);
    }

    public e0.c x() {
        return this.f56026a;
    }

    public n y() {
        return this.f56027b;
    }
}
