package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class o {
    @v0(version = "1.1")
    @bk.e
    public static final void a(@yt.k Throwable th2, @yt.k Throwable exception) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        kotlin.jvm.internal.f0.p(exception, "exception");
        if (th2 != exception) {
            bk.m.f9497a.a(th2, exception);
        }
    }

    @yt.k
    public static final StackTraceElement[] b(@yt.k Throwable th2) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        StackTraceElement[] stackTrace = th2.getStackTrace();
        kotlin.jvm.internal.f0.m(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void c(Throwable th2) {
    }

    @yt.k
    public static final List<Throwable> d(@yt.k Throwable th2) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        return bk.m.f9497a.d(th2);
    }

    @v0(version = "1.4")
    public static /* synthetic */ void e(Throwable th2) {
    }

    @bk.f
    public static final void f(Throwable th2) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        th2.printStackTrace();
    }

    @bk.f
    public static final void g(Throwable th2, PrintStream stream) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        kotlin.jvm.internal.f0.p(stream, "stream");
        th2.printStackTrace(stream);
    }

    @bk.f
    public static final void h(Throwable th2, PrintWriter writer) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        kotlin.jvm.internal.f0.p(writer, "writer");
        th2.printStackTrace(writer);
    }

    @v0(version = "1.4")
    @yt.k
    public static final String i(@yt.k Throwable th2) {
        kotlin.jvm.internal.f0.p(th2, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kotlin.jvm.internal.f0.o(string, "sw.toString()");
        return string;
    }
}
