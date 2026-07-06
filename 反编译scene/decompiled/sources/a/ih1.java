package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ih1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh1 f6413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1371a;

    public ih1(View view, oh1 oh1Var, p80.b bVar) {
        this.f1371a = view;
        this.f6413a = oh1Var;
        this.f1370a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1370a.c();
        oh1 oh1Var = this.f6413a;
        String string = this.f1371a.getContext().getString(u61.scene_dex2at_compact);
        f92.c(string, "context.getString(R.string.scene_dex2at_compact)");
        oh1Var.k(string);
    }
}
