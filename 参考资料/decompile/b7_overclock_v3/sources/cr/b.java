package cr;

import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class b implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f25799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AlgorithmParameterSpec> f25800b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f25801a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<AlgorithmParameterSpec> f25802b = new ArrayList();

        public a c(String str) {
            this.f25801a.add(str);
            this.f25802b.add(null);
            return this;
        }

        public a d(String str, AlgorithmParameterSpec algorithmParameterSpec) {
            this.f25801a.add(str);
            this.f25802b.add(algorithmParameterSpec);
            return this;
        }

        public b e() {
            if (this.f25801a.isEmpty()) {
                throw new IllegalStateException("cannot call build with no algorithm names added");
            }
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f25799a = Collections.unmodifiableList(new ArrayList(aVar.f25801a));
        this.f25800b = Collections.unmodifiableList(new ArrayList(aVar.f25802b));
    }

    public List<String> a() {
        return this.f25799a;
    }

    public List<AlgorithmParameterSpec> b() {
        return this.f25800b;
    }
}
