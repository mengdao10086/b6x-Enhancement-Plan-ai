package com.flydigi.base.ui.image_preview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.i;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.flydigi.base.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.common.o;
import com.flydigi.base.common.y;
import com.flydigi.base.ui.image_preview.ImagePreviewFragment;
import com.flydigi.base.widget.CompactViewPager;
import hk.m;
import j5.v;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v0;
import kotlin.z;
import kotlin.z1;
import p1.a;
import s4.p;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nImagePreviewFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImagePreviewFragment.kt\ncom/flydigi/base/ui/image_preview/ImagePreviewFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,154:1\n106#2,15:155\n*S KotlinDebug\n*F\n+ 1 ImagePreviewFragment.kt\ncom/flydigi/base/ui/image_preview/ImagePreviewFragment\n*L\n33#1:155,15\n*E\n"})
public final class ImagePreviewFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @k
    public static final a f13381t8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @k
    public final z f13382o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public com.flydigi.base.ui.image_preview.a f13383p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public int f13384q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @l
    public ArrayList<PreviewBean> f13385r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public v f13386s8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final ImagePreviewFragment a(@k ArrayList<PreviewBean> urls, int i10) {
            f0.p(urls, "urls");
            ImagePreviewFragment imagePreviewFragment = new ImagePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("main_image_urls", urls);
            bundle.putInt("main_image_current_position", i10);
            imagePreviewFragment.c5(bundle);
            return imagePreviewFragment;
        }
    }

    public static final class b implements ViewPager.j {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            ImagePreviewFragment.this.i6(i10);
        }
    }

    public static final class c implements g<Drawable> {
        public c() {
        }

        public static final void c(ImagePreviewFragment this$0) {
            f0.p(this$0, "this$0");
            if (this$0.s3()) {
                v vVar = this$0.f13386s8;
                if (vVar == null) {
                    f0.S("viewBinding");
                    vVar = null;
                }
                vVar.f36165c.setEnabled(true);
            }
        }

        @Override // com.bumptech.glide.request.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean e(@l Drawable drawable, @k Object model, @k p<Drawable> target, @k DataSource dataSource, boolean z10) {
            f0.p(model, "model");
            f0.p(target, "target");
            f0.p(dataSource, "dataSource");
            y yVarH5 = ImagePreviewFragment.this.H5();
            final ImagePreviewFragment imagePreviewFragment = ImagePreviewFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.base.ui.image_preview.d
                @Override // java.lang.Runnable
                public final void run() {
                    ImagePreviewFragment.c.c(imagePreviewFragment);
                }
            });
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean d(@l GlideException glideException, @k Object model, @k p<Drawable> target, boolean z10) {
            f0.p(model, "model");
            f0.p(target, "target");
            o.w(ImagePreviewFragment.this.c3(R.string.pic_load_failed));
            return false;
        }
    }

    public ImagePreviewFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Fragment o() {
                return this;
            }
        };
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 o() {
                return (d1) aVar.o();
            }
        });
        final ik.a aVar2 = null;
        this.f13382o8 = FragmentViewModelLazyKt.h(this, n0.d(ImagePreviewViewModel.class), new ik.a<c1>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar3;
                ik.a aVar4 = aVar2;
                if (aVar4 != null && (aVar3 = (p1.a) aVar4.o()) != null) {
                    return aVar3;
                }
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                r rVar = d1VarP instanceof r ? (r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0;
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                r rVar = d1VarP instanceof r ? (r) d1VarP : null;
                if (rVar == null || (bVarH0 = rVar.h0()) == null) {
                    bVarH0 = this.h0();
                }
                f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
    }

    @m
    @k
    public static final ImagePreviewFragment f6(@k ArrayList<PreviewBean> arrayList, int i10) {
        return f13381t8.a(arrayList, i10);
    }

    public static final void g6(ImagePreviewFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.I5();
    }

    public static final void h6(ImagePreviewFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.e6().j()) {
            ImagePreviewViewModel imagePreviewViewModelE6 = this$0.e6();
            ArrayList<PreviewBean> arrayList = this$0.f13385r8;
            f0.m(arrayList);
            String str = arrayList.get(this$0.f13384q8).url;
            f0.o(str, "mUrls!![mCurrent].url");
            imagePreviewViewModelE6.l(str, new ik.a<z1>() { // from class: com.flydigi.base.ui.image_preview.ImagePreviewFragment$onViewCreated$3$1
                public final void b() {
                    ToastUtils.T(R.string.pic_saved);
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f13385r8 = (ArrayList) (bundleT1 != null ? bundleT1.getSerializable("main_image_urls") : null);
        Bundle bundleT12 = T1();
        this.f13384q8 = bundleT12 != null ? bundleT12.getInt("main_image_current_position", 0) : 0;
        ArrayList<PreviewBean> arrayList = this.f13385r8;
        if (arrayList != null) {
            f0.m(arrayList);
            if (arrayList.size() >= 1) {
                return;
            }
        }
        I5();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_layout_fragment_image_preview;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        v vVarD = v.d(inflater, viewGroup, false);
        f0.o(vVarD, "inflate(inflater, container, false)");
        this.f13386s8 = vVarD;
        if (vVarD == null) {
            f0.S("viewBinding");
            vVarD = null;
        }
        RelativeLayout root = vVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    public final ImagePreviewViewModel e6() {
        return (ImagePreviewViewModel) this.f13382o8.getValue();
    }

    public final void i6(int i10) {
        this.f13384q8 = i10;
        v vVar = this.f13386s8;
        if (vVar == null) {
            f0.S("viewBinding");
            vVar = null;
        }
        vVar.f36165c.setEnabled(false);
        v vVar2 = this.f13386s8;
        if (vVar2 == null) {
            f0.S("viewBinding");
            vVar2 = null;
        }
        TextView textView = vVar2.f36167e;
        v0 v0Var = v0.f37964a;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i10 + 1);
        com.flydigi.base.ui.image_preview.a aVar = this.f13383p8;
        if (aVar == null) {
            f0.S("mAdapter");
            aVar = null;
        }
        objArr[1] = Integer.valueOf(aVar.getCount());
        String str = String.format("%d/%d", Arrays.copyOf(objArr, 2));
        f0.o(str, "format(format, *args)");
        textView.setText(str);
        ArrayList<PreviewBean> arrayList = this.f13385r8;
        f0.m(arrayList);
        if (arrayList.get(i10).video) {
            v vVar3 = this.f13386s8;
            if (vVar3 == null) {
                f0.S("viewBinding");
                vVar3 = null;
            }
            ImageView imageView = vVar3.f36165c;
            f0.o(imageView, "viewBinding.ibDownload");
            o5.c.b(imageView, Boolean.FALSE, false, 2, null);
            return;
        }
        v vVar4 = this.f13386s8;
        if (vVar4 == null) {
            f0.S("viewBinding");
            vVar4 = null;
        }
        ImageView imageView2 = vVar4.f36165c;
        f0.o(imageView2, "viewBinding.ibDownload");
        o5.c.b(imageView2, Boolean.TRUE, false, 2, null);
        i iVarG = com.bumptech.glide.b.G(this);
        ArrayList<PreviewBean> arrayList2 = this.f13385r8;
        f0.m(arrayList2);
        iVarG.t(arrayList2.get(i10).url).u1(new c()).I1();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        v vVar = this.f13386s8;
        v vVar2 = null;
        if (vVar == null) {
            f0.S("viewBinding");
            vVar = null;
        }
        com.blankj.utilcode.util.f.a(vVar.f36166d);
        v vVar3 = this.f13386s8;
        if (vVar3 == null) {
            f0.S("viewBinding");
            vVar3 = null;
        }
        com.blankj.utilcode.util.o.r(vVar3.f36164b, new View.OnClickListener() { // from class: com.flydigi.base.ui.image_preview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImagePreviewFragment.g6(this.f13405a, view2);
            }
        });
        com.flydigi.base.ui.image_preview.a aVar = new com.flydigi.base.ui.image_preview.a(U1());
        this.f13383p8 = aVar;
        aVar.b(this.f13385r8);
        v vVar4 = this.f13386s8;
        if (vVar4 == null) {
            f0.S("viewBinding");
            vVar4 = null;
        }
        CompactViewPager compactViewPager = vVar4.f36168f;
        com.flydigi.base.ui.image_preview.a aVar2 = this.f13383p8;
        if (aVar2 == null) {
            f0.S("mAdapter");
            aVar2 = null;
        }
        compactViewPager.setAdapter(aVar2);
        v vVar5 = this.f13386s8;
        if (vVar5 == null) {
            f0.S("viewBinding");
            vVar5 = null;
        }
        vVar5.f36168f.setCurrentItem(this.f13384q8);
        v vVar6 = this.f13386s8;
        if (vVar6 == null) {
            f0.S("viewBinding");
            vVar6 = null;
        }
        vVar6.f36168f.e(new b());
        v vVar7 = this.f13386s8;
        if (vVar7 == null) {
            f0.S("viewBinding");
            vVar7 = null;
        }
        vVar7.f36168f.setOffscreenPageLimit(3);
        v vVar8 = this.f13386s8;
        if (vVar8 == null) {
            f0.S("viewBinding");
            vVar8 = null;
        }
        TextView textView = vVar8.f36167e;
        v0 v0Var = v0.f37964a;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.f13384q8 + 1);
        com.flydigi.base.ui.image_preview.a aVar3 = this.f13383p8;
        if (aVar3 == null) {
            f0.S("mAdapter");
            aVar3 = null;
        }
        objArr[1] = Integer.valueOf(aVar3.getCount());
        String str = String.format("%d/%d", Arrays.copyOf(objArr, 2));
        f0.o(str, "format(format, *args)");
        textView.setText(str);
        v vVar9 = this.f13386s8;
        if (vVar9 == null) {
            f0.S("viewBinding");
        } else {
            vVar2 = vVar9;
        }
        com.blankj.utilcode.util.o.r(vVar2.f36165c, new View.OnClickListener() { // from class: com.flydigi.base.ui.image_preview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ImagePreviewFragment.h6(this.f13404a, view2);
            }
        });
    }
}
