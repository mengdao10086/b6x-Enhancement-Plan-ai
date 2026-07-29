package m5;

import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.x0;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.s;
import okhttp3.v;
import retrofit2.s;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f40649e = "2";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f40650f = "AndroidAlpha";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f40651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static f0 f40652h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public okhttp3.a0 f40653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Gson f40654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public retrofit2.s f40655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f40656d = "https://api.flydigi.com/";

    public class a implements X509TrustManager {
        public a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    static {
        f40651g = (androidx.core.util.j.a("zh", "zh") && o5.p.d()) ? "zh" : SocializeProtocolConstants.PROTOCOL_KEY_EN;
    }

    public static f0 i() {
        if (f40652h == null) {
            synchronized (f0.class) {
                if (f40652h == null) {
                    f40652h = new f0();
                }
            }
        }
        return f40652h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ okhttp3.d0 n(v.a aVar) throws IOException {
        okhttp3.b0 b0VarT = aVar.T();
        if (!Constants.HTTP_GET.equalsIgnoreCase(b0VarT.m()) && Constants.HTTP_POST.equalsIgnoreCase(b0VarT.m())) {
            okhttp3.c0 c0VarF = b0VarT.f();
            String strK = c0VarF.b().k();
            TreeMap<String, String> treeMap = new TreeMap<>();
            if (!strK.contains("form-data") && strK.contains("x-www-form-urlencoded")) {
                okhttp3.s sVar = (okhttp3.s) c0VarF;
                s.a aVar2 = new s.a();
                for (int i10 = 0; i10 < sVar.w(); i10++) {
                    String strT = sVar.t(i10);
                    String strU = sVar.u(i10);
                    treeMap.put(strT, strU);
                    aVar2.b(strT, strU);
                }
                aVar2.a("sign", g(treeMap));
                c0VarF = aVar2.c();
            }
            b0VarT = b0VarT.n().r(c0VarF).b();
        }
        return aVar.e(b0VarT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ okhttp3.d0 o(v.a aVar) throws IOException {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("uid", a5.f.i().l());
        treeMap.put("deviceId", com.blankj.utilcode.util.x.b());
        treeMap.put("systemType", "Android");
        treeMap.put("systemVersion", String.valueOf(com.blankj.utilcode.util.x.l()));
        treeMap.put("clientVersion", String.valueOf(com.blankj.utilcode.util.d.A()));
        treeMap.put("appVersion", com.blankj.utilcode.util.d.C());
        treeMap.put("apiVersion", "2");
        treeMap.put("exTime", String.valueOf(System.currentTimeMillis()));
        treeMap.put("manufacture", com.blankj.utilcode.util.x.j());
        treeMap.put("model", com.blankj.utilcode.util.x.k());
        treeMap.put("sign", g(treeMap));
        treeMap.put(zc.f.f58391u, f40651g);
        treeMap.put(an.N, o5.p.b());
        treeMap.put("appClassType", "AndroidAlpha");
        treeMap.put("packageName", com.blankj.utilcode.util.d.l());
        treeMap.put("token", a5.f.i().k());
        int iG = x0.g();
        int iE = x0.e();
        treeMap.put("phoneWidth", String.valueOf(Math.max(iE, iG)));
        treeMap.put("phoneHeight", String.valueOf(Math.min(iE, iG)));
        treeMap.put("deviceType", com.blankj.utilcode.util.x.j() + com.blankj.utilcode.util.x.k());
        treeMap.put("deviceName", v5.a.j().d().getDeviceCode());
        b0.a aVarN = aVar.T().n();
        for (String str : treeMap.keySet()) {
            aVarN.a(str, treeMap.get(str));
        }
        return aVar.e(aVarN.b());
    }

    public final okhttp3.v c() {
        return new okhttp3.v() { // from class: m5.e0
            @Override // okhttp3.v
            public final okhttp3.d0 intercept(v.a aVar) {
                return this.f40647a.n(aVar);
            }
        };
    }

    public final okhttp3.c d() {
        return new okhttp3.c(e(), ob.k.N);
    }

    public final File e() {
        return new File(j1.a().getExternalCacheDir(), "okhttp");
    }

    public final SSLSocketFactory f(X509TrustManager trustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{trustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (Exception e10) {
            throw new AssertionError(e10);
        }
    }

    public final String g(TreeMap<String, String> arrayMap) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : arrayMap.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(hb.u.f30904o);
            sb2.append(entry.getValue());
            sb2.append("&");
        }
        return b.d(sb2.substring(0, sb2.length() - 1));
    }

    public Gson h() {
        if (this.f40654b == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            this.f40654b = gsonBuilder.create();
        }
        return this.f40654b;
    }

    public okhttp3.a0 j() {
        return this.f40653a;
    }

    public retrofit2.s k() {
        if (this.f40655c == null) {
            m(this.f40656d);
        }
        return this.f40655c;
    }

    public final okhttp3.v l() {
        return new okhttp3.v() { // from class: m5.d0
            @Override // okhttp3.v
            public final okhttp3.d0 intercept(v.a aVar) {
                return this.f40645a.o(aVar);
            }
        };
    }

    public void m(final String url) {
        this.f40656d = url;
        a0.a aVar = new a0.a();
        if (!a5.f.i().p()) {
            aVar.g0(Proxy.NO_PROXY);
        }
        aVar.d(l());
        aVar.c(c());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        aVar.k(10L, timeUnit);
        aVar.j0(10L, timeUnit);
        aVar.R0(20L, timeUnit);
        aVar.l0(true);
        X509TrustManager x509TrustManagerQ = q();
        aVar.Q0(f(x509TrustManagerQ), x509TrustManagerQ);
        aVar.g(d());
        this.f40653a = aVar.f();
        this.f40655c = new s.b().c(this.f40656d).b(mu.a.g(h())).a(lu.g.d()).j(this.f40653a).f();
    }

    public final okhttp3.v p() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.g(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public final X509TrustManager q() {
        return new a();
    }
}
