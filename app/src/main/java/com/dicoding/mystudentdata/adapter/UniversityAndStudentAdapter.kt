package com.dicoding.mystudentdata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mystudentdata.database.UniversityAndStudent
import com.dicoding.mystudentdata.databinding.ItemStudentBinding

class UniversityAndStudentAdapter :
    ListAdapter<UniversityAndStudent, UniversityAndStudentAdapter.WordViewHolder>
        (WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WordViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UniversityAndStudent) {
            binding.tvItemName.text = data.university.name
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<UniversityAndStudent>() {
        override fun areItemsTheSame(oldItem: UniversityAndStudent, newItem: UniversityAndStudent): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UniversityAndStudent, newItem: UniversityAndStudent): Boolean {
            return oldItem.university.name == newItem.university.name
        }
    }
}