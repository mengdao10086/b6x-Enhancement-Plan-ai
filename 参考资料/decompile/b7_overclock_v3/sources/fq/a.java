package fq;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.its.ITSPublicEncryptionKey;
import org.bouncycastle.its.ITSValidityPeriod;
import org.bouncycastle.util.g;
import xr.d1;
import xr.n0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xr.e f28706a;

    public a(xr.e eVar) {
        this.f28706a = eVar;
    }

    public n0 a() {
        return this.f28706a.b().z();
    }

    public ITSPublicEncryptionKey b() {
        d1 d1VarR = this.f28706a.b().B().R();
        if (d1VarR != null) {
            return new ITSPublicEncryptionKey(d1VarR);
        }
        return null;
    }

    public ITSValidityPeriod c() {
        return new ITSValidityPeriod(this.f28706a.b().B().U());
    }

    public boolean d(iq.c cVar) throws Exception {
        cs.g gVar = cVar.get(this.f28706a.b().A().y());
        OutputStream outputStreamB = gVar.b();
        outputStreamB.write(org.bouncycastle.oer.b.a(this.f28706a.b().B(), yr.a.L));
        outputStreamB.close();
        return gVar.verify(iq.a.b(this.f28706a.b().A()));
    }

    public xr.e e() {
        return this.f28706a;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return org.bouncycastle.oer.b.a(this.f28706a.b(), yr.a.K);
    }
}
