package ql;

import android.app.Activity;
import android.view.Window;
import g.v0;

/* JADX INFO: loaded from: classes5.dex */
public class d extends ol.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f47447a = "d";

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void a(Activity activity, ol.d dVar) {
        super.a(activity, dVar);
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void e(Activity activity, ol.d dVar) {
        h(activity, dVar);
    }

    @Override // ol.a, ol.b
    public void f(Activity activity, ol.d dVar) {
        super.f(activity, dVar);
    }

    @Override // ol.b
    @v0(api = 26)
    public boolean g(Window window) {
        if (window == null) {
            return false;
        }
        return window.getContext().getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    @Override // ol.a, ol.b
    @v0(api = 26)
    public void h(Activity activity, ol.d dVar) {
        super.h(activity, dVar);
        if (g(activity.getWindow())) {
            pl.b.i(activity.getWindow());
        }
    }

    @Override // ol.b
    @v0(api = 26)
    public int i(Window window) {
        if (g(window)) {
            return pl.b.c(window.getContext());
        }
        return 0;
    }
}
