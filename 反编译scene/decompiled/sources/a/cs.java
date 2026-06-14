package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cs extends bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f5823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ds f441a;

    public cs(ds dsVar, ba baVar) {
        this.f441a = dsVar;
        this.f5823a = baVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.zr
    public void e(as asVar) {
        ((ArrayList) this.f5823a.get(this.f441a.f598a)).remove(asVar);
        asVar.P(this);
    }
}
