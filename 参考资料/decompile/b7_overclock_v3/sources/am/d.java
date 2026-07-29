package am;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lam/d;", "Ljava/util/logging/Handler;", "Ljava/util/logging/LogRecord;", "record", "Lkotlin/z1;", "publish", "flush", "close", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final d f781a = new d();

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(@yt.k LogRecord record) {
        f0.p(record, "record");
        c cVar = c.f777a;
        String loggerName = record.getLoggerName();
        f0.o(loggerName, "record.loggerName");
        int iB = e.b(record);
        String message = record.getMessage();
        f0.o(message, "record.message");
        cVar.a(loggerName, iB, message, record.getThrown());
    }
}
