package um;

import gm.c0;
import gm.f0;
import gm.j2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f52263b;

    public o(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f52262a = new gm.y(((gm.y) f0Var.K(0)).L());
            try {
                this.f52263b = c0.D(f0Var.K(1).b().v(gm.j.f29713a));
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public o(gm.y yVar, gm.h hVar) {
        this.f52262a = yVar;
        this.f52263b = hVar;
    }

    public static o x(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52262a);
        iVar.a(this.f52263b);
        return new j2(iVar);
    }

    public gm.y y() {
        return this.f52262a;
    }

    public gm.h z() {
        return this.f52263b;
    }
}
