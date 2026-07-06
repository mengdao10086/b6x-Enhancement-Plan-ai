package a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class a60 {
    public final Bitmap a(Bitmap bitmap, int i, int i2) {
        f92.d(bitmap, "bitmap");
        float width = bitmap.getWidth() / bitmap.getHeight();
        float f = i;
        float f2 = i2;
        if (f / f2 > 1) {
            i2 = (int) (f / width);
        } else {
            i = (int) (f2 * width);
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        f92.c(bitmapCreateScaledBitmap, "Bitmap.createScaledBitma…Width, finalHeight, true)");
        return bitmapCreateScaledBitmap;
    }

    public final Drawable b(Drawable drawable, int i, int i2) {
        f92.d(drawable, "drawable");
        if (drawable.getIntrinsicWidth() <= i && drawable.getIntrinsicHeight() <= i2) {
            return drawable;
        }
        Bitmap bitmapC = c(drawable);
        Bitmap bitmapA = bitmapC != null ? a(bitmapC, i, i2) : null;
        return bitmapA != null ? new BitmapDrawable(bitmapA) : drawable;
    }

    public final Bitmap c(Drawable drawable) {
        f92.d(drawable, "drawable");
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (Build.VERSION.SDK_INT < 26 || !(drawable instanceof AdaptiveIconDrawable)) {
            return null;
        }
        AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(adaptiveIconDrawable.getMinimumWidth(), adaptiveIconDrawable.getMinimumHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
