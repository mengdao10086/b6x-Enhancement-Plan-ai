package com.efs.sdk.net;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.r;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpListener extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f13048a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f13051d = new ArrayList();

    private void a(String str) {
        Map<String, Long> map;
        try {
            c cVarC = a.a().c(this.f13049b);
            if (cVarC == null || (map = cVarC.D) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void b() {
        try {
            c cVarC = a.a().c(this.f13049b);
            b bVarA = a.a().a(this.f13049b);
            if (cVarC == null || bVarA == null) {
                return;
            }
            Map<String, Long> map = cVarC.D;
            Map<String, Long> map2 = cVarC.E;
            Log.i("NetTrace-Listener", bVarA.toString());
            if (TextUtils.isEmpty(cVarC.B)) {
                Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(c.f13084d)) {
                efsJSONLog.put("wd_dns", map.get(c.f13084d));
            }
            if (map.containsKey(c.f13085e)) {
                efsJSONLog.put("wd_dnstm", map.get(c.f13085e));
            }
            if (map2.containsKey(c.f13100t)) {
                efsJSONLog.put("wl_dns", map2.get(c.f13100t));
            }
            if (map.containsKey(c.f13086f)) {
                efsJSONLog.put("wd_tcp", map.get(c.f13086f));
            }
            if (map.containsKey(c.f13089i)) {
                efsJSONLog.put("wd_tcptm", map.get(c.f13089i));
            }
            if (map2.containsKey(c.f13102v)) {
                efsJSONLog.put("wl_tcp", map2.get(c.f13102v));
            }
            if (map.containsKey(c.f13087g)) {
                efsJSONLog.put("wd_ssl", map.get(c.f13087g));
            }
            if (map.containsKey(c.f13088h)) {
                efsJSONLog.put("wd_ssltm", map.get(c.f13088h));
            }
            if (map2.containsKey(c.f13101u)) {
                efsJSONLog.put("wl_ssl", map2.get(c.f13101u));
            }
            if (map.containsKey(c.f13091k)) {
                efsJSONLog.put("wd_ds", map.get(c.f13091k));
            }
            if (map.containsKey(c.f13094n)) {
                efsJSONLog.put("wd_dstm", map.get(c.f13094n));
            }
            if (map2.containsKey(c.f13103w) && map2.containsKey(c.f13104x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(c.f13103w).longValue() + map2.get(c.f13104x).longValue()));
            }
            if (map.containsKey(c.f13095o)) {
                efsJSONLog.put("wd_srt", map.get(c.f13095o));
            }
            if (map.containsKey(c.f13098r)) {
                efsJSONLog.put("wd_srttm", map.get(c.f13098r));
            }
            if (map2.containsKey(c.f13105y) && map2.containsKey(c.f13106z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(c.f13105y).longValue() + map2.get(c.f13106z).longValue()));
            }
            String[] strArrSplit = cVarC.B.split("\\?");
            String str = strArrSplit != null ? strArrSplit[0] : null;
            List list = this.f13051d;
            if (list == null || str == null || list.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.f13051d.add(str);
                if (map.containsKey(c.f13094n)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.f13094n));
                } else if (map.containsKey(c.f13092l)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.f13092l));
                }
                if (map.containsKey(c.f13095o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(c.f13095o));
                }
                if (map.containsKey(c.f13095o)) {
                    if (map.containsKey(c.f13094n)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.f13095o).longValue() - map.get(c.f13094n).longValue()));
                    } else if (map.containsKey(c.f13092l)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.f13095o).longValue() - map.get(c.f13092l).longValue()));
                    }
                }
            }
            if (map.containsKey(c.f13081a)) {
                efsJSONLog.put("wd_rt", map.get(c.f13081a));
            }
            if (map.containsKey(c.f13082b)) {
                efsJSONLog.put("wd_rttm", map.get(c.f13082b));
            }
            if (map2.containsKey(c.f13099s)) {
                efsJSONLog.put("wl_rt", map2.get(c.f13099s));
            }
            efsJSONLog.put("wk_res", cVarC.B);
            efsJSONLog.put("wk_method", bVarA.f13076e);
            efsJSONLog.put("wk_rc", Integer.valueOf(bVarA.f13078g));
            efsJSONLog.put("wl_up", Long.valueOf(bVarA.f13077f));
            efsJSONLog.put("wl_down", Long.valueOf(bVarA.f13080i));
            efsJSONLog.put("wl_total", Long.valueOf(bVarA.f13077f + bVarA.f13080i));
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                a.a().d(this.f13049b);
                a.a().b(this.f13049b);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static r.c get() {
        return new r.c() { // from class: com.efs.sdk.net.OkHttpListener.1
            @Override // okhttp3.r.c
            @k
            public final r create(@k e eVar) {
                return new OkHttpListener();
            }
        };
    }

    @Override // okhttp3.r
    public void callEnd(@k e eVar) {
        super.callEnd(eVar);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(c.f13082b);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void callFailed(@k e eVar, @k IOException iOException) {
        super.callFailed(eVar, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(c.f13083c);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void callStart(@k e eVar) {
        super.callStart(eVar);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.f13050c = true;
            }
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.f13049b = String.valueOf(f13048a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.f13049b);
            a(c.f13081a);
            String string = eVar.T().q().toString();
            try {
                c cVarC = a.a().c(this.f13049b);
                if (cVarC != null) {
                    cVarC.B = string;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void connectEnd(@k e eVar, @k InetSocketAddress inetSocketAddress, @k Proxy proxy, @l Protocol protocol) {
        super.connectEnd(eVar, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(c.f13089i);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void connectFailed(@k e eVar, @k InetSocketAddress inetSocketAddress, @k Proxy proxy, @l Protocol protocol, @k IOException iOException) {
        super.connectFailed(eVar, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(c.f13090j);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void connectStart(@k e eVar, @k InetSocketAddress inetSocketAddress, @k Proxy proxy) {
        super.connectStart(eVar, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(c.f13086f);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void dnsEnd(@k e eVar, @k String str, @k List<InetAddress> list) {
        super.dnsEnd(eVar, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(c.f13085e);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void dnsStart(@k e eVar, @k String str) {
        super.dnsStart(eVar, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(c.f13084d);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void requestBodyEnd(@k e eVar, long j10) {
        super.requestBodyEnd(eVar, j10);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(c.f13094n);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void requestBodyStart(@k e eVar) {
        super.requestBodyStart(eVar);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(c.f13093m);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void requestHeadersEnd(@k e eVar, @k b0 b0Var) {
        super.requestHeadersEnd(eVar, b0Var);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(c.f13092l);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void requestHeadersStart(@k e eVar) {
        super.requestHeadersStart(eVar);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(c.f13091k);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void responseBodyEnd(@k e eVar, long j10) {
        super.responseBodyEnd(eVar, j10);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(c.f13098r);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void responseBodyStart(@k e eVar) {
        super.responseBodyStart(eVar);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(c.f13097q);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void responseHeadersEnd(@k e eVar, @k d0 d0Var) {
        super.responseHeadersEnd(eVar, d0Var);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(c.f13096p);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void responseHeadersStart(@k e eVar) {
        super.responseHeadersStart(eVar);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(c.f13095o);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void secureConnectEnd(@k e eVar, @l Handshake handshake) {
        super.secureConnectEnd(eVar, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(c.f13088h);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.r
    public void secureConnectStart(@k e eVar) {
        super.secureConnectStart(eVar);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.f13050c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(c.f13087g);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a() {
        try {
            c cVarC = a.a().c(this.f13049b);
            if (cVarC != null) {
                Map<String, Long> map = cVarC.D;
                Map<String, Long> map2 = cVarC.E;
                map2.put(c.f13099s, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13081a, c.f13082b)));
                map2.put(c.f13100t, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13084d, c.f13085e)));
                map2.put(c.f13101u, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13087g, c.f13088h)));
                map2.put(c.f13102v, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13086f, c.f13089i)));
                map2.put(c.f13103w, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13091k, c.f13092l)));
                map2.put(c.f13104x, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13093m, c.f13094n)));
                map2.put(c.f13105y, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13095o, c.f13096p)));
                map2.put(c.f13106z, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f13097q, c.f13098r)));
                b();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
