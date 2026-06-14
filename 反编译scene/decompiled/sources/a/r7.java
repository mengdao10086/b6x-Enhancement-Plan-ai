package a;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r7 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t7 f7276a;

    public r7(t7 t7Var) {
        this.f7276a = t7Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && (popupWindow = this.f7276a.f2987a) != null && popupWindow.isShowing() && x >= 0 && x < this.f7276a.f2987a.getWidth() && y >= 0 && y < this.f7276a.f2987a.getHeight()) {
            t7 t7Var = this.f7276a;
            t7Var.f2982a.postDelayed(t7Var.f2977a, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        t7 t7Var2 = this.f7276a;
        t7Var2.f2982a.removeCallbacks(t7Var2.f2977a);
        return false;
    }
}
