package b;

import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nCoroutineDebugging.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineDebugging.kt\n_COROUTINE/CoroutineDebuggingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final String f8905a = "_COROUTINE";

    public static final StackTraceElement b(Throwable th2, String str) {
        StackTraceElement stackTraceElement = th2.getStackTrace()[0];
        return new StackTraceElement(f8905a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    @k
    public static final String c() {
        return f8905a;
    }
}
