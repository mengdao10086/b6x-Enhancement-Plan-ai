package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.f0;
import kotlinx.coroutines.internal.o0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38441a = -1640531527;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38442b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final o0 f38443c = new o0("REHASH");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final h f38444d = new h(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final h f38445e = new h(Boolean.TRUE);

    public static final h d(Object obj) {
        return obj == null ? f38444d : f0.g(obj, Boolean.TRUE) ? f38445e : new h(obj);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
