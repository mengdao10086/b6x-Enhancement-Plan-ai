package hq;

import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.jcajce.util.i;
import xr.d2;
import xr.g;

/* JADX INFO: loaded from: classes5.dex */
public class c extends fq.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f31421g;

    public c(iq.b bVar, d2.a aVar) {
        this(bVar, aVar, new org.bouncycastle.jcajce.util.c());
    }

    public c(iq.b bVar, d2.a aVar, org.bouncycastle.jcajce.util.d dVar) {
        super(bVar, aVar);
        this.f31421g = dVar;
    }

    public fq.a j(g gVar, ECPublicKey eCPublicKey) {
        return k(gVar, eCPublicKey, null);
    }

    public fq.a k(g gVar, ECPublicKey eCPublicKey, ECPublicKey eCPublicKey2) {
        return super.i(gVar, new e(eCPublicKey, this.f31421g), eCPublicKey2 != null ? new f(eCPublicKey2, this.f31421g) : null);
    }

    public c l(String str) {
        this.f31421g = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public c m(Provider provider) {
        this.f31421g = new i(provider);
        return this;
    }
}
