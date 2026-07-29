package fs;

import java.io.IOException;
import org.bouncycastle.crypto.util.n;
import org.bouncycastle.pkcs.PKCSException;

/* JADX INFO: loaded from: classes6.dex */
public class a extends es.b {
    public a(es.b bVar) {
        super(bVar.k());
    }

    public a(pn.e eVar) {
        super(eVar);
    }

    public a(byte[] bArr) throws IOException {
        super(bArr);
    }

    public np.c l() throws PKCSException {
        try {
            return n.c(h());
        } catch (IOException e10) {
            throw new PKCSException("error extracting key encoding: " + e10.getMessage(), e10);
        }
    }
}
