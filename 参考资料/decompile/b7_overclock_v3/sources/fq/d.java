package fq;

import cs.o;
import cs.p;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.operator.OperatorCreationException;
import xr.d1;
import xr.d2;
import xr.e;
import xr.e0;
import xr.f;
import xr.g;
import xr.h;
import xr.k2;
import xr.n0;
import xr.q;

/* JADX INFO: loaded from: classes5.dex */
public class d extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f28713f;

    public d(a aVar, p pVar, d2.a aVar2) {
        super(aVar, aVar2);
        y yVar = kn.d.f37592c;
        zn.b bVar = new zn.b(yVar);
        y yVarX = bVar.x();
        try {
            o oVarA = pVar.a(bVar);
            try {
                OutputStream outputStreamB = oVarA.b();
                outputStreamB.write(aVar.getEncoded());
                outputStreamB.close();
                byte[] bArrC = oVarA.c();
                n0.a aVarX = n0.x();
                e0.d dVar = new e0.d(org.bouncycastle.util.a.W(bArrC, bArrC.length - 8, bArrC.length));
                if (yVarX.C(yVar)) {
                    aVarX.f(dVar);
                } else {
                    if (!yVarX.C(kn.d.f37594d)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    aVarX.g(dVar);
                }
                this.f28713f = aVarX.a();
            } catch (IOException e10) {
                throw new IllegalStateException(e10.getMessage(), e10);
            }
        } catch (OperatorCreationException e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }

    public a h(g gVar, BigInteger bigInteger, BigInteger bigInteger2) {
        return i(gVar, bigInteger, bigInteger2, null);
    }

    public a i(g gVar, BigInteger bigInteger, BigInteger bigInteger2, d1 d1Var) {
        q qVarF = q.y().f(bigInteger, bigInteger2);
        d2.a aVar = new d2.a(this.f28707a);
        aVar.g(gVar);
        if (d1Var != null) {
            aVar.j(d1Var);
        }
        aVar.m(k2.x().d(qVarF).a());
        f.a aVar2 = new f.a();
        aVar2.f(this.f28709c);
        aVar2.e(h.f55919f);
        aVar2.b(this.f28713f);
        aVar2.d(aVar.a());
        e.a aVar3 = new e.a();
        aVar3.b(aVar2.a());
        return new a(aVar3.a());
    }
}
