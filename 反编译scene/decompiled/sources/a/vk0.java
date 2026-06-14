package a;

import android.content.res.Resources;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vk0 extends g92 implements v72<Resources> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wk0 f7702a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vk0(wk0 wk0Var) {
        super(0);
        this.f7702a = wk0Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Resources i() {
        if (!sk0.f7408a.a().c()) {
            return super/*android.content.ContextWrapper*/.getResources();
        }
        Resources resources = super/*android.content.ContextWrapper*/.getResources();
        f92.c(resources, "super.getResources()");
        return new uk0(resources, sk0.f7408a.a());
    }
}
