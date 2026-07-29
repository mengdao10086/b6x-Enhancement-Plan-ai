package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.FloatWindowSizeBean;
import i9.a;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class f1 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f15607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f15608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f15609r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f15610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f15611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CFGEntity f15612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z7.v0 f15613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f15614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15615x;

    public f1(Context context, y7.n nVar) {
        super(context, nVar);
        this.f15607p = true;
        this.f15615x = false;
    }

    public final void D() {
        if (k()) {
            if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_VIEW_NOTICE_GAME_CONFIG_RATIO_PERFIX + this.f15614w, false) || !this.f15607p) {
                return;
            }
            if (this.f15612u.isRecommend() || this.f15612u.isDefault()) {
                this.f15607p = false;
                String ratio = this.f15612u.getRatio();
                if (com.blankj.utilcode.util.n0.x(ratio)) {
                    if (ratio.equals(new DecimalFormat("0.0000").format(Math.max(com.blankj.utilcode.util.x0.g(), com.blankj.utilcode.util.x0.e()) / Math.min(com.blankj.utilcode.util.x0.g(), com.blankj.utilcode.util.x0.e())))) {
                        return;
                    }
                    this.f15613v = new z7.v0(this.f56478a, this.f15614w);
                    if (this.f15612u.isDefault()) {
                        this.f15613v.B(0);
                    } else {
                        this.f15613v.B(1);
                    }
                }
            }
        }
    }

    public final void E() {
        z7.v0 v0Var = this.f15613v;
        if (v0Var != null) {
            v0Var.h();
            this.f15613v = null;
        }
    }

    public final void F() {
        FrameLayout frameLayout = this.f15608q;
        if (frameLayout == null) {
            return;
        }
        int height = frameLayout.getHeight();
        int width = this.f15608q.getWidth();
        int iMax = Math.max(height, width);
        int iMin = Math.min(height, width);
        int[] iArr = new int[2];
        this.f15608q.getLocationOnScreen(iArr);
        if (this.f56484g.isFlashplayMode() && n8.a.f(this.f15608q.getContext())) {
            n8.a.a(iArr, this.f15608q);
            if (!this.f15615x) {
                Display displayB = n8.a.b(this.f15608q.getContext(), true);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayB.getRealMetrics(displayMetrics);
                Display displayB2 = n8.a.b(this.f15608q.getContext(), false);
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                displayB2.getRealMetrics(displayMetrics2);
                HashMap map = new HashMap();
                map.put("manufacturer", Build.MANUFACTURER);
                map.put("model", Build.MODEL);
                map.put("sys_version", String.valueOf(Build.VERSION.SDK_INT));
                map.put("local_display", displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
                map.put("remote_display", displayMetrics2.widthPixels + "x" + displayMetrics2.heightPixels);
                GamepadInfo gamepadInfo = this.f56484g;
                if (gamepadInfo != null) {
                    map.put("deviceName", gamepadInfo.getDeviceName());
                    map.put(DataConstant.DEVICE_KEY_FIRMWARE_VERSION, this.f56484g.getFirmwareVersion());
                    map.put("driver_version", this.f56484g.getDriverVersion());
                    map.put("mapping_mode", this.f56484g.getReadableMappingMode());
                }
                u9.g.a().e(this.f15608q.getContext(), "extra_display", map);
                this.f15615x = true;
            }
        }
        if ((this.f15609r != iMax || this.f15610s != iMin || !Arrays.equals(iArr, this.f15611t)) && iMax > 0 && iMin > 0) {
            ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).h(this.f56478a, DataConstant.REMOTE_ACTION_MAPPINGICON_SIZE, DataConstant.REMOTE_ACTION_MAPPINGICON_SIZE, new FloatWindowSizeBean(iMax, iMin, iArr));
            this.f15609r = iMax;
            this.f15610s = iMin;
            this.f15611t = iArr;
            G();
        }
        this.f56483f.postDelayed(new e1(this), 1000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G() {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.float_view.ui.config.f1.G():void");
    }

    public void H(CFGEntity cFGEntity, String str) {
        this.f15612u = cFGEntity;
        this.f15607p = true;
        this.f15614w = str;
        this.f56483f.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15599a.G();
            }
        });
    }

    public void I() {
        if (this.f56479b != null) {
            if (k()) {
                l();
            } else {
                y();
            }
        }
    }

    @Override // y7.b
    public void h() {
        super.h();
        E();
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_container;
    }

    @Override // y7.b
    public void l() {
        super.l();
        E();
    }

    @Override // y7.b
    public void n() {
        this.f15608q = (FrameLayout) this.f56479b.findViewById(R.id.rl_root);
        this.f56483f.postDelayed(new e1(this), 1000L);
        this.f56479b.setVisibility(4);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(2);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }

    @Override // y7.b
    public void x(GamepadInfo gamepadInfo) {
        this.f56484g = gamepadInfo;
    }

    @Override // y7.b
    public void y() {
        super.y();
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + this.f15614w, true)) {
            return;
        }
        this.f56483f.postDelayed(new Runnable() { // from class: com.flydigi.float_view.ui.config.c1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15595a.l();
            }
        }, 50L);
    }
}
