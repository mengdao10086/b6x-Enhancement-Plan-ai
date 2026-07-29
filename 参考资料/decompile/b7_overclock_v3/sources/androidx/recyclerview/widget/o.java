package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.u0;
import androidx.recyclerview.R;

/* JADX INFO: loaded from: classes2.dex */
public class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f7162a = new o();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float fR = u0.R(childAt);
                if (fR > f10) {
                    f10 = fR;
                }
            }
        }
        return f10;
    }

    @Override // androidx.recyclerview.widget.n
    public void a(View view) {
        int i10 = R.id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i10);
        if (tag instanceof Float) {
            u0.N1(view, ((Float) tag).floatValue());
        }
        view.setTag(i10, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.n
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    @Override // androidx.recyclerview.widget.n
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (z10) {
            int i11 = R.id.item_touch_helper_previous_elevation;
            if (view.getTag(i11) == null) {
                Float fValueOf = Float.valueOf(u0.R(view));
                u0.N1(view, e(recyclerView, view) + 1.0f);
                view.setTag(i11, fValueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }
}
