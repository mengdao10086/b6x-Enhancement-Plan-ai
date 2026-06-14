package a;

import android.content.DialogInterface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kl1 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ hj0 f1653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i92 f1654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1655a;
    public final /* synthetic */ boolean b;

    public kl1(int i, l92 l92Var, boolean z, i92 i92Var, hj0 hj0Var) {
        this.f6618a = i;
        this.f1655a = l92Var;
        this.b = z;
        this.f1654a = i92Var;
        this.f1653a = hj0Var;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.f6618a != this.f1655a.f6687a || this.b != this.f1654a.b) {
            qx0.d().c();
        }
        this.f1653a.c();
    }
}
