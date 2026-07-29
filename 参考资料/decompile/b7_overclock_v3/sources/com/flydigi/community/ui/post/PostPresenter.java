package com.flydigi.community.ui.post;

import com.flydigi.community.ui.post.s;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.ConfigShareResult;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.community.ArticleBean;
import com.flydigi.data.bean.community.TopicBean;
import com.flydigi.data.bean.community.TopicListBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nPostPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostPresenter.kt\ncom/flydigi/community/ui/post/PostPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,195:1\n1#2:196\n1864#3,3:197\n1864#3,3:200\n*S KotlinDebug\n*F\n+ 1 PostPresenter.kt\ncom/flydigi/community/ui/post/PostPresenter\n*L\n54#1:197,3\n97#1:200,3\n*E\n"})
public final class PostPresenter implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final s.b f13998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final z5.f f13999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f14000c;

    public PostPresenter(@yt.k s.b mView) {
        kotlin.jvm.internal.f0.p(mView, "mView");
        this.f13998a = mView;
        this.f13999b = new z5.f();
        this.f14000c = new io.reactivex.disposables.a();
    }

    public static final void A0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void B0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void D0(ConfigBean config, xi.b0 it2) {
        kotlin.jvm.internal.f0.p(config, "$config");
        kotlin.jvm.internal.f0.p(it2, "it");
        File fileE0 = e6.z.e0(config);
        if (fileE0 == null || !com.blankj.utilcode.util.b0.g0(fileE0)) {
            it2.onError(new FileNotFoundException());
        } else {
            it2.onNext(fileE0);
        }
    }

    public static final void E0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void F0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void G0(PostPresenter this$0, ConfigBean config, boolean z10, okhttp3.d0 d0Var, Exception exc) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(config, "$config");
        if (!z10) {
            this$0.f13998a.F0();
            return;
        }
        try {
            okhttp3.e0 e0VarL = d0Var.L();
            String strOptString = new JSONObject(e0VarL != null ? e0VarL.string() : null).optString("url");
            kotlin.jvm.internal.f0.o(strOptString, "jsonObject.optString(\"url\")");
            this$0.z0(config, strOptString);
        } catch (JSONException unused) {
            this$0.f13998a.F0();
        }
    }

    public static final void r0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void s0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final ArrayList u0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (ArrayList) tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void x0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void y0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public final void C0(final ConfigBean configBean, File file) {
        u9.k.e(file, DataConstant.UPYUN_BUCKET, new gh.b() { // from class: com.flydigi.community.ui.post.v
            @Override // gh.b
            public final void a(boolean z10, okhttp3.d0 d0Var, Exception exc) {
                PostPresenter.G0(this.f14030a, configBean, z10, d0Var, exc);
            }
        }, null);
    }

    @Override // com.flydigi.community.ui.post.s.a
    public void a0(@yt.k String content, @yt.k ArrayList<ContentAddBean> medias, @yt.l TopicBean topicBean, @yt.l ConfigBean configBean) {
        String string;
        String strJ;
        String string2;
        kotlin.jvm.internal.f0.p(content, "content");
        kotlin.jvm.internal.f0.p(medias, "medias");
        String str = "";
        int i10 = -1;
        int i11 = 0;
        for (Object obj : medias) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            ContentAddBean contentAddBean = (ContentAddBean) obj;
            if (contentAddBean.isVideo()) {
                str = contentAddBean.url;
                kotlin.jvm.internal.f0.o(str, "media.url");
                i10 = i11;
            }
            i11 = i12;
        }
        if (i10 >= 0) {
            medias.remove(i10);
        }
        z5.f fVar = this.f13999b;
        String strV = com.blankj.utilcode.util.e0.v(medias);
        if (topicBean == null || (string = Integer.valueOf(topicBean.getId()).toString()) == null) {
            string = "";
        }
        int id2 = configBean != null ? configBean.getId() : 0;
        String title = configBean != null ? configBean.getTitle() : null;
        if (title == null) {
            title = "";
        }
        String gameName = configBean != null ? configBean.getGameName() : null;
        if (gameName == null) {
            gameName = "";
        }
        String deviceName = configBean != null ? configBean.getDeviceName() : null;
        String str2 = deviceName == null ? "" : deviceName;
        String str3 = (configBean == null || (string2 = Integer.valueOf(configBean.getDeviceType()).toString()) == null) ? "" : string2;
        if (configBean == null || (strJ = configBean.getManufacturer()) == null) {
            strJ = com.blankj.utilcode.util.x.j();
        }
        xi.z<R> zVarS0 = fVar.i(content, strV, str, i10, string, id2, title, gameName, str2, str3, String.valueOf(strJ)).s0(o5.l.d());
        final ik.l<ArticleBean, z1> lVar = new ik.l<ArticleBean, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$post$2
            {
                super(1);
            }

            public final void b(ArticleBean article) {
                s.b bVarT0 = this.this$0.t0();
                kotlin.jvm.internal.f0.o(article, "article");
                bVarT0.D(article);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArticleBean articleBean) {
                b(articleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.post.y
            @Override // dj.g
            public final void accept(Object obj2) {
                PostPresenter.x0(lVar, obj2);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$post$3
            {
                super(1);
            }

            public final void b(Throwable it2) {
                s.b bVarT0 = this.this$0.t0();
                kotlin.jvm.internal.f0.o(it2, "it");
                bVarT0.h2(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14000c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.post.z
            @Override // dj.g
            public final void accept(Object obj2) {
                PostPresenter.y0(lVar2, obj2);
            }
        }));
    }

    @yt.k
    public final s.b t0() {
        return this.f13998a;
    }

    @Override // com.flydigi.community.ui.post.s.a
    public void v(int i10, @yt.k String content, @yt.k ArrayList<ContentAddBean> medias, @yt.l TopicBean topicBean, @yt.l ConfigBean configBean) {
        String string;
        String string2;
        kotlin.jvm.internal.f0.p(content, "content");
        kotlin.jvm.internal.f0.p(medias, "medias");
        String str = "";
        int i11 = 0;
        int i12 = -1;
        for (Object obj : medias) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            ContentAddBean contentAddBean = (ContentAddBean) obj;
            if (contentAddBean.isVideo()) {
                str = contentAddBean.url;
                kotlin.jvm.internal.f0.o(str, "media.url");
                i12 = i11;
            }
            i11 = i13;
        }
        if (i12 >= 0) {
            medias.remove(i12);
        }
        z5.f fVar = this.f13999b;
        String strV = com.blankj.utilcode.util.e0.v(medias);
        String str2 = (topicBean == null || (string2 = Integer.valueOf(topicBean.getId()).toString()) == null) ? "" : string2;
        int id2 = configBean != null ? configBean.getId() : 0;
        String title = configBean != null ? configBean.getTitle() : null;
        String str3 = title == null ? "" : title;
        String gameName = configBean != null ? configBean.getGameName() : null;
        String str4 = gameName == null ? "" : gameName;
        String deviceName = configBean != null ? configBean.getDeviceName() : null;
        String str5 = deviceName == null ? "" : deviceName;
        String str6 = (configBean == null || (string = Integer.valueOf(configBean.getDeviceType()).toString()) == null) ? "" : string;
        String model = configBean != null ? configBean.getModel() : null;
        xi.z<R> zVarS0 = fVar.p(i10, content, strV, str, i12, str2, id2, str3, str4, str5, str6, model == null ? "" : model).s0(o5.l.d());
        final ik.l<ArticleBean, z1> lVar = new ik.l<ArticleBean, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$edit$2
            {
                super(1);
            }

            public final void b(ArticleBean article) {
                s.b bVarT0 = this.this$0.t0();
                kotlin.jvm.internal.f0.o(article, "article");
                bVarT0.D(article);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArticleBean articleBean) {
                b(articleBean);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.post.f0
            @Override // dj.g
            public final void accept(Object obj2) {
                PostPresenter.r0(lVar, obj2);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$edit$3
            {
                super(1);
            }

            public final void b(Throwable it2) {
                s.b bVarT0 = this.this$0.t0();
                kotlin.jvm.internal.f0.o(it2, "it");
                bVarT0.h2(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14000c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.post.b0
            @Override // dj.g
            public final void accept(Object obj2) {
                PostPresenter.s0(lVar2, obj2);
            }
        }));
    }

    @Override // com.flydigi.community.ui.post.s.a
    public void w() {
        xi.z<TopicListBean> zVarO = this.f13999b.o(true, 1, 4);
        final PostPresenter$getTopics$1 postPresenter$getTopics$1 = new ik.l<TopicListBean, ArrayList<TopicBean>>() { // from class: com.flydigi.community.ui.post.PostPresenter$getTopics$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ArrayList<TopicBean> i(@yt.k TopicListBean topicListBean) {
                kotlin.jvm.internal.f0.p(topicListBean, "topicListBean");
                return topicListBean.getTopics();
            }
        };
        xi.z zVarS0 = zVarO.A3(new dj.o() { // from class: com.flydigi.community.ui.post.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return PostPresenter.u0(postPresenter$getTopics$1, obj);
            }
        }).s0(o5.l.d());
        final ik.l<ArrayList<TopicBean>, z1> lVar = new ik.l<ArrayList<TopicBean>, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$getTopics$2
            {
                super(1);
            }

            public final void b(@yt.k ArrayList<TopicBean> topics) {
                kotlin.jvm.internal.f0.p(topics, "topics");
                this.this$0.t0().a1(topics);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<TopicBean> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.post.e0
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.v0(lVar, obj);
            }
        };
        final PostPresenter$getTopics$3 postPresenter$getTopics$3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$getTopics$3
            public final void b(Throwable th2) {
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14000c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.post.a0
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.w0(postPresenter$getTopics$3, obj);
            }
        }));
    }

    @Override // com.flydigi.community.ui.post.s.a
    public void y(@yt.k final ConfigBean config) {
        kotlin.jvm.internal.f0.p(config, "config");
        xi.z zVarR1 = xi.z.r1(new xi.c0() { // from class: com.flydigi.community.ui.post.w
            @Override // xi.c0
            public final void a(xi.b0 b0Var) {
                PostPresenter.D0(config, b0Var);
            }
        });
        final ik.l<File, z1> lVar = new ik.l<File, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$uploadConfig$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(File it2) {
                PostPresenter postPresenter = this.this$0;
                ConfigBean configBean = config;
                kotlin.jvm.internal.f0.o(it2, "it");
                postPresenter.C0(configBean, it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(File file) {
                b(file);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.post.t
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.E0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$uploadConfig$3
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.t0().F0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14000c.b(zVarR1.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.post.c0
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.F0(lVar2, obj);
            }
        }));
    }

    public final void z0(final ConfigBean configBean, String str) {
        int deviceType = configBean.getDeviceType();
        int i10 = deviceType != 1 ? deviceType != 2 ? 1 : 3 : 2;
        h5.d dVar = (h5.d) m5.f0.i().k().g(h5.d.class);
        String packageName = configBean.getPackageName();
        String title = configBean.getTitle();
        String strValueOf = String.valueOf(i10);
        String gameName = configBean.getGameName();
        String deviceName = configBean.getDeviceName();
        StringBuilder sb2 = new StringBuilder();
        String manufacturer = configBean.getManufacturer();
        if (manufacturer == null) {
            manufacturer = com.blankj.utilcode.util.x.j();
        }
        sb2.append(manufacturer);
        sb2.append(zc.f.f58383m);
        String model = configBean.getModel();
        if (model == null) {
            model = com.blankj.utilcode.util.x.k();
        }
        sb2.append(model);
        xi.z zVarS0 = dVar.y(packageName, "", title, str, strValueOf, gameName, deviceName, sb2.toString()).s0(m5.c0.p()).s0(m5.c0.t()).s0(o5.l.d());
        final ik.l<ConfigShareResult, z1> lVar = new ik.l<ConfigShareResult, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$saveConfigToServer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ConfigShareResult configShareResult) {
                configBean.setId(configShareResult.f14328id);
                this.t0().N1();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ConfigShareResult configShareResult) {
                b(configShareResult);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.post.x
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.A0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.post.PostPresenter$saveConfigToServer$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.t0().F0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f14000c.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.post.d0
            @Override // dj.g
            public final void accept(Object obj) {
                PostPresenter.B0(lVar2, obj);
            }
        }));
    }
}
