package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lokhttp3/q;", "", "", "hostname", "", "Ljava/net/InetAddress;", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f43935a = a.f43937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final q f43936b = new a.C0497a();

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lokhttp3/q$a;", "", "Lokhttp3/q;", "SYSTEM", "Lokhttp3/q;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f43937a = new a();

        /* JADX INFO: renamed from: okhttp3.q$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lokhttp3/q$a$a;", "Lokhttp3/q;", "", "hostname", "", "Ljava/net/InetAddress;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0497a implements q {
            @Override // okhttp3.q
            @yt.k
            public List<InetAddress> a(@yt.k String hostname) throws UnknownHostException {
                kotlin.jvm.internal.f0.p(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    kotlin.jvm.internal.f0.o(allByName, "getAllByName(hostname)");
                    return ArraysKt___ArraysKt.iz(allByName);
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException(kotlin.jvm.internal.f0.C("Broken system behaviour for dns lookup of ", hostname));
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }
    }

    @yt.k
    List<InetAddress> a(@yt.k String str) throws UnknownHostException;
}
