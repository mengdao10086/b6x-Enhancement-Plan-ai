package a;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y6 extends x6 {
    @Override // a.x6, a.z6
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // a.z6
    public boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
