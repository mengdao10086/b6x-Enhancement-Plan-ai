package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g1;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.b;
import f0.l0;
import g.d0;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
public class f extends androidx.fragment.app.g implements g, l0.b, c.InterfaceC0029c {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f1633k0 = "androidx:appcompat";
    public h C;
    public Resources D;

    public class a implements b.c {
        public a() {
        }

        @Override // androidx.savedstate.b.c
        @n0
        public Bundle a() {
            Bundle bundle = new Bundle();
            f.this.H3().D(bundle);
            return bundle;
        }
    }

    public class b implements e.c {
        public b() {
        }

        @Override // e.c
        public void a(@n0 Context context) {
            h hVarH3 = f.this.H3();
            hVarH3.u();
            hVarH3.z(f.this.l1().b(f.f1633k0));
        }
    }

    public f() {
        J3();
    }

    private void d3() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.b(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.b(getWindow().getDecorView(), this);
    }

    @Override // f0.l0.b
    @p0
    public Intent D0() {
        return f0.r.a(this);
    }

    @Override // androidx.fragment.app.g
    public void E3() {
        H3().v();
    }

    @Override // androidx.appcompat.app.g
    @g.i
    public void F2(@n0 l.b bVar) {
    }

    @n0
    public h H3() {
        if (this.C == null) {
            this.C = h.i(this, this);
        }
        return this.C;
    }

    @p0
    public androidx.appcompat.app.a I3() {
        return H3().s();
    }

    public final void J3() {
        l1().j(f1633k0, new a());
        r0(new b());
    }

    public void K3(@n0 l0 l0Var) {
        l0Var.d(this);
    }

    public void L3(int i10) {
    }

    public void M3(@n0 l0 l0Var) {
    }

    @Deprecated
    public void N3() {
    }

    public boolean O3() {
        Intent intentD0 = D0();
        if (intentD0 == null) {
            return false;
        }
        if (!Y3(intentD0)) {
            W3(intentD0);
            return true;
        }
        l0 l0VarG = l0.g(this);
        K3(l0VarG);
        M3(l0VarG);
        l0VarG.r();
        try {
            f0.b.z(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public final boolean P3(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public void Q3(@p0 Toolbar toolbar) {
        H3().Q(toolbar);
    }

    @Deprecated
    public void R3(int i10) {
    }

    @Override // androidx.appcompat.app.g
    @g.i
    public void S(@n0 l.b bVar) {
    }

    @Deprecated
    public void S3(boolean z10) {
    }

    @Deprecated
    public void T3(boolean z10) {
    }

    @Deprecated
    public void U3(boolean z10) {
    }

    @p0
    public l.b V3(@n0 b.a aVar) {
        return H3().T(aVar);
    }

    public void W3(@n0 Intent intent) {
        f0.r.g(this, intent);
    }

    public boolean X3(int i10) {
        return H3().I(i10);
    }

    public boolean Y3(@n0 Intent intent) {
        return f0.r.h(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d3();
        H3().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(H3().h(context));
    }

    @Override // androidx.appcompat.app.g
    @p0
    public l.b c2(@n0 b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a aVarI3 = I3();
        if (getWindow().hasFeature(0)) {
            if (aVarI3 == null || !aVarI3.l()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // f0.l, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a aVarI3 = I3();
        if (keyCode == 82 && aVarI3 != null && aVarI3.L(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(@d0 int i10) {
        return (T) H3().n(i10);
    }

    @Override // androidx.appcompat.app.c.InterfaceC0029c
    @p0
    public c.b g() {
        return H3().p();
    }

    @Override // android.app.Activity
    @n0
    public MenuInflater getMenuInflater() {
        return H3().r();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.D == null && g1.d()) {
            this.D = new g1(this, super.getResources());
        }
        Resources resources = this.D;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        H3().v();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@n0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        H3().y(configuration);
        if (this.D != null) {
            this.D.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        N3();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        H3().A();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (P3(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, @n0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a aVarI3 = I3();
        if (menuItem.getItemId() != 16908332 || aVarI3 == null || (aVarI3.p() & 4) == 0) {
            return false;
        }
        return O3();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, @n0 Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(@p0 Bundle bundle) {
        super.onPostCreate(bundle);
        H3().B(bundle);
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        H3().C();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        H3().E();
    }

    @Override // androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        H3().F();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        H3().S(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a aVarI3 = I3();
        if (getWindow().hasFeature(0)) {
            if (aVarI3 == null || !aVarI3.M()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@i0 int i10) {
        d3();
        H3().K(i10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@d1 int i10) {
        super.setTheme(i10);
        H3().R(i10);
    }

    @g.o
    public f(@i0 int i10) {
        super(i10);
        J3();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        d3();
        H3().L(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d3();
        H3().M(view, layoutParams);
    }
}
