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

class FirstFragment:Fragment() {
    var tv_first: TextView? = null
    var listener: ListenerOne? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.first_fragment,container,false)
        initViews(view)
        return view
    }

    fun initViews(view:View){
        tv_first = view.findViewById(R.id.tv_firstFrag)
        val btn_first:Button = view.findViewById(R.id.btn_firstFrag)
        btn_first.setOnClickListener{listener!!.sendOne("Hello Two")}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is ListenerOne){
            context
        }else{
            throw RuntimeException("$context You must init listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    public fun updateFirstText(str: String) {
        tv_first!!.text = str
    }

    interface ListenerOne{
        fun sendOne(str:String);
    }
}