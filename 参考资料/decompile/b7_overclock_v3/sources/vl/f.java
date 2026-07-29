package vl;

import com.tencent.connect.common.Constants;
import hk.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import xf.z;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lvl/f;", "", "", z.f55306i, "", "e", "b", "a", "d", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final f f53205a = new f();

    @m
    public static final boolean b(@yt.k String method) {
        f0.p(method, "method");
        return (f0.g(method, Constants.HTTP_GET) || f0.g(method, "HEAD")) ? false : true;
    }

    @m
    public static final boolean e(@yt.k String method) {
        f0.p(method, "method");
        return f0.g(method, Constants.HTTP_POST) || f0.g(method, "PUT") || f0.g(method, "PATCH") || f0.g(method, "PROPPATCH") || f0.g(method, "REPORT");
    }

    public final boolean a(@yt.k String method) {
        f0.p(method, "method");
        return f0.g(method, Constants.HTTP_POST) || f0.g(method, "PATCH") || f0.g(method, "PUT") || f0.g(method, "DELETE") || f0.g(method, "MOVE");
    }

    public final boolean c(@yt.k String method) {
        f0.p(method, "method");
        return !f0.g(method, "PROPFIND");
    }

    public final boolean d(@yt.k String method) {
        f0.p(method, "method");
        return f0.g(method, "PROPFIND");
    }
}
