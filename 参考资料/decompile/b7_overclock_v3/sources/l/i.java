package l;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import g.u;
import g.v0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class i implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f39334a;

    @v0(23)
    public static class a {
        @u
        public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        @u
        public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i10) {
            return callback.onWindowStartingActionMode(callback2, i10);
        }
    }

    @v0(24)
    public static class b {
        @u
        public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            callback.onProvideKeyboardShortcuts(list, menu, i10);
        }
    }

    @v0(26)
    public static class c {
        @u
        public static void a(Window.Callback callback, boolean z10) {
            callback.onPointerCaptureChanged(z10);
        }
    }

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f39334a = callback;
    }

    public final Window.Callback a() {
        return this.f39334a;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f39334a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f39334a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f39334a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f39334a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f39334a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f39334a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f39334a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f39334a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f39334a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f39334a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return this.f39334a.onCreatePanelMenu(i10, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i10) {
        return this.f39334a.onCreatePanelView(i10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f39334a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.f39334a.onMenuItemSelected(i10, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return this.f39334a.onMenuOpened(i10, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f39334a.onPanelClosed(i10, menu);
    }

    @Override // android.view.Window.Callback
    @v0(26)
    public void onPointerCaptureChanged(boolean z10) {
        c.a(this.f39334a, z10);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return this.f39334a.onPreparePanel(i10, view, menu);
    }

    @Override // android.view.Window.Callback
    @v0(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
        b.a(this.f39334a, list, menu, i10);
    }

    @Override // android.view.Window.Callback
    @v0(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f39334a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f39334a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        this.f39334a.onWindowFocusChanged(z10);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f39334a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f39334a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @v0(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return a.b(this.f39334a, callback, i10);
    }
}
