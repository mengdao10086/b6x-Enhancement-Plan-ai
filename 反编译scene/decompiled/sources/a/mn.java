package a;

import a.hn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hn.b f6824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public in f1958a;

    public mn(jn jnVar, hn.b bVar) {
        this.f1958a = on.f(jnVar);
        this.f6824a = bVar;
    }

    public void a(kn knVar, hn.a aVar) {
        hn.b bVarH = nn.h(aVar);
        this.f6824a = nn.l(this.f6824a, bVarH);
        this.f1958a.a(knVar, aVar);
        this.f6824a = bVarH;
    }
}
