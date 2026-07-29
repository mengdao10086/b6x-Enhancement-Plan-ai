package com.flydigi.community.ui.post;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.community.R;
import com.flydigi.community.ui.post.s;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.ArticleTopic;
import com.flydigi.data.bean.community.TopicBean;
import com.yqritc.recyclerviewflexibledivider.b;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.Item;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z1;
import org.json.JSONException;
import org.json.JSONObject;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nPostActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostActivity.kt\ncom/flydigi/community/ui/post/PostActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,659:1\n1#2:660\n1549#3:661\n1620#3,3:662\n1549#3:665\n1620#3,3:666\n766#3:669\n857#3,2:670\n1855#3,2:672\n26#4:674\n*S KotlinDebug\n*F\n+ 1 PostActivity.kt\ncom/flydigi/community/ui/post/PostActivity\n*L\n233#1:661\n233#1:662,3\n358#1:665\n358#1:666,3\n454#1:669\n454#1:670,2\n459#1:672,2\n578#1:674\n*E\n"})
@Route(extras = 10000000, path = a.b.f31927l)
public final class PostActivity extends com.flydigi.base.common.p implements s.b {

    @yt.k
    public static final a Q7 = new a(null);
    public static final int R7 = 9;
    public static final int S7 = 1;
    public static final int T7 = 4000;
    public s.a G7;

    @hk.e
    @yt.l
    @Autowired(name = a.b.f31931p)
    public ArticleBean H7;

    @hk.e
    @yt.l
    @Autowired(name = a.b.f31929n)
    public TopicBean I7;

    @hk.e
    @yt.l
    @Autowired(name = "key_config")
    public ConfigBean J7;
    public y5.e K2;

    @hk.e
    @Autowired(name = a.b.f31933r)
    public int K7;
    public int O7;
    public boolean P7;

    @yt.k
    public final eu.davidea.flexibleadapter.b<ei.h<?>> E7 = new eu.davidea.flexibleadapter.b<>(null);

    @yt.k
    public final eu.davidea.flexibleadapter.b<TopicItem> F7 = new eu.davidea.flexibleadapter.b<>(null);

    @yt.k
    public ArrayList<ContentAddBean> L7 = new ArrayList<>(9);

