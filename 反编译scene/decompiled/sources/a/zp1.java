package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iq1 f8088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3871a;

    public zp1(iq1 iq1Var, p80.b bVar) {
        this.f8088a = iq1Var;
        this.f3871a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3871a.c();
        this.f8088a.x();
    }
}
