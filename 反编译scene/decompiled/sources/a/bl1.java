package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bl1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fl1 f5715a;

    public bl1(fl1 fl1Var) {
        this.f5715a = fl1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p80.a aVar = p80.f2403a;
        g91 g91VarQ = this.f5715a.q();
        String string = this.f5715a.q().getString(u61.btn_help);
        f92.c(string, "context.getString(R.string.btn_help)");
        String string2 = this.f5715a.q().getString(u61.dialog_addin_device_desc);
        f92.c(string2, "context.getString(R.stri…dialog_addin_device_desc)");
        p80.a.b(aVar, g91VarQ, string, string2, null, 8, null);
    }
}
