package a;

import a.p80;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nh1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh1 f6915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f2090a;

    public nh1(oh1 oh1Var, p80.b bVar) {
        this.f6915a = oh1Var;
        this.f2090a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2090a.c();
        Toast.makeText(this.f6915a.f7022a, this.f6915a.f7022a.getString(u61.dex2oat_faq_cn), 1).show();
        this.f6915a.f7022a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f6915a.f7022a.getString(u61.addin_dex2oat_helplink))));
    }
}
