package a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e12 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h12 f5957a;

    public e12(h12 h12Var) {
        this.f5957a = h12Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f92.c(motionEvent, "event");
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.f5957a.f1093a.findViewById(t61.view_main).getGlobalVisibleRect(rect);
        if (rect.contains(x, y)) {
            return false;
        }
        this.f5957a.c();
        return false;
    }
}
