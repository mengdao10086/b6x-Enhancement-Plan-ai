package a;

import android.view.View;
import android.widget.Switch;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rd1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rd1 f7290a = new rd1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Scene.c cVar = Scene.f4798a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        cVar.k("get_next_release", ((Switch) view).isChecked());
    }
}
