package l;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.y0;
import androidx.core.view.x;
import g.i0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f39285e = "SupportMenuInflater";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f39286f = "menu";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f39287g = "group";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f39288h = "item";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f39289i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Class<?>[] f39290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Class<?>[] f39291k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f39292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f39293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f39294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f39295d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f39296c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f39297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f39298b;

        public a(Object obj, String str) {
            this.f39297a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f39298b = cls.getMethod(str, f39296c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f39298b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f39298b.invoke(this.f39297a, menuItem)).booleanValue();
                }
                this.f39298b.invoke(this.f39297a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {
        public static final int G = 0;
        public static final int H = 0;
        public static final int I = 0;
        public static final int J = 0;
        public static final int K = 0;
        public static final boolean L = false;
        public static final boolean M = true;
        public static final boolean N = true;
        public androidx.core.view.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f39299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f39303e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f39304f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f39305g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f39306h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f39307i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f39308j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f39309k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f39310l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f39311m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f39312n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f39313o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f39314p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f39315q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f39316r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f39317s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f39318t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f39319u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f39320v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f39321w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f39322x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f39323y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f39324z;

        public b(Menu menu) {
            this.f39299a = menu;
            h();
        }

        public void a() {
            this.f39306h = true;
            i(this.f39299a.add(this.f39300b, this.f39307i, this.f39308j, this.f39309k));
        }

        public SubMenu b() {
            this.f39306h = true;
            SubMenu subMenuAddSubMenu = this.f39299a.addSubMenu(this.f39300b, this.f39307i, this.f39308j, this.f39309k);
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
            return this.f39306h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f39294c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot instantiate class: ");
                sb2.append(str);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f39294c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f39300b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f39301c = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f39302d = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f39303e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f39304f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f39305g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            y0 y0VarF = y0.F(g.this.f39294c, attributeSet, R.styleable.MenuItem);
            this.f39307i = y0VarF.u(R.styleable.MenuItem_android_id, 0);
            this.f39308j = (y0VarF.o(R.styleable.MenuItem_android_menuCategory, this.f39301c) & (-65536)) | (y0VarF.o(R.styleable.MenuItem_android_orderInCategory, this.f39302d) & 65535);
            this.f39309k = y0VarF.x(R.styleable.MenuItem_android_title);
            this.f39310l = y0VarF.x(R.styleable.MenuItem_android_titleCondensed);
            this.f39311m = y0VarF.u(R.styleable.MenuItem_android_icon, 0);
            this.f39312n = c(y0VarF.w(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f39313o = y0VarF.o(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f39314p = c(y0VarF.w(R.styleable.MenuItem_android_numericShortcut));
            this.f39315q = y0VarF.o(R.styleable.MenuItem_numericModifiers, 4096);
            int i10 = R.styleable.MenuItem_android_checkable;
            if (y0VarF.C(i10)) {
                this.f39316r = y0VarF.a(i10, false) ? 1 : 0;
            } else {
                this.f39316r = this.f39303e;
            }
            this.f39317s = y0VarF.a(R.styleable.MenuItem_android_checked, false);
            this.f39318t = y0VarF.a(R.styleable.MenuItem_android_visible, this.f39304f);
            this.f39319u = y0VarF.a(R.styleable.MenuItem_android_enabled, this.f39305g);
            this.f39320v = y0VarF.o(R.styleable.MenuItem_showAsAction, -1);
            this.f39324z = y0VarF.w(R.styleable.MenuItem_android_onClick);
            this.f39321w = y0VarF.u(R.styleable.MenuItem_actionLayout, 0);
            this.f39322x = y0VarF.w(R.styleable.MenuItem_actionViewClass);
            String strW = y0VarF.w(R.styleable.MenuItem_actionProviderClass);
            this.f39323y = strW;
            if ((strW != null) && this.f39321w == 0 && this.f39322x == null) {
                this.A = (androidx.core.view.b) e(strW, g.f39291k, g.this.f39293b);
            } else {
                this.A = null;
            }
            this.B = y0VarF.x(R.styleable.MenuItem_contentDescription);
            this.C = y0VarF.x(R.styleable.MenuItem_tooltipText);
            int i11 = R.styleable.MenuItem_iconTintMode;
            if (y0VarF.C(i11)) {
                this.E = d0.e(y0VarF.o(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = R.styleable.MenuItem_iconTint;
            if (y0VarF.C(i12)) {
                this.D = y0VarF.d(i12);
            } else {
                this.D = null;
            }
            y0VarF.I();
            this.f39306h = false;
        }

        public void h() {
            this.f39300b = 0;
            this.f39301c = 0;
            this.f39302d = 0;
            this.f39303e = 0;
            this.f39304f = true;
            this.f39305g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f39317s).setVisible(this.f39318t).setEnabled(this.f39319u).setCheckable(this.f39316r >= 1).setTitleCondensed(this.f39310l).setIcon(this.f39311m);
            int i10 = this.f39320v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f39324z != null) {
                if (g.this.f39294c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f39324z));
            }
            if (this.f39316r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    ((androidx.appcompat.view.menu.h) menuItem).w(true);
                } else if (menuItem instanceof m.c) {
                    ((m.c) menuItem).j(true);
                }
            }
            String str = this.f39322x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f39290j, g.this.f39292a));
                z10 = true;
            }
            int i11 = this.f39321w;
            if (i11 > 0 && !z10) {
                menuItem.setActionView(i11);
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                x.l(menuItem, bVar);
            }
            x.p(menuItem, this.B);
            x.w(menuItem, this.C);
            x.o(menuItem, this.f39312n, this.f39313o);
            x.s(menuItem, this.f39314p, this.f39315q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                x.r(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                x.q(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f39290j = clsArr;
        f39291k = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f39294c = context;
        Object[] objArr = {context};
        this.f39292a = objArr;
        this.f39293b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f39295d == null) {
            this.f39295d = a(this.f39294c);
        }
        return this.f39295d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals(f39286f)) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        str = null;
                        z11 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            androidx.core.view.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.b()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals(f39286f)) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals(f39286f)) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(@i0 int i10, Menu menu) {
        if (!(menu instanceof r0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f39294c.getResources().getLayout(i10);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
