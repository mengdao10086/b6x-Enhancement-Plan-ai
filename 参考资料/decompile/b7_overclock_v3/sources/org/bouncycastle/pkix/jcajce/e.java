package org.bouncycastle.pkix.jcajce;

import zn.y0;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f45667b = new e(33023);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45668a;

    public e() {
        this(0);
    }

    public e(int i10) {
        this.f45668a = i10;
    }

    public e(y0 y0Var) {
        this.f45668a = y0Var.N();
    }

    public void a(e eVar) {
        this.f45668a = eVar.b() | this.f45668a;
    }

    public int b() {
        return this.f45668a;
    }

    public boolean c(e eVar) {
        return ((eVar.b() ^ this.f45668a) | this.f45668a) != 0;
    }

    public e d(e eVar) {
        e eVar2 = new e();
        eVar2.a(new e(eVar.b() & this.f45668a));
        return eVar2;
    }

    public boolean e() {
        return this.f45668a == f45667b.f45668a;
    }
}
