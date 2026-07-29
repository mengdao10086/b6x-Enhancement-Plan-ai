package androidx.work;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import g.n0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<a> f8356a = new HashSet();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final Uri f8357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f8358b;

        public a(@n0 Uri uri, boolean triggerForDescendants) {
            this.f8357a = uri;
            this.f8358b = triggerForDescendants;
        }

        @n0
        public Uri a() {
            return this.f8357a;
        }

        public boolean b() {
            return this.f8358b;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || a.class != o10.getClass()) {
                return false;
            }
            a aVar = (a) o10;
            return this.f8358b == aVar.f8358b && this.f8357a.equals(aVar.f8357a);
        }

        public int hashCode() {
            return (this.f8357a.hashCode() * 31) + (this.f8358b ? 1 : 0);
        }
    }

    public void a(@n0 Uri uri, boolean triggerForDescendants) {
        this.f8356a.add(new a(uri, triggerForDescendants));
    }

    @n0
    public Set<a> b() {
        return this.f8356a;
    }

    public int c() {
        return this.f8356a.size();
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || c.class != o10.getClass()) {
            return false;
        }
        return this.f8356a.equals(((c) o10).f8356a);
    }

    public int hashCode() {
        return this.f8356a.hashCode();
    }
}
