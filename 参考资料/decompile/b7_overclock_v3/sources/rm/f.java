package rm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f48858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f48859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f48860c;

    public f(f0 f0Var) {
        this.f48858a = g.B(f0Var.K(0));
        this.f48859b = k.z(f0Var.K(1));
        if (f0Var.size() > 2) {
            this.f48860c = b0.z(f0Var.K(2));
        }
    }

    public f(g gVar, k kVar) {
        this(gVar, kVar, null);
    }

    public f(g gVar, k kVar, b0 b0Var) {
        this.f48858a = gVar;
        this.f48859b = kVar;
        this.f48860c = b0Var;
    }

    public static f y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static f z(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    public g A() {
        return this.f48858a;
    }

    public b0 B() {
        return this.f48860c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f48858a);
        iVar.a(this.f48859b);
        b0 b0Var = this.f48860c;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        return new j2(iVar);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DVCSRequest {\nrequestInformation: ");
        sb2.append(this.f48858a);
        sb2.append("\ndata: ");
        sb2.append(this.f48859b);
        sb2.append("\n");
        if (this.f48860c != null) {
            str = "transactionIdentifier: " + this.f48860c + "\n";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append("}\n");
        return sb2.toString();
    }

    public k x() {
        return this.f48859b;
    }
}
