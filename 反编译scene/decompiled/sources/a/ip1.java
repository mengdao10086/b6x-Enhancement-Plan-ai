package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ip1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iq1 f6433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1398a;

    public ip1(iq1 iq1Var, boolean z, p80.b bVar) {
        this.f6433a = iq1Var;
        this.f1398a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1398a.c();
        this.f6433a.F();
    }
}
