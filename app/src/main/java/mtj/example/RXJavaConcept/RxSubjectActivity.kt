package mtj.example.RXJavaConcept


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import mtj.example.kotlinapplication.R

class RxSubjectActivity : AppCompatActivity() {

        val TAG:String = "RxSubjectActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_subject)
       // asyncSubject1()
       // BehaviourSubject()
       // behaviourSubject1()
       // publishSubject()
        //publishSubject1()
        replaySubject()
    }

    /*fun asyncSubject(){
        val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val asyncSubject = AsyncSubject.create<String>().apply {
            subscribe(getObserver1())
            subscribe(getObserver2())
            subscribe(getObserver3())
        }
        observable.subscribe(asyncSubject)
    }*/

    fun BehaviourSubject(){
        val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val behaviourSubject = BehaviorSubject.create<String>().apply {
            subscribe(getObserver1())
            subscribe(getObserver2())
            subscribe(getObserver3())

        }
        observable.subscribe(behaviourSubject)
    }

    fun publishSubject(){
        val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val publishSubject = PublishSubject.create<String>().apply {
            subscribe(getObserver1())
            subscribe(getObserver2())
            subscribe(getObserver3())

        }
        observable.subscribe(publishSubject)
    }

    fun replaySubject(){
        val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        val replaySubject = ReplaySubject.create<String>().apply {
            subscribe(getObserver1())
            subscribe(getObserver2())
            subscribe(getObserver3())

        }
        observable.subscribe(replaySubject)
    }

    fun asyncSubject1(){
       /* val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())*/
        val asyncSubject = AsyncSubject.create<String>()
        asyncSubject.subscribe(getObserver1())
        asyncSubject.onNext("Mrutyunjay")
        asyncSubject.onNext("jay")
        asyncSubject.subscribe(getObserver2())
        asyncSubject.onNext("sam")
        asyncSubject.onComplete()
        asyncSubject.subscribe(getObserver3())
    }

    fun behaviourSubject1(){
        /* val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
         observable.subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())*/
        val behaviorSubject = BehaviorSubject.create<String>()
        behaviorSubject.subscribe(getObserver1())
        behaviorSubject.onNext("Mrutyunjay")
        behaviorSubject.onNext("jay")
        behaviorSubject.subscribe(getObserver2())
        behaviorSubject.onNext("sam")
        behaviorSubject.onComplete()
        behaviorSubject.subscribe(getObserver3())
    }

    fun publishSubject1(){
        /* val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
         observable.subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())*/
        val publishSubject = PublishSubject.create<String>()
        publishSubject.subscribe(getObserver1())
        publishSubject.onNext("Mrutyunjay")
        publishSubject.onNext("jay")
        publishSubject.subscribe(getObserver2())
        publishSubject.onNext("sam")
        publishSubject.onComplete()
        publishSubject.subscribe(getObserver3())
    }

    fun replaySubject1(){
        /* val observable = Observable.just("Mrutyunjay","jay","sam","ram","raj")
         observable.subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())*/
        val replaySubject = ReplaySubject.create<String>()
        replaySubject.subscribe(getObserver1())
        replaySubject.onNext("Mrutyunjay")
        replaySubject.onNext("jay")
        replaySubject.subscribe(getObserver2())
        replaySubject.onNext("sam")
        replaySubject.onComplete()
        replaySubject.subscribe(getObserver3())
    }



    fun getObserver1():DisposableObserver<String>{
        val disposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String?) {
                Log.d(TAG, " onNext $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, " onError ")
            }

            override fun onComplete() {
                Log.d(TAG, " onComplete ")
            }

        }
        return disposableObserver
    }
    fun getObserver2():DisposableObserver<String>{
        val disposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String?) {
                Log.d(TAG, "Observer2 onNext $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "Observer2 onError ")
            }

            override fun onComplete() {
                Log.d(TAG, "Observer2 onComplete ")
            }

        }
        return disposableObserver
    }
    fun getObserver3():DisposableObserver<String>{
        val disposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String?) {
                Log.d(TAG, "Observer3 onNext $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG, "Observer3 onError ")
            }

            override fun onComplete() {
                Log.d(TAG, "Observer3 onComplete ")
            }

        }
        return disposableObserver
    }


}