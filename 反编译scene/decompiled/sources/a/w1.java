package a;

import a.cg;
import a.hn;
import a.i4;
import a.k3;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w1 extends x0 implements i4.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ia<String, Integer> f7742a = new ia<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f3323a;
    public static final boolean u;
    public static final boolean v;
    public static final boolean w;
    public static boolean x;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a2 f3324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c7 f3325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d0 f3326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h1 f3327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k1 f3328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k3 f3329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lh f3330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n1 f3331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u1 f3332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v1 f3333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final w0 f3334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f3336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MenuInflater f3337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f3338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f3339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Window f3340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow f3341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f3342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarContextView f3343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f3345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u1[] f3346a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public n1 f3347b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Rect f3348b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Object f3349b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f3350b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3351b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3352c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3353d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    static {
        u = Build.VERSION.SDK_INT < 21;
        f3323a = new int[]{R.attr.windowBackground};
        v = !"robolectric".equals(Build.FINGERPRINT);
        w = Build.VERSION.SDK_INT >= 17;
        if (!u || x) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new y0(Thread.getDefaultUncaughtExceptionHandler()));
        x = true;
    }

    public w1(Activity activity, w0 w0Var) {
        this(activity, null, w0Var, activity);
    }

    public w1(Dialog dialog, w0 w0Var) {
        this(dialog.getContext(), dialog.getWindow(), w0Var, dialog);
    }

    public w1(Context context, Window window, w0 w0Var, Object obj) {
        Integer num;
        v0 v0VarN0;
        this.f3330a = null;
        this.f3351b = true;
        this.b = -100;
        this.f3350b = new z0(this);
        this.f3335a = context;
        this.f3334a = w0Var;
        this.f3349b = obj;
        if (this.b == -100 && (obj instanceof Dialog) && (v0VarN0 = N0()) != null) {
            this.b = v0VarN0.getDelegate().n();
        }
        if (this.b == -100 && (num = f7742a.get(this.f3349b.getClass().getName())) != null) {
            this.b = num.intValue();
            f7742a.remove(this.f3349b.getClass().getName());
        }
        if (window != null) {
            O(window);
        }
        v5.h();
    }

    public static Configuration f0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i = configuration.mcc;
            int i2 = configuration2.mcc;
            if (i != i2) {
                configuration3.mcc = i2;
            }
            int i3 = configuration.mnc;
            int i4 = configuration2.mnc;
            if (i3 != i4) {
                configuration3.mnc = i4;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                q1.a(configuration, configuration2, configuration3);
            } else if (!kf.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i5 = configuration.touchscreen;
            int i6 = configuration2.touchscreen;
            if (i5 != i6) {
                configuration3.touchscreen = i6;
            }
            int i7 = configuration.keyboard;
            int i8 = configuration2.keyboard;
            if (i7 != i8) {
                configuration3.keyboard = i8;
            }
            int i9 = configuration.keyboardHidden;
            int i10 = configuration2.keyboardHidden;
            if (i9 != i10) {
                configuration3.keyboardHidden = i10;
            }
            int i11 = configuration.navigation;
            int i12 = configuration2.navigation;
            if (i11 != i12) {
                configuration3.navigation = i12;
            }
            int i13 = configuration.navigationHidden;
            int i14 = configuration2.navigationHidden;
            if (i13 != i14) {
                configuration3.navigationHidden = i14;
            }
            int i15 = configuration.orientation;
            int i16 = configuration2.orientation;
            if (i15 != i16) {
                configuration3.orientation = i16;
            }
            int i17 = configuration.screenLayout & 15;
            int i18 = configuration2.screenLayout;
            if (i17 != (i18 & 15)) {
                configuration3.screenLayout |= i18 & 15;
            }
            int i19 = configuration.screenLayout & 192;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 192)) {
                configuration3.screenLayout |= i20 & 192;
            }
            int i21 = configuration.screenLayout & 48;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 48)) {
                configuration3.screenLayout |= i22 & 48;
            }
            int i23 = configuration.screenLayout & 768;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 768)) {
                configuration3.screenLayout |= i24 & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                r1.a(configuration, configuration2, configuration3);
            }
            int i25 = configuration.uiMode & 15;
            int i26 = configuration2.uiMode;
            if (i25 != (i26 & 15)) {
                configuration3.uiMode |= i26 & 15;
            }
            int i27 = configuration.uiMode & 48;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 48)) {
                configuration3.uiMode |= i28 & 48;
            }
            int i29 = configuration.screenWidthDp;
            int i30 = configuration2.screenWidthDp;
            if (i29 != i30) {
                configuration3.screenWidthDp = i30;
            }
            int i31 = configuration.screenHeightDp;
            int i32 = configuration2.screenHeightDp;
            if (i31 != i32) {
                configuration3.screenHeightDp = i32;
            }
            int i33 = configuration.smallestScreenWidthDp;
            int i34 = configuration2.smallestScreenWidthDp;
            if (i33 != i34) {
                configuration3.smallestScreenWidthDp = i34;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                p1.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    public void A0(int i) {
        d0 d0VarP;
        if (i != 108 || (d0VarP = p()) == null) {
            return;
        }
        d0VarP.i(true);
    }

    public void B0(int i) {
        if (i == 108) {
            d0 d0VarP = p();
            if (d0VarP != null) {
                d0VarP.i(false);
                return;
            }
            return;
        }
        if (i == 0) {
            u1 u1VarJ0 = j0(i, true);
            if (u1VarJ0.f3102c) {
                U(u1VarJ0, false);
            }
        }
    }

    @Override // a.x0
    public boolean C(int i) {
        int iI0 = I0(i);
        if (this.j && iI0 == 108) {
            return false;
        }
        if (this.f && iI0 == 1) {
            this.f = false;
        }
        if (iI0 == 1) {
            M0();
            this.j = true;
            return true;
        }
        if (iI0 == 2) {
            M0();
            this.f3353d = true;
            return true;
        }
        if (iI0 == 5) {
            M0();
            this.e = true;
            return true;
        }
        if (iI0 == 10) {
            M0();
            this.h = true;
            return true;
        }
        if (iI0 == 108) {
            M0();
            this.f = true;
            return true;
        }
        if (iI0 != 109) {
            return this.f3340a.requestFeature(iI0);
        }
        M0();
        this.g = true;
        return true;
    }

    public void C0(ViewGroup viewGroup) {
    }

    @Override // a.x0
    public void D(int i) {
        c0();
        ViewGroup viewGroup = (ViewGroup) this.f3339a.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3335a).inflate(i, viewGroup);
        this.f3328a.a().onContentChanged();
    }

    public final void D0(u1 u1Var, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (u1Var.f3102c || this.p) {
            return;
        }
        if (u1Var.f7553a == 0) {
            if ((this.f3335a.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackL0 = l0();
        if (callbackL0 != null && !callbackL0.onMenuOpened(u1Var.f7553a, u1Var.f3094a)) {
            U(u1Var, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3335a.getSystemService("window");
        if (windowManager != null && G0(u1Var, keyEvent)) {
            if (u1Var.f3098a != null && !u1Var.f3104e) {
                View view = u1Var.f3100b;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                u1Var.f3101b = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, u1Var.d, u1Var.e, 1002, 8519680, -3);
                layoutParams2.gravity = u1Var.c;
                layoutParams2.windowAnimations = u1Var.f;
                windowManager.addView(u1Var.f3098a, layoutParams2);
                u1Var.f3102c = true;
            }
            ViewGroup viewGroup = u1Var.f3098a;
            if (viewGroup == null) {
                if (!o0(u1Var) || u1Var.f3098a == null) {
                    return;
                }
            } else if (u1Var.f3104e && viewGroup.getChildCount() > 0) {
                u1Var.f3098a.removeAllViews();
            }
            if (!n0(u1Var) || !u1Var.b()) {
                u1Var.f3104e = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = u1Var.f3097a.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            u1Var.f3098a.setBackgroundResource(u1Var.b);
            ViewParent parent = u1Var.f3097a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(u1Var.f3097a);
            }
            u1Var.f3098a.addView(u1Var.f3097a, layoutParams3);
            if (!u1Var.f3097a.hasFocus()) {
                u1Var.f3097a.requestFocus();
            }
            i = -2;
            u1Var.f3101b = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, u1Var.d, u1Var.e, 1002, 8519680, -3);
            layoutParams22.gravity = u1Var.c;
            layoutParams22.windowAnimations = u1Var.f;
            windowManager.addView(u1Var.f3098a, layoutParams22);
            u1Var.f3102c = true;
        }
    }

    @Override // a.x0
    public void E(View view) {
        c0();
        ViewGroup viewGroup = (ViewGroup) this.f3339a.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3328a.a().onContentChanged();
    }

    public final d0 E0() {
        return this.f3326a;
    }

    @Override // a.x0
    public void F(View view, ViewGroup.LayoutParams layoutParams) {
        c0();
        ViewGroup viewGroup = (ViewGroup) this.f3339a.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3328a.a().onContentChanged();
    }

    public final boolean F0(u1 u1Var, int i, KeyEvent keyEvent, int i2) {
        i4 i4Var;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((u1Var.f3099a || G0(u1Var, keyEvent)) && (i4Var = u1Var.f3094a) != null) {
            zPerformShortcut = i4Var.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.f3325a == null) {
            U(u1Var, true);
        }
        return zPerformShortcut;
    }

    public final boolean G0(u1 u1Var, KeyEvent keyEvent) {
        c7 c7Var;
        c7 c7Var2;
        c7 c7Var3;
        if (this.p) {
            return false;
        }
        if (u1Var.f3099a) {
            return true;
        }
        u1 u1Var2 = this.f3332a;
        if (u1Var2 != null && u1Var2 != u1Var) {
            U(u1Var2, false);
        }
        Window.Callback callbackL0 = l0();
        if (callbackL0 != null) {
            u1Var.f3100b = callbackL0.onCreatePanelView(u1Var.f7553a);
        }
        int i = u1Var.f7553a;
        boolean z = i == 0 || i == 108;
        if (z && (c7Var3 = this.f3325a) != null) {
            c7Var3.a();
        }
        if (u1Var.f3100b == null && (!z || !(E0() instanceof h2))) {
            if (u1Var.f3094a == null || u1Var.f3105f) {
                if (u1Var.f3094a == null && (!p0(u1Var) || u1Var.f3094a == null)) {
                    return false;
                }
                if (z && this.f3325a != null) {
                    if (this.f3327a == null) {
                        this.f3327a = new h1(this);
                    }
                    this.f3325a.b(u1Var.f3094a, this.f3327a);
                }
                u1Var.f3094a.d0();
                if (!callbackL0.onCreatePanelMenu(u1Var.f7553a, u1Var.f3094a)) {
                    u1Var.c(null);
                    if (z && (c7Var = this.f3325a) != null) {
                        c7Var.b(null, this.f3327a);
                    }
                    return false;
                }
                u1Var.f3105f = false;
            }
            u1Var.f3094a.d0();
            Bundle bundle = u1Var.f3096a;
            if (bundle != null) {
                u1Var.f3094a.P(bundle);
                u1Var.f3096a = null;
            }
            if (!callbackL0.onPreparePanel(0, u1Var.f3100b, u1Var.f3094a)) {
                if (z && (c7Var2 = this.f3325a) != null) {
                    c7Var2.b(null, this.f3327a);
                }
                u1Var.f3094a.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            u1Var.f3103d = z2;
            u1Var.f3094a.setQwertyMode(z2);
            u1Var.f3094a.c0();
        }
        u1Var.f3099a = true;
        u1Var.f3101b = false;
        this.f3332a = u1Var;
        return true;
    }

    @Override // a.x0
    public void H(int i) {
        if (this.b != i) {
            this.b = i;
            if (this.m) {
                e();
            }
        }
    }

    public final void H0(boolean z) {
        c7 c7Var = this.f3325a;
        if (c7Var == null || !c7Var.c() || (ViewConfiguration.get(this.f3335a).hasPermanentMenuKey() && !this.f3325a.g())) {
            u1 u1VarJ0 = j0(0, true);
            u1VarJ0.f3104e = true;
            U(u1VarJ0, false);
            D0(u1VarJ0, null);
            return;
        }
        Window.Callback callbackL0 = l0();
        if (this.f3325a.d() && z) {
            this.f3325a.e();
            if (this.p) {
                return;
            }
            callbackL0.onPanelClosed(108, j0(0, true).f3094a);
            return;
        }
        if (callbackL0 == null || this.p) {
            return;
        }
        if (this.s && (this.d & 1) != 0) {
            this.f3340a.getDecorView().removeCallbacks(this.f3350b);
            this.f3350b.run();
        }
        u1 u1VarJ02 = j0(0, true);
        i4 i4Var = u1VarJ02.f3094a;
        if (i4Var == null || u1VarJ02.f3105f || !callbackL0.onPreparePanel(0, u1VarJ02.f3100b, i4Var)) {
            return;
        }
        callbackL0.onMenuOpened(108, u1VarJ02.f3094a);
        this.f3325a.f();
    }

    @Override // a.x0
    public void I(Toolbar toolbar) {
        Window window;
        Window.Callback callbackY;
        if (this.f3349b instanceof Activity) {
            d0 d0VarP = p();
            if (d0VarP instanceof p2) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f3337a = null;
            if (d0VarP != null) {
                d0VarP.n();
            }
            if (toolbar != null) {
                h2 h2Var = new h2(toolbar, k0(), this.f3328a);
                this.f3326a = h2Var;
                window = this.f3340a;
                callbackY = h2Var.y();
            } else {
                this.f3326a = null;
                window = this.f3340a;
                callbackY = this.f3328a;
            }
            window.setCallback(callbackY);
            r();
        }
    }

    public final int I0(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    @Override // a.x0
    public void J(int i) {
        this.c = i;
    }

    public final boolean J0() {
        ViewGroup viewGroup;
        return this.f3352c && (viewGroup = this.f3339a) != null && eh.Q(viewGroup);
    }

    @Override // a.x0
    public final void K(CharSequence charSequence) {
        this.f3344a = charSequence;
        c7 c7Var = this.f3325a;
        if (c7Var != null) {
            c7Var.setWindowTitle(charSequence);
            return;
        }
        if (E0() != null) {
            E0().v(charSequence);
            return;
        }
        TextView textView = this.f3342a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean K0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f3340a.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || eh.P((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // a.x0
    public k3 L(k3.a aVar) {
        w0 w0Var;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        k3 k3Var = this.f3329a;
        if (k3Var != null) {
            k3Var.c();
        }
        j1 j1Var = new j1(this, aVar);
        d0 d0VarP = p();
        if (d0VarP != null) {
            k3 k3VarW = d0VarP.w(j1Var);
            this.f3329a = k3VarW;
            if (k3VarW != null && (w0Var = this.f3334a) != null) {
                w0Var.onSupportActionModeStarted(k3VarW);
            }
        }
        if (this.f3329a == null) {
            this.f3329a = L0(j1Var);
        }
        return this.f3329a;
    }

    public k3 L0(k3.a aVar) {
        k3 k3VarOnWindowStartingSupportActionMode;
        Context m3Var;
        w0 w0Var;
        b0();
        k3 k3Var = this.f3329a;
        if (k3Var != null) {
            k3Var.c();
        }
        if (!(aVar instanceof j1)) {
            aVar = new j1(this, aVar);
        }
        w0 w0Var2 = this.f3334a;
        if (w0Var2 == null || this.p) {
            k3VarOnWindowStartingSupportActionMode = null;
        } else {
            try {
                k3VarOnWindowStartingSupportActionMode = w0Var2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
                k3VarOnWindowStartingSupportActionMode = null;
            }
        }
        if (k3VarOnWindowStartingSupportActionMode != null) {
            this.f3329a = k3VarOnWindowStartingSupportActionMode;
        } else {
            if (this.f3343a == null) {
                if (this.i) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f3335a.getTheme();
                    theme.resolveAttribute(t.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f3335a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        m3Var = new m3(this.f3335a, 0);
                        m3Var.getTheme().setTo(themeNewTheme);
                    } else {
                        m3Var = this.f3335a;
                    }
                    this.f3343a = new ActionBarContextView(m3Var);
                    PopupWindow popupWindow = new PopupWindow(m3Var, (AttributeSet) null, t.actionModePopupWindowStyle);
                    this.f3341a = popupWindow;
                    mj.b(popupWindow, 2);
                    this.f3341a.setContentView(this.f3343a);
                    this.f3341a.setWidth(-1);
                    m3Var.getTheme().resolveAttribute(t.actionBarSize, typedValue, true);
                    this.f3343a.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, m3Var.getResources().getDisplayMetrics()));
                    this.f3341a.setHeight(-2);
                    this.f3345a = new e1(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f3339a.findViewById(y.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(g0()));
                        this.f3343a = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f3343a != null) {
                b0();
                this.f3343a.k();
                n3 n3Var = new n3(this.f3343a.getContext(), this.f3343a, aVar, this.f3341a == null);
                if (aVar.b(n3Var, n3Var.e())) {
                    n3Var.k();
                    this.f3343a.h(n3Var);
                    this.f3329a = n3Var;
                    if (J0()) {
                        this.f3343a.setAlpha(0.0f);
                        lh lhVarC = eh.c(this.f3343a);
                        lhVarC.a(1.0f);
                        this.f3330a = lhVarC;
                        lhVarC.f(new f1(this));
                    } else {
                        this.f3343a.setAlpha(1.0f);
                        this.f3343a.setVisibility(0);
                        this.f3343a.sendAccessibilityEvent(32);
                        if (this.f3343a.getParent() instanceof View) {
                            eh.h0((View) this.f3343a.getParent());
                        }
                    }
                    if (this.f3341a != null) {
                        this.f3340a.getDecorView().post(this.f3345a);
                    }
                } else {
                    this.f3329a = null;
                }
            }
        }
        k3 k3Var2 = this.f3329a;
        if (k3Var2 != null && (w0Var = this.f3334a) != null) {
            w0Var.onSupportActionModeStarted(k3Var2);
        }
        return this.f3329a;
    }

    public final boolean M(boolean z) {
        if (this.p) {
            return false;
        }
        int iP = P();
        boolean zO0 = O0(t0(this.f3335a, iP), z);
        if (iP == 0) {
            i0(this.f3335a).e();
        } else {
            n1 n1Var = this.f3331a;
            if (n1Var != null) {
                n1Var.a();
            }
        }
        if (iP == 3) {
            h0(this.f3335a).e();
        } else {
            n1 n1Var2 = this.f3347b;
            if (n1Var2 != null) {
                n1Var2.a();
            }
        }
        return zO0;
    }

    public final void M0() {
        if (this.f3352c) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void N() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f3339a.findViewById(R.id.content);
        View decorView = this.f3340a.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f3335a.obtainStyledAttributes(c0.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(c0.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final v0 N0() {
        for (Context baseContext = this.f3335a; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof v0) {
                return (v0) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final void O(Window window) {
        if (this.f3340a != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof k1) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        k1 k1Var = new k1(this, callback);
        this.f3328a = k1Var;
        window.setCallback(k1Var);
        o8 o8VarU = o8.u(this.f3335a, null, f3323a);
        Drawable drawableH = o8VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        o8VarU.w();
        this.f3340a = window;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean O0(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3335a
            r1 = 0
            android.content.res.Configuration r0 = r6.V(r0, r7, r1)
            boolean r2 = r6.r0()
            android.content.Context r3 = r6.f3335a
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L47
            if (r8 == 0) goto L47
            if (r2 != 0) goto L47
            boolean r8 = r6.m
            if (r8 == 0) goto L47
            boolean r8 = a.w1.v
            if (r8 != 0) goto L30
            boolean r8 = r6.n
            if (r8 == 0) goto L47
        L30:
            java.lang.Object r8 = r6.f3349b
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L47
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L47
            java.lang.Object r8 = r6.f3349b
            android.app.Activity r8 = (android.app.Activity) r8
            a.va.l(r8)
            r8 = r4
            goto L48
        L47:
            r8 = 0
        L48:
            if (r8 != 0) goto L50
            if (r3 == r0) goto L50
            r6.P0(r0, r2, r1)
            goto L51
        L50:
            r4 = r8
        L51:
            if (r4 == 0) goto L5e
            java.lang.Object r8 = r6.f3349b
            boolean r0 = r8 instanceof a.v0
            if (r0 == 0) goto L5e
            a.v0 r8 = (a.v0) r8
            r8.onNightModeChanged(r7)
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.w1.O0(int, boolean):boolean");
    }

    public final int P() {
        int i = this.b;
        return i != -100 ? i : x0.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P0(int i, boolean z, Configuration configuration) {
        Resources resources = this.f3335a.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            b2.a(resources);
        }
        int i2 = this.c;
        if (i2 != 0) {
            this.f3335a.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f3335a.getTheme().applyStyle(this.c, true);
            }
        }
        if (z) {
            Object obj = this.f3349b;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof kn) {
                    if (!((kn) activity).getLifecycle().b().a(hn.b.STARTED)) {
                        return;
                    }
                } else if (!this.o) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    public void Q(int i, u1 u1Var, Menu menu) {
        if (menu == null) {
            if (u1Var == null && i >= 0) {
                u1[] u1VarArr = this.f3346a;
                if (i < u1VarArr.length) {
                    u1Var = u1VarArr[i];
                }
            }
            if (u1Var != null) {
                menu = u1Var.f3094a;
            }
        }
        if ((u1Var == null || u1Var.f3102c) && !this.p) {
            this.f3328a.a().onPanelClosed(i, menu);
        }
    }

    public final int Q0(sh shVar, Rect rect) {
        boolean z;
        boolean z2;
        int i = shVar != null ? shVar.i() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f3343a;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3343a.getLayoutParams();
            if (this.f3343a.isShown()) {
                if (this.f3336a == null) {
                    this.f3336a = new Rect();
                    this.f3348b = new Rect();
                }
                Rect rect2 = this.f3336a;
                Rect rect3 = this.f3348b;
                if (shVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(shVar.g(), shVar.i(), shVar.h(), shVar.f());
                }
                z8.a(this.f3339a, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                sh shVarF = eh.F(this.f3339a);
                int iG = shVarF == null ? 0 : shVarF.g();
                int iH = shVarF == null ? 0 : shVarF.h();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.f3338a != null) {
                    View view = this.f3338a;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != iG || marginLayoutParams2.rightMargin != iH) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = iG;
                            marginLayoutParams2.rightMargin = iH;
                            this.f3338a.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f3335a);
                    this.f3338a = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iG;
                    layoutParams.rightMargin = iH;
                    this.f3339a.addView(this.f3338a, -1, layoutParams);
                }
                z = this.f3338a != null;
                if (z && this.f3338a.getVisibility() != 0) {
                    R0(this.f3338a);
                }
                if (!this.h && z) {
                    i = 0;
                }
                z = z;
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                this.f3343a.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f3338a;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    public void R(i4 i4Var) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.f3325a.o();
        Window.Callback callbackL0 = l0();
        if (callbackL0 != null && !this.p) {
            callbackL0.onPanelClosed(108, i4Var);
        }
        this.k = false;
    }

    public final void R0(View view) {
        Context context;
        int i;
        if ((eh.J(view) & 8192) != 0) {
            context = this.f3335a;
            i = v.abc_decor_view_status_guard_light;
        } else {
            context = this.f3335a;
            i = v.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(yb.b(context, i));
    }

    public final void S() {
        n1 n1Var = this.f3331a;
        if (n1Var != null) {
            n1Var.a();
        }
        n1 n1Var2 = this.f3347b;
        if (n1Var2 != null) {
            n1Var2.a();
        }
    }

    public void T(int i) {
        U(j0(i, true), true);
    }

    public void U(u1 u1Var, boolean z) {
        ViewGroup viewGroup;
        c7 c7Var;
        if (z && u1Var.f7553a == 0 && (c7Var = this.f3325a) != null && c7Var.d()) {
            R(u1Var.f3094a);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3335a.getSystemService("window");
        if (windowManager != null && u1Var.f3102c && (viewGroup = u1Var.f3098a) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                Q(u1Var.f7553a, u1Var, null);
            }
        }
        u1Var.f3099a = false;
        u1Var.f3101b = false;
        u1Var.f3102c = false;
        u1Var.f3097a = null;
        u1Var.f3104e = true;
        if (this.f3332a == u1Var) {
            this.f3332a = null;
        }
    }

    public final Configuration V(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    public final ViewGroup W() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f3335a.obtainStyledAttributes(c0.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c0.AppCompatTheme_windowNoTitle, false)) {
            C(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(c0.AppCompatTheme_windowActionBar, false)) {
            C(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c0.AppCompatTheme_windowActionBarOverlay, false)) {
            C(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(c0.AppCompatTheme_windowActionModeOverlay, false)) {
            C(10);
        }
        this.i = typedArrayObtainStyledAttributes.getBoolean(c0.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        d0();
        this.f3340a.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3335a);
        if (this.j) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(this.h ? z.abc_screen_simple_overlay_action_mode : z.abc_screen_simple, (ViewGroup) null);
        } else if (this.i) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(z.abc_dialog_title_material, (ViewGroup) null);
            this.g = false;
            this.f = false;
        } else if (this.f) {
            TypedValue typedValue = new TypedValue();
            this.f3335a.getTheme().resolveAttribute(t.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new m3(this.f3335a, typedValue.resourceId) : this.f3335a).inflate(z.abc_screen_toolbar, (ViewGroup) null);
            c7 c7Var = (c7) viewGroup.findViewById(y.decor_content_parent);
            this.f3325a = c7Var;
            c7Var.setWindowCallback(l0());
            if (this.g) {
                this.f3325a.n(109);
            }
            if (this.f3353d) {
                this.f3325a.n(2);
            }
            if (this.e) {
                this.f3325a.n(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f + ", windowActionBarOverlay: " + this.g + ", android:windowIsFloating: " + this.i + ", windowActionModeOverlay: " + this.h + ", windowNoTitle: " + this.j + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            eh.v0(viewGroup, new a1(this));
        } else if (viewGroup instanceof i7) {
            ((i7) viewGroup).setOnFitSystemWindowsListener(new b1(this));
        }
        if (this.f3325a == null) {
            this.f3342a = (TextView) viewGroup.findViewById(y.title);
        }
        z8.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(y.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f3340a.findViewById(R.id.content);
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
        this.f3340a.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c1(this));
        return viewGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View X(View view, String str, Context context, AttributeSet attributeSet) {
        a2 a2Var;
        boolean zK0 = false;
        if (this.f3324a == null) {
            String string = this.f3335a.obtainStyledAttributes(c0.AppCompatTheme).getString(c0.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                a2Var = new a2();
            } else {
                try {
                    this.f3324a = (a2) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    a2Var = new a2();
                    this.f3324a = a2Var;
                }
            }
            this.f3324a = a2Var;
        }
        if (u) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zK0 = K0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zK0 = true;
            }
        }
        return this.f3324a.q(view, str, context, attributeSet, zK0, u, true, y8.b());
    }

    public void Y() {
        i4 i4Var;
        c7 c7Var = this.f3325a;
        if (c7Var != null) {
            c7Var.o();
        }
        if (this.f3341a != null) {
            this.f3340a.getDecorView().removeCallbacks(this.f3345a);
            if (this.f3341a.isShowing()) {
                try {
                    this.f3341a.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f3341a = null;
        }
        b0();
        u1 u1VarJ0 = j0(0, false);
        if (u1VarJ0 == null || (i4Var = u1VarJ0.f3094a) == null) {
            return;
        }
        i4Var.close();
    }

    public boolean Z(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f3349b;
        if (((obj instanceof cg.a) || (obj instanceof y1)) && (decorView = this.f3340a.getDecorView()) != null && cg.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f3328a.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? v0(keyCode, keyEvent) : y0(keyCode, keyEvent);
    }

    @Override // a.i4.a
    public void a(i4 i4Var) {
        H0(true);
    }

    public void a0(int i) {
        u1 u1VarJ0;
        u1 u1VarJ02 = j0(i, true);
        if (u1VarJ02.f3094a != null) {
            Bundle bundle = new Bundle();
            u1VarJ02.f3094a.Q(bundle);
            if (bundle.size() > 0) {
                u1VarJ02.f3096a = bundle;
            }
            u1VarJ02.f3094a.d0();
            u1VarJ02.f3094a.clear();
        }
        u1VarJ02.f3105f = true;
        u1VarJ02.f3104e = true;
        if ((i != 108 && i != 0) || this.f3325a == null || (u1VarJ0 = j0(0, false)) == null) {
            return;
        }
        u1VarJ0.f3099a = false;
        G0(u1VarJ0, null);
    }

    @Override // a.i4.a
    public boolean b(i4 i4Var, MenuItem menuItem) {
        u1 u1VarE0;
        Window.Callback callbackL0 = l0();
        if (callbackL0 == null || this.p || (u1VarE0 = e0(i4Var.D())) == null) {
            return false;
        }
        return callbackL0.onMenuItemSelected(u1VarE0.f7553a, menuItem);
    }

    public void b0() {
        lh lhVar = this.f3330a;
        if (lhVar != null) {
            lhVar.b();
        }
    }

    public final void c0() {
        if (this.f3352c) {
            return;
        }
        this.f3339a = W();
        CharSequence charSequenceK0 = k0();
        if (!TextUtils.isEmpty(charSequenceK0)) {
            c7 c7Var = this.f3325a;
            if (c7Var != null) {
                c7Var.setWindowTitle(charSequenceK0);
            } else if (E0() != null) {
                E0().v(charSequenceK0);
            } else {
                TextView textView = this.f3342a;
                if (textView != null) {
                    textView.setText(charSequenceK0);
                }
            }
        }
        N();
        C0(this.f3339a);
        this.f3352c = true;
        u1 u1VarJ0 = j0(0, false);
        if (this.p) {
            return;
        }
        if (u1VarJ0 == null || u1VarJ0.f3094a == null) {
            q0(108);
        }
    }

    @Override // a.x0
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        c0();
        ((ViewGroup) this.f3339a.findViewById(R.id.content)).addView(view, layoutParams);
        this.f3328a.a().onContentChanged();
    }

    public final void d0() {
        if (this.f3340a == null) {
            Object obj = this.f3349b;
            if (obj instanceof Activity) {
                O(((Activity) obj).getWindow());
            }
        }
        if (this.f3340a == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // a.x0
    public boolean e() {
        return M(true);
    }

    public u1 e0(Menu menu) {
        u1[] u1VarArr = this.f3346a;
        int length = u1VarArr != null ? u1VarArr.length : 0;
        for (int i = 0; i < length; i++) {
            u1 u1Var = u1VarArr[i];
            if (u1Var != null && u1Var.f3094a == menu) {
                return u1Var;
            }
        }
        return null;
    }

    public final Context g0() {
        d0 d0VarP = p();
        Context contextK = d0VarP != null ? d0VarP.k() : null;
        return contextK == null ? this.f3335a : contextK;
    }

    @Override // a.x0
    public Context h(Context context) {
        this.m = true;
        int iT0 = t0(context, P());
        if (w && (context instanceof ContextThemeWrapper)) {
            try {
                s1.a((ContextThemeWrapper) context, V(context, iT0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof m3) {
            try {
                ((m3) context).a(V(context, iT0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!v) {
            super.h(context);
            return context;
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration configurationV = V(context, iT0, configuration.equals(configuration2) ? null : f0(configuration, configuration2));
            m3 m3Var = new m3(context, b0.Theme_AppCompat_Empty);
            m3Var.a(configurationV);
            boolean z = false;
            try {
                z = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z) {
                qc.a(m3Var.getTheme());
            }
            super.h(m3Var);
            return m3Var;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Application failed to obtain resources from itself", e);
        }
    }

    public final n1 h0(Context context) {
        if (this.f3347b == null) {
            this.f3347b = new l1(this, context);
        }
        return this.f3347b;
    }

    public final n1 i0(Context context) {
        if (this.f3331a == null) {
            this.f3331a = new o1(this, k2.a(context));
        }
        return this.f3331a;
    }

    public u1 j0(int i, boolean z) {
        u1[] u1VarArr = this.f3346a;
        if (u1VarArr == null || u1VarArr.length <= i) {
            u1[] u1VarArr2 = new u1[i + 1];
            if (u1VarArr != null) {
                System.arraycopy(u1VarArr, 0, u1VarArr2, 0, u1VarArr.length);
            }
            this.f3346a = u1VarArr2;
            u1VarArr = u1VarArr2;
        }
        u1 u1Var = u1VarArr[i];
        if (u1Var != null) {
            return u1Var;
        }
        u1 u1Var2 = new u1(i);
        u1VarArr[i] = u1Var2;
        return u1Var2;
    }

    @Override // a.x0
    public <T extends View> T k(int i) {
        c0();
        return (T) this.f3340a.findViewById(i);
    }

    public final CharSequence k0() {
        Object obj = this.f3349b;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f3344a;
    }

    public final Window.Callback l0() {
        return this.f3340a.getCallback();
    }

    @Override // a.x0
    public final f0 m() {
        return new g1(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m0() {
        /*
            r3 = this;
            r3.c0()
            boolean r0 = r3.f
            if (r0 == 0) goto L37
            a.d0 r0 = r3.f3326a
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.f3349b
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            a.p2 r0 = new a.p2
            java.lang.Object r1 = r3.f3349b
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.g
            r0.<init>(r1, r2)
        L1d:
            r3.f3326a = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            a.p2 r0 = new a.p2
            java.lang.Object r1 = r3.f3349b
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            a.d0 r0 = r3.f3326a
            if (r0 == 0) goto L37
            boolean r1 = r3.t
            r0.r(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.w1.m0():void");
    }

    @Override // a.x0
    public int n() {
        return this.b;
    }

    public final boolean n0(u1 u1Var) {
        View view = u1Var.f3100b;
        if (view != null) {
            u1Var.f3097a = view;
            return true;
        }
        if (u1Var.f3094a == null) {
            return false;
        }
        if (this.f3333a == null) {
            this.f3333a = new v1(this);
        }
        View view2 = (View) u1Var.a(this.f3333a);
        u1Var.f3097a = view2;
        return view2 != null;
    }

    @Override // a.x0
    public MenuInflater o() {
        if (this.f3337a == null) {
            m0();
            d0 d0Var = this.f3326a;
            this.f3337a = new s3(d0Var != null ? d0Var.k() : this.f3335a);
        }
        return this.f3337a;
    }

    public final boolean o0(u1 u1Var) {
        u1Var.d(g0());
        u1Var.f3098a = new t1(this, u1Var.f3095a);
        u1Var.c = 81;
        return true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return X(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // a.x0
    public d0 p() {
        m0();
        return this.f3326a;
    }

    public final boolean p0(u1 u1Var) {
        Context context = this.f3335a;
        int i = u1Var.f7553a;
        if ((i == 0 || i == 108) && this.f3325a != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(t.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(t.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(t.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                m3 m3Var = new m3(context, 0);
                m3Var.getTheme().setTo(themeNewTheme);
                context = m3Var;
            }
        }
        i4 i4Var = new i4(context);
        i4Var.R(this);
        u1Var.c(i4Var);
        return true;
    }

    @Override // a.x0
    public void q() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3335a);
        if (layoutInflaterFrom.getFactory() == null) {
            dg.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof w1) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final void q0(int i) {
        this.d = (1 << i) | this.d;
        if (this.s) {
            return;
        }
        eh.c0(this.f3340a.getDecorView(), this.f3350b);
        this.s = true;
    }

    @Override // a.x0
    public void r() {
        d0 d0VarP = p();
        if (d0VarP == null || !d0VarP.l()) {
            q0(0);
        }
    }

    public final boolean r0() {
        if (!this.r && (this.f3349b instanceof Activity)) {
            PackageManager packageManager = this.f3335a.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f3335a, this.f3349b.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.q = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.q = false;
            }
        }
        this.r = true;
        return this.q;
    }

    @Override // a.x0
    public void s(Configuration configuration) {
        d0 d0VarP;
        if (this.f && this.f3352c && (d0VarP = p()) != null) {
            d0VarP.m(configuration);
        }
        v5.b().g(this.f3335a);
        M(false);
    }

    public boolean s0() {
        return this.f3351b;
    }

    @Override // a.x0
    public void t(Bundle bundle) {
        this.m = true;
        M(false);
        d0();
        Object obj = this.f3349b;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = hb.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                d0 d0VarE0 = E0();
                if (d0VarE0 == null) {
                    this.t = true;
                } else {
                    d0VarE0.r(true);
                }
            }
            x0.c(this);
        }
        this.n = true;
    }

    public int t0(Context context, int i) {
        n1 n1VarI0;
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                    n1VarI0 = h0(context);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                }
                n1VarI0 = i0(context);
            }
            return n1VarI0.c();
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    @Override // a.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3349b
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            a.x0.A(r3)
        L9:
            boolean r0 = r3.s
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f3340a
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f3350b
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.o = r0
            r0 = 1
            r3.p = r0
            int r0 = r3.b
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.f3349b
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            a.ia<java.lang.String, java.lang.Integer> r0 = a.w1.f7742a
            java.lang.Object r1 = r3.f3349b
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            a.ia<java.lang.String, java.lang.Integer> r0 = a.w1.f7742a
            java.lang.Object r1 = r3.f3349b
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            a.d0 r0 = r3.f3326a
            if (r0 == 0) goto L5e
            r0.n()
        L5e:
            r3.S()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.w1.u():void");
    }

    public boolean u0() {
        k3 k3Var = this.f3329a;
        if (k3Var != null) {
            k3Var.c();
            return true;
        }
        d0 d0VarP = p();
        return d0VarP != null && d0VarP.h();
    }

    @Override // a.x0
    public void v(Bundle bundle) {
        c0();
    }

    public boolean v0(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.l = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            w0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // a.x0
    public void w() {
        d0 d0VarP = p();
        if (d0VarP != null) {
            d0VarP.u(true);
        }
    }

    public final boolean w0(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        u1 u1VarJ0 = j0(i, true);
        if (u1VarJ0.f3102c) {
            return false;
        }
        return G0(u1VarJ0, keyEvent);
    }

    @Override // a.x0
    public void x(Bundle bundle) {
    }

    public boolean x0(int i, KeyEvent keyEvent) {
        d0 d0VarP = p();
        if (d0VarP != null && d0VarP.o(i, keyEvent)) {
            return true;
        }
        u1 u1Var = this.f3332a;
        if (u1Var != null && F0(u1Var, keyEvent.getKeyCode(), keyEvent, 1)) {
            u1 u1Var2 = this.f3332a;
            if (u1Var2 != null) {
                u1Var2.f3101b = true;
            }
            return true;
        }
        if (this.f3332a == null) {
            u1 u1VarJ0 = j0(0, true);
            G0(u1VarJ0, keyEvent);
            boolean zF0 = F0(u1VarJ0, keyEvent.getKeyCode(), keyEvent, 1);
            u1VarJ0.f3099a = false;
            if (zF0) {
                return true;
            }
        }
        return false;
    }

    @Override // a.x0
    public void y() {
        this.o = true;
        e();
    }

    public boolean y0(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.l;
            this.l = false;
            u1 u1VarJ0 = j0(0, false);
            if (u1VarJ0 != null && u1VarJ0.f3102c) {
                if (!z) {
                    U(u1VarJ0, true);
                }
                return true;
            }
            if (u0()) {
                return true;
            }
        } else if (i == 82) {
            z0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // a.x0
    public void z() {
        this.o = false;
        d0 d0VarP = p();
        if (d0VarP != null) {
            d0VarP.u(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z0(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            a.k3 r0 = r3.f3329a
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            a.u1 r2 = r3.j0(r4, r0)
            if (r4 != 0) goto L43
            a.c7 r4 = r3.f3325a
            if (r4 == 0) goto L43
            boolean r4 = r4.c()
            if (r4 == 0) goto L43
            android.content.Context r4 = r3.f3335a
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L43
            a.c7 r4 = r3.f3325a
            boolean r4 = r4.d()
            if (r4 != 0) goto L3c
            boolean r4 = r3.p
            if (r4 != 0) goto L62
            boolean r4 = r3.G0(r2, r5)
            if (r4 == 0) goto L62
            a.c7 r4 = r3.f3325a
            boolean r0 = r4.f()
            goto L6a
        L3c:
            a.c7 r4 = r3.f3325a
            boolean r0 = r4.e()
            goto L6a
        L43:
            boolean r4 = r2.f3102c
            if (r4 != 0) goto L64
            boolean r4 = r2.f3101b
            if (r4 == 0) goto L4c
            goto L64
        L4c:
            boolean r4 = r2.f3099a
            if (r4 == 0) goto L62
            boolean r4 = r2.f3105f
            if (r4 == 0) goto L5b
            r2.f3099a = r1
            boolean r4 = r3.G0(r2, r5)
            goto L5c
        L5b:
            r4 = r0
        L5c:
            if (r4 == 0) goto L62
            r3.D0(r2, r5)
            goto L6a
        L62:
            r0 = r1
            goto L6a
        L64:
            boolean r4 = r2.f3102c
            r3.U(r2, r0)
            r0 = r4
        L6a:
            if (r0 == 0) goto L87
            android.content.Context r4 = r3.f3335a
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L80
            r4.playSoundEffect(r1)
            goto L87
        L80:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.w1.z0(int, android.view.KeyEvent):boolean");
    }
}
