package xr;

import gm.n2;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class z1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56106c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56107d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56108e = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.h f56109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56110b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56112b;

        public a a() {
            this.f56111a = 1;
            this.f56112b = gm.d2.f29657b;
            return this;
        }

        public a b(int i10) {
            this.f56111a = i10;
            return this;
        }

        public z1 c() {
            return new z1(this.f56111a, this.f56112b);
        }

        public a d(p1 p1Var) {
            this.f56111a = 0;
            this.f56112b = p1Var;
            return this;
        }

        public a e(gm.h hVar) {
            this.f56111a = 3;
            if (hVar instanceof gm.z) {
                this.f56112b = hVar;
            } else {
                try {
                    this.f56112b = new gm.f2(hVar.b().getEncoded());
                } catch (IOException e10) {
                    throw new RuntimeException(e10.getMessage(), e10);
                }
            }
            return this;
        }

        public a f(gm.h hVar) {
            this.f56112b = hVar;
            return this;
        }
    }

    public z1(int i10, gm.h hVar) {
        this.f56109a = hVar;
        this.f56110b = i10;
    }

    public static a x() {
        return new a();
    }

    public static z1 y(Object obj) {
        if (obj instanceof z1) {
            return (z1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new z1(0, p1.y(n0VarT.U()));
        }
        if (iQ == 1) {
            return new z1(1, gm.d2.f29657b);
        }
        if (iQ != 3) {
            return null;
        }
        try {
            return new z1(3, new gm.f2(n0VarT.U().getEncoded()));
        } catch (IOException e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56110b, this.f56109a);
    }
}
