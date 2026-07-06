package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class oe implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf f7011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f2235a;

    public oe(pe peVar, hf hfVar, Object obj) {
        this.f7011a = hfVar;
        this.f2235a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7011a.a(this.f2235a);
    }
}
