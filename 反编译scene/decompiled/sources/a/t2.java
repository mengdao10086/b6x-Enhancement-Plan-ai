package a;

import android.graphics.drawable.Animatable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t2 extends y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animatable f7455a;

    public t2(Animatable animatable) {
        super();
        this.f7455a = animatable;
    }

    @Override // a.y2
    public void c() {
        this.f7455a.start();
    }

    @Override // a.y2
    public void d() {
        this.f7455a.stop();
    }
}
