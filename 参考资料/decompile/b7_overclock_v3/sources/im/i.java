package im;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.o;
import gm.p2;
import gm.r0;
import gm.t;
import gm.w;
import gm.z1;
import java.math.BigInteger;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f32524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f32525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f32526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f32527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f32528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f32529f;

    public i(f0 f0Var) {
        this.f32524a = t.I(f0Var.K(0)).K();
        this.f32525b = zn.b.z(f0Var.K(1));
        this.f32526c = o.M(f0Var.K(2));
        this.f32527d = o.M(f0Var.K(3));
        this.f32528e = g.x(f0Var.K(4));
        this.f32529f = f0Var.size() == 6 ? r0.I(f0Var.K(5)).d() : null;
    }

    public i(zn.b bVar, Date date, Date date2, g gVar, String str) {
        this.f32524a = BigInteger.valueOf(1L);
        this.f32525b = bVar;
        this.f32526c = new z1(date);
        this.f32527d = new z1(date2);
        this.f32528e = gVar;
        this.f32529f = str;
    }

    public static i z(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f32525b;
    }

    public o B() {
        return this.f32527d;
    }

    public g C() {
        return this.f32528e;
    }

    public BigInteger D() {
        return this.f32524a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(new t(this.f32524a));
        iVar.a(this.f32525b);
        iVar.a(this.f32526c);
        iVar.a(this.f32527d);
        iVar.a(this.f32528e);
        if (this.f32529f != null) {
            iVar.a(new p2(this.f32529f));
        }
        return new j2(iVar);
    }

    public String x() {
        return this.f32529f;
    }

    public o y() {
        return this.f32526c;
    }
}
