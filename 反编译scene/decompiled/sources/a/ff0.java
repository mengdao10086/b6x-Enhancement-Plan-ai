package a;

import a.p80;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.omarea.krscript.model.TextNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ff0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf0 f6100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextNode.TextRow f895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextNode f896a;

    public ff0(hf0 hf0Var, TextNode.TextRow textRow, TextNode textNode) {
        this.f6100a = hf0Var;
        this.f895a = textRow;
        this.f896a = textNode;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        f92.d(view, "widget");
        String strC = yc0.c(this.f6100a.b, this.f895a.getOnClickScript$krscript_release_mini(), this.f896a);
        f92.c(strC, "result");
        if (strC == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (ec2.r0(strC).toString().length() > 0) {
            p80.a aVar = p80.f2403a;
            Context context = this.f6100a.b;
            String string = this.f6100a.b.getString(ob0.kr_slice_script_result);
            f92.c(string, "context.getString(R.string.kr_slice_script_result)");
            p80.a.B(aVar, context, string, strC, null, 8, null);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f92.d(textPaint, "ds");
        textPaint.setColor(this.f895a.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f895a.getColor$krscript_release_mini());
        textPaint.setUnderlineText(this.f895a.getUnderline$krscript_release_mini());
    }
}
