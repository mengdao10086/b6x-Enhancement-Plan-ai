package f4;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27964a = "GlideRuntimeCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27965b = "cpu[0-9]+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27966c = "/sys/devices/system/cpu/";

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pattern f27967a;

        public a(Pattern pattern) {
            this.f27967a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f27967a.matcher(str).matches();
        }
    }

    public static int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArrListFiles = new File(f27966c).listFiles(new a(Pattern.compile(f27965b)));
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (Throwable unused) {
            Log.isLoggable(f27964a, 6);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            fileArrListFiles = null;
        }
        return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
    }
}
