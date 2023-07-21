package com.example.artspace

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(1)
    }
    val lastImageIndex =3
    Column(
        modifier = modifier

            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (count) {
            1-> {imageSet(image = R.drawable.b1)}
            2-> imageSet(image = R.drawable.b2)
            3-> imageSet(image = R.drawable.b3)

        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Button(onClick = {
                if(count==1){
                    count=lastImageIndex

                }

                else{
                    count = count-1
                }
            },) {
                Text(text = "Previous",Modifier.padding(start = 20.dp, end = 20.dp))
            }
            Button(onClick = {
                if(count==lastImageIndex){
                    count=1
                }
                else{
                    count = count+1
                }
            },/* modifier = modifier.size(80.dp),*/ shape = RoundedCornerShape(20.dp)) {

                Text(text = "Next",Modifier.padding(start = 34.dp, end = 34.dp))
            }

        }
        //bothButton(lastImageIndex = lastImageIndex, count =count )

    }
}

@Composable
fun imageSet(
    @DrawableRes image:Int,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = image),
        contentDescription = "first",
        modifier = modifier
            .padding(
                top =
                100.dp
            )
            .size(300.dp)
            .shadow(400.dp)
            .background(Color(255, 255, 255)),
        contentScale = ContentScale.Inside

    )
}
@Composable
fun bothButton(
    lastImageIndex:Int,
    count:Int,
    modifier: Modifier = Modifier){

    var currentCount by remember { mutableStateOf(count) }



}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting("Android")
    }
}