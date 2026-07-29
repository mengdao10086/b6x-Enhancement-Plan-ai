package g2;

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

/* JADX INFO: loaded from: classes2.dex */
public class w implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f28983a;

    public static class a extends ViewGroup {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Method f28984f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewGroup f28985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f28986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Drawable> f28987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public w f28988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f28989e;

        static {
            try {
                Class cls = Integer.TYPE;
                f28984f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        public a(Context context, ViewGroup viewGroup, View view, w wVar) {
            super(context);
            this.f28987c = null;
            this.f28985a = viewGroup;
            this.f28986b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f28988d = wVar;
        }

        public void a(Drawable drawable) {
            c();
            if (this.f28987c == null) {
                this.f28987c = new ArrayList<>();
            }
            if (this.f28987c.contains(drawable)) {
                return;
            }
            this.f28987c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f28985a && viewGroup.getParent() != null && u0.O0(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f28985a.getLocationOnScreen(iArr2);
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
            if (this.f28989e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        public final void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f28987c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f28989e = true;
                    this.f28985a.removeView(this);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            this.f28985a.getLocationOnScreen(new int[2]);
            this.f28986b.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f28986b.getWidth(), this.f28986b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f28987c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f28987c.get(i10).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public final void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f28985a.getLocationOnScreen(iArr2);
            this.f28986b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewParent f(int i10, int i11, Rect rect) {
            if (this.f28985a == null || f28984f == null) {
                return null;
            }
            try {
                e(new int[2]);
                f28984f.invoke(this.f28985a, Integer.valueOf(i10), Integer.valueOf(i11), rect);
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
            ArrayList<Drawable> arrayList = this.f28987c;
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
            if (this.f28985a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f28985a == null) {
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
            return super.verifyDrawable(drawable) || ((arrayList = this.f28987c) != null && arrayList.contains(drawable));
        }
    }

    public w(Context context, ViewGroup viewGroup, View view) {
        this.f28983a = new a(context, viewGroup, view, this);
    }

    public static w e(View view) {
        ViewGroup viewGroupF = f(view);
        if (viewGroupF == null) {
            return null;
        }
        int childCount = viewGroupF.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroupF.getChildAt(i10);
            if (childAt instanceof a) {
                return ((a) childAt).f28988d;
            }
        }
        return new s(viewGroupF.getContext(), viewGroupF, view);
    }

    public static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // g2.y
    public void a(@n0 Drawable drawable) {
        this.f28983a.a(drawable);
    }

    @Override // g2.y
    public void b(@n0 Drawable drawable) {
        this.f28983a.g(drawable);
    }
}
