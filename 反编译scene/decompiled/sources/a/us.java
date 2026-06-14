package a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class us implements vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f7626a;

    public us(View view) {
        this.f7626a = view.getOverlay();
    }

    @Override // a.vs
    public void a(Drawable drawable) {
        this.f7626a.add(drawable);
    }

    @Override // a.vs
    public void b(Drawable drawable) {
        this.f7626a.remove(drawable);
    }
}
