package sq;

import gm.c0;
import gm.f;
import gm.f0;
import gm.f2;
import gm.h;
import gm.i;
import gm.j;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.z;
import gr.r;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Enumeration;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class a extends AlgorithmParametersSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f50383a;

    public boolean a(String str) {
        return str == null || str.equals("ASN.1");
    }

    public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
        if (cls == r.class || cls == AlgorithmParameterSpec.class) {
            return this.f50383a;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }

    @Override // java.security.AlgorithmParametersSpi
    public byte[] engineGetEncoded() {
        try {
            i iVar = new i();
            if (this.f50383a.b() != null) {
                iVar.a(new n2(false, 0, (h) new f2(this.f50383a.b())));
            }
            if (this.f50383a.c() != null) {
                iVar.a(new n2(false, 1, (h) new f2(this.f50383a.c())));
            }
            iVar.a(new t(this.f50383a.d()));
            if (this.f50383a.e() != null) {
                i iVar2 = new i();
                iVar2.a(new t(this.f50383a.a()));
                iVar2.a(new f2(this.f50383a.e()));
                iVar.a(new j2(iVar2));
            }
            iVar.a(this.f50383a.f() ? f.f29675f : f.f29674e);
            return new j2(iVar).v(j.f29713a);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding IESParameters");
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
        if (!(algorithmParameterSpec instanceof r)) {
            throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
        }
        this.f50383a = (r) algorithmParameterSpec;
    }

    @Override // java.security.AlgorithmParametersSpi
    public void engineInit(byte[] bArr) throws IOException {
        try {
            f0 f0Var = (f0) c0.D(bArr);
            if (f0Var.size() > 5) {
                throw new IOException("sequence too big");
            }
            Enumeration enumerationL = f0Var.L();
            BigInteger bigInteger = null;
            BigInteger bigIntegerK = null;
            byte[] bArrJ = null;
            byte[] bArrJ2 = null;
            byte[] bArrJ3 = null;
            boolean zL = false;
            while (enumerationL.hasMoreElements()) {
                Object objNextElement = enumerationL.nextElement();
                if (objNextElement instanceof n0) {
                    n0 n0VarT = n0.T(objNextElement);
                    if (n0VarT.q() == 0) {
                        bArrJ = z.H(n0VarT, false).J();
                    } else if (n0VarT.q() == 1) {
                        bArrJ2 = z.H(n0VarT, false).J();
                    }
                } else if (objNextElement instanceof t) {
                    bigIntegerK = t.I(objNextElement).K();
                } else if (objNextElement instanceof f0) {
                    f0 f0VarJ = f0.J(objNextElement);
                    BigInteger bigIntegerK2 = t.I(f0VarJ.K(0)).K();
                    bArrJ3 = z.I(f0VarJ.K(1)).J();
                    bigInteger = bigIntegerK2;
                } else if (objNextElement instanceof f) {
                    zL = f.J(objNextElement).L();
                }
            }
            this.f50383a = bigInteger != null ? new r(bArrJ, bArrJ2, bigIntegerK.intValue(), bigInteger.intValue(), bArrJ3, zL) : new r(bArrJ, bArrJ2, bigIntegerK.intValue(), -1, null, zL);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Not a valid IES Parameter encoding.");
        } catch (ClassCastException unused2) {
            throw new IOException("Not a valid IES Parameter encoding.");
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
        return "IES Parameters";
    }
}
