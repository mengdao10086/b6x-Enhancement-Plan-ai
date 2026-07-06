package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gm0 f7741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f3321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3322a;

    public w02(CompoundButton compoundButton, gm0 gm0Var, Runnable runnable) {
        this.f3321a = compoundButton;
        this.f7741a = gm0Var;
        this.f3322a = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean zC;
        if (this.f3321a.isChecked()) {
            gm0 gm0Var = this.f7741a;
            Context context = this.f3321a.getContext();
            f92.c(context, "context");
            zC = gm0Var.b(f92.a(new ri0(context).d(fa0.f867a.j()), Boolean.TRUE));
        } else {
            zC = this.f7741a.c();
        }
        if (zC) {
            this.f3322a.run();
            return;
        }
        Scene.c cVar = Scene.f4798a;
        String string = this.f3321a.getContext().getString(u61.device_unsupport);
        f92.c(string, "context.getString(R.string.device_unsupport)");
        Scene.c.p(cVar, string, 0, 2, null);
        this.f3321a.setChecked(!r5.isChecked());
    }
}
