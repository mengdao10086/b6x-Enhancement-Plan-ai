package vl;

import com.tencent.open.SocialConstants;
import java.net.Proxy;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.b0;
import okhttp3.u;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"Lvl/i;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Ljava/net/Proxy$Type;", "proxyType", "", "a", "Lokhttp3/u;", "url", "c", "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final i f53218a = new i();

    @yt.k
    public final String a(@yt.k b0 request, @yt.k Proxy.Type proxyType) {
        f0.p(request, "request");
        f0.p(proxyType, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.m());
        sb2.append(zc.f.f58383m);
        i iVar = f53218a;
        if (iVar.b(request, proxyType)) {
            sb2.append(request.q());
        } else {
            sb2.append(iVar.c(request.q()));
        }
        sb2.append(" HTTP/1.1");
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean b(b0 b0Var, Proxy.Type type) {
        return !b0Var.l() && type == Proxy.Type.HTTP;
    }

    @yt.k
    public final String c(@yt.k u url) {
        f0.p(url, "url");
        String strX = url.x();
        String strZ = url.z();
        if (strZ == null) {
            return strX;
        }
        return strX + '?' + ((Object) strZ);
    }
}
