package rm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;
import lm.b0;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f48849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b0 f48850b;

    public d(f0 f0Var) {
        this.f48849a = b0.z(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f48850b = zn.b0.z(f0Var.K(1));
        }
    }

    public d(b0 b0Var) {
        this(b0Var, null);
    }

    public d(b0 b0Var, zn.b0 b0Var2) {
        this.f48849a = b0Var;
        this.f48850b = b0Var2;
    }

    public static d x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static d y(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public b0 A() {
        return this.f48849a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f48849a);
        zn.b0 b0Var = this.f48850b;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        return new j2(iVar);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DVCSErrorNotice {\ntransactionStatus: ");
        sb2.append(this.f48849a);
        sb2.append("\n");
        if (this.f48850b != null) {
            str = "transactionIdentifier: " + this.f48850b + "\n";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append("}\n");
        return sb2.toString();
    }

    public zn.b0 z() {
        return this.f48850b;
    }
}
