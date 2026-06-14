package a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o02 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a12 f6967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2183a;

    public o02(a12 a12Var, View view) {
        this.f6967a = a12Var;
        this.f2183a = view;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        f92.c(motionEvent, "event");
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.f2183a.getGlobalVisibleRect(rect);
        if (rect.contains(x, y)) {
            return false;
        }
        this.f6967a.b();
        return false;
    }
}
