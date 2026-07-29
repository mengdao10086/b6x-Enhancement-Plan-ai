package lo;

import gm.f2;
import java.io.IOException;
import org.bouncycastle.cert.ocsp.OCSPException;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40088a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40089b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40090c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40091d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40092e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40093f = 6;

    public g a(int i10, Object obj) throws OCSPException {
        if (obj == null) {
            return new g(new nn.g(new nn.h(i10), null));
        }
        if (!(obj instanceof a)) {
            throw new OCSPException("unknown response object");
        }
        try {
            return new g(new nn.g(new nn.h(i10), new nn.k(nn.e.f42257b, new f2(((a) obj).getEncoded()))));
        } catch (IOException e10) {
            throw new OCSPException("can't encode object.", e10);
        }
    }
}
