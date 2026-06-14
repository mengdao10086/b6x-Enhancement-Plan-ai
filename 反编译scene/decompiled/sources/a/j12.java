package a;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.omarea.Scene;
import com.omarea.model.SceneConfigInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WindowManager.LayoutParams f1491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WindowManager f1492a;

    public j12(Context context) {
        f92.d(context, "mContext");
        this.f6463a = context;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = 0;
        layoutParams.width = 0;
        layoutParams.screenOrientation = -1;
        layoutParams.type = (!(this.f6463a instanceof AccessibilityService) || Build.VERSION.SDK_INT < 22) ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2003 : 2032;
        layoutParams.format = -3;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = 56;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        m42 m42Var = m42.f6769a;
        this.f1491a = layoutParams;
        Object systemService = this.f6463a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.f1492a = (WindowManager) systemService;
    }

    public final void f() {
        View view = this.f1490a;
        if (view != null) {
            this.f1492a.removeViewImmediate(view);
        }
        this.f1490a = null;
        this.f1491a.screenOrientation = -1;
    }

    public final void g(SceneConfigInfo sceneConfigInfo) {
        f92.d(sceneConfigInfo, "config");
        int i = sceneConfigInfo.screenOrientation;
        if (i != this.f1491a.screenOrientation || this.f1490a == null) {
            this.f1491a.screenOrientation = i;
            Scene.f4798a.i(new i12(this));
        }
    }
}
