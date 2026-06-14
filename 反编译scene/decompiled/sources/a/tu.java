package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tu implements Comparable<tu> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7533a;
    public int b;

    public tu() {
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(tu tuVar) {
        int i = this.b;
        int i2 = tuVar.b;
        return i != i2 ? i - i2 : this.f7533a - tuVar.f7533a;
    }

    public String toString() {
        return "Order{order=" + this.b + ", index=" + this.f7533a + '}';
    }
}
