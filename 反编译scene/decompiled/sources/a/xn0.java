package a;

import com.omarea.model.MagiskModuleUnofficial;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xn0<V> implements Callable<ArrayList<MagiskModuleUnofficial>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yn0 f7906a;

    public xn0(yn0 yn0Var) {
        this.f7906a = yn0Var;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ArrayList<MagiskModuleUnofficial> call() {
        String strS = this.f7906a.s(no0.f6937a.a() + "/scene-magisk-modules", "");
        if (!(strS.length() > 0)) {
            return null;
        }
        d30 d30VarW = this.f7906a.w(strS);
        int iG = d30VarW != null ? d30VarW.g() : 0;
        if (iG <= 0) {
            return null;
        }
        ArrayList<MagiskModuleUnofficial> arrayList = new ArrayList<>();
        for (int i = 0; i < iG; i++) {
            f92.b(d30VarW);
            g30 g30VarD = d30VarW.d(i);
            yn0 yn0Var = this.f7906a;
            f92.c(g30VarD, "item");
            MagiskModuleUnofficial magiskModuleUnofficialC = yn0Var.C(g30VarD);
            if (magiskModuleUnofficialC != null) {
                arrayList.add(magiskModuleUnofficialC);
            }
        }
        return arrayList;
    }
}
