package a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r4 extends y3 implements MenuItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd f7268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Method f2706a;

    public r4(Context context, rd rdVar) {
        super(context);
        if (rdVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f7268a = rdVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f7268a.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f7268a.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        uf ufVarC = this.f7268a.c();
        if (ufVarC instanceof m4) {
            return ((m4) ufVarC).f1887a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f7268a.getActionView();
        return actionView instanceof o4 ? ((o4) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f7268a.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f7268a.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f7268a.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f7268a.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f7268a.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f7268a.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f7268a.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f7268a.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f7268a.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f7268a.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f7268a.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f7268a.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f7268a.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        SubMenu subMenu = this.f7268a.getSubMenu();
        f(subMenu);
        return subMenu;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f7268a.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f7268a.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f7268a.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f7268a.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f7268a.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f7268a.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f7268a.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f7268a.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f7268a.isVisible();
    }

    public void j(boolean z) {
        try {
            if (this.f2706a == null) {
                this.f2706a = this.f7268a.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f2706a.invoke(this.f7268a, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        uf n4Var = Build.VERSION.SDK_INT >= 16 ? new n4(this, ((y3) this).f3652a, actionProvider) : new m4(this, ((y3) this).f3652a, actionProvider);
        rd rdVar = this.f7268a;
        if (actionProvider == null) {
            n4Var = null;
        }
        rdVar.d(n4Var);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f7268a.setActionView(i);
        View actionView = this.f7268a.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f7268a.setActionView(new o4(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new o4(view);
        }
        this.f7268a.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f7268a.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f7268a.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f7268a.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f7268a.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f7268a.b(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f7268a.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f7268a.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f7268a.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7268a.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7268a.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f7268a.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f7268a.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f7268a.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f7268a.setOnActionExpandListener(onActionExpandListener != null ? new p4(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7268a.setOnMenuItemClickListener(onMenuItemClickListener != null ? new q4(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f7268a.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f7268a.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f7268a.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f7268a.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f7268a.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f7268a.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7268a.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f7268a.a(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f7268a.setVisible(z);
    }
}
