package a;

import android.annotation.SuppressLint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Typeface f1000a;

    public ge(int i) {
        this.f1000a = null;
        this.f6198a = i;
    }

    @SuppressLint({"WrongConstant"})
    public ge(Typeface typeface) {
        this.f1000a = typeface;
        this.f6198a = 0;
    }

    @SuppressLint({"WrongConstant"})
    public boolean a() {
        return this.f6198a == 0;
    }
}
