package xf;

import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f55293a;

    public o() {
        this.f55293a = null;
        this.f55293a = new androidx.collection.a();
    }

    public static o b() {
        return new o();
    }

    public void a(String str, String str2) {
        this.f55293a.put(str, str2);
    }

    public Map<String, String> c() {
        return this.f55293a;
    }

    public boolean d() {
        Map<String, String> map = this.f55293a;
        return map == null || map.isEmpty();
    }

    public void e(String str) {
        this.f55293a.remove(str);
    }

    public String toString() {
        return "HttpHeaders{mHeaders=" + this.f55293a + '}';
    }
}
