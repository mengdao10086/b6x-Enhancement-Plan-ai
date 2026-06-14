package a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.omarea.model.AppInfo;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ih0 extends a60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f1366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PackageManager f1368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<String, Drawable> f1369a;
    public final int b;

    public ih0(Context context, int i, int i2) {
        f92.d(context, "context");
        this.f1367a = context;
        this.f6412a = i;
        this.b = i2;
        this.f1366a = a42.a(new fh0(this));
        this.f1369a = this.f6412a < 1 ? null : new LruCache<>(this.f6412a);
    }

    public /* synthetic */ ih0(Context context, int i, int i2, int i3, b92 b92Var) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 128 : i2);
    }

    public final Drawable f() {
        return (Drawable) this.f1366a.getValue();
    }

    public final Drawable g(String str) {
        return (str.hashCode() == -526675574 && str.equals("com.tencent.mm:appbrand")) ? this.f1367a.getDrawable(2131230967) : f();
    }

    public final PackageManager h() {
        if (this.f1368a == null) {
            this.f1368a = this.f1367a.getPackageManager();
        }
        PackageManager packageManager = this.f1368a;
        f92.b(packageManager);
        return packageManager;
    }

    public final fe2<eh0> i(String str) {
        f92.d(str, "packageName");
        return qc2.b(hf2.f6309a, qe2.b(), null, new gh0(this, str, null), 2, null);
    }

    public final Drawable j(AppInfo appInfo) {
        ApplicationInfo applicationInfo;
        f92.d(appInfo, "item");
        LruCache<String, Drawable> lruCache = this.f1369a;
        Drawable drawable = lruCache != null ? lruCache.get(appInfo.getPackageName()) : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawableK = k(appInfo.getPackageName());
        if (drawableK != null) {
            return drawableK;
        }
        CharSequence charSequence = appInfo.path;
        if (charSequence == null || charSequence.length() == 0) {
            return drawableK;
        }
        try {
            File file = new File(appInfo.path.toString());
            if (!file.exists() || !file.canRead()) {
                return drawableK;
            }
            PackageInfo packageArchiveInfo = h().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            drawableK = (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) ? null : applicationInfo.loadIcon(h());
            Drawable drawableB = drawableK != null ? b(drawableK, this.b, this.b) : null;
            try {
                m(appInfo.getPackageName(), drawableB);
            } catch (Exception unused) {
            }
            return drawableB;
        } catch (Exception unused2) {
            return drawableK;
        }
    }

    public final Drawable k(String str) {
        Drawable drawableLoadIcon;
        f92.d(str, "packageName");
        LruCache<String, Drawable> lruCache = this.f1369a;
        Drawable drawableB = null;
        Drawable drawable = lruCache != null ? lruCache.get(str) : null;
        if (drawable != null) {
            return drawable;
        }
        try {
            drawableLoadIcon = h().getPackageInfo(str, 0).applicationInfo.loadIcon(h());
        } catch (Exception unused) {
            drawableLoadIcon = null;
        }
        if (drawableLoadIcon != null) {
            int i = this.b;
            drawableB = b(drawableLoadIcon, i, i);
        }
        m(str, drawableB);
        return drawableB;
    }

    public final fe2<Drawable> l(String str) {
        f92.d(str, "packageName");
        return qc2.b(hf2.f6309a, qe2.b(), null, new hh0(this, str, null), 2, null);
    }

    public final void m(String str, Drawable drawable) {
        LruCache<String, Drawable> lruCache = this.f1369a;
        if (lruCache == null || drawable == null) {
            return;
        }
        lruCache.put(str, drawable);
    }
}