    @yt.k
    public final com.flydigi.community.ui.post.a M7 = new com.flydigi.community.ui.post.a();
    public int N7 = -1;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public static final class b implements b.z {

        public static final class a implements PermissionUtils.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PostActivity f13993a;

            public a(PostActivity postActivity) {
                this.f13993a = postActivity;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.e
            public void a() {
                this.f13993a.H0();
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.e
            public void b() {
                PostActivity postActivity = this.f13993a;
                com.flydigi.base.common.o.E(postActivity.getString(R.string.community_error_no_permission_to_read_storage, new Object[]{postActivity.getString(R.string.app_name)}));
            }
        }

        public b() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            ei.h hVarG2;
            kotlin.jvm.internal.f0.p(view, "view");
            if (i10 != -1 && (hVarG2 = PostActivity.this.E7.g2(i10)) != null) {
                PostActivity postActivity = PostActivity.this;
                if (hVarG2 instanceof com.flydigi.community.ui.post.a) {
                    PermissionUtils.E("android.permission.READ_EXTERNAL_STORAGE").r(new a(postActivity)).I();
                    return true;
                }
                if (hVarG2 instanceof MediaItem) {
                    if (view.getId() == R.id.btn_remove) {
                        MediaItem mediaItem = (MediaItem) hVarG2;
                        if (mediaItem.z().isVideo()) {
                            postActivity.N7 = -1;
                        }
                        postActivity.L7.remove(mediaItem.z());
                        postActivity.E7.E3(i10);
                        if (postActivity.E7.l2() == 9) {
                            postActivity.E7.A3();
                        } else if (postActivity.E7.q2().isEmpty()) {
                            postActivity.E7.Q0(postActivity.M7);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static final class c implements b.z {
        public c() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            TopicItem topicItem;
            kotlin.jvm.internal.f0.p(view, "view");
            if (i10 == -1 || (topicItem = (TopicItem) PostActivity.this.F7.g2(i10)) == null) {
                return false;
            }
            PostActivity postActivity = PostActivity.this;
            postActivity.I7 = topicItem.z();
            postActivity.Q1(true);
            return true;
        }
    }

    public static final class d extends p5.t {
        public d() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(@yt.l Editable editable) {
            super.afterTextChanged(editable);
            PostActivity.this.P7 = true;
        }
    }

    public static final class e extends sh.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set<MimeType> f13996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PostActivity f13997e;

        public e(Set<MimeType> set, PostActivity postActivity) {
            this.f13996d = set;
            this.f13997e = postActivity;
        }

        @Override // sh.a
        @yt.k
        public Set<MimeType> a() {
            Set<MimeType> mimeTypes = this.f13996d;
            kotlin.jvm.internal.f0.o(mimeTypes, "mimeTypes");
            return mimeTypes;
        }

        @Override // sh.a
        @yt.l
        public th.b b(@yt.k Context context, @yt.k Item item) {
            kotlin.jvm.internal.f0.p(context, "context");
            kotlin.jvm.internal.f0.p(item, "item");
            if (!MimeType.isVideo(item.f25098b)) {
                if (!MimeType.isImage(item.f25098b) || item.f25100d < 15728640) {
                    return null;
                }
                return new th.b(this.f13997e.getString(R.string.community_share_config_image_length));
            }
            if (item.f25101e > 300000) {
                return new th.b(this.f13997e.getString(R.string.community_publish_article_video_too_long, new Object[]{300}));
            }
            if (item.f25100d >= 524288000) {
                return new th.b(this.f13997e.getString(R.string.community_publish_article_video_file_too_big));
            }
            return null;
        }
    }

    public static final void K4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void L4(PostActivity this$0, View view) {
        z1 z1Var;
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        view.setEnabled(false);
        if (!this$0.Q0()) {
            view.setEnabled(true);
            return;
        }
        ConfigBean configBean = this$0.J7;
        if (configBean == null || configBean.getCfgEntity() == null) {
            z1Var = null;
        } else {
            this$0.a5();
            z1Var = z1.f38230a;
        }
        if (z1Var == null) {
            this$0.N1();
        }
    }

    public static final void N4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.J7 = null;
        this$0.J1(true);
    }

    public static final void O4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        h3.a.j().d(a.d.f31958n).withBoolean(a.d.f31963s, true).navigation(this$0, 8195);
    }

    public static final void P4(PostActivity this_run, View view) {
        kotlin.jvm.internal.f0.p(this_run, "$this_run");
        h3.a.j().d(a.d.f31958n).withBoolean(a.d.f31963s, true).navigation(this_run, 8195);
    }

    public static final void Q4(PostActivity this_run, View view) {
        kotlin.jvm.internal.f0.p(this_run, "$this_run");
        h3.a.j().d(a.d.f31958n).withBoolean(a.d.f31963s, true).navigation(this_run, 8195);
    }

    public static final void S4(DialogFragment obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        obj.I5();
    }

    public static final void T4(PostActivity this$0, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.finish();
    }

    public static final void V4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.I7 = null;
        this$0.Q1(true);
    }

    public static final void W4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.I7 = null;
        this$0.Q1(true);
    }

