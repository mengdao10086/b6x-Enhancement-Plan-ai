package ar;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends AlgorithmParametersSpi {
    public boolean a(String str) {
        return str == null || str.equals("ASN.1");
    }

    public abstract AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException;

    @Override // java.security.AlgorithmParametersSpi
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        Objects.requireNonNull(cls, "argument to getParameterSpec must not be null");
        return b(cls);
    }
}
