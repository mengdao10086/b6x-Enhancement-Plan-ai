package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f11701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f11702b;

        public a(b bVar, View view) {
            this.f11701a = bVar;
            this.f11702b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f11701a;
            if (bVar != null) {
                bVar.a(this.f11702b);
            }
        }
    }

    public interface b {
        void a(View view);
    }

    public b1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static float a(float f10, int i10) {
        float f11;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (i10 == 0) {
            return f10;
        }
        if (i10 == 1) {
            f11 = displayMetrics.density;
        } else if (i10 == 2) {
            f11 = displayMetrics.scaledDensity;
        } else if (i10 == 3) {
            f10 *= displayMetrics.xdpi;
            f11 = 0.013888889f;
        } else if (i10 == 4) {
            f11 = displayMetrics.xdpi;
        } else {
            if (i10 != 5) {
                return 0.0f;
            }
            f10 *= displayMetrics.xdpi;
            f11 = 0.03937008f;
        }
        return f10 * f11;
    }

    public static int b(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(View view, b bVar) {
        view.post(new a(bVar, view));
    }

    public static int d(View view) {
        return f(view)[1];
    }

    public static int e(View view) {
        return f(view)[0];
    }

    public static int[] f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i10 = layoutParams.height;
        view.measure(childMeasureSpec, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int g(float f10) {
        return (int) ((f10 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int h(float f10) {
        return (int) ((f10 / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int i(float f10) {
        return (int) ((f10 * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
