package a;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.omarea.krscript.model.TextNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ef0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf0 f5996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextNode.TextRow f726a;

    public ef0(hf0 hf0Var, TextNode.TextRow textRow) {
        this.f5996a = hf0Var;
        this.f726a = textRow;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        f92.d(view, "widget");
        new qb0(this.f5996a.b, this.f726a.getActivity$krscript_release_mini()).b();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f92.d(textPaint, "ds");
        textPaint.setColor(this.f726a.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f726a.getColor$krscript_release_mini());
        textPaint.setUnderlineText(this.f726a.getUnderline$krscript_release_mini());
    }
}
