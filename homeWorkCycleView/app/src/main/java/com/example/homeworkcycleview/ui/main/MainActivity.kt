package com.example.homeworkcycleview.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkcycleview.R
import com.example.homeworkcycleview.adapter.ItemAdapter
import com.example.homeworkcycleview.databinding.ActivityMainBinding
import com.example.homeworkcycleview.network.model.DataModel
import com.example.homeworkcycleview.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>(),MainNavigator {
    override fun tag(): String = MainActivity::class.java.simpleName
    private  val mainBinding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var mainViewModel: MainViewModel? = null
    private var listAdapter : ItemAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        mainViewModel?.setNavigator(this)

        if (savedInstanceState == null){
            setUpView()
            initial()
        }
    }


    override fun setUpView() {
        listAdapter = ItemAdapter(this@MainActivity)
        mainBinding.mainRecyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun initial() {
        getSimpleList()
    }


    override fun getSimpleList() {
        mainViewModel?.getSimpleList()
    }

    override fun getSimpleListSuccess(list: MutableList<DataModel>) {
        listAdapter?.submitList(list)
    }

    override fun getSimpleListFailed(exception: Exception) {

    }
}