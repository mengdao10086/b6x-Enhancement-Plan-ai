package um;

import gm.c0;
import gm.f0;
import gm.j2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f52265b;

    public p(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f52264a = (gm.y) f0Var.K(0);
            try {
                this.f52265b = c0.D(f0Var.K(1).b().v(gm.j.f29713a));
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public p(gm.y yVar, gm.h hVar) {
        this.f52264a = yVar;
        this.f52265b = hVar;
    }

    public static p x(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52264a);
        iVar.a(this.f52265b);
        return new j2(iVar);
    }

    public gm.y y() {
        return this.f52264a;
    }

    public gm.h z() {
        return this.f52265b;
    }
}
