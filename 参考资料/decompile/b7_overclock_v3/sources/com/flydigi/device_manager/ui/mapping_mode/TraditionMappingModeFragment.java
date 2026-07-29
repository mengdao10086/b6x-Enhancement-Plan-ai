package com.flydigi.device_manager.ui.mapping_mode;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c7.d1;
import com.blankj.utilcode.util.j1;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.BleDialogFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import i9.a;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class TraditionMappingModeFragment extends BleDialogFragment {

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    @yt.k
    public static final a f15322c9 = new a(null);

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    @yt.k
    public static final String f15323d9 = "key_current_mapping_mode";

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    @yt.k
    public static final String f15324e9 = "key_selected_mapping_mode";

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    @yt.k
    public static final String f15325f9 = "key_suggest_mapping_mode";

    @yt.l
    public String V8;
    public boolean W8;
    public int X8;
    public boolean Y8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    @yt.l
    public b f15326a9;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public d1 f15327b9;
    public int S8 = -1;
    public int T8 = -1;
    public int U8 = -1;

    @yt.k
    public String Z8 = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final TraditionMappingModeFragment a(int i10, int i11, int i12) {
            TraditionMappingModeFragment traditionMappingModeFragment = new TraditionMappingModeFragment();
            traditionMappingModeFragment.c5(androidx.core.os.e.b(new Pair("key_current_mapping_mode", Integer.valueOf(i10)), new Pair("key_suggest_mapping_mode", Integer.valueOf(i11)), new Pair("key_selected_mapping_mode", Integer.valueOf(i12))));
            return traditionMappingModeFragment;
        }
    }

    public interface b {

        public static final class a {
            public static void a(@yt.k b bVar, @yt.k String deviceCode, boolean z10) {
                f0.p(deviceCode, "deviceCode");
            }
        }

        void h(@yt.k String str, boolean z10);
    }

    public static final String B7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final void C7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void D7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void E7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @hk.m
    @yt.k
    public static final TraditionMappingModeFragment v7(int i10, int i11, int i12) {
        return f15322c9.a(i10, i11, i12);
    }

    public static final void x7(TraditionMappingModeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.e6();
    }

    public static final void y7(View view) {
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, com.flydigi.device_manager.o.f14462f).navigation();
    }

    public final void A7() {
        int i10 = this.U8;
        if (i10 == -1) {
            return;
        }
        if (!this.W8) {
            com.flydigi.base.common.o.E(c3(R.string.device_you_disconnect_macro));
            return;
        }
        if (this.S8 == i10) {
            e6();
            return;
        }
        z zVarM3 = z.m3(Integer.valueOf(i10));
        final TraditionMappingModeFragment$switchMappingMode$disposable$1 traditionMappingModeFragment$switchMappingMode$disposable$1 = new ik.l<Integer, String>() { // from class: com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment$switchMappingMode$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k Integer it2) {
                f0.p(it2, "it");
                int iIntValue = it2.intValue();
                return iIntValue != 0 ? iIntValue != 1 ? iIntValue != 3 ? "" : DataConstant.REMOTE_ACTION_SWITCH_MODE_MI_8_DEVELOPER : DataConstant.REMOTE_ACTION_SWITCH_MODE_T : DataConstant.REMOTE_ACTION_SWITCH_MODE_DRIVER;
            }
        };
        z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.mapping_mode.q
            @Override // dj.o
            public final Object apply(Object obj) {
                return TraditionMappingModeFragment.B7(traditionMappingModeFragment$switchMappingMode$disposable$1, obj);
            }
        });
        final ik.l<io.reactivex.disposables.b, z1> lVar = new ik.l<io.reactivex.disposables.b, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment$switchMappingMode$disposable$2
            {
                super(1);
            }

            public final void b(io.reactivex.disposables.b bVar) {
                View viewK3 = this.this$0.k3();
                if (viewK3 != null) {
                    o5.c.b(viewK3, Boolean.FALSE, false, 2, null);
                }
                TraditionMappingModeFragment traditionMappingModeFragment = this.this$0;
                String strC3 = traditionMappingModeFragment.c3(R.string.device_mode_switching);
                f0.o(strC3, "getString(R.string.device_mode_switching)");
                traditionMappingModeFragment.j7(strC3);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(io.reactivex.disposables.b bVar) {
                b(bVar);
                return z1.f38230a;
            }
        };
        z zVarZ1 = zVarA3.Z1(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.n
            @Override // dj.g
            public final void accept(Object obj) {
                TraditionMappingModeFragment.C7(lVar, obj);
            }
        });
        final TraditionMappingModeFragment$switchMappingMode$disposable$3 traditionMappingModeFragment$switchMappingMode$disposable$3 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment$switchMappingMode$disposable$3
            public final void b(String str) {
                Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
                f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
                ((IRemoteProvider) objNavigation).l(j1.a(), str);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        z zVarX1 = zVarZ1.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.o
            @Override // dj.g
            public final void accept(Object obj) {
                TraditionMappingModeFragment.D7(traditionMappingModeFragment$switchMappingMode$disposable$3, obj);
            }
        }).x1(1000L, TimeUnit.MILLISECONDS);
        final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.TraditionMappingModeFragment$switchMappingMode$disposable$4
            {
                super(1);
            }

            public final void b(String str) {
                String str2 = this.this$0.V8;
                if (str2 != null) {
                    this.this$0.c7(str2);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        zVarX1.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.p
            @Override // dj.g
            public final void accept(Object obj) {
                TraditionMappingModeFragment.E7(lVar2, obj);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        super.G0(bluetoothDevice, z10);
        if (z10) {
            e6();
            b bVar = this.f15326a9;
            if (bVar != null) {
                bVar.h(H6(), false);
            }
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.S8 = bundleT1.getInt("key_current_mapping_mode");
            this.T8 = bundleT1.getInt("key_suggest_mapping_mode");
            this.U8 = bundleT1.getInt("key_selected_mapping_mode", -1);
        }
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    public void L6(@yt.k GamepadInfo deviceInfo) {
        int iB;
        f0.p(deviceInfo, "deviceInfo");
        this.W8 = deviceInfo.isConnected();
        i7(deviceInfo.getDeviceCode());
        this.V8 = deviceInfo.getAddress();
        this.X8 = deviceInfo.getDeviceMode();
        String firmwareVersion = deviceInfo.getFirmwareVersion();
        if (firmwareVersion == null) {
            firmwareVersion = "";
        }
        this.Z8 = firmwareVersion;
        this.Y8 = deviceInfo.isSupportFlashplay();
        this.S8 = deviceInfo.getMappingMode();
        if (!this.W8 || (iB = com.flydigi.device_manager.ui.p.b(deviceInfo)) == deviceInfo.getMappingMode()) {
            return;
        }
        this.S8 = deviceInfo.getMappingMode();
        this.T8 = iB;
        this.U8 = iB;
        A7();
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        d1 d1VarD = d1.d(inflater, viewGroup, false);
        f0.o(d1VarD, "inflate(inflater, container, false)");
        this.f15327b9 = d1VarD;
        if (d1VarD == null) {
            f0.S("viewBinding");
            d1VarD = null;
        }
        FrameLayout root = d1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_fragment_mapping_mode_tradition_pro;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        d1 d1Var = this.f15327b9;
        d1 d1Var2 = null;
        if (d1Var == null) {
            f0.S("viewBinding");
            d1Var = null;
        }
        com.blankj.utilcode.util.o.r(d1Var.f9929c, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.mapping_mode.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TraditionMappingModeFragment.x7(this.f15341a, view2);
            }
        });
        d1 d1Var3 = this.f15327b9;
        if (d1Var3 == null) {
            f0.S("viewBinding");
            d1Var3 = null;
        }
        com.blankj.utilcode.util.o.r(d1Var3.f9930d, new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.mapping_mode.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TraditionMappingModeFragment.y7(view2);
            }
        });
        d1 d1Var4 = this.f15327b9;
        if (d1Var4 == null) {
            f0.S("viewBinding");
        } else {
            d1Var2 = d1Var4;
        }
        d1Var2.f9932f.setSelected(true);
    }

    @yt.l
    public final b w7() {
        return this.f15326a9;
    }

    public final void z7(@yt.l b bVar) {
        this.f15326a9 = bVar;
    }
}
