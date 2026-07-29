package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f22819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f22820b = null;

    public static synchronized h a() {
        if (f22819a == null) {
            f22819a = new h();
        }
        return f22819a;
    }

    public String a(Context context, String str) {
        if (this.f22820b == null || this.f22820b.get() == null) {
            this.f22820b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f22820b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String strReplace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + strReplace);
                return strReplace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e10.getMessage());
            return str;
        }
    }
}
