package xr;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class d2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f55853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f55854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f55855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j2 f55856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f55857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y1 f55858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o1 f55859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n1 f55860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n1 f55861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final gm.u f55862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d1 f55863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k2 f55864l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f55865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e0 f55866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f55867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j2 f55868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a0 f55869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public y1 f55870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o1 f55871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public n1 f55872h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public n1 f55873i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public gm.u f55874j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public d1 f55875k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public k2 f55876l;

        public a() {
        }

        public a(a aVar) {
            this.f55865a = aVar.f55865a;
            this.f55866b = aVar.f55866b;
            this.f55867c = aVar.f55867c;
            this.f55868d = aVar.f55868d;
            this.f55869e = aVar.f55869e;
            this.f55870f = aVar.f55870f;
            this.f55871g = aVar.f55871g;
            this.f55872h = aVar.f55872h;
            this.f55873i = aVar.f55873i;
            this.f55874j = aVar.f55874j;
            this.f55875k = aVar.f55875k;
            this.f55876l = aVar.f55876l;
        }

        public a(d2 d2Var) {
            this.f55865a = d2Var.f55853a;
            this.f55866b = d2Var.f55854b;
            this.f55867c = d2Var.f55855c;
            this.f55868d = d2Var.f55856d;
            this.f55869e = d2Var.f55857e;
            this.f55870f = d2Var.f55858f;
            this.f55871g = d2Var.f55859g;
            this.f55872h = d2Var.f55860h;
            this.f55873i = d2Var.f55861i;
            this.f55874j = d2Var.f55862j;
            this.f55875k = d2Var.f55863k;
            this.f55876l = d2Var.f55864l;
        }

        public d2 a() {
            return new d2(this.f55865a, this.f55866b, this.f55867c, this.f55868d, this.f55869e, this.f55870f, this.f55871g, this.f55872h, this.f55873i, this.f55874j, this.f55875k, this.f55876l);
        }

        public a b(o1 o1Var) {
            this.f55871g = o1Var;
            return this;
        }

        public a c(y1 y1Var) {
            this.f55870f = y1Var;
            return this;
        }

        public a d(gm.u uVar) {
            this.f55874j = uVar;
            return this;
        }

        public a e(n1 n1Var) {
            this.f55872h = n1Var;
            return this;
        }

        public a f(n1 n1Var) {
            this.f55873i = n1Var;
            return this;
        }

        public a g(g gVar) {
            this.f55865a = gVar;
            return this;
        }

        public a h(e0 e0Var) {
            this.f55866b = e0Var;
            return this;
        }

        public a i(n nVar) {
            this.f55867c = nVar;
            return this;
        }

        public a j(d1 d1Var) {
            this.f55875k = d1Var;
            return this;
        }

        public a k(a0 a0Var) {
            this.f55869e = a0Var;
            return this;
        }

        public a l(j2 j2Var) {
            this.f55868d = j2Var;
            return this;
        }

        public a m(k2 k2Var) {
            this.f55876l = k2Var;
            return this;
        }
    }

    public d2(g gVar, e0 e0Var, n nVar, j2 j2Var, a0 a0Var, y1 y1Var, o1 o1Var, n1 n1Var, n1 n1Var2, gm.u uVar, d1 d1Var, k2 k2Var) {
        this.f55853a = gVar;
        this.f55854b = e0Var;
        this.f55855c = nVar;
        this.f55856d = j2Var;
        this.f55857e = a0Var;
        this.f55858f = y1Var;
        this.f55859g = o1Var;
        this.f55860h = n1Var;
        this.f55861i = n1Var2;
        this.f55862j = uVar;
        this.f55863k = d1Var;
        this.f55864l = k2Var;
    }

    public static d2 T(Object obj) {
        if (obj == null || (obj instanceof d2)) {
            return (d2) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        return new a().g(g.z(it2.next())).h(e0.x(it2.next())).i(n.z(it2.next())).l(j2.z(it2.next())).k((a0) org.bouncycastle.oer.d.B(a0.class, it2.next())).c((y1) org.bouncycastle.oer.d.B(y1.class, it2.next())).b((o1) org.bouncycastle.oer.d.B(o1.class, it2.next())).e((n1) org.bouncycastle.oer.d.B(n1.class, it2.next())).f((n1) org.bouncycastle.oer.d.B(n1.class, it2.next())).d((gm.u) org.bouncycastle.oer.d.B(gm.u.class, it2.next())).j((d1) org.bouncycastle.oer.d.B(d1.class, it2.next())).m(k2.z(it2.next())).a();
    }

    public o1 J() {
        return this.f55859g;
    }

    public y1 K() {
        return this.f55858f;
    }

    public gm.u L() {
        return this.f55862j;
    }

    public n1 M() {
        return this.f55860h;
    }

    public n1 N() {
        return this.f55861i;
    }

    public g O() {
        return this.f55853a;
    }

    public e0 P() {
        return this.f55854b;
    }

    public n Q() {
        return this.f55855c;
    }

    public d1 R() {
        return this.f55863k;
    }

    public a0 S() {
        return this.f55857e;
    }

    public j2 U() {
        return this.f55856d;
    }

    public k2 V() {
        return this.f55864l;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55853a, this.f55854b, this.f55855c, this.f55856d, org.bouncycastle.oer.d.z(this.f55857e), org.bouncycastle.oer.d.z(this.f55858f), org.bouncycastle.oer.d.z(this.f55859g), org.bouncycastle.oer.d.z(this.f55860h), org.bouncycastle.oer.d.z(this.f55861i), org.bouncycastle.oer.d.z(this.f55862j), org.bouncycastle.oer.d.z(this.f55863k), this.f55864l);
    }
}
