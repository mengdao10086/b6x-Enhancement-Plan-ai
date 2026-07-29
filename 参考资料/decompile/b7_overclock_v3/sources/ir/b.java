package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements h {
    @Override // ir.h
    public i a(i iVar, BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0 || iVar.v()) {
            return iVar.i().w();
        }
        i iVarC = c(iVar, bigInteger.abs());
        if (iSignum <= 0) {
            iVarC = iVarC.A();
        }
        return b(iVarC);
    }

    public i b(i iVar) {
        return c.b(iVar);
    }

    public abstract i c(i iVar, BigInteger bigInteger);
}
