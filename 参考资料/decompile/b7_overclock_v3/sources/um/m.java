package um;

import gm.c0;
import gm.f2;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f52258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f52259b;

    public m(z zVar) {
        this.f52258a = zVar;
    }

    public m(n nVar) {
        this.f52259b = nVar;
    }

    public m(byte[] bArr) {
        this.f52258a = new f2(bArr);
    }

    public static m z(Object obj) {
        return obj instanceof m ? (m) obj : obj instanceof z ? new m((z) obj) : new m(n.z(obj));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        n nVar = this.f52259b;
        return nVar == null ? this.f52258a : nVar.b();
    }

    public zn.b x() {
        n nVar = this.f52259b;
        return nVar == null ? new zn.b(on.b.f44365i) : nVar.x();
    }

    public byte[] y() {
        n nVar = this.f52259b;
        return (nVar == null ? this.f52258a : nVar.y()).J();
    }
}
