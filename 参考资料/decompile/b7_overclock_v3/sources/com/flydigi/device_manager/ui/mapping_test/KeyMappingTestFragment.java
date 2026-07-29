package com.flydigi.device_manager.ui.mapping_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import c7.a1;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.n;
import com.flydigi.base.common.o;
import com.flydigi.base.common.y;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.device_manager.BaseGamepadFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.mapping_test.KeyMappingTestFragment;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import e6.z;
import g.p0;
import h9.d;
import h9.f;
import i9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m9.h;
import m9.m;
import m9.s;
import m9.t;
import o5.l;
import tt.c;
import u9.g;
import xi.e0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class KeyMappingTestFragment extends BaseGamepadFragment implements View.OnTouchListener {
    public static final int L9 = 1;
    public static final int M9 = 2;
    public static final int N9 = 3;
    public static final int O9 = 4;
    public static final int P9 = 5;
    public static final int Q9 = 6;
    public a1 A8;
    public View B8;
    public boolean B9;
    public Button C8;
    public boolean C9;
    public Button D8;
    public boolean D9;
    public Button E8;
    public boolean E9;
    public Button F8;
    public boolean F9;
    public Button G8;
    public Button H8;
    public Button I8;
    public Button J8;
    public Button K8;
    public Button L8;
    public Button M8;
    public Button N8;
    public Button O8;
    public Button P8;
    public Button Q8;
    public Button R8;
    public Button S8;
    public Button T8;
    public Button U8;
    public Button V8;
    public Button W8;
    public Button X8;
    public Button Y8;
    public Button Z8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public Button f15347a9;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public Button f15348b9;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public Button f15349c9;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public Button f15350d9;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public Button f15351e9;

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public Button f15352f9;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public Button f15353g9;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public Button f15354h9;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public Button f15355i9;

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public Button f15356j9;

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public Button f15357k9;

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public Button f15358l9;

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public Button f15359m9;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public Button f15360n9;

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    public Button f15361o9;

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    public Button f15362p9;

    /* JADX INFO: renamed from: q9, reason: collision with root package name */
    public Button f15363q9;

    /* JADX INFO: renamed from: r9, reason: collision with root package name */
    public View f15364r9;

    /* JADX INFO: renamed from: s9, reason: collision with root package name */
    public Button f15365s9;

    /* JADX INFO: renamed from: t9, reason: collision with root package name */
    public Button f15366t9;

    /* JADX INFO: renamed from: u9, reason: collision with root package name */
    public Button f15367u9;

    /* JADX INFO: renamed from: v9, reason: collision with root package name */
    public Button f15368v9;

    /* JADX INFO: renamed from: w9, reason: collision with root package name */
    public Button f15369w9;

    /* JADX INFO: renamed from: x9, reason: collision with root package name */
    public final SparseArray<View> f15370x9 = new SparseArray<>();

    /* JADX INFO: renamed from: y9, reason: collision with root package name */
    public final SparseArray<View> f15371y9 = new SparseArray<>();

    /* JADX INFO: renamed from: z9, reason: collision with root package name */
    public final List<View> f15372z9 = new ArrayList();
    public final Runnable A9 = new Runnable() { // from class: o7.l
        @Override // java.lang.Runnable
        public final void run() {
            this.f42793a.W6();
        }
    };
    public boolean G9 = false;
    public boolean H9 = false;
    public boolean I9 = false;
    public final View.OnLayoutChangeListener J9 = new a();
    public int K9 = -1;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            KeyMappingTestFragment.this.B8 = view;
        }
    }

    public class b extends f {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W0(byte[] bArr) {
            KeyMappingTestFragment.this.Z6(bArr);
        }

        @Override // h9.f, h9.d
        public void A(@k final byte[] bArr) {
            super.A(bArr);
            if (KeyMappingTestFragment.this.k6() != null) {
                KeyMappingTestFragment.this.H5().e(new Runnable() { // from class: o7.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42796a.W0(bArr);
                    }
                });
            }
        }

        @Override // h9.f, h9.d
        public void l() {
            int i10 = (KeyMappingTestFragment.this.k6() == null || !KeyMappingTestFragment.this.k6().isFlashplayMode()) ? 1500 : 500;
            y yVarH5 = KeyMappingTestFragment.this.H5();
            final KeyMappingTestFragment keyMappingTestFragment = KeyMappingTestFragment.this;
            yVarH5.f(new Runnable() { // from class: o7.p
                @Override // java.lang.Runnable
                public final void run() {
                    KeyMappingTestFragment.U6(keyMappingTestFragment);
                }
            }, i10);
        }
    }

    public static /* synthetic */ void U6(KeyMappingTestFragment keyMappingTestFragment) {
        keyMappingTestFragment.G7();
    }

    public static /* synthetic */ void f7() {
        c.f().q(new ExitAppEvent(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g7(GamepadInfo gamepadInfo) {
        b7(gamepadInfo.getDeviceMode());
        t7();
        if (gamepadInfo.isSupportMotion()) {
            this.A8.f9803j.setText(R.string.device_key_mapping_test_motion);
            this.A8.f9803j.setVisibility(0);
        } else {
            this.A8.f9803j.setVisibility(8);
        }
        if (gamepadInfo.isGamepadKeyboard()) {
            this.A8.f9796c.setVisibility(8);
        } else {
            this.A8.f9796c.setVisibility(0);
        }
        A7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h7(View view) {
        I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i7(View view) {
        e7();
    }

    public static /* synthetic */ e0 j7(Boolean bool) throws Exception {
        return bool.booleanValue() ? z.m0(DataConstant.TEST_KEYMAPPING) : xi.z.f2(new IllegalAccessException(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CFGEntity k7(CFGEntityList cFGEntityList) throws Exception {
        return z.J(cFGEntityList, k6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m7(final CFGEntity cFGEntity) throws Exception {
        this.B8.post(new Runnable() { // from class: o7.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f42782a.l7(cFGEntity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n7(Throwable th2) throws Exception {
        o.E(c3(R.string.device_read_config_error));
        y7(DataConstant.REMOTE_ACTION_END_TEST_KEYMAPPING);
        I5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o7() {
        E0();
        X6();
        A7();
        o.E(c3(R.string.device_joystick_reset_finish));
    }

    public static /* synthetic */ void p7(View view, float f10, float f11) {
        view.setX(f10);
        view.setY(f11);
        view.setVisibility(0);
    }

    public static KeyMappingTestFragment q7(GamepadInfo gamepadInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_device_info", gamepadInfo);
        KeyMappingTestFragment keyMappingTestFragment = new KeyMappingTestFragment();
        keyMappingTestFragment.c5(bundle);
        return keyMappingTestFragment;
    }

    public final void A7() {
        if (k6() == null) {
            return;
        }
        x(c3(R.string.device_preparing), false);
        v7();
        if (this.I9) {
            y7(DataConstant.REMOTE_ACTION_ENABLE_SHOW_MAPPING_ICON);
            G5().post(new Runnable() { // from class: o7.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42794a.G7();
                }
            });
        } else {
            y7(DataConstant.REMOTE_ACTION_START_TEST_KEYMAPPING);
            this.I9 = true;
        }
    }

    public final void B7(int i10, int i11, int i12, float f10, float f11) {
        if (k6() == null) {
            return;
        }
        final View view = k6().isGamepadKeyboard() ? this.f15371y9.get(i12) : this.f15370x9.get(i12);
        if (view == null) {
            return;
        }
        final float measuredWidth = (f10 * i10) - (view.getMeasuredWidth() >> 1);
        final float measuredHeight = (f11 * i11) - (view.getMeasuredHeight() >> 1);
        view.post(new Runnable() { // from class: o7.k
            @Override // java.lang.Runnable
            public final void run() {
                KeyMappingTestFragment.p7(view, measuredWidth, measuredHeight);
            }
        });
        if (k6().containKey(i12)) {
            return;
        }
        view.setEnabled(false);
        if (i12 == 242) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: C7, reason: merged with bridge method [inline-methods] */
    public final void l7(CFGEntity cFGEntity) {
        if (k6() == null) {
            return;
        }
        int measuredWidth = this.B8.getMeasuredWidth();
        int measuredHeight = this.B8.getMeasuredHeight();
        for (CFGPropertyKey cFGPropertyKey : cFGEntity.keyList) {
            int i10 = cFGPropertyKey.key_id;
            if (i10 != 12 || cFGPropertyKey.type != 3) {
                B7(measuredWidth, measuredHeight, i10, cFGPropertyKey.f16347x, cFGPropertyKey.f16348y);
            }
        }
        if (k6().isGamepadKeyboard()) {
            this.f15364r9.setVisibility(0);
            return;
        }
        for (CFGPropertyJS cFGPropertyJS : cFGEntity.jsList) {
            if (n0.b(h.f40768k, k6().getDeviceCode()) || cFGPropertyJS.key_id != 242) {
                B7(measuredWidth, measuredHeight, cFGPropertyJS.key_id, cFGPropertyJS.f16345x, cFGPropertyJS.f16346y);
            }
        }
    }

    public final void D7(Intent intent, int i10) {
        E0();
        X6();
        this.H9 = false;
        y7(DataConstant.REMOTE_ACTION_HIDE_FLOAT_WINDOW);
        z5(intent, i10);
        w1().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public final void E7() {
        TextView textView = this.A8.f9803j;
        int i10 = R.string.device_detect_error;
        textView.setText(i10);
        if (!v5.c.f()) {
            D7(FullScreenDialogActivity.o4(X1(), 2, c3(i10), c3(R.string.device_detect_error_notice), c3(R.string.device_action_reconnect_device)), 1);
            return;
        }
        int i11 = this.K9;
        if (i11 >= 4) {
            this.K9 = -1;
            D7(FullScreenDialogActivity.p4(X1(), 3, c3(i10), c3(R.string.device_detect_error_notice_for_simulator), c3(R.string.device_quit_keymapping), c3(R.string.cancel)), 6);
        } else {
            this.K9 = i11 + 1;
            o.E(c3(R.string.device_reseting_rotation_retry));
            u9.b.w(X1(), this.K9);
            A7();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F3(int i10, int i11, Intent intent) {
        super.F3(i10, i11, intent);
        if (i11 == -1) {
            switch (i10) {
                case 1:
                    s.c();
                    o5.f.e(X1());
                    break;
                case 2:
                    if (!intent.getBooleanExtra(FullScreenDialogActivity.I7, false)) {
                        E7();
                    } else {
                        A7();
                    }
                    break;
                case 3:
                    A7();
                    break;
                case 4:
                    if (k6() != null) {
                        w7();
                        break;
                    }
                    break;
                case 5:
                    o5.h.C(X1());
                    break;
                case 6:
                    if (!intent.getBooleanExtra(FullScreenDialogActivity.I7, false)) {
                        A7();
                    } else {
                        x(c3(R.string.device_prepare_exit_mapping_and_service), false);
                        i9.b.d(this.f13317d8, DataConstant.REMOTE_ACTION_KILL_DRIVER);
                        G5().postDelayed(new Runnable() { // from class: o7.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                KeyMappingTestFragment.f7();
                            }
                        }, 1000L);
                    }
                    break;
            }
        }
    }

    public final void F7(byte[] bArr) {
        if (k6() == null) {
            return;
        }
        int i10 = bArr[5] & 255;
        int i11 = bArr[4] & 255;
        int i12 = bArr[3] & 255;
        int i13 = bArr[2] & 255;
        int i14 = bArr[1] & 255;
        this.f15365s9.setText(com.flydigi.sdk.gamepad.extension.a.i(i10, 1));
        this.f15365s9.setSelected(i10 != 0);
        this.f15366t9.setText(com.flydigi.sdk.gamepad.extension.a.i(i11, 1));
        this.f15366t9.setSelected(i11 != 0);
        this.f15367u9.setText(com.flydigi.sdk.gamepad.extension.a.i(i12, 1));
        this.f15367u9.setSelected(i12 != 0);
        this.f15368v9.setText(com.flydigi.sdk.gamepad.extension.a.i(i13, 1));
        this.f15368v9.setSelected(i13 != 0);
        this.f15369w9.setText(com.flydigi.sdk.gamepad.extension.a.i(i14, 1));
        this.f15369w9.setSelected(i14 != 0);
    }

    public final void G7() {
        E0();
        u7();
        X6();
        g.a().b(X1(), "Module_MappingTest_Start");
        this.G9 = true;
        this.H9 = true;
    }

    public final void H7() {
        if (k6() == null) {
            return;
        }
        com.flydigi.userBehavior.a.a().b(X1(), "外设管理_测试页_按键测试成功");
        this.G9 = false;
        g.a().b(X1(), "Module_MappingTest_Success");
    }

    public final void I7(MotionEvent motionEvent, int i10, float f10, float f11) {
        for (int i11 = 0; i11 < i10; i11++) {
            View viewY6 = Y6(motionEvent.getPointerId(i11));
            if (viewY6 != null) {
                float fB = b1.b(10.0f);
                viewY6.setX((motionEvent.getX(i11) + f10) - fB);
                viewY6.setY((motionEvent.getY(i11) + f11) - fB);
            }
        }
    }

    public final void J7(byte[] bArr) {
        if (k6() == null) {
            return;
        }
        if (k6().isGamepadKeyboard()) {
            this.f15357k9.setSelected(m9.b.I(bArr));
            this.f15358l9.setSelected(m9.b.J(bArr));
            this.f15359m9.setSelected(m9.b.K(bArr));
            this.f15360n9.setSelected(m9.b.L(bArr));
            this.f15361o9.setSelected(m9.b.G(bArr));
            this.f15362p9.setSelected(m9.b.H(bArr));
            this.f15363q9.setSelected(m9.b.F(bArr));
            this.f15353g9.setSelected(m9.b.T(bArr));
            this.f15356j9.setSelected(m9.b.f(bArr));
            this.f15354h9.setSelected(m9.b.l(bArr));
            this.f15355i9.setSelected(m9.b.e0(bArr));
            F7(bArr);
            return;
        }
        this.E8.setSelected(m9.b.t(bArr));
        this.F8.setSelected(m9.b.N(bArr));
        this.C8.setSelected(m9.b.u(bArr));
        this.D8.setSelected(m9.b.O(bArr));
        this.W8.setSelected(m9.b.S(bArr));
        this.X8.setSelected(m9.b.h(bArr));
        this.Y8.setSelected(m9.b.r(bArr));
        this.Z8.setSelected(m9.b.E(bArr));
        this.f15347a9.setSelected(m9.b.V(bArr));
        this.G8.setSelected(m9.b.Y(bArr));
        this.I8.setSelected(m9.b.v(bArr));
        this.J8.setSelected(m9.b.P(bArr));
        this.H8.setSelected(m9.b.n(bArr));
        this.O8.setSelected(m9.b.i(bArr));
        this.P8.setSelected(m9.b.h0(bArr));
        this.Q8.setSelected(m9.b.y(bArr));
        this.R8.setSelected(m9.b.z(bArr));
        this.S8.setSelected(m9.b.A(bArr));
        this.T8.setSelected(m9.b.B(bArr));
        if (n0.b(h.f40768k, k6().getDeviceCode())) {
            this.U8.setSelected(m9.b.C(bArr));
            this.V8.setSelected(m9.b.D(bArr));
        }
        this.N8.setSelected(m9.b.f0(bArr));
        this.M8.setSelected(m9.b.g0(bArr));
        this.K8.setSelected(m9.b.e(bArr));
        this.L8.setSelected(m9.b.g(bArr));
        this.f15348b9.setSelected(m9.b.W(bArr));
        this.f15349c9.setSelected(m9.b.X(bArr));
        this.f15350d9.setSelected(m9.b.a(Integer.valueOf(k6().getDeviceType()), m9.b.q0(bArr)));
        this.f15351e9.setSelected(m9.b.a(Integer.valueOf(k6().getDeviceType()), m9.b.t0(bArr)));
        this.f15352f9.setSelected(m9.b.a(Integer.valueOf(k6().getDeviceType()), m9.b.u0(bArr)));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (T1() != null) {
            y6((GamepadInfo) T1().getParcelable("key_device_info"));
        }
        x(c3(R.string.device_preparing), false);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_keymapping_test;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @p0
    public View O3(@k LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        a1 a1VarD = a1.d(layoutInflater, viewGroup, false);
        this.A8 = a1VarD;
        return a1VarD.getRoot();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void R3() {
        this.H9 = false;
        E0();
        X6();
        super.R3();
    }

    public final void W6() {
        if (!this.G9) {
            n.a(KeyMappingTestFragment.class.getSimpleName() + " 映射测试未开始或已结束");
            return;
        }
        if (!this.B9) {
            if (!this.F9 || this.C9) {
                return;
            }
            this.G9 = false;
            z7("只接收到了映射，没有收到裸数据");
            return;
        }
        g.a().b(X1(), "Module_MappingTest_A_Gatt");
        if (this.D9) {
            this.G9 = false;
            z7("接收到A键裸数据的同时有摇杆数据");
            return;
        }
        if (!this.E9) {
            this.G9 = false;
            z7("只检测到裸数据");
            return;
        }
        if (this.F9) {
            g.a().b(X1(), "Module_MappingTest_A_Mapping");
            n.a(KeyMappingTestFragment.class.getSimpleName() + " 接收到A键裸数据和映射");
            H7();
            return;
        }
        this.G9 = false;
        n.a(KeyMappingTestFragment.class.getSimpleName() + " 接收到A键裸数据和非A键映射");
        z7("接收到A键裸数据和非A键映射");
    }

    public final void X6() {
        com.blankj.utilcode.util.a.g(FullScreenDialogActivity.class, R.anim.fade_in, R.anim.fade_out);
    }

    public final View Y6(int i10) {
        for (int i11 = 0; i11 < this.f15372z9.size(); i11++) {
            View view = this.f15372z9.get(i11);
            if (view.getVisibility() == 0 && view.getTag() != null && ((Integer) view.getTag()).intValue() == i10) {
                return view;
            }
            if (view.getVisibility() != 0) {
                view.setTag(Integer.valueOf(i10));
                view.setVisibility(0);
                view.setSelected(true);
                return view;
            }
        }
        return null;
    }

    public final void Z6(byte[] bArr) {
        if (k6() == null || !m9.b.M(bArr)) {
            return;
        }
        this.C9 = true;
        if (this.G9) {
            if (k6().isGamepadKeyboard()) {
                if (m9.b.I(bArr)) {
                    n.a(getClass().getSimpleName() + " 接收到鼠标左键裸数据");
                    this.B9 = true;
                    s7(this.A9, 250L);
                }
            } else if (m9.b.e(bArr) && m9.b.v0(bArr, k6()).size() == 1) {
                n.a(getClass().getSimpleName() + " 接收到A键裸数据");
                this.B9 = true;
                this.D9 = m9.b.a(Integer.valueOf(k6().getDeviceType()), m9.b.q0(bArr));
                s7(this.A9, 250L);
            }
        }
        if (m9.b.M(bArr) && this.H9) {
            J7(bArr);
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        if (com.blankj.utilcode.util.a.P() != null) {
            com.blankj.utilcode.util.a.P().getWindow().getDecorView().removeOnLayoutChangeListener(this.J9);
        }
    }

    public final void a7(View view) {
        if (k6() == null) {
            return;
        }
        this.E9 = true;
        n.a(KeyMappingTestFragment.class.getSimpleName() + " 接收到touch事件" + view);
        if (!k6().isGamepadKeyboard() && view == this.f15370x9.get(4)) {
            this.F9 = true;
            s7(this.A9, 250L);
        } else if (k6().isGamepadKeyboard() && view == this.f15371y9.get(100)) {
            this.F9 = true;
            s7(this.A9, 250L);
        }
    }

    public final void b7(int i10) {
        int i11 = 0;
        if (i10 == 1) {
            while (i11 < this.f15370x9.size()) {
                this.f15370x9.valueAt(i11).setVisibility(4);
                i11++;
            }
        } else {
            while (i11 < this.f15371y9.size()) {
                this.f15371y9.valueAt(i11).setVisibility(4);
                i11++;
            }
            this.f15364r9.setVisibility(4);
        }
    }

    public final void c7() {
        if (k6() == null) {
            return;
        }
        Button button = (Button) F5(R.id.btn_lt);
        this.C8 = button;
        this.f15370x9.put(12, button);
        Button button2 = (Button) F5(R.id.btn_rt);
        this.D8 = button2;
        this.f15370x9.put(13, button2);
        Button button3 = (Button) F5(R.id.btn_lb);
        this.E8 = button3;
        this.f15370x9.put(10, button3);
        Button button4 = (Button) F5(R.id.btn_rb);
        this.F8 = button4;
        this.f15370x9.put(11, button4);
        Button button5 = (Button) F5(R.id.btn_up);
        this.G8 = button5;
        this.f15370x9.put(0, button5);
        Button button6 = (Button) F5(R.id.btn_down);
        this.H8 = button6;
        this.f15370x9.put(2, button6);
        Button button7 = (Button) F5(R.id.btn_left);
        this.I8 = button7;
        this.f15370x9.put(3, button7);
        Button button8 = (Button) F5(R.id.btn_right);
        this.J8 = button8;
        this.f15370x9.put(1, button8);
        Button button9 = (Button) F5(R.id.btn_a);
        this.K8 = button9;
        this.f15370x9.put(4, button9);
        Button button10 = (Button) F5(R.id.btn_b);
        this.L8 = button10;
        this.f15370x9.put(5, button10);
        Button button11 = (Button) F5(R.id.btn_y);
        this.M8 = button11;
        this.f15370x9.put(8, button11);
        Button button12 = (Button) F5(R.id.btn_x);
        this.N8 = button12;
        this.f15370x9.put(7, button12);
        Button button13 = (Button) F5(R.id.btn_c);
        this.O8 = button13;
        this.f15370x9.put(37, button13);
        Button button14 = (Button) F5(R.id.btn_z);
        this.P8 = button14;
        this.f15370x9.put(38, button14);
        this.Q8 = (Button) F5(R.id.btn_m1);
        if (k6().getDeviceType() == 67) {
            this.Q8.setText("M");
        } else {
            this.Q8.setText("M1");
        }
        this.f15370x9.put(39, this.Q8);
        Button button15 = (Button) F5(R.id.btn_m2);
        this.R8 = button15;
        this.f15370x9.put(40, button15);
        Button button16 = (Button) F5(R.id.btn_m3);
        this.S8 = button16;
        this.f15370x9.put(41, button16);
        Button button17 = (Button) F5(R.id.btn_m4);
        this.T8 = button17;
        this.f15370x9.put(42, button17);
        Button button18 = (Button) F5(R.id.btn_m5);
        this.U8 = button18;
        this.f15370x9.put(53, button18);
        Button button19 = (Button) F5(R.id.btn_m6);
        this.V8 = button19;
        this.f15370x9.put(54, button19);
        Button button20 = (Button) F5(R.id.btn_select);
        this.W8 = button20;
        this.f15370x9.put(6, button20);
        Button button21 = (Button) F5(R.id.btn_back);
        this.X8 = button21;
        this.f15370x9.put(18, button21);
        Button button22 = (Button) F5(R.id.btn_home);
        this.Y8 = button22;
        this.f15370x9.put(19, button22);
        Button button23 = (Button) F5(R.id.btn_menu);
        this.Z8 = button23;
        this.f15370x9.put(20, button23);
        Button button24 = (Button) F5(R.id.btn_start);
        this.f15347a9 = button24;
        this.f15370x9.put(9, button24);
        Button button25 = (Button) F5(R.id.btn_l3);
        this.f15348b9 = button25;
        this.f15370x9.put(14, button25);
        Button button26 = (Button) F5(R.id.btn_r3);
        this.f15349c9 = button26;
        this.f15370x9.put(15, button26);
        Button button27 = (Button) F5(R.id.btn_left_joystick);
        this.f15350d9 = button27;
        this.f15370x9.put(240, button27);
        Button button28 = (Button) F5(R.id.btn_right_joystick);
        this.f15351e9 = button28;
        this.f15370x9.put(241, button28);
        Button button29 = (Button) F5(R.id.btn_wheel);
        this.f15352f9 = button29;
        this.f15370x9.put(m.f40854e0, button29);
        this.f15352f9.setVisibility(n0.b(k6().getDeviceCode(), h.f40768k) ? 0 : 8);
        for (int i10 = 0; i10 < this.f15370x9.size(); i10++) {
            this.f15370x9.valueAt(i10).setOnTouchListener(this);
        }
    }

    public final void d7() {
        this.f15364r9 = F5(R.id.ll_km_common_key);
        this.f15365s9 = (Button) F5(R.id.btn_km_key1);
        this.f15366t9 = (Button) F5(R.id.btn_km_key2);
        this.f15367u9 = (Button) F5(R.id.btn_km_key3);
        this.f15368v9 = (Button) F5(R.id.btn_km_key4);
        this.f15369w9 = (Button) F5(R.id.btn_km_key5);
        Button button = (Button) F5(R.id.btn_shift);
        this.f15353g9 = button;
        this.f15371y9.put(108, button);
        Button button2 = (Button) F5(R.id.btn_ctrl);
        this.f15354h9 = button2;
        this.f15371y9.put(109, button2);
        Button button3 = (Button) F5(R.id.btn_win);
        this.f15355i9 = button3;
        this.f15371y9.put(110, button3);
        Button button4 = (Button) F5(R.id.btn_alt);
        this.f15356j9 = button4;
        this.f15371y9.put(111, button4);
        Button button5 = (Button) F5(R.id.btn_mouse_left);
        this.f15357k9 = button5;
        this.f15371y9.put(100, button5);
        Button button6 = (Button) F5(R.id.btn_mouse_middle);
        this.f15358l9 = button6;
        this.f15371y9.put(102, button6);
        Button button7 = (Button) F5(R.id.btn_mouse_right);
        this.f15359m9 = button7;
        this.f15371y9.put(101, button7);
        Button button8 = (Button) F5(R.id.btn_mouse_wheel_up);
        this.f15360n9 = button8;
        this.f15371y9.put(105, button8);
        Button button9 = (Button) F5(R.id.btn_mouse_wheel_down);
        this.f15361o9 = button9;
        this.f15371y9.put(106, button9);
        Button button10 = (Button) F5(R.id.btn_mouse_forward);
        this.f15362p9 = button10;
        this.f15371y9.put(104, button10);
        Button button11 = (Button) F5(R.id.btn_mouse_backward);
        this.f15363q9 = button11;
        this.f15371y9.put(103, button11);
        for (int i10 = 0; i10 < this.f15371y9.size(); i10++) {
            this.f15371y9.valueAt(i10).setOnTouchListener(this);
        }
    }

    public final void e7() {
        if (k6() == null) {
            return;
        }
        boolean zA = t.a(k6());
        this.G9 = false;
        y7(DataConstant.REMOTE_ACTION_HIDE_FLOAT_WINDOW);
        if (zA) {
            y7(DataConstant.REMOTE_ACTION_START_RESET_JOYSTICK_SMART);
        }
        D7(FullScreenDialogActivity.o4(X1(), 2, c3(R.string.device_reset_joystick), c3(zA ? k6().isGamepadHalf() ? R.string.device_reset_joystick_operation_desc_half : R.string.device_reset_joystick_operation_desc_whole : R.string.put_device_horizontal_no_touch), c3(zA ? R.string.device_reset_joystick_operation_finished : R.string.device_reset_joystick_auto)), 4);
    }

    @Override // com.flydigi.base.common.FZLazyFragment, com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        u7();
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        y7(DataConstant.REMOTE_ACTION_HIDE_FLOAT_WINDOW);
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.B8 = view;
        view.setOnTouchListener(this);
        com.blankj.utilcode.util.o.r(this.A8.f9802i, new View.OnClickListener() { // from class: o7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f42779a.h7(view2);
            }
        });
        com.blankj.utilcode.util.o.r(this.A8.f9796c, new View.OnClickListener() { // from class: o7.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f42785a.i7(view2);
            }
        });
        d7();
        c7();
        this.f15372z9.add(this.A8.f9797d);
        this.f15372z9.add(this.A8.f9798e);
        this.f15372z9.add(this.A8.f9799f);
        this.f15372z9.add(this.A8.f9800g);
        this.f15372z9.add(this.A8.f9801h);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        r7(motionEvent, view);
        return false;
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    @p0
    public d p6() {
        return new b();
    }

    @Override // com.flydigi.device_manager.BaseGamepadFragment
    public void q6(@k final GamepadInfo gamepadInfo) {
        super.q6(gamepadInfo);
        if (!gamepadInfo.isDisconnected() && (!gamepadInfo.isDriverMode() || gamepadInfo.isDriverConnected())) {
            if (gamepadInfo.isConnected()) {
                H5().f(new Runnable() { // from class: o7.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f42780a.g7(gamepadInfo);
                    }
                }, 250L);
                return;
            }
            return;
        }
        if (gamepadInfo.isDisconnected()) {
            o.E(c3(R.string.device_please_connect_gamepad));
        } else if (gamepadInfo.isDriverMode() && !gamepadInfo.isDriverConnected()) {
            o.E(c3(R.string.floatview_please_active_driver));
        }
        E0();
        X6();
        I5();
    }

    public void r7(MotionEvent motionEvent, View view) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return;
                            }
                        }
                    }
                }
            }
            x7();
            a7(view);
            return;
        }
        I7(motionEvent, pointerCount, view.getX(), view.getY());
    }

    public final void s7(Runnable runnable, long j10) {
        H5().g(runnable);
        H5().f(runnable, j10);
    }

    public final void t7() {
        if (k6() == null) {
            return;
        }
        (n5.c.c(R4()) ? z.m0(DataConstant.TEST_KEYMAPPING) : new wg.c(this).q("android.permission.READ_EXTERNAL_STORAGE").l2(new dj.o() { // from class: o7.j
            @Override // dj.o
            public final Object apply(Object obj) {
                return KeyMappingTestFragment.j7((Boolean) obj);
            }
        })).A3(new dj.o() { // from class: o7.i
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f42788a.k7((CFGEntityList) obj);
            }
        }).s0(l.d()).F5(new dj.g() { // from class: o7.g
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f42786a.m7((CFGEntity) obj);
            }
        }, new dj.g() { // from class: o7.h
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f42787a.n7((Throwable) obj);
            }
        });
    }

    public final void u7() {
        if (com.blankj.utilcode.util.a.P() != null) {
            View decorView = com.blankj.utilcode.util.a.P().getWindow().getDecorView();
            decorView.setSystemUiVisibility(4614);
            decorView.addOnLayoutChangeListener(this.J9);
        }
    }

    public final void v7() {
        this.F9 = false;
        this.E9 = false;
        this.D9 = false;
        this.B9 = false;
        this.C9 = false;
        this.G9 = false;
    }

    public final void w7() {
        boolean zA = t.a(k6());
        if (zA) {
            y7(DataConstant.REMOTE_ACTION_FINISH_RESET_JOYSTICK_SMART);
        } else {
            x(c3(R.string.device_reset_joystick_action), false);
            y7(DataConstant.REMOTE_ACTION_T_MODE_RESET_JOYSTICK);
        }
        G5().postDelayed(new Runnable() { // from class: o7.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f42795a.o7();
            }
        }, zA ? 500L : 2000L);
    }

    public final void x7() {
        for (int i10 = 0; i10 < this.f15372z9.size(); i10++) {
            this.f15372z9.get(i10).setVisibility(4);
        }
    }

    public final void y7(String str) {
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).l(H1(), str);
    }

    public final void z7(String str) {
        HashMap map = new HashMap();
        map.put("errorMessage", str);
        g.a().e(X1(), "Module_MappingTest_Error", map);
        com.flydigi.userBehavior.a.a().b(w1(), "外设管理_测试页_按键测试失败(" + str + ee.a.f26979d);
        n.a(getClass().getSimpleName() + " 按键测试失败" + str);
    }
}
