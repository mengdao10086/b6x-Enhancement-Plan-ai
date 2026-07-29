package lt;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f40446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f40447b;

    public a(String str, String str2) {
        this.f40446a = str;
        this.f40447b = str2;
    }

    public final int a(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    public String b() {
        return this.f40446a;
    }

    public String c() {
        return this.f40447b;
    }

    public final boolean d(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar == this || (d(this.f40446a, aVar.f40446a) && d(this.f40447b, aVar.f40447b));
    }

    public int hashCode() {
        return a(this.f40446a) + (a(this.f40447b) * 31);
    }
}
