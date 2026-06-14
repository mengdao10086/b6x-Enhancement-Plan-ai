package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jq1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iz0 f6536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1578a;

    public jq1(p80.b bVar, iz0 iz0Var) {
        this.f1578a = bVar;
        this.f6536a = iz0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1578a.c();
        this.f6536a.h();
    }
}
