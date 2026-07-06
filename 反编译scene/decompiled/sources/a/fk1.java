package a;

import com.omarea.model.PowerStatSession;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fk1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ gk1 f908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f910a;

    public fk1(s11 s11Var, ArrayList arrayList, gk1 gk1Var, int i, int i2) {
        this.f909a = s11Var;
        this.f910a = arrayList;
        this.f908a = gk1Var;
        this.f6115a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f910a.iterator();
        while (it.hasNext()) {
            this.f908a.f1027a.f1648a.o(((PowerStatSession) it.next()).session);
        }
        this.f909a.F(this.f910a);
        this.f909a.G(this.f6115a);
    }
}
