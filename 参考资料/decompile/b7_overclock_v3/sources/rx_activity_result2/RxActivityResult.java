package rx_activity_result2;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import dj.g;
import g.p0;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class RxActivityResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f49218a;

    public static class Builder<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f49219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PublishSubject<f<T>> f49220b = PublishSubject.o8();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f49221c;

        public class a implements g<Activity> {
            public a() {
            }

            @Override // dj.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Activity activity) throws Exception {
                activity.startActivity(new Intent(activity, (Class<?>) HolderActivity.class).addFlags(65536));
            }
        }

        public Builder(T t10) {
            if (RxActivityResult.f49218a == null) {
                throw new IllegalStateException(b.f49232a);
            }
            this.f49219a = t10.getClass();
            this.f49221c = t10 instanceof Activity;
        }

        @p0
        public Fragment a(List<Fragment> list) {
            Fragment fragmentA;
            if (list == null) {
                return null;
            }
            for (Fragment fragment : list) {
                if (fragment != null && fragment.C3() && fragment.getClass() == this.f49219a) {
                    return fragment;
                }
                if (fragment != null && fragment.s3() && fragment.U1() != null && (fragmentA = a(fragment.U1().I0())) != null) {
                    return fragmentA;
                }
            }
            return null;
        }

        public final OnResult b() {
            return new OnResult() { // from class: rx_activity_result2.RxActivityResult.Builder.2
                @Override // rx_activity_result2.OnResult
                public void e(Throwable th2) {
                    Builder.this.f49220b.onError(th2);
                }

                @Override // rx_activity_result2.OnResult
                public void j(int i10, int i11, Intent intent) {
                    if (RxActivityResult.f49218a.a() != null && RxActivityResult.f49218a.a().getClass() == Builder.this.f49219a) {
                        Builder.this.f49220b.onNext(new f<>(RxActivityResult.f49218a.a(), i10, i11, intent));
                        Builder.this.f49220b.onComplete();
                    }
                }
            };
        }

        public final OnResult c() {
            return new OnResult() { // from class: rx_activity_result2.RxActivityResult.Builder.3
                @Override // rx_activity_result2.OnResult
                public void e(Throwable th2) {
                    Builder.this.f49220b.onError(th2);
                }

                @Override // rx_activity_result2.OnResult
                public void j(int i10, int i11, Intent intent) {
                    if (RxActivityResult.f49218a.a() == null) {
                        return;
                    }
                    Fragment fragmentA = Builder.this.a(((androidx.fragment.app.g) RxActivityResult.f49218a.a()).n3().I0());
                    if (fragmentA != null) {
                        Builder.this.f49220b.onNext(new f<>(fragmentA, i10, i11, intent));
                        Builder.this.f49220b.onComplete();
                    }
                }
            };
        }

        public final z<f<T>> d(d dVar, @p0 c cVar) {
            dVar.e(this.f49221c ? b() : c());
            dVar.d(cVar);
            HolderActivity.a(dVar);
            RxActivityResult.f49218a.b().E5(new a());
            return this.f49220b;
        }

        public z<f<T>> e(Intent intent) {
            return f(intent, null);
        }

        public z<f<T>> f(Intent intent, @p0 c cVar) {
            return d(new d(intent), cVar);
        }

        public z<f<T>> g(IntentSender intentSender, @p0 Intent intent, int i10, int i11, int i12) {
            return h(intentSender, intent, i10, i11, i12, null);
        }

        public z<f<T>> h(IntentSender intentSender, @p0 Intent intent, int i10, int i11, int i12, @p0 Bundle bundle) {
            return d(new e(intentSender, intent, i10, i11, i12, bundle), null);
        }
    }

    public static <T extends Activity> Builder<T> a(T t10) {
        return new Builder<>(t10);
    }

    public static <T extends Fragment> Builder<T> b(T t10) {
        return new Builder<>(t10);
    }

    public static void c(Application application) {
        f49218a = new a(application);
    }
}
