package mtj.example.RXJavaConcept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Predicate
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import mtj.example.kotlinapplication.R
import mtj.example.kotlinapplication.Student

class skipFilterConatActivity : AppCompatActivity() {
    val TAG:String = "RxJava"
    lateinit var dispossableObserver: DisposableObserver<Int>
   // lateinit var dispossableObserver: DisposableObserver<List<Int>>

    lateinit var compositeDisposable: CompositeDisposable
    lateinit var myObservable:Observable<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skip_filter_conat)
        /*myObservable = Observable.range(1,20)*/
        myObservable = Observable.just(1, 2, 3, 4, 5, 6,2,4,10,1)
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /*.map {student ->
                    return@map student.apply {
                        this.name = name.uppercase()
                        this.email = email.removeSuffix(".com")
                    }*/
               /* .filter(Predicate {
                    return@Predicate it%2==0
                })*/
               // .buffer(4)
                .distinct()
                .subscribeWith(getObserver())
        )
    }


    /*fun getObservable():Observable<Student>{

        return Observable.create {  var studentList:ArrayList<Student> = getStudents()
            for(s in studentList)
            {
                it.onNext(s)
            }
            it.onComplete() }
    }*/

   fun getObserver():DisposableObserver<Int>
    {
        dispossableObserver = object : DisposableObserver<Int>() {
            override fun onNext(t: Int?) {
                Log.d(TAG,"onNext..$t" )
            }

            override fun onError(e: Throwable?) {
                Log.d(TAG,"onComplete" )
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete" )
            }

        }

        return dispossableObserver
    }

    /*fun getObserver():DisposableObserver<List<Int>>{

      dispossableObserver = object : DisposableObserver<List<Int>>() {
           override fun onNext(t: List<Int>?) {
               Log.d(TAG,"onNext.." )
               if (t != null) {
                   for ( i in t){
                       Log.d(TAG,"int value is $i" )
                   }
               }

           }

           override fun onError(e: Throwable?) {

           }

           override fun onComplete() {

           }

       }
        return dispossableObserver
    } */



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