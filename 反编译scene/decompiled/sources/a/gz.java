package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gz implements oz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f6254a;

    public gz(iz izVar, float f) {
        this.f6254a = f;
    }

    @Override // a.oz
    public bz a(bz bzVar) {
        return bzVar instanceof kz ? bzVar : new az(this.f6254a, bzVar);
    }
}
