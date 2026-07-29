package com.flydigi.device_manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import com.alibaba.android.arouter.facade.Postcard;
import com.android.motionelf.FloatingWindow;
import com.blankj.utilcode.util.PermissionUtils;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.common.y;
import com.flydigi.base.ui.StoragePermissionRequestActivity;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.ui.home.device.g0;
import com.flydigi.remote.DeviceInfo;
import com.flydigi.sdk.gamepad.GamepadInfo;
import f.b;
import h9.b;
import i9.a;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.u;
import kotlin.z;
import kotlin.z1;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nBaseGamepadFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseGamepadFragment.kt\ncom/flydigi/device_manager/BaseGamepadFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,273:1\n172#2,9:274\n106#2,15:283\n*S KotlinDebug\n*F\n+ 1 BaseGamepadFragment.kt\ncom/flydigi/device_manager/BaseGamepadFragment\n*L\n44#1:274,9\n48#1:283,15\n*E\n"})
public abstract class BaseGamepadFragment extends FZLazyFragment {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.l
    public GamepadInfo f14372p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public final z f14373q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @yt.l
    public h9.b f14374r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public boolean f14375s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @yt.k
    public final z f14376t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public boolean f14377u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @yt.k
    public Runnable f14378v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @yt.k
    public final h9.c f14379w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    @yt.l
    public h9.d f14380x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    @yt.k
    public final ServiceConnection f14381y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @yt.k
    public final androidx.activity.result.g<Intent> f14382z8;

    public static final class a extends h9.e {
        public a() {
        }

        public static final void X0(BaseGamepadFragment this$0) {
            f0.p(this$0, "this$0");
            this$0.s6();
        }

        public static final void Y0(BaseGamepadFragment this$0, boolean z10) {
            f0.p(this$0, "this$0");
            this$0.t6(z10);
        }

        public static final void Z0(BaseGamepadFragment this$0) {
            f0.p(this$0, "this$0");
            this$0.u6();
        }

        public static final void a1(BaseGamepadFragment this$0) {
            f0.p(this$0, "this$0");
            this$0.v6();
        }

        @Override // h9.e, h9.c
        public void H0(@yt.k DeviceInfo deviceInfo) {
            f0.p(deviceInfo, "deviceInfo");
            BaseGamepadFragment.this.y6(DeviceInfo.b(deviceInfo));
            BaseGamepadFragment.this.H5().g(BaseGamepadFragment.this.f14378v8);
            BaseGamepadFragment.this.H5().f(BaseGamepadFragment.this.f14378v8, 250L);
        }

