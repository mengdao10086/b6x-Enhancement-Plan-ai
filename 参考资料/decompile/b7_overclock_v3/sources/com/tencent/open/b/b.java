package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f22663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22664b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22665c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22666d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22667e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22668f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22669g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22670h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Serializable> f22671i = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<Serializable> f22672j = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Executor f22673k = j.b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22674l;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f22674l) {
            List<Serializable> listA = g.a().a("report_atta");
            this.f22674l = listA.isEmpty();
            this.f22671i.addAll(listA);
            Iterator<Serializable> it2 = listA.iterator();
            while (it2.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it2.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f22671i.isEmpty()) {
            c cVar = (c) this.f22671i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f22674l) {
                return;
            }
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a().b("report_atta");
            this.f22674l = true;
            return;
        }
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) it3.next())));
        }
        g.a().a("report_atta", arrayList);
        this.f22674l = false;
    }

    public static synchronized b a() {
        if (f22663a == null) {
            f22663a = new b();
        }
        return f22663a;
    }

    private void b() {
        while (!this.f22672j.isEmpty()) {
            c cVar = (c) this.f22672j.remove(0);
            cVar.f22677a.put("appid", this.f22664b);
            cVar.f22677a.put("app_name", this.f22665c);
            cVar.f22677a.put(Constants.PARAM_APP_VER, this.f22667e);
            cVar.f22677a.put(Constants.PARAM_PKG_NAME, this.f22668f);
            cVar.f22677a.put("qq_install", this.f22669g);
            cVar.f22677a.put(Constants.PARAM_QQ_VER, this.f22670h);
            cVar.f22677a.put("openid", this.f22666d);
            cVar.f22677a.put("time_appid_openid", cVar.f22677a.get("time") + "_" + this.f22664b + "_" + this.f22666d);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fixDirtyData--------------------------");
            sb2.append(cVar);
            SLog.i("AttaReporter", sb2.toString());
            this.f22671i.add(cVar);
        }
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f22664b = str;
        this.f22665c = i.a(context);
        this.f22667e = k.d(context, com.tencent.open.utils.f.b());
        this.f22668f = com.tencent.open.utils.f.b();
        this.f22669g = i.b(context) ? "1" : "0";
        this.f22670h = k.c(context, "com.tencent.mobileqq");
        b();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f22666d = str;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map2 = new HashMap();
        map2.put("attaid", "09400051119");
        map2.put("token", "9389887874");
        map2.put("time_appid_openid", jCurrentTimeMillis + "_" + this.f22664b + "_" + this.f22666d);
        map2.put("time", String.valueOf(jCurrentTimeMillis));
        map2.put("openid", this.f22666d);
        map2.put("appid", this.f22664b);
        map2.put("app_name", this.f22665c);
        map2.put(Constants.PARAM_APP_VER, this.f22667e);
        map2.put(Constants.PARAM_PKG_NAME, this.f22668f);
        map2.put("os", "AND");
        map2.put("os_ver", Build.VERSION.RELEASE);
        map2.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        map2.put(Constants.PARAM_MODEL_NAME, Build.MODEL);
        map2.put("interface_name", str);
        map2.put("interface_data", str2);
        map2.put("interface_result", obj == null ? "" : obj.toString());
        map2.put("qq_install", this.f22669g);
        map2.put(Constants.PARAM_QQ_VER, this.f22670h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            map2.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            map2.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            map2.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            map2.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c((HashMap<String, String>) map2);
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c cVarB = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f22664b) && !TextUtils.isEmpty(this.f22665c) && com.tencent.open.utils.f.a() != null) {
            a(cVarB);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f22664b + ", mAppName=" + this.f22665c + ", context=" + com.tencent.open.utils.f.a() + ", " + cVarB);
        this.f22672j.add(cVarB);
    }

    private void a(final c cVar) {
        this.f22673k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f22671i.add(cVar);
                if (k.b(com.tencent.open.utils.f.a())) {
                    try {
                        b.this.c();
                        return;
                    } catch (Exception e10) {
                        SLog.e("AttaReporter", "Exception", e10);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
            }
        });
    }

    private boolean b(c cVar) {
        int i10 = 0;
        do {
            i10++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.a.a().b("https://h.trace.qq.com/kv", cVar.f22677a).d() == 200;
            } catch (Exception e10) {
                SLog.i("AttaReporter", "Exception", e10);
            }
        } while (i10 < 2);
        return false;
    }
}
