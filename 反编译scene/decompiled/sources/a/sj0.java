package a;

import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sj0 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj0 f7405a = new sj0();

    public sj0() {
        super(0);
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 35 && f92.a(um0.f7612a.a("ro.vivo.os.name"), "Funtouch");
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}
