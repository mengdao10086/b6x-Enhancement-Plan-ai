package a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f6673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f1753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1755a;
    public TextView b;

    public l41(p41 p41Var) {
    }

    public final View a() {
        View view = this.f6673a;
        if (view != null) {
            return view;
        }
        f92.m("currentView");
        throw null;
    }

    public final CharSequence b() {
        return this.f1755a;
    }

    public final ImageView c() {
        return this.f1753a;
    }

    public final TextView d() {
        return this.b;
    }

    public final TextView e() {
        return this.f1754a;
    }

    public final void f(View view) {
        f92.d(view, "<set-?>");
        this.f6673a = view;
    }

    public final void g(CharSequence charSequence) {
        this.f1755a = charSequence;
    }

    public final void h(ImageView imageView) {
        this.f1753a = imageView;
    }

    public final void i(TextView textView) {
        this.b = textView;
    }

    public final void j(TextView textView) {
        this.f1754a = textView;
    }
}
