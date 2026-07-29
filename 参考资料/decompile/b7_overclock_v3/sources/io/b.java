package io;

import gm.j;
import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.jcajce.util.i;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class b extends go.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f32593g;

    public b(go.c cVar) {
        this(cVar.l());
    }

    public b(om.e eVar) {
        super(eVar);
        this.f32593g = new a(new org.bouncycastle.jcajce.util.c());
    }

    public b(byte[] bArr) {
        this(om.e.A(bArr));
    }

    public PublicKey n() throws CRMFException {
        c1 c1VarB = b().B();
        if (c1VarB != null) {
            return this.f32593g.l(c1VarB);
        }
        return null;
    }

    public X500Principal o() {
        xn.d dVarE = b().E();
        if (dVarE == null) {
            return null;
        }
        try {
            return new X500Principal(dVarE.v(j.f29713a));
        } catch (IOException e10) {
            throw new IllegalStateException("unable to construct DER encoding of name: " + e10.getMessage());
        }
    }

    public b p(String str) {
        this.f32593g = new a(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public b q(Provider provider) {
        this.f32593g = new a(new i(provider));
        return this;
    }
}
