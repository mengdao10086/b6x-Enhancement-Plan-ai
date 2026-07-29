package org.bouncycastle.jcajce.util;

import co.j;
import co.l;
import co.n;
import gm.y;
import gm.z;
import java.io.IOException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class ECKeyUtil {

    public static class ECPublicKeyWithCompression implements ECPublicKey {
        private final ECPublicKey ecPublicKey;

        public ECPublicKeyWithCompression(ECPublicKey eCPublicKey) {
            this.ecPublicKey = eCPublicKey;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return this.ecPublicKey.getAlgorithm();
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            ir.e eVarY;
            c1 c1VarA = c1.A(this.ecPublicKey.getEncoded());
            j jVarY = j.y(c1VarA.x().A());
            if (jVarY.B()) {
                y yVar = (y) jVarY.z();
                l lVarK = ap.a.k(yVar);
                if (lVarK == null) {
                    lVarK = co.e.c(yVar);
                }
                eVarY = lVarK.y();
            } else {
                if (jVarY.A()) {
                    throw new IllegalStateException("unable to identify implictlyCA");
                }
                eVarY = l.D(jVarY.z()).y();
            }
            try {
                return new c1(c1VarA.x(), z.I(new n(eVarY.k(c1VarA.C().L()), true).b()).J()).getEncoded();
            } catch (IOException e10) {
                throw new IllegalStateException("unable to encode EC public key: " + e10.getMessage());
            }
        }

        @Override // java.security.Key
        public String getFormat() {
            return this.ecPublicKey.getFormat();
        }

        @Override // java.security.interfaces.ECKey
        public ECParameterSpec getParams() {
            return this.ecPublicKey.getParams();
        }

        @Override // java.security.interfaces.ECPublicKey
        public ECPoint getW() {
            return this.ecPublicKey.getW();
        }
    }

    public static ECPublicKey a(ECPublicKey eCPublicKey) {
        return new ECPublicKeyWithCompression(eCPublicKey);
    }
}
