package a;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kq0 extends AccessibilityService.GestureResultCallback {
    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCancelled(GestureDescription gestureDescription) {
        f92.d(gestureDescription, "gestureDescription");
        super.onCancelled(gestureDescription);
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCompleted(GestureDescription gestureDescription) {
        f92.d(gestureDescription, "gestureDescription");
        super.onCompleted(gestureDescription);
    }
}
