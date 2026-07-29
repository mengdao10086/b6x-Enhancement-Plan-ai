package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokio/s0;", "Lokio/h;", "Ljava/io/IOException;", "cause", "y", "Lkotlin/z1;", "C", "Ljava/net/Socket;", "n", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class s0 extends h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final Socket f44207n;

    public s0(@yt.k Socket socket) {
        kotlin.jvm.internal.f0.p(socket, "socket");
        this.f44207n = socket;
    }

    @Override // okio.h
    public void C() {
        try {
            this.f44207n.close();
        } catch (AssertionError e10) {
            if (!f0.l(e10)) {
                throw e10;
            }
            g0.f44057a.log(Level.WARNING, kotlin.jvm.internal.f0.C("Failed to close timed out socket ", this.f44207n), (Throwable) e10);
        } catch (Exception e11) {
            g0.f44057a.log(Level.WARNING, kotlin.jvm.internal.f0.C("Failed to close timed out socket ", this.f44207n), (Throwable) e11);
        }
    }

    @Override // okio.h
    @yt.k
    public IOException y(@yt.l IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
