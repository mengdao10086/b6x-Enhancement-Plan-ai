package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f12982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f12983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f12984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f12985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f12986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f12987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f12988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f12989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f12990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f12991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f12992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static List<EfsJSONLog> f12993l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Map<String, Long[]> f12994m = new HashMap();

    public static void a(Activity activity, String str, boolean z10) {
        long jCurrentTimeMillis;
        Context applicationContext;
        String name;
        int i10;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long jCurrentTimeMillis2;
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_CREATE)) {
            if (z10) {
                boolean z11 = LaunchManager.isDebug;
                f12985d = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_RE_START)) {
            if (z10 && f12992k == 0) {
                boolean z12 = LaunchManager.isDebug;
                f12986e = System.currentTimeMillis();
                f12988g = true;
                return;
            }
            return;
        }
        if (TextUtils.equals(str, LaunchManager.PAGE_ON_START)) {
            if (z10) {
                boolean z13 = LaunchManager.isDebug;
                f12992k++;
                f12989h = true;
                return;
            }
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.PAGE_ON_RESUME)) {
            if (TextUtils.equals(str, LaunchManager.PAGE_ON_STOP) && z10) {
                boolean z14 = LaunchManager.isDebug;
                f12992k--;
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        boolean z15 = LaunchManager.isDebug;
        if (f12987f) {
            f12987f = false;
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            long j18 = jCurrentTimeMillis3 - f12984c;
            if (LaunchManager.isDebug) {
                "loadTime is ".concat(String.valueOf(j18));
            }
            long j19 = jCurrentTimeMillis3 - f12982a;
            if (LaunchManager.isDebug) {
                "======>>>>>> coldTime is ".concat(String.valueOf(j19));
            }
            int i11 = !c.d(activity.getApplicationContext()) ? 1 : 0;
            if (LaunchManager.isDebug) {
                "type is ".concat(String.valueOf(i11));
            }
            a(activity.getApplicationContext(), i11, activity.getClass().getName(), j19, f12982a, f12983b, f12990i, f12984c, f12991j, jCurrentTimeMillis3, j18, 0L, 0L, f12994m);
        } else if (f12992k == 1) {
            if (f12988g) {
                f12988g = false;
                jCurrentTimeMillis2 = System.currentTimeMillis() - f12986e;
                if (LaunchManager.isDebug) {
                    "======>>>>>> hotTime is ".concat(String.valueOf(jCurrentTimeMillis2));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i10 = 2;
                j10 = 0;
                j11 = 0;
                j12 = 0;
                j13 = 0;
                j14 = 0;
                j15 = 0;
                j16 = 0;
                j17 = 0;
                jCurrentTimeMillis = 0;
            } else if (f12989h) {
                jCurrentTimeMillis = System.currentTimeMillis() - f12985d;
                if (LaunchManager.isDebug) {
                    "======>>>>>> warmTime is ".concat(String.valueOf(jCurrentTimeMillis));
                }
                applicationContext = activity.getApplicationContext();
                name = activity.getClass().getName();
                i10 = 3;
                j10 = 0;
                j11 = 0;
                j12 = 0;
                j13 = 0;
                j14 = 0;
                j15 = 0;
                j16 = 0;
                j17 = 0;
                jCurrentTimeMillis2 = 0;
            }
            a(applicationContext, i10, name, j10, j11, j12, j13, j14, j15, j16, j17, jCurrentTimeMillis2, jCurrentTimeMillis, f12994m);
        }
        f12989h = false;
    }

    private static void a(Context context, int i10, String str, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, Map<String, Long[]> map) {
        String str2;
        String str3;
        int i11;
        List<EfsJSONLog> list;
        StringBuilder sb2;
        String strGenerateString;
        JSONArray jSONArray;
        Object objValueOf;
        if (!LaunchManager.isInit()) {
            if (i10 == 0) {
                boolean z10 = LaunchManager.isDebug;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w_type", i10);
                    jSONObject.put("w_url", str);
                    jSONObject.put("l_version", "0.0.5.umeng");
                    jSONObject.put("wl_avgv", j10);
                    jSONObject.put("wd_init", j11);
                    jSONObject.put("wd_inittm", j12);
                    jSONObject.put("wl_init", j13);
                    jSONObject.put("wd_build", j12);
                    jSONObject.put("wd_buildtm", j14);
                    jSONObject.put("wl_build", j15);
                    jSONObject.put("wd_page", j14);
                    jSONObject.put("wd_pagetm", j16);
                    jSONObject.put("wl_page", j17);
                    if (map != null && !map.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry<String, Long[]> entry : map.entrySet()) {
                            String key = entry.getKey();
                            Long[] value = entry.getValue();
                            if (key != null && value != null) {
                                try {
                                    JSONArray jSONArray2 = new JSONArray();
                                    jSONArray2.put(value[0]);
                                    jSONArray2.put(value[1]);
                                    jSONObject2.put(key, jSONArray2);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        jSONObject.put("userExtra", jSONObject2);
                    }
                    c.a(context, jSONObject.toString());
                    if (LaunchManager.isDebug) {
                        new StringBuilder("no init, cache first launch, content is ").append(jSONObject.toString());
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
            if (LaunchManager.isDebug) {
                str2 = "wl_page";
                str3 = "wd_pagetm";
                "no init, cache launch, type is ".concat(String.valueOf(i10));
            } else {
                str2 = "wl_page";
                str3 = "wd_pagetm";
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", Integer.valueOf(i10));
            efsJSONLog.put("w_url", str);
            efsJSONLog.put("l_version", "0.0.5.umeng");
            if (i10 == 1) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j10));
                efsJSONLog.put("wd_init", Long.valueOf(j11));
                efsJSONLog.put("wd_inittm", Long.valueOf(j12));
                efsJSONLog.put("wl_init", Long.valueOf(j13));
                efsJSONLog.put("wd_build", Long.valueOf(j12));
                efsJSONLog.put("wd_buildtm", Long.valueOf(j14));
                efsJSONLog.put("wl_build", Long.valueOf(j15));
                efsJSONLog.put("wd_page", Long.valueOf(j14));
                efsJSONLog.put(str3, Long.valueOf(j16));
                efsJSONLog.put(str2, Long.valueOf(j17));
                if (map != null && !map.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (Map.Entry<String, Long[]> entry2 : map.entrySet()) {
                        String key2 = entry2.getKey();
                        Long[] value2 = entry2.getValue();
                        if (key2 != null && value2 != null) {
                            try {
                                jSONArray = new JSONArray();
                            } catch (Throwable unused2) {
                            }
                            try {
                                jSONArray.put(value2[0]);
                                try {
                                    jSONArray.put(value2[1]);
                                    jSONObject3.put(key2, jSONArray);
                                } catch (Throwable unused3) {
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    efsJSONLog.put("userExtra", jSONObject3);
                }
            } else if (i10 == 2) {
                efsJSONLog.put("wl_avgv", Long.valueOf(j18));
            } else {
                i11 = 3;
                if (i10 == 3) {
                    efsJSONLog.put("wl_avgv", Long.valueOf(j19));
                }
                list = f12993l;
                if (list != null || list.size() >= i11) {
                    boolean z11 = LaunchManager.isDebug;
                    return;
                }
                f12993l.add(efsJSONLog);
                if (!LaunchManager.isDebug) {
                    return;
                }
                sb2 = new StringBuilder("cache launch report --->>> ");
                strGenerateString = efsJSONLog.generateString();
            }
            i11 = 3;
            list = f12993l;
            if (list != null) {
            }
            boolean z112 = LaunchManager.isDebug;
            return;
        }
        LaunchConfigManager launchConfigManager = LaunchManager.getLaunchConfigManager();
        if ((launchConfigManager == null || !launchConfigManager.enableTracer()) && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            boolean z12 = LaunchManager.isDebug;
            return;
        }
        EfsJSONLog efsJSONLog2 = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
        efsJSONLog2.put("w_type", Integer.valueOf(i10));
        efsJSONLog2.put("w_url", str);
        efsJSONLog2.put("l_version", "0.0.5.umeng");
        if (i10 == 0 || i10 == 1) {
            efsJSONLog2.put("wl_avgv", Long.valueOf(j10));
            efsJSONLog2.put("wd_init", Long.valueOf(j11));
            efsJSONLog2.put("wd_inittm", Long.valueOf(j12));
            efsJSONLog2.put("wl_init", Long.valueOf(j13));
            efsJSONLog2.put("wd_build", Long.valueOf(j12));
            efsJSONLog2.put("wd_buildtm", Long.valueOf(j14));
            efsJSONLog2.put("wl_build", Long.valueOf(j15));
            efsJSONLog2.put("wd_page", Long.valueOf(j14));
            efsJSONLog2.put("wd_pagetm", Long.valueOf(j16));
            efsJSONLog2.put("wl_page", Long.valueOf(j17));
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, Long[]> entry3 : map.entrySet()) {
                    String key3 = entry3.getKey();
                    Long[] value3 = entry3.getValue();
                    if (key3 != null && value3 != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(value3[0]);
                            jSONArray3.put(value3[1]);
                            jSONObject4.put(key3, jSONArray3);
                        } catch (Throwable unused5) {
                        }
                    }
                }
                efsJSONLog2.put("userExtra", jSONObject4);
            }
        } else {
            if (i10 == 2) {
                objValueOf = Long.valueOf(j18);
            } else if (i10 == 3) {
                objValueOf = Long.valueOf(j19);
            }
            efsJSONLog2.put("wl_avgv", objValueOf);
        }
        String strA = c.a(context);
        if (LaunchManager.isDebug) {
            "umid is ".concat(String.valueOf(strA));
        }
        if (strA != null && !TextUtils.isEmpty(strA)) {
            if (LaunchManager.isDebug) {
                new StringBuilder("send current launch report --->>> ").append(efsJSONLog2.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog2);
                return;
            }
            return;
        }
        List<EfsJSONLog> list2 = f12993l;
        if (list2 == null || list2.size() >= 3) {
            boolean z13 = LaunchManager.isDebug;
            return;
        }
        f12993l.add(efsJSONLog2);
        if (!LaunchManager.isDebug) {
            return;
        }
        sb2 = new StringBuilder("cache launch report --->>> ");
        strGenerateString = efsJSONLog2.generateString();
        sb2.append(strGenerateString);
    }

    public static void a(Context context, String str) {
        boolean z10 = LaunchManager.isDebug;
        if (str == null || TextUtils.isEmpty(str)) {
            str = c.a(context);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap(1);
        map.put(UMCrash.KEY_HEADER_UMID, str);
        if (LaunchManager.getReporter() != null) {
            LaunchManager.getReporter().addPublicParams(map);
        }
        String strB = c.b(context);
        if (strB != null && !TextUtils.isEmpty(strB)) {
            try {
                JSONObject jSONObject = new JSONObject(strB);
                jSONObject.put(UMCrash.KEY_HEADER_UMID, str);
                if (a(jSONObject)) {
                    c.c(context);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        List<EfsJSONLog> list = f12993l;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (EfsJSONLog efsJSONLog : f12993l) {
            if (efsJSONLog != null) {
                if (LaunchManager.isDebug) {
                    new StringBuilder("send cache launch report --->>> ").append(efsJSONLog.generateString());
                }
                EfsReporter reporter = LaunchManager.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
        f12993l.clear();
        f12993l = null;
    }

    public static void a(String str, long j10) {
        Map<String, Long[]> map = f12994m;
        if (map == null || map.containsKey(str) || f12994m.size() >= 10) {
            boolean z10 = LaunchManager.isDebug;
            return;
        }
        Long[] lArr = new Long[2];
        lArr[0] = Long.valueOf(j10);
        f12994m.put(str, lArr);
    }

    public static void a(String str, boolean z10) {
        if (TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (!TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (!TextUtils.equals(str, LaunchManager.APP_ON_CREATE) || z10) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            f12984c = jCurrentTimeMillis;
            f12991j = jCurrentTimeMillis - f12983b;
            if (LaunchManager.isDebug) {
                new StringBuilder("buildTime is ").append(f12991j);
                return;
            }
            return;
        }
        if (z10) {
            f12982a = System.currentTimeMillis();
            f12987f = true;
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        f12983b = jCurrentTimeMillis2;
        f12990i = jCurrentTimeMillis2 - f12982a;
        if (LaunchManager.isDebug) {
            new StringBuilder("initTime is ").append(f12990i);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject.opt("wl_page"));
            efsJSONLog.put("userExtra", jSONObject.opt("userExtra"));
            if (LaunchManager.isDebug) {
                new StringBuilder("send cache cold launch report --->>> ").append(efsJSONLog.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static void b(String str, long j10) {
        Map<String, Long[]> map = f12994m;
        if (map == null || !map.containsKey(str)) {
            boolean z10 = LaunchManager.isDebug;
            return;
        }
        Long[] lArr = f12994m.get(str);
        lArr[1] = Long.valueOf(j10);
        f12994m.put(str, lArr);
    }
}
