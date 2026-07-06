package a;

import android.annotation.SuppressLint;
import android.opengl.GLSurfaceView;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"ViewConstructor"})
public class fk0 extends GLSurfaceView {
    public fk0(ViewGroup viewGroup, ck0 ck0Var) {
        super(viewGroup.getContext());
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        setRenderer(new bk0(new ek0(this, viewGroup, this, ck0Var)));
        viewGroup.addView(this);
    }
}
