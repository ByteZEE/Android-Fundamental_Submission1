package com.dicoding.picodiploma.githubuserapps

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListUserAdapter (private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (username, name, location, repository, company, followers, following, avatar) = listUser[position]
        holder.tvUsername.text = username
        holder.tvName.text = name
        if (avatar != null) {
            holder.imgAvatar.setImageResource(avatar)
        }

        holder.itemView.setOnClickListener{
            val person = User (username, name, location, repository, company, followers, following, avatar)
            val moveIntent = Intent(holder.itemView.context, DetailUser::class.java)
            moveIntent.putExtra(DetailUser.EXTRA_USER, person)
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_avatar)
        var tvUsername: TextView = itemView.findViewById(R.id.id_username)
        var tvName: TextView = itemView.findViewById(R.id.full_name)
    }
}