package com.flydigi.game.ui.game_detail.adapter;

import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.request.h;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flydigi.game.R;

/* JADX INFO: loaded from: classes7.dex */
public class GameDetailPosterAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public GameDetailPosterAdapter() {
        super(R.layout.game_item_game_poster);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_game_poster);
        b.F(imageView).Y(new h().E0(R.drawable.pic_banner_place_holder)).t(str).s1(imageView);
    }
}
