package gt;

import cs.o;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSAttributeTableGenerationException;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.tsp.TSPException;
import pn.s;
import so.b2;
import so.e0;
import so.m0;
import zn.a0;
import zn.b0;
import zn.c0;
import zn.h0;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f30060n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f30061o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f30062p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f30063q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f30064r = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Locale f30066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f30069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b0 f30071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y f30072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f30073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f30074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f30075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f30076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b2 f30077m;

    public class a implements so.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b2 f30078g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ vm.c f30079h;

        public a(b2 b2Var, vm.c cVar) {
            this.f30078g = b2Var;
            this.f30079h = cVar;
        }

        @Override // so.d
        public mm.b a(Map map) throws CMSAttributeTableGenerationException {
            mm.b bVarA = this.f30078g.j().a(map);
            y yVar = s.f46853w5;
            return bVarA.d(yVar) == null ? bVarA.a(yVar, new vm.g(this.f30079h)) : bVarA;
        }
    }

    public class b implements so.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b2 f30081g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ vm.d f30082h;

        public b(b2 b2Var, vm.d dVar) {
            this.f30081g = b2Var;
            this.f30082h = dVar;
        }

        @Override // so.d
        public mm.b a(Map map) throws CMSAttributeTableGenerationException {
            mm.b bVarA = this.f30081g.j().a(map);
            y yVar = s.f46856x5;
            return bVarA.d(yVar) == null ? bVarA.a(yVar, new vm.h(this.f30082h)) : bVarA;
        }
    }

    public i(b2 b2Var, o oVar, y yVar) throws TSPException, IllegalArgumentException {
        this(b2Var, oVar, yVar, false);
    }

    public i(b2 b2Var, o oVar, y yVar, boolean z10) throws TSPException, IllegalArgumentException {
        b2 b2Var2;
        this.f30065a = 0;
        this.f30066b = null;
        this.f30067c = -1;
        this.f30068d = -1;
        this.f30069e = -1;
        this.f30070f = false;
        this.f30071g = null;
        this.f30073i = new ArrayList();
        this.f30074j = new ArrayList();
        this.f30075k = new ArrayList();
        this.f30076l = new HashMap();
        this.f30077m = b2Var;
        this.f30072h = yVar;
        if (!b2Var.l()) {
            throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
        }
        X509CertificateHolder x509CertificateHolderB = b2Var.b();
        c.e(x509CertificateHolderB);
        try {
            OutputStream outputStreamB = oVar.b();
            outputStreamB.write(x509CertificateHolderB.getEncoded());
            outputStreamB.close();
            if (oVar.a().x().C(on.b.f44365i)) {
                b2Var2 = new b2(b2Var, new a(b2Var, new vm.c(oVar.c(), z10 ? new h0(new c0(new b0(x509CertificateHolderB.f())), x509CertificateHolderB.l()) : null)), b2Var.k());
            } else {
                b2Var2 = new b2(b2Var, new b(b2Var, new vm.d(new zn.b(oVar.a().x()), oVar.c(), z10 ? new h0(new c0(new b0(x509CertificateHolderB.f())), new t(x509CertificateHolderB.l())) : null)), b2Var.k());
            }
            this.f30077m = b2Var2;
        } catch (IOException e10) {
            throw new TSPException("Exception processing certificate.", e10);
        }
    }

    public void a(org.bouncycastle.util.s sVar) {
        this.f30075k.addAll(sVar.a(null));
    }

    public void b(org.bouncycastle.util.s sVar) {
        this.f30074j.addAll(sVar.a(null));
    }

    public void c(org.bouncycastle.util.s sVar) {
        this.f30073i.addAll(sVar.a(null));
    }

    public void d(y yVar, org.bouncycastle.util.s sVar) {
        this.f30076l.put(yVar, sVar.a(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[PHI: r4
  0x0072: PHI (r4v1 int) = (r4v0 int), (r4v4 int) binds: [B:23:0x0070, B:20:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final gm.o e(java.util.Date r6) throws org.bouncycastle.tsp.TSPException {
        /*
            r5 = this;
            java.util.Locale r0 = r5.f30066b
            java.lang.String r1 = "yyyyMMddHHmmss.SSS"
            if (r0 != 0) goto Lc
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r1)
            goto L13
        Lc:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r2 = r5.f30066b
            r0.<init>(r1, r2)
        L13:
            java.util.SimpleTimeZone r1 = new java.util.SimpleTimeZone
            r2 = 0
            java.lang.String r3 = "Z"
            r1.<init>(r2, r3)
            r0.setTimeZone(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = r0.format(r6)
            r1.<init>(r6)
            java.lang.String r6 = "."
            int r6 = r1.indexOf(r6)
            if (r6 >= 0) goto L3c
            r1.append(r3)
            gm.o r6 = new gm.o
            java.lang.String r0 = r1.toString()
            r6.<init>(r0)
            return r6
        L3c:
            int r0 = r5.f30065a
            r2 = 1
            if (r0 == r2) goto L6a
            r4 = 2
            if (r0 == r4) goto L61
            r4 = 3
            if (r0 != r4) goto L48
            goto L79
        L48:
            org.bouncycastle.tsp.TSPException r6 = new org.bouncycastle.tsp.TSPException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown time-stamp resolution: "
            r0.append(r1)
            int r1 = r5.f30065a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L61:
            int r0 = r1.length()
            int r4 = r6 + 3
            if (r0 <= r4) goto L79
            goto L72
        L6a:
            int r0 = r1.length()
            int r4 = r6 + 2
            if (r0 <= r4) goto L79
        L72:
            int r0 = r1.length()
            r1.delete(r4, r0)
        L79:
            int r0 = r1.length()
            int r0 = r0 - r2
            char r0 = r1.charAt(r0)
            r4 = 48
            if (r0 != r4) goto L8f
            int r0 = r1.length()
            int r0 = r0 - r2
            r1.deleteCharAt(r0)
            goto L79
        L8f:
            int r0 = r1.length()
            int r0 = r0 - r2
            if (r0 != r6) goto L9e
            int r6 = r1.length()
            int r6 = r6 - r2
            r1.deleteCharAt(r6)
        L9e:
            r1.append(r3)
            gm.o r6 = new gm.o
            java.lang.String r0 = r1.toString()
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: gt.i.e(java.util.Date):gm.o");
    }

    public h f(d dVar, BigInteger bigInteger, Date date) throws TSPException {
        return g(dVar, bigInteger, date, null);
    }

    public h g(d dVar, BigInteger bigInteger, Date date, z zVar) throws TSPException {
        z zVarE;
        un.h hVar = new un.h(dVar.h(), dVar.j());
        int i10 = this.f30067c;
        un.a aVar = (i10 > 0 || this.f30068d > 0 || this.f30069e > 0) ? new un.a(i10 > 0 ? new t(this.f30067c) : null, this.f30068d > 0 ? new t(this.f30068d) : null, this.f30069e > 0 ? new t(this.f30069e) : null) : null;
        boolean z10 = this.f30070f;
        gm.f fVarK = z10 ? gm.f.K(z10) : null;
        t tVar = dVar.l() != null ? new t(dVar.l()) : null;
        y yVarM = this.f30072h;
        if (dVar.m() != null) {
            yVarM = dVar.m();
        }
        y yVar = yVarM;
        z zVarG = dVar.g();
        if (zVar != null) {
            a0 a0Var = new a0();
            if (zVarG != null) {
                Enumeration enumerationI = zVarG.I();
                while (enumerationI.hasMoreElements()) {
                    a0Var.c(zVarG.z(y.N(enumerationI.nextElement())));
                }
            }
            Enumeration enumerationI2 = zVar.I();
            while (enumerationI2.hasMoreElements()) {
                a0Var.c(zVar.z(y.N(enumerationI2.nextElement())));
            }
            zVarE = a0Var.e();
        } else {
            zVarE = zVarG;
        }
        un.j jVar = new un.j(yVar, hVar, new t(bigInteger), this.f30065a == 0 ? this.f30066b == null ? new gm.o(date) : new gm.o(date, this.f30066b) : e(date), aVar, fVarK, tVar, this.f30071g, zVarE);
        try {
            m0 m0Var = new m0();
            if (dVar.b()) {
                m0Var.f(new org.bouncycastle.util.e(this.f30073i));
                m0Var.b(new org.bouncycastle.util.e(this.f30075k));
            }
            m0Var.d(new org.bouncycastle.util.e(this.f30074j));
            if (!this.f30076l.isEmpty()) {
                for (y yVar2 : this.f30076l.keySet()) {
                    m0Var.h(yVar2, new org.bouncycastle.util.e((Collection) this.f30076l.get(yVar2)));
                }
            }
            m0Var.i(this.f30077m);
            return new h(m0Var.n(new e0(s.X4, jVar.v(gm.j.f29713a)), true));
        } catch (IOException e10) {
            throw new TSPException("Exception encoding info", e10);
        } catch (CMSException e11) {
            throw new TSPException("Error generating time-stamp token", e11);
        }
    }

    public void h(int i10) {
        this.f30069e = i10;
    }

    public void i(int i10) {
        this.f30068d = i10;
    }

    public void j(int i10) {
        this.f30067c = i10;
    }

    public void k(Locale locale) {
        this.f30066b = locale;
    }

    public void l(boolean z10) {
        this.f30070f = z10;
    }

    public void m(int i10) {
        this.f30065a = i10;
    }

    public void n(b0 b0Var) {
        this.f30071g = b0Var;
    }
}
