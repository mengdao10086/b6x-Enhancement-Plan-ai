package im;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.o;
import gm.p2;
import gm.r0;
import gm.t;
import gm.w;
import gm.z;
import gm.z1;
import java.math.BigInteger;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f32515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f32517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f32518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f32519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f32520f;

    public f(f0 f0Var) {
        this.f32515a = t.I(f0Var.K(0)).K();
        this.f32516b = r0.I(f0Var.K(1)).d();
        this.f32517c = o.M(f0Var.K(2));
        this.f32518d = o.M(f0Var.K(3));
        this.f32519e = z.I(f0Var.K(4));
        this.f32520f = f0Var.size() == 6 ? r0.I(f0Var.K(5)).d() : null;
    }

    public f(BigInteger bigInteger, String str, Date date, Date date2, byte[] bArr, String str2) {
        this.f32515a = bigInteger;
        this.f32516b = str;
        this.f32517c = new z1(date);
        this.f32518d = new z1(date2);
        this.f32519e = new f2(org.bouncycastle.util.a.p(bArr));
        this.f32520f = str2;
    }

    public static f B(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    public String A() {
        return this.f32516b;
    }

    public o C() {
        return this.f32518d;
    }

    public BigInteger D() {
        return this.f32515a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(new t(this.f32515a));
        iVar.a(new p2(this.f32516b));
        iVar.a(this.f32517c);
        iVar.a(this.f32518d);
        iVar.a(this.f32519e);
        if (this.f32520f != null) {
            iVar.a(new p2(this.f32520f));
        }
        return new j2(iVar);
    }

    public String x() {
        return this.f32520f;
    }

    public o y() {
        return this.f32517c;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f32519e.J());
    }
}
