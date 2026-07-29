package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f23123a = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f23124h = "sp_uapp";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f23125i = "prepp_uapp";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f23126o = 128;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f23127p = 256;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f23128q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f23129r = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f23131t = "ekv_bl_ver";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f23133w = "ekv_wl_ver";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f23134z = "umsp_1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISysListener f23135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f23136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v f23137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f23138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u f23139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l f23140g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f23141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile JSONObject f23142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile JSONObject f23143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile JSONObject f23144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23145n;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.umeng.analytics.filter.a f23146u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.umeng.analytics.filter.b f23147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private m f23148y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f23130s = d.f23488al;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f23132v = d.f23489am;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f23149a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f23123a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.f23149a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f23142k == null) {
                this.f23142k = new JSONObject();
            }
            if (this.f23143l == null) {
                this.f23143l = new JSONObject();
            }
            String string = sharedPreferences.getString(f23125i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f23144m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f23144m == null) {
                this.f23144m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f23142k;
    }

    public JSONObject c() {
        return this.f23144m;
    }

    public JSONObject d() {
        return this.f23143l;
    }

    public void e() {
        this.f23143l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f23123a)) {
            return f23128q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f23123a)) {
            return f23129r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            Context context = f23123a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Context context2 = f23123a;
                UMWorkDispatch.sendEvent(context2, 4352, CoreProtocol.getInstance(context2), Long.valueOf(jCurrentTimeMillis));
                Context context3 = f23123a;
                UMWorkDispatch.sendEvent(context3, 4103, CoreProtocol.getInstance(context3), Long.valueOf(jCurrentTimeMillis));
            }
            ISysListener iSysListener = this.f23135b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    public void j() {
        try {
            Context context = f23123a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", jCurrentTimeMillis);
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, 4102, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f23123a;
            UMWorkDispatch.sendEvent(context3, o.a.f23729o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th2);
            }
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = f23123a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f23142k != null) {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f23123a).edit();
            editorEdit.putString(f23124h, this.f23142k.toString());
            editorEdit.commit();
        } else {
            this.f23142k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = f23123a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f23142k == null) {
            this.f23142k = new JSONObject();
        }
        return this.f23142k;
    }

    public synchronized void m() {
        try {
            Context context = f23123a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f23123a).edit();
                    editorEdit.remove(f23124h);
                    editorEdit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(o.a.A)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f23123a;
                UMWorkDispatch.sendEvent(context, o.a.A, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f23136c = new p();
        this.f23137d = new v();
        this.f23138e = new k();
        this.f23139f = u.a();
        this.f23140g = null;
        this.f23141j = false;
        this.f23142k = null;
        this.f23143l = null;
        this.f23144m = null;
        this.f23145n = false;
        this.f23146u = null;
        this.f23147x = null;
        this.f23148y = null;
        this.f23136c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (this.f23146u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f23130s, "ekv_bl_ver");
                this.f23146u = aVar;
                aVar.register(f23123a);
            }
            if (this.f23147x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(f23132v, "ekv_wl_ver");
                this.f23147x = bVar;
                bVar.register(f23123a);
            }
            if (UMUtils.isMainProgress(f23123a)) {
                if (!this.f23141j) {
                    this.f23141j = true;
                    i(f23123a);
                }
                synchronized (this) {
                    if (!this.f23145n) {
                        l lVarA = l.a(context);
                        this.f23140g = lVarA;
                        if (lVarA.a()) {
                            this.f23145n = true;
                        }
                        this.f23148y = m.a();
                        try {
                            m.a(context);
                            this.f23148y.a(this);
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f23123a));
            }
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f23137d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context) {
        if (context == null) {
            UMLog.aq(j.f23651p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.f23652q, 2, "\\|");
        }
        try {
            if (!this.f23141j || !this.f23145n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f23138e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th2);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            f23129r = context.getClass().getName();
        }
    }

    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23123a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            l lVar = this.f23140g;
            if (lVar != null) {
                lVar.c();
            }
            l.a(context, "onKillProcess");
            k kVar = this.f23138e;
            if (kVar != null) {
                kVar.b();
            }
            v vVar = this.f23137d;
            if (vVar != null) {
                vVar.b();
            }
            Context context2 = f23123a;
            if (context2 != null) {
                u uVar = this.f23139f;
                if (uVar != null) {
                    uVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(f23123a).d();
                v.a(f23123a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f23123a);
                }
                PreferenceWrapper.getDefault(f23123a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f23627ai, 0, "\\|");
            return null;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.f23625ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f23134z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f23142k == null) {
            this.f23142k = new JSONObject();
        } else if (this.f23142k.has(str)) {
            return this.f23142k.opt(str);
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.f23626ah, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        this.f23142k = new JSONObject();
        Context context2 = f23123a;
        UMWorkDispatch.sendEvent(context2, 8196, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.f23634ap, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (this.f23144m.length() > 0) {
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, o.a.f23738x, CoreProtocol.getInstance(context2), null);
        }
        this.f23144m = new JSONObject();
    }

    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.f23650o, 2, "\\|");
        }
        try {
            if (!this.f23141j || !this.f23145n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f23138e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f23128q = context.getClass().getName();
            }
        } catch (Throwable th2) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th2);
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.f23635aq, 0, "\\|");
            return null;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (this.f23144m == null) {
            this.f23144m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f23144m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f23144m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f23123a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f23123a;
                UMWorkDispatch.sendEvent(context2, 4104, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f23123a;
                UMWorkDispatch.sendEvent(context3, 4100, CoreProtocol.getInstance(context3), null);
                Context context4 = f23123a;
                UMWorkDispatch.sendEvent(context4, 4099, CoreProtocol.getInstance(context4), null);
                Context context5 = f23123a;
                UMWorkDispatch.sendEvent(context5, 4105, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f23135b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f23632an, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (this.f23144m == null) {
            this.f23144m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f23144m.has(str)) {
                this.f23144m.remove(str);
                Context context2 = f23123a;
                UMWorkDispatch.sendEvent(context2, o.a.f23737w, CoreProtocol.getInstance(context2), this.f23144m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.f23633ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean c(String str) {
        if (this.f23146u.enabled() && this.f23146u.matchHit(str)) {
            return true;
        }
        if (!this.f23147x.enabled()) {
            return false;
        }
        if (!this.f23147x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(j.f23626ah, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.f23625ag, 0, "\\|");
            return;
        }
        if (!str.equals(f23134z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f23142k == null) {
            this.f23142k = new JSONObject();
        }
        if (this.f23142k.has(str)) {
            this.f23142k.remove(str);
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, 8197, CoreProtocol.getInstance(context2), str);
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23123a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f23141j || !this.f23145n) {
                a(f23123a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put(d.aE, str);
                a(f23123a, d.aD, (Map<String, Object>) map, -1L, false);
                return;
            }
            UMLog.aq(j.O, 0, "\\|");
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.f23627ai, 0, "\\|");
            return null;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f23142k != null) {
            return this.f23142k.toString();
        }
        this.f23142k = new JSONObject();
        return null;
    }

    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f23661z, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        AnalyticsConfig.a(f23123a, str);
    }

    public void a(String str) {
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f23137d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f23135b = iSysListener;
        }
    }

    public void a(Context context, int i10) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        AnalyticsConfig.a(f23123a, i10);
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = f23123a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f23123a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f23125i, str).commit();
            }
        } else if (editorEdit != null) {
            editorEdit.remove(f23125i).commit();
        }
    }

    public void a(Context context, String str, HashMap<String, Object> map) {
        if (context == null) {
            return;
        }
        try {
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23123a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f23141j || !this.f23145n) {
                a(f23123a);
            }
            String string = "";
            if (this.f23142k == null) {
                this.f23142k = new JSONObject();
            } else {
                string = this.f23142k.toString();
            }
            s.a(f23123a).a(str, map, string);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int length;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            length = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            length = 0;
        }
        if (length > 128) {
            MLog.e("key length is " + length + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    public void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f23658w, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.f23659x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.f23141j || !this.f23145n) {
                a(f23123a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(d.Q, 2);
            jSONObject.put(d.R, str);
            jSONObject.put("__ii", this.f23139f.c());
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, 4106, CoreProtocol.getInstance(context2), jSONObject);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public void a(Context context, Throwable th2) {
        if (context != null && th2 != null) {
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23123a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f23141j || !this.f23145n) {
                    a(f23123a);
                }
                a(f23123a, DataHelper.convertExceptionToString(th2));
                return;
            } catch (Exception e10) {
                if (MLog.DEBUG) {
                    MLog.e(e10);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.f23660y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j10, int i10) {
        if (context == null) {
            return;
        }
        try {
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!this.f23141j || !this.f23145n) {
                a(f23123a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f23142k == null) {
                this.f23142k = new JSONObject();
            } else {
                string = this.f23142k.toString();
            }
            s.a(f23123a).a(str, str2, j10, i10, string);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public void a(Context context, String str, Map<String, Object> map, long j10) {
        try {
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(d.aF).contains(str)) {
                UMLog.aq(j.f23637b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(j.f23639d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (Arrays.asList(d.aF).contains(it2.next().getKey())) {
                    UMLog.aq(j.f23640e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j10, false);
            return;
        }
        UMLog.aq(j.f23638c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j10, boolean z10) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f23123a == null) {
                f23123a = context.getApplicationContext();
            }
            if (!this.f23141j || !this.f23145n) {
                a(f23123a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f23142k == null) {
                this.f23142k = new JSONObject();
            } else {
                string = this.f23142k.toString();
            }
            s.a(f23123a).a(str, map, j10, string, z10);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th2) {
        try {
            Context context = f23123a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                v vVar = this.f23137d;
                if (vVar != null) {
                    vVar.b();
                }
                l.a(f23123a, "onAppCrash");
                k kVar = this.f23138e;
                if (kVar != null) {
                    kVar.b();
                }
                l lVar = this.f23140g;
                if (lVar != null) {
                    lVar.c();
                }
                u uVar = this.f23139f;
                if (uVar != null) {
                    uVar.c(f23123a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(d.Q, 1);
                    jSONObject.put(d.R, DataHelper.convertExceptionToString(th2));
                    i.a(f23123a).a(this.f23139f.c(), jSONObject.toString(), 1);
                }
                o.a(f23123a).d();
                v.a(f23123a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f23123a);
                }
                PreferenceWrapper.getDefault(f23123a).edit().commit();
            }
        } catch (Exception e10) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e10);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            Context context = f23123a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", jCurrentTimeMillis);
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, 4101, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f23123a;
            UMWorkDispatch.sendEvent(context3, o.a.f23729o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th2);
            }
        }
    }

    public void a(boolean z10) {
        Context context = f23123a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z10;
        }
    }

    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    public void a(double d10, double d11) {
        Context context = f23123a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f23100a == null) {
            AnalyticsConfig.f23100a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f23100a;
        dArr[0] = d10;
        dArr[1] = d11;
    }

    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f23123a, eScenarioType.toValue());
        }
        if (this.f23141j && this.f23145n) {
            return;
        }
        a(f23123a);
    }

    public void a(long j10) {
        Context context = f23123a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j10;
            y.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i10 = 0;
        if (context == null) {
            UMLog.aq(j.f23624af, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f23134z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f23142k == null) {
                    this.f23142k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i10 < strArr.length) {
                            if (strArr[i10] != null && HelperUtils.checkStrLen(strArr[i10], 256)) {
                                jSONArray.put(strArr[i10]);
                                i10++;
                            }
                            MLog.e("please check value, length is " + strArr[i10].length() + ", overlength 256!");
                            return;
                        }
                        this.f23142k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i10 < jArr.length) {
                            jSONArray2.put(jArr[i10]);
                            i10++;
                        }
                        this.f23142k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i10 < iArr.length) {
                            jSONArray3.put(iArr[i10]);
                            i10++;
                        }
                        this.f23142k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i10 < fArr.length) {
                            jSONArray4.put(fArr[i10]);
                            i10++;
                        }
                        this.f23142k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i10 < dArr.length) {
                            jSONArray5.put(dArr[i10]);
                            i10++;
                        }
                        this.f23142k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i10 < sArr.length) {
                            jSONArray6.put((int) sArr[i10]);
                            i10++;
                        }
                        this.f23142k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f23142k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            Context context2 = f23123a;
            UMWorkDispatch.sendEvent(context2, 8195, CoreProtocol.getInstance(context2), this.f23142k.toString());
            return;
        }
        UMLog.aq(j.f23625ag, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.f23142k == null) {
                this.f23142k = new JSONObject();
            }
            int i10 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i10 < strArr.length) {
                        if (strArr[i10] != null && !HelperUtils.checkStrLen(strArr[i10], 256)) {
                            jSONArray.put(strArr[i10]);
                        }
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i10 < jArr.length) {
                        jSONArray2.put(jArr[i10]);
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i10 < iArr.length) {
                        jSONArray3.put(iArr[i10]);
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i10 < fArr.length) {
                        jSONArray4.put(fArr[i10]);
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i10 < dArr.length) {
                        jSONArray5.put(dArr[i10]);
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i10 < sArr.length) {
                        jSONArray6.put((int) sArr[i10]);
                        i10++;
                    }
                    this.f23142k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i10 < list.size()) {
                    Object obj2 = list.get(i10);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i10));
                    }
                    i10++;
                }
                this.f23142k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f23142k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = f23123a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f23123a).edit();
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f23124h, this.f23142k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th2) {
            MLog.e(th2);
        }
        if (context == null) {
            UMLog.aq(j.f23628aj, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        s.a(f23123a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            UMLog.aq(j.f23630al, 0, "\\|");
            return;
        }
        if (f23123a == null) {
            f23123a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23123a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f23141j || !this.f23145n) {
            a(f23123a);
        }
        if (this.f23144m == null) {
            this.f23144m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f23144m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    try {
                        String string = itKeys.next().toString();
                        Object obj = jSONObject.get(string);
                        if (b(string, obj)) {
                            jSONObject2.put(string, obj);
                            if (jSONObject2.length() > 10) {
                                MLog.e("please check propertics, size overlength!");
                                return;
                            }
                            continue;
                        } else {
                            return;
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.f23144m = jSONObject2;
            if (this.f23144m.length() > 0) {
                Context context2 = f23123a;
                UMWorkDispatch.sendEvent(context2, o.a.f23736v, CoreProtocol.getInstance(context2), this.f23144m.toString());
            }
            return;
        }
        UMLog.aq(j.f23631am, 0, "\\|");
    }
}
