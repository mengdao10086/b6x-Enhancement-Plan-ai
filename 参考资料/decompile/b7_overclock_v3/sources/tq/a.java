package tq;

import gm.d2;
import gm.f2;
import gm.j;
import gm.t;
import gm.y;
import gm.z;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Objects;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import pn.a0;
import pn.s;
import pn.w;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends AlgorithmParametersSpi {

    /* JADX INFO: renamed from: tq.a$a, reason: collision with other inner class name */
    public static class C0586a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OAEPParameterSpec f51572a;

        @Override // tq.a
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == OAEPParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.f51572a;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            y yVarB = br.d.b(this.f51572a.getDigestAlgorithm());
            d2 d2Var = d2.f29657b;
            try {
                return new w(new zn.b(yVarB, d2Var), new zn.b(s.E3, new zn.b(br.d.b(((MGF1ParameterSpec) this.f51572a.getMGFParameters()).getDigestAlgorithm()), d2Var)), new zn.b(s.F3, new f2(((PSource.PSpecified) this.f51572a.getPSource()).getValue()))).v(j.f29713a);
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding OAEPParameters");
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
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
            }
            this.f51572a = (OAEPParameterSpec) algorithmParameterSpec;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            try {
                w wVarY = w.y(bArr);
                if (wVarY.z().x().C(s.E3)) {
                    this.f51572a = new OAEPParameterSpec(org.bouncycastle.jcajce.util.f.a(wVarY.x().x()), OAEPParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(org.bouncycastle.jcajce.util.f.a(zn.b.z(wVarY.z().A()).x())), new PSource.PSpecified(z.I(wVarY.A().A()).J()));
                    return;
                }
                throw new IOException("unknown mask generation function: " + wVarY.z().x());
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            } catch (ClassCastException unused2) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format " + str);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "OAEP Parameters";
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PSSParameterSpec f51573a;

        @Override // tq.a
        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == PSSParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.f51573a;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            PSSParameterSpec pSSParameterSpec = this.f51573a;
            y yVarB = br.d.b(pSSParameterSpec.getDigestAlgorithm());
            d2 d2Var = d2.f29657b;
            zn.b bVar = new zn.b(yVarB, d2Var);
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) pSSParameterSpec.getMGFParameters();
            if (mGF1ParameterSpec != null) {
                return new a0(bVar, new zn.b(s.E3, new zn.b(br.d.b(mGF1ParameterSpec.getDigestAlgorithm()), d2Var)), new t(pSSParameterSpec.getSaltLength()), new t(pSSParameterSpec.getTrailerField())).v(j.f29713a);
            }
            return new a0(bVar, new zn.b(pSSParameterSpec.getMGFAlgorithm().equals("SHAKE128") ? kn.d.f37612m : kn.d.f37614n), new t(pSSParameterSpec.getSaltLength()), new t(pSSParameterSpec.getTrailerField())).v(j.f29713a);
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (!(algorithmParameterSpec instanceof PSSParameterSpec)) {
                throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
            }
            this.f51573a = (PSSParameterSpec) algorithmParameterSpec;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            try {
                a0 a0VarY = a0.y(bArr);
                y yVarX = a0VarY.z().x();
                if (yVarX.C(s.E3)) {
                    this.f51573a = new PSSParameterSpec(org.bouncycastle.jcajce.util.f.a(a0VarY.x().x()), PSSParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(org.bouncycastle.jcajce.util.f.a(zn.b.z(a0VarY.z().A()).x())), a0VarY.A().intValue(), a0VarY.B().intValue());
                    return;
                }
                y yVar = kn.d.f37612m;
                if (!yVarX.C(yVar) && !yVarX.C(kn.d.f37614n)) {
                    throw new IOException("unknown mask generation function: " + a0VarY.z().x());
                }
                this.f51573a = new PSSParameterSpec(org.bouncycastle.jcajce.util.f.a(a0VarY.x().x()), yVarX.C(yVar) ? "SHAKE128" : "SHAKE256", null, a0VarY.A().intValue(), a0VarY.B().intValue());
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            } catch (ClassCastException unused2) {
                throw new IOException("Not a valid PSS Parameter encoding.");
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
            return "PSS Parameters";
        }
    }

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
