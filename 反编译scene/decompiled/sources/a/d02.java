package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f5845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f455a;
    public final /* synthetic */ Runnable b;

    public d02(l02 l02Var, String str, Runnable runnable, Runnable runnable2) {
        this.f5845a = l02Var;
        this.f455a = str;
        this.f454a = runnable;
        this.b = runnable2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        wr0 wr0Var = this.f5845a.f1704a;
        String str = this.f455a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        wr0Var.q(str, ((CompoundButton) view).isChecked());
        this.f454a.run();
        this.b.run();
    }
}
