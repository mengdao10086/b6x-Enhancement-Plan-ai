package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import com.blankj.utilcode.util.i0;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AuthAgent f22450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QQToken f22451b;

    private c(String str, Context context) {
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.f22451b = new QQToken(str);
        this.f22450a = new AuthAgent(this.f22451b);
        com.tencent.connect.a.a.c(context, this.f22451b);
        a(context, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("bcb3903995", str);
        editorEdit.apply();
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.f22450a.a(activity, str, iUiListener, true, null, false);
    }

    public boolean c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isSessionValid(), result = ");
        sb2.append(this.f22451b.isSessionValid() ? "true" : "false");
        SLog.i("openSDK_LOG.QQAuth", sb2.toString());
        return this.f22451b.isSessionValid();
    }

    public QQToken b() {
        return this.f22451b;
    }

    public void b(Context context, String str) {
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.f22451b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.f22451b);
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public static c a(String str, Context context) {
        f.a(context.getApplicationContext());
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        c cVar = new c(str, context);
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return cVar;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z10) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, null, str, iUiListener, "", z10);
    }

    public int a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.QQAuth", "login--params");
        return a(activity, (Fragment) null, k.a(map, Constants.KEY_SCOPE, "all"), iUiListener, "", k.a(map, Constants.KEY_QRCODE, false), map);
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, (Fragment) null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        g gVarW1 = fragment.w1();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + gVarW1);
        return a(gVarW1, fragment, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z10) {
        g gVarW1 = fragment.w1();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + gVarW1);
        return a(gVarW1, fragment, str, iUiListener, str2, z10);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return a(activity, fragment, str, iUiListener, str2, false);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z10) {
        return a(activity, fragment, str, iUiListener, str2, z10, (Map<String, Object>) null);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z10, Map<String, Object> map) {
        try {
            String strA = i.a(activity);
            if (strA != null) {
                String strA2 = com.tencent.open.utils.b.a(new File(strA));
                if (!TextUtils.isEmpty(strA2)) {
                    SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + strA2);
                    return a(activity, str, iUiListener, z10, strA2, strA2, "");
                }
            }
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th2);
        }
        SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.f22450a.doLogin(activity, str, iUiListener, false, fragment, z10, map);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z10, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = i0.f11859x;
        }
        if (str3.equals("")) {
            str3 = i0.f11859x;
        }
        if (str4.equals("")) {
            str4 = i0.f11859x;
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.f22450a.a(activity, str, iUiListener, false, null, z10);
    }

    public void a() {
        this.f22450a.a((IUiListener) null);
    }

    public void a(IUiListener iUiListener) {
        this.f22450a.b(iUiListener);
    }

    public void a(String str, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.f22451b.setAccessToken(str, str2);
    }
}
