package a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;
import com.omarea.krscript.model.TextNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class df0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf0 f5892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextNode.TextRow f551a;

    public df0(hf0 hf0Var, TextNode.TextRow textRow) {
        this.f5892a = hf0Var;
        this.f551a = textRow;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        f92.d(view, "widget");
        if (this.f551a.getLink$krscript_release_mini().length() > 0) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f551a.getLink$krscript_release_mini()));
                intent.addFlags(268435456);
                this.f5892a.b.startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(this.f5892a.b, this.f5892a.b.getString(ob0.kr_slice_activity_fail), 0).show();
            }
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        f92.d(textPaint, "ds");
        textPaint.setColor(this.f551a.getColor$krscript_release_mini() != 1 ? textPaint.linkColor : this.f551a.getColor$krscript_release_mini());
        textPaint.setUnderlineText(this.f551a.getUnderline$krscript_release_mini());
    }
}
