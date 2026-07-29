package com.umeng.socialize.media;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import m7.a;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleShareContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UMImage f24654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UMImage[] f24655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private UMVideo f24657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UMVideo[] f24658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UMEmoji f24659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UMusic f24660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private UMMin f24661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private UMQQMini f24662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private UMWeb f24663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f24664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BaseMediaObject f24665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f24666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f24667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f24668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CompressListener f24669p;
    public int THUMB_LIMIT = 24576;
    public int WX_THUMB_LIMIT = 18432;
    public int WX_MIN_LIMIT = 131072;
    public final int IMAGE_LIMIT = 491520;
    public final String DEFAULT_TITLE = "这里是标题";
    public final String DEFAULT_DESCRIPTION = "这里是描述";

    public SimpleShareContent(ShareContent shareContent) {
        UMVideo[] uMVideoArr;
        this.f24656c = shareContent.mText;
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject == null || !(uMediaObject instanceof UMImage) || (uMVideoArr = shareContent.Video_mMedias) == null) {
            if (uMediaObject != null && (uMediaObject instanceof UMImage)) {
                UMImage uMImage = (UMImage) uMediaObject;
                this.f24654a = uMImage;
                this.f24665l = uMImage;
                UMImage[] uMImageArr = shareContent.mMedias;
                if (uMImageArr != null && uMImageArr.length > 0) {
                    this.f24655b = uMImageArr;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMusic)) {
                UMusic uMusic = (UMusic) uMediaObject;
                this.f24660g = uMusic;
                this.f24665l = uMusic;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMVideo)) {
                UMVideo uMVideo = (UMVideo) uMediaObject;
                this.f24657d = uMVideo;
                this.f24665l = uMVideo;
                UMVideo[] uMVideoArr2 = shareContent.Video_mMedias;
                if (uMVideoArr2 != null && uMVideoArr2.length > 0) {
                    this.f24658e = uMVideoArr2;
                }
            }
            if (uMediaObject != null && (uMediaObject instanceof UMEmoji)) {
                UMEmoji uMEmoji = (UMEmoji) uMediaObject;
                this.f24659f = uMEmoji;
                this.f24665l = uMEmoji;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMWeb)) {
                UMWeb uMWeb = (UMWeb) uMediaObject;
                this.f24663j = uMWeb;
                this.f24665l = uMWeb;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMMin)) {
                this.f24661h = (UMMin) uMediaObject;
                this.f24665l = this.f24663j;
            }
            if (uMediaObject != null && (uMediaObject instanceof UMQQMini)) {
                this.f24662i = (UMQQMini) uMediaObject;
                this.f24665l = this.f24663j;
            }
            File file = shareContent.file;
            if (file != null) {
                this.f24664k = file;
            }
        } else {
            UMImage uMImage2 = (UMImage) uMediaObject;
            this.f24654a = uMImage2;
            this.f24665l = uMImage2;
            UMImage[] uMImageArr2 = shareContent.mMedias;
            if (uMImageArr2 != null && uMImageArr2.length > 0) {
                this.f24655b = uMImageArr2;
            }
            this.f24665l = this.f24657d;
            if (uMVideoArr != null && uMVideoArr.length > 0) {
                this.f24658e = uMVideoArr;
            }
        }
        this.f24668o = shareContent.subject;
        this.f24666m = shareContent.getShareType();
        this.f24667n = a();
    }

    private String a() {
        int i10 = this.f24666m;
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 8 ? i10 != 16 ? i10 != 32 ? i10 != 64 ? i10 != 128 ? i10 != 256 ? d.O : "qqMini" : "minapp" : "emoji" : a.f40702b : "web" : "video" : "music" : "textandimage" : "image" : "text";
    }

    private byte[] b() {
        byte[] bytes = DefaultClass.getBytes();
        if (ContextUtil.getIcon() != 0 && ((bytes = com.umeng.socialize.c.a.a.a(new UMImage(ContextUtil.getContext(), ContextUtil.getIcon()), this.WX_THUMB_LIMIT)) == null || bytes.length <= 0)) {
            SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        }
        return bytes;
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null;
    }

    public String getAssertSubject() {
        return TextUtils.isEmpty(this.f24668o) ? "umengshare" : this.f24668o;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.f24665l;
    }

    public File getFile() {
        return this.f24664k;
    }

    public UMImage getImage() {
        return this.f24654a;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() == null) {
            return b();
        }
        byte[] bArrA = com.umeng.socialize.c.a.a.a(uMImage.getThumbImage(), this.WX_THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public UMusic getMusic() {
        return this.f24660g;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        return TextUtils.isEmpty(uMusic.getmTargetUrl()) ? uMusic.toUrl() : uMusic.getmTargetUrl();
    }

    public UMQQMini getQQMini() {
        return this.f24662i;
    }

    public String getStrStyle() {
        return this.f24667n;
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) <= 491520) {
            return getImageData(uMImage);
        }
        byte[] bArrA = com.umeng.socialize.c.a.a.a(getImage(), 491520);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return null;
    }

    public String getSubject() {
        return this.f24668o;
    }

    public String getText() {
        return this.f24656c;
    }

    public int getUMImageScale(UMImage uMImage) {
        return com.umeng.socialize.c.a.a.a(uMImage);
    }

    public UMEmoji getUmEmoji() {
        return this.f24659f;
    }

    public UMMin getUmMin() {
        return this.f24661h;
    }

    public UMVideo[] getUmVideos() {
        return this.f24658e;
    }

    public UMWeb getUmWeb() {
        return this.f24663j;
    }

    public UMVideo getVideo() {
        return this.f24657d;
    }

    public UMImage[] getmImages() {
        return this.f24655b;
    }

    public int getmStyle() {
        return this.f24666m;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        String description = baseMediaObject.getDescription();
        return description.length() > 1024 ? description.substring(0, 1024) : description;
    }

    public byte[] objectSetMInAppThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return DefaultClass.getBytes();
        }
        if (this.f24669p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || com.umeng.socialize.c.a.a.a(thumbImage) > this.WX_MIN_LIMIT) ? this.f24669p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = com.umeng.socialize.c.a.a.a(baseMediaObject.getThumbImage().asBinImage(), this.WX_MIN_LIMIT, Bitmap.CompressFormat.JPEG);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return bArrA;
    }

    public String objectSetText(String str, int i10) {
        return TextUtils.isEmpty(str) ? "这里是描述" : str.length() > i10 ? str.substring(0, i10) : str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return b();
        }
        if (this.f24669p != null) {
            UMImage thumbImage = baseMediaObject.getThumbImage();
            if (thumbImage == null) {
                return DefaultClass.getBytes();
            }
            byte[] bArrAsBinImage = thumbImage.asBinImage();
            return (bArrAsBinImage == null || com.umeng.socialize.c.a.a.a(thumbImage) > this.THUMB_LIMIT) ? this.f24669p.compressThumb(bArrAsBinImage) : bArrAsBinImage;
        }
        byte[] bArrA = com.umeng.socialize.c.a.a.a(baseMediaObject.getThumbImage(), this.THUMB_LIMIT);
        if (bArrA != null && bArrA.length > 0) {
            return bArrA;
        }
        SLog.E(UmengText.IMAGE.SHARECONTENT_THUMB_ERROR);
        return b();
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        String title = baseMediaObject.getTitle();
        return title.length() > 512 ? title.substring(0, 512) : title;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.f24669p = compressListener;
    }

    public void setImage(UMImage uMImage) {
        this.f24654a = uMImage;
    }

    public void setMusic(UMusic uMusic) {
        this.f24660g = uMusic;
    }

    public void setText(String str) {
        this.f24656c = str;
    }

    public void setVideo(UMVideo uMVideo) {
        this.f24657d = uMVideo;
    }

    public String subString(String str, int i10) {
        return (!TextUtils.isEmpty(str) || str.length() <= i10) ? str : str.substring(0, i10);
    }

    public String objectSetText(String str) {
        return objectSetText(str, androidx.work.d.f8361d);
    }
}
