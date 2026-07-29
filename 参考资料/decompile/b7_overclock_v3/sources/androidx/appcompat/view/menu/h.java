package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.k;
import androidx.core.view.b;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class h implements r0.c {
    public static final String Q = "MenuItemImpl";
    public static final int R = 3;
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 4;
    public static final int V = 8;
    public static final int W = 16;
    public static final int X = 32;
    public static final int Y = 0;
    public Runnable A;
    public MenuItem.OnMenuItemClickListener B;
    public CharSequence C;
    public CharSequence D;
    public int K;
    public View L;
    public androidx.core.view.b M;
    public MenuItem.OnActionExpandListener N;
    public ContextMenu.ContextMenuInfo P;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1953l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1954m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1955n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1956o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f1957p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f1958q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Intent f1959r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public char f1960s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public char f1962u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f1964w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f1966y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m f1967z;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1961t = 4096;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1963v = 4096;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1965x = 0;
    public ColorStateList E = null;
    public PorterDuff.Mode F = null;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public int J = 16;
    public boolean O = false;

    public class a implements b.InterfaceC0042b {
        public a() {
        }

        @Override // androidx.core.view.b.InterfaceC0042b
        public void onActionProviderVisibilityChanged(boolean z10) {
            h hVar = h.this;
            hVar.f1966y.M(hVar);
        }
    }

    public h(e eVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f1966y = eVar;
        this.f1953l = i11;
        this.f1954m = i10;
        this.f1955n = i12;
        this.f1956o = i13;
        this.f1957p = charSequence;
        this.K = i14;
    }

    public static void f(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    public void A(m mVar) {
        this.f1967z = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    public boolean B(boolean z10) {
        int i10 = this.J;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.J = i11;
        return i10 != i11;
    }

    public boolean C() {
        return this.f1966y.D();
    }

    public boolean D() {
        return this.f1966y.K() && j() != 0;
    }

    public boolean E() {
        return (this.K & 4) == 4;
    }

    @Override // r0.c
    @n0
    public r0.c a(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.M;
        if (bVar2 != null) {
            bVar2.j();
        }
        this.L = null;
        this.M = bVar;
        this.f1966y.N(true);
        androidx.core.view.b bVar3 = this.M;
        if (bVar3 != null) {
            bVar3.l(new a());
        }
        return this;
    }

    @Override // r0.c
    public androidx.core.view.b b() {
        return this.M;
    }

    @Override // r0.c
    public boolean c() {
        return (d() || q()) ? false : true;
    }

    @Override // r0.c, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1966y.g(this);
        }
        return false;
    }

    @Override // r0.c
    public boolean d() {
        return (this.K & 2) == 2;
    }

    public void e() {
        this.f1966y.L(this);
    }

    @Override // r0.c, android.view.MenuItem
    public boolean expandActionView() {
        if (!m()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1966y.n(this);
        }
        return false;
    }

    public final Drawable g(Drawable drawable) {
        if (drawable != null && this.I && (this.G || this.H)) {
            drawable = n0.c.r(drawable).mutate();
            if (this.G) {
                n0.c.o(drawable, this.E);
            }
            if (this.H) {
                n0.c.p(drawable, this.F);
            }
            this.I = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // r0.c, android.view.MenuItem
    public View getActionView() {
        View view = this.L;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.M;
        if (bVar == null) {
            return null;
        }
        View viewE = bVar.e(this);
        this.L = viewE;
        return viewE;
    }

    @Override // r0.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1963v;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1962u;
    }

    @Override // r0.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1954m;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1964w;
        if (drawable != null) {
            return g(drawable);
        }
        if (this.f1965x == 0) {
            return null;
        }
        Drawable drawableB = i.a.b(this.f1966y.x(), this.f1965x);
        this.f1965x = 0;
        this.f1964w = drawableB;
        return g(drawableB);
    }

    @Override // r0.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.E;
    }

    @Override // r0.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.F;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1959r;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1953l;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.P;
    }

    @Override // r0.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1961t;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1960s;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1955n;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1967z;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1957p;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1958q;
        return charSequence != null ? charSequence : this.f1957p;
    }

    @Override // r0.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.D;
    }

    public Runnable h() {
        return this.A;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1967z != null;
    }

    public int i() {
        return this.f1956o;
    }

    @Override // r0.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.O;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.J & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.J & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.J & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.M;
        return (bVar == null || !bVar.h()) ? (this.J & 8) == 0 : (this.J & 8) == 0 && this.M.c();
    }

    public char j() {
        return this.f1966y.J() ? this.f1962u : this.f1960s;
    }

    public String k() {
        char cJ = j();
        if (cJ == 0) {
            return "";
        }
        Resources resources = this.f1966y.x().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f1966y.x()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i10 = this.f1966y.J() ? this.f1963v : this.f1961t;
        f(sb2, i10, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        f(sb2, i10, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        f(sb2, i10, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        f(sb2, i10, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        f(sb2, i10, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        f(sb2, i10, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cJ == '\b') {
            sb2.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cJ == '\n') {
            sb2.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cJ != ' ') {
            sb2.append(cJ);
        } else {
            sb2.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    public CharSequence l(k.a aVar) {
        return (aVar == null || !aVar.f()) ? getTitle() : getTitleCondensed();
    }

    public boolean m() {
        androidx.core.view.b bVar;
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null && (bVar = this.M) != null) {
            this.L = bVar.e(this);
        }
        return this.L != null;
    }

    public boolean n() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.B;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f1966y;
        if (eVar.i(eVar, this)) {
            return true;
        }
        Runnable runnable = this.A;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1959r != null) {
            try {
                this.f1966y.x().startActivity(this.f1959r);
                return true;
            } catch (ActivityNotFoundException unused) {
            }
        }
        androidx.core.view.b bVar = this.M;
        return bVar != null && bVar.f();
    }

    public boolean o() {
        return (this.J & 32) == 32;
    }

    public boolean p() {
        return (this.J & 4) != 0;
    }

    public boolean q() {
        return (this.K & 1) == 1;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public r0.c setActionView(int i10) {
        Context contextX = this.f1966y.x();
        setActionView(LayoutInflater.from(contextX).inflate(i10, (ViewGroup) new LinearLayout(contextX), false));
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public r0.c setActionView(View view) {
        int i10;
        this.L = view;
        this.M = null;
        if (view != null && view.getId() == -1 && (i10 = this.f1953l) > 0) {
            view.setId(i10);
        }
        this.f1966y.L(this);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f1962u == c10) {
            return this;
        }
        this.f1962u = Character.toLowerCase(c10);
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.J;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.J = i11;
        if (i10 != i11) {
            this.f1966y.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.J & 4) != 0) {
            this.f1966y.a0(this);
        } else {
            v(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.J |= 16;
        } else {
            this.J &= -17;
        }
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1965x = 0;
        this.f1964w = drawable;
        this.I = true;
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setIconTintList(@p0 ColorStateList colorStateList) {
        this.E = colorStateList;
        this.G = true;
        this.I = true;
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.F = mode;
        this.H = true;
        this.I = true;
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1959r = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f1960s == c10) {
            return this;
        }
        this.f1960s = c10;
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.N = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.B = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1960s = c10;
        this.f1962u = Character.toLowerCase(c11);
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.K = i10;
        this.f1966y.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1957p = charSequence;
        this.f1966y.N(false);
        m mVar = this.f1967z;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1958q = charSequence;
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (B(z10)) {
            this.f1966y.M(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.O = z10;
        this.f1966y.N(false);
    }

    public String toString() {
        CharSequence charSequence = this.f1957p;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public MenuItem u(Runnable runnable) {
        this.A = runnable;
        return this;
    }

    public void v(boolean z10) {
        int i10 = this.J;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.J = i11;
        if (i10 != i11) {
            this.f1966y.N(false);
        }
    }

    public void w(boolean z10) {
        this.J = (z10 ? 4 : 0) | (this.J & (-5));
    }

    public void x(boolean z10) {
        if (z10) {
            this.J |= 32;
        } else {
            this.J &= -33;
        }
    }

    public void y(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.P = contextMenuInfo;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public r0.c setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public r0.c setContentDescription(CharSequence charSequence) {
        this.C = charSequence;
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public r0.c setTooltipText(CharSequence charSequence) {
        this.D = charSequence;
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f1962u == c10 && this.f1963v == i10) {
            return this;
        }
        this.f1962u = Character.toLowerCase(c10);
        this.f1963v = KeyEvent.normalizeMetaState(i10);
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f1960s == c10 && this.f1961t == i10) {
            return this;
        }
        this.f1960s = c10;
        this.f1961t = KeyEvent.normalizeMetaState(i10);
        this.f1966y.N(false);
        return this;
    }

    @Override // r0.c, android.view.MenuItem
    @n0
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1960s = c10;
        this.f1961t = KeyEvent.normalizeMetaState(i10);
        this.f1962u = Character.toLowerCase(c11);
        this.f1963v = KeyEvent.normalizeMetaState(i11);
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1964w = null;
        this.f1965x = i10;
        this.I = true;
        this.f1966y.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f1966y.x().getString(i10));
    }
}
