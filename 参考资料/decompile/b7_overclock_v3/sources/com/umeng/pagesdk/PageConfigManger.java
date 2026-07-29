package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public class PageConfigManger {
    public static final String APM_FPSPERF_COLLECT_INTERVAL = "apm_pageperf_collect_interval";
    public static final String APM_FPSPERF_COLLECT_INTERVAL_TOGETHER = "apm_pageperf_collect_interval_together";
    public static final String APM_FPSPERF_COLLECT_MAX_PERIOD_SEC = "apm_pageperf_collect_max_period_sec";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f24451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EfsReporter f24452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24456g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24450a = "PageConfigManager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24454e = 0;

    public PageConfigManger(Context context, EfsReporter efsReporter) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.f24453d = 100;
        this.f24456g = false;
        Context applicationContext = context.getApplicationContext();
        this.f24451b = applicationContext;
        this.f24452c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_page", 0);
        if (sharedPreferences2 != null) {
            this.f24455f = sharedPreferences2.getInt("apm_pageperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.f24451b.getSharedPreferences("efs_page", 0);
        int i10 = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_pageperf_sampling_rate", -1) : -1;
        this.f24452c.getAllSdkConfig(new String[]{"apm_pageperf_sampling_rate", APM_FPSPERF_COLLECT_INTERVAL, APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, APM_FPSPERF_COLLECT_MAX_PERIOD_SEC}, new IConfigCallback() { // from class: com.umeng.pagesdk.PageConfigManger.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences.Editor editorEdit6;
                try {
                    SharedPreferences sharedPreferences4 = PageConfigManger.this.f24451b.getSharedPreferences("efs_page", 0);
                    if (sharedPreferences4 == null || (editorEdit6 = sharedPreferences4.edit()) == null || map == null) {
                        return;
                    }
                    Object obj = map.get("apm_pageperf_sampling_rate");
                    if (obj != null) {
                        editorEdit6.putInt("apm_pageperf_sampling_rate", Integer.parseInt(obj.toString()));
                    }
                    Object obj2 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL);
                    if (obj2 != null) {
                        editorEdit6.putFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, Float.parseFloat(obj2.toString()) * 1000.0f);
                    }
                    Object obj3 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER);
                    if (obj3 != null) {
                        editorEdit6.putInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, Integer.parseInt(obj3.toString()));
                    }
                    Object obj4 = map.get(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC);
                    if (obj4 != null) {
                        editorEdit6.putLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, Long.parseLong(obj4.toString()) * 1000);
                    }
                    editorEdit6.commit();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
        if (i10 != -1) {
            this.f24453d = i10;
        }
        SharedPreferences sharedPreferences4 = this.f24451b.getSharedPreferences("efs_page", 0);
        long j10 = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z10 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i11 = this.f24453d;
        boolean z11 = true;
        if (i11 != 0) {
            boolean z12 = i11 != this.f24455f;
            Long lValueOf = Long.valueOf(j10);
            int i12 = this.f24453d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (z10 && lValueOf3.longValue() < 86400000 && !z12) {
                boolean z13 = PageManger.isDebug;
            } else if (lValueOf3.longValue() >= 86400000 || z12) {
                if (i12 != 0 && (i12 == 100 || new Random().nextInt(100) <= i12)) {
                    boolean z14 = PageManger.isDebug;
                } else {
                    boolean z15 = PageManger.isDebug;
                    z11 = false;
                }
                SharedPreferences sharedPreferences5 = this.f24451b.getSharedPreferences("efs_page", 0);
                if (sharedPreferences5 != null && (editorEdit2 = sharedPreferences5.edit()) != null) {
                    editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z11);
                    editorEdit2.commit();
                }
                if (sharedPreferences5 != null && (editorEdit = sharedPreferences5.edit()) != null) {
                    editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                    editorEdit.commit();
                }
            } else {
                boolean z16 = PageManger.isDebug;
            }
            this.f24456g = z11;
            sharedPreferences = this.f24451b.getSharedPreferences("efs_page", 0);
            if (sharedPreferences != null || (editorEdit3 = sharedPreferences.edit()) == null) {
            }
            editorEdit3.putInt("apm_pageperf_sampling_rate_last", this.f24453d);
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
        this.f24456g = z11;
        sharedPreferences = this.f24451b.getSharedPreferences("efs_page", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f24456g;
    }
}
