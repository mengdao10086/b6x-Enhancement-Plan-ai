package a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qi extends pi {
    public qi(ri riVar) {
        super(riVar);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.f7024a.a(i, ni.D0(accessibilityNodeInfo), str, bundle);
    }
}
