package com.efs.sdk.base.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import g.n0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f12810a = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f12811b = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", 2097152L);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, AtomicInteger> f12812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile SharedPreferences f12813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile SharedPreferences.Editor f12814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f12815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12816g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12817a = new b(0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b a() {
        return a.f12817a;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th2) {
            Log.e("efs.flow", "init sharedpreferences error", th2);
        }
    }

    private void c() {
        if (this.f12813d == null) {
            synchronized (b.class) {
                if (this.f12813d == null) {
                    this.f12813d = SharedPreferencesUtils.getSharedPreferences(this.f12815f, this.f12816g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.f12814e == null) {
            synchronized (b.class) {
                if (this.f12814e == null) {
                    this.f12814e = this.f12813d.edit();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@n0 Message message) {
        super.handleMessage(message);
        int i10 = message.what;
        if (i10 == 0) {
            b();
            if (this.f12813d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
                return;
            }
            if (this.f12814e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
                return;
            }
            String strValueOf = String.valueOf(message.obj);
            long j10 = message.arg1;
            String strB = b.a.f12871a.b();
            for (String str : f12810a.keySet()) {
                String strConcat = "curr_time_".concat(String.valueOf(str));
                if (!this.f12813d.contains(strConcat)) {
                    this.f12814e.putLong(strConcat, System.currentTimeMillis());
                }
                for (String str2 : a(str, strValueOf, strB)) {
                    this.f12814e.putLong(str2, this.f12813d.getLong(str2, 0L) + j10);
                }
            }
            this.f12814e.apply();
            return;
        }
        if (i10 != 1) {
            Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
            return;
        }
        String strValueOf2 = String.valueOf(message.obj);
        long j11 = message.arg1;
        b();
        if (this.f12813d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            return;
        }
        if (this.f12814e == null) {
            Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            return;
        }
        String strConcat2 = "curr_time_".concat(strValueOf2);
        if (Math.abs(System.currentTimeMillis() - this.f12813d.getLong(strConcat2, System.currentTimeMillis())) >= j11) {
            for (String str3 : this.f12813d.getAll().keySet()) {
                if (str3.startsWith(strValueOf2)) {
                    this.f12814e.putLong(str3, 0L);
                }
            }
            this.f12814e.putLong(strConcat2, System.currentTimeMillis());
            this.f12814e.apply();
            this.f12812c.clear();
        }
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper());
        this.f12812c = new ConcurrentHashMap(5);
        this.f12815f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.f12816g = ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        File fileC = com.efs.sdk.base.core.util.a.c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileC.exists()) {
            com.efs.sdk.base.core.util.b.b(fileC);
        }
    }

    private boolean a(@n0 String str, long j10, @n0 String str2, @n0 String str3, long j11) {
        b();
        if (this.f12813d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> listA = a(str, str2, str3);
        Map<String, String> mapC = com.efs.sdk.base.core.config.a.c.a().c();
        for (String str4 : listA) {
            if (Math.abs(System.currentTimeMillis() - this.f12813d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j10) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                messageObtain.arg1 = Long.valueOf(j10).intValue();
                sendMessage(messageObtain);
            }
            long jA = a(mapC, str, str4);
            long j12 = this.f12813d.getLong(str4, 0L);
            if (j12 + j11 > jA) {
                Log.i("efs.flow", "flow limit, key: " + str4 + ", max: " + jA + ", now: " + j12 + ", size: " + j11);
                a(str4);
                return false;
            }
        }
        return true;
    }

    private void a(String str) {
        if (!this.f12812c.containsKey(str) || this.f12812c.get(str) == null || this.f12812c.get(str).get() <= 10) {
            f.a.f12921a.a(com.efs.sdk.base.core.config.a.c.a().f12860d.f12850a, str);
            if (str.equals("flow_day")) {
                f.a.f12921a.a(com.efs.sdk.base.core.config.a.c.a().f12860d.f12850a);
            }
            if (!this.f12812c.containsKey(str)) {
                this.f12812c.put(str, new AtomicInteger());
            }
            this.f12812c.get(str).incrementAndGet();
        }
    }

    private static long a(Map<String, String> map, @n0 String str, @n0 String str2) {
        long jLongValue = f12811b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return jLongValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th2) {
            Log.w("efs.flow", "get max flow error", th2);
            return jLongValue;
        }
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }

    public final boolean a(@n0 String str, long j10) {
        String strB = b.a.f12871a.b();
        boolean zA = true;
        for (Map.Entry<String, Long> entry : f12810a.entrySet()) {
            zA = a(entry.getKey(), entry.getValue().longValue(), str, strB, j10);
            if (!zA) {
                break;
            }
        }
        return zA;
    }
}
