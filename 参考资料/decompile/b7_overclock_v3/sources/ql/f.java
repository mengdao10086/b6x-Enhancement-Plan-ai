package ql;

import android.app.Activity;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import g.v0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends ol.a {
    @Override // ol.a, ol.b
    @v0(api = 28)
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // ol.b
    @v0(api = 28)
    public boolean g(Window window) {
        DisplayCutout displayCutout;
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects() == null) ? false : true;
    }

    @Override // ol.a, ol.b
    @v0(api = 28)
    public void h(Activity activity, ol.d dVar) {
        super.h(activity, dVar);
        if (g(activity.getWindow())) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
            pl.b.i(activity.getWindow());
        }
    }

    @Override // ol.b
    @v0(api = 28)
    public int i(Window window) {
        DisplayCutout displayCutout;
        WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
        if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects() == null) {
            return 0;
        }
        return displayCutout.getSafeInsetTop();
    }
}
