package org.bouncycastle.jce;

import gm.c0;
import gm.d2;
import gm.f2;
import gm.y;
import gm.z;
import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import pn.n;
import pn.t;

/* JADX INFO: loaded from: classes5.dex */
public class f {
    public static byte[] a(y yVar, byte[] bArr, int i10, char[] cArr, byte[] bArr2, String str) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(yVar.L(), str);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i10);
        SecretKey secretKeyGenerateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(cArr));
        Mac mac = Mac.getInstance(yVar.L(), str);
        mac.init(secretKeyGenerateSecret, pBEParameterSpec);
        mac.update(bArr2);
        return mac.doFinal();
    }

    public static byte[] b(byte[] bArr) throws IOException {
        return t.y(bArr).v(gm.j.f29713a);
    }

    public static byte[] c(byte[] bArr, char[] cArr, String str) throws IOException {
        t tVarY = t.y(bArr);
        pn.g gVarX = tVarY.x();
        pn.g gVar = new pn.g(gVarX.y(), new f2(c0.D(z.I(gVarX.x()).J()).v(gm.j.f29713a)));
        n nVarZ = tVarY.z();
        try {
            int iIntValue = nVarZ.y().intValue();
            return new t(gVar, new n(new zn.t(new zn.b(nVarZ.z().x().x(), d2.f29657b), a(nVarZ.z().x().x(), nVarZ.A(), iIntValue, cArr, z.I(gVar.x()).J(), str)), nVarZ.A(), iIntValue)).v(gm.j.f29713a);
        } catch (Exception e10) {
            throw new IOException("error constructing MAC: " + e10.toString());
        }
    }
}
