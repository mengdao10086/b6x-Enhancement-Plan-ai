package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends g0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public gm.y f42462m;

    public k0(gm.y yVar, co.l lVar) {
        super(lVar);
        this.f42462m = yVar;
    }

    public k0(gm.y yVar, ir.e eVar, ir.i iVar, BigInteger bigInteger) {
        this(yVar, eVar, iVar, bigInteger, ir.d.f35647b, null);
    }

    public k0(gm.y yVar, ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(yVar, eVar, iVar, bigInteger, bigInteger2, null);
    }

    public k0(gm.y yVar, ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eVar, iVar, bigInteger, bigInteger2, bArr);
        this.f42462m = yVar;
    }

    public k0(gm.y yVar, g0 g0Var) {
        super(g0Var.a(), g0Var.b(), g0Var.e(), g0Var.c(), g0Var.f());
        this.f42462m = yVar;
    }

    public gm.y j() {
        return this.f42462m;
    }
}
