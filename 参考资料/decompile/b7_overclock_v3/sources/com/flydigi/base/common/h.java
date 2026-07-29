package com.flydigi.base.common;

import android.content.Context;
import bin.mt.signature.KillerApplication;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.mmkv.MMKV;
import io.reactivex.exceptions.UndeliverableException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class h extends KillerApplication {
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new mg.b() { // from class: com.flydigi.base.common.g
            @Override // mg.b
            public final mg.g a(Context context, mg.j jVar) {
                return h.j(context, jVar);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new mg.a() { // from class: com.flydigi.base.common.f
            @Override // mg.a
            public final mg.f a(Context context, mg.j jVar) {
                return h.k(context, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        x9.c.b(this, str);
    }

    public static /* synthetic */ void i(Throwable th2) throws Exception {
        if ((th2 instanceof UndeliverableException) || (th2 instanceof IOException) || (th2 instanceof InterruptedException)) {
            return;
        }
        if ((th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException)) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th2);
        } else if (th2 instanceof IllegalStateException) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th2);
        }
    }

    public static /* synthetic */ mg.g j(Context context, mg.j jVar) {
        return new pg.b(context);
    }

    public static /* synthetic */ mg.f k(Context context, mg.j jVar) {
        return new og.b(context).z(20.0f);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        androidx.multidex.b.l(context);
        String.format("%s attachBaseContext", getClass().getSimpleName());
    }

    public void l() {
        if (tt.c.f().o(this)) {
            return;
        }
        tt.c.f().v(this);
    }

    public final void m() {
        kj.a.k0(new dj.g() { // from class: com.flydigi.base.common.e
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                h.i((Throwable) obj);
            }
        });
    }

    public void n() {
        tt.c.f().A(this);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        String.format("%s onCreate", getClass().getSimpleName());
        m();
        MMKV.initialize(this, new MMKV.LibLoader() { // from class: com.flydigi.base.common.d
            @Override // com.tencent.mmkv.MMKV.LibLoader
            public final void loadLibrary(String str) {
                this.f13338a.h(str);
            }
        });
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        String.format("%s onLowMemory", getClass().getSimpleName());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        String.format("%s onTerminate", getClass().getSimpleName());
        n();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        String.format("%s onTrimMemory(%d)", getClass().getSimpleName(), Integer.valueOf(i10));
    }
}
