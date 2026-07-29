package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface q extends a, MotionLayout.l {
    void b(MotionLayout motionLayout);

    boolean e();

    boolean f();

    void g(MotionLayout motionLayout, HashMap<View, o> controllerMap);

    void h(Canvas canvas);

    void i(Canvas canvas);

    boolean j();
}
