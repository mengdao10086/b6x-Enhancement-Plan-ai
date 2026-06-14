package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gp implements RecyclerView.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ np f6229a;

    public gp(np npVar) {
        this.f6229a = npVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public int a(int i, int i2) {
        np npVar = this.f6229a;
        View view = npVar.f2137a;
        if (view == null) {
            return i2;
        }
        int iIndexOfChild = npVar.f2151e;
        if (iIndexOfChild == -1) {
            iIndexOfChild = npVar.f2141a.indexOfChild(view);
            this.f6229a.f2151e = iIndexOfChild;
        }
        return i2 == i + (-1) ? iIndexOfChild : i2 < iIndexOfChild ? i2 : i2 + 1;
    }
}
