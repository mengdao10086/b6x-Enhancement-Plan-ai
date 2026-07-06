package a;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pp implements op {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final op f7136a = new pp();

    public static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float fT = eh.t(childAt);
                if (fT > f) {
                    f = fT;
                }
            }
        }
        return f;
    }

    @Override // a.op
    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(eo.item_touch_helper_previous_elevation) == null) {
            Float fValueOf = Float.valueOf(eh.t(view));
            eh.q0(view, e(recyclerView, view) + 1.0f);
            view.setTag(eo.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // a.op
    public void b(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(eo.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                eh.q0(view, ((Float) tag).floatValue());
            }
            view.setTag(eo.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // a.op
    public void c(View view) {
    }

    @Override // a.op
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }
}
