package bu;

import java.util.Objects;
import java.util.concurrent.Flow;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: bu.a$a, reason: collision with other inner class name */
    public static final class FlowPublisherC0102a<T> implements Flow.Publisher<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.c<? extends T> f9648a;

        public FlowPublisherC0102a(bu.c<? extends T> cVar) {
            this.f9648a = cVar;
        }

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.f9648a.d(subscriber == null ? null : new g(subscriber));
        }
    }

    public static final class b<T, U> implements Flow.Processor<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.b<? super T, ? extends U> f9649a;

        public b(bu.b<? super T, ? extends U> bVar) {
            this.f9649a = bVar;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f9649a.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th2) {
            this.f9649a.onError(th2);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t10) {
            this.f9649a.onNext(t10);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.f9649a.onSubscribe(subscription == null ? null : new h(subscription));
        }

        @Override // java.util.concurrent.Flow.Publisher
        public void subscribe(Flow.Subscriber<? super U> subscriber) {
            this.f9649a.d(subscriber == null ? null : new g(subscriber));
        }
    }

    public static final class c<T> implements Flow.Subscriber<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f9650a;

        public c(bu.d<? super T> dVar) {
            this.f9650a = dVar;
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onComplete() {
            this.f9650a.onComplete();
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onError(Throwable th2) {
            this.f9650a.onError(th2);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onNext(T t10) {
            this.f9650a.onNext(t10);
        }

        @Override // java.util.concurrent.Flow.Subscriber
        public void onSubscribe(Flow.Subscription subscription) {
            this.f9650a.onSubscribe(subscription == null ? null : new h(subscription));
        }
    }

    public static final class d implements Flow.Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.e f9651a;

        public d(bu.e eVar) {
            this.f9651a = eVar;
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void cancel() {
            this.f9651a.cancel();
        }

        @Override // java.util.concurrent.Flow.Subscription
        public void request(long j10) {
            this.f9651a.request(j10);
        }
    }

    public static final class e<T> implements bu.c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Flow.Publisher<? extends T> f9652a;

        public e(Flow.Publisher<? extends T> publisher) {
            this.f9652a = publisher;
        }

        @Override // bu.c
        public void d(bu.d<? super T> dVar) {
            this.f9652a.subscribe(dVar == null ? null : new c(dVar));
        }
    }

    public static final class f<T, U> implements bu.b<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Flow.Processor<? super T, ? extends U> f9653a;

        public f(Flow.Processor<? super T, ? extends U> processor) {
            this.f9653a = processor;
        }

        @Override // bu.c
        public void d(bu.d<? super U> dVar) {
            this.f9653a.subscribe(dVar == null ? null : new c(dVar));
        }

        @Override // bu.d
        public void onComplete() {
            this.f9653a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f9653a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f9653a.onNext(t10);
        }

        @Override // bu.d
        public void onSubscribe(bu.e eVar) {
            this.f9653a.onSubscribe(eVar == null ? null : new d(eVar));
        }
    }

    public static final class g<T> implements bu.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Flow.Subscriber<? super T> f9654a;

        public g(Flow.Subscriber<? super T> subscriber) {
            this.f9654a = subscriber;
        }

        @Override // bu.d
        public void onComplete() {
            this.f9654a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f9654a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f9654a.onNext(t10);
        }

        @Override // bu.d
        public void onSubscribe(bu.e eVar) {
            this.f9654a.onSubscribe(eVar == null ? null : new d(eVar));
        }
    }

    public static final class h implements bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Flow.Subscription f9655a;

        public h(Flow.Subscription subscription) {
            this.f9655a = subscription;
        }

        @Override // bu.e
        public void cancel() {
            this.f9655a.cancel();
        }

        @Override // bu.e
        public void request(long j10) {
            this.f9655a.request(j10);
        }
    }

    public a() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flow.Processor<T, U> a(bu.b<? super T, ? extends U> bVar) {
        Objects.requireNonNull(bVar, "reactiveStreamsProcessor");
        return bVar instanceof f ? ((f) bVar).f9653a : bVar instanceof Flow.Processor ? (Flow.Processor) bVar : new b(bVar);
    }

    public static <T> Flow.Publisher<T> b(bu.c<? extends T> cVar) {
        Objects.requireNonNull(cVar, "reactiveStreamsPublisher");
        return cVar instanceof e ? ((e) cVar).f9652a : cVar instanceof Flow.Publisher ? (Flow.Publisher) cVar : new FlowPublisherC0102a(cVar);
    }

    public static <T> Flow.Subscriber<T> c(bu.d<T> dVar) {
        Objects.requireNonNull(dVar, "reactiveStreamsSubscriber");
        return dVar instanceof g ? ((g) dVar).f9654a : dVar instanceof Flow.Subscriber ? (Flow.Subscriber) dVar : new c(dVar);
    }

    public static <T, U> bu.b<T, U> d(Flow.Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "flowProcessor");
        return processor instanceof b ? ((b) processor).f9649a : processor instanceof bu.b ? (bu.b) processor : new f(processor);
    }

    public static <T> bu.c<T> e(Flow.Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "flowPublisher");
        return publisher instanceof FlowPublisherC0102a ? ((FlowPublisherC0102a) publisher).f9648a : publisher instanceof bu.c ? (bu.c) publisher : new e(publisher);
    }

    public static <T> bu.d<T> f(Flow.Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "flowSubscriber");
        return subscriber instanceof c ? ((c) subscriber).f9650a : subscriber instanceof bu.d ? (bu.d) subscriber : new g(subscriber);
    }
}
