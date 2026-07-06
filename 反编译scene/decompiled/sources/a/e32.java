package a;

import android.graphics.Paint;
import android.webkit.WebView;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e32 {
    public void a() {
        XposedBridge.hookAllConstructors(WebView.class, new c32(this));
        XposedHelpers.findAndHookMethod(WebView.class, "setLayerType", new Object[]{Integer.TYPE, Paint.class, new d32(this)});
        XposedHelpers.findAndHookMethod(WebView.class, "setWebContentsDebuggingEnabled", new Object[]{Boolean.TYPE, new b32(this)});
    }
}
