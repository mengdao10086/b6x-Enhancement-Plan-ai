package a;

import a.p80;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uk1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vk1 f7607a;

    public uk1(vk1 vk1Var) {
        this.f7607a = vk1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        try {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:1191634433@qq.com"));
            intent.putExtra("android.intent.extra.SUBJECT", "Scene(Feedback)");
            intent.putExtra("android.intent.extra.TEXT", "");
            this.f7607a.f7703a.startActivity(Intent.createChooser(intent, "Scene(Feedback)"));
        } catch (Exception unused) {
            p80.a.C(p80.f2403a, this.f7607a.f7703a, "Failed to launch mail app!", null, 4, null);
        }
    }
}
