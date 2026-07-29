package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import g.n0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class y implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20499a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    public static class a extends ViewGroup {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Method f20500f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewGroup f20501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f20502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Drawable> f20503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public y f20504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20505e;

        static {
            try {
                Class cls = Integer.TYPE;
                f20500f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public a(Context context, ViewGroup viewGroup, View view, y yVar) {
            super(context);
            this.f20503c = null;
            this.f20501a = viewGroup;
            this.f20502b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f20504d = yVar;
        }

        public void a(Drawable drawable) {
            c();
            if (this.f20503c == null) {
                this.f20503c = new ArrayList<>();
            }
            if (this.f20503c.contains(drawable)) {
                return;
            }
            this.f20503c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f20501a && viewGroup.getParent() != null && u0.O0(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f20501a.getLocationOnScreen(iArr2);
                    u0.e1(view, iArr[0] - iArr2[0]);
                    u0.f1(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public final void c() {
            if (this.f20505e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f20503c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f20505e = true;
                    this.f20501a.removeView(this);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            this.f20501a.getLocationOnScreen(new int[2]);
            this.f20502b.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f20502b.getWidth(), this.f20502b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f20503c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f20503c.get(i10).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public final void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f20501a.getLocationOnScreen(iArr2);
            this.f20502b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent f(int i10, int i11, Rect rect) {
            if (this.f20501a == null || f20500f == null) {
                return null;
            }
            try {
                e(new int[2]);
                f20500f.invoke(this.f20501a, Integer.valueOf(i10), Integer.valueOf(i11), rect);
                return null;
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
                return null;
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public void g(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f20503c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void h(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f20501a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f20501a == null) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            e(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@n0 Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        }

        @Override // android.view.View
        public boolean verifyDrawable(@n0 Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f20503c) != null && arrayList.contains(drawable));
        }
    }

    public y(Context context, ViewGroup viewGroup, View view) {
        this.f20499a = new a(context, viewGroup, view, this);
    }

    public static y e(View view) {
        ViewGroup viewGroupG = b0.g(view);
        if (viewGroupG == null) {
            return null;
        }
        int childCount = viewGroupG.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroupG.getChildAt(i10);
            if (childAt instanceof a) {
                return ((a) childAt).f20504d;
            }
        }
        return new v(viewGroupG.getContext(), viewGroupG, view);
    }

    @Override // com.google.android.material.internal.a0
    public void a(@n0 Drawable drawable) {
        this.f20499a.a(drawable);
    }

    @Override // com.google.android.material.internal.a0
    public void b(@n0 Drawable drawable) {
        this.f20499a.g(drawable);
    }
}
