package com.flydigi.game.ui.download;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.c;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.ui.download.DownloadingFragment;
import com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter;
import com.flydigi.game.utils.FZGameDownloadHandler;
import g.p0;
import io.objectbox.query.k0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadingFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public DownloadGameStatusAdapter f15859p8;

    public class a implements DownloadGameStatusAdapter.b {
        public a() {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void a(int i10) {
            DownloadingFragment.this.f15859p8.remove(i10);
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void b(GameBean gameBean, View view, int i10) {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void c(GameBean gameBean, View view, int i10) {
            DownloadingFragment.this.j6(gameBean, view, i10);
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void d(GameBean gameBean, View view, int i10) {
        }
    }

    public static /* synthetic */ boolean f6(GameBean gameBean) {
        return gameBean.getCurrentState() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g6(GameBean gameBean, int i10, DialogFragment dialogFragment) {
        i6(gameBean);
        if (this.f15859p8.getItemCount() != 0) {
            this.f15859p8.remove(i10);
        }
        dialogFragment.I5();
    }

    public static DownloadingFragment h6() {
        return new DownloadingFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_downloaded;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        e6();
    }

    public final void e6() {
        this.f15859p8.setNewData(DBManager.getInstance().getBoxStore().i(GameBean.class).L().w(new k0() { // from class: t8.j
            @Override // io.objectbox.query.k0
            public final boolean a(Object obj) {
                return DownloadingFragment.f6((GameBean) obj);
            }
        }).g().W());
    }

    public final void i6(GameBean gameBean) {
        FZGameDownloadHandler.getInstance().cancel(gameBean);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        RecyclerView recyclerView = (RecyclerView) F5(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(X1()));
        DownloadGameStatusAdapter downloadGameStatusAdapter = new DownloadGameStatusAdapter(1);
        this.f15859p8 = downloadGameStatusAdapter;
        recyclerView.setAdapter(downloadGameStatusAdapter);
        this.f15859p8.setEmptyView(w2().inflate(R.layout.game_view_downloading_empty, (ViewGroup) recyclerView.getParent(), false));
        this.f15859p8.n(new a());
    }

    public final void j6(final GameBean gameBean, View view, final int i10) {
        new FZDialog.a().t(c3(R.string.game_delete_game)).j(c3(R.string.game_delete_game_notice)).d(c3(R.string.cancel)).g(c3(R.string.confirm)).b(Boolean.TRUE).f(new FZDialog.c() { // from class: t8.i
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                this.f50933a.g6(gameBean, i10, dialogFragment);
            }
        }).c(c.f9082a).u(t2(), "delete_task");
    }
}
