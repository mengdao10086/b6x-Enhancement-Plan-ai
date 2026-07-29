package com.flydigi.community.ui.article;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.blankj.utilcode.util.ImageUtils;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.ui.image_preview.PreviewBean;
import com.flydigi.community.R;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ContentAddBean;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nMediaBannerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaBannerFragment.kt\ncom/flydigi/community/ui/article/MediaBannerFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n1#2:151\n1549#3:152\n1620#3,3:153\n*S KotlinDebug\n*F\n+ 1 MediaBannerFragment.kt\ncom/flydigi/community/ui/article/MediaBannerFragment\n*L\n104#1:152\n104#1:153,3\n*E\n"})
public final class MediaBannerFragment extends FZFragment {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public static final a f13715s8 = new a(null);

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public static final String f13716t8 = "key_medias";

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @yt.k
    public static final String f13717u8 = "key_position";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public y5.k f13718o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public ArrayList<ContentAddBean> f13719p8 = new ArrayList<>();

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public int f13720q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public ContentAddBean f13721r8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final MediaBannerFragment a(@yt.k ArrayList<ContentAddBean> medias, int i10) {
            kotlin.jvm.internal.f0.p(medias, "medias");
            MediaBannerFragment mediaBannerFragment = new MediaBannerFragment();
            mediaBannerFragment.c5(androidx.core.os.e.b(new Pair(MediaBannerFragment.f13716t8, medias), new Pair(MediaBannerFragment.f13717u8, Integer.valueOf(i10))));
            return mediaBannerFragment;
        }
    }

    public static final File f6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final Bitmap g6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (Bitmap) tmp0.i(obj);
    }

    public static final void h6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void i6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void j6(MediaBannerFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        ArrayList<ContentAddBean> arrayList = this$0.f13719p8;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
        for (ContentAddBean contentAddBean : arrayList) {
            PreviewBean previewBean = new PreviewBean();
            previewBean.url = contentAddBean.url;
            previewBean.video = contentAddBean.isVideo();
            previewBean.videoCover = contentAddBean.videoCover;
            arrayList2.add(previewBean);
        }
        h3.a.j().d(i9.a.f31901c).withSerializable("main_image_urls", new ArrayList(arrayList2)).withInt("main_image_current_position", this$0.f13720q8).navigation();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        ArrayList<ContentAddBean> parcelableArrayList = bundleT1 != null ? bundleT1.getParcelableArrayList(f13716t8) : null;
        if (parcelableArrayList == null) {
            parcelableArrayList = new ArrayList<>();
        }
        this.f13719p8 = parcelableArrayList;
        Bundle bundleT12 = T1();
        int i10 = bundleT12 != null ? bundleT12.getInt(f13717u8) : 0;
        this.f13720q8 = i10;
        if (i10 < this.f13719p8.size()) {
            this.f13721r8 = this.f13719p8.get(this.f13720q8);
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.community_fragment_media_banner;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        y5.k kVarD = y5.k.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(kVarD, "inflate(inflater, container, false)");
        this.f13718o8 = kVarD;
        if (kVarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            kVarD = null;
        }
        ConstraintLayout root = kVarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        Jzvd.releaseAllVideos();
        i9.b.f(this, DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
        super.R3();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        y5.k kVar = this.f13718o8;
        y5.k kVar2 = null;
        if (kVar == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            kVar = null;
        }
        if (kVar.f56368c.state == 5) {
            y5.k kVar3 = this.f13718o8;
            if (kVar3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                kVar2 = kVar3;
            }
            kVar2.f56368c.setState(6);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        ContentAddBean contentAddBean = this.f13721r8;
        if (contentAddBean != null) {
            y5.k kVar = null;
            if (contentAddBean.isVideo()) {
                y5.k kVar2 = this.f13718o8;
                if (kVar2 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    kVar2 = null;
                }
                JzvdStd jzvdStd = kVar2.f56368c;
                kotlin.jvm.internal.f0.o(jzvdStd, "viewBinding.areaVideo");
                o5.c.b(jzvdStd, Boolean.TRUE, false, 2, null);
                com.bumptech.glide.h<Drawable> hVarT = com.bumptech.glide.b.G(this).t(contentAddBean.videoCover);
                int i10 = R.drawable.pic_banner_place_holder;
                com.bumptech.glide.h hVarX = hVarT.E0(i10).x(i10);
                y5.k kVar3 = this.f13718o8;
                if (kVar3 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    kVar3 = null;
                }
                hVarX.s1(kVar3.f56368c.posterImageView);
                y5.k kVar4 = this.f13718o8;
                if (kVar4 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                } else {
                    kVar = kVar4;
                }
                kVar.f56368c.setUp(contentAddBean.url, "", 0, t0.class);
                return;
            }
            y5.k kVar5 = this.f13718o8;
            if (kVar5 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
                kVar5 = null;
            }
            ImageView imageView = kVar5.f56367b;
            kotlin.jvm.internal.f0.o(imageView, "viewBinding.areaImage");
            o5.c.b(imageView, Boolean.TRUE, false, 2, null);
            xi.z zVarM3 = xi.z.m3(contentAddBean.url);
            final ik.l<String, File> lVar = new ik.l<String, File>() { // from class: com.flydigi.community.ui.article.MediaBannerFragment$onViewCreated$1$1
                {
                    super(1);
                }

                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final File i(@yt.k String url) {
                    kotlin.jvm.internal.f0.p(url, "url");
                    y5.k kVar6 = this.this$0.f13718o8;
                    if (kVar6 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        kVar6 = null;
                    }
                    return com.bumptech.glide.b.F(kVar6.f56367b).E().t(url).J1(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                }
            };
            xi.z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.community.ui.article.y0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return MediaBannerFragment.f6(lVar, obj);
                }
            });
            final MediaBannerFragment$onViewCreated$1$2 mediaBannerFragment$onViewCreated$1$2 = new ik.l<File, Bitmap>() { // from class: com.flydigi.community.ui.article.MediaBannerFragment$onViewCreated$1$2
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Bitmap i(@yt.k File file) {
                    kotlin.jvm.internal.f0.p(file, "file");
                    return ImageUtils.S(file);
                }
            };
            xi.z zVarS0 = zVarA3.A3(new dj.o() { // from class: com.flydigi.community.ui.article.z0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return MediaBannerFragment.g6(mediaBannerFragment$onViewCreated$1$2, obj);
                }
            }).s0(o5.l.d());
            final ik.l<Bitmap, z1> lVar2 = new ik.l<Bitmap, z1>() { // from class: com.flydigi.community.ui.article.MediaBannerFragment$onViewCreated$1$3
                {
                    super(1);
                }

                public final void b(Bitmap bitmap) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    y5.k kVar6 = this.this$0.f13718o8;
                    y5.k kVar7 = null;
                    if (kVar6 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        kVar6 = null;
                    }
                    int width2 = kVar6.f56367b.getWidth();
                    y5.k kVar8 = this.this$0.f13718o8;
                    if (kVar8 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                        kVar8 = null;
                    }
                    if (width2 >= kVar8.f56367b.getHeight()) {
                        y5.k kVar9 = this.this$0.f13718o8;
                        if (kVar9 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            kVar9 = null;
                        }
                        int height2 = (width * kVar9.f56367b.getHeight()) / height;
                        y5.k kVar10 = this.this$0.f13718o8;
                        if (kVar10 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            kVar10 = null;
                        }
                        kVar10.f56367b.getLayoutParams().width = height2;
                    } else {
                        y5.k kVar11 = this.this$0.f13718o8;
                        if (kVar11 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            kVar11 = null;
                        }
                        int width3 = (height * kVar11.f56367b.getWidth()) / width;
                        y5.k kVar12 = this.this$0.f13718o8;
                        if (kVar12 == null) {
                            kotlin.jvm.internal.f0.S("viewBinding");
                            kVar12 = null;
                        }
                        kVar12.f56367b.getLayoutParams().height = width3;
                    }
                    y5.k kVar13 = this.this$0.f13718o8;
                    if (kVar13 == null) {
                        kotlin.jvm.internal.f0.S("viewBinding");
                    } else {
                        kVar7 = kVar13;
                    }
                    kVar7.f56367b.setImageBitmap(bitmap);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Bitmap bitmap) {
                    b(bitmap);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.community.ui.article.x0
                @Override // dj.g
                public final void accept(Object obj) {
                    MediaBannerFragment.h6(lVar2, obj);
                }
            };
            final MediaBannerFragment$onViewCreated$1$4 mediaBannerFragment$onViewCreated$1$4 = new ik.l<Throwable, z1>() { // from class: com.flydigi.community.ui.article.MediaBannerFragment$onViewCreated$1$4
                public final void b(Throwable th2) {
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            this.f13327n8.b(zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.community.ui.article.w0
                @Override // dj.g
                public final void accept(Object obj) {
                    MediaBannerFragment.i6(mediaBannerFragment$onViewCreated$1$4, obj);
                }
            }));
            y5.k kVar6 = this.f13718o8;
            if (kVar6 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                kVar = kVar6;
            }
            kVar.f56367b.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.community.ui.article.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MediaBannerFragment.j6(this.f13778a, view2);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@yt.k Configuration newConfig) {
        kotlin.jvm.internal.f0.p(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i10 = newConfig.orientation;
        if (i10 == 1) {
            i9.b.f(this, DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
        } else if (i10 == 2) {
            i9.b.f(this, DataConstant.REMOTE_ACTION_START_TEST_KEYMAPPING_UI);
        }
    }
}
