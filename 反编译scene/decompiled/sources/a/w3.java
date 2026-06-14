package a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w3 implements rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f7750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f3364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Intent f3365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f3368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3369a;
    public char b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f3371b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f3372b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f3374c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f3375d;
    public int d = 4096;
    public int e = 4096;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f3366a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f3367a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3370a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3373b = false;
    public int f = 16;

    public w3(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f3364a = context;
        this.f3363a = i2;
        this.f3371b = i;
        this.c = i4;
        this.f3369a = charSequence;
    }

    @Override // a.rd
    public rd a(CharSequence charSequence) {
        this.f3375d = charSequence;
        return this;
    }

    @Override // a.rd
    public rd b(CharSequence charSequence) {
        this.f3374c = charSequence;
        return this;
    }

    @Override // a.rd
    public uf c() {
        return null;
    }

    @Override // a.rd, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // a.rd
    public rd d(uf ufVar) {
        throw new UnsupportedOperationException();
    }

    public final void e() {
        if (this.f3368a != null) {
            if (this.f3370a || this.f3373b) {
                Drawable drawableR = kd.r(this.f3368a);
                this.f3368a = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f3368a = drawableMutate;
                if (this.f3370a) {
                    kd.o(drawableMutate, this.f3366a);
                }
                if (this.f3373b) {
                    kd.p(this.f3368a, this.f3367a);
                }
            }
        }
    }

    @Override // a.rd, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    public rd f(int i) {
        throw new UnsupportedOperationException();
    }

    public rd g(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // a.rd, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // a.rd, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.b;
    }

    @Override // a.rd, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3374c;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3371b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3368a;
    }

    @Override // a.rd, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3366a;
    }

    @Override // a.rd, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3367a;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3365a;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3363a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // a.rd, android.view.MenuItem
    public int getNumericModifiers() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f7750a;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3369a;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3372b;
        return charSequence != null ? charSequence : this.f3369a;
    }

    @Override // a.rd, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3375d;
    }

    public rd h(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // a.rd, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        f(i);
        throw null;
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        g(view);
        throw null;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.b = Character.toLowerCase(c);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.b = Character.toLowerCase(c);
        this.e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f = (z ? 1 : 0) | (this.f & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f = (z ? 2 : 0) | (this.f & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        b(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f = (z ? 16 : 0) | (this.f & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f3368a = yb.d(this.f3364a, i);
        e();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3368a = drawable;
        e();
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3366a = colorStateList;
        this.f3370a = true;
        e();
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3367a = mode;
        this.f3373b = true;
        e();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3365a = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f7750a = c;
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f7750a = c;
        this.d = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f7750a = c;
        this.b = Character.toLowerCase(c2);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f7750a = c;
        this.d = KeyEvent.normalizeMetaState(i);
        this.b = Character.toLowerCase(c2);
        this.e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        h(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f3369a = this.f3364a.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3369a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3372b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f = (this.f & 8) | (z ? 0 : 8);
        return this;
    }
}
