package a;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pi extends oi {
    public pi(ri riVar) {
        super(riVar);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i) {
        ni niVarD = this.f7024a.d(i);
        if (niVarD == null) {
            return null;
        }
        return niVarD.C0();
    }
}
