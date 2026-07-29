package qq;

import gm.c0;
import gr.j;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public class b extends ar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f47598a;

    @Override // ar.b
    public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == j.class || cls == AlgorithmParameterSpec.class) {
            return this.f47598a;
        }
        if (cls == DHParameterSpec.class) {
            return new DHParameterSpec(this.f47598a.b(), this.f47598a.a());
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        try {
            return new on.a(this.f47598a.b(), this.f47598a.a()).v(gm.j.f29713a);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding ElGamalParameters");
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) {
        if (a(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        boolean z10 = algorithmParameterSpec instanceof j;
        if (!z10 && !(algorithmParameterSpec instanceof DHParameterSpec)) {
            throw new InvalidParameterSpecException("DHParameterSpec required to initialise a ElGamal algorithm parameters object");
        }
        if (z10) {
            this.f47598a = (j) algorithmParameterSpec;
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.f47598a = new j(dHParameterSpec.getP(), dHParameterSpec.getG());
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        try {
            on.a aVarY = on.a.y(c0.D(bArr));
            this.f47598a = new j(aVarY.z(), aVarY.x());
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
        } catch (ClassCastException unused2) {
            throw new IOException("Not a valid ElGamal Parameter encoding.");
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
        return "ElGamal Parameters";
    }
}
