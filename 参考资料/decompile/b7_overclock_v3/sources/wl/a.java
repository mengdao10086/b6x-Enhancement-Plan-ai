package wl;

import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.t;
import okio.l;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lwl/a;", "", "", "c", "Lokhttp3/t;", "b", "Lokio/l;", "source", "Lokio/l;", "a", "()Lokio/l;", "<init>", "(Lokio/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final C0639a f54711c = new C0639a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f54712d = 262144;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final l f54713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f54714b;

    /* JADX INFO: renamed from: wl.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lwl/a$a;", "", "", "HEADER_LIMIT", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0639a {
        public C0639a() {
        }

        public /* synthetic */ C0639a(u uVar) {
            this();
        }
    }

    public a(@k l source) {
        f0.p(source, "source");
        this.f54713a = source;
        this.f54714b = 262144L;
    }

    @k
    public final l a() {
        return this.f54713a;
    }

    @k
    public final t b() throws IOException {
        t.a aVar = new t.a();
        while (true) {
            String strC = c();
            if (strC.length() == 0) {
                return aVar.i();
            }
            aVar.f(strC);
        }
    }

    @k
    public final String c() throws IOException {
        String strR0 = this.f54713a.r0(this.f54714b);
        this.f54714b -= (long) strR0.length();
        return strR0;
    }
}
