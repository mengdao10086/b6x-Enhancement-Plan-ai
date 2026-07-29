package z6;

import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f57770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SeekBar f57771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f57772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f57773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f57774f;

    public Button a() {
        return this.f57773e;
    }

    public Button b() {
        return this.f57774f;
    }

    public int c() {
        return this.f57769a;
    }

    public Boolean d() {
        return this.f57770b;
    }

    public SeekBar e() {
        return this.f57771c;
    }

    public TextView f() {
        return this.f57772d;
    }

    public void g(Button button) {
        this.f57773e = button;
    }

    public void h(Button button) {
        this.f57774f = button;
    }

    public void i(int i10) {
        this.f57769a = i10;
        this.f57771c.setId(i10);
        this.f57773e.setId(i10);
        this.f57774f.setId(i10);
    }

    public void j(Boolean bool) {
        this.f57770b = bool;
        this.f57771c.setTag(bool);
        this.f57773e.setTag(bool);
        this.f57774f.setTag(bool);
    }

    public void k(SeekBar seekBar) {
        this.f57771c = seekBar;
    }

    public void l(TextView textView) {
        this.f57772d = textView;
    }
}
