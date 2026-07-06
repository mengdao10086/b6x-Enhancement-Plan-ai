package a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class oi extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ri f7024a;

    public oi(ri riVar) {
        this.f7024a = riVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        ni niVarB = this.f7024a.b(i);
        if (niVarB == null) {
            return null;
        }
        return niVarB.C0();
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        List<ni> listC = this.f7024a.c(str, i);
        if (listC == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = listC.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(listC.get(i2).C0());
        }
        return arrayList;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.f7024a.f(i, i2, bundle);
    }
}
