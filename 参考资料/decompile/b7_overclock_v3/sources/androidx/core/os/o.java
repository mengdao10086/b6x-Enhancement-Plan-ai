package androidx.core.os;

import android.os.LocaleList;
import g.n0;
import g.p0;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@v0(24)
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f4670a;

    public o(Object obj) {
        this.f4670a = (LocaleList) obj;
    }

    @Override // androidx.core.os.n
    public int a(Locale locale) {
        return this.f4670a.indexOf(locale);
    }

    @Override // androidx.core.os.n
    public String b() {
        return this.f4670a.toLanguageTags();
    }

    @Override // androidx.core.os.n
    public Object c() {
        return this.f4670a;
    }

    @Override // androidx.core.os.n
    @p0
    public Locale d(@n0 String[] strArr) {
        return this.f4670a.getFirstMatch(strArr);
    }

    public boolean equals(Object obj) {
        return this.f4670a.equals(((n) obj).c());
    }

    @Override // androidx.core.os.n
    public Locale get(int i10) {
        return this.f4670a.get(i10);
    }

    public int hashCode() {
        return this.f4670a.hashCode();
    }

    @Override // androidx.core.os.n
    public boolean isEmpty() {
        return this.f4670a.isEmpty();
    }

    @Override // androidx.core.os.n
    public int size() {
        return this.f4670a.size();
    }

    public String toString() {
        return this.f4670a.toString();
    }
}
