package com.efs.sdk.base.core.config.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.just.agentweb.DefaultWebClient;
import g.n0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12850a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12851b = DefaultWebClient.f21815w;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12852c = "errnewlog.umeng.com";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12853d = 480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f12856g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Double> f12854e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, String> f12855f = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar = new b();
        if (ControllerCenter.getGlobalEnvStruct().isIntl()) {
            bVar.f12852c = "errnewlogos.umeng.com";
        } else {
            bVar.f12852c = "errnewlog.umeng.com";
        }
        return bVar;
    }

    public final void a(@n0 Map<String, String> map) {
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.f12852c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.f12851b = Boolean.parseBoolean(str2) ? DefaultWebClient.f21815w : DefaultWebClient.f21814v;
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.f12853d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String strReplace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d10 = 100.0d;
                try {
                    d10 = Double.parseDouble(entry.getValue());
                } catch (Throwable unused) {
                }
                map2.put(strReplace, Double.valueOf(d10));
            }
        }
        this.f12854e = map2;
        this.f12855f = map;
    }
}
