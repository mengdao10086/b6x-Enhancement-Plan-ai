package okhttp3.internal.http2;

import hk.e;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/StreamResetException;", "Ljava/io/IOException;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "(Lokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StreamResetException extends IOException {

    @e
    @k
    public final ErrorCode errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(@k ErrorCode errorCode) {
        super(f0.C("stream was reset: ", errorCode));
        f0.p(errorCode, "errorCode");
        this.errorCode = errorCode;
    }
}
