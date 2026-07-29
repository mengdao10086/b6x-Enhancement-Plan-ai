package zq;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import np.n1;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    public static class a extends ar.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59571c;

        public a(String str, int i10) {
            super(str, in.c.M);
            this.f59571c = i10;
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof cr.t)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            cr.t tVar = (cr.t) keySpec;
            if (tVar.f() == null) {
                throw new IllegalArgumentException("Salt S must be provided.");
            }
            if (tVar.b() <= 1) {
                throw new IllegalArgumentException("Cost parameter N must be > 1.");
            }
            if (tVar.c() > 0) {
                if (tVar.e().length == 0) {
                    throw new IllegalArgumentException("password empty");
                }
                return new BCPBEKey(this.f8862a, new n1(fp.n0.i(PasswordConverter.UTF8.convert(tVar.e()), tVar.f(), tVar.b(), tVar.a(), tVar.d(), tVar.c() / 8)));
            }
            throw new InvalidKeySpecException("positive key length required: " + tVar.c());
        }
    }

    public static class b extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59572a = c0.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59572a;
            sb2.append(str);
            sb2.append("$ScryptWithUTF8");
            aVar.h("SecretKeyFactory.SCRYPT", sb2.toString());
            aVar.k("SecretKeyFactory", in.c.M, str + "$ScryptWithUTF8");
        }
    }

    public static class c extends a {
        public c() {
            super("SCRYPT", 5);
        }
    }
}
