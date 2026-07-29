package a1;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f145a;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void a(@p0 Bundle bundle) {
            this.f145a = bundle;
        }
    }

    public static final class b extends a {
        public boolean b() {
            return this.f145a.getBoolean(a1.d.T);
        }

        public int c() {
            return this.f145a.getInt(a1.d.R);
        }
    }

    public static final class c extends a {
        @p0
        public String b() {
            return this.f145a.getString(a1.d.S);
        }
    }

    public static final class d extends a {
        public int b() {
            return this.f145a.getInt(a1.d.f64a0);
        }

        public int c() {
            return this.f145a.getInt(a1.d.f65b0);
        }
    }

    public static final class e extends a {
        public int b() {
            return this.f145a.getInt(a1.d.Y);
        }

        public int c() {
            return this.f145a.getInt(a1.d.X);
        }
    }

    public static final class f extends a {
        public float b() {
            return this.f145a.getFloat(a1.d.Z);
        }
    }

    /* JADX INFO: renamed from: a1.g$g, reason: collision with other inner class name */
    public static final class C0007g extends a {
        public int b() {
            return this.f145a.getInt(a1.d.V);
        }

        public int c() {
            return this.f145a.getInt(a1.d.U);
        }
    }

    public static final class h extends a {
        @p0
        public CharSequence b() {
            return this.f145a.getCharSequence(a1.d.W);
        }
    }

    boolean a(@n0 View view, @p0 a aVar);
}
