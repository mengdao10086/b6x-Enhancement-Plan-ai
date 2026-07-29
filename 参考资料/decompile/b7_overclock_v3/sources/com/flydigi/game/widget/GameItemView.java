package com.flydigi.game.widget;

import a5.f;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import b6.c;
import com.arialyy.aria.core.task.DownloadTask;
import com.blankj.utilcode.util.NetworkUtils;
import com.flydigi.base.common.i;
import com.flydigi.base.common.o;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.flydigi.data.event.APKInstallEvent;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.DownloadTaskEvent;
import com.flydigi.game.data.api.GameApiService;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import com.flydigi.game.utils.FZGameDownloadHandler;
import com.flydigi.game.widget.DownloadStatusButton;
import com.flydigi.game.widget.GameItemView;
import com.flydigi.game.widget.a;
import g.n0;
import g.p0;
import g.v0;
import i9.a;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import m5.c0;
import m5.f0;
import o5.l;
import o5.n;
import o5.p;
import org.greenrobot.eventbus.ThreadMode;
import u9.g;
import u9.h;
import xc.d;
import xl.e;

/* JADX INFO: loaded from: classes7.dex */
public class GameItemView extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f15955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f15957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CBRatingBar f15958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f15959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f15960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f15961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f15962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ProgressBar f15963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f15964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f15965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DownloadStatusButton f15966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameBean f15967o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f15968p;

    public class a implements DownloadStatusButton.a {
        public a() {
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void a() {
            GameItemView.this.y(e.f55529q);
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void b() {
            GameItemView.this.y(d.f55084n0);
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void c() {
            GameItemView.this.G();
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void open() {
            GameItemView.this.M();
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void order() {
            GameItemView.this.S();
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void pause() {
            GameItemView.this.F();
            GameItemView.this.f15965m.setText(R.string.game_pause_already);
            h.o(GameItemView.this.getContext(), GameItemView.this.f15967o.f15815id, "pause", GameItemView.this.f15968p);
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void resume() {
            GameItemView.this.y("continue");
        }
    }

    public GameItemView(@n0 Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(BoxStore boxStore) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean = (GameBean) aVarI.L().s(GameBean_.packageName, this.f15967o.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean != null && gameBean.progress != 100.0f) {
            gameBean.progress = 100.0f;
            this.f15967o.localPath = gameBean.localPath;
            aVarI.G(gameBean);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(BoxStore boxStore) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean = (GameBean) aVarI.L().s(GameBean_.packageName, this.f15967o.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean != null) {
            try {
                aVarI.U(gameBean);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(String str) {
        this.f15967o.wifiRequired = false;
        z(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(BaseResponse baseResponse) throws Exception {
        GameBean gameBean = this.f15967o;
        gameBean.isSubscribed = 1;
        setData(gameBean);
        R(this.f15967o.title);
    }

    public static /* synthetic */ void L(Throwable th2) throws Exception {
        o.E(th2.getMessage());
    }

    private void setInstallStatus(GameBean gameBean) {
        this.f15966n.setStatus(4);
        this.f15967o.localPath = gameBean.localPath;
        this.f15957e.setVisibility(0);
        this.f15962j.setVisibility(8);
    }

    public final void A() {
        this.f15962j.setVisibility(8);
        this.f15957e.setVisibility(0);
        this.f15966n.setStatus(1);
    }

    public final void B() {
        this.f15966n.setStatus(6);
        o.E(getContext().getString(R.string.game_download_state_error));
    }

    public final void C(DownloadTask downloadTask) {
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: z8.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f57944a.H(boxStore);
            }
        }, null);
        this.f15957e.setVisibility(0);
        this.f15962j.setVisibility(8);
        this.f15966n.setStatus(4);
    }

    public final void D(DownloadTask downloadTask) {
        this.f15957e.setVisibility(8);
        this.f15962j.setVisibility(0);
        this.f15966n.setStatus(2);
        this.f15963k.setProgress(downloadTask.getPercent());
        float fA = n.a((downloadTask.getCurrentProgress() * 100.0f) / downloadTask.getDownloadEntity().getFileSize());
        this.f15967o.progress = fA;
        this.f15964l.setText(String.format(Locale.CHINA, "%.2f%%", Float.valueOf(fA)));
        this.f15965m.setText(String.format("%s/s", n.b(downloadTask.getSpeed(), true)));
        FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(this.f15967o);
    }

    public final void E() {
        this.f15957e.setVisibility(8);
        this.f15962j.setVisibility(0);
    }

    public final void F() {
        FZGameDownloadHandler.getInstance().stop(this.f15967o.link);
    }

    public final void G() {
        try {
            if (new File(this.f15967o.localPath).exists()) {
                h.o(getContext(), this.f15967o.f15815id, "install", "");
                com.blankj.utilcode.util.d.I(this.f15967o.localPath);
            } else {
                o.w(getContext().getString(R.string.game_apk_delete_redownload));
                N();
            }
        } catch (Exception unused) {
            o.w(getContext().getString(R.string.game_apk_delete_redownload));
            N();
        }
    }

    public final void M() {
        if (!p.c(this.f15967o.packageName)) {
            N();
            o.E(getContext().getString(R.string.game_uninstall_please_reinstall));
        } else if (o5.d.o(getContext())) {
            v5.d.c(this.f13342a, this.f15967o.packageName);
        } else {
            h3.a.j().d(a.d.f31959o).navigation(getContext());
        }
    }

    public final void N() {
        this.f15966n.setStatus(1);
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: z8.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f57946a.I(boxStore);
            }
        }, null);
    }

    public final void O() {
        this.f15965m.setText(R.string.game_pause_already);
        this.f15963k.setProgress((int) this.f15967o.progress);
        this.f15964l.setText(String.format("%s%%", Float.valueOf(this.f15967o.progress)));
    }

    public final void P() {
        this.f15966n.setStatus(6);
        this.f15965m.setText(R.string.game_pause_already);
    }

    public final void Q(final String str) {
        com.flydigi.game.widget.a aVar = new com.flydigi.game.widget.a(getContext());
        aVar.E(new a.InterfaceC0164a() { // from class: z8.l
            @Override // com.flydigi.game.widget.a.InterfaceC0164a
            public final void a() {
                this.f57940a.J(str);
            }
        });
        aVar.show();
    }

    public final void R(String str) {
        HashMap map = new HashMap();
        map.put("title", str);
        g.a().e(getContext(), "GAME_SUBSCRIBE_SUCCESS", map);
        FZDialog fZDialogA = new FZDialog.a().t(getResources().getString(R.string.game_subscribe_succeed)).j(getResources().getString(R.string.game_subscribe_succeed_desc)).b(Boolean.FALSE).l(17).q(getResources().getString(R.string.confirm)).p(c.f9082a).a();
        Activity activityP = com.blankj.utilcode.util.a.P();
        if (activityP instanceof androidx.fragment.app.g) {
            o5.a.t0(((androidx.fragment.app.g) activityP).n3(), fZDialogA);
        }
    }

    public final void S() {
        if (f.i().o()) {
            ((GameApiService) f0.i().k().g(GameApiService.class)).subscribeGame(this.f15967o.f15815id).s0(c0.r()).s0(l.d()).F5(new dj.g() { // from class: z8.m
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f57942a.K((BaseResponse) obj);
                }
            }, new dj.g() { // from class: z8.n
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    GameItemView.L((Throwable) obj);
                }
            });
        } else {
            h3.a.j().d(a.C0378a.f31905b).navigation();
        }
    }

    @Override // com.flydigi.base.common.i
    public void f(AttributeSet attributeSet) {
        this.f15955c = (ImageView) findViewById(R.id.iv_icon);
        this.f15956d = (TextView) findViewById(R.id.tv_name);
        this.f15957e = (LinearLayout) findViewById(R.id.ll_game_info);
        this.f15958f = (CBRatingBar) findViewById(R.id.cb_score);
        this.f15959g = (TextView) findViewById(R.id.tv_score);
        this.f15960h = (TextView) findViewById(R.id.tv_size);
        this.f15961i = (TextView) findViewById(R.id.tv_info);
        this.f15962j = (LinearLayout) findViewById(R.id.ll_game_status);
        this.f15963k = (ProgressBar) findViewById(R.id.pb_download);
        this.f15964l = (TextView) findViewById(R.id.tv_size_ratio);
        this.f15965m = (TextView) findViewById(R.id.tv_speed);
        DownloadStatusButton downloadStatusButton = (DownloadStatusButton) findViewById(R.id.download_status_btn);
        this.f15966n = downloadStatusButton;
        downloadStatusButton.setOnOperateListener(new a());
    }

    @Override // com.flydigi.base.common.i
    public int getLayoutId() {
        return R.layout.game_view_game_item;
    }

    public String getRefer() {
        return this.f15968p;
    }

    @Override // com.flydigi.base.common.i, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // com.flydigi.base.common.i, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @tt.l(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(APKInstallEvent aPKInstallEvent) {
        if (TextUtils.equals(aPKInstallEvent.packageName, this.f15967o.packageName)) {
            if (aPKInstallEvent.install) {
                this.f15962j.setVisibility(8);
                this.f15957e.setVisibility(0);
                this.f15966n.setStatus(3);
            } else {
                this.f15962j.setVisibility(8);
                this.f15957e.setVisibility(0);
                this.f15966n.setStatus(1);
            }
        }
    }

    public void setData(GameBean gameBean) {
        this.f15967o = gameBean;
        l5.a.b().h(this, this.f15955c, gameBean.thumb);
        this.f15956d.setText(gameBean.title);
        this.f15958f.A(gameBean.star);
        this.f15959g.setText(String.valueOf(gameBean.star));
        this.f15960h.setText(gameBean.size);
        this.f15961i.setText(gameBean.description);
        this.f15957e.setVisibility(0);
        this.f15962j.setVisibility(8);
        this.f15966n.setStatus(1);
        v(gameBean);
    }

    public void setRefer(String str) {
        this.f15968p = str;
    }

    public final void v(GameBean gameBean) {
        GameBean installedGameBean = DBManager.getInstalledGameBean(gameBean.packageName);
        gameBean.installed = p.c(gameBean.packageName);
        if (installedGameBean != null) {
            gameBean.localPath = installedGameBean.localPath;
            gameBean.progress = installedGameBean.progress;
            gameBean.wifiRequired = installedGameBean.wifiRequired;
            gameBean.updateAble = installedGameBean.updateAble;
            gameBean.packageName = installedGameBean.packageName;
            gameBean.appointmentStatus = installedGameBean.appointmentStatus;
            gameBean.isSubscribed = installedGameBean.isSubscribed;
            gameBean.link = installedGameBean.link;
        } else {
            gameBean.progress = -1.0f;
        }
        this.f15966n.setEnabled(true);
        int currentState = gameBean.getCurrentState();
        if (currentState == 1) {
            if (gameBean.progress == 100.0f) {
                setInstallStatus(gameBean);
                return;
            }
            this.f15966n.setStatus(6);
            this.f15957e.setVisibility(8);
            this.f15962j.setVisibility(0);
            O();
            return;
        }
        if (currentState == 2) {
            w(gameBean);
            return;
        }
        if (currentState == 3) {
            setInstallStatus(gameBean);
            return;
        }
        if (currentState == 4) {
            this.f15966n.setStatus(7);
            this.f15957e.setVisibility(0);
            this.f15962j.setVisibility(8);
        } else {
            if (currentState != 5) {
                return;
            }
            this.f15966n.setStatus(8);
            this.f15966n.setEnabled(false);
            this.f15957e.setVisibility(0);
            this.f15962j.setVisibility(8);
        }
    }

    public final void w(GameBean gameBean) {
        this.f15962j.setVisibility(8);
        this.f15957e.setVisibility(0);
        if (gameBean.installed) {
            if (gameBean.updateAble) {
                this.f15966n.setStatus(5);
            } else {
                this.f15966n.setStatus(3);
            }
        }
    }

    public final void x(String str) {
        if (NetworkUtils.M()) {
            Q(str);
        } else {
            z(str);
        }
    }

    public final void y(String str) {
        if (!NetworkUtils.K()) {
            o.E(getContext().getString(R.string.net_state_error));
            return;
        }
        GameBean gameBean = (GameBean) DBManager.getInstance().getBoxStore().i(GameBean.class).L().s(GameBean_.packageName, this.f15967o.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean == null) {
            x(str);
        } else if (gameBean.wifiRequired) {
            x(str);
        } else {
            z(str);
        }
    }

    public final void z(String str) {
        this.f15966n.setStatus(2);
        this.f15962j.setVisibility(0);
        this.f15957e.setVisibility(8);
        this.f15963k.setProgress((int) this.f15967o.progress);
        this.f15964l.setText(String.format("0/%s", this.f15967o.size));
        this.f15965m.setText("");
        h.o(getContext(), this.f15967o.f15815id, str, this.f15968p);
        FZGameDownloadHandler fZGameDownloadHandler = FZGameDownloadHandler.getInstance();
        GameBean gameBean = this.f15967o;
        fZGameDownloadHandler.start(gameBean.link, gameBean.packageName);
        FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(this.f15967o);
    }

    public GameItemView(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameItemView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @v0(api = 21)
    public GameItemView(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(DownloadTaskEvent downloadTaskEvent) {
        if (TextUtils.equals(downloadTaskEvent.mDownloadTask.getDownloadUrl(), this.f15967o.link)) {
            DownloadTask downloadTask = downloadTaskEvent.mDownloadTask;
            switch (downloadTaskEvent.mStatus) {
                case 4:
                    E();
                    break;
                case 5:
                    P();
                    break;
                case 6:
                    A();
                    break;
                case 7:
                    B();
                    break;
                case 8:
                    C(downloadTask);
                    break;
                case 9:
                    D(downloadTask);
                    break;
            }
        }
    }
}
