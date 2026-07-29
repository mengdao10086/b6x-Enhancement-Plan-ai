package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrashUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f23689a = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f23690l = "first_activate_time";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f23691m = "ana_is_f";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f23692n = "thtstart";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f23693o = "dstk_last_time";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f23694p = "dstk_cnt";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f23695q = "gkvc";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f23696r = "ekvc";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f23697t = "-1";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f23698x = "com.umeng.umcrash.UMCrashUtils";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static Class<?> f23699y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static Method f23700z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f23701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f23702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONArray f23706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f23707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f23708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f23710k;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f23711s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f23712u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f23713v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Object f23714w;

    public static class a {
        public static final int A = 8210;
        public static final int B = 8211;
        public static final int C = 8212;
        public static final int D = 8213;
        public static final int E = 8214;
        public static final int F = 8215;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f23715a = 4097;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f23716b = 4098;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f23717c = 4099;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f23718d = 4100;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f23719e = 4101;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f23720f = 4102;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f23721g = 4103;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f23722h = 4104;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f23723i = 4105;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f23724j = 4106;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f23725k = 4352;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f23726l = 4353;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f23727m = 4354;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f23728n = 4355;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f23729o = 4356;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f23730p = 4357;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f23731q = 8193;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f23732r = 8194;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f23733s = 8195;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f23734t = 8196;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f23735u = 8197;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f23736v = 8199;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f23737w = 8200;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f23738x = 8201;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f23739y = 8208;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f23740z = 8209;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final o f23741a = new o();

        private b() {
        }
    }

    static {
        h();
    }

    public static o a(Context context) {
        if (f23689a == null && context != null) {
            f23689a = context.getApplicationContext();
        }
        return b.f23741a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (i.a(UMGlobalContext.getAppContext(f23689a)).c() || (jSONObjectF = i.a(UMGlobalContext.getAppContext(f23689a)).f()) == null) {
            return;
        }
        String strOptString = jSONObjectF.optString("__av");
        String strOptString2 = jSONObjectF.optString("__vc");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f23689a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f23689a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f23710k, this.f23708i)) {
                    return;
                } else {
                    this.f23708i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f23710k, this.f23709j)) {
                    return;
                } else {
                    this.f23709j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f23706g == null) {
                    this.f23706g = new JSONArray();
                }
                this.f23706g.put(jSONObject);
                i.a(f23689a).a(this.f23706g);
                this.f23706g = new JSONArray();
                return;
            }
            if (this.f23706g.length() >= this.f23705f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(f23689a).a(this.f23706g);
                this.f23706g = new JSONArray();
            }
            if (this.f23710k == 0) {
                this.f23710k = System.currentTimeMillis();
            }
            this.f23706g.put(jSONObject);
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.f23510n)) {
                    i.a(f23689a).a(true, false);
                }
                i.a(f23689a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(com.umeng.analytics.pro.d.f23510n) && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.d.f23510n).optJSONObject(0)) != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(strOptString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        i.a(f23689a).b(strOptString);
                    }
                }
            }
            i.a(f23689a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = f23689a;
            UMWorkDispatch.sendEvent(context, a.f23726l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            f23699y = UMCrashUtils.class;
            Method declaredMethod = UMCrashUtils.class.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f23700z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(f23689a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (f23689a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f23689a, jSONObject, jSONObject2);
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(jSONObjectBuildEnvelopeWithExtHeader);
            }
            b((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(f23689a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        Context context = f23689a;
        if (context == null || jSONObject == null || jSONObject2 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(jSONObjectBuildEnvelopeWithExtHeader);
        }
        a((Object) jSONObjectBuildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return jSONObjectL;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f23689a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23505i), verticalType);
            String str = "9.5.4";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f23689a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.5.4");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f23689a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(f23689a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23689a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(f23689a, com.umeng.analytics.pro.d.f23490an, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23492ap), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23492ap), strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(f23689a, com.umeng.analytics.pro.d.f23491ao, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23493aq), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23493aq), strImprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23484ah), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23486aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f23691m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23508l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23509m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23508l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f23509m), sharedPreferences.getString("vers_date", str2));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f23689a)).putString("pre_date", str2).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(f23689a, "pr_ve", null);
            if (TextUtils.isEmpty(strImprintProperty)) {
                if (!TextUtils.isEmpty(this.f23703d)) {
                    return this.f23703d;
                }
                if (this.f23702c == null) {
                    this.f23702c = PreferenceWrapper.getDefault(f23689a);
                }
                String string = this.f23702c.getString("pre_version", "");
                String appVersionName = DeviceConfig.getAppVersionName(f23689a);
                if (TextUtils.isEmpty(string)) {
                    this.f23702c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                    strImprintProperty = "0";
                } else {
                    String string2 = this.f23702c.getString("cur_version", "");
                    if (appVersionName.equals(string2)) {
                        strImprintProperty = string;
                    } else {
                        this.f23702c.edit().putString("pre_version", string2).putString("cur_version", appVersionName).commit();
                        strImprintProperty = string2;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f23703d = strImprintProperty;
        return strImprintProperty;
    }

    private String n() {
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(f23689a, "ud_da", null);
            if (TextUtils.isEmpty(strImprintProperty)) {
                if (!TextUtils.isEmpty(this.f23704e)) {
                    return this.f23704e;
                }
                if (this.f23702c == null) {
                    this.f23702c = PreferenceWrapper.getDefault(f23689a);
                }
                String string = this.f23702c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f23702c.edit().putString("pre_date", string).commit();
                } else {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(str)) {
                        this.f23702c.edit().putString("pre_date", str).commit();
                        strImprintProperty = str;
                    }
                }
                strImprintProperty = string;
            }
        } catch (Throwable unused) {
        }
        this.f23704e = strImprintProperty;
        return strImprintProperty;
    }

    private void o() {
        try {
            this.f23708i = 0;
            this.f23709j = 0;
            this.f23710k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f23689a).edit().putLong(f23693o, System.currentTimeMillis()).putInt(f23694p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(f23689a);
            }
            if (this.f23706g.length() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < this.f23706g.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = this.f23706g.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || f23697t.equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f23706g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < this.f23706g.length(); i10++) {
                try {
                    JSONObject jSONObject = this.f23706g.getJSONObject(i10);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("__i");
                        boolean zIsEmpty = TextUtils.isEmpty(strOptString);
                        String str = f23697t;
                        if (zIsEmpty || f23697t.equals(strOptString)) {
                            String strB = u.a().b();
                            if (!TextUtils.isEmpty(strB)) {
                                str = strB;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f23706g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = f23689a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f23690l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f23690l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f23689a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f23691m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f23689a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f23706g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(f23689a).a(this.f23706g);
                this.f23706g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f23689a).edit().putLong(f23692n, this.f23710k).putInt(f23695q, this.f23708i).putInt(f23696r, this.f23709j).commit();
        } catch (Throwable unused) {
        }
    }

    private o() {
        this.f23701b = null;
        this.f23702c = null;
        this.f23703d = null;
        this.f23704e = null;
        this.f23705f = 10;
        this.f23706g = new JSONArray();
        this.f23707h = 5000;
        this.f23708i = 0;
        this.f23709j = 0;
        this.f23710k = 0L;
        this.f23711s = 28800000L;
        this.f23712u = false;
        this.f23713v = false;
        this.f23714w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23689a);
            this.f23710k = sharedPreferences.getLong(f23692n, 0L);
            this.f23708i = sharedPreferences.getInt(f23695q, 0);
            this.f23709j = sharedPreferences.getInt(f23696r, 0);
            this.f23701b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.f23510n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    i.a(f23689a).i();
                    i.a(f23689a).h();
                    i.a(f23689a).b(true, false);
                    i.a(f23689a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.f23510n)) {
                    i.a(f23689a).b(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.T)) {
                    i.a(f23689a).h();
                }
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.O)) {
                    i.a(f23689a).i();
                }
            }
            i.a(f23689a).a();
        } catch (Exception unused) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f23742a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f23743b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f23744c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f23745d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f23746e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ABTest f23747f;

        public c() {
            this.f23747f = null;
            this.f23747f = ABTest.getService(o.f23689a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.f23743b = iArrA[0];
                this.f23744c = iArrA[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            int iA;
            Defcon service = Defcon.getService(o.f23689a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f23742a;
                this.f23742a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f23742a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.f23689a), service);
            } else {
                boolean z10 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f23689a, "integrated_test", o.f23697t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z10 && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z10) {
                    this.f23742a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.f23689a));
                } else if (this.f23747f.isInTest() && "RPT".equals(this.f23747f.getTestName())) {
                    if (this.f23747f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f23689a, "test_report_interval", o.f23697t)).intValue() != -1) {
                            iA = a(90000);
                        } else {
                            iA = this.f23744c;
                            if (iA <= 0) {
                                iA = this.f23746e;
                            }
                        }
                    } else {
                        iA = 0;
                    }
                    this.f23742a = b(this.f23747f.getTestPolicy(), iA);
                } else {
                    int i10 = this.f23745d;
                    int i11 = this.f23746e;
                    int i12 = this.f23743b;
                    if (i12 != -1) {
                        i11 = this.f23744c;
                        i10 = i12;
                    }
                    this.f23742a = b(i10, i11);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f23742a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z11 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f23742a;
        }

        public int[] a(int i10, int i11) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f23689a, "report_policy", o.f23697t)).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f23689a, "report_interval", o.f23697t)).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[]{i10, i11};
            }
            if (6 == iIntValue) {
                if (iIntValue2 == -1 || iIntValue2 < 90 || iIntValue2 > 86400) {
                    iIntValue2 = 90;
                }
                return new int[]{iIntValue, iIntValue2 * 1000};
            }
            if (11 != iIntValue) {
                return new int[]{i10, i11};
            }
            if (iIntValue2 == -1 || iIntValue2 < 15 || iIntValue2 > 3600) {
                iIntValue2 = 15;
            }
            return new int[]{iIntValue, iIntValue2 * 1000};
        }

        public int a(int i10) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f23689a, "test_report_interval", o.f23697t)).intValue();
            return (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) ? i10 : iIntValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i10, int i11) {
            if (i10 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f23742a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i10 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f23742a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i10 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f23742a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.f23689a));
            }
            if (i10 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f23742a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.f23689a);
            }
            if (i10 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f23742a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i11);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.f23689a), i11);
            }
            if (i10 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f23742a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.f23689a));
            }
            if (i10 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f23742a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f23742a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i11);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i11);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!i.a(f23689a).e()) {
                JSONObject jSONObjectG = i.a(f23689a).g();
                if (jSONObjectG != null) {
                    String strOptString = jSONObjectG.optString("__av");
                    String strOptString2 = jSONObjectG.optString("__vc");
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f23689a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f23689a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f23689a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f23689a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f23689a != null) {
            synchronized (this.f23714w) {
                if (this.f23712u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    Context context = f23689a;
                    UMWorkDispatch.sendEvent(context, a.f23726l, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.f23714w) {
                if (this.f23713v) {
                    Context context2 = f23689a;
                    UMWorkDispatch.sendEvent(context2, a.f23727m, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Object> f23748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f23749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f23750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f23751d;

        private d() {
            this.f23748a = null;
            this.f23749b = null;
            this.f23750c = null;
            this.f23751d = 0L;
        }

        public Map<String, Object> a() {
            return this.f23748a;
        }

        public String b() {
            return this.f23750c;
        }

        public String c() {
            return this.f23749b;
        }

        public long d() {
            return this.f23751d;
        }

        public d(String str, Map<String, Object> map, String str2, long j10) {
            this.f23748a = map;
            this.f23749b = str;
            this.f23751d = j10;
            this.f23750c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String strOptString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            i.a(f23689a).a(strOptString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.T)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.T));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.O)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.O, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.O));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.f23510n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f23510n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(com.umeng.analytics.pro.d.f23517u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.d.f23517u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f23510n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put(db.d.f26139i, jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    public JSONObject b(long j10) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(f23689a)))) {
            return null;
        }
        JSONObject jSONObjectB = i.a(UMGlobalContext.getAppContext(f23689a)).b(false);
        String[] strArrA = com.umeng.analytics.c.a(f23689a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.d.M, strArrA[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int iA = r.a().a(f23689a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
            return null;
        }
        r.a().b(jSONObjectB, f23689a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            b(jSONObjectK);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject2.put("header", jSONObjectK);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j10);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z10) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f23701b == null) {
            this.f23701b = new c();
        }
        this.f23701b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.f23701b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z10);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval) || (reportStrategyC instanceof ReportPolicy.DebugPolicy) || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + reportStrategyC.getClass().getSimpleName());
            }
        }
        return zShouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f23699y;
        if (cls == null || (method = f23700z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.f23510n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f23510n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f23510n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put(db.d.f26139i, jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th2) {
            MLog.e(th2);
        }
    }

    public void a(Object obj, int i10) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i10 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                h.a(f23689a);
                com.umeng.commonsdk.utils.c.c(f23689a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                switch (i10) {
                    case 4097:
                        if (UMUtils.isMainProgress(f23689a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if (f23697t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        }
                        UMProcessDBHelper.getInstance(f23689a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f23689a), new JSONArray().put(obj));
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if (f23697t.equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4099:
                        v.a(f23689a);
                        return;
                    case 4100:
                        l.c(f23689a);
                        return;
                    case 4101:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case 4102:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case 4103:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        u.a().a(f23689a, obj);
                        synchronized (this.f23714w) {
                            this.f23713v = true;
                            break;
                        }
                        return;
                    case 4104:
                        u.a().c(f23689a, obj);
                        return;
                    case 4105:
                        d();
                        return;
                    case 4106:
                        h(obj);
                        return;
                    default:
                        switch (i10) {
                            case 4352:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                u.a().b(f23689a, obj);
                                synchronized (this.f23714w) {
                                    this.f23712u = true;
                                    break;
                                }
                                return;
                            case a.f23726l /* 4353 */:
                                a(obj, true);
                                return;
                            case a.f23727m /* 4354 */:
                                c();
                                return;
                            case a.f23728n /* 4355 */:
                                if (!UMUtils.isMainProgress(f23689a)) {
                                    UMProcessDBHelper.getInstance(f23689a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f23689a), new JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    }
                                    return;
                                }
                            case a.f23729o /* 4356 */:
                                if (obj == null || f23699y == null || f23700z == null) {
                                    return;
                                }
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                String string = "";
                                String string2 = "";
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.d.M)) {
                                        string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                                        string2 = jSONObject.getString("uid");
                                    }
                                    a(string2, string);
                                    return;
                                }
                                return;
                            default:
                                switch (i10) {
                                    case 8195:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case 8196:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case 8197:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i10) {
                                            case a.f23736v /* 8199 */:
                                            case a.f23737w /* 8200 */:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case a.f23738x /* 8201 */:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i10) {
                                                    case a.f23739y /* 8208 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f23689a;
                                                        UMWorkDispatch.sendEvent(context, a.f23740z, CoreProtocol.getInstance(context), null);
                                                        Context context2 = f23689a;
                                                        UMWorkDispatch.sendEvent(context2, a.f23727m, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case a.f23740z /* 8209 */:
                                                        a(obj, false);
                                                        return;
                                                    case a.A /* 8210 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(f23689a) || (this.f23701b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        switch (i10) {
                                                            case a.D /* 8213 */:
                                                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (DeviceConfig.getGlobleActivity(f23689a) != null) {
                                                                        u.b(f23689a);
                                                                    }
                                                                    Context context3 = f23689a;
                                                                    UMWorkDispatch.sendEventEx(context3, a.D, CoreProtocol.getInstance(context3), null, 5000L);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.E /* 8214 */:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    String strOptString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                    String strOptString2 = ((JSONObject) obj).optString("period");
                                                                    String strOptString3 = ((JSONObject) obj).optString("debugkey");
                                                                    if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                                                                        return;
                                                                    }
                                                                    Context context4 = f23689a;
                                                                    String str = AnalyticsConfig.RTD_SP_FILE;
                                                                    com.umeng.common.b.a(context4, str, AnalyticsConfig.RTD_START_TIME, strOptString);
                                                                    com.umeng.common.b.a(f23689a, str, "period", strOptString2);
                                                                    com.umeng.common.b.a(f23689a, str, "debugkey", strOptString3);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.F /* 8215 */:
                                                                com.umeng.common.b.a(f23689a, AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f23689a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                String string2 = jSONObject.getString("uid");
                long j10 = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(f23689a);
                if (strArrA != null && string.equals(strArrA[0]) && string2.equals(strArrA[1])) {
                    return;
                }
                u.a().a(f23689a, j10);
                String strC = y.a().c(f23689a);
                boolean zB = u.a().b(f23689a, j10, false);
                com.umeng.analytics.c.a(f23689a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                u.a().a(f23689a, j10, true);
                if (zB) {
                    u.a().b(f23689a, j10);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            Context context = f23689a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j10 = sharedPreferences.getLong(f23690l, 0L);
            if (j10 == 0) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f23690l, jCurrentTimeMillis).commit();
                    return jCurrentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j10;
        } catch (Throwable unused2) {
            return jCurrentTimeMillis;
        }
    }

    public void c(Object obj) {
        b(f23689a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j10 = jSONObject.getLong("ts");
                b(f23689a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(f23689a);
                if (strArrA == null || TextUtils.isEmpty(strArrA[0]) || TextUtils.isEmpty(strArrA[1])) {
                    return;
                }
                u.a().a(f23689a, j10);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + y.a().c(f23689a));
                boolean zB = u.a().b(f23689a, j10, false);
                com.umeng.analytics.c.b(f23689a);
                u.a().a(f23689a, j10, true);
                if (zB) {
                    u.a().b(f23689a, j10);
                }
            }
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th2);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j10) {
        try {
            if (q.a(jSONObject) <= j10) {
                return jSONObject;
            }
            jSONObject = null;
            i.a(f23689a).a(true, false);
            i.a(f23689a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z10) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = i.a(f23689a).a(z10);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            } else {
                try {
                    boolean zHas = jSONObjectA.has(com.umeng.analytics.pro.d.f23510n);
                    jSONObjectA = jSONObjectA;
                    if (zHas) {
                        JSONArray jSONArray3 = jSONObjectA.getJSONArray(com.umeng.analytics.pro.d.f23510n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i10 = 0;
                        while (i10 < jSONArray3.length()) {
                            JSONObject jSONObject = (JSONObject) jSONArray3.get(i10);
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pages");
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.umeng.analytics.pro.d.f23517u);
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                jSONObject.put("pages", jSONArrayOptJSONArray2);
                                jSONObject.remove(com.umeng.analytics.pro.d.f23517u);
                            }
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i11));
                                }
                                for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i12));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.f23520x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    jSONArray5.put((JSONObject) it2.next());
                                }
                                jSONObject.put("pages", jSONArray5);
                                jSONObject.remove(com.umeng.analytics.pro.d.f23517u);
                            }
                            if (jSONObject.has("pages")) {
                                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("pages");
                                int i13 = 0;
                                while (i13 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i13);
                                    if (jSONObject2.has(com.umeng.analytics.pro.d.f23520x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject2.put("ts", jSONObject2.getLong(com.umeng.analytics.pro.d.f23520x));
                                        jSONObject2.remove(com.umeng.analytics.pro.d.f23520x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i13++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject.put("pages", jSONArrayOptJSONArray3);
                                jSONObject.put(com.umeng.analytics.pro.d.f23522z, jSONArrayOptJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.d.f23522z, 0);
                            }
                            jSONArray4.put(jSONObject);
                            i10++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObjectA.put(com.umeng.analytics.pro.d.f23510n, jSONArray4);
                        jSONObjectA = jSONObjectA;
                    }
                } catch (Exception e10) {
                    MLog.e("merge pages error");
                    e10.printStackTrace();
                    jSONObjectA = jSONObjectA;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f23689a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObjectA.put("userlevel", string);
                }
            }
            String[] strArrA = com.umeng.analytics.c.a(f23689a);
            if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(com.umeng.analytics.pro.d.M, strArrA[0]);
                jSONObject3.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                if (jSONObject3.length() > 0) {
                    jSONObjectA.put(com.umeng.analytics.pro.d.L, jSONObject3);
                }
            }
            if (ABTest.getService(f23689a).isInTest()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(ABTest.getService(f23689a).getTestName(), ABTest.getService(f23689a).getGroupInfo());
                jSONObjectA.put(com.umeng.analytics.pro.d.K, jSONObject4);
            }
            r.a().a(jSONObjectA, f23689a);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z10) {
        if (this.f23701b == null) {
            this.f23701b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.f23701b.c();
        if (!(reportStrategyC instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z10) {
            return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
        }
        return reportStrategyC.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z10) {
        if (c(z10)) {
            if (!(this.f23701b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f23689a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z10) {
                if (UMEnvelopeBuild.isOnline(f23689a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f23689a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                    if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                        i10++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    public JSONObject a(long j10) {
        if (TextUtils.isEmpty(y.a().d(f23689a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = r.a().a(f23689a);
        if (jSONObjectB.length() > 0) {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(com.umeng.analytics.pro.d.f23510n);
            String strOptString2 = jSONObjectB.optString(com.umeng.analytics.pro.d.T);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && a(jSONObjectB)) {
                return null;
            }
        } else if (iA != 3) {
            return null;
        }
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            c(jSONObjectL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectL != null && jSONObjectL.length() > 0) {
                jSONObject.put("header", jSONObjectL);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j10);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j10) {
        try {
            if (q.a(jSONObject) <= j10) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.d.aB, q.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return q.a(f23689a, j10, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j10, int i10) {
        if (j10 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j10 <= 28800000) {
            return i10 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z10) {
        if (z10) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f23689a) && d(true)) {
            i();
        }
    }
}
