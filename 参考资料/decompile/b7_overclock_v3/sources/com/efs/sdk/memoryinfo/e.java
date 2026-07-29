package com.efs.sdk.memoryinfo;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class e {
    public final List<EfsJSONLog> B = new ArrayList();
    public volatile boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EfsReporter f13026a;

    public e(final Context context, EfsReporter efsReporter) {
        this.f13026a = efsReporter;
        String uMId = UMUtils.getUMId(context);
        this.C = !TextUtils.isEmpty(uMId);
        if (!this.C) {
            ImprintHandler.getImprintService(context).registImprintCallback("umid", new UMImprintChangeCallback() { // from class: com.efs.sdk.memoryinfo.e.1
                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public final void onImprintValueChanged(String str, String str2) {
                    try {
                        if ("umid".equals(str)) {
                            HashMap map = new HashMap(1);
                            map.put(UMCrash.KEY_HEADER_UMID, str2);
                            e.this.f13026a.addPublicParams(map);
                            synchronized (e.class) {
                                e.b(e.this);
                            }
                            Iterator it2 = e.this.B.iterator();
                            while (it2.hasNext()) {
                                e.this.a((EfsJSONLog) it2.next());
                            }
                            new StringBuilder("send cache:").append(e.this.B.size());
                            boolean z10 = a.DEBUG;
                            e.this.B.clear();
                            ImprintHandler.getImprintService(context).unregistImprintCallback("umid", this);
                        }
                    } catch (Throwable th2) {
                        f.a("umid ", th2);
                    }
                }
            });
            return;
        }
        HashMap map = new HashMap(1);
        map.put(UMCrash.KEY_HEADER_UMID, uMId);
        efsReporter.addPublicParams(map);
    }

    public static /* synthetic */ boolean b(e eVar) {
        eVar.C = true;
        return true;
    }

    public final void a(EfsJSONLog efsJSONLog) {
        try {
            this.f13026a.send(efsJSONLog);
        } catch (Throwable th2) {
            f.a("send", th2);
        }
    }
}
