package a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class li extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ni f1803a;
    public final int b;

    public li(int i, ni niVar, int i2) {
        this.f6709a = i;
        this.f1803a = niVar;
        this.b = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f6709a);
        this.f1803a.Q(this.b, bundle);
    }
}
