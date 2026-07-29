package com.flydigi.qiji;

import a5.f;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.webkit.WebView;
import androidx.work.a;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.blankj.utilcode.util.q0;
import com.flydigi.base.common.h;
import com.flydigi.base.common.n;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FZUserAccount;
import com.flydigi.data.event.ExitAppEvent;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import i9.a;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.Executors;
import m5.f0;
import m9.s;
import o5.m;
import org.greenrobot.eventbus.ThreadMode;
import p8.d;
import t9.j;
import tt.l;
import u9.g;

/* JADX INFO: loaded from: classes3.dex */
public class FZApplication extends h implements j1.d, a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BroadcastReceiver f16021a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastReceiver f16022b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16023c;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (n0.b(DataConstant.BROADCAST_RECEIVER_ACTION_REQUEST_POLICY, d1.l(intent.getAction()))) {
                FZApplication.this.v();
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (n0.b(DataConstant.BROADCAST_RECEIVER_ACTION_LOGIN_STATUS, d1.l(intent.getAction()))) {
                FZAccountLoginChangeEvent fZAccountLoginChangeEvent = new FZAccountLoginChangeEvent((FZUserAccount) intent.getParcelableExtra(DataConstant.EXTRA_KEY_LOGIN_ACCOUNT), intent.getBooleanExtra(DataConstant.EXTRA_KEY_LOGIN_STATUS, false));
                tt.c.f().q(fZAccountLoginChangeEvent);
                f.i().x(fZAccountLoginChangeEvent.getAccount());
            }
        }
    }

    public class c extends ThreadUtils.d<Object> {
        public c() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public Object e() {
            FZApplication.this.s();
            n.f();
            f.i();
            f0.i().m("https://api.flydigi.com/");
            DBManager.getInstance().init();
            IntentFilter intentFilter = new IntentFilter(DataConstant.BROADCAST_RECEIVER_ACTION_LOGIN_STATUS);
            FZApplication fZApplication = FZApplication.this;
            fZApplication.registerReceiver(fZApplication.f16022b, intentFilter);
            FZApplication fZApplication2 = FZApplication.this;
            fZApplication2.registerReceiver(fZApplication2.f16021a, new IntentFilter(DataConstant.BROADCAST_RECEIVER_ACTION_REQUEST_POLICY));
            if (q0.g()) {
                d.f46511a.init(FZApplication.this);
                com.blankj.utilcode.util.d.X(FZApplication.this);
                return null;
            }
            b0.l(o5.b.f42734c);
            if (Build.VERSION.SDK_INT < 30) {
                return null;
            }
            x9.c.b(FZApplication.this, "adb");
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public void l(Object obj) {
        }
    }

    @Override // com.blankj.utilcode.util.j1.d
    public void a(Activity activity) {
        if (this.f16023c && m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            b0.o(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), ".flashplay"));
            ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).e(getApplicationContext(), DataConstant.REMOTE_ACTION_START_GAME, "package_name", getApplicationContext().getPackageName());
        }
    }

    @Override // com.flydigi.base.common.h, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        androidx.multidex.b.l(context);
    }

    @Override // com.blankj.utilcode.util.j1.d
    public void b(Activity activity) {
        this.f16023c = true;
    }

    @Override // androidx.work.a.c
    @g.n0
    public androidx.work.a c() {
        return new a.b().c(Executors.newSingleThreadExecutor()).h(5).a();
    }

    @Override // com.flydigi.base.common.h, android.app.Application
    public void onCreate() {
        super.onCreate();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Build.MANUFACTURER:");
        sb2.append(Build.MANUFACTURER);
        a9.c.a(this);
        tt.c.b().a(new z4.a()).a(new z4.d()).a(new z4.b()).a(new z4.c()).h();
        l();
        h3.a.k(this);
        j1.b(this);
        u();
        v();
        s.q(this, null, false);
        if (q0.g()) {
            q9.f.l(this, null, false);
            j.m(this, null, false);
        }
        ThreadUtils.M(new c());
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEvent(ExitAppEvent exitAppEvent) {
        if (q0.g()) {
            t(exitAppEvent.mKillDriverPID);
        }
    }

    @Override // com.flydigi.base.common.h, android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        l5.a.b().k(this);
    }

    @Override // com.flydigi.base.common.h, android.app.Application
    public void onTerminate() {
        super.onTerminate();
        l5.a.b().a(this);
        h3.a.j().h();
        com.blankj.utilcode.util.d.b0(this);
        unregisterReceiver(this.f16022b);
    }

    @Override // com.flydigi.base.common.h, android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        l5.a.b().l(this, i10);
    }

    public final void s() {
        if (Build.VERSION.SDK_INT >= 28) {
            String processName = Application.getProcessName();
            if (Objects.equals(getPackageName(), processName)) {
                return;
            }
            WebView.setDataDirectorySuffix(processName);
        }
    }

    public final void t(boolean z10) {
        n.a("flydigitestdata FZApplication exitApp:" + z10);
        com.flydigi.userBehavior.a.a().b(this, "App 关闭");
        ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).k(this, z10);
        g.a().g(this);
        com.blankj.utilcode.util.d.a();
        Process.killProcess(Process.myPid());
    }

    public final void u() {
        String strD = zf.g.d(this, "official");
        if (!m.l(DataConstant.SP_FLOAT, 2).c(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME)) {
            m.l(DataConstant.SP_FLOAT, 2).B(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, strD);
        }
        UMConfigure.preInit(this, a9.a.f318l, strD);
        UMConfigure.setLogEnabled(false);
        UMConfigure.setEncryptEnabled(true);
        UMConfigure.setProcessEvent(true);
        PlatformConfig.setWeixin("wx375c3eac842e742d", "5e53a7e9877dfed305e86da4dfb4ac31");
        PlatformConfig.setWXFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setQQZone("101550532", "bf959c6af7035b57f9da282767df4c84");
        PlatformConfig.setQQFileProvider(getPackageName() + ".fileprovider");
    }

    public final void v() {
        if (m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_IS_USER_POLICY_ALLOWED)) {
            String strD = zf.g.d(this, "official");
            UMConfigure.submitPolicyGrantResult(this, true);
            UMConfigure.init(this, a9.a.f318l, strD, 1, "");
        }
    }
}
