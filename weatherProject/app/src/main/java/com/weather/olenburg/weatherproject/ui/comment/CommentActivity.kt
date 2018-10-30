package com.weather.olenburg.weatherproject.ui.comment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.weather.olenburg.weatherproject.R
import com.weather.olenburg.weatherproject.model.Comment
import com.weather.olenburg.weatherproject.model.Posts
import kotlinx.android.synthetic.main.activity_comment.*

class CommentActivity : AppCompatActivity(), CommentContract.View {
    override fun onSuccess(data: ArrayList<Comment>) {
        adapter.setCommentData(data)
    }

    override fun onError(m: String) {

    }

    private lateinit var presenter: CommentPresenter
    private lateinit var adapter: CommentAdapter
    private var commentId: Int? = null
    private lateinit var postData: Posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        init()
    }

    private fun init() {
        postData = intent.getParcelableExtra(getString(R.string.comment_data))
        commentId = postData.id
        adapter = CommentAdapter()
        presenter = CommentPresenter(this)
        presenter.getComment(commentId!!)
        recview.adapter = adapter
        initViews()
    }

    private fun initViews() {
        body.text = postData.body
        name.text = postData.title

        //bishkek  1528334
    }
}
