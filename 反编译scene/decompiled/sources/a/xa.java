package a;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xa extends SharedElementCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wb f7868a;

    public xa(wb wbVar) {
        this.f7868a = wbVar;
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.f7868a.a(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.f7868a.b(context, parcelable);
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List<String> list, Map<String, View> map) {
        this.f7868a.c(list, map);
    }

    @Override // android.app.SharedElementCallback
    public void onRejectSharedElements(List<View> list) {
        this.f7868a.d(list);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        this.f7868a.e(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        this.f7868a.f(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f7868a.g(list, list2, new wa(this, onSharedElementsReadyListener));
    }
}
