package com.umeng.pagesdk;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Map> f24475a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f24476b;

    private static void a(String str) {
        Map map;
        if (TextUtils.isEmpty(str) || (map = f24475a.get(str)) == null || (r0 = map.entrySet().iterator()) == null) {
            return;
        }
        JSONArray jSONArray = null;
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                String str2 = (String) entry.getKey();
                Long[] lArr = (Long[]) entry.getValue();
                if (!TextUtils.isEmpty(str2) && lArr != null && lArr.length >= 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("mN", str2);
                        jSONObject.put("mBT", lArr[0]);
                        jSONObject.put("mET", lArr[1]);
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
        if (jSONArray != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pN", str);
                jSONObject2.put("pL", jSONArray);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("pageperf");
            efsJSONLog.put("page", jSONObject2);
            EfsReporter reporter = PageManger.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
            }
        }
    }

    public static void a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            boolean z11 = PageManger.isDebug;
            return;
        }
        if (!PageManger.isInit()) {
            boolean z12 = PageManger.isDebug;
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            boolean z13 = PageManger.isDebug;
            return;
        }
        if (z10) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (f24475a.containsKey(str)) {
            Map map = f24475a.get(str);
            if (map == null) {
                boolean z14 = PageManger.isDebug;
                return;
            }
            if (map.containsKey(str2)) {
                return;
            }
            if (PageManger.isDebug) {
                StringBuilder sb2 = new StringBuilder("tracePageBegin. begin add method. ");
                sb2.append(str2);
                sb2.append(" - ");
                sb2.append(str);
            }
            if (z10 || map.size() <= 6) {
                Long[] lArr = new Long[2];
                lArr[0] = Long.valueOf(System.currentTimeMillis());
                map.put(str2, lArr);
                return;
            } else {
                if (PageManger.isDebug) {
                    StringBuilder sb3 = new StringBuilder("tracePageBegin. user trace number of transfinite. ");
                    sb3.append(str2);
                    sb3.append("-");
                    sb3.append(str);
                    return;
                }
                return;
            }
        }
        if (str2.equals("UM_onCreate")) {
            if (PageManger.isDebug) {
                StringBuilder sb4 = new StringBuilder("tracePageBegin. begin add onCreate. ");
                sb4.append(str2);
                sb4.append(" - ");
                sb4.append(str);
            }
            Long[] lArr2 = new Long[2];
            lArr2[0] = Long.valueOf(System.currentTimeMillis());
            HashMap map2 = new HashMap();
            map2.put(str2, lArr2);
            f24475a.put(str, map2);
            a aVar = f24476b;
            if (aVar != null) {
                aVar.b();
                a aVar2 = f24476b;
                aVar2.f24472j = str;
                aVar2.a();
                return;
            }
            a aVar3 = new a(PageManger.getApplicationContext());
            f24476b = aVar3;
            aVar3.f24472j = str;
            aVar3.a();
        }
    }

    public static void b(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            boolean z11 = PageManger.isDebug;
            return;
        }
        if (!PageManger.isInit()) {
            boolean z12 = PageManger.isDebug;
            return;
        }
        PageConfigManger pageConfigManger = PageManger.getPageConfigManger();
        if (pageConfigManger == null || !pageConfigManger.enableTracer()) {
            boolean z13 = PageManger.isDebug;
            return;
        }
        if (z10) {
            str2 = "UM_".concat(String.valueOf(str2));
        }
        if (!f24475a.containsKey(str)) {
            if (str2.equals("UM_onPause")) {
                if (PageManger.isDebug) {
                    "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str));
                }
                a aVar = f24476b;
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            return;
        }
        Map map = f24475a.get(str);
        if (map == null) {
            if (PageManger.isDebug) {
                StringBuilder sb2 = new StringBuilder("tracePageEnd. ");
                sb2.append(str);
                sb2.append(" is null in pageMap!");
                return;
            }
            return;
        }
        if (!map.containsKey(str2)) {
            if (PageManger.isDebug) {
                StringBuilder sb3 = new StringBuilder("tracePageEnd. ");
                sb3.append(str2);
                sb3.append(" non-exist in ");
                sb3.append(str);
                sb3.append(" map!");
                return;
            }
            return;
        }
        Long[] lArr = (Long[]) map.get(str2);
        if (lArr.length >= 2) {
            lArr[1] = Long.valueOf(System.currentTimeMillis());
        }
        if (str2.equals("UM_onResume")) {
            if (PageManger.isDebug) {
                "tracePageEnd. onResume save data. ".concat(String.valueOf(str));
            }
            a(str);
            if (TextUtils.isEmpty(str) || !f24475a.containsKey(str)) {
                return;
            }
            f24475a.remove(str);
            return;
        }
        if (str2.equals("UM_onPause")) {
            if (PageManger.isDebug) {
                "tracePageEnd. onPause stop fps. ".concat(String.valueOf(str));
            }
            a aVar2 = f24476b;
            if (aVar2 != null) {
                aVar2.b();
                f24476b = null;
            }
        }
    }
}
