package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        HttpResponse httpResponseA;
        if (!bVar.f12891b.f12894a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.c.d dVarA = com.efs.sdk.base.core.c.d.a();
        if (!bVar.f12891b.f12895b || com.efs.sdk.base.core.c.b.a().a(bVar.f12890a.f12883a, bVar.a())) {
            f.a.f12921a.f12919c.b();
            f.a.f12921a.f12919c.c();
            httpResponseA = dVarA.f12819b.a(bVar, false);
        } else {
            httpResponseA = new HttpResponse();
            httpResponseA.data = "flow_limit";
        }
        bVar.f12891b.f12896c = httpResponseA;
        b(bVar);
    }
}
