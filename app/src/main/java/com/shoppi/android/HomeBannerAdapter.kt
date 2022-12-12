package com.shoppi.android

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.android.dataclass.Banner
import org.w3c.dom.Text

// ListAdapter : 데이터를 리스트형태로 받아서 0번째부터 순차적으로 뷰홀더와 바인딩을 시켜주는 연결고리 역할
//               레이아웃은 그대로 유지한채로, 데이터만 업데이트시켜주는 역할
// ListAdatper를 상속받아서 구현해주기 위해서는 인자로서 AsyncDifferConfig 또는 DiffUtil을 인자로 받아줘야한다.
// DiffUtil -> 스크롤이 변경됨에 따라 실제로 데이터가 변경되는지 확인하고, 변경 되었음이 확인된다면, 데이터를 업데이트하여 보여준다.
class HomeBannerAdapter : ListAdapter<Banner, HomeBannerAdapter.HomeBannerViewHolder>(BannerDiffCallback()) {

    class HomeBannerViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val bannerImageView = view.findViewById<ImageView>(R.id.home_banner_image)
        private val bannerBadgeText = view.findViewById<TextView>(R.id.home_banner_badge)
        private val bannerTitleText = view.findViewById<TextView>(R.id.home_banner_title)
        private val detailThumbnailImage = view.findViewById<ImageView>(R.id.home_banner_detail_thumbnail)
        private val detailBrandLabelText = view.findViewById<TextView>(R.id.home_banner_detail_brand_label)
        private val detailProductLabelText = view.findViewById<TextView>(R.id.home_banner_detail_product_label)
        private val detailProductDiscountRateText = view.findViewById<TextView>(R.id.home_banner_detail_product_discount_rate)
        private val detailProductDiscountPriceText = view.findViewById<TextView>(R.id.home_banner_detail_product_discount_price)
        private val detailProductPriceText = view.findViewById<TextView>(R.id.home_banner_detail_product_price)


        fun bind(banner : Banner) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        //HomeBannerViewHolder를 만들어주는 정의 함수
        // return에 view를 담아 전달해야하고, 전달해주기 위한 메소드는 LayoutInflater를 사용
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_banner, parent, false)
        return HomeBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        // onCreateViewHolder에서 만들었다면, 여기에서는 만든 ViewHolder 안에 담길 데이터를 바인딩해주는 함수
        holder.bind(getItem(position))
    }
}

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {
    // areItems 두 객체의 값이 동등한지 우선 판단하여 나타내줌. 만약 동일하다면,
    // 이어서 areContents 메소드가 호출되어 나머지 property값도 비교함
    // 만약 비교하는 과정에서 일부의 객체가 서로 다른값을 가지고 있음이 확인된다면, 기존 UI를 newItem의 property값으로 업데이트된 UI로 바꿔서 나타내줌
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        // 식별자들의 oldItem과 newItem의 비교연산자를 통해 return
        return oldItem.productDetail.productId == newItem.productDetail.productId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        // 위의 productId의 단편적인 것만 비교했다면, 여기에선 그 외 다른 property의 값도 동등한지 비교하여 return
        return oldItem == newItem
    }

}