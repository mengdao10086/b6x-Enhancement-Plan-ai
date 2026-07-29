package b2;

import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f {
    public static void a(@n0 Exception exc) throws Throwable {
        b(exc);
    }

    public static <E extends Throwable> void b(@n0 Throwable th2) throws Throwable {
        throw th2;
    }
}
