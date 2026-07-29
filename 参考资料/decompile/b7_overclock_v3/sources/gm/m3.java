package gm;

/* JADX INFO: loaded from: classes5.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29744b = 0;

    public m3(String str) {
        this.f29743a = str;
    }

    public boolean a() {
        return this.f29744b != -1;
    }

    public String b() {
        int i10 = this.f29744b;
        if (i10 == -1) {
            return null;
        }
        int iIndexOf = this.f29743a.indexOf(46, i10);
        if (iIndexOf == -1) {
            String strSubstring = this.f29743a.substring(this.f29744b);
            this.f29744b = -1;
            return strSubstring;
        }
        String strSubstring2 = this.f29743a.substring(this.f29744b, iIndexOf);
        this.f29744b = iIndexOf + 1;
        return strSubstring2;
    }
}
