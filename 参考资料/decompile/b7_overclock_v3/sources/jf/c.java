package jf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f36367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36368b;

    public c(List<b> list, int i10) {
        this.f36367a = new ArrayList(list);
        this.f36368b = i10;
    }

    public List<b> a() {
        return this.f36367a;
    }

    public int b() {
        return this.f36368b;
    }

    public boolean c(List<b> list) {
        return this.f36367a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f36367a.equals(((c) obj).f36367a);
        }
        return false;
    }

    public int hashCode() {
        return this.f36367a.hashCode();
    }

    public String toString() {
        return "{ " + this.f36367a + " }";
    }
}
