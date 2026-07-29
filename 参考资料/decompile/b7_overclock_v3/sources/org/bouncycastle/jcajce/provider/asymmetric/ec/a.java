package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.j;
import co.l;
import co.n;
import gm.d2;
import gm.u;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class a extends AlgorithmParametersSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECParameterSpec f44930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f44931b;

    public boolean a(String str) {
        return str == null || str.equals("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        j jVar;
        if (!a(str)) {
            throw new IOException("Unknown parameters format in AlgorithmParameters object: " + str);
        }
        ECParameterSpec eCParameterSpec = this.f44930a;
        if (eCParameterSpec == null) {
            jVar = new j((u) d2.f29657b);
        } else {
            String str2 = this.f44931b;
            if (str2 != null) {
                jVar = new j(i.l(str2));
            } else {
                gr.e eVarG = org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
                jVar = new j(new l(eVarG.a(), new n(eVarG.b(), false), eVarG.d(), eVarG.c(), eVarG.e()));
            }
        }
        return jVar.getEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.f44930a;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.f44931b;
            if (str != null) {
                y yVarL = i.l(str);
                return yVarL != null ? new ECGenParameterSpec(yVarL.L()) : new ECGenParameterSpec(this.f44931b);
            }
            y yVarK = i.k(org.bouncycastle.jcajce.provider.asymmetric.util.h.g(this.f44930a));
            if (yVarK != null) {
                return new ECGenParameterSpec(yVarK.L());
            }
        }
        throw new InvalidParameterSpecException("EC AlgorithmParameters cannot convert to " + cls.getName());
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof ECGenParameterSpec)) {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                this.f44931b = algorithmParameterSpec instanceof gr.d ? ((gr.d) algorithmParameterSpec).c() : null;
                this.f44930a = (ECParameterSpec) algorithmParameterSpec;
                return;
            } else {
                throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
            }
        }
        ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
        l lVarB = b.b(eCGenParameterSpec, BouncyCastleProvider.f45330c);
        if (lVarB != null) {
            this.f44931b = eCGenParameterSpec.getName();
            ECParameterSpec eCParameterSpecJ = org.bouncycastle.jcajce.provider.asymmetric.util.h.j(lVarB);
            this.f44930a = new gr.d(this.f44931b, eCParameterSpecJ.getCurve(), eCParameterSpecJ.getGenerator(), eCParameterSpecJ.getOrder(), BigInteger.valueOf(eCParameterSpecJ.getCofactor()));
        } else {
            throw new InvalidParameterSpecException("EC curve name not recognized: " + eCGenParameterSpec.getName());
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (!a(str)) {
            throw new IOException("Unknown encoded parameters format in AlgorithmParameters object: " + str);
        }
        j jVarY = j.y(bArr);
        ir.e eVarL = org.bouncycastle.jcajce.provider.asymmetric.util.h.l(BouncyCastleProvider.f45330c, jVarY);
        if (jVarY.B()) {
            y yVarN = y.N(jVarY.z());
            String strD = co.e.d(yVarN);
            this.f44931b = strD;
            if (strD == null) {
                this.f44931b = yVarN.L();
            }
        }
        this.f44930a = org.bouncycastle.jcajce.provider.asymmetric.util.h.i(jVarY, eVarL);
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "EC Parameters";
    }
}
