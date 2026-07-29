package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import gm.c0;
import gm.j;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Objects;
import zn.s;

/* JADX INFO: loaded from: classes7.dex */
public class b extends AlgorithmParametersSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DSAParameterSpec f44895a;

    public boolean a(String str) {
        return str == null || str.equals("ASN.1");
    }

    public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == DSAParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.f44895a;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to DSA parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        try {
            return new s(this.f44895a.getP(), this.f44895a.getQ(), this.f44895a.getG()).v(j.f29713a);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding DSAParameters");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) {
        if (a(str)) {
            return engineGetEncoded();
        }
        return null;
    }

    @Override // java.security.AlgorithmParametersSpi
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        Objects.requireNonNull(cls, "argument to getParameterSpec must not be null");
        return b(cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            throw new InvalidParameterSpecException("DSAParameterSpec required to initialise a DSA algorithm parameters object");
        }
        this.f44895a = (DSAParameterSpec) algorithmParameterSpec;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        try {
            s sVarZ = s.z(c0.D(bArr));
            this.f44895a = new DSAParameterSpec(sVarZ.A(), sVarZ.B(), sVarZ.x());
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Not a valid DSA Parameter encoding.");
        } catch (ClassCastException unused2) {
            throw new IOException("Not a valid DSA Parameter encoding.");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (a(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "DSA Parameters";
    }
}
