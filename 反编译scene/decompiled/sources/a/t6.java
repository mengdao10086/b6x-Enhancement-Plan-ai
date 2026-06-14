package a;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextClassifier f7470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2970a;

    public t6(TextView textView) {
        pf.b(textView);
        this.f2970a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f7470a;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f2970a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f7470a = textClassifier;
    }
}
