package mq;

import gm.f0;
import gm.y;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jcajce.CompositePrivateKey;
import org.bouncycastle.jcajce.CompositePublicKey;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41551a = "org.bouncycastle.jcajce.provider.asymmetric.COMPOSITE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f41552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static br.c f41553c;

    /* JADX INFO: renamed from: mq.a$a, reason: collision with other inner class name */
    public static class C0458a implements br.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final uq.a f41554a;

        public C0458a(uq.a aVar) {
            this.f41554a = aVar;
        }

        @Override // br.c
        public PublicKey a(c1 c1Var) throws IOException {
            f0 f0VarJ = f0.J(c1Var.C().H());
            PublicKey[] publicKeyArr = new PublicKey[f0VarJ.size()];
            for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
                c1 c1VarA = c1.A(f0VarJ.K(i10));
                publicKeyArr[i10] = this.f41554a.l(c1VarA.x().x()).a(c1VarA);
            }
            return new CompositePublicKey(publicKeyArr);
        }

        @Override // br.c
        public PrivateKey b(u uVar) throws IOException {
            f0 f0VarJ = f0.J(uVar.A().J());
            PrivateKey[] privateKeyArr = new PrivateKey[f0VarJ.size()];
            for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
                u uVarZ = u.z(f0VarJ.K(i10));
                privateKeyArr[i10] = this.f41554a.l(uVarZ.B().x()).b(uVarZ);
            }
            return new CompositePrivateKey(privateKeyArr);
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
        @Override // br.c
        public PublicKey a(c1 c1Var) throws IOException {
            return a.f41553c.a(c1Var);
        }

        @Override // br.c
        public PrivateKey b(u uVar) throws IOException {
            return a.f41553c.b(uVar);
        }

        @Override // java.security.KeyFactorySpi
        public Key engineTranslateKey(Key key) throws InvalidKeyException {
            try {
                if (key instanceof PrivateKey) {
                    return b(u.z(key.getEncoded()));
                }
                if (key instanceof PublicKey) {
                    return a(c1.A(key.getEncoded()));
                }
                throw new InvalidKeyException("key not recognized");
            } catch (IOException e10) {
                throw new InvalidKeyException("key could not be parsed: " + e10.getMessage());
            }
        }
    }

    public static class c extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.COMPOSITE", "org.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KeyFactory.");
            y yVar = in.c.N;
            sb2.append(yVar);
            aVar.h(sb2.toString(), "org.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            aVar.h("KeyFactory.OID." + yVar, "org.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            br.c unused = a.f41553c = new C0458a(aVar);
            aVar.b(yVar, a.f41553c);
        }
    }

    static {
        HashMap map = new HashMap();
        f41552b = map;
        map.put("SupportedKeyClasses", "org.bouncycastle.jcajce.CompositePublicKey|org.bouncycastle.jcajce.CompositePrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
