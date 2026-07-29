package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class c2 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55836c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55838b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55840b;

        public c2 a() {
            return new c2(this.f55839a, this.f55840b);
        }

        public a b(int i10) {
            this.f55839a = i10;
            return this;
        }

        public a c(gm.h hVar) {
            this.f55840b = hVar;
            return this;
        }
    }

    public c2(int i10, gm.h hVar) {
        this.f55837a = i10;
        this.f55838b = hVar;
    }

    public static c2 y(Object obj) {
        if (obj instanceof c2) {
            return (c2) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        return new a().b(n0VarT.q()).c(n0VarT.U()).a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55837a, this.f55838b);
    }

    public int x() {
        return this.f55837a;
    }

    public gm.h z() {
        return this.f55838b;
    }
}
