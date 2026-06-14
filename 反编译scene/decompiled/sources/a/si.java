package a;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class si {
    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }
}
