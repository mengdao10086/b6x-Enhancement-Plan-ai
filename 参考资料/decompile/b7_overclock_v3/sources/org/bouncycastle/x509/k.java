package org.bouncycastle.x509;

import gm.c0;
import gm.f2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import zn.b0;
import zn.g1;
import zn.h1;
import zn.i1;

/* JADX INFO: loaded from: classes6.dex */
public class k implements org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f46121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f46122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Date f46124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f46125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Collection f46126f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Collection f46127g = new HashSet();

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        byte[] extensionValue;
        i1[] i1VarArrY;
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        l lVar2 = this.f46125e;
        if (lVar2 != null && !lVar2.equals(lVar)) {
            return false;
        }
        if (this.f46123c != null && !lVar.getSerialNumber().equals(this.f46123c)) {
            return false;
        }
        if (this.f46121a != null && !lVar.i().equals(this.f46121a)) {
            return false;
        }
        if (this.f46122b != null && !lVar.m().equals(this.f46122b)) {
            return false;
        }
        Date date = this.f46124d;
        if (date != null) {
            try {
                lVar.checkValidity(date);
            } catch (CertificateExpiredException | CertificateNotYetValidException unused) {
                return false;
            }
        }
        if ((!this.f46126f.isEmpty() || !this.f46127g.isEmpty()) && (extensionValue = lVar.getExtensionValue(zn.y.f59078v1.L())) != null) {
            try {
                i1VarArrY = h1.x(new gm.s(((f2) c0.D(extensionValue)).J()).n()).y();
                if (!this.f46126f.isEmpty()) {
                    boolean z10 = false;
                    for (i1 i1Var : i1VarArrY) {
                        g1[] g1VarArrY = i1Var.y();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= g1VarArrY.length) {
                                break;
                            }
                            if (this.f46126f.contains(b0.z(g1VarArrY[i10].z()))) {
                                z10 = true;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (!z10) {
                        return false;
                    }
                }
            } catch (IOException | IllegalArgumentException unused2) {
            }
            if (!this.f46127g.isEmpty()) {
                boolean z11 = false;
                for (i1 i1Var2 : i1VarArrY) {
                    g1[] g1VarArrY2 = i1Var2.y();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= g1VarArrY2.length) {
                            break;
                        }
                        if (this.f46127g.contains(b0.z(g1VarArrY2[i11].y()))) {
                            z11 = true;
                            break;
                        }
                        i11++;
                    }
                }
                if (!z11) {
                    return false;
                }
            }
        }
        return true;
    }

    public void a(b0 b0Var) {
        this.f46127g.add(b0Var);
    }

    public void b(byte[] bArr) throws IOException {
        a(b0.z(c0.D(bArr)));
    }

    public void c(b0 b0Var) {
        this.f46126f.add(b0Var);
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        k kVar = new k();
        kVar.f46125e = this.f46125e;
        kVar.f46124d = g();
        kVar.f46121a = this.f46121a;
        kVar.f46122b = this.f46122b;
        kVar.f46123c = this.f46123c;
        kVar.f46127g = k();
        kVar.f46126f = l();
        return kVar;
    }

    public void d(byte[] bArr) throws IOException {
        c(b0.z(c0.D(bArr)));
    }

    public final Set e(Collection collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (Object objZ : collection) {
            if (!(objZ instanceof b0)) {
                objZ = b0.z(c0.D((byte[]) objZ));
            }
            hashSet.add(objZ);
        }
        return hashSet;
    }

    public l f() {
        return this.f46125e;
    }

    public Date g() {
        if (this.f46124d != null) {
            return new Date(this.f46124d.getTime());
        }
        return null;
    }

    public a h() {
        return this.f46121a;
    }

    public b i() {
        return this.f46122b;
    }

    public BigInteger j() {
        return this.f46123c;
    }

    public Collection k() {
        return Collections.unmodifiableCollection(this.f46127g);
    }

    public Collection l() {
        return Collections.unmodifiableCollection(this.f46126f);
    }

    public void m(l lVar) {
        this.f46125e = lVar;
    }

    public void n(Date date) {
        if (date != null) {
            this.f46124d = new Date(date.getTime());
        } else {
            this.f46124d = null;
        }
    }

    public void o(a aVar) {
        this.f46121a = aVar;
    }

    public void p(b bVar) {
        this.f46122b = bVar;
    }

    public void q(BigInteger bigInteger) {
        this.f46123c = bigInteger;
    }

    public void r(Collection collection) throws IOException {
        this.f46127g = e(collection);
    }

    public void s(Collection collection) throws IOException {
        this.f46126f = e(collection);
    }
}
