package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class SocialApiIml extends BaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f22603a;

    public class a extends DefaultUiListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IUiListener f22605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f22606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bundle f22608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Activity f22609f;

        public a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f22605b = iUiListener;
            this.f22606c = str;
            this.f22607d = str2;
            this.f22608e = bundle;
            this.f22609f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f22605b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String string;
            try {
                string = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e10) {
                e10.printStackTrace();
                SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e10);
                string = null;
            }
            this.f22608e.putString("encrytoken", string);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f22603a, this.f22606c, this.f22608e, this.f22607d, this.f22605b);
            if (TextUtils.isEmpty(string)) {
                SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f22609f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f22605b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    public Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (k.c(f.a()) && i.a(f.a(), intent3)) {
            return intent3;
        }
        if (i.a(f.a(), intent2) && i.c(f.a(), "4.7") >= 0) {
            return intent2;
        }
        if (i.a(f.a(), intent) && i.a(i.a(f.a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && i.a(f.a(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            return intent;
        }
        return null;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22603a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            intentC = c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, intentC, SocialConstants.ACTION_INVITE, bundle, h.a().a(f.a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22603a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, intentC, SocialConstants.ACTION_STORY, bundle, h.a().a(f.a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String strG;
        String accessToken = this.f22519c.getAccessToken();
        String appId = this.f22519c.getAppId();
        String openId = this.f22519c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            strG = null;
        } else {
            strG = k.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        i.a(settings);
        String str = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f22519c.getOpenId() + "_" + this.f22519c.getAppId() + "\"]=\"" + strG + "\";</script></head><body></body></html>";
        String strA = h.a().a(context, "https://imgcache.qq.com");
        bVar.loadDataWithBaseURL(strA, str, "text/html", "utf-8", strA);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f22603a = activity;
        Intent intentC = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            intentC = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = intentC;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, h.a().a(f.a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("-->handleIntent action = ");
        sb2.append(str);
        sb2.append(", activityIntent = null ? ");
        boolean z11 = true;
        sb2.append(intent == null);
        SLog.i("openSDK_LOG.SocialApiIml", sb2.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        g gVarA = g.a(f.a(), this.f22519c.getAppId());
        if (!z10 && !gVarA.b("C_LoginH5")) {
            z11 = false;
        }
        if (z11) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent intentB = b("com.tencent.open.agent.AgentActivity");
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent intentB2 = b("com.tencent.open.agent.EncryTokenActivity");
        if (intentB2 != null && intentB != null && intentB.getComponent() != null && intentB2.getComponent() != null && intentB.getComponent().getPackageName().equals(intentB2.getComponent().getPackageName())) {
            intentB2.putExtra("oauth_consumer_key", this.f22519c.getAppId());
            intentB2.putExtra("openid", this.f22519c.getOpenId());
            intentB2.putExtra("access_token", this.f22519c.getAccessToken());
            intentB2.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (a(intentB2)) {
                SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity, intentB2, Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String strG = k.g("tencent&sdk&qazxc***14969%%" + this.f22519c.getAccessToken() + this.f22519c.getAppId() + this.f22519c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, strG);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f22519c.getAppId());
        if (this.f22519c.isSessionValid()) {
            bundle.putString("access_token", this.f22519c.getAccessToken());
        }
        String openId = this.f22519c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
        } catch (Exception e10) {
            e10.printStackTrace();
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f22603a, str, str3, iUiListener, this.f22519c).show();
        } else {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.f22603a, str, str3, iUiListener, this.f22519c).show();
        }
    }
}
