package org.bouncycastle.jce.provider;

import zn.y0;

/* JADX INFO: loaded from: classes5.dex */
public class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f45419b = new d0(33023);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45420a;

    public d0() {
        this(0);
    }

    public d0(int i10) {
        this.f45420a = i10;
    }

    public d0(y0 y0Var) {
        this.f45420a = y0Var.N();
    }

    public void a(d0 d0Var) {
        this.f45420a = d0Var.b() | this.f45420a;
    }

    public int b() {
        return this.f45420a;
    }

    public boolean c(d0 d0Var) {
        return ((d0Var.b() ^ this.f45420a) | this.f45420a) != 0;
    }

    public d0 d(d0 d0Var) {
        d0 d0Var2 = new d0();
        d0Var2.a(new d0(d0Var.b() & this.f45420a));
        return d0Var2;
    }

    public boolean e() {
        return this.f45420a == f45419b.f45420a;
    }
}
