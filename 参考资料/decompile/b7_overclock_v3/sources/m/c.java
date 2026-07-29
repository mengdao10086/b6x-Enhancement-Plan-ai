package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.view.b;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c extends m.b implements MenuItem {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f40501q = "MenuItemWrapper";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r0.c f40502o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Method f40503p;

    public class a extends androidx.core.view.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ActionProvider f40504e;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f40504e = actionProvider;
        }

        @Override // androidx.core.view.b
        public boolean b() {
            return this.f40504e.hasSubMenu();
        }

        @Override // androidx.core.view.b
        public View d() {
            return this.f40504e.onCreateActionView();
        }

        @Override // androidx.core.view.b
        public boolean f() {
            return this.f40504e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.b
        public void g(SubMenu subMenu) {
            this.f40504e.onPrepareSubMenu(c.this.f(subMenu));
        }
    }

    @v0(16)
    public class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b.InterfaceC0042b f40506g;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.b
        public boolean c() {
            return this.f40504e.isVisible();
        }

        @Override // androidx.core.view.b
        public View e(MenuItem menuItem) {
            return this.f40504e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.b
        public boolean h() {
            return this.f40504e.overridesItemVisibility();
        }

        @Override // androidx.core.view.b
        public void i() {
            this.f40504e.refreshVisibility();
        }

        @Override // androidx.core.view.b
        public void l(b.InterfaceC0042b interfaceC0042b) {
            this.f40506g = interfaceC0042b;
            this.f40504e.setVisibilityListener(interfaceC0042b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            b.InterfaceC0042b interfaceC0042b = this.f40506g;
            if (interfaceC0042b != null) {
                interfaceC0042b.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    /* JADX INFO: renamed from: m.c$c, reason: collision with other inner class name */
    public static class C0448c extends FrameLayout implements l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CollapsibleActionView f40508a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0448c(View view) {
            super(view.getContext());
            this.f40508a = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f40508a;
        }

        @Override // l.c
        public void b() {
            this.f40508a.onActionViewExpanded();
        }

        @Override // l.c
        public void d() {
            this.f40508a.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f40509a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f40509a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f40509a.onMenuItemActionCollapse(c.this.e(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f40509a.onMenuItemActionExpand(c.this.e(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f40511a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f40511a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f40511a.onMenuItemClick(c.this.e(menuItem));
        }
    }

    public c(Context context, r0.c cVar) {
        super(context);
        if (cVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f40502o = cVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f40502o.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f40502o.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.b bVarB = this.f40502o.b();
        if (bVarB instanceof a) {
            return ((a) bVarB).f40504e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f40502o.getActionView();
        return actionView instanceof C0448c ? ((C0448c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f40502o.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f40502o.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f40502o.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f40502o.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f40502o.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f40502o.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f40502o.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f40502o.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f40502o.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f40502o.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f40502o.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f40502o.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f40502o.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return f(this.f40502o.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f40502o.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f40502o.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f40502o.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f40502o.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f40502o.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f40502o.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f40502o.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f40502o.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f40502o.isVisible();
    }

    public void j(boolean z10) {
        try {
            if (this.f40503p == null) {
                this.f40503p = this.f40502o.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f40503p.invoke(this.f40502o, Boolean.valueOf(z10));
        } catch (Exception unused) {
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f40498l, actionProvider);
        r0.c cVar = this.f40502o;
        if (actionProvider == null) {
            bVar = null;
        }
        cVar.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0448c(view);
        }
        this.f40502o.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f40502o.setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f40502o.setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f40502o.setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f40502o.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f40502o.setEnabled(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f40502o.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f40502o.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f40502o.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f40502o.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f40502o.setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f40502o.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f40502o.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f40502o.setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        this.f40502o.setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        this.f40502o.setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f40502o.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f40502o.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f40502o.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return this.f40502o.setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f40502o.setAlphabeticShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f40502o.setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f40502o.setNumericShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f40502o.setShortcut(c10, c11, i10, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f40502o.setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        this.f40502o.setActionView(i10);
        View actionView = this.f40502o.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f40502o.setActionView(new C0448c(actionView));
        }
        return this;
    }
}
