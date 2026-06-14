package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ay1 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f5654a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay1(View view) {
        super(0);
        this.f5654a = view;
    }

    public final boolean a() {
        return this.f5654a.performHapticFeedback(4);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}
