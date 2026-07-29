package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f48600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f48601b;

    public k(Method method, List<?> list) {
        this.f48600a = method;
        this.f48601b = Collections.unmodifiableList(list);
    }

    public static k c(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new k(method, new ArrayList(list));
    }

    public List<?> a() {
        return this.f48601b;
    }

    public Method b() {
        return this.f48600a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f48600a.getDeclaringClass().getName(), this.f48600a.getName(), this.f48601b);
    }
}
