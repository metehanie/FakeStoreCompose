package com.metehanbolat.fakestorecompose.presentation.allproduct

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.metehanbolat.fakestorecompose.R
import com.metehanbolat.fakestorecompose.model.ProductUIData

@ExperimentalMaterialApi
@ExperimentalGlideComposeApi
@Composable
fun ProductCard(
    product: ProductUIData,
    cardClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .size(200.dp)
            .padding(5.dp)
            .clickable { cardClick?.invoke() },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(
                model = product.imageUrl,
                contentDescription = stringResource(id = R.string.limited_product),
                modifier = Modifier.size(140.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = product.name
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalGlideComposeApi
@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ProductCard(
        product = ProductUIData(
            id = "1",
            name = "Bag",
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
        )
    ) {}
}
