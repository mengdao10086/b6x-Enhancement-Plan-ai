package m0;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    @yt.k
    public static final PorterDuffColorFilter a(@yt.k PorterDuff.Mode mode, int i10) {
        kotlin.jvm.internal.f0.p(mode, "<this>");
        return new PorterDuffColorFilter(i10, mode);
    }

    @yt.k
    public static final PorterDuffXfermode b(@yt.k PorterDuff.Mode mode) {
        kotlin.jvm.internal.f0.p(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
