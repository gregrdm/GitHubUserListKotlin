package gregrdm.githubuserlistkotlin.utils;

import rx.Scheduler;

/**
 *
 */

public class SchedulersImpl {

    private Scheduler observer, subscriber;

    public SchedulersImpl(Scheduler observer, Scheduler subscriber) {
        this.observer = observer;
        this.subscriber = subscriber;
    }

    public Scheduler getObserver() {
        return observer;
    }

    public Scheduler getSubscriber() {
        return subscriber;
    }
}
