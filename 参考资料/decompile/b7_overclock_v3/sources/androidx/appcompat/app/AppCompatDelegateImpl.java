package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.g1;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.y0;
import androidx.core.view.b1;
import androidx.core.view.d1;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.o;
import androidx.core.view.u0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.y;
import g.d0;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import j0.i;
import java.lang.Thread;
import java.util.List;
import l.b;
import l.f;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AppCompatDelegateImpl extends androidx.appcompat.app.h implements e.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final androidx.collection.l<String, Integer> f1519e8 = new androidx.collection.l<>();

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final boolean f1520f8 = false;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int[] f1521g8 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final boolean f1522h8 = !"robolectric".equals(Build.FINGERPRINT);

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final boolean f1523i8 = true;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static boolean f1524j8 = false;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public static final String f1525k8 = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    public l.b A;
    public ActionBarContextView B;
    public PopupWindow C;
    public TextView C1;
    public boolean C2;
    public Runnable D;
    public boolean E7;
    public boolean F7;
    public boolean G7;
    public boolean H7;
    public boolean I7;
    public PanelFeatureState[] J7;
    public boolean K0;
    public View K1;
    public boolean K2;
    public PanelFeatureState K7;
    public boolean L7;
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public Configuration P7;
    public int Q7;
    public int R7;
    public boolean S7;
    public boolean T7;
    public r U7;
    public r V7;
    public boolean W7;
    public int X7;
    public final Runnable Y7;
    public boolean Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public Rect f1526a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public Rect f1527b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public androidx.appcompat.app.k f1528c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public androidx.appcompat.app.l f1529d8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public b1 f1530k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f1531k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f1532p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f1533q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Window f1534r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public p f1535s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.appcompat.app.g f1536t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.appcompat.app.a f1537u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MenuInflater f1538v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public ViewGroup f1539v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f1540v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f1541w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b0 f1542x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j f1543y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v f1544z;

    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1547c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1548d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1549e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1550f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ViewGroup f1551g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f1552h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f1553i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f1554j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.c f1555k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Context f1556l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1557m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1558n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1559o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f1560p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f1561q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f1562r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f1563s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Bundle f1564t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Bundle f1565u;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1566a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f1567b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Bundle f1568c;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1566a = parcel.readInt();
                boolean z10 = parcel.readInt() == 1;
                savedState.f1567b = z10;
                if (z10) {
                    savedState.f1568c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f1566a);
                parcel.writeInt(this.f1567b ? 1 : 0);
                if (this.f1567b) {
                    parcel.writeBundle(this.f1568c);
                }
            }
        }

        public PanelFeatureState(int i10) {
            this.f1545a = i10;
        }

        public void a() {
            Bundle bundle;
            androidx.appcompat.view.menu.e eVar = this.f1554j;
            if (eVar == null || (bundle = this.f1564t) == null) {
                return;
            }
            eVar.U(bundle);
            this.f1564t = null;
        }

        public void b() {
            androidx.appcompat.view.menu.e eVar = this.f1554j;
            if (eVar != null) {
                eVar.S(this.f1555k);
            }
            this.f1555k = null;
        }

        public androidx.appcompat.view.menu.k c(j.a aVar) {
            if (this.f1554j == null) {
                return null;
            }
            if (this.f1555k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f1556l, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.f1555k = cVar;
                cVar.h(aVar);
                this.f1554j.b(this.f1555k);
            }
            return this.f1555k.m(this.f1551g);
        }

        public boolean d() {
            if (this.f1552h == null) {
                return false;
            }
            return this.f1553i != null || this.f1555k.a().getCount() > 0;
        }

        public void e(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.f1545a = savedState.f1566a;
            this.f1563s = savedState.f1567b;
            this.f1564t = savedState.f1568c;
            this.f1552h = null;
            this.f1551g = null;
        }

        public Parcelable f() {
            SavedState savedState = new SavedState();
            savedState.f1566a = this.f1545a;
            savedState.f1567b = this.f1559o;
            if (this.f1554j != null) {
                Bundle bundle = new Bundle();
                savedState.f1568c = bundle;
                this.f1554j.W(bundle);
            }
            return savedState;
        }

        public void g(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1554j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.S(this.f1555k);
            }
            this.f1554j = eVar;
            if (eVar == null || (cVar = this.f1555k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        public void h(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                themeNewTheme.applyStyle(i10, true);
            }
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                themeNewTheme.applyStyle(i11, true);
            } else {
                themeNewTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            l.d dVar = new l.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f1556l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.f1546b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f1550f = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f1569a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f1569a = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th2) {
            String message;
            if (!(th2 instanceof Resources.NotFoundException) || (message = th2.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@n0 Thread thread, @n0 Throwable th2) {
            if (!a(th2)) {
                this.f1569a.uncaughtException(thread, th2);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th2.getMessage() + AppCompatDelegateImpl.f1525k8);
            notFoundException.initCause(th2.getCause());
            notFoundException.setStackTrace(th2.getStackTrace());
            this.f1569a.uncaughtException(thread, notFoundException);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.X7 & 1) != 0) {
                appCompatDelegateImpl.h0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.X7 & 4096) != 0) {
                appCompatDelegateImpl2.h0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.W7 = false;
            appCompatDelegateImpl3.X7 = 0;
        }
    }

    public class c implements k0 {
        public c() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            int iR = j1Var.r();
            int iY0 = AppCompatDelegateImpl.this.Y0(j1Var, null);
            if (iR != iY0) {
                j1Var = j1Var.D(j1Var.p(), iY0, j1Var.q(), j1Var.o());
            }
            return u0.g1(view, j1Var);
        }
    }

    public class d implements g0.a {
        public d() {
        }

        @Override // androidx.appcompat.widget.g0.a
        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.Y0(null, rect);
        }
    }

    public class e implements ContentFrameLayout.a {
        public e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.f0();
        }
    }

    public class f implements Runnable {

        public class a extends d1 {
            public a() {
            }

            @Override // androidx.core.view.d1, androidx.core.view.c1
            public void b(View view) {
                AppCompatDelegateImpl.this.B.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f1530k0.u(null);
                AppCompatDelegateImpl.this.f1530k0 = null;
            }

            @Override // androidx.core.view.d1, androidx.core.view.c1
            public void c(View view) {
                AppCompatDelegateImpl.this.B.setVisibility(0);
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.C.showAtLocation(appCompatDelegateImpl.B, 55, 0, 0);
            AppCompatDelegateImpl.this.i0();
            if (!AppCompatDelegateImpl.this.R0()) {
                AppCompatDelegateImpl.this.B.setAlpha(1.0f);
                AppCompatDelegateImpl.this.B.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.B.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f1530k0 = u0.g(appCompatDelegateImpl2.B).b(1.0f);
                AppCompatDelegateImpl.this.f1530k0.u(new a());
            }
        }
    }

    public class g extends d1 {
        public g() {
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void b(View view) {
            AppCompatDelegateImpl.this.B.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f1530k0.u(null);
            AppCompatDelegateImpl.this.f1530k0 = null;
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void c(View view) {
            AppCompatDelegateImpl.this.B.setVisibility(0);
            if (AppCompatDelegateImpl.this.B.getParent() instanceof View) {
                u0.v1((View) AppCompatDelegateImpl.this.B.getParent());
            }
        }
    }

    public class h implements c.b {
        public h() {
        }

        @Override // androidx.appcompat.app.c.b
        public void a(Drawable drawable, int i10) {
            androidx.appcompat.app.a aVarS = AppCompatDelegateImpl.this.s();
            if (aVarS != null) {
                aVarS.l0(drawable);
                aVarS.i0(i10);
            }
        }

        @Override // androidx.appcompat.app.c.b
        public Drawable b() {
            y0 y0VarF = y0.F(e(), null, new int[]{androidx.appcompat.R.attr.homeAsUpIndicator});
            Drawable drawableH = y0VarF.h(0);
            y0VarF.I();
            return drawableH;
        }

        @Override // androidx.appcompat.app.c.b
        public void c(int i10) {
            androidx.appcompat.app.a aVarS = AppCompatDelegateImpl.this.s();
            if (aVarS != null) {
                aVarS.i0(i10);
            }
        }

        @Override // androidx.appcompat.app.c.b
        public boolean d() {
            androidx.appcompat.app.a aVarS = AppCompatDelegateImpl.this.s();
            return (aVarS == null || (aVarS.p() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.c.b
        public Context e() {
            return AppCompatDelegateImpl.this.n0();
        }
    }

    public interface i {
        boolean a(int i10);

        @p0
        View onCreatePanelView(int i10);
    }

    public final class j implements j.a {
        public j() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(@n0 androidx.appcompat.view.menu.e eVar, boolean z10) {
            AppCompatDelegateImpl.this.Z(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(@n0 androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackU0 = AppCompatDelegateImpl.this.u0();
            if (callbackU0 == null) {
                return true;
            }
            callbackU0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public class k implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b.a f1579a;

        public class a extends d1 {
            public a() {
            }

            @Override // androidx.core.view.d1, androidx.core.view.c1
            public void b(View view) {
                AppCompatDelegateImpl.this.B.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.C;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.B.getParent() instanceof View) {
                    u0.v1((View) AppCompatDelegateImpl.this.B.getParent());
                }
                AppCompatDelegateImpl.this.B.t();
                AppCompatDelegateImpl.this.f1530k0.u(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f1530k0 = null;
                u0.v1(appCompatDelegateImpl2.f1539v1);
            }
        }

        public k(b.a aVar) {
            this.f1579a = aVar;
        }

        @Override // l.b.a
        public boolean a(l.b bVar, Menu menu) {
            return this.f1579a.a(bVar, menu);
        }

        @Override // l.b.a
        public boolean b(l.b bVar, Menu menu) {
            u0.v1(AppCompatDelegateImpl.this.f1539v1);
            return this.f1579a.b(bVar, menu);
        }

        @Override // l.b.a
        public void c(l.b bVar) {
            this.f1579a.c(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.C != null) {
                appCompatDelegateImpl.f1534r.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.D);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.B != null) {
                appCompatDelegateImpl2.i0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f1530k0 = u0.g(appCompatDelegateImpl3.B).b(0.0f);
                AppCompatDelegateImpl.this.f1530k0.u(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.g gVar = appCompatDelegateImpl4.f1536t;
            if (gVar != null) {
                gVar.F2(appCompatDelegateImpl4.A);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.A = null;
            u0.v1(appCompatDelegateImpl5.f1539v1);
        }

        @Override // l.b.a
        public boolean d(l.b bVar, MenuItem menuItem) {
            return this.f1579a.d(bVar, menuItem);
        }
    }

    @v0(17)
    public static class l {
        public static Context a(@n0 Context context, @n0 Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        public static void b(@n0 Configuration configuration, @n0 Configuration configuration2, @n0 Configuration configuration3) {
            int i10 = configuration.densityDpi;
            int i11 = configuration2.densityDpi;
            if (i10 != i11) {
                configuration3.densityDpi = i11;
            }
        }
    }

    @v0(21)
    public static class m {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    @v0(24)
    public static class n {
        public static void a(@n0 Configuration configuration, @n0 Configuration configuration2, @n0 Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    @v0(26)
    public static class o {
        public static void a(@n0 Configuration configuration, @n0 Configuration configuration2, @n0 Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    public class q extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f1587c;

        public q(@n0 Context context) {
            super();
            this.f1587c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return m.a(this.f1587c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void e() {
            AppCompatDelegateImpl.this.e();
        }
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f1589a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                r.this.e();
            }
        }

        public r() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f1589a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f1533q.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1589a = null;
            }
        }

        @p0
        public abstract IntentFilter b();

        public abstract int c();

        public boolean d() {
            return this.f1589a != null;
        }

        public abstract void e();

        public void f() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f1589a == null) {
                this.f1589a = new a();
            }
            AppCompatDelegateImpl.this.f1533q.registerReceiver(this.f1589a, intentFilterB);
        }
    }

    public class s extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.appcompat.app.q f1592c;

        public s(@n0 androidx.appcompat.app.q qVar) {
            super();
            this.f1592c = qVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return this.f1592c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void e() {
            AppCompatDelegateImpl.this.e();
        }
    }

    @v0(17)
    public static class t {
        public static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    public class u extends ContentFrameLayout {
        public u(Context context) {
            super(context);
        }

        public final boolean c(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.b0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(i.a.b(getContext(), i10));
        }
    }

    public final class v implements j.a {
        public v() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void b(@n0 androidx.appcompat.view.menu.e eVar, boolean z10) {
            androidx.appcompat.view.menu.e eVarG = eVar.G();
            boolean z11 = eVarG != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                eVar = eVarG;
            }
            PanelFeatureState panelFeatureStateL0 = appCompatDelegateImpl.l0(eVar);
            if (panelFeatureStateL0 != null) {
                if (!z11) {
                    AppCompatDelegateImpl.this.c0(panelFeatureStateL0, z10);
                } else {
                    AppCompatDelegateImpl.this.Y(panelFeatureStateL0.f1545a, panelFeatureStateL0, eVarG);
                    AppCompatDelegateImpl.this.c0(panelFeatureStateL0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean c(@n0 androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackU0;
            if (eVar != eVar.G()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.K2 || (callbackU0 = appCompatDelegateImpl.u0()) == null || AppCompatDelegateImpl.this.O7) {
                return true;
            }
            callbackU0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.g gVar) {
        this(activity, null, gVar, activity);
    }

    @n0
    public static Configuration m0(@n0 Configuration configuration, @p0 Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                n.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.j.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                o.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            l.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1532p
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.h.G(r3)
        L9:
            boolean r0 = r3.W7
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1534r
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.Y7
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.O7 = r0
            int r0 = r3.Q7
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1532p
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.l<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1519e8
            java.lang.Object r1 = r3.f1532p
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.Q7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.l<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f1519e8
            java.lang.Object r1 = r3.f1532p
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f1537u
            if (r0 == 0) goto L5b
            r0.J()
        L5b:
            r3.a0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.A():void");
    }

    public final boolean A0(Context context) {
        if (!this.T7 && (this.f1532p instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i10 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1532p.getClass()), i10 >= 29 ? 269221888 : i10 >= 24 ? 786432 : 0);
                this.S7 = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.S7 = false;
            }
        }
        this.T7 = true;
        return this.S7;
    }

    @Override // androidx.appcompat.app.h
    public void B(Bundle bundle) {
        j0();
    }

    public int B0(@n0 Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return q0(context).c();
                }
                return -1;
            }
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    return o0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i10;
    }

    @Override // androidx.appcompat.app.h
    public void C() {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            aVarS.u0(true);
        }
    }

    public boolean C0() {
        l.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a aVarS = s();
        return aVarS != null && aVarS.m();
    }

    @Override // androidx.appcompat.app.h
    public void D(Bundle bundle) {
    }

    public boolean D0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.L7 = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            E0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.h
    public void E() {
        e();
    }

    public final boolean E0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateR0 = r0(i10, true);
        if (panelFeatureStateR0.f1559o) {
            return false;
        }
        return O0(panelFeatureStateR0, keyEvent);
    }

    @Override // androidx.appcompat.app.h
    public void F() {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            aVarS.u0(false);
        }
    }

    public boolean F0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null && aVarS.K(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.K7;
        if (panelFeatureState != null && N0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.K7;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f1558n = true;
            }
            return true;
        }
        if (this.K7 == null) {
            PanelFeatureState panelFeatureStateR0 = r0(0, true);
            O0(panelFeatureStateR0, keyEvent);
            boolean zN0 = N0(panelFeatureStateR0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateR0.f1557m = false;
            if (zN0) {
                return true;
            }
        }
        return false;
    }

    public boolean G0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.L7;
            this.L7 = false;
            PanelFeatureState panelFeatureStateR0 = r0(0, false);
            if (panelFeatureStateR0 != null && panelFeatureStateR0.f1559o) {
                if (!z10) {
                    c0(panelFeatureStateR0, true);
                }
                return true;
            }
            if (C0()) {
                return true;
            }
        } else if (i10 == 82) {
            H0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            l.b r0 = r4.A
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.r0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.b0 r5 = r4.f1542x
            if (r5 == 0) goto L43
            boolean r5 = r5.h()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f1533q
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.b0 r5 = r4.f1542x
            boolean r5 = r5.e()
            if (r5 != 0) goto L3c
            boolean r5 = r4.O7
            if (r5 != 0) goto L62
            boolean r5 = r4.O0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.b0 r5 = r4.f1542x
            boolean r0 = r5.l()
            goto L68
        L3c:
            androidx.appcompat.widget.b0 r5 = r4.f1542x
            boolean r0 = r5.k()
            goto L68
        L43:
            boolean r5 = r2.f1559o
            if (r5 != 0) goto L64
            boolean r3 = r2.f1558n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f1557m
            if (r5 == 0) goto L62
            boolean r5 = r2.f1562r
            if (r5 == 0) goto L5b
            r2.f1557m = r1
            boolean r5 = r4.O0(r2, r6)
            goto L5c
        L5b:
            r5 = 1
        L5c:
            if (r5 == 0) goto L62
            r4.L0(r2, r6)
            goto L68
        L62:
            r0 = 0
            goto L68
        L64:
            r4.c0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L7d
            android.content.Context r5 = r4.f1533q
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7d
            r5.playSoundEffect(r1)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.H0(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.app.h
    public boolean I(int i10) {
        int iQ0 = Q0(i10);
        if (this.H7 && iQ0 == 108) {
            return false;
        }
        if (this.K2 && iQ0 == 1) {
            this.K2 = false;
        }
        if (iQ0 == 1) {
            U0();
            this.H7 = true;
            return true;
        }
        if (iQ0 == 2) {
            U0();
            this.f1540v2 = true;
            return true;
        }
        if (iQ0 == 5) {
            U0();
            this.C2 = true;
            return true;
        }
        if (iQ0 == 10) {
            U0();
            this.F7 = true;
            return true;
        }
        if (iQ0 == 108) {
            U0();
            this.K2 = true;
            return true;
        }
        if (iQ0 != 109) {
            return this.f1534r.requestFeature(iQ0);
        }
        U0();
        this.E7 = true;
        return true;
    }

    public void I0(int i10) {
        androidx.appcompat.app.a aVarS;
        if (i10 != 108 || (aVarS = s()) == null) {
            return;
        }
        aVarS.n(true);
    }

    public void J0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a aVarS = s();
            if (aVarS != null) {
                aVarS.n(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState panelFeatureStateR0 = r0(i10, true);
            if (panelFeatureStateR0.f1559o) {
                c0(panelFeatureStateR0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.h
    public void K(int i10) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1539v1.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1533q).inflate(i10, viewGroup);
        this.f1535s.c(this.f1534r.getCallback());
    }

    public void K0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.h
    public void L(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1539v1.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1535s.c(this.f1534r.getCallback());
    }

    public final void L0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.f1559o || this.O7) {
            return;
        }
        if (panelFeatureState.f1545a == 0) {
            if ((this.f1533q.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null && !callbackU0.onMenuOpened(panelFeatureState.f1545a, panelFeatureState.f1554j)) {
            c0(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1533q.getSystemService("window");
        if (windowManager != null && O0(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f1551g;
            if (viewGroup != null && !panelFeatureState.f1561q) {
                View view = panelFeatureState.f1553i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i10 = -1;
                }
                panelFeatureState.f1558n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f1548d, panelFeatureState.f1549e, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.f1547c;
                layoutParams2.windowAnimations = panelFeatureState.f1550f;
                windowManager.addView(panelFeatureState.f1551g, layoutParams2);
                panelFeatureState.f1559o = true;
            }
            if (viewGroup == null) {
                if (!x0(panelFeatureState) || panelFeatureState.f1551g == null) {
                    return;
                }
            } else if (panelFeatureState.f1561q && viewGroup.getChildCount() > 0) {
                panelFeatureState.f1551g.removeAllViews();
            }
            if (!w0(panelFeatureState) || !panelFeatureState.d()) {
                panelFeatureState.f1561q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f1552h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.f1551g.setBackgroundResource(panelFeatureState.f1546b);
            ViewParent parent = panelFeatureState.f1552h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(panelFeatureState.f1552h);
            }
            panelFeatureState.f1551g.addView(panelFeatureState.f1552h, layoutParams3);
            if (!panelFeatureState.f1552h.hasFocus()) {
                panelFeatureState.f1552h.requestFocus();
            }
            i10 = -2;
            panelFeatureState.f1558n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f1548d, panelFeatureState.f1549e, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.f1547c;
            layoutParams22.windowAnimations = panelFeatureState.f1550f;
            windowManager.addView(panelFeatureState.f1551g, layoutParams22);
            panelFeatureState.f1559o = true;
        }
    }

    @Override // androidx.appcompat.app.h
    public void M(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f1539v1.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1535s.c(this.f1534r.getCallback());
    }

    public final androidx.appcompat.app.a M0() {
        return this.f1537u;
    }

    public final boolean N0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f1557m || O0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.f1554j) != null) {
            zPerformShortcut = eVar.performShortcut(i10, keyEvent, i11);
        }
        if (zPerformShortcut && (i11 & 1) == 0 && this.f1542x == null) {
            c0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    @Override // androidx.appcompat.app.h
    public void O(boolean z10) {
        this.K0 = z10;
    }

    public final boolean O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        if (this.O7) {
            return false;
        }
        if (panelFeatureState.f1557m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.K7;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            c0(panelFeatureState2, false);
        }
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null) {
            panelFeatureState.f1553i = callbackU0.onCreatePanelView(panelFeatureState.f1545a);
        }
        int i10 = panelFeatureState.f1545a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (b0Var3 = this.f1542x) != null) {
            b0Var3.f();
        }
        if (panelFeatureState.f1553i == null && (!z10 || !(M0() instanceof androidx.appcompat.app.o))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.f1554j;
            if (eVar == null || panelFeatureState.f1562r) {
                if (eVar == null && (!y0(panelFeatureState) || panelFeatureState.f1554j == null)) {
                    return false;
                }
                if (z10 && this.f1542x != null) {
                    if (this.f1543y == null) {
                        this.f1543y = new j();
                    }
                    this.f1542x.a(panelFeatureState.f1554j, this.f1543y);
                }
                panelFeatureState.f1554j.m0();
                if (!callbackU0.onCreatePanelMenu(panelFeatureState.f1545a, panelFeatureState.f1554j)) {
                    panelFeatureState.g(null);
                    if (z10 && (b0Var = this.f1542x) != null) {
                        b0Var.a(null, this.f1543y);
                    }
                    return false;
                }
                panelFeatureState.f1562r = false;
            }
            panelFeatureState.f1554j.m0();
            Bundle bundle = panelFeatureState.f1565u;
            if (bundle != null) {
                panelFeatureState.f1554j.T(bundle);
                panelFeatureState.f1565u = null;
            }
            if (!callbackU0.onPreparePanel(0, panelFeatureState.f1553i, panelFeatureState.f1554j)) {
                if (z10 && (b0Var2 = this.f1542x) != null) {
                    b0Var2.a(null, this.f1543y);
                }
                panelFeatureState.f1554j.l0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f1560p = z11;
            panelFeatureState.f1554j.setQwertyMode(z11);
            panelFeatureState.f1554j.l0();
        }
        panelFeatureState.f1557m = true;
        panelFeatureState.f1558n = false;
        this.K7 = panelFeatureState;
        return true;
    }

    @Override // androidx.appcompat.app.h
    @v0(17)
    public void P(int i10) {
        if (this.Q7 != i10) {
            this.Q7 = i10;
            if (this.M7) {
                e();
            }
        }
    }

    public final void P0(boolean z10) {
        b0 b0Var = this.f1542x;
        if (b0Var == null || !b0Var.h() || (ViewConfiguration.get(this.f1533q).hasPermanentMenuKey() && !this.f1542x.j())) {
            PanelFeatureState panelFeatureStateR0 = r0(0, true);
            panelFeatureStateR0.f1561q = true;
            c0(panelFeatureStateR0, false);
            L0(panelFeatureStateR0, null);
            return;
        }
        Window.Callback callbackU0 = u0();
        if (this.f1542x.e() && z10) {
            this.f1542x.k();
            if (this.O7) {
                return;
            }
            callbackU0.onPanelClosed(108, r0(0, true).f1554j);
            return;
        }
        if (callbackU0 == null || this.O7) {
            return;
        }
        if (this.W7 && (this.X7 & 1) != 0) {
            this.f1534r.getDecorView().removeCallbacks(this.Y7);
            this.Y7.run();
        }
        PanelFeatureState panelFeatureStateR02 = r0(0, true);
        androidx.appcompat.view.menu.e eVar = panelFeatureStateR02.f1554j;
        if (eVar == null || panelFeatureStateR02.f1562r || !callbackU0.onPreparePanel(0, panelFeatureStateR02.f1553i, eVar)) {
            return;
        }
        callbackU0.onMenuOpened(108, panelFeatureStateR02.f1554j);
        this.f1542x.l();
    }

    @Override // androidx.appcompat.app.h
    public void Q(Toolbar toolbar) {
        if (this.f1532p instanceof Activity) {
            androidx.appcompat.app.a aVarS = s();
            if (aVarS instanceof androidx.appcompat.app.r) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f1538v = null;
            if (aVarS != null) {
                aVarS.J();
            }
            this.f1537u = null;
            if (toolbar != null) {
                androidx.appcompat.app.o oVar = new androidx.appcompat.app.o(toolbar, t0(), this.f1535s);
                this.f1537u = oVar;
                this.f1535s.e(oVar.f1680k);
            } else {
                this.f1535s.e(null);
            }
            v();
        }
    }

    public final int Q0(int i10) {
        if (i10 == 8) {
            return 108;
        }
        if (i10 == 9) {
            return 109;
        }
        return i10;
    }

    @Override // androidx.appcompat.app.h
    public void R(@g.d1 int i10) {
        this.R7 = i10;
    }

    public final boolean R0() {
        ViewGroup viewGroup;
        return this.f1531k1 && (viewGroup = this.f1539v1) != null && u0.U0(viewGroup);
    }

    @Override // androidx.appcompat.app.h
    public final void S(CharSequence charSequence) {
        this.f1541w = charSequence;
        b0 b0Var = this.f1542x;
        if (b0Var != null) {
            b0Var.setWindowTitle(charSequence);
            return;
        }
        if (M0() != null) {
            M0().B0(charSequence);
            return;
        }
        TextView textView = this.C1;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1534r.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || u0.O0((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.h
    public l.b T(@n0 b.a aVar) {
        androidx.appcompat.app.g gVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        l.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
        k kVar = new k(aVar);
        androidx.appcompat.app.a aVarS = s();
        if (aVarS != null) {
            l.b bVarD0 = aVarS.D0(kVar);
            this.A = bVarD0;
            if (bVarD0 != null && (gVar = this.f1536t) != null) {
                gVar.S(bVarD0);
            }
        }
        if (this.A == null) {
            this.A = T0(kVar);
        }
        return this.A;
    }

    public l.b T0(@n0 b.a aVar) {
        l.b bVarC2;
        Context dVar;
        androidx.appcompat.app.g gVar;
        i0();
        l.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof k)) {
            aVar = new k(aVar);
        }
        androidx.appcompat.app.g gVar2 = this.f1536t;
        if (gVar2 == null || this.O7) {
            bVarC2 = null;
        } else {
            try {
                bVarC2 = gVar2.c2(aVar);
            } catch (AbstractMethodError unused) {
                bVarC2 = null;
            }
        }
        if (bVarC2 != null) {
            this.A = bVarC2;
        } else {
            if (this.B == null) {
                if (this.G7) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1533q.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1533q.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new l.d(this.f1533q, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f1533q;
                    }
                    this.B = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                    this.C = popupWindow;
                    androidx.core.widget.p.d(popupWindow, 2);
                    this.C.setContentView(this.B);
                    this.C.setWidth(-1);
                    dVar.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.B.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.C.setHeight(-2);
                    this.D = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1539v1.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n0()));
                        this.B = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.B != null) {
                i0();
                this.B.t();
                l.e eVar = new l.e(this.B.getContext(), this.B, aVar, this.C == null);
                if (aVar.a(eVar, eVar.e())) {
                    eVar.k();
                    this.B.q(eVar);
                    this.A = eVar;
                    if (R0()) {
                        this.B.setAlpha(0.0f);
                        b1 b1VarB = u0.g(this.B).b(1.0f);
                        this.f1530k0 = b1VarB;
                        b1VarB.u(new g());
                    } else {
                        this.B.setAlpha(1.0f);
                        this.B.setVisibility(0);
                        if (this.B.getParent() instanceof View) {
                            u0.v1((View) this.B.getParent());
                        }
                    }
                    if (this.C != null) {
                        this.f1534r.getDecorView().post(this.D);
                    }
                } else {
                    this.A = null;
                }
            }
        }
        l.b bVar2 = this.A;
        if (bVar2 != null && (gVar = this.f1536t) != null) {
            gVar.S(bVar2);
        }
        return this.A;
    }

    public final boolean U(boolean z10) {
        if (this.O7) {
            return false;
        }
        int iX = X();
        boolean zW0 = W0(B0(this.f1533q, iX), z10);
        if (iX == 0) {
            q0(this.f1533q).f();
        } else {
            r rVar = this.U7;
            if (rVar != null) {
                rVar.a();
            }
        }
        if (iX == 3) {
            o0(this.f1533q).f();
        } else {
            r rVar2 = this.V7;
            if (rVar2 != null) {
                rVar2.a();
            }
        }
        return zW0;
    }

    public final void U0() {
        if (this.f1531k1) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void V() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1539v1.findViewById(R.id.content);
        View decorView = this.f1534r.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1533q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            typedArrayObtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            typedArrayObtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            typedArrayObtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @p0
    public final androidx.appcompat.app.f V0() {
        for (Context baseContext = this.f1533q; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof androidx.appcompat.app.f) {
                return (androidx.appcompat.app.f) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final void W(@n0 Window window) {
        if (this.f1534r != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof p) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        p pVar = new p(callback);
        this.f1535s = pVar;
        window.setCallback(pVar);
        y0 y0VarF = y0.F(this.f1533q, null, f1521g8);
        Drawable drawableI = y0VarF.i(0);
        if (drawableI != null) {
            window.setBackgroundDrawable(drawableI);
        }
        y0VarF.I();
        this.f1534r = window;
    }

    public final boolean W0(int i10, boolean z10) {
        boolean z11 = false;
        Configuration configurationD0 = d0(this.f1533q, i10, null, false);
        boolean zA0 = A0(this.f1533q);
        Configuration configuration = this.P7;
        if (configuration == null) {
            configuration = this.f1533q.getResources().getConfiguration();
        }
        int i11 = configuration.uiMode & 48;
        int i12 = configurationD0.uiMode & 48;
        boolean z12 = true;
        if (i11 != i12 && z10 && !zA0 && this.M7 && (f1522h8 || this.N7)) {
            Object obj = this.f1532p;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                f0.b.H((Activity) this.f1532p);
                z11 = true;
            }
        }
        if (z11 || i11 == i12) {
            z12 = z11;
        } else {
            X0(i12, zA0, null);
        }
        if (z12) {
            Object obj2 = this.f1532p;
            if (obj2 instanceof androidx.appcompat.app.f) {
                ((androidx.appcompat.app.f) obj2).L3(i10);
            }
        }
        return z12;
    }

    public final int X() {
        int i10 = this.Q7;
        return i10 != -100 ? i10 : androidx.appcompat.app.h.o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0(int i10, boolean z10, @p0 Configuration configuration) {
        Resources resources = this.f1533q.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            androidx.appcompat.app.n.a(resources);
        }
        int i12 = this.R7;
        if (i12 != 0) {
            this.f1533q.setTheme(i12);
            if (i11 >= 23) {
                this.f1533q.getTheme().applyStyle(this.R7, true);
            }
        }
        if (z10) {
            Object obj = this.f1532p;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof y) {
                    if (((y) activity).e().b().isAtLeast(Lifecycle.State.CREATED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else {
                    if (!this.N7 || this.O7) {
                        return;
                    }
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    public void Y(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.J7;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f1554j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f1559o) && !this.O7) {
            this.f1535s.d(this.f1534r.getCallback(), i10, menu);
        }
    }

    public final int Y0(@p0 j1 j1Var, @p0 Rect rect) {
        boolean z10;
        boolean z11;
        int iR = j1Var != null ? j1Var.r() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.B;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
            if (this.B.isShown()) {
                if (this.f1526a8 == null) {
                    this.f1526a8 = new Rect();
                    this.f1527b8 = new Rect();
                }
                Rect rect2 = this.f1526a8;
                Rect rect3 = this.f1527b8;
                if (j1Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(j1Var.p(), j1Var.r(), j1Var.q(), j1Var.o());
                }
                h1.a(this.f1539v1, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                j1 j1VarO0 = u0.o0(this.f1539v1);
                int iP = j1VarO0 == null ? 0 : j1VarO0.p();
                int iQ = j1VarO0 == null ? 0 : j1VarO0.q();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                if (i10 <= 0 || this.K1 != null) {
                    View view = this.K1;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != iP || marginLayoutParams2.rightMargin != iQ) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = iP;
                            marginLayoutParams2.rightMargin = iQ;
                            this.K1.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1533q);
                    this.K1 = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iP;
                    layoutParams.rightMargin = iQ;
                    this.f1539v1.addView(this.K1, -1, layoutParams);
                }
                View view3 = this.K1;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    Z0(this.K1);
                }
                if (!this.F7 && z) {
                    iR = 0;
                }
                z10 = z;
                z = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z = false;
            }
            if (z) {
                this.B.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.K1;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return iR;
    }

    public void Z(@n0 androidx.appcompat.view.menu.e eVar) {
        if (this.I7) {
            return;
        }
        this.I7 = true;
        this.f1542x.o();
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null && !this.O7) {
            callbackU0.onPanelClosed(108, eVar);
        }
        this.I7 = false;
    }

    public final void Z0(View view) {
        view.setBackgroundColor((u0.C0(view) & 8192) != 0 ? h0.d.f(this.f1533q, androidx.appcompat.R.color.abc_decor_view_status_guard_light) : h0.d.f(this.f1533q, androidx.appcompat.R.color.abc_decor_view_status_guard));
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(@n0 androidx.appcompat.view.menu.e eVar, @n0 MenuItem menuItem) {
        PanelFeatureState panelFeatureStateL0;
        Window.Callback callbackU0 = u0();
        if (callbackU0 == null || this.O7 || (panelFeatureStateL0 = l0(eVar.G())) == null) {
            return false;
        }
        return callbackU0.onMenuItemSelected(panelFeatureStateL0.f1545a, menuItem);
    }

    public final void a0() {
        r rVar = this.U7;
        if (rVar != null) {
            rVar.a();
        }
        r rVar2 = this.V7;
        if (rVar2 != null) {
            rVar2.a();
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(@n0 androidx.appcompat.view.menu.e eVar) {
        P0(true);
    }

    public void b0(int i10) {
        c0(r0(i10, true), true);
    }

    public void c0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        b0 b0Var;
        if (z10 && panelFeatureState.f1545a == 0 && (b0Var = this.f1542x) != null && b0Var.e()) {
            Z(panelFeatureState.f1554j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1533q.getSystemService("window");
        if (windowManager != null && panelFeatureState.f1559o && (viewGroup = panelFeatureState.f1551g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                Y(panelFeatureState.f1545a, panelFeatureState, null);
            }
        }
        panelFeatureState.f1557m = false;
        panelFeatureState.f1558n = false;
        panelFeatureState.f1559o = false;
        panelFeatureState.f1552h = null;
        panelFeatureState.f1561q = true;
        if (this.K7 == panelFeatureState) {
            this.K7 = null;
        }
    }

    @Override // androidx.appcompat.app.h
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.f1539v1.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1535s.c(this.f1534r.getCallback());
    }

    @n0
    public final Configuration d0(@n0 Context context, int i10, @p0 Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    @Override // androidx.appcompat.app.h
    public boolean e() {
        return U(true);
    }

    public final ViewGroup e0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1533q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        int i10 = androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            I(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            I(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            I(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            I(10);
        }
        this.G7 = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        k0();
        this.f1534r.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1533q);
        if (this.H7) {
            viewGroup = this.F7 ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.G7) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.E7 = false;
            this.K2 = false;
        } else if (this.K2) {
            TypedValue typedValue = new TypedValue();
            this.f1533q.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new l.d(this.f1533q, typedValue.resourceId) : this.f1533q).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
            b0 b0Var = (b0) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.f1542x = b0Var;
            b0Var.setWindowCallback(u0());
            if (this.E7) {
                this.f1542x.n(109);
            }
            if (this.f1540v2) {
                this.f1542x.n(2);
            }
            if (this.C2) {
                this.f1542x.n(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.K2 + ", windowActionBarOverlay: " + this.E7 + ", android:windowIsFloating: " + this.G7 + ", windowActionModeOverlay: " + this.F7 + ", windowNoTitle: " + this.H7 + " }");
        }
        u0.a2(viewGroup, new c());
        if (this.f1542x == null) {
            this.C1 = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        h1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f1534r.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1534r.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    public void f0() {
        androidx.appcompat.view.menu.e eVar;
        b0 b0Var = this.f1542x;
        if (b0Var != null) {
            b0Var.o();
        }
        if (this.C != null) {
            this.f1534r.getDecorView().removeCallbacks(this.D);
            if (this.C.isShowing()) {
                try {
                    this.C.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.C = null;
        }
        i0();
        PanelFeatureState panelFeatureStateR0 = r0(0, false);
        if (panelFeatureStateR0 == null || (eVar = panelFeatureStateR0.f1554j) == null) {
            return;
        }
        eVar.close();
    }

    public boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1532p;
        if (((obj instanceof o.a) || (obj instanceof androidx.appcompat.app.j)) && (decorView = this.f1534r.getDecorView()) != null && androidx.core.view.o.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1535s.b(this.f1534r.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? D0(keyCode, keyEvent) : G0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.h
    @g.i
    @n0
    public Context h(@n0 Context context) {
        this.M7 = true;
        int iB0 = B0(context, X());
        boolean z10 = false;
        if (f1523i8 && (context instanceof ContextThemeWrapper)) {
            try {
                t.a((ContextThemeWrapper) context, d0(context, iB0, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof l.d) {
            try {
                ((l.d) context).a(d0(context, iB0, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1522h8) {
            return super.h(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = l.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationD0 = d0(context, iB0, configuration2.equals(configuration3) ? null : m0(configuration2, configuration3), true);
        l.d dVar = new l.d(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        dVar.a(configurationD0);
        try {
            z10 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z10) {
            i.h.a(dVar.getTheme());
        }
        return super.h(dVar);
    }

    public void h0(int i10) {
        PanelFeatureState panelFeatureStateR0;
        PanelFeatureState panelFeatureStateR02 = r0(i10, true);
        if (panelFeatureStateR02.f1554j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateR02.f1554j.V(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateR02.f1565u = bundle;
            }
            panelFeatureStateR02.f1554j.m0();
            panelFeatureStateR02.f1554j.clear();
        }
        panelFeatureStateR02.f1562r = true;
        panelFeatureStateR02.f1561q = true;
        if ((i10 != 108 && i10 != 0) || this.f1542x == null || (panelFeatureStateR0 = r0(0, false)) == null) {
            return;
        }
        panelFeatureStateR0.f1557m = false;
        O0(panelFeatureStateR0, null);
    }

    public void i0() {
        b1 b1Var = this.f1530k0;
        if (b1Var != null) {
            b1Var.d();
        }
    }

    public final void j0() {
        if (this.f1531k1) {
            return;
        }
        this.f1539v1 = e0();
        CharSequence charSequenceT0 = t0();
        if (!TextUtils.isEmpty(charSequenceT0)) {
            b0 b0Var = this.f1542x;
            if (b0Var != null) {
                b0Var.setWindowTitle(charSequenceT0);
            } else if (M0() != null) {
                M0().B0(charSequenceT0);
            } else {
                TextView textView = this.C1;
                if (textView != null) {
                    textView.setText(charSequenceT0);
                }
            }
        }
        V();
        K0(this.f1539v1);
        this.f1531k1 = true;
        PanelFeatureState panelFeatureStateR0 = r0(0, false);
        if (this.O7) {
            return;
        }
        if (panelFeatureStateR0 == null || panelFeatureStateR0.f1554j == null) {
            z0(108);
        }
    }

    public final void k0() {
        if (this.f1534r == null) {
            Object obj = this.f1532p;
            if (obj instanceof Activity) {
                W(((Activity) obj).getWindow());
            }
        }
        if (this.f1534r == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public PanelFeatureState l0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.J7;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f1554j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.h
    public View m(View view, String str, @n0 Context context, @n0 AttributeSet attributeSet) {
        boolean z10;
        boolean zS0 = false;
        if (this.f1528c8 == null) {
            String string = this.f1533q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f1528c8 = new androidx.appcompat.app.k();
            } else {
                try {
                    this.f1528c8 = (androidx.appcompat.app.k) this.f1533q.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to instantiate custom view inflater ");
                    sb2.append(string);
                    sb2.append(". Falling back to default.");
                    this.f1528c8 = new androidx.appcompat.app.k();
                }
            }
        }
        boolean z11 = f1520f8;
        if (z11) {
            if (this.f1529d8 == null) {
                this.f1529d8 = new androidx.appcompat.app.l();
            }
            if (this.f1529d8.a(attributeSet)) {
                z10 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zS0 = S0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zS0 = true;
                }
                z10 = zS0;
            }
        } else {
            z10 = false;
        }
        return this.f1528c8.r(view, str, context, attributeSet, z10, z11, true, g1.d());
    }

    @Override // androidx.appcompat.app.h
    @p0
    public <T extends View> T n(@d0 int i10) {
        j0();
        return (T) this.f1534r.findViewById(i10);
    }

    public final Context n0() {
        androidx.appcompat.app.a aVarS = s();
        Context contextA = aVarS != null ? aVarS.A() : null;
        return contextA == null ? this.f1533q : contextA;
    }

    public final r o0(@n0 Context context) {
        if (this.V7 == null) {
            this.V7 = new q(context);
        }
        return this.V7;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.h
    public final c.b p() {
        return new h();
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public final r p0() {
        return q0(this.f1533q);
    }

    @Override // androidx.appcompat.app.h
    public int q() {
        return this.Q7;
    }

    public final r q0(@n0 Context context) {
        if (this.U7 == null) {
            this.U7 = new s(androidx.appcompat.app.q.a(context));
        }
        return this.U7;
    }

    @Override // androidx.appcompat.app.h
    public MenuInflater r() {
        if (this.f1538v == null) {
            v0();
            androidx.appcompat.app.a aVar = this.f1537u;
            this.f1538v = new l.g(aVar != null ? aVar.A() : this.f1533q);
        }
        return this.f1538v;
    }

    public PanelFeatureState r0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.J7;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.J7 = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.h
    public androidx.appcompat.app.a s() {
        v0();
        return this.f1537u;
    }

    public ViewGroup s0() {
        return this.f1539v1;
    }

    @Override // androidx.appcompat.app.h
    public boolean t(int i10) {
        int iQ0 = Q0(i10);
        return (iQ0 != 1 ? iQ0 != 2 ? iQ0 != 5 ? iQ0 != 10 ? iQ0 != 108 ? iQ0 != 109 ? false : this.E7 : this.K2 : this.F7 : this.C2 : this.f1540v2 : this.H7) || this.f1534r.hasFeature(i10);
    }

    public final CharSequence t0() {
        Object obj = this.f1532p;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1541w;
    }

    @Override // androidx.appcompat.app.h
    public void u() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1533q);
        if (layoutInflaterFrom.getFactory() == null) {
            androidx.core.view.p.d(layoutInflaterFrom, this);
        } else {
            boolean z10 = layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    public final Window.Callback u0() {
        return this.f1534r.getCallback();
    }

    @Override // androidx.appcompat.app.h
    public void v() {
        if (M0() == null || s().D()) {
            return;
        }
        z0(0);
    }

    public final void v0() {
        j0();
        if (this.K2 && this.f1537u == null) {
            Object obj = this.f1532p;
            if (obj instanceof Activity) {
                this.f1537u = new androidx.appcompat.app.r((Activity) this.f1532p, this.E7);
            } else if (obj instanceof Dialog) {
                this.f1537u = new androidx.appcompat.app.r((Dialog) this.f1532p);
            }
            androidx.appcompat.app.a aVar = this.f1537u;
            if (aVar != null) {
                aVar.X(this.Z7);
            }
        }
    }

    public final boolean w0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f1553i;
        if (view != null) {
            panelFeatureState.f1552h = view;
            return true;
        }
        if (panelFeatureState.f1554j == null) {
            return false;
        }
        if (this.f1544z == null) {
            this.f1544z = new v();
        }
        View view2 = (View) panelFeatureState.c(this.f1544z);
        panelFeatureState.f1552h = view2;
        return view2 != null;
    }

    @Override // androidx.appcompat.app.h
    public boolean x() {
        return this.K0;
    }

    public final boolean x0(PanelFeatureState panelFeatureState) {
        panelFeatureState.h(n0());
        panelFeatureState.f1551g = new u(panelFeatureState.f1556l);
        panelFeatureState.f1547c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.h
    public void y(Configuration configuration) {
        androidx.appcompat.app.a aVarS;
        if (this.K2 && this.f1531k1 && (aVarS = s()) != null) {
            aVarS.I(configuration);
        }
        androidx.appcompat.widget.i.b().g(this.f1533q);
        this.P7 = new Configuration(this.f1533q.getResources().getConfiguration());
        U(false);
        configuration.updateFrom(this.f1533q.getResources().getConfiguration());
    }

    public final boolean y0(PanelFeatureState panelFeatureState) {
        Context context = this.f1533q;
        int i10 = panelFeatureState.f1545a;
        if ((i10 == 0 || i10 == 108) && this.f1542x != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                l.d dVar = new l.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.X(this);
        panelFeatureState.g(eVar);
        return true;
    }

    @Override // androidx.appcompat.app.h
    public void z(Bundle bundle) {
        this.M7 = true;
        U(false);
        k0();
        Object obj = this.f1532p;
        if (obj instanceof Activity) {
            String strD = null;
            try {
                strD = f0.r.d((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strD != null) {
                androidx.appcompat.app.a aVarM0 = M0();
                if (aVarM0 == null) {
                    this.Z7 = true;
                } else {
                    aVarM0.X(true);
                }
            }
            androidx.appcompat.app.h.c(this);
        }
        this.P7 = new Configuration(this.f1533q.getResources().getConfiguration());
        this.N7 = true;
    }

    public final void z0(int i10) {
        this.X7 = (1 << i10) | this.X7;
        if (this.W7) {
            return;
        }
        u0.p1(this.f1534r.getDecorView(), this.Y7);
        this.W7 = true;
    }

    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.g gVar) {
        this(dialog.getContext(), dialog.getWindow(), gVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.g gVar) {
        this(context, window, gVar, context);
    }

    public class p extends l.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f1582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1585e;

        public p(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1584d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1584d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1583c = true;
                callback.onContentChanged();
            } finally {
                this.f1583c = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f1585e = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f1585e = false;
            }
        }

        @Override // l.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1584d ? a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // l.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.F0(keyEvent.getKeyCode(), keyEvent);
        }

        public void e(@p0 i iVar) {
            this.f1582b = iVar;
        }

        public final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f1533q, callback);
            l.b bVarT = AppCompatDelegateImpl.this.T(aVar);
            if (bVarT != null) {
                return aVar.e(bVarT);
            }
            return null;
        }

        @Override // l.i, android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1583c) {
                a().onContentChanged();
            }
        }

        @Override // l.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // l.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View viewOnCreatePanelView;
            i iVar = this.f1582b;
            return (iVar == null || (viewOnCreatePanelView = iVar.onCreatePanelView(i10)) == null) ? super.onCreatePanelView(i10) : viewOnCreatePanelView;
        }

        @Override // l.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.I0(i10);
            return true;
        }

        @Override // l.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f1585e) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                AppCompatDelegateImpl.this.J0(i10);
            }
        }

        @Override // l.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.i0(true);
            }
            i iVar = this.f1582b;
            boolean zOnPreparePanel = iVar != null && iVar.a(i10);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            }
            if (eVar != null) {
                eVar.i0(false);
            }
            return zOnPreparePanel;
        }

        @Override // l.i, android.view.Window.Callback
        @v0(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState panelFeatureStateR0 = AppCompatDelegateImpl.this.r0(0, true);
            if (panelFeatureStateR0 == null || (eVar = panelFeatureStateR0.f1554j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        @Override // l.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.x() ? f(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // l.i, android.view.Window.Callback
        @v0(23)
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (AppCompatDelegateImpl.this.x() && i10 == 0) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback, i10);
        }
    }

    public AppCompatDelegateImpl(Context context, Activity activity, androidx.appcompat.app.g gVar) {
        this(context, null, gVar, activity);
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.g gVar, Object obj) {
        androidx.collection.l<String, Integer> lVar;
        Integer num;
        androidx.appcompat.app.f fVarV0;
        this.f1530k0 = null;
        this.K0 = true;
        this.Q7 = -100;
        this.Y7 = new b();
        this.f1533q = context;
        this.f1536t = gVar;
        this.f1532p = obj;
        if (this.Q7 == -100 && (obj instanceof Dialog) && (fVarV0 = V0()) != null) {
            this.Q7 = fVarV0.H3().q();
        }
        if (this.Q7 == -100 && (num = (lVar = f1519e8).get(obj.getClass().getName())) != null) {
            this.Q7 = num.intValue();
            lVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            W(window);
        }
        androidx.appcompat.widget.i.i();
    }
}
