package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aj1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f5613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f76a;

    public aj1(pj1 pj1Var, p80.b bVar) {
        this.f76a = pj1Var;
        this.f5613a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5613a.c();
        this.f76a.w();
    }
}
