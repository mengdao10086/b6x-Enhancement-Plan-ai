package ah;

import android.view.View;
import xi.b0;
import xi.c0;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements c0<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f711b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f712a;

    public class a extends yi.a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0<Object> f713b;

        public a(b0<Object> b0Var) {
            this.f713b = b0Var;
        }

        @Override // yi.a
        public void a() {
            c.this.f712a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f713b.onNext(c.f711b);
        }
    }

    public c(View view) {
        this.f712a = view;
    }

    @Override // xi.c0
    public void a(b0<Object> b0Var) throws Exception {
        yi.a.b();
        a aVar = new a(b0Var);
        b0Var.c(aVar);
        this.f712a.addOnAttachStateChangeListener(aVar);
    }
}
