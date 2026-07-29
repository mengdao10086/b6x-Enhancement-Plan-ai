package so;

import gm.l2;
import gm.n2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class n0 extends r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q0 f50232l = q0.f50286a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final cs.j f50233m = new cs.j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mm.t0 f50234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.y f50235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s0 f50236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f50237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<zn.b> f50238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e2 f50239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.h0 f50240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.h0 f50241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50242k;

    public n0(cs.p pVar, InputStream inputStream) throws CMSException {
        this(pVar, (s0) null, inputStream);
    }

    public n0(cs.p pVar, s0 s0Var, InputStream inputStream) throws CMSException {
        s0 p1Var;
        super(inputStream);
        try {
            this.f50236e = s0Var;
            this.f50234c = mm.t0.e(this.f50297a.a(16));
            this.f50237f = new HashMap();
            gm.i0 i0VarC = this.f50234c.c();
            HashSet hashSet = new HashSet();
            while (true) {
                gm.h object = i0VarC.readObject();
                if (object == null) {
                    break;
                }
                zn.b bVarZ = zn.b.z(object);
                hashSet.add(bVarZ);
                try {
                    cs.o oVarA = pVar.a(bVarZ);
                    if (oVarA != null) {
                        this.f50237f.put(bVarZ.x(), oVarA);
                    }
                } catch (OperatorCreationException unused) {
                }
            }
            this.f50238g = Collections.unmodifiableSet(hashSet);
            mm.o oVarD = this.f50234c.d();
            gm.h hVarA = oVarD.a(4);
            if (hVarA instanceof gm.a0) {
                p1Var = new s0(oVarD.b(), ((gm.a0) hVarA).a());
                if (this.f50236e == null) {
                    this.f50236e = p1Var;
                } else {
                    p1Var.a();
                }
            } else if (hVarA != null) {
                p1Var = new p1(oVarD.b(), hVarA);
                if (this.f50236e == null) {
                    this.f50236e = p1Var;
                } else {
                    p1Var.a();
                }
            }
            this.f50235d = s0Var == null ? oVarD.b() : this.f50236e.c();
        } catch (IOException e10) {
            throw new CMSException("io exception: " + e10.getMessage(), e10);
        }
    }

    public n0(cs.p pVar, s0 s0Var, byte[] bArr) throws CMSException {
        this(pVar, s0Var, new ByteArrayInputStream(bArr));
    }

    public n0(cs.p pVar, byte[] bArr) throws CMSException {
        this(pVar, new ByteArrayInputStream(bArr));
    }

    public static gm.h0 b(gm.i0 i0Var) {
        if (i0Var == null) {
            return null;
        }
        return gm.h0.I(i0Var.b());
    }

    public static void l(mm.o oVar, OutputStream outputStream) throws IOException {
        gm.a0 a0Var = (gm.a0) oVar.a(4);
        if (a0Var != null) {
            m(a0Var, outputStream);
        }
    }

    public static void m(gm.a0 a0Var, OutputStream outputStream) throws IOException {
        OutputStream outputStreamE = t0.e(outputStream, 0, true, 0);
        kt.c.b(a0Var.a(), outputStreamE);
        outputStreamE.close();
    }

    public static OutputStream o(InputStream inputStream, org.bouncycastle.util.s sVar, org.bouncycastle.util.s sVar2, org.bouncycastle.util.s sVar3, OutputStream outputStream) throws CMSException, IOException {
        mm.t0 t0VarE = mm.t0.e(new mm.o((gm.g0) new gm.j0(inputStream).j()).a(16));
        gm.j1 j1Var = new gm.j1(outputStream);
        j1Var.f(mm.k.J2);
        gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
        j1Var2.f(t0VarE.g());
        j1Var2.a().write(t0VarE.c().b().getEncoded());
        mm.o oVarD = t0VarE.d();
        gm.j1 j1Var3 = new gm.j1(j1Var2.a());
        j1Var3.f(oVarD.b());
        l(oVarD, j1Var3.a());
        j1Var3.g();
        b(t0VarE.a());
        b(t0VarE.b());
        if (sVar != null || sVar3 != null) {
            ArrayList arrayList = new ArrayList();
            if (sVar != null) {
                arrayList.addAll(t0.j(sVar));
            }
            if (sVar3 != null) {
                arrayList.addAll(t0.h(sVar3));
            }
            gm.h0 h0VarF = t0.f(arrayList);
            if (h0VarF.size() > 0) {
                j1Var2.a().write(new n2(false, 0, (gm.h) h0VarF).getEncoded());
            }
        }
        if (sVar2 != null) {
            gm.h0 h0VarF2 = t0.f(t0.i(sVar2));
            if (h0VarF2.size() > 0) {
                j1Var2.a().write(new n2(false, 1, (gm.h) h0VarF2).getEncoded());
            }
        }
        j1Var2.a().write(t0VarE.f().b().getEncoded());
        j1Var2.g();
        j1Var.g();
        return outputStream;
    }

    public static OutputStream p(InputStream inputStream, e2 e2Var, OutputStream outputStream) throws CMSException, IOException {
        mm.t0 t0VarE = mm.t0.e(new mm.o((gm.g0) new gm.j0(inputStream).j()).a(16));
        gm.j1 j1Var = new gm.j1(outputStream);
        j1Var.f(mm.k.J2);
        gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
        j1Var2.f(t0VarE.g());
        t0VarE.c().b();
        gm.i iVar = new gm.i();
        Iterator<d2> it2 = e2Var.b().iterator();
        while (it2.hasNext()) {
            iVar.a(q0.f50286a.b(it2.next().i(), f50233m));
        }
        j1Var2.a().write(new l2(iVar).getEncoded());
        mm.o oVarD = t0VarE.d();
        gm.j1 j1Var3 = new gm.j1(j1Var2.a());
        j1Var3.f(oVarD.b());
        l(oVarD, j1Var3.a());
        j1Var3.g();
        q(j1Var2, t0VarE.a(), 0);
        q(j1Var2, t0VarE.b(), 1);
        gm.i iVar2 = new gm.i();
        Iterator<d2> it3 = e2Var.b().iterator();
        while (it3.hasNext()) {
            iVar2.a(it3.next().v());
        }
        j1Var2.a().write(new l2(iVar2).getEncoded());
        j1Var2.g();
        j1Var.g();
        return outputStream;
    }

    public static void q(gm.p pVar, gm.i0 i0Var, int i10) throws IOException {
        gm.h0 h0VarB = b(i0Var);
        if (h0VarB != null) {
            boolean z10 = i0Var instanceof gm.m1;
            OutputStream outputStreamA = pVar.a();
            if (z10) {
                outputStreamA.write(new gm.n1(false, i10, (gm.h) h0VarB).getEncoded());
            } else {
                outputStreamA.write(new n2(false, i10, (gm.h) h0VarB).getEncoded());
            }
        }
    }

    public org.bouncycastle.util.s c() throws CMSException {
        n();
        return f50232l.c(this.f50240i);
    }

    public org.bouncycastle.util.s d() throws CMSException {
        n();
        return f50232l.d(this.f50241j);
    }

    public org.bouncycastle.util.s e() throws CMSException {
        n();
        return f50232l.e(this.f50240i);
    }

    public Set<zn.b> f() {
        return this.f50238g;
    }

    public org.bouncycastle.util.s g(gm.y yVar) throws CMSException {
        n();
        return f50232l.g(yVar, this.f50241j);
    }

    public s0 h() {
        if (this.f50236e == null) {
            return null;
        }
        return new s0(this.f50236e.c(), t0.b(this.f50237f.values(), this.f50236e.b()));
    }

    public String i() {
        return this.f50235d.L();
    }

    public e2 j() throws CMSException {
        if (this.f50239h == null) {
            n();
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            for (Object obj : this.f50237f.keySet()) {
                map.put(obj, ((cs.o) this.f50237f.get(obj)).c());
            }
            try {
                gm.i0 i0VarF = this.f50234c.f();
                while (true) {
                    gm.h object = i0VarF.readObject();
                    if (object == null) {
                        break;
                    }
                    mm.v0 v0VarB = mm.v0.B(object.b());
                    arrayList.add(new d2(v0VarB, this.f50235d, null, (byte[]) map.get(v0VarB.y().x())));
                }
                this.f50239h = new e2(arrayList);
            } catch (IOException e10) {
                throw new CMSException("io exception: " + e10.getMessage(), e10);
            }
        }
        return this.f50239h;
    }

    public int k() {
        return this.f50234c.g().Q();
    }

    public final void n() throws CMSException {
        if (this.f50242k) {
            return;
        }
        this.f50242k = true;
        try {
            this.f50240i = b(this.f50234c.a());
            this.f50241j = b(this.f50234c.b());
        } catch (IOException e10) {
            throw new CMSException("problem parsing cert/crl sets", e10);
        }
    }
}
