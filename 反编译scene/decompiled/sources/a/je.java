package a;

import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f1529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1530a;
    public final int b;
    public final int c;

    @Deprecated
    public je(Uri uri, int i, int i2, boolean z, int i3) {
        pf.b(uri);
        this.f1529a = uri;
        this.f6503a = i;
        this.b = i2;
        this.f1530a = z;
        this.c = i3;
    }

    public static je a(Uri uri, int i, int i2, boolean z, int i3) {
        return new je(uri, i, i2, z, i3);
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.f6503a;
    }

    public Uri d() {
        return this.f1529a;
    }

    public int e() {
        return this.b;
    }

    public boolean f() {
        return this.f1530a;
    }
}
