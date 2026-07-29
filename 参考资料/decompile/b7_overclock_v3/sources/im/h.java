package im;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.h f32522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f32523b;

    public h(f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("malformed sequence");
        }
        gm.h hVarK = f0Var.K(0);
        if (!(hVarK instanceof b) && !(hVarK instanceof i)) {
            f0 f0VarJ = f0.J(hVarK);
            hVarK = f0VarJ.size() == 2 ? b.z(f0VarJ) : i.z(f0VarJ);
        }
        this.f32522a = hVarK;
        this.f32523b = j.x(f0Var.K(1));
    }

    public h(b bVar, j jVar) {
        this.f32522a = bVar;
        this.f32523b = jVar;
    }

    public h(i iVar, j jVar) {
        this.f32522a = iVar;
        this.f32523b = jVar;
    }

    public static h x(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f32522a);
        iVar.a(this.f32523b);
        return new j2(iVar);
    }

    public j y() {
        return this.f32523b;
    }

    public gm.h z() {
        return this.f32522a;
    }
}
