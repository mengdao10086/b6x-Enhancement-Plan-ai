package h2;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends Animatable {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Animatable2.AnimationCallback f30276a;

        /* JADX INFO: renamed from: h2.b$a$a, reason: collision with other inner class name */
        public class C0357a extends Animatable2.AnimationCallback {
            public C0357a() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                a.this.b(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                a.this.c(drawable);
            }
        }

        @v0(23)
        public Animatable2.AnimationCallback a() {
            if (this.f30276a == null) {
                this.f30276a = new C0357a();
            }
            return this.f30276a;
        }

        public void b(Drawable drawable) {
        }

        public void c(Drawable drawable) {
        }
    }

    boolean b(@n0 a aVar);

    void c(@n0 a aVar);

    void d();
}
