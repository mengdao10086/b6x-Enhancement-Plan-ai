package com.flydigi.game.ui.game_detail;

import a5.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arialyy.aria.core.task.DownloadTask;
import com.blankj.utilcode.util.d1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.base.ui.image_preview.PreviewBean;
import com.flydigi.base.widget.ExpandableTextView;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.APKInstallEvent;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.DownloadTaskEvent;
import com.flydigi.game.data.api.GameApiService;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import com.flydigi.game.data.bean.GameDetailBean;
import com.flydigi.game.ui.game_detail.GameDetailFragment;
import com.flydigi.game.ui.game_detail.adapter.GameDetailPosterAdapter;
import com.flydigi.game.utils.FZGameDownloadHandler;
import com.flydigi.game.widget.TextProgressView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.p0;
import i9.a;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m5.c0;
import m5.f0;
import mg.j;
import o5.l;
import o5.n;
import o5.p;
import org.greenrobot.eventbus.ThreadMode;
import u9.g;
import u9.h;
import xc.d;
import xl.e;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class GameDetailFragment extends FZFragment {
    public TextView A8;
    public TextProgressView B8;
    public String C8;
    public SmartRefreshLayout D8;
    public GameDetailPosterAdapter E8;
    public GameDetailBean F8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public ImageView f15870o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public TextView f15871p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public CBRatingBar f15872q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public TextView f15873r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public TextView f15874s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public RecyclerView f15875t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public ExpandableTextView f15876u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public TextView f15877v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public TextView f15878w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public RelativeLayout f15879x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public LinearLayout f15880y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public TextView f15881z8;

    public class a extends LinearLayoutManager {
        public a(Context context, int i10, boolean z10) {
            super(context, i10, z10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public boolean v() {
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public boolean w() {
            return false;
        }
    }

    public class b implements TextProgressView.a {
        public b() {
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void a() {
            if (GameDetailFragment.this.F8 == null) {
                return;
            }
            GameDetailFragment.this.s6();
            h.o(GameDetailFragment.this.X1(), GameDetailFragment.this.F8.f15818id, e.f55529q, "detail");
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void b() {
            if (GameDetailFragment.this.F8 == null) {
                return;
            }
            GameDetailFragment.this.s6();
            h.o(GameDetailFragment.this.X1(), GameDetailFragment.this.F8.f15818id, d.f55084n0, "detail");
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void c() {
            GameDetailFragment.this.B6();
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void d() {
            GameDetailFragment.this.T6();
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void open() {
            GameDetailFragment.this.L6();
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void pause() {
            if (GameDetailFragment.this.F8 == null) {
                return;
            }
            h.o(GameDetailFragment.this.X1(), GameDetailFragment.this.F8.f15818id, "pause", "detail");
            GameDetailFragment.this.y6();
        }

        @Override // com.flydigi.game.widget.TextProgressView.a
        public void resume() {
            if (GameDetailFragment.this.F8 == null) {
                return;
            }
            GameDetailFragment.this.s6();
            h.o(GameDetailFragment.this.X1(), GameDetailFragment.this.F8.f15818id, "continue", "detail");
        }
    }

    public class c extends m5.c<BaseResponse<GameDetailBean>> {
        public c() {
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
            o.E(str);
        }

        @Override // m5.c
        public void c(boolean z10) {
            if (z10) {
                return;
            }
            GameDetailFragment.this.D8.N();
        }

        @Override // m5.c
        public void d(BaseResponse<GameDetailBean> baseResponse) {
            if (GameDetailFragment.this.A3()) {
                GameDetailBean gameDetailBean = baseResponse.data;
                if (gameDetailBean != null) {
                    GameDetailFragment.this.z6(gameDetailBean);
                } else {
                    o.E(GameDetailFragment.this.c3(R.string.game_not_found));
                    GameDetailFragment.this.w1().finish();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse C6(BaseResponse baseResponse) throws Exception {
        GameDetailBean gameDetailBean = (GameDetailBean) baseResponse.data;
        if (gameDetailBean != null) {
            gameDetailBean.installed = p.c(gameDetailBean.pkgname);
            GameBean installedGameBean = DBManager.getInstalledGameBean(gameDetailBean.pkgname);
            if (installedGameBean != null) {
                gameDetailBean.localPath = installedGameBean.localPath;
                gameDetailBean.progress = installedGameBean.progress;
                gameDetailBean.wifiRequired = installedGameBean.wifiRequired;
                gameDetailBean.updateAble = installedGameBean.updateAble;
                gameDetailBean.appointmentStatus = installedGameBean.appointmentStatus;
                gameDetailBean.isSubscribed = installedGameBean.isSubscribed;
                gameDetailBean.link = installedGameBean.link;
            }
        }
        return baseResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D6(BoxStore boxStore, DownloadTask downloadTask) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean = (GameBean) aVarI.L().s(GameBean_.packageName, this.F8.pkgname, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean == null || gameBean.progress == 100.0f) {
            return;
        }
        gameBean.progress = 100.0f;
        String filePath = downloadTask.getFilePath();
        gameBean.localPath = filePath;
        this.F8.localPath = filePath;
        aVarI.G(gameBean);
        B6();
    }

    public static /* synthetic */ void E6(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        List<String> data = baseQuickAdapter.getData();
        ArrayList arrayList = new ArrayList();
        for (String str : data) {
            PreviewBean previewBean = new PreviewBean();
            previewBean.url = str;
            arrayList.add(previewBean);
        }
        h3.a.j().d(i9.a.f31901c).withSerializable("main_image_urls", arrayList).withInt("main_image_current_position", i10).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F6(View view) {
        if (p.a(H1(), this.f15877v8.getText().toString())) {
            o.E(c3(R.string.game_copy_success));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G6(j jVar) {
        r6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H6(BoxStore boxStore) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean = (GameBean) aVarI.L().s(GameBean_.packageName, this.F8.pkgname, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean != null) {
            try {
                aVarI.U(gameBean);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I6(BaseResponse baseResponse) throws Exception {
        GameDetailBean gameDetailBean = this.F8;
        gameDetailBean.isSubscribed = 1;
        z6(gameDetailBean);
        S6(this.F8.title);
    }

    public static /* synthetic */ void J6(Throwable th2) throws Exception {
        o.E(th2.getMessage());
    }

    public static GameDetailFragment K6(String str) {
        GameDetailFragment gameDetailFragment = new GameDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DataConstant.KEY_GAME_ID, str);
        gameDetailFragment.c5(bundle);
        return gameDetailFragment;
    }

    public final void A6() {
        this.E8 = new GameDetailPosterAdapter();
        this.f15875t8.setLayoutManager(new a(H1(), 0, false));
        this.f15875t8.setHasFixedSize(false);
        this.f15875t8.setNestedScrollingEnabled(false);
        this.f15875t8.setAdapter(this.E8);
        this.E8.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: v8.b
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                GameDetailFragment.E6(baseQuickAdapter, view, i10);
            }
        });
        this.f15878w8.setOnClickListener(new View.OnClickListener() { // from class: v8.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52791a.F6(view);
            }
        });
        this.D8.L(new sg.d() { // from class: v8.h
            @Override // sg.d
            public final void o(j jVar) {
                this.f52801a.G6(jVar);
            }
        });
        this.B8.setOnOperateListener(new b());
        r6();
    }

    @SuppressLint({"CheckResult"})
    public final void B6() {
        if (this.F8 == null) {
            return;
        }
        h.o(X1(), this.F8.f15818id, "install", "");
        try {
            com.blankj.utilcode.util.d.I(this.F8.localPath);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_game_detail;
    }

    public final void L6() {
        if (this.F8 == null) {
            return;
        }
        if (o5.d.o(X1())) {
            v5.d.c(X1(), this.F8.pkgname);
        } else {
            h3.a.j().d(a.d.f31959o).navigation();
        }
    }

    public final void M6() {
        this.B8.i(1, 1.0f);
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: v8.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f52796a.H6(boxStore);
            }
        }, null);
    }

    public final void N6() {
        this.B8.i(6, this.F8.progress / 100.0f);
    }

    public final void O6(GameBean gameBean) {
        this.F8.localPath = gameBean.localPath;
        this.B8.i(5, 1.0f);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        Y5();
    }

    public final void P6(GameBean gameBean) {
        this.B8.i(7, 1.0f);
    }

    public final void Q6(GameBean gameBean) {
        this.B8.i(8, 1.0f);
    }

    public final void R6() {
        TextProgressView textProgressView = this.B8;
        textProgressView.i(6, textProgressView.getProgress());
    }

    public final void S6(String str) {
        HashMap map = new HashMap();
        map.put("title", str);
        g.a().e(X1(), "GAME_SUBSCRIBE_SUCCESS", map);
        o5.a.t0(U1(), new FZDialog.a().t(V2().getString(R.string.game_subscribe_succeed)).j(V2().getString(R.string.game_subscribe_succeed_desc)).b(Boolean.FALSE).l(17).q(V2().getString(R.string.confirm)).p(b6.c.f9082a).a());
    }

    public final void T6() {
        if (f.i().o()) {
            ((GameApiService) f0.i().k().g(GameApiService.class)).subscribeGame(this.F8.f15818id).s0(c0.r()).s0(l.d()).s0(y1()).F5(new dj.g() { // from class: v8.c
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f52793a.I6((BaseResponse) obj);
                }
            }, new dj.g() { // from class: v8.d
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    GameDetailFragment.J6((Throwable) obj);
                }
            });
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        if (T1() != null) {
            this.C8 = T1().getString(DataConstant.KEY_GAME_ID);
        }
        if (d1.g(this.C8)) {
            this.f13317d8.finish();
        }
        J5(view);
        this.f13321h8.setText(R.string.game_detail);
        this.D8 = (SmartRefreshLayout) F5(R.id.smart_refresh_layout);
        this.f15870o8 = (ImageView) F5(R.id.iv_icon);
        this.f15871p8 = (TextView) F5(R.id.tv_name);
        this.f15872q8 = (CBRatingBar) F5(R.id.cb_score);
        this.f15873r8 = (TextView) F5(R.id.tv_score);
        this.f15874s8 = (TextView) F5(R.id.tv_size);
        RecyclerView recyclerView = (RecyclerView) F5(R.id.rv_game_poster);
        this.f15875t8 = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.f15876u8 = (ExpandableTextView) F5(R.id.expandable_text_view);
        this.f15879x8 = (RelativeLayout) F5(R.id.rl_group);
        this.f15877v8 = (TextView) F5(R.id.tv_group_num);
        this.f15878w8 = (TextView) F5(R.id.tv_copy_group_num);
        this.f15880y8 = (LinearLayout) F5(R.id.ll_prize);
        this.f15881z8 = (TextView) F5(R.id.tv_prize_num);
        this.A8 = (TextView) F5(R.id.tv_notice_name);
        TextProgressView textProgressView = (TextProgressView) F5(R.id.text_progress_view);
        this.B8 = textProgressView;
        textProgressView.i(1, 1.0f);
        N5();
        A6();
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(DownloadTaskEvent downloadTaskEvent) {
        if (this.F8 == null || !TextUtils.equals(downloadTaskEvent.mDownloadTask.getDownloadUrl(), this.F8.link)) {
            return;
        }
        DownloadTask downloadTask = downloadTaskEvent.mDownloadTask;
        switch (downloadTaskEvent.mStatus) {
            case 4:
                x6();
                break;
            case 6:
                t6();
                break;
            case 7:
                u6();
                break;
            case 8:
                v6(downloadTask);
                break;
            case 9:
                w6(downloadTask);
                break;
        }
    }

    public final void p6() {
        int currentState = this.F8.getCurrentState();
        GameBean gameBeanConvertGameBean = this.F8.convertGameBean();
        if (currentState == 1) {
            if (gameBeanConvertGameBean.progress == 100.0f) {
                O6(gameBeanConvertGameBean);
                return;
            } else {
                N6();
                return;
            }
        }
        if (currentState == 2) {
            q6(gameBeanConvertGameBean);
            return;
        }
        if (currentState == 3) {
            O6(gameBeanConvertGameBean);
        } else if (currentState == 4) {
            P6(gameBeanConvertGameBean);
        } else {
            if (currentState != 5) {
                return;
            }
            Q6(gameBeanConvertGameBean);
        }
    }

    public final void q6(@p0 GameBean gameBean) {
        if (gameBean == null) {
            if (p.c(this.F8.pkgname)) {
                this.B8.i(3, 1.0f);
            }
        } else if (gameBean.updateAble) {
            this.B8.i(2, 1.0f);
        } else if (p.c(this.F8.pkgname)) {
            this.B8.i(3, 1.0f);
        }
    }

    public final void r6() {
        ((GameApiService) f0.i().k().g(GameApiService.class)).getGameDetail(this.C8).s0(c0.r()).s0(c0.t()).s0(l.d()).s0(y1()).A3(new dj.o() { // from class: v8.e
            @Override // dj.o
            public final Object apply(Object obj) {
                return GameDetailFragment.C6((BaseResponse) obj);
            }
        }).c(new c());
    }

    public final void s6() {
        GameDetailBean gameDetailBean = this.F8;
        if (gameDetailBean == null || TextUtils.isEmpty(gameDetailBean.link)) {
            return;
        }
        GameBean gameBeanConvertGameBean = this.F8.convertGameBean();
        FZGameDownloadHandler fZGameDownloadHandler = FZGameDownloadHandler.getInstance();
        GameDetailBean gameDetailBean2 = this.F8;
        fZGameDownloadHandler.start(gameDetailBean2.link, gameDetailBean2.pkgname);
        FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(gameBeanConvertGameBean);
    }

    public final void t6() {
        this.B8.i(1, 1.0f);
    }

    public final void u6() {
        this.B8.i(1, 1.0f);
    }

    public final void v6(final DownloadTask downloadTask) {
        this.B8.i(5, 1.0f);
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: v8.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f52798a.D6(boxStore, downloadTask);
            }
        }, null);
    }

    public final void w6(DownloadTask downloadTask) {
        this.F8.progress = n.a((downloadTask.getCurrentProgress() * 100.0f) / downloadTask.getDownloadEntity().getFileSize());
        this.B8.i(4, this.F8.progress / 100.0f);
    }

    public final void x6() {
        this.B8.i(4, 0.0f);
    }

    public final void y6() {
        if (this.F8 == null) {
            return;
        }
        FZGameDownloadHandler.getInstance().stop(this.F8.link);
    }

    public final void z6(GameDetailBean gameDetailBean) {
        this.F8 = gameDetailBean;
        l5.a aVarB = l5.a.b();
        ImageView imageView = this.f15870o8;
        aVarB.h(imageView, imageView, gameDetailBean.thumb);
        this.f15871p8.setText(gameDetailBean.title);
        this.f15872q8.A(gameDetailBean.star);
        this.f15873r8.setText(String.valueOf(gameDetailBean.star));
        this.f15874s8.setText(gameDetailBean.size);
        this.E8.setNewData(gameDetailBean.images);
        this.f15876u8.setText(gameDetailBean.description);
        if (!d1.g(gameDetailBean.f15819qq)) {
            this.f15879x8.setVisibility(0);
            this.f15877v8.setText(gameDetailBean.f15819qq);
        }
        if (gameDetailBean.gift != null) {
            this.f15880y8.setVisibility(0);
            this.f15881z8.setText(gameDetailBean.gift.gift);
        }
        this.A8.setText(gameDetailBean.notice);
        p6();
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(APKInstallEvent aPKInstallEvent) {
        if (this.F8 == null) {
            return;
        }
        if (aPKInstallEvent.install) {
            this.B8.i(3, 1.0f);
        } else {
            this.B8.i(1, 1.0f);
        }
    }
}
