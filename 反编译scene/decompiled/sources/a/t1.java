package a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t1 extends ContentFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f7451a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(w1 w1Var, Context context) {
        super(context);
        this.f7451a = w1Var;
    }

    public final boolean c(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f7451a.Z(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.f7451a.T(0);
        return true;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(r2.d(getContext(), i));
    }
}
