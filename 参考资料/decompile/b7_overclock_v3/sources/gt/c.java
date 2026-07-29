package gt;

import cs.o;
import cs.p;
import gm.h0;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mm.n;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TSPIOException;
import org.bouncycastle.tsp.TSPValidationException;
import pn.s;
import so.d2;
import zn.a0;
import zn.j0;
import zn.x;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f30033a = Collections.unmodifiableList(new ArrayList());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f30034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f30035c;

    static {
        HashMap map = new HashMap();
        f30034b = map;
        HashMap map2 = new HashMap();
        f30035c = map2;
        y yVar = s.f46803f4;
        map.put(yVar.L(), org.bouncycastle.util.j.g(16));
        y yVar2 = on.b.f44365i;
        map.put(yVar2.L(), org.bouncycastle.util.j.g(20));
        y yVar3 = kn.d.f37598f;
        map.put(yVar3.L(), org.bouncycastle.util.j.g(28));
        y yVar4 = kn.d.f37592c;
        map.put(yVar4.L(), org.bouncycastle.util.j.g(32));
        y yVar5 = kn.d.f37594d;
        map.put(yVar5.L(), org.bouncycastle.util.j.g(48));
        y yVar6 = kn.d.f37596e;
        map.put(yVar6.L(), org.bouncycastle.util.j.g(64));
        y yVar7 = tn.b.f51361c;
        map.put(yVar7.L(), org.bouncycastle.util.j.g(16));
        y yVar8 = tn.b.f51360b;
        map.put(yVar8.L(), org.bouncycastle.util.j.g(20));
        y yVar9 = tn.b.f51362d;
        map.put(yVar9.L(), org.bouncycastle.util.j.g(32));
        y yVar10 = qm.a.f47452b;
        map.put(yVar10.L(), org.bouncycastle.util.j.g(32));
        y yVar11 = qn.a.f47513c;
        map.put(yVar11.L(), org.bouncycastle.util.j.g(32));
        y yVar12 = qn.a.f47514d;
        map.put(yVar12.L(), org.bouncycastle.util.j.g(64));
        y yVar13 = xm.b.f55616b0;
        map.put(yVar13.L(), org.bouncycastle.util.j.g(32));
        map2.put(yVar.L(), "MD5");
        map2.put(yVar2.L(), "SHA1");
        map2.put(yVar3.L(), "SHA224");
        map2.put(yVar4.L(), "SHA256");
        map2.put(yVar5.L(), "SHA384");
        map2.put(yVar6.L(), "SHA512");
        map2.put(s.B3.L(), "SHA1");
        map2.put(s.K3.L(), "SHA224");
        map2.put(s.H3.L(), "SHA256");
        map2.put(s.I3.L(), "SHA384");
        map2.put(s.J3.L(), "SHA512");
        map2.put(yVar7.L(), "RIPEMD128");
        map2.put(yVar8.L(), "RIPEMD160");
        map2.put(yVar9.L(), "RIPEMD256");
        map2.put(yVar10.L(), "GOST3411");
        map2.put(yVar11.L(), "GOST3411-2012-256");
        map2.put(yVar12.L(), "GOST3411-2012-512");
        map2.put(yVar13.L(), "SM3");
    }

    public static void a(a0 a0Var, y yVar, boolean z10, gm.h hVar) throws TSPIOException {
        try {
            a0Var.a(yVar, z10, hVar);
        } catch (IOException e10) {
            throw new TSPIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public static int b(String str) throws TSPException {
        Integer num = (Integer) f30034b.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new TSPException("digest algorithm cannot be found.");
    }

    public static List c(z zVar) {
        return zVar == null ? f30033a : Collections.unmodifiableList(Arrays.asList(zVar.B()));
    }

    public static Collection d(d2 d2Var, p pVar) throws TSPValidationException {
        ArrayList arrayList = new ArrayList();
        mm.b bVarR = d2Var.r();
        if (bVarR != null) {
            gm.i iVarE = bVarR.e(s.f46862z5);
            for (int i10 = 0; i10 < iVarE.i(); i10++) {
                h0 h0VarY = ((mm.a) iVarE.g(i10)).y();
                for (int i11 = 0; i11 < h0VarY.size(); i11++) {
                    try {
                        h hVar = new h(n.A(h0VarY.J(i11)));
                        j jVarI = hVar.i();
                        o oVarA = pVar.a(jVarI.f());
                        OutputStream outputStreamB = oVarA.b();
                        outputStreamB.write(d2Var.n());
                        outputStreamB.close();
                        if (!org.bouncycastle.util.a.I(oVarA.c(), jVarI.h())) {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                        arrayList.add(hVar);
                    } catch (OperatorCreationException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static void e(X509CertificateHolder x509CertificateHolder) throws TSPValidationException {
        if (x509CertificateHolder.y().J() != 3) {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
        zn.y yVarB = x509CertificateHolder.b(zn.y.f59080x);
        if (yVarB == null) {
            throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
        }
        if (!yVarB.D()) {
            throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
        }
        x xVarZ = x.z(yVarB.C());
        if (!xVarZ.B(j0.f58785k) || xVarZ.size() != 1) {
            throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
        }
    }
}
