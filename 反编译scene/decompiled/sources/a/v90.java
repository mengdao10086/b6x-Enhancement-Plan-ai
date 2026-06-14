package a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v90 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v72 f7670a;

    public v90(v72 v72Var) {
        this.f7670a = v72Var;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        f92.d(view, "widget");
        this.f7670a.i();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f92.d(textPaint, "ds");
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(true);
    }
}
