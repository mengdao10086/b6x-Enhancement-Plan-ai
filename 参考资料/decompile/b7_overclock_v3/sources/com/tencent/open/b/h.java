package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f22683a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f22687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f22688f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Random f22684b = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Serializable> f22686d = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Serializable> f22685c = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Executor f22689g = j.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Executor f22690h = j.b();

    private h() {
        this.f22687e = null;
        if (this.f22687e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f22687e = handlerThread;
            handlerThread.start();
        }
        if (!this.f22687e.isAlive() || this.f22687e.getLooper() == null) {
            return;
        }
        this.f22688f = new Handler(this.f22687e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    h.this.b();
                } else if (i10 == 1001) {
                    h.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized h a() {
        if (f22683a == null) {
            f22683a = new h();
        }
        return f22683a;
    }

    public void b() {
        if (k.b(com.tencent.open.utils.f.a())) {
            this.f22690h.execute(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, String> mapC = h.this.c();
                        if (mapC != null && !mapC.isEmpty()) {
                            int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
                            if (iA == 0) {
                                iA = 3;
                            }
                            SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + iA);
                            boolean z10 = false;
                            int i10 = 0;
                            while (true) {
                                i10++;
                                try {
                                    try {
                                        int iD = com.tencent.open.a.a.a().b("https://wspeed.qq.com/w.cgi", mapC).d();
                                        SLog.i("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + iD);
                                        if (iD != 200) {
                                            break;
                                        }
                                        g.a().b("report_cgi");
                                        z10 = true;
                                        break;
                                    } catch (Exception e10) {
                                        SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e10);
                                    }
                                } catch (SocketTimeoutException e11) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e11);
                                    if (i10 >= iA) {
                                        break;
                                    }
                                }
                            }
                            if (!z10) {
                                g.a().a("report_cgi", h.this.f22685c);
                            }
                            h.this.f22685c.clear();
                        }
                    } catch (Exception e12) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e12);
                    }
                }
            });
        }
    }

    public Map<String, String> c() {
        if (this.f22685c.size() == 0) {
            return null;
        }
        c cVar = (c) this.f22685c.get(0);
        if (cVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = cVar.f22677a.get("appid");
        List<Serializable> listA = g.a().a("report_cgi");
        if (listA != null) {
            this.f22685c.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f22685c.size());
        if (this.f22685c.size() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            map.put("appid", str);
            map.put("releaseversion", Constants.SDK_VERSION_REPORT);
            map.put("device", Build.DEVICE);
            map.put("qua", Constants.SDK_QUA);
            map.put("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i10 = 0; i10 < this.f22685c.size(); i10++) {
                c cVar2 = (c) this.f22685c.get(i10);
                map.put(i10 + "_1", cVar2.f22677a.get("apn"));
                map.put(i10 + "_2", cVar2.f22677a.get("frequency"));
                map.put(i10 + "_3", cVar2.f22677a.get("commandid"));
                map.put(i10 + "_4", cVar2.f22677a.get("resultCode"));
                map.put(i10 + "_5", cVar2.f22677a.get("timeCost"));
                map.put(i10 + "_6", cVar2.f22677a.get("reqSize"));
                map.put(i10 + "_7", cVar2.f22677a.get("rspSize"));
                map.put(i10 + "_8", cVar2.f22677a.get("detail"));
                map.put(i10 + "_9", cVar2.f22677a.get("uin"));
                map.put(i10 + "_10", d.e(com.tencent.open.utils.f.a()) + "&" + cVar2.f22677a.get("deviceInfo"));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + map.toString());
            return map;
        } catch (Exception e10) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e10);
            return null;
        }
    }

    public Map<String, String> d() {
        List<Serializable> listA = g.a().a("report_via");
        if (listA != null) {
            this.f22686d.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f22686d.size());
        if (this.f22686d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f22686d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.f22677a.keySet()) {
                try {
                    String str2 = cVar.f22677a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e10) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e10);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap map = new HashMap();
            map.put("data", jSONObject2.toString());
            return map;
        } catch (JSONException e11) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e11);
            return null;
        }
    }

    public void e() {
        if (k.b(com.tencent.open.utils.f.a())) {
            this.f22689g.execute(new Runnable() { // from class: com.tencent.open.b.h.5
                /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
                
                    r18 = r5;
                    r22 = r9;
                    r20 = r14;
                    r7 = true;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 279
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.AnonymousClass5.run():void");
                }
            });
        }
    }

    public void a(final Bundle bundle, String str, final boolean z10) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z10) {
            this.f22689g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strK = k.k(d.b(com.tencent.open.utils.f.a()));
                        String strK2 = k.k(d.c(com.tencent.open.utils.f.a()));
                        String strK3 = k.k(d.a());
                        String strK4 = k.k(d.d(com.tencent.open.utils.f.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", strK);
                        bundle2.putString("imsi", strK2);
                        bundle2.putString(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, strK4);
                        bundle2.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, strK3);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString(CommonNetImpl.POSITION, "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.f.a()));
                        bundle2.putString(an.N, d.b());
                        bundle2.putString(an.f23260z, d.a(com.tencent.open.utils.f.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.f.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, Build.MODEL);
                        bundle2.putString(an.M, TimeZone.getDefault().getID());
                        bundle2.putString(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", k.d(com.tencent.open.utils.f.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, k.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", k.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.f.b());
                        bundle2.putString(Constants.PARAM_APP_VER, k.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        h.this.f22686d.add(new c(bundle2));
                        int size = h.this.f22686d.size();
                        int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z10) {
                            if (h.this.f22688f.hasMessages(1001)) {
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1001;
                            h.this.f22688f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        h.this.e();
                        h.this.f22688f.removeMessages(1001);
                    } catch (Exception e10) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e10);
                    }
                }
            });
        }
    }

    public void a(String str, long j10, long j11, long j12, int i10) {
        a(str, j10, j11, j12, i10, "", false);
    }

    public void a(final String str, final long j10, final long j11, final long j12, final int i10, final String str2, final boolean z10) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j10 + " | reqSize:" + j11 + " | rspSize: " + j12 + " | responseCode: " + i10 + " | detail: " + str2);
        if (a("report_cgi", "" + i10) || z10) {
            this.f22690h.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
                        Bundle bundle = new Bundle();
                        String strA = a.a(com.tencent.open.utils.f.a());
                        bundle.putString("apn", strA);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("network=");
                        sb2.append(strA);
                        sb2.append('&');
                        sb2.append("sdcard=");
                        int i11 = 1;
                        sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb2.append('&');
                        sb2.append("wifi=");
                        sb2.append(a.e(com.tencent.open.utils.f.a()));
                        bundle.putString("deviceInfo", sb2.toString());
                        int iA = 100 / h.this.a(i10);
                        if (iA > 0) {
                            i11 = iA > 100 ? 100 : iA;
                        }
                        bundle.putString("frequency", i11 + "");
                        bundle.putString("reqSize", j11 + "");
                        bundle.putString("resultCode", i10 + "");
                        bundle.putString("rspSize", j12 + "");
                        bundle.putString("timeCost", jElapsedRealtime + "");
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        h.this.f22685c.add(new c(bundle));
                        int size = h.this.f22685c.size();
                        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA2 == 0) {
                            iA2 = 10000;
                        }
                        if (h.this.a("report_cgi", size) || z10) {
                            h.this.b();
                            h.this.f22688f.removeMessages(1000);
                        } else if (!h.this.f22688f.hasMessages(1000)) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1000;
                            h.this.f22688f.sendMessageDelayed(messageObtain, iA2);
                        }
                    } catch (Exception e10) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e10);
                    }
                }
            });
        }
    }

    public boolean a(String str, String str2) {
        int iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i10 = 100;
        if (str.equals("report_cgi")) {
            try {
                iA = a(Integer.parseInt(str2));
                if (this.f22684b.nextInt(100) < iA) {
                    z10 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                iA = f.a(str2);
                if (this.f22684b.nextInt(100) < iA) {
                    i10 = iA;
                    z10 = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
            return z10;
        }
        i10 = iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[PHI: r0
  0x001c: PHI (r0v9 int) = (r0v6 int), (r0v12 int) binds: [B:11:0x0034, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.f.a()
            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.f.a()
            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, int):boolean");
    }

    public int a(int i10) {
        if (i10 == 0) {
            int iA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(final String str, final Map<String, String> map) {
        if (k.b(com.tencent.open.utils.f.a())) {
            j.b(new Runnable() { // from class: com.tencent.open.b.h.6
                @Override // java.lang.Runnable
                public void run() {
                    int i10 = 0;
                    try {
                        int iA = f.a();
                        if (iA == 0) {
                            iA = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                        do {
                            i10++;
                            try {
                                SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.a.a().a(str, map).d());
                            } catch (SocketTimeoutException e10) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e10);
                            } catch (Exception e11) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e11);
                            }
                        } while (i10 < iA);
                    } catch (Exception e12) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e12);
                    }
                }
            });
        }
    }
}
