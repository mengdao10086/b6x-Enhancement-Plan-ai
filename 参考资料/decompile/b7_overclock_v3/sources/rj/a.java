package rj;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static Drawable a(Context context, int i10) {
        Drawable drawable = context.getDrawable(i10);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalArgumentException("maskId is invalid");
    }
}
