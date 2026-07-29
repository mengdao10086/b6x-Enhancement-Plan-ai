package com.efs.sdk.memoryinfo;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EfsReporter f12996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12997b = false;
    public final Context mContext;

    public b(Context context, EfsReporter efsReporter) {
        this.mContext = context.getApplicationContext();
        this.f12996a = efsReporter;
    }

    public static /* synthetic */ void a(b bVar, e eVar, String str) {
        c cVar = new c(bVar.mContext);
        EfsJSONLog efsJSONLog = new EfsJSONLog("memperf");
        efsJSONLog.put("w_pgid", str);
        efsJSONLog.put("crver", "0.0.2.umeng");
        efsJSONLog.put("k_st", cVar.f13012bg);
        efsJSONLog.put("w_url", cVar.activity);
        efsJSONLog.put("wl_tpss", Long.valueOf(cVar.f13013n));
        efsJSONLog.put("wl_jpss", Long.valueOf(cVar.f13014o));
        efsJSONLog.put("wl_npss", Long.valueOf(cVar.f13015p));
        efsJSONLog.put("wl_heap", Long.valueOf(cVar.f13016q));
        efsJSONLog.put("wf_heap_used_rate", Float.valueOf(cVar.f13017r));
        efsJSONLog.put("wl_graphics", Long.valueOf(cVar.f13018s));
        efsJSONLog.put("wl_vmsize", Long.valueOf(cVar.f13019t));
        synchronized (e.class) {
            if (eVar.C) {
                eVar.a(efsJSONLog);
            } else {
                eVar.B.add(efsJSONLog);
            }
        }
    }
}
