package ar;

import gm.c0;
import gm.f2;
import gm.z;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8872a;

    @Override // ar.b
    public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == IvParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return new IvParameterSpec(this.f8872a);
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded(String str) throws IOException {
        if (a(str)) {
            return new f2(engineGetEncoded("RAW")).getEncoded();
        }
        if (str.equals("RAW")) {
            return org.bouncycastle.util.a.p(this.f8872a);
        }
        return null;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }
        this.f8872a = ((IvParameterSpec) algorithmParameterSpec).getIV();
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        if (bArr.length % 8 != 0 && bArr[0] == 4 && bArr[1] == bArr.length - 2) {
            bArr = ((z) c0.D(bArr)).J();
        }
        this.f8872a = org.bouncycastle.util.a.p(bArr);
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (!a(str)) {
            if (!str.equals("RAW")) {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
            engineInit(bArr);
        } else {
            try {
                engineInit(((z) c0.D(bArr)).J());
            } catch (Exception e10) {
                throw new IOException("Exception decoding: " + e10);
            }
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    public String engineToString() {
        return "IV Parameters";
    }
}
