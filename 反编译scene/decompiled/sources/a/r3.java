package a;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char f7265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s3 f2686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uf f2687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f2688a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f2689a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Menu f2690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2693a;
    public char b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2694b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f2695b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f2696b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2697b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f2698c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f2699c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2700c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f2701d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2702d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2703e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2704f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public r3(s3 s3Var, Menu menu) {
        this.f2686a = s3Var;
        this.f2690a = menu;
        h();
    }

    public void a() {
        this.f2700c = true;
        i(this.f2690a.add(this.f2685a, this.e, this.f, this.f2691a));
    }

    public SubMenu b() {
        this.f2700c = true;
        SubMenu subMenuAddSubMenu = this.f2690a.addSubMenu(this.f2685a, this.e, this.f, this.f2691a);
        i(subMenuAddSubMenu.getItem());
        return subMenuAddSubMenu;
    }

    public final char c(String str) {
        if (str == null) {
            return (char) 0;
        }
        return str.charAt(0);
    }

    public boolean d() {
        return this.f2700c;
    }

    public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f2686a.f2831a.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public void f(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.f2686a.f2831a.obtainStyledAttributes(attributeSet, c0.MenuGroup);
        this.f2685a = typedArrayObtainStyledAttributes.getResourceId(c0.MenuGroup_android_id, 0);
        this.f2694b = typedArrayObtainStyledAttributes.getInt(c0.MenuGroup_android_menuCategory, 0);
        this.c = typedArrayObtainStyledAttributes.getInt(c0.MenuGroup_android_orderInCategory, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(c0.MenuGroup_android_checkableBehavior, 0);
        this.f2693a = typedArrayObtainStyledAttributes.getBoolean(c0.MenuGroup_android_visible, true);
        this.f2697b = typedArrayObtainStyledAttributes.getBoolean(c0.MenuGroup_android_enabled, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g(AttributeSet attributeSet) {
        o8 o8VarU = o8.u(this.f2686a.f2831a, attributeSet, c0.MenuItem);
        this.e = o8VarU.n(c0.MenuItem_android_id, 0);
        this.f = (o8VarU.k(c0.MenuItem_android_menuCategory, this.f2694b) & (-65536)) | (o8VarU.k(c0.MenuItem_android_orderInCategory, this.c) & 65535);
        this.f2691a = o8VarU.p(c0.MenuItem_android_title);
        this.f2695b = o8VarU.p(c0.MenuItem_android_titleCondensed);
        this.g = o8VarU.n(c0.MenuItem_android_icon, 0);
        this.f7265a = c(o8VarU.o(c0.MenuItem_android_alphabeticShortcut));
        this.h = o8VarU.k(c0.MenuItem_alphabeticModifiers, 4096);
        this.b = c(o8VarU.o(c0.MenuItem_android_numericShortcut));
        this.i = o8VarU.k(c0.MenuItem_numericModifiers, 4096);
        this.j = o8VarU.s(c0.MenuItem_android_checkable) ? o8VarU.a(c0.MenuItem_android_checkable, false) : this.d;
        this.f2702d = o8VarU.a(c0.MenuItem_android_checked, false);
        this.f2703e = o8VarU.a(c0.MenuItem_android_visible, this.f2693a);
        this.f2704f = o8VarU.a(c0.MenuItem_android_enabled, this.f2697b);
        this.k = o8VarU.k(c0.MenuItem_showAsAction, -1);
        this.f2699c = o8VarU.o(c0.MenuItem_android_onClick);
        this.l = o8VarU.n(c0.MenuItem_actionLayout, 0);
        this.f2692a = o8VarU.o(c0.MenuItem_actionViewClass);
        String strO = o8VarU.o(c0.MenuItem_actionProviderClass);
        this.f2696b = strO;
        boolean z = strO != null;
        if (z && this.l == 0 && this.f2692a == null) {
            this.f2687a = (uf) e(this.f2696b, s3.b, this.f2686a.f2834b);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f2687a = null;
        }
        this.f2698c = o8VarU.p(c0.MenuItem_contentDescription);
        this.f2701d = o8VarU.p(c0.MenuItem_tooltipText);
        if (o8VarU.s(c0.MenuItem_iconTintMode)) {
            this.f2689a = e7.d(o8VarU.k(c0.MenuItem_iconTintMode, -1), this.f2689a);
        } else {
            this.f2689a = null;
        }
        if (o8VarU.s(c0.MenuItem_iconTint)) {
            this.f2688a = o8VarU.c(c0.MenuItem_iconTint);
        } else {
            this.f2688a = null;
        }
        o8VarU.w();
        this.f2700c = false;
    }

    public void h() {
        this.f2685a = 0;
        this.f2694b = 0;
        this.c = 0;
        this.d = 0;
        this.f2693a = true;
        this.f2697b = true;
    }

    public final void i(MenuItem menuItem) {
        boolean z = false;
        menuItem.setChecked(this.f2702d).setVisible(this.f2703e).setEnabled(this.f2704f).setCheckable(this.j >= 1).setTitleCondensed(this.f2695b).setIcon(this.g);
        int i = this.k;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.f2699c != null) {
            if (this.f2686a.f2831a.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new q3(this.f2686a.b(), this.f2699c));
        }
        if (this.j >= 2) {
            if (menuItem instanceof l4) {
                ((l4) menuItem).v(true);
            } else if (menuItem instanceof r4) {
                ((r4) menuItem).j(true);
            }
        }
        String str = this.f2692a;
        if (str != null) {
            menuItem.setActionView((View) e(str, s3.f7357a, this.f2686a.f2833a));
            z = true;
        }
        int i2 = this.l;
        if (i2 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        uf ufVar = this.f2687a;
        if (ufVar != null) {
            fg.a(menuItem, ufVar);
        }
        fg.c(menuItem, this.f2698c);
        fg.g(menuItem, this.f2701d);
        fg.b(menuItem, this.f7265a, this.h);
        fg.f(menuItem, this.b, this.i);
        PorterDuff.Mode mode = this.f2689a;
        if (mode != null) {
            fg.e(menuItem, mode);
        }
        ColorStateList colorStateList = this.f2688a;
        if (colorStateList != null) {
            fg.d(menuItem, colorStateList);
        }
    }
}
