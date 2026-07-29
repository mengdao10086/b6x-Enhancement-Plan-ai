package com.flydigi.game.ui.download.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.widget.DownloadGameItemView;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadGameStatusAdapter extends BaseQuickAdapter<GameBean, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f15865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15866b;

    public class a implements DownloadGameItemView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f15867a;

        public a(BaseViewHolder baseViewHolder) {
            this.f15867a = baseViewHolder;
        }

        @Override // com.flydigi.game.widget.DownloadGameItemView.b
        public void a(GameBean gameBean, View view) {
            if (DownloadGameStatusAdapter.this.f15865a != null) {
                DownloadGameStatusAdapter.this.f15865a.d(gameBean, view, this.f15867a.getLayoutPosition());
            }
        }

        @Override // com.flydigi.game.widget.DownloadGameItemView.b
        public void b(GameBean gameBean, View view) {
            if (DownloadGameStatusAdapter.this.f15865a != null) {
                DownloadGameStatusAdapter.this.f15865a.c(gameBean, view, this.f15867a.getLayoutPosition());
            }
        }

        @Override // com.flydigi.game.widget.DownloadGameItemView.b
        public void c(GameBean gameBean, View view) {
            if (DownloadGameStatusAdapter.this.f15865a != null) {
                DownloadGameStatusAdapter.this.f15865a.b(gameBean, view, this.f15867a.getLayoutPosition());
            }
        }

        @Override // com.flydigi.game.widget.DownloadGameItemView.b
        public void d() {
            if (DownloadGameStatusAdapter.this.f15865a != null) {
                DownloadGameStatusAdapter.this.f15865a.a(this.f15867a.getLayoutPosition());
            }
        }
    }

    public interface b {
        void a(int i10);

        void b(GameBean gameBean, View view, int i10);

        void c(GameBean gameBean, View view, int i10);

        void d(GameBean gameBean, View view, int i10);
    }

    public DownloadGameStatusAdapter(int i10) {
        super(R.layout.game_item_game_download);
        this.f15866b = i10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, GameBean gameBean) {
        DownloadGameItemView downloadGameItemView = (DownloadGameItemView) baseViewHolder.getView(R.id.download_game_item_view);
        downloadGameItemView.setData(gameBean);
        downloadGameItemView.setStatus(this.f15866b);
        downloadGameItemView.setOnOperateListener(new a(baseViewHolder));
    }

    public void n(b bVar) {
        this.f15865a = bVar;
    }
}
