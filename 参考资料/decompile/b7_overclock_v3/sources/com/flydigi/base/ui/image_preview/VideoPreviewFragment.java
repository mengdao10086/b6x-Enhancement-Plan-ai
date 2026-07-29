package com.flydigi.base.ui.image_preview;

import android.os.Bundle;
import android.view.View;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.blankj.utilcode.util.d1;
import com.flydigi.base.R;
import com.flydigi.base.common.FZLazyFragment;
import g.p0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPreviewFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final String f13396t8 = "video_url";

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final String f13397u8 = "video_cover";

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final String f13398v8 = "video_title";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public JzvdStd f13399p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public String f13400q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public String f13401r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public String f13402s8;

    public static VideoPreviewFragment a6(PreviewBean previewBean) {
        VideoPreviewFragment videoPreviewFragment = new VideoPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(f13396t8, previewBean.url);
        bundle.putString(f13397u8, previewBean.videoCover);
        bundle.putString(f13398v8, previewBean.title);
        videoPreviewFragment.c5(bundle);
        return videoPreviewFragment;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_layout_fragment_video;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        this.f13399p8.setUp(this.f13400q8, d1.l(this.f13402s8), 0);
        l5.a.b().d(this.f13317d8, this.f13399p8.posterImageView, this.f13401r8);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        Jzvd.releaseAllVideos();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.f13400q8 = bundleT1.getString(f13396t8);
            this.f13401r8 = bundleT1.getString(f13397u8);
            this.f13402s8 = bundleT1.getString(f13398v8);
        }
        JzvdStd jzvdStd = (JzvdStd) F5(R.id.jz_video_player_standard);
        this.f13399p8 = jzvdStd;
        jzvdStd.startButton.setImageResource(R.drawable.community_ic_video_play_mark);
    }
}
