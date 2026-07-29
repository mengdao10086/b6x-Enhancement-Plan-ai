package com.flydigi.device_manager.ui.mapping_mode;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import c7.c1;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.BleDialogFragment;
import i9.a;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import xi.z;

/* JADX INFO: loaded from: classes7.dex */
public final class SwitchMappingModeFragment extends BleDialogFragment {

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    @yt.k
    public static final a f15304i9 = new a(null);

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    @yt.k
    public static final String f15305j9 = "key_simple_choose";

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    @yt.k
    public static final String f15306k9 = "key_current_mapping_mode";

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    @yt.k
    public static final String f15307l9 = "key_selected_mapping_mode";

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    @yt.k
    public static final String f15308m9 = "key_suggest_mapping_mode";

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    @yt.k
    public static final String f15309n9 = "key_force_switch";

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    @yt.k
    public static final String f15310o9 = "key_auto_switch";

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    @yt.k
    public static final String f15311p9 = "key_notice_message";
    public boolean V8;
    public boolean W8;

    @yt.l
    public String X8;

    @yt.l
    public String Y8;
    public boolean Z8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public int f15312a9;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public boolean f15313b9;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public boolean f15315d9;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    @yt.l
    public b f15316e9;

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public c1 f15317f9;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public boolean f15318g9;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public boolean f15319h9;
    public int S8 = -1;
    public int T8 = -1;
    public int U8 = -1;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    @yt.k
    public String f15314c9 = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final SwitchMappingModeFragment a(int i10, int i11, int i12, @yt.l Boolean bool, @yt.l Boolean bool2, @yt.l Boolean bool3, @yt.l String str) {
            SwitchMappingModeFragment switchMappingModeFragment = new SwitchMappingModeFragment();
            switchMappingModeFragment.c5(androidx.core.os.e.b(new Pair(SwitchMappingModeFragment.f15305j9, bool), new Pair("key_current_mapping_mode", Integer.valueOf(i10)), new Pair("key_suggest_mapping_mode", Integer.valueOf(i11)), new Pair("key_selected_mapping_mode", Integer.valueOf(i12)), new Pair(SwitchMappingModeFragment.f15309n9, bool2), new Pair(SwitchMappingModeFragment.f15310o9, bool3), new Pair(SwitchMappingModeFragment.f15311p9, str)));
            return switchMappingModeFragment;
        }
    }

    public interface b {

        public static final class a {
            public static void a(@yt.k b bVar, int i10, int i11) {
            }

            public static void b(@yt.k b bVar, @yt.k String deviceCode, boolean z10) {
                f0.p(deviceCode, "deviceCode");
            }
        }

        void Q(int i10, int i11);

        void h(@yt.k String str, boolean z10);
    }

    @hk.m
    @yt.k
    public static final SwitchMappingModeFragment A7(int i10, int i11, int i12, @yt.l Boolean bool, @yt.l Boolean bool2, @yt.l Boolean bool3, @yt.l String str) {
        return f15304i9.a(i10, i11, i12, bool, bool2, bool3, str);
    }

    public static final void F7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void G7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final String H7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final void I7(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void K7(SwitchMappingModeFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        dialogFragment.I5();
        this$0.E7();
    }

    public static final void L7(DialogFragment dialogFragment) {
        dialogFragment.I5();
    }

    public static final void N7(SwitchMappingModeFragment this$0, View view) {
        b bVar;
        f0.p(this$0, "this$0");
        if (this$0.f15315d9 && (bVar = this$0.f15316e9) != null) {
            int i10 = this$0.S8;
            bVar.Q(i10, i10);
        }
        this$0.e6();
    }

    public static final void O7(SwitchMappingModeFragment this$0, View view) {
        int i10;
        f0.p(this$0, "this$0");
        if (this$0.f15315d9) {
            b bVar = this$0.f15316e9;
            if (bVar != null) {
                bVar.Q(this$0.S8, this$0.U8);
            }
            this$0.e6();
            return;
        }
        if (u9.b.d() && (i10 = this$0.U8) == 0 && i10 != this$0.S8) {
            this$0.J7();
        } else {
            this$0.E7();
        }
    }

    public static final void P7(SwitchMappingModeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        Postcard postcardD = h3.a.j().d(i9.a.f31902d);
        int i10 = this$0.f15312a9;
        String str = "https://bbs.flydigi.com/en/detail/60?hideTop=1";
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    str = o5.p.d() ? com.flydigi.device_manager.o.f14461e : com.flydigi.device_manager.o.f14466j;
                } else if (o5.p.d()) {
                    str = com.flydigi.device_manager.o.f14464h;
                }
            } else if (o5.p.d()) {
                str = com.flydigi.device_manager.o.f14465i;
            }
        } else if (o5.p.d()) {
            str = com.flydigi.device_manager.o.f14463g;
        }
        postcardD.withString(DataConstant.WEB_URL, str).navigation();
    }

    public static final void Q7(SwitchMappingModeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.U8 = 1;
        c1 c1Var = this$0.f15317f9;
        c1 c1Var2 = null;
        if (c1Var == null) {
            f0.S("viewBinding");
            c1Var = null;
        }
        this$0.D7(c1Var.f9886e, true);
        c1 c1Var3 = this$0.f15317f9;
        if (c1Var3 == null) {
            f0.S("viewBinding");
        } else {
            c1Var2 = c1Var3;
        }
        this$0.D7(c1Var2.f9887f, false);
    }

    public static final void R7(SwitchMappingModeFragment this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.U8 = 0;
        c1 c1Var = this$0.f15317f9;
        c1 c1Var2 = null;
        if (c1Var == null) {
            f0.S("viewBinding");
            c1Var = null;
        }
        this$0.D7(c1Var.f9886e, false);
        c1 c1Var3 = this$0.f15317f9;
        if (c1Var3 == null) {
            f0.S("viewBinding");
        } else {
            c1Var2 = c1Var3;
        }
        this$0.D7(c1Var2.f9887f, true);
    }

    @yt.l
    public final b B7() {
        return this.f15316e9;
    }

    public final void C7(@yt.l b bVar) {
        this.f15316e9 = bVar;
    }

    public final void D7(ViewGroup viewGroup, boolean z10) {
        if (viewGroup != null) {
            viewGroup.setSelected(z10);
        }
        if (this.U8 != -1) {
            c1 c1Var = null;
            if (this.V8) {
                c1 c1Var2 = this.f15317f9;
                if (c1Var2 == null) {
                    f0.S("viewBinding");
                } else {
                    c1Var = c1Var2;
                }
                c1Var.f9883b.setEnabled(this.U8 == this.T8);
                return;
            }
            c1 c1Var3 = this.f15317f9;
            if (c1Var3 == null) {
                f0.S("viewBinding");
            } else {
                c1Var = c1Var3;
            }
            c1Var.f9883b.setEnabled(true);
        }
    }

    public final void E7() {
        int i10 = this.U8;
        if (i10 == -1) {
            return;
        }
        if (!this.Z8) {
            com.flydigi.base.common.o.E(c3(R.string.device_you_disconnect_macro));
            return;
        }
        if (this.S8 == i10) {
            e6();
            return;
        }
        z zVarM3 = z.m3(Integer.valueOf(i10));
        final SwitchMappingModeFragment$switchMappingMode$disposable$1 switchMappingModeFragment$switchMappingMode$disposable$1 = new ik.l<Integer, String>() { // from class: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment$switchMappingMode$disposable$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k Integer it2) {
                f0.p(it2, "it");
                int iIntValue = it2.intValue();
                return iIntValue != 0 ? iIntValue != 1 ? iIntValue != 3 ? "" : DataConstant.REMOTE_ACTION_SWITCH_MODE_MI_8_DEVELOPER : DataConstant.REMOTE_ACTION_SWITCH_MODE_T : DataConstant.REMOTE_ACTION_SWITCH_MODE_DRIVER;
            }
        };
        z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.mapping_mode.b
            @Override // dj.o
            public final Object apply(Object obj) {
                return SwitchMappingModeFragment.H7(switchMappingModeFragment$switchMappingMode$disposable$1, obj);
            }
        });
        final ik.l<io.reactivex.disposables.b, z1> lVar = new ik.l<io.reactivex.disposables.b, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment$switchMappingMode$disposable$2
            {
                super(1);
            }

            public final void b(io.reactivex.disposables.b bVar) {
                View viewK3 = this.this$0.k3();
                if (viewK3 != null) {
                    o5.c.b(viewK3, Boolean.FALSE, false, 2, null);
                }
                SwitchMappingModeFragment switchMappingModeFragment = this.this$0;
                String strC3 = switchMappingModeFragment.c3(R.string.device_mode_switching);
                f0.o(strC3, "getString(R.string.device_mode_switching)");
                switchMappingModeFragment.j7(strC3);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(io.reactivex.disposables.b bVar) {
                b(bVar);
                return z1.f38230a;
            }
        };
        z zVarZ1 = zVarA3.Z1(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.i
            @Override // dj.g
            public final void accept(Object obj) {
                SwitchMappingModeFragment.I7(lVar, obj);
            }
        });
        final SwitchMappingModeFragment$switchMappingMode$disposable$3 switchMappingModeFragment$switchMappingMode$disposable$3 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment$switchMappingMode$disposable$3
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
        z zVarX1 = zVarZ1.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.k
            @Override // dj.g
            public final void accept(Object obj) {
                SwitchMappingModeFragment.F7(switchMappingModeFragment$switchMappingMode$disposable$3, obj);
            }
        }).x1(1000L, TimeUnit.MILLISECONDS);
        final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment$switchMappingMode$disposable$4
            {
                super(1);
            }

            public final void b(String str) {
                String str2 = this.this$0.Y8;
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
        zVarX1.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.mapping_mode.j
            @Override // dj.g
            public final void accept(Object obj) {
                SwitchMappingModeFragment.G7(lVar2, obj);
            }
        });
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.sdk.bluetooth.n
    public void G0(@yt.l BluetoothDevice bluetoothDevice, boolean z10) {
        super.G0(bluetoothDevice, z10);
        if (z10) {
            this.f15318g9 = true;
        }
        e6();
        if (this.Z8 || !this.f15318g9 || this.f15319h9) {
            return;
        }
        this.f15319h9 = true;
        b bVar = this.f15316e9;
        if (bVar != null) {
            bVar.h(H6(), false);
        }
    }

    public final void J7() {
        new FZDialog.a().t(c3(R.string.notice)).j(c3(R.string.device_notice_for_nubia)).g(c3(R.string.confirm)).b(Boolean.FALSE).d(c3(R.string.cancel)).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.mapping_mode.g
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SwitchMappingModeFragment.K7(this.f15336a, dialogFragment);
            }
        }).c(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.mapping_mode.h
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                SwitchMappingModeFragment.L7(dialogFragment);
            }
        }).a().Z5(U1(), "nubia");
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@yt.l Bundle bundle) {
        super.K3(bundle);
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            this.S8 = bundleT1.getInt("key_current_mapping_mode");
            this.T8 = bundleT1.getInt("key_suggest_mapping_mode");
            String string = bundleT1.getString(f15311p9);
            if (string == null) {
                string = "";
            }
            this.X8 = string;
            this.U8 = bundleT1.getInt("key_selected_mapping_mode", -1);
            this.f15315d9 = bundleT1.getBoolean(f15305j9);
            this.V8 = bundleT1.getBoolean(f15309n9);
            this.W8 = bundleT1.getBoolean(f15310o9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    @Override // com.flydigi.device_manager.ui.BleDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L6(@yt.k com.flydigi.sdk.gamepad.GamepadInfo r4) {
        /*
            r3 = this;
            java.lang.String r0 = "deviceInfo"
            kotlin.jvm.internal.f0.p(r4, r0)
            boolean r0 = r4.isConnected()
            r3.Z8 = r0
            java.lang.String r0 = r4.getDeviceCode()
            r3.i7(r0)
            java.lang.String r0 = r4.getAddress()
            r3.Y8 = r0
            int r0 = r4.getDeviceMode()
            r3.f15312a9 = r0
            java.lang.String r0 = r4.getFirmwareVersion()
            if (r0 != 0) goto L26
            java.lang.String r0 = ""
        L26:
            r3.f15314c9 = r0
            boolean r0 = r4.isSupportFlashplay()
            r3.f15313b9 = r0
            int r0 = r4.getMappingMode()
            r3.S8 = r0
            boolean r0 = r3.Z8
            if (r0 == 0) goto L60
            int r0 = com.flydigi.device_manager.ui.p.b(r4)
            boolean r1 = r3.W8
            if (r1 == 0) goto L4c
            int r1 = r3.S8
            int r2 = r3.T8
            if (r1 == r2) goto L4c
            r3.U8 = r2
            r3.E7()
            goto L7a
        L4c:
            int r1 = r4.getMappingMode()
            if (r0 == r1) goto L7a
            int r4 = r4.getMappingMode()
            r3.S8 = r4
            r3.T8 = r0
            r3.U8 = r0
            r3.E7()
            goto L7a
        L60:
            boolean r4 = r3.f15318g9
            if (r4 == 0) goto L7a
            r3.e6()
            boolean r4 = r3.f15319h9
            if (r4 != 0) goto L7a
            r4 = 1
            r3.f15319h9 = r4
            com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment$b r4 = r3.f15316e9
            if (r4 == 0) goto L7a
            java.lang.String r0 = r3.H6()
            r1 = 0
            r4.h(r0, r1)
        L7a:
            boolean r4 = r3.s3()
            if (r4 == 0) goto L83
            r3.M7()
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.L6(com.flydigi.sdk.gamepad.GamepadInfo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M7() {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.mapping_mode.SwitchMappingModeFragment.M7():void");
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, androidx.fragment.app.Fragment
    @yt.k
    public View O3(@yt.k LayoutInflater inflater, @yt.l ViewGroup viewGroup, @yt.l Bundle bundle) {
        f0.p(inflater, "inflater");
        c1 c1VarD = c1.d(inflater, viewGroup, false);
        f0.o(c1VarD, "inflate(inflater, container, false)");
        this.f15317f9 = c1VarD;
        if (c1VarD == null) {
            f0.S("viewBinding");
            c1VarD = null;
        }
        FrameLayout root = c1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    @Override // com.flydigi.base.common.BaseDialogFragment
    public int c6() {
        return R.layout.device_fragment_mapping_mode;
    }

    @Override // com.flydigi.device_manager.ui.BleDialogFragment, com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        c1 c1Var = this.f15317f9;
        c1 c1Var2 = null;
        if (c1Var == null) {
            f0.S("viewBinding");
            c1Var = null;
        }
        if (c1Var.f9886e.isSelected()) {
            this.U8 = 1;
            return;
        }
        c1 c1Var3 = this.f15317f9;
        if (c1Var3 == null) {
            f0.S("viewBinding");
        } else {
            c1Var2 = c1Var3;
        }
        if (c1Var2.f9887f.isSelected()) {
            this.U8 = 0;
        }
    }

    @Override // com.flydigi.base.common.BaseDialogFragment, com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @yt.l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        M7();
    }
}
