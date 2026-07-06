package a;

import android.view.Display;
import android.view.WindowManager;
import com.omarea.vtools.activities.ActivityAddin;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddin f6483a;
    public final /* synthetic */ ActivityAddin b;

    public j71(ActivityAddin activityAddin, ActivityAddin activityAddin2, ActivityAddin activityAddin3) {
        this.f6483a = activityAddin2;
        this.b = activityAddin3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        di1 di1Var = new di1(this.b);
        WindowManager windowManager = this.f6483a.getWindowManager();
        f92.c(windowManager, "activity.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        f92.c(defaultDisplay, "activity.windowManager.defaultDisplay");
        di1Var.m(defaultDisplay, this.b);
    }
}
