package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.a;

/* JADX INFO: loaded from: classes2.dex */
public class m implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.e f1668a;

    public m(a.e eVar) {
        this.f1668a = eVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        a.e eVar = this.f1668a;
        if (eVar != null) {
            eVar.a(i10, j10);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
