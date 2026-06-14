package a;

import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p22 {
    public void a(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        c();
        b();
    }

    public final void b() {
        XposedBridge.hookAllConstructors(Window.class, new m22(this));
        XposedHelpers.findAndHookMethod(Window.class, "setWindowManager", new Object[]{WindowManager.class, IBinder.class, String.class, Boolean.TYPE, new n22(this)});
        Class cls = Integer.TYPE;
        XposedHelpers.findAndHookMethod(Window.class, "setFlags", new Object[]{cls, cls, new o22(this)});
    }

    public final void c() {
        XposedBridge.hookAllConstructors(RecyclerView.class, new k22(this));
        XposedHelpers.findAndHookMethod(RecyclerView.class, "setItemViewCacheSize", new Object[]{Integer.TYPE, new l22(this)});
    }
}
