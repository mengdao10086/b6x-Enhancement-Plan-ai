package zh;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public class f implements MediaScannerConnection.MediaScannerConnectionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaScannerConnection f58592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f58593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f58594c;

    public interface a {
        void h();
    }

    public f(Context context, String str, a aVar) {
        this.f58593b = str;
        this.f58594c = aVar;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, this);
        this.f58592a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.f58592a.scanFile(this.f58593b, null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f58592a.disconnect();
        a aVar = this.f58594c;
        if (aVar != null) {
            aVar.h();
        }
    }
}
