package am;

import android.util.Log;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.s0;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import okhttp3.a0;

/* JADX INFO: loaded from: classes5.dex */
@rl.c
@d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¨\u0006\u0013"}, d2 = {"Lam/c;", "", "", "loggerName", "", "logLevel", "message", "", "t", "Lkotlin/z1;", "a", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "b", "d", "logger", CommonNetImpl.TAG, "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f778b = 4000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final Map<String, String> f780d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f777a = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final CopyOnWriteArraySet<Logger> f779c = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r12 = a0.class.getPackage();
        String name = r12 == null ? null : r12.getName();
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = a0.class.getName();
        f0.o(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = xl.c.class.getName();
        f0.o(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = ul.d.class.getName();
        f0.o(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f780d = s0.D0(linkedHashMap);
    }

    public final void a(@yt.k String loggerName, int i10, @yt.k String message, @yt.l Throwable th2) {
        int iMin;
        f0.p(loggerName, "loggerName");
        f0.p(message, "message");
        String strD = d(loggerName);
        if (Log.isLoggable(strD, i10)) {
            if (th2 != null) {
                message = message + '\n' + ((Object) Log.getStackTraceString(th2));
            }
            int i11 = 0;
            int length = message.length();
            while (i11 < length) {
                int iR3 = StringsKt__StringsKt.r3(message, '\n', i11, false, 4, null);
                if (iR3 == -1) {
                    iR3 = length;
                }
                while (true) {
                    iMin = Math.min(iR3, i11 + 4000);
                    String strSubstring = message.substring(i11, iMin);
                    f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i10, strD, strSubstring);
                    if (iMin >= iR3) {
                        break;
                    } else {
                        i11 = iMin;
                    }
                }
                i11 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f780d.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }

    public final void c(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f779c.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(d.f781a);
        }
    }

    public final String d(String str) {
        String str2 = f780d.get(str);
        return str2 == null ? StringsKt___StringsKt.Y8(str, 23) : str2;
    }
}
