package m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class e extends b implements Menu {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r0.a f40514o;

    public e(Context context, r0.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f40514o = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return e(this.f40514o.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f40514o.addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr[i14] = e(menuItemArr2[i14]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return f(this.f40514o.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        g();
        this.f40514o.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f40514o.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        return e(this.f40514o.findItem(i10));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return e(this.f40514o.getItem(i10));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f40514o.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return this.f40514o.isShortcutKey(i10, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return this.f40514o.performIdentifierAction(i10, i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return this.f40514o.performShortcut(i10, keyEvent, i11);
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        h(i10);
        this.f40514o.removeGroup(i10);
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        i(i10);
        this.f40514o.removeItem(i10);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        this.f40514o.setGroupCheckable(i10, z10, z11);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        this.f40514o.setGroupEnabled(i10, z10);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        this.f40514o.setGroupVisible(i10, z10);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f40514o.setQwertyMode(z10);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f40514o.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return e(this.f40514o.add(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return f(this.f40514o.addSubMenu(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return e(this.f40514o.add(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return f(this.f40514o.addSubMenu(i10, i11, i12, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return e(this.f40514o.add(i10, i11, i12, i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return f(this.f40514o.addSubMenu(i10, i11, i12, i13));
    }
}
