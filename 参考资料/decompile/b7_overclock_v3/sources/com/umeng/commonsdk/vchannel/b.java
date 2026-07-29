package com.umeng.commonsdk.vchannel;

import ag.c;
import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24445b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24444a = "_$unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f24446c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f24447d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24448e = a.f24443j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f24449f = null;

    public b(Context context) {
        this.f24445b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f24444a;
    }

    public long b() {
        return this.f24446c;
    }

    public Map<String, Object> c() {
        return this.f24449f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f24444a);
            jSONObject.put("pn", this.f24445b);
            jSONObject.put("ds", this.f24447d);
            jSONObject.put("ts", this.f24446c);
            Map<String, Object> map = this.f24449f;
            if (map != null && map.size() > 0) {
                for (String str : this.f24449f.keySet()) {
                    jSONObject.put(str, this.f24449f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f24448e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append("id:" + this.f24444a + c.f654g);
        sb2.append("pn:" + this.f24445b + c.f654g);
        sb2.append("ts:" + this.f24446c + c.f654g);
        Map<String, Object> map = this.f24449f;
        if (map != null && map.size() > 0) {
            for (String str : this.f24449f.keySet()) {
                Object obj = this.f24449f.get(str);
                sb2.append(obj == null ? str + ": null" + c.f654g : str + ": " + obj.toString() + c.f654g);
            }
        }
        sb2.append("ds:" + this.f24447d + "]");
        return sb2.toString();
    }

    public void a(String str) {
        this.f24444a = str;
    }

    public void a(long j10) {
        this.f24446c = j10;
    }

    public void a(Map<String, Object> map) {
        this.f24449f = map;
    }
}
