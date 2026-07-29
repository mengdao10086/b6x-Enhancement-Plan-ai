package com.flydigi.device_manager.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import c7.v0;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.d0;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.NoticeBean;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.connection.ScanFragment;
import com.flydigi.device_manager.ui.home.device.DeviceGamepadFragment;
import com.flydigi.device_manager.ui.home.device.DeviceHeadsetFragment;
import com.flydigi.device_manager.ui.home.device.DeviceWaspwingFragment;
import com.flydigi.device_manager.ui.home.device.EmptyDeviceFragment;
import com.flydigi.device_manager.ui.home.game.MyGameZoneFragment;
import com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import i9.a;
import java.util.HashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.b0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import kotlin.z1;
import org.json.JSONException;
import p1.a;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nDeviceHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceHomeFragment.kt\ncom/flydigi/device_manager/ui/home/DeviceHomeFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 Handler.kt\nandroidx/core/os/HandlerKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,596:1\n106#2,15:597\n172#2,9:612\n172#2,9:621\n33#3,12:630\n1#4:642\n*S KotlinDebug\n*F\n+ 1 DeviceHomeFragment.kt\ncom/flydigi/device_manager/ui/home/DeviceHomeFragment\n*L\n70#1:597,15\n71#1:612,9\n72#1:621,9\n459#1:630,12\n*E\n"})
public final class DeviceHomeFragment extends BaseGamepadFragment {

    @yt.k
    public static final a I8 = new a(null);

    @yt.k
    public String A8 = "all";
    public v0 B8;

    @yt.k
    public final z C8;

    @yt.k
    public final z D8;

    @yt.k
    public final z E8;

