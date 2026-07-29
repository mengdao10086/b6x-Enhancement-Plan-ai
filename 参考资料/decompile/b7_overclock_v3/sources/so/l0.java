package so;

import gm.b3;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class l0 implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q0 f50215f = q0.f50286a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final cs.j f50216g = new cs.j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.s0 f50217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.n f50218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f50219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e2 f50220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f50221e;

    public class a implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f50222a;

        public a(d0 d0Var) {
            this.f50222a = d0Var;
        }

        @Override // so.r0
        public gm.y a() {
            return l0.this.f50217a.C().y();
        }

        @Override // so.d0
        public Object b() {
            return this.f50222a.b();
        }

        @Override // so.d0
        public void d(OutputStream outputStream) throws CMSException, IOException {
            this.f50222a.d(outputStream);
        }
    }

    public l0(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public l0(Map map, mm.n nVar) throws CMSException {
        this.f50221e = map;
        this.f50218b = nVar;
        this.f50217a = j();
    }

    public l0(Map map, byte[] bArr) throws CMSException {
        this(map, t0.v(bArr));
    }

    public l0(mm.n nVar) throws CMSException {
        this.f50218b = nVar;
        mm.s0 s0VarJ = j();
        this.f50217a = s0VarJ;
        gm.h hVarX = s0VarJ.C().x();
        if (hVarX != null) {
            this.f50219c = hVarX instanceof gm.z ? new e0(this.f50217a.C().y(), ((gm.z) hVarX).J()) : new o1(this.f50217a.C().y(), hVarX);
        } else {
            this.f50219c = null;
        }
    }

    public l0(d0 d0Var, InputStream inputStream) throws CMSException {
        this(d0Var, t0.u(new gm.s(inputStream)));
    }

    public l0(d0 d0Var, mm.n nVar) throws CMSException {
        if (d0Var instanceof r0) {
            this.f50219c = (r0) d0Var;
        } else {
            this.f50219c = new a(d0Var);
        }
        this.f50218b = nVar;
        this.f50217a = j();
    }

    public l0(d0 d0Var, byte[] bArr) throws CMSException {
        this(d0Var, t0.v(bArr));
    }

    public l0(l0 l0Var) {
        this.f50217a = l0Var.f50217a;
        this.f50218b = l0Var.f50218b;
        this.f50219c = l0Var.f50219c;
        this.f50220d = l0Var.f50220d;
    }

    public l0(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public static l0 a(l0 l0Var, zn.b bVar) {
        Set<zn.b> setE = l0Var.e();
        zn.b bVarB = q0.f50286a.b(bVar, f50216g);
        if (setE.contains(bVarB)) {
            return l0Var;
        }
        l0 l0Var2 = new l0(l0Var);
        HashSet hashSet = new HashSet();
        Iterator<zn.b> it2 = setE.iterator();
        while (it2.hasNext()) {
            hashSet.add(q0.f50286a.b(it2.next(), f50216g));
        }
        hashSet.add(bVarB);
        gm.h0 h0VarD = t0.d(hashSet);
        gm.f0 f0Var = (gm.f0) l0Var.f50217a.b();
        gm.i iVar = new gm.i();
        iVar.a(f0Var.K(0));
        iVar.a(h0VarD);
        for (int i10 = 2; i10 != f0Var.size(); i10++) {
            iVar.a(f0Var.K(i10));
        }
        l0Var2.f50217a = mm.s0.D(new gm.i1(iVar));
        l0Var2.f50218b = new mm.n(l0Var2.f50218b.y(), l0Var2.f50217a);
        return l0Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static so.l0 o(so.l0 r8, org.bouncycastle.util.s r9, org.bouncycastle.util.s r10, org.bouncycastle.util.s r11) throws org.bouncycastle.cms.CMSException {
        /*
            so.l0 r0 = new so.l0
            r0.<init>(r8)
            r1 = 0
            if (r9 != 0) goto La
            if (r10 == 0) goto L2d
        La:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r9 == 0) goto L18
            java.util.List r9 = so.t0.j(r9)
            r2.addAll(r9)
        L18:
            if (r10 == 0) goto L21
            java.util.List r9 = so.t0.h(r10)
            r2.addAll(r9)
        L21:
            gm.h0 r9 = so.t0.f(r2)
            int r10 = r9.size()
            if (r10 == 0) goto L2d
            r5 = r9
            goto L2e
        L2d:
            r5 = r1
        L2e:
            if (r11 == 0) goto L40
            java.util.List r9 = so.t0.i(r11)
            gm.h0 r9 = so.t0.f(r9)
            int r10 = r9.size()
            if (r10 == 0) goto L40
            r6 = r9
            goto L41
        L40:
            r6 = r1
        L41:
            mm.s0 r9 = new mm.s0
            mm.s0 r10 = r8.f50217a
            gm.h0 r3 = r10.B()
            mm.s0 r10 = r8.f50217a
            mm.n r4 = r10.C()
            mm.s0 r8 = r8.f50217a
            gm.h0 r7 = r8.E()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r0.f50217a = r9
            mm.n r8 = new mm.n
            mm.n r9 = r0.f50218b
            gm.y r9 = r9.y()
            mm.s0 r10 = r0.f50217a
            r8.<init>(r9, r10)
            r0.f50218b = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: so.l0.o(so.l0, org.bouncycastle.util.s, org.bouncycastle.util.s, org.bouncycastle.util.s):so.l0");
    }

    public static l0 p(l0 l0Var, e2 e2Var) {
        l0 l0Var2 = new l0(l0Var);
        l0Var2.f50220d = e2Var;
        HashSet hashSet = new HashSet();
        gm.i iVar = new gm.i();
        for (d2 d2Var : e2Var.b()) {
            t0.a(hashSet, d2Var, f50216g);
            iVar.a(d2Var.v());
        }
        gm.h0 h0VarD = t0.d(hashSet);
        b3 b3Var = new b3(iVar);
        gm.f0 f0Var = (gm.f0) l0Var.f50217a.b();
        gm.i iVar2 = new gm.i();
        iVar2.a(f0Var.K(0));
        iVar2.a(h0VarD);
        for (int i10 = 2; i10 != f0Var.size() - 1; i10++) {
            iVar2.a(f0Var.K(i10));
        }
        iVar2.a(b3Var);
        l0Var2.f50217a = mm.s0.D(new gm.i1(iVar2));
        l0Var2.f50218b = new mm.n(l0Var2.f50218b.y(), l0Var2.f50217a);
        return l0Var2;
    }

    public org.bouncycastle.util.s<X509AttributeCertificateHolder> b() {
        return f50215f.c(this.f50217a.A());
    }

    public org.bouncycastle.util.s<X509CRLHolder> c() {
        return f50215f.d(this.f50217a.z());
    }

    public org.bouncycastle.util.s<X509CertificateHolder> d() {
        return f50215f.e(this.f50217a.A());
    }

    public Set<zn.b> e() {
        HashSet hashSet = new HashSet(this.f50217a.B().size());
        Enumeration enumerationK = this.f50217a.B().K();
        while (enumerationK.hasMoreElements()) {
            hashSet.add(zn.b.z(enumerationK.nextElement()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] f(String str) throws IOException {
        return this.f50218b.v(str);
    }

    public org.bouncycastle.util.s g(gm.y yVar) {
        return f50215f.g(yVar, this.f50217a.z());
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50218b.getEncoded();
    }

    public r0 h() {
        return this.f50219c;
    }

    public String i() {
        return this.f50217a.C().y().L();
    }

    public final mm.s0 j() throws CMSException {
        try {
            return mm.s0.D(this.f50218b.x());
        } catch (ClassCastException e10) {
            throw new CMSException("Malformed content.", e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("Malformed content.", e11);
        }
    }

    public e2 k() {
        Map map;
        Object objX;
        if (this.f50220d == null) {
            gm.h0 h0VarE = this.f50217a.E();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 != h0VarE.size(); i10++) {
                mm.v0 v0VarB = mm.v0.B(h0VarE.J(i10));
                gm.y yVarY = this.f50217a.C().y();
                Map map2 = this.f50221e;
                if (map2 == null) {
                    arrayList.add(new d2(v0VarB, yVarY, this.f50219c, null));
                } else {
                    if (map2.keySet().iterator().next() instanceof String) {
                        map = this.f50221e;
                        objX = v0VarB.y().x().L();
                    } else {
                        map = this.f50221e;
                        objX = v0VarB.y().x();
                    }
                    arrayList.add(new d2(v0VarB, yVarY, null, (byte[]) map.get(objX)));
                }
            }
            this.f50220d = new e2(arrayList);
        }
        return this.f50220d;
    }

    public int l() {
        return this.f50217a.F().Q();
    }

    public boolean m() {
        return this.f50217a.C().x() == null && this.f50217a.E().size() == 0;
    }

    public boolean n() {
        return this.f50217a.C().x() == null && this.f50217a.E().size() > 0;
    }

    public mm.n q() {
        return this.f50218b;
    }

    public final boolean r(d2 d2Var, g2 g2Var) throws CMSException, OperatorCreationException {
        if (!d2Var.w(g2Var.a(d2Var.m()))) {
            return false;
        }
        Iterator<d2> it2 = d2Var.f().b().iterator();
        while (it2.hasNext()) {
            if (!r(it2.next(), g2Var)) {
                return false;
            }
        }
        return true;
    }

    public boolean s(g2 g2Var) throws CMSException {
        return t(g2Var, false);
    }

    public boolean t(g2 g2Var, boolean z10) throws CMSException {
        for (d2 d2Var : k().b()) {
            try {
                if (!d2Var.w(g2Var.a(d2Var.m()))) {
                    return false;
                }
                if (!z10) {
                    Iterator<d2> it2 = d2Var.f().b().iterator();
                    while (it2.hasNext()) {
                        if (!r(it2.next(), g2Var)) {
                            return false;
                        }
                    }
                }
            } catch (OperatorCreationException e10) {
                throw new CMSException("failure in verifier provider: " + e10.getMessage(), e10);
            }
        }
        return true;
    }
}
