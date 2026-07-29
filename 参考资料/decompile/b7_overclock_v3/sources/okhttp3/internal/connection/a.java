package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.v;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/a;", "Lokhttp3/v;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f43795a = new a();

    @Override // okhttp3.v
    @k
    public okhttp3.d0 intercept(@k v.a chain) throws IOException {
        f0.p(chain, "chain");
        vl.g gVar = (vl.g) chain;
        return vl.g.j(gVar, 0, gVar.k().r(gVar), null, 0, 0, 0, 61, null).e(gVar.o());
    }
}
