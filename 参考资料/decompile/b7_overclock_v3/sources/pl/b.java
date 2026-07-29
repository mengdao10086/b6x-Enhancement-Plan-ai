package pl;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import g.l;
import l4.f;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f46701a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f46702b;

    public static class a implements View.OnSystemUiVisibilityChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f46703a;

        public a(Window window) {
            this.f46703a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            if (i10 == 0) {
                b.f(this.f46703a, false);
            }
        }
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static ViewGroup b(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return (ViewGroup) decorView.findViewWithTag(nl.b.f42221e);
    }

    public static int c(Context context) {
        int i10 = f46701a;
        if (i10 != -1) {
            return i10;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", f.f39447b);
        if (identifier > 0) {
            f46701a = context.getResources().getDimensionPixelSize(identifier);
        }
        if (f46701a < 0) {
            int dimensionPixelSize = 0;
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f46701a = 0;
                throw th2;
            }
            f46701a = dimensionPixelSize;
        }
        if (f46701a < 0) {
            f46701a = a(context, 25.0f);
        }
        return f46701a;
    }

    public static ViewGroup d(Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return (ViewGroup) decorView.findViewWithTag(nl.b.f42222f);
    }

    public static void e(Window window) {
        ViewGroup viewGroupB = b(window);
        if (viewGroupB == null) {
            return;
        }
        viewGroupB.getChildCount();
        viewGroupB.setVisibility(8);
    }

    public static void f(Window window, boolean z10) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags |= 1024;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility((f46702b ? 1028 : 1542) | 4096);
        if (z10) {
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new a(window));
        }
    }

    public static void g(Window window, ol.d dVar) {
        window.clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 23) {
            window.clearFlags(67108864);
            try {
                window.getDecorView().setSystemUiVisibility(1280);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else {
            window.addFlags(67108864);
        }
        if (!f46702b) {
            window.getDecorView().setSystemUiVisibility(gg.b.W);
        }
        ol.c cVar = new ol.c();
        cVar.h(nl.b.l().n(window));
        cVar.g(nl.b.l().m(window));
        cVar.f(nl.b.l().o(window));
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    public static void h(Window window) {
        View childAt;
        int iN = nl.b.l().n(window);
        ViewGroup viewGroupD = d(window);
        if (viewGroupD == null || viewGroupD.getChildCount() < 1 || (childAt = viewGroupD.getChildAt(0)) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i10 = layoutParams.height;
        if (i10 <= 0) {
            childAt.setPadding(0, iN, 0, 0);
        } else {
            layoutParams.height = i10 + iN;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public static void i(Window window) {
        ViewGroup viewGroupB = b(window);
        if (viewGroupB == null) {
            return;
        }
        if (viewGroupB.getChildCount() == 0) {
            View view = new View(window.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, nl.b.l().m(window)));
            view.setBackgroundColor(-16777216);
            viewGroupB.addView(view);
        }
        viewGroupB.setVisibility(0);
    }

    public static void j(Window window, @l int i10) {
        ViewGroup viewGroupB = b(window);
        if (viewGroupB != null && viewGroupB.getChildCount() == 1) {
            viewGroupB.getChildAt(0).setBackgroundColor(i10);
        }
    }
}
