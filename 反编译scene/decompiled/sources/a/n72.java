package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n72 extends g92 implements g82<String, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6885a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n72(ArrayList arrayList) {
        super(1);
        this.f6885a = arrayList;
    }

    public final void a(String str) {
        f92.d(str, "it");
        this.f6885a.add(str);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(String str) {
        a(str);
        return m42.f6769a;
    }
}
