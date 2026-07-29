package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class NetConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13027a = "NetConfigManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13028b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EfsReporter f13029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f13033g;

    public NetConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.f13030d = 0;
        this.f13032f = false;
        Context applicationContext = context.getApplicationContext();
        this.f13033g = applicationContext;
        this.f13029c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            this.f13031e = sharedPreferences2.getInt("apm_netperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f13033g.getSharedPreferences("net_launch", 0);
        int i10 = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_netperf_sampling_rate", -1) : -1;
        this.f13029c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                final SharedPreferences.Editor editorEdit6;
                try {
                    final Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = NetConfigManager.this.f13033g.getSharedPreferences("net_launch", 0)) == null || (editorEdit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            editorEdit6.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                            editorEdit6.commit();
                        }
                    }).start();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f13030d = i10;
        }
        SharedPreferences sharedPreferences4 = this.f13033g.getSharedPreferences("net_launch", 0);
        long j10 = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z10 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i11 = this.f13030d;
        boolean z11 = true;
        if (i11 != 0) {
            boolean z12 = i11 != this.f13031e;
            Long lValueOf = Long.valueOf(j10);
            int i12 = this.f13030d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (z10 && lValueOf3.longValue() < 86400000 && !z12) {
                Log.d("NetConfigManager", " check in allready");
            } else if (lValueOf3.longValue() >= 86400000 || z12) {
                if (i12 != 0 && (i12 == 100 || new Random().nextInt(100) <= i12)) {
                    Log.d("NetConfigManager", "random check in");
                } else {
                    Log.d("NetConfigManager", "random not check in!");
                    z11 = false;
                }
                SharedPreferences sharedPreferences5 = this.f13033g.getSharedPreferences("net_launch", 0);
                if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                    editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z11);
                    editorEdit2.commit();
                }
                if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                    editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                    editorEdit.commit();
                }
            } else {
                Log.d("NetConfigManager", "un repeat check in 24 hour!");
            }
            this.f13032f = z11;
            sharedPreferences = this.f13033g.getSharedPreferences("net_launch", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_netperf_sampling_rate_last", this.f13030d);
            editorEdit3.commit();
            return;
        }
        if (z10 && sharedPreferences4 != null && (editorEdit5 = sharedPreferences4.edit()) != null) {
            editorEdit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            editorEdit5.commit();
        }
        if (j10 != 0 && sharedPreferences4 != null && (editorEdit4 = sharedPreferences4.edit()) != null) {
            editorEdit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            editorEdit4.commit();
        }
        z11 = false;
        this.f13032f = z11;
        sharedPreferences = this.f13033g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f13032f;
    }
}
