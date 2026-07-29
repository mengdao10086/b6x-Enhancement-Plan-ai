package n0;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @yt.k
    public static final ColorDrawable a(@g.l int i10) {
        return new ColorDrawable(i10);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final ColorDrawable b(@yt.k Color color) {
        f0.p(color, "<this>");
        return new ColorDrawable(color.toArgb());
    }
}
