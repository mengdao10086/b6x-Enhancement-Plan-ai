package a;

import android.content.Context;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2814a;

    public s02(View view, float f) {
        this.f2814a = view;
        this.f7349a = f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        if (u12.f3107a.b()) {
            Context context = this.f2814a.getContext();
            f92.c(context, "context");
            new u12(context).m(true);
            f92.c(view, "it");
            f = this.f7349a;
        } else {
            Context context2 = this.f2814a.getContext();
            f92.c(context2, "context");
            u12 u12Var = new u12(context2);
            if (!u12Var.l()) {
                Scene.c cVar = Scene.f4798a;
                String string = this.f2814a.getContext().getString(u61.process_unsupported);
                f92.c(string, "context.getString(R.string.process_unsupported)");
                cVar.o(string, 0);
                return;
            }
            u12Var.q();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}
