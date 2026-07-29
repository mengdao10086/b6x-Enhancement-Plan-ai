package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import g.n0;
import g.p0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f12779b = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12780a;

    /* JADX INFO: renamed from: com.efs.sdk.base.core.a.a$a, reason: collision with other inner class name */
    public static class C0123a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12781a = new a(0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a a() {
        return C0123a.f12781a;
    }

    public static long b() {
        return f12779b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + f12779b;
    }

    private a() {
        this.f12780a = true;
    }

    @n0
    public final HttpResponse a(String str, c cVar, File file, boolean z10) {
        String strB = cVar.b();
        String strA = a(str, cVar);
        if (this.f12780a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(strA)));
        }
        HashMap map = new HashMap(1);
        map.put("wpk-header", strB);
        com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA).a(map);
        dVarA.f12941a.f12936d = file;
        com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVar.f12790h);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.f12795m);
        return dVarA2.a("size", sb2.toString()).a("flow_limit", Boolean.toString(z10)).a(d.a()).a().b();
    }

    public static String a(@n0 String str, @n0 c cVar) {
        byte b10 = cVar.f12789g;
        return str + (b10 != 1 ? b10 != 2 ? b10 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs");
    }

    public static void a(@p0 HttpResponse httpResponse) {
        if (httpResponse == null || !httpResponse.succ || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(httpResponse.data);
            String strOptString = jSONObject.optString("code", "-1");
            httpResponse.setBizCode(strOptString);
            if (!"0".equals(strOptString)) {
                httpResponse.succ = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
            }
            long j10 = jSONObject.getLong("stm") * 1000;
            if (Math.abs(j10 - b()) > 1500000) {
                f12779b = j10 - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th2) {
            Log.e("efs.px.api", "checkPxReturn error", th2);
        }
    }
}
