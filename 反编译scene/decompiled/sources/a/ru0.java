package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ru0 extends a60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f2787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<String, Drawable> f2788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2789a;

    public ru0(Context context, boolean z, int i) {
        f92.d(context, "context");
        this.f2786a = context;
        this.f2789a = z;
        this.f7332a = i;
        this.f2787a = context.getSharedPreferences("IconCacheManager", 0);
        this.f2788a = this.f7332a < 1 ? null : new LruCache<>(this.f7332a);
    }

    public /* synthetic */ ru0(Context context, boolean z, int i, int i2, b92 b92Var) {
        this(context, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i);
    }

    public final eh0 f(String str) {
        f92.d(str, "packageName");
        if (!this.f2787a.contains(str)) {
            j(str);
        }
        String string = this.f2787a.getString(str, null);
        Drawable drawableH = h(str);
        if (string != null) {
            str = string;
        }
        return new eh0(str, drawableH);
    }

    public final String g(String str) {
        String str2 = this.f2789a ? "logo_cache_xs/" : "logo_cache/";
        return c60.f5764a.d(this.f2786a, str2 + str + ".png");
    }

    public final Drawable h(String str) {
        LruCache<String, Drawable> lruCache;
        f92.d(str, "packageName");
        if (bc2.x(str, ".", false, 2, null)) {
            return null;
        }
        LruCache<String, Drawable> lruCache2 = this.f2788a;
        Drawable drawable = lruCache2 != null ? lruCache2.get(str) : null;
        if (drawable != null) {
            return drawable;
        }
        if (this.f2787a.contains(str)) {
            Bitmap bitmapI = i(str);
            BitmapDrawable bitmapDrawable = bitmapI != null ? new BitmapDrawable(bitmapI) : null;
            if (bitmapDrawable == null) {
                j(str);
            }
            drawable = bitmapDrawable;
        } else {
            j(str);
        }
        if (drawable != null && (lruCache = this.f2788a) != null) {
            lruCache.put(str, drawable);
        }
        return drawable;
    }

    public final Bitmap i(String str) {
        f92.d(str, "packageName");
        Bitmap bitmapD = new z50().d(g(str));
        if (bitmapD != null) {
            return bitmapD;
        }
        return null;
    }

    public final void j(String str) {
        f92.d(str, "packageName");
        pc2.b(null, new qu0(this, str, null), 1, null);
    }

    public final void k(Drawable drawable, String str) {
        f92.d(drawable, "drawable");
        f92.d(str, "packageName");
        boolean z = this.f2789a;
        Bitmap bitmapA = null;
        Bitmap bitmapC = c(drawable);
        if (z) {
            if (bitmapC != null) {
                bitmapA = a(bitmapC, 32, 32);
            }
        } else if (bitmapC != null) {
            if (bitmapC.getWidth() > 96) {
                bitmapC = a(bitmapC, bitmapC.getWidth() / 2, bitmapC.getHeight() / 2);
            }
            bitmapA = bitmapC;
        }
        new z50().e(bitmapA, g(str), Boolean.TRUE);
    }
}
