package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f24463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f24464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f24466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Double> f24468f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f24470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f24471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f24472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f24473k;

    public a(Context context) {
        SharedPreferences sharedPreferences;
        this.f24463a = 1000.0f;
        this.f24467e = 6;
        this.f24471i = 300000L;
        this.f24473k = context;
        if (context == null || (sharedPreferences = context.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.f24463a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.f24467e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.f24471i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000L);
        if (PageManger.isDebug) {
            StringBuilder sb2 = new StringBuilder("init fps. diff is ");
            sb2.append(this.f24463a);
            sb2.append(", count diff is ");
            sb2.append(this.f24467e);
            sb2.append(", dlealt time is ");
            sb2.append(this.f24471i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator<Map.Entry<String, Double>> it2 = this.f24468f.entrySet().iterator();
        if (it2 != null) {
            JSONArray jSONArray = null;
            while (it2.hasNext()) {
                Map.Entry<String, Double> next = it2.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.f24472j);
                    jSONObject2.put("pF", jSONArray);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
                EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                efsJSONLog.put("fps", jSONObject2);
                EfsReporter reporter = PageManger.getReporter();
                if (reporter != null) {
                    reporter.send(efsJSONLog);
                }
            }
        }
    }

    public final void a() {
        if (this.f24469g) {
            boolean z10 = PageManger.isDebug;
            return;
        }
        this.f24469g = true;
        if (PageManger.isDebug) {
            new StringBuilder("start, page is ").append(this.f24472j);
        }
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.umeng.pagesdk.a.1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                boolean z11 = PageManger.isDebug;
                a aVar = a.this;
                if (aVar.f24469g) {
                    if (aVar.f24470h == 0) {
                        aVar.f24470h = System.currentTimeMillis();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    a aVar2 = a.this;
                    if (jCurrentTimeMillis - aVar2.f24470h > aVar2.f24471i) {
                        aVar2.b();
                        return;
                    }
                    if (aVar2.f24464b == 0) {
                        aVar2.f24464b = j10;
                    }
                    float f10 = (j10 - aVar2.f24464b) / 1000000.0f;
                    if (f10 > aVar2.f24463a) {
                        double d10 = (((long) aVar2.f24465c) * 1000) / ((double) f10);
                        aVar2.f24465c = 0;
                        aVar2.f24464b = 0L;
                        if (PageManger.isDebug) {
                            StringBuilder sb2 = new StringBuilder("doFrame: ");
                            sb2.append(d10);
                            sb2.append(", map size is ");
                            sb2.append(a.this.f24468f.size());
                            sb2.append(", page is ");
                            sb2.append(a.this.f24472j);
                        }
                        Map<String, Double> map = a.this.f24468f;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(System.currentTimeMillis());
                        map.put(sb3.toString(), Double.valueOf(d10));
                        a aVar3 = a.this;
                        int i10 = aVar3.f24466d + 1;
                        aVar3.f24466d = i10;
                        if (i10 >= aVar3.f24467e) {
                            aVar3.c();
                            a aVar4 = a.this;
                            aVar4.f24466d = 0;
                            Map<String, Double> map2 = aVar4.f24468f;
                            if (map2 != null) {
                                map2.clear();
                            }
                        }
                    } else {
                        aVar2.f24465c++;
                    }
                    Choreographer.getInstance().postFrameCallback(this);
                }
            }
        });
    }

    public final void b() {
        if (PageManger.isDebug) {
            new StringBuilder("stop, page is ").append(this.f24472j);
        }
        c();
        this.f24469g = false;
        this.f24470h = 0L;
        this.f24464b = 0L;
        this.f24465c = 0;
        Map<String, Double> map = this.f24468f;
        if (map != null) {
            map.clear();
        }
        this.f24466d = 0;
    }
}
