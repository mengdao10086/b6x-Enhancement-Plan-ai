package x7;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.x;
import com.flydigi.base.common.n;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.GameStrategyBean;
import com.flydigi.data.bean.KeyPropertySubPkg;
import com.flydigi.data.bean.RecommendConfigBean;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.google.gson.reflect.TypeToken;
import com.iir_eq.ui.activity.LeScanActivity;
import java.util.HashMap;
import java.util.List;
import m5.c0;
import m5.f0;
import o5.l;
import org.greenrobot.eventbus.ThreadMode;
import u9.g;
import y7.m;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static HashMap<String, KeyPropertySubPkg> f54910q = new HashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f54911r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f54912s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f54913t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static long f54914u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f54915v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f54916w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f54917x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f54918y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f54919a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f54921c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f54925g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GamepadInfo f54928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CFGEntity f54929k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f54931m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f54932n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f54933o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f54920b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f54922d = new Runnable() { // from class: x7.c
        @Override // java.lang.Runnable
        public final void run() {
            this.f54905a.m();
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f54923e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f54924f = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f54926h = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f54934p = 0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n8.b.e(f.this.f54919a, f.this.f54926h)) {
                return;
            }
            if (f.this.n()) {
                n.a("flydigitestdata 调整配置等界面正在使用 不能操作功能菜单界面");
                return;
            }
            f.this.f54925g.l0(12);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 7);
            f.this.f54925g.J(bundle);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n8.b.e(f.this.f54919a, f.this.f54926h)) {
                return;
            }
            if (f.this.o(true)) {
                n.a("flydigitestdata 调整配置等界面正在使用 不能操作映射图标界面");
                return;
            }
            boolean zF = o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + f.this.f54926h, true);
            o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_MAPPING_SHOW_MAPPING_ICON + f.this.f54926h, !zF, true);
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            f.this.f54925g.J(bundle);
        }
    }

    public class c extends TypeToken<GameStrategyBean> {
        public c() {
        }
    }

    public class d extends m5.c<BaseResponse<GameStrategyBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f54938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GameStrategyBean f54939b;

        public d(boolean z10, GameStrategyBean gameStrategyBean) {
            this.f54938a = z10;
            this.f54939b = gameStrategyBean;
        }

        @Override // m5.c
        public void a(String str, int i10) {
            super.a(str, i10);
        }

        @Override // m5.c
        public void d(BaseResponse<GameStrategyBean> baseResponse) {
            GameStrategyBean gameStrategyBean = baseResponse.data;
            if (gameStrategyBean == null || gameStrategyBean.updateTime <= 0) {
                if (this.f54939b != null) {
                    n.a("flydigitestdata checkGameStrategy 攻略未更新");
                    if (this.f54938a) {
                        n.a("flydigitestdata checkGameStrategy 自动弹出-不再提示-不显示攻略");
                        return;
                    } else {
                        n.a("flydigitestdata checkGameStrategy 自动弹出-正常提示-显示攻略");
                        f.this.b0(this.f54939b);
                        return;
                    }
                }
                return;
            }
            GameStrategyBean gameStrategyBean2 = gameStrategyBean;
            String json = f0.i().h().toJson(gameStrategyBean2);
            if (d1.g(gameStrategyBean2.pkgName)) {
                o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_SPECIAL_GAME_STRATEGY_PREFIX + f.this.f54926h, false, true);
                o5.m.l(DataConstant.SP_FLOAT, 2).C("sp_float_game_strategy_prefix_common", json, true);
            } else {
                o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_SPECIAL_GAME_STRATEGY_PREFIX + f.this.f54926h, true, true);
                o5.m.l(DataConstant.SP_FLOAT, 2).C(DataConstant.SP_FLOAT_GAME_STRATEGY_PREFIX + f.this.f54926h, json, true);
            }
            n.a("flydigitestdata checkGameStrategy 攻略有更新");
            if (!this.f54938a) {
                n.a("flydigitestdata checkGameStrategy 自动弹出-正常提示-显示攻略");
                f.this.b0(gameStrategyBean2);
                return;
            }
            n.a("flydigitestdata checkGameStrategy 自动弹出-不再提示");
            GameStrategyBean gameStrategyBean3 = this.f54939b;
            if (gameStrategyBean3 != null && gameStrategyBean3.version >= gameStrategyBean2.version) {
                n.a("flydigitestdata checkGameStrategy 自动弹出-不再提示-攻略无更新-不显示攻略");
                return;
            }
            n.a("flydigitestdata checkGameStrategy 自动弹出-不再提示-攻略有更新-显示攻略");
            if (d1.g(gameStrategyBean2.pkgName)) {
                o5.m.l(DataConstant.SP_FLOAT, 2).G("sp_float_hide_game_strategy_prefix_common", false, true);
            } else {
                o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_HIDE_GAME_STRATEGY_PREFIX + f.this.f54926h, false, true);
            }
            f.this.b0(gameStrategyBean2);
        }
    }

    public f(Context context, Handler handler) {
        this.f54919a = context;
        this.f54921c = handler;
        this.f54925g = new m(context, handler);
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(String str) {
        if (!this.f54927i) {
            W(this.f54919a.getString(R.string.floatview_not_support_vertical_game));
            return;
        }
        this.f54926h = str;
        if (this.f54928j == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 3);
        bundle.putInt(DataConstant.KEY_EDIT_TYPE, 2);
        bundle.putParcelable("key_config", new CFGEntity());
        this.f54925g.J(bundle);
    }

    public static /* synthetic */ void w(BaseResponse baseResponse) throws Exception {
    }

    public static /* synthetic */ void x(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(GamepadInfo gamepadInfo) {
        HashMap map = new HashMap();
        map.put(LeScanActivity.R7, gamepadInfo.getReadableMappingMode());
        map.put("chip", this.f54928j.getChipType() == 1 ? "沁恒" : "NORDIC");
        if (n0.x(gamepadInfo.getFirmwareVersion())) {
            map.put("firmware", gamepadInfo.getFirmwareVersion());
        }
        map.put("deviceName", gamepadInfo.getDeviceName());
        map.put("phone", x.j() + "_" + x.k());
        map.put("system", String.valueOf(Build.VERSION.SDK_INT));
        g.a().e(this.f54919a, "device_mapping_mode", map);
    }

    public void A(int i10, int i11) {
        B(i10, i11, null);
    }

    public void B(int i10, int i11, Object obj) {
        if (this.f54921c != null) {
            Message message = new Message();
            message.what = i10;
            if (i11 > -1) {
                message.arg1 = i11;
            }
            message.obj = obj;
            this.f54921c.sendMessage(message);
        }
    }

    public void C(int i10, Object obj) {
        B(i10, -1, obj);
    }

    public void D(Intent intent) {
        String strL = d1.l(intent.getAction());
        n.a("FloatViewManager Action:" + strL);
        strL.hashCode();
        switch (strL) {
            case "float_window_action_hide_float_mapping_icon":
                Bundle bundle = new Bundle();
                bundle.putInt("action", 1);
                this.f54925g.J(bundle);
                break;
            case "float_window_action_toast":
                W(intent.getStringExtra(DataConstant.TOAST_CONTENT));
                break;
            case "float_window_action_display_over_other_app_permission_show":
                U(true);
                break;
            case "float_window_check_wifi_adb":
                V(true);
                break;
            case "float_window_check_three_finger_show":
                Q(true);
                break;
            case "float_window_action_enable_usb_debug_check_show":
                R(true);
                break;
            case "float_window_action_show_developer_option":
                Y(true);
                break;
            case "float_window_action_show_add_game_adjust_config":
                final String stringExtra = intent.getStringExtra("package_name");
                this.f54920b.postDelayed(new Runnable() { // from class: x7.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f54908a.v(stringExtra);
                    }
                }, 2000L);
                break;
            case "float_window_close_all":
                q();
                break;
            case "float_window_action_enable_usb_debug_show":
                X(true);
                break;
        }
    }

    public void E(String str, List<CFGEntity> list, CFGEntity cFGEntity, List<RecommendConfigBean.RecommendConfig> list2) {
        this.f54926h = str;
        this.f54929k = cFGEntity;
        if (!TextUtils.equals(str, DataConstant.TEST_KEYMAPPING)) {
            this.f54920b.removeCallbacks(this.f54922d);
            this.f54920b.postDelayed(this.f54922d, 2000L);
        }
        this.f54925g.K(this.f54926h, list, list2, this.f54929k);
        if (p()) {
            if (!DataConstant.TEST_KEYMAPPING.equals(this.f54926h)) {
                com.flydigi.userBehavior.a.a().b(this.f54919a, "悬浮窗_启动游戏_" + com.blankj.utilcode.util.d.k(this.f54926h));
            }
            F("StartGame");
            if (DataConstant.TEST_KEYMAPPING.equals(this.f54926h)) {
                return;
            }
            HashMap map = new HashMap();
            map.put("pkgName", this.f54926h);
            GamepadInfo gamepadInfo = this.f54928j;
            if (gamepadInfo != null) {
                int mappingMode = gamepadInfo.getMappingMode();
                map.put(LeScanActivity.R7, mappingMode != 0 ? mappingMode != 1 ? mappingMode != 3 ? mappingMode != 4 ? "未知" : "iOS智连模式" : "Android智连模式Q" : "Android智连模式" : "传统模式");
                map.put("chip", this.f54928j.getChipType() == 1 ? "沁恒" : "NORDIC");
                if (n0.x(this.f54928j.getFirmwareVersion())) {
                    map.put("firmware", this.f54928j.getFirmwareVersion());
                }
                map.put("deviceName", this.f54928j.getDeviceName());
                if (n0.x(this.f54928j.getDriverVersion())) {
                    map.put("driverVersion", this.f54928j.getDriverVersion());
                }
                map.put("manufacturer", x.j());
                map.put("model", x.k());
                map.put("system", String.valueOf(Build.VERSION.SDK_INT));
            }
            g.a().e(this.f54919a, "Module_FloatView_StartGame", map);
        }
    }

    public void F(String str) {
        h5.c cVar = (h5.c) f0.i().k().g(h5.c.class);
        String strC = com.blankj.utilcode.util.d.C();
        String strH = u9.b.h(this.f54919a, this.f54926h);
        GamepadInfo gamepadInfo = this.f54928j;
        String strG = gamepadInfo == null ? v5.a.j().g() : gamepadInfo.getDeviceName();
        GamepadInfo gamepadInfo2 = this.f54928j;
        cVar.a(str, strC, strH, strG, gamepadInfo2 == null ? v5.a.j().e() : gamepadInfo2.getAddress(), x.j(), x.k(), Build.VERSION.RELEASE).s0(c0.t()).J5(lj.b.d()).b4(lj.b.d()).F5(new dj.g() { // from class: x7.a
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                f.w((BaseResponse) obj);
            }
        }, new dj.g() { // from class: x7.b
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                f.x((Throwable) obj);
            }
        });
    }

    public final void G() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public void H(CFGEntity cFGEntity) {
        this.f54929k = cFGEntity;
    }

    public void I(boolean z10) {
        this.f54927i = z10;
        this.f54925g.M(z10);
    }

    public void J(String str) {
        this.f54926h = str;
        this.f54925g.O(str);
    }

    public void K(GamepadInfo gamepadInfo) {
        this.f54928j = gamepadInfo;
        this.f54925g.N(gamepadInfo);
    }

    public void L(boolean z10) {
        this.f54932n = z10;
    }

    public void M(boolean z10) {
        this.f54933o = z10;
    }

    public void N(boolean z10) {
        this.f54930l = z10;
    }

    public void O(boolean z10) {
        this.f54931m = z10;
    }

    public void P(GamepadInfo gamepadInfo) {
        if (gamepadInfo != null) {
            if (gamepadInfo.isDriverMode() && !gamepadInfo.isDriverConnected()) {
                q();
            } else {
                if (u9.b.d() || !this.f54928j.isGamepadHalf() || gamepadInfo.isDriverConnected()) {
                    return;
                }
                q();
            }
        }
    }

    public void Q(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(95, bundle);
    }

    public void R(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(92, bundle);
    }

    public final void S(boolean z10, final GamepadInfo gamepadInfo) {
        Bundle bundle = new Bundle();
        bundle.putString("device_name", gamepadInfo.getDeviceName());
        bundle.putBoolean(DataConstant.DEVICE_CONNECT_STATE, z10);
        this.f54925g.w(5, bundle);
        this.f54920b.postDelayed(new Runnable() { // from class: x7.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f54906a.y(gamepadInfo);
            }
        }, 1500L);
    }

    public void T(GamepadInfo gamepadInfo) {
        if (gamepadInfo.isConnected()) {
            S(true, gamepadInfo);
        } else if (gamepadInfo.isDisconnected()) {
            S(false, gamepadInfo);
            q();
        }
    }

    public void U(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(94, bundle);
    }

    public void V(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(96, bundle);
    }

    public final void W(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("content", str);
        this.f54925g.w(6, bundle);
    }

    public void X(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(91, bundle);
    }

    public void Y(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z10);
        this.f54925g.w(90, bundle);
    }

    public void Z(boolean z10) {
        if (z10) {
            this.f54925g.Q(0);
        } else {
            this.f54925g.y(0);
        }
    }

    public void a0() {
        this.f54925g.w(13, new Bundle());
    }

    public final void b0(GameStrategyBean gameStrategyBean) {
        n.a("flydigitestdata showStrategyView 准备显示攻略：" + gameStrategyBean.toString());
        if (n0.z(gameStrategyBean.config)) {
            this.f54925g.l0(8);
            this.f54925g.l0(3);
            n.a("flydigitestdata showStrategyView foreground:" + com.blankj.utilcode.util.d.L() + " mCurLandscape：" + this.f54927i);
            if (com.blankj.utilcode.util.d.L() || !this.f54927i) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f54926h);
            bundle.putBoolean("value", false);
            bundle.putSerializable("content", gameStrategyBean);
            this.f54925g.w(8, bundle);
        }
    }

    public final void c0() {
        if (this.f54927i) {
            this.f54920b.removeCallbacks(this.f54923e);
            this.f54920b.post(this.f54923e);
        }
    }

    public final void d0() {
        if (this.f54927i && this.f54925g.j(0)) {
            this.f54920b.removeCallbacks(this.f54924f);
            this.f54920b.post(this.f54924f);
        }
    }

    public final void e0() {
        if (tt.c.f().o(this)) {
            tt.c.f().A(this);
        }
    }

    public void f0(int i10, List<CFGEntity> list) {
        this.f54925g.R(i10, list);
    }

    public void finalize() throws Throwable {
        super.finalize();
        e0();
    }

    public final boolean l() {
        return this.f54925g.h();
    }

    public final void m() {
        boolean zF;
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_SPECIAL_GAME_STRATEGY_PREFIX + this.f54926h, false)) {
            zF = o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_GAME_STRATEGY_PREFIX + this.f54926h, false);
        } else {
            zF = o5.m.l(DataConstant.SP_FLOAT, 2).f("sp_float_hide_game_strategy_prefix_common", false);
        }
        GameStrategyBean gameStrategyBean = null;
        if (zF && !o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_VIEW_GUIDE_FLOAT_BALL, false)) {
            this.f54925g.w(12, null);
        }
        long j10 = 0;
        String strR = o5.m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_GAME_STRATEGY_PREFIX + this.f54926h, "");
        if (d1.g(strR)) {
            strR = o5.m.l(DataConstant.SP_FLOAT, 2).r("sp_float_game_strategy_prefix_common", "");
        }
        if (!d1.g(strR)) {
            gameStrategyBean = (GameStrategyBean) f0.i().h().fromJson(strR, new c().getType());
            j10 = gameStrategyBean.updateTime;
        }
        n.a("flydigitestdata checkGameStrategy 上次更新攻略 lastStrategy:" + gameStrategyBean);
        n.a("flydigitestdata checkGameStrategy 上次更新时间 lastTime:" + j10);
        ((h5.d) f0.i().k().g(h5.d.class)).u(this.f54926h, j10).s0(c0.t()).s0(l.d()).c(new d(zF, gameStrategyBean));
    }

    public final boolean n() {
        return o(false);
    }

    public final boolean o(boolean z10) {
        return this.f54925g.i(z10);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(BluetoothDeviceOperateEvent bluetoothDeviceOperateEvent) {
        if (this.f54928j != null && !f54911r && this.f54927i && m9.b.M(bluetoothDeviceOperateEvent.value)) {
            if (this.f54928j.isGamepadHalf()) {
                int deviceType = this.f54928j.getDeviceType();
                if (deviceType == 64 || deviceType == 65 || deviceType == 66) {
                    if (!m9.b.W(bluetoothDeviceOperateEvent.value) || this.f54931m || n8.b.d(14, this.f54929k) || l()) {
                        return;
                    }
                    if (System.currentTimeMillis() - f54915v <= 150) {
                        f54915v = System.currentTimeMillis();
                        return;
                    } else {
                        f54915v = System.currentTimeMillis();
                        c0();
                        return;
                    }
                }
                if (m9.b.S(bluetoothDeviceOperateEvent.value) && !this.f54930l && !n8.b.d(6, this.f54929k)) {
                    if (l()) {
                        return;
                    }
                    if (System.currentTimeMillis() - f54916w <= 150) {
                        f54916w = System.currentTimeMillis();
                        return;
                    } else {
                        f54916w = System.currentTimeMillis();
                        c0();
                    }
                }
                if (!m9.b.W(bluetoothDeviceOperateEvent.value) || this.f54931m || n8.b.d(14, this.f54929k) || l()) {
                    return;
                }
                if (System.currentTimeMillis() - f54915v <= 150) {
                    f54915v = System.currentTimeMillis();
                    return;
                } else {
                    f54915v = System.currentTimeMillis();
                    d0();
                    return;
                }
            }
            if ((bluetoothDeviceOperateEvent.value[0] & 255) == 172) {
                return;
            }
            if (this.f54928j.isGamepadKeyboard()) {
                if (m9.b.o(bluetoothDeviceOperateEvent.value) && !this.f54932n) {
                    if (l()) {
                        return;
                    }
                    if (System.currentTimeMillis() - f54913t <= 80) {
                        f54913t = System.currentTimeMillis();
                        return;
                    } else {
                        f54913t = System.currentTimeMillis();
                        d0();
                    }
                }
                if (!m9.b.p(bluetoothDeviceOperateEvent.value) || this.f54933o || l()) {
                    return;
                }
                if (System.currentTimeMillis() - f54914u <= 80) {
                    f54914u = System.currentTimeMillis();
                    return;
                } else {
                    f54914u = System.currentTimeMillis();
                    c0();
                    return;
                }
            }
            if (m9.b.S(bluetoothDeviceOperateEvent.value) && !this.f54930l) {
                if (l()) {
                    return;
                }
                if (System.currentTimeMillis() - f54917x <= 150) {
                    f54917x = System.currentTimeMillis();
                    return;
                } else {
                    f54917x = System.currentTimeMillis();
                    c0();
                }
            }
            if (!m9.b.W(bluetoothDeviceOperateEvent.value) || this.f54931m || l()) {
                return;
            }
            if (System.currentTimeMillis() - f54918y <= 150) {
                f54918y = System.currentTimeMillis();
            } else {
                f54918y = System.currentTimeMillis();
                d0();
            }
        }
    }

    public final boolean p() {
        if (System.currentTimeMillis() - this.f54934p <= 2000) {
            return false;
        }
        this.f54934p = System.currentTimeMillis();
        return true;
    }

    public void q() {
        this.f54925g.L();
    }

    public void r() {
        this.f54925g.l0(1);
        this.f54925g.v(2);
    }

    public void s(boolean z10) {
        GamepadInfo gamepadInfo = this.f54928j;
        if (gamepadInfo == null || !gamepadInfo.isConnected()) {
            return;
        }
        if ((this.f54928j.isFlashplayMode() || this.f54928j.isDriverConnected()) && z10 && !DataConstant.TEST_KEYMAPPING.equals(this.f54926h) && !n0.b(this.f54926h, this.f54919a.getPackageName())) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 2);
            this.f54925g.J(bundle);
        }
    }

    public void t() {
        R(false);
        Q(false);
        X(false);
        V(false);
        Y(false);
    }

    public void u() {
        this.f54925g.x();
    }

    public void z(int i10) {
        A(i10, -1);
    }

    @tt.l(threadMode = ThreadMode.MAIN)
    public void onEvent(FlyMouseEvent flyMouseEvent) {
        if (l()) {
            return;
        }
        this.f54925g.P(flyMouseEvent);
    }
}
