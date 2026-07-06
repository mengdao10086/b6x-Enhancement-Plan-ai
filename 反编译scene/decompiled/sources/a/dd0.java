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
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5885a;

    public dd0(Context context) {
        f92.d(context, "context");
        this.f5885a = context;
    }

    public final boolean a(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        f92.d(intent, "intent");
        f92.d(drawable, "drawable");
        f92.d(nodeInfoBase, "config");
        if (intent.hasExtra("page")) {
            Serializable serializableExtra = intent.getSerializableExtra("page");
            if (serializableExtra == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.krscript.model.PageNode");
            }
            intent.putExtra("shortcutId", e((PageNode) serializableExtra));
            intent.removeExtra("page");
        }
        return Build.VERSION.SDK_INT >= 26 ? c(intent, drawable, nodeInfoBase) : b(intent, drawable, nodeInfoBase);
    }

    public final boolean b(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        try {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            String str = "addin_" + nodeInfoBase.getIndex();
            intent2.putExtra("android.intent.extra.shortcut.NAME", nodeInfoBase.getTitle());
            intent2.putExtra("duplicate", false);
            if (drawable == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            }
            intent2.putExtra("android.intent.extra.shortcut.ICON", ((BitmapDrawable) drawable).getBitmap());
            Intent intent3 = new Intent("android.intent.action.MAIN");
            Context applicationContext = this.f5885a.getApplicationContext();
            ComponentName component = intent.getComponent();
            f92.b(component);
            intent3.setClassName(applicationContext, component.getClassName());
            intent3.putExtras(intent);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent3);
            intent3.setFlags(1082130432);
            this.f5885a.sendBroadcast(intent2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(26)
    public final boolean c(Intent intent, Drawable drawable, NodeInfoBase nodeInfoBase) {
        f92.d(intent, "intent");
        f92.d(drawable, "drawable");
        f92.d(nodeInfoBase, "config");
        try {
            Object systemService = this.f5885a.getSystemService("shortcut");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.content.pm.ShortcutManager");
            }
            ShortcutManager shortcutManager = (ShortcutManager) systemService;
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return true;
            }
            String str = "addin_" + nodeInfoBase.getIndex();
            Intent intent2 = new Intent("android.intent.action.MAIN");
            Context applicationContext = this.f5885a.getApplicationContext();
            ComponentName component = intent.getComponent();
            f92.b(component);
            intent2.setClassName(applicationContext, component.getClassName());
            intent2.putExtras(intent);
            intent2.setFlags(1082130432);
            ShortcutInfo.Builder intent3 = new ShortcutInfo.Builder(this.f5885a, str).setIcon(Icon.createWithBitmap(((BitmapDrawable) drawable).getBitmap())).setShortLabel(nodeInfoBase.getTitle()).setIntent(intent2);
            ComponentName component2 = intent.getComponent();
            f92.b(component2);
            ShortcutInfo shortcutInfoBuild = intent3.setActivity(component2).build();
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f5885a, 0, new Intent(), 134217728);
            if (!shortcutManager.isRequestPinShortcutSupported()) {
                return false;
            }
            for (ShortcutInfo shortcutInfo : shortcutManager.getPinnedShortcuts()) {
                f92.c(shortcutInfo, "item");
                if (f92.a(shortcutInfo.getId(), str)) {
                    shortcutManager.updateShortcuts(new cd0(shortcutInfoBuild));
                    return true;
                }
            }
            f92.c(broadcast, "shortcutCallbackIntent");
            shortcutManager.requestPinShortcut(shortcutInfoBuild, broadcast.getIntentSender());
            return true;
        } catch (Exception e) {
            Log.e("ActionShortcutManager", "" + e.getMessage());
            return false;
        }
    }

    public final PageNode d(String str) {
        f92.d(str, "shortcutId");
        return (PageNode) new g60(this.f5885a).c(str);
    }

    public final String e(PageNode pageNode) throws Throwable {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        new g60(this.f5885a).d(pageNode, strValueOf);
        return strValueOf;
    }
}
