package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.o;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/connection/RouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/io/IOException;", "e", "Lkotlin/z1;", "a", "firstConnectException", "Ljava/io/IOException;", "b", "()Ljava/io/IOException;", "<set-?>", "lastConnectException", "c", "<init>", "(Ljava/io/IOException;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class RouteException extends RuntimeException {

    @k
    private final IOException firstConnectException;

    @k
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(@k IOException firstConnectException) {
        super(firstConnectException);
        f0.p(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    public final void a(@k IOException e10) throws IllegalAccessException, InvocationTargetException {
        f0.p(e10, "e");
        o.a(this.firstConnectException, e10);
        this.lastConnectException = e10;
    }

    @k
    public final IOException b() {
        return this.firstConnectException;
    }

    @k
    public final IOException c() {
        return this.lastConnectException;
    }
}
