package a;

import a.p80;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f31 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f849a;

    public f31(String str, Context context, View view) {
        this.f849a = str;
        this.f6069a = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p80.a aVar = p80.f2403a;
        Context context = this.f6069a;
        f92.b(context);
        String string = this.f6069a.getString(2131886774);
        f92.c(string, "context.getString(R.string.help_title)");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6069a);
        String str = this.f849a;
        f92.c(str, "attrValue");
        View viewInflate = layoutInflaterFrom.inflate(Integer.parseInt(bc2.t(str, "@", "", false, 4, null)), (ViewGroup) null);
        f92.c(viewInflate, "LayoutInflater.from(cont…                        )");
        p80.a.D(aVar, context, string, "", viewInflate, null, 16, null);
    }
}
