package q8;

import android.view.View;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.ui.game_cat_detail.GameCatActivity;

/* JADX INFO: loaded from: classes7.dex */
public class c extends BaseItemProvider<GameBean, BaseViewHolder> {
    public static /* synthetic */ void c(GameBean gameBean, BaseViewHolder baseViewHolder, View view) {
        GameCatEntity gameCatEntity = new GameCatEntity();
        gameCatEntity.f15817id = gameBean.catId;
        gameCatEntity.title = gameBean.catName;
        GameCatActivity.j4(baseViewHolder.itemView.getContext(), gameCatEntity);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final GameBean gameBean, int i10) {
        baseViewHolder.setText(R.id.tv_game_cat, gameBean.catName);
        baseViewHolder.getView(R.id.tv_more).setOnClickListener(new View.OnClickListener() { // from class: q8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c(gameBean, baseViewHolder, view);
            }
        });
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int layout() {
        return R.layout.game_item_game_notice;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int viewType() {
        return 2;
    }
}
