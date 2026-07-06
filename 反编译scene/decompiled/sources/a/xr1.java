package a;

import android.view.MotionEvent;
import android.view.View;
import com.omarea.common.ui.OverScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xr1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f7915a;

    public xr1(zs1 zs1Var) {
        this.f7915a = zs1Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f92.c(motionEvent, "event");
        if (motionEvent.getAction() == 1) {
            ((OverScrollView) this.f7915a.w1(t61.home_root)).requestDisallowInterceptTouchEvent(false);
        } else {
            ((OverScrollView) this.f7915a.w1(t61.home_root)).requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
}
