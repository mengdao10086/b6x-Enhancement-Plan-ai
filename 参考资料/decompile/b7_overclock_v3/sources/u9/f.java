package u9;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.common.o;
import com.flydigi.data.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import g.v;
import hk.m;
import kotlin.jvm.internal.f0;
import o5.p;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final f f51965a = new f();

    @m
    public static final void b(@yt.k Activity activity, @yt.k String url, @yt.k String title, @yt.k String description, @v int i10, @yt.k UMShareListener shareListener) {
        f0.p(activity, "activity");
        f0.p(url, "url");
        f0.p(title, "title");
        f0.p(description, "description");
        f0.p(shareListener, "shareListener");
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(activity.getResources(), i10);
        f0.o(bitmapDecodeResource, "decodeResource(activity.resources, image)");
        c(activity, url, title, description, bitmapDecodeResource, shareListener);
    }

    @m
    public static final void c(@yt.k final Activity activity, @yt.k String url, @yt.k String title, @yt.k String description, @yt.k Bitmap image, @yt.k final UMShareListener shareListener) {
        f0.p(activity, "activity");
        f0.p(url, "url");
        f0.p(title, "title");
        f0.p(description, "description");
        f0.p(image, "image");
        f0.p(shareListener, "shareListener");
        final UMWeb uMWeb = new UMWeb(url);
        uMWeb.setTitle(title);
        uMWeb.setDescription(description);
        uMWeb.setThumb(new UMImage(activity, image));
        ShareBoardConfig shareBoardConfig = new ShareBoardConfig();
        shareBoardConfig.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_BOTTOM);
        shareBoardConfig.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE);
        shareBoardConfig.setTitleText(activity.getString(R.string.share));
        shareBoardConfig.setCancelButtonText(activity.getString(R.string.cancel));
        shareBoardConfig.setCancelButtonVisibility(true);
        shareBoardConfig.setIndicatorVisibility(false);
        shareBoardConfig.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_BOTTOM);
        new ShareAction(activity).withMedia(uMWeb).setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ).addButton(activity.getString(R.string.copy_link), "copy_link", "ic_copy", "ic_copy").setShareboardclickCallback(new ShareBoardlistener() { // from class: u9.e
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                f.d(activity, uMWeb, shareListener, snsPlatform, share_media);
            }
        }).open(shareBoardConfig);
    }

    public static final void d(Activity activity, UMWeb web, UMShareListener shareListener, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        f0.p(activity, "$activity");
        f0.p(web, "$web");
        f0.p(shareListener, "$shareListener");
        if (share_media == null) {
            if (snsPlatform.mKeyword.equals("copy_link")) {
                p.a(activity, web.toUrl());
                o.E(activity.getString(R.string.link_copied));
                return;
            }
            return;
        }
        boolean z10 = true;
        if (share_media == SHARE_MEDIA.QQ) {
            if (!UMShareAPI.get(activity).isInstall(activity, share_media)) {
                ToastUtils.T(R.string.community_qq_not_exist);
                z10 = false;
            }
        } else if ((share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.WEIXIN_CIRCLE) && !UMShareAPI.get(activity).isInstall(activity, share_media)) {
            ToastUtils.T(R.string.community_wechat_not_exist);
            z10 = false;
        }
        if (z10) {
            new ShareAction(activity).setPlatform(share_media).withMedia(web).setCallback(shareListener).share();
        }
    }
}
