package a;

import com.omarea.model.ChargeStatSession;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nk1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ok1 f2104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r01 f2105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2106a;

    public nk1(r01 r01Var, ArrayList arrayList, ok1 ok1Var, int i, int i2) {
        this.f2105a = r01Var;
        this.f2106a = arrayList;
        this.f2104a = ok1Var;
        this.f6927a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f2106a.iterator();
        while (it.hasNext()) {
            this.f2104a.f2262a.f2900a.n(((ChargeStatSession) it.next()).session);
        }
        this.f2105a.F(this.f2106a);
        this.f2105a.I(this.f6927a);
    }
}
