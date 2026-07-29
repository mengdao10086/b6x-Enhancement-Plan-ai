package com.flydigi.device_manager.ui.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z0;
import c7.q1;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.base.widget.FZDialogV2;
import com.flydigi.data.bean.CloudConfigBean;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.EntitySimpleConfig;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.sync.SyncConfigFragment;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import eu.davidea.flexibleadapter.b;
import i9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.z1;
import p1.a;
import t7.c;

/* JADX INFO: loaded from: classes7.dex */
@kotlin.jvm.internal.t0({"SMAP\nSyncConfigFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyncConfigFragment.kt\ncom/flydigi/device_manager/ui/sync/SyncConfigFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,545:1\n106#2,15:546\n1559#3:561\n1590#3,4:562\n*S KotlinDebug\n*F\n+ 1 SyncConfigFragment.kt\ncom/flydigi/device_manager/ui/sync/SyncConfigFragment\n*L\n43#1:546,15\n389#1:561\n389#1:562,4\n*E\n"})
public final class SyncConfigFragment extends FZFragment {

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public static final a f15397y8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.l
    public q1 f15398o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final kotlin.z f15399p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public b f15400q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.k
    public eu.davidea.flexibleadapter.b<GameItem> f15401r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<LocalConfigItem> f15402s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public final eu.davidea.flexibleadapter.b<CloudConfigItem> f15403t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public boolean f15404u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public boolean f15405v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f15406w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.k
    public final c f15407x8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ SyncConfigFragment b(a aVar, Boolean bool, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                bool = Boolean.FALSE;
            }
            return aVar.a(bool);
        }

        @hk.m
        @yt.k
        public final SyncConfigFragment a(@yt.l Boolean bool) {
            SyncConfigFragment syncConfigFragment = new SyncConfigFragment();
            syncConfigFragment.c5(androidx.core.os.e.b(new Pair(a.d.f31963s, bool)));
            return syncConfigFragment;
        }
    }

    public interface b {
        void w2(@yt.k String str, @yt.k String str2);
    }

    public static final class c implements androidx.core.view.a0 {
        public c() {
        }

        @Override // androidx.core.view.a0
        public boolean a(@yt.k MenuItem menuItem) {
            kotlin.jvm.internal.f0.p(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_download) {
                return false;
            }
            SyncConfigFragment.this.l7();
            return true;
        }

        @Override // androidx.core.view.a0
        public /* synthetic */ void b(Menu menu) {
            androidx.core.view.z.a(this, menu);
        }

        @Override // androidx.core.view.a0
        public void c(@yt.k Menu menu, @yt.k MenuInflater menuInflater) {
            kotlin.jvm.internal.f0.p(menu, "menu");
            kotlin.jvm.internal.f0.p(menuInflater, "menuInflater");
            menuInflater.inflate(R.menu.device_menu_sync_config, menu);
        }

        @Override // androidx.core.view.a0
        public /* synthetic */ void d(Menu menu) {
            androidx.core.view.z.b(this, menu);
        }
    }

    public static final class d implements b.z {
        public d() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.l View view, int i10) {
            SyncConfigFragment.this.f15401r8.M(i10);
            SyncConfigFragment.this.L6().i1(i10);
            return true;
        }
    }

    public static final class e implements b.z {
        public e() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            kotlin.jvm.internal.f0.p(view, "view");
            if (view.getId() == R.id.iv_rename) {
                SyncConfigFragment.this.j7(i10);
            } else if (view.getId() == R.id.iv_upload_download) {
                SyncConfigFragment.this.q7(new int[]{i10});
            } else if (view.getId() == R.id.iv_delete) {
                SyncConfigFragment.this.c7(false, new int[]{i10});
            } else if (SyncConfigFragment.this.f15404u8) {
                SyncConfigFragment syncConfigFragment = SyncConfigFragment.this;
                syncConfigFragment.x(syncConfigFragment.c3(R.string.device_uploading), false);
                SyncConfigFragment.this.L6().p1(i10);
            } else {
                SyncConfigFragment.this.f15402s8.M(i10);
            }
            return true;
        }
    }

    public static final class f implements b.z {
        public f() {
        }

        @Override // eu.davidea.flexibleadapter.b.z
        public boolean M(@yt.k View view, int i10) {
            CloudConfigBean cloudConfigBeanZ;
            kotlin.jvm.internal.f0.p(view, "view");
            int id2 = view.getId();
            if (id2 == R.id.iv_upload_download) {
                SyncConfigFragment.this.e7(new int[]{i10});
            } else if (id2 == R.id.iv_delete) {
                SyncConfigFragment.this.c7(true, new int[]{i10});
            } else if (SyncConfigFragment.this.f15404u8) {
                CloudConfigItem cloudConfigItem = (CloudConfigItem) SyncConfigFragment.this.f15403t8.g2(i10);
                if (cloudConfigItem != null && (cloudConfigBeanZ = cloudConfigItem.z()) != null) {
                    SyncConfigFragment syncConfigFragment = SyncConfigFragment.this;
                    ConfigBean configBean = new ConfigBean();
                    configBean.setId(cloudConfigBeanZ.f14326id);
                    configBean.setTitle(cloudConfigBeanZ.title);
                    configBean.setManufacturer(com.blankj.utilcode.util.x.j());
                    configBean.setModel(com.blankj.utilcode.util.x.k());
                    LocalGameBean localGameBeanF = syncConfigFragment.L6().G0().f();
                    configBean.setPackageName(localGameBeanF != null ? localGameBeanF.localPackageName : null);
                    LocalGameBean localGameBeanF2 = syncConfigFragment.L6().G0().f();
                    configBean.setGameName(localGameBeanF2 != null ? localGameBeanF2.name : null);
                    configBean.setDeviceName(cloudConfigBeanZ.deviceCode);
                    configBean.setDeviceType(cloudConfigBeanZ.version);
                    syncConfigFragment.Z6(configBean);
                }
            } else {
                SyncConfigFragment.this.f15403t8.M(i10);
            }
            return true;
        }
    }

    public static final class g implements androidx.lifecycle.k0, kotlin.jvm.internal.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15412a;

        public g(ik.l function) {
            kotlin.jvm.internal.f0.p(function, "function");
            this.f15412a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15412a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15412a.i(obj);
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

    public SyncConfigFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$special$$inlined$viewModels$default$1
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
        final kotlin.z zVarC = kotlin.b0.c(LazyThreadSafetyMode.NONE, new ik.a<androidx.lifecycle.d1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.d1 o() {
                return (androidx.lifecycle.d1) aVar.o();
            }
        });
        final ik.a aVar2 = null;
        this.f15399p8 = FragmentViewModelLazyKt.h(this, kotlin.jvm.internal.n0.d(SyncConfigViewModel.class), new ik.a<androidx.lifecycle.c1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final androidx.lifecycle.c1 o() {
                androidx.lifecycle.c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                kotlin.jvm.internal.f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$special$$inlined$viewModels$default$4
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
                androidx.lifecycle.d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0;
                androidx.lifecycle.d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
                if (rVar == null || (bVarH0 = rVar.h0()) == null) {
                    bVarH0 = this.h0();
                }
                kotlin.jvm.internal.f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
        this.f15401r8 = new eu.davidea.flexibleadapter.b<>(CollectionsKt__CollectionsKt.E());
        this.f15402s8 = new eu.davidea.flexibleadapter.b<>(CollectionsKt__CollectionsKt.E());
        this.f15403t8 = new eu.davidea.flexibleadapter.b<>(CollectionsKt__CollectionsKt.E());
        this.f15407x8 = new c();
    }

    public static final void N6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15402s8.T2()) {
            ToastUtils.P(R.string.device_config_cloud_sync_no_local_config);
        } else {
            this$0.h7(true);
        }
    }

    public static final void O6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.f15402s8.H(new Integer[0]);
    }

    public static final void P6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15403t8.u() <= 0) {
            ToastUtils.P(R.string.device_config_cloud_sync_choose_config);
            return;
        }
        List<Integer> listV = this$0.f15403t8.v();
        kotlin.jvm.internal.f0.o(listV, "mAdapterCloud.selectedPositions");
        this$0.c7(true, CollectionsKt___CollectionsKt.P5(listV));
    }

    public static final void Q6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.i7(!this$0.f15405v8);
    }

    public static final void R6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15402s8.u() <= 0) {
            ToastUtils.P(R.string.device_config_cloud_sync_choose_config);
            return;
        }
        List<Integer> listV = this$0.f15402s8.v();
        kotlin.jvm.internal.f0.o(listV, "mAdapterLocal.selectedPositions");
        this$0.q7(CollectionsKt___CollectionsKt.P5(listV));
    }

    public static final void S6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15402s8.u() <= 0) {
            ToastUtils.P(R.string.device_config_cloud_sync_choose_config);
            return;
        }
        List<Integer> listV = this$0.f15402s8.v();
        kotlin.jvm.internal.f0.o(listV, "mAdapterLocal.selectedPositions");
        this$0.c7(false, CollectionsKt___CollectionsKt.P5(listV));
    }

    public static final void T6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15403t8.T2()) {
            ToastUtils.P(R.string.device_config_cloud_sync_no_cloud_config);
        } else {
            this$0.a7(true);
        }
    }

    public static final void U6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.f15403t8.H(new Integer[0]);
    }

    public static final void V6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.b7(!this$0.f15406w8);
    }

    public static final void W6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.x(this$0.c3(R.string.loading), false);
        this$0.L6().f1();
    }

    public static final void X6(SyncConfigFragment this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        if (this$0.f15403t8.u() <= 0) {
            ToastUtils.P(R.string.device_config_cloud_sync_choose_config);
            return;
        }
        List<Integer> listV = this$0.f15403t8.v();
        kotlin.jvm.internal.f0.o(listV, "mAdapterCloud.selectedPositions");
        this$0.e7(CollectionsKt___CollectionsKt.P5(listV));
    }

    @hk.m
    @yt.k
    public static final SyncConfigFragment Y6(@yt.l Boolean bool) {
        return f15397y8.a(bool);
    }

    public static final void d7(boolean z10, SyncConfigFragment this$0, int[] position, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(position, "$position");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        if (z10) {
            this$0.x(this$0.c3(R.string.device_deleting), false);
            this$0.L6().f0(position);
        } else {
            this$0.L6().i0(position);
            if (position.length == 1) {
                this$0.f15402s8.notifyItemChanged(position[0]);
            }
        }
    }

    public static final void f7(List conflictTitles, SyncConfigFragment this$0, int[] selectedPositions, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(conflictTitles, "$conflictTitles");
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(selectedPositions, "$selectedPositions");
        dialogFragment.I5();
        if (!conflictTitles.isEmpty()) {
            this$0.x(this$0.c3(R.string.downloading), false);
            this$0.L6().v0(selectedPositions, false);
        }
    }

    public static final void g7(SyncConfigFragment this$0, int[] selectedPositions, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(selectedPositions, "$selectedPositions");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.x(this$0.c3(R.string.downloading), false);
        this$0.L6().v0(selectedPositions, true);
    }

    public static final void k7(SyncConfigFragment this$0, int i10, t7.c this_apply, String content, androidx.appcompat.app.j jVar) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(this_apply, "$this_apply");
        kotlin.jvm.internal.f0.p(content, "content");
        kotlin.jvm.internal.f0.p(jVar, "<anonymous parameter 1>");
        if (content.length() < 2) {
            com.flydigi.base.common.o.E(this$0.c3(R.string.device_config_cloud_sync_config_name_atleast_length_2));
            return;
        }
        if (content.length() > 10) {
            com.flydigi.base.common.o.E(this$0.c3(R.string.device_config_cloud_sync_config_name_almost_length_10));
            return;
        }
        if (this$0.L6().a0(false, i10, content)) {
            ToastUtils.S(this$0.c3(R.string.device_config_cloud_sync_config_name_conflict), new Object[0]);
            return;
        }
        this_apply.dismiss();
        this$0.f15402s8.notifyItemChanged(i10);
        this$0.x("", false);
        this$0.L6().U0(false, i10, content);
    }

    public static final void m7(SyncConfigFragment this$0, String content, androidx.appcompat.app.j dialog) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(content, "content");
        kotlin.jvm.internal.f0.p(dialog, "dialog");
        if (com.blankj.utilcode.util.n0.m(content)) {
            ToastUtils.T(R.string.floatview_config_manager_download_code_empty);
            return;
        }
        dialog.dismiss();
        this$0.x(this$0.c3(R.string.downloading), false);
        this$0.L6().o0(content);
    }

    public static final void o7(SyncConfigFragment this$0, CFGEntityList newCfgEntityList, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(newCfgEntityList, "$newCfgEntityList");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.x(this$0.c3(R.string.downloading), false);
        this$0.L6().b1(newCfgEntityList, true);
    }

    public static final void p7(SyncConfigFragment this$0, CFGEntityList newCfgEntityList, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(newCfgEntityList, "$newCfgEntityList");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.x(this$0.c3(R.string.downloading), false);
        this$0.L6().b1(newCfgEntityList, false);
    }

    public static final void r7(SyncConfigFragment this$0, int[] selectedPositions, DialogFragment dialogFragment) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(selectedPositions, "$selectedPositions");
        kotlin.jvm.internal.f0.p(dialogFragment, "dialogFragment");
        dialogFragment.I5();
        this$0.x(this$0.c3(R.string.device_uploading), false);
        this$0.L6().j1(selectedPositions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f15400q8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        this.f15404u8 = bundleT1 != null ? bundleT1.getBoolean(a.d.f31963s) : false;
    }

    public final q1 K6() {
        q1 q1Var = this.f15398o8;
        kotlin.jvm.internal.f0.m(q1Var);
        return q1Var;
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_sync_config;
    }

    public final SyncConfigViewModel L6() {
        return (SyncConfigViewModel) this.f15399p8.getValue();
    }

    public final void M6() {
        com.blankj.utilcode.util.o.r(K6().f10366d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.N6(this.f15440a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10378p, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.O6(this.f15485a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10376n, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.Q6(this.f15481a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10379q, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.R6(this.f15491a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10377o, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.S6(this.f15443a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10364b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.T6(this.f15493a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10374l, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.U6(this.f15479a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10372j, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.V6(this.f15483a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10375m, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.W6(this.f15487a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10371i, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.X6(this.f15489a, view);
            }
        });
        com.blankj.utilcode.util.o.r(K6().f10373k, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.sync.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SyncConfigFragment.P6(this.f15495a, view);
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        this.f15398o8 = q1.d(inflater, viewGroup, false);
        LinearLayout linearLayoutB = K6().getRoot();
        kotlin.jvm.internal.f0.o(linearLayoutB, "binding.root");
        return linearLayoutB;
    }

    public final void Z6(ConfigBean configBean) {
        androidx.fragment.app.g gVarW1 = w1();
        if (gVarW1 != null) {
            Intent intent = new Intent();
            intent.putExtra("key_result_data", configBean);
            gVarW1.setResult(-1, intent);
            gVarW1.finish();
        }
    }

    public final void a7(boolean z10) {
        LinearLayout linearLayout = K6().f10364b;
        kotlin.jvm.internal.f0.o(linearLayout, "binding.llCloudConfig");
        o5.c.b(linearLayout, Boolean.valueOf(!z10), false, 2, null);
        LinearLayout linearLayout2 = K6().f10365c;
        kotlin.jvm.internal.f0.o(linearLayout2, "binding.llCloudConfigDetail");
        o5.c.b(linearLayout2, Boolean.valueOf(z10), false, 2, null);
        if (z10) {
            h7(false);
        } else {
            b7(false);
        }
    }

    public final void b7(boolean z10) {
        this.f15406w8 = z10;
        TextView textView = K6().f10375m;
        kotlin.jvm.internal.f0.o(textView, "binding.tvCloudShare");
        o5.c.b(textView, Boolean.valueOf(!z10), false, 2, null);
        TextView textView2 = K6().f10371i;
        kotlin.jvm.internal.f0.o(textView2, "binding.tvCloudDown");
        o5.c.b(textView2, Boolean.valueOf(z10), false, 2, null);
        TextView textView3 = K6().f10373k;
        kotlin.jvm.internal.f0.o(textView3, "binding.tvCloudRemove");
        o5.c.b(textView3, Boolean.valueOf(z10), false, 2, null);
        TextView textView4 = K6().f10374l;
        kotlin.jvm.internal.f0.o(textView4, "binding.tvCloudSelectAll");
        o5.c.b(textView4, Boolean.valueOf(z10), false, 2, null);
        K6().f10372j.setText(z10 ? R.string.cancel : R.string.edit);
        this.f15403t8.J(z10 ? 2 : 0);
        this.f15403t8.n();
        eu.davidea.flexibleadapter.b<CloudConfigItem> bVar = this.f15403t8;
        bVar.notifyItemRangeChanged(0, bVar.l2());
    }

    public final void c7(final boolean z10, final int[] iArr) {
        new FZDialog.a().t(c3(R.string.device_config_cloud_sync_delete_config_title)).j(c3(R.string.device_config_cloud_sync_delete_config_content)).d(c3(R.string.cancel)).g(c3(R.string.confirm)).c(b6.c.f9082a).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.sync.g
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.d7(z10, this, iArr, dialogFragment);
            }
        }).a().Z5(L2(), "delete");
    }

    public final void e7(final int[] iArr) {
        final List<String> listE0 = L6().E0(true, iArr);
        FZDialog.a aVarF = new FZDialog.a().d(c3(true ^ listE0.isEmpty() ? R.string.floatview_config_manager_download_config_conflict_with_local_ignore : R.string.cancel)).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.sync.f
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.f7(listE0, this, iArr, dialogFragment);
            }
        }).g(c3(R.string.download)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.sync.e
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.g7(this.f15450a, iArr, dialogFragment);
            }
        });
        if (listE0.isEmpty()) {
            aVarF.t(c3(R.string.device_config_cloud_sync_download_cloud_config_title)).j(c3(R.string.device_config_cloud_sync_download_cloud_config_content));
        } else {
            aVarF.t(c3(R.string.device_config_cloud_sync_name_conflict_local_title)).j(c3(R.string.floatview_config_manager_download_config_conflict_with_local));
        }
        aVarF.a().Z5(L2(), "download");
    }

    public final void h7(boolean z10) {
        LinearLayout linearLayout = K6().f10366d;
        kotlin.jvm.internal.f0.o(linearLayout, "binding.llLocalConfig");
        o5.c.b(linearLayout, Boolean.valueOf(!z10), false, 2, null);
        LinearLayout linearLayout2 = K6().f10367e;
        kotlin.jvm.internal.f0.o(linearLayout2, "binding.llLocalConfigDetail");
        o5.c.b(linearLayout2, Boolean.valueOf(z10), false, 2, null);
        if (z10) {
            a7(false);
        } else {
            i7(false);
        }
    }

    public final void i7(boolean z10) {
        this.f15405v8 = z10;
        TextView textView = K6().f10377o;
        kotlin.jvm.internal.f0.o(textView, "binding.tvLocalRemove");
        o5.c.b(textView, Boolean.valueOf(z10), false, 2, null);
        TextView textView2 = K6().f10379q;
        kotlin.jvm.internal.f0.o(textView2, "binding.tvLocalUpload");
        o5.c.b(textView2, Boolean.valueOf(z10), false, 2, null);
        TextView textView3 = K6().f10378p;
        kotlin.jvm.internal.f0.o(textView3, "binding.tvLocalSelectAll");
        o5.c.b(textView3, Boolean.valueOf(z10), false, 2, null);
        K6().f10376n.setText(z10 ? R.string.cancel : R.string.edit);
        this.f15402s8.J(z10 ? 2 : 0);
        this.f15402s8.n();
        eu.davidea.flexibleadapter.b<LocalConfigItem> bVar = this.f15402s8;
        bVar.notifyItemRangeChanged(0, bVar.l2());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(view, "view");
        super.j4(view, bundle);
        P4().n2(this.f15407x8);
        this.f15401r8.J(1);
        K6().f10369g.setAdapter(this.f15401r8);
        this.f15401r8.P0(new d());
        this.f15402s8.P0(new e());
        K6().f10370h.n(new xd.a(R4(), 1));
        K6().f10370h.setHasFixedSize(true);
        K6().f10370h.setAdapter(this.f15402s8);
        this.f15402s8.J(this.f15404u8 ? 1 : 0);
        K6().f10368f.setAdapter(this.f15403t8);
        this.f15403t8.J(this.f15404u8 ? 1 : 0);
        this.f15403t8.P0(new f());
        K6().f10368f.setHasFixedSize(true);
        K6().f10368f.n(new xd.a(R4(), 1));
        M6();
        L6().K0().k(l3(), new g(new ik.l<List<? extends LocalGameBean>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$4
            {
                super(1);
            }

            public final void b(List<? extends LocalGameBean> it2) {
                kotlin.jvm.internal.f0.o(it2, "it");
                if (!it2.isEmpty()) {
                    ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(it2, 10));
                    Iterator<T> it3 = it2.iterator();
                    while (it3.hasNext()) {
                        arrayList.add(new GameItem((LocalGameBean) it3.next()));
                    }
                    this.this$0.f15401r8.I4(arrayList);
                    this.this$0.f15401r8.M(0);
                    this.this$0.L6().i1(0);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<? extends LocalGameBean> list) {
                b(list);
                return z1.f38230a;
            }
        }));
        L6().L0().k(l3(), new g(new ik.l<ArrayList<EntitySimpleConfig>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$5
            {
                super(1);
            }

            public final void b(ArrayList<EntitySimpleConfig> it2) {
                if (it2.isEmpty()) {
                    this.this$0.h7(false);
                } else {
                    this.this$0.i7(false);
                }
                kotlin.jvm.internal.f0.o(it2, "it");
                ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(it2, 10));
                Iterator<T> it3 = it2.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new LocalConfigItem((EntitySimpleConfig) it3.next(), false, 2, null));
                }
                this.this$0.f15402s8.I4(arrayList);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<EntitySimpleConfig> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        }));
        L6().F0().k(l3(), new g(new ik.l<List<? extends CloudConfigBean>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$6
            {
                super(1);
            }

            public final void b(List<? extends CloudConfigBean> it2) {
                if (it2.isEmpty()) {
                    this.this$0.a7(false);
                }
                kotlin.jvm.internal.f0.o(it2, "it");
                ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(it2, 10));
                Iterator<T> it3 = it2.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new CloudConfigItem((CloudConfigBean) it3.next(), false, 2, null));
                }
                this.this$0.f15403t8.I4(arrayList);
                z1 z1Var = z1.f38230a;
                this.this$0.f15403t8.n();
                this.this$0.b7(false);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(List<? extends CloudConfigBean> list) {
                b(list);
                return z1.f38230a;
            }
        }));
        L6().R0().k(l3(), new g(new ik.l<Pair<? extends LocalGameBean, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$7
            {
                super(1);
            }

            public final void b(Pair<? extends LocalGameBean, String> pair) {
                this.this$0.E0();
                if (!(pair.h().length() == 0)) {
                    ToastUtils.S(pair.h(), new Object[0]);
                    return;
                }
                this.this$0.P4().F(this.this$0.f15407x8);
                SyncConfigFragment.b bVar = this.this$0.f15400q8;
                if (bVar == null) {
                    kotlin.jvm.internal.f0.S("listener");
                    bVar = null;
                }
                String str = pair.f().name;
                kotlin.jvm.internal.f0.o(str, "it.first.name");
                String str2 = pair.f().shareCode;
                kotlin.jvm.internal.f0.o(str2, "it.first.shareCode");
                bVar.w2(str, str2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends LocalGameBean, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
        L6().H0().k(l3(), new g(new ik.l<Pair<? extends Boolean, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$8
            {
                super(1);
            }

            public final void b(Pair<Boolean, String> pair) {
                this.this$0.E0();
                ToastUtils.P(pair.f().booleanValue() ? R.string.device_config_cloud_sync_delete_success : R.string.device_config_cloud_sync_delete_failed_);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends Boolean, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
        L6().Q0().k(l3(), new g(new ik.l<Pair<? extends Boolean, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$9
            {
                super(1);
            }

            public final void b(Pair<Boolean, String> pair) {
                this.this$0.E0();
                if (pair.f().booleanValue()) {
                    return;
                }
                ToastUtils.S(this.this$0.c3(R.string.device_config_cloud_sync_config_name_conflict), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends Boolean, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
        L6().T0().k(l3(), new g(new ik.l<Pair<? extends Boolean, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$10
            {
                super(1);
            }

            public final void b(Pair<Boolean, String> pair) {
                this.this$0.E0();
                if (pair.f().booleanValue()) {
                    this.this$0.a7(true);
                } else {
                    ToastUtils.S(this.this$0.c3(R.string.device_config_cloud_sync_upload_failed_retry), new Object[0]);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends Boolean, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
        L6().I0().k(l3(), new g(new ik.l<Pair<? extends Boolean, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$11
            {
                super(1);
            }

            public final void b(Pair<Boolean, String> pair) {
                this.this$0.E0();
                if (pair.f().booleanValue()) {
                    this.this$0.h7(true);
                } else {
                    ToastUtils.S(this.this$0.c3(R.string.device_config_cloud_sync_config_download_failed), new Object[0]);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends Boolean, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
        L6().S0().k(l3(), new g(new ik.l<ConfigBean, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$12
            {
                super(1);
            }

            public final void b(@yt.l ConfigBean configBean) {
                z1 z1Var;
                this.this$0.E0();
                if (configBean != null) {
                    this.this$0.Z6(configBean);
                    z1Var = z1.f38230a;
                } else {
                    z1Var = null;
                }
                if (z1Var == null) {
                    ToastUtils.P(R.string.device_config_cloud_sync_upload_failed_retry);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ConfigBean configBean) {
                b(configBean);
                return z1.f38230a;
            }
        }));
        L6().J0().k(l3(), new g(new ik.l<Pair<? extends CFGEntityList, ? extends String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigFragment$onViewCreated$13
            {
                super(1);
            }

            public final void b(Pair<? extends CFGEntityList, String> pair) {
                this.this$0.E0();
                z1 z1Var = null;
                if (com.blankj.utilcode.util.n0.x(pair.h())) {
                    CFGEntityList cFGEntityListF = pair.f();
                    if (cFGEntityListF != null) {
                        this.this$0.n7(cFGEntityListF);
                        z1Var = z1.f38230a;
                    }
                    if (z1Var == null) {
                        ToastUtils.S(pair.h(), new Object[0]);
                        return;
                    }
                    return;
                }
                CFGEntityList cFGEntityListF2 = pair.f();
                if (cFGEntityListF2 != null) {
                    this.this$0.L6().b0(cFGEntityListF2);
                    z1Var = z1.f38230a;
                }
                if (z1Var == null) {
                    ToastUtils.P(R.string.device_config_cloud_sync_config_download_failed);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Pair<? extends CFGEntityList, ? extends String> pair) {
                b(pair);
                return z1.f38230a;
            }
        }));
    }

    public final void j7(final int i10) {
        EntitySimpleConfig entitySimpleConfigZ;
        Context contextH1 = H1();
        String strC3 = c3(R.string.device_config_cloud_sync_rename_config_title);
        LocalConfigItem localConfigItem = (LocalConfigItem) this.f15402s8.g2(i10);
        final t7.c cVar = new t7.c(contextH1, strC3, (localConfigItem == null || (entitySimpleConfigZ = localConfigItem.z()) == null) ? null : entitySimpleConfigZ.getName());
        cVar.F(new c.a() { // from class: com.flydigi.device_manager.ui.sync.k
            @Override // t7.c.a
            public final void a(String str, androidx.appcompat.app.j jVar) {
                SyncConfigFragment.k7(this.f15475a, i10, cVar, str, jVar);
            }
        });
        cVar.show();
    }

    public final void l7() {
        t7.c cVar = new t7.c(R4(), c3(R.string.device_config_cloud_sync_download_cloud_config_title), "", c3(R.string.floatview_config_manager_input_download_code_hint));
        cVar.F(new c.a() { // from class: com.flydigi.device_manager.ui.sync.j
            @Override // t7.c.a
            public final void a(String str, androidx.appcompat.app.j jVar) {
                SyncConfigFragment.m7(this.f15472a, str, jVar);
            }
        });
        cVar.show();
    }

    public final void n7(final CFGEntityList cFGEntityList) {
        new FZDialogV2.a().q(c3(R.string.device_config_cloud_sync_name_conflict_local_title)).j(c3(R.string.floatview_config_manager_download_config_conflict_with_local)).b(Boolean.FALSE).g(c3(R.string.floatview_config_manager_download_config_conflict_with_local_overwrite)).l(false).d(c3(R.string.floatview_config_manager_download_config_conflict_with_local_ignore)).f(new FZDialogV2.c() { // from class: com.flydigi.device_manager.ui.sync.h
            @Override // com.flydigi.base.widget.FZDialogV2.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.o7(this.f15464a, cFGEntityList, dialogFragment);
            }
        }).c(new FZDialogV2.c() { // from class: com.flydigi.device_manager.ui.sync.i
            @Override // com.flydigi.base.widget.FZDialogV2.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.p7(this.f15468a, cFGEntityList, dialogFragment);
            }
        }).a().Z5(U1(), "showSharedConfigConflictDialog");
    }

    public final void q7(final int[] iArr) {
        int i10 = 0;
        List<String> listE0 = L6().E0(false, iArr);
        FZDialog.a aVarF = new FZDialog.a().d(c3(R.string.cancel)).c(b6.c.f9082a).g(c3(R.string.device_upload)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.sync.d
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SyncConfigFragment.r7(this.f15446a, iArr, dialogFragment);
            }
        });
        if (listE0.isEmpty()) {
            aVarF.t(c3(R.string.device_config_cloud_sync_upload_config_title)).j(c3(R.string.device_config_cloud_sync_upload_config_content));
        } else {
            FZDialog.a aVarT = aVarF.t(c3(R.string.device_config_cloud_sync_config_exist_cloud));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c3(R.string.device_config_cloud_sync_upload_config_content_conflict));
            sb2.append('\n');
            ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(listE0, 10));
            for (Object obj : listE0) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                arrayList.add(i11 + ". " + ((String) obj));
                i10 = i11;
            }
            sb2.append(CollectionsKt___CollectionsKt.h3(arrayList, "\n", null, null, 0, null, null, 62, null));
            aVarT.j(sb2.toString());
        }
        aVarF.a().Z5(L2(), "uploading");
    }
}
