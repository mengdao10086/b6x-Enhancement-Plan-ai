package lm;

import gm.d2;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.u f39970a;

    public t() {
        this.f39970a = d2.f29657b;
    }

    public t(gm.u uVar) {
        this.f39970a = uVar;
    }

    public static t x(Object obj) {
        if (obj == null || (obj instanceof t)) {
            return (t) obj;
        }
        if (obj instanceof gm.u) {
            return new t((gm.u) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39970a;
    }
}
