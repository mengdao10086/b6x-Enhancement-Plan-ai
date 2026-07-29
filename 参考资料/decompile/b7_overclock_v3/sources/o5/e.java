package o5;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void b(Context context) {
        Intent intent = new Intent("android.settings.DISPLAY_SETTINGS");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void c(Context context) {
        if (h.p()) {
            if (d(new Intent("com.vivo.settings.display.FullScreenDisplayActivity"), context)) {
                b(context);
            } else {
                b(context);
            }
        }
    }

    public static boolean d(Intent intent, Context context) {
        try {
            if (!a(intent, context)) {
                return false;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.flydigi.base.common.n.d(e10, "启动Activity失败！！！！！！", new Object[0]);
            return false;
        }
    }
}
