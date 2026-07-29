package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes7.dex */
public final class h1 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w7.g0 f15624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f15625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15626r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(@yt.k Context context, @yt.k Handler handler, @yt.k GamepadInfo deviceInfo) {
        super(context, null, handler, deviceInfo);
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(handler, "handler");
        kotlin.jvm.internal.f0.p(deviceInfo, "deviceInfo");
        this.f15625q = -1;
        this.f15626r = -1;
        v();
    }

    public static final void D(h1 this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.q(25);
        this$0.h();
    }

    public final void C(byte[] bArr) {
        GamepadInfo deviceInfo = this.f56484g;
        kotlin.jvm.internal.f0.o(deviceInfo, "deviceInfo");
        List<Integer> listV0 = m9.b.v0(bArr, deviceInfo);
        if (!listV0.isEmpty()) {
            int iIntValue = listV0.get(0).intValue();
            if (iIntValue == 20 || iIntValue == 6 || (iIntValue == 14 && (this.f56484g.getDeviceType() == 64 || this.f56484g.getDeviceType() == 66 || this.f56484g.getDeviceType() == 65 || this.f56484g.getDeviceType() == 32 || this.f56484g.getDeviceType() == 33))) {
                Context context = this.f56478a;
                n8.b.m(context, context.getString(R.string.floatview_combo_key_current_key_cannot_used));
                return;
            }
            int i10 = this.f15625q;
            w7.g0 g0Var = null;
            if (i10 == -1) {
                this.f15625q = iIntValue;
                w7.g0 g0Var2 = this.f15624p;
                if (g0Var2 == null) {
                    kotlin.jvm.internal.f0.S("viewBinding");
                } else {
                    g0Var = g0Var2;
                }
                g0Var.f54110c.i(iIntValue, this.f56484g, false);
                return;
            }
            if (this.f15626r != -1 || i10 == iIntValue) {
                return;
            }
            this.f15626r = iIntValue;
            w7.g0 g0Var3 = this.f15624p;
            if (g0Var3 == null) {
                kotlin.jvm.internal.f0.S("viewBinding");
            } else {
                g0Var = g0Var3;
            }
            g0Var.f54111d.i(iIntValue, this.f56484g, false);
            q(26);
            h();
        }
    }

    @Override // y7.b
    public void h() {
        super.h();
        A();
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_setting_config_combo_key_listen;
    }

    @Override // y7.b
    public void n() {
        w7.g0 g0VarA = w7.g0.a(j());
        kotlin.jvm.internal.f0.o(g0VarA, "bind(view)");
        this.f15624p = g0VarA;
        w7.g0 g0Var = null;
        if (g0VarA == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            g0VarA = null;
        }
        com.blankj.utilcode.util.o.r(g0VarA.f54109b, new View.OnClickListener() { // from class: com.flydigi.float_view.ui.config.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h1.D(this.f15619a, view);
            }
        });
        w7.g0 g0Var2 = this.f15624p;
        if (g0Var2 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
            g0Var2 = null;
        }
        g0Var2.f54110c.i(-1, this.f56484g, false);
        w7.g0 g0Var3 = this.f15624p;
        if (g0Var3 == null) {
            kotlin.jvm.internal.f0.S("viewBinding");
        } else {
            g0Var = g0Var3;
        }
        g0Var.f54111d.i(-1, this.f56484g, false);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public final void onEvent(@yt.k BluetoothDeviceOperateEvent event) {
        kotlin.jvm.internal.f0.p(event, "event");
        byte[] bArr = event.value;
        kotlin.jvm.internal.f0.o(bArr, "event.value");
        C(bArr);
    }

    @Override // y7.b
    @yt.l
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }

    @Override // y7.b
    public void q(int i10) {
        if (this.f56482e != null) {
            Message message = new Message();
            message.what = i10;
            if (i10 == 26) {
                message.arg1 = o9.b.b(this.f15625q);
                message.arg2 = o9.b.b(this.f15626r);
            }
            this.f56482e.sendMessage(message);
        }
    }
}
