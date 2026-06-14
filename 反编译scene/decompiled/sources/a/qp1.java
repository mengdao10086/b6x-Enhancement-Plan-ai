package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iq1 f7229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f2596a;

    public qp1(iq1 iq1Var, p80.b bVar) {
        this.f7229a = iq1Var;
        this.f2596a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2596a.c();
        this.f7229a.T();
    }
}
