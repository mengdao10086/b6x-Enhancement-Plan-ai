package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ZIDManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ZIDManager f24863d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24864a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24865b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24866c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f24867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f24868b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f24867a = context;
            this.f24868b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.f24867a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f24868b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f24868b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f24870a;

        public b(Context context) {
            this.f24870a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.f24870a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f24872a;

        public c(Context context) {
            this.f24872a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.f24872a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String strOptString = null;
        if (!zIDManager.f24864a) {
            zIDManager.f24864a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id2 = Spy.getID();
                jSONObject.put(an.aD, id2);
                String strB = d.b(context);
                jSONObject.put(an.A, strB);
                String strC = d.c(context);
                jSONObject.put("o", strC);
                zIDManager.a(context, jSONObject);
                String strA = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject2 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        d.f(context, id2);
                        d.a(context, strB);
                        d.b(context, strC);
                        strOptString = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            d.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            d.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f24864a = false;
        }
        return strOptString;
    }

    public static synchronized ZIDManager getInstance() {
        if (f24863d == null) {
            f24863d = new ZIDManager();
        }
        return f24863d;
    }

    public static String getSDKVersion() {
        return "1.6.3";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strA = d.a(applicationContext);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        boolean zD = d.d(context);
        this.f24866c = zD;
        if (zD) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strA = d.a(applicationContext);
            if (strA == null || TextUtils.isEmpty(strA)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strA);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString("uuid", string).commit();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }
}
