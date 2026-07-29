package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UMVideo extends BaseMediaObject {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f24695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f24697k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f24696j;
    }

    public String getH5Url() {
        return this.f24695i;
    }

    public String getHighBandDataUrl() {
        return this.f24694h;
    }

    public File getLocalVideoFile() {
        return this.f24697k;
    }

    public String getLowBandDataUrl() {
        return this.f24693g;
    }

    public String getLowBandUrl() {
        return this.f24692f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i10) {
        this.f24696j = i10;
    }

    public void setH5Url(String str) {
        this.f24695i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f24694h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f24693g = str;
    }

    public void setLowBandUrl(String str) {
        this.f24692f = str;
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
        return "UMVedio [media_url=" + this.f24649a + ", qzone_title=" + this.f24650b + ", qzone_thumb=media_url=" + this.f24649a + ", qzone_title=" + this.f24650b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f24649a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    public UMVideo(File file) {
        this.f24697k = file;
    }
}
