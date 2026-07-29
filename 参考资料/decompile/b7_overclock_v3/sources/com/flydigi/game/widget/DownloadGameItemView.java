package com.flydigi.game.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.arialyy.aria.core.task.DownloadTask;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.f1;
import com.flydigi.base.common.i;
import com.flydigi.base.common.o;
import com.flydigi.base.widget.ExpandableTextView;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.APKInstallEvent;
import com.flydigi.game.R;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.DownloadTaskEvent;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import com.flydigi.game.utils.FZGameDownloadHandler;
import com.flydigi.game.widget.DownloadStatusButton;
import com.flydigi.game.widget.a;
import g.n0;
import g.p0;
import g.v0;
import i9.a;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;
import java.util.Locale;
import o5.m;
import o5.n;
import o5.p;
import org.greenrobot.eventbus.ThreadMode;
import tt.l;
import u9.h;
import xc.d;
import xl.e;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadGameItemView extends i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f15922r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f15923s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f15924t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f15925u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f15926v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f15927w = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f15928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f15929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f15930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProgressBar f15931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f15932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f15933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DownloadStatusButton f15934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f15935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GameBean f15936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f15937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageButton f15938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ExpandableTextView f15939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f15941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f15942q;

    public class a implements DownloadStatusButton.a {
        public a() {
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void a() {
            DownloadGameItemView.this.v(e.f55529q);
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void b() {
            DownloadGameItemView.this.v(d.f55084n0);
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void c() {
            DownloadGameItemView.this.D();
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void open() {
            DownloadGameItemView.this.I();
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void order() {
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void pause() {
            DownloadGameItemView.this.C();
            DownloadGameItemView.this.f15933h.setText(R.string.game_pause_already);
            h.o(DownloadGameItemView.this.getContext(), DownloadGameItemView.this.f15936k.f15815id, "pause", "manager");
        }

        @Override // com.flydigi.game.widget.DownloadStatusButton.a
        public void resume() {
            DownloadGameItemView.this.v("continue");
        }
    }

    public interface b {
        void a(GameBean gameBean, View view);

        void b(GameBean gameBean, View view);

        void c(GameBean gameBean, View view);

        void d();
    }

    public DownloadGameItemView(@n0 Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(BoxStore boxStore, DownloadTask downloadTask) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean = (GameBean) aVarI.L().s(GameBean_.packageName, this.f15936k.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean != null) {
            try {
                if (gameBean.progress != 100.0f) {
                    gameBean.progress = 100.0f;
                    String filePath = downloadTask.getFilePath();
                    gameBean.localPath = filePath;
                    this.f15936k.localPath = filePath;
                    aVarI.G(gameBean);
                    D();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        if (this.f15936k != null) {
            h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, this.f15936k.f15815id).navigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        b bVar = this.f15941p;
        if (bVar != null) {
            int i10 = this.f15940o;
            if (i10 == 1) {
                bVar.b(this.f15936k, this.f15938m);
            } else if (i10 == 2) {
                bVar.c(this.f15936k, this.f15938m);
            } else {
                if (i10 != 3) {
                    return;
                }
                bVar.a(this.f15936k, this.f15938m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(String str) {
        this.f15936k.wifiRequired = false;
        w(str);
    }

    private void setButtonOpen(@p0 GameBean gameBean) {
        if (p.c(this.f15936k.packageName)) {
            this.f15934i.setStatus(3);
            if (gameBean != null) {
                if (!b0.h0(gameBean.localPath)) {
                    this.f15938m.setVisibility(8);
                    return;
                }
                this.f15940o = 2;
                this.f15938m.setVisibility(0);
                this.f15938m.setImageResource(R.drawable.main_ic_more);
            }
        }
    }

    public final void A(DownloadTask downloadTask) {
        this.f15930e.setVisibility(0);
        this.f15934i.setStatus(2);
        float fA = n.a((downloadTask.getCurrentProgress() * 100.0f) / downloadTask.getDownloadEntity().getFileSize());
        this.f15936k.progress = fA;
        this.f15931f.setProgress((int) fA);
        this.f15932g.setText(String.format("%s%%", String.format(Locale.CHINA, "%.1f", Float.valueOf(fA))));
        this.f15933h.setText(String.format("%s/s", n.b(downloadTask.getSpeed(), true)));
        FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(this.f15936k);
    }

    public final void B() {
        this.f15930e.setVisibility(0);
    }

    public final void C() {
        FZGameDownloadHandler.getInstance().stop(this.f15936k.link);
    }

    public final void D() {
        h.o(getContext(), this.f15936k.f15815id, "install", "");
        com.blankj.utilcode.util.d.I(this.f15936k.localPath);
    }

    public final void I() {
        if (o5.d.o(getContext())) {
            v5.d.c(getContext(), this.f15936k.packageName);
        } else {
            h3.a.j().d(a.d.f31959o).navigation(getContext());
        }
    }

    public final void J() {
        this.f15933h.setText(R.string.game_pause_already);
        this.f15931f.setProgress((int) this.f15936k.progress);
    }

    public final void K() {
        this.f15934i.setStatus(4);
        this.f15930e.setVisibility(8);
        this.f15937l.setVisibility(0);
        this.f15937l.setText(this.f15936k.size);
        this.f15938m.setVisibility(0);
        this.f15940o = 2;
        this.f15938m.setImageResource(R.drawable.main_ic_delete);
    }

    public final void L() {
        this.f15934i.setStatus(6);
        this.f15933h.setText(R.string.game_pause_already);
    }

    public final void M(final String str) {
        com.flydigi.game.widget.a aVar = new com.flydigi.game.widget.a(getContext());
        aVar.E(new a.InterfaceC0164a() { // from class: z8.c
            @Override // com.flydigi.game.widget.a.InterfaceC0164a
            public final void a() {
                this.f57921a.H(str);
            }
        });
        aVar.show();
    }

    @Override // com.flydigi.base.common.i
    public void f(AttributeSet attributeSet) {
        this.f15935j = (LinearLayout) findViewById(R.id.rl_root);
        this.f15928c = (ImageView) findViewById(R.id.iv_icon);
        this.f15929d = (TextView) findViewById(R.id.tv_name);
        this.f15937l = (TextView) findViewById(R.id.tv_update_time_or_size);
        this.f15938m = (ImageButton) findViewById(R.id.ib_delete_or_more);
        this.f15939n = (ExpandableTextView) findViewById(R.id.expandable_text_view);
        this.f15930e = (LinearLayout) findViewById(R.id.ll_game_status);
        this.f15931f = (ProgressBar) findViewById(R.id.pb_download);
        this.f15932g = (TextView) findViewById(R.id.tv_size_ratio);
        this.f15933h = (TextView) findViewById(R.id.tv_speed);
        this.f15934i = (DownloadStatusButton) findViewById(R.id.download_status_btn);
        this.f15935j.setOnClickListener(new View.OnClickListener() { // from class: z8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57920a.F(view);
            }
        });
        this.f15938m.setOnClickListener(new View.OnClickListener() { // from class: z8.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57919a.G(view);
            }
        });
        this.f15934i.setOnOperateListener(new a());
    }

    @Override // com.flydigi.base.common.i
    public int getLayoutId() {
        return R.layout.game_view_download_game_item;
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

    @l(threadMode = ThreadMode.MAIN)
    public void onEvent(APKInstallEvent aPKInstallEvent) {
        if (TextUtils.equals(aPKInstallEvent.packageName, this.f15936k.packageName)) {
            if (!aPKInstallEvent.install) {
                this.f15930e.setVisibility(8);
                this.f15934i.setStatus(1);
                return;
            }
            this.f15930e.setVisibility(8);
            if (m.k(DataConstant.SP_MAIN).f(DataConstant.SP_MAIN_AUTO_DELETE_APK, true)) {
                this.f15938m.setVisibility(8);
            } else {
                this.f15938m.setVisibility(0);
                this.f15940o = 2;
            }
            this.f15934i.setStatus(3);
        }
    }

    public final void s() {
        GameBean gameBean = this.f15936k;
        if (gameBean == null) {
            t(null);
            return;
        }
        int currentState = gameBean.getCurrentState();
        if (currentState != 1) {
            if (currentState == 2) {
                this.f15938m.setVisibility(8);
                t(this.f15936k);
                return;
            } else {
                if (currentState != 3) {
                    return;
                }
                K();
                return;
            }
        }
        if (this.f15936k.progress == 100.0f) {
            K();
            return;
        }
        this.f15937l.setVisibility(8);
        this.f15930e.setVisibility(0);
        this.f15938m.setVisibility(0);
        this.f15934i.setStatus(6);
        this.f15938m.setImageResource(R.drawable.main_ic_delete);
        J();
    }

    public void setData(GameBean gameBean) {
        this.f15936k = gameBean;
        if (gameBean.installed) {
            Drawable drawableE = com.blankj.utilcode.util.d.e(gameBean.packageName);
            if (drawableE == null) {
                l5.a aVarB = l5.a.b();
                ImageView imageView = this.f15928c;
                aVarB.h(imageView, imageView, gameBean.thumb);
            } else {
                this.f15928c.setImageDrawable(drawableE);
            }
            String strK = com.blankj.utilcode.util.d.k(gameBean.packageName);
            if (d1.g(strK)) {
                this.f15929d.setText(gameBean.title);
            } else {
                this.f15929d.setText(strK);
            }
        } else {
            l5.a aVarB2 = l5.a.b();
            ImageView imageView2 = this.f15928c;
            aVarB2.h(imageView2, imageView2, gameBean.thumb);
            this.f15929d.setText(gameBean.title);
        }
        this.f15938m.setVisibility(4);
        this.f15940o = 1;
        this.f15930e.setVisibility(8);
        this.f15937l.setVisibility(0);
        this.f15934i.setStatus(1);
        this.f15933h.setText("");
        s();
    }

    public void setOnOperateListener(b bVar) {
        this.f15941p = bVar;
    }

    public void setStatus(int i10) {
        this.f15942q = i10;
    }

    public final void t(@p0 GameBean gameBean) {
        this.f15930e.setVisibility(8);
        this.f15937l.setVisibility(0);
        this.f15937l.setText(this.f15936k.size);
        if (gameBean == null) {
            setButtonOpen(null);
            return;
        }
        if (!gameBean.updateAble) {
            setButtonOpen(gameBean);
            return;
        }
        this.f15934i.setStatus(5);
        this.f15938m.setVisibility(8);
        this.f15940o = 0;
        this.f15939n.setText(gameBean.log);
        this.f15937l.setText(f1.B(gameBean.updateTime));
    }

    public final void u(String str) {
        if (NetworkUtils.M()) {
            M(str);
        } else {
            w(str);
        }
    }

    public final void v(String str) {
        if (!NetworkUtils.K()) {
            o.E(getContext().getString(R.string.net_state_error));
            return;
        }
        GameBean gameBean = (GameBean) DBManager.getInstance().getBoxStore().i(GameBean.class).L().s(GameBean_.packageName, this.f15936k.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean == null) {
            u(str);
        } else if (gameBean.wifiRequired) {
            u(str);
        } else {
            w(str);
        }
    }

    public final void w(String str) {
        if (com.blankj.utilcode.util.n0.m(this.f15936k.link)) {
            return;
        }
        this.f15930e.setVisibility(0);
        this.f15937l.setVisibility(8);
        this.f15940o = 1;
        this.f15938m.setVisibility(0);
        this.f15938m.setImageResource(R.drawable.main_ic_delete);
        this.f15932g.setText(String.format("0/%s", this.f15936k.size));
        FZGameDownloadHandler fZGameDownloadHandler = FZGameDownloadHandler.getInstance();
        GameBean gameBean = this.f15936k;
        fZGameDownloadHandler.start(gameBean.link, gameBean.packageName);
        FZGameDownloadHandler.getInstance().addGameDownloadInfoToDB(this.f15936k);
        h.o(getContext(), this.f15936k.f15815id, str, "manager");
    }

    public final void x() {
        this.f15930e.setVisibility(8);
        this.f15934i.setStatus(1);
    }

    public final void y() {
        this.f15934i.setStatus(6);
    }

    public final void z(final DownloadTask downloadTask) {
        b bVar = this.f15941p;
        if (bVar != null) {
            bVar.d();
        }
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: z8.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f57923a.E(boxStore, downloadTask);
            }
        }, null);
        this.f15937l.setVisibility(0);
        this.f15930e.setVisibility(8);
        this.f15940o = 2;
        this.f15938m.setImageResource(R.drawable.main_ic_more);
        this.f15934i.setStatus(4);
    }

    public DownloadGameItemView(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DownloadGameItemView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @v0(api = 21)
    public DownloadGameItemView(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEvent(DownloadTaskEvent downloadTaskEvent) {
        if (TextUtils.equals(downloadTaskEvent.mDownloadTask.getDownloadUrl(), this.f15936k.link)) {
            DownloadTask downloadTask = downloadTaskEvent.mDownloadTask;
            switch (downloadTaskEvent.mStatus) {
                case 4:
                    B();
                    break;
                case 5:
                    L();
                    break;
                case 6:
                    x();
                    break;
                case 7:
                    y();
                    break;
                case 8:
                    z(downloadTask);
                    break;
                case 9:
                    A(downloadTask);
                    break;
            }
        }
    }
}
