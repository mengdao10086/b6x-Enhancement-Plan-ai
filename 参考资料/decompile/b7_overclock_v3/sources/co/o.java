package co;

import gm.c0;
import gm.f2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class o extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f11150b = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ir.f f11151a;

    public o(ir.f fVar) {
        this.f11151a = fVar;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new f2(f11150b.c(this.f11151a.v(), f11150b.b(this.f11151a)));
    }

    public ir.f x() {
        return this.f11151a;
    }
}
