package com.android.motionelf;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.WindowManager;
import com.android.motionelf.adb.AdbManager;
import com.android.motionelf.work.DeleteGameHasNotConfigWorker;
import com.android.motionelf.work.FindGameHasConfigWorker;
import com.android.motionelf.work.FindSupportedGameFromInstalledAppsWorker;
import com.android.motionelf.work.SyncSupportedGameWorker;
import com.android.motionelf.z0;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.KeyPropertySubPkg;
import com.flydigi.data.bean.RecommendConfigBean;
import com.flydigi.data.event.BluetoothDeviceOperateEvent;
import com.flydigi.data.event.FlyMouseEvent;
import com.flydigi.remote.DeviceInfo;
import com.flydigi.remote.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateBean;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateItem;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateList;
import com.flydigi.sdk.gamepad.extension.config.data.FloatWindowSizeBean;
import com.flydigi.userBehavior.UserBehaviorManager;
import h9.b;
import i9.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import k3.b;
import moe.shizuku.manager.adb.AdbInvalidPairingCodeException;
import n3.d;
import n8.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingWindow extends androidx.lifecycle.d0 implements z0.b, b.a, d.c, AdbManager.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k3.b f11211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AdbManager f11212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n3.d f11213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x7.f f11214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UserBehaviorManager f11215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GamepadInfo f11216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InstalledGameBean f11217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CFGEntity f11218j;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public CFGEntity f11220k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FloatWindowSizeBean f11221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WindowManager f11222m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Handler f11225p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f11226q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f11227r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public UsageStatsManager f11228s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f11210b = new Runnable() { // from class: com.android.motionelf.k0
        @Override // java.lang.Runnable
        public final void run() {
            this.f11298a.B1();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11219k = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11223n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f11224o = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11230u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LruCache<String, RecommendConfigBean> f11231v = new LruCache<>(5);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<RecommendConfigBean.RecommendConfig> f11232w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<CFGEntity> f11233x = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RemoteCallbackList<h9.c> f11234y = new RemoteCallbackList<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RemoteCallbackList<h9.d> f11235z = new RemoteCallbackList<>();
    public final b.AbstractBinderC0365b A = new a();
    public final z0.a B = new FloatingWindowPresenter(this);
    public BroadcastReceiver C = new b();
    public int D = 5;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final io.reactivex.disposables.a f11229t = new io.reactivex.disposables.a();

    public class a extends b.AbstractBinderC0365b {
        public a() {
        }

        @Override // h9.b
        public DeviceInfo E0() {
            return DeviceInfo.a(FloatingWindow.this.f11216h);
        }

        @Override // h9.b
        public void O(h9.c cVar) {
            if (cVar != null) {
                FloatingWindow.this.f11234y.register(cVar);
            }
        }

        @Override // h9.b
        public void S(h9.d dVar) {
            if (dVar != null) {
                FloatingWindow.this.f11235z.register(dVar);
            }
        }

        @Override // h9.b
        public void W(h9.c cVar) {
            if (cVar != null) {
                FloatingWindow.this.f11234y.unregister(cVar);
            }
        }

        @Override // h9.b
        public void b0(h9.d dVar) {
            if (dVar != null) {
                FloatingWindow.this.f11235z.unregister(dVar);
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleP = f0.h0.p(intent);
            if (bundleP != null) {
                CharSequence charSequence = bundleP.getCharSequence("quick_notification_wadb_pair");
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("输入的配对码是");
                sb2.append((Object) charSequence);
                FloatingWindow.this.f11212d.j(charSequence);
            }
        }
    }

    public class c implements a.b {
        public c() {
        }

        @Override // n8.a.b
        public void a() {
            FloatingWindow.this.I1();
        }

        @Override // n8.a.b
        public void b() {
            FloatingWindow.this.I1();
        }
    }

    public class d extends io.reactivex.observers.d<CFGEntity> {
        public d() {
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(@yt.k CFGEntity cFGEntity) {
            if (FloatingWindow.this.f11218j == null || FloatingWindow.this.f11218j.isInvalid()) {
                if (cFGEntity.isInvalid()) {
                    cFGEntity.toString();
                } else {
                    FloatingWindow floatingWindow = FloatingWindow.this;
                    floatingWindow.k3(floatingWindow.f11219k, cFGEntity);
                }
            }
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getConfigObserver:");
            sb2.append(th2.getMessage());
            if (FloatingWindow.this.f11218j == null || FloatingWindow.this.f11218j.isInvalid()) {
                if (FloatingWindow.this.f11218j != null) {
                    FloatingWindow.this.f11218j.toString();
                }
                CFGEntity cFGEntityB = e6.z.B(FloatingWindow.this.f11216h.getDeviceMode());
                FloatingWindow floatingWindow = FloatingWindow.this;
                floatingWindow.k3(floatingWindow.f11219k, cFGEntityB);
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        public final IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            return intentFilter;
        }

        public void b(Context context) {
            context.registerReceiver(this, a());
        }

        public void c(Context context) {
            context.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String dataString = intent.getDataString();
                Objects.requireNonNull(dataString);
                String strSubstring = dataString.substring(8);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("接收到的app包名：");
                sb2.append(strSubstring);
                FloatingWindow.this.w3(strSubstring);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            FloatingWindow.this.f11211c.b();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (com.blankj.utilcode.util.d1.g(intent.getAction())) {
                return;
            }
            String action = intent.getAction();
            action.hashCode();
            switch (action) {
                case "android.intent.action.SCREEN_OFF":
                    com.flydigi.base.common.n.a("screenLog,screen off");
                    if (FloatingWindow.this.f11213e != null) {
                        FloatingWindow.this.f11213e.D();
                        break;
                    }
                    break;
                case "android.intent.action.SCREEN_ON":
                    com.flydigi.base.common.n.a("screenLog,screen on");
                    if (FloatingWindow.this.f11213e != null) {
                        FloatingWindow.this.f11213e.E();
                        break;
                    }
                    break;
                case "android.intent.action.USER_PRESENT":
                    com.flydigi.base.common.n.a("screenLog,screen present");
                    if (FloatingWindow.this.f11213e != null) {
                        FloatingWindow.this.f11213e.F();
                    }
                    if (FloatingWindow.this.f11211c != null) {
                        FloatingWindow.this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.y0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f11407a.b();
                            }
                        }, 500L);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(CFGEntityList cFGEntityList) throws Exception {
        if (!cFGEntityList.isValid()) {
            this.f11233x.clear();
        } else {
            this.f11233x.clear();
            this.f11233x.addAll(e6.z.H(cFGEntityList, this.f11216h.getDeviceMode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 C2(InstalledGameBean installedGameBean) throws Exception {
        return e6.z.n0(installedGameBean.getLocalPackageName(), installedGameBean.getStandardPackageName()).Y1(new dj.g() { // from class: com.android.motionelf.v0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11396a.A2((CFGEntityList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 D2(long j10, InstalledGameBean installedGameBean, RecommendConfigBean recommendConfigBean, RecommendConfigBean recommendConfigBean2) throws Exception {
        if (j10 != 0 && recommendConfigBean2.getVersion() == j10) {
            this.f11231v.put(installedGameBean.getStandardPackageName(), recommendConfigBean);
            return xi.z.m3(recommendConfigBean);
        }
        this.f11231v.put(installedGameBean.getStandardPackageName(), recommendConfigBean2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cachedRecommendConfig put:");
        sb2.append(recommendConfigBean2);
        return e6.z.x0(recommendConfigBean2, installedGameBean.getLocalPackageName());
    }

    public static /* synthetic */ xi.e0 F2(RecommendConfigBean recommendConfigBean, Throwable th2) throws Exception {
        return xi.z.m3(recommendConfigBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 G2(final InstalledGameBean installedGameBean, final RecommendConfigBean recommendConfigBean) throws Exception {
        final long version = recommendConfigBean.getVersion();
        return ((h5.b) m5.f0.i().k().g(h5.b.class)).a(version, installedGameBean.getStandardPackageName(), installedGameBean.getTitle()).s0(m5.c0.p()).J5(lj.b.a()).l2(new dj.o() { // from class: com.android.motionelf.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11389a.D2(version, installedGameBean, recommendConfigBean, (RecommendConfigBean) obj);
            }
        }).f4(new dj.o() { // from class: com.android.motionelf.x
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindow.F2(recommendConfigBean, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 H2(final InstalledGameBean installedGameBean) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cachedRecommendConfig installedGameBean ");
        sb2.append(installedGameBean);
        RecommendConfigBean recommendConfigBean = this.f11231v.get(installedGameBean.getStandardPackageName());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("cachedRecommendConfig recommendConfigBean:");
        sb3.append(recommendConfigBean);
        return com.blankj.utilcode.util.n0.y(recommendConfigBean) ? xi.z.m3(recommendConfigBean) : e6.z.p0(installedGameBean.getLocalPackageName()).l2(new dj.o() { // from class: com.android.motionelf.v
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11394a.G2(installedGameBean, (RecommendConfigBean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List I2(RecommendConfigBean recommendConfigBean) throws Exception {
        int deviceMode = this.f11216h.getDeviceMode();
        return deviceMode != 1 ? deviceMode != 2 ? recommendConfigBean.getGamepadList() : recommendConfigBean.getV1List() : recommendConfigBean.getKeyboardMouseList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List J2(List list) throws Exception {
        this.f11232w.clear();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            RecommendConfigBean.RecommendConfig recommendConfig = (RecommendConfigBean.RecommendConfig) it2.next();
            if (recommendConfig.getType() != 0) {
                this.f11232w.add(recommendConfig);
            } else if (this.f11216h.getDeviceType() == 68) {
                if (!com.blankj.utilcode.util.n0.m(recommendConfig.getDeviceType()) && recommendConfig.getDeviceType().contains(this.f11216h.getDeviceCode())) {
                    this.f11232w.add(recommendConfig);
                }
            } else if (com.blankj.utilcode.util.n0.m(recommendConfig.getDeviceType()) || recommendConfig.getDeviceType().contains(this.f11216h.getDeviceCode())) {
                this.f11232w.add(recommendConfig);
            }
        }
        return this.f11232w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable L2(UsageStatsManager usageStatsManager) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return this.f11228s.queryUsageStats(4, jCurrentTimeMillis - 2000, jCurrentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2() {
        this.f11213e.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P2() {
        onDestroy();
        stopSelf();
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q2(Message message) {
        a2(message);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2() {
        if (this.f11216h.isDriverConnected()) {
            this.f11213e.w(this.f11216h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2() {
        if (this.f11213e == null || v5.c.f()) {
            return;
        }
        this.f11213e.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T2() {
        this.f11212d.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(boolean z10, int i10) {
        if (!z10) {
            this.f11214f.P(this.f11216h);
            if (x3(this.f11223n) && this.f11216h.isConnected() && !this.f11216h.isDriverConnected() && DBManager.getInstance().isSupportGame(this.f11219k)) {
                n8.b.m(this, getString(R.string.floatview_please_active_driver));
                return;
            }
            return;
        }
        if (v5.c.c(u9.b.j(i10))) {
            i3();
            if (v5.c.f()) {
                n3.b.a();
            } else {
                this.f11213e.o();
                if (o5.b.i(this)) {
                    this.f11212d.h(v5.c.f52717i);
                    return;
                }
            }
        }
        n3.d dVar = this.f11213e;
        if (dVar != null) {
            dVar.w(this.f11216h);
        }
        if (x3(this.f11223n)) {
            F1(this.f11219k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2() {
        this.f11211c.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean W2(Message message) {
        com.flydigi.base.common.n.a("flydigitestdata Remote尝试主动连接并退出 ------TCPIP尝试成功，无需再进行TCPIP尝试");
        h3(message.what != 0);
        return false;
    }

    public static /* synthetic */ xi.e0 X2(xi.z zVar, xi.z zVar2) throws Exception {
        return xi.z.H3(zVar2, zVar.J5(lj.b.d()).n6(zVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y2(CFGVibrateBean cFGVibrateBean, CFGVibrateList cFGVibrateList) throws Exception {
        D3(cFGVibrateBean.getEnable(), cFGVibrateBean.getKeys());
    }

    public static /* synthetic */ void Z2(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a3(boolean z10, GamepadInfo gamepadInfo) {
        if (z10) {
            if (gamepadInfo.isConnected()) {
                this.f11215g.W(gamepadInfo, "悬浮窗_手柄已连接");
            } else if (gamepadInfo.isDisconnected()) {
                this.f11215g.W(gamepadInfo, "悬浮窗_手柄未连接");
            }
            x7.f fVar = this.f11214f;
            if (fVar != null) {
                fVar.T(gamepadInfo);
            }
        }
        com.android.motionelf.tools.e.g(this, gamepadInfo.isConnected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(InstalledGameBean installedGameBean) throws Exception {
        this.f11215g.W(this.f11216h, "悬浮窗_" + installedGameBean.getTitle() + "_3min");
        l3();
    }

    public static /* synthetic */ CFGVibrateBean c3(CFGVibrateList cFGVibrateList) throws Exception {
        return cFGVibrateList.getConfigs().get(0);
    }

    public static /* synthetic */ void d2(Throwable th2) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3(CFGVibrateBean cFGVibrateBean) throws Exception {
        D3(cFGVibrateBean.getEnable(), cFGVibrateBean.getKeys());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(InstalledGameBean installedGameBean) throws Exception {
        this.f11217i = installedGameBean;
        if (this.f11211c != null) {
            if (!installedGameBean.isUseMappingMode()) {
                throw new IllegalArgumentException("No Supported");
            }
            if (this.f11216h.isFlashplayMode() || this.f11216h.isDriverConnected()) {
                if (TextUtils.equals(installedGameBean.getLocalPackageName(), DataConstant.TEST_KEYMAPPING)) {
                    if (this.f11216h.isFlashplayMode()) {
                        this.f11211c.n();
                        return;
                    } else {
                        this.f11211c.o();
                        return;
                    }
                }
                if (this.f11216h.isFlashplayMode()) {
                    this.f11211c.m();
                } else {
                    this.f11211c.h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(Throwable th2) throws Exception {
        D3(false, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(String str, InstalledGameBean installedGameBean) throws Exception {
        if (this.f11214f != null) {
            if (installedGameBean.isUseMappingMode()) {
                m3(str);
                return;
            }
            this.f11218j = null;
            this.f11214f.H(null);
            this.f11214f.q();
            if (this.f11216h.isSupportMotor()) {
                D3(false, Collections.emptyList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(Throwable th2) throws Exception {
        GamepadInfo gamepadInfo;
        this.f11217i = null;
        this.f11218j = null;
        this.f11214f.H(null);
        this.f11214f.q();
        n3.d dVar = this.f11213e;
        if (dVar != null) {
            dVar.c();
        }
        if (this.f11211c == null || (gamepadInfo = this.f11216h) == null) {
            return;
        }
        if (gamepadInfo.isSupportMotor()) {
            D3(false, Collections.emptyList());
        }
        if (this.f11216h.isFlashplayMode()) {
            this.f11211c.m();
            return;
        }
        this.f11211c.j();
        n3.d dVar2 = this.f11213e;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(InstalledGameBean installedGameBean) throws Exception {
        if (!installedGameBean.isUseMappingMode()) {
            x7.f.f54911r = true;
            return;
        }
        this.f11214f.s(true);
        l3();
        x7.f.f54911r = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(Throwable th2) throws Exception {
        if (com.blankj.utilcode.util.x.A() || o5.m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_FLOAT_KEY_NEED_START_FROM_APP_DIALOG_SHOWN)) {
            x7.f.f54911r = true;
        } else {
            this.f11214f.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2() {
        GamepadInfo gamepadInfo;
        if (this.f11214f == null || (gamepadInfo = this.f11216h) == null || !gamepadInfo.isConnected()) {
            return;
        }
        DBManager.getInstance().getInstalledGameObservable(this.f11219k).s0(o5.l.d()).F5(new dj.g() { // from class: com.android.motionelf.h0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11289a.j2((InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.c
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11271a.k2((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 m2(Long l10) throws Exception {
        return Z1();
    }

    public static /* synthetic */ boolean n2(SortedMap sortedMap) throws Exception {
        return !sortedMap.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o2(SortedMap sortedMap) throws Exception {
        String packageName;
        LinkedList linkedList = new LinkedList(sortedMap.values());
        int size = linkedList.size() - 1;
        while (true) {
            if (size < 0) {
                packageName = "";
                break;
            }
            packageName = ((UsageStats) linkedList.get(size)).getPackageName();
            if (!l4.f.f39447b.equalsIgnoreCase(packageName) && !com.blankj.utilcode.util.n0.b("com.tencent.qqpinyin", packageName) && !packageName.contains("com.baidu.input") && !packageName.contains("inputmethod")) {
                break;
            } else {
                size--;
            }
        }
        com.flydigi.base.common.n.a("topPackageName:" + packageName + "，mRunningPkgName：" + this.f11219k);
        if (this.f11219k.equalsIgnoreCase(packageName)) {
            return;
        }
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).e(getApplicationContext(), DataConstant.REMOTE_ACTION_START_GAME, "package_name", packageName);
    }

    public static /* synthetic */ void p2(Throwable th2) throws Exception {
        com.flydigi.base.common.n.d(th2, "未获取到其他应用数据", new Object[0]);
    }

    public static /* synthetic */ xi.e0 q2(List list) throws Exception {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            RecommendConfigBean.RecommendConfig recommendConfig = (RecommendConfigBean.RecommendConfig) it2.next();
            if (recommendConfig.getType() == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("找到第一个推荐配置：");
                sb2.append(recommendConfig.getTitle());
                return xi.z.m3(recommendConfig);
            }
        }
        return xi.z.m3(new RecommendConfigBean.RecommendConfig());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CFGEntity s2(File file) throws Exception {
        return e6.z.j0(file, true, this.f11216h.getDeviceMode());
    }

    public static /* synthetic */ void t2(RecommendConfigBean.RecommendConfig recommendConfig, CFGEntity cFGEntity) throws Exception {
        cFGEntity.title = recommendConfig.getTitle();
        cFGEntity.desc = recommendConfig.getDesc();
        cFGEntity.setRatio(recommendConfig.getRatio());
        cFGEntity.setRecommend(true);
        cFGEntity.setInUse(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ xi.e0 u2(final RecommendConfigBean.RecommendConfig recommendConfig) throws Exception {
        CFGEntity cFGEntity = this.f11218j;
        if (cFGEntity != null && !cFGEntity.isInvalid() && !this.f11218j.isDefault()) {
            return xi.z.m3(this.f11218j);
        }
        if (!com.blankj.utilcode.util.n0.x(recommendConfig.getConfigUrl())) {
            return xi.z.m3(e6.z.B(this.f11216h.getDeviceMode()));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("下载推荐配置：");
        sb2.append(recommendConfig.getTitle());
        return e6.z.F(recommendConfig.getConfigUrl()).A3(new dj.o() { // from class: com.android.motionelf.r
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11318a.s2((File) obj);
            }
        }).Y1(new dj.g() { // from class: com.android.motionelf.g
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                FloatingWindow.t2(recommendConfig, (CFGEntity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(CFGEntity cFGEntity) throws Exception {
        cFGEntity.setGamepad(this.f11216h.getDeviceCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(CFGEntity cFGEntity) throws Exception {
        boolean z10;
        Iterator<CFGEntity> it2 = this.f11233x.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z10 = true;
                break;
            }
            CFGEntity next = it2.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mConfigsForCurrentDevice entity:");
            sb2.append(next);
            if (next.isForCurrentDevice(this.f11216h.getDeviceCode())) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("mConfigsForCurrentDevice put:");
            sb3.append(cFGEntity);
            this.f11233x.add(cFGEntity);
            s3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CFGEntity z2(CFGEntityList cFGEntityList) throws Exception {
        return e6.z.J(cFGEntityList, this.f11216h);
    }

    @Override // k3.b.a
    public void A(byte[] bArr) {
        FloatWindowSizeBean floatWindowSizeBean;
        if (m9.b.U(bArr) && (floatWindowSizeBean = this.f11221l) != null) {
            tt.c.f().q(new FlyMouseEvent(com.android.motionelf.tools.f.a(bArr, floatWindowSizeBean.getFloatWindowStartPosition()[0], this.f11216h), com.android.motionelf.tools.f.b(bArr, this.f11221l.getFloatWindowStartPosition()[1], this.f11216h), bArr[17], true));
        }
        tt.c.f().q(new BluetoothDeviceOperateEvent(bArr));
        try {
            int iBeginBroadcast = this.f11235z.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.d) this.f11235z.getBroadcastItem(i10)).A(bArr);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11235z.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void A3(final GamepadInfo gamepadInfo, final boolean z10) {
        this.f11224o.post(new Runnable() { // from class: com.android.motionelf.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11319a.a3(z10, gamepadInfo);
            }
        });
    }

    public final void B1() {
        this.f11225p.removeCallbacks(this.f11210b);
        GamepadInfo gamepadInfo = this.f11216h;
        if (gamepadInfo == null || !gamepadInfo.isConnected() || com.blankj.utilcode.util.n0.b(DataConstant.TEST_KEYMAPPING, this.f11219k) || com.blankj.utilcode.util.n0.b(getPackageName(), this.f11219k) || !x3(this.f11223n)) {
            return;
        }
        DBManager.getInstance().getInstalledGameObservable(this.f11219k).J5(lj.b.d()).b4(lj.b.d()).F5(new dj.g() { // from class: com.android.motionelf.s0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11323a.c2((InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.i
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                FloatingWindow.d2((Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: B3, reason: merged with bridge method [inline-methods] */
    public final void b3(final CFGEntity cFGEntity) {
        if (cFGEntity == null || !x3(this.f11223n) || this.f11221l == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("配置为空：");
            sb2.append(cFGEntity == null);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("不是横屏：");
            sb3.append(!x3(this.f11223n));
            StringBuilder sb4 = new StringBuilder();
            sb4.append("mFloatWindowSizeBean为空：");
            sb4.append(this.f11221l == null);
            int i10 = this.D - 1;
            this.D = i10;
            if (i10 > 0) {
                this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11312a.b3(cFGEntity);
                    }
                }, 1000L);
                return;
            }
            return;
        }
        this.D = 10;
        CFGEntity cFGEntityCopy = cFGEntity.copy();
        KeyPropertySubPkg keyPropertySubPkg = x7.f.f54910q.get(this.f11219k);
        if (keyPropertySubPkg == null) {
            keyPropertySubPkg = x7.f.f54910q.get(DataConstant.KEY_COMMON_PKGNAME);
        }
        if (keyPropertySubPkg != null) {
            com.flydigi.base.common.n.a("flydigitestdata writeConfig 该游戏属性控制规则存在:" + this.f11219k);
            for (String str : keyPropertySubPkg.config.keySet()) {
                if (keyPropertySubPkg.config.get(str).state.equals("1")) {
                    for (CFGPropertyKey cFGPropertyKey : cFGEntityCopy.keyList) {
                        if ((cFGPropertyKey.type + "_" + cFGPropertyKey.sub_type).equals(str)) {
                            com.flydigi.base.common.n.a("flydigitestdata writeConfig 禁用属性默认设置为普通点击:key" + str + " 按键Name:" + cFGPropertyKey.key);
                            cFGPropertyKey.type = 1;
                            cFGPropertyKey.sub_type = 0;
                        }
                    }
                    if ("012".equals(str)) {
                        com.flydigi.base.common.n.a("flydigitestdata 宏禁用 写入前删除");
                        for (CFGPropertyMacro cFGPropertyMacro : cFGEntityCopy.marcoList) {
                            CFGPropertyKey cFGPropertyKey2 = new CFGPropertyKey();
                            cFGPropertyKey2.type = 1;
                            cFGPropertyKey2.sub_type = 0;
                            cFGPropertyKey2.key_id = cFGPropertyMacro.key_id;
                            cFGPropertyKey2.comboKeyFirst = cFGPropertyMacro.comboKeyFirst;
                            cFGPropertyKey2.comboKeySecond = cFGPropertyMacro.comboKeySecond;
                            cFGPropertyKey2.comboKeyMode = 2;
                            cFGPropertyKey2.f16347x = cFGPropertyMacro.macro_keys.get(0).getX();
                            cFGPropertyKey2.f16348y = cFGPropertyMacro.macro_keys.get(0).getY();
                            cFGEntityCopy.keyList.add(cFGPropertyKey2);
                        }
                        cFGEntityCopy.marcoList.clear();
                    }
                }
            }
        }
        this.f11220k0 = cFGEntityCopy;
        n3();
    }

    public final void C3() {
        e6.z.q0(this.f11219k).A3(new dj.o() { // from class: com.android.motionelf.z
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindow.c3((CFGVibrateList) obj);
            }
        }).F5(new dj.g() { // from class: com.android.motionelf.w0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11398a.d3((CFGVibrateBean) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.x0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11405a.e3((Throwable) obj);
            }
        });
    }

    public final void D3(boolean z10, List<CFGVibrateItem> list) {
        this.f11211c.y(z10, list);
    }

    @Override // n3.d.c
    public void F(byte[] bArr) {
        tt.c.f().q(bArr[6] > 0 ? new FlyMouseEvent(l3.b.b(bArr, this.f11221l.getFloatWindowStartPosition()[0]), l3.b.c(bArr, this.f11221l.getFloatWindowStartPosition()[1]), bArr[1], true) : new FlyMouseEvent(0, 0, 0, false));
    }

    public final void F1(final String str) {
        this.D = 10;
        GamepadInfo gamepadInfo = this.f11216h;
        if (gamepadInfo == null || !gamepadInfo.isConnected()) {
            return;
        }
        DBManager.getInstance().getInstalledGameObservable(str).Y1(new dj.g() { // from class: com.android.motionelf.w
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11397a.e2((InstalledGameBean) obj);
            }
        }).s0(o5.l.d()).F5(new dj.g() { // from class: com.android.motionelf.f
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11281a.f2(str, (InstalledGameBean) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.b
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11268a.g2((Throwable) obj);
            }
        });
    }

    public final void H1() {
        this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11283a.l2();
            }
        }, 250L);
    }

    public final void I1() {
        InstalledGameBean installedGameBean;
        x7.f fVar;
        WindowManager windowManager = this.f11222m;
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (this.f11230u) {
                if (rotation == 0) {
                    rotation = 1;
                } else if (rotation == 1) {
                    rotation = 2;
                } else if (rotation == 2) {
                    rotation = 3;
                } else if (rotation == 3) {
                    rotation = 0;
                }
            }
            int i10 = this.f11223n;
            if (rotation == i10) {
                return;
            }
            boolean zX3 = x3(i10);
            boolean zX32 = x3(rotation);
            if (!zX32) {
                if (zX3) {
                    this.f11215g.W(this.f11216h, "悬浮窗_切到竖屏");
                    if (this.f11217i != null && (fVar = this.f11214f) != null) {
                        fVar.F("EndGame");
                    }
                    if (this.f11216h.isFlashplayMode()) {
                        this.f11211c.m();
                    } else {
                        this.f11211c.j();
                        n3.d dVar = this.f11213e;
                        if (dVar != null) {
                            dVar.c();
                        }
                    }
                }
                this.f11225p.removeCallbacks(this.f11210b);
                x7.f fVar2 = this.f11214f;
                if (fVar2 != null) {
                    fVar2.s(false);
                    this.f11214f.u();
                }
            } else if (!zX3) {
                H1();
            } else if (this.f11214f != null && (installedGameBean = this.f11217i) != null && installedGameBean.isUseMappingMode()) {
                this.f11214f.s(true);
            }
            this.f11223n = rotation;
            x7.f fVar3 = this.f11214f;
            if (fVar3 != null) {
                fVar3.I(zX32);
            }
            y3(this.f11222m.getDefaultDisplay().getRotation());
        }
    }

    @TargetApi(22)
    public final void L1() {
        this.f11229t.b(xi.z.g3(2L, TimeUnit.SECONDS).l2(new dj.o() { // from class: com.android.motionelf.s
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11322a.m2((Long) obj);
            }
        }).s4().M4().h2(new dj.r() { // from class: com.android.motionelf.d0
            @Override // dj.r
            public final boolean a(Object obj) {
                return FloatingWindow.n2((SortedMap) obj);
            }
        }).J5(lj.b.a()).n7(lj.b.a()).b4(lj.b.a()).F5(new dj.g() { // from class: com.android.motionelf.d
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11274a.o2((SortedMap) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.j
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                FloatingWindow.p2((Throwable) obj);
            }
        }));
    }

    public String O1(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
            return (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) ? "" : runningTasks.get(0).topActivity.getPackageName();
        } catch (Exception e10) {
            com.flydigi.base.common.n.b("flydigitestdata getBaseRunningAppPkg() Error:", e10);
            return "";
        }
    }

    public final io.reactivex.observers.d<CFGEntity> P1() {
        return new d();
    }

    public final xi.z<CFGEntity> R1(String str) {
        return X1(str).l2(new dj.o() { // from class: com.android.motionelf.a0
            @Override // dj.o
            public final Object apply(Object obj) {
                return FloatingWindow.q2((List) obj);
            }
        }).x1(500L, TimeUnit.MILLISECONDS).l2(new dj.o() { // from class: com.android.motionelf.o
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11309a.u2((RecommendConfigBean.RecommendConfig) obj);
            }
        }).Y1(new dj.g() { // from class: com.android.motionelf.u0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11393a.v2((CFGEntity) obj);
            }
        }).Y1(new dj.g() { // from class: com.android.motionelf.t0
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11325a.w2((CFGEntity) obj);
            }
        }).J5(lj.b.d());
    }

    public final xi.z<CFGEntity> T1(String str) {
        return U1(str).A3(new dj.o() { // from class: com.android.motionelf.q
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11314a.z2((CFGEntityList) obj);
            }
        }).J5(lj.b.d());
    }

    public final xi.z<CFGEntityList> U1(String str) {
        return DBManager.getInstance().getInstalledGameObservable(str).l2(new dj.o() { // from class: com.android.motionelf.n
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11306a.C2((InstalledGameBean) obj);
            }
        }).J5(lj.b.d());
    }

    public final int V1(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f11233x.size(); i12++) {
            if (this.f11233x.get(i12).isForCurrentDevice(this.f11216h.getDeviceCode())) {
                if (i11 == i10) {
                    return i12;
                }
                i11++;
            }
        }
        return -1;
    }

    public final xi.z<List<RecommendConfigBean.RecommendConfig>> X1(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cachedRecommendConfig get ");
        sb2.append(str);
        return DBManager.getInstance().getInstalledGameObservable(str).l2(new dj.o() { // from class: com.android.motionelf.m
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11303a.H2((InstalledGameBean) obj);
            }
        }).A3(new dj.o() { // from class: com.android.motionelf.p
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11311a.I2((RecommendConfigBean) obj);
            }
        }).A3(new dj.o() { // from class: com.android.motionelf.t
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11324a.J2((List) obj);
            }
        });
    }

    @TargetApi(22)
    public final xi.z<SortedMap<Long, UsageStats>> Z1() {
        return xi.z.m3(this.f11228s).z2(new dj.o() { // from class: com.android.motionelf.k
            @Override // dj.o
            public final Object apply(Object obj) {
                return this.f11297a.L2((UsageStatsManager) obj);
            }
        }).b7(new dj.o() { // from class: com.android.motionelf.c0
            @Override // dj.o
            public final Object apply(Object obj) {
                return Long.valueOf(((UsageStats) obj).getLastTimeUsed());
            }
        }).s0(new dj.o() { // from class: com.android.motionelf.b0
            @Override // dj.o
            public final Object apply(Object obj) {
                return new TreeMap((Map) obj);
            }
        }).v1();
    }

    @Override // k3.b.a, n3.d.c
    public void a(GamepadInfo gamepadInfo) {
        boolean zIsDriverConnected = this.f11216h.isDriverConnected();
        String driverVersion = this.f11216h.getDriverVersion();
        this.f11216h = gamepadInfo;
        gamepadInfo.setDriverConnected(zIsDriverConnected);
        this.f11216h.setDriverVersion(driverVersion);
        A3(this.f11216h, true);
        this.f11225p.removeCallbacks(this.f11210b);
        if (!this.f11216h.isConnected()) {
            this.f11213e.w(this.f11216h);
            this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.j0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11295a.S2();
                }
            }, 500L);
            this.f11218j = null;
        } else if (this.f11216h.isDriverMode()) {
            p3();
            this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.g0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11286a.R2();
                }
            }, 1000L);
        } else {
            this.f11213e.e();
        }
        if (this.f11216h.isConnected()) {
            com.flydigi.base.common.n.a("flydigitestdata 13是横屏发送方向,同时检测包名 ; 02是竖屏不写方向!!! mDisplayRotatio:" + this.f11223n);
            if (x3(this.f11223n)) {
                l3();
                y3(this.f11222m.getDefaultDisplay().getRotation());
                F1(this.f11219k);
                return;
            }
            com.flydigi.base.common.n.a("flydigitestdata 连接成功，但方向竖屏，这是模式指令需要发送");
            if (this.f11216h.isFlashplayMode()) {
                k3.b bVar = this.f11211c;
                if (bVar != null) {
                    bVar.m();
                    return;
                }
                return;
            }
            k3.b bVar2 = this.f11211c;
            if (bVar2 != null) {
                bVar2.j();
            }
            n3.d dVar = this.f11213e;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    public final void a2(Message message) {
        int i10 = message.what;
        int iV1 = V1(message.arg1);
        if (iV1 == -1 && message.arg1 >= 0) {
            iV1 = this.f11233x.size();
        }
        Object obj = message.obj;
        CFGEntity cFGEntity = obj instanceof CFGEntity ? (CFGEntity) obj : null;
        if (cFGEntity != null) {
            cFGEntity.setGamepad(this.f11216h.getDeviceCode());
        }
        if (i10 == 16) {
            o3(cFGEntity);
        }
        if (i10 == 29) {
            Object obj2 = message.obj;
            if (obj2 instanceof CFGVibrateBean) {
                v3((CFGVibrateBean) obj2);
                return;
            }
            return;
        }
        switch (i10) {
            case 8:
                if ((cFGEntity == null || cFGEntity.isInvalid()) && iV1 >= 0) {
                    cFGEntity = this.f11233x.get(iV1);
                }
                if (cFGEntity != null) {
                    r3();
                    cFGEntity.setInUse(true);
                    this.f11218j = cFGEntity;
                    this.f11214f.H(cFGEntity);
                    if (!com.blankj.utilcode.util.n0.z(this.f11233x) || this.f11233x.size() <= iV1) {
                        this.f11233x.add(cFGEntity);
                    } else if (com.blankj.utilcode.util.n0.b(this.f11233x.get(iV1).title, cFGEntity.title)) {
                        this.f11233x.set(iV1, cFGEntity);
                    } else {
                        this.f11233x.add(iV1, cFGEntity);
                    }
                    b3(cFGEntity);
                }
                s3();
                break;
            case 9:
                z3(iV1, cFGEntity);
                s3();
                break;
            case 10:
                if (cFGEntity != null) {
                    r3();
                    cFGEntity.setInUse(true);
                    cFGEntity.setRecommend(false);
                    cFGEntity.setDefault(false);
                    this.f11218j = cFGEntity;
                    this.f11214f.H(cFGEntity);
                    b3(cFGEntity);
                    if (!com.blankj.utilcode.util.n0.z(this.f11233x) || this.f11233x.size() <= iV1) {
                        this.f11233x.add(cFGEntity);
                    } else if (com.blankj.utilcode.util.n0.b(this.f11233x.get(iV1).title, cFGEntity.title)) {
                        this.f11233x.set(iV1, cFGEntity);
                    } else {
                        this.f11233x.add(iV1, cFGEntity);
                    }
                    s3();
                }
                break;
            case 11:
                if (cFGEntity != null) {
                    cFGEntity.setInUse(true);
                    cFGEntity.setRecommend(false);
                    cFGEntity.setDefault(false);
                    this.f11233x.clear();
                    this.f11218j = cFGEntity;
                    this.f11233x.add(cFGEntity);
                    this.f11232w.clear();
                    s3();
                    DBManager.getInstance().addInstalledGame(com.blankj.utilcode.util.d.i(this.f11219k), null);
                    k3(this.f11219k, this.f11218j);
                }
                break;
            case 12:
                if (cFGEntity != null) {
                    r3();
                    cFGEntity.setInUse(true);
                    cFGEntity.setRecommend(false);
                    cFGEntity.setDefault(false);
                    this.f11218j = cFGEntity;
                    this.f11214f.H(cFGEntity);
                    b3(cFGEntity);
                    this.f11233x.add(cFGEntity);
                    s3();
                }
                break;
            case 13:
                this.f11233x.set(iV1, cFGEntity);
                s3();
                this.f11214f.f0(iV1, this.f11233x);
                break;
            case 14:
                this.f11233x.remove(iV1);
                s3();
                this.f11214f.f0(-1, this.f11233x);
                break;
        }
    }

    public final void b2(boolean z10) {
        if (this.f11213e != null) {
            if (z10) {
                com.flydigi.base.common.n.a("flydigitestdata killService 对于已经执行杀掉驱动进程的操作，接下来直接关掉socket即可");
                this.f11213e.e();
            } else {
                com.flydigi.base.common.n.a("flydigitestdata killService 杀掉Service之前，通知驱动断开手柄");
                this.f11216h.setConnectState(0);
                this.f11213e.w(this.f11216h);
                this.f11224o.postDelayed(new Runnable() { // from class: com.android.motionelf.m0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f11304a.O2();
                    }
                }, 500L);
            }
        }
        this.f11224o.postDelayed(new Runnable() { // from class: com.android.motionelf.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11292a.P2();
            }
        }, 800L);
    }

    @Override // n3.d.c
    public void d() {
        if (!v5.c.f() && o5.b.i(this)) {
            this.f11212d.h(v5.c.f52717i);
        }
        this.f11213e.I();
        n();
    }

    public final void f3() {
        try {
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).v0();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.android.motionelf.adb.AdbManager.a
    public void g(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FloatingWindow onPairPortGot:");
        sb2.append(i10);
        if (i10 <= 1 || i10 >= 65535) {
            A3(this.f11216h, false);
        } else {
            com.android.motionelf.tools.e.h(this, getString(R.string.floatview_wireless_adb_activate_desc), true);
        }
    }

    public final void g3() {
        try {
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).x0();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void h3(boolean z10) {
        try {
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).k0(z10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.android.motionelf.adb.AdbManager.a
    public void i(boolean z10, Throwable th2) {
        if (v5.c.f()) {
            return;
        }
        if (z10) {
            this.f11212d.m();
            unregisterReceiver(this.C);
            com.android.motionelf.tools.e.h(this, getString(R.string.floatview_wireless_adb_pair_success, new Object[]{getString(R.string.app_name)}), false);
            this.f11225p.postDelayed(new Runnable() { // from class: com.android.motionelf.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11301a.T2();
                }
            }, 1000L);
            return;
        }
        String string = getString(R.string.floatview_wireless_adb_pair_failed);
        if (th2 instanceof AdbInvalidPairingCodeException) {
            string = getString(R.string.floatview_wireless_adb_pair_failed_wrong_code);
        }
        com.android.motionelf.tools.e.h(this, getString(R.string.floatview_input_wadb_pair_code_input_again, new Object[]{string}), true);
    }

    public final void i3() {
        try {
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).J0();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public boolean j3() {
        String strO1 = O1(getApplicationContext());
        return (com.blankj.utilcode.util.d1.g(strO1) || TextUtils.equals(strO1, getPackageName())) ? false : true;
    }

    public final void k3(String str, CFGEntity cFGEntity) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("packageName:");
        sb2.append(str);
        sb2.append("\n当前配置:");
        sb2.append(cFGEntity);
        sb2.append("\n本地配置");
        sb2.append(this.f11233x.size());
        sb2.append("个\n推荐配置");
        sb2.append(this.f11232w.size());
        sb2.append("个");
        this.f11218j = cFGEntity;
        b3(cFGEntity);
        if (com.blankj.utilcode.util.n0.o(this.f11233x)) {
            this.f11233x.add(this.f11218j);
        }
        InstalledGameBean installedGameBean = this.f11217i;
        if (installedGameBean != null) {
            this.f11214f.E(installedGameBean.getLocalPackageName(), this.f11233x, cFGEntity, this.f11232w);
        } else {
            this.f11214f.E(str, this.f11233x, cFGEntity, this.f11232w);
        }
    }

    @Override // k3.b.a, n3.d.c
    public void l() {
        try {
            int iBeginBroadcast = this.f11235z.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.d) this.f11235z.getBroadcastItem(i10)).l();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11235z.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void l3() {
        this.f11225p.removeCallbacks(this.f11210b);
        this.f11225p.postDelayed(this.f11210b, 180000L);
    }

    public final void m3(String str) {
        final xi.z<CFGEntity> zVarT1 = T1(str);
        xi.z<CFGEntity> zVarR1 = R1(str);
        if (!com.blankj.utilcode.util.n0.b(DataConstant.TEST_KEYMAPPING, str)) {
            zVarT1 = zVarR1.J5(lj.b.d()).m4(new dj.o() { // from class: com.android.motionelf.y
                @Override // dj.o
                public final Object apply(Object obj) {
                    return FloatingWindow.X2(zVarT1, (xi.z) obj);
                }
            });
        }
        zVarT1.b4(aj.a.c()).c(P1());
        if (this.f11216h.isSupportMotor()) {
            C3();
        }
    }

    @Override // n3.d.c
    public void n() {
        try {
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).n();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void n3() {
        int iA = l3.a.a(this.f11223n, this);
        if (this.f11216h.isFlashplayMode()) {
            List<byte[]> listC = com.android.motionelf.tools.a.c(this.f11220k0, this.f11216h, this.f11221l, iA);
            k3.b bVar = this.f11211c;
            if (bVar != null) {
                bVar.w(listC);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(com.android.motionelf.tools.a.b(this.f11220k0, this.f11221l, this.f11216h, iA));
            arrayList.add(l3.b.j());
            this.f11213e.K(arrayList);
            this.f11213e.B(this.f11223n);
            this.f11213e.C();
            for (int i10 = 0; i10 < this.f11220k0.keyList.size(); i10++) {
                CFGPropertyKey cFGPropertyKey = this.f11220k0.keyList.get(i10);
                int iA2 = cFGPropertyKey.key_id;
                int i11 = cFGPropertyKey.type;
                int iA3 = -1;
                if (iA2 == 256) {
                    iA2 = o9.b.a(cFGPropertyKey.comboKeyFirst);
                    iA3 = o9.b.a(cFGPropertyKey.comboKeySecond);
                }
                if (i11 == 20) {
                    this.f11213e.l(iA2, iA3);
                } else if (i11 == 21) {
                    this.f11213e.k(iA2, iA3, cFGPropertyKey.radius);
                } else if (i11 == 34 && cFGPropertyKey.angle < 1) {
                    this.f11213e.j(iA2, iA3, cFGPropertyKey.senVisualRJsX);
                }
            }
        }
        x1(this.f11220k0);
    }

    @Override // n3.d.c
    public void o(final boolean z10, final int i10) {
        if (z10 && !v5.c.f() && ((o5.h.l() || o5.h.d()) && !o5.b.a(this))) {
            this.f11213e.o();
            com.flydigi.base.common.n.a("flydigitestdata 有权限未开启，杀死驱动");
            g3();
            return;
        }
        GamepadInfo gamepadInfo = this.f11216h;
        if (gamepadInfo != null) {
            if (gamepadInfo.isFlashplayMode()) {
                return;
            }
            this.f11216h.setDriverConnected(z10);
            this.f11216h.setDriverVersion(u9.b.j(i10));
            if (!v5.c.f()) {
                this.f11212d.l();
            }
            if (z10) {
                o5.m.l(DataConstant.SP_FLOAT, 2).F(DataConstant.SP_MAIN_TCPIP_HAVE_ABLE_TO_ACTIVE, true);
            } else {
                this.f11218j = null;
            }
            q(this.f11216h);
        }
        this.f11225p.post(new Runnable() { // from class: com.android.motionelf.q0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11315a.U2(z10, i10);
            }
        });
    }

    public final void o3(CFGEntity cFGEntity) {
        int i10 = 0;
        while (true) {
            if (i10 < this.f11233x.size()) {
                if (this.f11233x.get(i10).isForCurrentDevice(this.f11216h.getDeviceCode()) && com.blankj.utilcode.util.n0.b(this.f11233x.get(i10).title, cFGEntity.title)) {
                    this.f11233x.set(i10, cFGEntity);
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        s3();
        this.f11214f.f0(-1, this.f11233x);
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public IBinder onBind(@yt.k Intent intent) {
        super.onBind(intent);
        if (h9.b.class.getName().equals(intent.getAction())) {
            return this.A;
        }
        return null;
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onCreate() {
        super.onCreate();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onCreate");
        u1(false);
        this.f11215g = new UserBehaviorManager(this, o5.m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, "official"));
        this.f11227r = new f();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f11227r, intentFilter);
        e eVar = new e();
        this.f11226q = eVar;
        eVar.b(this);
        HandlerThread handlerThread = new HandlerThread("FloatingWindowSubThread");
        handlerThread.start();
        this.f11225p = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.android.motionelf.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f11254a.Q2(message);
            }
        });
        this.f11216h = v5.a.j().d();
        this.f11214f = new x7.f(this, this.f11225p);
        if (!v5.c.f()) {
            this.f11213e = new n3.i(this);
            this.f11212d = new AdbManager(this);
        }
        if (m9.s.t()) {
            this.f11211c = new k3.b(this);
        }
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.f11222m = windowManager;
        int rotation = windowManager.getDefaultDisplay().getRotation();
        this.f11230u = rotation == 3 || rotation == 1;
        v1();
        t1();
        w1();
        if (Build.VERSION.SDK_INT >= 28) {
            au.i.k("L");
        }
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onDestroy");
        this.f11234y.kill();
        this.f11225p.removeCallbacksAndMessages(null);
        x7.f fVar = this.f11214f;
        if (fVar != null) {
            fVar.q();
        }
        this.f11224o.removeCallbacksAndMessages(null);
        f fVar2 = this.f11227r;
        if (fVar2 != null) {
            unregisterReceiver(fVar2);
        }
        e eVar = this.f11226q;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    @Override // androidx.lifecycle.d0, android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(android.content.Intent r10, int r11, int r12) {
        /*
            Method dump skipped, instruction units count: 1954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.FloatingWindow.onStartCommand(android.content.Intent, int, int):int");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        GamepadInfo gamepadInfo;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" onTaskRemoved");
        if (this.f11213e != null && (gamepadInfo = this.f11216h) != null) {
            gamepadInfo.setConnectState(0);
            this.f11213e.w(this.f11216h);
        }
        super.onTaskRemoved(intent);
    }

    public final void p3() {
        if (this.f11213e == null || !this.f11216h.isConnected() || !this.f11216h.isDriverMode() || this.f11216h.isDriverConnected()) {
            return;
        }
        this.f11213e.I();
    }

    @Override // k3.b.a
    public void q(GamepadInfo gamepadInfo) {
        GamepadInfo gamepadInfo2;
        x7.f fVar;
        v5.a.j().o(gamepadInfo);
        GamepadInfo gamepadInfo3 = this.f11216h;
        boolean zIsDriverConnected = false;
        boolean z10 = gamepadInfo3 == null || !com.blankj.utilcode.util.n0.b(Integer.valueOf(gamepadInfo3.getDeviceMode()), Integer.valueOf(gamepadInfo.getDeviceMode()));
        String driverVersion = null;
        GamepadInfo gamepadInfo4 = this.f11216h;
        if (gamepadInfo4 != null) {
            zIsDriverConnected = gamepadInfo4.isDriverConnected();
            driverVersion = this.f11216h.getDriverVersion();
        }
        this.f11216h = gamepadInfo;
        gamepadInfo.setDriverConnected(zIsDriverConnected);
        this.f11216h.setDriverVersion(driverVersion);
        y1(this.f11216h);
        u3(this.f11216h);
        x7.f fVar2 = this.f11214f;
        if (fVar2 != null) {
            fVar2.K(this.f11216h);
        }
        n3.d dVar = this.f11213e;
        if (dVar != null) {
            dVar.G(this.f11216h);
        }
        if (z10) {
            q3();
        }
        if (this.f11217i == null || (gamepadInfo2 = this.f11216h) == null || !gamepadInfo2.isDisconnected() || (fVar = this.f11214f) == null) {
            return;
        }
        fVar.F("EndGame");
    }

    public final void q3() {
        this.f11218j = null;
        if (x3(this.f11223n)) {
            F1(this.f11219k);
        }
    }

    @Override // k3.b.a
    public void r(byte[] bArr, byte[] bArr2) {
        this.f11213e.M(bArr2);
    }

    public final void r3() {
        for (int i10 = 0; i10 < this.f11233x.size(); i10++) {
            if (this.f11233x.get(i10).isForCurrentDevice(this.f11216h.getDeviceCode())) {
                this.f11233x.get(i10).setInUse(false);
            }
        }
    }

    public final void s3() {
        e6.z.v0(this.f11219k, this.f11216h.getDeviceMode(), this.f11233x);
    }

    public final void t1() {
        n8.a.h(this, new c());
    }

    public final void t3() {
        if (com.blankj.utilcode.util.d1.l(v5.a.j().e()).length() > 0) {
            GamepadInfo gamepadInfo = this.f11216h;
            String str = (gamepadInfo == null || !gamepadInfo.isConnected()) ? "disconnect" : this.f11216h.isSystemConnect() ? this.f11216h.isFlashplayMode() ? "sys_flashplay" : "sys_tradition" : "hall_tradition";
            String strH = v5.a.j().m() ? v5.a.j().h() : "0";
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.flydigi.community.ui.search.b.f14046c, v5.a.j().e());
                jSONObject.put("deviceName", v5.a.j().g());
                jSONObject.put("connectType", str);
                jSONObject.put("driverVersion", strH);
                jSONObject.put("firmwareVersion", v5.a.j().c());
                jSONObject.put("appPkgName", getPackageName());
                jSONObject.put("appVersion", com.blankj.utilcode.util.d.C());
                jSONObject.put("sysVersion", Build.VERSION.RELEASE);
                jSONObject.put("manufacture", com.blankj.utilcode.util.x.j());
                jSONObject.put("model", com.blankj.utilcode.util.x.k());
                o5.m.k(DataConstant.SP_MAIN).C(DataConstant.SP_NAME_APP_START_DATA_STATISTICS, jSONObject.toString(), true);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void u1(boolean z10) {
        com.android.motionelf.tools.e.i(this, z10);
    }

    public final void u3(GamepadInfo gamepadInfo) {
        o5.m.l(DataConstant.SP_FLOAT, 2).B(DataConstant.SP_LATEST_DEVICE, m5.f0.i().h().toJson(gamepadInfo));
        t3();
    }

    public final void v1() {
        I1();
        this.f11224o.postDelayed(new Runnable() { // from class: com.android.motionelf.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11310a.v1();
            }
        }, 500L);
    }

    public final void v3(final CFGVibrateBean cFGVibrateBean) {
        e6.z.y0(this.f11219k, cFGVibrateBean).s0(o5.l.d()).F5(new dj.g() { // from class: com.android.motionelf.e
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f11277a.Y2(cFGVibrateBean, (CFGVibrateList) obj);
            }
        }, new dj.g() { // from class: com.android.motionelf.h
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                FloatingWindow.Z2((Throwable) obj);
            }
        });
    }

    @TargetApi(22)
    public final void w1() {
        if (Build.VERSION.SDK_INT < 22) {
            return;
        }
        if (((AppOpsManager) getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), getPackageName()) == 0) {
            try {
                this.f11228s = (UsageStatsManager) getSystemService("usagestats");
                L1();
            } catch (Exception unused) {
            }
        }
    }

    public final void w3(@yt.l String str) {
        androidx.work.m mVarE = androidx.work.m.e(SyncSupportedGameWorker.class);
        androidx.work.m mVarE2 = androidx.work.m.e(DeleteGameHasNotConfigWorker.class);
        androidx.work.m mVarE3 = androidx.work.m.e(FindSupportedGameFromInstalledAppsWorker.class);
        androidx.work.m mVarE4 = androidx.work.m.e(FindGameHasConfigWorker.class);
        if (com.blankj.utilcode.util.n0.x(str)) {
            androidx.work.v.p(this).k(com.blankj.utilcode.util.s.w(mVarE2, mVarE3));
        } else {
            androidx.work.v.p(this).c(mVarE).f(mVarE2).f(mVarE3).f(mVarE4).c();
        }
    }

    @Override // n3.d.c
    public void x(byte[] bArr) {
        tt.c.f().q(new BluetoothDeviceOperateEvent(bArr));
        try {
            int iBeginBroadcast = this.f11235z.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.d) this.f11235z.getBroadcastItem(i10)).A(bArr);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11235z.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void x1(CFGEntity cFGEntity) {
        if (cFGEntity == null || this.f11216h == null || cFGEntity.isTest() || com.blankj.utilcode.util.n0.b(this.f11219k, DataConstant.TEST_KEYMAPPING)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("game", this.f11219k);
        map.put("deviceName", this.f11216h.getDeviceName());
        if (this.f11216h.getMappingMode() == 0) {
            map.put("mapping_mode", "传统模式");
        } else {
            map.put("mapping_mode", "智连模式");
        }
        boolean zF = o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_FLOAT_HIDE_FLOAT_VIEW, false);
        boolean z10 = zF;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 = 0; i10 < cFGEntity.keyList.size(); i10++) {
            CFGPropertyKey cFGPropertyKey = cFGEntity.keyList.get(i10);
            int i11 = cFGPropertyKey.key_id;
            if (!this.f11216h.isGamepadKeyboard() && (i11 == 6 || cFGPropertyKey.comboKeyFirst == 6 || cFGPropertyKey.comboKeySecond == 6)) {
                z11 = true;
            }
            if (!this.f11216h.isGamepadKeyboard() && (i11 == 14 || cFGPropertyKey.comboKeyFirst == 14 || cFGPropertyKey.comboKeySecond == 14)) {
                zF = true;
            }
            if (this.f11216h.isGamepadKeyboard() && (i11 == 58 || cFGPropertyKey.comboKeyFirst == 58 || cFGPropertyKey.comboKeySecond == 58)) {
                z12 = true;
            }
            if (this.f11216h.isGamepadKeyboard() && (i11 == 59 || cFGPropertyKey.comboKeyFirst == 59 || cFGPropertyKey.comboKeySecond == 59)) {
                z10 = true;
            }
            map.put("key", com.flydigi.sdk.gamepad.extension.a.j(cFGPropertyKey.key_id, cFGPropertyKey.comboKeyFirst, cFGPropertyKey.comboKeySecond, this.f11216h.getDeviceMode()));
            String strC = o9.i.c(cFGPropertyKey.type, cFGPropertyKey.sub_type);
            if (com.blankj.utilcode.util.n0.x(strC)) {
                map.put("property", strC);
            } else {
                map.put("property", cFGPropertyKey.type + "_" + cFGPropertyKey.sub_type);
            }
            u9.g.a().e(this, "game_property_used", map);
        }
        x7.f fVar = this.f11214f;
        if (fVar != null) {
            fVar.N(z11);
            this.f11214f.O(zF);
            this.f11214f.L(z12);
            this.f11214f.M(z10);
        }
        for (int i12 = 0; i12 < cFGEntity.jsList.size(); i12++) {
            CFGPropertyJS cFGPropertyJS = cFGEntity.jsList.get(i12);
            map.put("key", com.flydigi.sdk.gamepad.extension.a.i(cFGPropertyJS.key_id, this.f11216h.getDeviceMode()));
            String strB = o9.h.b(cFGPropertyJS.type);
            if (com.blankj.utilcode.util.n0.x(strB)) {
                map.put("property", strB);
            } else {
                map.put("property", String.valueOf(cFGPropertyJS.type));
            }
            u9.g.a().e(this, "game_property_used", map);
        }
        for (int i13 = 0; i13 < cFGEntity.marcoList.size(); i13++) {
            CFGPropertyMacro cFGPropertyMacro = cFGEntity.marcoList.get(i13);
            map.put("key", com.flydigi.sdk.gamepad.extension.a.j(cFGPropertyMacro.key_id, cFGPropertyMacro.comboKeyFirst, cFGPropertyMacro.comboKeySecond, this.f11216h.getDeviceMode()));
            int i14 = cFGPropertyMacro.type;
            String str = i14 != 0 ? i14 != 1 ? i14 != 2 ? "" : "按住循环" : "松开触发" : "按下触发";
            if (com.blankj.utilcode.util.n0.x(str)) {
                map.put("property", str);
            } else {
                map.put("property", String.valueOf(cFGPropertyMacro.type));
            }
            u9.g.a().e(this, "game_property_used", map);
        }
    }

    public boolean x3(int i10) {
        return i10 == 1 || i10 == 3;
    }

    @Override // com.android.motionelf.adb.AdbManager.a
    public void y() {
        f3();
    }

    public final void y1(GamepadInfo gamepadInfo) {
        try {
            DeviceInfo deviceInfoA = DeviceInfo.a(gamepadInfo);
            int iBeginBroadcast = this.f11234y.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((h9.c) this.f11234y.getBroadcastItem(i10)).H0(deviceInfoA);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            this.f11234y.finishBroadcast();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void y3(int i10) {
        GamepadInfo gamepadInfo = this.f11216h;
        if (gamepadInfo == null || !gamepadInfo.isConnected()) {
            return;
        }
        if (this.f11216h.isFlashplayMode()) {
            byte[] bArrY = m9.e.y(l3.a.a(i10, this));
            k3.b bVar = this.f11211c;
            if (bVar != null) {
                bVar.i(bArrY);
                return;
            }
            return;
        }
        this.f11213e.M(l3.b.l(i10));
        if (v5.c.f()) {
            byte[] bArrL = l3.b.l(i10);
            bArrL[0] = 12;
            boolean z10 = this.f11230u;
            if (!z10) {
                if (bArrL[1] == 0) {
                    bArrL[1] = 3;
                } else if (bArrL[1] == 1) {
                    bArrL[1] = 0;
                }
            }
            bArrL[2] = (byte) (!z10 ? 1 : 0);
            this.f11213e.M(bArrL);
            this.f11213e.z(u9.b.i());
        }
    }

    public final void z3(int i10, CFGEntity cFGEntity) {
        int size = -1;
        int i11 = 0;
        if (this.f11233x.size() > i10) {
            CFGEntity cFGEntityRemove = this.f11233x.remove(i10);
            cFGEntityRemove.setInTop(!cFGEntity.isInTop());
            u9.h.v(this, cFGEntity.getTitle(), this.f11219k, cFGEntity.isInTop());
            if (cFGEntity.isInTop()) {
                this.f11233x.add(0, cFGEntityRemove);
                size = 0;
            } else {
                while (true) {
                    if (i11 >= this.f11233x.size()) {
                        i11 = -1;
                        break;
                    } else if (this.f11233x.get(i11).isForCurrentDevice(this.f11216h.getDeviceCode()) && !this.f11233x.get(i11).isInTop()) {
                        break;
                    } else {
                        i11++;
                    }
                }
                size = i11 == -1 ? this.f11233x.size() : i11;
                this.f11233x.add(size, cFGEntityRemove);
            }
        }
        this.f11214f.f0(size, this.f11233x);
    }
}
