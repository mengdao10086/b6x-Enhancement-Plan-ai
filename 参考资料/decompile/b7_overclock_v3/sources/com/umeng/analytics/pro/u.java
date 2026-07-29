package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class u implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23769a = "session_start_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f23770b = "session_end_time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23771c = "session_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f23772d = "pre_session_id";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f23773e = "a_start_time";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f23774f = "a_end_time";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f23775g = "fg_count";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f23776h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f23777i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f23778j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f23779k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f23780l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static long f23781m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final u f23782a = new u();

        private a() {
        }
    }

    public static u a() {
        return a.f23782a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23777i);
        if (sharedPreferences != null) {
            long j10 = sharedPreferences.getLong(f23775g, 0L);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putLong(f23775g, j10 + 1);
                editorEdit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putLong(f23775g, 0L);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f23777i == null && context != null) {
            f23777i = context.getApplicationContext();
        }
        String strD = y.a().d(f23777i);
        try {
            f(context);
            o.a(f23777i).d((Object) null);
        } catch (Throwable unused) {
        }
        return strD;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f23777i == null && context != null) {
                f23777i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f23773e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + jLongValue);
            editorEdit.putLong(f23774f, jLongValue);
            editorEdit.putLong(f23770b, jLongValue);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f23775g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j10) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23777i);
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putLong(f23769a, j10);
        editorEdit.commit();
    }

    public void b(Context context, Object obj) {
        long jLongValue;
        try {
            if (f23777i == null) {
                f23777i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                jLongValue = System.currentTimeMillis();
            } else {
                jLongValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23777i);
            if (sharedPreferences == null) {
                return;
            }
            f23779k = sharedPreferences.getLong(f23774f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f23779k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f23777i);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                editorEdit.putLong(f23769a, jLongValue);
                editorEdit.commit();
                o.a(f23777i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + y.a().c(f23777i));
                f23778j = true;
                a(f23777i, jLongValue, true);
                return;
            }
            if (y.a().e(f23777i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f23778j = true;
                editorEdit.putLong(f23769a, jLongValue);
                editorEdit.commit();
                a(f23777i, jLongValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f23778j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor editorEdit;
        try {
            if (f23777i == null && context != null) {
                f23777i = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23777i);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f23777i);
            if (TextUtils.isEmpty(string)) {
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(d.az, appVersionName);
                editorEdit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i10 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(d.az, appVersionName);
                editorEdit.putString("vers_date", string2);
                editorEdit.putString("vers_pre_version", string3);
                editorEdit.putString("cur_version", string4);
                editorEdit.putInt("vers_code", i10);
                editorEdit.putString("vers_name", string);
                editorEdit.commit();
                if (f23780l) {
                    f23780l = false;
                }
                if (f23778j) {
                    f23778j = false;
                    b(f23777i, jLongValue, true);
                    b(f23777i, jLongValue);
                    return;
                }
                return;
            }
            if (f23778j) {
                f23778j = false;
                if (f23780l) {
                    f23780l = false;
                }
                f23776h = e(context);
                MLog.d("创建新会话: " + f23776h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f23776h);
                return;
            }
            f23776h = sharedPreferences.getString("session_id", null);
            editorEdit.putLong(f23773e, jLongValue);
            editorEdit.putLong(f23774f, 0L);
            editorEdit.commit();
            MLog.d("延续上一个会话: " + f23776h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f23776h);
            if (f23780l) {
                f23780l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    Context context2 = f23777i;
                    UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            o.a(f23777i).a(false);
        } catch (Throwable unused) {
        }
    }

    public String c(Context context) {
        try {
            if (f23776h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f23776h;
    }

    public String c() {
        return c(f23777i);
    }

    public boolean b(Context context, long j10, boolean z10) {
        String strA;
        long j11;
        boolean z11 = false;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (strA = y.a().a(f23777i)) == null) {
                return false;
            }
            long j12 = sharedPreferences.getLong(f23773e, 0L);
            long j13 = sharedPreferences.getLong(f23774f, 0L);
            if (j12 > 0 && j13 == 0) {
                z11 = true;
                if (z10) {
                    j11 = f23779k;
                    if (j11 == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j10);
                        j11 = j10;
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f23779k);
                    }
                    c(f23777i, Long.valueOf(j11));
                } else {
                    c(f23777i, Long.valueOf(j10));
                    j11 = j10;
                }
                JSONObject jSONObject = new JSONObject();
                if (z10) {
                    jSONObject.put(e.d.a.f23572g, j11);
                } else {
                    jSONObject.put(e.d.a.f23572g, j10);
                }
                JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
                if (jSONObjectB != null && jSONObjectB.length() > 0) {
                    jSONObject.put("__sp", jSONObjectB);
                }
                JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
                if (jSONObjectC != null && jSONObjectC.length() > 0) {
                    jSONObject.put("__pp", jSONObjectC);
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f23781m);
                    jSONObject.put(e.d.a.f23573h, f23781m);
                    f23781m = 0L;
                } else {
                    jSONObject.put(e.d.a.f23573h, 0L);
                }
                i.a(context).a(strA, jSONObject, i.a.END);
                o.a(f23777i).e();
            }
        } catch (Throwable unused) {
        }
        return z11;
    }

    public void b(Context context, long j10) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f23777i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j10, boolean z10) {
        String strB = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + strB);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j10);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            i.a(context).a(strB, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z10);
        } catch (Throwable unused) {
        }
        return strB;
    }

    public String b() {
        return f23776h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j10, long j11, long j12) {
        a(f23777i, str2, j10, j11, j12);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f23777i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j10);
    }

    private void a(Context context, String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(f23776h)) {
            f23776h = y.a().a(f23777i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f23776h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f23572g, j11);
            jSONObject.put(e.d.a.f23573h, j12);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            i.a(context).a(f23776h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j10);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f23781m = j12;
                d(context);
                Context context2 = f23777i;
                UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f23776h = str;
    }

    private void a(String str, long j10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23777i);
        if (sharedPreferences == null) {
            return;
        }
        long j11 = sharedPreferences.getLong(f23770b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j10);
            jSONObject.put(e.d.a.f23572g, j11);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.C, location[0]);
                jSONObject2.put(d.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f23570e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i10 = f23777i.getApplicationInfo().uid;
            if (i10 == -1) {
                return;
            }
            long jLongValue = ((Long) method.invoke(null, Integer.valueOf(i10))).longValue();
            long jLongValue2 = ((Long) method2.invoke(null, Integer.valueOf(i10))).longValue();
            if (jLongValue > 0 && jLongValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, jLongValue);
                jSONObject3.put(d.G, jLongValue2);
                jSONObject.put(e.d.a.f23569d, jSONObject3);
            }
            i.a(f23777i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f23777i);
            l.c(f23777i);
        } catch (Throwable unused) {
        }
    }
}
