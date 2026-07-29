package com.tencent.connect.share;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;

/* JADX INFO: loaded from: classes5.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f22548a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f22550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22551f;
    public String mViaShareQzoneType;

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f22548a = true;
        this.f22549d = false;
        this.f22550e = false;
        this.f22551f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.app.Activity r26, android.os.Bundle r27, com.tencent.tauth.IUiListener r28) {
        /*
            Method dump skipped, instruction units count: 1099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void shareToQzone(android.app.Activity r29, android.os.Bundle r30, com.tencent.tauth.IUiListener r31) {
        /*
            Method dump skipped, instruction units count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.shareToQzone(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
