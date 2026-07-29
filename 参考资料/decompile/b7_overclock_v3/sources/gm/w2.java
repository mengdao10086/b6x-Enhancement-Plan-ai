package gm;

/* JADX INFO: loaded from: classes5.dex */
public class w2 extends l {
    public w2(i iVar) {
        this(x2.a(iVar));
    }

    public w2(y yVar, t tVar, c0 c0Var, int i10, c0 c0Var2) {
        super(yVar, tVar, c0Var, i10, c0Var2);
    }

    public w2(y yVar, t tVar, c0 c0Var, n2 n2Var) {
        super(yVar, tVar, c0Var, n2Var);
    }

    public w2(z2 z2Var) {
        super(z2Var);
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
            iVar.a(c0Var.F());
        }
        int i10 = this.f29733d;
        iVar.a(new d3(i10 == 0, i10, this.f29734e));
        return new z2(iVar);
    }
}
