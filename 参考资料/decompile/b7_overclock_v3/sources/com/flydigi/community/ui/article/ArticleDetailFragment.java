package com.flydigi.community.ui.article;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.f1;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.ui.image_preview.PreviewBean;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.community.R;
import com.flydigi.community.ui.article.f;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleTopic;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import com.just.agentweb.AgentWebView;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import f.b;
import i9.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.text.Regex;
import kotlin.z1;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nArticleDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArticleDetailFragment.kt\ncom/flydigi/community/ui/article/ArticleDetailFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,663:1\n1#2:664\n*E\n"})
public final class ArticleDetailFragment extends FZLazyFragment implements f.b {

    @yt.k
    public static final b A8 = new b(null);

    @yt.k
    public static final String B8 = "1";

    @yt.k
    public static final String C8 = "4";

    @yt.k
    public static final String D8 = "5";

    @yt.k
    public static final String E8 = "6";

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public String f13686p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public f.a f13687q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public c f13688r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public y5.i f13689s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public int f13690t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public int f13691u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.l
    public ArticleBean f13692v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public final ArrayList<ContentAddBean> f13693w8 = new ArrayList<>();

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.l
    public View f13694x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.l
    public WebChromeClient.CustomViewCallback f13695y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f13696z8;

    public static final class a {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public final void open_url(@yt.k String data, @yt.k String type) {
            kotlin.jvm.internal.f0.p(data, "data");
            kotlin.jvm.internal.f0.p(type, "type");
            com.flydigi.base.common.n.b("网页JS传来参数：" + data + zc.f.f58383m + type, new Object[0]);
            int iHashCode = type.hashCode();
            if (iHashCode != 49) {
                switch (iHashCode) {
                    case 52:
                        if (!type.equals("4")) {
                            return;
                        }
                        break;
                    case 53:
                        if (type.equals("5")) {
                            ArrayList arrayList = new ArrayList();
                            PreviewBean previewBean = new PreviewBean();
                            previewBean.url = data;
                            arrayList.add(previewBean);
                            h3.a.j().d(i9.a.f31901c).withSerializable("main_image_urls", arrayList).withInt("main_image_current_position", 0).navigation();
                            return;
                        }
                        return;
                    case 54:
                        if (!type.equals("6")) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
            } else if (!type.equals("1")) {
                return;
            }
            h3.a.j().d(a.b.f31919d).withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13289g).navigation();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final ArticleDetailFragment a(int i10, int i11, @yt.k String source, @yt.l ArticleBean articleBean) {
            kotlin.jvm.internal.f0.p(source, "source");
            ArticleDetailFragment articleDetailFragment = new ArticleDetailFragment();
            articleDetailFragment.c5(androidx.core.os.e.b(new Pair("id", Integer.valueOf(i10)), new Pair(DataConstant.COMMUNITY_MESSAGE_ID, Integer.valueOf(i11)), new Pair(DataConstant.COMMUNITY_ARTICLE_SOURCE, source), new Pair(a.b.f31931p, articleBean)));
            return articleDetailFragment;
        }
    }

    public interface c {
        void J2(@yt.k ArticleBean articleBean);

        void n1(boolean z10);
    }

