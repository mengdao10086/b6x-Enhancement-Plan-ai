package a;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ok extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Uri f2260a;

    public ok(mk mkVar, Context context, Uri uri) {
        super(mkVar);
        this.f7031a = context;
        this.f2260a = uri;
    }

    @Override // a.mk
    public boolean a() {
        return nk.a(this.f7031a, this.f2260a);
    }

    @Override // a.mk
    public mk b(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // a.mk
    public mk c(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // a.mk
    public String g() {
        return nk.c(this.f7031a, this.f2260a);
    }

    @Override // a.mk
    public mk[] h() {
        throw new UnsupportedOperationException();
    }
}
