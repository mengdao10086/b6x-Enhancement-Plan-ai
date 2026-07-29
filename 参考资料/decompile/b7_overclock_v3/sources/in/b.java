package in;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f32544a;

    public b(f0 f0Var) {
        this.f32544a = f0Var.size() == 1 ? (z) f0Var.K(0) : null;
    }

    public b(byte[] bArr) {
        this.f32544a = new f2(bArr);
    }

    public static b y(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(1);
        z zVar = this.f32544a;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public byte[] x() {
        z zVar = this.f32544a;
        if (zVar != null) {
            return org.bouncycastle.util.a.p(zVar.J());
        }
        return null;
    }
}
