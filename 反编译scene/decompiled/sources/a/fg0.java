package a;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fg0 implements eg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gg0 f6102a;

    public fg0(gg0 gg0Var) {
        this.f6102a = gg0Var;
    }

    @Override // a.eg0
    public String a() {
        if (this.f6102a.f6204a.f1166a.getSuffix().length() > 0) {
            return this.f6102a.f6204a.f1166a.getSuffix();
        }
        return null;
    }

    @Override // a.eg0
    public int b() {
        String type = this.f6102a.f6204a.f1166a.getType();
        return (type != null && type.hashCode() == -1268966290 && type.equals("folder")) ? eg0.f5999a.b() : eg0.f5999a.a();
    }

    @Override // a.eg0
    public String c() {
        if (this.f6102a.f6204a.f1166a.getMime().length() > 0) {
            return this.f6102a.f6204a.f1166a.getMime();
        }
        return null;
    }

    @Override // a.eg0
    public void d(String str) {
        TextView textView;
        Context context;
        int i;
        if (!(str == null || str.length() == 0)) {
            TextView textView2 = this.f6102a.f1008a;
            f92.c(textView2, "textView");
            textView2.setText(str);
            this.f6102a.f1007a.setText(str);
            return;
        }
        if (b() == eg0.f5999a.b()) {
            textView = this.f6102a.f1008a;
            f92.c(textView, "textView");
            context = this.f6102a.f6204a.f1165a;
            i = ob0.kr_please_choose_folder;
        } else {
            textView = this.f6102a.f1008a;
            f92.c(textView, "textView");
            context = this.f6102a.f6204a.f1165a;
            i = ob0.kr_please_choose_file;
        }
        textView.setText(context.getString(i));
        this.f6102a.f1007a.setText("");
    }
}
