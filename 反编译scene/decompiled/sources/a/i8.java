package a;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f6383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f1336a;
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final TextView f1337b;
    public final ImageView c;

    public i8(View view) {
        this.f1336a = (TextView) view.findViewById(R.id.text1);
        this.f1337b = (TextView) view.findViewById(R.id.text2);
        this.f6383a = (ImageView) view.findViewById(R.id.icon1);
        this.b = (ImageView) view.findViewById(R.id.icon2);
        this.c = (ImageView) view.findViewById(y.edit_query);
    }
}
