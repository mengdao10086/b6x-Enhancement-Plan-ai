package lm;

import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.z f39908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f39909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f39910c;

    public i(gm.f0 f0Var) {
        this.f39908a = gm.z.I(f0Var.K(0));
        this.f39909b = gm.t.I(f0Var.K(1));
        if (f0Var.size() > 2) {
            this.f39910c = b0.z(f0Var.K(2));
        }
    }

    public i(byte[] bArr, BigInteger bigInteger) {
        this.f39908a = new f2(bArr);
        this.f39909b = new gm.t(bigInteger);
    }

    public i(byte[] bArr, BigInteger bigInteger, b0 b0Var) {
        this.f39908a = new f2(bArr);
        this.f39909b = new gm.t(bigInteger);
        this.f39910c = b0Var;
    }

    public static i z(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(gm.f0.J(obj));
        }
        return null;
    }

    public b0 A() {
        return this.f39910c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39908a);
        iVar.a(this.f39909b);
        b0 b0Var = this.f39910c;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        return new j2(iVar);
    }

    public gm.z x() {
        return this.f39908a;
    }

    public gm.t y() {
        return this.f39909b;
    }
}
