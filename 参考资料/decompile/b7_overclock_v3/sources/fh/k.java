package fh;

import com.upyun.library.exception.RespException;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.w;
import okhttp3.x;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f28488a;

    public k() {
        a0.a aVar = new a0.a();
        long j10 = j.f28484f;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f28488a = aVar.k(j10, timeUnit).j0(j.f28485g, timeUnit).R0(j.f28486h, timeUnit).t(true).f();
    }

    public d0 a(File file, String str, String str2, String str3, String str4, gh.c cVar) throws RespException, IOException {
        c0 c0VarF = new x.a().g(x.f43998l).a("policy", str2).a("authorization", "UPYUN " + str3 + ":" + str4).b(m7.a.f40702b, URLEncoder.encode(file.getName()), c0.e(w.j(DfuBaseService.MIME_TYPE_OCTET_STREAM), file)).f();
        if (cVar != null) {
            c0VarF = g.a(c0VarF, cVar);
        }
        d0 d0VarX = this.f28488a.a(new b0.a().a("x-upyun-api-version", "2").n("User-Agent", hh.c.f31296b).B(str).r(c0VarF).b()).X();
        if (d0VarX.k1()) {
            return d0VarX;
        }
        throw new RespException(d0VarX.W(), d0VarX.L().string());
    }
}