        @Override // h9.e, h9.c
        public void J0() {
            super.J0();
            y yVarH5 = BaseGamepadFragment.this.H5();
            final BaseGamepadFragment baseGamepadFragment = BaseGamepadFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.device_manager.i
                @Override // java.lang.Runnable
                public final void run() {
                    BaseGamepadFragment.a.Z0(baseGamepadFragment);
                }
            });
        }

        @Override // h9.e, h9.c
        public void k0(final boolean z10) {
            y yVarH5 = BaseGamepadFragment.this.H5();
            final BaseGamepadFragment baseGamepadFragment = BaseGamepadFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.device_manager.l
                @Override // java.lang.Runnable
                public final void run() {
                    BaseGamepadFragment.a.Y0(baseGamepadFragment, z10);
                }
            });
        }

        @Override // h9.e, h9.c
        public void n() {
            y yVarH5 = BaseGamepadFragment.this.H5();
            final BaseGamepadFragment baseGamepadFragment = BaseGamepadFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.device_manager.k
                @Override // java.lang.Runnable
                public final void run() {
                    BaseGamepadFragment.a.a1(baseGamepadFragment);
                }
            });
        }

        @Override // h9.e, h9.c
        public void x0() {
            y yVarH5 = BaseGamepadFragment.this.H5();
            final BaseGamepadFragment baseGamepadFragment = BaseGamepadFragment.this;
            yVarH5.e(new Runnable() { // from class: com.flydigi.device_manager.j
                @Override // java.lang.Runnable
                public final void run() {
                    BaseGamepadFragment.a.X0(baseGamepadFragment);
                }
            });
        }
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@yt.l ComponentName componentName, @yt.l IBinder iBinder) {
            BaseGamepadFragment.this.f14374r8 = b.AbstractBinderC0365b.Q0(iBinder);
            try {
                h9.b bVar = BaseGamepadFragment.this.f14374r8;
                if (bVar != null) {
                    BaseGamepadFragment baseGamepadFragment = BaseGamepadFragment.this;
                    bVar.O(baseGamepadFragment.f14379w8);
                    if (baseGamepadFragment.f14380x8 != null) {
                        bVar.S(baseGamepadFragment.f14380x8);
                    }
                    baseGamepadFragment.y6(DeviceInfo.b(bVar.E0()));
                    baseGamepadFragment.H5().g(baseGamepadFragment.f14378v8);
                    baseGamepadFragment.H5().f(baseGamepadFragment.f14378v8, 250L);
                }
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@yt.l ComponentName componentName) {
            BaseGamepadFragment.this.f14374r8 = null;
        }
    }

    public static final class c implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14385a;

        public c(ik.l function) {
            f0.p(function, "function");
            this.f14385a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final u<?> a() {
            return this.f14385a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14385a.i(obj);
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

    public BaseGamepadFragment() {
        final ik.a aVar = null;
        this.f14373q8 = FragmentViewModelLazyKt.h(this, n0.d(m9.u.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c1 o() {
                c1 c1VarO0 = this.P4().O0();
                f0.o(c1VarO0, "requireActivity().viewModelStore");
                return c1VarO0;
            }
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar2;
                ik.a aVar3 = aVar;
                if (aVar3 != null && (aVar2 = (p1.a) aVar3.o()) != null) {
                    return aVar2;
                }
                p1.a aVarJ0 = this.P4().j0();
                f0.o(aVarJ0, "requireActivity().defaultViewModelCreationExtras");
                return aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final z0.b o() {
                z0.b bVarH0 = this.P4().h0();
                f0.o(bVarH0, "requireActivity().defaultViewModelProviderFactory");
                return bVarH0;
            }
        });
        final ik.a<Fragment> aVar2 = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$viewModels$default$1
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
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 o() {
                return (d1) aVar2.o();
            }
        });
        this.f14376t8 = FragmentViewModelLazyKt.h(this, n0.d(g0.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$viewModels$default$3
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final p1.a o() {
                p1.a aVar3;
                ik.a aVar4 = aVar;
                if (aVar4 != null && (aVar3 = (p1.a) aVar4.o()) != null) {
                    return aVar3;
                }
                d1 d1VarP = FragmentViewModelLazyKt.p(zVarC);
                r rVar = d1VarP instanceof r ? (r) d1VarP : null;
                p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
                return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$special$$inlined$viewModels$default$5
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
        this.f14378v8 = new Runnable() { // from class: com.flydigi.device_manager.h
            @Override // java.lang.Runnable
            public final void run() {
                BaseGamepadFragment.r6(this.f14442a);
            }
        };
        this.f14379w8 = new a();
        this.f14380x8 = p6();
        this.f14381y8 = new b();
        androidx.activity.result.g<Intent> gVarP1 = P1(new b.m(), new androidx.activity.result.a() { // from class: com.flydigi.device_manager.f
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                BaseGamepadFragment.x6(this.f14440a, (ActivityResult) obj);
            }
        });
        f0.o(gVarP1, "registerForActivityResul…)\n            }\n        }");
        this.f14382z8 = gVarP1;
    }

    public static final void A6(BaseGamepadFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        dialogFragment.I5();
        if (com.blankj.utilcode.util.n0.b("official", "official")) {
            PermissionUtils.C();
        } else {
            this$0.w6();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r6(com.flydigi.device_manager.BaseGamepadFragment r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.f0.p(r3, r0)
            com.flydigi.sdk.gamepad.GamepadInfo r0 = r3.f14372p8
            if (r0 == 0) goto L44
            v5.a r1 = v5.a.j()
            com.flydigi.sdk.gamepad.GamepadInfo r2 = r3.f14372p8
            r1.o(r2)
            m9.u r1 = r3.l6()
            r1.i(r0)
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L38
            boolean r1 = r3.f14377u8
            if (r1 != 0) goto L38
            boolean r0 = r0.isDriverMode()
            if (r0 != 0) goto L3e
            android.content.Context r0 = r3.R4()
            java.lang.String r1 = "requireContext()"
            kotlin.jvm.internal.f0.o(r0, r1)
            boolean r0 = n5.c.c(r0)
            if (r0 == 0) goto L3e
        L38:
            boolean r0 = v5.c.f()
            if (r0 == 0) goto L44
        L3e:
            r0 = 1
            r3.f14377u8 = r0
            r3.w6()
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.BaseGamepadFragment.r6(com.flydigi.device_manager.BaseGamepadFragment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s6() {
        Postcard postcardD = h3.a.j().d(a.d.f31950f);
        GamepadInfo gamepadInfo = this.f14372p8;
        postcardD.withString("key_device_code", gamepadInfo != null ? gamepadInfo.getDeviceCode() : null).withBoolean(DataConstant.DEVICE_KEY_ACTIVATION_FAILED, true).withBoolean(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, true).navigation();
    }

    private final void w6() {
        androidx.fragment.app.g gVarP4 = P4();
        f0.o(gVarP4, "requireActivity()");
        if (n5.c.b(gVarP4)) {
            if (f0.g(v5.c.f() ? v5.c.f52709a : v5.c.f52710b, o5.m.l(DataConstant.SP_FLOAT, 2).q(DataConstant.SP_FLOAT_KEY_DRIVER_VERSION_RELEASED))) {
                return;
            }
            m6().m();
        } else {
            androidx.activity.result.g<Intent> gVar = this.f14382z8;
            StoragePermissionRequestActivity.a aVar = StoragePermissionRequestActivity.f13377k0;
            Context contextR4 = R4();
            f0.o(contextR4, "requireContext()");
            GamepadInfo gamepadInfo = this.f14372p8;
            gVar.b(aVar.a(contextR4, Integer.valueOf((gamepadInfo == null || !gamepadInfo.isDriverMode()) ? 0 : 1)));
        }
    }

    public static final void x6(BaseGamepadFragment this$0, ActivityResult activityResult) {
        f0.p(this$0, "this$0");
        if (activityResult.b() == -1) {
            this$0.w6();
        } else if (activityResult.b() == 0) {
            this$0.z6();
        }
    }

    private final void z6() {
        FZDialog.a aVarT = new FZDialog.a().t(c3(R.string.notice));
        GamepadInfo gamepadInfo = this.f14372p8;
        aVarT.j(c3(gamepadInfo != null && gamepadInfo.isDriverMode() ? R.string.device_storage_permission_must_granted_for_release_driver : R.string.device_storage_permission_must_granted_for_start_game)).q(c3(R.string.device_setting_now)).b(Boolean.FALSE).p(new FZDialog.c() { // from class: com.flydigi.device_manager.g
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                BaseGamepadFragment.A6(this.f14441a, dialogFragment);
            }
        }).u(U1(), "storage_permission_denied");
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        Intent intent = new Intent(X1(), (Class<?>) FloatingWindow.class);
        intent.setAction(h9.b.class.getName());
        Context contextX1 = X1();
        this.f14375s8 = contextX1 != null ? contextX1.bindService(intent, this.f14381y8, 65) : false;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        Context contextX1;
        super.i4();
        try {
            if (!this.f14375s8 || (contextX1 = X1()) == null) {
                return;
            }
            contextX1.unbindService(this.f14381y8);
        } catch (Exception unused) {
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        m6().k().k(l3(), new c(new BaseGamepadFragment$onViewCreated$1(this)));
        l6().h().k(l3(), new c(new ik.l<GamepadInfo, z1>() { // from class: com.flydigi.device_manager.BaseGamepadFragment$onViewCreated$2
            {
                super(1);
            }

            public final void b(GamepadInfo it2) {
                BaseGamepadFragment baseGamepadFragment = this.this$0;
                f0.o(it2, "it");
                baseGamepadFragment.q6(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(GamepadInfo gamepadInfo) {
                b(gamepadInfo);
                return z1.f38230a;
            }
        }));
    }

    @yt.l
    public final GamepadInfo k6() {
        return this.f14372p8;
    }

    @yt.k
    public final m9.u l6() {
        return (m9.u) this.f14373q8.getValue();
    }

    public final g0 m6() {
        return (g0) this.f14376t8.getValue();
    }

    public final boolean n6() {
        GamepadInfo gamepadInfo = this.f14372p8;
        if (gamepadInfo != null) {
            return gamepadInfo.isConnected();
        }
        return false;
    }

    public final boolean o6() {
        GamepadInfo gamepadInfo = this.f14372p8;
        if (gamepadInfo != null) {
            return gamepadInfo.isDriverConnected();
        }
        return false;
    }

    @yt.l
    public h9.d p6() {
        return null;
    }

    public void q6(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
    }

    public void t6(boolean z10) {
    }

    public void u6() {
        o5.m.l(DataConstant.SP_FLOAT, 2).H(DataConstant.SP_FLOAT_KEY_DRIVER_VERSION_RELEASED);
        w6();
    }

    public void v6() {
    }

    public final void y6(@yt.l GamepadInfo gamepadInfo) {
        this.f14372p8 = gamepadInfo;
    }
}
