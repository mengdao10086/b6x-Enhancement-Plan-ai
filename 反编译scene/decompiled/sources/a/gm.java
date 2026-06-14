package a;

import a.hn;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hn.b f1036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f1037a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public hn.b f1038b;
    public int c;
    public int d;
    public int e;

    public gm() {
    }

    public gm(int i, Fragment fragment) {
        this.f6220a = i;
        this.f1037a = fragment;
        hn.b bVar = hn.b.RESUMED;
        this.f1036a = bVar;
        this.f1038b = bVar;
    }

    public gm(int i, Fragment fragment, hn.b bVar) {
        this.f6220a = i;
        this.f1037a = fragment;
        this.f1036a = fragment.f4253a;
        this.f1038b = bVar;
    }
}
