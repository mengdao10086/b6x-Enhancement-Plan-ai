package com.flydigi.cyberfox.ui.detail.x1;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import androidx.lifecycle.k0;
import androidx.lifecycle.r;
import androidx.lifecycle.z0;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.j1;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.base.common.FZFragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.cyberfox.R;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.sdk.bluetooth.t;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.umeng.analytics.pro.an;
import i9.a;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.b0;
import kotlin.collections.r0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import kotlin.z1;
import p1.a;
import q9.e;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nX1DetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 X1DetailFragment.kt\ncom/flydigi/cyberfox/ui/detail/x1/X1DetailFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,325:1\n106#2,15:326\n*S KotlinDebug\n*F\n+ 1 X1DetailFragment.kt\ncom/flydigi/cyberfox/ui/detail/x1/X1DetailFragment\n*L\n40#1:326,15\n*E\n"})
public final class X1DetailFragment extends FZFragment implements t, q9.e {

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    @yt.k
    public static final a f14234q8 = new a(null);

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public h6.k f14235o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @yt.k
    public final z f14236p8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final X1DetailFragment a() {
            return new X1DetailFragment();
        }
    }

    public static final class b implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f14237a;

        public b(ik.l function) {
            f0.p(function, "function");
            this.f14237a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @yt.k
        public final kotlin.u<?> a() {
            return this.f14237a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f14237a.i(obj);
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

    public X1DetailFragment() {
        final ik.a<Fragment> aVar = new ik.a<Fragment>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$special$$inlined$viewModels$default$1
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
        final z zVarC = b0.c(LazyThreadSafetyMode.NONE, new ik.a<d1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$special$$inlined$viewModels$default$2
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
        this.f14236p8 = FragmentViewModelLazyKt.h(this, n0.d(X1DetailViewModel.class), new ik.a<c1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$special$$inlined$viewModels$default$3
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
        }, new ik.a<p1.a>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$special$$inlined$viewModels$default$4
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
        }, new ik.a<z0.b>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$special$$inlined$viewModels$default$5
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

    public static final void A6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.E(2);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair(an.aT, "超低延迟")));
    }

    public static final void B6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(0);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "普通")));
    }

    public static final void C6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(3);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "流行")));
    }

    public static final void D6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(2);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "摇滚")));
    }

    public static final void E6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(1);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "民谣")));
    }

    public static final void F6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(4);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "说唱")));
    }

    public static final void G6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(5);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "电子")));
    }

    public static final void H6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(6);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", "古典")));
    }

    public static final void J6(X1DetailFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        h3.a.j().d(a.c.f31943b).withString("key_device_code", q9.c.f47168e).withParcelable("key_device_info", this$0.u6().n().f()).withParcelable(DataConstant.DEVICE_KEY_FIRMWARE_INFO, this$0.u6().o().f()).navigation();
        dialogFragment.H5();
    }

    public static final void v6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.E(1);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair(an.aT, "低延迟")));
    }

    public static final void w6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.E(0);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair(an.aT, "正常")));
    }

    public static final void x6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        q9.f.f47178a.D(7);
        u9.g.a().e(this$0.R4(), "Headset_Detail_x1", r0.k(new Pair("eq", ArticleReadLog.f13288f)));
    }

    public static final void y6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(a.c.f31943b).withString("key_device_code", q9.c.f47168e).withParcelable("key_device_info", this$0.u6().n().f()).withParcelable(DataConstant.DEVICE_KEY_FIRMWARE_INFO, this$0.u6().o().f()).navigation();
    }

    public static final void z6(X1DetailFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, f6.b.f27994d).navigation(this$0.w1());
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        e.a.c(this, bluetoothDevice);
    }

    @Override // q9.e
    public void H2(@yt.k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        u6().r(deviceInfo);
    }

    public final void I6() {
        if (d0.B(U1(), "FirmwareUpgradeForce") != null) {
            return;
        }
        new FZDialog.a().t(c3(R.string.cf_firmware_upgrade_please)).j(c3(R.string.cf_firmware_not_same)).q(c3(R.string.cf_firmware_upgrade_do_action)).p(new FZDialog.c() { // from class: com.flydigi.cyberfox.ui.detail.x1.e
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                X1DetailFragment.J6(this.f14248a, dialogFragment);
            }
        }).a().Z5(U1(), "FirmwareUpgradeForce");
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        q9.f.u(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.cf_fragment_detail_x1;
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void N(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.b(this, bluetoothDevice);
        u6().q(false);
    }

    @Override // q9.e
    public void N0(@yt.k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        u6().r(deviceInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt bluetoothGatt) {
        e.a.f(this, bluetoothGatt);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        h6.k kVarD = h6.k.d(inflater, viewGroup, false);
        f0.o(kVarD, "inflate(inflater, container, false)");
        this.f14235o8 = kVarD;
        if (kVarD == null) {
            f0.S("viewBinding");
            kVarD = null;
        }
        NestedScrollView nestedScrollViewB = kVarD.getRoot();
        f0.o(nestedScrollViewB, "viewBinding.root");
        return nestedScrollViewB;
    }

    @Override // q9.e
    public void P0(@yt.k HeadsetInfo deviceInfo, boolean z10) {
        f0.p(deviceInfo, "deviceInfo");
        u6().r(deviceInfo);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        q9.f.d();
        q9.f.I(this);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice bluetoothDevice) {
        e.a.e(this, bluetoothDevice);
    }

    @Override // q9.e
    public void Z0(@yt.k HeadsetInfo deviceInfo, boolean z10) {
        f0.p(deviceInfo, "deviceInfo");
        u6().r(deviceInfo);
    }

    @Override // com.flydigi.sdk.bluetooth.t
    public void e0(@yt.l BluetoothDevice bluetoothDevice) {
        t.a.a(this, bluetoothDevice);
        u6().k(bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice bluetoothDevice) {
        e.a.d(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        e.a.b(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        h6.k kVar = this.f14235o8;
        h6.k kVar2 = null;
        if (kVar == null) {
            f0.S("viewBinding");
            kVar = null;
        }
        kVar.D.setText(s6.a.b(q9.c.f47168e));
        h6.k kVar3 = this.f14235o8;
        if (kVar3 == null) {
            f0.S("viewBinding");
            kVar3 = null;
        }
        kVar3.f30654x.setImageResource(s6.a.f49519a.c(q9.c.f47168e));
        u6().m().k(l3(), new b(new ik.l<Boolean, z1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(Boolean bool) {
                if (bool.booleanValue()) {
                    return;
                }
                X1DetailViewModel.l(this.this$0.u6(), null, 1, null);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Boolean bool) {
                b(bool);
                return z1.f38230a;
            }
        }));
        u6().n().k(l3(), new b(new ik.l<HeadsetInfo, z1>() { // from class: com.flydigi.cyberfox.ui.detail.x1.X1DetailFragment$onViewCreated$2
            {
                super(1);
            }

            public final void b(HeadsetInfo it2) {
                h6.k kVar4 = this.this$0.f14235o8;
                h6.k kVar5 = null;
                if (kVar4 == null) {
                    f0.S("viewBinding");
                    kVar4 = null;
                }
                kVar4.f30633c.setEnabled(it2.getConnected());
                h6.k kVar6 = this.this$0.f14235o8;
                if (kVar6 == null) {
                    f0.S("viewBinding");
                    kVar6 = null;
                }
                kVar6.H.setText(it2.getConnected() ? R.string.cf_state_connected : R.string.cf_state_unconnected);
                h6.k kVar7 = this.this$0.f14235o8;
                if (kVar7 == null) {
                    f0.S("viewBinding");
                    kVar7 = null;
                }
                kVar7.H.setTextColor(h0.d.f(j1.a(), it2.getConnected() ? R.color.colorAccentGreen : R.color.color_000000_a50));
                h6.k kVar8 = this.this$0.f14235o8;
                if (kVar8 == null) {
                    f0.S("viewBinding");
                    kVar8 = null;
                }
                boolean z10 = false;
                kVar8.A.setVisibility(it2.getConnected() ? 0 : 8);
                h6.k kVar9 = this.this$0.f14235o8;
                if (kVar9 == null) {
                    f0.S("viewBinding");
                    kVar9 = null;
                }
                kVar9.f30652v.setVisibility(it2.getConnected() ? 0 : 8);
                h6.k kVar10 = this.this$0.f14235o8;
                if (kVar10 == null) {
                    f0.S("viewBinding");
                    kVar10 = null;
                }
                kVar10.B.setVisibility(it2.getConnected() ? 0 : 8);
                h6.k kVar11 = this.this$0.f14235o8;
                if (kVar11 == null) {
                    f0.S("viewBinding");
                    kVar11 = null;
                }
                kVar11.f30653w.setVisibility(it2.getConnected() ? 0 : 8);
                h6.k kVar12 = this.this$0.f14235o8;
                if (kVar12 == null) {
                    f0.S("viewBinding");
                    kVar12 = null;
                }
                kVar12.f30656z.setVisibility(it2.getConnected() ? 0 : 8);
                h6.k kVar13 = this.this$0.f14235o8;
                if (kVar13 == null) {
                    f0.S("viewBinding");
                    kVar13 = null;
                }
                kVar13.f30651u.setVisibility(it2.getConnected() ? 0 : 8);
                if (it2.getBatteryLeft() >= 0) {
                    h6.k kVar14 = this.this$0.f14235o8;
                    if (kVar14 == null) {
                        f0.S("viewBinding");
                        kVar14 = null;
                    }
                    TextView textView = kVar14.A;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.this$0.t6(it2.getBatteryLeft()));
                    sb2.append('%');
                    textView.setText(sb2.toString());
                    h6.k kVar15 = this.this$0.f14235o8;
                    if (kVar15 == null) {
                        f0.S("viewBinding");
                        kVar15 = null;
                    }
                    kVar15.f30652v.setPower(this.this$0.t6(it2.getBatteryLeft()));
                }
                if (it2.getBatteryRight() >= 0) {
                    h6.k kVar16 = this.this$0.f14235o8;
                    if (kVar16 == null) {
                        f0.S("viewBinding");
                        kVar16 = null;
                    }
                    TextView textView2 = kVar16.B;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.this$0.t6(it2.getBatteryRight()));
                    sb3.append('%');
                    textView2.setText(sb3.toString());
                    h6.k kVar17 = this.this$0.f14235o8;
                    if (kVar17 == null) {
                        f0.S("viewBinding");
                        kVar17 = null;
                    }
                    kVar17.f30653w.setPower(this.this$0.t6(it2.getBatteryRight()));
                }
                if (it2.getBatteryBox() >= 0) {
                    h6.k kVar18 = this.this$0.f14235o8;
                    if (kVar18 == null) {
                        f0.S("viewBinding");
                        kVar18 = null;
                    }
                    TextView textView3 = kVar18.f30656z;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.this$0.t6(it2.getBatteryBox()));
                    sb4.append('%');
                    textView3.setText(sb4.toString());
                    h6.k kVar19 = this.this$0.f14235o8;
                    if (kVar19 == null) {
                        f0.S("viewBinding");
                        kVar19 = null;
                    }
                    kVar19.f30651u.setPower(this.this$0.t6(it2.getBatteryBox()));
                }
                h6.k kVar20 = this.this$0.f14235o8;
                if (kVar20 == null) {
                    f0.S("viewBinding");
                    kVar20 = null;
                }
                kVar20.f30646p.setSelected(it2.getConnected() && it2.getLatency() == 1);
                h6.k kVar21 = this.this$0.f14235o8;
                if (kVar21 == null) {
                    f0.S("viewBinding");
                    kVar21 = null;
                }
                kVar21.f30647q.setSelected(it2.getConnected() && it2.getLatency() == 2);
                h6.k kVar22 = this.this$0.f14235o8;
                if (kVar22 == null) {
                    f0.S("viewBinding");
                    kVar22 = null;
                }
                kVar22.f30648r.setSelected(it2.getConnected() && it2.getLatency() == 0);
                h6.k kVar23 = this.this$0.f14235o8;
                if (kVar23 == null) {
                    f0.S("viewBinding");
                    kVar23 = null;
                }
                kVar23.C.setText(it2.getLatency() == 2 ? R.string.cf_latency_lowest_x1_desc : R.string.cf_latency_switch_by_touch_x1);
                h6.k kVar24 = this.this$0.f14235o8;
                if (kVar24 == null) {
                    f0.S("viewBinding");
                    kVar24 = null;
                }
                kVar24.f30642l.setSelected(it2.getConnected() && it2.getEqMode() == 0);
                h6.k kVar25 = this.this$0.f14235o8;
                if (kVar25 == null) {
                    f0.S("viewBinding");
                    kVar25 = null;
                }
                kVar25.f30643m.setSelected(it2.getConnected() && it2.getEqMode() == 3);
                h6.k kVar26 = this.this$0.f14235o8;
                if (kVar26 == null) {
                    f0.S("viewBinding");
                    kVar26 = null;
                }
                kVar26.f30645o.setSelected(it2.getConnected() && it2.getEqMode() == 2);
                h6.k kVar27 = this.this$0.f14235o8;
                if (kVar27 == null) {
                    f0.S("viewBinding");
                    kVar27 = null;
                }
                kVar27.f30640j.setSelected(it2.getConnected() && it2.getEqMode() == 1);
                h6.k kVar28 = this.this$0.f14235o8;
                if (kVar28 == null) {
                    f0.S("viewBinding");
                    kVar28 = null;
                }
                kVar28.f30644n.setSelected(it2.getConnected() && it2.getEqMode() == 4);
                h6.k kVar29 = this.this$0.f14235o8;
                if (kVar29 == null) {
                    f0.S("viewBinding");
                    kVar29 = null;
                }
                kVar29.f30639i.setSelected(it2.getConnected() && it2.getEqMode() == 5);
                h6.k kVar30 = this.this$0.f14235o8;
                if (kVar30 == null) {
                    f0.S("viewBinding");
                    kVar30 = null;
                }
                kVar30.f30638h.setSelected(it2.getConnected() && it2.getEqMode() == 6);
                h6.k kVar31 = this.this$0.f14235o8;
                if (kVar31 == null) {
                    f0.S("viewBinding");
                    kVar31 = null;
                }
                TextView textView4 = kVar31.f30641k;
                if (it2.getConnected() && it2.getEqMode() == 7) {
                    z10 = true;
                }
                textView4.setSelected(z10);
                h6.k kVar32 = this.this$0.f14235o8;
                if (kVar32 == null) {
                    f0.S("viewBinding");
                } else {
                    kVar5 = kVar32;
                }
                kVar5.f30650t.setEnabled(it2.getConnected());
                if (it2.getConnected()) {
                    X1DetailFragment x1DetailFragment = this.this$0;
                    f0.o(it2, "it");
                    x1DetailFragment.s6(it2, this.this$0.u6().o().f());
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(HeadsetInfo headsetInfo) {
                b(headsetInfo);
                return z1.f38230a;
            }
        }));
        h6.k kVar4 = this.f14235o8;
        if (kVar4 == null) {
            f0.S("viewBinding");
            kVar4 = null;
        }
        com.blankj.utilcode.util.o.r(kVar4.f30646p, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.v6(this.f14244a, view2);
            }
        });
        h6.k kVar5 = this.f14235o8;
        if (kVar5 == null) {
            f0.S("viewBinding");
            kVar5 = null;
        }
        com.blankj.utilcode.util.o.r(kVar5.f30648r, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.w6(this.f14252a, view2);
            }
        });
        h6.k kVar6 = this.f14235o8;
        if (kVar6 == null) {
            f0.S("viewBinding");
            kVar6 = null;
        }
        com.blankj.utilcode.util.o.r(kVar6.f30647q, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.A6(this.f14257a, view2);
            }
        });
        h6.k kVar7 = this.f14235o8;
        if (kVar7 == null) {
            f0.S("viewBinding");
            kVar7 = null;
        }
        com.blankj.utilcode.util.o.r(kVar7.f30642l, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.B6(this.f14255a, view2);
            }
        });
        h6.k kVar8 = this.f14235o8;
        if (kVar8 == null) {
            f0.S("viewBinding");
            kVar8 = null;
        }
        com.blankj.utilcode.util.o.r(kVar8.f30643m, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.C6(this.f14254a, view2);
            }
        });
        h6.k kVar9 = this.f14235o8;
        if (kVar9 == null) {
            f0.S("viewBinding");
            kVar9 = null;
        }
        com.blankj.utilcode.util.o.r(kVar9.f30645o, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.D6(this.f14245a, view2);
            }
        });
        h6.k kVar10 = this.f14235o8;
        if (kVar10 == null) {
            f0.S("viewBinding");
            kVar10 = null;
        }
        com.blankj.utilcode.util.o.r(kVar10.f30640j, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.E6(this.f14258a, view2);
            }
        });
        h6.k kVar11 = this.f14235o8;
        if (kVar11 == null) {
            f0.S("viewBinding");
            kVar11 = null;
        }
        com.blankj.utilcode.util.o.r(kVar11.f30644n, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.F6(this.f14253a, view2);
            }
        });
        h6.k kVar12 = this.f14235o8;
        if (kVar12 == null) {
            f0.S("viewBinding");
            kVar12 = null;
        }
        com.blankj.utilcode.util.o.r(kVar12.f30639i, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.G6(this.f14256a, view2);
            }
        });
        h6.k kVar13 = this.f14235o8;
        if (kVar13 == null) {
            f0.S("viewBinding");
            kVar13 = null;
        }
        com.blankj.utilcode.util.o.r(kVar13.f30638h, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.H6(this.f14246a, view2);
            }
        });
        h6.k kVar14 = this.f14235o8;
        if (kVar14 == null) {
            f0.S("viewBinding");
            kVar14 = null;
        }
        com.blankj.utilcode.util.o.r(kVar14.f30641k, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.x6(this.f14247a, view2);
            }
        });
        h6.k kVar15 = this.f14235o8;
        if (kVar15 == null) {
            f0.S("viewBinding");
            kVar15 = null;
        }
        com.blankj.utilcode.util.o.r(kVar15.f30650t, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.y6(this.f14251a, view2);
            }
        });
        h6.k kVar16 = this.f14235o8;
        if (kVar16 == null) {
            f0.S("viewBinding");
        } else {
            kVar2 = kVar16;
        }
        com.blankj.utilcode.util.o.r(kVar2.f30649s, new View.OnClickListener() { // from class: com.flydigi.cyberfox.ui.detail.x1.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                X1DetailFragment.z6(this.f14250a, view2);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        e.a.h(this, i10);
    }

    @Override // q9.e
    public void o2(@yt.l String str, @yt.l String str2) {
    }

    @Override // q9.e
    public void p(@yt.k HeadsetInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        u6().r(deviceInfo);
    }

    public final void s6(HeadsetInfo headsetInfo, FirmwareInfoBean firmwareInfoBean) {
        if (!com.blankj.utilcode.util.n0.b(headsetInfo.getFirmwareLeft(), headsetInfo.getFirmwareRight())) {
            H5().g(new Runnable() { // from class: com.flydigi.cyberfox.ui.detail.x1.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14249a.I6();
                }
            });
            H5().f(new Runnable() { // from class: com.flydigi.cyberfox.ui.detail.x1.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14249a.I6();
                }
            }, 1000L);
        }
        h6.k kVar = null;
        if (firmwareInfoBean != null) {
            String str = firmwareInfoBean.url;
            if (!(str == null || str.length() == 0)) {
                String firmwareLeft = headsetInfo.getFirmwareLeft();
                if (!(firmwareLeft == null || firmwareLeft.length() == 0)) {
                    String firmwareRight = headsetInfo.getFirmwareRight();
                    if (!(firmwareRight == null || firmwareRight.length() == 0) && headsetInfo.getConnected()) {
                        if (Objects.equals(headsetInfo.getFirmwareLeft(), firmwareInfoBean.version) && Objects.equals(headsetInfo.getFirmwareRight(), firmwareInfoBean.version)) {
                            h6.k kVar2 = this.f14235o8;
                            if (kVar2 == null) {
                                f0.S("viewBinding");
                            } else {
                                kVar = kVar2;
                            }
                            kVar.f30650t.T(Boolean.FALSE);
                            return;
                        }
                        h6.k kVar3 = this.f14235o8;
                        if (kVar3 == null) {
                            f0.S("viewBinding");
                        } else {
                            kVar = kVar3;
                        }
                        kVar.f30650t.T(Boolean.TRUE);
                        return;
                    }
                }
            }
        }
        h6.k kVar4 = this.f14235o8;
        if (kVar4 == null) {
            f0.S("viewBinding");
        } else {
            kVar = kVar4;
        }
        kVar.f30650t.T(Boolean.FALSE);
    }

    public final int t6(int i10) {
        if (i10 < 10) {
            return 10;
        }
        if (i10 < 20) {
            return 20;
        }
        if (i10 < 30) {
            return 30;
        }
        if (i10 < 40) {
            return 40;
        }
        if (i10 < 50) {
            return 50;
        }
        if (i10 < 60) {
            return 60;
        }
        if (i10 < 70) {
            return 70;
        }
        if (i10 < 80) {
            return 80;
        }
        return i10 < 86 ? 90 : 100;
    }

    public final X1DetailViewModel u6() {
        return (X1DetailViewModel) this.f14236p8.getValue();
    }
}
