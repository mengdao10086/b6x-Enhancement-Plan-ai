package a;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t7 implements y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f7472a;
    public static Method b;
    public static Method c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h7 f2973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final o7 f2974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final q7 f2975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final r7 f2976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final s7 f2977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSetObserver f2979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f2980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f2981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f2982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterView.OnItemClickListener f2984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterView.OnItemSelectedListener f2985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListAdapter f2986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PopupWindow f2987a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2988b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Rect f2989b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f2990b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2991b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f2992c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2993c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2994d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2995e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2996f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f2997g;
    public int h;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f7472a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public t7(Context context) {
        this(context, null, t.listPopupWindowStyle);
    }

    public t7(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public t7(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2972a = -2;
        this.f2988b = -2;
        this.e = 1002;
        this.f = 0;
        this.f2995e = false;
        this.f2996f = false;
        this.g = Integer.MAX_VALUE;
        this.h = 0;
        this.f2977a = new s7(this);
        this.f2976a = new r7(this);
        this.f2975a = new q7(this);
        this.f2974a = new o7(this);
        this.f2980a = new Rect();
        this.f2978a = context;
        this.f2982a = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.ListPopupWindow, i, i2);
        this.f2992c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c0.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c0.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.d = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2991b = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        b6 b6Var = new b6(context, attributeSet, i, i2);
        this.f2987a = b6Var;
        b6Var.setInputMethodMode(1);
    }

    public boolean A() {
        return this.f2987a.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.f2997g;
    }

    public final void C() {
        View view = this.f2983a;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2983a);
            }
        }
    }

    public void D(View view) {
        this.f2990b = view;
    }

    public void E(int i) {
        this.f2987a.setAnimationStyle(i);
    }

    public void F(int i) {
        Drawable background = this.f2987a.getBackground();
        if (background == null) {
            Q(i);
            return;
        }
        background.getPadding(this.f2980a);
        Rect rect = this.f2980a;
        this.f2988b = rect.left + rect.right + i;
    }

    public void G(int i) {
        this.f = i;
    }

    public void H(Rect rect) {
        this.f2989b = rect != null ? new Rect(rect) : null;
    }

    public void I(int i) {
        this.f2987a.setInputMethodMode(i);
    }

    public void J(boolean z) {
        this.f2997g = z;
        this.f2987a.setFocusable(z);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.f2987a.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2984a = onItemClickListener;
    }

    public void M(boolean z) {
        this.f2994d = true;
        this.f2993c = z;
    }

    public final void N(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.f2987a.setIsClippedToScreen(z);
            return;
        }
        Method method = f7472a;
        if (method != null) {
            try {
                method.invoke(this.f2987a, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void O(int i) {
        this.h = i;
    }

    public void P(int i) {
        h7 h7Var = this.f2973a;
        if (!a() || h7Var == null) {
            return;
        }
        h7Var.setListSelectionHidden(false);
        h7Var.setSelection(i);
        if (h7Var.getChoiceMode() != 0) {
            h7Var.setItemChecked(i, true);
        }
    }

    public void Q(int i) {
        this.f2988b = i;
    }

    @Override // a.y4
    public boolean a() {
        return this.f2987a.isShowing();
    }

    public void b(Drawable drawable) {
        this.f2987a.setBackgroundDrawable(drawable);
    }

    @Override // a.y4
    public void c() {
        int iQ = q();
        boolean zA = A();
        mj.b(this.f2987a, this.e);
        if (this.f2987a.isShowing()) {
            if (eh.P(t())) {
                int width = this.f2988b;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i = this.f2972a;
                if (i == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    if (zA) {
                        this.f2987a.setWidth(this.f2988b == -1 ? -1 : 0);
                        this.f2987a.setHeight(0);
                    } else {
                        this.f2987a.setWidth(this.f2988b == -1 ? -1 : 0);
                        this.f2987a.setHeight(-1);
                    }
                } else if (i != -2) {
                    iQ = i;
                }
                this.f2987a.setOutsideTouchable((this.f2996f || this.f2995e) ? false : true);
                this.f2987a.update(t(), this.f2992c, this.d, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.f2988b;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i2 = this.f2972a;
        if (i2 == -1) {
            iQ = -1;
        } else if (i2 != -2) {
            iQ = i2;
        }
        this.f2987a.setWidth(width2);
        this.f2987a.setHeight(iQ);
        N(true);
        this.f2987a.setOutsideTouchable((this.f2996f || this.f2995e) ? false : true);
        this.f2987a.setTouchInterceptor(this.f2976a);
        if (this.f2994d) {
            mj.a(this.f2987a, this.f2993c);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = c;
            if (method != null) {
                try {
                    method.invoke(this.f2987a, this.f2989b);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            this.f2987a.setEpicenterBounds(this.f2989b);
        }
        mj.c(this.f2987a, t(), this.f2992c, this.d, this.f);
        this.f2973a.setSelection(-1);
        if (!this.f2997g || this.f2973a.isInTouchMode()) {
            r();
        }
        if (this.f2997g) {
            return;
        }
        this.f2982a.post(this.f2974a);
    }

    public void d(int i) {
        this.d = i;
        this.f2991b = true;
    }

    @Override // a.y4
    public void dismiss() {
        this.f2987a.dismiss();
        C();
        this.f2987a.setContentView(null);
        this.f2973a = null;
        this.f2982a.removeCallbacks(this.f2977a);
    }

    @Override // a.y4
    public ListView e() {
        return this.f2973a;
    }

    public Drawable g() {
        return this.f2987a.getBackground();
    }

    public int i() {
        return this.f2992c;
    }

    public int k() {
        if (this.f2991b) {
            return this.d;
        }
        return 0;
    }

    public void l(int i) {
        this.f2992c = i;
    }

    public void n(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2979a;
        if (dataSetObserver == null) {
            this.f2979a = new p7(this);
        } else {
            ListAdapter listAdapter2 = this.f2986a;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2986a = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2979a);
        }
        h7 h7Var = this.f2973a;
        if (h7Var != null) {
            h7Var.setAdapter(this.f2986a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0123 A[PHI: r1
  0x0123: PHI (r1v1 int) = (r1v0 int), (r1v6 int) binds: [B:45:0x0118, B:47:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int q() {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t7.q():int");
    }

    public void r() {
        h7 h7Var = this.f2973a;
        if (h7Var != null) {
            h7Var.setListSelectionHidden(true);
            h7Var.requestLayout();
        }
    }

    public h7 s(Context context, boolean z) {
        return new h7(context, z);
    }

    public View t() {
        return this.f2990b;
    }

    public final int u(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f2987a.getMaxAvailableHeight(view, i, z);
        }
        Method method = b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f2987a, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2987a.getMaxAvailableHeight(view, i);
    }

    public Object v() {
        if (a()) {
            return this.f2973a.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (a()) {
            return this.f2973a.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (a()) {
            return this.f2973a.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (a()) {
            return this.f2973a.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.f2988b;
    }
}
