package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wn1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f7806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3460a;

    public wn1(jo1 jo1Var, p80.b bVar) {
        this.f7806a = jo1Var;
        this.f3460a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new nm1(this.f7806a.f1572a, this.f7806a.f6531a, this.f7806a.f1571a).p();
        this.f3460a.c();
    }
}
