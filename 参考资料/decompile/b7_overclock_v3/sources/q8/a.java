package q8;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.widget.GameItemView;

/* JADX INFO: loaded from: classes7.dex */
public class a extends BaseItemProvider<GameBean, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47153a;

    public a(String str) {
        this.f47153a = str;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, GameBean gameBean, int i10) {
        GameItemView gameItemView = (GameItemView) baseViewHolder.getView(R.id.game_item_view);
        gameItemView.setData(gameBean);
        gameItemView.setRefer(this.f47153a);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int layout() {
        return R.layout.game_item_game;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int viewType() {
        return 1;
    }
}
