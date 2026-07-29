package t4;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public class k<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f50884a;

    public interface a {
        Animation a(Context context);
    }

    public k(a aVar) {
        this.f50884a = aVar;
    }

    @Override // t4.f
    public boolean a(R r10, f.a aVar) {
        View view = aVar.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f50884a.a(view.getContext()));
        return false;
    }
}
