package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import g.n0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    @Override // com.efs.sdk.base.core.c.c
    @n0
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z10) {
        HttpResponse httpResponseA;
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        com.efs.sdk.base.core.d.a aVar = bVar.f12890a;
        cVarA.f12786d = aVar.f12886d;
        cVarA.f12787e = aVar.f12887e;
        cVarA.f12789g = aVar.f12884b;
        cVarA.f12790h = aVar.f12883a;
        cVarA.f12795m = bVar.a();
        String strA = com.efs.sdk.base.core.config.a.c.a().a(false);
        int i10 = bVar.f12890a.f12885c;
        if (i10 == 0) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            byte[] bArr = bVar.f12892c;
            boolean z11 = bVar.f12891b.f12895b;
            String strB = cVarA.b();
            String strA2 = com.efs.sdk.base.core.a.a.a(strA, cVarA);
            if (aVarA.f12780a) {
                Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA2).a(map);
            com.efs.sdk.base.core.util.a.b bVar2 = dVarA.f12941a;
            bVar2.f12935c = bArr;
            bVar2.f12939g = true;
            com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVarA.f12790h);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cVarA.f12795m);
            httpResponseA = dVarA2.a("size", sb2.toString()).a("flow_limit", Boolean.toString(z11)).a(com.efs.sdk.base.core.a.d.a()).a().b();
        } else {
            httpResponseA = 1 == i10 ? com.efs.sdk.base.core.a.a.a().a(strA, cVarA, bVar.f12893d, bVar.f12891b.f12895b) : new HttpResponse();
        }
        if (httpResponseA.succ && z10) {
            com.efs.sdk.base.core.util.b.b(bVar.f12893d);
        }
        return httpResponseA;
    }
}
