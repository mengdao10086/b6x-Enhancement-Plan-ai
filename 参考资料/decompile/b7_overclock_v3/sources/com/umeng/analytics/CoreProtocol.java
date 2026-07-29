package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f23108a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CoreProtocol f23109a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f23108a == null && context != null) {
            f23108a = context.getApplicationContext();
        }
        return a.f23109a;
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(f23108a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(f23108a).b();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(f23108a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j10) {
        return o.a(f23108a).a(j10);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i10) {
        o.a(f23108a).a(obj, i10);
    }

    private CoreProtocol() {
    }
}
