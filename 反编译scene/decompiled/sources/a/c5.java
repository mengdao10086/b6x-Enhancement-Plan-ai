package a;

import a.i4;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c5 extends i4 implements SubMenu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i4 f5760a;
    public l4 b;

    public c5(Context context, i4 i4Var, l4 l4Var) {
        super(context);
        this.f5760a = i4Var;
        this.b = l4Var;
    }

    @Override // a.i4
    public i4 D() {
        return this.f5760a.D();
    }

    @Override // a.i4
    public boolean F() {
        return this.f5760a.F();
    }

    @Override // a.i4
    public boolean G() {
        return this.f5760a.G();
    }

    @Override // a.i4
    public boolean H() {
        return this.f5760a.H();
    }

    @Override // a.i4
    public void R(i4.a aVar) {
        this.f5760a.R(aVar);
    }

    public Menu e0() {
        return this.f5760a;
    }

    @Override // a.i4
    public boolean f(l4 l4Var) {
        return this.f5760a.f(l4Var);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.b;
    }

    @Override // a.i4
    public boolean h(i4 i4Var, MenuItem menuItem) {
        return super.h(i4Var, menuItem) || this.f5760a.h(i4Var, menuItem);
    }

    @Override // a.i4
    public boolean k(l4 l4Var) {
        return this.f5760a.k(l4Var);
    }

    @Override // a.i4, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f5760a.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        super.U(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.V(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        super.X(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.Y(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        super.Z(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.b.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.b.setIcon(drawable);
        return this;
    }

    @Override // a.i4, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f5760a.setQwertyMode(z);
    }

    @Override // a.i4
    public String t() {
        l4 l4Var = this.b;
        int itemId = l4Var != null ? l4Var.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }
}
