package uz.exemple.less8_task1.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import uz.exemple.less8_task1.R
import java.lang.RuntimeException

class SecondFragment:Fragment() {
    var tv_second:TextView? = null
    var listener:ListenerTwo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment,container,false)
        initViews(view)
        return view
    }

    fun initViews(view:View){
        tv_second = view.findViewById(R.id.tv_second_frag)
        val btn_second:Button = view.findViewById(R.id.btn_second_frag)
        btn_second.setOnClickListener{listener!!.sendTwo("Hello One")}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is ListenerTwo){
            context
        }else{
            throw RuntimeException("$context You must init listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    public fun updateSecondText(str: String) {
        tv_second!!.text = str
    }
    interface ListenerTwo{
        fun sendTwo(str:String);
    }

}