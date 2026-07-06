package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f5660a;
    public final /* synthetic */ Runnable b;

    public b02(Runnable runnable, Runnable runnable2) {
        this.f5660a = runnable;
        this.b = runnable2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        hz0 hz0Var = hz0.f1282a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        hz0Var.J0(((CompoundButton) view).isChecked());
        this.f5660a.run();
        this.b.run();
    }
}
