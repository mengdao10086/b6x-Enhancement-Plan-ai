package fu;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f28827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f28828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28829d;

    public a(String str) {
        this.f28828c = str;
    }

    public void a(int i10) {
        this.f28829d = i10;
    }

    public void b(long j10) {
        this.f28826a = j10;
    }

    public void c(String str) {
        this.f28827b = str;
    }

    public boolean d() {
        return this.f28826a > System.currentTimeMillis();
    }

    public void e() {
        this.f28826a = 0L;
    }
}
