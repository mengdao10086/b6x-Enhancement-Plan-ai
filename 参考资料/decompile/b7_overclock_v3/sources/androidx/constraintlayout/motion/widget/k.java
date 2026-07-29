package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends f {
    public static final float E = 20.0f;
    public int D = f.f3644f;

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
    }

    public abstract void o(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y);

    public abstract float p();

    public abstract float q();

    public abstract boolean r(int layoutWidth, int layoutHeight, RectF start, RectF end, float x10, float y10);

    public abstract void s(View view, RectF start, RectF end, float x10, float y10, String[] attribute, float[] value);
}
