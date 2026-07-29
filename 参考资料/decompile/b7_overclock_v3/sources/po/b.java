package po;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.util.q;
import zn.b0;
import zn.g1;
import zn.h1;
import zn.i1;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p000do.a f46916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p000do.b f46917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f46918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f46919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X509AttributeCertificateHolder f46920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Collection f46921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Collection f46922g;

    public b(p000do.a aVar, p000do.b bVar, BigInteger bigInteger, Date date, X509AttributeCertificateHolder x509AttributeCertificateHolder, Collection collection, Collection collection2) {
        this.f46916a = aVar;
        this.f46917b = bVar;
        this.f46918c = bigInteger;
        this.f46919d = date;
        this.f46920e = x509AttributeCertificateHolder;
        this.f46921f = collection;
        this.f46922g = collection2;
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        y yVarD;
        i1[] i1VarArrY;
        if (!(obj instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        X509AttributeCertificateHolder x509AttributeCertificateHolder = (X509AttributeCertificateHolder) obj;
        X509AttributeCertificateHolder x509AttributeCertificateHolder2 = this.f46920e;
        if (x509AttributeCertificateHolder2 != null && !x509AttributeCertificateHolder2.equals(x509AttributeCertificateHolder)) {
            return false;
        }
        if (this.f46918c != null && !x509AttributeCertificateHolder.p().equals(this.f46918c)) {
            return false;
        }
        if (this.f46916a != null && !x509AttributeCertificateHolder.i().equals(this.f46916a)) {
            return false;
        }
        if (this.f46917b != null && !x509AttributeCertificateHolder.k().equals(this.f46917b)) {
            return false;
        }
        Date date = this.f46919d;
        if (date != null && !x509AttributeCertificateHolder.x(date)) {
            return false;
        }
        if ((!this.f46921f.isEmpty() || !this.f46922g.isEmpty()) && (yVarD = x509AttributeCertificateHolder.d(y.f59078v1)) != null) {
            try {
                i1VarArrY = h1.x(yVarD.C()).y();
                if (!this.f46921f.isEmpty()) {
                    boolean z10 = false;
                    for (i1 i1Var : i1VarArrY) {
                        g1[] g1VarArrY = i1Var.y();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= g1VarArrY.length) {
                                break;
                            }
                            if (this.f46921f.contains(b0.z(g1VarArrY[i10].z()))) {
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
            } catch (IllegalArgumentException unused) {
            }
            if (!this.f46922g.isEmpty()) {
                boolean z11 = false;
                for (i1 i1Var2 : i1VarArrY) {
                    g1[] g1VarArrY2 = i1Var2.y();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= g1VarArrY2.length) {
                            break;
                        }
                        if (this.f46922g.contains(b0.z(g1VarArrY2[i11].y()))) {
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

    public X509AttributeCertificateHolder a() {
        return this.f46920e;
    }

    public Date b() {
        if (this.f46919d != null) {
            return new Date(this.f46919d.getTime());
        }
        return null;
    }

    public p000do.a c() {
        return this.f46916a;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new b(this.f46916a, this.f46917b, this.f46918c, this.f46919d, this.f46920e, this.f46921f, this.f46922g);
    }

    public p000do.b d() {
        return this.f46917b;
    }

    public BigInteger e() {
        return this.f46918c;
    }

    public Collection f() {
        return this.f46922g;
    }

    public Collection g() {
        return this.f46921f;
    }
}
