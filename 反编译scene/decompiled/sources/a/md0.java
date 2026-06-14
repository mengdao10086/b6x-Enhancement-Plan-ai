package a;

import a.p80;
import android.content.DialogInterface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class md0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nd0 f6795a;

    public md0(nd0 nd0Var) {
        this.f6795a = nd0Var;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        cl clVarJ = this.f6795a.f6902a.f7008a.j();
        if (clVarJ != null) {
            p80.a aVar = p80.f2403a;
            f92.c(clVarJ, "this");
            aVar.L(clVarJ);
        }
    }
}
