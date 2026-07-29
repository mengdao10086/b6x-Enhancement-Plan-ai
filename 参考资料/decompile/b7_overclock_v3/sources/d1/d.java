package d1;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int[] f25943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int[] f25944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f25945q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f25946r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f25947s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String[] f25948t;

    public interface a {
        CharSequence a(Cursor cursor);
    }

    public interface b {
        boolean a(View view, Cursor cursor, int i10);
    }

    @Deprecated
    public d(Context context, int i10, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i10, cursor);
        this.f25945q = -1;
        this.f25944p = iArr;
        this.f25948t = strArr;
        q(cursor, strArr);
    }

    @Override // d1.a, d1.b.a
    public CharSequence a(Cursor cursor) {
        a aVar = this.f25946r;
        if (aVar != null) {
            return aVar.a(cursor);
        }
        int i10 = this.f25945q;
        return i10 > -1 ? cursor.getString(i10) : super.a(cursor);
    }

    @Override // d1.a
    public void e(View view, Context context, Cursor cursor) {
        b bVar = this.f25947s;
        int[] iArr = this.f25944p;
        int length = iArr.length;
        int[] iArr2 = this.f25943o;
        for (int i10 = 0; i10 < length; i10++) {
            View viewFindViewById = view.findViewById(iArr[i10]);
            if (viewFindViewById != null) {
                if (bVar != null ? bVar.a(viewFindViewById, cursor, iArr2[i10]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i10]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        y((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        x((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    @Override // d1.a
    public Cursor m(Cursor cursor) {
        q(cursor, this.f25948t);
        return super.m(cursor);
    }

    public void p(Cursor cursor, String[] strArr, int[] iArr) {
        this.f25948t = strArr;
        this.f25944p = iArr;
        q(cursor, strArr);
        super.b(cursor);
    }

    public final void q(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.f25943o = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.f25943o;
        if (iArr == null || iArr.length != length) {
            this.f25943o = new int[length];
        }
        for (int i10 = 0; i10 < length; i10++) {
            this.f25943o[i10] = cursor.getColumnIndexOrThrow(strArr[i10]);
        }
    }

    public a r() {
        return this.f25946r;
    }

    public int s() {
        return this.f25945q;
    }

    public b t() {
        return this.f25947s;
    }

    public void u(a aVar) {
        this.f25946r = aVar;
    }

    public void v(int i10) {
        this.f25945q = i10;
    }

    public void w(b bVar) {
        this.f25947s = bVar;
    }

    public void x(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void y(TextView textView, String str) {
        textView.setText(str);
    }

    public d(Context context, int i10, Cursor cursor, String[] strArr, int[] iArr, int i11) {
        super(context, i10, cursor, i11);
        this.f25945q = -1;
        this.f25944p = iArr;
        this.f25948t = strArr;
        q(cursor, strArr);
    }
}
