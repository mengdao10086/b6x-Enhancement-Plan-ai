package n7;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public class a extends BaseItemProvider<LocalGameBean, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, LocalGameBean localGameBean, int i10) {
        baseViewHolder.setImageResource(R.id.iv_icon, R.drawable.main_ic_add_game_square);
        baseViewHolder.setText(R.id.tv_name, R.string.device_add_game);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int layout() {
        return R.layout.device_item_local_game_square;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int viewType() {
        return 2;
    }
}
