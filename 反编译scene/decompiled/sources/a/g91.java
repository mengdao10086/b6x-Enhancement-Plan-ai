package a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.omarea.Scene;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g91 extends v0 {
    public HashMap _$_findViewCache;
    public Context ctx;
    public x90 themeMode;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6184a = new a();

        @Override // java.lang.Runnable
        public final void run() {
            System.gc();
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityBase$onDestroy$2", f = "ActivityBase.kt", l = {115, 116}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wd2 f983a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f984a;
        public int b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = g91.this.new b(b62Var);
            bVar.f983a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            wd2 wd2Var;
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2Var = this.f983a;
                this.f984a = wd2Var;
                this.b = 1;
                if (ke2.a(1000L, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    h42.b(obj);
                    return m42.f6769a;
                }
                wd2Var = (wd2) this.f984a;
                h42.b(obj);
            }
            e50 e50Var = e50.f677a;
            String packageName = g91.this.getContext().getPackageName();
            f92.c(packageName, "context.packageName");
            String[] strArr = {packageName};
            this.f984a = wd2Var;
            this.b = 2;
            if (e50Var.V("meminfo", strArr, this) == objC) {
                return objC;
            }
            return m42.f6769a;
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g91.this.onBackPressed();
        }
    }

    public static /* synthetic */ void i(g91 g91Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fullScreen");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        g91Var.fullScreen(z);
    }

    @Override // a.v0, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        f92.d(context, "newBase");
        Context contextA = wk0.f7798a.a(context);
        this.ctx = contextA;
        if (contextA != null) {
            super.attachBaseContext(contextA);
        } else {
            f92.m("ctx");
            throw null;
        }
    }

    public final void excludeFromRecent() {
        try {
            Object systemService = getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            for (ActivityManager.AppTask appTask : ((ActivityManager) systemService).getAppTasks()) {
                f92.c(appTask, "task");
                if (appTask.getTaskInfo().id == getTaskId()) {
                    appTask.setExcludeFromRecents(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void fullScreen(boolean z) {
        Window window = getWindow();
        f92.c(window, "window");
        ki kiVarI = eh.I(window.getDecorView());
        if (z) {
            if (kiVarI != null) {
                kiVarI.a(di.d());
            }
            if (kiVarI != null) {
                kiVarI.a(di.c());
            }
            q32.a().c(this);
            return;
        }
        if (kiVarI != null) {
            kiVarI.b(di.d());
        }
        if (kiVarI != null) {
            kiVarI.b(di.c());
        }
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context context = this.ctx;
        if (context != null) {
            return context;
        }
        f92.m("ctx");
        throw null;
    }

    public final Context getContext() {
        return this;
    }

    @Override // a.v0, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Context context = this.ctx;
        if (context == null) {
            f92.m("ctx");
            throw null;
        }
        Resources resources = context.getResources();
        f92.c(resources, "ctx.resources");
        return resources;
    }

    public final x90 getThemeMode() {
        x90 x90Var = this.themeMode;
        if (x90Var != null) {
            return x90Var;
        }
        f92.m("themeMode");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishAfterTransition();
    }

    @Override // a.v0, a.cl, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        f92.d(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        this.themeMode = gh1.f1013a.k(this);
    }

    @Override // a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        nk0.f6926a.a(this);
        super.onCreate(bundle);
        this.themeMode = gh1.f1013a.k(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        nk0.f6926a.a(this);
        super.onCreate(bundle, persistableBundle);
        this.themeMode = gh1.f1013a.k(this);
    }

    @Override // a.v0, a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d41.f480a.h(this);
        Scene.f4798a.j(a.f6184a, 500L);
        if (isTaskRoot() && (!f92.a(e50.f677a.y0(), "basic"))) {
            qc2.d(xd2.a(qe2.b()), null, null, new b(null), 3, null);
        }
    }

    @Override // a.cl, android.app.Activity
    public void onPause() {
        View decorView;
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.destroyDrawingCache();
        }
        super.onPause();
    }

    @Override // a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void setBackArrow() {
        View viewFindViewById = findViewById(t61.toolbar);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        }
        Toolbar toolbar = (Toolbar) viewFindViewById;
        setSupportActionBar(toolbar);
        d0 supportActionBar = getSupportActionBar();
        f92.b(supportActionBar);
        supportActionBar.t(true);
        d0 supportActionBar2 = getSupportActionBar();
        f92.b(supportActionBar2);
        supportActionBar2.s(true);
        toolbar.setNavigationOnClickListener(new c());
    }

    public final void setThemeMode(x90 x90Var) {
        f92.d(x90Var, "<set-?>");
        this.themeMode = x90Var;
    }
}
