package wd;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Dialog f54637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54640d;

    public a(@n0 Dialog dialog, @n0 Rect rect) {
        this.f54637a = dialog;
        this.f54638b = rect.left;
        this.f54639c = rect.top;
        this.f54640d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@n0 View view, @n0 MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f54638b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f54639c + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i10 = this.f54640d;
            motionEventObtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f54637a.onTouchEvent(motionEventObtain);
    }
}