    public static final void X4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        h3.a.j().d(a.b.f31926k).withBoolean(a.b.f31934s, true).navigation(this$0, 8193);
    }

    public static final void Y4(PostActivity this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        h3.a.j().d(a.b.f31926k).withBoolean(a.b.f31934s, true).navigation(this$0, 8193);
    }

    public static final void Z4(PostActivity this_run, View view) {
        kotlin.jvm.internal.f0.p(this_run, "$this_run");
        h3.a.j().d(a.b.f31926k).withBoolean(a.b.f31934s, true).navigation(this_run, 8193);
    }

    public static final void c5(PostActivity this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.b5();
    }

    public static final void d5(final PostActivity this$0, boolean z10, okhttp3.d0 d0Var, Exception exc) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (!z10) {
            this$0.O7 = 0;
            this$0.c4().e(new Runnable() { // from class: com.flydigi.community.ui.post.i
                @Override // java.lang.Runnable
                public final void run() {
                    PostActivity.f5(this.f14018a);
                }
            });
            return;
        }
        try {
            okhttp3.e0 e0VarL = d0Var.L();
            JSONObject jSONObject = new JSONObject(e0VarL != null ? e0VarL.string() : null);
            this$0.L7.get(this$0.O7).url = DataConstant.UPYUN_COMMUNITY_URI + jSONObject.optString("url");
            this$0.L7.get(this$0.O7).path = null;
            this$0.c4().e(new Runnable() { // from class: com.flydigi.community.ui.post.h
                @Override // java.lang.Runnable
                public final void run() {
                    PostActivity.e5(this.f14017a);
                }
            });
        } catch (JSONException e10) {
            this$0.I4().f56308i.setEnabled(true);
            e10.printStackTrace();
        }
    }

    public static final void e5(PostActivity this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.b5();
    }

    public static final void f5(PostActivity this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.E0();
        this$0.I4().f56308i.setEnabled(true);
        if (NetworkUtils.K()) {
            com.flydigi.base.common.o.E(this$0.getString(R.string.community_upload_failed_retry));
        } else {
            com.flydigi.base.common.o.E(this$0.getString(R.string.net_state_error));
        }
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void D(@yt.k ArticleBean article) {
        kotlin.jvm.internal.f0.p(article, "article");
        com.flydigi.userBehavior.a.a().b(this, "社区_发帖成功_" + article.getId());
        com.flydigi.base.common.o.E(getString(R.string.community_add_message_success));
        setResult(-1);
        finish();
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void F0() {
        E0();
        I4().f56308i.setEnabled(true);
        com.flydigi.base.common.o.E(getString(R.string.api_error_notice));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G4() {
        /*
            r9 = this;
            java.util.ArrayList<com.flydigi.data.bean.ContentAddBean> r0 = r9.L7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r2 = r0.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            r5 = r2
            com.flydigi.data.bean.ContentAddBean r5 = (com.flydigi.data.bean.ContentAddBean) r5
            boolean r6 = r5.video
            if (r6 != 0) goto L38
            java.lang.String r6 = r5.path
            boolean r6 = com.blankj.utilcode.util.b0.h0(r6)
            if (r6 == 0) goto L38
            java.lang.String r5 = r5.path
            java.lang.String r6 = "it.path"
            kotlin.jvm.internal.f0.o(r5, r6)
            r6 = 2
            r7 = 0
            java.lang.String r8 = "gif"
            boolean r5 = kotlin.text.u.K1(r5, r8, r4, r6, r7)
            if (r5 != 0) goto L38
            goto L39
        L38:
            r3 = 0
        L39:
            if (r3 == 0) goto Lb
            r1.add(r2)
            goto Lb
        L3f:
            java.util.Iterator r0 = r1.iterator()
        L43:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L88
            java.lang.Object r1 = r0.next()
            com.flydigi.data.bean.ContentAddBean r1 = (com.flydigi.data.bean.ContentAddBean) r1
            top.zibin.luban.e$b r2 = top.zibin.luban.e.n(r9)
            java.lang.String r5 = r1.path
            top.zibin.luban.e$b r2 = r2.p(r5)
            r5 = 1024(0x400, float:1.435E-42)
            top.zibin.luban.e$b r2 = r2.l(r5)
            java.util.List r2 = r2.k()
            java.lang.Object r2 = r2.get(r4)
            java.io.File r2 = (java.io.File) r2
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options
            r5.<init>()
            r5.inJustDecodeBounds = r3
            java.lang.String r6 = r2.getAbsolutePath()
            android.graphics.BitmapFactory.decodeFile(r6, r5)
            int r6 = r5.outWidth
            r1.width = r6
            int r6 = r5.outHeight
            r1.height = r6
            java.lang.String r2 = r2.getAbsolutePath()
            r1.path = r2
            r5.inJustDecodeBounds = r4
            goto L43
        L88:
            kotlin.z1 r0 = kotlin.z1.f38230a
            r9.E0()
            r9.b5()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.community.ui.post.PostActivity.G4():void");
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void H0() {
        int iL2 = this.E7.l2();
        int i10 = 9 - iL2;
        int i11 = 0;
        if (iL2 >= 0) {
            int i12 = 0;
            while (true) {
                ei.h hVarG2 = this.E7.g2(i11);
                if (hVarG2 != null && (hVarG2 instanceof MediaItem) && ((MediaItem) hVarG2).z().isVideo()) {
                    i12++;
                }
                if (i11 == iL2) {
                    break;
                } else {
                    i11++;
                }
            }
            i11 = i12;
        }
        Set<MimeType> setOfImage = i11 >= 1 ? MimeType.ofImage() : MimeType.ofAll();
        ph.b.c(this).a(setOfImage).e(true).j(i10).g(getResources().getDimensionPixelSize(R.dimen.grid_expected_size)).a(new e(setOfImage, this)).m(-1).t(0.85f).h(new w5.b()).f(8194);
    }

    public final void H4() {
        CfgInfoBean cfgInfo;
        ArticleTopic articleTopic;
        ArticleBean articleBean = this.H7;
        if (articleBean != null) {
            List<ArticleTopic> topics = articleBean.getTopics();
            this.I7 = (topics == null || (articleTopic = (ArticleTopic) CollectionsKt___CollectionsKt.B2(topics)) == null) ? null : articleTopic.getTopic();
            if (articleBean.getCfgId() > 0 && (cfgInfo = articleBean.getCfgInfo()) != null) {
                ConfigBean configBean = new ConfigBean();
                configBean.setId(cfgInfo.getId());
                configBean.setTitle(cfgInfo.getTitle());
                this.J7 = configBean;
            }
            List<ContentAddBean> image = articleBean.getImage();
            if (image != null) {
                this.L7.addAll(image);
            }
            if (articleBean.getVideoFile() != null && n0.x(articleBean.getVideoFile())) {
                ContentAddBean contentAddBean = new ContentAddBean();
                contentAddBean.videoCover = articleBean.getVideoImg();
                contentAddBean.url = articleBean.getVideoFile();
                contentAddBean.setVideo(true);
                this.L7.add(articleBean.getVideoIndex() >= 0 ? articleBean.getVideoIndex() : 0, contentAddBean);
            }
            I4().f56309j.setText(articleBean.getContent());
        }
        Q1(false);
        J1(false);
        U4();
    }

    @yt.k
    public final y5.e I4() {
        y5.e eVar = this.K2;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.f0.S("viewBinding");
        return null;
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void J1(boolean z10) {
        z1 z1Var = null;
        I4().f56313n.setIcon(null);
        ConfigBean configBean = this.J7;
        if (configBean != null) {
            I4().f56302c.setBackgroundResource(R.color.colorPrimaryA08);
            I4().f56313n.setText(configBean.getTitle());
            I4().f56313n.setTextColor(h0.d.f(this, R.color.colorPrimary));
            if (z10) {
                Drawable drawableI = h0.d.i(this, R.drawable.ic_close);
                if (drawableI != null) {
                    I4().f56313n.setIcon(drawableI);
                }
                com.blankj.utilcode.util.o.r(I4().f56313n, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.N4(this.f14023a, view);
                    }
                });
            } else {
                SuperButton superButton = I4().f56305f;
                kotlin.jvm.internal.f0.o(superButton, "viewBinding.btnChooseConfig");
                o5.c.b(superButton, Boolean.FALSE, false, 2, null);
                com.blankj.utilcode.util.o.r(I4().f56313n, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.O4(this.f14020a, view);
                    }
                });
            }
            I4().f56310k.setImageResource(R.drawable.community_icon_config);
            z1Var = z1.f38230a;
        }
        if (z1Var == null) {
            com.blankj.utilcode.util.o.r(I4().f56301b, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostActivity.P4(this.f14006a, view);
                }
            });
            com.blankj.utilcode.util.o.r(I4().f56313n, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostActivity.Q4(this.f14022a, view);
                }
            });
            I4().f56302c.setBackgroundResource(R.color.transparent);
            I4().f56310k.setImageResource(R.drawable.community_icon_upload);
            I4().f56313n.setText(getString(R.string.community_choose_config));
            I4().f56313n.setTextColor(h0.d.f(this, R.color.color_000000_a90));
        }
    }

    public final void J4() {
        this.E7.P0(new b());
        I4().f56312m.setAdapter(this.E7);
        I4().f56312m.n(new b.a(this).l(R.color.color_white).v(R.dimen.qb_px_2).y());
        this.E7.Q0(this.M7);
        this.F7.P0(new c());
        com.blankj.utilcode.util.o.r(I4().f56307h, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostActivity.K4(this.f14008a, view);
            }
        });
        com.blankj.utilcode.util.o.r(I4().f56308i, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostActivity.L4(this.f14021a, view);
            }
        });
        I4().f56309j.addTextChangedListener(new d());
    }

    public final void M4(@yt.k y5.e eVar) {
        kotlin.jvm.internal.f0.p(eVar, "<set-?>");
        this.K2 = eVar;
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void N1() {
        if (!this.L7.isEmpty()) {
            G4();
        } else {
            h1();
        }
    }

    @Override // com.flydigi.community.ui.post.s.b
    public boolean Q0() {
        Editable text = I4().f56309j.getText();
        kotlin.jvm.internal.f0.o(text, "viewBinding.etContent.text");
        String string = StringsKt__StringsKt.F5(text).toString();
        Charset charsetForName = Charset.forName("gb2312");
        kotlin.jvm.internal.f0.o(charsetForName, "forName(charsetName)");
        byte[] bytes = string.getBytes(charsetForName);
        kotlin.jvm.internal.f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        if (bytes.length > 4000) {
            com.flydigi.base.common.o.E(getString(R.string.community_publish_article_content_too_long, new Object[]{2000}));
            return false;
        }
        Editable text2 = I4().f56309j.getText();
        kotlin.jvm.internal.f0.o(text2, "viewBinding.etContent.text");
        if (!n0.m(StringsKt__StringsKt.F5(text2))) {
            return true;
        }
        com.flydigi.base.common.o.E(getString(R.string.community_publish_article_empty_content_and_image));
        return false;
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void Q1(boolean z10) {
        z1 z1Var;
        I4().f56314o.setIcon(null);
        TopicBean topicBean = this.I7;
        if (topicBean != null) {
            I4().f56304e.setBackgroundResource(R.color.colorPrimaryA08);
            I4().f56314o.setText(topicBean.getTitle());
            SuperButton superButton = I4().f56314o;
            int i10 = R.color.colorPrimary;
            superButton.setTextColor(h0.d.f(this, i10));
            if (z10) {
                Drawable drawableI = h0.d.i(this, R.drawable.ic_close);
                if (drawableI != null) {
                    I4().f56314o.setIcon(drawableI);
                }
                com.blankj.utilcode.util.o.r(I4().f56304e, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.V4(this.f14025a, view);
                    }
                });
                com.blankj.utilcode.util.o.r(I4().f56314o, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.W4(this.f14019a, view);
                    }
                });
            } else {
                RecyclerView recyclerView = I4().f56311l;
                kotlin.jvm.internal.f0.o(recyclerView, "viewBinding.rvHotTag");
                Boolean bool = Boolean.FALSE;
                o5.c.b(recyclerView, bool, false, 2, null);
                SuperButton superButton2 = I4().f56306g;
                kotlin.jvm.internal.f0.o(superButton2, "viewBinding.btnChooseTopic");
                o5.c.b(superButton2, bool, false, 2, null);
                com.blankj.utilcode.util.o.r(I4().f56304e, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.X4(this.f14027a, view);
                    }
                });
                com.blankj.utilcode.util.o.r(I4().f56314o, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PostActivity.Y4(this.f14026a, view);
                    }
                });
            }
            I4().f56315p.setBackgroundResource(i10);
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            RecyclerView recyclerView2 = I4().f56311l;
            kotlin.jvm.internal.f0.o(recyclerView2, "viewBinding.rvHotTag");
            o5.c.b(recyclerView2, Boolean.TRUE, false, 2, null);
            if (I4().f56311l.getAdapter() == null) {
                I4().f56311l.setAdapter(this.F7);
                I4().f56311l.n(new b.a(this).l(R.color.color_white).v(R.dimen.qb_px_8).y());
            }
            I4().f56304e.setBackgroundResource(R.color.transparent);
            I4().f56314o.setText(getString(R.string.community_choose_topic));
            SuperButton superButton3 = I4().f56314o;
            int i11 = R.color.color_000000_a90;
            superButton3.setTextColor(h0.d.f(this, i11));
            I4().f56315p.setBackgroundResource(i11);
            com.blankj.utilcode.util.o.r(I4().f56303d, new View.OnClickListener() { // from class: com.flydigi.community.ui.post.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostActivity.Z4(this.f14024a, view);
                }
            });
        }
    }

    public final void R4() {
        FZDialog.a aVar = new FZDialog.a();
        int i10 = R.string.community_exit_confirm_question;
        aVar.t(getString(i10)).j(getString(R.string.community_sharing_confirm_content)).d(getString(R.string.community_share_config_continue_edit)).g(getString(i10)).h(R.color.color_notice).e(R.color.colorPrimary).b(Boolean.FALSE).c(new FZDialog.c() { // from class: com.flydigi.community.ui.post.e
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                PostActivity.S4(dialogFragment);
            }
        }).f(new FZDialog.c() { // from class: com.flydigi.community.ui.post.d
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                PostActivity.T4(this.f14010a, dialogFragment);
            }
        }).a().Z5(n3(), "exit_confirm");
    }

    public final void U4() {
        ArrayList<ContentAddBean> arrayList = this.L7;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new MediaItem((ContentAddBean) it2.next()));
        }
        this.E7.I4(CollectionsKt___CollectionsKt.Q5(arrayList2));
        if (this.E7.l2() == 9) {
            this.E7.A3();
        } else if (this.E7.q2().isEmpty()) {
            this.E7.Q0(this.M7);
        }
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void a1(@yt.k ArrayList<TopicBean> topics) {
        kotlin.jvm.internal.f0.p(topics, "topics");
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(topics, 10));
        Iterator<T> it2 = topics.iterator();
        while (it2.hasNext()) {
            arrayList.add(new TopicItem((TopicBean) it2.next()));
        }
        this.F7.I4(CollectionsKt___CollectionsKt.Q5(arrayList));
    }

    public final void a5() {
        x(getString(R.string.community_uploading_config_no_exit), false);
        ConfigBean configBean = this.J7;
        z1 z1Var = null;
        s.a aVar = null;
        if (configBean != null) {
            s.a aVar2 = this.G7;
            if (aVar2 == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
            } else {
                aVar = aVar2;
            }
            aVar.y(configBean);
            z1Var = z1.f38230a;
        }
        if (z1Var == null) {
            N1();
        }
    }

    public final void b5() {
        if (this.O7 >= this.L7.size()) {
            E0();
            h1();
            return;
        }
        v0 v0Var = v0.f37964a;
        String string = getString(R.string.community_uploading_content_no_exit_);
        kotlin.jvm.internal.f0.o(string, "getString(R.string.commu…loading_content_no_exit_)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.O7 + 1), Integer.valueOf(this.L7.size())}, 2));
        kotlin.jvm.internal.f0.o(str, "format(format, *args)");
        x(str, false);
        if (!n0.x(this.L7.get(this.O7).url)) {
            u9.k.e(com.blankj.utilcode.util.b0.C(this.L7.get(this.O7).path), DataConstant.UPYUN_COMMUNITY_BUCKET, new gh.b() { // from class: com.flydigi.community.ui.post.f
                @Override // gh.b
                public final void a(boolean z10, okhttp3.d0 d0Var, Exception exc) {
                    PostActivity.d5(this.f14014a, z10, d0Var, exc);
                }
            }, null);
        } else {
            this.O7++;
            c4().e(new Runnable() { // from class: com.flydigi.community.ui.post.g
                @Override // java.lang.Runnable
                public final void run() {
                    PostActivity.c5(this.f14016a);
                }
            });
        }
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.community_activity_post;
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void h1() {
        z1 z1Var;
        s.a aVar;
        ArticleBean articleBean = this.H7;
        s.a aVar2 = null;
        if (articleBean != null) {
            s.a aVar3 = this.G7;
            if (aVar3 == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
                aVar = null;
            } else {
                aVar = aVar3;
            }
            int id2 = articleBean.getId();
            Editable text = I4().f56309j.getText();
            kotlin.jvm.internal.f0.o(text, "viewBinding.etContent.text");
            aVar.v(id2, StringsKt__StringsKt.F5(text).toString(), this.L7, this.I7, this.J7);
            z1Var = z1.f38230a;
        } else {
            z1Var = null;
        }
        if (z1Var == null) {
            s.a aVar4 = this.G7;
            if (aVar4 == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
            } else {
                aVar2 = aVar4;
            }
            Editable text2 = I4().f56309j.getText();
            kotlin.jvm.internal.f0.o(text2, "viewBinding.etContent.text");
            aVar2.a0(StringsKt__StringsKt.F5(text2).toString(), this.L7, this.I7, this.J7);
        }
    }

    @Override // com.flydigi.community.ui.post.s.b
    public void h2(@yt.k Throwable throwable) {
        kotlin.jvm.internal.f0.p(throwable, "throwable");
        I4().f56308i.setEnabled(true);
        String message = throwable.getMessage();
        if (message != null) {
            com.flydigi.base.common.o.E(message);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r10, int r11, @yt.l android.content.Intent r12) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.community.ui.post.PostActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.P7) {
            R4();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        this.G7 = new PostPresenter(this);
        J4();
        H4();
        com.flydigi.userBehavior.a.a().b(this, "社区_发帖");
    }

    @Override // com.flydigi.base.common.c, androidx.appcompat.app.f, android.app.Activity
    public void onPostCreate(@yt.l Bundle bundle) {
        super.onPostCreate(bundle);
        s.a aVar = null;
        if (this.I7 != null) {
            ArticleBean articleBean = this.H7;
            if (articleBean == null) {
                return;
            }
            if (!n0.o(articleBean != null ? articleBean.getTopics() : null)) {
                return;
            }
        }
        s.a aVar2 = this.G7;
        if (aVar2 == null) {
            kotlin.jvm.internal.f0.S("mPresenter");
        } else {
            aVar = aVar2;
        }
        aVar.w();
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        y5.e eVarC = y5.e.c(getLayoutInflater());
        kotlin.jvm.internal.f0.o(eVarC, "inflate(layoutInflater)");
        M4(eVarC);
        setContentView(I4().getRoot());
    }
}
