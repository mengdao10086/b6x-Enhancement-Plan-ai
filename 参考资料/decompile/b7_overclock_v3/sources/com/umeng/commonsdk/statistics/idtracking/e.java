package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f24222a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f24223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24224c = z.b().b("id");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f24225j = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f24226d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f24228f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f24231i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f24227e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f24230h = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f24229g = 86400000;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f24232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f24233b = new HashSet();

        public a(Context context) {
            this.f24232a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f24233b.contains(str);
        }

        public synchronized void b(String str) {
            this.f24233b.add(str);
        }

        public void c(String str) {
            this.f24233b.remove(str);
        }

        public synchronized void a() {
            if (!this.f24233b.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it2 = this.f24233b.iterator();
                while (it2.hasNext()) {
                    sb2.append(it2.next());
                    sb2.append(',');
                }
                sb2.deleteCharAt(sb2.length() - 1);
                PreferenceWrapper.getDefault(this.f24232a).edit().putString("invld_id", sb2.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.f24232a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(ag.c.f654g)) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f24233b.add(str);
                    }
                }
            }
        }
    }

    public e(Context context) {
        this.f24231i = null;
        this.f24226d = new File(context.getFilesDir(), f24224c);
        a aVar = new a(context);
        this.f24231i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        e eVar = f24223b;
        if (eVar != null) {
            eVar.e();
            f24223b = null;
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24230h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.f24227e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th2;
        FileInputStream fileInputStream;
        synchronized (f24225j) {
            if (!this.f24226d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f24226d);
                try {
                    try {
                        byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new az().a(cVar, streamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th2;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
            } catch (Throwable th4) {
                th2 = th4;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th2;
            }
        }
    }

    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f24228f >= this.f24229g) {
            boolean z10 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24230h) {
                if (aVar.c() && aVar.a()) {
                    z10 = true;
                    if (!aVar.c()) {
                        this.f24231i.b(aVar.b());
                    }
                }
            }
            if (z10) {
                h();
                this.f24231i.a();
                g();
            }
            this.f24228f = jCurrentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f24227e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f24223b == null) {
            return;
        }
        boolean z10 = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24230h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z10 = true;
            }
        }
        if (z10) {
            this.f24227e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c cVarI = i();
        if (cVarI == null) {
            return;
        }
        a(cVarI);
        ArrayList arrayList = new ArrayList(this.f24230h.size());
        synchronized (this) {
            this.f24227e = cVarI;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24230h) {
                aVar.a(this.f24227e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f24230h.remove((com.umeng.commonsdk.statistics.idtracking.a) it2.next());
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f24227e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized e a(Context context) {
        if (f24223b == null) {
            e eVar = new e(context);
            f24223b = eVar;
            eVar.a(new f(context));
            f24223b.a(new b(context));
            f24223b.a(new j(context));
            f24223b.a(new d(context));
            f24223b.a(new c(context));
            f24223b.a(new g(context));
            f24223b.a(new i());
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                f24223b.a(new h(context));
            }
            f24223b.f();
        }
        return f24223b;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (f24225j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new bf().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.f24226d, bArrA);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f24231i.a(aVar.b())) {
            return this.f24230h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j10) {
        this.f24229g = j10;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f24318a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24415h)) {
            cVar.f24318a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (cVar.f24318a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24414g)) {
            cVar.f24318a.remove("imei");
        }
        if (cVar.f24318a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24416i)) {
            cVar.f24318a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (cVar.f24318a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24417j)) {
            cVar.f24318a.remove("serial");
        }
        if (cVar.f24318a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24430w)) {
            cVar.f24318a.remove("idfa");
        }
        if (!cVar.f24318a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f24318a.remove("oaid");
    }
}
