package sn;

import gm.h;
import gm.i;
import gm.j2;
import gm.t;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f50034a = new i();

    public void a(y yVar) {
        this.f50034a.a(new j2(yVar));
    }

    public void b(y yVar, int i10) {
        i iVar = new i(2);
        iVar.a(yVar);
        iVar.a(new t(i10));
        this.f50034a.a(new j2(iVar));
    }

    public void c(y yVar, h hVar) {
        i iVar = new i(2);
        iVar.a(yVar);
        iVar.a(hVar);
        this.f50034a.a(new j2(iVar));
    }

    public i d() {
        return this.f50034a;
    }
}
