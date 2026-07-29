package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        com.efs.sdk.base.core.b.e eVarA;
        byte[] bArr;
        if (bVar.f12891b.f12894a) {
            b(bVar);
            return;
        }
        com.efs.sdk.base.core.b.a aVar = a.b.f12801a;
        if ("wa".equals(bVar.f12890a.f12883a) || com.efs.sdk.base.core.b.c.a().f12803a) {
            com.efs.sdk.base.core.d.a aVar2 = bVar.f12890a;
            if ((aVar2.f12885c == 0 && ((bArr = bVar.f12892c) == null || bArr.length == 0)) || (eVarA = aVar.f12799c.a(aVar2.f12884b)) == null) {
                return;
            }
            eVarA.a(bVar);
            return;
        }
        if (!aVar.f12797a) {
            com.efs.sdk.base.core.f.f fVar = f.a.f12921a;
            int i10 = com.efs.sdk.base.core.config.a.c.a().f12860d.f12850a;
            if (fVar.f12918b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                fVar.f12918b.send(fVar.a("disk_limit", i10));
            }
        }
        aVar.f12797a = true;
    }
}
