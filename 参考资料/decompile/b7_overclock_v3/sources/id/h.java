package id;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class h extends GLSurfaceView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f32228a;

    public h(Context context) {
        this(context, null);
    }

    public k getVideoDecoderOutputBufferRenderer() {
        return this.f32228a;
    }

    public h(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        g gVar = new g(this);
        this.f32228a = gVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(gVar);
        setRenderMode(0);
    }
}
