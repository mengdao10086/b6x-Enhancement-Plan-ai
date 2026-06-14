package androidx.lifecycle;

import a.gn;
import a.hn;
import a.in;
import a.kn;
import a.pn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CompositeGeneratedAdaptersObserver implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gn[] f8202a;

    public CompositeGeneratedAdaptersObserver(gn[] gnVarArr) {
        this.f8202a = gnVarArr;
    }

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        pn pnVar = new pn();
        for (gn gnVar : this.f8202a) {
            gnVar.a(knVar, aVar, false, pnVar);
        }
        for (gn gnVar2 : this.f8202a) {
            gnVar2.a(knVar, aVar, true, pnVar);
        }
    }
}
