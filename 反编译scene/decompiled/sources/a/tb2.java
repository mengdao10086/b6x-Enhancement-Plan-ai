package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tb2 extends g92 implements g82<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7486a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tb2(String str) {
        super(1);
        this.f7486a = str;
    }

    @Override // a.g82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String f(String str) {
        f92.d(str, "line");
        return this.f7486a + str;
    }
}
