package zq;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class u {

    public static class a extends ar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pn.o f59627a;

        @Override // ar.b
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new PBEParameterSpec(this.f59627a.z(), this.f59627a.y().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF1 PBE parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            try {
                return this.f59627a.v(gm.j.f29713a);
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
                throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF1 PBE parameters algorithm parameters object");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            this.f59627a = new pn.o(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.f59627a = pn.o.x(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!a(str)) {
                throw new IOException("Unknown parameters format in PBKDF2 parameters object");
            }
            engineInit(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF1 Parameters";
        }
    }

    public static class b extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59628a = u.class.getName();

        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("AlgorithmParameters.PBKDF1", f59628a + "$AlgParams");
            aVar.h("Alg.Alias.AlgorithmParameters." + pn.s.Q3, "PBKDF1");
            aVar.h("Alg.Alias.AlgorithmParameters." + pn.s.S3, "PBKDF1");
            aVar.h("Alg.Alias.AlgorithmParameters." + pn.s.T3, "PBKDF1");
            aVar.h("Alg.Alias.AlgorithmParameters." + pn.s.U3, "PBKDF1");
            aVar.h("Alg.Alias.AlgorithmParameters." + pn.s.V3, "PBKDF1");
        }
    }
}
