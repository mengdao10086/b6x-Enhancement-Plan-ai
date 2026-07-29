package so;

import gm.l2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mm.u0 f50074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f50075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f50076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cs.f f50077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cs.o f50078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zn.b f50079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k0 f50080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f50081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public X509CertificateHolder f50082i;

    public b2(mm.u0 u0Var, cs.f fVar, cs.o oVar, k0 k0Var, d dVar, d dVar2) {
        this.f50081h = null;
        this.f50074a = u0Var;
        this.f50077d = fVar;
        this.f50079f = oVar.a();
        this.f50078e = oVar;
        this.f50075b = dVar;
        this.f50076c = dVar2;
        this.f50080g = k0Var;
    }

    public b2(mm.u0 u0Var, cs.f fVar, zn.b bVar, k0 k0Var) {
        this.f50081h = null;
        this.f50074a = u0Var;
        this.f50077d = fVar;
        this.f50079f = bVar;
        this.f50078e = null;
        this.f50075b = null;
        this.f50076c = null;
        this.f50080g = k0Var;
    }

    public b2(b2 b2Var, d dVar, d dVar2) {
        this.f50081h = null;
        this.f50074a = b2Var.f50074a;
        this.f50077d = b2Var.f50077d;
        this.f50079f = b2Var.f50079f;
        this.f50078e = b2Var.f50078e;
        this.f50080g = b2Var.f50080g;
        this.f50075b = dVar;
        this.f50076c = dVar2;
    }

    public mm.v0 a(gm.y yVar) throws CMSException {
        zn.b bVarA;
        gm.h0 h0Var;
        gm.h0 h0VarC;
        try {
            zn.b bVarA2 = this.f50080g.a(this.f50077d.a());
            if (this.f50075b != null) {
                bVarA = this.f50078e.a();
                this.f50081h = this.f50078e.c();
                gm.h0 h0VarC2 = c(this.f50075b.a(Collections.unmodifiableMap(d(yVar, this.f50078e.a(), bVarA2, this.f50081h))));
                OutputStream outputStreamB = this.f50077d.b();
                outputStreamB.write(h0VarC2.v(gm.j.f29713a));
                outputStreamB.close();
                h0Var = h0VarC2;
            } else {
                bVarA = this.f50079f;
                cs.o oVar = this.f50078e;
                if (oVar != null) {
                    this.f50081h = oVar.c();
                } else {
                    this.f50081h = null;
                }
                h0Var = null;
            }
            byte[] signature = this.f50077d.getSignature();
            if (this.f50076c != null) {
                Map mapD = d(yVar, bVarA, bVarA2, this.f50081h);
                mapD.put(d.f50129c, org.bouncycastle.util.a.p(signature));
                h0VarC = c(this.f50076c.a(Collections.unmodifiableMap(mapD)));
            } else {
                h0VarC = null;
            }
            return new mm.v0(this.f50074a, (this.f50075b == null && tm.a.f51341e.C(bVarA2.x())) ? new zn.b(kn.d.f37614n) : bVarA, h0Var, bVarA2, new gm.f2(signature), h0VarC);
        } catch (IOException e10) {
            throw new CMSException("encoding error.", e10);
        }
    }

    public X509CertificateHolder b() {
        return this.f50082i;
    }

    public final gm.h0 c(mm.b bVar) {
        if (bVar != null) {
            return new l2(bVar.h());
        }
        return null;
    }

    public final Map d(gm.y yVar, zn.b bVar, zn.b bVar2, byte[] bArr) {
        HashMap map = new HashMap();
        if (yVar != null) {
            map.put(d.f50127a, yVar);
        }
        map.put(d.f50130d, bVar);
        map.put(d.f50132f, bVar2);
        map.put(d.f50128b, org.bouncycastle.util.a.p(bArr));
        return map;
    }

    public byte[] e() {
        byte[] bArr = this.f50081h;
        if (bArr != null) {
            return org.bouncycastle.util.a.p(bArr);
        }
        return null;
    }

    public OutputStream f() {
        cs.o oVar = this.f50078e;
        return oVar != null ? this.f50075b == null ? new kt.e(this.f50078e.b(), this.f50077d.b()) : oVar.b() : this.f50077d.b();
    }

    public zn.b g() {
        return this.f50079f;
    }

    public int h() {
        return this.f50074a.z() ? 3 : 1;
    }

    public mm.u0 i() {
        return this.f50074a;
    }

    public d j() {
        return this.f50075b;
    }

    public d k() {
        return this.f50076c;
    }

    public boolean l() {
        return this.f50082i != null;
    }

    public void m(X509CertificateHolder x509CertificateHolder) {
        this.f50082i = x509CertificateHolder;
    }
}
