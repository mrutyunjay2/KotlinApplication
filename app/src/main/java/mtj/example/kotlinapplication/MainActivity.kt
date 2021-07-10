package mtj.example.kotlinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import mtj.example.RXJavaConcept.RXActivity
import mtj.example.RXJavaConcept.RxSubjectActivity
import mtj.example.RXJavaConcept.skipFilterConatActivity
import mtj.example.dagger2.model.DaggerActivity

class MainActivity : AppCompatActivity() {

    lateinit var myObservable:Observable<String>
    lateinit var myObserver: Observer<String>
    lateinit var compositeDisposable: CompositeDisposable
    lateinit var myDisposableObserver:DisposableObserver<String>
    lateinit var myDisposableObserver2:DisposableObserver<String>

    lateinit var disposable:Disposable
    val msg:String = "Hello RxJava"
    val TAG:String = "RxJava"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       // service.log()
        dialog_create.setOnClickListener {
            val i = Intent(this, RxSubjectActivity::class.java)
            startActivity(i)
        }

        compositeDisposable = CompositeDisposable()
        myObservable = Observable.just(msg)
     /*  myObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                    Log.d(TAG,"onSubscribe..")
                d?.let { disposable =d  }
            }

            override fun onNext(t: String?) {
                Log.d(TAG,"onNext..")
                rxmessage.setText(t)
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onError..")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete..")
            }

        }*/

        myDisposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String?) {
                Log.d(TAG,"onNext..")
                rxmessage.setText(t)
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onError..")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete..")
            }

        }

       compositeDisposable.add(myObservable.subscribeOn(Schedulers.io())
                                           .observeOn(AndroidSchedulers.mainThread())
                                           .subscribeWith(myDisposableObserver))
        myDisposableObserver2= object : DisposableObserver<String>() {
            override fun onNext(t: String?) {
                Log.d(TAG,"onNext..")
                rxmessage.setText(t)
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onError..")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete..")
            }

        }
      /*  compositeDisposable.add(myDisposableObserver2);
       myObservable.subscribe(myDisposableObserver2);*/
        compositeDisposable.add(
            myObservable.subscribeWith(myDisposableObserver2)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy..")
       // disposable.dispose()
        compositeDisposable.clear()
    }

    fun getStudents():ArrayList<Student>{
        val arrylistStu:ArrayList<Student>

        arrylistStu = ArrayList<Student>()
        val s1: Student = Student("jay","jay@gmail.com",12)
        arrylistStu.add(s1)
        val s2: Student = Student("sam","sam@gmail.com",22)
        arrylistStu.add(s2)
        val s3: Student = Student("biki","biki@gmail.com",13)
        arrylistStu.add(s3)
        val s4: Student = Student("raj","raj@gmail.com",42)
        arrylistStu.add(s4)
        val s5:  Student = Student("anish", "anish@gmail.com",25)
        arrylistStu.add(s5)
        return arrylistStu
    }


}