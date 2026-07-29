package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class m extends e implements SubMenu {
    public e Q;
    public h R;

    public m(Context context, e eVar, h hVar) {
        super(context);
        this.Q = eVar;
        this.R = hVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public e G() {
        return this.Q.G();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean I() {
        return this.Q.I();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean J() {
        return this.Q.J();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean K() {
        return this.Q.K();
    }

    @Override // androidx.appcompat.view.menu.e
    public void X(e.a aVar) {
        this.Q.X(aVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean g(h hVar) {
        return this.Q.g(hVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.R;
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean i(@n0 e eVar, @n0 MenuItem menuItem) {
        return super.i(eVar, menuItem) || this.Q.i(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public void j0(boolean z10) {
        this.Q.j0(z10);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean n(h hVar) {
        return this.Q.n(hVar);
    }

    public Menu n0() {
        return this.Q;
    }

    @Override // androidx.appcompat.view.menu.e, r0.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.Q.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.c0(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.f0(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.g0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.R.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.Q.setQwertyMode(z10);
    }

    @Override // androidx.appcompat.view.menu.e
    public String w() {
        h hVar = this.R;
        int itemId = hVar != null ? hVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.w() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.b0(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.e0(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.R.setIcon(i10);
        return this;
    }
}
