package a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.omarea.scene_mode.ReceiverShortcut;
import com.omarea.vtools.activities.ActivityQuickStart;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ot0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2301a = "*";

    public boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b(context, str);
        }
        try {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            PackageManager packageManager = context.getPackageManager();
            intent.putExtra("android.intent.extra.shortcut.NAME", this.f2301a + ((Object) applicationInfo.loadLabel(packageManager)));
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.ICON", d(applicationInfo.loadIcon(packageManager)));
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setClassName(context.getApplicationContext(), ActivityQuickStart.class.getName());
            intent2.putExtra("packageName", str);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            context.sendBroadcast(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean b(Context context, String str) {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService("shortcut");
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            PackageManager packageManager = context.getPackageManager();
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return true;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setClassName(context.getApplicationContext(), ActivityQuickStart.class.getName());
            intent.putExtra("packageName", str);
            ShortcutInfo shortcutInfoBuild = new ShortcutInfo.Builder(context, str).setIcon(Icon.createWithBitmap(d(applicationInfo.loadIcon(packageManager)))).setShortLabel(this.f2301a + ((Object) applicationInfo.loadLabel(packageManager))).setIntent(intent).setActivity(new ComponentName(context, (Class<?>) ActivityQuickStart.class)).build();
            Intent intent2 = new Intent(context, (Class<?>) ReceiverShortcut.class);
            intent2.setAction(context.getString(u61.scene_create_shortcut_action));
            intent2.putExtra("packageName", str);
            int i = f7054a + 1;
            f7054a = i;
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent2, 268435456);
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return false;
            }
            Iterator<ShortcutInfo> it = shortcutManager.getPinnedShortcuts().iterator();
            while (it.hasNext()) {
                if (it.next().getId().equals(shortcutInfoBuild.getId())) {
                    shortcutManager.updateShortcuts(new lt0(this, shortcutInfoBuild));
                    return true;
                }
            }
            shortcutManager.requestPinShortcut(shortcutInfoBuild, broadcast.getIntentSender());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c(Context context, String str) {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService("shortcut");
            shortcutManager.removeDynamicShortcuts(new mt0(this, str));
            shortcutManager.disableShortcuts(new nt0(this, str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final Bitmap d(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (Build.VERSION.SDK_INT < 26 || !(drawable instanceof AdaptiveIconDrawable)) {
            return null;
        }
        AdaptiveIconDrawable adaptiveIconDrawable = (AdaptiveIconDrawable) drawable;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{adaptiveIconDrawable.getBackground(), adaptiveIconDrawable.getForeground()});
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        layerDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public ArrayList<String> e(Context context) {
        return Build.VERSION.SDK_INT >= 26 ? f(context) : new ArrayList<>();
    }

    public final ArrayList<String> f(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (ShortcutInfo shortcutInfo : ((ShortcutManager) context.getSystemService("shortcut")).getPinnedShortcuts()) {
                CharSequence shortLabel = shortcutInfo.getShortLabel();
                if (shortLabel != null && shortLabel.toString().startsWith(this.f2301a)) {
                    arrayList.add(shortcutInfo.getId());
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public boolean g(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c(context, str);
        }
        try {
            Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", this.f2301a + ((Object) context.getPackageManager().getPackageInfo(str, 0).applicationInfo.loadLabel(context.getPackageManager())));
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setClassName(context.getApplicationContext(), ActivityQuickStart.class.getName());
            intent2.putExtra("packageName", str);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            context.sendBroadcast(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
