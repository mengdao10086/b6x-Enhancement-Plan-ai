package a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ss extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ts f7427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f2919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Drawable> f2920a;
    public boolean b;

    static {
        try {
            ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public ss(Context context, ViewGroup viewGroup, View view, ts tsVar) {
        super(context);
        this.f2920a = null;
        this.f2919a = viewGroup;
        this.f2918a = view;
        setRight(viewGroup.getWidth());
        setBottom(viewGroup.getHeight());
        viewGroup.addView(this);
        this.f7427a = tsVar;
    }

    public void a(Drawable drawable) {
        c();
        if (this.f2920a == null) {
            this.f2920a = new ArrayList<>();
        }
        if (this.f2920a.contains(drawable)) {
            return;
        }
        this.f2920a.add(drawable);
        invalidate(drawable.getBounds());
        drawable.setCallback(this);
    }

    public void b(View view) {
        c();
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != this.f2919a && viewGroup.getParent() != null && eh.P(viewGroup)) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                this.f2919a.getLocationOnScreen(iArr2);
                eh.V(view, iArr[0] - iArr2[0]);
                eh.W(view, iArr[1] - iArr2[1]);
            }
            viewGroup.removeView(view);
            if (view.getParent() != null) {
                viewGroup.removeView(view);
            }
        }
        super.addView(view);
    }

    public final void c() {
        if (this.b) {
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }
    }

    public final void d() {
        if (getChildCount() == 0) {
            ArrayList<Drawable> arrayList = this.f2920a;
            if (arrayList == null || arrayList.size() == 0) {
                this.b = true;
                this.f2919a.removeView(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f2919a.getLocationOnScreen(new int[2]);
        this.f2918a.getLocationOnScreen(new int[2]);
        canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
        canvas.clipRect(new Rect(0, 0, this.f2918a.getWidth(), this.f2918a.getHeight()));
        super.dispatchDraw(canvas);
        ArrayList<Drawable> arrayList = this.f2920a;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f2920a.get(i).draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void e(int[] iArr) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.f2919a.getLocationOnScreen(iArr2);
        this.f2918a.getLocationOnScreen(iArr3);
        iArr[0] = iArr3[0] - iArr2[0];
        iArr[1] = iArr3[1] - iArr2[1];
    }

    public void f(Drawable drawable) {
        ArrayList<Drawable> arrayList = this.f2920a;
        if (arrayList != null) {
            arrayList.remove(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(null);
            d();
        }
    }

    public void g(View view) {
        super.removeView(view);
        d();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (this.f2919a == null) {
            return null;
        }
        rect.offset(iArr[0], iArr[1]);
        if (!(this.f2919a instanceof ViewGroup)) {
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
    public void invalidateDrawable(Drawable drawable) {
        invalidate(drawable.getBounds());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        ArrayList<Drawable> arrayList;
        return super.verifyDrawable(drawable) || ((arrayList = this.f2920a) != null && arrayList.contains(drawable));
    }
}
