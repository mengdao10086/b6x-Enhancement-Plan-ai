package pn;

import gm.f0;
import gm.i1;
import gm.z2;

/* JADX INFO: loaded from: classes5.dex */
public class b extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g[] f46731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46732b;

    public b(f0 f0Var) {
        this.f46732b = true;
        this.f46731a = new g[f0Var.size()];
        int i10 = 0;
        while (true) {
            g[] gVarArr = this.f46731a;
            if (i10 == gVarArr.length) {
                this.f46732b = f0Var instanceof i1;
                return;
            } else {
                gVarArr[i10] = g.z(f0Var.K(i10));
                i10++;
            }
        }
    }

    public b(g[] gVarArr) {
        this.f46732b = true;
        this.f46731a = x(gVarArr);
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f46732b ? new i1(this.f46731a) : new z2(this.f46731a);
    }

    public final g[] x(g[] gVarArr) {
        int length = gVarArr.length;
        g[] gVarArr2 = new g[length];
        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
        return gVarArr2;
    }

    public g[] y() {
        return x(this.f46731a);
    }
}
