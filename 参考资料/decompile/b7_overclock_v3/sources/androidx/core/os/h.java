package androidx.core.os;

import android.os.Environment;
import g.n0;
import g.v0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4655a = "EnvironmentCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4656b = "unknown";

    @v0(19)
    public static class a {
        @g.u
        public static String a(File file) {
            return Environment.getStorageState(file);
        }
    }

    @v0(21)
    public static class b {
        @g.u
        public static String a(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    @n0
    public static String a(@n0 File file) {
        return b.a(file);
    }
}
