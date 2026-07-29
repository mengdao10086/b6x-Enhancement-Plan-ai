package com.flydigi.device_manager.ui.apex_space.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.g;
import c7.b1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.o;
import com.flydigi.base.common.y;
import com.flydigi.base.widget.FZDialogV2;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.apex_space.ui.LedSettingFragment;
import com.flydigi.device_manager.ui.apex_space.view.ColorPicker;
import com.flydigi.device_manager.ui.apex_space.view.ColorSeekBar;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.google.android.material.tabs.TabLayout;
import hk.m;
import i9.a;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m9.h;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class LedSettingFragment extends BaseGamepadFragment {
    public static final int L8 = 1;
    public static final int M8 = 2;
    public static final int N8 = 3;
    public b1 A8;

    @l
    public String B8;

    @l
    public d7.a C8;

    @l
    public d7.a D8;

    @l
    public d7.a E8;

    @l
    public d7.a F8;

    @l
    public d7.a G8;
    public int H8 = 1;
    public int I8;
    public boolean J8;

    @k
    public static final a K8 = new a(null);

    @k
    public static final ArrayList<int[]> O8 = CollectionsKt__CollectionsKt.r(new int[]{255, 0, 0}, new int[]{255, 165, 0}, new int[]{255, 255, 0}, new int[]{0, 255, 0}, new int[]{0, 127, 255}, new int[]{0, 0, 255}, new int[]{139, 0, 255});

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @m
        @k
        public final LedSettingFragment a() {
            LedSettingFragment ledSettingFragment = new LedSettingFragment();
            ledSettingFragment.c5(androidx.core.os.e.a());
            return ledSettingFragment;
        }

        @k
        public final ArrayList<int[]> b() {
            return LedSettingFragment.O8;
        }
    }

    public static final class b extends h9.f {
        public b() {
        }

        public static final void V0(LedSettingFragment this$0) {
            f0.p(this$0, "this$0");
            this$0.P7();
            this$0.O7();
        }

        public static final void W0(byte[] value, LedSettingFragment this$0) {
            f0.p(value, "$value");
            f0.p(this$0, "this$0");
            byte b10 = (byte) (value[2] & (-1));
            b1 b1Var = null;
            if (b10 == 0) {
                b1 b1Var2 = this$0.A8;
                if (b1Var2 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var2;
                }
                TabLayout.i iVarY = b1Var.D.y(0);
                if (iVarY != null) {
                    iVarY.r();
                }
            } else if (b10 == 1) {
                b1 b1Var3 = this$0.A8;
                if (b1Var3 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var3;
                }
                TabLayout.i iVarY2 = b1Var.D.y(1);
                if (iVarY2 != null) {
                    iVarY2.r();
                }
            } else if (b10 == 2) {
                b1 b1Var4 = this$0.A8;
                if (b1Var4 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var4;
                }
                TabLayout.i iVarY3 = b1Var.D.y(2);
                if (iVarY3 != null) {
                    iVarY3.r();
                }
            } else if (b10 == 3) {
                b1 b1Var5 = this$0.A8;
                if (b1Var5 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var5;
                }
                TabLayout.i iVarY4 = b1Var.D.y(3);
                if (iVarY4 != null) {
                    iVarY4.r();
                }
            }
            this$0.P7();
            this$0.O7();
        }

        @Override // h9.f, h9.d
        public void A(@k final byte[] value) {
            d7.a aVar;
            f0.p(value, "value");
            boolean z10 = !n0.b(LedSettingFragment.this.B8, h.f40767j);
            if (value.length == 20) {
                if (((byte) (value[0] & (-1))) != -69) {
                    d7.a aVar2 = LedSettingFragment.this.C8;
                    if (((aVar2 == null || aVar2.f() != 3) ? 0 : 1) == 0 || !m9.b.d(value)) {
                        return;
                    }
                    y yVarH5 = LedSettingFragment.this.H5();
                    final LedSettingFragment ledSettingFragment = LedSettingFragment.this;
                    yVarH5.g(new Runnable() { // from class: e7.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            ledSettingFragment.P7();
                        }
                    });
                    y yVarH52 = LedSettingFragment.this.H5();
                    final LedSettingFragment ledSettingFragment2 = LedSettingFragment.this;
                    yVarH52.f(new Runnable() { // from class: e7.v
                        @Override // java.lang.Runnable
                        public final void run() {
                            ledSettingFragment2.P7();
                        }
                    }, 250L);
                    return;
                }
                if (((byte) (value[1] & (-1))) != 47) {
                    if (((byte) (value[1] & (-1))) == 48) {
                        LedSettingFragment.this.C8 = d7.a.g(value, z10);
                        y yVarH53 = LedSettingFragment.this.H5();
                        final LedSettingFragment ledSettingFragment3 = LedSettingFragment.this;
                        yVarH53.e(new Runnable() { // from class: e7.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                LedSettingFragment.b.W0(value, ledSettingFragment3);
                            }
                        });
                        return;
                    }
                    return;
                }
                byte b10 = (byte) (value[2] & (-1));
                if (b10 == -1) {
                    d7.a aVarG = d7.a.g(value, z10);
                    LedSettingFragment ledSettingFragment4 = LedSettingFragment.this;
                    int iF = aVarG.f();
                    if (iF == 0) {
                        LedSettingFragment.this.D8 = aVarG.clone();
                        aVar = LedSettingFragment.this.D8;
                    } else if (iF == 1 || iF == 2) {
                        LedSettingFragment.this.G8 = aVarG.clone();
                        aVar = LedSettingFragment.this.G8;
                    } else if (iF == 3) {
                        LedSettingFragment.this.E8 = aVarG.clone();
                        aVar = LedSettingFragment.this.E8;
                    } else if (iF != 4) {
                        aVar = null;
                    } else {
                        LedSettingFragment.this.F8 = aVarG.clone();
                        aVar = LedSettingFragment.this.F8;
                    }
                    ledSettingFragment4.C8 = aVar;
                    y yVarH54 = LedSettingFragment.this.H5();
                    final LedSettingFragment ledSettingFragment5 = LedSettingFragment.this;
                    yVarH54.e(new Runnable() { // from class: e7.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            LedSettingFragment.b.V0(ledSettingFragment5);
                        }
                    });
                } else if (b10 == 0) {
                    LedSettingFragment.this.D8 = d7.a.g(value, z10);
                } else if (b10 == 2) {
                    if (z10) {
                        LedSettingFragment.this.F8 = d7.a.g(value, z10);
                    } else {
                        LedSettingFragment.this.E8 = d7.a.g(value, z10);
                    }
                } else if (b10 == 3) {
                    if (z10) {
                        LedSettingFragment.this.G8 = d7.a.g(value, z10);
                    } else {
                        LedSettingFragment.this.F8 = d7.a.g(value, z10);
                    }
                } else if (b10 == 1) {
                    if (z10) {
                        LedSettingFragment.this.E8 = d7.a.g(value, z10);
                    } else {
                        LedSettingFragment.this.G8 = d7.a.g(value, z10);
                    }
                }
                if (LedSettingFragment.this.D8 == null) {
                    i = 0;
                } else if (LedSettingFragment.this.E8 == null) {
                    i = 2;
                } else if (LedSettingFragment.this.F8 == null) {
                    i = 3;
                } else if (LedSettingFragment.this.G8 != null) {
                    i = 255;
                }
                if (i != 255) {
                    LedSettingFragment.this.D7(i);
                }
            }
        }
    }

    public static final class c implements ColorSeekBar.a {
        public c() {
        }

        @Override // com.flydigi.device_manager.ui.apex_space.view.ColorSeekBar.a
        public void a(int i10) {
            d7.a aVar = LedSettingFragment.this.C8;
            if (aVar != null) {
                aVar.i(new int[]{Color.red(i10), Color.green(i10), Color.blue(i10)});
            }
            LedSettingFragment.this.G7();
        }
    }

    public static final class d implements SeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@l SeekBar seekBar, int i10, boolean z10) {
            d7.a aVar;
            if (z10 && (aVar = LedSettingFragment.this.C8) != null) {
                LedSettingFragment ledSettingFragment = LedSettingFragment.this;
                if (ledSettingFragment.H8 == 3) {
                    aVar.k(((i10 * 30) / 100) + 14);
                } else if (ledSettingFragment.H8 == 2) {
                    aVar.j((i10 * 255) / 100);
                }
                ledSettingFragment.G7();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@l SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@l SeekBar seekBar) {
        }
    }

    public static final class e implements TabLayout.f {
        public e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@k TabLayout.i tab) {
            f0.p(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@k TabLayout.i tab) {
            f0.p(tab, "tab");
            LedSettingFragment ledSettingFragment = LedSettingFragment.this;
            Object objM = tab.m();
            f0.n(objM, "null cannot be cast to non-null type kotlin.Int");
            ledSettingFragment.D7(((Integer) objM).intValue());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(@k TabLayout.i tab) {
            f0.p(tab, "tab");
        }
    }

    public static final class f implements ColorSeekBar.a {
        public f() {
        }

        @Override // com.flydigi.device_manager.ui.apex_space.view.ColorSeekBar.a
        public void a(int i10) {
            d7.a aVar = LedSettingFragment.this.C8;
            if (aVar != null) {
                aVar.h(new int[]{Color.red(i10), Color.green(i10), Color.blue(i10)});
            }
            LedSettingFragment.this.G7();
        }
    }

    public static final void A7(LedSettingFragment this$0, int i10, int i11) {
        f0.p(this$0, "this$0");
        this$0.y7(i10, i11 + 1);
    }

    public static final void C7(LedSettingFragment this$0, boolean z10) {
        f0.p(this$0, "this$0");
        Context contextX1 = this$0.X1();
        if (contextX1 != null) {
            Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
            f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation).l(contextX1, z10 ? DataConstant.REMOTE_ACTION_TMODE_ONLY_GATT_MODE : DataConstant.DEVICE_UART_TEST);
        }
    }

    public static final void F7(LedSettingFragment this$0) {
        f0.p(this$0, "this$0");
        if (this$0.J8) {
            o.E(this$0.c3(R.string.floatview_action_apply_config_success));
            g gVarW1 = this$0.w1();
            if (gVarW1 != null) {
                gVarW1.finish();
            }
        }
        this$0.P7();
    }

    public static final void H7(LedSettingFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.E7(false);
    }

    public static final void I7(LedSettingFragment this$0) {
        f0.p(this$0, "this$0");
        this$0.E7(false);
    }

    public static final void L7(LedSettingFragment this$0, DialogFragment dialogFragment) {
        f0.p(this$0, "this$0");
        dialogFragment.I5();
        g gVarW1 = this$0.w1();
        if (gVarW1 != null) {
            gVarW1.finish();
        }
    }

    @m
    @k
    public static final LedSettingFragment l7() {
        return K8.a();
    }

    public static final void m7(LedSettingFragment this$0, View it2) {
        f0.p(this$0, "this$0");
        f0.o(it2, "it");
        this$0.N7(it2);
        this$0.J7(2);
    }

    public static final void n7(LedSettingFragment this$0, View it2) {
        f0.p(this$0, "this$0");
        f0.o(it2, "it");
        this$0.N7(it2);
        this$0.J7(3);
    }

    public static final void o7(LedSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (n0.b(this$0.B8, h.f40767j)) {
            this$0.C8 = this$0.G8;
        } else {
            d7.a aVar = this$0.C8;
            if (aVar != null) {
                aVar.l(1);
            }
        }
        d7.a aVar2 = this$0.C8;
        if (aVar2 != null) {
            int[] iArr = new int[3];
            for (int i10 = 0; i10 < 3; i10++) {
                iArr[i10] = 0;
            }
            b1 b1Var = null;
            if (Arrays.equals(iArr, aVar2.b())) {
                b1 b1Var2 = this$0.A8;
                if (b1Var2 == null) {
                    f0.S("viewBinding");
                    b1Var2 = null;
                }
                aVar2.h(b1Var2.B.getColor());
            }
            int[] iArr2 = new int[3];
            for (int i11 = 0; i11 < 3; i11++) {
                iArr2[i11] = 0;
            }
            if (Arrays.equals(iArr2, aVar2.c())) {
                b1 b1Var3 = this$0.A8;
                if (b1Var3 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var3;
                }
                aVar2.i(b1Var.C.getColor());
            }
        }
        this$0.G7();
        this$0.O7();
    }

    public static final void p7(LedSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (n0.b(this$0.B8, h.f40767j)) {
            this$0.C8 = this$0.E8;
        } else {
            d7.a aVar = this$0.C8;
            if (aVar != null) {
                aVar.l(3);
            }
        }
        d7.a aVar2 = this$0.C8;
        if (aVar2 != null) {
            int[] iArr = new int[3];
            for (int i10 = 0; i10 < 3; i10++) {
                iArr[i10] = 0;
            }
            if (Arrays.equals(iArr, aVar2.b())) {
                b1 b1Var = this$0.A8;
                if (b1Var == null) {
                    f0.S("viewBinding");
                    b1Var = null;
                }
                aVar2.h(b1Var.B.getColor());
            }
        }
        this$0.G7();
        this$0.O7();
    }

    public static final void q7(LedSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (n0.b(this$0.B8, h.f40767j)) {
            this$0.C8 = this$0.D8;
        } else {
            d7.a aVar = this$0.C8;
            if (aVar != null) {
                aVar.l(0);
            }
        }
        d7.a aVar2 = this$0.C8;
        if (aVar2 != null) {
            int[] iArr = new int[3];
            for (int i10 = 0; i10 < 3; i10++) {
                iArr[i10] = 0;
            }
            if (Arrays.equals(iArr, aVar2.b())) {
                b1 b1Var = this$0.A8;
                if (b1Var == null) {
                    f0.S("viewBinding");
                    b1Var = null;
                }
                aVar2.h(b1Var.B.getColor());
            }
        }
        this$0.G7();
        this$0.O7();
    }

    public static final void r7(LedSettingFragment this$0, View view) {
        f0.p(this$0, "this$0");
        if (n0.b(this$0.B8, h.f40767j)) {
            this$0.C8 = this$0.F8;
        } else {
            d7.a aVar = this$0.C8;
            if (aVar != null) {
                aVar.l(4);
            }
        }
        this$0.G7();
        this$0.O7();
    }

    public static final void s7(LedSettingFragment this$0, View it2) {
        f0.p(this$0, "this$0");
        f0.o(it2, "it");
        this$0.N7(it2);
        this$0.J7(1);
    }

    public static final void u7(LedSettingFragment this$0, d7.a config, int[] nextColor) {
        f0.p(this$0, "this$0");
        f0.p(config, "$config");
        f0.o(nextColor, "nextColor");
        this$0.t7(config, nextColor);
    }

    public static final void v7(LedSettingFragment this$0, d7.a config, int[] nextColor) {
        f0.p(this$0, "this$0");
        f0.p(config, "$config");
        f0.o(nextColor, "nextColor");
        this$0.t7(config, nextColor);
    }

    public static final void x7(LedSettingFragment this$0) {
        f0.p(this$0, "this$0");
        b1 b1Var = this$0.A8;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        b1Var.f9850s.setBackgroundColor(0);
    }

    public static final void z7(LedSettingFragment this$0, int i10, int i11) {
        f0.p(this$0, "this$0");
        this$0.y7(i10, i11 + 1);
    }

    public final void B7(GamepadInfo gamepadInfo) {
        final boolean zIsFlashplayMode = gamepadInfo.isFlashplayMode();
        this.B8 = gamepadInfo.getDeviceCode();
        boolean zIsSupportLed = gamepadInfo.isSupportLed();
        boolean z10 = !n0.b(this.B8, h.f40767j);
        b1 b1Var = this.A8;
        b1 b1Var2 = null;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        b1Var.D.setVisibility(z10 ? 0 : 8);
        int iK = a5.b.k(this.B8, gamepadInfo.getIpType(), gamepadInfo.getDeviceType());
        if (iK > 0) {
            b1 b1Var3 = this.A8;
            if (b1Var3 == null) {
                f0.S("viewBinding");
                b1Var3 = null;
            }
            b1Var3.f9850s.setVisibility(0);
            b1 b1Var4 = this.A8;
            if (b1Var4 == null) {
                f0.S("viewBinding");
            } else {
                b1Var2 = b1Var4;
            }
            b1Var2.f9851t.setImageResource(iK);
        }
        if (zIsSupportLed) {
            if (this.C8 == null) {
                D7(255);
            }
            G5().postDelayed(new Runnable() { // from class: e7.k
                @Override // java.lang.Runnable
                public final void run() {
                    LedSettingFragment.C7(this.f26713a, zIsFlashplayMode);
                }
            }, 1000L);
        }
    }

    public final void D7(int i10) {
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).g(X1(), DataConstant.FLOAT_WINDOW_ACTION_GET_LED_CONFIG, DataConstant.KEY_LED_MODE_TYPE, Byte.valueOf((byte) i10));
    }

    public final void E7(boolean z10) {
        this.J8 = z10;
        d7.a aVar = this.C8;
        if (aVar != null) {
            byte[] bArr = new byte[20];
            for (int i10 = 0; i10 < 20; i10++) {
                bArr[i10] = 0;
            }
            bArr[0] = z10 ? (byte) 32 : rc.a.V;
            bArr[1] = (byte) aVar.f();
            bArr[2] = (byte) aVar.e();
            int i11 = 4;
            bArr[3] = (byte) aVar.d();
            if (n0.b(this.B8, h.f40767j)) {
                bArr[4] = 2;
                i11 = 5;
            }
            int i12 = i11 + 1;
            bArr[i11] = (byte) aVar.b()[0];
            int i13 = i12 + 1;
            bArr[i12] = (byte) aVar.b()[1];
            int i14 = i13 + 1;
            bArr[i13] = (byte) aVar.b()[2];
            int i15 = i14 + 1;
            bArr[i14] = (byte) aVar.c()[0];
            bArr[i15] = (byte) aVar.c()[1];
            bArr[i15 + 1] = (byte) aVar.c()[2];
            bArr[18] = (byte) this.I8;
            int i16 = 0;
            for (int i17 = 0; i17 < 19; i17++) {
                i16 += bArr[i17];
            }
            bArr[19] = (byte) (i16 & 255);
            this.I8++;
            Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
            f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
            ((IRemoteProvider) objNavigation).m(this.f13317d8, DataConstant.REMOTE_ACTION_BY_BLUEBOOTH_SEND_BYTE_ARRAY, DataConstant.BYTE_ARRAY, bArr);
            H5().f(new Runnable() { // from class: e7.f
                @Override // java.lang.Runnable
                public final void run() {
                    LedSettingFragment.F7(this.f26700a);
                }
            }, 500L);
        }
    }

    public final void G7() {
        G5().removeCallbacks(new Runnable() { // from class: e7.e
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.H7(this.f26699a);
            }
        });
        G5().postDelayed(new Runnable() { // from class: e7.t
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.I7(this.f26723a);
            }
        }, 250L);
    }

    public final void J7(int i10) {
        this.H8 = i10;
        b1 b1Var = null;
        if (i10 == 1) {
            b1 b1Var2 = this.A8;
            if (b1Var2 == null) {
                f0.S("viewBinding");
                b1Var2 = null;
            }
            LinearLayout linearLayout = b1Var2.f9834c;
            f0.o(linearLayout, "viewBinding.areaSeekbarSingle");
            Boolean bool = Boolean.FALSE;
            o5.c.b(linearLayout, bool, false, 2, null);
            b1 b1Var3 = this.A8;
            if (b1Var3 == null) {
                f0.S("viewBinding");
                b1Var3 = null;
            }
            LinearLayout linearLayout2 = b1Var3.f9833b;
            f0.o(linearLayout2, "viewBinding.areaSeekbarDouble");
            Boolean bool2 = Boolean.TRUE;
            o5.c.b(linearLayout2, bool2, false, 2, null);
            d7.a aVar = this.C8;
            if (aVar != null && aVar.f() == 1) {
                b1 b1Var4 = this.A8;
                if (b1Var4 == null) {
                    f0.S("viewBinding");
                    b1Var4 = null;
                }
                ColorPicker colorPicker = b1Var4.C;
                f0.o(colorPicker, "viewBinding.seekbarColor2");
                o5.c.b(colorPicker, bool2, false, 2, null);
            } else {
                b1 b1Var5 = this.A8;
                if (b1Var5 == null) {
                    f0.S("viewBinding");
                    b1Var5 = null;
                }
                ColorPicker colorPicker2 = b1Var5.C;
                f0.o(colorPicker2, "viewBinding.seekbarColor2");
                o5.c.b(colorPicker2, bool, false, 2, null);
            }
            d7.a aVar2 = this.C8;
            if (aVar2 != null) {
                b1 b1Var6 = this.A8;
                if (b1Var6 == null) {
                    f0.S("viewBinding");
                    b1Var6 = null;
                }
                b1Var6.B.setColor(Color.rgb(aVar2.b()[0], aVar2.b()[1], aVar2.b()[2]));
                b1 b1Var7 = this.A8;
                if (b1Var7 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var7;
                }
                b1Var.C.setColor(Color.rgb(aVar2.c()[0], aVar2.c()[1], aVar2.c()[2]));
                return;
            }
            return;
        }
        if (i10 == 2) {
            b1 b1Var8 = this.A8;
            if (b1Var8 == null) {
                f0.S("viewBinding");
                b1Var8 = null;
            }
            LinearLayout linearLayout3 = b1Var8.f9834c;
            f0.o(linearLayout3, "viewBinding.areaSeekbarSingle");
            o5.c.b(linearLayout3, Boolean.TRUE, false, 2, null);
            b1 b1Var9 = this.A8;
            if (b1Var9 == null) {
                f0.S("viewBinding");
                b1Var9 = null;
            }
            LinearLayout linearLayout4 = b1Var9.f9833b;
            f0.o(linearLayout4, "viewBinding.areaSeekbarDouble");
            o5.c.b(linearLayout4, Boolean.FALSE, false, 2, null);
            d7.a aVar3 = this.C8;
            if (aVar3 != null) {
                int iD = ((aVar3.d() & 255) * 100) / 255;
                b1 b1Var10 = this.A8;
                if (b1Var10 == null) {
                    f0.S("viewBinding");
                } else {
                    b1Var = b1Var10;
                }
                b1Var.A.setProgress(iD);
                return;
            }
            return;
        }
        if (i10 != 3) {
            return;
        }
        b1 b1Var11 = this.A8;
        if (b1Var11 == null) {
            f0.S("viewBinding");
            b1Var11 = null;
        }
        LinearLayout linearLayout5 = b1Var11.f9834c;
        f0.o(linearLayout5, "viewBinding.areaSeekbarSingle");
        o5.c.b(linearLayout5, Boolean.TRUE, false, 2, null);
        b1 b1Var12 = this.A8;
        if (b1Var12 == null) {
            f0.S("viewBinding");
            b1Var12 = null;
        }
        LinearLayout linearLayout6 = b1Var12.f9833b;
        f0.o(linearLayout6, "viewBinding.areaSeekbarDouble");
        o5.c.b(linearLayout6, Boolean.FALSE, false, 2, null);
        d7.a aVar4 = this.C8;
        if (aVar4 != null) {
            int iE = (((aVar4.e() & 255) * 100) / 255) - 14;
            b1 b1Var13 = this.A8;
            if (b1Var13 == null) {
                f0.S("viewBinding");
            } else {
                b1Var = b1Var13;
            }
            b1Var.A.setProgress(iE);
        }
    }

    public final void K7() {
        o5.a.t0(U1(), new FZDialogV2.a().q(c3(R.string.device_state_unconnected)).j(c3(R.string.device_led_gamepad_disconnected_desc)).l(true).g(c3(R.string.confirm)).f(new FZDialogV2.c() { // from class: e7.r
            @Override // com.flydigi.base.widget.FZDialogV2.c
            public final void a(DialogFragment dialogFragment) {
                LedSettingFragment.L7(this.f26721a, dialogFragment);
            }
        }).b(Boolean.FALSE).a());
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_led_setting;
    }

    public final void M7(int i10, int[] iArr) {
        int i11 = i10 & 255;
        int iRgb = Color.rgb((iArr[0] * i11) >> 8, (iArr[1] * i11) >> 8, (iArr[2] * i11) >> 8);
        b1 b1Var = this.A8;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        b1Var.f9850s.setBackgroundColor(iRgb);
    }

    public final void N7(View view) {
        b1 b1Var = this.A8;
        b1 b1Var2 = null;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        LinearLayout linearLayout = b1Var.f9838g;
        linearLayout.setSelected(f0.g(linearLayout, view));
        b1 b1Var3 = this.A8;
        if (b1Var3 == null) {
            f0.S("viewBinding");
            b1Var3 = null;
        }
        b1Var3.f9845n.setVisibility(linearLayout.isSelected() ? 0 : 4);
        b1 b1Var4 = this.A8;
        if (b1Var4 == null) {
            f0.S("viewBinding");
            b1Var4 = null;
        }
        LinearLayout linearLayout2 = b1Var4.f9843l;
        linearLayout2.setSelected(f0.g(linearLayout2, view));
        b1 b1Var5 = this.A8;
        if (b1Var5 == null) {
            f0.S("viewBinding");
            b1Var5 = null;
        }
        b1Var5.f9846o.setVisibility(linearLayout2.isSelected() ? 0 : 4);
        b1 b1Var6 = this.A8;
        if (b1Var6 == null) {
            f0.S("viewBinding");
            b1Var6 = null;
        }
        LinearLayout linearLayout3 = b1Var6.f9844m;
        linearLayout3.setSelected(f0.g(linearLayout3, view));
        b1 b1Var7 = this.A8;
        if (b1Var7 == null) {
            f0.S("viewBinding");
        } else {
            b1Var2 = b1Var7;
        }
        b1Var2.f9847p.setVisibility(linearLayout3.isSelected() ? 0 : 4);
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @k
    public View O3(@k LayoutInflater inflater, @l ViewGroup viewGroup, @l Bundle bundle) {
        f0.p(inflater, "inflater");
        b1 b1VarD = b1.d(inflater, viewGroup, false);
        f0.o(b1VarD, "inflate(inflater, container, false)");
        this.A8 = b1VarD;
        if (b1VarD == null) {
            f0.S("viewBinding");
            b1VarD = null;
        }
        ConstraintLayout root = b1VarD.getRoot();
        f0.o(root, "viewBinding.root");
        return root;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O7() {
        /*
            Method dump skipped, instruction units count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.apex_space.ui.LedSettingFragment.O7():void");
    }

    public final void P7() {
        b1 b1Var = null;
        H5().h(null);
        d7.a aVar = this.C8;
        if (aVar == null) {
            b1 b1Var2 = this.A8;
            if (b1Var2 == null) {
                f0.S("viewBinding");
            } else {
                b1Var = b1Var2;
            }
            b1Var.f9850s.setBackgroundResource(R.color.transparent);
            return;
        }
        int iF = aVar.f();
        if (iF == 0) {
            int iD = aVar.d();
            int[] iArrB = aVar.b();
            f0.o(iArrB, "it.color1");
            M7(iD, iArrB);
            return;
        }
        if (iF == 1 || iF == 2) {
            int[] iArrB2 = aVar.b();
            f0.o(iArrB2, "it.color1");
            t7(aVar, iArrB2);
        } else if (iF == 3) {
            w7(aVar);
        } else {
            if (iF != 4) {
                return;
            }
            y7(aVar.d(), 0);
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).l(X1(), DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        b1 b1Var = this.A8;
        b1 b1Var2 = null;
        if (b1Var == null) {
            f0.S("viewBinding");
            b1Var = null;
        }
        TabLayout tabLayout = b1Var.D;
        b1 b1Var3 = this.A8;
        if (b1Var3 == null) {
            f0.S("viewBinding");
            b1Var3 = null;
        }
        tabLayout.d(b1Var3.D.D().B(0).C(R.string.device_led_config_1));
        b1 b1Var4 = this.A8;
        if (b1Var4 == null) {
            f0.S("viewBinding");
            b1Var4 = null;
        }
        TabLayout tabLayout2 = b1Var4.D;
        b1 b1Var5 = this.A8;
        if (b1Var5 == null) {
            f0.S("viewBinding");
            b1Var5 = null;
        }
        tabLayout2.d(b1Var5.D.D().B(1).C(R.string.device_led_config_2));
        b1 b1Var6 = this.A8;
        if (b1Var6 == null) {
            f0.S("viewBinding");
            b1Var6 = null;
        }
        TabLayout tabLayout3 = b1Var6.D;
        b1 b1Var7 = this.A8;
        if (b1Var7 == null) {
            f0.S("viewBinding");
            b1Var7 = null;
        }
        tabLayout3.d(b1Var7.D.D().B(2).C(R.string.device_led_config_3));
        b1 b1Var8 = this.A8;
        if (b1Var8 == null) {
            f0.S("viewBinding");
            b1Var8 = null;
        }
        TabLayout tabLayout4 = b1Var8.D;
        b1 b1Var9 = this.A8;
        if (b1Var9 == null) {
            f0.S("viewBinding");
            b1Var9 = null;
        }
        tabLayout4.d(b1Var9.D.D().B(3).C(R.string.device_led_config_4));
        b1 b1Var10 = this.A8;
        if (b1Var10 == null) {
            f0.S("viewBinding");
            b1Var10 = null;
        }
        b1Var10.D.c(new e());
        b1 b1Var11 = this.A8;
        if (b1Var11 == null) {
            f0.S("viewBinding");
            b1Var11 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var11.f9839h, new View.OnClickListener() { // from class: e7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.o7(this.f26718a, view2);
            }
        });
        b1 b1Var12 = this.A8;
        if (b1Var12 == null) {
            f0.S("viewBinding");
            b1Var12 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var12.f9840i, new View.OnClickListener() { // from class: e7.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.p7(this.f26715a, view2);
            }
        });
        b1 b1Var13 = this.A8;
        if (b1Var13 == null) {
            f0.S("viewBinding");
            b1Var13 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var13.f9842k, new View.OnClickListener() { // from class: e7.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.q7(this.f26716a, view2);
            }
        });
        b1 b1Var14 = this.A8;
        if (b1Var14 == null) {
            f0.S("viewBinding");
            b1Var14 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var14.f9841j, new View.OnClickListener() { // from class: e7.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.r7(this.f26717a, view2);
            }
        });
        b1 b1Var15 = this.A8;
        if (b1Var15 == null) {
            f0.S("viewBinding");
            b1Var15 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var15.f9838g, new View.OnClickListener() { // from class: e7.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.s7(this.f26698a, view2);
            }
        });
        b1 b1Var16 = this.A8;
        if (b1Var16 == null) {
            f0.S("viewBinding");
            b1Var16 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var16.f9843l, new View.OnClickListener() { // from class: e7.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.m7(this.f26720a, view2);
            }
        });
        b1 b1Var17 = this.A8;
        if (b1Var17 == null) {
            f0.S("viewBinding");
            b1Var17 = null;
        }
        com.blankj.utilcode.util.o.r(b1Var17.f9844m, new View.OnClickListener() { // from class: e7.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LedSettingFragment.n7(this.f26719a, view2);
            }
        });
        b1 b1Var18 = this.A8;
        if (b1Var18 == null) {
            f0.S("viewBinding");
            b1Var18 = null;
        }
        b1Var18.B.setOnColorPickerListener$device_manager_officialRelease(new f());
        b1 b1Var19 = this.A8;
        if (b1Var19 == null) {
            f0.S("viewBinding");
            b1Var19 = null;
        }
        b1Var19.C.setOnColorPickerListener$device_manager_officialRelease(new c());
        b1 b1Var20 = this.A8;
        if (b1Var20 == null) {
            f0.S("viewBinding");
        } else {
            b1Var2 = b1Var20;
        }
        b1Var2.A.setOnSeekBarChangeListener(new d());
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    @l
    public h9.d p6() {
        return new b();
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        super.q6(deviceInfo);
        if (!deviceInfo.isConnected()) {
            this.C8 = null;
            K7();
        } else if (this.C8 == null) {
            B7(deviceInfo);
        }
    }

    public final void t7(final d7.a aVar, int[] iArr) {
        M7(aVar.d(), iArr);
        final int[] iArrC = n0.b(iArr, aVar.b()) ? aVar.c() : aVar.b();
        H5().g(new Runnable() { // from class: e7.j
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.u7(this.f26710a, aVar, iArrC);
            }
        });
        H5().f(new Runnable() { // from class: e7.i
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.v7(this.f26707a, aVar, iArrC);
            }
        }, aVar.e() * 100);
    }

    public final boolean w7(d7.a aVar) {
        int iD = aVar.d();
        int[] iArrB = aVar.b();
        f0.o(iArrB, "it.color1");
        M7(iD, iArrB);
        return H5().f(new Runnable() { // from class: e7.s
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.x7(this.f26722a);
            }
        }, aVar.e() * 100);
    }

    public final void y7(final int i10, final int i11) {
        ArrayList<int[]> arrayList = O8;
        if (i11 == arrayList.size()) {
            i11 = 0;
        }
        int[] iArr = arrayList.get(i11);
        f0.o(iArr, "RAINBOW_COLOR[tempIdx]");
        M7(i10, iArr);
        H5().g(new Runnable() { // from class: e7.g
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.z7(this.f26701a, i10, i11);
            }
        });
        H5().f(new Runnable() { // from class: e7.h
            @Override // java.lang.Runnable
            public final void run() {
                LedSettingFragment.A7(this.f26704a, i10, i11);
            }
        }, 2000L);
    }
}
