package a;

import android.content.Context;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7346a;

    public rz1(View view) {
        this.f7346a = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        if (iz1.f6457a.b()) {
            Context context = this.f7346a.getContext();
            f92.c(context, "context");
            new iz1(context).i();
            f92.c(view, "it");
            f = 0.15f;
        } else {
            Context context2 = this.f7346a.getContext();
            f92.c(context2, "context");
            iz1 iz1Var = new iz1(context2);
            if (!iz1Var.h()) {
                Scene.c cVar = Scene.f4798a;
                String string = this.f7346a.getContext().getString(u61.process_unsupported);
                f92.c(string, "context.getString(R.string.process_unsupported)");
                cVar.o(string, 0);
                return;
            }
            iz1Var.j();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}
