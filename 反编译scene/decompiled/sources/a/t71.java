package a;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.omarea.vtools.activities.ActivityAddinOnline;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAddinOnline.d f3000a;

    public t71(ActivityAddinOnline.d dVar, int i) {
        this.f3000a = dVar;
        this.f7474a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View decorView;
        int iC;
        Window window = ActivityAddinOnline.this.getWindow();
        f92.c(window, "window");
        window.setStatusBarColor(this.f7474a);
        if (Build.VERSION.SDK_INT >= 23) {
            if (Color.red(this.f7474a) <= 180 || Color.green(this.f7474a) <= 180 || Color.blue(this.f7474a) <= 180) {
                Window window2 = ActivityAddinOnline.this.getWindow();
                f92.c(window2, "window");
                decorView = window2.getDecorView();
                f92.c(decorView, "window.decorView");
                Window window3 = ActivityAddinOnline.this.getWindow();
                f92.c(window3, "window");
                View decorView2 = window3.getDecorView();
                f92.c(decorView2, "window.decorView");
                iC = new d60(decorView2.getSystemUiVisibility()).c(8192);
            } else {
                Window window4 = ActivityAddinOnline.this.getWindow();
                f92.c(window4, "window");
                decorView = window4.getDecorView();
                f92.c(decorView, "window.decorView");
                Window window5 = ActivityAddinOnline.this.getWindow();
                f92.c(window5, "window");
                View decorView3 = window5.getDecorView();
                f92.c(decorView3, "window.decorView");
                iC = new d60(decorView3.getSystemUiVisibility()).a(8192);
            }
            decorView.setSystemUiVisibility(iC);
        }
    }
}
