package com.flydigi.qiji.ui.advertise;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import com.blankj.utilcode.util.j1;
import com.fdg.flashplay.farsef.R;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.AdvertiseBean;
import com.flydigi.qiji.ui.advertise.AdFragment;
import com.umeng.analytics.pro.an;
import i9.a;
import ik.l;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import kotlin.z1;
import p1.a;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAdFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdFragment.kt\ncom/flydigi/qiji/ui/advertise/AdFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,208:1\n106#2,15:209\n*S KotlinDebug\n*F\n+ 1 AdFragment.kt\ncom/flydigi/qiji/ui/advertise/AdFragment\n*L\n42#1:209,15\n*E\n"})
public final class AdFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @k
    public static final b f16079t8 = new b(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public a f16080o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f16081p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f16082q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public b9.b f16083r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @k
    public final z f16084s8;

    public interface a {
        void k2();
    }

    @t0({"SMAP\nAdFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdFragment.kt\ncom/flydigi/qiji/ui/advertise/AdFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @k
        public final AdFragment a() {
            AdFragment adFragment = new AdFragment();
            adFragment.c5(androidx.core.os.e.a());
            return adFragment;
        }
    }

    public static final class c implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f16085a;

        public c(l function) {
            f0.p(function, "function");
            this.f16085a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @k
        public final kotlin.u<?> a() {
            return this.f16085a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f16085a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof k0) && (obj instanceof a0)) {
                return f0.g(a(), ((a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public AdFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$special$$inlined$viewModels$default$1
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
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$special$$inlined$viewModels$default$2
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
        this.f16084s8 = FragmentViewModelLazyKt.h(this, n0.d(AdvertiseViewModel.class), new ik.a<c1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$special$$inlined$viewModels$default$3
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$special$$inlined$viewModels$default$4
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$special$$inlined$viewModels$default$5
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

    public static final void k6(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l6(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void m6(l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void n6(AdFragment this$0) {
        f0.p(this$0, "this$0");
        a aVar = this$0.f16080o8;
        if (aVar == null) {
            f0.S("mCallback");
            aVar = null;
        }
        aVar.k2();
        b9.b bVar = this$0.f16083r8;
        if (bVar == null) {
            f0.S("viewBinding");
            bVar = null;
        }
        TextView textView = bVar.f9148d;
        f0.o(textView, "viewBinding.tvJump");
        o5.c.b(textView, Boolean.FALSE, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@k Context context) {
        f0.p(context, "context");
        super.H3(context);
        this.f16080o8 = (a) context;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.app_layout_fragment_ad;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        b9.b bVarD = b9.b.d(inflater, viewGroup, false);
        f0.o(bVarD, "inflate(inflater, container, false)");
        this.f16083r8 = bVarD;
        if (bVarD == null) {
            f0.S("viewBinding");
            bVarD = null;
        }
        ConstraintLayout root = bVarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        AdvertiseBean advertiseBeanF = o6().m().f();
        if (advertiseBeanF != null) {
            u9.h.h(X1(), advertiseBeanF.getAdvertiseId(), this.f16081p8, this.f16082q8);
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        o6().n().k(l3(), new c(new l<Boolean, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(Boolean bool) {
                if (bool.booleanValue()) {
                    return;
                }
                AdFragment.a aVar = this.this$0.f16080o8;
                if (aVar == null) {
                    f0.S("mCallback");
                    aVar = null;
                }
                aVar.k2();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Boolean bool) {
                b(bool);
                return z1.f38230a;
            }
        }));
        o6().m().k(l3(), new c(new AdFragment$onViewCreated$2(this)));
    }

    public final void j6() {
        xi.z<Long> zVarF = o5.l.f(3);
        final l<io.reactivex.disposables.b, z1> lVar = new l<io.reactivex.disposables.b, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$countdown$1
            {
                super(1);
            }

            public final void b(io.reactivex.disposables.b bVar) {
                b9.b bVar2 = this.this$0.f16083r8;
                if (bVar2 == null) {
                    f0.S("viewBinding");
                    bVar2 = null;
                }
                bVar2.f9148d.setText(this.this$0.d3(R.string.app_jump_s, 3));
                b9.b bVar3 = this.this$0.f16083r8;
                if (bVar3 == null) {
                    f0.S("viewBinding");
                    bVar3 = null;
                }
                TextView textView = bVar3.f9148d;
                f0.o(textView, "viewBinding.tvJump");
                o5.c.b(textView, Boolean.TRUE, false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(io.reactivex.disposables.b bVar) {
                b(bVar);
                return z1.f38230a;
            }
        };
        xi.z<Long> zVarB4 = zVarF.Z1(new dj.g() { // from class: com.flydigi.qiji.ui.advertise.c
            @Override // dj.g
            public final void accept(Object obj) {
                AdFragment.k6(lVar, obj);
            }
        }).b4(aj.a.c());
        final l<Long, z1> lVar2 = new l<Long, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$countdown$2
            {
                super(1);
            }

            public final void b(long j10) {
                b9.b bVar = this.this$0.f16083r8;
                b9.b bVar2 = null;
                if (bVar == null) {
                    f0.S("viewBinding");
                    bVar = null;
                }
                TextView textView = bVar.f9148d;
                f0.o(textView, "viewBinding.tvJump");
                o5.c.b(textView, Boolean.TRUE, false, 2, null);
                b9.b bVar3 = this.this$0.f16083r8;
                if (bVar3 == null) {
                    f0.S("viewBinding");
                } else {
                    bVar2 = bVar3;
                }
                bVar2.f9148d.setText(this.this$0.d3(R.string.app_jump_s, Long.valueOf(j10 - 1)));
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Long l10) {
                b(l10.longValue());
                return z1.f38230a;
            }
        };
        dj.g<? super Long> gVar = new dj.g() { // from class: com.flydigi.qiji.ui.advertise.b
            @Override // dj.g
            public final void accept(Object obj) {
                AdFragment.l6(lVar2, obj);
            }
        };
        final l<Throwable, z1> lVar3 = new l<Throwable, z1>() { // from class: com.flydigi.qiji.ui.advertise.AdFragment$countdown$3
            {
                super(1);
            }

            public final void b(Throwable th2) {
                AdFragment.a aVar = this.this$0.f16080o8;
                if (aVar == null) {
                    f0.S("mCallback");
                    aVar = null;
                }
                aVar.k2();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f13327n8.b(zVarB4.G5(gVar, new dj.g() { // from class: com.flydigi.qiji.ui.advertise.d
            @Override // dj.g
            public final void accept(Object obj) {
                AdFragment.m6(lVar3, obj);
            }
        }, new dj.a() { // from class: com.flydigi.qiji.ui.advertise.a
            @Override // dj.a
            public final void run() {
                AdFragment.n6(this.f16090a);
            }
        }));
    }

    public final AdvertiseViewModel o6() {
        return (AdvertiseViewModel) this.f16084s8.getValue();
    }

    public final void p6(int i10, String str) {
        a aVar = this.f16080o8;
        if (aVar == null) {
            f0.S("mCallback");
            aVar = null;
        }
        aVar.k2();
        if (TextUtils.isEmpty(str)) {
        }
        switch (i10) {
            case 1:
                o5.f.f(R4(), str);
                break;
            case 2:
                u9.h.n(R4(), "游戏详情访问", str, an.aw);
                h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, str).navigation(R4());
                break;
            case 3:
                h3.a.j().d(a.b.f31919d).withInt("id", Integer.parseInt(str)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13292j).navigation(R4());
                break;
            case 4:
                Intent launchIntentForPackage = R4().getPackageManager().getLaunchIntentForPackage("com.taobao.taobao");
                if (launchIntentForPackage == null) {
                    h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + str).navigation(R4());
                } else {
                    launchIntentForPackage.setAction("android.intent.action.VIEW");
                    launchIntentForPackage.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
                    launchIntentForPackage.setData(Uri.parse(DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + str));
                    if (!o5.f.j(H1(), launchIntentForPackage)) {
                        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + str).navigation(R4());
                    }
                }
                break;
            case 5:
                if (!o5.f.a(j1.a(), "com.taobao.taobao")) {
                    h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_TAOBAO_SHOP_WEB + str).navigation();
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(DataConstant.MAIN_RECOMMEND_TAOBAO_SHOP_URL + str));
                    com.blankj.utilcode.util.a.P().startActivity(intent);
                }
                break;
            case 6:
                if (!o5.f.a(j1.a(), "air.tv.douyu.android")) {
                    h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_DOUYU_LIVE + str).navigation();
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(DataConstant.SCHEMA_DOUYU + str + "&isVertical=0"));
                    x5(intent2);
                }
                break;
            case 7:
                h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, "").withString(DataConstant.WEB_URL, str).navigation(R4());
                break;
        }
    }
}
