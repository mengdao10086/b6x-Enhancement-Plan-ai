package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.a0;
import androidx.lifecycle.y;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import g.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
public class j extends Dialog implements y, q, androidx.savedstate.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public a0 f1367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final androidx.savedstate.c f1368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final OnBackPressedDispatcher f1369c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public j(@yt.k Context context) {
        this(context, 0, 2, null);
        f0.p(context, "context");
    }

    public /* synthetic */ j(Context context, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? 0 : i10);
    }

    public static /* synthetic */ void c() {
    }

    public static final void f(j this$0) {
        f0.p(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(@yt.k View view, @yt.l ViewGroup.LayoutParams layoutParams) {
        f0.p(view, "view");
        d();
        super.addContentView(view, layoutParams);
    }

    public final a0 b() {
        a0 a0Var = this.f1367a;
        if (a0Var != null) {
            return a0Var;
        }
        a0 a0Var2 = new a0(this);
        this.f1367a = a0Var2;
        return a0Var2;
    }

    public final void d() {
        Window window = getWindow();
        f0.m(window);
        View decorView = window.getDecorView();
        f0.o(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.b(decorView, this);
        Window window2 = getWindow();
        f0.m(window2);
        View decorView2 = window2.getDecorView();
        f0.o(decorView2, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.b(decorView2, this);
        Window window3 = getWindow();
        f0.m(window3);
        View decorView3 = window3.getDecorView();
        f0.o(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.b(decorView3, this);
    }

    @Override // androidx.lifecycle.y
    @yt.k
    public Lifecycle e() {
        return b();
    }

    @Override // androidx.savedstate.d
    @yt.k
    public androidx.savedstate.b l1() {
        return this.f1368b.b();
    }

    @Override // android.app.Dialog
    @g.i
    public void onBackPressed() {
        this.f1369c.f();
    }

    @Override // android.app.Dialog
    @g.i
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f1369c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            f0.o(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.g(onBackInvokedDispatcher);
        }
        this.f1368b.d(bundle);
        b().l(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    @yt.k
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        f0.o(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f1368b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    @g.i
    public void onStart() {
        super.onStart();
        b().l(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    @g.i
    public void onStop() {
        b().l(Lifecycle.Event.ON_DESTROY);
        this.f1367a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        d();
        super.setContentView(i10);
    }

    @Override // androidx.activity.q
    @yt.k
    public final OnBackPressedDispatcher t() {
        return this.f1369c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public j(@yt.k Context context, @d1 int i10) {
        super(context, i10);
        f0.p(context, "context");
        this.f1368b = androidx.savedstate.c.f7641d.a(this);
        this.f1369c = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                j.f(this.f1366a);
            }
        });
    }

    @Override // android.app.Dialog
    public void setContentView(@yt.k View view) {
        f0.p(view, "view");
        d();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(@yt.k View view, @yt.l ViewGroup.LayoutParams layoutParams) {
        f0.p(view, "view");
        d();
        super.setContentView(view, layoutParams);
    }
}