    @yt.k
    public Object F8;
    public boolean G8;
    public boolean H8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final DeviceHomeFragment a() {
            return new DeviceHomeFragment();
        }
    }

    public static final class b extends ThreadUtils.d<Object> {
        public b() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @yt.l
        public Object e() {
            if (!v5.c.f()) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("Manufacturer", v5.c.b() + Build.VERSION.RELEASE);
            u9.g.a().e(DeviceHomeFragment.this.H1(), "Simulator_Start", map);
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public void l(@yt.l Object obj) {
        }
    }

    public static final class c extends ThreadUtils.d<Boolean> {
        public c() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public /* bridge */ /* synthetic */ void l(Object obj) {
            r(((Boolean) obj).booleanValue());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        @yt.k
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            if (v5.c.f() && !DeviceHomeFragment.this.G8 && !DeviceHomeFragment.this.H8) {
                DeviceHomeFragment.this.H8 = true;
                DeviceHomeFragment.this.G8 = n3.b.a();
                DeviceHomeFragment.this.H8 = false;
            }
            return Boolean.valueOf(DeviceHomeFragment.this.G8);
        }

        public void r(boolean z10) {
            if (DeviceHomeFragment.this.G8) {
                i9.b.f(DeviceHomeFragment.this, DataConstant.REMOTE_ACTION_ROOT_PERMISSION_SUCCESS);
            }
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 DeviceHomeFragment.kt\ncom/flydigi/device_manager/ui/home/DeviceHomeFragment\n*L\n1#1,69:1\n460#2,2:70\n*E\n"})
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeviceHomeFragment.this.b7().k();
        }
    }

    public static final class e implements MyGameZoneFragment.b {
        public e() {
        }

        @Override // com.flydigi.device_manager.ui.home.game.MyGameZoneFragment.b
        public void a(int i10, int i11) {
            DeviceHomeFragment.this.u7(i10, i11);
        }
    }

    public static final class f implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f15124a;

        public f(ik.l function) {
            f0.p(function, "function");
            this.f15124a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f15124a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f15124a.i(obj);
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

    public static final class g implements SwitchMappingModeFragment.b {
        public g() {
        }

        @Override // com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.b
        public void Q(int i10, int i11) {
            SwitchMappingModeFragment.b.a.a(this, i10, i11);
        }

        @Override // com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.b, com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment.b
        public void h(@yt.k String deviceCode, boolean z10) {
            f0.p(deviceCode, "deviceCode");
            SwitchMappingModeFragment.b.a.b(this, deviceCode, z10);
            DeviceHomeFragment.this.t7(deviceCode);
        }
    }

    public DeviceHomeFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$viewModels$default$1
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
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$viewModels$default$2
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
        this.C8 = FragmentViewModelLazyKt.h(this, n0.d(DeviceHomeViewModel.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$viewModels$default$3
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$viewModels$default$4
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$viewModels$default$5
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
        this.D8 = FragmentViewModelLazyKt.h(this, n0.d(q9.h.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$1
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$2
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
                f0.o(aVarJ0, "requireActivity().defaultViewModelCreationExtras");
                return aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$3
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
        this.E8 = FragmentViewModelLazyKt.h(this, n0.d(t9.l.class), new ik.a<c1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$4
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$5
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
                f0.o(aVarJ0, "requireActivity().defaultViewModelCreationExtras");
                return aVarJ0;
            }
        }, new ik.a<z0.b>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$special$$inlined$activityViewModels$default$6
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
        this.F8 = new o();
    }

    @hk.m
    @yt.k
    public static final DeviceHomeFragment d7() {
        return I8.a();
    }

    public static final void e7(DeviceHomeFragment this$0, Object it2) {
        Fragment fragmentA;
        f0.p(this$0, "this$0");
        f0.o(it2, "it");
        this$0.F8 = it2;
        boolean z10 = it2 instanceof GamepadInfo;
        if (z10) {
            GamepadInfo gamepadInfo = (GamepadInfo) it2;
            if (gamepadInfo.isConnected()) {
                o5.m.i().x(DataConstant.SP_APP_LASTEST_CONNECTED_DEVICE_TYPE, 1);
                v0 v0Var = this$0.B8;
                if (v0Var == null) {
                    f0.S("binding");
                    v0Var = null;
                }
                TextView textView = v0Var.f10518d;
                f0.o(textView, "binding.btnAction");
                o5.c.b(textView, Boolean.FALSE, false, 2, null);
            } else {
                v0 v0Var2 = this$0.B8;
                if (v0Var2 == null) {
                    f0.S("binding");
                    v0Var2 = null;
                }
                TextView textView2 = v0Var2.f10518d;
                f0.o(textView2, "binding.btnAction");
                o5.c.b(textView2, Boolean.TRUE, false, 2, null);
                v0 v0Var3 = this$0.B8;
                if (v0Var3 == null) {
                    f0.S("binding");
                    v0Var3 = null;
                }
                v0Var3.f10518d.setText(R.string.device_add_first_device);
            }
            if (!androidx.core.util.j.a(this$0.A8, gamepadInfo.getDeviceCode())) {
                this$0.a7().u(gamepadInfo.getDeviceCode());
            }
            fragmentA = d0.A(this$0.U1(), DeviceGamepadFragment.class);
            if (fragmentA == null) {
                fragmentA = DeviceGamepadFragment.G8.a();
            }
        } else if (it2 instanceof HeadsetInfo) {
            v0 v0Var4 = this$0.B8;
            if (v0Var4 == null) {
                f0.S("binding");
                v0Var4 = null;
            }
            TextView textView3 = v0Var4.f10518d;
            f0.o(textView3, "binding.btnAction");
            o5.c.b(textView3, Boolean.TRUE, false, 2, null);
            HeadsetInfo headsetInfo = (HeadsetInfo) it2;
            if (headsetInfo.getConnected()) {
                o5.m.i().x(DataConstant.SP_APP_LASTEST_CONNECTED_DEVICE_TYPE, 2);
            }
            v0 v0Var5 = this$0.B8;
            if (v0Var5 == null) {
                f0.S("binding");
                v0Var5 = null;
            }
            v0Var5.f10518d.setText(headsetInfo.getConnected() ? R.string.device_function_setting : R.string.device_add_first_device);
            v0 v0Var6 = this$0.B8;
            if (v0Var6 == null) {
                f0.S("binding");
                v0Var6 = null;
            }
            TextView textView4 = v0Var6.f10520f;
            f0.o(textView4, "binding.btnHeadset");
            o5.c.b(textView4, Boolean.FALSE, false, 2, null);
            if (!androidx.core.util.j.a(this$0.A8, headsetInfo.getDeviceCode())) {
                this$0.a7().u(headsetInfo.getDeviceCode());
            }
            fragmentA = d0.A(this$0.U1(), DeviceHeadsetFragment.class);
            if (fragmentA == null) {
                fragmentA = DeviceHeadsetFragment.f15140r8.a(headsetInfo);
            }
        } else if (it2 instanceof WaspWingInfo) {
            v0 v0Var7 = this$0.B8;
            if (v0Var7 == null) {
                f0.S("binding");
                v0Var7 = null;
            }
            TextView textView5 = v0Var7.f10518d;
            f0.o(textView5, "binding.btnAction");
            o5.c.b(textView5, Boolean.TRUE, false, 2, null);
            WaspWingInfo waspWingInfo = (WaspWingInfo) it2;
            if (waspWingInfo.isConnected()) {
                o5.m.i().x(DataConstant.SP_APP_LASTEST_CONNECTED_DEVICE_TYPE, 3);
            }
            v0 v0Var8 = this$0.B8;
            if (v0Var8 == null) {
                f0.S("binding");
                v0Var8 = null;
            }
            v0Var8.f10518d.setText(waspWingInfo.isConnected() ? R.string.device_function_setting : R.string.device_add_first_device);
            v0 v0Var9 = this$0.B8;
            if (v0Var9 == null) {
                f0.S("binding");
                v0Var9 = null;
            }
            TextView textView6 = v0Var9.f10522h;
            f0.o(textView6, "binding.btnRadiator");
            o5.c.b(textView6, Boolean.FALSE, false, 2, null);
            if (!androidx.core.util.j.a(this$0.A8, waspWingInfo.getDeviceCode())) {
                this$0.a7().u(waspWingInfo.getDeviceCode());
            }
            fragmentA = d0.A(this$0.U1(), DeviceWaspwingFragment.class);
            if (fragmentA == null) {
                fragmentA = DeviceWaspwingFragment.f15152q8.a(waspWingInfo);
            }
        } else {
            v0 v0Var10 = this$0.B8;
            if (v0Var10 == null) {
                f0.S("binding");
                v0Var10 = null;
            }
            TextView textView7 = v0Var10.f10518d;
            f0.o(textView7, "binding.btnAction");
            o5.c.b(textView7, Boolean.TRUE, false, 2, null);
            v0 v0Var11 = this$0.B8;
            if (v0Var11 == null) {
                f0.S("binding");
                v0Var11 = null;
            }
            v0Var11.f10518d.setText(R.string.device_add_first_device);
            v0 v0Var12 = this$0.B8;
            if (v0Var12 == null) {
                f0.S("binding");
                v0Var12 = null;
            }
            TextView textView8 = v0Var12.f10522h;
            f0.o(textView8, "binding.btnRadiator");
            Boolean bool = Boolean.FALSE;
            o5.c.b(textView8, bool, false, 2, null);
            v0 v0Var13 = this$0.B8;
            if (v0Var13 == null) {
                f0.S("binding");
                v0Var13 = null;
            }
            TextView textView9 = v0Var13.f10520f;
            f0.o(textView9, "binding.btnHeadset");
            o5.c.b(textView9, bool, false, 2, null);
            fragmentA = d0.A(this$0.U1(), EmptyDeviceFragment.class);
            if (fragmentA == null) {
                fragmentA = EmptyDeviceFragment.f15156o8.a();
            }
        }
        FragmentManager fragmentManagerU1 = this$0.U1();
        int i10 = R.id.container_my_device;
        d0.v0(fragmentManagerU1, fragmentA, i10);
        v0 v0Var14 = this$0.B8;
        if (v0Var14 == null) {
            f0.S("binding");
            v0Var14 = null;
        }
        v0Var14.f10525k.setVisibility(it2 instanceof o ? 8 : 0);
        boolean z11 = z10 && ((GamepadInfo) it2).isConnected();
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        v0 v0Var15 = this$0.B8;
        if (v0Var15 == null) {
            f0.S("binding");
            v0Var15 = null;
        }
        dVar.H(v0Var15.f10516b);
        if (z11) {
            Fragment fragmentA2 = d0.A(this$0.U1(), MyGameZoneFragment.class);
            if (fragmentA2 == null) {
                fragmentA2 = MyGameZoneFragment.D8.a();
            }
            Fragment fragment = fragmentA2;
            f0.n(fragment, "null cannot be cast to non-null type com.flydigi.device_manager.ui.home.game.MyGameZoneFragment");
            ((MyGameZoneFragment) fragment).h7(this$0.new e());
            d0.H0(this$0.U1(), fragment, R.id.container_game_zone, false, R.anim.anim_bottom_in, R.anim.anim_bottom_out);
            dVar.k1(i10, 3, 0);
            dVar.K(i10, 3, 0, 3);
            int i11 = R.id.area_notice;
            dVar.K(i10, 4, i11, 3);
            dVar.K(i11, 3, i10, 4);
            dVar.K(i11, 4, 0, 4);
        } else {
            Fragment fragmentA3 = d0.A(this$0.U1(), MyGameZoneFragment.class);
            if (fragmentA3 != null) {
                d0.c0(fragmentA3);
            }
            dVar.k1(i10, 3, this$0.V2().getDimensionPixelSize(R.dimen.qb_px_16));
            dVar.K(i10, 4, 0, 4);
            int i12 = R.id.area_notice;
            dVar.K(i10, 3, i12, 4);
            dVar.K(i12, 4, i10, 3);
            dVar.K(i12, 3, 0, 3);
        }
        v0 v0Var16 = this$0.B8;
        if (v0Var16 == null) {
            f0.S("binding");
            v0Var16 = null;
        }
        androidx.transition.u.a(v0Var16.f10516b);
        v0 v0Var17 = this$0.B8;
        if (v0Var17 == null) {
            f0.S("binding");
            v0Var17 = null;
        }
        dVar.r(v0Var17.f10516b);
        v0 v0Var18 = this$0.B8;
        if (v0Var18 == null) {
            f0.S("binding");
            v0Var18 = null;
        }
        FrameLayout frameLayout = v0Var18.f10523i;
        f0.o(frameLayout, "binding.containerGameZone");
        o5.c.b(frameLayout, Boolean.valueOf(z11), false, 2, null);
    }

    public static final void f7(DeviceHomeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        Object objF = this$0.a7().m().f();
        if (objF instanceof GamepadInfo) {
            GamepadInfo gamepadInfoF = this$0.l6().h().f();
            if (gamepadInfoF != null) {
                h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 1).withParcelable("key_device_info", gamepadInfoF).navigation();
                return;
            }
            return;
        }
        if (objF instanceof WaspWingInfo) {
            WaspWingInfo waspWingInfoF = this$0.c7().h().f();
            if (waspWingInfoF != null) {
                u9.g.a().c(this$0.X1(), "Device_Home_Waspwing", "外设管理_散热器");
                h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 3).withInt("ip_type", waspWingInfoF.getIpType()).withString("key_device_code", waspWingInfoF.getDeviceCode()).navigation();
                return;
            }
            return;
        }
        if (!(objF instanceof HeadsetInfo)) {
            h3.a.j().d(v5.c.f() ? a.d.f31948d : a.d.f31947c).navigation();
            return;
        }
        HeadsetInfo headsetInfoF = this$0.b7().j().f();
        if (headsetInfoF != null) {
            u9.g.a().c(this$0.X1(), "Device_Home_Headset", "外设管理_耳机");
            if (headsetInfoF.getConnected()) {
                h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 2).withString("key_device_code", headsetInfoF.getDeviceCode()).navigation();
            } else {
                h3.a.j().d(a.c.f31944c).withString("key_device_code", headsetInfoF.getDeviceCode()).withString(DataConstant.DEVICE_KEY_DEVICE_NAME, headsetInfoF.getDeviceName()).navigation();
            }
        }
    }

    public static final void g7(DeviceHomeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        u9.b.o(1, "外设管理");
        u9.g.a().c(this$0.X1(), "Device_Home_Help", "外设管理_帮助");
    }

    public static final void h7(DeviceHomeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(v5.c.f() ? a.d.f31948d : a.d.f31947c).navigation();
        u9.g.a().c(this$0.X1(), "Device_Home_Add", "外设管理_添加");
    }

    public static final void i7(DeviceHomeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        HeadsetInfo headsetInfoF = this$0.b7().j().f();
        if (headsetInfoF == null) {
            headsetInfoF = v5.a.j().i();
        }
        if (!(!q9.f.h().isEmpty())) {
            h3.a.j().d(a.c.f31944c).withString("key_device_code", headsetInfoF.getDeviceCode()).withString(DataConstant.DEVICE_KEY_DEVICE_NAME, headsetInfoF.getDeviceName()).navigation();
        } else {
            u9.g.a().c(this$0.X1(), "Device_Home_Headset", "外设管理_耳机");
            h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 2).withString("key_device_code", headsetInfoF.getDeviceCode()).navigation();
        }
    }

    public static final void j7(DeviceHomeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfoF = this$0.c7().h().f();
        if (waspWingInfoF == null) {
            waspWingInfoF = v5.a.j().k();
        }
        u9.g.a().c(this$0.X1(), "Device_Home_Waspwing", "外设管理_散热器");
        h3.a.j().d(a.d.f31949e).withInt(DataConstant.DEVICE_KEY_DEVICE_TYPE, 3).withString("key_device_code", waspWingInfoF.getDeviceCode()).navigation();
    }

    public static final void l7(DeviceHomeFragment this$0) {
        f0.p(this$0, "this$0");
        ku.b.d(this$0.P4(), h0.d.f(this$0.P4(), R.color.white));
        ku.b.c(this$0.P4());
    }

    public static final void n7(DeviceHomeFragment this$0, NoticeBean.DialogBean dialogBean, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        int id2 = dialogBean.getId();
        String text = dialogBean.getButton().get(0).getText();
        f0.o(text, "item.button[0].text");
        this$0.k7(id2, text);
        String type = dialogBean.getButton().get(0).getType();
        f0.o(type, "item.button[0].type");
        String link = dialogBean.getButton().get(0).getLink();
        f0.o(link, "item.button[0].link");
        u9.d.a(type, link, ArticleReadLog.f13286d);
        dialogFragment.I5();
    }

    public static final void o7(DeviceHomeFragment this$0, NoticeBean.DialogBean dialogBean, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        int id2 = dialogBean.getId();
        String text = dialogBean.getButton().get(0).getText();
        f0.o(text, "item.button[0].text");
        this$0.k7(id2, text);
        String type = dialogBean.getButton().get(0).getType();
        f0.o(type, "item.button[0].type");
        String link = dialogBean.getButton().get(0).getLink();
        f0.o(link, "item.button[0].link");
        u9.d.a(type, link, ArticleReadLog.f13286d);
        dialogFragment.I5();
    }

    public static final void p7(DeviceHomeFragment this$0, NoticeBean.DialogBean dialogBean, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        int id2 = dialogBean.getId();
        String text = dialogBean.getButton().get(1).getText();
        f0.o(text, "item.button[1].text");
        this$0.k7(id2, text);
        String type = dialogBean.getButton().get(1).getType();
        f0.o(type, "item.button[1].type");
        String link = dialogBean.getButton().get(1).getLink();
        f0.o(link, "item.button[1].link");
        u9.d.a(type, link, ArticleReadLog.f13286d);
        dialogFragment.I5();
    }

    public static final void q7(DeviceHomeFragment this$0, NoticeBean.DialogBean dialogBean, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        int id2 = dialogBean.getId();
        String strC3 = this$0.c3(R.string.device_just_know);
        f0.o(strC3, "getString(R.string.device_just_know)");
        this$0.k7(id2, strC3);
        dialogFragment.I5();
    }

    public static final void s7(NoticeBean.TopBean topBean, DeviceHomeFragment this$0, View view) throws JSONException {
        f0.p(topBean, "$topBean");
        f0.p(this$0, "this$0");
        NoticeBean.ButtonBean buttonBean = topBean.getButton().get(0);
        String type = buttonBean.getType();
        f0.o(type, "button.type");
        String link = buttonBean.getLink();
        f0.o(link, "button.link");
        u9.d.a(type, link, ArticleReadLog.f13285c);
        u9.h.p(this$0.X1(), topBean.getTitle(), buttonBean.getType());
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        if (bundle == null) {
            ThreadUtils.M(new b());
        }
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_home;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        v0 v0VarD = v0.d(inflater, viewGroup, false);
        f0.o(v0VarD, "inflate(inflater, container, false)");
        this.B8 = v0VarD;
        if (v0VarD == null) {
            f0.S("binding");
            v0VarD = null;
        }
        LinearLayout root = v0VarD.getRoot();
        f0.o(root, "binding.root");
        return root;
    }

    @Override // com.flydigi.base.common.FZFragment
    public void S5() {
        H5().e(new Runnable() { // from class: com.flydigi.device_manager.ui.home.c
            @Override // java.lang.Runnable
            public final void run() {
                DeviceHomeFragment.l7(this.f15136a);
            }
        });
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void U3(boolean z10) {
        super.U3(z10);
        if (z10) {
            return;
        }
        i9.b.f(this, DataConstant.REMOTE_ACTION_REQUEST_BLUETOOTH_STATE);
    }

    public final DeviceHomeViewModel a7() {
        return (DeviceHomeViewModel) this.C8.getValue();
    }

    public final q9.h b7() {
        return (q9.h) this.D8.getValue();
    }

    public final t9.l c7() {
        return (t9.l) this.E8.getValue();
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        com.flydigi.userBehavior.a.a().b(X1(), "外设管理首页");
        ThreadUtils.M(new c());
        i9.b.f(this, DataConstant.REMOTE_ACTION_REQUEST_BLUETOOTH_STATE);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        Handler handler = G5();
        f0.o(handler, "handler");
        handler.postDelayed(new d(), 500L);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        v0 v0Var = this.B8;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("binding");
            v0Var = null;
        }
        com.blankj.utilcode.util.o.r(v0Var.f10518d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceHomeFragment.f7(this.f15289a, view2);
            }
        });
        v0 v0Var3 = this.B8;
        if (v0Var3 == null) {
            f0.S("binding");
            v0Var3 = null;
        }
        com.blankj.utilcode.util.o.r(v0Var3.f10521g, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceHomeFragment.g7(this.f15212a, view2);
            }
        });
        v0 v0Var4 = this.B8;
        if (v0Var4 == null) {
            f0.S("binding");
            v0Var4 = null;
        }
        com.blankj.utilcode.util.o.r(v0Var4.f10519e, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceHomeFragment.h7(this.f15211a, view2);
            }
        });
        v0 v0Var5 = this.B8;
        if (v0Var5 == null) {
            f0.S("binding");
            v0Var5 = null;
        }
        com.blankj.utilcode.util.o.r(v0Var5.f10520f, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceHomeFragment.i7(this.f15137a, view2);
            }
        });
        v0 v0Var6 = this.B8;
        if (v0Var6 == null) {
            f0.S("binding");
        } else {
            v0Var2 = v0Var6;
        }
        com.blankj.utilcode.util.o.r(v0Var2.f10522h, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeviceHomeFragment.j7(this.f15213a, view2);
            }
        });
        a7().l().k(l3(), new f(new ik.l<NoticeBean, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$onViewCreated$6
            {
                super(1);
            }

            public final void b(NoticeBean it2) {
                DeviceHomeFragment deviceHomeFragment = this.this$0;
                String deviceCode = it2.getDeviceCode();
                f0.o(deviceCode, "it.deviceCode");
                deviceHomeFragment.A8 = deviceCode;
                f0.o(it2.getTop(), "it.top");
                if (!r0.isEmpty()) {
                    DeviceHomeFragment deviceHomeFragment2 = this.this$0;
                    NoticeBean.TopBean topBean = it2.getTop().get(0);
                    f0.o(topBean, "it.top[0]");
                    deviceHomeFragment2.r7(topBean);
                } else {
                    v0 v0Var7 = this.this$0.B8;
                    if (v0Var7 == null) {
                        f0.S("binding");
                        v0Var7 = null;
                    }
                    CardView root = v0Var7.f10517c.getRoot();
                    f0.o(root, "binding.areaNotice.root");
                    o5.c.b(root, Boolean.FALSE, false, 2, null);
                }
                DeviceHomeFragment deviceHomeFragment3 = this.this$0;
                f0.o(it2, "it");
                deviceHomeFragment3.m7(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(NoticeBean noticeBean) {
                b(noticeBean);
                return z1.f38230a;
            }
        }));
        a7().m().k(l3(), new k0() { // from class: com.flydigi.device_manager.ui.home.i
            @Override // androidx.lifecycle.k0
            public final void b(Object obj) {
                DeviceHomeFragment.e7(this.f15290a, obj);
            }
        });
        l6().h().k(l3(), new f(new ik.l<GamepadInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$onViewCreated$8
            {
                super(1);
            }

            public final void b(GamepadInfo it2) {
                DeviceHomeViewModel deviceHomeViewModelA7 = this.this$0.a7();
                f0.o(it2, "it");
                deviceHomeViewModelA7.o(it2);
                v0 v0Var7 = this.this$0.B8;
                if (v0Var7 == null) {
                    f0.S("binding");
                    v0Var7 = null;
                }
                TextView textView = v0Var7.f10522h;
                f0.o(textView, "binding.btnRadiator");
                o5.c.b(textView, Boolean.valueOf((v5.a.j().k() == null || (this.this$0.F8 instanceof WaspWingInfo)) ? false : true), false, 2, null);
                v0 v0Var8 = this.this$0.B8;
                if (v0Var8 == null) {
                    f0.S("binding");
                    v0Var8 = null;
                }
                TextView textView2 = v0Var8.f10520f;
                f0.o(textView2, "binding.btnHeadset");
                o5.c.b(textView2, Boolean.valueOf((v5.a.j().i() == null || (this.this$0.F8 instanceof HeadsetInfo)) ? false : true), false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(GamepadInfo gamepadInfo) {
                b(gamepadInfo);
                return z1.f38230a;
            }
        }));
        b7().j().k(l3(), new f(new ik.l<HeadsetInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$onViewCreated$9
            {
                super(1);
            }

            public final void b(HeadsetInfo it2) {
                DeviceHomeViewModel deviceHomeViewModelA7 = this.this$0.a7();
                f0.o(it2, "it");
                DeviceHomeViewModel.s(deviceHomeViewModelA7, it2, null, 2, null);
                v0 v0Var7 = this.this$0.B8;
                if (v0Var7 == null) {
                    f0.S("binding");
                    v0Var7 = null;
                }
                TextView textView = v0Var7.f10520f;
                f0.o(textView, "binding.btnHeadset");
                o5.c.b(textView, Boolean.valueOf(!(this.this$0.F8 instanceof HeadsetInfo)), false, 2, null);
                v0 v0Var8 = this.this$0.B8;
                if (v0Var8 == null) {
                    f0.S("binding");
                    v0Var8 = null;
                }
                TextView textView2 = v0Var8.f10522h;
                f0.o(textView2, "binding.btnRadiator");
                o5.c.b(textView2, Boolean.valueOf((v5.a.j().k() == null || (this.this$0.F8 instanceof WaspWingInfo)) ? false : true), false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(HeadsetInfo headsetInfo) {
                b(headsetInfo);
                return z1.f38230a;
            }
        }));
        c7().h().k(l3(), new f(new ik.l<WaspWingInfo, z1>() { // from class: com.flydigi.device_manager.ui.home.DeviceHomeFragment$onViewCreated$10
            {
                super(1);
            }

            public final void b(WaspWingInfo it2) {
                DeviceHomeViewModel deviceHomeViewModelA7 = this.this$0.a7();
                f0.o(it2, "it");
                deviceHomeViewModelA7.r(it2, Boolean.valueOf((this.this$0.F8 instanceof HeadsetInfo) || (this.this$0.F8 instanceof WaspWingInfo)));
                v0 v0Var7 = this.this$0.B8;
                if (v0Var7 == null) {
                    f0.S("binding");
                    v0Var7 = null;
                }
                TextView textView = v0Var7.f10520f;
                f0.o(textView, "binding.btnHeadset");
                o5.c.b(textView, Boolean.valueOf((v5.a.j().i() == null || (this.this$0.F8 instanceof HeadsetInfo)) ? false : true), false, 2, null);
                v0 v0Var8 = this.this$0.B8;
                if (v0Var8 == null) {
                    f0.S("binding");
                    v0Var8 = null;
                }
                TextView textView2 = v0Var8.f10522h;
                f0.o(textView2, "binding.btnRadiator");
                o5.c.b(textView2, Boolean.valueOf(!(this.this$0.F8 instanceof WaspWingInfo)), false, 2, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(WaspWingInfo waspWingInfo) {
                b(waspWingInfo);
                return z1.f38230a;
            }
        }));
    }

    public final void k7(int i10, String str) {
        HashMap map = new HashMap();
        map.put("id", String.valueOf(i10));
        map.put("action", str);
        u9.g.a().e(X1(), "App_Notice_Dialog_Click", map);
    }

    public final void m7(NoticeBean noticeBean) {
        f0.o(noticeBean.getDialog(), "noticeBean.dialog");
        if (!r0.isEmpty()) {
            final NoticeBean.DialogBean dialogBean = noticeBean.getDialog().get(0);
            if (dialogBean.getCycle() < 0 || System.currentTimeMillis() - dialogBean.getLastShowTime() < dialogBean.getCycle()) {
                return;
            }
            FZDialog.a aVarJ = new FZDialog.a().t(dialogBean.getTitle()).j(dialogBean.getContent());
            if (com.blankj.utilcode.util.n0.x(dialogBean.getImage())) {
                aVarJ.o(dialogBean.getImage());
            }
            f0.o(dialogBean.getButton(), "item.button");
            if (!(!r4.isEmpty())) {
                aVarJ.q(c3(R.string.device_just_know)).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.b
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceHomeFragment.q7(this.f15134a, dialogBean, dialogFragment);
                    }
                });
            } else if (dialogBean.getButton().size() == 1) {
                aVarJ.q(dialogBean.getButton().get(0).getText()).p(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.l
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceHomeFragment.n7(this.f15295a, dialogBean, dialogFragment);
                    }
                });
            } else {
                aVarJ.d(dialogBean.getButton().get(0).getText()).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.k
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceHomeFragment.o7(this.f15293a, dialogBean, dialogFragment);
                    }
                });
                aVarJ.g(dialogBean.getButton().get(1).getText()).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.j
                    @Override // com.flydigi.base.widget.FZDialog.c
                    public final void a(DialogFragment dialogFragment) {
                        DeviceHomeFragment.p7(this.f15291a, dialogBean, dialogFragment);
                    }
                });
            }
            dialogBean.setLastShowTime(System.currentTimeMillis());
            a7().n(noticeBean);
            o5.a.t0(L2(), aVarJ.a());
        }
    }

    public final void r7(final NoticeBean.TopBean topBean) {
        v0 v0Var = this.B8;
        v0 v0Var2 = null;
        if (v0Var == null) {
            f0.S("binding");
            v0Var = null;
        }
        CardView root = v0Var.f10517c.getRoot();
        f0.o(root, "binding.areaNotice.root");
        o5.c.b(root, Boolean.TRUE, false, 2, null);
        v0 v0Var3 = this.B8;
        if (v0Var3 == null) {
            f0.S("binding");
            v0Var3 = null;
        }
        v0Var3.f10517c.f10052d.setText(topBean.getTitle());
        v0 v0Var4 = this.B8;
        if (v0Var4 == null) {
            f0.S("binding");
            v0Var4 = null;
        }
        v0Var4.f10517c.f10051c.setText(topBean.getContent());
        v0 v0Var5 = this.B8;
        if (v0Var5 == null) {
            f0.S("binding");
            v0Var5 = null;
        }
        TextView textView = v0Var5.f10517c.f10050b;
        f0.o(textView, "binding.areaNotice.tvAction");
        o5.c.b(textView, Boolean.valueOf(!androidx.core.util.j.a(topBean.getMessageType(), "0")), false, 2, null);
        f0.o(topBean.getButton(), "topBean.button");
        if (!r0.isEmpty()) {
            v0 v0Var6 = this.B8;
            if (v0Var6 == null) {
                f0.S("binding");
                v0Var6 = null;
            }
            v0Var6.f10517c.f10050b.setText(topBean.getButton().get(0).getText());
        } else {
            v0 v0Var7 = this.B8;
            if (v0Var7 == null) {
                f0.S("binding");
                v0Var7 = null;
            }
            v0Var7.f10517c.f10050b.setText(c3(R.string.device_more));
        }
        v0 v0Var8 = this.B8;
        if (v0Var8 == null) {
            f0.S("binding");
        } else {
            v0Var2 = v0Var8;
        }
        com.blankj.utilcode.util.o.r(v0Var2.f10517c.getRoot(), new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                DeviceHomeFragment.s7(topBean, this, view);
            }
        });
    }

    public final void t7(String str) {
        o5.a.t0(L2(), ScanFragment.f14524f9.a(str, false));
    }

    public final void u7(int i10, int i11) {
        SwitchMappingModeFragment switchMappingModeFragmentA = SwitchMappingModeFragment.f15304i9.a(i10, i11, i11, (88 & 8) != 0 ? Boolean.FALSE : null, (88 & 16) != 0 ? Boolean.FALSE : null, (88 & 32) != 0 ? Boolean.FALSE : Boolean.TRUE, (88 & 64) != 0 ? null : null);
        switchMappingModeFragmentA.C7(new g());
        o5.a.t0(L2(), switchMappingModeFragmentA);
    }
}
