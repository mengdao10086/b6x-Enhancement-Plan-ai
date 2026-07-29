package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    private static boolean c(com.efs.sdk.base.core.d.b bVar) {
        if (!bVar.b()) {
            com.efs.sdk.base.core.d.a aVar = bVar.f12890a;
            if ((1 != aVar.f12884b || bVar.f12891b.f12894a) && 1 != aVar.f12885c) {
                return false;
            }
        }
        return true;
    }

    @Override // com.efs.sdk.base.core.e.a.a
    public final void a(com.efs.sdk.base.core.d.b bVar) {
        if (c(bVar)) {
            b(bVar);
            return;
        }
        byte[] bArrA = com.efs.sdk.base.core.util.c.a(bVar.f12892c);
        if (bArrA == null) {
            Log.w("efs.base", "gzip error");
            b(bVar);
        } else {
            bVar.a(bArrA);
            bVar.a(Constants.CP_GZIP);
            b(bVar);
        }
    }
}
