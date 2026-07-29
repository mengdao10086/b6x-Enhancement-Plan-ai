package rq;

import gm.c0;
import gm.f0;
import gm.j;
import gm.y;
import gr.n;
import gr.p;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Objects;
import qm.g;

/* JADX INFO: loaded from: classes7.dex */
public class b extends AlgorithmParametersSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f49119a;

    public boolean a(String str) {
        return str == null || str.equals("ASN.1");
    }

    public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == p.class || cls == AlgorithmParameterSpec.class) {
            return this.f49119a;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        try {
            return new g(new y(this.f49119a.c()), new y(this.f49119a.d()), new y(this.f49119a.b())).v(j.f29713a);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding GOST3410Parameters");
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
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        Objects.requireNonNull(cls, "argument to getParameterSpec must not be null");
        return b(cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof n)) {
            throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
        }
        this.f49119a = (n) algorithmParameterSpec;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        try {
            this.f49119a = n.e(g.A((f0) c0.D(bArr)));
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
        } catch (ClassCastException unused2) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
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
        return "GOST3410 Parameters";
    }
}
