package a;

import a.p80;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7703a;

    public vk1(Context context) {
        f92.d(context, "context");
        this.f7703a = context;
    }

    public final void b() {
        View viewInflate = LayoutInflater.from(this.f7703a).inflate(2131558517, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Context context = this.f7703a;
        f92.c(viewInflate, "view");
        viewInflate.findViewById(2131362069).setOnClickListener(new tk1(p80.a.t(aVar, context, viewInflate, false, 4, null)));
        viewInflate.findViewById(2131362070).setOnClickListener(new uk1(this));
    }
}
