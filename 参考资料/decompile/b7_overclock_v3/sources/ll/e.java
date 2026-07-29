package ll;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class e extends TextView implements il.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39834b;

    public e(Context context) {
        super(context, null);
        e(context);
    }

    public void a(int i10, int i11) {
        setTextColor(this.f39834b);
    }

    public void b(int i10, int i11, float f10, boolean z10) {
    }

    public void c(int i10, int i11) {
        setTextColor(this.f39833a);
    }

    public void d(int i10, int i11, float f10, boolean z10) {
    }

    public final void e(Context context) {
        setGravity(17);
        int iA = fl.b.a(context, 10.0d);
        setPadding(iA, 0, iA, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // il.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // il.b
    public int getContentLeft() {
        String string;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            string = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // il.b
    public int getContentRight() {
        String string;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            string = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = getText().toString();
        }
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // il.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f39834b;
    }

    public int getSelectedColor() {
        return this.f39833a;
    }

    public void setNormalColor(int i10) {
        this.f39834b = i10;
    }

    public void setSelectedColor(int i10) {
        this.f39833a = i10;
    }
}
