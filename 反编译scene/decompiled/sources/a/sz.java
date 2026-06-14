package a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sz extends yz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f7445a;
    public final /* synthetic */ Matrix b;

    public sz(zz zzVar, List list, Matrix matrix) {
        this.f7445a = list;
        this.b = matrix;
    }

    @Override // a.yz
    public void a(Matrix matrix, xy xyVar, int i, Canvas canvas) {
        Iterator it = this.f7445a.iterator();
        while (it.hasNext()) {
            ((yz) it.next()).a(this.b, xyVar, i, canvas);
        }
    }
}
