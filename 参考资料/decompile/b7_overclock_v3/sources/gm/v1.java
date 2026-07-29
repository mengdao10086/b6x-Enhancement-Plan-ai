package gm;

/* JADX INFO: loaded from: classes5.dex */
public class v1 extends l {
    public v1(i iVar) {
        this(x1.a(iVar));
    }

    public v1(j2 j2Var) {
        super(j2Var);
    }

    public v1(y yVar, t tVar, c0 c0Var, int i10, c0 c0Var2) {
        super(yVar, tVar, c0Var, i10, c0Var2);
    }

    public v1(y yVar, t tVar, c0 c0Var, n2 n2Var) {
        super(yVar, tVar, c0Var, n2Var);
    }

    @Override // gm.l, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.l, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.l
    public f0 G() {
        i iVar = new i(4);
        y yVar = this.f29730a;
        if (yVar != null) {
            iVar.a(yVar);
        }
        t tVar = this.f29731b;
        if (tVar != null) {
            iVar.a(tVar);
        }
        c0 c0Var = this.f29732c;
        if (c0Var != null) {
            iVar.a(c0Var.E());
        }
        int i10 = this.f29733d;
        iVar.a(new n2(i10 == 0, i10, this.f29734e));
        return new j2(iVar);
    }
}
