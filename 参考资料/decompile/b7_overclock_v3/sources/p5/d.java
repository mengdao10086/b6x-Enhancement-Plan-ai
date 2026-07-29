package p5;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.flydigi.base.R;

/* JADX INFO: loaded from: classes2.dex */
public class d extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLayoutId() {
        return R.layout.view_load_more;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }
}
