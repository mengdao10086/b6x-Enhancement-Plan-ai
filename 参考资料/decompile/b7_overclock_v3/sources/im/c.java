package im;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import zn.o;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pn.j f32507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o[] f32508b;

    public c(f0 f0Var) {
        int i10 = 0;
        this.f32507a = pn.j.z(f0Var.K(0));
        f0 f0VarJ = f0.J(f0Var.K(1));
        this.f32508b = new o[f0VarJ.size()];
        while (true) {
            o[] oVarArr = this.f32508b;
            if (i10 == oVarArr.length) {
                return;
            }
            oVarArr[i10] = o.z(f0VarJ.K(i10));
            i10++;
        }
    }

    public c(pn.j jVar, o[] oVarArr) {
        this.f32507a = jVar;
        o[] oVarArr2 = new o[oVarArr.length];
        this.f32508b = oVarArr2;
        System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
    }

    public static c z(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f32507a);
        iVar.a(new j2(this.f32508b));
        return new j2(iVar);
    }

    public o[] x() {
        o[] oVarArr = this.f32508b;
        o[] oVarArr2 = new o[oVarArr.length];
        System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
        return oVarArr2;
    }

    public pn.j y() {
        return this.f32507a;
    }
}
