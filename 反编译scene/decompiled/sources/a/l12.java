package a;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l12 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f6665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u12 f1718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f1719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1720a;

    public l12(u12 u12Var, l92 l92Var, ListView listView, TextView textView) {
        this.f1718a = u12Var;
        this.f6665a = l92Var;
        this.f1719a = listView;
        this.f1720a = textView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        int i;
        l92 l92Var = this.f6665a;
        l92Var.f6687a = l92Var.f6687a == 32 ? 1 : 32;
        this.f1719a.setScrollY(0);
        ListAdapter adapter = this.f1719a.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterProcessMini");
        }
        ((f21) adapter).m(this.f6665a.f6687a);
        TextView textView = this.f1720a;
        if (this.f6665a.f6687a == 32) {
            context = this.f1718a.f3113a;
            i = u61.process_app;
        } else {
            context = this.f1718a.f3113a;
            i = u61.process_all;
        }
        textView.setText(context.getString(i));
    }
}
