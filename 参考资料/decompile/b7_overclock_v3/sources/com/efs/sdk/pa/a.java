package com.efs.sdk.pa;

import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements PAANRListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PAFactory f13116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PATraceListener f13117b;

    public a(PAFactory pAFactory) {
        this.f13116a = pAFactory;
        this.f13117b = pAFactory.getTraceListener();
        boolean zEnableTracer = pAFactory.getConfigManager().enableTracer();
        if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            c.a(this.f13116a, "patracepv", null);
        }
        PATraceListener pATraceListener = this.f13117b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(zEnableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.f13116a, "patrace", str);
        PATraceListener pATraceListener = this.f13117b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.f13117b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
