package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;
import fh.a;

/* JADX INFO: loaded from: classes5.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24711a = "/share/multi_add/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24712b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f24719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private UMediaObject f24720j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f24714d = str;
        this.f24719i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    public String getPath() {
        return f24711a + SocializeUtils.getAppkey(this.mContext) + a.f28350w + Config.EntityKey + a.f28350w;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f24714d;
        String str = this.f24713c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String str2 = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f24716f);
        addStringParams("usid", this.f24713c);
        addStringParams("ct", this.f24719i);
        if (!TextUtils.isEmpty(this.f24718h)) {
            addStringParams("url", this.f24718h);
        }
        if (!TextUtils.isEmpty(this.f24717g)) {
            addStringParams("title", this.f24717g);
        }
        addMediaParams(this.f24720j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f24720j = uMediaObject;
            return;
        }
        if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f24717g = uMusic.getTitle();
            this.f24718h = uMusic.toUrl();
            this.f24719i = uMusic.getDescription();
            this.f24720j = uMusic.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f24717g = uMVideo.getTitle();
            this.f24718h = uMVideo.toUrl();
            this.f24719i = uMVideo.getDescription();
            this.f24720j = uMVideo.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f24717g = uMWeb.getTitle();
            this.f24718h = uMWeb.toUrl();
            this.f24719i = uMWeb.getDescription();
            this.f24720j = uMWeb.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f24717g = uMMin.getTitle();
            this.f24718h = uMMin.toUrl();
            this.f24719i = uMMin.getDescription();
            this.f24720j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f24714d = str;
    }

    public void setText(String str) {
        this.f24719i = str;
    }

    public void setType(String str) {
        this.f24716f = str;
    }

    public void setUID(String str) {
        this.f24715e = str;
    }

    public void setmUsid(String str) {
        this.f24713c = str;
    }
}
