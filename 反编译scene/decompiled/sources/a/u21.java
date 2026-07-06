package a;

import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u21 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v21 f7559a;

    public u21(v21 v21Var) {
        this.f7559a = v21Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Scene.c.p(Scene.f4798a, "Battery Cycles: " + this.f7559a.c, 0, 2, null);
    }
}
