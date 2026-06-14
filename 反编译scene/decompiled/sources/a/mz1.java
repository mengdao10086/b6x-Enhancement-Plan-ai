package a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mz1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f6854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1979a;

    public mz1(l02 l02Var, View view) {
        this.f6854a = l02Var;
        this.f1979a = view;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f92.c(motionEvent, "event");
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.f1979a.getGlobalVisibleRect(rect);
        if (rect.contains(x, y)) {
            return false;
        }
        this.f6854a.k();
        return false;
    }
}
