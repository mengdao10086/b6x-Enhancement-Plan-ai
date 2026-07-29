package androidx.core.view;

import android.R;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f5010b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5011c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f5012d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5013e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5014a;

    @g.v0(20)
    public static class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final Window f5015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.n0
        public final View f5016b;

        public a(@g.n0 Window window, @g.n0 View view) {
            this.f5015a = window;
            this.f5016b = view;
        }

        public static /* synthetic */ void n(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override // androidx.core.view.l1.e
        public void a(f fVar) {
        }

        @Override // androidx.core.view.l1.e
        public void b(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, h1 h1Var) {
        }

        @Override // androidx.core.view.l1.e
        public int c() {
            return 0;
        }

        @Override // androidx.core.view.l1.e
        public void d(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    m(i11);
                }
            }
        }

        @Override // androidx.core.view.l1.e
        public void g(@g.n0 f fVar) {
        }

        @Override // androidx.core.view.l1.e
        public void j(int i10) {
            if (i10 == 0) {
                r(6144);
                return;
            }
            if (i10 == 1) {
                r(4096);
                o(2048);
            } else {
                if (i10 != 2) {
                    return;
                }
                r(2048);
                o(4096);
            }
        }

        @Override // androidx.core.view.l1.e
        public void k(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    q(i11);
                }
            }
        }

        public final void m(int i10) {
            if (i10 == 1) {
                o(4);
            } else if (i10 == 2) {
                o(2);
            } else {
                if (i10 != 8) {
                    return;
                }
                ((InputMethodManager) this.f5015a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f5015a.getDecorView().getWindowToken(), 0);
            }
        }

        public void o(int i10) {
            View decorView = this.f5015a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void p(int i10) {
            this.f5015a.addFlags(i10);
        }

        public final void q(int i10) {
            if (i10 == 1) {
                r(4);
                s(1024);
                return;
            }
            if (i10 == 2) {
                r(2);
                return;
            }
            if (i10 != 8) {
                return;
            }
            final View viewFindViewById = this.f5016b;
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = this.f5015a.getCurrentFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f5015a.findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.k1
                @Override // java.lang.Runnable
                public final void run() {
                    l1.a.n(viewFindViewById);
                }
            });
        }

        public void r(int i10) {
            View decorView = this.f5015a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public void s(int i10) {
            this.f5015a.clearFlags(i10);
        }
    }

    @g.v0(23)
    public static class b extends a {
        public b(@g.n0 Window window, @g.p0 View view) {
            super(window, view);
        }

        @Override // androidx.core.view.l1.e
        public boolean f() {
            return (this.f5015a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.l1.e
        public void i(boolean z10) {
            if (!z10) {
                r(8192);
                return;
            }
            s(67108864);
            p(Integer.MIN_VALUE);
            o(8192);
        }
    }

    @g.v0(26)
    public static class c extends b {
        public c(@g.n0 Window window, @g.p0 View view) {
            super(window, view);
        }

        @Override // androidx.core.view.l1.e
        public boolean e() {
            return (this.f5015a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.l1.e
        public void h(boolean z10) {
            if (!z10) {
                r(16);
                return;
            }
            s(134217728);
            p(Integer.MIN_VALUE);
            o(16);
        }
    }

    public static class e {
        public void a(f fVar) {
        }

        public void b(int i10, long j10, Interpolator interpolator, CancellationSignal cancellationSignal, h1 h1Var) {
        }

        public int c() {
            return 0;
        }

        public void d(int i10) {
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void g(@g.n0 f fVar) {
        }

        public void h(boolean z10) {
        }

        public void i(boolean z10) {
        }

        public void j(int i10) {
        }

        public void k(int i10) {
        }
    }

    public interface f {
        void a(@g.n0 l1 l1Var, int i10);
    }

    @g.v0(30)
    @Deprecated
    public l1(@g.n0 WindowInsetsController windowInsetsController) {
        this.f5014a = new d(windowInsetsController, this);
    }

    @g.n0
    @g.v0(30)
    @Deprecated
    public static l1 l(@g.n0 WindowInsetsController windowInsetsController) {
        return new l1(windowInsetsController);
    }

    public void a(@g.n0 f fVar) {
        this.f5014a.a(fVar);
    }

    public void b(int i10, long j10, @g.p0 Interpolator interpolator, @g.p0 CancellationSignal cancellationSignal, @g.n0 h1 h1Var) {
        this.f5014a.b(i10, j10, interpolator, cancellationSignal, h1Var);
    }

    @SuppressLint({"WrongConstant"})
    public int c() {
        return this.f5014a.c();
    }

    public void d(int i10) {
        this.f5014a.d(i10);
    }

    public boolean e() {
        return this.f5014a.e();
    }

    public boolean f() {
        return this.f5014a.f();
    }

    public void g(@g.n0 f fVar) {
        this.f5014a.g(fVar);
    }

    public void h(boolean z10) {
        this.f5014a.h(z10);
    }

    public void i(boolean z10) {
        this.f5014a.i(z10);
    }

    public void j(int i10) {
        this.f5014a.j(i10);
    }

    public void k(int i10) {
        this.f5014a.k(i10);
    }

    @g.v0(30)
    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f5017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsetsController f5018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.collection.l<f, WindowInsetsController.OnControllableInsetsChangedListener> f5019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Window f5020d;

        public class a implements WindowInsetsAnimationControlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public i1 f5021a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h1 f5022b;

            public a(h1 h1Var) {
                this.f5022b = h1Var;
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onCancelled(@g.p0 WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f5022b.a(windowInsetsAnimationController == null ? null : this.f5021a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onFinished(@g.n0 WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f5022b.c(this.f5021a);
            }

            @Override // android.view.WindowInsetsAnimationControlListener
            public void onReady(@g.n0 WindowInsetsAnimationController windowInsetsAnimationController, int i10) {
                i1 i1Var = new i1(windowInsetsAnimationController);
                this.f5021a = i1Var;
                this.f5022b.b(i1Var, i10);
            }
        }

        public d(@g.n0 Window window, @g.n0 l1 l1Var) {
            this(window.getInsetsController(), l1Var);
            this.f5020d = window;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(f fVar, WindowInsetsController windowInsetsController, int i10) {
            if (this.f5018b == windowInsetsController) {
                fVar.a(this.f5017a, i10);
            }
        }

        @Override // androidx.core.view.l1.e
        public void a(@g.n0 final f fVar) {
            if (this.f5019c.containsKey(fVar)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.m1
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i10) {
                    this.f5028a.m(fVar, windowInsetsController, i10);
                }
            };
            this.f5019c.put(fVar, onControllableInsetsChangedListener);
            this.f5018b.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
        }

        @Override // androidx.core.view.l1.e
        public void b(int i10, long j10, @g.p0 Interpolator interpolator, @g.p0 CancellationSignal cancellationSignal, @g.n0 h1 h1Var) {
            this.f5018b.controlWindowInsetsAnimation(i10, j10, interpolator, cancellationSignal, new a(h1Var));
        }

        @Override // androidx.core.view.l1.e
        @SuppressLint({"WrongConstant"})
        public int c() {
            return this.f5018b.getSystemBarsBehavior();
        }

        @Override // androidx.core.view.l1.e
        public void d(int i10) {
            this.f5018b.hide(i10);
        }

        @Override // androidx.core.view.l1.e
        public boolean e() {
            return (this.f5018b.getSystemBarsAppearance() & 16) != 0;
        }

        @Override // androidx.core.view.l1.e
        public boolean f() {
            return (this.f5018b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.l1.e
        public void g(@g.n0 f fVar) {
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListenerRemove = this.f5019c.remove(fVar);
            if (onControllableInsetsChangedListenerRemove != null) {
                this.f5018b.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListenerRemove);
            }
        }

        @Override // androidx.core.view.l1.e
        public void h(boolean z10) {
            if (z10) {
                if (this.f5020d != null) {
                    n(16);
                }
                this.f5018b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f5020d != null) {
                    o(16);
                }
                this.f5018b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.l1.e
        public void i(boolean z10) {
            if (z10) {
                if (this.f5020d != null) {
                    n(8192);
                }
                this.f5018b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f5020d != null) {
                    o(8192);
                }
                this.f5018b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.l1.e
        public void j(int i10) {
            this.f5018b.setSystemBarsBehavior(i10);
        }

        @Override // androidx.core.view.l1.e
        public void k(int i10) {
            Window window = this.f5020d;
            if (window != null && (i10 & 8) != 0 && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
            }
            this.f5018b.show(i10);
        }

        public void n(int i10) {
            View decorView = this.f5020d.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void o(int i10) {
            View decorView = this.f5020d.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public d(@g.n0 WindowInsetsController windowInsetsController, @g.n0 l1 l1Var) {
            this.f5019c = new androidx.collection.l<>();
            this.f5018b = windowInsetsController;
            this.f5017a = l1Var;
        }
    }

    public l1(@g.n0 Window window, @g.n0 View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f5014a = new d(window, this);
            return;
        }
        if (i10 >= 26) {
            this.f5014a = new c(window, view);
        } else if (i10 >= 23) {
            this.f5014a = new b(window, view);
        } else {
            this.f5014a = new a(window, view);
        }
    }
}
