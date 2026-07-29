package gr;

import gm.y;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class n implements AlgorithmParameterSpec, er.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f29956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f29957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f29958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f29959d;

    public n(p pVar) {
        this.f29956a = pVar;
        this.f29958c = qm.a.f47466p.L();
        this.f29959d = null;
    }

    public n(String str) {
        this(str, qm.a.f47466p.L(), null);
    }

    public n(String str, String str2) {
        this(str, str2, null);
    }

    public n(String str, String str2, String str3) {
        qm.f fVarB;
        try {
            fVarB = qm.e.b(new y(str));
        } catch (IllegalArgumentException unused) {
            y yVarD = qm.e.d(str);
            if (yVarD != null) {
                str = yVarD.L();
                fVarB = qm.e.b(yVarD);
            } else {
                fVarB = null;
            }
        }
        if (fVarB == null) {
            throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
        }
        this.f29956a = new p(fVarB.C(), fVarB.D(), fVarB.x());
        this.f29957b = str;
        this.f29958c = str2;
        this.f29959d = str3;
    }

    public static n e(qm.g gVar) {
        return gVar.y() != null ? new n(gVar.B().L(), gVar.x().L(), gVar.y().L()) : new n(gVar.B().L(), gVar.x().L());
    }

    @Override // er.f
    public p a() {
        return this.f29956a;
    }

    @Override // er.f
    public String b() {
        return this.f29959d;
    }

    @Override // er.f
    public String c() {
        return this.f29957b;
    }

    @Override // er.f
    public String d() {
        return this.f29958c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f29956a.equals(nVar.f29956a) || !this.f29958c.equals(nVar.f29958c)) {
            return false;
        }
        String str = this.f29959d;
        String str2 = nVar.f29959d;
        return str == str2 || (str != null && str.equals(str2));
    }

    public int hashCode() {
        int iHashCode = this.f29956a.hashCode() ^ this.f29958c.hashCode();
        String str = this.f29959d;
        return iHashCode ^ (str != null ? str.hashCode() : 0);
    }
}
