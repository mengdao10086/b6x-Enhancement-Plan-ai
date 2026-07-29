package com.efs.sdk.base.core.config.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.just.agentweb.DefaultWebClient;
import g.n0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f12857a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IConfigRefreshAction f12858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f12860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<IConfigCallback, String[]> f12861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f12862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f12863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12864h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12866a = new c(0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    private void e() {
        if (!f.a.f12832a.a()) {
            Log.i("efs.config", "has no permission to refresh config from remote");
            return;
        }
        if (!this.f12859c) {
            Log.i("efs.config", "disable refresh config from remote");
            return;
        }
        String strRefresh = g().refresh();
        Log.i("efs.config", "from server. efs config is ".concat(String.valueOf(strRefresh)));
        if (TextUtils.isEmpty(strRefresh)) {
            return;
        }
        a(strRefresh);
    }

    private void f() {
        boolean zA;
        try {
            zA = this.f12863g.a(this.f12860d);
        } catch (Throwable unused) {
            zA = false;
        }
        if (zA) {
            return;
        }
        this.f12862f.sendEmptyMessageDelayed(3, 3000L);
    }

    @n0
    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.f12858b;
        return iConfigRefreshAction == null ? com.efs.sdk.base.core.config.a.a.a() : iConfigRefreshAction;
    }

    private boolean h() {
        e.b();
        long j10 = 0;
        try {
            e eVar = this.f12863g;
            eVar.c();
            if (eVar.f12868a != null) {
                j10 = eVar.f12868a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return System.currentTimeMillis() - j10 >= (this.f12860d.f12853d * 60) * 1000;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message messageObtain = Message.obtain(null, 1, new JSONObject(this.f12860d.f12855f).toString());
                Message messageObtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
                messageObtain.recycle();
                messageObtain2.recycle();
            }
            Iterator<IEfsReporterObserver> it2 = ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers().iterator();
            while (it2.hasNext()) {
                it2.next().onConfigChange();
            }
        } catch (Throwable th2) {
            Log.e("efs.config", th2);
        }
    }

    public final Map<String, String> c() {
        return new HashMap(this.f12860d.f12855f);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : c.this.f12861e.keySet()) {
                        String[] strArr = (String[]) c.this.f12861e.get(iConfigCallback);
                        HashMap map = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            for (String str : strArr) {
                                if (c.this.f12860d.f12855f.containsKey(str)) {
                                    map.put(str, c.this.c().get(str));
                                    Log.i("efs.config", "--->>> configCallback key is " + str + " ## value is " + c.this.c().get(str));
                                }
                            }
                        }
                        iConfigCallback.onChange(map);
                    }
                    c.this.f12861e.clear();
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(@n0 Message message) {
        b bVar;
        int i10 = message.what;
        if (i10 == 0) {
            boolean zA = e.a();
            Log.i("efs.config", "delete old config is ".concat(String.valueOf(zA)));
            if (zA) {
                this.f12862f.sendEmptyMessage(1);
            } else {
                e eVar = this.f12863g;
                eVar.c();
                if (eVar.f12868a == null) {
                    bVar = null;
                } else {
                    b bVarA = b.a();
                    bVarA.f12850a = eVar.f12868a.getInt("cver", -1);
                    Set<String> setKeySet = eVar.f12868a.getAll().keySet();
                    HashMap map = new HashMap();
                    for (String str : setKeySet) {
                        String string = eVar.f12868a.getString(str, "");
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str, string);
                        }
                    }
                    bVarA.a(map);
                    bVar = bVarA;
                }
                if (bVar == null) {
                    Log.i("efs.config", "first load local config false.");
                } else if (a(bVar)) {
                    Log.i("efs.config", "current config to same.");
                } else {
                    this.f12860d = bVar;
                    String str2 = "load config from storage";
                    if (-1 != bVar.f12850a) {
                        i();
                        d();
                        str2 = "load config from storage and notify observer";
                    }
                    Log.i("efs.config", str2);
                }
            }
        } else if (i10 == 1) {
            int i11 = message.arg1;
            if (i11 <= this.f12860d.f12850a) {
                Log.i("efs.config", "current config version is " + i11 + ", no need to refresh");
                Log.i("efs.config", "current config version(" + this.f12860d.f12850a + ") is " + i11 + ", no need to refresh");
            } else {
                e();
            }
        } else if (i10 == 2) {
            try {
                if (f.a.f12832a.a()) {
                    if (h()) {
                        e();
                    } else {
                        Log.i("efs.config", "No update is required, less than 8h since the last update");
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else if (i10 == 3) {
            f();
        }
        return true;
    }

    private c() {
        this.f12859c = true;
        this.f12861e = new HashMap();
        this.f12862f = new Handler(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper(), this);
        this.f12863g = new e();
        this.f12860d = b.a();
        this.f12864h = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
    }

    public static c a() {
        return a.f12866a;
    }

    public final void b() {
        this.f12862f.sendEmptyMessage(0);
        this.f12862f.sendEmptyMessageDelayed(2, this.f12864h);
    }

    public final void a(int i10) {
        if (i10 <= this.f12860d.f12850a) {
            Log.i("efs.config", "current config version is " + i10 + ", no need to refresh");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i10;
        messageObtain.what = 1;
        this.f12862f.sendMessage(messageObtain);
    }

    public final String a(boolean z10) {
        if (z10) {
            return DefaultWebClient.f21815w + this.f12860d.f12852c;
        }
        return this.f12860d.f12851b + this.f12860d.f12852c;
    }

    public final void a(String str) {
        b bVarA = b.a();
        if (d.a(str, bVarA)) {
            if (a(bVarA)) {
                return;
            }
            this.f12860d = bVarA;
            f();
            i();
            d();
            return;
        }
        this.f12862f.sendEmptyMessageDelayed(1, 3000L);
    }

    private boolean a(b bVar) {
        if (this.f12860d.f12850a >= bVar.f12850a) {
            return true;
        }
        Log.i("efs.config", "current config version (" + this.f12860d.f12850a + ") is older than another (" + bVar.f12850a + ee.a.f26979d);
        return false;
    }
}
