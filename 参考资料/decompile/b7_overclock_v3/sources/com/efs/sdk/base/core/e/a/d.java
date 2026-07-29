package com.efs.sdk.base.core.e.a;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ILogEncryptAction f12899b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.f12899b = new com.efs.sdk.base.core.e.b();
        } else {
            this.f12899b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    @Override // com.efs.sdk.base.core.e.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.efs.sdk.base.core.d.b r5) {
        /*
            r4 = this;
            com.efs.sdk.base.core.d.a r0 = r5.f12890a
            int r1 = r0.f12887e
            r2 = 0
            r3 = 1
            if (r3 == r1) goto La
            r1 = 1
            goto Lb
        La:
            r1 = 0
        Lb:
            if (r1 != 0) goto L33
            java.lang.String r0 = r0.f12883a
            java.lang.String r1 = "wa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L33
            com.efs.sdk.base.core.d.a r0 = r5.f12890a
            java.lang.String r0 = r0.f12883a
            java.lang.String r1 = "startperf"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L33
            com.efs.sdk.base.core.d.a r0 = r5.f12890a
            byte r1 = r0.f12884b
            if (r3 != r1) goto L2f
            com.efs.sdk.base.core.d.c r1 = r5.f12891b
            boolean r1 = r1.f12894a
            if (r1 == 0) goto L33
        L2f:
            int r0 = r0.f12885c
            if (r3 != r0) goto L34
        L33:
            r2 = 1
        L34:
            if (r2 == 0) goto L3a
            r4.b(r5)
            return
        L3a:
            com.efs.sdk.base.processor.action.ILogEncryptAction r0 = r4.f12899b
            com.efs.sdk.base.core.config.GlobalEnvStruct r1 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r1 = r1.getSecret()
            byte[] r2 = r5.f12892c
            byte[] r0 = r0.encrypt(r1, r2)
            if (r0 == 0) goto L58
            r5.a(r0)
            com.efs.sdk.base.processor.action.ILogEncryptAction r0 = r4.f12899b
            int r0 = r0.getDeVal()
            r5.a(r0)
        L58:
            r4.b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.e.a.d.a(com.efs.sdk.base.core.d.b):void");
    }
}
