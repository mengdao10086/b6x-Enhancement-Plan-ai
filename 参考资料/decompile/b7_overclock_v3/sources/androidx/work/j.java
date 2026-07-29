package androidx.work;

import androidx.annotation.RestrictTo;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8564a = l.f("InputMerger");

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static j a(String className) {
        try {
            return (j) Class.forName(className).newInstance();
        } catch (Exception e10) {
            l.c().b(f8564a, "Trouble instantiating + " + className, e10);
            return null;
        }
    }

    @n0
    public abstract d b(@n0 List<d> inputs);
}
