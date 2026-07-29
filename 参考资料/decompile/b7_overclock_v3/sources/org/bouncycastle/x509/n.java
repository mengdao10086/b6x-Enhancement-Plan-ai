package org.bouncycastle.x509;

/* JADX INFO: loaded from: classes6.dex */
public class n implements org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f46134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f46135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f46136c;

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        try {
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            o oVar = this.f46134a;
            if (oVar != null && !oVar.M(pVar.b())) {
                return false;
            }
            o oVar2 = this.f46135b;
            if (oVar2 != null && !oVar2.M(pVar.c())) {
                return false;
            }
            p pVar2 = this.f46136c;
            if (pVar2 != null) {
                return pVar2.equals(obj);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public p a() {
        return this.f46136c;
    }

    public o b() {
        return this.f46134a;
    }

    public o c() {
        return this.f46135b;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        n nVar = new n();
        nVar.f46136c = this.f46136c;
        o oVar = this.f46134a;
        if (oVar != null) {
            nVar.e((o) oVar.clone());
        }
        o oVar2 = this.f46135b;
        if (oVar2 != null) {
            nVar.f((o) oVar2.clone());
        }
        return nVar;
    }

    public void d(p pVar) {
        this.f46136c = pVar;
    }

    public void e(o oVar) {
        this.f46134a = oVar;
    }

    public void f(o oVar) {
        this.f46135b = oVar;
    }
}
