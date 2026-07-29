package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5139a = "MenuItemCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f5140b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f5141c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f5142d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f5143e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f5144f = 8;

    public class a implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f5145a;

        public a(c cVar) {
            this.f5145a = cVar;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f5145a.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f5145a.onMenuItemActionExpand(menuItem);
        }
    }

    @g.v0(26)
    public static class b {
        @g.u
        public static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        @g.u
        public static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        @g.u
        public static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        @g.u
        public static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        @g.u
        public static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        @g.u
        public static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        @g.u
        public static MenuItem g(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        @g.u
        public static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        @g.u
        public static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        @g.u
        public static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        @g.u
        public static MenuItem k(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        @g.u
        public static MenuItem l(MenuItem menuItem, char c10, char c11, int i10, int i11) {
            return menuItem.setShortcut(c10, c11, i10, i11);
        }

        @g.u
        public static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    @Deprecated
    public interface c {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    @Deprecated
    public static boolean a(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean b(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    @g.p0
    public static androidx.core.view.b c(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).b();
        }
        return null;
    }

    @Deprecated
    public static View d(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int e(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(menuItem);
        }
        return 0;
    }

    @g.p0
    public static CharSequence f(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.b(menuItem);
        }
        return null;
    }

    @g.p0
    public static ColorStateList g(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.c(menuItem);
        }
        return null;
    }

    @g.p0
    public static PorterDuff.Mode h(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.d(menuItem);
        }
        return null;
    }

    public static int i(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.e(menuItem);
        }
        return 0;
    }

    @g.p0
    public static CharSequence j(@g.n0 MenuItem menuItem) {
        if (menuItem instanceof r0.c) {
            return ((r0.c) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return b.f(menuItem);
        }
        return null;
    }

    @Deprecated
    public static boolean k(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    @g.p0
    public static MenuItem l(@g.n0 MenuItem menuItem, @g.p0 androidx.core.view.b bVar) {
        return menuItem instanceof r0.c ? ((r0.c) menuItem).a(bVar) : menuItem;
    }

    @Deprecated
    public static MenuItem m(MenuItem menuItem, int i10) {
        return menuItem.setActionView(i10);
    }

    @Deprecated
    public static MenuItem n(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void o(@g.n0 MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setAlphabeticShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.g(menuItem, c10, i10);
        }
    }

    public static void p(@g.n0 MenuItem menuItem, @g.p0 CharSequence charSequence) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.h(menuItem, charSequence);
        }
    }

    public static void q(@g.n0 MenuItem menuItem, @g.p0 ColorStateList colorStateList) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.i(menuItem, colorStateList);
        }
    }

    public static void r(@g.n0 MenuItem menuItem, @g.p0 PorterDuff.Mode mode) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.j(menuItem, mode);
        }
    }

    public static void s(@g.n0 MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setNumericShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.k(menuItem, c10, i10);
        }
    }

    @Deprecated
    public static MenuItem t(MenuItem menuItem, c cVar) {
        return menuItem.setOnActionExpandListener(new a(cVar));
    }

    public static void u(@g.n0 MenuItem menuItem, char c10, char c11, int i10, int i11) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setShortcut(c10, c11, i10, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.l(menuItem, c10, c11, i10, i11);
        }
    }

    @Deprecated
    public static void v(MenuItem menuItem, int i10) {
        menuItem.setShowAsAction(i10);
    }

    public static void w(@g.n0 MenuItem menuItem, @g.p0 CharSequence charSequence) {
        if (menuItem instanceof r0.c) {
            ((r0.c) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            b.m(menuItem, charSequence);
        }
    }
}
