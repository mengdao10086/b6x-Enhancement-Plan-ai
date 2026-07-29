package com.flydigi.game.ui.download.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameCatEntity;

/* JADX INFO: loaded from: classes7.dex */
public class GameCatPopAdapter extends BaseQuickAdapter<GameCatEntity, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15869a;

    public GameCatPopAdapter(int i10) {
        super(R.layout.game_item_pop_game_cat);
        this.f15869a = i10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, GameCatEntity gameCatEntity) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_game_cat);
        textView.setText(gameCatEntity.title);
        textView.setSelected(baseViewHolder.getAdapterPosition() == this.f15869a);
    }
}
