package a;

import a.p80;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o80 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2216a;

    public o80(View view, p80.b bVar) {
        this.f2216a = view;
        this.f6994a = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() != 1) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect();
        this.f2216a.getGlobalVisibleRect(rect);
        if (!rect.contains(x, y) && this.f6994a.f()) {
            this.f6994a.c();
        }
        return true;
    }
}
