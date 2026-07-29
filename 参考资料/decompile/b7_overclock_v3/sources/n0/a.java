package n0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @yt.k
    public static final BitmapDrawable a(@yt.k Bitmap bitmap, @yt.k Resources resources) {
        f0.p(bitmap, "<this>");
        f0.p(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
