package a;

import a.w4;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l4 implements rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f6671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c5 f1730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f1731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uf f1732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Intent f1733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ContextMenu.ContextMenuInfo f1737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MenuItem.OnActionExpandListener f1738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MenuItem.OnMenuItemClickListener f1739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1742a;
    public char b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f1744b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f1745b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f1747c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f1749d;
    public int i;
    public int e = 4096;
    public int f = 4096;
    public int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1734a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f1735a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1743a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1746b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1748c = false;
    public int h = 16;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1750d = false;

    public l4(i4 i4Var, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.i = 0;
        this.f1731a = i4Var;
        this.f1729a = i2;
        this.f1744b = i;
        this.c = i3;
        this.d = i4;
        this.f1741a = charSequence;
        this.i = i5;
    }

    public static void f(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public boolean A(boolean z) {
        int i = this.h;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.h = i2;
        return i != i2;
    }

    public boolean B() {
        return this.f1731a.A();
    }

    public boolean C() {
        return this.f1731a.H() && i() != 0;
    }

    public boolean D() {
        return (this.i & 4) == 4;
    }

    @Override // a.rd
    public rd a(CharSequence charSequence) {
        this.f1749d = charSequence;
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd
    public rd b(CharSequence charSequence) {
        this.f1747c = charSequence;
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd
    public uf c() {
        return this.f1732a;
    }

    @Override // a.rd, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.i & 8) == 0) {
            return false;
        }
        if (this.f1740a == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1738a;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1731a.f(this);
        }
        return false;
    }

    @Override // a.rd
    public rd d(uf ufVar) {
        uf ufVar2 = this.f1732a;
        if (ufVar2 != null) {
            ufVar2.h();
        }
        this.f1740a = null;
        this.f1732a = ufVar;
        this.f1731a.K(true);
        uf ufVar3 = this.f1732a;
        if (ufVar3 != null) {
            ufVar3.j(new k4(this));
        }
        return this;
    }

    public void e() {
        this.f1731a.I(this);
    }

    @Override // a.rd, android.view.MenuItem
    public boolean expandActionView() {
        if (!l()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1738a;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1731a.k(this);
        }
        return false;
    }

    public final Drawable g(Drawable drawable) {
        if (drawable != null && this.f1748c && (this.f1743a || this.f1746b)) {
            drawable = kd.r(drawable).mutate();
            if (this.f1743a) {
                kd.o(drawable, this.f1734a);
            }
            if (this.f1746b) {
                kd.p(drawable, this.f1735a);
            }
            this.f1748c = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // a.rd, android.view.MenuItem
    public View getActionView() {
        View view = this.f1740a;
        if (view != null) {
            return view;
        }
        uf ufVar = this.f1732a;
        if (ufVar == null) {
            return null;
        }
        View viewD = ufVar.d(this);
        this.f1740a = viewD;
        return viewD;
    }

    @Override // a.rd, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.b;
    }

    @Override // a.rd, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1747c;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1744b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1736a;
        if (drawable != null) {
            return g(drawable);
        }
        if (this.g == 0) {
            return null;
        }
        Drawable drawableD = r2.d(this.f1731a.u(), this.g);
        this.g = 0;
        this.f1736a = drawableD;
        return g(drawableD);
    }

    @Override // a.rd, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1734a;
    }

    @Override // a.rd, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1735a;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1733a;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1729a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1737a;
    }

    @Override // a.rd, android.view.MenuItem
    public int getNumericModifiers() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f6671a;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1730a;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1741a;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1745b;
        if (charSequence == null) {
            charSequence = this.f1741a;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // a.rd, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1749d;
    }

    public int h() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1730a != null;
    }

    public char i() {
        return this.f1731a.G() ? this.b : this.f6671a;
    }

    @Override // a.rd, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1750d;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.h & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.h & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.h & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        uf ufVar = this.f1732a;
        return (ufVar == null || !ufVar.g()) ? (this.h & 8) == 0 : (this.h & 8) == 0 && this.f1732a.b();
    }

    public String j() {
        int i;
        char cI = i();
        if (cI == 0) {
            return "";
        }
        Resources resources = this.f1731a.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1731a.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a0.abc_prepend_shortcut_label));
        }
        int i2 = this.f1731a.G() ? this.f : this.e;
        f(sb, i2, 65536, resources.getString(a0.abc_menu_meta_shortcut_label));
        f(sb, i2, 4096, resources.getString(a0.abc_menu_ctrl_shortcut_label));
        f(sb, i2, 2, resources.getString(a0.abc_menu_alt_shortcut_label));
        f(sb, i2, 1, resources.getString(a0.abc_menu_shift_shortcut_label));
        f(sb, i2, 4, resources.getString(a0.abc_menu_sym_shortcut_label));
        f(sb, i2, 8, resources.getString(a0.abc_menu_function_shortcut_label));
        if (cI == '\b') {
            i = a0.abc_menu_delete_shortcut_label;
        } else if (cI == '\n') {
            i = a0.abc_menu_enter_shortcut_label;
        } else {
            if (cI != ' ') {
                sb.append(cI);
                return sb.toString();
            }
            i = a0.abc_menu_space_shortcut_label;
        }
        sb.append(resources.getString(i));
        return sb.toString();
    }

    public CharSequence k(w4.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    public boolean l() {
        uf ufVar;
        if ((this.i & 8) == 0) {
            return false;
        }
        if (this.f1740a == null && (ufVar = this.f1732a) != null) {
            this.f1740a = ufVar.d(this);
        }
        return this.f1740a != null;
    }

    public boolean m() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1739a;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        i4 i4Var = this.f1731a;
        if (i4Var.h(i4Var, this)) {
            return true;
        }
        Runnable runnable = this.f1742a;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1733a != null) {
            try {
                this.f1731a.u().startActivity(this.f1733a);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        uf ufVar = this.f1732a;
        return ufVar != null && ufVar.e();
    }

    public boolean n() {
        return (this.h & 32) == 32;
    }

    public boolean o() {
        return (this.h & 4) != 0;
    }

    public boolean p() {
        return (this.i & 1) == 1;
    }

    public boolean q() {
        return (this.i & 2) == 2;
    }

    public rd r(int i) {
        Context contextU = this.f1731a.u();
        s(LayoutInflater.from(contextU).inflate(i, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    public rd s(View view) {
        int i;
        this.f1740a = view;
        this.f1732a = null;
        if (view != null && view.getId() == -1 && (i = this.f1729a) > 0) {
            view.setId(i);
        }
        this.f1731a.I(this);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i) {
        r(i);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        s(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.b == c) {
            return this;
        }
        this.b = Character.toLowerCase(c);
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.b == c && this.f == i) {
            return this;
        }
        this.b = Character.toLowerCase(c);
        this.f = KeyEvent.normalizeMetaState(i);
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.h;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.h = i2;
        if (i != i2) {
            this.f1731a.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.h & 4) != 0) {
            this.f1731a.T(this);
        } else {
            u(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        b(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.h = z ? this.h | 16 : this.h & (-17);
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1736a = null;
        this.g = i;
        this.f1748c = true;
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.g = 0;
        this.f1736a = drawable;
        this.f1748c = true;
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1734a = colorStateList;
        this.f1743a = true;
        this.f1748c = true;
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1735a = mode;
        this.f1746b = true;
        this.f1748c = true;
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1733a = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f6671a == c) {
            return this;
        }
        this.f6671a = c;
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f6671a == c && this.e == i) {
            return this;
        }
        this.f6671a = c;
        this.e = KeyEvent.normalizeMetaState(i);
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1738a = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1739a = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f6671a = c;
        this.b = Character.toLowerCase(c2);
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f6671a = c;
        this.e = KeyEvent.normalizeMetaState(i);
        this.b = Character.toLowerCase(c2);
        this.f = KeyEvent.normalizeMetaState(i2);
        this.f1731a.K(false);
        return this;
    }

    @Override // a.rd, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.i = i;
        this.f1731a.I(this);
    }

    @Override // a.rd, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        y(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f1731a.u().getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1741a = charSequence;
        this.f1731a.K(false);
        c5 c5Var = this.f1730a;
        if (c5Var != null) {
            c5Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1745b = charSequence;
        this.f1731a.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (A(z)) {
            this.f1731a.J(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.f1750d = z;
        this.f1731a.K(false);
    }

    public String toString() {
        CharSequence charSequence = this.f1741a;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z) {
        int i = this.h;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.h = i2;
        if (i != i2) {
            this.f1731a.K(false);
        }
    }

    public void v(boolean z) {
        this.h = (z ? 4 : 0) | (this.h & (-5));
    }

    public void w(boolean z) {
        this.h = z ? this.h | 32 : this.h & (-33);
    }

    public void x(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1737a = contextMenuInfo;
    }

    public rd y(int i) {
        setShowAsAction(i);
        return this;
    }

    public void z(c5 c5Var) {
        this.f1730a = c5Var;
        c5Var.setHeaderTitle(getTitle());
    }
}
