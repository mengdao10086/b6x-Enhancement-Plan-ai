package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.omarea.krscript.model.ClickableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ye0 extends if0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public we0 f7974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xe0 f3683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f3684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ClickableNode f3685a;
    public View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye0(Context context, int i, ClickableNode clickableNode) {
        Drawable drawableB;
        super(context, i, clickableNode);
        f92.d(context, "context");
        f92.d(clickableNode, "config");
        this.f3685a = clickableNode;
        this.b = c().findViewById(mb0.kr_shortcut_icon);
        this.f3684a = (ImageView) c().findViewById(mb0.kr_icon);
        g(this.f3685a.getTitle());
        e(this.f3685a.getDesc());
        f(this.f3685a.getSummary());
        c().setOnClickListener(new ue0(this));
        if ((b().length() > 0) && (!f92.a(this.f3685a.getAllowShortcut(), Boolean.FALSE))) {
            c().setOnLongClickListener(new ve0(this));
            View view = this.b;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.b;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        ImageView imageView = this.f3684a;
        if (imageView != null) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (!(this.f3685a.getIconPath().length() > 0) || (drawableB = new jc0().b(context, this.f3685a)) == null) {
                return;
            }
            ImageView imageView2 = this.f3684a;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawableB);
            }
            ImageView imageView3 = this.f3684a;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
        }
    }

    public final we0 i() {
        return this.f7974a;
    }

    public final xe0 j() {
        return this.f3683a;
    }

    public final ye0 k(we0 we0Var) {
        f92.d(we0Var, "onClickListener");
        this.f7974a = we0Var;
        return this;
    }

    public final ye0 l(xe0 xe0Var) {
        f92.d(xe0Var, "onLongClickListener");
        this.f3683a = xe0Var;
        return this;
    }

    public final void m() {
        we0 we0Var = this.f7974a;
        if (we0Var != null) {
            we0Var.a(this);
        }
    }
}
