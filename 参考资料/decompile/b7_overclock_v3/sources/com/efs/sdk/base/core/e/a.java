package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.a f12897a;

    public abstract com.efs.sdk.base.core.e.a.a a();

    public final void a(com.efs.sdk.base.core.d.b bVar) {
        try {
            if (this.f12897a == null) {
                synchronized (this) {
                    if (this.f12897a == null) {
                        com.efs.sdk.base.core.e.a.a aVarA = a();
                        this.f12897a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.f12897a.a(bVar);
        } catch (Throwable th2) {
            Log.e("efs.processor", "log handle error", th2);
        }
    }
}
