package a;

import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n12 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u12 f6864a;

    public n12(u12 u12Var) {
        this.f6864a = u12Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u12.f3110a = !u12.f3110a;
        boolean z = u12.f3110a;
        f92.c(view, "it");
        if (!z) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
            Toast.makeText(this.f6864a.f3113a, this.f6864a.f3113a.getString(u61.process_locked), 1).show();
        }
    }
}
