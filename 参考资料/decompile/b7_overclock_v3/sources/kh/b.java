package kh;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f37381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f37383c;

    public b(int i10, int i11, int i12) {
        this.f37381a = i10;
        this.f37382b = i11;
        this.f37383c = i12;
    }

    public int a() {
        return this.f37382b;
    }

    public int b() {
        return this.f37381a;
    }

    public int c() {
        return this.f37383c;
    }

    public void d(int i10) {
        this.f37382b = i10;
    }

    public void e(int i10) {
        this.f37381a = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f37381a == bVar.f37381a && this.f37382b == bVar.f37382b && this.f37383c == bVar.f37383c;
    }

    public void f(int i10) {
        this.f37383c = i10;
    }

    public int hashCode() {
        return (((this.f37381a * 31) + this.f37382b) * 31) + this.f37383c;
    }
}
