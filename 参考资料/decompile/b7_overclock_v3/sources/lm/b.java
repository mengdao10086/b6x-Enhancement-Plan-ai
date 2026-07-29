package lm;

import gm.n0;
import gm.n2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class b extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.o f39853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.w f39855c;

    public b(int i10, gm.w wVar) {
        this.f39854b = i10;
        this.f39855c = wVar;
    }

    public b(zn.f fVar) {
        this(1, fVar);
    }

    public b(zn.o oVar) {
        if (oVar.J() != 3) {
            throw new IllegalArgumentException("only version 3 certificates allowed");
        }
        this.f39853a = oVar;
    }

    public static b x(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof byte[]) {
            try {
                obj = gm.c0.D((byte[]) obj);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Invalid encoding in CMPCertificate");
            }
        }
        if (obj instanceof gm.f0) {
            return new b(zn.o.z(obj));
        }
        if (obj instanceof n0) {
            n0 n0Var = (n0) obj;
            return new b(n0Var.q(), n0Var.U());
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public zn.f A() {
        return zn.f.y(this.f39855c);
    }

    public zn.o B() {
        return this.f39853a;
    }

    public boolean C() {
        return this.f39853a != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.w wVar = this.f39855c;
        return wVar != null ? new n2(true, this.f39854b, (gm.h) wVar) : this.f39853a.b();
    }

    public gm.w y() {
        return this.f39855c;
    }

    public int z() {
        return this.f39854b;
    }
}
