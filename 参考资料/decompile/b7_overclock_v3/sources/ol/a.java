package ol;

import android.app.Activity;
import android.view.Window;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements b {
    @Override // ol.b
    public void a(Activity activity, d dVar) {
        pl.b.f(activity.getWindow(), false);
        k(activity, dVar);
        if (g(activity.getWindow())) {
            pl.b.e(activity.getWindow());
        }
    }

    @Override // ol.b
    public void b(Activity activity) {
        c(activity, null);
    }

    @Override // ol.b
    public void c(Activity activity, d dVar) {
        pl.b.e(activity.getWindow());
        pl.b.g(activity.getWindow(), dVar);
    }

    @Override // ol.b
    public int d(Window window) {
        return pl.b.c(window.getContext());
    }

    @Override // ol.b
    public void e(Activity activity, d dVar) {
        h(activity, dVar);
    }

    @Override // ol.b
    public void f(Activity activity, d dVar) {
        pl.b.f(activity.getWindow(), false);
        j(activity, i(activity.getWindow()), dVar);
    }

    @Override // ol.b
    public void h(Activity activity, d dVar) {
        pl.b.f(activity.getWindow(), false);
        k(activity, dVar);
    }

    public void j(Activity activity, int i10, d dVar) {
        if (dVar != null) {
            c cVar = new c();
            cVar.g(i(activity.getWindow()));
            cVar.f(g(activity.getWindow()));
            cVar.e(i10);
            dVar.a(cVar);
        }
    }

    public void k(Activity activity, d dVar) {
        if (dVar != null) {
            c cVar = new c();
            cVar.g(i(activity.getWindow()));
            cVar.f(g(activity.getWindow()));
            dVar.a(cVar);
        }
    }
}
