package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x4 extends y3 implements Menu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qd f7852a;

    public x4(Context context, qd qdVar) {
        super(context);
        if (qdVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f7852a = qdVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return e(this.f7852a.add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return e(this.f7852a.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return e(this.f7852a.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return e(this.f7852a.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f7852a.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = e(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        SubMenu subMenuAddSubMenu = this.f7852a.addSubMenu(i);
        f(subMenuAddSubMenu);
        return subMenuAddSubMenu;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        SubMenu subMenuAddSubMenu = this.f7852a.addSubMenu(i, i2, i3, i4);
        f(subMenuAddSubMenu);
        return subMenuAddSubMenu;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        SubMenu subMenuAddSubMenu = this.f7852a.addSubMenu(i, i2, i3, charSequence);
        f(subMenuAddSubMenu);
        return subMenuAddSubMenu;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        SubMenu subMenuAddSubMenu = this.f7852a.addSubMenu(charSequence);
        f(subMenuAddSubMenu);
        return subMenuAddSubMenu;
    }

    @Override // android.view.Menu
    public void clear() {
        g();
        this.f7852a.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f7852a.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return e(this.f7852a.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return e(this.f7852a.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f7852a.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f7852a.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f7852a.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f7852a.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        h(i);
        this.f7852a.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        i(i);
        this.f7852a.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f7852a.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f7852a.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f7852a.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f7852a.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f7852a.size();
    }
}
