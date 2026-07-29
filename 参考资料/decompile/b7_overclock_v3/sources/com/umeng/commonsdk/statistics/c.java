package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bo;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24165b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24166c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24167d = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f24168o = "thtstart";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f24169p = "gkvc";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f24170q = "ekvc";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24171a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f24173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImprintHandler f24174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f24175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f24176i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Defcon f24178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f24179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f24180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24181n;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f24182r;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24172e = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ABTest f24177j = null;

    public c(Context context) {
        this.f24175h = null;
        this.f24176i = null;
        this.f24178k = null;
        this.f24179l = 0L;
        this.f24180m = 0;
        this.f24181n = 0;
        this.f24171a = null;
        this.f24182r = context;
        this.f24176i = ImprintHandler.getImprintService(context).c();
        this.f24178k = Defcon.getService(this.f24182r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f24182r);
        this.f24179l = sharedPreferences.getLong(f24168o, 0L);
        this.f24180m = sharedPreferences.getInt(f24169p, 0);
        this.f24181n = sharedPreferences.getInt(f24170q, 0);
        this.f24171a = UMEnvelopeBuild.imprintProperty(this.f24182r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f24182r);
        this.f24174g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f24178k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f24171a = UMEnvelopeBuild.imprintProperty(cVar.f24182r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f24182r)) {
            this.f24175h = e.a(this.f24182r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f24182r);
        this.f24173f = cVar;
        cVar.a(StatTracer.getInstance(this.f24182r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a aVarA = com.umeng.commonsdk.statistics.internal.a.a(this.f24182r);
            aVarA.e(name);
            boolean zA = aVarA.a(name);
            boolean zB = aVarA.b(name);
            boolean zC = aVarA.c(name);
            boolean zD = aVarA.d(name);
            String strD = com.umeng.commonsdk.stateless.d.d(name);
            byte[] bArrA = this.f24173f.a(byteArray, zA, zC, !TextUtils.isEmpty(strD) ? com.umeng.commonsdk.stateless.d.c(strD) : zD ? UMServerURL.SILENT_HEART_BEAT : zC ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int iA = bArrA == null ? 1 : a(bArrA);
            if (UMConfigure.isDebugLog()) {
                if (zD && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (zC && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (zB && iA == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (zA && iA == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (iA == 2) {
                e eVar = this.f24175h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.f24182r).saveSate();
                if (zD) {
                    String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f24182r, "iss", "");
                    if (!TextUtils.isEmpty(strImprintProperty)) {
                        if ("1".equalsIgnoreCase(strImprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.f24182r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(strImprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.f24182r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.f24182r);
                        }
                    }
                }
            } else if (iA == 3) {
                StatTracer.getInstance(this.f24182r).saveSate();
                if (zC) {
                    FieldManager.a().a(this.f24182r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f24182r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24047s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return iA == 2;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(this.f24182r, th2);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new az(new bo.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f24174g.b(response.getImprint());
                this.f24174g.d();
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(this.f24182r, th2);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
