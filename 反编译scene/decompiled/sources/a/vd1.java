package a;

import android.view.View;
import android.widget.Switch;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vd1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vd1 f7683a = new vd1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Scene.c cVar = Scene.f4798a;
        String strG = hz0.f1282a.G();
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        cVar.k(strG, ((Switch) view).isChecked());
        z90.b(z90.f8048a, aa0.SCENE_NOTIFY_UPDATE, null, 2, null);
    }
}
