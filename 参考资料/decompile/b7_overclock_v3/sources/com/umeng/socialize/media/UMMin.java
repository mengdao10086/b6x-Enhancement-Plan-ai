package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UMMin extends BaseMediaObject {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24688g;

    public UMMin(String str) {
        super(str);
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getPath() {
        return this.f24688g;
    }

    public String getUserName() {
        return this.f24687f;
    }

    public void setPath(String str) {
        this.f24688g = str;
    }

    public void setUserName(String str) {
        this.f24687f = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f24653e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f24649a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f24650b);
        }
        return map;
    }
}
