package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12964a = "LaunchConfigManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12965b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EfsReporter f12966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f12970g;

    public LaunchConfigManager(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.f12967d = 100;
        this.f12969f = false;
        Context applicationContext = context.getApplicationContext();
        this.f12970g = applicationContext;
        this.f12966c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.f12968e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f12970g.getSharedPreferences("efs_launch", 0);
        int i10 = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.f12966c.getAllSdkConfig(new String[]{"apm_startperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.launch.LaunchConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor editorEdit6;
                try {
                    Object obj = map.get("apm_startperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = LaunchConfigManager.this.f12970g.getSharedPreferences("efs_launch", 0)) == null || (editorEdit6 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    editorEdit6.putInt("apm_startperf_sampling_rate", Integer.parseInt(obj.toString()));
                    editorEdit6.commit();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f12967d = i10;
        }
        SharedPreferences sharedPreferences4 = this.f12970g.getSharedPreferences("efs_launch", 0);
        long j10 = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z10 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i11 = this.f12967d;
        boolean z11 = true;
        if (i11 != 0) {
            boolean z12 = i11 != this.f12968e;
            Long lValueOf = Long.valueOf(j10);
            int i12 = this.f12967d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (z10 && lValueOf3.longValue() < 86400000 && !z12) {
                boolean z13 = LaunchManager.isDebug;
            } else if (lValueOf3.longValue() >= 86400000 || z12) {
                if (i12 != 0 && (i12 == 100 || new Random().nextInt(100) <= i12)) {
                    boolean z14 = LaunchManager.isDebug;
                } else {
                    boolean z15 = LaunchManager.isDebug;
                    z11 = false;
                }
                SharedPreferences sharedPreferences5 = this.f12970g.getSharedPreferences("efs_launch", 0);
                if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                    editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z11);
                    editorEdit2.commit();
                }
                if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                    editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                    editorEdit.commit();
                }
            } else {
                boolean z16 = LaunchManager.isDebug;
            }
            this.f12969f = z11;
            sharedPreferences = this.f12970g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_startperf_sampling_rate_last", this.f12967d);
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
        this.f12969f = z11;
        sharedPreferences = this.f12970g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f12969f;
    }
}
