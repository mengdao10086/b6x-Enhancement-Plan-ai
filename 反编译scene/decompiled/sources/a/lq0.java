package a;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lq0 {
    public final GestureDescription a(Rect rect) {
        Point point = new Point(rect.left + ((rect.right - rect.left) / 2), rect.top + ((rect.bottom - rect.top) / 2));
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        path.moveTo(point.x, point.y);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, 20L));
        GestureDescription gestureDescriptionBuild = builder.build();
        f92.c(gestureDescriptionBuild, "gesture");
        return gestureDescriptionBuild;
    }

    public final boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        f92.d(accessibilityNodeInfo, "node");
        if (!d(accessibilityNodeInfo)) {
            return false;
        }
        accessibilityNodeInfo.performAction(16);
        return true;
    }

    public final AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo) {
        f92.d(accessibilityNodeInfo, "nodeInfo");
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo;
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        if (parent != null) {
            return c(parent);
        }
        return null;
    }

    public final boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        f92.d(accessibilityNodeInfo, "node");
        return accessibilityNodeInfo.getActionList().contains(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
    }

    public final boolean e(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityService accessibilityService) {
        f92.d(accessibilityNodeInfo, "node");
        f92.d(accessibilityService, "service");
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        return accessibilityService.dispatchGesture(a(rect), new kq0(), null);
    }
}
