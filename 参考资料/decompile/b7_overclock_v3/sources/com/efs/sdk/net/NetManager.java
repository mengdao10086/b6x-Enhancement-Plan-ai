package com.efs.sdk.net;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import hb.u;
import java.util.Map;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.f;
import okhttp3.w;

/* JADX INFO: loaded from: classes2.dex */
public class NetManager {
    private static final String TAG = "OkHttpManager";
    private static NetConfigManager mNetConfigManager;
    private static EfsReporter mReporter;

    public static void get(String str, f fVar) {
        new a0.a().s(OkHttpListener.get()).d(new OkHttpInterceptor()).f().a(new b0.a().B(str).b()).b0(fVar);
    }

    public static NetConfigManager getNetConfigManager() {
        return mNetConfigManager;
    }

    public static EfsReporter getReporter() {
        return mReporter;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init net manager error! parameter is null!");
        } else {
            mReporter = efsReporter;
            mNetConfigManager = new NetConfigManager(context, efsReporter);
        }
    }

    public static void post(String str, Map<String, Object> map, f fVar) {
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : map.keySet()) {
            sb2.append(str2);
            sb2.append(u.f30904o);
            sb2.append(map.get(str2));
            sb2.append("&");
        }
        new a0.a().s(OkHttpListener.get()).d(new OkHttpInterceptor()).f().a(new b0.a().B(str).r(c0.f(w.j("application/x-www-form-urlencoded"), sb2.toString())).b()).b0(fVar);
    }
}
