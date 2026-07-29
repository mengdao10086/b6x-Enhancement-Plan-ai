package com.umeng.socialize;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.shareboard.ShareBoard;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ShareAction {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SHARE_MEDIA f24481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private UMShareListener f24482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ShareBoardlistener f24483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f24484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<SHARE_MEDIA> f24485f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f24490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f24491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ShareBoard f24492m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ShareContent f24480a = new ShareContent();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<SnsPlatform> f24486g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<ShareContent> f24487h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<UMShareListener> f24488i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24489j = 80;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ShareBoardlistener f24493n = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.1
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ShareBoardlistener f24494o = new ShareBoardlistener() { // from class: com.umeng.socialize.ShareAction.2
        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            int iIndexOf = ShareAction.this.f24485f.indexOf(share_media);
            int size = ShareAction.this.f24487h.size();
            if (size != 0) {
                ShareAction.this.f24480a = iIndexOf < size ? (ShareContent) ShareAction.this.f24487h.get(iIndexOf) : (ShareContent) ShareAction.this.f24487h.get(size - 1);
            }
            int size2 = ShareAction.this.f24488i.size();
            if (size2 != 0) {
                if (iIndexOf < size2) {
                    ShareAction shareAction = ShareAction.this;
                    shareAction.f24482c = (UMShareListener) shareAction.f24488i.get(iIndexOf);
                } else {
                    ShareAction shareAction2 = ShareAction.this;
                    shareAction2.f24482c = (UMShareListener) shareAction2.f24488i.get(size2 - 1);
                }
            }
            ShareAction.this.setPlatform(share_media);
            ShareAction.this.share();
        }
    };

    public ShareAction(Activity activity) {
        if (activity != null) {
            this.f24484e = (Activity) new WeakReference(activity).get();
        }
    }

    public static Rect locateView(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return null;
        }
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            int i10 = iArr[0];
            rect.left = i10;
            rect.top = iArr[1];
            rect.right = i10 + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            return rect;
        } catch (NullPointerException e10) {
            SLog.error(e10);
            return null;
        }
    }

    public ShareAction addButton(String str, String str2, String str3, String str4) {
        this.f24486g.add(SHARE_MEDIA.createSnsPlatform(str, str2, str3, str4, 0));
        return this;
    }

    public ShareAction bySystem() {
        this.f24491l = true;
        return this;
    }

    public void close() {
        ShareBoard shareBoard = this.f24492m;
        if (shareBoard != null) {
            shareBoard.dismiss();
            this.f24492m = null;
        }
    }

    public SHARE_MEDIA getPlatform() {
        return this.f24481b;
    }

    public ShareContent getShareContent() {
        return this.f24480a;
    }

    public boolean getUrlValid() {
        UMediaObject uMediaObject;
        ShareContent shareContent = this.f24480a;
        return shareContent == null || (uMediaObject = shareContent.mMedia) == null || !(uMediaObject instanceof UMWeb) || uMediaObject.toUrl() == null || this.f24480a.mMedia.toUrl().startsWith("http");
    }

    public void open(ShareBoardConfig shareBoardConfig) {
        if (CommonUtil.isSilentMode(this.f24484e)) {
            return;
        }
        if (this.f24486g.size() != 0) {
            HashMap map = new HashMap();
            map.put("listener", this.f24482c);
            map.put("content", this.f24480a);
            try {
                ShareBoard shareBoard = new ShareBoard(this.f24484e, this.f24486g, shareBoardConfig);
                this.f24492m = shareBoard;
                ShareBoardlistener shareBoardlistener = this.f24483d;
                if (shareBoardlistener == null) {
                    shareBoard.setShareBoardlistener(this.f24494o);
                } else {
                    shareBoard.setShareBoardlistener(shareBoardlistener);
                }
                this.f24492m.setFocusable(true);
                this.f24492m.setBackgroundDrawable(new BitmapDrawable());
                if (this.f24490k == null) {
                    this.f24490k = this.f24484e.getWindow().getDecorView();
                }
                this.f24492m.showAtLocation(this.f24490k, this.f24489j, 0, 0);
                return;
            } catch (Exception e10) {
                SLog.error(e10);
                return;
            }
        }
        this.f24486g.add(SHARE_MEDIA.WEIXIN.toSnsPlatform());
        this.f24486g.add(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform());
        this.f24486g.add(SHARE_MEDIA.SINA.toSnsPlatform());
        this.f24486g.add(SHARE_MEDIA.QQ.toSnsPlatform());
        this.f24486g.add(SHARE_MEDIA.DINGTALK.toSnsPlatform());
        HashMap map2 = new HashMap();
        map2.put("listener", this.f24482c);
        map2.put("content", this.f24480a);
        ShareBoard shareBoard2 = new ShareBoard(this.f24484e, this.f24486g, shareBoardConfig);
        this.f24492m = shareBoard2;
        ShareBoardlistener shareBoardlistener2 = this.f24483d;
        if (shareBoardlistener2 == null) {
            shareBoard2.setShareBoardlistener(this.f24493n);
        } else {
            shareBoard2.setShareBoardlistener(shareBoardlistener2);
        }
        this.f24492m.setFocusable(true);
        this.f24492m.setBackgroundDrawable(new BitmapDrawable());
        if (this.f24490k == null) {
            this.f24490k = this.f24484e.getWindow().getDecorView();
        }
        this.f24492m.showAtLocation(this.f24490k, 80, 0, 0);
    }

    public ShareAction setCallback(UMShareListener uMShareListener) {
        this.f24482c = uMShareListener;
        return this;
    }

    @Deprecated
    public ShareAction setContentList(ShareContent... shareContentArr) {
        if (shareContentArr == null || Arrays.asList(shareContentArr).size() == 0) {
            ShareContent shareContent = new ShareContent();
            shareContent.mText = "empty";
            this.f24487h.add(shareContent);
        } else {
            this.f24487h = Arrays.asList(shareContentArr);
        }
        return this;
    }

    public ShareAction setDisplayList(SHARE_MEDIA... share_mediaArr) {
        this.f24485f = Arrays.asList(share_mediaArr);
        this.f24486g.clear();
        Iterator<SHARE_MEDIA> it2 = this.f24485f.iterator();
        while (it2.hasNext()) {
            this.f24486g.add(it2.next().toSnsPlatform());
        }
        return this;
    }

    @Deprecated
    public ShareAction setListenerList(UMShareListener... uMShareListenerArr) {
        this.f24488i = Arrays.asList(uMShareListenerArr);
        return this;
    }

    public ShareAction setPlatform(SHARE_MEDIA share_media) {
        this.f24481b = share_media;
        return this;
    }

    public ShareAction setShareContent(ShareContent shareContent) {
        this.f24480a = shareContent;
        return this;
    }

    public ShareAction setShareboardclickCallback(ShareBoardlistener shareBoardlistener) {
        this.f24483d = shareBoardlistener;
        return this;
    }

    public void share() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.f24484e);
        if (uMShareAPI != null) {
            ShareContent shareContent = getShareContent();
            if (shareContent != null) {
                shareContent.bySystem = this.f24491l;
            }
            uMShareAPI.doShare(this.f24484e, this, this.f24482c);
        }
    }

    public ShareAction withApp(File file) {
        this.f24480a.app = file;
        return this;
    }

    public ShareAction withExtra(UMImage uMImage) {
        this.f24480a.mExtra = uMImage;
        return this;
    }

    public ShareAction withFile(File file) {
        this.f24480a.file = file;
        return this;
    }

    public ShareAction withFollow(String str) {
        this.f24480a.mFollow = str;
        return this;
    }

    public ShareAction withMedia(UMImage uMImage) {
        this.f24480a.mMedia = uMImage;
        return this;
    }

    public ShareAction withMedias(UMImage... uMImageArr) {
        if (uMImageArr != null && uMImageArr.length > 0) {
            this.f24480a.mMedia = uMImageArr[0];
        }
        this.f24480a.mMedias = uMImageArr;
        return this;
    }

    public ShareAction withShareBoardDirection(View view, int i10) {
        this.f24489j = i10;
        this.f24490k = view;
        return this;
    }

    public ShareAction withSubject(String str) {
        this.f24480a.subject = str;
        return this;
    }

    public ShareAction withText(String str) {
        this.f24480a.mText = str;
        return this;
    }

    public ShareAction withMedia(UMMin uMMin) {
        this.f24480a.mMedia = uMMin;
        return this;
    }

    public ShareAction withMedia(UMQQMini uMQQMini) {
        this.f24480a.mMedia = uMQQMini;
        return this;
    }

    public ShareAction withMedia(UMEmoji uMEmoji) {
        this.f24480a.mMedia = uMEmoji;
        return this;
    }

    public ShareAction withMedias(UMVideo... uMVideoArr) {
        if (uMVideoArr != null && uMVideoArr.length > 0) {
            this.f24480a.mMedia = uMVideoArr[0];
        }
        this.f24480a.Video_mMedias = uMVideoArr;
        return this;
    }

    public ShareAction withMedia(UMWeb uMWeb) {
        this.f24480a.mMedia = uMWeb;
        return this;
    }

    public ShareAction withMedia(UMusic uMusic) {
        this.f24480a.mMedia = uMusic;
        return this;
    }

    public ShareAction withMedia(UMVideo uMVideo) {
        this.f24480a.mMedia = uMVideo;
        return this;
    }

    public void open() {
        open(null);
    }
}
