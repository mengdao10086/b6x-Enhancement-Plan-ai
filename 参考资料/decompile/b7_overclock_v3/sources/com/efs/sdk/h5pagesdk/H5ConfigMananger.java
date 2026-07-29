package com.efs.sdk.h5pagesdk;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class H5ConfigMananger {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EfsReporter f12953b;
    private Context mContext;
    private final String TAG = "H5ConfigMananger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12952a = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12954c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12955d = false;

    public H5ConfigMananger(Context context, EfsReporter efsReporter) {
        this.mContext = context;
        this.f12953b = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"apm_native_h5perf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.h5pagesdk.H5ConfigMananger.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("apm_native_h5perf_sampling_rate");
                    if (obj != null) {
                        H5ConfigMananger.this.f12954c = Integer.parseInt(obj.toString());
                        H5ConfigMananger h5ConfigMananger = H5ConfigMananger.this;
                        h5ConfigMananger.f12955d = H5ConfigMananger.a(h5ConfigMananger.f12954c);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public String generateLaunchOptions() {
        if (!this.f12955d && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            if (!H5Manager.isDebug) {
                return "";
            }
            Log.e("H5ConfigMananger", "采样未命中，并且不处于集成测试模式");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sample", this.f12954c);
            if (this.f12955d) {
                jSONObject.put("sampleResult", "Y");
            } else {
                jSONObject.put("sampleResult", "N");
            }
            Context context = this.mContext;
            if (context != null) {
                jSONObject.put("appName", context.getApplicationInfo().packageName);
            }
            jSONObject.put("bridgeVersion", 1);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isH5TracerEnable() {
        return this.f12955d;
    }

    public void sendData(final String str) {
        if (this.f12955d || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            a.execute(new Runnable() { // from class: com.efs.sdk.h5pagesdk.H5ConfigMananger.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (H5ConfigMananger.this.f12953b == null) {
                        return;
                    }
                    EfsJSONLog efsJSONLog = new EfsJSONLog("nativeh5perf");
                    efsJSONLog.put("wk_native_h5log", str);
                    H5ConfigMananger.this.f12953b.send(efsJSONLog);
                }
            });
        }
    }

    public static /* synthetic */ boolean a(int i10) {
        if (i10 != 0) {
            return i10 == 100 || new Random().nextInt(100) <= i10;
        }
        return false;
    }
}
