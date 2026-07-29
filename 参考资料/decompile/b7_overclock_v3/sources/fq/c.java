package fq;

import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.its.ITSPublicEncryptionKey;
import xr.c0;
import xr.d2;
import xr.e;
import xr.e0;
import xr.f;
import xr.g;
import xr.h;
import xr.k2;
import xr.n0;
import xr.t1;

/* JADX INFO: loaded from: classes5.dex */
public class c extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final iq.b f28712f;

    public c(iq.b bVar, d2.a aVar) {
        super(aVar);
        this.f28712f = bVar;
    }

    public a h(g gVar, e eVar) {
        return i(gVar, eVar, null);
    }

    public a i(g gVar, e eVar, ITSPublicEncryptionKey iTSPublicEncryptionKey) {
        t1 t1VarA;
        c0 c0Var;
        d2.a aVar = new d2.a(this.f28707a);
        aVar.g(gVar);
        if (iTSPublicEncryptionKey != null) {
            aVar.j(iTSPublicEncryptionKey.a());
        }
        aVar.m(k2.x().c(eVar.a()).a());
        d2 d2VarA = aVar.a();
        k2 k2VarV = this.f28712f.d() ? d2VarA.V() : this.f28712f.c().e().b().B().V();
        OutputStream outputStreamB = this.f28712f.b();
        try {
            outputStreamB.write(org.bouncycastle.oer.b.a(d2VarA, yr.a.L));
            outputStreamB.close();
            int iY = k2VarV.y();
            if (iY == 0) {
                t1VarA = iq.a.a(rn.d.H, this.f28712f.getSignature());
            } else if (iY == 1) {
                t1VarA = iq.a.a(tn.b.f51379u, this.f28712f.getSignature());
            } else {
                if (iY != 3) {
                    throw new IllegalStateException("unknown key type");
                }
                t1VarA = iq.a.a(tn.b.f51383y, this.f28712f.getSignature());
            }
            f.a aVar2 = new f.a();
            n0.a aVarX = n0.x();
            y yVarX = this.f28712f.e().x();
            if (this.f28712f.d()) {
                if (yVarX.C(kn.d.f37592c)) {
                    c0Var = c0.f55828b;
                } else {
                    if (!yVarX.C(kn.d.f37594d)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    c0Var = c0.f55829c;
                }
                aVarX.c(c0Var);
            } else {
                byte[] bArrA = this.f28712f.a();
                e0.d dVar = new e0.d(org.bouncycastle.util.a.W(bArrA, bArrA.length - 8, bArrA.length));
                if (yVarX.C(kn.d.f37592c)) {
                    aVarX.f(dVar);
                } else {
                    if (!yVarX.C(kn.d.f37594d)) {
                        throw new IllegalStateException("unknown digest");
                    }
                    aVarX.g(dVar);
                }
            }
            aVar2.f(this.f28709c);
            aVar2.e(h.f55918e);
            aVar2.b(aVarX.a());
            aVar2.d(d2VarA);
            aVar2.c(t1VarA);
            e.a aVar3 = new e.a();
            aVar3.b(aVar2.a());
            return new a(aVar3.a());
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot produce certificate signature");
        }
    }
}
