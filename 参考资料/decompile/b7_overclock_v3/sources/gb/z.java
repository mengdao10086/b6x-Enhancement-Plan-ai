package gb;

import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import g.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29134a = "LicenseDurationRemaining";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f29135b = "PlaybackDurationRemaining";

    public static long a(Map<String, String> map, String str) {
        if (map == null) {
            return ya.g.f56663b;
        }
        try {
            String str2 = map.get(str);
            return str2 != null ? Long.parseLong(str2) : ya.g.f56663b;
        } catch (NumberFormatException unused) {
            return ya.g.f56663b;
        }
    }

    @p0
    public static Pair<Long, Long> b(DrmSession drmSession) {
        Map<String, String> mapI = drmSession.i();
        if (mapI == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(mapI, f29134a)), Long.valueOf(a(mapI, f29135b)));
    }
}
