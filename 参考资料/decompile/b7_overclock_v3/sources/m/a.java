package m;

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
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a implements r0.c {
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 4;
    public static final int I = 8;
    public static final int J = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f40483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f40484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f40485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f40486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f40487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Intent f40488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public char f40489r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public char f40491t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f40493v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f40494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f40495x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f40496y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f40497z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f40490s = 4096;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f40492u = 4096;
    public ColorStateList A = null;
    public PorterDuff.Mode B = null;
    public boolean C = false;
    public boolean D = false;
    public int E = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f40494w = context;
        this.f40483l = i11;
        this.f40484m = i10;
        this.f40485n = i13;
        this.f40486o = charSequence;
    }

    @Override // r0.c
    @n0
    public r0.c a(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // r0.c
    public androidx.core.view.b b() {
        return null;
    }

    @Override // r0.c
    public boolean c() {
        return false;
    }

    @Override // r0.c, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // r0.c
    public boolean d() {
        return true;
    }

    public final void e() {
        Drawable drawable = this.f40493v;
        if (drawable != null) {
            if (this.C || this.D) {
                Drawable drawableR = n0.c.r(drawable);
                this.f40493v = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f40493v = drawableMutate;
                if (this.C) {
                    n0.c.o(drawableMutate, this.A);
                }
                if (this.D) {
                    n0.c.p(this.f40493v, this.B);
                }
            }
        }
    }

    @Override // r0.c, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    public boolean f() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f40495x;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.f40488q;
        if (intent == null) {
            return false;
        }
        this.f40494w.startActivity(intent);
        return true;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public r0.c setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // r0.c, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // r0.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f40492u;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f40491t;
    }

    @Override // r0.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f40496y;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f40484m;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f40493v;
    }

    @Override // r0.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.A;
    }

    @Override // r0.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.B;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f40488q;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f40483l;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // r0.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f40490s;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f40489r;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f40485n;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f40486o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f40487p;
        return charSequence != null ? charSequence : this.f40486o;
    }

    @Override // r0.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f40497z;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public r0.c setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public a i(boolean z10) {
        this.E = (z10 ? 4 : 0) | (this.E & (-5));
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.E & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.E & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.E & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.E & 8) == 0;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public r0.c setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f40491t = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.E = (z10 ? 1 : 0) | (this.E & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.E = (z10 ? 2 : 0) | (this.E & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.E = (z10 ? 16 : 0) | (this.E & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f40493v = drawable;
        e();
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setIconTintList(@p0 ColorStateList colorStateList) {
        this.A = colorStateList;
        this.C = true;
        e();
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.B = mode;
        this.D = true;
        e();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f40488q = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f40489r = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f40495x = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f40489r = c10;
        this.f40491t = Character.toLowerCase(c11);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f40486o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f40487p = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.E = (this.E & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f40491t = Character.toLowerCase(c10);
        this.f40492u = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public r0.c setContentDescription(CharSequence charSequence) {
        this.f40496y = charSequence;
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f40489r = c10;
        this.f40490s = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f40486o = this.f40494w.getResources().getString(i10);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public r0.c setTooltipText(CharSequence charSequence) {
        this.f40497z = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f40493v = h0.d.i(this.f40494w, i10);
        e();
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f40489r = c10;
        this.f40490s = KeyEvent.normalizeMetaState(i10);
        this.f40491t = Character.toLowerCase(c11);
        this.f40492u = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
