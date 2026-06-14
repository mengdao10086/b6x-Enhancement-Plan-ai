package a;

import android.content.Context;
import android.widget.ImageView;
import com.omarea.krscript.model.PageNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class af0 extends ye0 {
    public final ImageView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af0(Context context, PageNode pageNode) {
        super(context, nb0.kr_action_list_item, pageNode);
        f92.d(context, "context");
        f92.d(pageNode, "config");
        ImageView imageView = (ImageView) c().findViewById(mb0.kr_widget);
        this.b = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.b;
        if (imageView2 != null) {
            imageView2.setImageDrawable(context.getDrawable(lb0.kr_arrow));
        }
    }
}
