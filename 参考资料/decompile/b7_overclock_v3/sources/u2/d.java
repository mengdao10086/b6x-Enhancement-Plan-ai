package u2;

import androidx.annotation.RestrictTo;
import androidx.room.j0;
import androidx.room.m1;
import androidx.room.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@u0
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m1
    @j0(name = "key")
    @n0
    public String f51807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    @j0(name = "long_value")
    public Long f51808b;

    public d(@n0 String key, boolean value) {
        this(key, value ? 1L : 0L);
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof d)) {
            return false;
        }
        d dVar = (d) o10;
        if (!this.f51807a.equals(dVar.f51807a)) {
            return false;
        }
        Long l10 = this.f51808b;
        Long l11 = dVar.f51808b;
        return l10 != null ? l10.equals(l11) : l11 == null;
    }

    public int hashCode() {
        int iHashCode = this.f51807a.hashCode() * 31;
        Long l10 = this.f51808b;
        return iHashCode + (l10 != null ? l10.hashCode() : 0);
    }

    public d(@n0 String key, long value) {
        this.f51807a = key;
        this.f51808b = Long.valueOf(value);
    }
}
