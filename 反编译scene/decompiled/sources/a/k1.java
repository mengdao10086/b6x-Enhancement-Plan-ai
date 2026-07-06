package a;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k1 extends v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f6562a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(w1 w1Var, Window.Callback callback) {
        super(callback);
        this.f6562a = w1Var;
    }

    public final ActionMode b(ActionMode.Callback callback) {
        o3 o3Var = new o3(this.f6562a.f3335a, callback);
        k3 k3VarL = this.f6562a.L(o3Var);
        if (k3VarL != null) {
            return o3Var.e(k3VarL);
        }
        return null;
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6562a.Z(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.f6562a.x0(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // a.v3, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof i4)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.f6562a.A0(i);
        return true;
    }

    @Override // a.v3, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.f6562a.B0(i);
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        i4 i4Var = menu instanceof i4 ? (i4) menu : null;
        if (i == 0 && i4Var == null) {
            return false;
        }
        if (i4Var != null) {
            i4Var.a0(true);
        }
        boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
        if (i4Var != null) {
            i4Var.a0(false);
        }
        return zOnPreparePanel;
    }

    @Override // a.v3, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        i4 i4Var;
        u1 u1VarJ0 = this.f6562a.j0(0, true);
        if (u1VarJ0 == null || (i4Var = u1VarJ0.f3094a) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, i4Var, i);
        }
    }

    @Override // a.v3, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        return this.f6562a.s0() ? b(callback) : super.onWindowStartingActionMode(callback);
    }

    @Override // a.v3, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return (this.f6562a.s0() && i == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i);
    }
}
