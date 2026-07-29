package com.tencent.open.a;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import hb.u;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.k;
import okhttp3.s;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f22646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a0 f22647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f22648c;

    /* JADX INFO: renamed from: com.tencent.open.a.a$a, reason: collision with other inner class name */
    public static class C0248a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22649a;

        public C0248a(String str) {
            this.f22649a = str;
        }

        @Override // okhttp3.v
        public d0 intercept(v.a aVar) throws IOException {
            return aVar.e(aVar.T().n().n("User-Agent", this.f22649a).b());
        }
    }

    public a() {
        b();
    }

    public static a a() {
        if (f22646a == null) {
            synchronized (a.class) {
                if (f22646a == null) {
                    f22646a = new a();
                }
            }
        }
        f22646a.c();
        return f22646a;
    }

    private void a(a0.a aVar) {
    }

    private void b() {
        C0248a c0248a = new C0248a("AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        a0.a aVarN = new a0.a().n(Arrays.asList(k.f43884i, k.f43885j));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a0.a aVarC = aVarN.k(15000L, timeUnit).j0(30000L, timeUnit).R0(30000L, timeUnit).g(null).c(c0248a);
        a(aVarC);
        this.f22647b = aVarC.f();
    }

    private void c() {
        g gVar = this.f22648c;
        if (gVar == null) {
            return;
        }
        int iA = gVar.a("Common_HttpConnectionTimeout");
        if (iA == 0) {
            iA = 15000;
        }
        int iA2 = this.f22648c.a("Common_SocketConnectionTimeout");
        if (iA2 == 0) {
            iA2 = 30000;
        }
        a(iA, iA2);
    }

    public void a(g gVar) {
        this.f22648c = gVar;
        c();
    }

    public void a(long j10, long j11) {
        if (this.f22647b.L() == j10 && this.f22647b.m0() == j11) {
            return;
        }
        SLog.i("openSDK_LOG.OpenHttpService", "setTimeout changed.");
        a0.a aVarG0 = this.f22647b.g0();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f22647b = aVarG0.k(j10, timeUnit).j0(j11, timeUnit).R0(j11, timeUnit).f();
    }

    public b b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        s.a aVar = new s.a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    aVar.a(str2, str3);
                }
            }
        }
        s sVarC = aVar.c();
        return new b(this.f22647b.a(new b0.a().B(str).r(sVarC).b()).X(), (int) sVarC.a());
    }

    public b a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb2.append(URLEncoder.encode(str2, "UTF-8"));
                    sb2.append(u.f30904o);
                    sb2.append(URLEncoder.encode(str3, "UTF-8"));
                    sb2.append("&");
                }
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return a(str, sb2.toString());
        }
        return a(str, "");
    }

    public b a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int iIndexOf = str2.indexOf("?");
            if (iIndexOf == -1) {
                str = str + "?";
            } else if (iIndexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new b(this.f22647b.a(new b0.a().B(str).g().b()).X(), str2.length());
    }

    public b a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("openSDK_LOG.OpenHttpService", "post data, has byte data");
            x.a aVar = new x.a();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        aVar.a(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    aVar.b(str4, str4, c0.h(w.h("content/unknown"), bArr));
                    SLog.w("openSDK_LOG.OpenHttpService", "post byte data.");
                }
            }
            x xVarF = aVar.f();
            return new b(this.f22647b.a(new b0.a().B(str).r(xVarF).b()).X(), (int) xVarF.a());
        }
        return b(str, map);
    }
}
