package a;

import a.d70;
import com.omarea.ui.Games;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x21 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y21 f7847a;

    public x21(y21 y21Var) {
        this.f7847a = y21Var;
    }

    @Override // a.w70
    public void a(List<? extends d70.a> list) {
        f92.d(list, "apps");
        Games games = Games.this;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((d70.a) it.next()).getPackageName());
        }
        games.l(new ArrayList(arrayList));
    }
}
