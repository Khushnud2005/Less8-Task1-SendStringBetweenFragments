package uz.exemple.less8_task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.exemple.less8_task1.fragments.FirstFragment
import uz.exemple.less8_task1.fragments.SecondFragment

class MainActivity : AppCompatActivity(),FirstFragment.ListenerOne,SecondFragment.ListenerTwo {
    private var firstFragment: FirstFragment? = null
    private var secondFragment: SecondFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }
    fun initViews(){
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.firstFrame,firstFragment!!)
            .replace(R.id.secondFrame,secondFragment!!)
            .commit()
    }

    override fun sendOne(str: String) {
        secondFragment!!.updateSecondText(str)
    }

    override fun sendTwo(str: String) {
        firstFragment!!.updateFirstText(str)
    }
}