package nl;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import ql.e;
import ql.f;
import ql.g;
import ql.h;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f42220d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f42221e = "notch_container";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f42222f = "toolbar_container";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42223g = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f42224h = 28;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ol.b f42225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f42226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42227c;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f42228a;

        public a(Activity activity) {
            this.f42228a = activity;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.b(this.f42228a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: renamed from: nl.b$b, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0476b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f42230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ol.d f42231b;

        public ViewOnAttachStateChangeListenerC0476b(Activity activity, ol.d dVar) {
            this.f42230a = activity;
            this.f42231b = dVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.c(this.f42230a, this.f42231b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f42233a;

        public c(Activity activity) {
            this.f42233a = activity;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.g(this.f42233a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f42235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ol.d f42236b;

        public d(Activity activity, ol.d dVar) {
            this.f42235a = activity;
            this.f42236b = dVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.h(this.f42235a, this.f42236b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static b l() {
        pl.b.f46702b = true;
        if (f42220d == null) {
            synchronized (b.class) {
                if (f42220d == null) {
                    f42220d = new b();
                }
            }
        }
        return f42220d;
    }

    public final void a(Window window) {
        if (this.f42225a != null) {
            return;
        }
        int i10 = f42223g;
        if (i10 < 26) {
            this.f42225a = new ql.a();
            return;
        }
        pl.a aVarA = pl.a.a();
        if (i10 >= 28) {
            if (aVarA.c()) {
                this.f42225a = new e();
                return;
            } else {
                this.f42225a = new f();
                return;
            }
        }
        if (aVarA.c()) {
            this.f42225a = new ql.b();
            return;
        }
        if (aVarA.d()) {
            this.f42225a = new ql.c();
            return;
        }
        if (aVarA.g()) {
            this.f42225a = new h();
            return;
        }
        if (aVarA.e()) {
            this.f42225a = new ql.d();
        } else if (aVarA.f()) {
            this.f42225a = new g();
        } else {
            this.f42225a = new ql.a();
        }
    }

    public void b(Activity activity) {
        c(activity, null);
    }

    public void c(Activity activity, ol.d dVar) {
        if (this.f42225a == null) {
            a(activity.getWindow());
        }
        if (this.f42225a == null) {
            return;
        }
        if (p(activity)) {
            this.f42225a.e(activity, dVar);
        } else {
            this.f42225a.a(activity, dVar);
        }
    }

    public void d(Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new a(activity));
    }

    public void e(Activity activity, ol.d dVar) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0476b(activity, dVar));
    }

    public void f(Activity activity) {
        b(activity);
    }

    public void g(Activity activity) {
        h(activity, null);
    }

    public void h(Activity activity, ol.d dVar) {
        if (this.f42225a == null) {
            a(activity.getWindow());
        }
        ol.b bVar = this.f42225a;
        if (bVar != null) {
            bVar.f(activity, dVar);
        }
    }

    public void i(Activity activity) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(activity));
    }

    public void j(Activity activity, ol.d dVar) {
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new d(activity, dVar));
    }

    public void k(Activity activity) {
        g(activity);
    }

    public int m(Window window) {
        if (this.f42225a == null) {
            a(window);
        }
        ol.b bVar = this.f42225a;
        if (bVar == null) {
            return 0;
        }
        return bVar.i(window);
    }

    public int n(Window window) {
        return pl.b.c(window.getContext());
    }

    public boolean o(Window window) {
        if (!this.f42226b) {
            if (this.f42225a == null) {
                a(window);
            }
            ol.b bVar = this.f42225a;
            if (bVar == null) {
                this.f42226b = true;
                this.f42227c = false;
            } else {
                this.f42227c = bVar.g(window);
            }
        }
        return this.f42227c;
    }

    public final boolean p(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 1;
    }

    public b q(boolean z10) {
        pl.b.f46702b = z10;
        return this;
    }

    public void r(Activity activity) {
        if (this.f42225a == null) {
            a(activity.getWindow());
        }
        ol.b bVar = this.f42225a;
        if (bVar != null) {
            bVar.b(activity);
        }
    }

    public void s(Activity activity, ol.d dVar) {
        if (this.f42225a == null) {
            a(activity.getWindow());
        }
        ol.b bVar = this.f42225a;
        if (bVar != null) {
            bVar.c(activity, dVar);
        }
    }
}
