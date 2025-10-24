package com.example.responsi1mobile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobile.data.model.Player
import com.example.responsi1mobile.databinding.ItemPlayerBinding
import com.example.responsi1mobile.ui.fragment.PlayerDetailFragment
import com.example.responsi1mobile.utils.ColorUtils

class PlayerAdapter(private var list: List<Player>) : RecyclerView.Adapter<PlayerAdapter.VH>() {

    fun setData(newList: List<Player>) {
        list = newList
        notifyDataSetChanged()
    }

    inner class VH(val b: ItemPlayerBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = list[position]
        holder.b.tvName.text = p.name ?: "-"
        holder.b.tvPosition.text = p.position ?: "-"
        holder.b.tvNationality.text = p.nationality ?: "-"
        val color = ColorUtils.forPosition(p.position)
        holder.b.cardPlayer.setCardBackgroundColor(color)

        holder.b.root.setOnClickListener {
            val fm = (it.context as androidx.fragment.app.FragmentActivity).supportFragmentManager
            PlayerDetailFragment.newInstance(
                p.name ?: "-",
                p.dateOfBirth ?: "-",
                p.nationality ?: "-",
                p.position ?: "-"
            ).show(fm, PlayerDetailFragment::class.java.simpleName)
        }
    }

    override fun getItemCount(): Int = list.size
}