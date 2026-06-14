package a;

import android.app.Activity;
import android.app.UiModeManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.omarea.Scene;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Bitmap f1015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final gh1 f1013a = new gh1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f1014a = a42.a(fh1.f6106a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final LruCache<Float, BitmapDrawable> f1016a = new LruCache<>(3);

    public final boolean a(Context context, String str) {
        return ac.b(context, str) == 0;
    }

    public final boolean b() {
        return new File(c60.f5764a.d(Scene.f4798a.c(), "windowBg.jpg")).exists();
    }

    public final float c() {
        Point pointD = d();
        return pointD.y / pointD.x;
    }

    public final Point d() {
        Object objA;
        Object systemService;
        try {
            e42 e42Var = g42.f6169a;
            systemService = Scene.f4798a.c().getSystemService("window");
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        objA = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        g42.a(objA);
        Point point = new Point(0, 0);
        if (g42.c(objA)) {
            objA = point;
        }
        return (Point) objA;
    }

    public final Bitmap e(Activity activity) {
        if (b()) {
            Point pointM = m(activity);
            int i = pointM.x * pointM.y;
            if (f1015a == null || i != f6207a) {
                f6207a = i;
                Bitmap bitmapD = new z50().d(f());
                gh1 gh1Var = f1013a;
                f92.c(bitmapD, "this");
                f1017a = gh1Var.g(bitmapD);
                f1015a = bitmapD;
            }
        } else if (a(activity, "android.permission.READ_EXTERNAL_STORAGE") && a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && Scene.f4798a.g().getInt(hz0.f1282a.g0(), -1) == 10) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity);
            int wallpaperId = Build.VERSION.SDK_INT >= 24 ? wallpaperManager.getWallpaperId(1) : wallpaperManager.hashCode();
            if (f1015a == null || f6207a != wallpaperId) {
                f92.c(wallpaperManager, "wallpaper");
                WallpaperInfo wallpaperInfo = wallpaperManager.getWallpaperInfo();
                Bitmap bitmap = null;
                if ((wallpaperInfo != null ? wallpaperInfo.getPackageName() : null) == null) {
                    Drawable drawable = wallpaperManager.getDrawable();
                    if (drawable == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                    }
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                }
                f6207a = wallpaperId;
                if (bitmap != null) {
                    f1017a = f1013a.g(bitmap);
                    f1015a = bitmap;
                }
            }
        }
        return f1015a;
    }

    public final String f() {
        return (String) f1014a.getValue();
    }

    public final boolean g(Bitmap bitmap) {
        int i;
        int i2;
        int height = bitmap.getHeight() - 1;
        int width = bitmap.getWidth() - 1;
        int i3 = (height <= 4 || width <= 4) ? 1 : 4;
        if (i3 >= 0) {
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (true) {
                int i5 = (width / i3) * i4;
                if (i3 >= 0) {
                    int i6 = 0;
                    while (true) {
                        int pixel = bitmap.getPixel(i5, (height / i3) * i6);
                        int iRed = Color.red(pixel);
                        int iBlue = Color.blue(pixel);
                        int iGreen = Color.green(pixel);
                        if (iRed + iBlue + iGreen > 520 || iRed > 205 || iBlue > 205 || iGreen > 205) {
                            i2++;
                        } else {
                            i++;
                        }
                        if (i6 == i3) {
                            break;
                        }
                        i6++;
                    }
                }
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        return i > i2;
    }

    public final boolean h(Activity activity) {
        f92.d(activity, "activity");
        Object systemService = activity.getApplicationContext().getSystemService("uimode");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
        }
        UiModeManager uiModeManager = (UiModeManager) systemService;
        Context applicationContext = activity.getApplicationContext();
        f92.c(applicationContext, "activity.applicationContext");
        Resources resources = applicationContext.getResources();
        f92.c(resources, "activity.applicationContext.resources");
        d60 d60Var = new d60(resources.getConfiguration().uiMode);
        return uiModeManager.getNightMode() == 2 || (d60Var.b(32) || d60Var.b(48));
    }

    public final void i(Context context) {
        Resources resources = context.getResources();
        f92.c(resources, "resource");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        f92.c(displayMetrics, "resource.displayMetrics");
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.density;
        float f3 = f / f2;
        float f4 = 385;
        if (f3 < f4) {
            displayMetrics.density = f2 * (f3 / f4);
            resources.getDisplayMetrics().setTo(displayMetrics);
        }
    }

    public final void j(Bitmap bitmap) {
        f1015a = bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x019c, TryCatch #0 {all -> 0x019c, blocks: (B:3:0x001a, B:5:0x0031, B:7:0x003b, B:9:0x0045, B:13:0x006d, B:17:0x0082, B:23:0x0091, B:25:0x0097, B:27:0x009e, B:29:0x00a2, B:30:0x00b5, B:32:0x00be, B:36:0x00d6, B:65:0x0196, B:26:0x009b, B:20:0x0089, B:21:0x008d, B:38:0x00dd, B:61:0x018c, B:64:0x0193, B:41:0x00e9, B:48:0x013d, B:50:0x014e, B:51:0x0157, B:53:0x015f, B:56:0x016a, B:58:0x0185, B:60:0x0189, B:57:0x0178, B:44:0x010e, B:46:0x0128, B:47:0x0138), top: B:70:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b A[Catch: all -> 0x019c, TryCatch #0 {all -> 0x019c, blocks: (B:3:0x001a, B:5:0x0031, B:7:0x003b, B:9:0x0045, B:13:0x006d, B:17:0x0082, B:23:0x0091, B:25:0x0097, B:27:0x009e, B:29:0x00a2, B:30:0x00b5, B:32:0x00be, B:36:0x00d6, B:65:0x0196, B:26:0x009b, B:20:0x0089, B:21:0x008d, B:38:0x00dd, B:61:0x018c, B:64:0x0193, B:41:0x00e9, B:48:0x013d, B:50:0x014e, B:51:0x0157, B:53:0x015f, B:56:0x016a, B:58:0x0185, B:60:0x0189, B:57:0x0178, B:44:0x010e, B:46:0x0128, B:47:0x0138), top: B:70:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2 A[Catch: all -> 0x019c, TryCatch #0 {all -> 0x019c, blocks: (B:3:0x001a, B:5:0x0031, B:7:0x003b, B:9:0x0045, B:13:0x006d, B:17:0x0082, B:23:0x0091, B:25:0x0097, B:27:0x009e, B:29:0x00a2, B:30:0x00b5, B:32:0x00be, B:36:0x00d6, B:65:0x0196, B:26:0x009b, B:20:0x0089, B:21:0x008d, B:38:0x00dd, B:61:0x018c, B:64:0x0193, B:41:0x00e9, B:48:0x013d, B:50:0x014e, B:51:0x0157, B:53:0x015f, B:56:0x016a, B:58:0x0185, B:60:0x0189, B:57:0x0178, B:44:0x010e, B:46:0x0128, B:47:0x0138), top: B:70:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be A[Catch: all -> 0x019c, TryCatch #0 {all -> 0x019c, blocks: (B:3:0x001a, B:5:0x0031, B:7:0x003b, B:9:0x0045, B:13:0x006d, B:17:0x0082, B:23:0x0091, B:25:0x0097, B:27:0x009e, B:29:0x00a2, B:30:0x00b5, B:32:0x00be, B:36:0x00d6, B:65:0x0196, B:26:0x009b, B:20:0x0089, B:21:0x008d, B:38:0x00dd, B:61:0x018c, B:64:0x0193, B:41:0x00e9, B:48:0x013d, B:50:0x014e, B:51:0x0157, B:53:0x015f, B:56:0x016a, B:58:0x0185, B:60:0x0189, B:57:0x0178, B:44:0x010e, B:46:0x0128, B:47:0x0138), top: B:70:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.x90 k(android.app.Activity r18) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.gh1.k(android.app.Activity):a.x90");
    }

    public final float l(Activity activity) {
        Point pointM = m(activity);
        return pointM.y / pointM.x;
    }

    public final Point m(Activity activity) {
        Point point;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowManager windowManager = activity.getWindowManager();
            f92.c(windowManager, "windowManager");
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            f92.c(currentWindowMetrics, "windowManager.currentWindowMetrics");
            Rect bounds = currentWindowMetrics.getBounds();
            f92.c(bounds, "windowManager.currentWindowMetrics.bounds");
            return new Point(bounds.width(), bounds.height());
        }
        Window window = activity.getWindow();
        f92.c(window, "window");
        View decorView = window.getDecorView();
        f92.c(decorView, "window.decorView");
        if (decorView.getWidth() <= 0 || decorView.getHeight() <= 0) {
            Object systemService = activity.getSystemService("window");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            point = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point = new Point(decorView.getWidth(), decorView.getHeight());
        }
        return point;
    }
}
