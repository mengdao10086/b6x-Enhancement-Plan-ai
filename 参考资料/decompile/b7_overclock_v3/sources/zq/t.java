package zq;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import np.n1;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public final class t {

    public static class a extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59625a = t.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("SecretKeyFactory.PBKDF-OPENSSL", f59625a + "$PBKDF");
        }
    }

    public static class b extends ar.d {
        public b() {
            super("PBKDF-OpenSSL", null);
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof PBEKeySpec)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                throw new InvalidKeySpecException("missing required salt");
            }
            if (pBEKeySpec.getIterationCount() <= 0) {
                throw new InvalidKeySpecException("positive iteration count required: " + pBEKeySpec.getIterationCount());
            }
            if (pBEKeySpec.getKeyLength() <= 0) {
                throw new InvalidKeySpecException("positive key length required: " + pBEKeySpec.getKeyLength());
            }
            if (pBEKeySpec.getPassword().length == 0) {
                throw new IllegalArgumentException("password empty");
            }
            fp.g0 g0Var = new fp.g0();
            g0Var.l(Strings.n(pBEKeySpec.getPassword()), pBEKeySpec.getSalt());
            return new SecretKeySpec(((n1) g0Var.e(pBEKeySpec.getKeyLength())).a(), "OpenSSLPBKDF");
        }
    }
}
