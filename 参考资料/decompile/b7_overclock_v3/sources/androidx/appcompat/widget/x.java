package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public TextView f2730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public TextClassifier f2731b;

    @g.v0(26)
    public static final class a {
        @g.u
        @g.n0
        public static TextClassifier a(@g.n0 TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    public x(@g.n0 TextView textView) {
        this.f2730a = (TextView) androidx.core.util.o.l(textView);
    }

    @g.n0
    @g.v0(api = 26)
    public TextClassifier a() {
        TextClassifier textClassifier = this.f2731b;
        return textClassifier == null ? a.a(this.f2730a) : textClassifier;
    }

    @g.v0(api = 26)
    public void b(@g.p0 TextClassifier textClassifier) {
        this.f2731b = textClassifier;
    }
}
