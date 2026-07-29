package h0;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class j0 {

    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static a f30160b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0355a f30161a = new C0355a();

        /* JADX INFO: renamed from: h0.j0$a$a, reason: collision with other inner class name */
        public static class C0355a {
            public void a(@g.n0 SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        @Deprecated
        public static a b() {
            if (f30160b == null) {
                f30160b = new a();
            }
            return f30160b;
        }

        @Deprecated
        public void a(@g.n0 SharedPreferences.Editor editor) {
            this.f30161a.a(editor);
        }
    }
}
