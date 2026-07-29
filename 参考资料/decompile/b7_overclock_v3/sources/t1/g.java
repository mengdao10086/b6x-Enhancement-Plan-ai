package t1;

import android.content.Context;
import android.media.session.MediaSessionManager;
import g.v0;
import t1.e;
import t1.h;

/* JADX INFO: loaded from: classes2.dex */
@v0(28)
public class g extends f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaSessionManager f50837h;

    public g(Context context) {
        super(context);
        this.f50837h = (MediaSessionManager) context.getSystemService("media_session");
    }

    @Override // t1.f, t1.h, t1.e.a
    public boolean a(e.c cVar) {
        return super.a(cVar);
    }

    public static final class a extends h.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f50838d;

        public a(String str, int i10, int i11) {
            super(str, i10, i11);
            this.f50838d = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
        }

        public a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
            this.f50838d = remoteUserInfo;
        }
    }
}
