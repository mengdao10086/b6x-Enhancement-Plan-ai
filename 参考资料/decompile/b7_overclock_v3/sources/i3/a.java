package i3;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class a extends CountDownLatch {
    public a(int i10) {
        super(i10);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
