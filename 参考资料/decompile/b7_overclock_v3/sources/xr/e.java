package xr;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f55877a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f55878a;

        public e a() {
            return new e(this.f55878a);
        }

        public a b(f fVar) {
            this.f55878a = fVar;
            return this;
        }
    }

    public e(f fVar) {
        this.f55877a = fVar;
    }

    public static a a() {
        return new a();
    }

    public static e c(Object obj) {
        return obj instanceof e ? (e) obj : new a().b(f.y(obj)).a();
    }

    public f b() {
        return this.f55877a;
    }
}
