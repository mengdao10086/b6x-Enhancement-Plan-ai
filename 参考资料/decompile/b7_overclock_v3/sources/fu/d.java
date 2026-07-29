package fu;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f28836c = System.currentTimeMillis() + 86400000;

    public d(String str, int i10) {
        this.f28834a = str;
        this.f28835b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f28834a + "', code=" + this.f28835b + ", expired=" + this.f28836c + '}';
    }
}
