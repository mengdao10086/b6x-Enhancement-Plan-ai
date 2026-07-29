package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23672c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.umeng.analytics.vshelper.a f23673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f23674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f23675h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f23676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f23678n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static JSONArray f23665i = new JSONArray();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f23666j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Application f23667k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f23663d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f23664e = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f23668o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Object f23669p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static as f23670q = new com.umeng.analytics.vshelper.b();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f23680a = new l();

        private a() {
        }
    }

    public static /* synthetic */ int a(l lVar) {
        int i10 = lVar.f23678n;
        lVar.f23678n = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int b(l lVar) {
        int i10 = lVar.f23677m;
        lVar.f23677m = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int e(l lVar) {
        int i10 = lVar.f23678n;
        lVar.f23678n = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int f(l lVar) {
        int i10 = lVar.f23677m;
        lVar.f23677m = i10 + 1;
        return i10;
    }

    private void g() {
        if (this.f23676l) {
            return;
        }
        this.f23676l = true;
        if (f23667k != null) {
            f23667k.registerActivityLifecycleCallbacks(this.f23674g);
        }
    }

    private l() {
        this.f23675h = new HashMap();
        this.f23676l = false;
        this.f23671b = false;
        this.f23672c = false;
        this.f23677m = 0;
        this.f23678n = 0;
        this.f23673f = PageNameMonitor.getInstance();
        this.f23674g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.f23670q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.f23669p) {
                        if (l.f23668o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.f23671b = false;
                    l.f23670q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.f23669p) {
                        if (l.f23668o) {
                            boolean unused = l.f23668o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.f23670q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f23677m <= 0) {
                        if (l.f23663d == null) {
                            l.f23663d = UUID.randomUUID().toString();
                        }
                        if (l.f23664e == -1) {
                            l.f23664e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f23664e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            }
                            l.f23664e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.f23636ar);
                            }
                        } else if (l.f23664e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", l.f23663d);
                            map2.put("pid", Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                            }
                        }
                    }
                    if (l.this.f23678n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f23677m <= 0) {
                        if (l.f23664e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i10 = l.f23664e;
                        if (i10 == 1 || (i10 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", l.f23663d);
                            map.put("reason", "Normal");
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            }
                            if (l.f23663d != null) {
                                l.f23663d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f23667k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f23669p) {
            if (f23668o) {
                f23668o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f23666j) {
                    string = f23665i.toString();
                    f23665i = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(e.d.a.f23568c, new JSONArray(string));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f23676l;
    }

    public static synchronized l a(Context context) {
        if (f23667k == null && context != null) {
            if (context instanceof Activity) {
                f23667k = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                f23667k = (Application) context;
            }
        }
        return a.f23680a;
    }

    public static void a(Context context, String str) {
        if (f23664e == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", f23663d);
            map.put("reason", str);
            if (f23663d != null) {
                f23663d = null;
            }
            if (context != null) {
                map.put("pid", Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    public void b() {
        this.f23676l = false;
        if (f23667k != null) {
            f23667k.unregisterActivityLifecycleCallbacks(this.f23674g);
            f23667k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j10;
        long j11;
        try {
            synchronized (this.f23675h) {
                if (f23662a == null && activity != null) {
                    f23662a = activity.getPackageName() + j3.b.f36044h + activity.getLocalClassName();
                }
                j10 = 0;
                if (TextUtils.isEmpty(f23662a) || !this.f23675h.containsKey(f23662a)) {
                    j11 = 0;
                } else {
                    long jLongValue = this.f23675h.get(f23662a).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.f23675h.remove(f23662a);
                    j10 = jCurrentTimeMillis;
                    j11 = jLongValue;
                }
            }
            synchronized (f23666j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.f23518v, f23662a);
                    jSONObject.put("duration", j10);
                    jSONObject.put(d.f23520x, j11);
                    jSONObject.put("type", 0);
                    f23665i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f23662a = activity.getPackageName() + j3.b.f36044h + activity.getLocalClassName();
        synchronized (this.f23675h) {
            this.f23675h.put(f23662a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f23669p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + j3.b.f36044h + activity.getLocalClassName();
            this.f23673f.activityResume(str);
            if (this.f23671b) {
                this.f23671b = false;
                if (!TextUtils.isEmpty(f23662a)) {
                    if (f23662a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f23669p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f23662a = str;
                return;
            }
            b(activity);
            synchronized (f23669p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
