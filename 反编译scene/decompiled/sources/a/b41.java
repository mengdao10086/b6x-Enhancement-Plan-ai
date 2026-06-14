package a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.LruCache;
import java.util.Collection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b41 {
    public b41() {
    }

    public /* synthetic */ b41(b92 b92Var) {
        this();
    }

    public final void a() {
        j(null);
        d41.f483a.clear();
        j(null);
    }

    public final Paint b() {
        return d41.f481a;
    }

    public final float c() {
        return d41.f5859a;
    }

    public final boolean d() {
        return d41.f485b;
    }

    public final boolean e() {
        return d41.f480a.f() != null;
    }

    public final Bitmap f() {
        return d41.f484b;
    }

    @SuppressLint({"MissingPermission"})
    public final void g(Activity activity, Bitmap bitmap, boolean z) {
        f92.d(activity, "activity");
        int iHashCode = activity.hashCode();
        if (bitmap == null) {
            d41.j(true);
            j(null);
            d41.f483a.put(Integer.valueOf(iHashCode), null);
            return;
        }
        int iHashCode2 = bitmap.hashCode();
        d41.f483a.put(Integer.valueOf(iHashCode), Integer.valueOf(iHashCode2));
        Bitmap bitmap2 = (Bitmap) d41.f482a.get(Integer.valueOf(iHashCode2));
        if (bitmap2 != null) {
            j(bitmap2);
            return;
        }
        Bitmap bitmapG = s90.g(Bitmap.createScaledBitmap(bitmap, 192, (int) (bitmap.getHeight() / (bitmap.getWidth() / 192)), false), Boolean.valueOf(z));
        b().setColor(z ? d41.f479a : d41.b);
        j(s90.b(bitmapG, 16));
        d41.f482a.put(Integer.valueOf(iHashCode2), f());
    }

    public final void h(Activity activity) {
        f92.d(activity, "activity");
        d41.f483a.remove(Integer.valueOf(activity.hashCode()));
        if (!d41.f483a.isEmpty()) {
            LruCache lruCache = d41.f482a;
            Collection collectionValues = d41.f483a.values();
            f92.c(collectionValues, "wallpaperStack.values");
            j((Bitmap) lruCache.get(i52.I(collectionValues)));
        }
    }

    public final void i(boolean z) {
        d41.c = z;
    }

    public final void j(Bitmap bitmap) {
        d41.f484b = bitmap;
    }
}
