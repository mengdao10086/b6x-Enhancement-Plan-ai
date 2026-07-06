package a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ns implements os {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f6943a;

    public ns(ViewGroup viewGroup) {
        this.f6943a = viewGroup.getOverlay();
    }

    @Override // a.vs
    public void a(Drawable drawable) {
        this.f6943a.add(drawable);
    }

    @Override // a.vs
    public void b(Drawable drawable) {
        this.f6943a.remove(drawable);
    }

    @Override // a.os
    public void c(View view) {
        this.f6943a.remove(view);
    }

    @Override // a.os
    public void d(View view) {
        this.f6943a.add(view);
    }
}
