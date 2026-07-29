package zr;

import co.r;
import gm.c0;
import gm.d2;
import gm.f0;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.openssl.PEMException;
import pn.u;
import pn.x;
import pn.z;
import zn.c1;
import zn.s;

/* JADX INFO: loaded from: classes6.dex */
public class i extends lt.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f59658d = "CERTIFICATE REQUEST";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f59659e = "NEW CERTIFICATE REQUEST";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f59660f = "CERTIFICATE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f59661g = "TRUSTED CERTIFICATE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f59662h = "X509 CERTIFICATE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f59663i = "X509 CRL";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f59664j = "PKCS7";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f59665k = "CMS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f59666l = "ATTRIBUTE CERTIFICATE";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f59667m = "EC PARAMETERS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f59668n = "PUBLIC KEY";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f59669o = "RSA PUBLIC KEY";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f59670p = "RSA PRIVATE KEY";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f59671q = "DSA PRIVATE KEY";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f59672r = "EC PRIVATE KEY";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f59673s = "ENCRYPTED PRIVATE KEY";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f59674t = "PRIVATE KEY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f59675c;

    public class b implements zr.h {
        public b() {
        }

        @Override // zr.h
        public zr.g a(byte[] bArr) throws IOException {
            try {
                f0 f0VarJ = f0.J(bArr);
                if (f0VarJ.size() != 6) {
                    throw new PEMException("malformed sequence in DSA private key");
                }
                t tVarI = t.I(f0VarJ.K(1));
                t tVarI2 = t.I(f0VarJ.K(2));
                t tVarI3 = t.I(f0VarJ.K(3));
                t tVarI4 = t.I(f0VarJ.K(4));
                t tVarI5 = t.I(f0VarJ.K(5));
                y yVar = r.W0;
                return new zr.g(new c1(new zn.b(yVar, new s(tVarI.K(), tVarI2.K(), tVarI3.K())), tVarI4), new u(new zn.b(yVar, new s(tVarI.K(), tVarI2.K(), tVarI3.K())), tVarI5));
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new PEMException("problem creating DSA private key: " + e11.toString(), e11);
            }
        }
    }

    public class c implements lt.d {
        public c() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                c0 c0VarD = c0.D(bVar.a());
                if (c0VarD instanceof y) {
                    return c0.D(bVar.a());
                }
                if (c0VarD instanceof f0) {
                    return co.l.D(c0VarD);
                }
                return null;
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new PEMException("exception extracting EC named curve: " + e11.toString());
            }
        }
    }

    public class d implements zr.h {
        public d() {
        }

        @Override // zr.h
        public zr.g a(byte[] bArr) throws IOException {
            try {
                rn.a aVarX = rn.a.x(f0.J(bArr));
                zn.b bVar = new zn.b(r.f11174l0, aVarX.B());
                u uVar = new u(bVar, aVarX);
                return aVarX.C() != null ? new zr.g(new c1(bVar, aVarX.C().H()), uVar) : new zr.g(null, uVar);
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new PEMException("problem creating EC private key: " + e11.toString(), e11);
            }
        }
    }

    public class e implements lt.d {
        public e() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new es.k(pn.j.z(bVar.a()));
            } catch (Exception e10) {
                throw new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e10.toString(), e10);
            }
        }
    }

    public class f implements lt.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final zr.h f59680a;

        public f(zr.h hVar) {
            this.f59680a = hVar;
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            boolean z10 = false;
            String strC = null;
            for (lt.a aVar : bVar.b()) {
                if (aVar.b().equals("Proc-Type") && aVar.c().equals("4,ENCRYPTED")) {
                    z10 = true;
                } else if (aVar.b().equals("DEK-Info")) {
                    strC = aVar.c();
                }
            }
            byte[] bArrA = bVar.a();
            try {
                if (!z10) {
                    return this.f59680a.a(bArrA);
                }
                StringTokenizer stringTokenizer = new StringTokenizer(strC, ag.c.f654g);
                return new zr.e(stringTokenizer.nextToken(), jt.h.b(stringTokenizer.nextToken()), bArrA, this.f59680a);
            } catch (IOException e10) {
                if (z10) {
                    throw new PEMException("exception decoding - please check password and data.", e10);
                }
                throw new PEMException(e10.getMessage(), e10);
            } catch (IllegalArgumentException e11) {
                if (z10) {
                    throw new PEMException("exception decoding - please check password and data.", e11);
                }
                throw new PEMException(e11.getMessage(), e11);
            }
        }
    }

    public class g implements lt.d {
        public g() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new es.b(bVar.a());
            } catch (Exception e10) {
                throw new PEMException("problem parsing certrequest: " + e10.toString(), e10);
            }
        }
    }

    public class h implements lt.d {
        public h() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return mm.n.A(new gm.s(bVar.a()).n());
            } catch (Exception e10) {
                throw new PEMException("problem parsing PKCS7 object: " + e10.toString(), e10);
            }
        }
    }

    /* JADX INFO: renamed from: zr.i$i, reason: collision with other inner class name */
    public class C0702i implements lt.d {
        public C0702i() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return u.z(bVar.a());
            } catch (Exception e10) {
                throw new PEMException("problem parsing PRIVATE KEY: " + e10.toString(), e10);
            }
        }
    }

    public class j implements lt.d {
        public j() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            return c1.A(bVar.a());
        }
    }

    public class k implements zr.h {
        public k() {
        }

        @Override // zr.h
        public zr.g a(byte[] bArr) throws IOException {
            try {
                f0 f0VarJ = f0.J(bArr);
                if (f0VarJ.size() != 9) {
                    throw new PEMException("malformed sequence in RSA private key");
                }
                x xVarB = x.B(f0VarJ);
                z zVar = new z(xVarB.C(), xVarB.G());
                zn.b bVar = new zn.b(pn.s.f46854x3, d2.f29657b);
                return new zr.g(new c1(bVar, zVar), new u(bVar, xVarB));
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new PEMException("problem creating RSA private key: " + e11.toString(), e11);
            }
        }
    }

    public class l implements lt.d {
        public l() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new c1(new zn.b(pn.s.f46854x3, d2.f29657b), z.y(bVar.a()));
            } catch (IOException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new PEMException("problem extracting key: " + e11.toString(), e11);
            }
        }
    }

    public class m implements lt.d {
        public m() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            return new X509AttributeCertificateHolder(bVar.a());
        }
    }

    public class n implements lt.d {
        public n() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new X509CRLHolder(bVar.a());
            } catch (Exception e10) {
                throw new PEMException("problem parsing cert: " + e10.toString(), e10);
            }
        }
    }

    public class o implements lt.d {
        public o() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new X509CertificateHolder(bVar.a());
            } catch (Exception e10) {
                throw new PEMException("problem parsing cert: " + e10.toString(), e10);
            }
        }
    }

    public class p implements lt.d {
        public p() {
        }

        @Override // lt.d
        public Object a(lt.b bVar) throws IOException {
            try {
                return new zr.m(bVar.a());
            } catch (Exception e10) {
                throw new PEMException("problem parsing cert: " + e10.toString(), e10);
            }
        }
    }

    public i(Reader reader) {
        super(reader);
        HashMap map = new HashMap();
        this.f59675c = map;
        map.put(f59658d, new g());
        map.put(f59659e, new g());
        map.put(f59660f, new o());
        map.put(f59661g, new p());
        map.put(f59662h, new o());
        map.put(f59663i, new n());
        map.put(f59664j, new h());
        map.put(f59665k, new h());
        map.put(f59666l, new m());
        map.put(f59667m, new c());
        map.put(f59668n, new j());
        map.put(f59669o, new l());
        map.put(f59670p, new f(new k()));
        map.put(f59671q, new f(new b()));
        map.put(f59672r, new f(new d()));
        map.put(f59673s, new e());
        map.put(f59674t, new C0702i());
    }

    public Set<String> d() {
        return Collections.unmodifiableSet(this.f59675c.keySet());
    }

    public Object readObject() throws IOException {
        lt.b bVarC = c();
        if (bVarC == null) {
            return null;
        }
        String strC = bVarC.c();
        Object obj = this.f59675c.get(strC);
        if (obj != null) {
            return ((lt.d) obj).a(bVarC);
        }
        throw new IOException("unrecognised object: " + strC);
    }
}
