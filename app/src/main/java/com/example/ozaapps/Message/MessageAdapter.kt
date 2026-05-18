package com.example.ozaapps.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ozaapps.R

class MessageAdapter(
    private val context: Context,
    private val list: List<MessageModel>
) : BaseAdapter() {

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_message, parent, false)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvMessage = view.findViewById<TextView>(R.id.tvMessage)

        val item = list[position]
        tvName.text = item.name
        tvMessage.text = item.message

        return view
    }
}