package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ly extends sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ky f6746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Typeface f1852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1853a;

    public ly(ky kyVar, Typeface typeface) {
        this.f1852a = typeface;
        this.f6746a = kyVar;
    }

    @Override // a.sy
    public void a(int i) {
        d(this.f1852a);
    }

    @Override // a.sy
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f1853a = true;
    }

    public final void d(Typeface typeface) {
        if (this.f1853a) {
            return;
        }
        this.f6746a.a(typeface);
    }
}
