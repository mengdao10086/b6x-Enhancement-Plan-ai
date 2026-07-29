package com.umeng.socialize.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.blankj.utilcode.util.i0;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.dplus.cache1.DplusCacheApi;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24564b = "umeng_share_platform";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24565c = "share_action";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SHARE_MEDIA f24566a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24567d = "7.2.2";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<SHARE_MEDIA, UMSSOHandler> f24568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Pair<SHARE_MEDIA, String>> f24569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private C0269a f24570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f24571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SparseArray<UMAuthListener> f24572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SparseArray<UMShareListener> f24573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SparseArray<UMAuthListener> f24574k;

    public a(Context context) {
        HashMap map = new HashMap();
        this.f24568e = map;
        ArrayList arrayList = new ArrayList();
        this.f24569f = arrayList;
        arrayList.add(new Pair(SHARE_MEDIA.LAIWANG, "com.umeng.socialize.handler.UMLWHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.LAIWANG_DYNAMIC, "com.umeng.socialize.handler.UMLWHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSimplyHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.QZONE, "com.umeng.qq.handler.UmengQZoneHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.QQ, "com.umeng.qq.handler.UmengQQHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.RENREN, "com.umeng.socialize.handler.RenrenSsoHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.TENCENT, "com.umeng.socialize.handler.TencentWBSsoHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.WEIXIN, "com.umeng.weixin.handler.UmengWXHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.WEIXIN_CIRCLE, "com.umeng.weixin.handler.UmengWXHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.WEIXIN_FAVORITE, "com.umeng.weixin.handler.UmengWXHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.WXWORK, "com.umeng.socialize.handler.UMWXWorkHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.YIXIN_CIRCLE, "com.umeng.socialize.handler.UMYXHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.FACEBOOK_MESSAGER, "com.umeng.socialize.handler.UMFacebookHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.GOOGLEPLUS, "com.umeng.socialize.handler.UMGooglePlusHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.BYTEDANCE, "com.umeng.socialize.handler.UMDYHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.BYTEDANCE_PUBLISH, "com.umeng.socialize.handler.UMDYHandler"));
        arrayList.add(new Pair(SHARE_MEDIA.BYTEDANCE_FRIENDS, "com.umeng.socialize.handler.UMDYHandler"));
        this.f24570g = new C0269a(map);
        this.f24571h = null;
        this.f24572i = new SparseArray<>();
        this.f24573j = new SparseArray<>();
        this.f24574k = new SparseArray<>();
        this.f24571h = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMShareListener e(int i10) {
        UMShareListener uMShareListener;
        uMShareListener = this.f24573j.get(i10, null);
        if (uMShareListener != null) {
            this.f24573j.remove(i10);
        }
        return uMShareListener;
    }

    public boolean d(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f24570g.a(activity, share_media)) {
            return false;
        }
        this.f24568e.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f24568e.get(share_media).isAuthorize();
    }

    private void b(Context context) {
        String appkey = SocializeUtils.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
        }
        if (SocializeNetUtils.isConSpeCharacters(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
        if (SocializeNetUtils.isSelfAppkey(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
    }

    public String c(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f24570g.a(activity, share_media)) {
            return "";
        }
        this.f24568e.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f24568e.get(share_media).getSDKVersion();
    }

    public void a(Context context) {
        this.f24571h = context.getApplicationContext();
    }

    private UMSSOHandler a(String str) {
        UMSSOHandler uMSSOHandler;
        try {
            uMSSOHandler = (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            uMSSOHandler = null;
        }
        if (uMSSOHandler == null) {
            if (str.contains("SinaSimplyHandler")) {
                Config.isUmengSina = Boolean.FALSE;
                return a("com.umeng.socialize.handler.SinaSsoHandler");
            }
            if (str.contains("UmengQQHandler")) {
                Config.isUmengQQ = Boolean.FALSE;
                return a("com.umeng.socialize.handler.UMQQSsoHandler");
            }
            if (str.contains("UmengQZoneHandler")) {
                Config.isUmengQQ = Boolean.FALSE;
                return a("com.umeng.socialize.handler.QZoneSsoHandler");
            }
            if (str.contains("UmengWXHandler")) {
                Config.isUmengWx = Boolean.FALSE;
                return a("com.umeng.socialize.handler.UMWXHandler");
            }
        }
        return uMSSOHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener d(int i10) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f24574k.get(i10, null);
        if (uMAuthListener != null) {
            this.f24574k.remove(i10);
        }
        return uMAuthListener;
    }

    public void c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f24570g.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f24568e.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), strValueOf);
            }
            int iOrdinal = share_media.ordinal();
            a(iOrdinal, uMAuthListener);
            UMAuthListener uMAuthListenerA = a(iOrdinal, strValueOf, uMSSOHandler.isInstall());
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    uMAuthListener.onStart(share_media);
                }
            });
            uMSSOHandler.authorize(uMAuthListenerA);
            this.f24566a = share_media;
        }
    }

    /* JADX INFO: renamed from: com.umeng.socialize.b.a$a, reason: collision with other inner class name */
    public static class C0269a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<SHARE_MEDIA, UMSSOHandler> f24598a;

        public C0269a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f24598a = map;
        }

        private boolean a(Context context) {
            return context != null;
        }

        public boolean a(Context context, SHARE_MEDIA share_media) {
            if (CommonUtil.isSilentMode(context) || !a(context) || !a(share_media)) {
                return false;
            }
            if (this.f24598a.get(share_media).isSupportAuth()) {
                return true;
            }
            SLog.E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
            return false;
        }

        public boolean a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform != SHARE_MEDIA.SINA && platform != SHARE_MEDIA.QQ) || PlatformConfig.configs.get(platform).isConfigured()) {
                return a(platform);
            }
            SLog.E(UmengText.CHECK.noKey(platform));
            return false;
        }

        private boolean a(SHARE_MEDIA share_media) {
            PlatformConfig.configs.get(share_media);
            if (this.f24598a.get(share_media) != null) {
                return true;
            }
            SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
            return false;
        }
    }

    private void b() {
        UMSSOHandler uMSSOHandlerA;
        for (Pair<SHARE_MEDIA, String> pair : this.f24569f) {
            Object obj = pair.first;
            if (obj != SHARE_MEDIA.WEIXIN_CIRCLE && obj != SHARE_MEDIA.WEIXIN_FAVORITE) {
                if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                    uMSSOHandlerA = this.f24568e.get(SHARE_MEDIA.FACEBOOK);
                } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                    uMSSOHandlerA = this.f24568e.get(SHARE_MEDIA.YIXIN);
                } else if (obj == SHARE_MEDIA.LAIWANG_DYNAMIC) {
                    uMSSOHandlerA = this.f24568e.get(SHARE_MEDIA.LAIWANG);
                } else if (obj == SHARE_MEDIA.TENCENT) {
                    uMSSOHandlerA = a((String) pair.second);
                } else if (obj == SHARE_MEDIA.MORE) {
                    uMSSOHandlerA = new UMMoreHandler();
                } else if (obj == SHARE_MEDIA.SINA) {
                    if (Config.isUmengSina.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.SinaSsoHandler");
                    }
                } else if (obj == SHARE_MEDIA.WEIXIN) {
                    if (Config.isUmengWx.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.UMWXHandler");
                    }
                } else if (obj == SHARE_MEDIA.QQ) {
                    if (Config.isUmengQQ.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.UMQQSsoHandler");
                    }
                } else if (obj == SHARE_MEDIA.QZONE) {
                    if (Config.isUmengQQ.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.QZoneSsoHandler");
                    }
                } else if (obj == SHARE_MEDIA.BYTEDANCE) {
                    if (Config.isUmengDY.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.UMDYHandler");
                    }
                } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                    if (Config.isUmengDY.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.UMDYHandler");
                    }
                } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                    if (Config.isUmengDY.booleanValue()) {
                        uMSSOHandlerA = a((String) pair.second);
                    } else {
                        uMSSOHandlerA = a("com.umeng.socialize.handler.UMDYHandler");
                    }
                } else {
                    uMSSOHandlerA = a((String) pair.second);
                }
            } else {
                uMSSOHandlerA = this.f24568e.get(SHARE_MEDIA.WEIXIN);
            }
            this.f24568e.put((SHARE_MEDIA) pair.first, uMSSOHandlerA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener c(int i10) {
        UMAuthListener uMAuthListener;
        this.f24566a = null;
        uMAuthListener = this.f24572i.get(i10, null);
        if (uMAuthListener != null) {
            this.f24572i.remove(i10);
        }
        return uMAuthListener;
    }

    public UMSSOHandler a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f24568e.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f24571h, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    private synchronized void c() {
        this.f24572i.clear();
        this.f24573j.clear();
        this.f24574k.clear();
    }

    public void a(int i10, int i11, Intent intent) {
        UMSSOHandler uMSSOHandlerA = a(i10);
        if (uMSSOHandlerA != null) {
            uMSSOHandlerA.onActivityResult(i10, i11, intent);
        }
    }

    @Deprecated
    public void a(Activity activity, int i10, UMAuthListener uMAuthListener) {
        UMSSOHandler uMSSOHandlerA = a(i10);
        if (uMSSOHandlerA != null) {
            if (i10 == 10103 || i10 == 11101) {
                uMSSOHandlerA.onCreate(activity, PlatformConfig.getPlatform(b(i10)));
                a(SHARE_MEDIA.QQ, uMAuthListener, uMSSOHandlerA, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private UMSSOHandler a(int i10) {
        int i11 = 10103;
        if (i10 != 10103 && i10 != 11101) {
            i11 = i10;
        }
        if (i10 == 64207 || i10 == 64206 || i10 == 64208) {
            i11 = HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE;
        }
        if (i10 == 32973 || i10 == 765) {
            i11 = 10001;
        }
        if (i10 == 5650) {
            i11 = HandlerRequestCode.SINA_REQUEST_CODE;
        }
        for (UMSSOHandler uMSSOHandler : this.f24568e.values()) {
            if (uMSSOHandler != null && i11 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    public void a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f24570g.a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i10) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i10, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i10, Throwable th2) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }
                };
            }
            this.f24568e.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f24568e.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    public boolean a(Activity activity, SHARE_MEDIA share_media) {
        this.f24568e.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f24568e.get(share_media).isInstall();
    }

    private UMAuthListener a(final int i10, final String str, final boolean z10) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(SHARE_MEDIA share_media, int i11) {
                UMAuthListener uMAuthListenerC = a.this.c(i10);
                if (uMAuthListenerC != null) {
                    uMAuthListenerC.onCancel(share_media, i11);
                }
                if (ContextUtil.getContext() != null) {
                    SocialAnalytics.authendt(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, z10, "", str, null);
                }
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(SHARE_MEDIA share_media, int i11, Map<String, String> map) {
                UMAuthListener uMAuthListenerC = a.this.c(i10);
                if (uMAuthListenerC != null) {
                    uMAuthListenerC.onComplete(share_media, i11, map);
                }
                if (ContextUtil.getContext() != null) {
                    SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "success", z10, "", str, a.this.a(share_media, map));
                }
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(SHARE_MEDIA share_media, int i11, Throwable th2) {
                UMAuthListener uMAuthListenerC = a.this.c(i10);
                if (uMAuthListenerC != null) {
                    uMAuthListenerC.onError(share_media, i11, th2);
                }
                if (th2 != null) {
                    SLog.E(th2.getMessage());
                    SLog.runtimePrint(th2.getMessage());
                } else {
                    SLog.E(i0.f11859x);
                    SLog.runtimePrint(i0.f11859x);
                }
                if (ContextUtil.getContext() == null || th2 == null) {
                    return;
                }
                SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "fail", z10, th2.getMessage(), str, null);
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(SHARE_MEDIA share_media) {
                UMAuthListener uMAuthListenerC = a.this.c(i10);
                if (uMAuthListenerC != null) {
                    uMAuthListenerC.onStart(share_media);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(SHARE_MEDIA share_media, Map<String, String> map) {
        String click_key;
        String appSecret;
        String appid = "";
        if (PlatformConfig.getPlatform(share_media) != null) {
            appid = PlatformConfig.getPlatform(share_media).getAppid();
            appSecret = PlatformConfig.getPlatform(share_media).getAppSecret();
            click_key = PlatformConfig.getPlatform(share_media).getClick_key();
        } else {
            click_key = "";
            appSecret = click_key;
        }
        map.put(CommonNetImpl.AID, appid);
        map.put(CommonNetImpl.AS, appSecret);
        map.put("at", click_key);
        return map;
    }

    private void a(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UmengText.SHARE.INFO);
        arrayList.add(UmengText.SHARE.SHAREPLAT + shareAction.getPlatform().toString());
        arrayList.add(UmengText.SHARE.SHARESTYLE + shareAction.getShareContent().getShareType());
        arrayList.add(UmengText.SHARE.SHARETEXT + shareContent.mText);
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMImage) {
                UMImage uMImage = (UMImage) uMediaObject;
                if (uMImage.isUrlMedia()) {
                    arrayList.add(UmengText.SHARE.URLIMAGE + uMImage.asUrlImage());
                } else {
                    byte[] bArrAsBinImage = uMImage.asBinImage();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(UmengText.SHARE.LOCALIMAGE);
                    sb2.append(bArrAsBinImage == null ? 0 : bArrAsBinImage.length);
                    arrayList.add(sb2.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    UMImage thumbImage = uMImage.getThumbImage();
                    if (thumbImage.isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + thumbImage.asUrlImage());
                    } else {
                        byte[] bArrAsBinImage2 = thumbImage.asBinImage();
                        if (bArrAsBinImage2 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage2.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) uMediaObject2;
                arrayList.add(UmengText.SHARE.VIDEOURL + uMVideo.toUrl());
                arrayList.add(UmengText.SHARE.VIDEOTITLE + uMVideo.getTitle());
                arrayList.add(UmengText.SHARE.VIDEODES + uMVideo.getDescription());
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        if (uMVideo.getThumbImage().asUrlImage() != null) {
                            arrayList.add(UmengText.SHARE.URLTHUMB + uMVideo.getThumbImage().asUrlImage());
                        }
                    } else {
                        byte[] bArrAsBinImage3 = uMVideo.getThumbImage().asBinImage();
                        if (bArrAsBinImage3 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage3.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 instanceof UMusic) {
                UMusic uMusic = (UMusic) uMediaObject3;
                arrayList.add(UmengText.SHARE.MUSICURL + uMusic.toUrl() + "   " + uMusic.getmTargetUrl());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(UmengText.SHARE.MUSICTITLE);
                sb3.append(uMusic.getTitle());
                arrayList.add(sb3.toString());
                arrayList.add(UmengText.SHARE.MUSICDES + uMusic.getDescription());
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMusic.getThumbImage().asUrlImage());
                    } else {
                        byte[] bArrAsBinImage4 = uMusic.getThumbImage().asBinImage();
                        if (bArrAsBinImage4 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage4.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) uMediaObject4;
                arrayList.add(UmengText.SHARE.URLURL + uMWeb.toUrl());
                arrayList.add(UmengText.SHARE.URLTITLE + uMWeb.getTitle());
                arrayList.add(UmengText.SHARE.URLDES + uMWeb.getDescription());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMWeb.getThumbImage().asUrlImage());
                    } else {
                        byte[] bArrAsBinImage5 = uMWeb.getThumbImage().asBinImage();
                        if (bArrAsBinImage5 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage5.length);
                        }
                    }
                }
            }
        }
        if (shareContent.file != null) {
            arrayList.add(UmengText.SHARE.FILENAME + shareContent.file.getName());
        }
        SLog.mutlI((String[]) arrayList.toArray(new String[1]));
    }

    private SHARE_MEDIA b(int i10) {
        if (i10 == 10103 || i10 == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i10 != 32973 && i10 != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    public void b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f24570g.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f24568e.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, strValueOf);
            }
            final int iOrdinal = share_media.ordinal();
            b(iOrdinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(SHARE_MEDIA share_media2, int i10) {
                    UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                    if (uMAuthListenerD != null) {
                        uMAuthListenerD.onCancel(share_media2, i10);
                    }
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.CANCEL, "", strValueOf, null);
                    }
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(SHARE_MEDIA share_media2, int i10, Map<String, String> map) {
                    UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                    if (uMAuthListenerD != null) {
                        uMAuthListenerD.onComplete(share_media2, i10, map);
                    }
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "success", "", strValueOf, map);
                    }
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onError(SHARE_MEDIA share_media2, int i10, Throwable th2) {
                    UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                    if (uMAuthListenerD != null) {
                        uMAuthListenerD.onError(share_media2, i10, th2);
                    }
                    if (th2 != null) {
                        SLog.E(th2.getMessage());
                        SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                        SLog.runtimePrint(th2.getMessage());
                    } else {
                        SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                    }
                    if (ContextUtil.getContext() == null || th2 == null) {
                        return;
                    }
                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "fail", th2.getMessage(), strValueOf, null);
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onStart(SHARE_MEDIA share_media2) {
                    UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                    if (uMAuthListenerD != null) {
                        uMAuthListenerD.onStart(share_media2);
                    }
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    uMAuthListener.onStart(share_media);
                }
            });
            uMSSOHandler.getPlatformInfo(uMAuthListener2);
        }
    }

    public boolean b(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f24570g.a(activity, share_media)) {
            return false;
        }
        this.f24568e.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f24568e.get(share_media).isSupport();
    }

    private synchronized void b(int i10, UMAuthListener uMAuthListener) {
        this.f24574k.put(i10, uMAuthListener);
    }

    public void a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f24570g.a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.E(UmengText.SHARE.VERSION + this.f24567d);
                a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f24568e.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            if (!platform.toString().equals("TENCENT") && !platform.toString().equals("RENREN") && !platform.toString().equals("DOUBAN") && !platform.toString().equals("WEIXIN") && !platform.toString().equals("WEIXIN_CIRCLE")) {
                platform.toString().equals("WEIXIN_FAVORITE");
            }
            final String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, strValueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int iOrdinal = platform.ordinal();
            a(iOrdinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(SHARE_MEDIA share_media) {
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, "", strValueOf);
                    }
                    UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                    if (uMShareListenerE != null) {
                        uMShareListenerE.onCancel(share_media);
                    }
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(SHARE_MEDIA share_media, Throwable th2) {
                    if (ContextUtil.getContext() != null && th2 != null) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "fail", th2.getMessage(), strValueOf);
                    }
                    UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                    if (uMShareListenerE != null) {
                        uMShareListenerE.onError(share_media, th2);
                    }
                    if (th2 != null) {
                        SLog.E(th2.getMessage());
                        SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                        SLog.runtimePrint(th2.getMessage());
                        return;
                    }
                    SLog.E(i0.f11859x);
                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                    SLog.runtimePrint(i0.f11859x);
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(SHARE_MEDIA share_media) {
                    if (ContextUtil.getContext() != null) {
                        SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "success", "", strValueOf);
                    }
                    UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                    if (uMShareListenerE != null) {
                        uMShareListenerE.onResult(share_media);
                    }
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(SHARE_MEDIA share_media) {
                    UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                    if (uMShareListenerE != null) {
                        uMShareListenerE.onStart(share_media);
                    }
                }
            };
            if (!shareAction.getUrlValid()) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        uMShareListener2.onError(shareAction.getPlatform(), new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.SHARE.WEB_HTTP));
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    UMShareListener uMShareListener3 = uMShareListener;
                    if (uMShareListener3 != null) {
                        uMShareListener3.onStart(shareAction.getPlatform());
                    }
                }
            });
            try {
                uMSSOHandler.share(shareAction.getShareContent(), uMShareListener2);
            } catch (Throwable th2) {
                SLog.error(th2);
            }
        }
    }

    private synchronized void a(int i10, UMAuthListener uMAuthListener) {
        this.f24572i.put(i10, uMAuthListener);
    }

    private synchronized void a(int i10, UMShareListener uMShareListener) {
        this.f24573j.put(i10, uMShareListener);
    }

    private void a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int iOrdinal = share_media.ordinal();
        a(iOrdinal, uMAuthListener);
        uMSSOHandler.setAuthListener(a(iOrdinal, str, uMSSOHandler.isInstall()));
    }

    public void a() {
        c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f24568e.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f24568e.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f24568e.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f24568e.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f24568e.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f24566a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    public void a(Bundle bundle) {
        String string;
        int i10;
        SHARE_MEDIA share_media = this.f24566a;
        if (share_media == null || !(share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            string = "";
            i10 = -1;
        } else {
            string = share_media.toString();
            i10 = 0;
        }
        bundle.putString(f24564b, string);
        bundle.putInt(f24565c, i10);
        this.f24566a = null;
    }

    public void a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA share_mediaConvertToEmun;
        UMSSOHandler uMSSOHandlerA;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString(f24564b, null);
        if (bundle.getInt(f24565c, -1) != 0 || TextUtils.isEmpty(string) || (share_mediaConvertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (share_mediaConvertToEmun == SHARE_MEDIA.QQ) {
            uMSSOHandlerA = this.f24568e.get(share_mediaConvertToEmun);
            uMSSOHandlerA.onCreate(activity, PlatformConfig.getPlatform(share_mediaConvertToEmun));
        } else {
            uMSSOHandlerA = a(share_mediaConvertToEmun);
        }
        if (uMSSOHandlerA != null) {
            a(share_mediaConvertToEmun, uMAuthListener, uMSSOHandlerA, String.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(UMShareConfig uMShareConfig) {
        Map<SHARE_MEDIA, UMSSOHandler> map = this.f24568e;
        if (map == null || map.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<SHARE_MEDIA, UMSSOHandler>> it2 = this.f24568e.entrySet().iterator();
        while (it2.hasNext()) {
            UMSSOHandler value = it2.next().getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}
