package ro;

import gm.c0;
import java.io.IOException;
import mm.n;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cmc.CMCException;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.util.g;
import org.bouncycastle.util.s;
import so.l0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f48965a;

    public a(n nVar) throws CMCException {
        try {
            l0 l0Var = new l0(nVar);
            this.f48965a = l0Var;
            if (l0Var.k().size() != 0) {
                throw new CMCException("malformed response: SignerInfo structures found");
            }
            if (l0Var.h() != null) {
                throw new CMCException("malformed response: Signed Content found");
            }
        } catch (CMSException e10) {
            throw new CMCException("malformed response: " + e10.getMessage(), e10);
        }
    }

    public a(byte[] bArr) throws CMCException {
        this(c(bArr));
    }

    public static n c(byte[] bArr) throws CMCException {
        try {
            return n.A(c0.D(bArr));
        } catch (Exception e10) {
            throw new CMCException("malformed data: " + e10.getMessage(), e10);
        }
    }

    public s<X509CRLHolder> a() {
        return this.f48965a.c();
    }

    public s<X509CertificateHolder> b() {
        return this.f48965a.d();
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f48965a.getEncoded();
    }
}
