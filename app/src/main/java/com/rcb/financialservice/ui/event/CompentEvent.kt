package decoration.scsowing.com.decoration.ui.event

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.rcb.financialservice.R
import com.rcb.financialservice.widget.transformation.CircleTransformation
import com.rcb.financialservice.widget.transformation.RoundCornerTransformation
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import decoration.scsowing.com.decoration.utils.DensyUtils
import decoration.scsowing.com.decoration.utils.LogUtils

class CompentEvent {

    companion object {
        val TAG = this.javaClass.simpleName
        @BindingAdapter("image_url")
        @JvmStatic
        fun image_url(imageView: ImageView, url: String) {
            LogUtils.e(TAG,  "conpentEvent  loadimage imageUrl "+ url);
            Picasso.with(imageView.context)
                    .load(url)
                    .error(R.drawable.bg_orange_radius)
                    .placeholder(R.drawable.bg_orange_radius)
                    .into(imageView)
        }
        // app:img_reference="@{R.drawable.icon_next}"
        @BindingAdapter("img_reference")
        @JvmStatic
        fun img_reference(imageView: ImageView, resId: Int) {
            LogUtils.e(TAG, "conpentEvent img_reference " + resId);
            Picasso.with(imageView.context)
                .load(resId)
                .error(R.drawable.bg_orange_radius)
                .placeholder(R.drawable.bg_orange_radius)
                .into(imageView)
        }

        @BindingAdapter("circle_img_url)")
        @JvmStatic
        fun circle_img_url(imageView: ImageView, url: String) {
            LogUtils.e(TAG,   "conpentEvent circle_img_url "+url);
            Picasso.with(imageView.context)
                    .load(url)
                    .error(R.drawable.bg_orange_radius)
                    .transform(CircleTransformation())
                    .into(imageView)
        }

        @BindingAdapter("circle_img_reference")
        @JvmStatic
        fun circle_img_reference(imageView: ImageView, resId: Int) {
            LogUtils.e(TAG, "conpentEvent circle_img_reference " + resId);
            Picasso.with(imageView.context)
                    .load(resId)
                    .error(R.drawable.bg_orange_radius)
                    .transform(CircleTransformation())
                    .into(imageView)

        }

        @BindingAdapter("round_corner_img_url", "round_radius")
        @JvmStatic
        fun round_corner_img_url(imageView: ImageView, url: String, radius: Float) {
            Picasso.with(imageView.context)
                .load(url)
                .error(R.drawable.bg_orange_radius)
                .transform(RoundCornerTransformation(DensyUtils.dp2px(imageView.context, radius), 0))
                .placeholder(R.drawable.bg_orange_radius)
                .into(imageView)

        }

        @BindingAdapter("round_top_corner_img_url", "round_radius")
        @JvmStatic
        fun round_top_corner_img_url(imageView: ImageView, url: String, radius: Float) {
            LogUtils.e(TAG, "round_corner_img_url radius " + radius + " px value " + DensyUtils.dp2px(imageView.context, radius)+" url "+ url)
            Picasso.with(imageView.context)
                    .load(url)
                    .error(R.drawable.bg_orange_radius)
                    .transform(RoundCornerTransformation(DensyUtils.dp2px(imageView.context, radius), 0, RoundCornerTransformation.CornerType.TOP))
                    .placeholder(R.drawable.bg_orange_radius)
                    .into(imageView)

        }


        @BindingAdapter("round_corner_recycler_img_url", "round_radius")
        @JvmStatic
        fun round_corner_recycler_img_url(imageView: ImageView, url: String, dimension: Float) {
            LogUtils.e(TAG, "round_corner_recycler_img_url   dimen " + dimension + " to px value " + DensyUtils.dp2px(imageView.context, dimension))

            Picasso.with(imageView.context)
                    .load(url)
                    .tag("round_corner_recycler_img_url")
                    .error(R.drawable.bg_orange_radius)
                    .transform(RoundCornerTransformation(DensyUtils.dp2px(imageView.context, dimension), 0))
                    .placeholder(R.drawable.bg_orange_radius)
                    .into(imageView, object : Callback {
                        override fun onError() {
                        }

                        override fun onSuccess() {
                            imageView.scaleType = ImageView.ScaleType.FIT_XY
                            imageView.adjustViewBounds = true
                        }
                    })

        }

        @BindingAdapter("custom_selected")
        @JvmStatic
        fun custom_selected(imageView: ImageView, selected: Boolean) {
            LogUtils.e(TAG, "conpentEvent custom_selected " + selected);
            imageView.isSelected = selected
        }
    }

}