package n7;

import com.blankj.utilcode.util.d;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public class b extends BaseItemProvider<LocalGameBean, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, LocalGameBean localGameBean, int i10) {
        baseViewHolder.setImageDrawable(R.id.iv_icon, d.e(localGameBean.localPackageName));
        baseViewHolder.setText(R.id.tv_name, localGameBean.name);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int layout() {
        return R.layout.device_item_local_game_square;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int viewType() {
        return 1;
    }
}
