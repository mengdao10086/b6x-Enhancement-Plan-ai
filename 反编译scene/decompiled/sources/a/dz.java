package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dz extends cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5949a = -1.0f;

    @Override // a.cz
    public void a(zz zzVar, float f, float f2, float f3) {
        zzVar.o(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        zzVar.m((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
