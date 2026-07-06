package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lk1 implements q01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r01 f6717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sk1 f1824a;

    public lk1(r01 r01Var, sk1 sk1Var, ArrayList arrayList, View view) {
        this.f6717a = r01Var;
        this.f1824a = sk1Var;
    }

    @Override // a.q01
    public void b(int i) {
        this.f1824a.f2900a.n(this.f6717a.B(i).session);
        this.f6717a.E(i);
    }
}
