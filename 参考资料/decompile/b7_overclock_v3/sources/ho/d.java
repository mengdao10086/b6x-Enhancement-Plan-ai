package ho;

import gm.y;
import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.k;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static Object a(boolean z10, k kVar, zn.b bVar) throws CRMFException {
        try {
            return org.bouncycastle.crypto.util.c.c(z10, kVar, bVar);
        } catch (IllegalArgumentException e10) {
            throw new CRMFException(e10.getMessage(), e10);
        }
    }

    public j b(y yVar, SecureRandom secureRandom) throws CRMFException {
        try {
            return org.bouncycastle.crypto.util.d.b(yVar, secureRandom);
        } catch (IllegalArgumentException e10) {
            throw new CRMFException(e10.getMessage(), e10);
        }
    }

    public zn.b c(y yVar, n1 n1Var, SecureRandom secureRandom) throws CRMFException {
        try {
            return org.bouncycastle.crypto.util.a.a(yVar, n1Var.a().length * 8, secureRandom);
        } catch (IllegalArgumentException e10) {
            throw new CRMFException(e10.getMessage(), e10);
        }
    }
}
