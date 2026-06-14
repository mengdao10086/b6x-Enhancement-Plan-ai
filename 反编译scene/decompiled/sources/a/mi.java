package a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class mi {
    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }
}
