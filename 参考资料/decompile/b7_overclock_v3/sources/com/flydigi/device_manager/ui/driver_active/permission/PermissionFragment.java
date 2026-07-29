package com.flydigi.device_manager.ui.driver_active.permission;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import androidx.recyclerview.widget.RecyclerView;
import c7.i0;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment;
import com.shuhart.stepview.StepView;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import kotlin.z1;
import o5.p;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nPermissionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionFragment.kt\ncom/flydigi/device_manager/ui/driver_active/permission/PermissionFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,180:1\n106#2,15:181\n*S KotlinDebug\n*F\n+ 1 PermissionFragment.kt\ncom/flydigi/device_manager/ui/driver_active/permission/PermissionFragment\n*L\n36#1:181,15\n*E\n"})
public final class PermissionFragment extends FZFragment {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public static final a f14897t8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @yt.k
    public final z f14898o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public i0 f14899p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public b f14900q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public i f14901r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public int f14902s8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final PermissionFragment a() {
            PermissionFragment permissionFragment = new PermissionFragment();
            permissionFragment.c5(androidx.core.os.e.a());
            return permissionFragment;
        }
    }

    public interface b {
        void O1();

        void Y0();

        void e0();

        void w1();
    }

    public static final class c implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14903a;

        public c(ik.l function) {
            f0.p(function, "function");
            this.f14903a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f14903a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14903a.i(obj);
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

    public PermissionFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$special$$inlined$viewModels$default$1
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
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$special$$inlined$viewModels$default$2
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
        this.f14898o8 = FragmentViewModelLazyKt.h(this, n0.d(l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = FragmentViewModelLazyKt.p(zVarC).O0();
                f0.o(c1VarO0, "owner.viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$special$$inlined$viewModels$default$4
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
                r rVar = d1VarP instanceof r ? (r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$special$$inlined$viewModels$default$5
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
                r rVar = d1VarP instanceof r ? (r) d1VarP : null;
                if (rVar == null || (bVarH0 = rVar.h0()) == null) {
                    bVarH0 = this.h0();
                }
                f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return bVarH0;
            }
        });
    }

    @hk.m
    @yt.k
    public static final PermissionFragment g6() {
        return f14897t8.a();
    }

    public static final void h6(PermissionFragment this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = null;
        if (!o5.b.a(this$0.X1())) {
            b bVar2 = this$0.f14900q8;
            if (bVar2 == null) {
                f0.S("listener");
            } else {
                bVar = bVar2;
            }
            bVar.Y0();
            return;
        }
        if (this$0.f14902s8 != 7) {
            b bVar3 = this$0.f14900q8;
            if (bVar3 == null) {
                f0.S("listener");
            } else {
                bVar = bVar3;
            }
            bVar.e0();
            return;
        }
        b bVar4 = this$0.f14900q8;
        if (bVar4 == null) {
            f0.S("listener");
        } else {
            bVar = bVar4;
        }
        bVar.w1();
        this$0.f6().j(true);
    }

    public static final void i6(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? com.flydigi.device_manager.o.f14478v : com.flydigi.device_manager.o.f14479w).navigation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@yt.k Context context) {
        f0.p(context, "context");
        super.H3(context);
        if (context instanceof b) {
            this.f14900q8 = (b) context;
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_developer_permission;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        i0 i0VarD = i0.d(inflater, viewGroup, false);
        f0.o(i0VarD, "inflate(inflater, container, false)");
        this.f14899p8 = i0VarD;
        if (i0VarD == null) {
            f0.S("viewBinding");
            i0VarD = null;
        }
        ConstraintLayout constraintLayoutB = i0VarD.getRoot();
        f0.o(constraintLayoutB, "viewBinding.root");
        return constraintLayoutB;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        f6().g();
    }

    public final l f6() {
        return (l) this.f14898o8.getValue();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        this.f14901r8 = new i();
        i0 i0Var = this.f14899p8;
        i0 i0Var2 = null;
        if (i0Var == null) {
            f0.S("viewBinding");
            i0Var = null;
        }
        RecyclerView recyclerView = i0Var.f10101e;
        i iVar = this.f14901r8;
        if (iVar == null) {
            f0.S("mAdapter");
            iVar = null;
        }
        recyclerView.setAdapter(iVar);
        i0 i0Var3 = this.f14899p8;
        if (i0Var3 == null) {
            f0.S("viewBinding");
            i0Var3 = null;
        }
        i0Var3.f10100d.getState().u(o5.h.h() ? 3 : 2).t(o5.h.h() ? CollectionsKt__CollectionsKt.L("Step1", "Step2", "Step3") : CollectionsKt__CollectionsKt.L("Step1", "Step2")).c();
        f6().h().k(l3(), new c(new ik.l<Integer, z1>() { // from class: com.flydigi.device_manager.ui.driver_active.permission.PermissionFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(Integer it2) {
                int i10 = this.this$0.f14902s8;
                if (it2 != null && i10 == it2.intValue()) {
                    ToastUtils.P(R.string.device_driver_active_permission_not_enabled);
                    return;
                }
                if (it2 == null || it2.intValue() != -1) {
                    PermissionFragment permissionFragment = this.this$0;
                    f0.o(it2, "it");
                    permissionFragment.f14902s8 = it2.intValue();
                    this.this$0.j6();
                    return;
                }
                PermissionFragment.b bVar = this.this$0.f14900q8;
                if (bVar == null) {
                    f0.S("listener");
                    bVar = null;
                }
                bVar.e0();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Integer num) {
                b(num);
                return z1.f38230a;
            }
        }));
        i0 i0Var4 = this.f14899p8;
        if (i0Var4 == null) {
            f0.S("viewBinding");
            i0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(i0Var4.f10098b, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.permission.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionFragment.h6(this.f14915a, view2);
            }
        });
        i0 i0Var5 = this.f14899p8;
        if (i0Var5 == null) {
            f0.S("viewBinding");
        } else {
            i0Var2 = i0Var5;
        }
        com.blankj.utilcode.util.o.r(i0Var2.f10099c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.driver_active.permission.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionFragment.i6(view2);
            }
        });
    }

    public final void j6() {
        int i10 = this.f14902s8;
        i0 i0Var = null;
        if (i10 == 2) {
            i0 i0Var2 = this.f14899p8;
            if (i0Var2 == null) {
                f0.S("viewBinding");
                i0Var2 = null;
            }
            i0Var2.f10100d.i0(0, false);
            i iVar = this.f14901r8;
            if (iVar == null) {
                f0.S("mAdapter");
                iVar = null;
            }
            iVar.n(e.f14909a.a());
        } else if (i10 == 3) {
            if (o5.h.h()) {
                i0 i0Var3 = this.f14899p8;
                if (i0Var3 == null) {
                    f0.S("viewBinding");
                    i0Var3 = null;
                }
                i0Var3.f10100d.i0(2, false);
            } else {
                i0 i0Var4 = this.f14899p8;
                if (i0Var4 == null) {
                    f0.S("viewBinding");
                    i0Var4 = null;
                }
                i0Var4.f10100d.i0(1, false);
            }
            i iVar2 = this.f14901r8;
            if (iVar2 == null) {
                f0.S("mAdapter");
                iVar2 = null;
            }
            iVar2.n(e.f14909a.b());
        } else if (i10 != 6) {
            if (i10 == 7) {
                i0 i0Var5 = this.f14899p8;
                if (i0Var5 == null) {
                    f0.S("viewBinding");
                    i0Var5 = null;
                }
                i0Var5.f10098b.setText(R.string.next);
            }
            i iVar3 = this.f14901r8;
            if (iVar3 == null) {
                f0.S("mAdapter");
                iVar3 = null;
            }
            iVar3.n(e.f14909a.b());
            i0 i0Var6 = this.f14899p8;
            if (i0Var6 == null) {
                f0.S("viewBinding");
                i0Var6 = null;
            }
            StepView stepView = i0Var6.f10100d;
            i0 i0Var7 = this.f14899p8;
            if (i0Var7 == null) {
                f0.S("viewBinding");
                i0Var7 = null;
            }
            stepView.i0(i0Var7.f10100d.getStepCount() - 1, false);
        } else {
            i0 i0Var8 = this.f14899p8;
            if (i0Var8 == null) {
                f0.S("viewBinding");
                i0Var8 = null;
            }
            i0Var8.f10100d.i0(1, false);
            i iVar4 = this.f14901r8;
            if (iVar4 == null) {
                f0.S("mAdapter");
                iVar4 = null;
            }
            iVar4.n(e.f14909a.c());
        }
        i0 i0Var9 = this.f14899p8;
        if (i0Var9 == null) {
            f0.S("viewBinding");
            i0Var9 = null;
        }
        i0Var9.f10100d.requestLayout();
        i0 i0Var10 = this.f14899p8;
        if (i0Var10 == null) {
            f0.S("viewBinding");
        } else {
            i0Var = i0Var10;
        }
        i0Var.f10100d.invalidate();
    }
}