    public static final class d extends ViewPager2.j {
        public d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i10) {
            super.c(i10);
            y5.i iVar = ArticleDetailFragment.this.f13689s8;
            if (iVar == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar = null;
            }
            TextView textView = iVar.f56351n;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10 + 1);
            sb2.append(zc.f.f58380j);
            sb2.append(ArticleDetailFragment.this.f13693w8.size());
            textView.setText(sb2.toString());
        }
    }

    public static final class e implements UMShareListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArticleBean f13701b;

        public e(ArticleBean articleBean) {
            this.f13701b = articleBean;
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(@yt.k SHARE_MEDIA p02) {
            kotlin.jvm.internal.f0.p(p02, "p0");
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(@yt.k SHARE_MEDIA p02, @yt.k Throwable p12) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            kotlin.jvm.internal.f0.p(p12, "p1");
            ToastUtils.T(R.string.community_share_failed);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(@yt.k SHARE_MEDIA p02) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            ToastUtils.T(R.string.community_share_success);
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(@yt.k SHARE_MEDIA p02) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            Context contextX1 = ArticleDetailFragment.this.X1();
            int id2 = this.f13701b.getId();
            int type = this.f13701b.getType();
            String str = ArticleDetailFragment.this.f13686p8;
            f.a aVar = null;
            if (str == null) {
                kotlin.jvm.internal.f0.S("source");
                str = null;
            }
            u9.h.i(contextX1, id2, type, str, "分享");
            f.a aVar2 = ArticleDetailFragment.this.f13687q8;
            if (aVar2 == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
            } else {
                aVar = aVar2;
            }
            aVar.J(this.f13701b.getId(), this.f13701b.getShareCount());
        }
    }

    public static final class f extends WebViewClient {
        public f() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@yt.k WebView view, @yt.k String url) {
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(url, "url");
            if (kotlin.text.u.K1(url, ".apk", false, 2, null)) {
                return o5.f.f(ArticleDetailFragment.this.f13317d8, url);
            }
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, "").withString(DataConstant.WEB_URL, url).navigation();
            return true;
        }
    }

    public static final class g extends WebChromeClient {
        public g() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            ArticleDetailFragment.this.N6();
            i9.b.f(ArticleDetailFragment.this, DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
            super.onHideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(@yt.k View view, @yt.k WebChromeClient.CustomViewCallback callback) {
            kotlin.jvm.internal.f0.p(view, "view");
            kotlin.jvm.internal.f0.p(callback, "callback");
            super.onShowCustomView(view, callback);
            i9.b.f(ArticleDetailFragment.this, DataConstant.REMOTE_ACTION_START_TEST_KEYMAPPING_UI);
            ArticleDetailFragment.this.M6(view, callback);
        }
    }

    public static final class h extends TagFlowLayout.a<ArticleTopic> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<ArticleTopic> f13704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArticleDetailFragment f13705c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List<ArticleTopic> list, ArticleDetailFragment articleDetailFragment) {
            super(list);
            this.f13704b = list;
            this.f13705c = articleDetailFragment;
        }

        @Override // com.flydigi.base.widget.TagFlowLayout.a
        @yt.k
        public View c(int i10) {
            View item = LayoutInflater.from(this.f13705c.X1()).inflate(R.layout.community_item_tag_topic, (ViewGroup) null, false);
            item.setSelected(true);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.rightMargin = item.getResources().getDimensionPixelSize(R.dimen.qb_px_8);
            item.setLayoutParams(marginLayoutParams);
            TextView textView = (TextView) item.findViewById(R.id.tv_title);
            TopicBean topic = this.f13704b.get(i10).getTopic();
            textView.setText(topic != null ? topic.getTitle() : null);
            kotlin.jvm.internal.f0.o(item, "item");
            return item;
        }
    }

    public static final class i extends FragmentStateAdapter {
        public i() {
            super(ArticleDetailFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @yt.k
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public MediaBannerFragment n(int i10) {
            return MediaBannerFragment.f13715s8.a(ArticleDetailFragment.this.f13693w8, i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return ArticleDetailFragment.this.f13693w8.size();
        }
    }

    public ArticleDetailFragment() {
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.community.ui.article.x
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ArticleDetailFragment.S6(this.f13782a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.f13696z8 = gVarP1;
    }

    public static final CFGEntityList I6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (CFGEntityList) tmp0.i(obj);
    }

    public static final void J6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void K6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @hk.m
    @yt.k
    public static final ArticleDetailFragment L6(int i10, int i11, @yt.k String str, @yt.l ArticleBean articleBean) {
        return A8.a(i10, i11, str, articleBean);
    }

    public static final void O6(ArticleDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        f.a aVar = this$0.f13687q8;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
            aVar = null;
        }
        aVar.b0(this$0.f13690t8);
    }

    public static final void P6(ArticleDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.c0();
    }

    public static final void Q6(ArticleDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.R6();
    }

    public static final void S6(ArticleDetailFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            this$0.R6();
        } else if (activityResult.b() == 0) {
            this$0.m7();
        }
    }

    public static final void U6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void V6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void W6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void X6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void Z6(String pkgname, final ArticleDetailFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(pkgname, "$pkgname");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        xi.z<String> standardPackageNameOrDefault = DBManager.getInstance().getStandardPackageNameOrDefault(pkgname);
        final ArticleDetailFragment$saveConfigSuccess$1$1 articleDetailFragment$saveConfigSuccess$1$1 = new ik.l<String, InstalledGameBean>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfigSuccess$1$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InstalledGameBean i(@yt.k String it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return DBManager.getInstance().getInstalledGame(it2);
            }
        };
        xi.z zVarS0 = standardPackageNameOrDefault.A3(new dj.o() { // from class: com.flydigi.community.ui.article.s
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailFragment.a7(articleDetailFragment$saveConfigSuccess$1$1, obj);
            }
        }).s0(o5.l.d());
        final ik.l<InstalledGameBean, z1> lVar = new ik.l<InstalledGameBean, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfigSuccess$1$2
            {
                super(1);
            }

            public final void b(InstalledGameBean installedGameBean) {
                if (o5.d.o(this.this$0.X1())) {
                    v5.d.c(this.this$0.H1(), installedGameBean.getLocalPackageName());
                } else {
                    h3.a.j().d(a.d.f31959o).navigation(this.this$0.w1());
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(InstalledGameBean installedGameBean) {
                b(installedGameBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.j
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.b7(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfigSuccess$1$3
            {
                super(1);
            }

            public final void b(Throwable th2) {
                com.flydigi.base.common.o.E(this.this$0.c3(R.string.community_game_not_install));
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.p
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.c7(lVar2, obj);
            }
        });
    }

    public static final InstalledGameBean a7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (InstalledGameBean) tmp0.i(obj);
    }

    public static final void b7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void c7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void d7(List it2, int i10, View view) {
        kotlin.jvm.internal.f0.p(it2, "$it");
        kotlin.jvm.internal.f0.p(view, "view");
        view.setSelected(true);
        h3.a.j().d(a.b.f31918c).withParcelable(a.b.f31929n, ((ArticleTopic) it2.get(i10)).getTopic()).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13289g).navigation();
    }

    public static final File f7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final Bitmap g7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (Bitmap) tmp0.i(obj);
    }

    public static final void h7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void i7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void k7(ArticleDetailFragment this$0, CfgInfoBean config, CFGEntityList cfgEntityList, CFGEntity cfgEntity, int i10, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(config, "$config");
        kotlin.jvm.internal.f0.p(cfgEntityList, "$cfgEntityList");
        kotlin.jvm.internal.f0.p(cfgEntity, "$cfgEntity");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.T6(config, cfgEntityList, cfgEntity, i10);
    }

    public static final void l7(DialogFragment obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        obj.I5();
    }

    public static final void n7(DialogFragment dialogFragment) {
        dialogFragment.I5();
        PermissionUtils.C();
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void B2(@yt.k final CfgInfoBean config, @yt.k final CFGEntity cfgEntity) {
        kotlin.jvm.internal.f0.p(config, "config");
        kotlin.jvm.internal.f0.p(cfgEntity, "cfgEntity");
        E0();
        com.flydigi.userBehavior.a.a().b(X1(), "社区_下载配置_" + this.f13690t8);
        xi.z<String> standardPackageNameOrDefault = DBManager.getInstance().getStandardPackageNameOrDefault(config.getPkgname());
        final ArticleDetailFragment$downloadConfigSuccess$1 articleDetailFragment$downloadConfigSuccess$1 = new ik.l<String, CFGEntityList>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$downloadConfigSuccess$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CFGEntityList i(@yt.k String it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return e6.z.l0(it2, it2);
            }
        };
        xi.z zVarS0 = standardPackageNameOrDefault.A3(new dj.o() { // from class: com.flydigi.community.ui.article.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailFragment.I6(articleDetailFragment$downloadConfigSuccess$1, obj);
            }
        }).s0(o5.l.d());
        final ik.l<CFGEntityList, z1> lVar = new ik.l<CFGEntityList, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$downloadConfigSuccess$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(CFGEntityList it2) {
                ArticleDetailFragment articleDetailFragment = this.this$0;
                CfgInfoBean cfgInfoBean = config;
                kotlin.jvm.internal.f0.o(it2, "it");
                articleDetailFragment.G6(cfgInfoBean, it2, cfgEntity, config.getVersion(), 1);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(CFGEntityList cFGEntityList) {
                b(cFGEntityList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.h
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.J6(lVar, obj);
            }
        };
        final ArticleDetailFragment$downloadConfigSuccess$3 articleDetailFragment$downloadConfigSuccess$3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$downloadConfigSuccess$3
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13327n8.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.c0
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.K6(articleDetailFragment$downloadConfigSuccess$3, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void E(@yt.l Throwable th2) {
        String message;
        if (th2 == null || (message = th2.getMessage()) == null) {
            return;
        }
        com.flydigi.base.common.o.E(message);
    }

    public final void G6(CfgInfoBean cfgInfoBean, CFGEntityList cFGEntityList, CFGEntity cFGEntity, int i10, int i11) {
        if (!e6.z.z(i10 != 2 ? i10 != 3 ? cFGEntityList.getConfigsForWholeGamepad() : cFGEntityList.getConfigsForHalfGamepad() : cFGEntityList.getConfigsForKeyboard(), cFGEntity, cFGEntity.title)) {
            if (i11 == 1) {
                T6(cfgInfoBean, cFGEntityList, cFGEntity, i10);
                return;
            } else {
                j7(cfgInfoBean, cFGEntityList, cFGEntity, i10);
                return;
            }
        }
        String str = cFGEntity.title;
        kotlin.jvm.internal.f0.o(str, "cfgEntity.title");
        String strQ = new Regex("(\\(([^\\[\\]]*?)*\\))").q(str, "");
        cFGEntity.title = strQ;
        kotlin.jvm.internal.v0 v0Var = kotlin.jvm.internal.v0.f37964a;
        String str2 = String.format(Locale.US, "%s(%d)", Arrays.copyOf(new Object[]{strQ, Integer.valueOf(i11)}, 2));
        kotlin.jvm.internal.f0.o(str2, "format(locale, format, *args)");
        cFGEntity.title = str2;
        G6(cfgInfoBean, cFGEntityList, cFGEntity, i10, i11 + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        super.H3(context);
        if (context instanceof c) {
            this.f13688r8 = (c) context;
        }
    }

    public final void H6(CfgInfoBean cfgInfoBean) {
        x(c3(R.string.community_downloading), false);
        f.a aVar = this.f13687q8;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
            aVar = null;
        }
        aVar.F(cfgInfoBean);
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void K2(@yt.k Throwable throwable) {
        kotlin.jvm.internal.f0.p(throwable, "throwable");
        E0();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        this.f13687q8 = new ArticleDetailPresenter(this);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.f13690t8 = bundleT1.getInt("id");
            this.f13691u8 = bundleT1.getInt(DataConstant.COMMUNITY_MESSAGE_ID);
            String string = bundleT1.getString(DataConstant.COMMUNITY_ARTICLE_SOURCE);
            if (string == null) {
                string = "未知";
            } else {
                kotlin.jvm.internal.f0.o(string, "it.getString(DataConstan…Y_ARTICLE_SOURCE) ?: \"未知\"");
            }
            this.f13686p8 = string;
            this.f13692v8 = (ArticleBean) bundleT1.getParcelable(a.b.f31931p);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.community_fragment_article_detail;
    }

    public final void M6(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Window window;
        if (this.f13694x8 != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.f13694x8 = view;
        androidx.fragment.app.g gVarW1 = w1();
        View decorView = (gVarW1 == null || (window = gVarW1.getWindow()) == null) ? null : window.getDecorView();
        kotlin.jvm.internal.f0.n(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).addView(this.f13694x8);
        y5.i iVar = this.f13689s8;
        if (iVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar = null;
        }
        AgentWebView agentWebView = iVar.f56342e;
        kotlin.jvm.internal.f0.o(agentWebView, "viewBinding.areaContentWeb");
        o5.c.b(agentWebView, Boolean.FALSE, false, 2, null);
        this.f13695y8 = customViewCallback;
        androidx.fragment.app.g gVarW12 = w1();
        if (gVarW12 == null) {
            return;
        }
        gVarW12.setRequestedOrientation(0);
    }

    public final void N6() {
        Window window;
        if (this.f13694x8 == null) {
            return;
        }
        y5.i iVar = this.f13689s8;
        if (iVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar = null;
        }
        AgentWebView agentWebView = iVar.f56342e;
        kotlin.jvm.internal.f0.o(agentWebView, "viewBinding.areaContentWeb");
        o5.c.b(agentWebView, Boolean.TRUE, false, 2, null);
        View view = this.f13694x8;
        if (view != null) {
            o5.c.b(view, Boolean.FALSE, false, 2, null);
        }
        androidx.fragment.app.g gVarW1 = w1();
        View decorView = (gVarW1 == null || (window = gVarW1.getWindow()) == null) ? null : window.getDecorView();
        kotlin.jvm.internal.f0.n(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).removeView(this.f13694x8);
        WebChromeClient.CustomViewCallback customViewCallback = this.f13695y8;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.f13694x8 = null;
        androidx.fragment.app.g gVarW12 = w1();
        if (gVarW12 == null) {
            return;
        }
        gVarW12.setRequestedOrientation(1);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        super.R3();
        i9.b.f(this, DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
    }

    public final void R6() {
        CfgInfoBean cfgInfo;
        androidx.fragment.app.g gVarP4 = P4();
        kotlin.jvm.internal.f0.o(gVarP4, "requireActivity()");
        if (n5.c.c(gVarP4)) {
            ArticleBean articleBean = this.f13692v8;
            if (articleBean == null || (cfgInfo = articleBean.getCfgInfo()) == null) {
                return;
            }
            H6(cfgInfo);
            return;
        }
        androidx.activity.result.g<Intent> gVar = this.f13696z8;
        StoragePermissionRequestActivity.a aVar = StoragePermissionRequestActivity.f13377k0;
        Context contextR4 = R4();
        kotlin.jvm.internal.f0.o(contextR4, "requireContext()");
        gVar.b(StoragePermissionRequestActivity.a.b(aVar, contextR4, null, 2, null));
    }

    public final void T6(CfgInfoBean cfgInfoBean, final CFGEntityList cFGEntityList, final CFGEntity cFGEntity, final int i10) {
        xi.z<String> standardPackageNameOrDefault = DBManager.getInstance().getStandardPackageNameOrDefault(cfgInfoBean.getPkgname());
        final ik.l<String, z1> lVar = new ik.l<String, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfig$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String str) {
                int i11 = i10;
                List<CFGEntity> configList = i11 != 2 ? i11 != 3 ? cFGEntityList.getConfigsForWholeGamepad() : cFGEntityList.getConfigsForHalfGamepad() : cFGEntityList.getConfigsForKeyboard();
                kotlin.jvm.internal.f0.o(configList, "configList");
                ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(configList, 10));
                Iterator<T> it2 = configList.iterator();
                while (it2.hasNext()) {
                    ((CFGEntity) it2.next()).setInUse(false);
                    arrayList.add(z1.f38230a);
                }
                cFGEntity.setInUse(true);
                configList.add(cFGEntity);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        xi.z<String> zVarY1 = standardPackageNameOrDefault.Y1(new dj.g() { // from class: com.flydigi.community.ui.article.i
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.U6(lVar, obj);
            }
        });
        final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfig$2
            {
                super(1);
            }

            public final void b(String str) {
                e6.z.u0(cFGEntityList, str);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        xi.z<String> zVarY12 = zVarY1.Y1(new dj.g() { // from class: com.flydigi.community.ui.article.n
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.V6(lVar2, obj);
            }
        });
        final ik.l<String, z1> lVar3 = new ik.l<String, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfig$3
            {
                super(1);
            }

            public final void b(String it2) {
                ArticleDetailFragment articleDetailFragment = this.this$0;
                kotlin.jvm.internal.f0.o(it2, "it");
                articleDetailFragment.Y6(it2);
                this.this$0.E0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        dj.g<? super String> gVar = new dj.g() { // from class: com.flydigi.community.ui.article.o
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.W6(lVar3, obj);
            }
        };
        final ik.l<Throwable, z1> lVar4 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$saveConfig$4
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.E0();
                com.flydigi.base.common.o.E(this.this$0.c3(R.string.community_config_save_failed));
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13327n8.b(zVarY12.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.k
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.X6(lVar4, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void X() {
        y5.i iVar = this.f13689s8;
        c cVar = null;
        if (iVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar = null;
        }
        SuperButton superButton = iVar.f56346i;
        y5.i iVar2 = this.f13689s8;
        if (iVar2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar2 = null;
        }
        superButton.setIcon(h0.d.i(iVar2.f56346i.getContext(), R.drawable.ic_like));
        y5.i iVar3 = this.f13689s8;
        if (iVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar3 = null;
        }
        SuperButton superButton2 = iVar3.f56346i;
        y5.i iVar4 = this.f13689s8;
        if (iVar4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar4 = null;
        }
        superButton2.setIconColor(h0.d.f(iVar4.f56346i.getContext(), R.color.color_000000_a50));
        c cVar2 = this.f13688r8;
        if (cVar2 == null) {
            kotlin.jvm.internal.f0.S("interactionListener");
        } else {
            cVar = cVar2;
        }
        cVar.n1(false);
    }

    public final void Y6(final String str) {
        com.flydigi.base.common.o.E(c3(R.string.community_config_save_success));
        Context contextX1 = X1();
        int i10 = this.f13690t8;
        String str2 = this.f13686p8;
        y5.i iVar = null;
        if (str2 == null) {
            kotlin.jvm.internal.f0.S("source");
            str2 = null;
        }
        u9.h.i(contextX1, i10, 2, str2, "配置下载成功");
        i9.b.f(this, DataConstant.REMOTE_ACTION_SCAN_LOCAL_GAME);
        y5.i iVar2 = this.f13689s8;
        if (iVar2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar2 = null;
        }
        iVar2.f56345h.setText(c3(R.string.open));
        y5.i iVar3 = this.f13689s8;
        if (iVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            iVar = iVar3;
        }
        com.blankj.utilcode.util.o.r(iVar.f56345h, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArticleDetailFragment.Z6(str, this, view);
            }
        });
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        ArticleBean articleBean = this.f13692v8;
        if (articleBean != null) {
            c1(articleBean);
        }
        f.a aVar = this.f13687q8;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
            aVar = null;
        }
        aVar.a(this.f13690t8, this.f13691u8);
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void c0() {
        z1 z1Var;
        String description;
        String strC3;
        ArticleBean articleBean = this.f13692v8;
        if (articleBean != null) {
            androidx.fragment.app.g gVarP4 = P4();
            kotlin.jvm.internal.f0.o(gVarP4, "requireActivity()");
            String str = "https://bs.flydigi.com/topicDetail?id=" + articleBean.getId();
            if (com.blankj.utilcode.util.n0.x(articleBean.getTitle())) {
                description = articleBean.getTitle();
                kotlin.jvm.internal.f0.m(description);
            } else if (com.blankj.utilcode.util.n0.x(articleBean.getDescription())) {
                description = articleBean.getDescription();
                kotlin.jvm.internal.f0.m(description);
            } else {
                description = "";
            }
            if (com.blankj.utilcode.util.n0.x(articleBean.getTitle())) {
                strC3 = articleBean.getDescription();
                if (strC3 == null) {
                    strC3 = c3(R.string.community_share_article_desc);
                    kotlin.jvm.internal.f0.o(strC3, "getString(R.string.community_share_article_desc)");
                }
            } else {
                strC3 = c3(R.string.community_share_article_desc);
                kotlin.jvm.internal.f0.o(strC3, "{\n                    ge…e_desc)\n                }");
            }
            u9.f.b(gVarP4, str, description, strC3, R.mipmap.ic_launcher, new e(articleBean));
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            com.flydigi.base.common.o.E(c3(R.string.community_share_content_error));
        }
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void c1(@yt.k ArticleBean article) {
        CfgInfoBean cfgInfo;
        String strValueOf;
        kotlin.jvm.internal.f0.p(article, "article");
        if (s3()) {
            this.f13692v8 = article;
            y5.i iVar = this.f13689s8;
            if (iVar == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar = null;
            }
            iVar.f56339b.setVisibility(article.getCfgId() > 0 ? 0 : 8);
            y5.i iVar2 = this.f13689s8;
            if (iVar2 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar2 = null;
            }
            iVar2.f56353p.setVisibility(com.blankj.utilcode.util.n0.x(article.getTitle()) ? 0 : 8);
            y5.i iVar3 = this.f13689s8;
            if (iVar3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar3 = null;
            }
            iVar3.f56340c.setVisibility(com.blankj.utilcode.util.n0.x(article.getContent()) ? 0 : 8);
            y5.i iVar4 = this.f13689s8;
            if (iVar4 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar4 = null;
            }
            iVar4.f56348k.setVisibility(com.blankj.utilcode.util.n0.z(article.getTopics()) ? 0 : 8);
            y5.i iVar5 = this.f13689s8;
            if (iVar5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar5 = null;
            }
            iVar5.f56353p.setText(article.getTitle());
            if (article.getType() == 0) {
                String content = article.getContent();
                if (content != null) {
                    y5.i iVar6 = this.f13689s8;
                    if (iVar6 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar6 = null;
                    }
                    AgentWebView it2 = iVar6.f56342e;
                    kotlin.jvm.internal.f0.o(it2, "it");
                    o5.c.b(it2, Boolean.TRUE, false, 2, null);
                    WebSettings settings = it2.getSettings();
                    kotlin.jvm.internal.f0.o(settings, "it.settings");
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    settings.setJavaScriptEnabled(true);
                    it2.setWebViewClient(new f());
                    it2.setWebChromeClient(new g());
                    it2.addJavascriptInterface(new a(), l4.f.f39447b);
                    it2.loadDataWithBaseURL("", content, "text/html", "UTF-8", "");
                }
            } else {
                if ((article.getType() == 3 || article.getType() == 2) && (cfgInfo = article.getCfgInfo()) != null) {
                    y5.i iVar7 = this.f13689s8;
                    if (iVar7 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar7 = null;
                    }
                    iVar7.f56350m.setText(cfgInfo.getTitle());
                    y5.i iVar8 = this.f13689s8;
                    if (iVar8 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar8 = null;
                    }
                    TextView textView = iVar8.f56349l;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cfgInfo.getGameName());
                    sb2.append(zc.f.f58380j);
                    String gamepad = cfgInfo.getGamepad();
                    kotlin.jvm.internal.f0.o(gamepad, "it.gamepad");
                    sb2.append(com.flydigi.community.ui.article_list.c.a(gamepad));
                    sb2.append(zc.f.f58380j);
                    sb2.append(cfgInfo.getModelName());
                    textView.setText(sb2.toString());
                    y5.i iVar9 = this.f13689s8;
                    if (iVar9 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar9 = null;
                    }
                    SuperButton superButton = iVar9.f56345h;
                    y5.i iVar10 = this.f13689s8;
                    if (iVar10 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar10 = null;
                    }
                    Resources resources = iVar10.f56345h.getResources();
                    int i10 = R.string.community_config_download_with_count;
                    Object[] objArr = new Object[1];
                    if (cfgInfo.getDownnum() >= 10000) {
                        y5.i iVar11 = this.f13689s8;
                        if (iVar11 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            iVar11 = null;
                        }
                        strValueOf = iVar11.f56345h.getResources().getString(R.string.community_config_download_count_over_10000);
                    } else {
                        strValueOf = String.valueOf(cfgInfo.getDownnum());
                    }
                    objArr[0] = strValueOf;
                    superButton.setText(resources.getString(i10, objArr));
                }
                y5.i iVar12 = this.f13689s8;
                if (iVar12 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar12 = null;
                }
                TextView it3 = iVar12.f56341d;
                kotlin.jvm.internal.f0.o(it3, "it");
                o5.c.b(it3, Boolean.TRUE, false, 2, null);
                it3.setText(article.getContent());
            }
            final List<ArticleTopic> topics = article.getTopics();
            if (topics != null) {
                y5.i iVar13 = this.f13689s8;
                if (iVar13 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar13 = null;
                }
                iVar13.f56348k.setAdapter(new h(topics, this));
                y5.i iVar14 = this.f13689s8;
                if (iVar14 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar14 = null;
                }
                iVar14.f56348k.setOnItemClickListener(new TagFlowLayout.b() { // from class: com.flydigi.community.ui.article.b0
                    @Override // com.flydigi.base.widget.TagFlowLayout.b
                    public final void a(int i11, View view) {
                        ArticleDetailFragment.d7(topics, i11, view);
                    }
                });
            }
            y5.i iVar15 = this.f13689s8;
            if (iVar15 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar15 = null;
            }
            SuperButton superButton2 = iVar15.f56346i;
            y5.i iVar16 = this.f13689s8;
            if (iVar16 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar16 = null;
            }
            superButton2.setIcon(h0.d.i(iVar16.f56346i.getContext(), article.isLiked() ? R.drawable.community_ic_liked : R.drawable.ic_like));
            y5.i iVar17 = this.f13689s8;
            if (iVar17 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar17 = null;
            }
            SuperButton superButton3 = iVar17.f56346i;
            y5.i iVar18 = this.f13689s8;
            if (iVar18 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar18 = null;
            }
            superButton3.setIconColor(h0.d.f(iVar18.f56346i.getContext(), article.isLiked() ? R.color.colorAccentRed : R.color.color_000000_a50));
            c cVar = this.f13688r8;
            if (cVar == null) {
                kotlin.jvm.internal.f0.S("interactionListener");
                cVar = null;
            }
            cVar.J2(article);
            y5.i iVar19 = this.f13689s8;
            if (iVar19 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar19 = null;
            }
            iVar19.f56352o.setText(f1.Q0(article.getCreateTime() * ((long) 1000), "yyyy-MM-dd"));
            e7(article.getVideoFile(), article.getVideoImg(), article.getVideoIndex(), article.getType() != 0 ? article.getImage() : null);
        }
    }

    public final void e7(String str, String str2, int i10, List<? extends ContentAddBean> list) {
        this.f13693w8.clear();
        if (com.blankj.utilcode.util.n0.x(str)) {
            ContentAddBean contentAddBean = new ContentAddBean();
            contentAddBean.url = str;
            contentAddBean.setVideo(true);
            contentAddBean.videoCover = str2;
            this.f13693w8.add(0, contentAddBean);
        }
        if (list != null) {
            this.f13693w8.addAll(list);
        }
        y5.i iVar = this.f13689s8;
        y5.i iVar2 = null;
        if (iVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar = null;
        }
        if (iVar.f56354q.getAdapter() == null) {
            y5.i iVar3 = this.f13689s8;
            if (iVar3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar3 = null;
            }
            iVar3.f56354q.setAdapter(new i());
            if (this.f13693w8.size() > 0) {
                y5.i iVar4 = this.f13689s8;
                if (iVar4 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar4 = null;
                }
                iVar4.f56354q.setOffscreenPageLimit(this.f13693w8.size());
            }
        }
        if (!com.blankj.utilcode.util.n0.z(this.f13693w8)) {
            y5.i iVar5 = this.f13689s8;
            if (iVar5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                iVar5 = null;
            }
            RelativeLayout relativeLayout = iVar5.f56344g;
            kotlin.jvm.internal.f0.o(relativeLayout, "viewBinding.areaMedia");
            o5.c.b(relativeLayout, Boolean.FALSE, false, 2, null);
            return;
        }
        y5.i iVar6 = this.f13689s8;
        if (iVar6 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar6 = null;
        }
        RelativeLayout relativeLayout2 = iVar6.f56344g;
        kotlin.jvm.internal.f0.o(relativeLayout2, "viewBinding.areaMedia");
        o5.c.b(relativeLayout2, Boolean.TRUE, false, 2, null);
        if (this.f13693w8.get(0).isVideo()) {
            y5.i iVar7 = this.f13689s8;
            if (iVar7 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                iVar2 = iVar7;
            }
            iVar2.f56354q.getLayoutParams().height = (com.blankj.utilcode.util.x0.g() * 9) / 16;
            return;
        }
        xi.z zVarM3 = xi.z.m3(this.f13693w8);
        final ik.l<ArrayList<ContentAddBean>, File> lVar = new ik.l<ArrayList<ContentAddBean>, File>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$showMedia$3
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@yt.k ArrayList<ContentAddBean> it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                y5.i iVar8 = this.this$0.f13689s8;
                if (iVar8 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar8 = null;
                }
                return com.bumptech.glide.b.F(iVar8.f56354q).E().t(it2.get(0).url).J1(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
            }
        };
        xi.z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.community.ui.article.t
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailFragment.f7(lVar, obj);
            }
        });
        final ArticleDetailFragment$showMedia$4 articleDetailFragment$showMedia$4 = new ik.l<File, Bitmap>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$showMedia$4
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Bitmap i(@yt.k File it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return ImageUtils.S(it2);
            }
        };
        xi.z zVarS0 = zVarA3.A3(new dj.o() { // from class: com.flydigi.community.ui.article.q
            @Override // dj.o
            public final Object apply(Object obj) {
                return ArticleDetailFragment.g7(articleDetailFragment$showMedia$4, obj);
            }
        }).s0(o5.l.d());
        final ik.l<Bitmap, z1> lVar2 = new ik.l<Bitmap, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$showMedia$5
            {
                super(1);
            }

            public final void b(Bitmap bitmap) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != 0) {
                    int iG = (height * com.blankj.utilcode.util.x0.g()) / width;
                    Resources resourcesV2 = this.this$0.V2();
                    int i11 = R.dimen.qb_px_520;
                    if (iG >= resourcesV2.getDimensionPixelSize(i11)) {
                        iG = this.this$0.V2().getDimensionPixelSize(i11);
                    }
                    y5.i iVar8 = this.this$0.f13689s8;
                    if (iVar8 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        iVar8 = null;
                    }
                    iVar8.f56354q.getLayoutParams().height = iG;
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Bitmap bitmap) {
                b(bitmap);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.l
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.h7(lVar2, obj);
            }
        };
        final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.ArticleDetailFragment$showMedia$6
            {
                super(1);
            }

            public final void b(Throwable th2) {
                y5.i iVar8 = this.this$0.f13689s8;
                if (iVar8 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    iVar8 = null;
                }
                iVar8.f56354q.getLayoutParams().height = (com.blankj.utilcode.util.x0.g() * 9) / 16;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13327n8.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.m
            @Override // dj.g
            public final void accept(Object obj) {
                ArticleDetailFragment.i7(lVar3, obj);
            }
        }));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        y5.i iVarA = y5.i.a(view);
        kotlin.jvm.internal.f0.o(iVarA, "bind(view)");
        this.f13689s8 = iVarA;
        y5.i iVar = null;
        if (iVarA == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVarA = null;
        }
        iVarA.f56354q.n(new d());
        y5.i iVar2 = this.f13689s8;
        if (iVar2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar2 = null;
        }
        com.blankj.utilcode.util.o.r(iVar2.f56346i, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArticleDetailFragment.O6(this.f13762a, view2);
            }
        });
        y5.i iVar3 = this.f13689s8;
        if (iVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar3 = null;
        }
        com.blankj.utilcode.util.o.r(iVar3.f56347j, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArticleDetailFragment.P6(this.f13777a, view2);
            }
        });
        y5.i iVar4 = this.f13689s8;
        if (iVar4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            iVar = iVar4;
        }
        com.blankj.utilcode.util.o.r(iVar.f56345h, new View.OnClickListener() { // from class: com.flydigi.community.ui.article.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArticleDetailFragment.Q6(this.f13735a, view2);
            }
        });
    }

    public final void j7(final CfgInfoBean cfgInfoBean, final CFGEntityList cFGEntityList, final CFGEntity cFGEntity, final int i10) {
        E0();
        FZDialog.a aVarT = new FZDialog.a().t(c3(R.string.community_exist_smae_name));
        kotlin.jvm.internal.v0 v0Var = kotlin.jvm.internal.v0.f37964a;
        String strC3 = c3(R.string.community_save_notice_);
        kotlin.jvm.internal.f0.o(strC3, "getString(R.string.community_save_notice_)");
        String str = String.format(strC3, Arrays.copyOf(new Object[]{cFGEntity.title}, 1));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        aVarT.j(str).g(c3(R.string.download)).d(c3(R.string.cancel)).b(Boolean.TRUE).f(new FZDialog.c() { // from class: com.flydigi.community.ui.article.y
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ArticleDetailFragment.k7(this.f13784a, cfgInfoBean, cFGEntityList, cFGEntity, i10, dialogFragment);
            }
        }).c(new FZDialog.c() { // from class: com.flydigi.community.ui.article.a0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ArticleDetailFragment.l7(dialogFragment);
            }
        }).a().Z5(U1(), "confirm_dialog");
    }

    public final void m7() {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.community_storage_permission_must_granted_for_download_config)).q(c3(R.string.community_to_enable)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.community.ui.article.z
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                ArticleDetailFragment.n7(dialogFragment);
            }
        }).u(U1(), "storage_permission_denied");
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void r2() {
        f.a aVar = this.f13687q8;
        if (aVar == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
            aVar = null;
        }
        aVar.b0(this.f13690t8);
    }

    @Override // com.flydigi.community.ui.article.f.b
    public void z1() {
        y5.i iVar = this.f13689s8;
        c cVar = null;
        if (iVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar = null;
        }
        SuperButton superButton = iVar.f56346i;
        y5.i iVar2 = this.f13689s8;
        if (iVar2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar2 = null;
        }
        superButton.setIcon(h0.d.i(iVar2.f56346i.getContext(), R.drawable.community_ic_liked));
        y5.i iVar3 = this.f13689s8;
        if (iVar3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar3 = null;
        }
        SuperButton superButton2 = iVar3.f56346i;
        y5.i iVar4 = this.f13689s8;
        if (iVar4 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            iVar4 = null;
        }
        superButton2.setIconColor(h0.d.f(iVar4.f56346i.getContext(), R.color.colorAccentRed));
        c cVar2 = this.f13688r8;
        if (cVar2 == null) {
            kotlin.jvm.internal.f0.S("interactionListener");
        } else {
            cVar = cVar2;
        }
        cVar.n1(true);
    }
}
