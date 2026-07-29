package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import hb.u;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f22518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public QQToken f22519c;

    public class TempRequestListener implements IRequestListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IUiListener f22521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f22522c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f22521b = iUiListener;
            this.f22522c = new Handler(f.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f22521b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f22521b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = jSONObject;
            messageObtainMessage.what = 0;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = httpStatusException.getMessage();
            messageObtainMessage.what = -9;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = iOException.getMessage();
            messageObtainMessage.what = -2;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = jSONException.getMessage();
            messageObtainMessage.what = -4;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = malformedURLException.getMessage();
            messageObtainMessage.what = -3;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = networkUnavailableException.getMessage();
            messageObtainMessage.what = -10;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = socketTimeoutException.getMessage();
            messageObtainMessage.what = -8;
            this.f22522c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message messageObtainMessage = this.f22522c.obtainMessage();
            messageObtainMessage.obj = exc.getMessage();
            messageObtainMessage.what = -6;
            this.f22522c.sendMessage(messageObtainMessage);
        }
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.f22518b = cVar;
        this.f22519c = qQToken;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", UMSSOHandler.JSON);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.f22519c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f22519c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f22519c.getAppId());
            bundle.putString("openid", this.f22519c.getOpenId());
        }
        SharedPreferences sharedPreferences = f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + l4.f.f39447b + "-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
        }
        return bundle;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f22519c.getAppId());
        if (this.f22519c.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.f22519c.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.f22519c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
        SharedPreferences sharedPreferences = f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + l4.f.f39447b + "-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    public Intent c(String str) {
        Intent intent = new Intent();
        Intent intentB = b(str);
        if (intentB == null || intentB.getComponent() == null) {
            return null;
        }
        intent.setClassName(intentB.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    public void releaseResource() {
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    public String a(String str) {
        Bundle bundleA = a();
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            bundleA.putString("need_version", str);
        }
        sb2.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb2.append(HttpUtils.encodeUrl(bundleA));
        return sb2.toString();
    }

    public Intent b(String str) {
        Intent intent = new Intent();
        if (k.c(f.a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (i.a(f.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (i.a(f.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        if (i.a(f.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_QQ_SPEED, str);
        if (i.a(f.a(), intent)) {
            return intent;
        }
        return null;
    }

    public void a(StringBuilder sb2, Activity activity) {
        if (sb2.indexOf("?") < 0) {
            sb2.append("?");
        } else {
            sb2.append("&");
        }
        sb2.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb2.append(u.f30904o);
        sb2.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.f22519c.getAppId();
        String openId = this.f22519c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            a(sb2, Constants.JumpUrlConstants.URL_KEY_APPID, appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            a(sb2, Constants.JumpUrlConstants.URL_KEY_OPENID, k.l(openId));
        }
        String strA = k.a(activity);
        if (!TextUtils.isEmpty(strA)) {
            if (strA.length() > 20) {
                strA = strA.substring(0, 20) + "...";
            }
            a(sb2, "app_name", k.l(strA));
        }
        a(sb2, "sdk_version", k.l(Constants.SDK_VERSION));
    }

    public void a(StringBuilder sb2, String str, String str2) {
        sb2.append("&");
        sb2.append(str);
        sb2.append(u.f30904o);
        sb2.append(k.f(str2));
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.BaseApi", "Exception", e10);
        }
        return intent2;
    }

    public void a(Activity activity, int i10, Intent intent, boolean z10) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        if (z10) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i10);
    }

    public void a(Activity activity, Intent intent, int i10) {
        a(activity, intent, i10, (Map<String, Object>) null);
    }

    public void a(Activity activity, Intent intent, int i10, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i10);
        activity.startActivityForResult(a(activity, intent, map), i10);
    }

    public void a(Fragment fragment, Intent intent, int i10, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i10);
        fragment.z5(a(fragment.w1(), intent, map), i10);
    }

    public boolean a(Intent intent) {
        if (intent != null) {
            return i.a(f.a(), intent);
        }
        return false;
    }

    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f22519c).show();
    }
}
