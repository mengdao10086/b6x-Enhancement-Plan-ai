package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements m.f {
    public static final int C1 = 250;
    public static Method C2 = null;
    public static final int E7 = 1;
    public static final int F7 = -1;
    public static final int G7 = -2;
    public static final int H7 = 0;
    public static final int I7 = 1;
    public static final int J7 = 2;
    public static Method K1 = null;
    public static final int K2 = 0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f2540k1 = "ListPopupWindow";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final boolean f2541v1 = false;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static Method f2542v2;
    public Runnable A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public PopupWindow K0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f2544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f2545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2553k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f2554k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f2559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f2561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f2562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f2563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f2564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f2565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f2566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f2567x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h f2568y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f2569z;

    public class a extends h0 {
        public a(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.h0
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public j0 b() {
            return j0.this;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewV = j0.this.v();
            if (viewV == null || viewV.getWindowToken() == null) {
                return;
            }
            j0.this.a();
        }
    }

    public class c implements AdapterView.OnItemSelectedListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            e0 e0Var;
            if (i10 == -1 || (e0Var = j0.this.f2545c) == null) {
                return;
            }
            e0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @g.v0(24)
    public static class d {
        @g.u
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    @g.v0(29)
    public static class e {
        @g.u
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @g.u
        public static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.s();
        }
    }

    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.d()) {
                j0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    public class h implements AbsListView.OnScrollListener {
        public h() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || j0.this.K() || j0.this.K0.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.B.removeCallbacks(j0Var.f2566w);
            j0.this.f2566w.run();
        }
    }

    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.K0) != null && popupWindow.isShowing() && x10 >= 0 && x10 < j0.this.K0.getWidth() && y10 >= 0 && y10 < j0.this.K0.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.B.postDelayed(j0Var.f2566w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            j0 j0Var2 = j0.this;
            j0Var2.B.removeCallbacks(j0Var2.f2566w);
            return false;
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 e0Var = j0.this.f2545c;
            if (e0Var == null || !androidx.core.view.u0.O0(e0Var) || j0.this.f2545c.getCount() <= j0.this.f2545c.getChildCount()) {
                return;
            }
            int childCount = j0.this.f2545c.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.f2558o) {
                j0Var.K0.setInputMethodMode(2);
                j0.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                K1 = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                C2 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f2542v2 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public j0(@g.n0 Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public static boolean I(int i10) {
        return i10 == 66 || i10 == 23;
    }

    public final int A(View view, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT > 23) {
            return d.a(this.K0, view, i10, z10);
        }
        Method method = f2542v2;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.K0, view, Integer.valueOf(i10), Boolean.valueOf(z10))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.K0.getMaxAvailableHeight(view, i10);
    }

    public int B() {
        return this.f2560q;
    }

    @g.p0
    public Object C() {
        if (d()) {
            return this.f2545c.getSelectedItem();
        }
        return null;
    }

    public long D() {
        if (d()) {
            return this.f2545c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int E() {
        if (d()) {
            return this.f2545c.getSelectedItemPosition();
        }
        return -1;
    }

    @g.p0
    public View F() {
        if (d()) {
            return this.f2545c.getSelectedView();
        }
        return null;
    }

    public int G() {
        return this.K0.getSoftInputMode();
    }

    public int H() {
        return this.f2547e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean J() {
        return this.f2556m;
    }

    public boolean K() {
        return this.K0.getInputMethodMode() == 2;
    }

    public boolean L() {
        return this.f2554k0;
    }

    public boolean M(int i10, @g.n0 KeyEvent keyEvent) {
        if (d() && i10 != 62 && (this.f2545c.getSelectedItemPosition() >= 0 || !I(i10))) {
            int selectedItemPosition = this.f2545c.getSelectedItemPosition();
            boolean z10 = !this.K0.isAboveAnchor();
            ListAdapter listAdapter = this.f2544b;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MIN_VALUE;
            if (listAdapter != null) {
                boolean zAreAllItemsEnabled = listAdapter.areAllItemsEnabled();
                int iD = zAreAllItemsEnabled ? 0 : this.f2545c.d(0, true);
                int count = zAreAllItemsEnabled ? listAdapter.getCount() - 1 : this.f2545c.d(listAdapter.getCount() - 1, false);
                i11 = iD;
                i12 = count;
            }
            if ((z10 && i10 == 19 && selectedItemPosition <= i11) || (!z10 && i10 == 20 && selectedItemPosition >= i12)) {
                s();
                this.K0.setInputMethodMode(1);
                a();
                return true;
            }
            this.f2545c.setListSelectionHidden(false);
            if (this.f2545c.onKeyDown(i10, keyEvent)) {
                this.K0.setInputMethodMode(2);
                this.f2545c.requestFocusFromTouch();
                a();
                if (i10 == 19 || i10 == 20 || i10 == 23 || i10 == 66) {
                    return true;
                }
            } else if (z10 && i10 == 20) {
                if (selectedItemPosition == i12) {
                    return true;
                }
            } else if (!z10 && i10 == 19 && selectedItemPosition == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean N(int i10, @g.n0 KeyEvent keyEvent) {
        if (i10 != 4 || !d()) {
            return false;
        }
        View view = this.f2562s;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean O(int i10, @g.n0 KeyEvent keyEvent) {
        if (!d() || this.f2545c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean zOnKeyUp = this.f2545c.onKeyUp(i10, keyEvent);
        if (zOnKeyUp && I(i10)) {
            dismiss();
        }
        return zOnKeyUp;
    }

    public boolean P(int i10) {
        if (!d()) {
            return false;
        }
        if (this.f2564u == null) {
            return true;
        }
        e0 e0Var = this.f2545c;
        this.f2564u.onItemClick(e0Var, e0Var.getChildAt(i10 - e0Var.getFirstVisiblePosition()), i10, e0Var.getAdapter().getItemId(i10));
        return true;
    }

    public void Q() {
        this.B.post(this.A);
    }

    public final void R() {
        View view = this.f2559p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2559p);
            }
        }
    }

    public void S(@g.p0 View view) {
        this.f2562s = view;
    }

    public void T(@g.d1 int i10) {
        this.K0.setAnimationStyle(i10);
    }

    public void U(int i10) {
        Drawable background = this.K0.getBackground();
        if (background == null) {
            n0(i10);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f2547e = rect.left + rect.right + i10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void V(boolean z10) {
        this.f2556m = z10;
    }

    public void W(int i10) {
        this.f2555l = i10;
    }

    public void X(@g.p0 Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void Y(boolean z10) {
        this.f2557n = z10;
    }

    public void Z(int i10) {
        if (i10 < 0 && -2 != i10 && -1 != i10) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f2546d = i10;
    }

    @Override // m.f
    public void a() {
        int iR = r();
        boolean zK = K();
        androidx.core.widget.p.d(this.K0, this.f2550h);
        if (this.K0.isShowing()) {
            if (androidx.core.view.u0.O0(v())) {
                int width = this.f2547e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = v().getWidth();
                }
                int i10 = this.f2546d;
                if (i10 == -1) {
                    if (!zK) {
                        iR = -1;
                    }
                    if (zK) {
                        this.K0.setWidth(this.f2547e == -1 ? -1 : 0);
                        this.K0.setHeight(0);
                    } else {
                        this.K0.setWidth(this.f2547e == -1 ? -1 : 0);
                        this.K0.setHeight(-1);
                    }
                } else if (i10 != -2) {
                    iR = i10;
                }
                this.K0.setOutsideTouchable((this.f2557n || this.f2556m) ? false : true);
                this.K0.update(v(), this.f2548f, this.f2549g, width < 0 ? -1 : width, iR < 0 ? -1 : iR);
                return;
            }
            return;
        }
        int width2 = this.f2547e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = v().getWidth();
        }
        int i11 = this.f2546d;
        if (i11 == -1) {
            iR = -1;
        } else if (i11 != -2) {
            iR = i11;
        }
        this.K0.setWidth(width2);
        this.K0.setHeight(iR);
        i0(true);
        this.K0.setOutsideTouchable((this.f2557n || this.f2556m) ? false : true);
        this.K0.setTouchInterceptor(this.f2567x);
        if (this.f2553k) {
            androidx.core.widget.p.c(this.K0, this.f2552j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = C2;
            if (method != null) {
                try {
                    method.invoke(this.K0, this.D);
                } catch (Exception unused) {
                }
            }
        } else {
            e.a(this.K0, this.D);
        }
        androidx.core.widget.p.e(this.K0, v(), this.f2548f, this.f2549g, this.f2555l);
        this.f2545c.setSelection(-1);
        if (!this.f2554k0 || this.f2545c.isInTouchMode()) {
            s();
        }
        if (this.f2554k0) {
            return;
        }
        this.B.post(this.f2569z);
    }

    public void a0(int i10) {
        this.K0.setInputMethodMode(i10);
    }

    public void b0(int i10) {
        this.f2558o = i10;
    }

    public void c(@g.p0 Drawable drawable) {
        this.K0.setBackgroundDrawable(drawable);
    }

    public void c0(Drawable drawable) {
        this.f2563t = drawable;
    }

    @Override // m.f
    public boolean d() {
        return this.K0.isShowing();
    }

    public void d0(boolean z10) {
        this.f2554k0 = z10;
        this.K0.setFocusable(z10);
    }

    @Override // m.f
    public void dismiss() {
        this.K0.dismiss();
        R();
        this.K0.setContentView(null);
        this.f2545c = null;
        this.B.removeCallbacks(this.f2566w);
    }

    public int e() {
        return this.f2548f;
    }

    public void e0(@g.p0 PopupWindow.OnDismissListener onDismissListener) {
        this.K0.setOnDismissListener(onDismissListener);
    }

    public void f(int i10) {
        this.f2548f = i10;
    }

    public void f0(@g.p0 AdapterView.OnItemClickListener onItemClickListener) {
        this.f2564u = onItemClickListener;
    }

    public void g0(@g.p0 AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f2565v = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void h0(boolean z10) {
        this.f2553k = true;
        this.f2552j = z10;
    }

    @g.p0
    public Drawable i() {
        return this.K0.getBackground();
    }

    public final void i0(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            e.b(this.K0, z10);
            return;
        }
        Method method = K1;
        if (method != null) {
            try {
                method.invoke(this.K0, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    public void j0(int i10) {
        this.f2560q = i10;
    }

    @Override // m.f
    @g.p0
    public ListView k() {
        return this.f2545c;
    }

    public void k0(@g.p0 View view) {
        boolean zD = d();
        if (zD) {
            R();
        }
        this.f2559p = view;
        if (zD) {
            a();
        }
    }

    public void l(int i10) {
        this.f2549g = i10;
        this.f2551i = true;
    }

    public void l0(int i10) {
        e0 e0Var = this.f2545c;
        if (!d() || e0Var == null) {
            return;
        }
        e0Var.setListSelectionHidden(false);
        e0Var.setSelection(i10);
        if (e0Var.getChoiceMode() != 0) {
            e0Var.setItemChecked(i10, true);
        }
    }

    public void m0(int i10) {
        this.K0.setSoftInputMode(i10);
    }

    public void n0(int i10) {
        this.f2547e = i10;
    }

    public int o() {
        if (this.f2551i) {
            return this.f2549g;
        }
        return 0;
    }

    public void o0(int i10) {
        this.f2550h = i10;
    }

    public void q(@g.p0 ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2561r;
        if (dataSetObserver == null) {
            this.f2561r = new g();
        } else {
            ListAdapter listAdapter2 = this.f2544b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2544b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2561r);
        }
        e0 e0Var = this.f2545c;
        if (e0Var != null) {
            e0Var.setAdapter(this.f2544b);
        }
    }

    public final int r() {
        int measuredHeight;
        int i10;
        int iMakeMeasureSpec;
        View view;
        int i11;
        if (this.f2545c == null) {
            Context context = this.f2543a;
            this.A = new b();
            e0 e0VarU = u(context, !this.f2554k0);
            this.f2545c = e0VarU;
            Drawable drawable = this.f2563t;
            if (drawable != null) {
                e0VarU.setSelector(drawable);
            }
            this.f2545c.setAdapter(this.f2544b);
            this.f2545c.setOnItemClickListener(this.f2564u);
            this.f2545c.setFocusable(true);
            this.f2545c.setFocusableInTouchMode(true);
            this.f2545c.setOnItemSelectedListener(new c());
            this.f2545c.setOnScrollListener(this.f2568y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2565v;
            if (onItemSelectedListener != null) {
                this.f2545c.setOnItemSelectedListener(onItemSelectedListener);
            }
            e0 e0Var = this.f2545c;
            View view2 = this.f2559p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i12 = this.f2560q;
                if (i12 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(e0Var, layoutParams);
                } else if (i12 != 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid hint position ");
                    sb2.append(this.f2560q);
                } else {
                    linearLayout.addView(e0Var, layoutParams);
                    linearLayout.addView(view2);
                }
                int i13 = this.f2547e;
                if (i13 >= 0) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i13 = 0;
                    i11 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i13, i11), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = e0Var;
            }
            this.K0.setContentView(view);
        } else {
            View view3 = this.f2559p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.K0.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i14 = rect.top;
            i10 = rect.bottom + i14;
            if (!this.f2551i) {
                this.f2549g = -i14;
            }
        } else {
            this.C.setEmpty();
            i10 = 0;
        }
        int iA = A(v(), this.f2549g, this.K0.getInputMethodMode() == 2);
        if (this.f2556m || this.f2546d == -1) {
            return iA + i10;
        }
        int i15 = this.f2547e;
        if (i15 == -2) {
            int i16 = this.f2543a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i15 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        } else {
            int i17 = this.f2543a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect3.left + rect3.right), 1073741824);
        }
        int iE = this.f2545c.e(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iE > 0) {
            measuredHeight += i10 + this.f2545c.getPaddingTop() + this.f2545c.getPaddingBottom();
        }
        return iE + measuredHeight;
    }

    public void s() {
        e0 e0Var = this.f2545c;
        if (e0Var != null) {
            e0Var.setListSelectionHidden(true);
            e0Var.requestLayout();
        }
    }

    public View.OnTouchListener t(View view) {
        return new a(view);
    }

    @g.n0
    public e0 u(Context context, boolean z10) {
        return new e0(context, z10);
    }

    @g.p0
    public View v() {
        return this.f2562s;
    }

    @g.d1
    public int w() {
        return this.K0.getAnimationStyle();
    }

    @g.p0
    public Rect x() {
        if (this.D != null) {
            return new Rect(this.D);
        }
        return null;
    }

    public int y() {
        return this.f2546d;
    }

    public int z() {
        return this.K0.getInputMethodMode();
    }

    public j0(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public j0(@g.n0 Context context, @g.p0 AttributeSet attributeSet, @g.f int i10) {
        this(context, attributeSet, i10, 0);
    }

    public j0(@g.n0 Context context, @g.p0 AttributeSet attributeSet, @g.f int i10, @g.d1 int i11) {
        this.f2546d = -2;
        this.f2547e = -2;
        this.f2550h = 1002;
        this.f2555l = 0;
        this.f2556m = false;
        this.f2557n = false;
        this.f2558o = Integer.MAX_VALUE;
        this.f2560q = 0;
        this.f2566w = new j();
        this.f2567x = new i();
        this.f2568y = new h();
        this.f2569z = new f();
        this.C = new Rect();
        this.f2543a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i10, i11);
        this.f2548f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f2549g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2551i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i10, i11);
        this.K0 = qVar;
        qVar.setInputMethodMode(1);
    }
}
