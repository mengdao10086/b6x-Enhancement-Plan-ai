package com.flydigi.device_manager.ui.home.game;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.z0;
import androidx.recyclerview.widget.RecyclerView;
import c7.h1;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.x0;
import com.daasuu.bl.BubbleLayout;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZRecyclerViewFragment;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.home.game.GameModeChooseFragment;
import com.flydigi.device_manager.ui.home.game.p;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import f.b;
import i9.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import org.json.JSONException;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nMyGameZoneFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyGameZoneFragment.kt\ncom/flydigi/device_manager/ui/home/game/MyGameZoneFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,579:1\n106#2,15:580\n172#2,9:595\n1#3:604\n*S KotlinDebug\n*F\n+ 1 MyGameZoneFragment.kt\ncom/flydigi/device_manager/ui/home/game/MyGameZoneFragment\n*L\n74#1:580,15\n75#1:595,9\n*E\n"})
public final class MyGameZoneFragment extends FZRecyclerViewFragment implements p.b {

    @yt.k
    public static final a D8 = new a(null);

    @yt.k
    public static final String E8 = "key_device_info";

    @yt.l
    public b A8;

    @yt.k
    public final androidx.activity.result.g<Intent> B8;

    @yt.k
    public final androidx.activity.result.g<Intent> C8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public p.a f15228v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.l
    public GamepadInfo f15229w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public h1 f15230x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f15231y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f15232z8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final MyGameZoneFragment a() {
            MyGameZoneFragment myGameZoneFragment = new MyGameZoneFragment();
            myGameZoneFragment.c5(androidx.core.os.e.a());
            return myGameZoneFragment;
        }
    }

    public interface b {
        void a(int i10, int i11);
    }

    public static final class c implements androidx.lifecycle.k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15233a;

        public c(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f15233a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15233a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15233a.i(obj);
        }

        public final boolean equals(@yt.l Object obj) {
            if ((obj instanceof androidx.lifecycle.k0) && (obj instanceof kotlin.jvm.internal.a0)) {
                return kotlin.jvm.internal.f0.g(a(), ((kotlin.jvm.internal.a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class d implements GameModeChooseFragment.b {
        public d() {
        }

        @Override // com.flydigi.device_manager.ui.home.game.GameModeChooseFragment.b
        public void a(int i10, @yt.k String packageName) {
            kotlin.jvm.internal.f0.p(packageName, "packageName");
            p.a aVar = MyGameZoneFragment.this.f15228v8;
            if (aVar == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
                aVar = null;
            }
            aVar.u(packageName, i10);
        }
    }

    public MyGameZoneFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Fragment o() {
                return this;
            }
        };
        final kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 o() {
                return (d1) aVar.o();
            }
        });
        final ik.a aVar2 = null;
        this.f15231y8 = FragmentViewModelLazyKt.h(this, kotlin.jvm.internal.n0.d(InstalledGameViewModel.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                kotlin.jvm.internal.f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar3;
                ik.a aVar4 = aVar2;
                if (aVar4 != null && (aVar3 = (p1.a) aVar4.o()) != null) {
                    return aVar3;
                }
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0;
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                if (rVar == null || (bVarH0 = rVar.h0()) == null) {
                    bVarH0 = this.h0();
                }
                kotlin.jvm.internal.f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
        this.f15232z8 = FragmentViewModelLazyKt.h(this, kotlin.jvm.internal.n0.d(m9.u.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = this.P4().O0();
                kotlin.jvm.internal.f0.o(c1VarO0, "requireActivity().viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar3;
                ik.a aVar4 = aVar2;
                if (aVar4 != null && (aVar3 = (p1.a) aVar4.o()) != null) {
                    return aVar3;
                }
                p1.a aVarJ0 = this.P4().j0();
                kotlin.jvm.internal.f0.o(aVarJ0, "requireActivity().defaultViewModelCreationExtras");
                return aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0 = this.P4().h0();
                kotlin.jvm.internal.f0.o(bVarH0, "requireActivity().defaultViewModelProviderFactory");
                return bVarH0;
            }
        });
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.ui.home.game.b0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                MyGameZoneFragment.f7(this.f15245a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.B8 = gVarP1;
        androidx.activity.result.g<Intent> gVarP12 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.ui.home.game.q
            @Override // androidx.activity.result.a
            public final void a(Object obj) throws JSONException {
                MyGameZoneFragment.g7(this.f15276a, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.f0.o(gVarP12, "registerForActivityResul…)\n            }\n        }");
        this.C8 = gVarP12;
    }

    public static final void B7(DialogFragment dialogFragment) {
        dialogFragment.I5();
        PermissionUtils.C();
    }

    public static final void N6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void O6(MyGameZoneFragment this$0, Object obj) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.E0();
    }

    public static final void P6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @hk.m
    @yt.k
    public static final MyGameZoneFragment R6() {
        return D8.a();
    }

    public static final xi.e0 U6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final boolean V6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return ((Boolean) tmp0.i(obj)).booleanValue();
    }

    public static final LocalGameBean W6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (LocalGameBean) tmp0.i(obj);
    }

    public static final void X6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void Y6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static /* synthetic */ void c7(MyGameZoneFragment myGameZoneFragment, LocalGameBean localGameBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            localGameBean = null;
        }
        myGameZoneFragment.b7(localGameBean);
    }

    public static /* synthetic */ void e7(MyGameZoneFragment myGameZoneFragment, LocalGameBean localGameBean, int i10, Object obj) throws JSONException {
        if ((i10 & 1) != 0) {
            localGameBean = null;
        }
        myGameZoneFragment.d7(localGameBean);
    }

    public static final void f7(MyGameZoneFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            c7(this$0, null, 1, null);
        } else if (activityResult.b() == 0) {
            this$0.y7();
        }
    }

    public static final void g7(MyGameZoneFragment this$0, ActivityResult activityResult) throws JSONException {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            e7(this$0, null, 1, null);
        } else if (activityResult.b() == 0) {
            this$0.A7();
        }
    }

    public static final void k7(BubbleLayout it2, Rect rect, Rect recyclerViewRect, View view) {
        kotlin.jvm.internal.f0.p(it2, "$it");
        kotlin.jvm.internal.f0.p(rect, "$rect");
        kotlin.jvm.internal.f0.p(recyclerViewRect, "$recyclerViewRect");
        kotlin.jvm.internal.f0.p(view, "$view");
        ViewGroup.LayoutParams layoutParams = it2.getLayoutParams();
        kotlin.jvm.internal.f0.n(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = (rect.top - recyclerViewRect.top) - it2.getHeight();
        layoutParams2.rightMargin = x0.g() - rect.right;
        it2.g(it2.getWidth() - (view.getWidth() / 2));
        it2.requestLayout();
        it2.invalidate();
        o5.c.b(it2, Boolean.TRUE, false, 2, null);
    }

    public static final void m7(MyGameZoneFragment this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.j7();
    }

    public static final void p7(MyGameZoneFragment this$0, LocalGameBean localGameBean, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(localGameBean, "$localGameBean");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.M6(localGameBean);
    }

    public static final void q7(DialogFragment obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        obj.I5();
    }

    public static final MyGameItem t7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (MyGameItem) tmp0.i(obj);
    }

    public static final void u7(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w7(MyGameZoneFragment this$0, GamepadInfo deviceInfo, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(deviceInfo, "$deviceInfo");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        b bVar = this$0.A8;
        if (bVar != null) {
            bVar.a(deviceInfo.getMappingMode(), 0);
        }
    }

    public static final void x7(DialogFragment obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        obj.I5();
    }

    public static final void z7(DialogFragment dialogFragment) {
        dialogFragment.I5();
        PermissionUtils.C();
    }

    public final void A7() {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_storage_permission_must_granted_for_start_game)).b(Boolean.FALSE).q(c3(R.string.device_setting_now)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.e0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.B7(dialogFragment);
            }
        }).u(U1(), "storage_permission_denied");
    }

    public final void C7(GamepadInfo gamepadInfo) {
        if (!gamepadInfo.isConnected()) {
            a7();
        }
        List<LocalGameBean> listF = Z6().g().f();
        if (listF != null) {
            p.a aVar = this.f15228v8;
            if (aVar == null) {
                kotlin.jvm.internal.f0.S("mPresenter");
                aVar = null;
            }
            com.flydigi.device_manager.ui.home.game.b.c(aVar, listF, gamepadInfo.getDeviceMode());
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        this.f15228v8 = new n0(this);
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_my_game_zone;
    }

    public final void L6(LocalGameBean localGameBean) throws JSONException {
        GamepadInfo gamepadInfo = this.f15229w8;
        if (gamepadInfo != null) {
            if (v5.d.a(X1(), localGameBean.gameMode == 0, gamepadInfo)) {
                if (localGameBean.gameMode == 1 && gamepadInfo.isFlashplayMode()) {
                    v7(gamepadInfo);
                    return;
                }
                if (!o5.d.o(X1())) {
                    h3.a.j().d(a.d.f31959o).navigation(w1());
                    return;
                }
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("packageName", localGameBean.localPackageName);
                arrayMap.put("gameName", localGameBean.name);
                arrayMap.put("gameMode", localGameBean.gameMode == 0 ? "映射模式" : "原生模式");
                u9.h.f(X1(), "Device_Game_Launch", "外设管理_启动游戏", true, arrayMap);
                v5.d.c(X1(), localGameBean.localPackageName);
                p.a aVar = this.f15228v8;
                if (aVar == null) {
                    kotlin.jvm.internal.f0.S("mPresenter");
                    aVar = null;
                }
                aVar.d(localGameBean.localPackageName);
            }
        }
    }

    @Override // eu.davidea.flexibleadapter.b.z
    public boolean M(@yt.k View view, int i10) throws JSONException {
        kotlin.jvm.internal.f0.p(view, "view");
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (hVarG2 instanceof n) {
            u9.h.c(X1(), "Device_Game_Add_Local_Game", "外设管理_添加游戏");
            T6();
            return true;
        }
        if (hVarG2 instanceof o) {
            if (view.getId() != R.id.btn_config_manage) {
                return false;
            }
            if (a5.f.i().o()) {
                h3.a.j().d(a.d.f31958n).navigation(w1());
                return false;
            }
            h3.a.j().d(a.C0378a.f31905b).navigation(w1());
            return false;
        }
        if (!(hVarG2 instanceof MyGameItem)) {
            return false;
        }
        int id2 = view.getId();
        if (id2 == R.id.btn_game_mode) {
            MyGameItem myGameItem = (MyGameItem) hVarG2;
            String str = myGameItem.z().localPackageName;
            kotlin.jvm.internal.f0.o(str, "item.data.localPackageName");
            r7(str, myGameItem.z().gameMode);
        } else if (id2 == R.id.btn_open) {
            a7();
            d7(((MyGameItem) hVarG2).z());
        } else if (id2 == R.id.btn_community) {
            Object tag = view.getTag(R.id.device_tag_article_type);
            kotlin.jvm.internal.f0.n(tag, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) tag).intValue();
            Object tag2 = view.getTag(R.id.device_tag_article_id);
            kotlin.jvm.internal.f0.n(tag2, "null cannot be cast to non-null type kotlin.String");
            n7(iIntValue, (String) tag2);
        }
        return true;
    }

    public final void M6(final LocalGameBean localGameBean) {
        x(c3(R.string.device_deleting), true);
        xi.z zVarM3 = xi.z.m3(localGameBean);
        final ik.l<LocalGameBean, z1> lVar = new ik.l<LocalGameBean, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$deleteConfig$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(LocalGameBean localGameBean2) {
                LocalGameBean localGameBean3 = localGameBean;
                String str = localGameBean3.standardPackageName;
                e6.z.E(localGameBean3.localPackageName);
                e6.z.E(str);
                Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
                kotlin.jvm.internal.f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
                ((IRemoteProvider) objNavigation).e(this.R4(), DataConstant.REMOTE_ACTION_CLEAR_GAME_SETTING, "package_name", str);
                if (localGameBean.f14331id == 0) {
                    DBManager.getInstance().deleteInstalledGame(str);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LocalGameBean localGameBean2) {
                b(localGameBean2);
                return z1.f38230a;
            }
        };
        xi.z zVarS0 = zVarM3.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.u
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.N6(lVar, obj);
            }
        }).s0(y1()).s0(o5.l.d());
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.i0
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.O6(this.f15261a, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$deleteConfig$disposable$3
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.E0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.r
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.P6(lVar2, obj);
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        h1 h1VarD = h1.d(inflater, viewGroup, false);
        kotlin.jvm.internal.f0.o(h1VarD, "inflate(inflater, container, false)");
        this.f15230x8 = h1VarD;
        if (h1VarD == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            h1VarD = null;
        }
        SmartRefreshLayout root = h1VarD.getRoot();
        kotlin.jvm.internal.f0.o(root, "viewBinding.root");
        return root;
    }

    public final m9.u Q6() {
        return (m9.u) this.f15232z8.getValue();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, eu.davidea.flexibleadapter.b.a0
    public void S(int i10) {
        ei.h hVarG2 = this.f13331r8.g2(i10);
        if (hVarG2 instanceof MyGameItem) {
            b7(((MyGameItem) hVarG2).z());
        }
    }

    @yt.l
    public final b S6() {
        return this.A8;
    }

    @Override // com.flydigi.base.common.FZFragment
    public void T5() {
        super.T5();
        ViewGroup viewGroup = this.f13325l8;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View view = this.f13325l8.getChildAt(i10);
            if (view == this.f13322i8 || view == this.f13323j8 || view == this.f13324k8) {
                kotlin.jvm.internal.f0.o(view, "view");
                o5.c.b(view, Boolean.FALSE, false, 2, null);
            } else {
                h1 h1Var = this.f15230x8;
                if (h1Var == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                    h1Var = null;
                }
                if (view == h1Var.f10085b) {
                    ((BubbleLayout) view).setVisibility(4);
                } else {
                    kotlin.jvm.internal.f0.o(view, "view");
                    o5.c.b(view, Boolean.TRUE, false, 2, null);
                }
            }
        }
    }

    public final void T6() {
        xi.z zVarM3 = xi.z.m3(u9.b.m(true));
        final MyGameZoneFragment$getLocalApps$disposable$1 myGameZoneFragment$getLocalApps$disposable$1 = new ik.l<List<PackageInfo>, xi.e0<? extends PackageInfo>>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$getLocalApps$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends PackageInfo> i(@yt.k List<PackageInfo> it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return xi.z.P2(it2);
            }
        };
        xi.z zVarL2 = zVarM3.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.home.game.w
            @Override // dj.o
            public final Object apply(Object obj) {
                return MyGameZoneFragment.U6(myGameZoneFragment$getLocalApps$disposable$1, obj);
            }
        });
        final MyGameZoneFragment$getLocalApps$disposable$2 myGameZoneFragment$getLocalApps$disposable$2 = new ik.l<PackageInfo, Boolean>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$getLocalApps$disposable$2
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.k PackageInfo it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                return Boolean.valueOf(DBManager.getInstance().getInstalledGame(it2.packageName) == null);
            }
        };
        xi.z zVarH2 = zVarL2.h2(new dj.r() { // from class: com.flydigi.device_manager.ui.home.game.y
            @Override // dj.r
            public final boolean a(Object obj) {
                return MyGameZoneFragment.V6(myGameZoneFragment$getLocalApps$disposable$2, obj);
            }
        });
        final MyGameZoneFragment$getLocalApps$disposable$3 myGameZoneFragment$getLocalApps$disposable$3 = new ik.l<PackageInfo, LocalGameBean>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$getLocalApps$disposable$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final LocalGameBean i(@yt.k PackageInfo it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                LocalGameBean localGameBean = new LocalGameBean();
                localGameBean.setLocalPackageName(it2.packageName);
                localGameBean.setStandardPackageName(it2.packageName);
                d.a aVarI = com.blankj.utilcode.util.d.i(it2.packageName);
                if (aVarI != null) {
                    localGameBean.name = aVarI.b();
                } else {
                    localGameBean.name = it2.applicationInfo.name;
                }
                return localGameBean;
            }
        };
        xi.z zVarS0 = zVarH2.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.game.x
            @Override // dj.o
            public final Object apply(Object obj) {
                return MyGameZoneFragment.W6(myGameZoneFragment$getLocalApps$disposable$3, obj);
            }
        }).Y6().v1().s0(o5.l.d());
        final ik.l<List<LocalGameBean>, z1> lVar = new ik.l<List<LocalGameBean>, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$getLocalApps$disposable$4
            {
                super(1);
            }

            public final void b(List<LocalGameBean> it2) {
                kotlin.jvm.internal.f0.o(it2, "it");
                if (!it2.isEmpty()) {
                    this.this$0.i7(it2);
                } else {
                    b.d(this.this$0);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<LocalGameBean> list) {
                b(list);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.s
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.X6(lVar, obj);
            }
        };
        final MyGameZoneFragment$getLocalApps$disposable$5 myGameZoneFragment$getLocalApps$disposable$5 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$getLocalApps$disposable$5
            public final void b(Throwable th2) {
                String message = th2.getMessage();
                if (message != null) {
                    com.flydigi.base.common.o.E(message);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.t
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.Y6(myGameZoneFragment$getLocalApps$disposable$5, obj);
            }
        });
    }

    public final InstalledGameViewModel Z6() {
        return (InstalledGameViewModel) this.f15231y8.getValue();
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        a7();
        super.a4();
    }

    public final void a7() {
        h1 h1Var = this.f15230x8;
        if (h1Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            h1Var = null;
        }
        h1Var.f10085b.setVisibility(4);
    }

    public final void b7(LocalGameBean localGameBean) {
        androidx.fragment.app.g gVarP4 = P4();
        kotlin.jvm.internal.f0.o(gVarP4, "requireActivity()");
        if (n5.c.c(gVarP4)) {
            if (localGameBean != null) {
                o7(localGameBean);
            }
        } else {
            androidx.activity.result.g<Intent> gVar = this.B8;
            StoragePermissionRequestActivity.a aVar = StoragePermissionRequestActivity.f13377k0;
            Context contextR4 = R4();
            kotlin.jvm.internal.f0.o(contextR4, "requireContext()");
            gVar.b(StoragePermissionRequestActivity.a.b(aVar, contextR4, null, 2, null));
        }
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment
    public int c6() {
        return Integer.MAX_VALUE;
    }

    public final void d7(LocalGameBean localGameBean) throws JSONException {
        androidx.fragment.app.g gVarP4 = P4();
        kotlin.jvm.internal.f0.o(gVarP4, "requireActivity()");
        if (!n5.c.c(gVarP4)) {
            this.C8.b(new Intent(P4(), (Class<?>) StoragePermissionRequestActivity.class));
        } else if (localGameBean != null) {
            L6(localGameBean);
        }
    }

    @Override // com.flydigi.device_manager.ui.home.game.p.b
    public void f0(@yt.k List<ArticleForGame> articleForGames) {
        int i10;
        kotlin.jvm.internal.f0.p(articleForGames, "articleForGames");
        if (!articleForGames.isEmpty()) {
            int size = articleForGames.size();
            for (int i11 = 0; i11 < size; i11++) {
                ArticleForGame articleForGame = articleForGames.get(i11);
                int itemCount = this.f13331r8.getItemCount();
                if (itemCount >= 0) {
                    while (true) {
                        ei.h hVarG2 = this.f13331r8.g2(i10);
                        if (hVarG2 instanceof MyGameItem) {
                            MyGameItem myGameItem = (MyGameItem) hVarG2;
                            if (com.blankj.utilcode.util.n0.b(myGameItem.z().standardPackageName, articleForGame.getPkgname())) {
                                myGameItem.D(articleForGame);
                                this.f13331r8.M4(hVarG2, articleForGame);
                            }
                        }
                        i10 = i10 != itemCount ? i10 + 1 : 0;
                    }
                }
            }
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void g4(@yt.k Bundle outState) {
        kotlin.jvm.internal.f0.p(outState, "outState");
        super.g4(outState);
        outState.putParcelable("key_device_info", this.f15229w8);
    }

    public final void h7(@yt.l b bVar) {
        this.A8 = bVar;
    }

    public final void i7(List<? extends LocalGameBean> list) {
        o5.a.t0(L2(), GameSelectBottomSheetDialog.F8.a(new ArrayList<>(list)));
    }

    @Override // com.flydigi.base.common.FZRecyclerViewFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        Q6().h().k(l3(), new c(new ik.l<GamepadInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(GamepadInfo it2) {
                if (com.blankj.utilcode.util.n0.b(this.this$0.f15229w8, it2)) {
                    return;
                }
                this.this$0.f15229w8 = it2;
                MyGameZoneFragment myGameZoneFragment = this.this$0;
                kotlin.jvm.internal.f0.o(it2, "it");
                myGameZoneFragment.C7(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(GamepadInfo gamepadInfo) {
                b(gamepadInfo);
                return z1.f38230a;
            }
        }));
        Z6().g().k(l3(), new c(new ik.l<List<? extends LocalGameBean>, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$onViewCreated$2
            {
                super(1);
            }

            public final void b(List<? extends LocalGameBean> it2) {
                MyGameZoneFragment myGameZoneFragment = this.this$0;
                kotlin.jvm.internal.f0.o(it2, "it");
                myGameZoneFragment.s7(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<? extends LocalGameBean> list) {
                b(list);
                return z1.f38230a;
            }
        }));
    }

    public final void j7() {
        final View viewFindViewById;
        RecyclerView.e0 e0VarG0 = this.f13330q8.g0(1);
        if (e0VarG0 == null || (viewFindViewById = e0VarG0.itemView.findViewById(R.id.btn_open)) == null) {
            return;
        }
        final Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Rect rect2 = new Rect();
        this.f13330q8.getGlobalVisibleRect(rect2);
        o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_MAIN_DEVICE_GUIDE, true);
        h1 h1Var = this.f15230x8;
        if (h1Var == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            h1Var = null;
        }
        final BubbleLayout bubbleLayout = h1Var.f10085b;
        bubbleLayout.post(new Runnable() { // from class: com.flydigi.device_manager.ui.home.game.z
            @Override // java.lang.Runnable
            public final void run() {
                MyGameZoneFragment.k7(bubbleLayout, rect, rect2, viewFindViewById);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l7() {
        /*
            r6 = this;
            boolean r0 = r6.C3()
            if (r0 == 0) goto L8f
            boolean r0 = r6.A3()
            if (r0 != 0) goto Le
            goto L8f
        Le:
            java.lang.String r0 = "sp_app"
            o5.m r0 = o5.m.k(r0)
            java.lang.String r1 = "device_guide_start_game"
            r2 = 0
            boolean r0 = r0.f(r1, r2)
            if (r0 == 0) goto L1e
            return
        L1e:
            eu.davidea.flexibleadapter.b r0 = r6.f13331r8
            int r0 = r0.l2()
            if (r0 != 0) goto L27
            return
        L27:
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.f15229w8
            r1 = 1
            if (r0 == 0) goto L34
            boolean r0 = r0.isConnected()
            if (r0 != r1) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 != 0) goto L38
            return
        L38:
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.f15229w8
            if (r0 == 0) goto L62
            java.lang.String r0 = r0.getDeviceName()
            if (r0 == 0) goto L62
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r4 = "getDefault()"
            kotlin.jvm.internal.f0.o(r3, r4)
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.f0.o(r0, r3)
            if (r0 == 0) goto L62
            r3 = 2
            r4 = 0
            java.lang.String r5 = "-i"
            boolean r0 = kotlin.text.u.K1(r0, r5, r2, r3, r4)
            if (r0 != r1) goto L62
            r0 = 1
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 == 0) goto L66
            return
        L66:
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.f15229w8
            if (r0 == 0) goto L72
            boolean r0 = r0.isDriverMode()
            if (r0 != r1) goto L72
            r0 = 1
            goto L73
        L72:
            r0 = 0
        L73:
            if (r0 == 0) goto L83
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r6.f15229w8
            if (r0 == 0) goto L80
            boolean r0 = r0.isDriverConnected()
            if (r0 != 0) goto L80
            r2 = 1
        L80:
            if (r2 == 0) goto L83
            return
        L83:
            androidx.recyclerview.widget.RecyclerView r0 = r6.f13330q8
            if (r0 == 0) goto L8f
            com.flydigi.device_manager.ui.home.game.a0 r1 = new com.flydigi.device_manager.ui.home.game.a0
            r1.<init>()
            r0.post(r1)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment.l7():void");
    }

    public final void n7(int i10, String str) throws JSONException {
        u9.h.e(X1(), "Device_Game_Community", "外设管理_话题", false);
        if (i10 == 1) {
            h3.a.j().d(a.b.f31918c).withInt(a.b.f31930o, Integer.parseInt(str)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
        } else if (i10 == 2) {
            h3.a.j().d(a.b.f31919d).withInt("id", Integer.parseInt(str)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13284b).navigation();
        } else {
            if (i10 != 3) {
                return;
            }
            h3.a.j().d(a.b.f31921f).withString(DataConstant.COMMUNITY_KEY_SEARCH_KEYWORD, str).navigation();
        }
    }

    public final void o7(final LocalGameBean localGameBean) {
        new FZDialog.a().t(c3(R.string.device_delete_config)).j(c3(R.string.device_delete_local_game_config)).d(c3(R.string.cancel)).g(c3(R.string.confirm)).b(Boolean.TRUE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.c0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.p7(this.f15247a, localGameBean, dialogFragment);
            }
        }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.g0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.q7(dialogFragment);
            }
        }).u(L2(), "delete");
    }

    public final void r7(String str, int i10) {
        GameModeChooseFragment gameModeChooseFragmentA = GameModeChooseFragment.I8.a(str, i10);
        gameModeChooseFragmentA.t6(new d());
        o5.a.t0(L2(), gameModeChooseFragmentA);
    }

    public final void s7(final List<? extends LocalGameBean> list) {
        xi.z zVarP2 = xi.z.P2(list);
        final MyGameZoneFragment$showLocalGame$disposable$1 myGameZoneFragment$showLocalGame$disposable$1 = MyGameZoneFragment$showLocalGame$disposable$1.f15239c;
        xi.z zVarS0 = zVarP2.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.game.v
            @Override // dj.o
            public final Object apply(Object obj) {
                return MyGameZoneFragment.t7(myGameZoneFragment$showLocalGame$disposable$1, obj);
            }
        }).Y6().v1().s0(o5.l.d());
        final ik.l<List<MyGameItem>, z1> lVar = new ik.l<List<MyGameItem>, z1>() { // from class: com.flydigi.device_manager.ui.home.game.MyGameZoneFragment$showLocalGame$disposable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(List<MyGameItem> list2) {
                this.this$0.f13331r8.I4(list2);
                this.this$0.f13331r8.B3();
                this.this$0.f13331r8.A3();
                this.this$0.f13331r8.S0(new o());
                this.this$0.f13331r8.Q0(new n());
                if (list2.size() <= 0) {
                    this.this$0.T5();
                    return;
                }
                p.a aVar = this.this$0.f15228v8;
                if (aVar == null) {
                    kotlin.jvm.internal.f0.S("mPresenter");
                    aVar = null;
                }
                List<LocalGameBean> list3 = list;
                GamepadInfo gamepadInfo = this.this$0.f15229w8;
                b.c(aVar, list3, gamepadInfo != null ? gamepadInfo.getDeviceMode() : -1);
                this.this$0.l7();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<MyGameItem> list2) {
                b(list2);
                return z1.f38230a;
            }
        };
        zVarS0.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.j0
            @Override // dj.g
            public final void accept(Object obj) {
                MyGameZoneFragment.u7(lVar, obj);
            }
        });
    }

    public final void v7(final GamepadInfo gamepadInfo) {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_game_gamepad_native_mode_need_tradition_mode)).d(c3(R.string.cancel)).g(c3(R.string.device_change)).b(Boolean.FALSE).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.d0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.w7(this.f15250a, gamepadInfo, dialogFragment);
            }
        }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.f0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.x7(dialogFragment);
            }
        }).u(L2(), "needSwitchMappingModeDialog");
    }

    @Override // eu.davidea.flexibleadapter.b.s
    public void y0(int i10, int i11) {
    }

    public final void y7() {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_storage_permission_must_granted_for_manager_game_config)).q(c3(R.string.device_setting_now)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.h0
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                MyGameZoneFragment.z7(dialogFragment);
            }
        }).u(U1(), "storage_permission_denied");
    }
}
