package zq;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class w {

    public static class a extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pn.r f59635a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new PBEParameterSpec(this.f59635a.x(), this.f59635a.z().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PKCS12 PBE parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            try {
                return this.f59635a.v(gm.j.f29713a);
            } catch (IOException e10) {
                throw new RuntimeException("Oooops! " + e10.toString());
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
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PKCS12 PBE parameters algorithm parameters object");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            this.f59635a = new pn.r(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59635a = pn.r.y(gm.c0.D(bArr));
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("Unknown parameters format in PKCS12 PBE parameters object");
            }
            engineInit(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PKCS12 PBE Parameters";
        }
    }

    public static class b extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59636a = w.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("AlgorithmParameters.PKCS12PBE", f59636a + "$AlgParams");
        }
    }
}
