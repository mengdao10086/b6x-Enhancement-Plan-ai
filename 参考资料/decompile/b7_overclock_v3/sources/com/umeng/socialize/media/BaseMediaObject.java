package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f24650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f24651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f24652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UMImage f24653e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f24649a = "";
        this.f24650b = "";
        this.f24651c = new HashMap();
        this.f24652d = "";
    }

    public String getDescription() {
        return this.f24652d;
    }

    public UMImage getThumbImage() {
        return this.f24653e;
    }

    public String getTitle() {
        return this.f24650b;
    }

    public Map<String, Object> getmExtra() {
        return this.f24651c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f24649a);
    }

    public void setDescription(String str) {
        this.f24652d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f24653e = uMImage;
    }

    public void setTitle(String str) {
        this.f24650b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f24651c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f24649a + ", qzone_title=" + this.f24650b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f24649a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f24649a = "";
        this.f24650b = "";
        this.f24651c = new HashMap();
        this.f24652d = "";
        this.f24649a = str;
    }

    public BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f24649a = "";
        this.f24650b = "";
        this.f24651c = new HashMap();
        this.f24652d = "";
        if (parcel != null) {
            this.f24649a = parcel.readString();
            this.f24650b = parcel.readString();
        }
    }
}
