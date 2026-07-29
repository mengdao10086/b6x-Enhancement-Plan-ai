package ya;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f57054a = "ExoPlayer";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f57055b = "2.13.3";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f57057d = 2013003;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f57059f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f57060g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f57061h = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f57056c = "ExoPlayerLib/2.13.3";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final String f57058e = "ExoPlayerLib/2.13.3 (Linux; Android " + Build.VERSION.RELEASE + ") " + f57056c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashSet<String> f57062i = new HashSet<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f57063j = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f57062i.add(str)) {
            f57063j += ", " + str;
        }
    }

    public static synchronized String b() {
        return f57063j;
    }
}
