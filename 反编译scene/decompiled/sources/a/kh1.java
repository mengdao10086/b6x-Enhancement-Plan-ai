package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kh1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh1 f6607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1635a;

    public kh1(oh1 oh1Var, p80.b bVar) {
        this.f6607a = oh1Var;
        this.f1635a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1635a.c();
        oh1 oh1Var = this.f6607a;
        String string = oh1Var.f7022a.getString(u61.scene_speed_compile);
        f92.c(string, "context.getString(R.string.scene_speed_compile)");
        oh1Var.k(string);
    }
}
