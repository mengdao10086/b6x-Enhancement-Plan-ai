package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile y f23790c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f23791a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23792b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f23793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23794e;

    public interface a {
        void a(String str, long j10, long j11, long j12);

        void a(String str, String str2, long j10, long j11, long j12);
    }

    private y() {
    }

    public static y a() {
        if (f23790c == null) {
            synchronized (y.class) {
                if (f23790c == null) {
                    f23790c = new y();
                }
            }
        }
        return f23790c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(u.f23772d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.f23792b;
        long jA = u.a(context);
        long j10 = jA * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + jA);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(jI, jH, j10, str, false);
        this.f23792b = this.f23791a.a(context);
        a(jI, jH, j10, str, true);
        this.f23791a.a(context, this.f23792b);
        return this.f23792b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f23792b) && i.a(context).a(this.f23792b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f23774f);
    }

    private long i(Context context) {
        return a(context, u.f23769a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j10 = sharedPreferences.getLong(u.f23773e, 0L);
            long j11 = sharedPreferences.getLong(u.f23774f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j10 > 0 && j11 == 0) {
                long jA = u.a(appContext);
                if (jA > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j11 = j10 + (jA * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j11 - j10));
            return this.f23791a.a(j10, j11);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f23791a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f23792b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f23792b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f23792b)) {
            try {
                this.f23792b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f23792b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f23792b)) {
            this.f23792b = d(context);
        }
        return TextUtils.isEmpty(this.f23792b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f23792b = d(appContext);
        if (e(appContext)) {
            try {
                this.f23792b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f23792b;
    }

    public void a(long j10) {
        this.f23791a.a(j10);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (y.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(u.f23772d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f23793d) == null || list.size() == 0) {
            return;
        }
        this.f23793d.remove(aVar);
    }

    public String a(Context context, long j10) {
        if (TextUtils.isEmpty(this.f23794e)) {
            String str = "SUB" + j10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f23794e = sb2.toString();
        }
        return this.f23794e;
    }

    private long a(Context context, String str) {
        long j10;
        try {
            j10 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j10 = 0;
        }
        return j10 <= 0 ? System.currentTimeMillis() : j10;
    }

    private void a(long j10, long j11, long j12, String str, boolean z10) {
        List<a> list = this.f23793d;
        if (list != null) {
            for (a aVar : list) {
                if (z10) {
                    try {
                        aVar.a(str, this.f23792b, j10, j11, j12);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f23792b, j10, j11, j12);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f23793d == null) {
            this.f23793d = new ArrayList();
        }
        if (this.f23793d.contains(aVar)) {
            return;
        }
        this.f23793d.add(aVar);
    }
}
