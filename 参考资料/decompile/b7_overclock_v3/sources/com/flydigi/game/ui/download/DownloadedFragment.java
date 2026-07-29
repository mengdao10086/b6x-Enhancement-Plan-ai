package com.flydigi.game.ui.download;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.b0;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.common.n;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import com.flydigi.game.ui.download.DownloadedFragment;
import com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter;
import dj.g;
import g.p0;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;
import io.objectbox.query.k0;
import java.util.Collections;
import java.util.List;
import m5.c0;
import o5.l;
import o5.p;
import ri.k;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadedFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public DownloadGameStatusAdapter f15856p8;

    public class a implements DownloadGameStatusAdapter.b {
        public a() {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void a(int i10) {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void b(GameBean gameBean, View view, int i10) {
            DownloadedFragment.this.m6(gameBean, view, i10);
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void c(GameBean gameBean, View view, int i10) {
        }

        @Override // com.flydigi.game.ui.download.adapter.DownloadGameStatusAdapter.b
        public void d(GameBean gameBean, View view, int i10) {
        }
    }

    public class b extends m5.a<List<GameBean>> {
        public b() {
        }

        @Override // m5.a, xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<GameBean> list) {
            DownloadedFragment.this.f15856p8.setNewData(list);
        }
    }

    public static /* synthetic */ void h6(BoxStore boxStore, GameBean gameBean) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean2 = (GameBean) aVarI.L().s(GameBean_.packageName, gameBean.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean2 != null) {
            n.a("delete local file:" + b0.p(gameBean2.localPath));
            gameBean2.localPath = "";
            if (p.c(gameBean2.packageName)) {
                aVarI.G(gameBean2);
            } else {
                aVarI.U(gameBean2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i6(Void r12, Throwable th2) {
        Z5();
    }

    public static /* synthetic */ boolean j6(GameBean gameBean) {
        return gameBean.installed || gameBean.progress == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k6(PopupWindow popupWindow, GameBean gameBean, int i10, View view) {
        popupWindow.dismiss();
        g6(gameBean, i10);
    }

    public static DownloadedFragment l6() {
        return new DownloadedFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_downloaded;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        k.p(DBManager.getInstance().getBoxStore().i(GameBean.class).L().w(new k0() { // from class: t8.g
            @Override // io.objectbox.query.k0
            public final boolean a(Object obj) {
                return DownloadedFragment.j6((GameBean) obj);
            }
        }).g()).Y1(new g() { // from class: t8.e
            @Override // dj.g
            public final void accept(Object obj) {
                Collections.reverse((List) obj);
            }
        }).s0(c0.t()).s0(l.d()).c(new b());
    }

    public final void g6(final GameBean gameBean, int i10) {
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: t8.h
            @Override // java.lang.Runnable
            public final void run() {
                DownloadedFragment.h6(boxStore, gameBean);
            }
        }, new ii.l() { // from class: t8.f
            @Override // ii.l
            public final void a(Object obj, Throwable th2) {
                this.f50929a.i6((Void) obj, th2);
            }
        });
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        RecyclerView recyclerView = (RecyclerView) F5(R.id.rv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(X1()));
        DownloadGameStatusAdapter downloadGameStatusAdapter = new DownloadGameStatusAdapter(3);
        this.f15856p8 = downloadGameStatusAdapter;
        recyclerView.setAdapter(downloadGameStatusAdapter);
        this.f15856p8.setEmptyView(w2().inflate(R.layout.game_view_downloaded_empty, (ViewGroup) recyclerView.getParent(), false));
        this.f15856p8.n(new a());
    }

    public final void m6(final GameBean gameBean, View view, final int i10) {
        View viewInflate = LayoutInflater.from(this.f13317d8).inflate(R.layout.game_pop_delete_file, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setBackgroundDrawable(V2().getDrawable(R.color.color_black_trans));
        ((TextView) viewInflate.findViewById(R.id.tv_delete_file)).setOnClickListener(new View.OnClickListener() { // from class: t8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f50924a.k6(popupWindow, gameBean, i10, view2);
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAsDropDown(view, -V2().getDimensionPixelSize(R.dimen.qb_px_40), 0);
    }
}
