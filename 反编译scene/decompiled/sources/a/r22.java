package a;

import android.content.Context;
import android.content.res.Resources;
import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r22 extends XC_MethodHook {
    public r22(a32 a32Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr = methodHookParam.args;
        if (objArr == null) {
            return;
        }
        Resources resources = ((Context) objArr[0]).getResources();
        float f = resources.getDisplayMetrics().density;
        if (resources.getConfiguration().isLayoutSizeAtLeast(4)) {
            f *= 1.5f;
        }
        a32.f5566a = f;
    }
}
