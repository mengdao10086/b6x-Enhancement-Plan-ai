package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23754a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f23755b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23756c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f23757d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f23758e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f23759a = new r();

        private a() {
        }
    }

    public static r a() {
        return a.f23759a;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.f23512p, jCurrentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public void b(JSONObject jSONObject, Context context) {
        int iA = a(context);
        if (iA == 1) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.f23510n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(d.f23510n);
                    int length = jSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        if (jSONObject2.has(d.f23497au)) {
                            jSONObject2.remove(d.f23497au);
                        }
                        if (jSONObject2.has(d.av)) {
                            jSONObject2.remove(d.av);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            i.a(context).a(false, true);
            return;
        }
        if (iA == 2) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.f23510n)) {
                jSONObject.remove(d.f23510n);
            }
            try {
                jSONObject.put(d.f23510n, c());
            } catch (Exception unused2) {
            }
            i.a(context).a(false, true);
            return;
        }
        if (iA == 3) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            jSONObject.remove(d.f23510n);
            i.a(context).a(false, true);
        }
    }

    private r() {
        this.f23758e = 60000L;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z10) {
        if (!z10 && jSONObject.has(d.f23510n)) {
            jSONObject.remove(d.f23510n);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has(d.O)) {
            jSONObject.remove(d.O);
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(d.T)) {
            jSONObject.remove(d.T);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int iA = a(context);
        if (iA == 1) {
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else {
            if (iA == 2) {
                jSONObject.remove(d.f23510n);
                try {
                    jSONObject.put(d.f23510n, b());
                } catch (Exception unused) {
                }
                a(jSONObject, true);
                i.a(context).b(false, true);
                return;
            }
            if (iA == 3) {
                a(jSONObject, false);
                i.a(context).b(false, true);
            }
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.f23512p, jCurrentTimeMillis);
            jSONObject.put(d.f23513q, jCurrentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
