package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UMQQMini extends BaseMediaObject {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24691h;

    public UMQQMini(String str) {
        super(str);
        this.f24689f = "";
        this.f24690g = "";
        this.f24691h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f24689f;
    }

    public String getPath() {
        return this.f24690g;
    }

    public String getType() {
        return this.f24691h;
    }

    public void setMiniAppId(String str) {
        this.f24689f = str;
    }

    public void setPath(String str) {
        this.f24690g = str;
    }

    public void setType(String str) {
        this.f24691h = str;
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
