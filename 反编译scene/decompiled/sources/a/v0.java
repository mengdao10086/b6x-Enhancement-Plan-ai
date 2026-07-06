package a;

import a.k3;
import a.xb;
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
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class v0 extends cl implements w0, xb.a {
    public x0 mDelegate;
    public Resources mResources;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().h(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        d0 supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // a.gb, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        d0 supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().k(i);
    }

    public x0 getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = x0.i(this, this);
        }
        return this.mDelegate;
    }

    public f0 getDrawerToggleDelegate() {
        return getDelegate().m();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().o();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && y8.b()) {
            this.mResources = new y8(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public d0 getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // a.xb.a
    public Intent getSupportParentActivityIntent() {
        return hb.a(this);
    }

    public final boolean h(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // a.cl, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().s(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        x0 delegate = getDelegate();
        delegate.q();
        delegate.t(bundle);
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(xb xbVar) {
        xbVar.b(this);
    }

    @Override // a.cl, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (h(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // a.cl, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        d0 supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // a.cl, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().v(bundle);
    }

    @Override // a.cl, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    public void onPrepareSupportNavigateUpTaskStack(xb xbVar) {
    }

    @Override // a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().x(bundle);
    }

    @Override // a.cl, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().y();
    }

    @Override // a.cl, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().z();
    }

    @Override // a.w0
    public void onSupportActionModeFinished(k3 k3Var) {
    }

    @Override // a.w0
    public void onSupportActionModeStarted(k3 k3Var) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        xb xbVarD = xb.d(this);
        onCreateSupportNavigateUpTaskStack(xbVarD);
        onPrepareSupportNavigateUpTaskStack(xbVarD);
        xbVarD.e();
        try {
            va.h(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().K(charSequence);
    }

    @Override // a.w0
    public k3 onWindowStartingSupportActionMode(k3.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        d0 supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        getDelegate().D(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        getDelegate().E(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().F(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().I(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        getDelegate().J(i);
    }

    public k3 startSupportActionMode(k3.a aVar) {
        return getDelegate().L(aVar);
    }

    @Override // a.cl
    public void supportInvalidateOptionsMenu() {
        getDelegate().r();
    }

    public void supportNavigateUpTo(Intent intent) {
        hb.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().C(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return hb.f(this, intent);
    }
}
