package s4;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class m<Z> extends e<Z> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49494e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f49495f = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bumptech.glide.i f49496d;

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((m) message.obj).d();
            return true;
        }
    }

    public m(com.bumptech.glide.i iVar, int i10, int i11) {
        super(i10, i11);
        this.f49496d = iVar;
    }

    public static <Z> m<Z> e(com.bumptech.glide.i iVar, int i10, int i11) {
        return new m<>(iVar, i10, i11);
    }

    public void d() {
        this.f49496d.C(this);
    }

    @Override // s4.p
    public void g(@n0 Z z10, @p0 t4.f<? super Z> fVar) {
        com.bumptech.glide.request.e eVarR = r();
        if (eVarR == null || !eVarR.isComplete()) {
            return;
        }
        f49495f.obtainMessage(1, this).sendToTarget();
    }

    @Override // s4.p
    public void s(@p0 Drawable drawable) {
    }
}
