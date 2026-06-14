package a;

import android.view.View;
import android.widget.Switch;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class md1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final md1 f6796a = new md1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        boolean zIsChecked = ((Switch) view).isChecked();
        Scene.f4798a.k(hz0.f1282a.A(), zIsChecked);
        e50.f677a.U0(Boolean.valueOf(zIsChecked));
    }
}
