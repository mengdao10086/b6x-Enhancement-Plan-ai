package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* JADX INFO: loaded from: classes2.dex */
public class JZTextureView extends TextureView {
    public static final String TAG = "JZResizeTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;

    public JZTextureView(Context context) {
        super(context);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x012a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jzvd.JZTextureView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        if (f10 != getRotation()) {
            super.setRotation(f10);
            requestLayout();
        }
    }

    public void setVideoSize(int i10, int i11) {
        if (this.currentVideoWidth == i10 && this.currentVideoHeight == i11) {
            return;
        }
        this.currentVideoWidth = i10;
        this.currentVideoHeight = i11;
        requestLayout();
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
