package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.blankj.utilcode.util.i0;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.a.c;
import com.efs.sdk.base.core.config.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.e.d;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.umcrash.UMCrash;
import g.n0;
import g.p0;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import l4.f;

/* JADX INFO: loaded from: classes2.dex */
public class ControllerCenter implements Handler.Callback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static GlobalEnvStruct f12872h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12873a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12874b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12875c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12876d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12877e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12878f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f12879g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f12880i;

    public ControllerCenter(EfsReporter.Builder builder) {
        f12872h = builder.getGlobalEnvStruct();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper(), this);
        this.f12880i = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.f12879g == null) {
            this.f12879g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f12872h.mAppContext.registerReceiver(this.f12879g, intentFilter);
        } catch (Throwable th2) {
            Log.w("efs.base", "register network change receiver error", th2);
            int i10 = this.f12873a + 1;
            this.f12873a = i10;
            if (i10 < 3) {
                this.f12880i.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(b.a.f12871a.a());
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final com.efs.sdk.base.core.d.b bVarA = com.efs.sdk.base.core.d.b.a(iLogProtocol);
                        final d dVar = d.a.f12903a;
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.e.d.1

                            /* JADX INFO: renamed from: a */
                            public final /* synthetic */ com.efs.sdk.base.core.d.b f12901a;

                            public AnonymousClass1(final com.efs.sdk.base.core.d.b bVarA2) {
                                bVar = bVarA2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.f12900a.a(bVar);
                            }
                        });
                    }
                } catch (Throwable th2) {
                    Log.e("efs.base", "log send error", th2);
                }
            }
        });
    }

    @n0
    public static GlobalEnvStruct getGlobalEnvStruct() {
        return f12872h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@n0 Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            b bVar = b.a.f12871a;
            Log.e("ballack", "initGlobalInfo called once.");
            com.efs.sdk.base.core.config.a aVar = new com.efs.sdk.base.core.config.a();
            bVar.f12869a = aVar;
            aVar.a("appid", getGlobalEnvStruct().getAppid());
            int iMyPid = ProcessUtil.myPid();
            bVar.f12869a.a("pid", Integer.valueOf(iMyPid));
            bVar.f12869a.a("ps", ProcessUtil.getProcessName(iMyPid));
            String strA = com.efs.sdk.base.core.util.d.a(bVar.f12870b);
            bVar.f12869a.a("wid", strA);
            if (TextUtils.isEmpty(getGlobalEnvStruct().getUid())) {
                bVar.f12869a.a("uid", strA);
            } else {
                bVar.f12869a.a("uid", getGlobalEnvStruct().getUid());
            }
            com.efs.sdk.base.core.config.a aVar2 = bVar.f12869a;
            com.efs.sdk.base.core.a.a.a();
            aVar2.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
            bVar.f12869a.a("pkg", PackageUtil.getPackageName(bVar.f12870b));
            bVar.f12869a.a("ver", PackageUtil.getAppVersionName(bVar.f12870b));
            bVar.f12869a.a("vcode", PackageUtil.getAppVersionCode(bVar.f12870b));
            bVar.f12869a.a(Constants.PARAM_SDK_VER, BuildConfig.VERSION_NAME);
            bVar.f12869a.a("brand", Build.BRAND.toLowerCase());
            com.efs.sdk.base.core.config.a aVar3 = bVar.f12869a;
            String str = Build.MODEL;
            aVar3.a("model", str == null ? "unknown" : str.replace(i0.f11861z, "-").replace("_", "-").toLowerCase());
            bVar.f12869a.a("build_model", str);
            DisplayMetrics displayMetrics = bVar.f12870b.getResources().getDisplayMetrics();
            bVar.f12869a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            bVar.f12869a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
            bVar.f12869a.a(SocializeProtocolConstants.PROTOCOL_KEY_FR, f.f39447b);
            bVar.f12869a.a("rom", Build.VERSION.RELEASE);
            bVar.f12869a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
            bVar.f12869a.a(zc.f.f58391u, Locale.getDefault().getLanguage());
            bVar.f12869a.a("tzone", TimeZone.getDefault().getID());
            bVar.f12869a.a("net", NetworkUtil.getNetworkType(bVar.f12870b));
            try {
                String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(bVar.f12870b);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    bVar.f12869a.a(UMCrash.KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    bVar.f12869a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                } else {
                    bVar.f12869a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    bVar.f12869a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                }
                bVar.f12869a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(bVar.f12870b)));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            com.efs.sdk.base.core.c.f unused = f.a.f12832a;
            c.a().b();
            a();
            com.efs.sdk.base.core.f.f fVar = f.a.f12921a;
            boolean zIsIntl = f12872h.isIntl();
            com.efs.sdk.base.core.f.c cVar = fVar.f12917a;
            if (zIsIntl) {
                cVar.f12909a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.f12910b = "4ea4e41a3993";
            } else {
                cVar.f12909a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.f12910b = "28ef1713347d";
            }
            fVar.f12918b = this;
            fVar.f12919c.f12904a = this;
            fVar.f12920d.f12904a = this;
            this.f12878f = true;
            com.efs.sdk.base.core.c.d.a().sendEmptyMessageDelayed(0, f12872h.getLogSendDelayMills());
            com.efs.sdk.base.core.f.f fVar2 = f.a.f12921a;
            if (fVar2.f12918b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.f12918b.send(new com.efs.sdk.base.core.f.b("efs_core", "pvuv", fVar2.f12917a.f12911c));
            }
        } else if (i10 == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                b((ILogProtocol) obj);
            }
        } else if (i10 == 3) {
            a();
        }
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f12878f) {
            b(iLogProtocol);
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = iLogProtocol;
        this.f12880i.sendMessage(messageObtain);
    }

    @p0
    public HttpResponse sendSyncImmediately(String str, int i10, String str2, boolean z10, File file) {
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b(str, (byte) 2);
        bVar.b(1);
        bVar.f12893d = file;
        bVar.a(str2);
        bVar.a(i10);
        bVar.f12891b.f12895b = z10;
        bVar.c();
        d.a.f12903a.f12900a.a(bVar);
        return bVar.f12891b.f12896c;
    }

    public static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap map = new HashMap(4);
            map.put("log_type", iLogProtocol.getLogType());
            map.put("log_data", iLogProtocol.generateString());
            map.put("link_key", iLogProtocol.getLinkKey());
            map.put("link_id", iLogProtocol.getLinkId());
            Message messageObtain = Message.obtain(null, 9, map);
            Message messageObtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(messageObtain, messageObtain2));
            messageObtain.recycle();
            messageObtain2.recycle();
        }
    }
}
