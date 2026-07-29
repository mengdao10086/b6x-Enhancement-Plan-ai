package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class v extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56066c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56067d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56068e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56070b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56072b;

        public v a() {
            return new v(this.f56071a, this.f56072b);
        }

        public a b(int i10) {
            this.f56071a = i10;
            return this;
        }

        public a c(gm.h hVar) {
            this.f56072b = hVar;
            return this;
        }
    }

    public v(int i10, gm.h hVar) {
        this.f56069a = i10;
        this.f56070b = hVar;
    }

    public static v y(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1) {
            return new a().b(n0VarT.q()).c(n0VarT.U()).a();
        }
        throw new IllegalStateException("unknown choice " + n0VarT.q());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56069a, this.f56070b);
    }

    public int x() {
        return this.f56069a;
    }

    public gm.h z() {
        return this.f56070b;
    }
}
