package a;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b20 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f5666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AutoCompleteTextView f202a;

    public b20(e20 e20Var, AutoCompleteTextView autoCompleteTextView) {
        this.f5666a = e20Var;
        this.f202a = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f5666a.B()) {
                this.f5666a.f649a = false;
            }
            this.f5666a.F(this.f202a);
        }
        return false;
    }
}
