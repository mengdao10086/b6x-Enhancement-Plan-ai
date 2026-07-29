package s0;

import android.location.Location;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final double a(@yt.k Location location) {
        f0.p(location, "<this>");
        return location.getLatitude();
    }

    public static final double b(@yt.k Location location) {
        f0.p(location, "<this>");
        return location.getLongitude();
    }
}
