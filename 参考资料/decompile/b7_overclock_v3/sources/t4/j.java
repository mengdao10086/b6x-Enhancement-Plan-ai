package t4;

import android.view.View;
import t4.f;

/* JADX INFO: loaded from: classes2.dex */
public class j<R> implements f<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f50883a;

    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f50883a = aVar;
    }

    @Override // t4.f
    public boolean a(R r10, f.a aVar) {
        if (aVar.getView() == null) {
            return false;
        }
        this.f50883a.a(aVar.getView());
        return false;
    }
}
