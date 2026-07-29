package com.umeng.socialize.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UMTencentSSOHandler extends UMSSOHandler {
    public static final String FIGUREURL_QQ_2 = "figureurl_qq_2";
    public static final String IS_YELLOW_VIP = "is_yellow_vip";
    public static final String IS_YELLOW_YEAR_VIP = "is_yellow_year_vip";
    public static final String LEVEL = "level";
    public static final String MSG = "msg";
    public static final String NICKNAME = "nickname";
    private static final String PUBLIC_ACCOUNT = "100424468";
    public static final String RET = "ret";
    private static final String TAG = "UMTencentSSOHandler";
    public static final String VIP = "vip";
    public static final String YELLOW_VIP_LEVEL = "yellow_vip_level";
    public static Map<String, String> mImageCache = new HashMap();
    public UMAuthListener mAuthListener;
    public UMShareListener mShareListener;
    public Tencent mTencent;
    public ProgressDialog mProgressDialog = null;
    public String mImageUrl = null;
    public PlatformConfig.APPIDPlatform config = null;
    public String VERSION = "7.2.1";

    public interface ObtainAppIdListener {
        void onComplete();
    }

    public interface ObtainImageUrlListener {
        void onComplete(String str);
    }

    private void setImageUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        mImageCache.put(str, str2);
        this.mImageUrl = str2;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return this.VERSION;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
        PlatformConfig.APPIDPlatform aPPIDPlatform = (PlatformConfig.APPIDPlatform) platform;
        this.config = aPPIDPlatform;
        if (TextUtils.isEmpty(aPPIDPlatform.fileProvider)) {
            SLog.E(UmengText.QQ.QQ_FILE_PROVIDER_ERROR);
            this.mTencent = Tencent.createInstance(this.config.appId, context);
        } else {
            PlatformConfig.APPIDPlatform aPPIDPlatform2 = this.config;
            this.mTencent = Tencent.createInstance(aPPIDPlatform2.appId, context, aPPIDPlatform2.fileProvider);
        }
        if (this.mTencent == null) {
            SLog.E(UmengText.QQ.QQ_TENCENT_ERROR);
        }
    }

    public Bundle parseOauthData(Object obj) {
        Bundle bundle = new Bundle();
        if (obj == null) {
            return bundle;
        }
        String strTrim = obj.toString().trim();
        if (TextUtils.isEmpty(strTrim)) {
            return bundle;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(strTrim);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        if (jSONObject == null) {
            return bundle;
        }
        bundle.putString("auth_time", jSONObject.optString("auth_time", ""));
        bundle.putString("pay_token", jSONObject.optString("pay_token", ""));
        bundle.putString("pf", jSONObject.optString("pf", ""));
        bundle.putString(RET, String.valueOf(jSONObject.optInt(RET, -1)));
        bundle.putString("sendinstall", jSONObject.optString("sendinstall", ""));
        bundle.putString("page_type", jSONObject.optString("page_type", ""));
        bundle.putString("appid", jSONObject.optString("appid", ""));
        bundle.putString("openid", jSONObject.optString("openid", ""));
        bundle.putString("uid", jSONObject.optString("openid", ""));
        bundle.putString("expires_in", jSONObject.optString("expires_in", ""));
        bundle.putString("pfkey", jSONObject.optString("pfkey", ""));
        bundle.putString("access_token", jSONObject.optString("access_token", ""));
        return bundle;
    }

    public boolean validTencent() {
        Tencent tencent = this.mTencent;
        return tencent != null && tencent.getAppId().equals(this.config.appId);
    }
}
