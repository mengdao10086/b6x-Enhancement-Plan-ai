package so;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f50229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f50230b;

    public m1(X509CertificateHolder x509CertificateHolder) {
        ArrayList arrayList = new ArrayList(1);
        this.f50229a = arrayList;
        this.f50230b = null;
        arrayList.add(x509CertificateHolder.y());
    }

    public m1(org.bouncycastle.util.s sVar) throws CMSException {
        this(sVar, null);
    }

    public m1(org.bouncycastle.util.s sVar, org.bouncycastle.util.s sVar2) throws CMSException {
        this.f50229a = t0.j(sVar);
        this.f50230b = sVar2 != null ? t0.i(sVar2) : null;
    }

    public n1 a() {
        return this.f50230b != null ? new n1(new mm.g0(t0.g(this.f50229a), t0.g(this.f50230b))) : new n1(new mm.g0(t0.g(this.f50229a), null));
    }
}
