package a;

import a.p80;
import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e31 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f5962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f651a;

    public e31(String str, Context context, View view) {
        this.f651a = str;
        this.f5962a = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p80.a aVar = p80.f2403a;
        Context context = this.f5962a;
        f92.b(context);
        String str = this.f651a;
        f92.c(str, "text");
        p80.a.C(aVar, context, str, null, 4, null);
    }
}
