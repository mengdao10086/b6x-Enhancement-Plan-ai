package a;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Log;
import com.omarea.vtools.activities.ActivityQuickStart;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2255a;

    public oj0(Context context, boolean z) {
        f92.d(context, "context");
        this.f7028a = context;
        this.f2255a = z;
    }

    public final boolean a(Intent intent, String str, Drawable drawable) {
        f92.d(intent, "intent");
        f92.d(str, "title");
        f92.d(drawable, "drawable");
        return Build.VERSION.SDK_INT >= 26 ? d(intent, str, drawable) : b(intent, str, drawable);
    }

    public final boolean b(Intent intent, String str, Drawable drawable) {
        try {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
            intent2.putExtra("duplicate", false);
            if (drawable == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            }
            intent2.putExtra("android.intent.extra.shortcut.ICON", ((BitmapDrawable) drawable).getBitmap());
            Intent intent3 = new Intent("android.intent.action.MAIN");
            Context applicationContext = this.f7028a.getApplicationContext();
            ComponentName component = intent.getComponent();
            f92.b(component);
            f92.c(component, "intent.component!!");
            intent3.setClassName(applicationContext, component.getClassName());
            intent3.putExtras(intent);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent3);
            this.f7028a.sendBroadcast(intent2);
            return true;
        } catch (Exception e) {
            Log.e("ShortcutManager", "" + e.getMessage());
            return false;
        }
    }

    public final String c(Intent intent) {
        StringBuilder sb = new StringBuilder();
        ComponentName component = intent.getComponent();
        f92.b(component);
        f92.c(component, "intent.component!!");
        sb.append(component.getPackageName());
        sb.append("/");
        ComponentName component2 = intent.getComponent();
        f92.b(component2);
        f92.c(component2, "intent.component!!");
        sb.append(component2.getClassName());
        return sb.toString();
    }

    @TargetApi(26)
    public final boolean d(Intent intent, String str, Drawable drawable) {
        f92.d(intent, "intent");
        f92.d(str, "title");
        f92.d(drawable, "drawable");
        try {
            Object systemService = this.f7028a.getSystemService("shortcut");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
            }
            ShortcutManager shortcutManager = (ShortcutManager) systemService;
            if (shortcutManager.isRequestPinShortcutSupported()) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.putExtras(intent);
                if (this.f2255a) {
                    intent2.setClassName(this.f7028a, new ComponentName(this.f7028a, (Class<?>) ActivityQuickStart.class).getClassName());
                    intent2.setFlags(1082130432);
                    ComponentName component = intent.getComponent();
                    intent2.putExtra("packageName", component != null ? component.getPackageName() : null);
                    ComponentName component2 = intent.getComponent();
                    f92.c(intent2.putExtra("className", component2 != null ? component2.getClassName() : null), "shortcutIntent.run {\n   …me)\n                    }");
                } else {
                    intent2.setComponent(intent.getComponent());
                }
                String strC = c(intent);
                ShortcutInfo.Builder intent3 = new ShortcutInfo.Builder(this.f7028a, strC).setIcon(Icon.createWithBitmap(new z50().c(drawable))).setShortLabel(str).setIntent(intent2);
                if (this.f2255a) {
                    f92.c(intent3.setActivity(new ComponentName(this.f7028a, (Class<?>) ActivityQuickStart.class)), "setActivity(ComponentNam…yQuickStart::class.java))");
                }
                ShortcutInfo shortcutInfoBuild = intent3.build();
                f92.c(shortcutInfoBuild, "ShortcutInfo.Builder(con…                 .build()");
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f7028a, 0, new Intent(), 134217728);
                List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
                f92.c(pinnedShortcuts, "shortcutManager.pinnedShortcuts");
                for (ShortcutInfo shortcutInfo : pinnedShortcuts) {
                    f92.c(shortcutInfo, "item");
                    if (f92.a(shortcutInfo.getId(), strC)) {
                        shortcutManager.updateShortcuts(new nj0(shortcutInfoBuild));
                        return true;
                    }
                }
                f92.c(broadcast, "shortcutCallbackIntent");
                shortcutManager.requestPinShortcut(shortcutInfoBuild, broadcast.getIntentSender());
            }
            return true;
        } catch (Exception e) {
            Log.e("ShortcutManager", "" + e.getMessage());
            return false;
        }
    }
}
