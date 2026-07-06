package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class oy extends nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qy f7065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sy f2342a;

    public oy(qy qyVar, sy syVar) {
        this.f7065a = qyVar;
        this.f2342a = syVar;
    }

    @Override // a.nc
    public void d(int i) {
        this.f7065a.f2656a = true;
        this.f2342a.a(i);
    }

    @Override // a.nc
    public void e(Typeface typeface) {
        qy qyVar = this.f7065a;
        qyVar.f2654a = Typeface.create(typeface, qyVar.f2652a);
        this.f7065a.f2656a = true;
        this.f2342a.b(this.f7065a.f2654a, false);
    }
}
