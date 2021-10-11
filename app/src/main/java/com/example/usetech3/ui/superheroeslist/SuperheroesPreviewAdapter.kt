package com.example.usetech3.ui.superheroeslist

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.usetech3.R
import com.example.usetech3.data.entity.Result
import com.example.usetech3.databinding.ItemSuperheroBinding


class SuperheroesPreviewAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<SuperheroesPreviewAdapter.ViewHolder>() {

    var data = listOf<Result>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder private constructor(
        private val binding: ItemSuperheroBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        var id = 0
        lateinit var clMain: ConstraintLayout
        @SuppressLint("SetTextI18n")
        fun bind(
            item: Result,
            onClickListener: OnClickListener
        ) {
            clMain = binding.clMainLayout
            id = item.id.toInt()
            binding.tvCardName.text = item.name
            binding.tvCardPublisher.text = "by ${item.biography.publisher}"
            Glide.with(binding.ivCardImage.context)
                .load(item.image.url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .into(binding.ivCardImage)
            binding.clMainLayout.setOnClickListener {
                onClickListener.onClick(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemSuperheroBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return ViewHolder(binding)
            }
        }
    }


    class OnClickListener(val clickListener: (item: Result) -> Unit) {
        fun onClick(item: Result) = clickListener(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!data.isNullOrEmpty()) {
            val item = data[position]
            holder.bind(item, onClickListener)
        }

    }

    override fun getItemCount() = data.size
}