package f2;

import android.os.Trace;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(29)
public final class c {
    public static void a(@n0 String str, int i10) {
        Trace.beginAsyncSection(str, i10);
    }

    public static void b(@n0 String str, int i10) {
        Trace.endAsyncSection(str, i10);
    }

    public static void c(@n0 String str, int i10) {
        Trace.setCounter(str, i10);
    }
}
