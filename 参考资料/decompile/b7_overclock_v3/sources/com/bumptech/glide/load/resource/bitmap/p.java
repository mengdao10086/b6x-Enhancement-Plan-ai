package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import g.p0;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12623a = "DrawableToBitmap";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.engine.bitmap_recycle.e f12624b = new a();

    public class a extends com.bumptech.glide.load.engine.bitmap_recycle.f {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f, com.bumptech.glide.load.engine.bitmap_recycle.e
        public void e(Bitmap bitmap) {
        }
    }

    @p0
    public static com.bumptech.glide.load.engine.s<Bitmap> a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i10, int i11) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z10 = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(eVar, current, i10, i11);
            z10 = true;
        }
        if (!z10) {
            eVar = f12624b;
        }
        return g.f(bitmapB, eVar);
    }

    @p0
    public static Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i10, int i11) {
        if (i10 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f12623a, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to draw ");
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i11 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(f12623a, 5)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to draw ");
                sb3.append(drawable);
                sb3.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i10 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i11 = drawable.getIntrinsicHeight();
        }
        Lock lockI = d0.i();
        lockI.lock();
        Bitmap bitmapF = eVar.f(i10, i11, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapF);
            drawable.setBounds(0, 0, i10, i11);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapF;
        } finally {
            lockI.unlock();
        }
    }
}
