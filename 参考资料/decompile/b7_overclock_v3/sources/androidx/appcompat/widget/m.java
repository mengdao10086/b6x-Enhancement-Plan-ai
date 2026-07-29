package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof i1) {
                    editorInfo.hintText = ((i1) parent).a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
