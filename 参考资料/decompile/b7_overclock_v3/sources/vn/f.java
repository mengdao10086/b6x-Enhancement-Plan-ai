package vn;

import gm.c0;
import gm.f2;
import gm.w;
import gm.z;
import ir.i;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f53266a;

    public f(z zVar) {
        this.f53266a = zVar;
    }

    public f(i iVar) {
        this.f53266a = new f2(e.b(iVar));
    }

    public static f x(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(z.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f53266a;
    }
}
