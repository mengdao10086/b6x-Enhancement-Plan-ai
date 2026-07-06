package a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import de.robv.android.xposed.XposedBridge;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i32 {
    public RelativeLayout a(Activity activity) {
        int i;
        XposedBridge.log("Scene WeChat BaseScanUI onResume -> getInjectContainer");
        View decorView = activity.getWindow().getDecorView();
        try {
            i = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            i = 1841;
        }
        return i >= 1841 ? d(decorView, 0) : c(decorView, 0);
    }

    public final RelativeLayout b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getClass().getName().equals("android.widget.RelativeLayout")) {
                return (RelativeLayout) childAt;
            }
        }
        return null;
    }

    public final RelativeLayout c(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getClass().getName().equals("com.tencent.mm.plugin.scanner.ui.ScanMaskView")) {
                int i3 = i2 + 1;
                if (i3 < viewGroup.getChildCount()) {
                    return (RelativeLayout) viewGroup.getChildAt(i3);
                }
            } else {
                RelativeLayout relativeLayoutC = c(childAt, i + 1);
                if (relativeLayoutC != null) {
                    return relativeLayoutC;
                }
            }
        }
        return null;
    }

    public final RelativeLayout d(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getClass().getName().equals("com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView")) {
                return b((ViewGroup) childAt);
            }
            RelativeLayout relativeLayoutD = d(childAt, i + 1);
            if (relativeLayoutD != null) {
                return relativeLayoutD;
            }
        }
        return null;
    }
}
