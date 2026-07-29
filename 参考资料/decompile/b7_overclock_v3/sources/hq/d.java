package hq;

import java.security.Provider;
import org.bouncycastle.operator.OperatorCreationException;
import xr.d2;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.operator.jcajce.d f31422a = new org.bouncycastle.operator.jcajce.d();

    public fq.d a(fq.a aVar, d2.a aVar2) throws OperatorCreationException {
        return new fq.d(aVar, this.f31422a.b(), aVar2);
    }

    public d b(String str) {
        this.f31422a.d(str);
        return this;
    }

    public d c(Provider provider) {
        this.f31422a.e(provider);
        return this;
    }
}
