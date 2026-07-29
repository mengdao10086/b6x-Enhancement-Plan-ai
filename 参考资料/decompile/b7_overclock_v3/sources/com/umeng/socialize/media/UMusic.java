package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UMusic extends BaseMediaObject {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f24701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f24703k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f24702j;
    }

    public String getH5Url() {
        return this.f24700h;
    }

    public String getHighBandDataUrl() {
        return this.f24699g;
    }

    public String getLowBandDataUrl() {
        return this.f24698f;
    }

    public String getLowBandUrl() {
        return this.f24701i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f24653e;
    }

    public String getmTargetUrl() {
        return this.f24703k;
    }

    public void setDuration(int i10) {
        this.f24702j = i10;
    }

    public void setH5Url(String str) {
        this.f24700h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f24699g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f24698f = str;
    }

    public void setLowBandUrl(String str) {
        this.f24701i = str;
    }

    public void setmTargetUrl(String str) {
        this.f24703k = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f24653e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMusic [title=" + this.f24650b + "media_url=" + this.f24649a + ", qzone_title=" + this.f24650b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f24649a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f24650b);
        }
        return map;
    }

    public UMusic(Parcel parcel) {
        super(parcel);
    }
}
