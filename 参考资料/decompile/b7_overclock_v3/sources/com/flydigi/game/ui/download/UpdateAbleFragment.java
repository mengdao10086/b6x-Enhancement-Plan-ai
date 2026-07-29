package com.flydigi.game.ui.download;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter;
import g.p0;
import io.objectbox.query.k0;
import java.util.List;
import ji.c;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class UpdateAbleFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public RecyclerView f15861p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public DownloadGameStatusAdapter f15862q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public View f15863r8;

    public class a implements DownloadGameStatusAdapter.b {
        public a() {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void a(int i10) {
            UpdateAbleFragment.this.f15862q8.remove(i10);
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void b(GameBean gameBean, View view, int i10) {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void c(GameBean gameBean, View view, int i10) {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void d(GameBean gameBean, View view, int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e6(List list) {
        this.f15862q8.setNewData(list);
    }

    public static UpdateAbleFragment f6() {
        return new UpdateAbleFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_downloaded;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        DBManager.getInstance().getBoxStore().i(GameBean.class).L().w(new k0() { // from class: t8.k
            @Override // io.objectbox.query.k0
            public final boolean a(Object obj) {
                return ((GameBean) obj).updateAble;
            }
        }).g().J2().g(c.c()).f(new pi.a() { // from class: t8.l
            @Override // pi.a
            public final void b(Object obj) {
                this.f50938a.e6((List) obj);
            }
        });
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        RecyclerView recyclerView = (RecyclerView) F5(R.id.rv_content);
        this.f15861p8 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(X1()));
        DownloadGameStatusAdapter downloadGameStatusAdapter = new DownloadGameStatusAdapter(2);
        this.f15862q8 = downloadGameStatusAdapter;
        this.f15861p8.setAdapter(downloadGameStatusAdapter);
        View viewInflate = w2().inflate(R.layout.game_view_update_empty, (ViewGroup) this.f15861p8.getParent(), false);
        this.f15863r8 = viewInflate;
        this.f15862q8.setEmptyView(viewInflate);
        this.f15862q8.n(new a());
    }
}
