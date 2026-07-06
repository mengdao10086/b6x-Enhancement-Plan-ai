package a;

import a.hn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xm implements kn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn f7903a = null;

    public void a(hn.a aVar) {
        this.f7903a.i(aVar);
    }

    public void b() {
        if (this.f7903a == null) {
            this.f7903a = new nn(this);
        }
    }

    public boolean c() {
        return this.f7903a != null;
    }

    @Override // a.kn
    public hn getLifecycle() {
        b();
        return this.f7903a;
    }
}
