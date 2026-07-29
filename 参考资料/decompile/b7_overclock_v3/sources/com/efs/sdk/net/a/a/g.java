package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f13065a = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static g f13066c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f13067b = new b();

    private g() {
    }

    public static g c() {
        if (f13066c == null) {
            f13066c = new g();
        }
        return f13066c;
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.a aVar) {
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar = this.f13067b;
        try {
            String strA = aVar.a();
            bVar.f13056a.put(aVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.b bVarA = com.efs.sdk.net.a.a.a().a(strA);
            String strB = aVar.b();
            if (!TextUtils.isEmpty(strB)) {
                bVarA.f13075d = strB;
            }
            bVarA.f13076e = aVar.c();
            bVarA.f13077f = b.a(aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f13065a.getAndIncrement());
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.c cVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.f13067b;
        Log.i("NetTrace-Interceptor", "save response");
        String strA = cVar.a();
        if (bVar.f13056a != null) {
            com.efs.sdk.net.a.a.a().a(strA).f13078g = cVar.b();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    @l
    public final InputStream a(String str, @l String str2, @l String str3, @l InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
