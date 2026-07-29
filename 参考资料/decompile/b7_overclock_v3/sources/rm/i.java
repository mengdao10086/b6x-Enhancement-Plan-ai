package rm;

import gm.c0;
import gm.f0;
import gm.n0;
import gm.n2;
import gm.w;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f48892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f48893b;

    public i(b bVar) {
        this.f48892a = bVar;
    }

    public i(d dVar) {
        this.f48893b = dVar;
    }

    public static i A(Object obj) {
        if (obj == null || (obj instanceof i)) {
            return (i) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return A(c0.D((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e10.getMessage());
            }
        }
        if (obj instanceof f0) {
            return new i(b.C(obj));
        }
        if (obj instanceof n0) {
            return new i(d.x(n0.T(obj), false));
        }
        throw new IllegalArgumentException("Couldn't convert from object to DVCSResponse: " + obj.getClass().getName());
    }

    public static i z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        b bVar = this.f48892a;
        return bVar != null ? bVar.b() : new n2(false, 0, (gm.h) this.f48893b);
    }

    public String toString() {
        StringBuilder sb2;
        String string;
        if (this.f48892a != null) {
            sb2 = new StringBuilder();
            sb2.append("DVCSResponse {\ndvCertInfo: ");
            string = this.f48892a.toString();
        } else {
            sb2 = new StringBuilder();
            sb2.append("DVCSResponse {\ndvErrorNote: ");
            string = this.f48893b.toString();
        }
        sb2.append(string);
        sb2.append("}\n");
        return sb2.toString();
    }

    public b x() {
        return this.f48892a;
    }

    public d y() {
        return this.f48893b;
    }
}
