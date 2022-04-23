package com.groupsix.fitbuddy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.groupsix.fitbuddy.fragments.Post
import com.groupsix.fitbuddy.R

class PostAdapter(val context: Context, val posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        // Specify the layout file to use for this item

        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        // Set time difference
//        val formattedTime = TimeFormatter.getTimeDifference(post.getTime())

        holder.bind(post)

    }

    // Clean all elements of the recycler
    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(PostList: List<Post>) {
        posts.addAll(PostList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username: TextView
        val ivFileView: ImageView
        val tvDescription: TextView
        val tvTimeStamp: TextView

        init {
            username = itemView.findViewById(R.id.user_name)
            ivFileView = itemView.findViewById(R.id.ivFileView)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            tvTimeStamp = itemView.findViewById(R.id.tvTimeStamp)
        }

        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            username.text = post.getUser()?.username
            tvTimeStamp.text = post.getTime().toString()

            //Populate Image
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivFileView)
//            tvTimeStamp.text = TimeFormatter.getTimeDifference(Post.KEY_TIME)

        }
    }

}