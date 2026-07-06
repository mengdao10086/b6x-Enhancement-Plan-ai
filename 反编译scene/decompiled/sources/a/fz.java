package a;

import android.graphics.Matrix;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fz implements pz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iz f6150a;

    public fz(iz izVar) {
        this.f6150a = izVar;
    }

    @Override // a.pz
    public void a(zz zzVar, Matrix matrix, int i) {
        this.f6150a.f1458a.set(i, zzVar.e());
        this.f6150a.f1459a[i] = zzVar.f(matrix);
    }

    @Override // a.pz
    public void b(zz zzVar, Matrix matrix, int i) {
        this.f6150a.f1458a.set(i + 4, zzVar.e());
        this.f6150a.f1465b[i] = zzVar.f(matrix);
    }
}
