package com.noweshed.cointracker.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.util.Constants.BILLION
import com.noweshed.cointracker.data.util.Utils.formatPrice
import com.noweshed.cointracker.databinding.CoinListviewBinding
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Created by noweshedakram on 22/12/22.
 */
class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(private val binding: CoinListviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(coin: Coin) {
            binding.rank.text = coin.rank.toString()
            binding.coinName.text = coin.symbol
            binding.marketCap.text = (coin.quotes?.USD?.marketCap?.div(BILLION))?.toDouble().toString()
            binding.price.text = formatPrice(coin.quotes?.USD?.price)
            binding.percent.text = coin.quotes?.USD?.percentChange6h.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding =
            CoinListviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coins = differ.currentList[position]
        holder.bindData(coins)
    }

    override fun getItemCount() = differ.currentList.size

    private val callback = object : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Coin,
            newItem: Coin
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)
}