package a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xb implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<Intent> f3566a = new ArrayList<>();

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public xb(Context context) {
        this.f7872a = context;
    }

    public static xb d(Context context) {
        return new xb(context);
    }

    public xb a(Intent intent) {
        this.f3566a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xb b(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = hb.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f7872a.getPackageManager());
            }
            c(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public xb c(ComponentName componentName) {
        int size = this.f3566a.size();
        try {
            Context context = this.f7872a;
            while (true) {
                Intent intentB = hb.b(context, componentName);
                if (intentB == null) {
                    return this;
                }
                this.f3566a.add(size, intentB);
                context = this.f7872a;
                componentName = intentB.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f3566a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f3566a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (yb.g(this.f7872a, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f7872a.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f3566a.iterator();
    }
}
