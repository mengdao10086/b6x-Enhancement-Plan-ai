package a;

import android.webkit.WebView;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c32 extends XC_MethodHook {
    public c32(e32 e32Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        super.afterHookedMethod(methodHookParam);
        XposedHelpers.callMethod(methodHookParam.thisObject, "setLayerType", new Object[]{2, null});
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        try {
            XposedHelpers.callStaticMethod(WebView.class, "setWebContentsDebuggingEnabled", new Object[]{Boolean.TRUE});
        } catch (Exception unused) {
        }
    }
}
